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

package ims.scheduling.vo.beans;

public class SessionForReferralAppointmentVoBean extends ims.vo.ValueObjectBean
{
	public SessionForReferralAppointmentVoBean()
	{
	}
	public SessionForReferralAppointmentVoBean(ims.scheduling.vo.SessionForReferralAppointmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean();
		this.isfixed = vo.getIsFixed();
		this.sch_profile = vo.getSch_Profile() == null ? null : (ims.scheduling.vo.beans.Sch_ProfileLiteVoBean)vo.getSch_Profile().getBean();
		this.schlocation = vo.getSchLocation() == null ? null : (ims.core.vo.beans.LocationListVoBean)vo.getSchLocation().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.SessionForReferralAppointmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean(map);
		this.isfixed = vo.getIsFixed();
		this.sch_profile = vo.getSch_Profile() == null ? null : (ims.scheduling.vo.beans.Sch_ProfileLiteVoBean)vo.getSch_Profile().getBean(map);
		this.schlocation = vo.getSchLocation() == null ? null : (ims.core.vo.beans.LocationListVoBean)vo.getSchLocation().getBean(map);
	}

	public ims.scheduling.vo.SessionForReferralAppointmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.SessionForReferralAppointmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.SessionForReferralAppointmentVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.SessionForReferralAppointmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.SessionForReferralAppointmentVo();
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
	public ims.core.vo.beans.ServiceLiteVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.service = value;
	}
	public Boolean getIsFixed()
	{
		return this.isfixed;
	}
	public void setIsFixed(Boolean value)
	{
		this.isfixed = value;
	}
	public ims.scheduling.vo.beans.Sch_ProfileLiteVoBean getSch_Profile()
	{
		return this.sch_profile;
	}
	public void setSch_Profile(ims.scheduling.vo.beans.Sch_ProfileLiteVoBean value)
	{
		this.sch_profile = value;
	}
	public ims.core.vo.beans.LocationListVoBean getSchLocation()
	{
		return this.schlocation;
	}
	public void setSchLocation(ims.core.vo.beans.LocationListVoBean value)
	{
		this.schlocation = value;
	}

	private Integer id;
	private int version;
	private String name;
	private ims.core.vo.beans.ServiceLiteVoBean service;
	private Boolean isfixed;
	private ims.scheduling.vo.beans.Sch_ProfileLiteVoBean sch_profile;
	private ims.core.vo.beans.LocationListVoBean schlocation;
}
