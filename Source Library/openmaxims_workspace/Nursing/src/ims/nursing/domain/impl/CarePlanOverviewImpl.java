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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.18 build 40629.1400)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.nursing.vo.CarePlanOverviewCollection;
import ims.nursing.vo.CarePlanStatus;
import ims.nursing.vo.domain.CarePlanOverviewAssembler;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.domain.objects.CareSpell;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.vo.CareContextVo;
import ims.core.vo.CareSpellVo;
import ims.core.vo.domain.CareContextVoAssembler;
import ims.core.vo.domain.CareSpellVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.impl.DomainImpl;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.CodingRuntimeException;

public class CarePlanOverviewImpl extends DomainImpl implements ims.nursing.domain.CarePlanOverview, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	/**
	* Lists all careplans for the given Episode with the filter of 0 = Active, 1 = All
	*/
	public CarePlanOverviewCollection listCarePlans(CareContextRefVo voCurrentCareContext, CarePlanStatus currentStatus, Boolean bCarePlansFromOtherContexts) throws DomainInterfaceException
	{
		if(voCurrentCareContext == null && voCurrentCareContext.getID_CareContextIsNotNull())
			throw new CodingRuntimeException("Current Care Context not available.");

		DomainFactory factory = getDomainFactory();
		
		String hqlQuery = " from CarePlan cp ";
		StringBuffer condStr = new StringBuffer();
		ArrayList<String> markerNames = new ArrayList<String>();
		ArrayList<Integer> markerValues = new ArrayList<Integer>();
				
		CarePlanOverviewCollection voColl = null;
		
		condStr.append(" where ");
		
		if(voCurrentCareContext != null)
		{
			if(!bCarePlansFromOtherContexts)
				condStr.append(" cp.careContext.id = :rcc");
			else{
				condStr.append(" cp.careContext.episodeOfCare.careSpell.patient.id = :patientId and cp.careContext.id != :rcc");
				markerNames.add("patientId");
				markerValues.add(getPatientId(voCurrentCareContext));
			}
			markerNames.add("rcc");
			markerValues.add(voCurrentCareContext.getID_CareContext());
			
		}
		
		if(currentStatus != null)
		{
			if(currentStatus.getStatus() != null)
			{
				if(currentStatus != null)
					condStr.append(" and ");
				
				condStr.append(" cp.currentCarePlanStatus.status.id = :status");
				markerNames.add("status");
				markerValues.add(new Integer(currentStatus.getStatus().getId()));
			}
		}
		
		hqlQuery += condStr.toString();
		
		List careplans = factory.find(hqlQuery,markerNames,markerValues);	

		if(careplans != null)
			voColl = (CarePlanOverviewAssembler.createCarePlanOverviewCollectionFromCarePlan(careplans)); 
		
		if(voColl != null)
			voColl.sort(SortOrder.ASCENDING);
		
		return voColl;		
	}

	private Integer getPatientId(CareContextRefVo voCurrentCareContext) {
		
		DomainFactory factory = getDomainFactory();
		CareContext doCareContext = (CareContext)factory.getDomainObject(CareContext.class, voCurrentCareContext.getID_CareContext());
		CareContextVo voCareContext = CareContextVoAssembler.create(doCareContext);
		CareSpell doCareSpell = (CareSpell)factory.getDomainObject(CareSpell.class, voCareContext.getEpisodeOfCare().getCareSpell().getID_CareSpell());
		CareSpellVo voCareSpell = CareSpellVoAssembler.create(doCareSpell);
		return voCareSpell.getPatient().getID_Patient();
	}

}
