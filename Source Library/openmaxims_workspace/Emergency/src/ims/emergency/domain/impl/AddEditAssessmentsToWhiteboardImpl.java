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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4910.25978)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.DomainFactory;
import ims.emergency.domain.base.impl.BaseAddEditAssessmentsToWhiteboardImpl;
import ims.emergency.vo.domain.UserAssessmentForWhiteboardConfigVoAssembler;

import java.util.List;

public class AddEditAssessmentsToWhiteboardImpl extends BaseAddEditAssessmentsToWhiteboardImpl
{

	private static final long serialVersionUID = 1L;

	public ims.emergency.vo.UserAssessmentForWhiteboardConfigVoCollection listAssessments(String searchName)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from UserAssessment u where upper(u.name) like :name and u.activeStatus =:status";
		
		query += hql.toString();
		
		List <?> list = factory.find(query, new String[]{"name","status"} , new Object[] {searchName+"%",getDomLookup(PreActiveActiveInactiveStatus.ACTIVE)});

		return UserAssessmentForWhiteboardConfigVoAssembler.createUserAssessmentForWhiteboardConfigVoCollectionFromUserAssessment(list).sort();
	}
}
