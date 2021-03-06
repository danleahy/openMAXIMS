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

package ims.clinical.vo.beans;

public class PatientPMHChecklistVoBean extends ims.vo.ValueObjectBean
{
	public PatientPMHChecklistVoBean()
	{
	}
	public PatientPMHChecklistVoBean(ims.clinical.vo.PatientPMHChecklistVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean();
		this.pmhinfotext = vo.getPMHInfoText();
		this.prescomplaint = vo.getPresComplaint();
		this.positivediagnosis = vo.getPositiveDiagnosis() == null ? null : vo.getPositiveDiagnosis().getBeanCollection();
		this.positiveprocedure = vo.getPositiveProcedure() == null ? null : vo.getPositiveProcedure().getBeanCollection();
		this.otherdiagnosis = vo.getOtherDiagnosis() == null ? null : vo.getOtherDiagnosis().getBeanCollection();
		this.otherprocedure = vo.getOtherProcedure() == null ? null : vo.getOtherProcedure().getBeanCollection();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.PatientPMHChecklistVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean(map);
		this.pmhinfotext = vo.getPMHInfoText();
		this.prescomplaint = vo.getPresComplaint();
		this.positivediagnosis = vo.getPositiveDiagnosis() == null ? null : vo.getPositiveDiagnosis().getBeanCollection();
		this.positiveprocedure = vo.getPositiveProcedure() == null ? null : vo.getPositiveProcedure().getBeanCollection();
		this.otherdiagnosis = vo.getOtherDiagnosis() == null ? null : vo.getOtherDiagnosis().getBeanCollection();
		this.otherprocedure = vo.getOtherProcedure() == null ? null : vo.getOtherProcedure().getBeanCollection();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public ims.clinical.vo.PatientPMHChecklistVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.PatientPMHChecklistVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.PatientPMHChecklistVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.PatientPMHChecklistVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.PatientPMHChecklistVo();
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
	public ims.core.vo.beans.ClinicalContactShortVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.beans.ClinicalContactShortVoBean value)
	{
		this.clinicalcontact = value;
	}
	public String getPMHInfoText()
	{
		return this.pmhinfotext;
	}
	public void setPMHInfoText(String value)
	{
		this.pmhinfotext = value;
	}
	public String getPresComplaint()
	{
		return this.prescomplaint;
	}
	public void setPresComplaint(String value)
	{
		this.prescomplaint = value;
	}
	public ims.core.vo.beans.PatientDiagnosisVoBean[] getPositiveDiagnosis()
	{
		return this.positivediagnosis;
	}
	public void setPositiveDiagnosis(ims.core.vo.beans.PatientDiagnosisVoBean[] value)
	{
		this.positivediagnosis = value;
	}
	public ims.core.vo.beans.PatientProcedureShortVoBean[] getPositiveProcedure()
	{
		return this.positiveprocedure;
	}
	public void setPositiveProcedure(ims.core.vo.beans.PatientProcedureShortVoBean[] value)
	{
		this.positiveprocedure = value;
	}
	public ims.clinical.vo.beans.PatientPMHChecklistDiagnosisVoBean[] getOtherDiagnosis()
	{
		return this.otherdiagnosis;
	}
	public void setOtherDiagnosis(ims.clinical.vo.beans.PatientPMHChecklistDiagnosisVoBean[] value)
	{
		this.otherdiagnosis = value;
	}
	public ims.clinical.vo.beans.PatientPMHChecklistProcedureVoBean[] getOtherProcedure()
	{
		return this.otherprocedure;
	}
	public void setOtherProcedure(ims.clinical.vo.beans.PatientPMHChecklistProcedureVoBean[] value)
	{
		this.otherprocedure = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.ClinicalContactShortVoBean clinicalcontact;
	private String pmhinfotext;
	private String prescomplaint;
	private ims.core.vo.beans.PatientDiagnosisVoBean[] positivediagnosis;
	private ims.core.vo.beans.PatientProcedureShortVoBean[] positiveprocedure;
	private ims.clinical.vo.beans.PatientPMHChecklistDiagnosisVoBean[] otherdiagnosis;
	private ims.clinical.vo.beans.PatientPMHChecklistProcedureVoBean[] otherprocedure;
	private ims.vo.RefVoBean carecontext;
}
