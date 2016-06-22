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

public class AuditListFilterVoBean extends ims.vo.ValueObjectBean
{
	public AuditListFilterVoBean()
	{
	}
	public AuditListFilterVoBean(ims.core.vo.AuditListFilterVo vo)
	{
		this.datefrom = vo.getDateFrom() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateFrom().getBean();
		this.dateto = vo.getDateTo() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTo().getBean();
		this.action = vo.getAction();
		this.user = vo.getUser();
		this.classname = vo.getClassName();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean();
		this.classid = vo.getClassId();
		this.hostname = vo.getHostname();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean();
		this.auditlocation = vo.getAuditLocation() == null ? null : new ims.vo.RefVoBean(vo.getAuditLocation().getBoId(), vo.getAuditLocation().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.AuditListFilterVo vo)
	{
		this.datefrom = vo.getDateFrom() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateFrom().getBean();
		this.dateto = vo.getDateTo() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTo().getBean();
		this.action = vo.getAction();
		this.user = vo.getUser();
		this.classname = vo.getClassName();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean(map);
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean(map);
		this.classid = vo.getClassId();
		this.hostname = vo.getHostname();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean(map);
		this.auditlocation = vo.getAuditLocation() == null ? null : new ims.vo.RefVoBean(vo.getAuditLocation().getBoId(), vo.getAuditLocation().getBoVersion());
	}

	public ims.core.vo.AuditListFilterVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.AuditListFilterVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.AuditListFilterVo vo = null;
		if(map != null)
			vo = (ims.core.vo.AuditListFilterVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.AuditListFilterVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.framework.utils.beans.DateTimeBean getDateFrom()
	{
		return this.datefrom;
	}
	public void setDateFrom(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datefrom = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateTo()
	{
		return this.dateto;
	}
	public void setDateTo(ims.framework.utils.beans.DateTimeBean value)
	{
		this.dateto = value;
	}
	public String getAction()
	{
		return this.action;
	}
	public void setAction(String value)
	{
		this.action = value;
	}
	public String getUser()
	{
		return this.user;
	}
	public void setUser(String value)
	{
		this.user = value;
	}
	public String getClassName()
	{
		return this.classname;
	}
	public void setClassName(String value)
	{
		this.classname = value;
	}
	public ims.core.vo.beans.PatientShortBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.ClinicalContactShortVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.beans.ClinicalContactShortVoBean value)
	{
		this.clinicalcontact = value;
	}
	public Integer getClassId()
	{
		return this.classid;
	}
	public void setClassId(Integer value)
	{
		this.classid = value;
	}
	public String getHostname()
	{
		return this.hostname;
	}
	public void setHostname(String value)
	{
		this.hostname = value;
	}
	public ims.core.vo.beans.CareContextShortVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextShortVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.RefVoBean getAuditLocation()
	{
		return this.auditlocation;
	}
	public void setAuditLocation(ims.vo.RefVoBean value)
	{
		this.auditlocation = value;
	}

	private ims.framework.utils.beans.DateTimeBean datefrom;
	private ims.framework.utils.beans.DateTimeBean dateto;
	private String action;
	private String user;
	private String classname;
	private ims.core.vo.beans.PatientShortBean patient;
	private ims.core.vo.beans.ClinicalContactShortVoBean clinicalcontact;
	private Integer classid;
	private String hostname;
	private ims.core.vo.beans.CareContextShortVoBean carecontext;
	private ims.vo.RefVoBean auditlocation;
}
