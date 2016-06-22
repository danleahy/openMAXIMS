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

public class WardBayClosingDetailsVoBean extends ims.vo.ValueObjectBean
{
	public WardBayClosingDetailsVoBean()
	{
	}
	public WardBayClosingDetailsVoBean(ims.core.vo.WardBayClosingDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.closedby = vo.getClosedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getClosedBy().getBean();
		this.closuredate = vo.getClosureDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getClosureDate().getBean();
		this.reasonforclosure = vo.getReasonForClosure() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonForClosure().getBean();
		this.estimatedreopeningdate = vo.getEstimatedReopeningDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEstimatedReopeningDate().getBean();
		this.reopenreason = vo.getReopenReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getReopenReason().getBean();
		this.reopendate = vo.getReopenDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReopenDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.WardBayClosingDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.closedby = vo.getClosedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getClosedBy().getBean(map);
		this.closuredate = vo.getClosureDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getClosureDate().getBean();
		this.reasonforclosure = vo.getReasonForClosure() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonForClosure().getBean();
		this.estimatedreopeningdate = vo.getEstimatedReopeningDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEstimatedReopeningDate().getBean();
		this.reopenreason = vo.getReopenReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getReopenReason().getBean();
		this.reopendate = vo.getReopenDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReopenDate().getBean();
	}

	public ims.core.vo.WardBayClosingDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.WardBayClosingDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.WardBayClosingDetailsVo vo = null;
		if(map != null)
			vo = (ims.core.vo.WardBayClosingDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.WardBayClosingDetailsVo();
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
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getClosedBy()
	{
		return this.closedby;
	}
	public void setClosedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.closedby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getClosureDate()
	{
		return this.closuredate;
	}
	public void setClosureDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.closuredate = value;
	}
	public ims.vo.LookupInstanceBean getReasonForClosure()
	{
		return this.reasonforclosure;
	}
	public void setReasonForClosure(ims.vo.LookupInstanceBean value)
	{
		this.reasonforclosure = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEstimatedReopeningDate()
	{
		return this.estimatedreopeningdate;
	}
	public void setEstimatedReopeningDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.estimatedreopeningdate = value;
	}
	public ims.vo.LookupInstanceBean getReopenReason()
	{
		return this.reopenreason;
	}
	public void setReopenReason(ims.vo.LookupInstanceBean value)
	{
		this.reopenreason = value;
	}
	public ims.framework.utils.beans.DateTimeBean getReopenDate()
	{
		return this.reopendate;
	}
	public void setReopenDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.reopendate = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean closedby;
	private ims.framework.utils.beans.DateTimeBean closuredate;
	private ims.vo.LookupInstanceBean reasonforclosure;
	private ims.framework.utils.beans.DateTimeBean estimatedreopeningdate;
	private ims.vo.LookupInstanceBean reopenreason;
	private ims.framework.utils.beans.DateTimeBean reopendate;
}
