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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.70 build 3401.14277)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.ClinicList;
import ims.RefMan.domain.ReferralAppointmentDetailsComponent;
import ims.RefMan.domain.TheatreTrackingConfig;
import ims.RefMan.domain.base.impl.BaseTheatreListImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.PatientElectiveList;
import ims.RefMan.domain.objects.TCIForPatientElectiveList;
import ims.RefMan.domain.objects.TheatreTrackingIdleConfig;
import ims.RefMan.vo.CatsReferralForTheatreListVo;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.CatsReferralRttDateForTheatreListVo;
import ims.RefMan.vo.CatsReferralVo;
import ims.RefMan.vo.CatsReferralWizardVo;
import ims.RefMan.vo.PatientElectiveListForDNAAppointmentsVo;
import ims.RefMan.vo.TCIForPatientElectiveListAppointmentDNAVo;
import ims.RefMan.vo.TheatreListBookingAppointmentVo;
import ims.RefMan.vo.TheatreListBookingAppointmentVoCollection;
import ims.RefMan.vo.TheatreListFilterVo;
import ims.RefMan.vo.TheatreProcedureServiceAndConsultantLiteVo;
import ims.RefMan.vo.TheatreTrackingIdleConfigVo;
import ims.RefMan.vo.TrackingStatusConfigVo;
import ims.RefMan.vo.domain.CatsReferralForTheatreListVoAssembler;
import ims.RefMan.vo.domain.CatsReferralRttDateForTheatreListVoAssembler;
import ims.RefMan.vo.domain.CatsReferralVoAssembler;
import ims.RefMan.vo.domain.CatsReferralWizardVoAssembler;
import ims.RefMan.vo.domain.PatientElectiveListForDNAAppointmentsVoAssembler;
import ims.RefMan.vo.domain.TCIForPatientElectiveListAppointmentDNAVoAssembler;
import ims.RefMan.vo.domain.TheatreListBookingAppointmentVoAssembler;
import ims.RefMan.vo.domain.TheatreTrackingIdleConfigVoAssembler;
import ims.RefMan.vo.lookups.ReferralApptStatus;
import ims.chooseandbook.vo.lookups.ActionRequestType;
import ims.core.admin.pas.domain.objects.InpatientEpisode;
import ims.core.clinical.domain.objects.Procedure;
import ims.core.clinical.vo.ProcedureRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.InpatientEpisodeVo;
import ims.core.vo.LocShortMappingsVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.ProcedureLiteVo;
import ims.core.vo.ProcedureVo;
import ims.core.vo.ServiceLiteVo;
import ims.core.vo.TCIForPatElectListForWardLiteVo;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.InpatientEpisodeVoAssembler;
import ims.core.vo.domain.LocShortMappingsVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.domain.ProcedureLiteVoAssembler;
import ims.core.vo.domain.ProcedureVoAssembler;
import ims.core.vo.domain.ServiceLiteVoAssembler;
import ims.core.vo.domain.TCIForPatElectListForWardLiteVoAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.domain.DomainObject;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.icp.vo.domain.PatientICPLiteVoAssembler;
import ims.icps.instantiation.domain.objects.PatientICP;
import ims.scheduling.domain.SessionAdmin;
import ims.scheduling.domain.impl.SessionAdminImpl;
import ims.scheduling.domain.objects.Booking_Appointment;
import ims.scheduling.domain.objects.Sch_Session_Appointment_Order;
import ims.scheduling.domain.objects.SessionTheatreTCISlot;
import ims.scheduling.vo.BookingAppointmentTheatreVo;
import ims.scheduling.vo.Booking_AppointmentRefVo;
import ims.scheduling.vo.Booking_AppointmentVo;
import ims.scheduling.vo.Sch_SessionRefVo;
import ims.scheduling.vo.Sch_Session_Appointment_OrderVo;
import ims.scheduling.vo.SessionShortVoCollection;
import ims.scheduling.vo.SessionTheatreTCISlotLiteVo;
import ims.scheduling.vo.SessionTheatreTCISlotRefVo;
import ims.scheduling.vo.domain.BookingAppointmentTheatreVoAssembler;
import ims.scheduling.vo.domain.Booking_AppointmentVoAssembler;
import ims.scheduling.vo.domain.Sch_Session_Appointment_OrderVoAssembler;
import ims.scheduling.vo.domain.SessionShortVoAssembler;
import ims.scheduling.vo.domain.SessionTheatreTCISlotLiteVoAssembler;
import ims.scheduling.vo.lookups.CancelAppointmentReason;
import ims.scheduling.vo.lookups.ProfileListType;
import ims.scheduling.vo.lookups.SchProfileType;
import ims.scheduling.vo.lookups.Status_Reason;
import ims.scheduling.vo.lookups.TheatreType;
import ims.vo.domain.DomainObjectMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TheatreListImpl extends BaseTheatreListImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* List active locations where the location type is hospital for currently logged MOS user
	* Will return null if logged in user is not MOS
	*/
	// WDEV-11645
	public LocShortMappingsVoCollection listActiveHospitals(MemberOfStaffRefVo memberOfStaff)
	{
		if (memberOfStaff == null || !memberOfStaff.getID_MemberOfStaffIsNotNull())
			return null;

		StringBuilder query = new StringBuilder();
		query.append("select location from MemberOfStaff as mos left join mos.locations as hcpLocation left join hcpLocation.location as location ");
		query.append(" where location.type = :LocType and location.isActive = :isActive and location.isVirtual = :isVirtual and mos.id = :mosID");
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("LocType");
		paramValues.add(getDomLookup(LocationType.HOSP));
		
		paramNames.add("isActive");
		paramValues.add(Boolean.TRUE);
		
		paramNames.add("isVirtual");
		paramValues.add(Boolean.FALSE);
		
		paramNames.add("mosID");
		paramValues.add(memberOfStaff.getID_MemberOfStaff());
		
		return LocShortMappingsVoAssembler.createLocShortMappingsVoCollectionFromLocation(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}

	public ims.core.vo.LocShortMappingsVoCollection listTheatresForHospital(ims.core.resource.place.vo.LocationRefVo hospital)
	{
		if (hospital == null || hospital.getID_Location() == null)
			throw new CodingRuntimeException("hospital is null or id not provided in method listTheatresForHospital");
		
		List theatres = getDomainFactory().find("from Location loc where loc.parentLocation.id = :idParent and loc.type.id = :idLocType and loc.isActive = :isActive", new String[]{"idParent","idLocType", "isActive"}, new Object[]{hospital.getID_Location(), LocationType.THEATRE.getId(), Boolean.TRUE});
		return LocShortMappingsVoAssembler.createLocShortMappingsVoCollectionFromLocation(theatres);
	}
	public SessionShortVoCollection listSession(Date sessionDate, HcpRefVo listOwner, LocationRefVo hospital, TheatreType theatreType, ProfileListType listType)   //wdev-19419
	{
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = "";
		StringBuffer sb = new StringBuffer();

		String hql = "from Sch_Session as session left join fetch session.listOwners as lo ";

		andStr = " ";
		if (sessionDate != null)
		{
			sb.append(andStr + " session.sessionDate = :sessionDate");
			markers.add("sessionDate");
			values.add(sessionDate.getDate());
			andStr = " and ";
		}

		if (listOwner != null)
		{
			sb.append(andStr + " lo.hcp.id = :listOwner");
			markers.add("listOwner");
			values.add(listOwner.getID_Hcp());
			andStr = " and ";
		}

		if (hospital != null)
		{	
			sb.append(andStr + " ( session.schLocation.id = :locat or session.schLocation.parentLocation.id = :locat )");
			markers.add("locat");
			values.add(hospital.getID_Location());
			andStr = " and ";
		}
		//wdev-19419
		if( listType != null)
		{	
			sb.append(andStr + " ( session.listType.id = :idListType)");
			markers.add("idListType");
			values.add(getDomLookup(listType).getId());
			andStr = " and ";
		}
		//-----------

		sb.append(andStr + " session.sessionProfileType.id = :THEATRE_SESSION");
		markers.add("THEATRE_SESSION");
		values.add(SchProfileType.THEATRE.getId());
		andStr = " and ";

		
		if (theatreType != null)
		{
			//wdev-20233
			/*if (theatreType.equals(TheatreType.BOTH))
			{
				sb.append(andStr + " ( session.theatreType = :stat1 or session.theatreType = :stat2 or session.theatreType = :stat3)");
				markers.add("stat3");
				values.add(getDomLookup(TheatreType.BOTH));
				markers.add("stat1");
				values.add(getDomLookup(TheatreType.INPATIENT));
				markers.add("stat2");
				values.add(getDomLookup(TheatreType.DAYCASE));
			}
			else*/ 
			if(theatreType.equals(TheatreType.INPATIENT) || theatreType.equals(TheatreType.DAYCASE))
			{
				sb.append(andStr + " ( session.theatreType = :stat1)");	//sb.append(andStr + " ( session.theatreType = :stat1 or session.theatreType = :stat2)");
				markers.add("stat1");
				if (theatreType.equals(TheatreType.INPATIENT))
					values.add(getDomLookup(TheatreType.INPATIENT));
				if (theatreType.equals(TheatreType.DAYCASE))
					values.add(getDomLookup(TheatreType.DAYCASE));
				//markers.add("stat2");
				//values.add(getDomLookup(TheatreType.BOTH));
			}
			else
			{
				sb.append(andStr + " ( session.theatreType = :stat1)");
				markers.add("stat1");
				values.add(getDomLookup(theatreType));
			}
		}


		hql += " where " ;
		hql += sb.toString();

		java.util.List list = getDomainFactory().find(hql.toString(), markers, values);
		SessionShortVoCollection voCollSessionShort = new SessionShortVoCollection();
		if (list != null && list.size() > 0)
			voCollSessionShort = SessionShortVoAssembler.createSessionShortVoCollectionFromSch_Session(list);
		return voCollSessionShort;	
	}


	// WDEV-11645
	public TheatreListBookingAppointmentVoCollection listAppointments(HcpRefVo hcp, MemberOfStaffRefVo mosUser, Date date)
	{
		if (hcp == null || !hcp.getID_HcpIsNotNull())
			return null;
		
		if (mosUser == null || !mosUser.getID_MemberOfStaffIsNotNull())
			return null;
		
		StringBuilder query = new StringBuilder();

		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();

		query.append(" select icp, app from PatientICP as icp right join icp.appointments as app left join app.session as ses left join ses.listOwners as own left outer join app.theatreSlot as slot left join app.theatreBooking as tb left outer join tb.tCITime as lkpTci ");
		query.append(" where own.hcp.id = :HCP_ID and ses.sessionDate = :SesDate and ses.schLocation in ");
		query.append(" (select location from MemberOfStaff as mos left join mos.locations as loc left join loc.location as location where mos.id = :MOS_ID) ");
		query.append(" and app.theatreBooking is not null ");//WDEV-12965
		query.append(" and (app.apptStatus = :BOOKED or app.apptStatus = :ARRIVED or app.apptStatus = :SEEN or app.apptStatus = :ADMITED or app.apptStatus = :DNA or app.apptStatus = :DISCH) "); //wdev-19455

		paramNames.add("HCP_ID");
		paramValues.add(hcp.getID_Hcp());
		paramNames.add("MOS_ID");
		paramValues.add(mosUser.getID_MemberOfStaff());
		
		paramNames.add("SesDate");
		paramValues.add(date.getDate());
		
		paramNames.add("BOOKED");
		paramValues.add(getDomLookup(Status_Reason.BOOKED));
		paramNames.add("ARRIVED");
		paramValues.add(getDomLookup(Status_Reason.ARRIVAL));
		paramNames.add("SEEN");
		paramValues.add(getDomLookup(Status_Reason.SEEN));
		paramNames.add("ADMITED");
		paramValues.add(getDomLookup(Status_Reason.ADMITTED));
		paramNames.add("DNA");
		paramValues.add(getDomLookup(Status_Reason.DNA));
		paramNames.add("DISCH"); //wdev-19455
		paramValues.add(getDomLookup(Status_Reason.DISCHARGED));

		//WDEV-11777 - order by TCI Time and then Location
		query.append(" order by  slot.toComeInTime, lkpTci.text, ses.schLocation ");
		
		List list = getDomainFactory().find(query.toString(), paramNames, paramValues);

		// TODO Auto-generated method stub
		Iterator it = list.iterator();
		
		TheatreListBookingAppointmentVoCollection voColl = new TheatreListBookingAppointmentVoCollection();
		DomainObjectMap domainMap = new DomainObjectMap();
		
		while(it.hasNext())
		{			
			Object[] lstItem = (Object[]) it.next();
			Booking_Appointment doAppt = (Booking_Appointment)lstItem[1];
			
			//WDEV-9657 - need assembler call here as version numbers were incorrect when attempting DNA
			if (doAppt != null)
			{
				TheatreListBookingAppointmentVo voTheatre = TheatreListBookingAppointmentVoAssembler.create(domainMap, doAppt);
				voTheatre.setICPInfo(PatientICPLiteVoAssembler.create(domainMap, (PatientICP)lstItem[0]));
				voColl.add(voTheatre);
			}
		}
		return voColl;
	}

	public TheatreListBookingAppointmentVoCollection listAppointments(Sch_SessionRefVo session)
	{
		if(session == null)
			throw new CodingRuntimeException("session not provided");
		
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = "";
		StringBuffer sb = new StringBuffer();

		String hql = " from PatientICP as icp right join icp.appointments as appts left join appts.theatreBooking as tb left join appts.session as sess";

		if (session.getID_Sch_SessionIsNotNull())
		{
			sb.append(andStr + " appts.session.id = :clinic");
			markers.add("clinic");
			values.add(session.getID_Sch_Session());
			andStr = " and ";
		}

//WDEV-12965		sb.append(andStr + " icp.completedDateTime = null");
//WDEV-12965		andStr = " and ";
		sb.append(andStr + " appts.theatreBooking != null");
		andStr = " and ";
		sb.append(andStr + " ( appts.apptStatus = :apptBooked or appts.apptStatus = :apptArrived or appts.apptStatus = :apptSEEN or appts.apptStatus = :apptADM or appts.apptStatus = :apptDNA or appts.apptStatus = :DISCH)");
		markers.add("apptBooked");
		values.add(getDomLookup(Status_Reason.BOOKED));
		markers.add("apptArrived");
		values.add(getDomLookup(Status_Reason.ARRIVAL));
		markers.add("apptSEEN");
		values.add(getDomLookup(Status_Reason.SEEN));
		markers.add("apptADM");
		values.add(getDomLookup(Status_Reason.ADMITTED));
		markers.add("apptDNA");
		values.add(getDomLookup(Status_Reason.DNA));
		markers.add("DISCH"); //wdev-19455
		values.add(getDomLookup(Status_Reason.DISCHARGED));

		hql += " where ";
		hql += sb.toString();

		java.util.List list = getDomainFactory().find(hql.toString(), markers, values);
		Iterator it = list.iterator();
		
		TheatreListBookingAppointmentVoCollection voColl = new TheatreListBookingAppointmentVoCollection();
		while(it.hasNext())
		{
			TheatreListBookingAppointmentVo voTheatre = new TheatreListBookingAppointmentVo();
			
			Object[] lstItem = (Object[]) it.next();
			Booking_Appointment doOP = (Booking_Appointment)lstItem[1];
			
			if ( doOP != null )
			{
				//WDEV-11897 - needed assembler call here
				voTheatre = TheatreListBookingAppointmentVoAssembler.create(doOP);
				voTheatre.setICPInfo(PatientICPLiteVoAssembler.create((PatientICP)lstItem[0]));
				voColl.add(voTheatre);
			}
		}
		return voColl;
	}

	
	public PatientShort getPatientShort(PatientRefVo voPatientRef) 
	{
		DomainFactory factory = getDomainFactory();
		ims.core.patient.domain.objects.Patient patBo = (ims.core.patient.domain.objects.Patient) factory.getDomainObject(ims.core.patient.domain.objects.Patient.class, voPatientRef.getID_Patient().intValue());
		return PatientShortAssembler.create(patBo);
	}

	public Booking_AppointmentVo getBookingAppt(Booking_AppointmentRefVo bookingApptRefVo) 
	{
		DomainFactory factory = getDomainFactory();
		Booking_Appointment apptBo = (Booking_Appointment) factory.getDomainObject(Booking_Appointment.class, bookingApptRefVo.getID_Booking_Appointment());
		return Booking_AppointmentVoAssembler.create(apptBo);
	}

	public TheatreListBookingAppointmentVoCollection listAllAppointments(TheatreListFilterVo filterVo) 
	{
		if(filterVo == null)
			throw new CodingRuntimeException("filterVo not provided");
		
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = "";
		StringBuffer sb = new StringBuffer();

		//WDEV-9657 - don't need to retrieve the individual fields
		String hql = " from PatientICP as icp right join icp.appointments as appts " +
				"left join fetch appts.theatreSlot as slot " +	
				"left join fetch appts.theatreBooking as tb " +
				"left join fetch appts.session as sess " +
				"left join fetch sess.schLocation as locat " +
				"left outer join tb.tCITime as lkpTci ";

		if (filterVo.getSessionDateIsNotNull())
		{
			sb.append(andStr + " sess.sessionDate = :sessDate");
			markers.add("sessDate");
			values.add(filterVo.getSessionDate().getDate());
			andStr = " and ";
		}

		if (filterVo.getListownerIsNotNull())
		{
			hql += " right join sess.listOwners as lOwn";
			sb.append(andStr + " lOwn.hcp.id = :hcp");
			markers.add("hcp");
			values.add(filterVo.getListowner().getID_Hcp());
			andStr = " and ";
		}

		if (filterVo.getHospitalIsNotNull())
		{
			sb.append(andStr + " ( locat.id = :loc or locat.parentLocation.id = :loc1 )");
			markers.add("loc");
			values.add(filterVo.getHospital().getID_Location());
			markers.add("loc1");
			values.add(filterVo.getHospital().getID_Location());
			andStr = " and ";
		}

		if (filterVo.getSessionTypeIsNotNull())
		{
			//wdev-20233
			
				sb.append(andStr + " ( sess.theatreType = :stat1)");
				markers.add("stat1");
				values.add(getDomLookup(filterVo.getSessionType()));
			
		}

//WDEV-12965		sb.append(andStr + " icp.completedDateTime = null");
//WDEV-12965		andStr = " and ";
		sb.append(andStr + " appts.theatreBooking != null");
		andStr = " and ";
		sb.append(andStr + " ( appts.apptStatus = :apptBooked or appts.apptStatus = :apptArrived or appts.apptStatus = :apptSEEN or appts.apptStatus = :apptADM or appts.apptStatus = :apptDNA or appts.apptStatus = :DISCH)");
		markers.add("apptBooked");
		values.add(getDomLookup(Status_Reason.BOOKED));
		markers.add("apptArrived");
		values.add(getDomLookup(Status_Reason.ARRIVAL));
		markers.add("apptSEEN");
		values.add(getDomLookup(Status_Reason.SEEN));
		markers.add("apptADM");
		values.add(getDomLookup(Status_Reason.ADMITTED));
		markers.add("apptDNA");
		values.add(getDomLookup(Status_Reason.DNA));
		markers.add("DISCH"); //wdev-19455
		values.add(getDomLookup(Status_Reason.DISCHARGED));

	
		hql += " where ";
		hql += sb.toString();
		
		//WDEV-11777 - order by TCI Time and then Location
		hql += " order by slot.toComeInTime, lkpTci.text, locat";
		

		java.util.List list = getDomainFactory().find(hql.toString(), markers, values);
		Iterator it = list.iterator();
		TheatreListBookingAppointmentVoCollection voColl = new TheatreListBookingAppointmentVoCollection();
		DomainObjectMap domMap = new DomainObjectMap();
		while(it.hasNext())
		{			
			Object[] lstItem = (Object[]) it.next();
			Booking_Appointment doAppt = (Booking_Appointment)lstItem[1];
			
			//WDEV-9657 - need assembler call here as version numbers were incorrect when attempting DNA
			if (doAppt != null)
			{
				TheatreListBookingAppointmentVo voTheatre = TheatreListBookingAppointmentVoAssembler.create(domMap, doAppt);
				voTheatre.setICPInfo(PatientICPLiteVoAssembler.create(domMap, (PatientICP)lstItem[0]));
				voColl.add(voTheatre);
			}
		}
		return voColl;
	}

	public ProcedureVo getProcedureLOS(ProcedureRefVo procedureRefVo) 
	{
		DomainFactory factory = getDomainFactory();
		Procedure procBo = (Procedure) factory.getDomainObject(Procedure.class, procedureRefVo.getID_Procedure().intValue());
		return ProcedureVoAssembler.create(procBo);
	}

	public Sch_Session_Appointment_OrderVo getSessionOrder(Sch_SessionRefVo schSessionRefVo)
	{
		if (schSessionRefVo == null || schSessionRefVo.getID_Sch_Session() == null)
			throw new CodingRuntimeException("schSessionRefVo is null or id not provided in method getSessionOrder");
		
		Sch_Session_Appointment_Order doSessApptOrder = Sch_Session_Appointment_Order.getSch_Session_Appointment_OrderFromSession(getDomainFactory() , schSessionRefVo.getID_Sch_Session());
		if(doSessApptOrder != null)
			return Sch_Session_Appointment_OrderVoAssembler.create(doSessApptOrder); 
			
		return null;
	}

	public Boolean isReferralAccepted(Booking_AppointmentRefVo voBookingRefVo)
	{
		if(voBookingRefVo == null)
			throw new CodingRuntimeException("voBookingRefVo not populated for method isReferralAccepted");
		
		DomainFactory factory = getDomainFactory();
		List lstCatsRef = factory.find("from CatsReferral catsRef where catsRef.appointments.id = '" + voBookingRefVo.getID_Booking_Appointment() + "'");
		if(lstCatsRef != null && lstCatsRef.size() == 1)
		{
			CatsReferral doCatsRef = (CatsReferral) lstCatsRef.get(0);
			CatsReferralVo voCats = CatsReferralVoAssembler.create(doCatsRef);
			if (voCats.getCurrentStatusIsNotNull()
					&& voCats.getCurrentStatus().getReferralStatusIsNotNull())
				{
					if (   voCats.getCurrentStatus().getReferralStatus().equals(ReferralApptStatus.REFERRAL_ACCEPTED)
						|| voCats.getCurrentStatus().getReferralStatus().equals(ReferralApptStatus.FURTHER_MANAGEMENT_REQUIRED))
						return true;
				}
		}
		return false;
	}

	public CatsReferralWizardVo getCatsReferral(Booking_AppointmentRefVo voBookingRefVo)
	{
		if(voBookingRefVo == null)
			throw new CodingRuntimeException("voBookingRefVo not populated for method isReferralAccepted");
		
		DomainFactory factory = getDomainFactory();
		List lstCatsRef = factory.find("from CatsReferral catsRef where catsRef.appointments.id = '" + voBookingRefVo.getID_Booking_Appointment() + "'");
		if(lstCatsRef != null && lstCatsRef.size() == 1)
		{
			CatsReferral doCatsRef = (CatsReferral) lstCatsRef.get(0);
			return CatsReferralWizardVoAssembler.create(doCatsRef);
		}
		return null;
	}

	public Boolean isNotACurrentInpatient(PatientRefVo voPatRef) 
	{
		String hql = "from InpatientEpisode ip where ip.pasEvent in (select event.id from PASEvent as event where event.patient.id = :patID)";
		DomainFactory factory= getDomainFactory();
		List l = factory.find(hql, new String[] {"patID"}, new Object[] {voPatRef.getID_Patient()});		
		if (l != null && l.size() > 0)
		{
			return false;
		}
		return true;
	}

	public void saveTheatreAppointment(TheatreListBookingAppointmentVo voAppt) throws StaleObjectException
	{
		//WDEV-9657 do a get and save as the version is not retrieved in the original query and can cause staleobject (dlaffan)
		if (voAppt == null)
			throw new CodingRuntimeException("voAppt is null in method saveTheatreAppointment");
		if (!voAppt.isValidated())
			throw new CodingRuntimeException("voAppt has not been validated in method saveTheatreAppointment");
		
		DomainFactory factory = getDomainFactory();	
		Booking_Appointment doAppt = TheatreListBookingAppointmentVoAssembler.extractBooking_Appointment(factory, voAppt);		
		factory.save(doAppt);
	}

	public void saveTheatreAppointment(TheatreListBookingAppointmentVo appt, CatsReferralWizardVo voCatsReferral, SessionTheatreTCISlotLiteVo sessionSlot, PatientElectiveListForDNAAppointmentsVo electiveList) throws StaleObjectException
	{
		if (appt == null)
			throw new CodingRuntimeException("voAppt is null in method saveTheatreAppointment");
		if (!appt.isValidated())
			throw new CodingRuntimeException("voAppt has not been validated in method saveTheatreAppointment");
		if (voCatsReferral == null)
			throw new CodingRuntimeException("voCatsReferral is null in method saveTheatreAppointment");
		if (!voCatsReferral.isValidated())
			throw new CodingRuntimeException("voCatsReferral has not been validated in method saveTheatreAppointment");
	
		DomainFactory factory = getDomainFactory();	
		Booking_Appointment doAppt = TheatreListBookingAppointmentVoAssembler.extractBooking_Appointment(factory, appt);
		
		if (electiveList != null)
		{
			@SuppressWarnings("rawtypes")
			HashMap domMap = new HashMap(); 
			TCIForPatientElectiveListAppointmentDNAVo currentTCI = electiveList.getTCIDetails();
			TCIForPatientElectiveList domTCIToSave = TCIForPatientElectiveListAppointmentDNAVoAssembler.extractTCIForPatientElectiveList(factory, currentTCI, domMap);
			electiveList.setTCIDetails(null);
			PatientElectiveList domPatientElectiveList = PatientElectiveListForDNAAppointmentsVoAssembler.extractPatientElectiveList(factory, electiveList, domMap);
			
			factory.save(domPatientElectiveList);
			factory.save(domTCIToSave);
		}

		
		factory.save(doAppt);
		
		CatsReferral doCats = CatsReferralWizardVoAssembler.extractCatsReferral(factory, voCatsReferral);		
		factory.save(doCats);
		
		//WDEV-9091
		if(sessionSlot != null)
		{
			SessionTheatreTCISlot doSessoionSlot = SessionTheatreTCISlotLiteVoAssembler.extractSessionTheatreTCISlot(factory, sessionSlot);
			factory.save(doSessoionSlot);
		}
	}

	//WDEV-9091
	public SessionTheatreTCISlotLiteVo getSessionSlot(SessionTheatreTCISlotRefVo sessionSlot) 
	{
		if(sessionSlot == null || sessionSlot.getID_SessionTheatreTCISlot() == null)
			throw new CodingRuntimeException("Can not get Session Slot on null Id.");
		
		DomainFactory factory = getDomainFactory();
		
		SessionTheatreTCISlot doSessionSlot = (SessionTheatreTCISlot) factory.getDomainObject(SessionTheatreTCISlot.class, sessionSlot.getID_SessionTheatreTCISlot());
		
		return SessionTheatreTCISlotLiteVoAssembler.create(doSessionSlot);
	}

	public TrackingStatusConfigVo getTrackingStatus()
	{
		TheatreTrackingConfig impl = (TheatreTrackingConfig) getDomainImpl(TheatreTrackingConfigImpl.class);
		return impl.getTrackingStatus();
	}

	public CatsReferralRefVo getCatsReferralRef(Booking_AppointmentRefVo voBookingRefVo)
	{
		if(voBookingRefVo == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		List lstCatsRef = factory.find("from CatsReferral catsRef where catsRef.appointments.id = '" + voBookingRefVo.getID_Booking_Appointment() + "'");
		if(lstCatsRef != null && lstCatsRef.size() > 0)
		{
			CatsReferral doCatsRef = (CatsReferral) lstCatsRef.get(0);
			return new CatsReferralRefVo(doCatsRef.getId(),doCatsRef.getVersion());
		}
		return null;
	}

	public TheatreTrackingIdleConfigVo getTheatreTrackingIdleConfig()
	{
		DomainObject firstDo = getDomainFactory().findFirst("from TheatreTrackingIdleConfig");
		if (firstDo == null)
			return null;
		return TheatreTrackingIdleConfigVoAssembler.create((TheatreTrackingIdleConfig) firstDo);
	}

	//WDEV-13307
	public InpatientEpisodeVo getInpatientEpisode(PatientRefVo patient) 
	{
		if(patient == null || patient.getID_Patient() == null)
			throw new CodingRuntimeException("Cannot get InpatientEpisode for a null Patient Id.");
		
		DomainFactory factory = getDomainFactory();
		
		String query = "select ip from InpatientEpisode ip left join ip.pasEvent as pe left join pe.patient as p where p.id = :PatientId";
		List<?> listInpatient = factory.find(query, new String[] {"PatientId"}, new Object[] {patient.getID_Patient()});
		
		if(listInpatient != null && listInpatient.size() > 0)
			return InpatientEpisodeVoAssembler.create((InpatientEpisode) listInpatient.get(0));
		
		return null;
	}

	//WDEV-18005
	public TheatreProcedureServiceAndConsultantLiteVo getTheatreServiceProcedureAndConsultant(Booking_AppointmentRefVo appt)
	{
		if (appt == null || appt.getID_Booking_Appointment() == null)
			throw new CodingRuntimeException("appt is null or id not provided in method getTheatreServiceProcedureAndConsultant");

		TheatreProcedureServiceAndConsultantLiteVo voPsc = null;

		Booking_Appointment doAppt = (Booking_Appointment) getDomainFactory().getDomainObject(appt);
		if (doAppt != null)
		{
			ServiceLiteVo voService = ServiceLiteVoAssembler.create(doAppt.getSession() != null ? doAppt.getSession().getService() : null);
			ProcedureLiteVo voProc = ProcedureLiteVoAssembler.create(doAppt.getTheatreBooking() != null ? doAppt.getTheatreBooking().getProcedure() : null);
			HcpLiteVo voMos = HcpLiteVoAssembler.create(doAppt.getTheatreBooking() != null ? doAppt.getTheatreBooking().getConsultant() : null);

			voPsc = new TheatreProcedureServiceAndConsultantLiteVo();
			voPsc.setService(voService);
			voPsc.setProcedure(voProc);
			voPsc.setConsultant(voMos);
		}

		return voPsc;
	}

	public Booking_AppointmentVo cancelAppt(Booking_AppointmentVo appt, ActionRequestType requestType, String requestSource) throws StaleObjectException, DomainInterfaceException
	{
		ClinicList impl = (ClinicList) getDomainImpl(ClinicListImpl.class);
		return impl.cancelAppt(appt, requestType, requestSource);
	}

	public void updateCatsReferralAdditionalInvStatus(CatsReferralRefVo catsReferral) throws StaleObjectException
	{
		updateCatsReferralAdditionalInvStatus(catsReferral, null);
	}
	
	public void updateCatsReferralAdditionalInvStatus(CatsReferralRefVo catsReferral,Booking_AppointmentRefVo appt) throws StaleObjectException
	{
		SessionAdmin impl = (SessionAdmin) getDomainImpl(SessionAdminImpl.class);
		impl.updateCatsReferralAdditionalInvStatus(catsReferral,null);
	}

	public CatsReferralForTheatreListVo getCatsReferralForCancel(Booking_AppointmentRefVo appointmentRef)
	{
		if (appointmentRef == null)
			return null;

		DomainFactory factory = getDomainFactory();
		List<?> lstCatsRef = factory.find("from CatsReferral catsRef where catsRef.appointments.id = '" + appointmentRef.getID_Booking_Appointment() + "'");

		if (lstCatsRef != null && lstCatsRef.size() > 0)
		{
			return CatsReferralForTheatreListVoAssembler.createCatsReferralForTheatreListVoCollectionFromCatsReferral(lstCatsRef).get(0);
		}
		return null;
	}

	public BookingAppointmentTheatreVo getBookingAppointmentTheatre(Booking_AppointmentRefVo appRef)
	{
		if (appRef == null)
			throw new CodingRuntimeException("Cannot get Theatre Appointment on null Id.");

		return BookingAppointmentTheatreVoAssembler.create((Booking_Appointment) getDomainFactory().getDomainObject(Booking_Appointment.class, appRef.getID_Booking_Appointment()));
	}

	public CatsReferralRttDateForTheatreListVo getReferralWithRttDate(Booking_AppointmentRefVo appRef)
	{
		if (appRef == null)
			return null;

		DomainFactory factory = getDomainFactory();
		List<?> lstCatsRef = factory.find("from CatsReferral catsRef where catsRef.appointments.id = '" + appRef.getID_Booking_Appointment() + "'");

		if (lstCatsRef != null && lstCatsRef.size() > 0)
		{
			return CatsReferralRttDateForTheatreListVoAssembler.createCatsReferralRttDateForTheatreListVoCollectionFromCatsReferral(lstCatsRef).get(0);
		}

		return null;
	}
	//WDEV-22845
	public void cancelTCIAndReferralEROD(CatsReferralRefVo catsReferral, Booking_AppointmentRefVo apptRef,CancelAppointmentReason cancellationReason, String cancellationComment, Boolean isProviderCancellation, Boolean isPatientCancellation, Boolean cancelledForNonmedicalReason) throws StaleObjectException //WDEV-18249
	{
		ReferralAppointmentDetailsComponent impl = (ReferralAppointmentDetailsComponent) getDomainImpl(ReferralAppointmentDetailsComponentImpl.class);
		impl.cancelTCIAndReferralEROD(catsReferral, apptRef, cancellationReason, cancellationComment, isProviderCancellation, isPatientCancellation, cancelledForNonmedicalReason);//WDEV-18249,wdev-18419
	}

	public Boolean hasTCI(Booking_AppointmentRefVo appointment)
	{
		if (appointment == null)
			return Boolean.FALSE;

		String query = "SELECT COUNT (tci.id) FROM TCIForPatientElectiveList AS tci LEFT JOIN tci.appointment AS appt WHERE appt.id = :APPT_ID and tci.isRIE is null";
		
		long count = getDomainFactory().countWithHQL(query, new String[] {"APPT_ID"}, new Object[] {appointment.getID_Booking_Appointment()});
		
		if (count > 0)
			return Boolean.TRUE;
		
		return Boolean.FALSE;
	}

	public PatientElectiveListForDNAAppointmentsVo getPatientElectiveList(Booking_AppointmentRefVo appointment)
	{
		if (appointment == null)
			return null;
		
		String query = "SELECT electivList FROM PatientElectiveList AS electivList LEFT JOIN electivList.tCIDetails AS tci LEFT JOIN tci.appointment AS appt WHERE appt.id = :APPT_ID ";
		
		return PatientElectiveListForDNAAppointmentsVoAssembler.create((PatientElectiveList) getDomainFactory().findFirst(query, "APPT_ID", appointment.getID_Booking_Appointment()));
	}

	//wdev-19303
	public TCIForPatElectListForWardLiteVo getTCIForPatElectiveList(Booking_AppointmentRefVo bookAppt)
	{
		if( bookAppt == null || bookAppt.getID_Booking_Appointment() == null)
			throw new CodingRuntimeException("Appointment cannot be null");
		
		List tci = getDomainFactory().find("select t1_1 from TCIForPatientElectiveList as t1_1 left join t1_1.appointment as b1_1 where	(b1_1.id = :appointmid and (t1_1.isRIE = 0 or t1_1.isRIE = null))", new String[]{"appointmid"}, new Object[]{bookAppt.getID_Booking_Appointment()});
		if( tci != null && tci.size() > 0)
		{
			return TCIForPatElectListForWardLiteVoAssembler.createTCIForPatElectListForWardLiteVoCollectionFromTCIForPatientElectiveList(tci).get(0);
		}
		return null;
	}	
}
