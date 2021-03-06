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
// This code was generated by Peter Martin using IMS Development Environment (version 1.71 build 3642.24101)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.racpc.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.clinical.domain.objects.RACPSymptomRiskFactors;
import ims.clinical.domain.objects.RACPSymptoms;
import ims.clinical.vo.RACPSymptomRiskFactorsVo;
import ims.clinical.vo.RACPSymptomRiskFactorsVoCollection;
import ims.clinical.vo.RACPSymptomsVoCollection;
import ims.clinical.vo.domain.RACPSymptomRiskFactorsVoAssembler;
import ims.clinical.vo.domain.RACPSymptomsVoAssembler;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.clinical.domain.objects.Alcohol;
import ims.core.clinical.domain.objects.Smoking;
import ims.core.vo.domain.AlcoholVoAssembler;
import ims.core.vo.domain.SmokingAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.racpc.domain.RACPCSummary;
import ims.racpc.domain.base.impl.BaseRACPCSymptomAndRiskFactorImpl;

public class RACPCSymptomAndRiskFactorImpl extends BaseRACPCSymptomAndRiskFactorImpl
{

	private static final long serialVersionUID = 1L;

	public RACPSymptomRiskFactorsVo getRACPSymptomRiskFactorsForCareContact(CareContextRefVo refCareContextRefVo) {
		if (refCareContextRefVo == null)
			throw new CodingRuntimeException("Cannot get RACPSymptomRiskFactorsVo for null ClinicalContactRefVo");
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" from RACPSymptomRiskFactors srf where "); 
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		hql.append(" srf.careContext.id = :ccId");
		markers.add("ccId");
		values.add(refCareContextRefVo.getID_CareContext());

		List listRACPSymptomRiskFactors = factory.find(hql.toString(), markers,values);
		if(listRACPSymptomRiskFactors != null && listRACPSymptomRiskFactors.size() > 0)
		{ 
			RACPSymptomRiskFactorsVoCollection voColl = RACPSymptomRiskFactorsVoAssembler.createRACPSymptomRiskFactorsVoCollectionFromRACPSymptomRiskFactors(listRACPSymptomRiskFactors);
			if(voColl != null && voColl.size() > 0)
				return voColl.get(0);
		}
		return null;
	}

	public RACPSymptomRiskFactorsVo saveRACPSymptomRiskFactorsVo(RACPSymptomRiskFactorsVo voRACPSymptomRiskFactors) throws StaleObjectException {
		if (voRACPSymptomRiskFactors == null  || !voRACPSymptomRiskFactors.isValidated())
			throw new CodingRuntimeException("Plan Advice is null or has not been validated");
		DomainFactory factory=getDomainFactory();
		
		RACPSymptomsVoCollection symptoms = voRACPSymptomRiskFactors.getSymptoms();
		if(symptoms!=null){
			RACPSymptomsVoCollection collRACPSymptomsVo = new RACPSymptomsVoCollection();
			for (int i = 0; i < symptoms.size(); i++)
			{
				RACPSymptoms doSymptom = RACPSymptomsVoAssembler.extractRACPSymptoms(factory, symptoms.get(i));
				factory.save(doSymptom);
				collRACPSymptomsVo.add(RACPSymptomsVoAssembler.create(doSymptom));
			}
			voRACPSymptomRiskFactors.setSymptoms(collRACPSymptomsVo);
		}
		
		if(voRACPSymptomRiskFactors.getAlcoholUnitsPerWeekIsNotNull()){
			Alcohol doAlcohol  = AlcoholVoAssembler.extractAlcohol(factory, voRACPSymptomRiskFactors.getAlcoholUnitsPerWeek());
			factory.save(doAlcohol);
			voRACPSymptomRiskFactors.setAlcoholUnitsPerWeek(AlcoholVoAssembler.create(doAlcohol));
		}
		if(voRACPSymptomRiskFactors.getSmokingStatusIsNotNull()){
			Smoking doSmoking  = SmokingAssembler.extractSmoking(factory, voRACPSymptomRiskFactors.getSmokingStatus());
			factory.save(doSmoking);
			voRACPSymptomRiskFactors.setSmokingStatus(SmokingAssembler.create(doSmoking));
		}
		
		RACPSymptomRiskFactors doRACPSymptomRiskFactors = RACPSymptomRiskFactorsVoAssembler.extractRACPSymptomRiskFactors(factory, voRACPSymptomRiskFactors);
		factory.save(doRACPSymptomRiskFactors);
		return RACPSymptomRiskFactorsVoAssembler.create(doRACPSymptomRiskFactors);
	}

	//WDEV-13437
	public Boolean isRACPCSummaryComplete(CareContextRefVo careContext) 
	{
		RACPCSummary impl = (RACPCSummary)getDomainImpl(RACPCSummaryImpl.class);
		return impl.isRACPCSummaryComplete(careContext);
	}	
}
