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

package ims.clinical.vo.beans;

public class SystemReviewSymptomVoBean extends ims.vo.ValueObjectBean
{
	public SystemReviewSymptomVoBean()
	{
	}
	public SystemReviewSymptomVoBean(ims.clinical.vo.SystemReviewSymptomVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.symptom = vo.getSymptom() == null ? null : (ims.vo.LookupInstanceBean)vo.getSymptom().getBean();
		this.absentpresent = vo.getAbsentPresent() == null ? null : (ims.vo.LookupInstanceBean)vo.getAbsentPresent().getBean();
		this.durationvalue = vo.getDurationValue();
		this.durationunit = vo.getDurationUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getDurationUnit().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.SystemReviewSymptomVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.symptom = vo.getSymptom() == null ? null : (ims.vo.LookupInstanceBean)vo.getSymptom().getBean();
		this.absentpresent = vo.getAbsentPresent() == null ? null : (ims.vo.LookupInstanceBean)vo.getAbsentPresent().getBean();
		this.durationvalue = vo.getDurationValue();
		this.durationunit = vo.getDurationUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getDurationUnit().getBean();
	}

	public ims.clinical.vo.SystemReviewSymptomVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.SystemReviewSymptomVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.SystemReviewSymptomVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.SystemReviewSymptomVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.SystemReviewSymptomVo();
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
	public ims.vo.LookupInstanceBean getSymptom()
	{
		return this.symptom;
	}
	public void setSymptom(ims.vo.LookupInstanceBean value)
	{
		this.symptom = value;
	}
	public ims.vo.LookupInstanceBean getAbsentPresent()
	{
		return this.absentpresent;
	}
	public void setAbsentPresent(ims.vo.LookupInstanceBean value)
	{
		this.absentpresent = value;
	}
	public Integer getDurationValue()
	{
		return this.durationvalue;
	}
	public void setDurationValue(Integer value)
	{
		this.durationvalue = value;
	}
	public ims.vo.LookupInstanceBean getDurationUnit()
	{
		return this.durationunit;
	}
	public void setDurationUnit(ims.vo.LookupInstanceBean value)
	{
		this.durationunit = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean symptom;
	private ims.vo.LookupInstanceBean absentpresent;
	private Integer durationvalue;
	private ims.vo.LookupInstanceBean durationunit;
}
