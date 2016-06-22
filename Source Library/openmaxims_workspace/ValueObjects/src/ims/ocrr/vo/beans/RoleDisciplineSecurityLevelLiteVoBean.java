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

public class RoleDisciplineSecurityLevelLiteVoBean extends ims.vo.ValueObjectBean
{
	public RoleDisciplineSecurityLevelLiteVoBean()
	{
	}
	public RoleDisciplineSecurityLevelLiteVoBean(ims.ocrr.vo.RoleDisciplineSecurityLevelLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.role = vo.getRole() == null ? null : new ims.vo.RefVoBean(vo.getRole().getBoId(), vo.getRole().getBoVersion());
		this.service = vo.getService() == null ? null : new ims.vo.RefVoBean(vo.getService().getBoId(), vo.getService().getBoVersion());
		this.orderingsecuritylevel = vo.getOrderingSecurityLevel() == null ? null : (ims.ocrr.vo.beans.SecurityLevelConfigVoBean)vo.getOrderingSecurityLevel().getBean();
		this.viewingsecuritylevel = vo.getViewingSecurityLevel() == null ? null : (ims.ocrr.vo.beans.SecurityLevelConfigVoBean)vo.getViewingSecurityLevel().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.RoleDisciplineSecurityLevelLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.role = vo.getRole() == null ? null : new ims.vo.RefVoBean(vo.getRole().getBoId(), vo.getRole().getBoVersion());
		this.service = vo.getService() == null ? null : new ims.vo.RefVoBean(vo.getService().getBoId(), vo.getService().getBoVersion());
		this.orderingsecuritylevel = vo.getOrderingSecurityLevel() == null ? null : (ims.ocrr.vo.beans.SecurityLevelConfigVoBean)vo.getOrderingSecurityLevel().getBean(map);
		this.viewingsecuritylevel = vo.getViewingSecurityLevel() == null ? null : (ims.ocrr.vo.beans.SecurityLevelConfigVoBean)vo.getViewingSecurityLevel().getBean(map);
	}

	public ims.ocrr.vo.RoleDisciplineSecurityLevelLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.RoleDisciplineSecurityLevelLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.RoleDisciplineSecurityLevelLiteVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.RoleDisciplineSecurityLevelLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.RoleDisciplineSecurityLevelLiteVo();
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
	public ims.vo.RefVoBean getRole()
	{
		return this.role;
	}
	public void setRole(ims.vo.RefVoBean value)
	{
		this.role = value;
	}
	public ims.vo.RefVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.vo.RefVoBean value)
	{
		this.service = value;
	}
	public ims.ocrr.vo.beans.SecurityLevelConfigVoBean getOrderingSecurityLevel()
	{
		return this.orderingsecuritylevel;
	}
	public void setOrderingSecurityLevel(ims.ocrr.vo.beans.SecurityLevelConfigVoBean value)
	{
		this.orderingsecuritylevel = value;
	}
	public ims.ocrr.vo.beans.SecurityLevelConfigVoBean getViewingSecurityLevel()
	{
		return this.viewingsecuritylevel;
	}
	public void setViewingSecurityLevel(ims.ocrr.vo.beans.SecurityLevelConfigVoBean value)
	{
		this.viewingsecuritylevel = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean role;
	private ims.vo.RefVoBean service;
	private ims.ocrr.vo.beans.SecurityLevelConfigVoBean orderingsecuritylevel;
	private ims.ocrr.vo.beans.SecurityLevelConfigVoBean viewingsecuritylevel;
}
