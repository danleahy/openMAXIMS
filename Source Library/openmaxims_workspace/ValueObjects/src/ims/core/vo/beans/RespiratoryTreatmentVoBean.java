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

public class RespiratoryTreatmentVoBean extends ims.vo.ValueObjectBean
{
	public RespiratoryTreatmentVoBean()
	{
	}
	public RespiratoryTreatmentVoBean(ims.core.vo.RespiratoryTreatmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.soapclinicalcontact = vo.getSOAPClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getSOAPClinicalContact().getBean();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.authoringcp = vo.getAuthoringCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringCP().getBean();
		this.posturaldrainage = vo.getPosturalDrainage() == null ? null : (ims.vo.LookupInstanceBean)vo.getPosturalDrainage().getBean();
		this.assistedcough = vo.getAssistedCough() == null ? null : (ims.vo.LookupInstanceBean)vo.getAssistedCough().getBean();
		this.ippb = vo.getIPPB();
		this.contraindicationchecked = vo.getContraindicationChecked() == null ? null : (ims.vo.LookupInstanceBean)vo.getContraindicationChecked().getBean();
		this.coughassist = vo.getCoughAssist();
		this.treatments = vo.getTreatments() == null ? null : vo.getTreatments().getBeanCollection();
		this.treatmentanalysis = vo.getTreatmentAnalysis();
		this.referoncallphysio = vo.getReferOnCallPhysio() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferOnCallPhysio().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.RespiratoryTreatmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.soapclinicalcontact = vo.getSOAPClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getSOAPClinicalContact().getBean(map);
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.authoringcp = vo.getAuthoringCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringCP().getBean(map);
		this.posturaldrainage = vo.getPosturalDrainage() == null ? null : (ims.vo.LookupInstanceBean)vo.getPosturalDrainage().getBean();
		this.assistedcough = vo.getAssistedCough() == null ? null : (ims.vo.LookupInstanceBean)vo.getAssistedCough().getBean();
		this.ippb = vo.getIPPB();
		this.contraindicationchecked = vo.getContraindicationChecked() == null ? null : (ims.vo.LookupInstanceBean)vo.getContraindicationChecked().getBean();
		this.coughassist = vo.getCoughAssist();
		this.treatments = vo.getTreatments() == null ? null : vo.getTreatments().getBeanCollection();
		this.treatmentanalysis = vo.getTreatmentAnalysis();
		this.referoncallphysio = vo.getReferOnCallPhysio() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferOnCallPhysio().getBean();
	}

	public ims.core.vo.RespiratoryTreatmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.RespiratoryTreatmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.RespiratoryTreatmentVo vo = null;
		if(map != null)
			vo = (ims.core.vo.RespiratoryTreatmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.RespiratoryTreatmentVo();
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
	public ims.core.vo.beans.ClinicalContactShortVoBean getSOAPClinicalContact()
	{
		return this.soapclinicalcontact;
	}
	public void setSOAPClinicalContact(ims.core.vo.beans.ClinicalContactShortVoBean value)
	{
		this.soapclinicalcontact = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}
	public ims.core.vo.beans.HcpBean getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.beans.HcpBean value)
	{
		this.authoringcp = value;
	}
	public ims.vo.LookupInstanceBean getPosturalDrainage()
	{
		return this.posturaldrainage;
	}
	public void setPosturalDrainage(ims.vo.LookupInstanceBean value)
	{
		this.posturaldrainage = value;
	}
	public ims.vo.LookupInstanceBean getAssistedCough()
	{
		return this.assistedcough;
	}
	public void setAssistedCough(ims.vo.LookupInstanceBean value)
	{
		this.assistedcough = value;
	}
	public String getIPPB()
	{
		return this.ippb;
	}
	public void setIPPB(String value)
	{
		this.ippb = value;
	}
	public ims.vo.LookupInstanceBean getContraindicationChecked()
	{
		return this.contraindicationchecked;
	}
	public void setContraindicationChecked(ims.vo.LookupInstanceBean value)
	{
		this.contraindicationchecked = value;
	}
	public String getCoughAssist()
	{
		return this.coughassist;
	}
	public void setCoughAssist(String value)
	{
		this.coughassist = value;
	}
	public ims.core.vo.beans.RespiratoryTreatmentDetailVoBean[] getTreatments()
	{
		return this.treatments;
	}
	public void setTreatments(ims.core.vo.beans.RespiratoryTreatmentDetailVoBean[] value)
	{
		this.treatments = value;
	}
	public String getTreatmentAnalysis()
	{
		return this.treatmentanalysis;
	}
	public void setTreatmentAnalysis(String value)
	{
		this.treatmentanalysis = value;
	}
	public ims.vo.LookupInstanceBean getReferOnCallPhysio()
	{
		return this.referoncallphysio;
	}
	public void setReferOnCallPhysio(ims.vo.LookupInstanceBean value)
	{
		this.referoncallphysio = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.ClinicalContactShortVoBean soapclinicalcontact;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
	private ims.core.vo.beans.HcpBean authoringcp;
	private ims.vo.LookupInstanceBean posturaldrainage;
	private ims.vo.LookupInstanceBean assistedcough;
	private String ippb;
	private ims.vo.LookupInstanceBean contraindicationchecked;
	private String coughassist;
	private ims.core.vo.beans.RespiratoryTreatmentDetailVoBean[] treatments;
	private String treatmentanalysis;
	private ims.vo.LookupInstanceBean referoncallphysio;
}
