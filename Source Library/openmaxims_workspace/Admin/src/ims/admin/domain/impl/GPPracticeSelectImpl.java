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
// This code was generated by Neil McAnaspie using IMS Development Environment (version 1.21 build 41021.900)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.core.vo.domain.OrganisationVoAssembler;
import ims.core.vo.lookups.OrganisationType;
import ims.domain.DomainFactory;
import ims.domain.impl.DomainImpl;

public class GPPracticeSelectImpl extends DomainImpl implements ims.admin.domain.GPPracticeSelect, ims.domain.impl.Transactional
{
	/**
	* list Practices by either Practice name or Partial Address
	*/
	public ims.core.vo.OrganisationVoCollection listPractices(ims.core.vo.OrganisationVo organisationFilter)
	{ 
		DomainFactory factory = getDomainFactory();
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		String hql = " from Organisation org "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
		
		condStr.append(andStr + " org.type = :orgType");
		markers.add("orgType");
		values.add(getDomLookup(OrganisationType.GPP));
		
		if (organisationFilter.getName() != null && organisationFilter.getName().length() > 0)
		{
			condStr.append(" and upper(org.name) like :practiceName");
			markers.add("practiceName");
			values.add("%" + organisationFilter.getName().toUpperCase() + "%");
		}
		else if (organisationFilter.getAddress() != null)
		{
			if (organisationFilter.getAddress().getLine1() != null && organisationFilter.getAddress().getLine1().length() > 0)
			{
				condStr.append(" and upper(org.address.line1) like :partialAddress");
				condStr.append(" or upper(org.address.line2) like :partialAddress");
				condStr.append(" or upper(org.address.line3) like :partialAddress");
				condStr.append(" or upper(org.address.line4) like :partialAddress");
				condStr.append(" or upper(org.address.line5) like :partialAddress");
				markers.add("partialAddress");
				values.add("%" + organisationFilter.getAddress().getLine1().toUpperCase() + "%");
			}
		}
			
					
		hql += " where " + condStr.toString();
		
		List orgs = factory.find(hql,markers,values);
		
		return OrganisationVoAssembler.createOrganisationVoCollectionFromOrganisation(orgs).sort();
	}
}
