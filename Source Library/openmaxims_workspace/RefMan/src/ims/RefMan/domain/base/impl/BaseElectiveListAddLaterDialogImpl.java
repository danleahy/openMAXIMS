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

public abstract class BaseElectiveListAddLaterDialogImpl extends DomainImpl implements ims.RefMan.domain.ElectiveListAddLaterDialog, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetPatientElectiveList(ims.RefMan.vo.PatientElectiveListRefVo electiveListRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveRecord(ims.RefMan.vo.PatientElectiveListAddLaterVo record)
	{
	}

	@SuppressWarnings("unused")
	public void validategetReferralDetails(ims.RefMan.vo.CatsReferralRefVo referralRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistProcedures(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validategetActiveHospitals(ims.core.resource.people.vo.MemberOfStaffRefVo mos)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistWardsForHospital(ims.core.resource.place.vo.LocationRefVo hospital, String value)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientShort(ims.core.patient.vo.PatientRefVo patRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistSurgicalProcedures(String name, ims.core.vo.lookups.Specialty specialty, Boolean allProceduresORHotlist)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistMedicalProcedures(String name, ims.core.vo.lookups.Specialty specialty, Boolean allProceduresORHotlist)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistEndoscopyProcedures(String name, ims.core.vo.lookups.Specialty specialty, Boolean allProceduresORHotlist)
	{
	}

	@SuppressWarnings("unused")
	public void validategetElectiveListConfigByService(String filter, Integer serviceId, ims.core.resource.people.vo.HcpRefVo hcpRef)
	{
	}

	@SuppressWarnings("unused")
	public void validateisLoggedInUserForService(ims.core.resource.people.vo.HcpRefVo hcpRef, ims.core.clinical.vo.ServiceRefVo serviceRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveSuitableForTelephonePreAssessment(ims.RefMan.vo.PatientElectiveListAddLaterVo patElectiveToSave)
	{
	}

	@SuppressWarnings("unused")
	public void validateisLoggedInUserMedicByHcpAndService(ims.core.resource.people.vo.HcpRefVo hCpRef, ims.core.clinical.vo.ServiceRefVo serviceRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetMedicsByServices(ims.core.clinical.vo.ServiceRefVo serviceRef, String name, ims.core.vo.lookups.MedicGrade medicgrade)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveAndMarkAsRie(ims.RefMan.vo.PatientElectiveListAddLaterVo record,  ims.framework.FormName formName, Integer patId, Integer contactId, Integer careContextId, String comment)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHCPLiteFromReferral(ims.RefMan.vo.CatsReferralRefVo referralRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetElectiveListConfigByService(String filter, Integer serviceId, ims.core.resource.people.vo.HcpRefVo hcpRef, Boolean isDefaultHCP)
	{
	}
}
