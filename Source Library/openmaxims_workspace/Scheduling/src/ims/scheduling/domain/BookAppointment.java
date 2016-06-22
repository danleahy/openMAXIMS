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

package ims.scheduling.domain;

// Generated from form domain impl
public interface BookAppointment extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.scheduling.vo.SessionSlotVoCollection listSessionSlot(ims.scheduling.vo.SessionShortVo session);

	// Generated from form domain interface definition
	public ims.core.vo.ServiceShortVoCollection listActiveService();

	// Generated from form domain interface definition
	/**
	* temporary method to hardcode the patient until PDS patients are populated
	*/
	public ims.core.vo.PatientShort getPatient(Integer patientId);

	// Generated from form domain interface definition
	/**
	* list sessions for scheduling
	*/
	public ims.scheduling.vo.SessionShortVoCollection listGenericSession(ims.framework.utils.Date startDate, ims.framework.utils.Date endDate, ims.scheduling.vo.Sch_ProfileRefVo profile, ims.core.vo.ActivityVo activity, ims.core.clinical.vo.ServiceRefVo service, ims.core.resource.place.vo.LocationRefVo location, ims.vo.interfaces.IMos hcp, Boolean findFirstAvailable, Boolean allowOverBook);

	// Generated from form domain interface definition
	/**
	* list activities for ActivityType
	*/
	public ims.core.vo.ActivitySchedVoCollection listActivitiesForType(ims.core.vo.lookups.ActivityType actType);

	// Generated from form domain interface definition
	/**
	* list Booking appointments for a session
	*/
	public ims.scheduling.vo.Booking_AppointmentVoCollection listBookingAppointment(ims.scheduling.vo.SessionShortVo session);

	// Generated from form domain interface definition
	/**
	* listEvents
	*/
	public ims.pathways.vo.EventLiteVoCollection listEvents(ims.scheduling.vo.lookups.Status_Reason statusReason, ims.core.resource.place.vo.ActivityRefVo activity);

	// Generated from form domain interface definition
	/**
	* listJourneyByPatient
	*/
	public ims.pathways.vo.PatientJourneyVoCollection listJourneyByPatient(ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	/**
	* check Booking Rights for this Role and Session
	*/
	public Boolean hasBookingRights(ims.framework.interfaces.IAppRole role, ims.scheduling.vo.Sch_SessionRefVo session);

	// Generated from form domain interface definition
	/**
	* listProfileLiteByService
	*/
	public ims.scheduling.vo.ProfileLiteVoCollection listProfileLiteByService(ims.core.clinical.vo.ServiceRefVo service);

	// Generated from form domain interface definition
	/**
	* listLocationLite
	*/
	public ims.core.vo.LocationLiteVoCollection listLocationLite();

	// Generated from form domain interface definition
	/**
	* getCurrentMonth
	*/
	public ims.framework.utils.Date getCurrentMonth(ims.scheduling.vo.Sch_ProfileRefVo profile, ims.core.vo.ActivityVo activity, ims.core.clinical.vo.ServiceRefVo service, ims.core.resource.place.vo.LocationRefVo location, ims.vo.interfaces.IMos hcp, Boolean findFirstAvailable);

	// Generated from form domain interface definition
	/**
	* getProfileForSession
	*/
	public ims.scheduling.vo.Sch_ProfileRefVo getProfileForSession(ims.scheduling.vo.Sch_SessionRefVo session);

	// Generated from form domain interface definition
	/**
	* for rebooking used same Sch_booking
	*/
	public ims.scheduling.vo.Sch_BookingVo getSch_BookingByAppt(ims.scheduling.vo.Booking_AppointmentRefVo appt);

	// Generated from form domain interface definition
	/**
	* listNonCancelledAppointmentsForSession - a list of appts that are not cancelled for the session - this is used to validate booking another flexible appt
	*/
	public ims.scheduling.vo.BookingAppointmentLiteVoCollection listNonCancelledAppointmentsForSession(ims.scheduling.vo.Sch_SessionRefVo session);

	// Generated from form domain interface definition
	public ims.scheduling.vo.Sch_BookingVo saveBooking(ims.scheduling.vo.Sch_BookingVo voBooking, ims.scheduling.vo.SlotEventPathwayVoCollection voCollSlotEvPathway, ims.scheduling.vo.SessionShortVo session, ims.emergency.vo.EmergencyAttendanceOutcomeVo emergencyAttendance) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.scheduling.vo.SessionIntermediateVo getSessionIntermediate(ims.scheduling.vo.Sch_SessionRefVo session);

	// Generated from form domain interface definition
	/**
	* Instantiate Event used to create a patient event based on the appointments activity, external mappings etc..
	*/
	public void instantiateEvent(ims.scheduling.vo.Booking_AppointmentVo appt, String prepend, String refSource);
}
