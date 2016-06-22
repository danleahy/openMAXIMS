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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.70 build 3427.16359)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.rules.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.admin.domain.LookupTree;
import ims.admin.domain.impl.LookupTreeImpl;
import ims.admin.vo.AppUserShortVo;
import ims.admin.vo.AppUserShortVoCollection;
import ims.admin.vo.domain.AppUserShortVoAssembler;
import ims.configuration.gen.ConfigFlag;
import ims.core.configuration.domain.objects.AppUser;
import ims.core.configuration.vo.AppUserRefVo;
import ims.domain.DomainFactory;
import ims.rules.domain.base.impl.BaseRulesEditorComponentImpl;
import ims.vo.LookupInstanceCollection;
import ims.vo.LookupTypeVo;

public class RulesEditorComponentImpl extends BaseRulesEditorComponentImpl
{
	private static final long serialVersionUID = 1L;
		
	public LookupInstanceCollection  getLookupTypeInstance(Integer typeId) 
	{
		LookupTypeVo vo = new LookupTypeVo();
		vo.setId(typeId);
		
		LookupTree domainLookupTree = (LookupTree) getDomainImpl(LookupTreeImpl.class);
		return domainLookupTree.getLookupInstances(vo);
	}
	
	
	
	public AppUserShortVoCollection listAppUsers(AppUserShortVo appUserFilter) 
	{
		DomainFactory factory = getDomainFactory();
		String andStr = " ";
		StringBuffer clause = new StringBuffer();
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		String hql = "  from AppUser u ";
		
		boolean mosRequired = !ConfigFlag.GEN.ALLOW_NON_MOS_USERS.getValue();

		if (appUserFilter.getUsername() != null && appUserFilter.getUsername().length() > 0)
		{
			if (mosRequired)
			{
				hql = " select u from MemberOfStaff mos inner join mos.appUser u ";
				clause.append(" upper(mos.appUser.username) like :username");//name.upperSurname like :username");
				names.add("username");
				values.add(appUserFilter.getUsername().trim().toUpperCase() + "%");		
				andStr = " and ";				
			}
			else
			{
				hql = " from AppUser u ";
				clause.append(" upper(u.username) like :username");
				names.add("username");
				values.add("%" + appUserFilter.getUsername().trim().toUpperCase() + "%");
				andStr = " and ";
			}
		}		
		else if (appUserFilter.getUsername() == null)
		{
			if (mosRequired)
				hql = " select u from MemberOfStaff mos inner join mos.appUser u ";
		}
			
		if (appUserFilter.getIsActive() != null)
		{
			clause.append(andStr + " u.isActive = :isActive" );
			names.add("isActive");
			values.add(appUserFilter.getIsActive());		
			andStr = " and ";
		}
				
		clause.append(andStr).append(" u.username != 'xxxxx'");  // wdev-7907
		andStr=" and ";

		if (andStr.equals(" and "))
		{
			hql += " where ";
		}
		hql += clause.toString();

		AppUserShortVoCollection ret = new AppUserShortVoCollection();
		List l = factory.find(hql, names, values);
		for (int i = 0; i < l.size(); i++)
		{
			AppUser domUser = (AppUser)l.get(i);
			AppUserShortVo voUser = AppUserShortVoAssembler.create(domUser);
			if (domUser.getMos() != null && domUser.getMos().getName() != null)
				voUser.setUserRealName(domUser.getMos().getName().toString());
			ret.add(voUser);
			
		}
		return ret.sort();
	}
	
	public AppUserShortVo getAppUserShortVo(AppUserRefVo refVo)
	{
		if (refVo == null)
			throw new RuntimeException("Cannot get AppUserShortVo for null AppUserShortRefVo");

		AppUser doAppUser = (AppUser) getDomainFactory().getDomainObject(AppUser.class, refVo.getID_AppUser());
		return AppUserShortVoAssembler.create(doAppUser);		
	}
}
