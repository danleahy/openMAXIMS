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

package ims.assessment.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BasePatientAssessmentImpl extends DomainImpl implements ims.assessment.domain.PatientAssessment, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistPatientAssessments(ims.core.admin.vo.CareContextRefVo careContextRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatesavePatientAssessment(ims.assessment.vo.PatientAssessmentVo voPatientAssessment)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientAssessment(Integer patientAssessmentId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientAssessmentList(ims.assessment.instantiation.vo.PatientAssessmentRefVo patAssessmentRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatesavePatientAssessmentList(ims.assessment.vo.PatientAssessmentListVo voPatientAssessmentList)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistPatientUserDefinedObjects(ims.core.patient.vo.PatientRefVo patient, ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRef, ims.core.admin.vo.CareContextRefVo careContextRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatesavePatientUserDefinedObject(ims.assessment.vo.PatientUserDefinedObjectVo voPatientUserDefinedObject)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientUserDefinedObjectList(ims.assessment.instantiation.vo.PatientUserDefinedObjectRefVo patientUserDefinedObjectRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientUserDefinedObject(ims.assessment.instantiation.vo.PatientUserDefinedObjectRefVo patientUserDefinedObjectRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistPatientAssessments(ims.core.admin.vo.CareContextRefVo careContextRefVo, ims.core.vo.lookups.UserDefinedAssessmentType assessmentType)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatinetAssessmentListById(ims.assessment.instantiation.vo.PatientUserDefinedObjectRefVo recordId)
	{
	}
}
