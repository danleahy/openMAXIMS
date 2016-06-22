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

package ims.core.vo.beans;

public class HealthyLodgerVoBean extends ims.vo.ValueObjectBean
{
	public HealthyLodgerVoBean()
	{
	}
	public HealthyLodgerVoBean(ims.core.vo.HealthyLodgerVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName() == null ? null : (ims.core.vo.beans.PersonNameBean)vo.getName().getBean();
		this.relationshiptopatient = vo.getRelationshipToPatient() == null ? null : (ims.vo.LookupInstanceBean)vo.getRelationshipToPatient().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.HealthyLodgerVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName() == null ? null : (ims.core.vo.beans.PersonNameBean)vo.getName().getBean(map);
		this.relationshiptopatient = vo.getRelationshipToPatient() == null ? null : (ims.vo.LookupInstanceBean)vo.getRelationshipToPatient().getBean();
	}

	public ims.core.vo.HealthyLodgerVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.HealthyLodgerVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.HealthyLodgerVo vo = null;
		if(map != null)
			vo = (ims.core.vo.HealthyLodgerVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.HealthyLodgerVo();
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
	public ims.core.vo.beans.PersonNameBean getName()
	{
		return this.name;
	}
	public void setName(ims.core.vo.beans.PersonNameBean value)
	{
		this.name = value;
	}
	public ims.vo.LookupInstanceBean getRelationshipToPatient()
	{
		return this.relationshiptopatient;
	}
	public void setRelationshipToPatient(ims.vo.LookupInstanceBean value)
	{
		this.relationshiptopatient = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PersonNameBean name;
	private ims.vo.LookupInstanceBean relationshiptopatient;
}
