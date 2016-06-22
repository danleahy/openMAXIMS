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

package ims.ntpf.vo.beans;

public class ServiceActivityExportVoBean extends ims.vo.ValueObjectBean
{
	public ServiceActivityExportVoBean()
	{
	}
	public ServiceActivityExportVoBean(ims.ntpf.vo.ServiceActivityExportVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.serviceactivity = vo.getServiceActivity() == null ? null : new ims.vo.RefVoBean(vo.getServiceActivity().getBoId(), vo.getServiceActivity().getBoVersion());
		this.readyforexport = vo.getReadyForExport();
		this.datelastexported = vo.getDateLastExported() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateLastExported().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ntpf.vo.ServiceActivityExportVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.serviceactivity = vo.getServiceActivity() == null ? null : new ims.vo.RefVoBean(vo.getServiceActivity().getBoId(), vo.getServiceActivity().getBoVersion());
		this.readyforexport = vo.getReadyForExport();
		this.datelastexported = vo.getDateLastExported() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateLastExported().getBean();
	}

	public ims.ntpf.vo.ServiceActivityExportVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ntpf.vo.ServiceActivityExportVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ntpf.vo.ServiceActivityExportVo vo = null;
		if(map != null)
			vo = (ims.ntpf.vo.ServiceActivityExportVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ntpf.vo.ServiceActivityExportVo();
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
	public ims.vo.RefVoBean getServiceActivity()
	{
		return this.serviceactivity;
	}
	public void setServiceActivity(ims.vo.RefVoBean value)
	{
		this.serviceactivity = value;
	}
	public Boolean getReadyForExport()
	{
		return this.readyforexport;
	}
	public void setReadyForExport(Boolean value)
	{
		this.readyforexport = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateLastExported()
	{
		return this.datelastexported;
	}
	public void setDateLastExported(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datelastexported = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean serviceactivity;
	private Boolean readyforexport;
	private ims.framework.utils.beans.DateTimeBean datelastexported;
}
