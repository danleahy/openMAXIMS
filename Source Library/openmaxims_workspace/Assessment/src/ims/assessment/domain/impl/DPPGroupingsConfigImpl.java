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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.45 build 2426.24615)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.assessment.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.assessment.domain.base.impl.BaseDPPGroupingsConfigImpl;
import ims.assessment.configuration.domain.objects.DPPQuestionGroup;
import ims.assessment.configuration.domain.objects.UserAssessment;
import ims.assessment.configuration.vo.UserAssessmentRefVo;
import ims.assessment.vo.DPPQuestionGroupShortVoCollection;
import ims.assessment.vo.DPPQuestionGroupVoCollection;
import ims.assessment.vo.UserAssessmentVo;
import ims.assessment.vo.domain.DPPQuestionGroupShortVoAssembler;
import ims.assessment.vo.domain.DPPQuestionGroupVoAssembler;
import ims.assessment.vo.domain.UserAssessmentLiteVoAssembler;
import ims.assessment.vo.domain.UserAssessmentVoAssembler;
import ims.clinical.vo.lookups.PlanOfCareGroupings;
import ims.core.vo.lookups.UserDefinedAssessmentType;
import ims.core.vo.lookups.UserDefinedAssessmentTypeCollection;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.CodingRuntimeException;

public class DPPGroupingsConfigImpl extends BaseDPPGroupingsConfigImpl
{
	private static final long	serialVersionUID	= 1L;

	public ims.assessment.vo.UserAssessmentLiteVoCollection listUserAssessments(UserDefinedAssessmentTypeCollection assessmentTypes)
	{
		if (assessmentTypes == null || assessmentTypes.size() == 0)
			throw new CodingRuntimeException("Cannot list UserAssessment for null assessmentTypes");

		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("from UserAssessment u ");
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String orStr = " where ";

		// AssessmentType
		for (int i = 0; i < assessmentTypes.size(); i++)
		{
			UserDefinedAssessmentType type = assessmentTypes.get(i);
			if (type != null)
			{
				String marker = "assType" + i;
				hql.append(orStr + " u.assessmentType =:" + marker);
				markers.add(marker);
				values.add(getDomLookup(type));
				orStr = " or ";
			}
		}

		List list = factory.find(hql.toString(), markers, values);

		return UserAssessmentLiteVoAssembler.createUserAssessmentLiteVoCollectionFromUserAssessment(list).sort(SortOrder.DESCENDING);
	}

	public UserAssessmentVo getUserAssessment(UserAssessmentRefVo userAssessmentRefVo)
	{
		if (userAssessmentRefVo == null)
			throw new CodingRuntimeException("Cannot get UserAssessmentVo for null UserAssessmentRefVo");
		DomainFactory factory = getDomainFactory();
		UserAssessment doUserAssessment = (UserAssessment) factory.getDomainObject(UserAssessment.class, userAssessmentRefVo.getID_UserAssessment());
		return UserAssessmentVoAssembler.create(doUserAssessment);
	}

	public DPPQuestionGroupVoCollection listDPPGroupings(UserAssessmentRefVo userAssessmentRefVo)
	{
		List list = listDppGroupingsRecord(userAssessmentRefVo);
		return DPPQuestionGroupVoAssembler.createDPPQuestionGroupVoCollectionFromDPPQuestionGroup(list);
	}

	public DPPQuestionGroupShortVoCollection listDPPGroupings(UserAssessmentRefVo userAssessmentRefVo, Boolean status)
	{
		List list = listDppGroupingsRecord(userAssessmentRefVo, null, status);
		return DPPQuestionGroupShortVoAssembler.createDPPQuestionGroupShortVoCollectionFromDPPQuestionGroup(list);
	}

	private List listDppGroupingsRecord(UserAssessmentRefVo userAssessmentRefVo)
	{
		return listDppGroupingsRecord(userAssessmentRefVo, null, null);
	}

	private List listDppGroupingsRecord(UserAssessmentRefVo userAssessmentRefVo, PlanOfCareGroupings group, Boolean status)
	{
		if (userAssessmentRefVo == null)
			throw new CodingRuntimeException("Cannot list DPPQuestionGroupVoCollection for null UserAssessmentRefVo");

		StringBuffer sb = new StringBuffer("from DPPQuestionGroup dpp");
		ArrayList paramNames = new ArrayList();
		ArrayList values = new ArrayList();
		boolean whereClause = true;
		if (userAssessmentRefVo != null)
		{
			sb.append(getClause(whereClause));
			sb.append("dpp.userAssessment.id =:userAssId");
			paramNames.add("userAssId");
			values.add(userAssessmentRefVo.getID_UserAssessment());
			whereClause = false;
		}
		
		if(group != null)
		{
			sb.append(getClause(whereClause));
			sb.append("dpp.group =:group");
			paramNames.add("group");
			values.add(getDomLookup(group));
			whereClause = false;
		}
		
		if(status != null)
		{
			sb.append(getClause(whereClause));
			sb.append("dpp.isActive =:status");
			paramNames.add("status");
			values.add(status);
			whereClause = false;
		}
		
		paramNames.trimToSize();
		values.trimToSize();

		List list = getDomainFactory().find(sb.toString(), paramNames, values);
		return list;
	}

	private StringBuffer getClause(boolean whereClause)
	{
		StringBuffer sb = new StringBuffer(1);
		if (whereClause)
			sb.append(" where ");
		else
			sb.append(" and ");

		return sb;
	}

	public Boolean saveDPPQuestionGroupVoCollection(DPPQuestionGroupVoCollection voDppQuestionGroupCollection) throws StaleObjectException
	{
		if (voDppQuestionGroupCollection == null)
			throw new CodingRuntimeException("Cannot save null value for DPPQuestionGroupVoCollection");

		if (voDppQuestionGroupCollection.isValidated() == false)
			throw new CodingRuntimeException("DPPQuestionGroupVoCollection has not been validated");

		DomainFactory factory = getDomainFactory();
		for (int i = 0; voDppQuestionGroupCollection != null && i < voDppQuestionGroupCollection.size(); i++)
		{
			DPPQuestionGroup doDPPQuestionGroup = DPPQuestionGroupVoAssembler.extractDPPQuestionGroup(factory, voDppQuestionGroupCollection.get(i));
			factory.save(doDPPQuestionGroup);
		}

		return Boolean.TRUE;
	}
}
