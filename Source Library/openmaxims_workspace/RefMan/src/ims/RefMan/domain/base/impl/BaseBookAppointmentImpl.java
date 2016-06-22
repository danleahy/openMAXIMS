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

package ims.RefMan.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseBookAppointmentImpl extends DomainImpl implements ims.RefMan.domain.BookAppointment, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistSessionSlot(ims.scheduling.vo.Sch_SessionRefVoCollection session, ims.core.resource.place.vo.ActivityRefVo activity, ims.vo.LookupInstVo urgency, ims.core.clinical.vo.ServiceFunctionRefVo serviceFunction, ims.core.resource.people.vo.HcpRefVo respHCP)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveBooking(ims.scheduling.vo.Sch_BookingVo booking, ims.RefMan.vo.CatsReferralRefVo catsReferral, Boolean isRebook)
	{
		if(booking == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'booking' of type 'ims.scheduling.vo.Sch_BookingVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistSession(ims.framework.utils.Date startDate, ims.framework.utils.Date endDate, ims.core.vo.ActivityVo activity, ims.core.clinical.vo.ServiceRefVo service, ims.core.resource.place.vo.LocationRefVo location, ims.core.vo.HcpLiteVo listOwner, ims.core.clinical.vo.ServiceFunctionRefVo clinicType, ims.core.resource.place.vo.LocationRefVoCollection locationList, ims.scheduling.vo.lookups.ProfileListType listType, ims.vo.LookupInstVo urgency)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActivitiesForType(ims.core.vo.lookups.ActivityType actType, ims.RefMan.vo.CatsReferralRefVo catsReferral, ims.core.clinical.vo.ServiceRefVo service)
	{
		if(actType == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'actType' of type 'ims.core.vo.lookups.ActivityType' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistBookingAppointment(ims.scheduling.vo.Sch_SessionRefVo session)
	{
		if(session == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'session' of type 'ims.scheduling.vo.Sch_SessionRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatehasBookingRights(ims.framework.interfaces.IAppRole role, ims.scheduling.vo.Sch_SessionRefVo session)
	{
		if(session == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'session' of type 'ims.scheduling.vo.Sch_SessionRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetCurrentMonth(ims.core.vo.ActivityVo activity, ims.core.clinical.vo.ServiceRefVo service, ims.core.resource.place.vo.LocationRefVo location, ims.core.clinical.vo.ServiceFunctionRefVo clinicType, ims.core.resource.place.vo.LocationRefVoCollection locationList, ims.core.vo.HcpLiteVo listOwner, ims.scheduling.vo.lookups.ProfileListType listType)
	{
	}

	@SuppressWarnings("unused")
	public void validategetReferralDetail(ims.RefMan.vo.CatsReferralRefVo catsReferral)
	{
		if(catsReferral == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'catsReferral' of type 'ims.RefMan.vo.CatsReferralRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetSch_BookingByAppt(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetBookingAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistProfileLiteByService(ims.core.clinical.vo.ServiceRefVo service)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateCatsReferralAdditionalInvStatus(ims.RefMan.vo.CatsReferralRefVo catsReferral, ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validateaddSlotsToSession(ims.scheduling.vo.SessionShortVo session, ims.scheduling.vo.SessionSlotVoCollection slots)
	{
		if(session == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'session' of type 'ims.scheduling.vo.SessionShortVo' cannot be null.");
		if(slots == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'slots' of type 'ims.scheduling.vo.SessionSlotVoCollection' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistSessionSlot(ims.scheduling.vo.Sch_SessionRefVo session)
	{
	}

	@SuppressWarnings("unused")
	public void validateprocessAppointmentForPukkaJ(ims.RefMan.vo.CatsReferralRefVo catsReferral, ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(catsReferral == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'catsReferral' of type 'ims.RefMan.vo.CatsReferralRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatecancelAppointmentForPukkaJ(ims.RefMan.vo.CatsReferralRefVo catsReferral, ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(catsReferral == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'catsReferral' of type 'ims.RefMan.vo.CatsReferralRefVo' cannot be null.");
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetPatientICP(ims.core.admin.vo.CareContextRefVo careCOntextRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatesavePatientICP(ims.icp.vo.PatientICPFullVo pateintICPVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatecreateOrder(ims.RefMan.domain.objects.CatsReferral doCatsReferral, ims.scheduling.domain.objects.Booking_Appointment doAppt)
	{
		if(doCatsReferral == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'doCatsReferral' of type 'ims.RefMan.domain.objects.CatsReferral' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistLocationLiteForReferralContract(ims.RefMan.vo.CatsReferralRefVo referral)
	{
		if(referral == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'referral' of type 'ims.RefMan.vo.CatsReferralRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetCatsReferral(ims.RefMan.vo.CatsReferralRefVo catsrefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatehasSafetyQuestionnarie(ims.RefMan.vo.CatsReferralRefVo referral, ims.core.clinical.vo.ServiceRefVo service)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSessionSlot(ims.scheduling.vo.Session_SlotRefVo slot)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLastOutpatientEROD(ims.RefMan.vo.CatsReferralRefVo catsReferral)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveBooking(ims.scheduling.vo.Sch_BookingVo voBooking, ims.RefMan.vo.CatsReferralRefVo catsRef, Boolean isRebook, ims.RefMan.vo.ReferralERODForBookAppointmentVoCollection outpatientERODCollection, Boolean isERODUpdatedOnBooking, ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVoCollection linkApptsColl, ims.scheduling.vo.Booking_AppointmentVoCollection linkMultipleBookingApptsColl)
	{
	}

	@SuppressWarnings("unused")
	public void validategetReferralERODByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo apptRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatecheckIfThereIsFirstApptPerClock(ims.RefMan.vo.CatsReferralRefVo catsReferral, Boolean areFirstAppointmentsLocally, ims.scheduling.vo.SessionSlotListVo sessionSlot)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistClinicsListOwners(ims.core.vo.HcpFilter filter)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveAutomatedCaseNoteRequest(ims.core.vo.PatientLiteVo patient, ims.core.vo.MemberOfStaffLiteVo mos, ims.scheduling.vo.Booking_AppointmentVo appointment, ims.framework.utils.DateTime requiredByDate)
	{
	}

	@SuppressWarnings("unused")
	public void validateisAnyApptToBeLinked(ims.core.admin.vo.CareContextRefVo careContextRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistServiceFunctionsLite(ims.core.clinical.vo.ServiceRefVo service)
	{
	}

	@SuppressWarnings("unused")
	public void validateisActivityFlexible(ims.core.clinical.vo.ServiceRefVo serviceRef, ims.core.resource.place.vo.ActivityRefVo activityRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistFlexibleSessions(ims.framework.utils.Date startDate, ims.framework.utils.Date endDate, ims.core.vo.ActivityVo activity, ims.core.clinical.vo.ServiceRefVo service, ims.core.resource.place.vo.LocationRefVo location, ims.core.vo.HcpLiteVo listOwner, ims.core.clinical.vo.ServiceFunctionRefVo clinicType, ims.core.resource.place.vo.LocationRefVoCollection locationList, ims.scheduling.vo.lookups.ProfileListType listType, ims.vo.LookupInstVo urgency, Boolean isWardAttendance)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistOutpatientFlexibleSlots(ims.scheduling.vo.Sch_SessionRefVoCollection session, ims.vo.LookupInstVo urgency, ims.core.resource.people.vo.HcpRefVo respHCP)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSessionFlexibleSlot(ims.scheduling.vo.SessionParentChildSlotRefVo flexibleSlot)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocations(ims.core.resource.place.vo.LocationRefVo hospital, Boolean isWardAttendance)
	{
	}

	@SuppressWarnings("unused")
	public void validatecountFirstActivityAppointmentsForServices(ims.RefMan.vo.CatsReferralRefVo referral, ims.core.clinical.vo.ServiceRefVoCollection services)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateCatsReferralConsultationActivityRequired(ims.RefMan.vo.CatsReferralRefVo catsReferral, Boolean consultationActivityRequired)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHCPLite(ims.core.resource.people.vo.HcpRefVo hcp)
	{
	}

	@SuppressWarnings("unused")
	public void validateisCancerPathwayReferral(ims.RefMan.vo.CatsReferralRefVo catsReferral)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateLocalPatientWithPds(ims.core.vo.Patient lpiPatient, ims.core.vo.Patient pdsPatient, java.util.ArrayList errors, String samlXml, ims.framework.interfaces.IAppRole appRole, ims.core.vo.MissingMappingVoCollection missingMappings)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatient(ims.core.vo.PatientShort patient)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHcpLiteByServiceFunction(ims.core.vo.HcpFilter filter, ims.core.clinical.vo.ServiceRefVo serviceRef, ims.core.vo.lookups.ServiceFunctionCollection functions)
	{
	}

	@SuppressWarnings("unused")
	public void validategetListOwnerBySlots(ims.scheduling.vo.Sch_SessionRefVo slotRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHospitalForCurrentLocation(ims.core.resource.place.vo.LocationRefVo locRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCurrentAppts(ims.core.patient.vo.PatientRefVo patient, ims.framework.utils.Date appointmentDate)
	{
	}

	@SuppressWarnings("unused")
	public void validateaddFlexibleSlotsToSession(ims.scheduling.vo.SessionShortVo session, ims.scheduling.vo.SessionParentChildSlotVoCollection flexibleSlots)
	{
		if(session == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'session' of type 'ims.scheduling.vo.SessionShortVo' cannot be null.");
		if(flexibleSlots == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'flexibleSlots' of type 'ims.scheduling.vo.SessionParentChildSlotVoCollection' cannot be null.");
	}
}
