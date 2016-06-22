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

package ims.ocrr.vo.beans;

public class OrdersRequiringAuthorisationSearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public OrdersRequiringAuthorisationSearchCriteriaVoBean()
	{
	}
	public OrdersRequiringAuthorisationSearchCriteriaVoBean(ims.ocrr.vo.OrdersRequiringAuthorisationSearchCriteriaVo vo)
	{
		this.fromdate = vo.getFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFromDate().getBean();
		this.todate = vo.getToDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getToDate().getBean();
		this.respclinician = vo.getRespClinician() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getRespClinician().getBean();
		this.hospital = vo.getHospital() == null ? null : new ims.vo.RefVoBean(vo.getHospital().getBoId(), vo.getHospital().getBoVersion());
		this.loctype = vo.getLoctype();
		this.patientlocation = vo.getPatientLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getPatientLocation().getBean();
		this.patientclinic = vo.getPatientClinic() == null ? null : (ims.core.vo.beans.ClinicLiteVoBean)vo.getPatientClinic().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.OrdersRequiringAuthorisationSearchCriteriaVo vo)
	{
		this.fromdate = vo.getFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFromDate().getBean();
		this.todate = vo.getToDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getToDate().getBean();
		this.respclinician = vo.getRespClinician() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getRespClinician().getBean(map);
		this.hospital = vo.getHospital() == null ? null : new ims.vo.RefVoBean(vo.getHospital().getBoId(), vo.getHospital().getBoVersion());
		this.loctype = vo.getLoctype();
		this.patientlocation = vo.getPatientLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getPatientLocation().getBean(map);
		this.patientclinic = vo.getPatientClinic() == null ? null : (ims.core.vo.beans.ClinicLiteVoBean)vo.getPatientClinic().getBean(map);
	}

	public ims.ocrr.vo.OrdersRequiringAuthorisationSearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.OrdersRequiringAuthorisationSearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.OrdersRequiringAuthorisationSearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.OrdersRequiringAuthorisationSearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.OrdersRequiringAuthorisationSearchCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.framework.utils.beans.DateBean getFromDate()
	{
		return this.fromdate;
	}
	public void setFromDate(ims.framework.utils.beans.DateBean value)
	{
		this.fromdate = value;
	}
	public ims.framework.utils.beans.DateBean getToDate()
	{
		return this.todate;
	}
	public void setToDate(ims.framework.utils.beans.DateBean value)
	{
		this.todate = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getRespClinician()
	{
		return this.respclinician;
	}
	public void setRespClinician(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.respclinician = value;
	}
	public ims.vo.RefVoBean getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.vo.RefVoBean value)
	{
		this.hospital = value;
	}
	public Integer getLoctype()
	{
		return this.loctype;
	}
	public void setLoctype(Integer value)
	{
		this.loctype = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getPatientLocation()
	{
		return this.patientlocation;
	}
	public void setPatientLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.patientlocation = value;
	}
	public ims.core.vo.beans.ClinicLiteVoBean getPatientClinic()
	{
		return this.patientclinic;
	}
	public void setPatientClinic(ims.core.vo.beans.ClinicLiteVoBean value)
	{
		this.patientclinic = value;
	}

	private ims.framework.utils.beans.DateBean fromdate;
	private ims.framework.utils.beans.DateBean todate;
	private ims.core.vo.beans.HcpLiteVoBean respclinician;
	private ims.vo.RefVoBean hospital;
	private Integer loctype;
	private ims.core.vo.beans.LocationLiteVoBean patientlocation;
	private ims.core.vo.beans.ClinicLiteVoBean patientclinic;
}
