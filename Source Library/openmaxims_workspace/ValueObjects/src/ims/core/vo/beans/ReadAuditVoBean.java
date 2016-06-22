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

public class ReadAuditVoBean extends ims.vo.ValueObjectBean
{
	public ReadAuditVoBean()
	{
	}
	public ReadAuditVoBean(ims.core.vo.ReadAuditVo vo)
	{
		this.auditdatetime = vo.getAuditDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuditDateTime().getBean();
		this.audituser = vo.getAuditUser();
		this.action = vo.getAction();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean();
		this.hostname = vo.getHostName();
		this.location = vo.getLocation();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ReadAuditVo vo)
	{
		this.auditdatetime = vo.getAuditDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuditDateTime().getBean();
		this.audituser = vo.getAuditUser();
		this.action = vo.getAction();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean(map);
		this.hostname = vo.getHostName();
		this.location = vo.getLocation();
	}

	public ims.core.vo.ReadAuditVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ReadAuditVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ReadAuditVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ReadAuditVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ReadAuditVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.framework.utils.beans.DateTimeBean getAuditDateTime()
	{
		return this.auditdatetime;
	}
	public void setAuditDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.auditdatetime = value;
	}
	public String getAuditUser()
	{
		return this.audituser;
	}
	public void setAuditUser(String value)
	{
		this.audituser = value;
	}
	public String getAction()
	{
		return this.action;
	}
	public void setAction(String value)
	{
		this.action = value;
	}
	public ims.core.vo.beans.PatientShortBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.patient = value;
	}
	public String getHostName()
	{
		return this.hostname;
	}
	public void setHostName(String value)
	{
		this.hostname = value;
	}
	public String getLocation()
	{
		return this.location;
	}
	public void setLocation(String value)
	{
		this.location = value;
	}

	private ims.framework.utils.beans.DateTimeBean auditdatetime;
	private String audituser;
	private String action;
	private ims.core.vo.beans.PatientShortBean patient;
	private String hostname;
	private String location;
}
