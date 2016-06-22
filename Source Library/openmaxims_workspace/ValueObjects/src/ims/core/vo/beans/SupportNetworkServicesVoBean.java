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

public class SupportNetworkServicesVoBean extends ims.vo.ValueObjectBean
{
	public SupportNetworkServicesVoBean()
	{
	}
	public SupportNetworkServicesVoBean(ims.core.vo.SupportNetworkServicesVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.locationservice = vo.getLocationService() == null ? null : (ims.core.vo.beans.LocationServiceVoBean)vo.getLocationService().getBean();
		this.frequencyofservice = vo.getFrequencyOfService();
		this.comments = vo.getComments();
		this.iscurrentlyactive = vo.getIsCurrentlyActive();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.suppliedservice = vo.getSuppliedService() == null ? null : (ims.core.vo.beans.SuppNetworkServiceProfessionDetailVoBean)vo.getSuppliedService().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean();
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.SupportNetworkServicesVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.locationservice = vo.getLocationService() == null ? null : (ims.core.vo.beans.LocationServiceVoBean)vo.getLocationService().getBean(map);
		this.frequencyofservice = vo.getFrequencyOfService();
		this.comments = vo.getComments();
		this.iscurrentlyactive = vo.getIsCurrentlyActive();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.suppliedservice = vo.getSuppliedService() == null ? null : (ims.core.vo.beans.SuppNetworkServiceProfessionDetailVoBean)vo.getSuppliedService().getBean(map);
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean(map);
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean(map);
	}

	public ims.core.vo.SupportNetworkServicesVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.SupportNetworkServicesVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.SupportNetworkServicesVo vo = null;
		if(map != null)
			vo = (ims.core.vo.SupportNetworkServicesVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.SupportNetworkServicesVo();
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
	public ims.core.vo.beans.LocationServiceVoBean getLocationService()
	{
		return this.locationservice;
	}
	public void setLocationService(ims.core.vo.beans.LocationServiceVoBean value)
	{
		this.locationservice = value;
	}
	public String getFrequencyOfService()
	{
		return this.frequencyofservice;
	}
	public void setFrequencyOfService(String value)
	{
		this.frequencyofservice = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public Boolean getIsCurrentlyActive()
	{
		return this.iscurrentlyactive;
	}
	public void setIsCurrentlyActive(Boolean value)
	{
		this.iscurrentlyactive = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.core.vo.beans.SuppNetworkServiceProfessionDetailVoBean getSuppliedService()
	{
		return this.suppliedservice;
	}
	public void setSuppliedService(ims.core.vo.beans.SuppNetworkServiceProfessionDetailVoBean value)
	{
		this.suppliedservice = value;
	}
	public ims.core.vo.beans.ServiceLiteVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.service = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInfo()
	{
		return this.authoringinfo;
	}
	public void setAuthoringInfo(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinfo = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.LocationServiceVoBean locationservice;
	private String frequencyofservice;
	private String comments;
	private Boolean iscurrentlyactive;
	private ims.vo.SysInfoBean sysinfo;
	private ims.core.vo.beans.SuppNetworkServiceProfessionDetailVoBean suppliedservice;
	private ims.core.vo.beans.ServiceLiteVoBean service;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinfo;
}
