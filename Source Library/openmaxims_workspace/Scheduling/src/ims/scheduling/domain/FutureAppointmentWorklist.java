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
public interface FutureAppointmentWorklist extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.ServiceLiteVoCollection getServices();

	// Generated from form domain interface definition
	public ims.core.vo.ServiceFunctionLiteVoCollection getFunctionsForService(ims.core.clinical.vo.ServiceRefVo service);

	// Generated from form domain interface definition
	public ims.scheduling.vo.FutureAppointmentListVoCollection getFutureAppointments(ims.scheduling.vo.FutureAppointmentWorklistSearchCriteriaVo searchCriteria);

	// Generated from form domain interface definition
	public ims.scheduling.vo.FutureAppointmentDetailsVo getFutureAppointmentDetails(ims.scheduling.vo.FutureAppointmentDetailsRefVo futureAppt);

	// Generated from form domain interface definition
	public ims.core.vo.PatientShort getPatientShort(ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	public void saveFutureAppointment(ims.scheduling.vo.FutureAppointmentDetailsVo futureAppointment) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.ServiceFunctionLiteVo getServiceFunction(ims.core.clinical.vo.ServiceRefVo service, ims.core.vo.lookups.ServiceFunction function);

	// Generated from form domain interface definition
	public ims.scheduling.vo.Booking_AppointmentRefVo getAppointmentForRecord(ims.scheduling.vo.FutureAppointmentDetailsRefVo futureAppointment);

	// Generated from form domain interface definition
	public ims.core.vo.CareContextShortVo getCareContextForReferral(ims.RefMan.vo.CatsReferralRefVo referal);
}
