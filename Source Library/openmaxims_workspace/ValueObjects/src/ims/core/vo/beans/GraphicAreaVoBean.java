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

public class GraphicAreaVoBean extends ims.vo.ValueObjectBean
{
	public GraphicAreaVoBean()
	{
	}
	public GraphicAreaVoBean(ims.core.vo.GraphicAreaVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.areaid = vo.getAreaID();
		this.areaname = vo.getAreaName();
		this.areavectors = vo.getAreaVectors();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.GraphicAreaVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.areaid = vo.getAreaID();
		this.areaname = vo.getAreaName();
		this.areavectors = vo.getAreaVectors();
	}

	public ims.core.vo.GraphicAreaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.GraphicAreaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.GraphicAreaVo vo = null;
		if(map != null)
			vo = (ims.core.vo.GraphicAreaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.GraphicAreaVo();
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
	public Integer getAreaID()
	{
		return this.areaid;
	}
	public void setAreaID(Integer value)
	{
		this.areaid = value;
	}
	public String getAreaName()
	{
		return this.areaname;
	}
	public void setAreaName(String value)
	{
		this.areaname = value;
	}
	public String getAreaVectors()
	{
		return this.areavectors;
	}
	public void setAreaVectors(String value)
	{
		this.areavectors = value;
	}

	private Integer id;
	private int version;
	private Integer areaid;
	private String areaname;
	private String areavectors;
}
