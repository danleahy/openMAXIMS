//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.51 build 2463.27097)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.assessment.domain.impl;

import ims.assessment.configuration.domain.objects.UserDefinedObject;
import ims.assessment.configuration.domain.objects.UserDefinedObjectComponent;
import ims.assessment.configuration.vo.UserDefinedObjectComponentRefVo;
import ims.assessment.domain.base.impl.BaseUserAssessmentInstantiationWithComponentImpl;
import ims.assessment.instantiation.domain.objects.PatientAssessment;
import ims.assessment.instantiation.vo.PatientAssessmentRefVo;
import ims.assessment.vo.PatientAssessmentVo;
import ims.assessment.vo.UserDefinedObjectVo;
import ims.assessment.vo.domain.PatientAssessmentVoAssembler;
import ims.assessment.vo.domain.UserDefinedObjectComponentVoAssembler;
import ims.assessment.vo.domain.UserDefinedObjectVoAssembler;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.UserDefinedAssessmentType;
import ims.core.vo.lookups.UserDefinedObjectType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class UserAssessmentInstantiationWithComponentImpl extends BaseUserAssessmentInstantiationWithComponentImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* save
	*/
	public ims.assessment.vo.PatientAssessmentVo save(ims.assessment.vo.PatientAssessmentVo record) throws ims.domain.exceptions.StaleObjectException
	{
		if(record == null)
			throw new DomainRuntimeException("Cannot save null value for voPatientAssessment");
		if(record.isValidated() == false)
			throw new DomainRuntimeException("PatientAssessmentVo not validated");
		
		DomainFactory factory = getDomainFactory();
		PatientAssessment doPatientAssessment = PatientAssessmentVoAssembler.extractPatientAssessment(factory, record);
		factory.save(doPatientAssessment);
		
		return PatientAssessmentVoAssembler.create(doPatientAssessment);
	}

	/**
	* get
	*/
	public ims.assessment.vo.PatientAssessmentVo get(PatientAssessmentRefVo record)
	{
		if(record == null || record.getID_PatientAssessment() == null)
			throw new DomainRuntimeException("Invalid need assessment record to get");
		
		return PatientAssessmentVoAssembler.create((PatientAssessment)getDomainFactory().getDomainObject(PatientAssessment.class, record.getID_PatientAssessment()));
	}

	/**
	* getComponent
	*/
	public ims.assessment.vo.UserDefinedObjectComponentVo getComponent(UserDefinedObjectComponentRefVo ref)
	{
		if(ref == null || ref.getID_UserDefinedObjectComponent() == null)
			throw new DomainRuntimeException("Invalid component");
				
		return UserDefinedObjectComponentVoAssembler.create((UserDefinedObjectComponent)getDomainFactory().getDomainObject(UserDefinedObjectComponent.class, ref.getID_UserDefinedObjectComponent().intValue()));
	}

	public UserDefinedObjectVo getUDF(UserDefinedObjectType udfType, PreActiveActiveInactiveStatus status)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "select u1_1 from UserDefinedObject as u1_1 left join u1_1.components as u2_1 left join u1_1.objectType as l1_1 left join u1_1.activeStatus as l2_1 ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if (udfType != null)
		{
			hql.append(andStr + " l1_1.id = :UDFTYPE ");
			markers.add("UDFTYPE");
			values.add(new Integer(udfType.getID()));
			andStr = " and ";

		}
		if (status != null)
		{
			hql.append(andStr + " l2_1.id = :STATUS ");
			markers.add("STATUS");
			values.add(new Integer(status.getId()));
			andStr = " and ";
		}

		if (markers.size() > 0)
			query += " where ";

		query += hql.toString();

		List list = factory.find(query, markers, values);
		
		if(list == null || list.size() == 0)
			return null;
		
		//we should have only one active UDF
		return UserDefinedObjectVoAssembler.create((UserDefinedObject) list.get(0));
	}

	public PatientAssessmentVo getNursingAssessment(PatientRefVo patient, EpisodeOfCareRefVo episodeOfCareRef, CareContextRefVo careContext, UserDefinedAssessmentType type)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "select p1_1 from PatientAssessment as p1_1 left join p1_1.assessmentData as p2_1 left join p2_1.userAssessment as u1_1 left join u1_1.assessmentType as l1_1 left join p1_1.careContext as c1_1 ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if (type != null)
		{
			hql.append(andStr + " l1_1.id = :TYPE ");
			markers.add("TYPE");
			values.add(new Integer(type.getID()));
			andStr = " and ";

		}
		if (careContext != null)
		{
			hql.append(andStr + " c1_1.id = :CONTEXT ");
			markers.add("CONTEXT");
			values.add(careContext.getID_CareContext());
			andStr = " and ";
		}
		
		//WDEV-11526 - starts here
		else if (episodeOfCareRef != null)
		{
			hql.append(andStr + " p1_1.episodeOfCare.id = :EPISODE ");
			markers.add("EPISODE");
			values.add(episodeOfCareRef.getID_EpisodeOfCare());
			andStr = " and ";
		}
		//WDEV-11526 - ends here
		
		//WDEV-115721 - starts here
		else if (patient != null)
		{
			hql.append(andStr + " p1_1.patient.id = :pat ");
			markers.add("pat");
			values.add(patient.getID_Patient());
			andStr = " and ";
		}
		//WDEV-11721 - ends here
		
		if (markers.size() > 0)
			query += " where ";

		query += hql.toString();

		List list = factory.find(query, markers, values);
		
		if(list.size() == 0)
			return null;
		
		//we should have only one per care context
		return PatientAssessmentVoAssembler.create((PatientAssessment) list.get(0));
	}
}
