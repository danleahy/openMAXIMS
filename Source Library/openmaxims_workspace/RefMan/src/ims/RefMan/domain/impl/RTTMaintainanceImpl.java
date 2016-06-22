//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 5308.16958)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.base.impl.BaseRTTMaintainanceImpl;
import ims.RefMan.vo.AdmissionDetailUndoClockImpactVo;
import ims.RefMan.vo.CATSReferralForRTTMaintainanceVo;
import ims.RefMan.vo.CATSReferralForRTTMaintainanceVoCollection;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.domain.AdmissionDetailUndoClockImpactVoAssembler;
import ims.RefMan.vo.domain.CATSReferralForRTTMaintainanceVoAssembler;
import ims.core.admin.pas.domain.objects.AdmissionDetail;
import ims.core.patient.vo.PatientRefVo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.pathways.domain.objects.AdminEvent;
import ims.pathways.domain.objects.PathwaysRTTClockImpact;
import ims.pathways.vo.AdminEventVo;
import ims.pathways.vo.PathwayRTTClockImpactUndoVo;
import ims.pathways.vo.PathwayRTTClockImpactUndoVoCollection;
import ims.pathways.vo.PathwayRTTClockImpactVo;
import ims.pathways.vo.domain.AdminEventVoAssembler;
import ims.pathways.vo.domain.PathwayRTTClockImpactUndoVoAssembler;
import ims.pathways.vo.domain.PathwayRTTClockImpactVoAssembler;
import ims.pathways.vo.lookups.RTTClockImpactSource;
import ims.scheduling.domain.AppointmentOutcomeDialog;
import ims.scheduling.domain.impl.AppointmentOutcomeDialogImpl;
import ims.scheduling.domain.objects.Booking_Appointment;
import ims.scheduling.helper.IRecordRTTClockImpact;
import ims.scheduling.vo.AppointmentUndoClockImpactVo;
import ims.scheduling.vo.Booking_AppointmentRefVo;
import ims.scheduling.vo.domain.AppointmentUndoClockImpactVoAssembler;

import java.util.ArrayList;

public class RTTMaintainanceImpl extends BaseRTTMaintainanceImpl
{
	private static final long serialVersionUID = 1L;

	
	public CATSReferralForRTTMaintainanceVoCollection listReferralsForPatient(PatientRefVo patient, Date dateFrom, Date dateTo)
	{
		if (patient == null || patient.getID_Patient() == null)
			return null;
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		StringBuilder query = new StringBuilder("SELECT referral ");
		query.append(" FROM CatsReferral AS referral LEFT JOIN referral.referralDetails AS details LEFT JOIN referral.patient AS patient ");
		query.append(" WHERE patient.id = :PATIENT_ID AND referral.journey is not null ");

		paramNames.add("PATIENT_ID");
		paramValues.add(patient.getID_Patient());
		
		if (dateFrom != null)
		{
			query.append(" AND details.dateOfReferral >= :DATE_FROM ");
			
			paramNames.add("DATE_FROM");
			paramValues.add(dateFrom.getDate());
		}
		
		if (dateTo != null)
		{
			query.append(" AND details.dateOfReferral <= :DATE_TO ");
			
			paramNames.add("DATE_TO");
			paramValues.add(dateTo.getDate());
		}
		
		return CATSReferralForRTTMaintainanceVoAssembler.createCATSReferralForRTTMaintainanceVoCollectionFromCatsReferral(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}


	public PathwayRTTClockImpactUndoVoCollection listClockImpacts(CatsReferralRefVo referral)
	{
		if (referral == null || referral.getID_CatsReferral() == null)
			return null;
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();

		StringBuilder query = new StringBuilder("SELECT clockImpact FROM CatsReferral AS referral LEFT JOIN referral.rTTClockImpacts AS clockImpact ");
		query.append(" WHERE referral.id = :REFERRAL_ID ");
			
		paramNames.add("REFERRAL_ID");
		paramValues.add(referral.getID_CatsReferral());
			
		query.append(" ORDER BY clockImpact.systemInformation.creationDateTime DESC");
		
		return PathwayRTTClockImpactUndoVoAssembler.createPathwayRTTClockImpactUndoVoCollectionFromPathwaysRTTClockImpact(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}


	@Override
	public void undoClockImpact(CATSReferralForRTTMaintainanceVo referral, PathwayRTTClockImpactUndoVo clockImpact) throws DomainInterfaceException, StaleObjectException
	{
		if (clockImpact == null)
			return;
		
		if (RTTClockImpactSource.APPOINTMENT_OUTCOME.equals(clockImpact.getSource()))
		{
			undoAppointmentOutcomeClockImpact(clockImpact); 
		}
		else if (RTTClockImpactSource.ADMIN_EVENT.equals(clockImpact.getSource()))
		{
			undoAdminEventClockImpact(clockImpact);
		}
		else if (RTTClockImpactSource.ADMISSION.equals(clockImpact.getSource()))
		{
			undoAdmissionClockImpact(clockImpact);
		}
		else if (RTTClockImpactSource.APPOINTMENT_BOOKED.equals(clockImpact.getSource()))
		{
			undoAppointmentBookedClockImpact(clockImpact);
		}
	}


	private void undoAppointmentBookedClockImpact(PathwayRTTClockImpactUndoVo clockImpact) throws DomainInterfaceException, StaleObjectException
	{
		// Get Booking Appointment record for Clock Impact
		String query = "SELECT appointment FROM Booking_Appointment AS appointment LEFT JOIN appointment.bookedRTTClockImpact AS clockImpact WHERE clockImpact.id = :ID_IMPACT";
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("ID_IMPACT");
		paramValues.add(clockImpact.getID_PathwaysRTTClockImpact());
		
		Booking_Appointment appointmentDom = (Booking_Appointment) getDomainFactory().findFirst(query, paramNames, paramValues);
		PathwayRTTClockImpactVo pathwayClockImpact = PathwayRTTClockImpactVoAssembler.create((PathwaysRTTClockImpact) getDomainFactory().getDomainObject(PathwaysRTTClockImpact.class, clockImpact.getID_PathwaysRTTClockImpact()));

		if (appointmentDom != null)
		{
			AppointmentUndoClockImpactVo appointment = AppointmentUndoClockImpactVoAssembler.create(appointmentDom);
			IRecordRTTClockImpact referralDetailImpl = (IRecordRTTClockImpact) getDomainImpl(ReferralDetailsImpl.class);
			referralDetailImpl.undoAppointmentClockImpact(appointment, pathwayClockImpact);
		}
	}


	private void undoAdmissionClockImpact(PathwayRTTClockImpactUndoVo clockImpact) throws DomainInterfaceException, StaleObjectException
	{
		// Get Admission Details record for Clock Impact
		String query = "SELECT admissionDetail FROM AdmissionDetail AS admissionDetail LEFT JOIN admissionDetail.admissionRTTOutcome AS clockImpact WHERE clockImpact.id = :ID_IMPACT";
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("ID_IMPACT");
		paramValues.add(clockImpact.getID_PathwaysRTTClockImpact());
		
		AdmissionDetail admissionDetailDom = (AdmissionDetail) getDomainFactory().findFirst(query, paramNames, paramValues);
		PathwayRTTClockImpactVo pathwayClockImpact = PathwayRTTClockImpactVoAssembler.create((PathwaysRTTClockImpact) getDomainFactory().getDomainObject(PathwaysRTTClockImpact.class, clockImpact.getID_PathwaysRTTClockImpact()));

		if (admissionDetailDom != null)
		{
			AdmissionDetailUndoClockImpactVo admissionDetail = AdmissionDetailUndoClockImpactVoAssembler.create(admissionDetailDom);
			IRecordRTTClockImpact referralDetailsImpl = (IRecordRTTClockImpact) getDomainImpl(ReferralDetailsImpl.class);
			referralDetailsImpl.undoAdmissionClockImpact(admissionDetail, pathwayClockImpact);
		}
	}


	private void undoAdminEventClockImpact(PathwayRTTClockImpactUndoVo clockImpact) throws DomainInterfaceException, StaleObjectException
	{
		// Get AdminEvent record for Clock Impact
		String query = "SELECT adminEvent FROM AdminEvent AS adminEvent LEFT JOIN adminEvent.rTTClockImpact AS clockImpact WHERE clockImpact.id = :ID_IMPACT";
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("ID_IMPACT");
		paramValues.add(clockImpact.getID_PathwaysRTTClockImpact());
		
		AdminEvent adminEventDom = (AdminEvent) getDomainFactory().findFirst(query, paramNames, paramValues);
		PathwayRTTClockImpactVo pathwayClockImpact = PathwayRTTClockImpactVoAssembler.create((PathwaysRTTClockImpact) getDomainFactory().getDomainObject(PathwaysRTTClockImpact.class, clockImpact.getID_PathwaysRTTClockImpact()));
		
		if (adminEventDom != null)
		{
			AdminEventVo adminEvent = AdminEventVoAssembler.create(adminEventDom);
				
			IRecordRTTClockImpact referralDetailsImpl = (IRecordRTTClockImpact) getDomainImpl(ReferralDetailsImpl.class);
			referralDetailsImpl.undoAdminEventClockImpact(adminEvent, pathwayClockImpact);
		}
	}


	private void undoAppointmentOutcomeClockImpact(PathwayRTTClockImpactUndoVo clockImpact) throws DomainInterfaceException, StaleObjectException
	{
		if (clockImpact == null || clockImpact.getID_PathwaysRTTClockImpact() == null)
		{
			throw new CodingRuntimeException("Cannot undo the an unsaved clockImpact.");
		}
		
		// Get BookingAppointment record for Clock Impact
		String query = "SELECT appointment FROM Booking_Appointment AS appointment LEFT JOIN appointment.rTTClockImpact AS clockImpact WHERE clockImpact.id = :ID_IMPACT";

		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("ID_IMPACT");
		paramValues.add(clockImpact.getID_PathwaysRTTClockImpact());
		
		Booking_Appointment appointment = (Booking_Appointment) getDomainFactory().findFirst(query, paramNames, paramValues);
		
		if (appointment != null)
		{
			Booking_AppointmentRefVo appointmentRef = new Booking_AppointmentRefVo(appointment.getId(), appointment.getVersion());

			AppointmentOutcomeDialog outcomeDialogImpl = (AppointmentOutcomeDialog) getDomainImpl(AppointmentOutcomeDialogImpl.class);
			outcomeDialogImpl.undoAppointmentOutcome(appointmentRef);
		}
	}
}
