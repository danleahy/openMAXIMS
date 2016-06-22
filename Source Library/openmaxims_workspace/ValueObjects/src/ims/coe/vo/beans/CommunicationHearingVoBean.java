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

package ims.coe.vo.beans;

public class CommunicationHearingVoBean extends ims.vo.ValueObjectBean
{
	public CommunicationHearingVoBean()
	{
	}
	public CommunicationHearingVoBean(ims.coe.vo.CommunicationHearingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hearingimpairment = vo.getHearingImpairment() == null ? null : (ims.vo.LookupInstanceBean)vo.getHearingImpairment().getBean();
		this.effectedears = vo.getEffectedEars() == null ? null : (ims.vo.LookupInstanceBean)vo.getEffectedEars().getBean();
		this.hearingaid = vo.getHearingAid() == null ? null : (ims.vo.LookupInstanceBean)vo.getHearingAid().getBean();
		this.hearingaidwithpatientonadmission = vo.getHearingAidWithPatientOnAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getHearingAidWithPatientOnAdmission().getBean();
		this.batteriesinorder = vo.getBatteriesInOrder() == null ? null : (ims.vo.LookupInstanceBean)vo.getBatteriesInOrder().getBean();
		this.yearlasthearingtest = vo.getYearLastHearingTest();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.CommunicationHearingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hearingimpairment = vo.getHearingImpairment() == null ? null : (ims.vo.LookupInstanceBean)vo.getHearingImpairment().getBean();
		this.effectedears = vo.getEffectedEars() == null ? null : (ims.vo.LookupInstanceBean)vo.getEffectedEars().getBean();
		this.hearingaid = vo.getHearingAid() == null ? null : (ims.vo.LookupInstanceBean)vo.getHearingAid().getBean();
		this.hearingaidwithpatientonadmission = vo.getHearingAidWithPatientOnAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getHearingAidWithPatientOnAdmission().getBean();
		this.batteriesinorder = vo.getBatteriesInOrder() == null ? null : (ims.vo.LookupInstanceBean)vo.getBatteriesInOrder().getBean();
		this.yearlasthearingtest = vo.getYearLastHearingTest();
	}

	public ims.coe.vo.CommunicationHearingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.coe.vo.CommunicationHearingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.CommunicationHearingVo vo = null;
		if(map != null)
			vo = (ims.coe.vo.CommunicationHearingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.coe.vo.CommunicationHearingVo();
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
	public ims.vo.LookupInstanceBean getHearingImpairment()
	{
		return this.hearingimpairment;
	}
	public void setHearingImpairment(ims.vo.LookupInstanceBean value)
	{
		this.hearingimpairment = value;
	}
	public ims.vo.LookupInstanceBean getEffectedEars()
	{
		return this.effectedears;
	}
	public void setEffectedEars(ims.vo.LookupInstanceBean value)
	{
		this.effectedears = value;
	}
	public ims.vo.LookupInstanceBean getHearingAid()
	{
		return this.hearingaid;
	}
	public void setHearingAid(ims.vo.LookupInstanceBean value)
	{
		this.hearingaid = value;
	}
	public ims.vo.LookupInstanceBean getHearingAidWithPatientOnAdmission()
	{
		return this.hearingaidwithpatientonadmission;
	}
	public void setHearingAidWithPatientOnAdmission(ims.vo.LookupInstanceBean value)
	{
		this.hearingaidwithpatientonadmission = value;
	}
	public ims.vo.LookupInstanceBean getBatteriesInOrder()
	{
		return this.batteriesinorder;
	}
	public void setBatteriesInOrder(ims.vo.LookupInstanceBean value)
	{
		this.batteriesinorder = value;
	}
	public Integer getYearLastHearingTest()
	{
		return this.yearlasthearingtest;
	}
	public void setYearLastHearingTest(Integer value)
	{
		this.yearlasthearingtest = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean hearingimpairment;
	private ims.vo.LookupInstanceBean effectedears;
	private ims.vo.LookupInstanceBean hearingaid;
	private ims.vo.LookupInstanceBean hearingaidwithpatientonadmission;
	private ims.vo.LookupInstanceBean batteriesinorder;
	private Integer yearlasthearingtest;
}
