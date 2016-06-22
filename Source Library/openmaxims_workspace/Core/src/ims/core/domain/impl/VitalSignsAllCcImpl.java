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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.core.domain.VitalSignsAll;
import ims.core.domain.base.impl.BaseVitalSignsAllCcImpl;
import ims.core.vo.lookups.Sex;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.emergency.domain.objects.Triage;
import ims.emergency.vo.TriageForClinicianWorklistVo;
import ims.emergency.vo.TriageRefVo;
import ims.emergency.vo.domain.TriageForClinicianWorklistVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

public class VitalSignsAllCcImpl extends BaseVitalSignsAllCcImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* Generic List for all Vital Signs By Vital Signs Type
	*/
	public ims.core.vo.VitalSignsVoCollection listVitalSigns(ims.core.admin.vo.CareContextRefVo refCareContext)
	{
		VitalSignsAll vs = (VitalSignsAll)getDomainImpl(VitalSignsImpl.class);
		return vs.listVitalSigns(refCareContext);
	}

	/**
	* List of Hcps
	*/
	public ims.core.vo.HcpLiteVoCollection listLiteHcps(ims.core.vo.HcpFilter hcpFilter)
	{
		VitalSignsAll vs = (VitalSignsAll)getDomainImpl(VitalSignsImpl.class);
		return vs.listLiteHcps(hcpFilter);
	}

	/**
	* Saves a vital sign
	*/
	public ims.core.vo.VitalSignsVo saveVitalSign(ims.core.vo.VitalSignsVo vitalSign, TriageForClinicianWorklistVo triageToSave) throws ims.domain.exceptions.StaleObjectException //WDEV-20426
	{
		if (triageToSave!=null)
		{
			if (!triageToSave.isValidated())
    		{
    			throw new DomainRuntimeException("This Triage has not been validated");
    		}

    		DomainFactory factory = getDomainFactory();
    		Triage doTriage = TriageForClinicianWorklistVoAssembler.extractTriage(factory, triageToSave);
    		factory.save(doTriage);
		}
		
		VitalSignsAll vs = (VitalSignsAll)getDomainImpl(VitalSignsImpl.class);
		return vs.saveVitalSign(vitalSign);
	}

	public ims.core.vo.VitalSignsVo inactivateVitalSign(ims.core.vo.VitalSignsVo vitalSignsRecord, ims.core.vo.lookups.VSType type) throws ims.domain.exceptions.StaleObjectException
	{
		VitalSignsAll vs = (VitalSignsAll)getDomainImpl(VitalSignsImpl.class);
		return vs.inactivateVitalSign(vitalSignsRecord, type);
	}

	/**
	* Get a Vital Sign record
	*/
	public ims.core.vo.VitalSignsVo getVitalSignsRecord(ims.core.vo.VitalSignsVo voVitalSign)
	{
		VitalSignsAll vs = (VitalSignsAll)getDomainImpl(VitalSignsImpl.class);
		return vs.getVitalSignsRecord(voVitalSign);
	}

	/**
	* get Metrics From Patient
	*/
	public ims.core.vo.VSMetrics getMetricsFromPatient(ims.core.patient.vo.PatientRefVo voPatientRef)
	{
		VitalSignsAll vs = (VitalSignsAll)getDomainImpl(VitalSignsImpl.class);
		return vs.getMetricsFromPatient(voPatientRef);
	}

	/**
	* save Metrics To Core Clinical
	*/
	public ims.core.vo.VSMetrics saveMetricsToPatient(ims.core.vo.VSMetrics voMetrics) throws ims.domain.exceptions.StaleObjectException
	{
		VitalSignsAll vs = (VitalSignsAll)getDomainImpl(VitalSignsImpl.class);
		return vs.saveMetricsToPatient(voMetrics);
	}

	public ims.clinical.vo.SECSVo getSecs()
	{
		VitalSignsAll vs = (VitalSignsAll)getDomainImpl(VitalSignsImpl.class);
		return vs.getSecs();
	}

	/**
	* savePatientEws
	*/
	public void savePatientEws(ims.core.vo.PatientEWSVo voPatEws)
	{
		VitalSignsAll vs = (VitalSignsAll)getDomainImpl(VitalSignsImpl.class);
		vs.savePatientEws(voPatEws);
	}

	public ims.core.vo.VitalSignsVoCollection listVitalSignsByEpisodeofCare(ims.core.admin.vo.EpisodeOfCareRefVo episodeofcareref)
	{
		VitalSignsAll vs = (VitalSignsAll)getDomainImpl(VitalSignsImpl.class);
		return vs.listVitalSignsByEpisodeofCare(episodeofcareref);
	}

	public ims.assessment.vo.PatientAssessmentVo getPatientAssessmentFull(ims.assessment.instantiation.vo.PatientAssessmentRefVo patientAssessment)
	{
		VitalSignsAll vs = (VitalSignsAll)getDomainImpl(VitalSignsImpl.class);
		return vs.getPatientAssessmentFull(patientAssessment);
	}

	//WDEV-20311
	public TriageForClinicianWorklistVo getTriage(TriageRefVo triageRef)
	{
		if (triageRef == null || triageRef.getID_Triage()==null)
			throw new CodingRuntimeException("Can not retrieve TriageForClinicianWorklistVo for null triage.");
		
		Triage doTriage = (Triage)getDomainFactory().getDomainObject(Triage.class,triageRef.getID_Triage()); 
		return TriageForClinicianWorklistVoAssembler.create(doTriage);
	}

	//WDEV-20327
	public Float getHeight(String ulnaValue, Integer age, Sex sex)
	{
		VitalSignsAll vs = (VitalSignsAll)getDomainImpl(VitalSignsImpl.class);
		return vs.getHeight(ulnaValue, age, sex);
	}
}
