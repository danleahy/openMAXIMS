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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.45 build 2389.16953)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.assessment.domain.impl;

import ims.assessment.domain.base.impl.BaseUserAssessmentsImpl;
import ims.assessment.vo.UserAssessmentShortVoCollection;
import ims.assessment.vo.domain.UserAssessmentShortVoAssembler;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.UserAssessmentCategory;
import ims.core.vo.lookups.UserDefinedAssessmentType;
import ims.core.vo.lookups.UserDefinedAssessmentTypeCollection;
import ims.domain.DomainFactory;

import java.util.ArrayList;
import java.util.List;

public class UserAssessmentsImpl extends BaseUserAssessmentsImpl implements ims.assessment.domain.UserAssessments, ims.domain.impl.Transactional
{
	public UserAssessmentShortVoCollection listAssessments(String name, UserAssessmentCategory category, UserDefinedAssessmentType assessmentType)
	{
		UserDefinedAssessmentTypeCollection lkpColl = new UserDefinedAssessmentTypeCollection();
		if (assessmentType != null)
			lkpColl.add(assessmentType);
		return listAssessments(name, category, lkpColl, null);
	}

	public UserAssessmentShortVoCollection listAssessments(String name, PreActiveActiveInactiveStatus status, UserDefinedAssessmentType assessmentType)
	{
		UserDefinedAssessmentTypeCollection lkpColl = new UserDefinedAssessmentTypeCollection();
		lkpColl.add(assessmentType);
		return listAssessments(name, null, lkpColl, status);
	}

	public UserAssessmentShortVoCollection listAssessments(String name, ims.core.vo.lookups.UserAssessmentCategory category, UserDefinedAssessmentTypeCollection assessmentTypeColl, ims.core.vo.lookups.PreActiveActiveInactiveStatus status)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from UserAssessment u ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if (name != null && name.length() > 0)
		{
			hql.append(andStr + " upper(u.name) like :name");
			markers.add("name");
			values.add(name.toUpperCase());
			andStr = " and ";

		}
		if (category != null)
		{
			hql.append(andStr + " u.category.id =:category");
			markers.add("category");
			values.add(new Integer(category.getId()));
			andStr = " and ";
		}

		if (status != null)
		{
			hql.append(andStr + " u.activeStatus =:status");
			markers.add("status");
			values.add(getDomLookup(status));
			andStr = " and ";
		}

		if (assessmentTypeColl != null)
		{
			int size = assessmentTypeColl.size();
			for (int i = 0; i < size; i++)
			{
				UserDefinedAssessmentType assType = assessmentTypeColl.get(i);
				hql.append(andStr);
				if (i == 0)
					hql.append(" (");
				hql.append(" u.assessmentType.id =:assessmentType" + Integer.toString(i));
				markers.add("assessmentType" + i);
				values.add(new Integer(assType.getId()));
				andStr = " or ";

				if (i == (size - 1))
					hql.append(")");	
			}
		}

		if (markers.size() > 0)
			query += " where ";

		query += hql.toString();

		List list = factory.find(query, markers, values);

		return UserAssessmentShortVoAssembler.createUserAssessmentShortVoCollectionFromUserAssessment(list).sort();
	}
}
