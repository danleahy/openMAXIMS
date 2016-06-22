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

package ims.naes.vo.beans;

public class ActionDetailVoBean extends ims.vo.ValueObjectBean
{
	public ActionDetailVoBean()
	{
	}
	public ActionDetailVoBean(ims.naes.vo.ActionDetailVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.action = vo.getAction() == null ? null : (ims.vo.LookupInstanceBean)vo.getAction().getBean();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.naes.vo.beans.ActionDetailStatusVoBean)vo.getCurrentStatus().getBean();
		this.responsibletechnician = vo.getResponsibleTechnician() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getResponsibleTechnician().getBean();
		this.timeelapsed = vo.getTimeElapsed();
		this.comment = vo.getComment();
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
		this.sysinfo = vo.getSysinfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysinfo().getBean();
		this.actiontemplate = vo.getActionTemplate() == null ? null : (ims.core.vo.beans.ActionPlanTemplateVoBean)vo.getActionTemplate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.naes.vo.ActionDetailVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.action = vo.getAction() == null ? null : (ims.vo.LookupInstanceBean)vo.getAction().getBean();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.naes.vo.beans.ActionDetailStatusVoBean)vo.getCurrentStatus().getBean(map);
		this.responsibletechnician = vo.getResponsibleTechnician() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getResponsibleTechnician().getBean(map);
		this.timeelapsed = vo.getTimeElapsed();
		this.comment = vo.getComment();
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
		this.sysinfo = vo.getSysinfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysinfo().getBean();
		this.actiontemplate = vo.getActionTemplate() == null ? null : (ims.core.vo.beans.ActionPlanTemplateVoBean)vo.getActionTemplate().getBean(map);
	}

	public ims.naes.vo.ActionDetailVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.naes.vo.ActionDetailVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.naes.vo.ActionDetailVo vo = null;
		if(map != null)
			vo = (ims.naes.vo.ActionDetailVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.naes.vo.ActionDetailVo();
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
	public ims.vo.LookupInstanceBean getAction()
	{
		return this.action;
	}
	public void setAction(ims.vo.LookupInstanceBean value)
	{
		this.action = value;
	}
	public ims.framework.utils.beans.DateBean getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.startdate = value;
	}
	public ims.naes.vo.beans.ActionDetailStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.naes.vo.beans.ActionDetailStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getResponsibleTechnician()
	{
		return this.responsibletechnician;
	}
	public void setResponsibleTechnician(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.responsibletechnician = value;
	}
	public Integer getTimeElapsed()
	{
		return this.timeelapsed;
	}
	public void setTimeElapsed(Integer value)
	{
		this.timeelapsed = value;
	}
	public String getComment()
	{
		return this.comment;
	}
	public void setComment(String value)
	{
		this.comment = value;
	}
	public ims.naes.vo.beans.ActionDetailStatusVoBean[] getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.naes.vo.beans.ActionDetailStatusVoBean[] value)
	{
		this.statushistory = value;
	}
	public ims.vo.SysInfoBean getSysinfo()
	{
		return this.sysinfo;
	}
	public void setSysinfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.core.vo.beans.ActionPlanTemplateVoBean getActionTemplate()
	{
		return this.actiontemplate;
	}
	public void setActionTemplate(ims.core.vo.beans.ActionPlanTemplateVoBean value)
	{
		this.actiontemplate = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean action;
	private ims.framework.utils.beans.DateBean startdate;
	private ims.naes.vo.beans.ActionDetailStatusVoBean currentstatus;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean responsibletechnician;
	private Integer timeelapsed;
	private String comment;
	private ims.naes.vo.beans.ActionDetailStatusVoBean[] statushistory;
	private ims.vo.SysInfoBean sysinfo;
	private ims.core.vo.beans.ActionPlanTemplateVoBean actiontemplate;
}
