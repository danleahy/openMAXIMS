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

public class PatientDiagnosisLiteVoBean extends ims.vo.ValueObjectBean
{
	public PatientDiagnosisLiteVoBean()
	{
	}
	public PatientDiagnosisLiteVoBean(ims.core.vo.PatientDiagnosisLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.diagnosisdescription = vo.getDiagnosisDescription();
		this.diagnoseddate = vo.getDiagnosedDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDiagnosedDate().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.clinical.vo.beans.PatientDiagnosisStatusVoBean)vo.getCurrentStatus().getBean();
		this.sourceofinformation = vo.getSourceofInformation() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceofInformation().getBean();
		this.diagnosis = vo.getDiagnosis() == null ? null : (ims.core.vo.beans.DiagLiteVoBean)vo.getDiagnosis().getBean();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextLiteVoBean)vo.getCareContext().getBean();
		this.iscomorbidity = vo.getIsComorbidity();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.diagnosedonadmission = vo.getDiagnosedOnAdmission();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientDiagnosisLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.diagnosisdescription = vo.getDiagnosisDescription();
		this.diagnoseddate = vo.getDiagnosedDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDiagnosedDate().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.clinical.vo.beans.PatientDiagnosisStatusVoBean)vo.getCurrentStatus().getBean(map);
		this.sourceofinformation = vo.getSourceofInformation() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceofInformation().getBean();
		this.diagnosis = vo.getDiagnosis() == null ? null : (ims.core.vo.beans.DiagLiteVoBean)vo.getDiagnosis().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextLiteVoBean)vo.getCareContext().getBean(map);
		this.iscomorbidity = vo.getIsComorbidity();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.diagnosedonadmission = vo.getDiagnosedOnAdmission();
	}

	public ims.core.vo.PatientDiagnosisLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientDiagnosisLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientDiagnosisLiteVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientDiagnosisLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientDiagnosisLiteVo();
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
	public String getDiagnosisDescription()
	{
		return this.diagnosisdescription;
	}
	public void setDiagnosisDescription(String value)
	{
		this.diagnosisdescription = value;
	}
	public ims.framework.utils.beans.PartialDateBean getDiagnosedDate()
	{
		return this.diagnoseddate;
	}
	public void setDiagnosedDate(ims.framework.utils.beans.PartialDateBean value)
	{
		this.diagnoseddate = value;
	}
	public ims.clinical.vo.beans.PatientDiagnosisStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.clinical.vo.beans.PatientDiagnosisStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.vo.LookupInstanceBean getSourceofInformation()
	{
		return this.sourceofinformation;
	}
	public void setSourceofInformation(ims.vo.LookupInstanceBean value)
	{
		this.sourceofinformation = value;
	}
	public ims.core.vo.beans.DiagLiteVoBean getDiagnosis()
	{
		return this.diagnosis;
	}
	public void setDiagnosis(ims.core.vo.beans.DiagLiteVoBean value)
	{
		this.diagnosis = value;
	}
	public ims.core.vo.beans.CareContextLiteVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextLiteVoBean value)
	{
		this.carecontext = value;
	}
	public Boolean getIsComorbidity()
	{
		return this.iscomorbidity;
	}
	public void setIsComorbidity(Boolean value)
	{
		this.iscomorbidity = value;
	}
	public ims.vo.RefVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.vo.RefVoBean value)
	{
		this.episodeofcare = value;
	}
	public Boolean getDiagnosedOnAdmission()
	{
		return this.diagnosedonadmission;
	}
	public void setDiagnosedOnAdmission(Boolean value)
	{
		this.diagnosedonadmission = value;
	}

	private Integer id;
	private int version;
	private String diagnosisdescription;
	private ims.framework.utils.beans.PartialDateBean diagnoseddate;
	private ims.clinical.vo.beans.PatientDiagnosisStatusVoBean currentstatus;
	private ims.vo.LookupInstanceBean sourceofinformation;
	private ims.core.vo.beans.DiagLiteVoBean diagnosis;
	private ims.core.vo.beans.CareContextLiteVoBean carecontext;
	private Boolean iscomorbidity;
	private ims.vo.RefVoBean episodeofcare;
	private Boolean diagnosedonadmission;
}
