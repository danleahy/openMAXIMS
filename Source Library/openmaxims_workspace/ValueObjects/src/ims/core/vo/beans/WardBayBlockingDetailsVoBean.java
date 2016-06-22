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

public class WardBayBlockingDetailsVoBean extends ims.vo.ValueObjectBean
{
	public WardBayBlockingDetailsVoBean()
	{
	}
	public WardBayBlockingDetailsVoBean(ims.core.vo.WardBayBlockingDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.blockedby = vo.getBlockedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getBlockedBy().getBean();
		this.blockeddate = vo.getBlockedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getBlockedDate().getBean();
		this.reasonforblocking = vo.getReasonForBlocking() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonForBlocking().getBean();
		this.estimatedreopeningdate = vo.getEstimatedReopeningDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEstimatedReopeningDate().getBean();
		this.reopendate = vo.getReopenDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReopenDate().getBean();
		this.reopenreason = vo.getReopenReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getReopenReason().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.WardBayBlockingDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.blockedby = vo.getBlockedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getBlockedBy().getBean(map);
		this.blockeddate = vo.getBlockedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getBlockedDate().getBean();
		this.reasonforblocking = vo.getReasonForBlocking() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonForBlocking().getBean();
		this.estimatedreopeningdate = vo.getEstimatedReopeningDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEstimatedReopeningDate().getBean();
		this.reopendate = vo.getReopenDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReopenDate().getBean();
		this.reopenreason = vo.getReopenReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getReopenReason().getBean();
	}

	public ims.core.vo.WardBayBlockingDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.WardBayBlockingDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.WardBayBlockingDetailsVo vo = null;
		if(map != null)
			vo = (ims.core.vo.WardBayBlockingDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.WardBayBlockingDetailsVo();
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
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getBlockedBy()
	{
		return this.blockedby;
	}
	public void setBlockedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.blockedby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getBlockedDate()
	{
		return this.blockeddate;
	}
	public void setBlockedDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.blockeddate = value;
	}
	public ims.vo.LookupInstanceBean getReasonForBlocking()
	{
		return this.reasonforblocking;
	}
	public void setReasonForBlocking(ims.vo.LookupInstanceBean value)
	{
		this.reasonforblocking = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEstimatedReopeningDate()
	{
		return this.estimatedreopeningdate;
	}
	public void setEstimatedReopeningDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.estimatedreopeningdate = value;
	}
	public ims.framework.utils.beans.DateTimeBean getReopenDate()
	{
		return this.reopendate;
	}
	public void setReopenDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.reopendate = value;
	}
	public ims.vo.LookupInstanceBean getReopenReason()
	{
		return this.reopenreason;
	}
	public void setReopenReason(ims.vo.LookupInstanceBean value)
	{
		this.reopenreason = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean blockedby;
	private ims.framework.utils.beans.DateTimeBean blockeddate;
	private ims.vo.LookupInstanceBean reasonforblocking;
	private ims.framework.utils.beans.DateTimeBean estimatedreopeningdate;
	private ims.framework.utils.beans.DateTimeBean reopendate;
	private ims.vo.LookupInstanceBean reopenreason;
}
