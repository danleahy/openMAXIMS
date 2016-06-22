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

package ims.pci.vo.beans;

public class ClientAddressVoBean extends ims.vo.ValueObjectBean
{
	public ClientAddressVoBean()
	{
	}
	public ClientAddressVoBean(ims.pci.vo.ClientAddressVo vo)
	{
		this.personaddress = vo.getPersonAddress() == null ? null : (ims.core.vo.beans.PersonAddressBean)vo.getPersonAddress().getBean();
		this.communitycare = vo.getCommunityCare() == null ? null : (ims.pci.vo.beans.CommunityCareVoBean)vo.getCommunityCare().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.pci.vo.ClientAddressVo vo)
	{
		this.personaddress = vo.getPersonAddress() == null ? null : (ims.core.vo.beans.PersonAddressBean)vo.getPersonAddress().getBean(map);
		this.communitycare = vo.getCommunityCare() == null ? null : (ims.pci.vo.beans.CommunityCareVoBean)vo.getCommunityCare().getBean(map);
	}

	public ims.pci.vo.ClientAddressVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.pci.vo.ClientAddressVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.pci.vo.ClientAddressVo vo = null;
		if(map != null)
			vo = (ims.pci.vo.ClientAddressVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.pci.vo.ClientAddressVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.PersonAddressBean getPersonAddress()
	{
		return this.personaddress;
	}
	public void setPersonAddress(ims.core.vo.beans.PersonAddressBean value)
	{
		this.personaddress = value;
	}
	public ims.pci.vo.beans.CommunityCareVoBean getCommunityCare()
	{
		return this.communitycare;
	}
	public void setCommunityCare(ims.pci.vo.beans.CommunityCareVoBean value)
	{
		this.communitycare = value;
	}

	private ims.core.vo.beans.PersonAddressBean personaddress;
	private ims.pci.vo.beans.CommunityCareVoBean communitycare;
}
