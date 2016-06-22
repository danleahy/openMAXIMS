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

package ims.correspondence.vo.beans;

public class GpToLocationPracticeVoBean extends ims.vo.ValueObjectBean
{
	public GpToLocationPracticeVoBean()
	{
	}
	public GpToLocationPracticeVoBean(ims.correspondence.vo.GpToLocationPracticeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.gp = vo.getGp() == null ? null : (ims.core.vo.beans.GpShortVoBean)vo.getGp().getBean();
		this.isprimarypractice = vo.getIsPrimaryPractice();
		this.gpcode = vo.getGpCode();
		this.practice = vo.getPractice() == null ? null : (ims.core.vo.beans.GpPracticeLiteVoBean)vo.getPractice().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.correspondence.vo.GpToLocationPracticeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.gp = vo.getGp() == null ? null : (ims.core.vo.beans.GpShortVoBean)vo.getGp().getBean(map);
		this.isprimarypractice = vo.getIsPrimaryPractice();
		this.gpcode = vo.getGpCode();
		this.practice = vo.getPractice() == null ? null : (ims.core.vo.beans.GpPracticeLiteVoBean)vo.getPractice().getBean(map);
	}

	public ims.correspondence.vo.GpToLocationPracticeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.correspondence.vo.GpToLocationPracticeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.correspondence.vo.GpToLocationPracticeVo vo = null;
		if(map != null)
			vo = (ims.correspondence.vo.GpToLocationPracticeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.correspondence.vo.GpToLocationPracticeVo();
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
	public ims.core.vo.beans.GpShortVoBean getGp()
	{
		return this.gp;
	}
	public void setGp(ims.core.vo.beans.GpShortVoBean value)
	{
		this.gp = value;
	}
	public Boolean getIsPrimaryPractice()
	{
		return this.isprimarypractice;
	}
	public void setIsPrimaryPractice(Boolean value)
	{
		this.isprimarypractice = value;
	}
	public String getGpCode()
	{
		return this.gpcode;
	}
	public void setGpCode(String value)
	{
		this.gpcode = value;
	}
	public ims.core.vo.beans.GpPracticeLiteVoBean getPractice()
	{
		return this.practice;
	}
	public void setPractice(ims.core.vo.beans.GpPracticeLiteVoBean value)
	{
		this.practice = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.GpShortVoBean gp;
	private Boolean isprimarypractice;
	private String gpcode;
	private ims.core.vo.beans.GpPracticeLiteVoBean practice;
}
