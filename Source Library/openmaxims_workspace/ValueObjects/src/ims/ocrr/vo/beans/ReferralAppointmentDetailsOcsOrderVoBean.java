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

package ims.ocrr.vo.beans;

public class ReferralAppointmentDetailsOcsOrderVoBean extends ims.vo.ValueObjectBean
{
	public ReferralAppointmentDetailsOcsOrderVoBean()
	{
	}
	public ReferralAppointmentDetailsOcsOrderVoBean(ims.ocrr.vo.ReferralAppointmentDetailsOcsOrderVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigations = vo.getInvestigations() == null ? null : vo.getInvestigations().getBeanCollection();
		this.responsibleclinician = vo.getResponsibleClinician() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleClinician().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.ReferralAppointmentDetailsOcsOrderVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigations = vo.getInvestigations() == null ? null : vo.getInvestigations().getBeanCollection();
		this.responsibleclinician = vo.getResponsibleClinician() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleClinician().getBean(map);
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
	}

	public ims.ocrr.vo.ReferralAppointmentDetailsOcsOrderVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.ReferralAppointmentDetailsOcsOrderVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.ReferralAppointmentDetailsOcsOrderVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.ReferralAppointmentDetailsOcsOrderVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.ReferralAppointmentDetailsOcsOrderVo();
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
	public ims.ocrr.vo.beans.ReferralAppointmentDetailsOrderInvestigationVoBean[] getInvestigations()
	{
		return this.investigations;
	}
	public void setInvestigations(ims.ocrr.vo.beans.ReferralAppointmentDetailsOrderInvestigationVoBean[] value)
	{
		this.investigations = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getResponsibleClinician()
	{
		return this.responsibleclinician;
	}
	public void setResponsibleClinician(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.responsibleclinician = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}

	private Integer id;
	private int version;
	private ims.ocrr.vo.beans.ReferralAppointmentDetailsOrderInvestigationVoBean[] investigations;
	private ims.core.vo.beans.HcpLiteVoBean responsibleclinician;
	private ims.vo.SysInfoBean sysinfo;
}
