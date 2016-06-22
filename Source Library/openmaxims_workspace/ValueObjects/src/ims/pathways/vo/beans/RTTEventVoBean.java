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

package ims.pathways.vo.beans;

public class RTTEventVoBean extends ims.vo.ValueObjectBean
{
	public RTTEventVoBean()
	{
	}
	public RTTEventVoBean(ims.pathways.vo.RTTEventVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.providersystem = vo.getProviderSystem() == null ? null : (ims.ocrr.vo.beans.ProviderSystemVoBean)vo.getProviderSystem().getBean();
		this.name = vo.getName();
		this.pascode = vo.getPASCode();
		this.nationalcode = vo.getNationalCode();
		this.sequence = vo.getSequence();
		this.action = vo.getAction() == null ? null : (ims.vo.LookupInstanceBean)vo.getAction().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.RTTEventVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.providersystem = vo.getProviderSystem() == null ? null : (ims.ocrr.vo.beans.ProviderSystemVoBean)vo.getProviderSystem().getBean(map);
		this.name = vo.getName();
		this.pascode = vo.getPASCode();
		this.nationalcode = vo.getNationalCode();
		this.sequence = vo.getSequence();
		this.action = vo.getAction() == null ? null : (ims.vo.LookupInstanceBean)vo.getAction().getBean();
	}

	public ims.pathways.vo.RTTEventVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.pathways.vo.RTTEventVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.RTTEventVo vo = null;
		if(map != null)
			vo = (ims.pathways.vo.RTTEventVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.pathways.vo.RTTEventVo();
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
	public ims.ocrr.vo.beans.ProviderSystemVoBean getProviderSystem()
	{
		return this.providersystem;
	}
	public void setProviderSystem(ims.ocrr.vo.beans.ProviderSystemVoBean value)
	{
		this.providersystem = value;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public String getPASCode()
	{
		return this.pascode;
	}
	public void setPASCode(String value)
	{
		this.pascode = value;
	}
	public String getNationalCode()
	{
		return this.nationalcode;
	}
	public void setNationalCode(String value)
	{
		this.nationalcode = value;
	}
	public Integer getSequence()
	{
		return this.sequence;
	}
	public void setSequence(Integer value)
	{
		this.sequence = value;
	}
	public ims.vo.LookupInstanceBean getAction()
	{
		return this.action;
	}
	public void setAction(ims.vo.LookupInstanceBean value)
	{
		this.action = value;
	}

	private Integer id;
	private int version;
	private ims.ocrr.vo.beans.ProviderSystemVoBean providersystem;
	private String name;
	private String pascode;
	private String nationalcode;
	private Integer sequence;
	private ims.vo.LookupInstanceBean action;
}
