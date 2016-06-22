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

public class MosOrgLocVoBean extends ims.vo.ValueObjectBean
{
	public MosOrgLocVoBean()
	{
	}
	public MosOrgLocVoBean(ims.core.vo.MosOrgLocVo vo)
	{
		this.organisation = vo.getOrganisation() == null ? null : (ims.core.vo.beans.OrgShortVoBean)vo.getOrganisation().getBean();
		this.hcplocations = vo.getHCPLocations() == null ? null : vo.getHCPLocations().getBeanCollection();
		this.primarylocation = vo.getPrimaryLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getPrimaryLocation().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.MosOrgLocVo vo)
	{
		this.organisation = vo.getOrganisation() == null ? null : (ims.core.vo.beans.OrgShortVoBean)vo.getOrganisation().getBean(map);
		this.hcplocations = vo.getHCPLocations() == null ? null : vo.getHCPLocations().getBeanCollection();
		this.primarylocation = vo.getPrimaryLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getPrimaryLocation().getBean(map);
	}

	public ims.core.vo.MosOrgLocVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.MosOrgLocVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.MosOrgLocVo vo = null;
		if(map != null)
			vo = (ims.core.vo.MosOrgLocVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.MosOrgLocVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.OrgShortVoBean getOrganisation()
	{
		return this.organisation;
	}
	public void setOrganisation(ims.core.vo.beans.OrgShortVoBean value)
	{
		this.organisation = value;
	}
	public ims.core.vo.beans.HCPLocationLiteVoBean[] getHCPLocations()
	{
		return this.hcplocations;
	}
	public void setHCPLocations(ims.core.vo.beans.HCPLocationLiteVoBean[] value)
	{
		this.hcplocations = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getPrimaryLocation()
	{
		return this.primarylocation;
	}
	public void setPrimaryLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.primarylocation = value;
	}

	private ims.core.vo.beans.OrgShortVoBean organisation;
	private ims.core.vo.beans.HCPLocationLiteVoBean[] hcplocations;
	private ims.core.vo.beans.LocationLiteVoBean primarylocation;
}
