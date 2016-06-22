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

import java.util.List;

import ims.admin.vo.domain.AppFormVoAssembler;
import ims.assessment.configuration.domain.objects.GraphicAssessment;
import ims.assessment.vo.GraphicAssessmentShortVoCollection;
import ims.assessment.vo.domain.GraphicAssessmentShortVoAssembler;
import ims.core.configuration.domain.objects.AppForm;
import ims.core.domain.base.impl.BaseSelectGraphicalAssessmentImpl;
import ims.domain.DomainFactory;
import ims.domain.DomainFactory.ORDERMODE;
import ims.domain.hibernate3.IMSCriteria;

public class SelectGraphicalAssessmentImpl extends BaseSelectGraphicalAssessmentImpl
{
	private static final long serialVersionUID = 1L;

	public ims.assessment.vo.GraphicAssessmentShortVoCollection listAssessments(String assessment)
	{
		final int STATUS_ACTIVE = -617;
		
		// Get domain factory
		DomainFactory factory = getDomainFactory();
	
		// Create filter criteria
		IMSCriteria imsc = new IMSCriteria(GraphicAssessment.class,factory);
		
		// Add filters
		imsc.like(GraphicAssessment.FieldNames.Name, assessment + "%");
		imsc.equal("this.activeStatus.id", STATUS_ACTIVE);
		
		imsc.addOrder(GraphicAssessment.FieldNames.Name, ORDERMODE.ASC);//WDEV-17478
		
		// Query for records
		List<GraphicAssessment> assessments = imsc.find();
		
		
		if (assessment != null && assessments.size() > 0)
		{
			return GraphicAssessmentShortVoAssembler.createGraphicAssessmentShortVoCollectionFromGraphicAssessment(assessments);
		}
		
		return null;
	}
}
