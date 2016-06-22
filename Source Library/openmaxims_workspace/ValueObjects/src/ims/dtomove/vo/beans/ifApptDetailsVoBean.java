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

package ims.dtomove.vo.beans;

public class ifApptDetailsVoBean extends ims.vo.ValueObjectBean
{
	public ifApptDetailsVoBean()
	{
	}
	public ifApptDetailsVoBean(ims.dtomove.vo.ifApptDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.apptdate = vo.getApptDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getApptDate().getBean();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientBean)vo.getPatient().getBean();
		this.mos = vo.getMos() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getMos().getBean();
		this.starttime = vo.getStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getStartTime().getBean();
		this.endtime = vo.getEndTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getEndTime().getBean();
		this.priority = vo.getPriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getPriority().getBean();
		this.session = vo.getSession() == null ? null : new ims.vo.RefVoBean(vo.getSession().getBoId(), vo.getSession().getBoVersion());
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.activityname = vo.getActivityName();
		this.apptstart = vo.getApptStart();
		this.apptend = vo.getApptEnd();
		this.profilename = vo.getProfileName();
		this.activitycode = vo.getActivityCode();
		this.locationname = vo.getLocationName();
		this.machinename = vo.getMachineName();
		this.apptstatusstring = vo.getApptStatusString();
		this.activitygroupname = vo.getActivityGroupName();
		this.bookingmos = vo.getBookingMos() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getBookingMos().getBean();
		this.facilityname = vo.getFacilityName();
		this.consultantmos = vo.getConsultantMos() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getConsultantMos().getBean();
		this.patientstatus = vo.getPatientStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientStatus().getBean();
		this.firstapptindicator = vo.getFirstApptIndicator() == null ? null : (ims.vo.LookupInstanceBean)vo.getFirstApptIndicator().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.dtomove.vo.ifApptDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.apptdate = vo.getApptDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getApptDate().getBean();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientBean)vo.getPatient().getBean(map);
		this.mos = vo.getMos() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getMos().getBean(map);
		this.starttime = vo.getStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getStartTime().getBean();
		this.endtime = vo.getEndTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getEndTime().getBean();
		this.priority = vo.getPriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getPriority().getBean();
		this.session = vo.getSession() == null ? null : new ims.vo.RefVoBean(vo.getSession().getBoId(), vo.getSession().getBoVersion());
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.activityname = vo.getActivityName();
		this.apptstart = vo.getApptStart();
		this.apptend = vo.getApptEnd();
		this.profilename = vo.getProfileName();
		this.activitycode = vo.getActivityCode();
		this.locationname = vo.getLocationName();
		this.machinename = vo.getMachineName();
		this.apptstatusstring = vo.getApptStatusString();
		this.activitygroupname = vo.getActivityGroupName();
		this.bookingmos = vo.getBookingMos() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getBookingMos().getBean(map);
		this.facilityname = vo.getFacilityName();
		this.consultantmos = vo.getConsultantMos() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getConsultantMos().getBean(map);
		this.patientstatus = vo.getPatientStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientStatus().getBean();
		this.firstapptindicator = vo.getFirstApptIndicator() == null ? null : (ims.vo.LookupInstanceBean)vo.getFirstApptIndicator().getBean();
	}

	public ims.dtomove.vo.ifApptDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.dtomove.vo.ifApptDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.dtomove.vo.ifApptDetailsVo vo = null;
		if(map != null)
			vo = (ims.dtomove.vo.ifApptDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.dtomove.vo.ifApptDetailsVo();
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
	public ims.framework.utils.beans.DateBean getApptDate()
	{
		return this.apptdate;
	}
	public void setApptDate(ims.framework.utils.beans.DateBean value)
	{
		this.apptdate = value;
	}
	public ims.core.vo.beans.PatientBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.MemberOfStaffShortVoBean getMos()
	{
		return this.mos;
	}
	public void setMos(ims.core.vo.beans.MemberOfStaffShortVoBean value)
	{
		this.mos = value;
	}
	public ims.framework.utils.beans.TimeBean getStartTime()
	{
		return this.starttime;
	}
	public void setStartTime(ims.framework.utils.beans.TimeBean value)
	{
		this.starttime = value;
	}
	public ims.framework.utils.beans.TimeBean getEndTime()
	{
		return this.endtime;
	}
	public void setEndTime(ims.framework.utils.beans.TimeBean value)
	{
		this.endtime = value;
	}
	public ims.vo.LookupInstanceBean getPriority()
	{
		return this.priority;
	}
	public void setPriority(ims.vo.LookupInstanceBean value)
	{
		this.priority = value;
	}
	public ims.vo.RefVoBean getSession()
	{
		return this.session;
	}
	public void setSession(ims.vo.RefVoBean value)
	{
		this.session = value;
	}
	public ims.vo.LookupInstanceBean getApptStatus()
	{
		return this.apptstatus;
	}
	public void setApptStatus(ims.vo.LookupInstanceBean value)
	{
		this.apptstatus = value;
	}
	public String getActivityName()
	{
		return this.activityname;
	}
	public void setActivityName(String value)
	{
		this.activityname = value;
	}
	public String getApptStart()
	{
		return this.apptstart;
	}
	public void setApptStart(String value)
	{
		this.apptstart = value;
	}
	public String getApptEnd()
	{
		return this.apptend;
	}
	public void setApptEnd(String value)
	{
		this.apptend = value;
	}
	public String getProfileName()
	{
		return this.profilename;
	}
	public void setProfileName(String value)
	{
		this.profilename = value;
	}
	public String getActivityCode()
	{
		return this.activitycode;
	}
	public void setActivityCode(String value)
	{
		this.activitycode = value;
	}
	public String getLocationName()
	{
		return this.locationname;
	}
	public void setLocationName(String value)
	{
		this.locationname = value;
	}
	public String getMachineName()
	{
		return this.machinename;
	}
	public void setMachineName(String value)
	{
		this.machinename = value;
	}
	public String getApptStatusString()
	{
		return this.apptstatusstring;
	}
	public void setApptStatusString(String value)
	{
		this.apptstatusstring = value;
	}
	public String getActivityGroupName()
	{
		return this.activitygroupname;
	}
	public void setActivityGroupName(String value)
	{
		this.activitygroupname = value;
	}
	public ims.core.vo.beans.MemberOfStaffShortVoBean getBookingMos()
	{
		return this.bookingmos;
	}
	public void setBookingMos(ims.core.vo.beans.MemberOfStaffShortVoBean value)
	{
		this.bookingmos = value;
	}
	public String getFacilityName()
	{
		return this.facilityname;
	}
	public void setFacilityName(String value)
	{
		this.facilityname = value;
	}
	public ims.core.vo.beans.MemberOfStaffShortVoBean getConsultantMos()
	{
		return this.consultantmos;
	}
	public void setConsultantMos(ims.core.vo.beans.MemberOfStaffShortVoBean value)
	{
		this.consultantmos = value;
	}
	public ims.vo.LookupInstanceBean getPatientStatus()
	{
		return this.patientstatus;
	}
	public void setPatientStatus(ims.vo.LookupInstanceBean value)
	{
		this.patientstatus = value;
	}
	public ims.vo.LookupInstanceBean getFirstApptIndicator()
	{
		return this.firstapptindicator;
	}
	public void setFirstApptIndicator(ims.vo.LookupInstanceBean value)
	{
		this.firstapptindicator = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean apptdate;
	private ims.core.vo.beans.PatientBean patient;
	private ims.core.vo.beans.MemberOfStaffShortVoBean mos;
	private ims.framework.utils.beans.TimeBean starttime;
	private ims.framework.utils.beans.TimeBean endtime;
	private ims.vo.LookupInstanceBean priority;
	private ims.vo.RefVoBean session;
	private ims.vo.LookupInstanceBean apptstatus;
	private String activityname;
	private String apptstart;
	private String apptend;
	private String profilename;
	private String activitycode;
	private String locationname;
	private String machinename;
	private String apptstatusstring;
	private String activitygroupname;
	private ims.core.vo.beans.MemberOfStaffShortVoBean bookingmos;
	private String facilityname;
	private ims.core.vo.beans.MemberOfStaffShortVoBean consultantmos;
	private ims.vo.LookupInstanceBean patientstatus;
	private ims.vo.LookupInstanceBean firstapptindicator;
}
