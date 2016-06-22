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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 4968.18547)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.base.impl.BaseConfigFlagsDiffImpl;
import ims.core.vo.ConfigFlagListVoCollection;
import ims.core.vo.domain.ConfigFlagListVoAssembler;
import ims.domain.DomainFactory;

public class ConfigFlagsDiffImpl extends BaseConfigFlagsDiffImpl
{

	private static final long serialVersionUID = 1L;

	public ConfigFlagListVoCollection listSavedConfigFlags()
	{
		String hql = "select cflag from ConfigFlag as cflag order by cflag.name asc";
		DomainFactory factory = getDomainFactory();
		
		return ConfigFlagListVoAssembler.createConfigFlagListVoCollectionFromConfigFlag(factory.find(hql));
	}
	
}
