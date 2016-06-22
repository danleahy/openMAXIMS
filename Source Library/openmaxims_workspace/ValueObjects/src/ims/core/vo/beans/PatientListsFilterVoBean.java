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

public class PatientListsFilterVoBean extends ims.vo.ValueObjectBean
{
	public PatientListsFilterVoBean()
	{
	}
	public PatientListsFilterVoBean(ims.core.vo.PatientListsFilterVo vo)
	{
		this.consultants = vo.getConsultants() == null ? null : vo.getConsultants().getBeanCollection();
		this.specialties = vo.getSpecialties() == null ? null : vo.getSpecialties().getBeanCollection();
		this.clinics = vo.getClinics() == null ? null : vo.getClinics().getBeanCollection();
		this.date = vo.getDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDate().getBean();
		this.dateend = vo.getDateEnd() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateEnd().getBean();
		this.documentstatus = vo.getDocumentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getDocumentStatus().getBean();
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocShortMappingsVoBean)vo.getWard().getBean();
		this.inpatientsearch = vo.getInPatientSearch();
		this.hospital = vo.getHospital() == null ? null : (ims.core.vo.beans.LocShortMappingsVoBean)vo.getHospital().getBean();
		this.consultant = vo.getConsultant() == null ? null : (ims.core.vo.beans.MedicLiteVoBean)vo.getConsultant().getBean();
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getLocation().getBean();
		this.clinic = vo.getClinic() == null ? null : (ims.core.vo.beans.ClinicLiteVoBean)vo.getClinic().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.clinicdate = vo.getClinicDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getClinicDate().getBean();
		this.dictatedby = vo.getDictatedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getDictatedBy().getBean();
		this.statusofletter = vo.getStatusOfLetter() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatusOfLetter().getBean();
		this.dischargedatefrom = vo.getDischargeDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeDateFrom().getBean();
		this.dischargedateto = vo.getDischargeDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeDateTo().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientListsFilterVo vo)
	{
		this.consultants = vo.getConsultants() == null ? null : vo.getConsultants().getBeanCollection();
		this.specialties = vo.getSpecialties() == null ? null : vo.getSpecialties().getBeanCollection();
		this.clinics = vo.getClinics() == null ? null : vo.getClinics().getBeanCollection();
		this.date = vo.getDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDate().getBean();
		this.dateend = vo.getDateEnd() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateEnd().getBean();
		this.documentstatus = vo.getDocumentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getDocumentStatus().getBean();
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocShortMappingsVoBean)vo.getWard().getBean(map);
		this.inpatientsearch = vo.getInPatientSearch();
		this.hospital = vo.getHospital() == null ? null : (ims.core.vo.beans.LocShortMappingsVoBean)vo.getHospital().getBean(map);
		this.consultant = vo.getConsultant() == null ? null : (ims.core.vo.beans.MedicLiteVoBean)vo.getConsultant().getBean(map);
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getLocation().getBean(map);
		this.clinic = vo.getClinic() == null ? null : (ims.core.vo.beans.ClinicLiteVoBean)vo.getClinic().getBean(map);
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.clinicdate = vo.getClinicDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getClinicDate().getBean();
		this.dictatedby = vo.getDictatedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getDictatedBy().getBean(map);
		this.statusofletter = vo.getStatusOfLetter() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatusOfLetter().getBean();
		this.dischargedatefrom = vo.getDischargeDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeDateFrom().getBean();
		this.dischargedateto = vo.getDischargeDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeDateTo().getBean();
	}

	public ims.core.vo.PatientListsFilterVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientListsFilterVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientListsFilterVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientListsFilterVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientListsFilterVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.correspondence.vo.beans.ConsultantAccessFullVoBean[] getConsultants()
	{
		return this.consultants;
	}
	public void setConsultants(ims.correspondence.vo.beans.ConsultantAccessFullVoBean[] value)
	{
		this.consultants = value;
	}
	public ims.correspondence.vo.beans.SpecialtyAccessVoBean[] getSpecialties()
	{
		return this.specialties;
	}
	public void setSpecialties(ims.correspondence.vo.beans.SpecialtyAccessVoBean[] value)
	{
		this.specialties = value;
	}
	public ims.correspondence.vo.beans.ClinicAccessFullVoBean[] getClinics()
	{
		return this.clinics;
	}
	public void setClinics(ims.correspondence.vo.beans.ClinicAccessFullVoBean[] value)
	{
		this.clinics = value;
	}
	public ims.framework.utils.beans.DateBean getDate()
	{
		return this.date;
	}
	public void setDate(ims.framework.utils.beans.DateBean value)
	{
		this.date = value;
	}
	public ims.framework.utils.beans.DateBean getDateEnd()
	{
		return this.dateend;
	}
	public void setDateEnd(ims.framework.utils.beans.DateBean value)
	{
		this.dateend = value;
	}
	public ims.vo.LookupInstanceBean getDocumentStatus()
	{
		return this.documentstatus;
	}
	public void setDocumentStatus(ims.vo.LookupInstanceBean value)
	{
		this.documentstatus = value;
	}
	public ims.core.vo.beans.LocShortMappingsVoBean getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.beans.LocShortMappingsVoBean value)
	{
		this.ward = value;
	}
	public Boolean getInPatientSearch()
	{
		return this.inpatientsearch;
	}
	public void setInPatientSearch(Boolean value)
	{
		this.inpatientsearch = value;
	}
	public ims.core.vo.beans.LocShortMappingsVoBean getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.core.vo.beans.LocShortMappingsVoBean value)
	{
		this.hospital = value;
	}
	public ims.core.vo.beans.MedicLiteVoBean getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.beans.MedicLiteVoBean value)
	{
		this.consultant = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.location = value;
	}
	public ims.core.vo.beans.ClinicLiteVoBean getClinic()
	{
		return this.clinic;
	}
	public void setClinic(ims.core.vo.beans.ClinicLiteVoBean value)
	{
		this.clinic = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public ims.framework.utils.beans.DateBean getClinicDate()
	{
		return this.clinicdate;
	}
	public void setClinicDate(ims.framework.utils.beans.DateBean value)
	{
		this.clinicdate = value;
	}
	public ims.core.vo.beans.MemberOfStaffShortVoBean getDictatedBy()
	{
		return this.dictatedby;
	}
	public void setDictatedBy(ims.core.vo.beans.MemberOfStaffShortVoBean value)
	{
		this.dictatedby = value;
	}
	public ims.vo.LookupInstanceBean getStatusOfLetter()
	{
		return this.statusofletter;
	}
	public void setStatusOfLetter(ims.vo.LookupInstanceBean value)
	{
		this.statusofletter = value;
	}
	public ims.framework.utils.beans.DateBean getDischargeDateFrom()
	{
		return this.dischargedatefrom;
	}
	public void setDischargeDateFrom(ims.framework.utils.beans.DateBean value)
	{
		this.dischargedatefrom = value;
	}
	public ims.framework.utils.beans.DateBean getDischargeDateTo()
	{
		return this.dischargedateto;
	}
	public void setDischargeDateTo(ims.framework.utils.beans.DateBean value)
	{
		this.dischargedateto = value;
	}

	private ims.correspondence.vo.beans.ConsultantAccessFullVoBean[] consultants;
	private ims.correspondence.vo.beans.SpecialtyAccessVoBean[] specialties;
	private ims.correspondence.vo.beans.ClinicAccessFullVoBean[] clinics;
	private ims.framework.utils.beans.DateBean date;
	private ims.framework.utils.beans.DateBean dateend;
	private ims.vo.LookupInstanceBean documentstatus;
	private ims.core.vo.beans.LocShortMappingsVoBean ward;
	private Boolean inpatientsearch;
	private ims.core.vo.beans.LocShortMappingsVoBean hospital;
	private ims.core.vo.beans.MedicLiteVoBean consultant;
	private ims.core.vo.beans.LocationLiteVoBean location;
	private ims.core.vo.beans.ClinicLiteVoBean clinic;
	private ims.vo.LookupInstanceBean specialty;
	private ims.framework.utils.beans.DateBean clinicdate;
	private ims.core.vo.beans.MemberOfStaffShortVoBean dictatedby;
	private ims.vo.LookupInstanceBean statusofletter;
	private ims.framework.utils.beans.DateBean dischargedatefrom;
	private ims.framework.utils.beans.DateBean dischargedateto;
}
