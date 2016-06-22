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

package ims.coe.domain;

// Generated from form domain impl
public interface AssessDressingGrooming extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Retrieves a component
	*/
	public ims.nursing.vo.AssessmentComponent getComponent(ims.nursing.assessment.vo.AssessmentComponentRefVo voRefAssessComp);

	// Generated from form domain interface definition
	/**
	* Save the component, add to the assessment, updates the list of components in the returned object
	*/
	public ims.nursing.vo.AssessmentHeaderInfo saveComponent(ims.nursing.vo.AssessmentHeaderInfo assessmentVo, ims.nursing.vo.AssessmentComponent componentVo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* Gets the last component of this type for the given patient
	*/
	public ims.nursing.vo.AssessmentComponent getLastAssessmentComponent(ims.core.vo.PatientShort patientVo, ims.core.admin.vo.CareContextRefVo careContextRefVo, ims.nursing.vo.lookups.AssessmentComponentType componentTypeVo);

	// Generated from form domain interface definition
	/**
	* List Careplan Templates for the given component type
	*/
	public ims.nursing.vo.CarePlanTemplateTitleCollection listCarePlanTemplates(ims.nursing.vo.lookups.AssessmentComponentType assessmentComponentTypeVo);

	// Generated from form domain interface definition
	/**
	* Retrieves a component
	*/
	public ims.nursing.vo.AssessmentComponent getComponent(ims.core.clinical.vo.AssessmentRefVo assessmentVo, ims.nursing.vo.lookups.AssessmentComponentType componentType);

	// Generated from form domain interface definition
	public ims.nursing.vo.AssessmentHeaderInfo getAssessment(ims.core.admin.vo.CareContextRefVo careContextVo);
}
