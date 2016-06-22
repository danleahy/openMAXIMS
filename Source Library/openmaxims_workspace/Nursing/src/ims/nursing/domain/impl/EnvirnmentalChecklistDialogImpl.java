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
// This code was generated by Peter Martin using IMS Development Environment (version 1.60 build 2907.25848)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import ims.coe.assessment.domain.objects.MobilityComponent;
import ims.coe.vo.AssessmentMobility;
import ims.coe.vo.domain.AssessmentMobilityAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.nursing.domain.base.impl.BaseEnvirnmentalChecklistDialogImpl;
import ims.nursing.domain.objects.EnvironmentalChecklist;
import ims.nursing.vo.AssessmentComponent;
import ims.nursing.vo.EnvironmentalChecklistVo;
import ims.nursing.vo.domain.EnvironmentalChecklistVoAssembler;

public class EnvirnmentalChecklistDialogImpl extends BaseEnvirnmentalChecklistDialogImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* Retrieves header record
	*/
	public ims.coe.vo.FallAssessment getRecord(Integer recordID) throws ims.domain.exceptions.DomainInterfaceException
	{
		// TODO: Add your code here and change the return value.
		return null;
	}

	/**
	* true if the fall record belongs to a mobility assessment
	*/
	public Boolean isPartOfMobilityAssessment(ims.coe.vo.FallAssessment fallRecordVo) throws ims.domain.exceptions.DomainInterfaceException
	{
		// TODO: Add your code here and change the return value.
		return null;
	}

	public AssessmentMobility saveEnvironmentalChecklist(EnvironmentalChecklistVo voEnvironmentalChecklist, AssessmentMobility component) throws StaleObjectException {
		
//		 Ensure the Value Object was validated
		if (!voEnvironmentalChecklist.isValidated())
			throw new DomainRuntimeException("This has not been validated");
			
		DomainFactory factory = getDomainFactory();			
		//EnvironmentalChecklist domEnvironmentalChecklist = EnvironmentalChecklistVoAssembler.extractEnvironmentalChecklist(factory, voEnvironmentalChecklist);		
		
		try
		{
			//factory.save(domEnvironmentalChecklist);
			
			// If the component is not null
			if (component != null)
			{
				//voEnvironmentalChecklist = EnvironmentalChecklistVoAssembler.create(domEnvironmentalChecklist);
				component.validate();

				component.setEnvironmentChecklist(voEnvironmentalChecklist);
				
				MobilityComponent compDO = AssessmentMobilityAssembler.extractMobilityComponent(factory, component);
				
				factory.save(compDO);
				return AssessmentMobilityAssembler.create(compDO);
			}
			else
			{
				return null;
			}			
		}
		catch (DomainException e)
		{
			throw new DomainRuntimeException("DomainException occurred.\r\n" + e.getMessage(), e);
		}		
		
	}

	
}
