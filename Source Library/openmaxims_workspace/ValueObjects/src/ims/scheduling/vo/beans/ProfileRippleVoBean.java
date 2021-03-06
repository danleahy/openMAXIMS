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

public class ProfileRippleVoBean extends ims.vo.ValueObjectBean
{
	public ProfileRippleVoBean()
	{
	}
	public ProfileRippleVoBean(ims.scheduling.vo.ProfileRippleVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.datetimerequested = vo.getDateTimeRequested() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeRequested().getBean();
		this.effectivefromdate = vo.getEffectiveFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEffectiveFromDate().getBean();
		this.starttime = vo.getStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getStartTime().getBean();
		this.endtime = vo.getEndTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getEndTime().getBean();
		this.listowners = vo.getListOwners() == null ? null : vo.getListOwners().getBeanCollection();
		this.inactiveslots = vo.getInactiveSlots() == null ? null : vo.getInactiveSlots().getBeanCollection();
		this.newslots = vo.getNewSlots() == null ? null : vo.getNewSlots().getBeanCollection();
		this.datetimeactivated = vo.getDateTimeActivated() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeActivated().getBean();
		this.numberofsessions = vo.getNumberOfSessions();
		this.profile = vo.getProfile() == null ? null : (ims.scheduling.vo.beans.ProfileForProfileRippleVoBean)vo.getProfile().getBean();
		this.active = vo.getActive();
		this.details = vo.getDetails();
		this.cancellationreason = vo.getCancellationReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancellationReason().getBean();
		this.name = vo.getName();
		this.description = vo.getDescription();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.ProfileRippleVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.datetimerequested = vo.getDateTimeRequested() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeRequested().getBean();
		this.effectivefromdate = vo.getEffectiveFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEffectiveFromDate().getBean();
		this.starttime = vo.getStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getStartTime().getBean();
		this.endtime = vo.getEndTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getEndTime().getBean();
		this.listowners = vo.getListOwners() == null ? null : vo.getListOwners().getBeanCollection();
		this.inactiveslots = vo.getInactiveSlots() == null ? null : vo.getInactiveSlots().getBeanCollection();
		this.newslots = vo.getNewSlots() == null ? null : vo.getNewSlots().getBeanCollection();
		this.datetimeactivated = vo.getDateTimeActivated() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeActivated().getBean();
		this.numberofsessions = vo.getNumberOfSessions();
		this.profile = vo.getProfile() == null ? null : (ims.scheduling.vo.beans.ProfileForProfileRippleVoBean)vo.getProfile().getBean(map);
		this.active = vo.getActive();
		this.details = vo.getDetails();
		this.cancellationreason = vo.getCancellationReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancellationReason().getBean();
		this.name = vo.getName();
		this.description = vo.getDescription();
	}

	public ims.scheduling.vo.ProfileRippleVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.ProfileRippleVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.ProfileRippleVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.ProfileRippleVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.ProfileRippleVo();
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
	public ims.framework.utils.beans.DateBean getEffectiveFromDate()
	{
		return this.effectivefromdate;
	}
	public void setEffectiveFromDate(ims.framework.utils.beans.DateBean value)
	{
		this.effectivefromdate = value;
	}
	public ims.framework.utils.beans.TimeBean getStartTime()
	{
		return this.starttime;
	}
	public void setStartTime(ims.framework.utils.beans.TimeBean value)
	{
		this.starttime = value;
	}
	public ims.framework.utils.beans.TimeBean getEndTime()
	{
		return this.endtime;
	}
	public void setEndTime(ims.framework.utils.beans.TimeBean value)
	{
		this.endtime = value;
	}
	public ims.scheduling.vo.beans.Profile_ListOwnerVoBean[] getListOwners()
	{
		return this.listowners;
	}
	public void setListOwners(ims.scheduling.vo.beans.Profile_ListOwnerVoBean[] value)
	{
		this.listowners = value;
	}
	public ims.scheduling.vo.beans.Profile_SlotGenericVoBean[] getInactiveSlots()
	{
		return this.inactiveslots;
	}
	public void setInactiveSlots(ims.scheduling.vo.beans.Profile_SlotGenericVoBean[] value)
	{
		this.inactiveslots = value;
	}
	public ims.scheduling.vo.beans.Profile_SlotGenericVoBean[] getNewSlots()
	{
		return this.newslots;
	}
	public void setNewSlots(ims.scheduling.vo.beans.Profile_SlotGenericVoBean[] value)
	{
		this.newslots = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateTimeActivated()
	{
		return this.datetimeactivated;
	}
	public void setDateTimeActivated(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datetimeactivated = value;
	}
	public Integer getNumberOfSessions()
	{
		return this.numberofsessions;
	}
	public void setNumberOfSessions(Integer value)
	{
		this.numberofsessions = value;
	}
	public ims.scheduling.vo.beans.ProfileForProfileRippleVoBean getProfile()
	{
		return this.profile;
	}
	public void setProfile(ims.scheduling.vo.beans.ProfileForProfileRippleVoBean value)
	{
		this.profile = value;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.active = value;
	}
	public String getDetails()
	{
		return this.details;
	}
	public void setDetails(String value)
	{
		this.details = value;
	}
	public ims.vo.LookupInstanceBean getCancellationReason()
	{
		return this.cancellationreason;
	}
	public void setCancellationReason(ims.vo.LookupInstanceBean value)
	{
		this.cancellationreason = value;
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

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean datetimerequested;
	private ims.framework.utils.beans.DateBean effectivefromdate;
	private ims.framework.utils.beans.TimeBean starttime;
	private ims.framework.utils.beans.TimeBean endtime;
	private ims.scheduling.vo.beans.Profile_ListOwnerVoBean[] listowners;
	private ims.scheduling.vo.beans.Profile_SlotGenericVoBean[] inactiveslots;
	private ims.scheduling.vo.beans.Profile_SlotGenericVoBean[] newslots;
	private ims.framework.utils.beans.DateTimeBean datetimeactivated;
	private Integer numberofsessions;
	private ims.scheduling.vo.beans.ProfileForProfileRippleVoBean profile;
	private Boolean active;
	private String details;
	private ims.vo.LookupInstanceBean cancellationreason;
	private String name;
	private String description;
}
