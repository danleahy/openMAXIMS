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

public class ModalityReportsVoBean extends ims.vo.ValueObjectBean
{
	public ModalityReportsVoBean()
	{
	}
	public ModalityReportsVoBean(ims.core.vo.ModalityReportsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.modality = vo.getModality() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getModality().getBean();
		this.dftreport = vo.getDFTReport();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.template = vo.getTemplate() == null ? null : (ims.admin.vo.beans.ReportTemplateLiteVoBean)vo.getTemplate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ModalityReportsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.modality = vo.getModality() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getModality().getBean(map);
		this.dftreport = vo.getDFTReport();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.template = vo.getTemplate() == null ? null : (ims.admin.vo.beans.ReportTemplateLiteVoBean)vo.getTemplate().getBean(map);
	}

	public ims.core.vo.ModalityReportsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ModalityReportsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ModalityReportsVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ModalityReportsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ModalityReportsVo();
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
	public ims.core.vo.beans.ServiceLiteVoBean getModality()
	{
		return this.modality;
	}
	public void setModality(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.modality = value;
	}
	public Boolean getDFTReport()
	{
		return this.dftreport;
	}
	public void setDFTReport(Boolean value)
	{
		this.dftreport = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.admin.vo.beans.ReportTemplateLiteVoBean getTemplate()
	{
		return this.template;
	}
	public void setTemplate(ims.admin.vo.beans.ReportTemplateLiteVoBean value)
	{
		this.template = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.ServiceLiteVoBean modality;
	private Boolean dftreport;
	private ims.vo.SysInfoBean sysinfo;
	private ims.admin.vo.beans.ReportTemplateLiteVoBean template;
}
