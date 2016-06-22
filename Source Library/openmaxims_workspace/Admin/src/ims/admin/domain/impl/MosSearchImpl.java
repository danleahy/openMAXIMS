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
// This code was generated by Dara Hickey using IMS Development Environment (version 1.45 build 2421.18554)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.admin.domain.base.impl.BaseMosSearchImpl;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.MemberOfStaffLiteVoCollection;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.MemberOfStaffShortVoCollection;
import ims.core.vo.MemberOfStaffVoCollection;
import ims.core.vo.PersonName;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.MemberOfStaffLiteVoAssembler;
import ims.core.vo.domain.MemberOfStaffShortVoAssembler;
import ims.core.vo.domain.MemberOfStaffVoAssembler;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.StaffType;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;

public class MosSearchImpl extends BaseMosSearchImpl
{
	private static final long serialVersionUID = 1L;

	/**
	* Returns a MosList based on the search criteria in the passed in filter
	*/
	public MemberOfStaffShortVoCollection listMembersOfStaff(MemberOfStaffShortVo filter)
	{
		List mosList = listDomMos(filter);
		return MemberOfStaffShortVoAssembler.createMemberOfStaffShortVoCollectionFromMemberOfStaff(mosList);
	}


	private List listDomMos(MemberOfStaffShortVo filter)
	{
		DomainFactory factory = getDomainFactory();
		String hql = " from MemberOfStaff mos ";
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		if (filter.getID_MemberOfStaffIsNotNull())
		{
			hql += (" where mos.id = " + filter.getID_MemberOfStaff());
			return factory.find(hql, markers, values);
		}
		if (filter.getNameIsNotNull() && filter.getName().getSurname() != null && filter.getName().getSurname().length() > 0)
		{
			String surnameSearch = filter.getName().getSurname().toUpperCase();
			surnameSearch = surnameSearch.substring(0, Math.min(10, filter.getName().getSurname().length()));
			condStr.append(andStr + " mos.name.upperSurname like :mosSname");
			markers.add("mosSname");
			values.add(surnameSearch + "%");
			andStr = " and ";
		}

		if (filter.getStaffTypeIsNotNull())
		{
			condStr.append(andStr + " mos.staffType = :staffType");
			markers.add("staffType");
			values.add(getDomLookup(filter.getStaffType()));
			andStr = " and ";
		}

		if (filter.getHcpIsNotNull() && filter.getHcp().getHcpTypeIsNotNull())
		{
			if (filter.getHcp().getHcpType().equals(HcpDisType.OTHER))
			{
				condStr.append(andStr + " mos.hcp.hcpType not in (:hcpType1 , :hcpType2, :hcpType3)");
				markers.add("hcpType1");
				values.add(getDomLookup(HcpDisType.MEDICAL));
				markers.add("hcpType2");
				values.add(getDomLookup(HcpDisType.NURSING));
				markers.add("hcpType3");
				values.add(getDomLookup(HcpDisType.THERAPY));
				andStr = " and ";
			}
			else
			{
				condStr.append(andStr + " mos.hcp.hcpType = :hcpType");
				markers.add("hcpType");
				values.add(getDomLookup(filter.getHcp().getHcpType()));
				andStr = " and ";
			}
		}

		if (filter.getIsAppUserIsNotNull() && filter.getIsAppUser().booleanValue())
		{
			condStr.append(andStr + " mos.appUser is not null ");
			andStr = " and ";
		}

		if (filter.getIsActiveIsNotNull() && filter.getIsActive().booleanValue())
		{
			condStr.append(andStr + " mos.isActive = :isActive");
			markers.add("isActive");
			values.add(filter.getIsActive());
			andStr = " and ";
		}

		if (filter.getMappingValueIsNotNull())
		{
			condStr.append(andStr + " mos.codeMappings.taxonomyCode = :mappValue ");
			markers.add("mappValue");
			values.add(filter.getMappingValue());
			andStr = " and ";
		}
		if (andStr.equals(" and "))
			hql += " where ";

		hql += condStr.toString();
		hql += " order by mos.name.upperSurname,mos.name.upperForename";
		
		return factory.find(hql, markers, values);
	}
	
	public HcpLiteVoCollection listHcpsLite(MemberOfStaffShortVo voFilter)
	{
		DomainFactory factory = getDomainFactory();
		String hql = " from Hcp h";
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		if (voFilter.getNameIsNotNull() && voFilter.getName().getSurname() != null && voFilter.getName().getSurname().length() > 0)
		{
			condStr.append(andStr + " h.mos.name.upperSurname like :mosSname");
			markers.add("mosSname");
			values.add(voFilter.getName().getSurname().toUpperCase() + "%");
			andStr = " and ";
		}
		if (voFilter.getStaffTypeIsNotNull())
		{
			condStr.append(andStr + " h.mos.staffType = :staffType");
			markers.add("staffType");
			values.add(getDomLookup(StaffType.HCP));
			andStr = " and ";
		}

		if (voFilter.getIsActiveIsNotNull() && voFilter.getIsActive().booleanValue())
		{
			condStr.append(andStr + " h.isActive = :isActive");
			markers.add("isActive");
			values.add(voFilter.getIsActive());
			andStr = " and ";
		}

		if (voFilter.getHcpIsNotNull() && voFilter.getHcp().getHcpTypeIsNotNull())
		{
			if (voFilter.getHcp().getHcpType().equals(HcpDisType.OTHER))
			{
				condStr.append(andStr + " h.hcpType not in (:hcpType1 , :hcpType2, :hcpType3)");
				markers.add("hcpType1");
				values.add(getDomLookup(HcpDisType.MEDICAL));
				markers.add("hcpType2");
				values.add(getDomLookup(HcpDisType.NURSING));
				markers.add("hcpType3");
				values.add(getDomLookup(HcpDisType.THERAPY));
				andStr = " and ";
			}
			else
			{
				condStr.append(andStr + " h.hcpType = :hcpType");
				markers.add("hcpType");
				values.add(getDomLookup(voFilter.getHcp().getHcpType()));
				andStr = " and ";
			}
		}

		if (andStr.equals(" and "))
			hql += " where ";

		hql += condStr.toString();
		hql += " order by h.mos.name.upperSurname,h.mos.name.upperForename";
		List lstHCPs = factory.find(hql, markers, values);
		
		return HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(lstHCPs);
	}


	public MemberOfStaffLiteVoCollection listActiveMosByName(String name)
	{
		if(name == null)
			throw new CodingRuntimeException("name parameter null in method listActiveMosByName");
		
		MemberOfStaffShortVo voFilter = new MemberOfStaffShortVo();
		voFilter.setName(new PersonName());
		voFilter.getName().setSurname(name);
		voFilter.setIsActive(Boolean.TRUE);
	
		return MemberOfStaffLiteVoAssembler.createMemberOfStaffLiteVoCollectionFromMemberOfStaff(listDomMos(voFilter));
	}


	public MemberOfStaffShortVoCollection listMembersOfStaffWithPrimaryLocations(MemberOfStaffShortVo filter)
	{
		List mosList = listDomMos(filter);
		MemberOfStaffVoCollection voCollMos = MemberOfStaffVoAssembler.createMemberOfStaffVoCollectionFromMemberOfStaff(mosList);
		MemberOfStaffShortVoCollection voCollReturn = new MemberOfStaffShortVoCollection();
		if (voCollMos != null)
		{
			for (int i = 0; i < voCollMos.size(); i++)
			{
				MemberOfStaffShortVo voShortMos = new MemberOfStaffShortVo();
				voShortMos = voCollMos.get(i);
				for (int j = 0; j < voCollMos.get(i).getLocations().size(); j++)
				{
					if ( voCollMos.get(i).getLocations().get(j).getIsPrimary() != null &&
						 voCollMos.get(i).getLocations().get(j).getIsPrimary().equals(Boolean.TRUE))
						voShortMos.setPrimaryLocation(voCollMos.get(i).getLocations().get(j).getLocation());
				}
				voCollReturn.add(voShortMos);
			}
		}

		return voCollReturn;
	}
	
	
}
