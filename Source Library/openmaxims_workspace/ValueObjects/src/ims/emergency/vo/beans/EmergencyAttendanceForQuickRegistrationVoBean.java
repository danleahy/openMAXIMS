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

public class EmergencyAttendanceForQuickRegistrationVoBean extends ims.vo.ValueObjectBean
{
	public EmergencyAttendanceForQuickRegistrationVoBean()
	{
	}
	public EmergencyAttendanceForQuickRegistrationVoBean(ims.emergency.vo.EmergencyAttendanceForQuickRegistrationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.arrivaldatetime = vo.getArrivalDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getArrivalDateTime().getBean();
		this.registrationdatetime = vo.getRegistrationDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRegistrationDateTime().getBean();
		this.attendancetype = vo.getAttendanceType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAttendanceType().getBean();
		this.registrationlocation = vo.getRegistrationLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getRegistrationLocation().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.emergencyepisode = vo.getEmergencyEpisode() == null ? null : new ims.vo.RefVoBean(vo.getEmergencyEpisode().getBoId(), vo.getEmergencyEpisode().getBoVersion());
		this.isunknownpatient = vo.getIsUnknownPatient();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episode = vo.getEpisode() == null ? null : new ims.vo.RefVoBean(vo.getEpisode().getBoId(), vo.getEpisode().getBoVersion());
		this.isquickregistration = vo.getIsQuickRegistration();
		this.isexpectedarrival = vo.getIsExpectedArrival();
		this.ismajorincident = vo.getIsMajorIncident();
		this.expectedarrivaldatetime = vo.getExpectedArrivalDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getExpectedArrivalDateTime().getBean();
		this.ageatattendance = vo.getAgeAtAttendance();
		this.registeringmos = vo.getRegisteringMOS() == null ? null : new ims.vo.RefVoBean(vo.getRegisteringMOS().getBoId(), vo.getRegisteringMOS().getBoVersion());
		this.comments = vo.getComments();
		this.customid = vo.getCustomID();
		this.endofregistrationdatetime = vo.getEndOfRegistrationDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEndOfRegistrationDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.EmergencyAttendanceForQuickRegistrationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.arrivaldatetime = vo.getArrivalDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getArrivalDateTime().getBean();
		this.registrationdatetime = vo.getRegistrationDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRegistrationDateTime().getBean();
		this.attendancetype = vo.getAttendanceType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAttendanceType().getBean();
		this.registrationlocation = vo.getRegistrationLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getRegistrationLocation().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.emergencyepisode = vo.getEmergencyEpisode() == null ? null : new ims.vo.RefVoBean(vo.getEmergencyEpisode().getBoId(), vo.getEmergencyEpisode().getBoVersion());
		this.isunknownpatient = vo.getIsUnknownPatient();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episode = vo.getEpisode() == null ? null : new ims.vo.RefVoBean(vo.getEpisode().getBoId(), vo.getEpisode().getBoVersion());
		this.isquickregistration = vo.getIsQuickRegistration();
		this.isexpectedarrival = vo.getIsExpectedArrival();
		this.ismajorincident = vo.getIsMajorIncident();
		this.expectedarrivaldatetime = vo.getExpectedArrivalDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getExpectedArrivalDateTime().getBean();
		this.ageatattendance = vo.getAgeAtAttendance();
		this.registeringmos = vo.getRegisteringMOS() == null ? null : new ims.vo.RefVoBean(vo.getRegisteringMOS().getBoId(), vo.getRegisteringMOS().getBoVersion());
		this.comments = vo.getComments();
		this.customid = vo.getCustomID();
		this.endofregistrationdatetime = vo.getEndOfRegistrationDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEndOfRegistrationDateTime().getBean();
	}

	public ims.emergency.vo.EmergencyAttendanceForQuickRegistrationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.EmergencyAttendanceForQuickRegistrationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.EmergencyAttendanceForQuickRegistrationVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.EmergencyAttendanceForQuickRegistrationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.EmergencyAttendanceForQuickRegistrationVo();
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
	public ims.framework.utils.beans.DateTimeBean getArrivalDateTime()
	{
		return this.arrivaldatetime;
	}
	public void setArrivalDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.arrivaldatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getRegistrationDateTime()
	{
		return this.registrationdatetime;
	}
	public void setRegistrationDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.registrationdatetime = value;
	}
	public ims.vo.LookupInstanceBean getAttendanceType()
	{
		return this.attendancetype;
	}
	public void setAttendanceType(ims.vo.LookupInstanceBean value)
	{
		this.attendancetype = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getRegistrationLocation()
	{
		return this.registrationlocation;
	}
	public void setRegistrationLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.registrationlocation = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.RefVoBean getEmergencyEpisode()
	{
		return this.emergencyepisode;
	}
	public void setEmergencyEpisode(ims.vo.RefVoBean value)
	{
		this.emergencyepisode = value;
	}
	public Boolean getIsUnknownPatient()
	{
		return this.isunknownpatient;
	}
	public void setIsUnknownPatient(Boolean value)
	{
		this.isunknownpatient = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.RefVoBean getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.vo.RefVoBean value)
	{
		this.episode = value;
	}
	public Boolean getIsQuickRegistration()
	{
		return this.isquickregistration;
	}
	public void setIsQuickRegistration(Boolean value)
	{
		this.isquickregistration = value;
	}
	public Boolean getIsExpectedArrival()
	{
		return this.isexpectedarrival;
	}
	public void setIsExpectedArrival(Boolean value)
	{
		this.isexpectedarrival = value;
	}
	public Boolean getIsMajorIncident()
	{
		return this.ismajorincident;
	}
	public void setIsMajorIncident(Boolean value)
	{
		this.ismajorincident = value;
	}
	public ims.framework.utils.beans.DateTimeBean getExpectedArrivalDateTime()
	{
		return this.expectedarrivaldatetime;
	}
	public void setExpectedArrivalDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.expectedarrivaldatetime = value;
	}
	public Integer getAgeAtAttendance()
	{
		return this.ageatattendance;
	}
	public void setAgeAtAttendance(Integer value)
	{
		this.ageatattendance = value;
	}
	public ims.vo.RefVoBean getRegisteringMOS()
	{
		return this.registeringmos;
	}
	public void setRegisteringMOS(ims.vo.RefVoBean value)
	{
		this.registeringmos = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public String getCustomID()
	{
		return this.customid;
	}
	public void setCustomID(String value)
	{
		this.customid = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEndOfRegistrationDateTime()
	{
		return this.endofregistrationdatetime;
	}
	public void setEndOfRegistrationDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.endofregistrationdatetime = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean arrivaldatetime;
	private ims.framework.utils.beans.DateTimeBean registrationdatetime;
	private ims.vo.LookupInstanceBean attendancetype;
	private ims.core.vo.beans.LocationLiteVoBean registrationlocation;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.RefVoBean emergencyepisode;
	private Boolean isunknownpatient;
	private ims.vo.RefVoBean patient;
	private ims.vo.RefVoBean episode;
	private Boolean isquickregistration;
	private Boolean isexpectedarrival;
	private Boolean ismajorincident;
	private ims.framework.utils.beans.DateTimeBean expectedarrivaldatetime;
	private Integer ageatattendance;
	private ims.vo.RefVoBean registeringmos;
	private String comments;
	private String customid;
	private ims.framework.utils.beans.DateTimeBean endofregistrationdatetime;
}
