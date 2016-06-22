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
public interface DisplacedAppointmentsWorklist extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.scheduling.vo.ProfileLiteVoCollection listProfiles(String profileName);

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVoCollection listActiveHospitals();

	// Generated from form domain interface definition
	public ims.core.vo.LocShortMappingsVoCollection listActiveLocationsForHospital(ims.core.vo.LocationLiteVo location);

	// Generated from form domain interface definition
	public ims.core.vo.ServiceVoCollection listServices();

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVo getHospitalForCurrentLocation(Integer locId);

	// Generated from form domain interface definition
	public ims.scheduling.vo.SessionManagementVoCollection listSessionsWithDisplacedApppointments(ims.scheduling.vo.DisplacedAppointmentsSearchCriteriaVo displacedSearchCriteriaVo);

	// Generated from form domain interface definition
	public ims.scheduling.vo.BookingAppointmentForDisplacedAppointmentVoCollection getDisplacedAppointmentsForSession(ims.scheduling.vo.Sch_SessionRefVo session);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralForSessionManagementVo getCatsReferralForAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appointmentRef);

	// Generated from form domain interface definition
	public ims.core.vo.PatientShort getPatientShort(ims.core.patient.vo.PatientRefVo patientRef);

	// Generated from form domain interface definition
	public ims.scheduling.vo.Booking_AppointmentVo getBookingAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt);

	// Generated from form domain interface definition
	public void saveAppointment(ims.scheduling.vo.BookingAppointmentForDisplacedAppointmentVo appointmentToSave) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.scheduling.vo.BookingAppointmentForDisplacedAppointmentVo getDisplacedBookingAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt);

	// Generated from form domain interface definition
	/**
	* Get Care Context Short
	*/
	public ims.core.vo.CareContextShortVo getCareContextShort(ims.core.admin.vo.CareContextRefVo voCareContextRef);

	// Generated from form domain interface definition
	public ims.core.vo.CareContextShortVo getCareContextFromCatsReferral(ims.scheduling.vo.Booking_AppointmentRefVo appRef);

	// Generated from form domain interface definition
	public void removeFromDisplacedWorklist(ims.scheduling.vo.Booking_AppointmentRefVo appt) throws ims.domain.exceptions.StaleObjectException;
}
