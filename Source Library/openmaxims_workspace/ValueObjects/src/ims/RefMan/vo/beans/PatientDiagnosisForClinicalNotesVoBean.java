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

public class PatientDiagnosisForClinicalNotesVoBean extends ims.vo.ValueObjectBean
{
	public PatientDiagnosisForClinicalNotesVoBean()
	{
	}
	public PatientDiagnosisForClinicalNotesVoBean(ims.RefMan.vo.PatientDiagnosisForClinicalNotesVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.diagnosis = vo.getDiagnosis() == null ? null : (ims.core.vo.beans.DiagLiteVoBean)vo.getDiagnosis().getBean();
		this.diagnosisdescription = vo.getDiagnosisDescription();
		this.sourceofinformation = vo.getSourceofInformation() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceofInformation().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean();
		this.primaryforcarespells = vo.getPrimaryForCareSpells() == null ? null : vo.getPrimaryForCareSpells().getBeanCollection();
		this.diagnoseddate = vo.getDiagnosedDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDiagnosedDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.PatientDiagnosisForClinicalNotesVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.diagnosis = vo.getDiagnosis() == null ? null : (ims.core.vo.beans.DiagLiteVoBean)vo.getDiagnosis().getBean(map);
		this.diagnosisdescription = vo.getDiagnosisDescription();
		this.sourceofinformation = vo.getSourceofInformation() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceofInformation().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.authoringinfo = vo.getAuthoringInfo() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInfo().getBean(map);
		this.primaryforcarespells = vo.getPrimaryForCareSpells() == null ? null : vo.getPrimaryForCareSpells().getBeanCollection();
		this.diagnoseddate = vo.getDiagnosedDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDiagnosedDate().getBean();
	}

	public ims.RefMan.vo.PatientDiagnosisForClinicalNotesVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.PatientDiagnosisForClinicalNotesVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.PatientDiagnosisForClinicalNotesVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.PatientDiagnosisForClinicalNotesVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.PatientDiagnosisForClinicalNotesVo();
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
	public ims.core.vo.beans.DiagLiteVoBean getDiagnosis()
	{
		return this.diagnosis;
	}
	public void setDiagnosis(ims.core.vo.beans.DiagLiteVoBean value)
	{
		this.diagnosis = value;
	}
	public String getDiagnosisDescription()
	{
		return this.diagnosisdescription;
	}
	public void setDiagnosisDescription(String value)
	{
		this.diagnosisdescription = value;
	}
	public ims.vo.LookupInstanceBean getSourceofInformation()
	{
		return this.sourceofinformation;
	}
	public void setSourceofInformation(ims.vo.LookupInstanceBean value)
	{
		this.sourceofinformation = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.RefVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.vo.RefVoBean value)
	{
		this.episodeofcare = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInfo()
	{
		return this.authoringinfo;
	}
	public void setAuthoringInfo(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinfo = value;
	}
	public ims.RefMan.vo.beans.CSPrimaryDiagnosisForClinicalNotesVoBean[] getPrimaryForCareSpells()
	{
		return this.primaryforcarespells;
	}
	public void setPrimaryForCareSpells(ims.RefMan.vo.beans.CSPrimaryDiagnosisForClinicalNotesVoBean[] value)
	{
		this.primaryforcarespells = value;
	}
	public ims.framework.utils.beans.PartialDateBean getDiagnosedDate()
	{
		return this.diagnoseddate;
	}
	public void setDiagnosedDate(ims.framework.utils.beans.PartialDateBean value)
	{
		this.diagnoseddate = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.DiagLiteVoBean diagnosis;
	private String diagnosisdescription;
	private ims.vo.LookupInstanceBean sourceofinformation;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.RefVoBean episodeofcare;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinfo;
	private ims.RefMan.vo.beans.CSPrimaryDiagnosisForClinicalNotesVoBean[] primaryforcarespells;
	private ims.framework.utils.beans.PartialDateBean diagnoseddate;
}
