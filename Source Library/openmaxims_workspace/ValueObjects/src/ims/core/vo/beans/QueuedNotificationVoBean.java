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

public class QueuedNotificationVoBean extends ims.vo.ValueObjectBean
{
	public QueuedNotificationVoBean()
	{
	}
	public QueuedNotificationVoBean(ims.core.vo.QueuedNotificationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.datetime = vo.getDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTime().getBean();
		this.message = vo.getMessage();
		this.priority = vo.getPriority();
		this.entitytype = vo.getEntityType();
		this.entityid = vo.getEntityId();
		this.source = vo.getSource();
		this.userid = vo.getUserId();
		this.deliverymethod = vo.getDeliveryMethod();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.QueuedNotificationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.datetime = vo.getDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTime().getBean();
		this.message = vo.getMessage();
		this.priority = vo.getPriority();
		this.entitytype = vo.getEntityType();
		this.entityid = vo.getEntityId();
		this.source = vo.getSource();
		this.userid = vo.getUserId();
		this.deliverymethod = vo.getDeliveryMethod();
	}

	public ims.core.vo.QueuedNotificationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.QueuedNotificationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.QueuedNotificationVo vo = null;
		if(map != null)
			vo = (ims.core.vo.QueuedNotificationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.QueuedNotificationVo();
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
	public ims.framework.utils.beans.DateTimeBean getDateTime()
	{
		return this.datetime;
	}
	public void setDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datetime = value;
	}
	public String getMessage()
	{
		return this.message;
	}
	public void setMessage(String value)
	{
		this.message = value;
	}
	public Integer getPriority()
	{
		return this.priority;
	}
	public void setPriority(Integer value)
	{
		this.priority = value;
	}
	public String getEntityType()
	{
		return this.entitytype;
	}
	public void setEntityType(String value)
	{
		this.entitytype = value;
	}
	public Integer getEntityId()
	{
		return this.entityid;
	}
	public void setEntityId(Integer value)
	{
		this.entityid = value;
	}
	public String getSource()
	{
		return this.source;
	}
	public void setSource(String value)
	{
		this.source = value;
	}
	public Integer getUserId()
	{
		return this.userid;
	}
	public void setUserId(Integer value)
	{
		this.userid = value;
	}
	public Integer getDeliveryMethod()
	{
		return this.deliverymethod;
	}
	public void setDeliveryMethod(Integer value)
	{
		this.deliverymethod = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean datetime;
	private String message;
	private Integer priority;
	private String entitytype;
	private Integer entityid;
	private String source;
	private Integer userid;
	private Integer deliverymethod;
}
