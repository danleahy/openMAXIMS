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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4050.19540)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinicaladmin.domain.impl;

import ims.clinicaladmin.domain.base.impl.BaseSelectPrognosticRiskAssessmentImpl;
import ims.clinicaladmin.vo.domain.PrognosticRiskConfigVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.oncology.configuration.domain.objects.PrognosticRiskConfiguration;

public class SelectPrognosticRiskAssessmentImpl extends BaseSelectPrognosticRiskAssessmentImpl
{

	private static final long serialVersionUID = 1L;

	public ims.clinicaladmin.vo.PrognosticRiskConfigVoCollection listRiskAssessments()
	{
		DomainFactory factory = getDomainFactory();

		String query = "from PrognosticRiskConfiguration as prsk where prsk.isActive = 1 order by riskName";

		return PrognosticRiskConfigVoAssembler.createPrognosticRiskConfigVoCollectionFromPrognosticRiskConfiguration(factory.find(query));
	}

	public ims.clinicaladmin.vo.PrognosticRiskConfigVo getRiskAssessment(ims.oncology.configuration.vo.PrognosticRiskConfigurationRefVo risk)
	{
		if (risk == null || !risk.getID_PrognosticRiskConfigurationIsNotNull())
			return null;

		DomainFactory factory = getDomainFactory();

		return PrognosticRiskConfigVoAssembler.create((PrognosticRiskConfiguration) factory.getDomainObject(PrognosticRiskConfiguration.class, risk.getID_PrognosticRiskConfiguration()));
	}

	public ims.clinicaladmin.vo.PrognosticRiskConfigVo saveRiskAssessment(ims.clinicaladmin.vo.PrognosticRiskConfigVo risk) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException, ims.domain.exceptions.UniqueKeyViolationException
	{
		if(risk == null)
			throw new DomainRuntimeException("prognosticRiskVo parameter is null in method savePrognosticRisk");
		
		if(!risk.isValidated())
			throw new DomainRuntimeException("This Prognostic Risk has not been validated");
		
		PrognosticRiskConfiguration prognosticRisk = PrognosticRiskConfigVoAssembler.extractPrognosticRiskConfiguration(getDomainFactory(), risk);
		getDomainFactory().save(prognosticRisk);
		
		return PrognosticRiskConfigVoAssembler.create(prognosticRisk);
	}
}
