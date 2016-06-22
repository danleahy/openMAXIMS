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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import java.util.List;

import ims.core.domain.base.impl.BaseBedAvailabilityTimesImpl;
import ims.core.vo.domain.BedSpaceVoAssembler;
import ims.domain.DomainFactory;

public class BedAvailabilityTimesImpl extends BaseBedAvailabilityTimesImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.BedSpaceVoCollection getBedSpaces(ims.core.resource.place.vo.LocationRefVo bay)
	{
		if(bay == null || bay.getID_Location() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		String query = "select bed from BayConfig as bayConfig left join bayConfig.floorBedSpaceLayout as layout left join layout.bedSpaces as bed where bayConfig.bay.id = :BayId";
		
		List<?> beds = factory.find(query, new String[] {"BayId"}, new Object[] {bay.getID_Location()});
		return BedSpaceVoAssembler.createBedSpaceVoCollectionFromBedSpace(beds);
	}
}
