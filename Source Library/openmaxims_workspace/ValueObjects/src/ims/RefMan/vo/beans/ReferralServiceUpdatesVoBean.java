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

package ims.RefMan.vo.beans;

public class ReferralServiceUpdatesVoBean extends ims.vo.ValueObjectBean
{
	public ReferralServiceUpdatesVoBean()
	{
	}
	public ReferralServiceUpdatesVoBean(ims.RefMan.vo.ReferralServiceUpdatesVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean();
		this.recordinguser = vo.getRecordingUser() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getRecordingUser().getBean();
		this.recordingdatetime = vo.getRecordingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRecordingDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.ReferralServiceUpdatesVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean(map);
		this.recordinguser = vo.getRecordingUser() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getRecordingUser().getBean(map);
		this.recordingdatetime = vo.getRecordingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRecordingDateTime().getBean();
	}

	public ims.RefMan.vo.ReferralServiceUpdatesVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.ReferralServiceUpdatesVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.ReferralServiceUpdatesVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.ReferralServiceUpdatesVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.ReferralServiceUpdatesVo();
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
	public ims.core.vo.beans.ServiceLiteVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.service = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getRecordingUser()
	{
		return this.recordinguser;
	}
	public void setRecordingUser(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.recordinguser = value;
	}
	public ims.framework.utils.beans.DateTimeBean getRecordingDateTime()
	{
		return this.recordingdatetime;
	}
	public void setRecordingDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.recordingdatetime = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.ServiceLiteVoBean service;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean recordinguser;
	private ims.framework.utils.beans.DateTimeBean recordingdatetime;
}
