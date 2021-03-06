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
public interface SessionAdmin extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listSession
	*/
	public ims.scheduling.vo.SessionShortVoCollection listSession(ims.scheduling.vo.Sch_ProfileRefVo profile, ims.scheduling.vo.DirectoryofServiceRefVo dos, ims.framework.utils.Date startDate, ims.framework.utils.Date endDate, ims.scheduling.vo.lookups.Session_Status_and_Reason status);

	// Generated from form domain interface definition
	public ims.scheduling.vo.ProfileLiteVoCollection listProfile(String profileName);

	// Generated from form domain interface definition
	public ims.scheduling.vo.DirectoryOfServiceLiteVoCollection listDos(String dosName);

	// Generated from form domain interface definition
	public ims.scheduling.vo.SessionVo saveSession(ims.scheduling.vo.SessionVo session, Boolean editingSlots) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.scheduling.vo.SessionVo getSession(ims.scheduling.vo.SessionShortVo sessionShort);

	// Generated from form domain interface definition
	/**
	* cancelSession
	*/
	public void cancelSession(ims.scheduling.vo.Sch_SessionRefVo session, ims.scheduling.vo.Appointment_StatusVo apptCancelStatus, Boolean cancelAppointment, Boolean isFlexible) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void cancelSlot(ims.scheduling.vo.SessionSlotVo sessionSlot, ims.chooseandbook.vo.lookups.ActionRequestType requestType, String requestSource) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.scheduling.vo.Booking_AppointmentVo cancelAppt(ims.scheduling.vo.Booking_AppointmentVo appt, ims.chooseandbook.vo.lookups.ActionRequestType requestType, String requestSource) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* updateJourney
	*/
	public void updateJourney(ims.scheduling.domain.objects.Booking_Appointment doAppt, Boolean isCancel) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* updateCatsReferralAdditionalInvStatus
	*/
	public void updateCatsReferralAdditionalInvStatus(ims.RefMan.vo.CatsReferralRefVo catsReferral, ims.scheduling.vo.Booking_AppointmentRefVo appointment) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* listProcedureByHcpAndName
	*/
	public ims.core.vo.ProcedureLiteVoCollection listProcedureByHcpAndName(ims.core.resource.people.vo.HcpRefVoCollection hcps, String name);

	// Generated from form domain interface definition
	/**
	* maintainMaxContinuousTim - update the session with how much continuous time is available
	*/
	public void saveSessionForMaxContinuousTime(ims.scheduling.vo.SessionShortVo session) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* reOpenTheatreTCISlot
	*/
	public ims.scheduling.domain.objects.SessionTheatreTCISlot reOpenTheatreTCISlot(ims.scheduling.domain.objects.SessionTheatreTCISlot doTheatreSlot);

	// Generated from form domain interface definition
	/**
	* getTheatreSession
	*/
	public ims.scheduling.vo.SessionTheatreVo getTheatreSession(ims.scheduling.vo.Sch_SessionRefVo session);

	// Generated from form domain interface definition
	public void updateCatsReferralCancelStatus(ims.RefMan.vo.CatsReferralRefVo catsRefVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* updateCatsReferralAdditionalInvStatus
	*/
	public void updateCatsReferralAdditionalInvStatus(ims.RefMan.vo.CatsReferralRefVo catsReferral) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void updateCatsReferralConsultationActivityRequired(ims.RefMan.vo.CatsReferralRefVo catsReferral, Boolean consultationActivityRequired) throws ims.domain.exceptions.StaleObjectException;
}
