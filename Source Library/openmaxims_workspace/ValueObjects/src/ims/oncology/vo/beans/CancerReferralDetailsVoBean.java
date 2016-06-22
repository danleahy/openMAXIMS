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

package ims.oncology.vo.beans;

public class CancerReferralDetailsVoBean extends ims.vo.ValueObjectBean
{
	public CancerReferralDetailsVoBean()
	{
	}
	public CancerReferralDetailsVoBean(ims.oncology.vo.CancerReferralDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.pasreferral = vo.getPASReferral() == null ? null : (ims.core.vo.beans.PASReferralVoBean)vo.getPASReferral().getBean();
		this.assessment = vo.getAssessment() == null ? null : (ims.assessment.vo.beans.PatientAssessmentVoBean)vo.getAssessment().getBean();
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean();
		this.tumourrel = vo.getTumourRel();
		this.firsttherainter = vo.getFirstTheraInter() == null ? null : (ims.vo.LookupInstanceBean)vo.getFirstTheraInter().getBean();
		this.perfstatus = vo.getPerfStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPerfStatus().getBean();
		this.diagnosis = vo.getDiagnosis() == null ? null : (ims.oncology.vo.beans.PatientDiagnosisForPrimaryTumourVoBean)vo.getDiagnosis().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.CancerReferralDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.pasreferral = vo.getPASReferral() == null ? null : (ims.core.vo.beans.PASReferralVoBean)vo.getPASReferral().getBean(map);
		this.assessment = vo.getAssessment() == null ? null : (ims.assessment.vo.beans.PatientAssessmentVoBean)vo.getAssessment().getBean(map);
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean(map);
		this.tumourrel = vo.getTumourRel();
		this.firsttherainter = vo.getFirstTheraInter() == null ? null : (ims.vo.LookupInstanceBean)vo.getFirstTheraInter().getBean();
		this.perfstatus = vo.getPerfStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPerfStatus().getBean();
		this.diagnosis = vo.getDiagnosis() == null ? null : (ims.oncology.vo.beans.PatientDiagnosisForPrimaryTumourVoBean)vo.getDiagnosis().getBean(map);
	}

	public ims.oncology.vo.CancerReferralDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.oncology.vo.CancerReferralDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.CancerReferralDetailsVo vo = null;
		if(map != null)
			vo = (ims.oncology.vo.CancerReferralDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.oncology.vo.CancerReferralDetailsVo();
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
	public ims.vo.RefVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.vo.RefVoBean value)
	{
		this.episodeofcare = value;
	}
	public ims.core.vo.beans.PASReferralVoBean getPASReferral()
	{
		return this.pasreferral;
	}
	public void setPASReferral(ims.core.vo.beans.PASReferralVoBean value)
	{
		this.pasreferral = value;
	}
	public ims.assessment.vo.beans.PatientAssessmentVoBean getAssessment()
	{
		return this.assessment;
	}
	public void setAssessment(ims.assessment.vo.beans.PatientAssessmentVoBean value)
	{
		this.assessment = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInfo()
	{
		return this.authoringinfo;
	}
	public void setAuthoringInfo(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinfo = value;
	}
	public Boolean getTumourRel()
	{
		return this.tumourrel;
	}
	public void setTumourRel(Boolean value)
	{
		this.tumourrel = value;
	}
	public ims.vo.LookupInstanceBean getFirstTheraInter()
	{
		return this.firsttherainter;
	}
	public void setFirstTheraInter(ims.vo.LookupInstanceBean value)
	{
		this.firsttherainter = value;
	}
	public ims.vo.LookupInstanceBean getPerfStatus()
	{
		return this.perfstatus;
	}
	public void setPerfStatus(ims.vo.LookupInstanceBean value)
	{
		this.perfstatus = value;
	}
	public ims.oncology.vo.beans.PatientDiagnosisForPrimaryTumourVoBean getDiagnosis()
	{
		return this.diagnosis;
	}
	public void setDiagnosis(ims.oncology.vo.beans.PatientDiagnosisForPrimaryTumourVoBean value)
	{
		this.diagnosis = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean episodeofcare;
	private ims.core.vo.beans.PASReferralVoBean pasreferral;
	private ims.assessment.vo.beans.PatientAssessmentVoBean assessment;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinfo;
	private Boolean tumourrel;
	private ims.vo.LookupInstanceBean firsttherainter;
	private ims.vo.LookupInstanceBean perfstatus;
	private ims.oncology.vo.beans.PatientDiagnosisForPrimaryTumourVoBean diagnosis;
}
