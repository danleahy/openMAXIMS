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
// This code was generated by Ander Telleria using IMS Development Environment (version 1.70 build 3453.13770)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.assessment.configuration.domain.objects.UserAssessment;
import ims.assessment.vo.domain.UserAssessmentShortVoAssembler;
import ims.core.domain.base.impl.BaseSelectAssessmentImpl;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.DomainFactory;
import ims.domain.DomainFactory.ORDERMODE;
import ims.domain.hibernate3.IMSCriteria;

import java.util.List;

public class SelectAssessmentImpl extends BaseSelectAssessmentImpl
{

	private static final long serialVersionUID = 1L;

	public ims.assessment.vo.UserAssessmentShortVoCollection listAssessments(String assessment)
	{
		DomainFactory factory = getDomainFactory();
		IMSCriteria imsc=new IMSCriteria(UserAssessment.class,factory);
		imsc.like(UserAssessment.FieldNames.Name, assessment + "%");
		imsc.equal(UserAssessment.FieldNames.ActiveStatus, getDomLookup(PreActiveActiveInactiveStatus.ACTIVE));//WDEV-12097
		imsc.addOrder("name", ORDERMODE.ASC);//WDEV-12097
		List<UserAssessment> assessments=imsc.find();
		if (assessments.size()>0)
			return UserAssessmentShortVoAssembler.createUserAssessmentShortVoCollectionFromUserAssessment(assessments);
		return null;
	}
}
