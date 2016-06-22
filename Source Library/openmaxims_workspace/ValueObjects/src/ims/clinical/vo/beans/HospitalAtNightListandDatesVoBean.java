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

public class HospitalAtNightListandDatesVoBean extends ims.vo.ValueObjectBean
{
	public HospitalAtNightListandDatesVoBean()
	{
	}
	public HospitalAtNightListandDatesVoBean(ims.clinical.vo.HospitalAtNightListandDatesVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.cutoverpoints = vo.getCutOverPoints() == null ? null : new ims.vo.RefVoBean(vo.getCutOverPoints().getBoId(), vo.getCutOverPoints().getBoVersion());
		this.hospital = vo.getHospital() == null ? null : new ims.vo.RefVoBean(vo.getHospital().getBoId(), vo.getHospital().getBoVersion());
		this.patientdetails = vo.getPatientDetails() == null ? null : vo.getPatientDetails().getBeanCollection();
		this.shiftstartdate = vo.getShiftStartDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getShiftStartDate().getBean();
		this.shiftenddate = vo.getShiftEndDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getShiftEndDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.HospitalAtNightListandDatesVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.cutoverpoints = vo.getCutOverPoints() == null ? null : new ims.vo.RefVoBean(vo.getCutOverPoints().getBoId(), vo.getCutOverPoints().getBoVersion());
		this.hospital = vo.getHospital() == null ? null : new ims.vo.RefVoBean(vo.getHospital().getBoId(), vo.getHospital().getBoVersion());
		this.patientdetails = vo.getPatientDetails() == null ? null : vo.getPatientDetails().getBeanCollection();
		this.shiftstartdate = vo.getShiftStartDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getShiftStartDate().getBean();
		this.shiftenddate = vo.getShiftEndDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getShiftEndDate().getBean();
	}

	public ims.clinical.vo.HospitalAtNightListandDatesVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.HospitalAtNightListandDatesVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.HospitalAtNightListandDatesVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.HospitalAtNightListandDatesVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.HospitalAtNightListandDatesVo();
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
	public ims.vo.RefVoBean getCutOverPoints()
	{
		return this.cutoverpoints;
	}
	public void setCutOverPoints(ims.vo.RefVoBean value)
	{
		this.cutoverpoints = value;
	}
	public ims.vo.RefVoBean getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.vo.RefVoBean value)
	{
		this.hospital = value;
	}
	public ims.clinical.vo.beans.HospitalAtNightPatientDetailVoBean[] getPatientDetails()
	{
		return this.patientdetails;
	}
	public void setPatientDetails(ims.clinical.vo.beans.HospitalAtNightPatientDetailVoBean[] value)
	{
		this.patientdetails = value;
	}
	public ims.framework.utils.beans.DateTimeBean getShiftStartDate()
	{
		return this.shiftstartdate;
	}
	public void setShiftStartDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.shiftstartdate = value;
	}
	public ims.framework.utils.beans.DateTimeBean getShiftEndDate()
	{
		return this.shiftenddate;
	}
	public void setShiftEndDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.shiftenddate = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean cutoverpoints;
	private ims.vo.RefVoBean hospital;
	private ims.clinical.vo.beans.HospitalAtNightPatientDetailVoBean[] patientdetails;
	private ims.framework.utils.beans.DateTimeBean shiftstartdate;
	private ims.framework.utils.beans.DateTimeBean shiftenddate;
}
