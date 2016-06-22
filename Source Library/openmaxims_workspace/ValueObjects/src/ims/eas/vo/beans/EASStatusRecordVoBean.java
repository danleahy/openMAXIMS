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

package ims.eas.vo.beans;

public class EASStatusRecordVoBean extends ims.vo.ValueObjectBean
{
	public EASStatusRecordVoBean()
	{
	}
	public EASStatusRecordVoBean(ims.eas.vo.EASStatusRecordVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.comment = vo.getComment();
		this.recordingmos = vo.getRecordingMos() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getRecordingMos().getBean();
		this.recordingdatetime = vo.getRecordingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRecordingDateTime().getBean();
		this.tpcreated = vo.getTPCreated();
		this.actionrequired = vo.getActionRequired();
		this.removedstat = vo.getRemovedStat();
		this.removalreason = vo.getRemovalReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getRemovalReason().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.eas.vo.EASStatusRecordVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.comment = vo.getComment();
		this.recordingmos = vo.getRecordingMos() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getRecordingMos().getBean(map);
		this.recordingdatetime = vo.getRecordingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRecordingDateTime().getBean();
		this.tpcreated = vo.getTPCreated();
		this.actionrequired = vo.getActionRequired();
		this.removedstat = vo.getRemovedStat();
		this.removalreason = vo.getRemovalReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getRemovalReason().getBean();
	}

	public ims.eas.vo.EASStatusRecordVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.eas.vo.EASStatusRecordVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.eas.vo.EASStatusRecordVo vo = null;
		if(map != null)
			vo = (ims.eas.vo.EASStatusRecordVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.eas.vo.EASStatusRecordVo();
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
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public String getComment()
	{
		return this.comment;
	}
	public void setComment(String value)
	{
		this.comment = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getRecordingMos()
	{
		return this.recordingmos;
	}
	public void setRecordingMos(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.recordingmos = value;
	}
	public ims.framework.utils.beans.DateTimeBean getRecordingDateTime()
	{
		return this.recordingdatetime;
	}
	public void setRecordingDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.recordingdatetime = value;
	}
	public Boolean getTPCreated()
	{
		return this.tpcreated;
	}
	public void setTPCreated(Boolean value)
	{
		this.tpcreated = value;
	}
	public Boolean getActionRequired()
	{
		return this.actionrequired;
	}
	public void setActionRequired(Boolean value)
	{
		this.actionrequired = value;
	}
	public Boolean getRemovedStat()
	{
		return this.removedstat;
	}
	public void setRemovedStat(Boolean value)
	{
		this.removedstat = value;
	}
	public ims.vo.LookupInstanceBean getRemovalReason()
	{
		return this.removalreason;
	}
	public void setRemovalReason(ims.vo.LookupInstanceBean value)
	{
		this.removalreason = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean status;
	private String comment;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean recordingmos;
	private ims.framework.utils.beans.DateTimeBean recordingdatetime;
	private Boolean tpcreated;
	private Boolean actionrequired;
	private Boolean removedstat;
	private ims.vo.LookupInstanceBean removalreason;
}
