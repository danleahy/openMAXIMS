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

package ims.therapies.vo.beans;

public class RehabilitationActivityVoBean extends ims.vo.ValueObjectBean
{
	public RehabilitationActivityVoBean()
	{
	}
	public RehabilitationActivityVoBean(ims.therapies.vo.RehabilitationActivityVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.location = vo.getLocation() == null ? null : (ims.vo.LookupInstanceBean)vo.getLocation().getBean();
		this.purpose = vo.getPurpose() == null ? null : (ims.vo.LookupInstanceBean)vo.getPurpose().getBean();
		this.independencelevel = vo.getIndependenceLevel() == null ? null : (ims.vo.LookupInstanceBean)vo.getIndependenceLevel().getBean();
		this.activitytype = vo.getActivityType() == null ? null : (ims.vo.LookupInstanceBean)vo.getActivityType().getBean();
		this.activitycategory = vo.getActivityCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getActivityCategory().getBean();
		this.activitygroup = vo.getActivityGroup() == null ? null : (ims.vo.LookupInstanceBean)vo.getActivityGroup().getBean();
		this.activity = vo.getActivity() == null ? null : (ims.vo.LookupInstanceBean)vo.getActivity().getBean();
		this.technique = vo.getTechnique() == null ? null : vo.getTechnique().getBeanCollection();
		this.equipment = vo.getEquipment() == null ? null : vo.getEquipment().getBeanCollection();
		this.envadaptations = vo.getEnvAdaptations() == null ? null : vo.getEnvAdaptations().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.RehabilitationActivityVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.location = vo.getLocation() == null ? null : (ims.vo.LookupInstanceBean)vo.getLocation().getBean();
		this.purpose = vo.getPurpose() == null ? null : (ims.vo.LookupInstanceBean)vo.getPurpose().getBean();
		this.independencelevel = vo.getIndependenceLevel() == null ? null : (ims.vo.LookupInstanceBean)vo.getIndependenceLevel().getBean();
		this.activitytype = vo.getActivityType() == null ? null : (ims.vo.LookupInstanceBean)vo.getActivityType().getBean();
		this.activitycategory = vo.getActivityCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getActivityCategory().getBean();
		this.activitygroup = vo.getActivityGroup() == null ? null : (ims.vo.LookupInstanceBean)vo.getActivityGroup().getBean();
		this.activity = vo.getActivity() == null ? null : (ims.vo.LookupInstanceBean)vo.getActivity().getBean();
		this.technique = vo.getTechnique() == null ? null : vo.getTechnique().getBeanCollection();
		this.equipment = vo.getEquipment() == null ? null : vo.getEquipment().getBeanCollection();
		this.envadaptations = vo.getEnvAdaptations() == null ? null : vo.getEnvAdaptations().getBeanCollection();
	}

	public ims.therapies.vo.RehabilitationActivityVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.RehabilitationActivityVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.RehabilitationActivityVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.RehabilitationActivityVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.RehabilitationActivityVo();
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
	public ims.vo.LookupInstanceBean getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.vo.LookupInstanceBean value)
	{
		this.location = value;
	}
	public ims.vo.LookupInstanceBean getPurpose()
	{
		return this.purpose;
	}
	public void setPurpose(ims.vo.LookupInstanceBean value)
	{
		this.purpose = value;
	}
	public ims.vo.LookupInstanceBean getIndependenceLevel()
	{
		return this.independencelevel;
	}
	public void setIndependenceLevel(ims.vo.LookupInstanceBean value)
	{
		this.independencelevel = value;
	}
	public ims.vo.LookupInstanceBean getActivityType()
	{
		return this.activitytype;
	}
	public void setActivityType(ims.vo.LookupInstanceBean value)
	{
		this.activitytype = value;
	}
	public ims.vo.LookupInstanceBean getActivityCategory()
	{
		return this.activitycategory;
	}
	public void setActivityCategory(ims.vo.LookupInstanceBean value)
	{
		this.activitycategory = value;
	}
	public ims.vo.LookupInstanceBean getActivityGroup()
	{
		return this.activitygroup;
	}
	public void setActivityGroup(ims.vo.LookupInstanceBean value)
	{
		this.activitygroup = value;
	}
	public ims.vo.LookupInstanceBean getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.vo.LookupInstanceBean value)
	{
		this.activity = value;
	}
	public java.util.Collection getTechnique()
	{
		return this.technique;
	}
	public void setTechnique(java.util.Collection value)
	{
		this.technique = value;
	}
	public void addTechnique(java.util.Collection value)
	{
		if(this.technique == null)
			this.technique = new java.util.ArrayList();
		this.technique.add(value);
	}
	public java.util.Collection getEquipment()
	{
		return this.equipment;
	}
	public void setEquipment(java.util.Collection value)
	{
		this.equipment = value;
	}
	public void addEquipment(java.util.Collection value)
	{
		if(this.equipment == null)
			this.equipment = new java.util.ArrayList();
		this.equipment.add(value);
	}
	public java.util.Collection getEnvAdaptations()
	{
		return this.envadaptations;
	}
	public void setEnvAdaptations(java.util.Collection value)
	{
		this.envadaptations = value;
	}
	public void addEnvAdaptations(java.util.Collection value)
	{
		if(this.envadaptations == null)
			this.envadaptations = new java.util.ArrayList();
		this.envadaptations.add(value);
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean location;
	private ims.vo.LookupInstanceBean purpose;
	private ims.vo.LookupInstanceBean independencelevel;
	private ims.vo.LookupInstanceBean activitytype;
	private ims.vo.LookupInstanceBean activitycategory;
	private ims.vo.LookupInstanceBean activitygroup;
	private ims.vo.LookupInstanceBean activity;
	private java.util.Collection technique;
	private java.util.Collection equipment;
	private java.util.Collection envadaptations;
}
