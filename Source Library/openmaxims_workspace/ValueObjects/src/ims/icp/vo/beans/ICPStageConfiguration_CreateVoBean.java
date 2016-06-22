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

package ims.icp.vo.beans;

public class ICPStageConfiguration_CreateVoBean extends ims.vo.ValueObjectBean
{
	public ICPStageConfiguration_CreateVoBean()
	{
	}
	public ICPStageConfiguration_CreateVoBean(ims.icp.vo.ICPStageConfiguration_CreateVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.phases = vo.getPhases() == null ? null : vo.getPhases().getBeanCollection();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.isactivatedoninitiation = vo.getIsActivatedOnInitiation();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.ICPStageConfiguration_CreateVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.phases = vo.getPhases() == null ? null : vo.getPhases().getBeanCollection();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.isactivatedoninitiation = vo.getIsActivatedOnInitiation();
	}

	public ims.icp.vo.ICPStageConfiguration_CreateVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.icp.vo.ICPStageConfiguration_CreateVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.ICPStageConfiguration_CreateVo vo = null;
		if(map != null)
			vo = (ims.icp.vo.ICPStageConfiguration_CreateVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.icp.vo.ICPStageConfiguration_CreateVo();
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
	public ims.icp.vo.beans.ICPPhaseConfiguration_CreateVoBean[] getPhases()
	{
		return this.phases;
	}
	public void setPhases(ims.icp.vo.beans.ICPPhaseConfiguration_CreateVoBean[] value)
	{
		this.phases = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public Boolean getIsActivatedOnInitiation()
	{
		return this.isactivatedoninitiation;
	}
	public void setIsActivatedOnInitiation(Boolean value)
	{
		this.isactivatedoninitiation = value;
	}

	private Integer id;
	private int version;
	private String name;
	private ims.icp.vo.beans.ICPPhaseConfiguration_CreateVoBean[] phases;
	private ims.vo.LookupInstanceBean status;
	private Boolean isactivatedoninitiation;
}
