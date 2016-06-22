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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.22 build 41215.900)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.vo.CareContextShortVoCollection;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.impl.DomainImpl;
import ims.nursing.domain.MRSAAssessment;
import ims.nursing.vo.MRSAAssessmentVo;
import ims.nursing.vo.MRSAAssessmentVoCollection;
import java.util.List;
 
public class MRSATreatmentImpl extends DomainImpl implements ims.nursing.domain.MRSATreatment, ims.domain.impl.Transactional
{	
	public MRSAAssessmentVo saveTreatment(MRSAAssessmentVo voMRSA, ClinicalContactShortVo voClinicalContactShort) throws StaleObjectException 
	{
		MRSAAssessment impl = (MRSAAssessment)getDomainImpl(MRSAAssessmentImpl.class);
		return impl.saveMRSA(voMRSA, voClinicalContactShort);
	}

	public MRSAAssessmentVoCollection listMRSA(CareContextRefVo voCurrentCareContext)
	{
		MRSAAssessment impl = (MRSAAssessment)getDomainImpl(MRSAAssessmentImpl.class);
		return impl.listMRSA(voCurrentCareContext);
	}

	public CareContextShortVoCollection listMRSACareContexts(Integer idPatient)
	{
		if (idPatient != null)
		{
			DomainFactory factory = getDomainFactory();
			List MRSAaList  = factory.find(" select distinct mrsa.careContext from MRSAAssessment mrsa where mrsa.careContext.episodeOfCare.careSpell.patient.id = :patId",
					new String[]{"patId"},
					new Object[]{idPatient});
	
			CareContextShortVoCollection voCareContextList = new CareContextShortVoCollection();
			for (int x = 0; x < MRSAaList.size(); x++)
			{
				CareContext domMrsa = (CareContext) MRSAaList.get(x);
				voCareContextList.add(CareContextShortVoAssembler.create(domMrsa));
			}
	
			return voCareContextList.sort();
		}
		
		return null;
	}
}
