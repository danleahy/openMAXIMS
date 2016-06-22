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

package ims.nursing.vo.beans;

public class ClinicalAdmissionListVoBean extends ims.vo.ValueObjectBean
{
	public ClinicalAdmissionListVoBean()
	{
	}
	public ClinicalAdmissionListVoBean(ims.nursing.vo.ClinicalAdmissionListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.admittingnurse = vo.getAdmittingNurse() == null ? null : (ims.core.vo.beans.NurseVoBean)vo.getAdmittingNurse().getBean();
		this.dischargeddatetime = vo.getDischargedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargedDateTime().getBean();
		this.dischargedby = vo.getDischargedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getDischargedBy().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.ClinicalAdmissionListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.admittingnurse = vo.getAdmittingNurse() == null ? null : (ims.core.vo.beans.NurseVoBean)vo.getAdmittingNurse().getBean(map);
		this.dischargeddatetime = vo.getDischargedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargedDateTime().getBean();
		this.dischargedby = vo.getDischargedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getDischargedBy().getBean(map);
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public ims.nursing.vo.ClinicalAdmissionListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.ClinicalAdmissionListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.ClinicalAdmissionListVo vo = null;
		if(map != null)
			vo = (ims.nursing.vo.ClinicalAdmissionListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.ClinicalAdmissionListVo();
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
	public ims.core.vo.beans.NurseVoBean getAdmittingNurse()
	{
		return this.admittingnurse;
	}
	public void setAdmittingNurse(ims.core.vo.beans.NurseVoBean value)
	{
		this.admittingnurse = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDischargedDateTime()
	{
		return this.dischargeddatetime;
	}
	public void setDischargedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.dischargeddatetime = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getDischargedBy()
	{
		return this.dischargedby;
	}
	public void setDischargedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.dischargedby = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.NurseVoBean admittingnurse;
	private ims.framework.utils.beans.DateTimeBean dischargeddatetime;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean dischargedby;
	private ims.vo.SysInfoBean sysinfo;
	private ims.vo.RefVoBean carecontext;
}
