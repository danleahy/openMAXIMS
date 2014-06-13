//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.admin.vo.beans;

public class ServiceVoLiteVoBean extends ims.vo.ValueObjectBean
{
	public ServiceVoLiteVoBean()
	{
	}
	public ServiceVoLiteVoBean(ims.admin.vo.ServiceVoLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.servicename = vo.getServiceName();
		this.servicedescription = vo.getServiceDescription();
		this.isactive = vo.getIsActive();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.ServiceVoLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.servicename = vo.getServiceName();
		this.servicedescription = vo.getServiceDescription();
		this.isactive = vo.getIsActive();
	}

	public ims.admin.vo.ServiceVoLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.ServiceVoLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.ServiceVoLiteVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.ServiceVoLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.ServiceVoLiteVo();
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
	public String getServiceName()
	{
		return this.servicename;
	}
	public void setServiceName(String value)
	{
		this.servicename = value;
	}
	public String getServiceDescription()
	{
		return this.servicedescription;
	}
	public void setServiceDescription(String value)
	{
		this.servicedescription = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}

	private Integer id;
	private int version;
	private String servicename;
	private String servicedescription;
	private Boolean isactive;
}