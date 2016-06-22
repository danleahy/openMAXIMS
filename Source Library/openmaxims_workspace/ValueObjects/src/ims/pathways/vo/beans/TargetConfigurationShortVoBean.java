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

package ims.pathways.vo.beans;

public class TargetConfigurationShortVoBean extends ims.vo.ValueObjectBean
{
	public TargetConfigurationShortVoBean()
	{
	}
	public TargetConfigurationShortVoBean(ims.pathways.vo.TargetConfigurationShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.description = vo.getDescription();
		this.eventlinktype = vo.getEventLinkType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventLinkType().getBean();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.targetdatecalculation = vo.getTargetDateCalculation() == null ? null : (ims.vo.LookupInstanceBean)vo.getTargetDateCalculation().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.TargetConfigurationShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.description = vo.getDescription();
		this.eventlinktype = vo.getEventLinkType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventLinkType().getBean();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.targetdatecalculation = vo.getTargetDateCalculation() == null ? null : (ims.vo.LookupInstanceBean)vo.getTargetDateCalculation().getBean();
	}

	public ims.pathways.vo.TargetConfigurationShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.pathways.vo.TargetConfigurationShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.TargetConfigurationShortVo vo = null;
		if(map != null)
			vo = (ims.pathways.vo.TargetConfigurationShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.pathways.vo.TargetConfigurationShortVo();
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
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String value)
	{
		this.description = value;
	}
	public ims.vo.LookupInstanceBean getEventLinkType()
	{
		return this.eventlinktype;
	}
	public void setEventLinkType(ims.vo.LookupInstanceBean value)
	{
		this.eventlinktype = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.vo.LookupInstanceBean getTargetDateCalculation()
	{
		return this.targetdatecalculation;
	}
	public void setTargetDateCalculation(ims.vo.LookupInstanceBean value)
	{
		this.targetdatecalculation = value;
	}

	private Integer id;
	private int version;
	private String name;
	private String description;
	private ims.vo.LookupInstanceBean eventlinktype;
	private ims.vo.LookupInstanceBean status;
	private ims.vo.SysInfoBean sysinfo;
	private ims.vo.LookupInstanceBean targetdatecalculation;
}
