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

package ims.core.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseDemographicsImpl extends DomainImpl implements ims.core.domain.Demographics, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetPatient(ims.core.vo.PatientShort patient)
	{
	}

	@SuppressWarnings("unused")
	public void validatehasAlerts(Integer patientID)
	{
	}

	@SuppressWarnings("unused")
	public void validatehasAllergy(Integer patientID)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientGp(ims.core.vo.GpShortVo gp)
	{
	}

	@SuppressWarnings("unused")
	public void validatesavePatient(ims.core.vo.Patient patient, Boolean fromInterface)
	{
		if(fromInterface == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'fromInterface' of type 'Boolean' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatedeletePatient(ims.core.vo.Patient patient)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatient(ims.core.patient.vo.PatientRefVo patRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientShort(ims.core.patient.vo.PatientRefVo patRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientLite(ims.core.vo.PatientShort patVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatesynchronizeGPPracticeDetails(String strGPCode)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveDeathDetails(ims.core.vo.DeathDetailsVo deathDetails)
	{
	}

	@SuppressWarnings("unused")
	public void validategetMergedPatient(ims.core.vo.PatientShort patient)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveDemographics(ims.core.vo.Patient patient, ims.core.vo.DeathDetailsVo deathDetails)
	{
	}

	@SuppressWarnings("unused")
	public void validategetDeathDetails(ims.core.vo.PatientShort value)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocalPatient(ims.core.vo.PatientShort patient)
	{
	}

	@SuppressWarnings("unused")
	public void validatevalidatePatient(ims.core.vo.Patient patientVO, ims.core.patient.vo.PatientRefVo patientRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCaseNoteFolderLocation(String strHospNum)
	{
	}

	@SuppressWarnings("unused")
	public void validateinsertDTOHistoricAddress(ims.core.vo.PersonAddress previousAddress, String pkey)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCCOAlias(String szHospnum)
	{
	}

	@SuppressWarnings("unused")
	public void validategetDTOHistoricAddresses(String hospnum)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCCODTOPatient(String pkey)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocationSite(ims.core.resource.place.vo.LocationRefVo locSiteId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetGPPractice(ims.core.resource.place.vo.OrganisationRefVo organisationRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistPatientAlertsTextByTaxonomy(ims.core.patient.vo.PatientRefVo patient, Boolean active, ims.core.vo.lookups.TaxonomyType type)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatient(ims.core.vo.PatientShort patient, Boolean verify)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocalPatient(ims.core.vo.PatientShort patient, Boolean includeVerifiedInSearch)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdatePatientDeceasedData(ims.core.vo.Patient patient, ims.core.vo.DeathDetailsVo deathDetails, Boolean cancelFutureAppointments, Boolean savedFromDemographics)
	{
	}

	@SuppressWarnings("unused")
	public void validatehasAlertsForViewOrEdit(ims.core.patient.vo.PatientRefVo patient, ims.core.vo.lookups.AlertTypeCollection alertsType)
	{
	}

	@SuppressWarnings("unused")
	public void validatecreatePatientNumber(Integer patNum)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientIdentifiers(ims.core.patient.vo.PatientRefVo patient)
	{
	}
}
