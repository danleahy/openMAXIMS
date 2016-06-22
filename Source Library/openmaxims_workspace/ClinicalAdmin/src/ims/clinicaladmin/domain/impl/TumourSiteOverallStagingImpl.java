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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4077.23636)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinicaladmin.domain.impl;

import java.util.ArrayList;

import ims.clinicaladmin.domain.base.impl.BaseTumourSiteOverallStagingImpl;
import ims.clinicaladmin.vo.TumourGroupSiteOverallStagingVo;
import ims.clinicaladmin.vo.TumourGroupSiteOverallStagingVoCollection;
import ims.clinicaladmin.vo.domain.TumourGroupSiteOverallStagingVoAssembler;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.oncology.configuration.domain.objects.TumourGroupSiteOverallStaging;

public class TumourSiteOverallStagingImpl extends BaseTumourSiteOverallStagingImpl
{

	private static final long serialVersionUID = 1L;

	public ims.clinicaladmin.vo.TumourGroupSiteOverallStagingVoCollection listOverall(ims.oncology.configuration.vo.TumourSiteRefVo site)
	{
		if (site == null || !site.getID_TumourSiteIsNotNull())
			return null;
		
		String query = "select overall from TumourGroupSiteOverallStaging as overall left join overall.tSite as site where site.id = :SITE_ID";
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("SITE_ID");
		paramValues.add(site.getID_TumourSite());
		
		return TumourGroupSiteOverallStagingVoAssembler.createTumourGroupSiteOverallStagingVoCollectionFromTumourGroupSiteOverallStaging(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}

	public ims.clinicaladmin.vo.TumourGroupSiteOverallStagingVoCollection saveOverall(ims.clinicaladmin.vo.TumourGroupSiteOverallStagingVoCollection overallStaging) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException, ims.domain.exceptions.UniqueKeyViolationException
	{
		if (overallStaging == null)
			throw new DomainInterfaceException("Can not save empty records");
		
		TumourGroupSiteOverallStagingVoCollection returnCollection = new TumourGroupSiteOverallStagingVoCollection();
		
		
		for (TumourGroupSiteOverallStagingVo overall : overallStaging)
		{
			if (!overall.isValidated())
				throw new DomainRuntimeException("Record in collection is not validated");
			
			TumourGroupSiteOverallStaging domOverall = TumourGroupSiteOverallStagingVoAssembler.extractTumourGroupSiteOverallStaging(getDomainFactory(), overall);
			
			getDomainFactory().save(domOverall);
			
			returnCollection.add(TumourGroupSiteOverallStagingVoAssembler.create(domOverall));
		}
		
		return returnCollection;
	}
}
