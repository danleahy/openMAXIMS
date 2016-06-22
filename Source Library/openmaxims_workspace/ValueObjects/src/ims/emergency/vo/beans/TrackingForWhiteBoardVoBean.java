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

public class TrackingForWhiteBoardVoBean extends ims.vo.ValueObjectBean
{
	public TrackingForWhiteBoardVoBean()
	{
	}
	public TrackingForWhiteBoardVoBean(ims.emergency.vo.TrackingForWhiteBoardVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortListVoBean)vo.getPatient().getBean();
		this.attendance = vo.getAttendance() == null ? null : (ims.emergency.vo.beans.EmergencyAttendanceForTrackingVoBean)vo.getAttendance().getBean();
		this.episode = vo.getEpisode() == null ? null : (ims.emergency.vo.beans.EmergencyEpisodeForTrackingVoBean)vo.getEpisode().getBean();
		this.triagedetails = vo.getTriageDetails() == null ? null : (ims.emergency.vo.beans.TriageForTrackingWhiteVoBean)vo.getTriageDetails().getBean();
		this.currentarea = vo.getCurrentArea() == null ? null : (ims.emergency.vo.beans.TrackingAreaShortVoBean)vo.getCurrentArea().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.emergency.vo.beans.TrackingAttendanceStatusVoBean)vo.getCurrentStatus().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.TrackingForWhiteBoardVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortListVoBean)vo.getPatient().getBean(map);
		this.attendance = vo.getAttendance() == null ? null : (ims.emergency.vo.beans.EmergencyAttendanceForTrackingVoBean)vo.getAttendance().getBean(map);
		this.episode = vo.getEpisode() == null ? null : (ims.emergency.vo.beans.EmergencyEpisodeForTrackingVoBean)vo.getEpisode().getBean(map);
		this.triagedetails = vo.getTriageDetails() == null ? null : (ims.emergency.vo.beans.TriageForTrackingWhiteVoBean)vo.getTriageDetails().getBean(map);
		this.currentarea = vo.getCurrentArea() == null ? null : (ims.emergency.vo.beans.TrackingAreaShortVoBean)vo.getCurrentArea().getBean(map);
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.emergency.vo.beans.TrackingAttendanceStatusVoBean)vo.getCurrentStatus().getBean(map);
	}

	public ims.emergency.vo.TrackingForWhiteBoardVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.TrackingForWhiteBoardVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.TrackingForWhiteBoardVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.TrackingForWhiteBoardVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.TrackingForWhiteBoardVo();
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
	public ims.core.vo.beans.PatientShortListVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortListVoBean value)
	{
		this.patient = value;
	}
	public ims.emergency.vo.beans.EmergencyAttendanceForTrackingVoBean getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.emergency.vo.beans.EmergencyAttendanceForTrackingVoBean value)
	{
		this.attendance = value;
	}
	public ims.emergency.vo.beans.EmergencyEpisodeForTrackingVoBean getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.emergency.vo.beans.EmergencyEpisodeForTrackingVoBean value)
	{
		this.episode = value;
	}
	public ims.emergency.vo.beans.TriageForTrackingWhiteVoBean getTriageDetails()
	{
		return this.triagedetails;
	}
	public void setTriageDetails(ims.emergency.vo.beans.TriageForTrackingWhiteVoBean value)
	{
		this.triagedetails = value;
	}
	public ims.emergency.vo.beans.TrackingAreaShortVoBean getCurrentArea()
	{
		return this.currentarea;
	}
	public void setCurrentArea(ims.emergency.vo.beans.TrackingAreaShortVoBean value)
	{
		this.currentarea = value;
	}
	public ims.emergency.vo.beans.TrackingAttendanceStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.emergency.vo.beans.TrackingAttendanceStatusVoBean value)
	{
		this.currentstatus = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PatientShortListVoBean patient;
	private ims.emergency.vo.beans.EmergencyAttendanceForTrackingVoBean attendance;
	private ims.emergency.vo.beans.EmergencyEpisodeForTrackingVoBean episode;
	private ims.emergency.vo.beans.TriageForTrackingWhiteVoBean triagedetails;
	private ims.emergency.vo.beans.TrackingAreaShortVoBean currentarea;
	private ims.emergency.vo.beans.TrackingAttendanceStatusVoBean currentstatus;
}
