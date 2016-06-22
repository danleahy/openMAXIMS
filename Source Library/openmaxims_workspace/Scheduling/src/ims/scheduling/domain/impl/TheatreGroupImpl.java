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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.

package ims.scheduling.domain.impl;

import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.LocShortVo;
import ims.core.vo.LocShortVoCollection;
import ims.core.vo.domain.LocShortVoAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;
import ims.scheduling.domain.base.impl.BaseTheatreGroupImpl;
import ims.scheduling.domain.objects.TheatreGroup;
import ims.scheduling.vo.TheatreGroupRefVo;
import ims.scheduling.vo.domain.TheatreGroupVoAssembler;

import java.util.List;

public class TheatreGroupImpl extends BaseTheatreGroupImpl
{

	private static final long serialVersionUID = 1L;

	public ims.scheduling.vo.TheatreGroupVo getTheatreGroup(ims.scheduling.vo.TheatreGroupRefVo theatreGroupRef)
	{
		if (theatreGroupRef==null || theatreGroupRef.getID_TheatreGroup()==null)
		{
			throw new CodingRuntimeException("Cannot get TheatreGroup on null ID");
		}
		
		DomainFactory factory = getDomainFactory();
		
		TheatreGroup doTheatreGroup = (TheatreGroup)factory.getDomainObject(theatreGroupRef);
		
		return TheatreGroupVoAssembler.create(doTheatreGroup);
	}

	public ims.scheduling.vo.TheatreGroupVoCollection listTheatreGroups(Boolean active)
	{
		DomainFactory factory = getDomainFactory();
		String hql = "from TheatreGroup as theatreGroup ";
		
		if (Boolean.TRUE.equals(active))
		{
			hql += " where theatreGroup.isActive = 1 ";
		}
		
		hql +=" order by theatreGroup.theatreGroupName asc ";
		
		List list = factory.find(hql);
		
		return TheatreGroupVoAssembler.createTheatreGroupVoCollectionFromTheatreGroup(list);
		
	}

	public ims.scheduling.vo.TheatreGroupVo save(ims.scheduling.vo.TheatreGroupVo theatreGroupToSave) throws ims.domain.exceptions.StaleObjectException
	{
		if (theatreGroupToSave==null )
		{
			throw new CodingRuntimeException("Cannot save null TheatreGroup ");
		}
		
		DomainFactory factory = getDomainFactory();
		
		TheatreGroup doTheatreGroup = TheatreGroupVoAssembler.extractTheatreGroup(factory, theatreGroupToSave);
		
		factory.save(doTheatreGroup);
		
		return TheatreGroupVoAssembler.create(doTheatreGroup);
	}

	public LocShortVoCollection listTheatreLocations(ims.core.resource.place.vo.LocationRefVo locRef, String searchText, TheatreGroupRefVo theatreGroupToBeExcludedRef)
	{
		OrganisationAndLocation impl = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		LocShortVoCollection collTheatreLoc = impl.getLocationByParent(locRef,searchText,LocationType.THEATRE);
		LocShortVoCollection collTheatreAlreadyUsed = getAlreadyUsedTheatreLocations(locRef, theatreGroupToBeExcludedRef);
		
		for (int i=0;collTheatreAlreadyUsed!=null && i<collTheatreAlreadyUsed.size(); i++)
		{
			LocShortVo theatreLocUsed = collTheatreAlreadyUsed.get(i);
			
			for (int j=0; collTheatreLoc!=null && j<collTheatreLoc.size();j++)
			{
				LocShortVo theatreLoc = collTheatreLoc.get(j);
				if (theatreLoc.equals(theatreLocUsed))
				{
					collTheatreLoc.remove(theatreLoc);
					break;
				}
			}
		}
		
		return collTheatreLoc;
	}

	public ims.core.vo.LocationLiteVoCollection listActiveHospitals()
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listActiveHospitalsLite();
	}

	private LocShortVoCollection getAlreadyUsedTheatreLocations(LocationRefVo parentLocationRef, TheatreGroupRefVo theatreGroupToBeExcludedRef)
	{
		if (parentLocationRef==null )
		{
			throw new CodingRuntimeException("Cannot getTheatreLocations for null Hospital ");
		}
		
		DomainFactory factory = getDomainFactory();
		
		String hql = "select theatreloc from TheatreGroup as theatreGroup left join theatreGroup.hospital as hosp left join theatreGroup.theatreLocations as theatreloc where hosp.id = " +parentLocationRef.getID_Location() ;
		
		if (theatreGroupToBeExcludedRef!=null)
		{
			hql+= " and theatreGroup.id <> " + theatreGroupToBeExcludedRef.getID_TheatreGroup();
		}
		
		List list = factory.find(hql);
		
		return LocShortVoAssembler.createLocShortVoCollectionFromLocation(list);
	}
}
