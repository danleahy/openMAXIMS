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

public class PatientEWSVoBean extends ims.vo.ValueObjectBean
{
	public PatientEWSVoBean()
	{
	}
	public PatientEWSVoBean(ims.core.vo.PatientEWSVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.vitalsign = vo.getVitalSign() == null ? null : new ims.vo.RefVoBean(vo.getVitalSign().getBoId(), vo.getVitalSign().getBoVersion());
		this.patientassessment = vo.getPatientAssessment() == null ? null : (ims.assessment.vo.beans.PatientAssessmentVoBean)vo.getPatientAssessment().getBean();
		this.secsscore = vo.getSECSScore();
		this.scoredetails = vo.getScoreDetails();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientEWSVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.vitalsign = vo.getVitalSign() == null ? null : new ims.vo.RefVoBean(vo.getVitalSign().getBoId(), vo.getVitalSign().getBoVersion());
		this.patientassessment = vo.getPatientAssessment() == null ? null : (ims.assessment.vo.beans.PatientAssessmentVoBean)vo.getPatientAssessment().getBean(map);
		this.secsscore = vo.getSECSScore();
		this.scoredetails = vo.getScoreDetails();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
	}

	public ims.core.vo.PatientEWSVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientEWSVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientEWSVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientEWSVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientEWSVo();
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
	public ims.vo.RefVoBean getVitalSign()
	{
		return this.vitalsign;
	}
	public void setVitalSign(ims.vo.RefVoBean value)
	{
		this.vitalsign = value;
	}
	public ims.assessment.vo.beans.PatientAssessmentVoBean getPatientAssessment()
	{
		return this.patientassessment;
	}
	public void setPatientAssessment(ims.assessment.vo.beans.PatientAssessmentVoBean value)
	{
		this.patientassessment = value;
	}
	public Integer getSECSScore()
	{
		return this.secsscore;
	}
	public void setSECSScore(Integer value)
	{
		this.secsscore = value;
	}
	public String getScoreDetails()
	{
		return this.scoredetails;
	}
	public void setScoreDetails(String value)
	{
		this.scoredetails = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean vitalsign;
	private ims.assessment.vo.beans.PatientAssessmentVoBean patientassessment;
	private Integer secsscore;
	private String scoredetails;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.SysInfoBean sysinfo;
}
