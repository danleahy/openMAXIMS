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

package ims.correspondence.vo.beans;

public class UserAccessFullVoBean extends ims.vo.ValueObjectBean
{
	public UserAccessFullVoBean()
	{
	}
	public UserAccessFullVoBean(ims.correspondence.vo.UserAccessFullVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appuser = vo.getAppUser() == null ? null : new ims.vo.RefVoBean(vo.getAppUser().getBoId(), vo.getAppUser().getBoVersion());
		this.consultantaccess = vo.getConsultantAccess() == null ? null : vo.getConsultantAccess().getBeanCollection();
		this.clinicaccess = vo.getClinicAccess() == null ? null : vo.getClinicAccess().getBeanCollection();
		this.specialtyaccess = vo.getSpecialtyAccess() == null ? null : vo.getSpecialtyAccess().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.correspondence.vo.UserAccessFullVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appuser = vo.getAppUser() == null ? null : new ims.vo.RefVoBean(vo.getAppUser().getBoId(), vo.getAppUser().getBoVersion());
		this.consultantaccess = vo.getConsultantAccess() == null ? null : vo.getConsultantAccess().getBeanCollection();
		this.clinicaccess = vo.getClinicAccess() == null ? null : vo.getClinicAccess().getBeanCollection();
		this.specialtyaccess = vo.getSpecialtyAccess() == null ? null : vo.getSpecialtyAccess().getBeanCollection();
	}

	public ims.correspondence.vo.UserAccessFullVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.correspondence.vo.UserAccessFullVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.correspondence.vo.UserAccessFullVo vo = null;
		if(map != null)
			vo = (ims.correspondence.vo.UserAccessFullVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.correspondence.vo.UserAccessFullVo();
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
	public ims.vo.RefVoBean getAppUser()
	{
		return this.appuser;
	}
	public void setAppUser(ims.vo.RefVoBean value)
	{
		this.appuser = value;
	}
	public ims.correspondence.vo.beans.ConsultantAccessFullVoBean[] getConsultantAccess()
	{
		return this.consultantaccess;
	}
	public void setConsultantAccess(ims.correspondence.vo.beans.ConsultantAccessFullVoBean[] value)
	{
		this.consultantaccess = value;
	}
	public ims.correspondence.vo.beans.ClinicAccessFullVoBean[] getClinicAccess()
	{
		return this.clinicaccess;
	}
	public void setClinicAccess(ims.correspondence.vo.beans.ClinicAccessFullVoBean[] value)
	{
		this.clinicaccess = value;
	}
	public ims.correspondence.vo.beans.SpecialtyAccessVoBean[] getSpecialtyAccess()
	{
		return this.specialtyaccess;
	}
	public void setSpecialtyAccess(ims.correspondence.vo.beans.SpecialtyAccessVoBean[] value)
	{
		this.specialtyaccess = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean appuser;
	private ims.correspondence.vo.beans.ConsultantAccessFullVoBean[] consultantaccess;
	private ims.correspondence.vo.beans.ClinicAccessFullVoBean[] clinicaccess;
	private ims.correspondence.vo.beans.SpecialtyAccessVoBean[] specialtyaccess;
}
