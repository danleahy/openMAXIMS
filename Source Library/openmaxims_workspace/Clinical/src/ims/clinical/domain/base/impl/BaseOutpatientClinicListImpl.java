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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseOutpatientClinicListImpl extends DomainImpl implements ims.clinical.domain.OutpatientClinicList, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistOutpatientLocationsByHospital(ims.core.resource.place.vo.LocationRefVo hospital)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistClinics(ims.core.resource.place.vo.LocationRefVo hospital, ims.framework.utils.Date date, ims.scheduling.vo.lookups.ProfileListTypeCollection listTypes, String stringName)
	{
	}

	@SuppressWarnings("unused")
	public void validategetActiveHospitals(ims.core.resource.people.vo.MemberOfStaffRefVo mos)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistServices(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistAppointments(ims.clinical.vo.OutpatientClinicListSearchCriteriaVo searchCriteria)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCareContext(ims.RefMan.vo.CatsReferralRefVo referral)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientShort(ims.core.patient.vo.PatientRefVo patient)
	{
	}

	@SuppressWarnings("unused")
	public void validategetBookingAppt(ims.scheduling.vo.Booking_AppointmentRefVo appointment)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCatsReferral(ims.scheduling.vo.Booking_AppointmentRefVo appointment)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientElectiveList(ims.scheduling.vo.Booking_AppointmentRefVo appointment)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveOPEpisode(ims.scheduling.vo.Booking_AppointmentVo appointment, ims.RefMan.vo.CatsReferralListVo catsReferral, ims.scheduling.vo.SessionSlotVo sessionSlot, ims.RefMan.vo.PatientElectiveListForDNAAppointmentsVo electiveList, Boolean isFirstAppointmentActivity, Boolean isUndoDNA, Boolean isUndoArrival)
	{
	}

	@SuppressWarnings("unused")
	public void validategetServiceAndActivityByAppt(ims.scheduling.vo.Booking_AppointmentRefVo appointment)
	{
	}

	@SuppressWarnings("unused")
	public void validatecancelAppt(ims.scheduling.vo.Booking_AppointmentVo appointment, ims.chooseandbook.vo.lookups.ActionRequestType requestType, String requestSource)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateCatsReferralAdditionalInvStatus(ims.RefMan.vo.CatsReferralRefVo catsReferral, ims.scheduling.vo.Booking_AppointmentRefVo appointment)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateCatsReferralCancelStatus(ims.RefMan.vo.CatsReferralRefVo catsReferral)
	{
	}

	@SuppressWarnings("unused")
	public void validatecancelTCIAndReferralEROD(ims.RefMan.vo.CatsReferralRefVo catsReferral, ims.scheduling.vo.Booking_AppointmentRefVo appointment,  ims.scheduling.vo.lookups.CancelAppointmentReason cancellationReason, String cancellationComments, Boolean isProviderCancellation, Boolean isPatientCancellation, Boolean cancelledForNonMedicalReason)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCatsReferral(ims.RefMan.vo.CatsReferralRefVo catsReferral)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatient(ims.core.vo.PatientShort patient)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateLocalPatientWithPds(ims.core.vo.Patient lpiPatient, ims.core.vo.Patient pdsPatient, java.util.ArrayList errors, String samlXml, ims.framework.interfaces.IAppRole appRole, ims.core.vo.MissingMappingVoCollection missingMappings)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistAppointmentsManualAssemblerClass(ims.clinical.vo.OutpatientClinicListSearchCriteriaVo searchCriteria)
	{
	}

	@SuppressWarnings("unused")
	public void validategetParentHospital(ims.framework.interfaces.ILocation iLoc)
	{
	}
}
