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

public class PasEventWithReferringGPVoBean extends ims.vo.ValueObjectBean
{
	public PasEventWithReferringGPVoBean()
	{
	}
	public PasEventWithReferringGPVoBean(ims.core.vo.PasEventWithReferringGPVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasepisodeid = vo.getPasEpisodeId();
		this.eventdatetime = vo.getEventDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEventDateTime().getBean();
		this.paseventid = vo.getPasEventId();
		this.consultant = vo.getConsultant() == null ? null : (ims.core.vo.beans.MedicWithMappingsLiteVoBean)vo.getConsultant().getBean();
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getLocation().getBean();
		this.episodefinancialclass = vo.getEpisodeFinancialClass() == null ? null : (ims.vo.LookupInstanceBean)vo.getEpisodeFinancialClass().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean();
		this.sourceofreferral = vo.getSourceOfReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfReferral().getBean();
		this.isvip = vo.getIsVip();
		this.referringgp = vo.getReferringGP() == null ? null : (ims.core.vo.beans.GpLiteVoBean)vo.getReferringGP().getBean();
		this.referringgpsurgery = vo.getReferringGpSurgery() == null ? null : (ims.core.vo.beans.LocSiteShortVoBean)vo.getReferringGpSurgery().getBean();
		this.cspdocumentstatus = vo.getCspDocumentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getCspDocumentStatus().getBean();
		this.passpecialty = vo.getPASSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getPASSpecialty().getBean();
		this.attendinghcp = vo.getAttendingHCP() == null ? null : (ims.core.vo.beans.HcpMinVoBean)vo.getAttendingHCP().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PasEventWithReferringGPVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasepisodeid = vo.getPasEpisodeId();
		this.eventdatetime = vo.getEventDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEventDateTime().getBean();
		this.paseventid = vo.getPasEventId();
		this.consultant = vo.getConsultant() == null ? null : (ims.core.vo.beans.MedicWithMappingsLiteVoBean)vo.getConsultant().getBean(map);
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean(map);
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getLocation().getBean(map);
		this.episodefinancialclass = vo.getEpisodeFinancialClass() == null ? null : (ims.vo.LookupInstanceBean)vo.getEpisodeFinancialClass().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean(map);
		this.sourceofreferral = vo.getSourceOfReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfReferral().getBean();
		this.isvip = vo.getIsVip();
		this.referringgp = vo.getReferringGP() == null ? null : (ims.core.vo.beans.GpLiteVoBean)vo.getReferringGP().getBean(map);
		this.referringgpsurgery = vo.getReferringGpSurgery() == null ? null : (ims.core.vo.beans.LocSiteShortVoBean)vo.getReferringGpSurgery().getBean(map);
		this.cspdocumentstatus = vo.getCspDocumentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getCspDocumentStatus().getBean();
		this.passpecialty = vo.getPASSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getPASSpecialty().getBean();
		this.attendinghcp = vo.getAttendingHCP() == null ? null : (ims.core.vo.beans.HcpMinVoBean)vo.getAttendingHCP().getBean(map);
	}

	public ims.core.vo.PasEventWithReferringGPVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PasEventWithReferringGPVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PasEventWithReferringGPVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PasEventWithReferringGPVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PasEventWithReferringGPVo();
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
	public String getPasEpisodeId()
	{
		return this.pasepisodeid;
	}
	public void setPasEpisodeId(String value)
	{
		this.pasepisodeid = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEventDateTime()
	{
		return this.eventdatetime;
	}
	public void setEventDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.eventdatetime = value;
	}
	public String getPasEventId()
	{
		return this.paseventid;
	}
	public void setPasEventId(String value)
	{
		this.paseventid = value;
	}
	public ims.core.vo.beans.MedicWithMappingsLiteVoBean getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.beans.MedicWithMappingsLiteVoBean value)
	{
		this.consultant = value;
	}
	public ims.vo.LookupInstanceBean getEventType()
	{
		return this.eventtype;
	}
	public void setEventType(ims.vo.LookupInstanceBean value)
	{
		this.eventtype = value;
	}
	public ims.core.vo.beans.PatientShortBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.patient = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.location = value;
	}
	public ims.vo.LookupInstanceBean getEpisodeFinancialClass()
	{
		return this.episodefinancialclass;
	}
	public void setEpisodeFinancialClass(ims.vo.LookupInstanceBean value)
	{
		this.episodefinancialclass = value;
	}
	public ims.core.vo.beans.ServiceLiteVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.service = value;
	}
	public ims.vo.LookupInstanceBean getSourceOfReferral()
	{
		return this.sourceofreferral;
	}
	public void setSourceOfReferral(ims.vo.LookupInstanceBean value)
	{
		this.sourceofreferral = value;
	}
	public Boolean getIsVip()
	{
		return this.isvip;
	}
	public void setIsVip(Boolean value)
	{
		this.isvip = value;
	}
	public ims.core.vo.beans.GpLiteVoBean getReferringGP()
	{
		return this.referringgp;
	}
	public void setReferringGP(ims.core.vo.beans.GpLiteVoBean value)
	{
		this.referringgp = value;
	}
	public ims.core.vo.beans.LocSiteShortVoBean getReferringGpSurgery()
	{
		return this.referringgpsurgery;
	}
	public void setReferringGpSurgery(ims.core.vo.beans.LocSiteShortVoBean value)
	{
		this.referringgpsurgery = value;
	}
	public ims.vo.LookupInstanceBean getCspDocumentStatus()
	{
		return this.cspdocumentstatus;
	}
	public void setCspDocumentStatus(ims.vo.LookupInstanceBean value)
	{
		this.cspdocumentstatus = value;
	}
	public ims.vo.LookupInstanceBean getPASSpecialty()
	{
		return this.passpecialty;
	}
	public void setPASSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.passpecialty = value;
	}
	public ims.core.vo.beans.HcpMinVoBean getAttendingHCP()
	{
		return this.attendinghcp;
	}
	public void setAttendingHCP(ims.core.vo.beans.HcpMinVoBean value)
	{
		this.attendinghcp = value;
	}

	private Integer id;
	private int version;
	private String pasepisodeid;
	private ims.framework.utils.beans.DateTimeBean eventdatetime;
	private String paseventid;
	private ims.core.vo.beans.MedicWithMappingsLiteVoBean consultant;
	private ims.vo.LookupInstanceBean eventtype;
	private ims.core.vo.beans.PatientShortBean patient;
	private ims.vo.LookupInstanceBean specialty;
	private ims.core.vo.beans.LocationLiteVoBean location;
	private ims.vo.LookupInstanceBean episodefinancialclass;
	private ims.core.vo.beans.ServiceLiteVoBean service;
	private ims.vo.LookupInstanceBean sourceofreferral;
	private Boolean isvip;
	private ims.core.vo.beans.GpLiteVoBean referringgp;
	private ims.core.vo.beans.LocSiteShortVoBean referringgpsurgery;
	private ims.vo.LookupInstanceBean cspdocumentstatus;
	private ims.vo.LookupInstanceBean passpecialty;
	private ims.core.vo.beans.HcpMinVoBean attendinghcp;
}
