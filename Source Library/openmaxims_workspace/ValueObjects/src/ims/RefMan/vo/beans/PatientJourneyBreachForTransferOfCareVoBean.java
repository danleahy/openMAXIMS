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

package ims.RefMan.vo.beans;

public class PatientJourneyBreachForTransferOfCareVoBean extends ims.vo.ValueObjectBean
{
	public PatientJourneyBreachForTransferOfCareVoBean()
	{
	}
	public PatientJourneyBreachForTransferOfCareVoBean(ims.RefMan.vo.PatientJourneyBreachForTransferOfCareVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.breachreason = vo.getBreachReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getBreachReason().getBean();
		this.breachreasoncomment = vo.getBreachReasonComment();
		this.breachreasondate = vo.getBreachReasonDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getBreachReasonDate().getBean();
		this.breachreasonrecordingmos = vo.getBreachReasonRecordingMOS() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getBreachReasonRecordingMOS().getBean();
		this.correctioncomments = vo.getCorrectionComments();
		this.correctionauthoringinfo = vo.getCorrectionAuthoringInfo() == null ? null : (ims.core.vo.beans.RecordingUserInformationVoBean)vo.getCorrectionAuthoringInfo().getBean();
		this.corrected = vo.getCorrected();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.PatientJourneyBreachForTransferOfCareVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.breachreason = vo.getBreachReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getBreachReason().getBean();
		this.breachreasoncomment = vo.getBreachReasonComment();
		this.breachreasondate = vo.getBreachReasonDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getBreachReasonDate().getBean();
		this.breachreasonrecordingmos = vo.getBreachReasonRecordingMOS() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getBreachReasonRecordingMOS().getBean(map);
		this.correctioncomments = vo.getCorrectionComments();
		this.correctionauthoringinfo = vo.getCorrectionAuthoringInfo() == null ? null : (ims.core.vo.beans.RecordingUserInformationVoBean)vo.getCorrectionAuthoringInfo().getBean(map);
		this.corrected = vo.getCorrected();
	}

	public ims.RefMan.vo.PatientJourneyBreachForTransferOfCareVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.PatientJourneyBreachForTransferOfCareVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.PatientJourneyBreachForTransferOfCareVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.PatientJourneyBreachForTransferOfCareVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.PatientJourneyBreachForTransferOfCareVo();
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
	public ims.vo.LookupInstanceBean getBreachReason()
	{
		return this.breachreason;
	}
	public void setBreachReason(ims.vo.LookupInstanceBean value)
	{
		this.breachreason = value;
	}
	public String getBreachReasonComment()
	{
		return this.breachreasoncomment;
	}
	public void setBreachReasonComment(String value)
	{
		this.breachreasoncomment = value;
	}
	public ims.framework.utils.beans.DateTimeBean getBreachReasonDate()
	{
		return this.breachreasondate;
	}
	public void setBreachReasonDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.breachreasondate = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getBreachReasonRecordingMOS()
	{
		return this.breachreasonrecordingmos;
	}
	public void setBreachReasonRecordingMOS(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.breachreasonrecordingmos = value;
	}
	public String getCorrectionComments()
	{
		return this.correctioncomments;
	}
	public void setCorrectionComments(String value)
	{
		this.correctioncomments = value;
	}
	public ims.core.vo.beans.RecordingUserInformationVoBean getCorrectionAuthoringInfo()
	{
		return this.correctionauthoringinfo;
	}
	public void setCorrectionAuthoringInfo(ims.core.vo.beans.RecordingUserInformationVoBean value)
	{
		this.correctionauthoringinfo = value;
	}
	public Boolean getCorrected()
	{
		return this.corrected;
	}
	public void setCorrected(Boolean value)
	{
		this.corrected = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean breachreason;
	private String breachreasoncomment;
	private ims.framework.utils.beans.DateTimeBean breachreasondate;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean breachreasonrecordingmos;
	private String correctioncomments;
	private ims.core.vo.beans.RecordingUserInformationVoBean correctionauthoringinfo;
	private Boolean corrected;
}
