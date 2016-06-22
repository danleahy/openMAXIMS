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
// This code was generated by Dara Hickey using IMS Development Environment (version 1.22 build 50311.1300)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.OrganisationAndLocation;
import ims.core.vo.OrganisationMinWithLocSitesVoCollection;
import ims.domain.impl.DomainImpl;

public class LocationSelectImpl extends DomainImpl implements ims.admin.domain.LocationSelect, ims.domain.impl.Transactional
{
	private static final long	serialVersionUID	= 1L;

	public OrganisationMinWithLocSitesVoCollection  listRootOrgsNoGpp()//WDEV-20044
	{		
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl (OrganisationAndLocationImpl.class);				
		return impl.listActiveRootOrgsNoGppLite();
	}
}
