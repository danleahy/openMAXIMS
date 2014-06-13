//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.ocs_if.vo.beans;

public class IfOcsOrderShortVoBean extends ims.vo.ValueObjectBean
{
	public IfOcsOrderShortVoBean()
	{
	}
	public IfOcsOrderShortVoBean(ims.ocs_if.vo.IfOcsOrderShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.orderedby = vo.getOrderedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getOrderedBy().getBean();
		this.responsibleclinician = vo.getResponsibleClinician() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleClinician().getBean();
		this.responsiblegp = vo.getResponsibleGp() == null ? null : (ims.core.vo.beans.GpLiteVoBean)vo.getResponsibleGp().getBean();
		this.patientlocation = vo.getPatientLocation() == null ? null : new ims.vo.RefVoBean(vo.getPatientLocation().getBoId(), vo.getPatientLocation().getBoVersion());
		this.patientclinic = vo.getPatientClinic() == null ? null : new ims.vo.RefVoBean(vo.getPatientClinic().getBoId(), vo.getPatientClinic().getBoVersion());
		this.additclinnotes = vo.getAdditClinNotes();
		this.sendnumber = vo.getSendNumber();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocs_if.vo.IfOcsOrderShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.orderedby = vo.getOrderedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getOrderedBy().getBean(map);
		this.responsibleclinician = vo.getResponsibleClinician() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleClinician().getBean(map);
		this.responsiblegp = vo.getResponsibleGp() == null ? null : (ims.core.vo.beans.GpLiteVoBean)vo.getResponsibleGp().getBean(map);
		this.patientlocation = vo.getPatientLocation() == null ? null : new ims.vo.RefVoBean(vo.getPatientLocation().getBoId(), vo.getPatientLocation().getBoVersion());
		this.patientclinic = vo.getPatientClinic() == null ? null : new ims.vo.RefVoBean(vo.getPatientClinic().getBoId(), vo.getPatientClinic().getBoVersion());
		this.additclinnotes = vo.getAdditClinNotes();
		this.sendnumber = vo.getSendNumber();
	}

	public ims.ocs_if.vo.IfOcsOrderShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocs_if.vo.IfOcsOrderShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocs_if.vo.IfOcsOrderShortVo vo = null;
		if(map != null)
			vo = (ims.ocs_if.vo.IfOcsOrderShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocs_if.vo.IfOcsOrderShortVo();
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
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getOrderedBy()
	{
		return this.orderedby;
	}
	public void setOrderedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.orderedby = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getResponsibleClinician()
	{
		return this.responsibleclinician;
	}
	public void setResponsibleClinician(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.responsibleclinician = value;
	}
	public ims.core.vo.beans.GpLiteVoBean getResponsibleGp()
	{
		return this.responsiblegp;
	}
	public void setResponsibleGp(ims.core.vo.beans.GpLiteVoBean value)
	{
		this.responsiblegp = value;
	}
	public ims.vo.RefVoBean getPatientLocation()
	{
		return this.patientlocation;
	}
	public void setPatientLocation(ims.vo.RefVoBean value)
	{
		this.patientlocation = value;
	}
	public ims.vo.RefVoBean getPatientClinic()
	{
		return this.patientclinic;
	}
	public void setPatientClinic(ims.vo.RefVoBean value)
	{
		this.patientclinic = value;
	}
	public String getAdditClinNotes()
	{
		return this.additclinnotes;
	}
	public void setAdditClinNotes(String value)
	{
		this.additclinnotes = value;
	}
	public Boolean getSendNumber()
	{
		return this.sendnumber;
	}
	public void setSendNumber(Boolean value)
	{
		this.sendnumber = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean orderedby;
	private ims.core.vo.beans.HcpLiteVoBean responsibleclinician;
	private ims.core.vo.beans.GpLiteVoBean responsiblegp;
	private ims.vo.RefVoBean patientlocation;
	private ims.vo.RefVoBean patientclinic;
	private String additclinnotes;
	private Boolean sendnumber;
}