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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.80 build 3972.30067)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.admin.domain.impl;

import java.util.List;

import ims.admin.domain.base.impl.BaseSystemJobNotificationDialogImpl;
import ims.admin.vo.AppUserShortVoCollection;
import ims.admin.vo.domain.AppUserShortVoAssembler;
import ims.domain.DomainFactory;

public class SystemJobNotificationDialogImpl extends BaseSystemJobNotificationDialogImpl
{

	private static final long serialVersionUID = 1L;

	public AppUserShortVoCollection getAppUsers(String username)
	{
		DomainFactory factory = getDomainFactory();
		String hqlString = "from AppUser appUser where appUser.isActive = :ACTIVE and appUser.username like :USERNAME";
		List appUsers = factory.find(hqlString, new String[] {"ACTIVE", "USERNAME"}, new Object[] {Boolean.TRUE, username});
		return AppUserShortVoAssembler.createAppUserShortVoCollectionFromAppUser(appUsers);
	}	
}
