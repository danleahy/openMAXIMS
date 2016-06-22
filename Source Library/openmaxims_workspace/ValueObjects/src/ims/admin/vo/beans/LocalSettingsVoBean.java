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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.admin.vo.beans;

public class LocalSettingsVoBean extends ims.vo.ValueObjectBean
{
	public LocalSettingsVoBean()
	{
	}
	public LocalSettingsVoBean(ims.admin.vo.LocalSettingsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.instanceidentifier = vo.getInstanceIdentifier();
		this.settingtype = vo.getSettingType();
		this.values = vo.getValues();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.LocalSettingsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.instanceidentifier = vo.getInstanceIdentifier();
		this.settingtype = vo.getSettingType();
		this.values = vo.getValues();
	}

	public ims.admin.vo.LocalSettingsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.LocalSettingsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.LocalSettingsVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.LocalSettingsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.LocalSettingsVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public String getInstanceIdentifier()
	{
		return this.instanceidentifier;
	}
	public void setInstanceIdentifier(String value)
	{
		this.instanceidentifier = value;
	}
	public Integer getSettingType()
	{
		return this.settingtype;
	}
	public void setSettingType(Integer value)
	{
		this.settingtype = value;
	}
	public String getValues()
	{
		return this.values;
	}
	public void setValues(String value)
	{
		this.values = value;
	}

	private Integer id;
	private int version;
	private String instanceidentifier;
	private Integer settingtype;
	private String values;
}
