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

public class MergeRequestVoBean extends ims.vo.ValueObjectBean
{
	public MergeRequestVoBean()
	{
	}
	public MergeRequestVoBean(ims.core.vo.MergeRequestVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.sourcepatid = vo.getSourcePatId();
		this.destinationpatid = vo.getDestinationPatId();
		this.requestedby = vo.getRequestedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getRequestedBy().getBean();
		this.status = vo.getStatus();
		this.comment = vo.getComment();
		this.sysinfo = vo.getSysinfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysinfo().getBean();
		this.mergeidentifiers = vo.getMergeIdentifiers();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.MergeRequestVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.sourcepatid = vo.getSourcePatId();
		this.destinationpatid = vo.getDestinationPatId();
		this.requestedby = vo.getRequestedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getRequestedBy().getBean(map);
		this.status = vo.getStatus();
		this.comment = vo.getComment();
		this.sysinfo = vo.getSysinfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysinfo().getBean();
		this.mergeidentifiers = vo.getMergeIdentifiers();
	}

	public ims.core.vo.MergeRequestVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.MergeRequestVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.MergeRequestVo vo = null;
		if(map != null)
			vo = (ims.core.vo.MergeRequestVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.MergeRequestVo();
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
	public Integer getSourcePatId()
	{
		return this.sourcepatid;
	}
	public void setSourcePatId(Integer value)
	{
		this.sourcepatid = value;
	}
	public Integer getDestinationPatId()
	{
		return this.destinationpatid;
	}
	public void setDestinationPatId(Integer value)
	{
		this.destinationpatid = value;
	}
	public ims.core.vo.beans.MemberOfStaffShortVoBean getRequestedBy()
	{
		return this.requestedby;
	}
	public void setRequestedBy(ims.core.vo.beans.MemberOfStaffShortVoBean value)
	{
		this.requestedby = value;
	}
	public Boolean getStatus()
	{
		return this.status;
	}
	public void setStatus(Boolean value)
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
	public ims.vo.SysInfoBean getSysinfo()
	{
		return this.sysinfo;
	}
	public void setSysinfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public Boolean getMergeIdentifiers()
	{
		return this.mergeidentifiers;
	}
	public void setMergeIdentifiers(Boolean value)
	{
		this.mergeidentifiers = value;
	}

	private Integer id;
	private int version;
	private Integer sourcepatid;
	private Integer destinationpatid;
	private ims.core.vo.beans.MemberOfStaffShortVoBean requestedby;
	private Boolean status;
	private String comment;
	private ims.vo.SysInfoBean sysinfo;
	private Boolean mergeidentifiers;
}
