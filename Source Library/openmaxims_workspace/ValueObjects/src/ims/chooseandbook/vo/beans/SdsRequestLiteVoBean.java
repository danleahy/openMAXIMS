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

package ims.chooseandbook.vo.beans;

public class SdsRequestLiteVoBean extends ims.vo.ValueObjectBean
{
	public SdsRequestLiteVoBean()
	{
	}
	public SdsRequestLiteVoBean(ims.chooseandbook.vo.SdsRequestLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.datetimerequested = vo.getDateTimeRequested() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeRequested().getBean();
		this.comments = vo.getComments();
		this.appointment = vo.getAppointment();
		this.datetimelastchecked = vo.getDateTimeLastChecked() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeLastChecked().getBean();
		this.active = vo.getActive();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.chooseandbook.vo.SdsRequestLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.datetimerequested = vo.getDateTimeRequested() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeRequested().getBean();
		this.comments = vo.getComments();
		this.appointment = vo.getAppointment();
		this.datetimelastchecked = vo.getDateTimeLastChecked() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeLastChecked().getBean();
		this.active = vo.getActive();
	}

	public ims.chooseandbook.vo.SdsRequestLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.chooseandbook.vo.SdsRequestLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.chooseandbook.vo.SdsRequestLiteVo vo = null;
		if(map != null)
			vo = (ims.chooseandbook.vo.SdsRequestLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.chooseandbook.vo.SdsRequestLiteVo();
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
	public ims.framework.utils.beans.DateTimeBean getDateTimeRequested()
	{
		return this.datetimerequested;
	}
	public void setDateTimeRequested(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datetimerequested = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public Integer getAppointment()
	{
		return this.appointment;
	}
	public void setAppointment(Integer value)
	{
		this.appointment = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateTimeLastChecked()
	{
		return this.datetimelastchecked;
	}
	public void setDateTimeLastChecked(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datetimelastchecked = value;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.active = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean datetimerequested;
	private String comments;
	private Integer appointment;
	private ims.framework.utils.beans.DateTimeBean datetimelastchecked;
	private Boolean active;
}
