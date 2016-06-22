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

public class EventLiteVoBean extends ims.vo.ValueObjectBean
{
	public EventLiteVoBean()
	{
	}
	public EventLiteVoBean(ims.pathways.vo.EventLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.description = vo.getDescription();
		this.icon = vo.getIcon() == null ? null : (ims.admin.vo.beans.AppImageVoBean)vo.getIcon().getBean();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.actioningroles = vo.getActioningRoles() == null ? null : vo.getActioningRoles().getBeanCollection();
		this.patientdiaryimpact = vo.getPatientDiaryImpact();
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
		this.startsclock = vo.getStartsClock();
		this.stopsclock = vo.getStopsClock();
		this.endspathway = vo.getEndsPathway();
		this.ismanualscheduledevent = vo.getIsManualScheduledEvent();
		this.cancellationtype = vo.getCancellationType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancellationType().getBean();
		this.cancellationreason = vo.getCancellationReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancellationReason().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.EventLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.description = vo.getDescription();
		this.icon = vo.getIcon() == null ? null : (ims.admin.vo.beans.AppImageVoBean)vo.getIcon().getBean(map);
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.actioningroles = vo.getActioningRoles() == null ? null : vo.getActioningRoles().getBeanCollection();
		this.patientdiaryimpact = vo.getPatientDiaryImpact();
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
		this.startsclock = vo.getStartsClock();
		this.stopsclock = vo.getStopsClock();
		this.endspathway = vo.getEndsPathway();
		this.ismanualscheduledevent = vo.getIsManualScheduledEvent();
		this.cancellationtype = vo.getCancellationType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancellationType().getBean();
		this.cancellationreason = vo.getCancellationReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancellationReason().getBean();
	}

	public ims.pathways.vo.EventLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.pathways.vo.EventLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.EventLiteVo vo = null;
		if(map != null)
			vo = (ims.pathways.vo.EventLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.pathways.vo.EventLiteVo();
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
	public ims.admin.vo.beans.AppImageVoBean getIcon()
	{
		return this.icon;
	}
	public void setIcon(ims.admin.vo.beans.AppImageVoBean value)
	{
		this.icon = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.admin.vo.beans.AppRoleShortVoBean[] getActioningRoles()
	{
		return this.actioningroles;
	}
	public void setActioningRoles(ims.admin.vo.beans.AppRoleShortVoBean[] value)
	{
		this.actioningroles = value;
	}
	public Boolean getPatientDiaryImpact()
	{
		return this.patientdiaryimpact;
	}
	public void setPatientDiaryImpact(Boolean value)
	{
		this.patientdiaryimpact = value;
	}
	public ims.vo.LookupInstanceBean getEventType()
	{
		return this.eventtype;
	}
	public void setEventType(ims.vo.LookupInstanceBean value)
	{
		this.eventtype = value;
	}
	public Boolean getStartsClock()
	{
		return this.startsclock;
	}
	public void setStartsClock(Boolean value)
	{
		this.startsclock = value;
	}
	public Boolean getStopsClock()
	{
		return this.stopsclock;
	}
	public void setStopsClock(Boolean value)
	{
		this.stopsclock = value;
	}
	public Boolean getEndsPathway()
	{
		return this.endspathway;
	}
	public void setEndsPathway(Boolean value)
	{
		this.endspathway = value;
	}
	public Boolean getIsManualScheduledEvent()
	{
		return this.ismanualscheduledevent;
	}
	public void setIsManualScheduledEvent(Boolean value)
	{
		this.ismanualscheduledevent = value;
	}
	public ims.vo.LookupInstanceBean getCancellationType()
	{
		return this.cancellationtype;
	}
	public void setCancellationType(ims.vo.LookupInstanceBean value)
	{
		this.cancellationtype = value;
	}
	public ims.vo.LookupInstanceBean getCancellationReason()
	{
		return this.cancellationreason;
	}
	public void setCancellationReason(ims.vo.LookupInstanceBean value)
	{
		this.cancellationreason = value;
	}

	private Integer id;
	private int version;
	private String name;
	private String description;
	private ims.admin.vo.beans.AppImageVoBean icon;
	private ims.vo.LookupInstanceBean status;
	private ims.admin.vo.beans.AppRoleShortVoBean[] actioningroles;
	private Boolean patientdiaryimpact;
	private ims.vo.LookupInstanceBean eventtype;
	private Boolean startsclock;
	private Boolean stopsclock;
	private Boolean endspathway;
	private Boolean ismanualscheduledevent;
	private ims.vo.LookupInstanceBean cancellationtype;
	private ims.vo.LookupInstanceBean cancellationreason;
}
