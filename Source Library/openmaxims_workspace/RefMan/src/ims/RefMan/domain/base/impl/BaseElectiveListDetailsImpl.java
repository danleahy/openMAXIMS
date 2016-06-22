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

public abstract class BaseElectiveListDetailsImpl extends DomainImpl implements ims.RefMan.domain.ElectiveListDetails, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validateget(ims.RefMan.vo.PatientElectiveListRefVo patientElectiveListRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHospitalsByElectiveList(ims.core.configuration.vo.ElectiveListConfigurationRefVo electiveListConfig, String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistWards(String name, ims.core.resource.place.vo.LocationRefVo locationRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatesave(ims.RefMan.vo.PatientElectiveListDetailsVo patientElectiveList, ims.RefMan.vo.TCIForPatientElectiveListDetailsVo previousTCI, ims.framework.utils.Date previousEarliestDateOffered, Boolean createOutcomeHistory)
	{
	}

	@SuppressWarnings("unused")
	public void validatecreateCaseNoteRequests(ims.RefMan.vo.PatientElectiveListDetailsVo patientElectiveList, ims.core.vo.PatientShort patient)
	{
	}

	@SuppressWarnings("unused")
	public void validatetriggerElectiveListEvent(ims.RefMan.vo.PatientElectiveListRefVo patientElectiveList)
	{
	}

	@SuppressWarnings("unused")
	public void validatemarkERODAsRIE(ims.RefMan.vo.PatientElectiveListDetailsVo patientElectiveList, ims.framework.FormName formName, String comment)
	{
	}

	@SuppressWarnings("unused")
	public void validatecancelTCI(ims.RefMan.vo.PatientElectiveListRefVo patientWaitingListRef, ims.RefMan.vo.TCIOutcomeForPatientElectiveListVo tciOutcome, ims.scheduling.vo.Booking_AppointmentRefVo theatreApptThatIsNotCancelled)
	{
	}

	@SuppressWarnings("unused")
	public void validategetBookingAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validatecancelAppt(ims.scheduling.vo.Booking_AppointmentVo appt, ims.chooseandbook.vo.lookups.ActionRequestType requestType, String requestSource)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateCatsReferralAdditionalInvStatus(ims.RefMan.vo.CatsReferralRefVo catsReferral, ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdateCatsReferralCancelStatus(ims.RefMan.vo.CatsReferralRefVo catsReferral)
	{
	}

	@SuppressWarnings("unused")
	public void validatednaTCI(ims.RefMan.vo.PatientElectiveListRefVo patientElectiveList, ims.scheduling.vo.Booking_AppointmentRefVo theatreThatIsNotDNA)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSession(ims.scheduling.vo.SessionParentChildSlotRefVo sessionParentSlot)
	{
	}

	@SuppressWarnings("unused")
	public void validatednaAppointment(ims.scheduling.vo.Booking_AppointmentVo appt, ims.RefMan.vo.CatsReferralRefVo cats)
	{
	}

	@SuppressWarnings("unused")
	public void validateinactivatePause(ims.RefMan.vo.CatsReferralRefVo referral, ims.RefMan.vo.ReferralERODRefVo erod)
	{
	}

	@SuppressWarnings("unused")
	public void validatesavePatientElectiveListNotes(ims.RefMan.vo.PatientElectiveListDetailsVo patientElectiveList)
	{
	}

	@SuppressWarnings("unused")
	public void validateisStaleNote(ims.RefMan.vo.PatientElectiveListNotesVo patientElectiveListNote)
	{
	}

	@SuppressWarnings("unused")
	public void validateisERODStale(ims.RefMan.vo.ReferralERODRefVo referralERODRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetTCIAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validateisLoggedInUserMedicByHcpAndService(ims.core.resource.people.vo.HcpRefVo hCpRef, ims.core.clinical.vo.ServiceRefVo serviceRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatecountHospitalsFromElectiveListConfiguration(ims.core.configuration.vo.ElectiveListConfigurationRefVo electiveListConfiguration)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHCPByMedic(ims.core.resource.people.vo.HcpRefVo hcpRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetFormMenuAction(Integer formId)
	{
	}
}
