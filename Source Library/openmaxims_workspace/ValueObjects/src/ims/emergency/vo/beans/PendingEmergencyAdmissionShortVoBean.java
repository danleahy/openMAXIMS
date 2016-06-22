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

package ims.emergency.vo.beans;

public class PendingEmergencyAdmissionShortVoBean extends ims.vo.ValueObjectBean
{
	public PendingEmergencyAdmissionShortVoBean()
	{
	}
	public PendingEmergencyAdmissionShortVoBean(ims.emergency.vo.PendingEmergencyAdmissionShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventForPendingEmergencyAdmissionShortVoBean)vo.getPasEvent().getBean();
		this.admissionstatus = vo.getAdmissionStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdmissionStatus().getBean();
		this.dtadatetime = vo.getDTADateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDTADateTime().getBean();
		this.admissiontype = vo.getAdmissionType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdmissionType().getBean();
		this.currentlocation = vo.getCurrentLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getCurrentLocation().getBean();
		this.bedtyperequested = vo.getBedTypeRequested() == null ? null : (ims.vo.LookupInstanceBean)vo.getBedTypeRequested().getBean();
		this.allocatedward = vo.getAllocatedWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getAllocatedWard().getBean();
		this.comments = vo.getComments();
		this.hospital = vo.getHospital() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getHospital().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.PendingEmergencyAdmissionShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventForPendingEmergencyAdmissionShortVoBean)vo.getPasEvent().getBean(map);
		this.admissionstatus = vo.getAdmissionStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdmissionStatus().getBean();
		this.dtadatetime = vo.getDTADateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDTADateTime().getBean();
		this.admissiontype = vo.getAdmissionType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdmissionType().getBean();
		this.currentlocation = vo.getCurrentLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getCurrentLocation().getBean(map);
		this.bedtyperequested = vo.getBedTypeRequested() == null ? null : (ims.vo.LookupInstanceBean)vo.getBedTypeRequested().getBean();
		this.allocatedward = vo.getAllocatedWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getAllocatedWard().getBean(map);
		this.comments = vo.getComments();
		this.hospital = vo.getHospital() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getHospital().getBean(map);
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean(map);
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
	}

	public ims.emergency.vo.PendingEmergencyAdmissionShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.PendingEmergencyAdmissionShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.PendingEmergencyAdmissionShortVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.PendingEmergencyAdmissionShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.PendingEmergencyAdmissionShortVo();
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
	public ims.core.vo.beans.PasEventForPendingEmergencyAdmissionShortVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.beans.PasEventForPendingEmergencyAdmissionShortVoBean value)
	{
		this.pasevent = value;
	}
	public ims.vo.LookupInstanceBean getAdmissionStatus()
	{
		return this.admissionstatus;
	}
	public void setAdmissionStatus(ims.vo.LookupInstanceBean value)
	{
		this.admissionstatus = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDTADateTime()
	{
		return this.dtadatetime;
	}
	public void setDTADateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.dtadatetime = value;
	}
	public ims.vo.LookupInstanceBean getAdmissionType()
	{
		return this.admissiontype;
	}
	public void setAdmissionType(ims.vo.LookupInstanceBean value)
	{
		this.admissiontype = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getCurrentLocation()
	{
		return this.currentlocation;
	}
	public void setCurrentLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.currentlocation = value;
	}
	public ims.vo.LookupInstanceBean getBedTypeRequested()
	{
		return this.bedtyperequested;
	}
	public void setBedTypeRequested(ims.vo.LookupInstanceBean value)
	{
		this.bedtyperequested = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getAllocatedWard()
	{
		return this.allocatedward;
	}
	public void setAllocatedWard(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.allocatedward = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.hospital = value;
	}
	public ims.core.vo.beans.ServiceLiteVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.service = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PasEventForPendingEmergencyAdmissionShortVoBean pasevent;
	private ims.vo.LookupInstanceBean admissionstatus;
	private ims.framework.utils.beans.DateTimeBean dtadatetime;
	private ims.vo.LookupInstanceBean admissiontype;
	private ims.core.vo.beans.LocationLiteVoBean currentlocation;
	private ims.vo.LookupInstanceBean bedtyperequested;
	private ims.core.vo.beans.LocationLiteVoBean allocatedward;
	private String comments;
	private ims.core.vo.beans.LocationLiteVoBean hospital;
	private ims.core.vo.beans.ServiceLiteVoBean service;
	private ims.vo.LookupInstanceBean specialty;
}
