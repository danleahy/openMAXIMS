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

public class ClericalTaskWorklistSearchVoBean extends ims.vo.ValueObjectBean
{
	public ClericalTaskWorklistSearchVoBean()
	{
	}
	public ClericalTaskWorklistSearchVoBean(ims.core.vo.ClericalTaskWorklistSearchVo vo)
	{
		this.surname = vo.getSurname();
		this.forename = vo.getForename();
		this.hospitalno = vo.getHospitalNo();
		this.requestor = vo.getRequestor() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getRequestor().getBean();
		this.allocatedto = vo.getAllocatedTo() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAllocatedTo().getBean();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.datefrom = vo.getDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateFrom().getBean();
		this.dateto = vo.getDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateTo().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ClericalTaskWorklistSearchVo vo)
	{
		this.surname = vo.getSurname();
		this.forename = vo.getForename();
		this.hospitalno = vo.getHospitalNo();
		this.requestor = vo.getRequestor() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getRequestor().getBean(map);
		this.allocatedto = vo.getAllocatedTo() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAllocatedTo().getBean(map);
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.datefrom = vo.getDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateFrom().getBean();
		this.dateto = vo.getDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateTo().getBean();
	}

	public ims.core.vo.ClericalTaskWorklistSearchVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ClericalTaskWorklistSearchVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ClericalTaskWorklistSearchVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ClericalTaskWorklistSearchVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ClericalTaskWorklistSearchVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getSurname()
	{
		return this.surname;
	}
	public void setSurname(String value)
	{
		this.surname = value;
	}
	public String getForename()
	{
		return this.forename;
	}
	public void setForename(String value)
	{
		this.forename = value;
	}
	public String getHospitalNo()
	{
		return this.hospitalno;
	}
	public void setHospitalNo(String value)
	{
		this.hospitalno = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getRequestor()
	{
		return this.requestor;
	}
	public void setRequestor(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.requestor = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getAllocatedTo()
	{
		return this.allocatedto;
	}
	public void setAllocatedTo(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.allocatedto = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.framework.utils.beans.DateBean getDateFrom()
	{
		return this.datefrom;
	}
	public void setDateFrom(ims.framework.utils.beans.DateBean value)
	{
		this.datefrom = value;
	}
	public ims.framework.utils.beans.DateBean getDateTo()
	{
		return this.dateto;
	}
	public void setDateTo(ims.framework.utils.beans.DateBean value)
	{
		this.dateto = value;
	}

	private String surname;
	private String forename;
	private String hospitalno;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean requestor;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean allocatedto;
	private ims.vo.LookupInstanceBean status;
	private ims.framework.utils.beans.DateBean datefrom;
	private ims.framework.utils.beans.DateBean dateto;
}
