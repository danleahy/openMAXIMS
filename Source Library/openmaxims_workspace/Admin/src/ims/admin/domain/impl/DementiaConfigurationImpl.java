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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4694.23489)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.base.impl.BaseDementiaConfigurationImpl;
import ims.admin.vo.DementiaConfigurationVo;
import ims.admin.vo.domain.DementiaConfigurationVoAssembler;
import ims.core.admin.domain.objects.DementiaConfiguration;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class DementiaConfigurationImpl extends BaseDementiaConfigurationImpl
{

	private static final long serialVersionUID = 1L;
	//WDEV-18743
	public DementiaConfigurationVo save(DementiaConfigurationVo dementiaConfigToSave) throws StaleObjectException, UniqueKeyViolationException
	{
		if (dementiaConfigToSave == null)
			throw new CodingRuntimeException("Cannot save null DementiaConfiguration ");

		if (!dementiaConfigToSave.isValidated())
			throw new DomainRuntimeException("DementiaConfiguration Not Validated.");
		
		if (isDementiaConfigurationRecorded(dementiaConfigToSave)) //WDEV-18743
			throw new UniqueKeyViolationException("A dementia configuration record has already been saved. The screen will be refreshed.");
		
		DomainFactory factory = getDomainFactory();
		DementiaConfiguration domainDementiaConfig = DementiaConfigurationVoAssembler.extractDementiaConfiguration(factory, dementiaConfigToSave);

		factory.save(domainDementiaConfig);

		return DementiaConfigurationVoAssembler.create(domainDementiaConfig);
	}
	//WDEV-18743
	private boolean isDementiaConfigurationRecorded(DementiaConfigurationVo dementiaConfigToSave)
	{
		String hql = "select dcfg from DementiaConfiguration as dcfg where dcfg.id <> " + dementiaConfigToSave.getID_DementiaConfiguration();
		
		List<?> results = getDomainFactory().find(hql);
		
		if (results != null && results.size() > 0)
		{
			return true;
		}	
		return false;
	}
	public ims.admin.vo.DementiaConfigurationVo getDementiaConfig()
	{
		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();
		hql.append("from DementiaConfiguration as dementiaConfig");

		List<?> list = factory.find(hql.toString());

		if (list == null || list.size() == 0)
			return null;

		return DementiaConfigurationVoAssembler.create((DementiaConfiguration) list.get(0));
	}
}
