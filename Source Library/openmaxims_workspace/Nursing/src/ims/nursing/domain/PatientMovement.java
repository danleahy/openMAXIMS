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

package ims.nursing.domain;

// Generated from form domain impl
public interface PatientMovement extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Retrieves a list of PatientHandling Objects on Episode iD
	*/
	public ims.coe.vo.PatientHandlingHeaderCollection listPatientHandling(ims.core.vo.CareContextShortVo careContextShortVo);

	// Generated from form domain interface definition
	/**
	* Retrieves a list of Patient Movement Objects on Episode ID
	*/
	public ims.coe.vo.PatientMovementHeaderCollection listPatientMovement(ims.core.vo.CareContextShortVo careContextShortVo);

	// Generated from form domain interface definition
	/**
	* Retrieve a PatientHandling Object by its Unid
	*/
	public ims.coe.vo.PatientHandling getPatientHandling(ims.coe.vo.PatientHandlingHeader patientHandlingVo);

	// Generated from form domain interface definition
	/**
	* Retrieve a PatientMovement Object by its Unid
	*/
	public ims.coe.vo.PatientMovement getPatientMovement(ims.coe.vo.PatientMovementHeader patientMovementVo);

	// Generated from form domain interface definition
	/**
	* Saves  PatientHandling and PatientHandlingDetails
	*/
	public ims.nursing.vo.AssessmentHeaderInfo savePatientHandling(ims.coe.vo.PatientHandling patientHandlingVo, ims.nursing.vo.AssessmentHeaderInfo assessmentVo, ims.nursing.vo.AssessmentComponent componentVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Saves PatientMovement and PatientMovementDetails
	*/
	public ims.nursing.vo.AssessmentHeaderInfo savePatientMovement(ims.coe.vo.PatientMovement patientMovementVo, ims.nursing.vo.AssessmentHeaderInfo assessmentVo, ims.nursing.vo.AssessmentComponent componentVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* true if the Patient Handling record belongs to a MobilityAssessment
	*/
	public Boolean isHandlingPartOfMobilityAss(ims.coe.vo.PatientHandlingHeader voPatientHandling) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* true if the Patient Movement record belongs to a MobilityAssessment
	*/
	public Boolean isMovementPartOfMobilityAss(ims.coe.vo.PatientMovementHeader voPatientMovement) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* Save a Patient Handling record with no assessment.
	*/
	public ims.coe.vo.PatientHandling savePatientHandlingNoAssessment(ims.coe.vo.PatientHandling patientHandlingVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Save a Patient movement record with no assessment
	*/
	public ims.coe.vo.PatientMovement savePatientMovementNoAssessment(ims.coe.vo.PatientMovement patientMovementVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public String[] getReportAndTemplate(Integer reportId, Integer templateId);
}
