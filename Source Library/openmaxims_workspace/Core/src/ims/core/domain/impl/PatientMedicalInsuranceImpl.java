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
// This code was generated by Peter Martin using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.core.vo.PrivateInsuranceCompanyVoCollection;
import ims.core.vo.domain.PatientMedicalInsuranceVoAssembler;
import ims.core.vo.domain.PrivateInsuranceCompanyVoAssembler;
import ims.core.clinical.domain.objects.PatientMedicalInsurance;
import ims.core.domain.base.impl.BasePatientMedicalInsuranceImpl;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.framework.exceptions.CodingRuntimeException;

public class PatientMedicalInsuranceImpl extends BasePatientMedicalInsuranceImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* Retrieves a Patient Specific List of Alerts
	*/
	public ims.core.vo.PatientMedicalInsuranceVoCollection listPatientMedicalInsuranceVo(ims.core.vo.PatientShort patient)
	{
		if(patient == null)
			throw new CodingRuntimeException("Mandatory parameter - Patient not supplied");
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("from PatientMedicalInsurance pmi ");
		hql.append(" where pmi.patient.id = :patient");
		names.add("patient");
		values.add(patient.getID_Patient());
		
		hql.append(" order by pmi.expiryDate desc");
		
		List list = factory.find(hql.toString(), names,values);
		
		return PatientMedicalInsuranceVoAssembler.createPatientMedicalInsuranceVoCollectionFromPatientMedicalInsurance(list);
	}

	/**
	* Saves a Patient Medical Insurance Vo
	*/
	public ims.core.vo.PatientMedicalInsuranceVo savePatientMedicalInsuranceVo(ims.core.vo.PatientMedicalInsuranceVo patientMedicalInsuranceVo) throws ims.domain.exceptions.StaleObjectException
	{
		// Check for value to save
		if (patientMedicalInsuranceVo == null)
			throw new DomainRuntimeException("Domain Error - Can not save a null patientMedicalInsuranceVo record");
		
		// Check for validated record
		if (!patientMedicalInsuranceVo.isValidated())
			throw new DomainRuntimeException("Domain Error - patientMedicalInsuranceVo record must be validated before save");
		
		// Get domain object
		PatientMedicalInsurance patientMedicalInsurance = PatientMedicalInsuranceVoAssembler.extractPatientMedicalInsurance(getDomainFactory(), patientMedicalInsuranceVo);
				
		// Attempt save
		getDomainFactory().save(patientMedicalInsurance);
				
		return PatientMedicalInsuranceVoAssembler.create(patientMedicalInsurance);
	}

	/**
	* getPatientMedicalInsuranceVo
	*/
	public ims.core.vo.PatientMedicalInsuranceVo getPatientMedicalInsuranceVo(ims.core.clinical.vo.PatientMedicalInsuranceRefVo patientMedicalInsuranceRefVo)
	{
		if (patientMedicalInsuranceRefVo == null || !patientMedicalInsuranceRefVo.getID_PatientMedicalInsuranceIsNotNull())
			return null;
		return PatientMedicalInsuranceVoAssembler.create((PatientMedicalInsurance) getDomainFactory().getDomainObject(PatientMedicalInsurance.class, patientMedicalInsuranceRefVo.getID_PatientMedicalInsurance()));
	}
	
	public PrivateInsuranceCompanyVoCollection listCompanies() {
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("from PrivateInsuranceCompany pic ");
		
		hql.append (" where pic.isActive = :isActive");
		names.add("isActive");
		values.add(Boolean.TRUE);	

		List list = factory.find(hql.toString(), names,values);
		return(PrivateInsuranceCompanyVoAssembler.createPrivateInsuranceCompanyVoCollectionFromPrivateInsuranceCompany(list).sort());
	}
}