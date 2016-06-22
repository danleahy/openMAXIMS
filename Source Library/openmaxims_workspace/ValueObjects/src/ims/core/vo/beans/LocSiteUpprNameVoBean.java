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

public class LocSiteUpprNameVoBean extends ims.vo.ValueObjectBean
{
	public LocSiteUpprNameVoBean()
	{
	}
	public LocSiteUpprNameVoBean(ims.core.vo.LocSiteUpprNameVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.address = vo.getAddress() == null ? null : (ims.core.vo.beans.AddressVoBean)vo.getAddress().getBean();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.isactive = vo.getIsActive();
		this.codemappings = vo.getCodeMappings() == null ? null : vo.getCodeMappings().getBeanCollection();
		this.uppername = vo.getUpperName();
		this.isvirtual = vo.getIsVirtual();
		this.parentorganisation = vo.getParentOrganisation() == null ? null : (ims.core.vo.beans.OrgVoBean)vo.getParentOrganisation().getBean();
		this.commchannels = vo.getCommChannels() == null ? null : vo.getCommChannels().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.LocSiteUpprNameVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.address = vo.getAddress() == null ? null : (ims.core.vo.beans.AddressVoBean)vo.getAddress().getBean(map);
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.isactive = vo.getIsActive();
		this.codemappings = vo.getCodeMappings() == null ? null : vo.getCodeMappings().getBeanCollection();
		this.uppername = vo.getUpperName();
		this.isvirtual = vo.getIsVirtual();
		this.parentorganisation = vo.getParentOrganisation() == null ? null : (ims.core.vo.beans.OrgVoBean)vo.getParentOrganisation().getBean(map);
		this.commchannels = vo.getCommChannels() == null ? null : vo.getCommChannels().getBeanCollection();
	}

	public ims.core.vo.LocSiteUpprNameVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.LocSiteUpprNameVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.LocSiteUpprNameVo vo = null;
		if(map != null)
			vo = (ims.core.vo.LocSiteUpprNameVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.LocSiteUpprNameVo();
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
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public ims.core.vo.beans.AddressVoBean getAddress()
	{
		return this.address;
	}
	public void setAddress(ims.core.vo.beans.AddressVoBean value)
	{
		this.address = value;
	}
	public ims.vo.LookupInstanceBean getType()
	{
		return this.type;
	}
	public void setType(ims.vo.LookupInstanceBean value)
	{
		this.type = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.core.vo.beans.TaxonomyMapBean[] getCodeMappings()
	{
		return this.codemappings;
	}
	public void setCodeMappings(ims.core.vo.beans.TaxonomyMapBean[] value)
	{
		this.codemappings = value;
	}
	public String getUpperName()
	{
		return this.uppername;
	}
	public void setUpperName(String value)
	{
		this.uppername = value;
	}
	public Boolean getIsVirtual()
	{
		return this.isvirtual;
	}
	public void setIsVirtual(Boolean value)
	{
		this.isvirtual = value;
	}
	public ims.core.vo.beans.OrgVoBean getParentOrganisation()
	{
		return this.parentorganisation;
	}
	public void setParentOrganisation(ims.core.vo.beans.OrgVoBean value)
	{
		this.parentorganisation = value;
	}
	public ims.core.vo.beans.CommChannelVoBean[] getCommChannels()
	{
		return this.commchannels;
	}
	public void setCommChannels(ims.core.vo.beans.CommChannelVoBean[] value)
	{
		this.commchannels = value;
	}

	private Integer id;
	private int version;
	private String name;
	private ims.core.vo.beans.AddressVoBean address;
	private ims.vo.LookupInstanceBean type;
	private Boolean isactive;
	private ims.core.vo.beans.TaxonomyMapBean[] codemappings;
	private String uppername;
	private Boolean isvirtual;
	private ims.core.vo.beans.OrgVoBean parentorganisation;
	private ims.core.vo.beans.CommChannelVoBean[] commchannels;
}
