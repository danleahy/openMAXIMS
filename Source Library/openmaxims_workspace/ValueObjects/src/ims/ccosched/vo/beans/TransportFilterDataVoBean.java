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

package ims.ccosched.vo.beans;

public class TransportFilterDataVoBean extends ims.vo.ValueObjectBean
{
	public TransportFilterDataVoBean()
	{
	}
	public TransportFilterDataVoBean(ims.ccosched.vo.TransportFilterDataVo vo)
	{
		this.appt_head_id = vo.getAppt_head_id();
		this.pkey = vo.getPkey();
		this.treatpl_act_id = vo.getTreatpl_act_id();
		this.patient = vo.getPatient();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ccosched.vo.TransportFilterDataVo vo)
	{
		this.appt_head_id = vo.getAppt_head_id();
		this.pkey = vo.getPkey();
		this.treatpl_act_id = vo.getTreatpl_act_id();
		this.patient = vo.getPatient();
	}

	public ims.ccosched.vo.TransportFilterDataVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ccosched.vo.TransportFilterDataVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ccosched.vo.TransportFilterDataVo vo = null;
		if(map != null)
			vo = (ims.ccosched.vo.TransportFilterDataVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ccosched.vo.TransportFilterDataVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getAppt_head_id()
	{
		return this.appt_head_id;
	}
	public void setAppt_head_id(String value)
	{
		this.appt_head_id = value;
	}
	public String getPkey()
	{
		return this.pkey;
	}
	public void setPkey(String value)
	{
		this.pkey = value;
	}
	public String getTreatpl_act_id()
	{
		return this.treatpl_act_id;
	}
	public void setTreatpl_act_id(String value)
	{
		this.treatpl_act_id = value;
	}
	public String getPatient()
	{
		return this.patient;
	}
	public void setPatient(String value)
	{
		this.patient = value;
	}

	private String appt_head_id;
	private String pkey;
	private String treatpl_act_id;
	private String patient;
}
