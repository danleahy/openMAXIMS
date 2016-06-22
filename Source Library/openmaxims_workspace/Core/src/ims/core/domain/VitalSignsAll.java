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

package ims.core.domain;

// Generated from form domain impl
public interface VitalSignsAll extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Generic List for all Vital Signs By Vital Signs Type
	*/
	public ims.core.vo.VitalSignsVoCollection listVitalSigns(ims.core.admin.vo.CareContextRefVo refCareContext);

	// Generated from form domain interface definition
	/**
	* List of Hcps
	*/
	public ims.core.vo.HcpLiteVoCollection listLiteHcps(ims.core.vo.HcpFilter hcpFilter);

	// Generated from form domain interface definition
	/**
	* Saves a vital sign
	*/
	public ims.core.vo.VitalSignsVo saveVitalSign(ims.core.vo.VitalSignsVo vitalSign) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.VitalSignsVo inactivateVitalSign(ims.core.vo.VitalSignsVo vitalSignsRecord, ims.core.vo.lookups.VSType type) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Get a Vital Sign record
	*/
	public ims.core.vo.VitalSignsVo getVitalSignsRecord(ims.core.vo.VitalSignsVo voVitalSign);

	// Generated from form domain interface definition
	/**
	* get Metrics From Patient
	*/
	public ims.core.vo.VSMetrics getMetricsFromPatient(ims.core.patient.vo.PatientRefVo voPatientRef);

	// Generated from form domain interface definition
	/**
	* save Metrics To Core Clinical
	*/
	public ims.core.vo.VSMetrics saveMetricsToPatient(ims.core.vo.VSMetrics voMetrics) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.clinical.vo.SECSVo getSecs();

	// Generated from form domain interface definition
	/**
	* savePatientEws
	*/
	public void savePatientEws(ims.core.vo.PatientEWSVo voPatEws);

	// Generated from form domain interface definition
	public ims.core.vo.VitalSignsVoCollection listVitalSignsByEpisodeofCare(ims.core.admin.vo.EpisodeOfCareRefVo episodeofcareref);

	// Generated from form domain interface definition
	public ims.assessment.vo.PatientAssessmentVo getPatientAssessmentFull(ims.assessment.instantiation.vo.PatientAssessmentRefVo patientAssessment);

	// Generated from form domain interface definition
	public java.lang.Float getHeight(String ulnaValue, Integer age, ims.core.vo.lookups.Sex sex);
}
