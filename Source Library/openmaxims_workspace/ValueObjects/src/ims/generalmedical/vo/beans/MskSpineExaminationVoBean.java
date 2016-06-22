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

package ims.generalmedical.vo.beans;

public class MskSpineExaminationVoBean extends ims.vo.ValueObjectBean
{
	public MskSpineExaminationVoBean()
	{
	}
	public MskSpineExaminationVoBean(ims.generalmedical.vo.MskSpineExaminationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.spinemovements = vo.getSpineMovements();
		this.examinationfindings = vo.getExaminationFindings() == null ? null : vo.getExaminationFindings().getBeanCollection();
		this.imageversion = vo.getImageVersion() == null ? null : (ims.core.vo.beans.DrawingImageVersionVoBean)vo.getImageVersion().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean();
		this.authoringcp = vo.getAuthoringCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAuthoringCP().getBean();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.MskSpineExaminationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.spinemovements = vo.getSpineMovements();
		this.examinationfindings = vo.getExaminationFindings() == null ? null : vo.getExaminationFindings().getBeanCollection();
		this.imageversion = vo.getImageVersion() == null ? null : (ims.core.vo.beans.DrawingImageVersionVoBean)vo.getImageVersion().getBean(map);
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean(map);
		this.authoringcp = vo.getAuthoringCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAuthoringCP().getBean(map);
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean(map);
	}

	public ims.generalmedical.vo.MskSpineExaminationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.generalmedical.vo.MskSpineExaminationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.MskSpineExaminationVo vo = null;
		if(map != null)
			vo = (ims.generalmedical.vo.MskSpineExaminationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.generalmedical.vo.MskSpineExaminationVo();
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
	public String getSpineMovements()
	{
		return this.spinemovements;
	}
	public void setSpineMovements(String value)
	{
		this.spinemovements = value;
	}
	public ims.generalmedical.vo.beans.MskSpineExamFindingVoBean[] getExaminationFindings()
	{
		return this.examinationfindings;
	}
	public void setExaminationFindings(ims.generalmedical.vo.beans.MskSpineExamFindingVoBean[] value)
	{
		this.examinationfindings = value;
	}
	public ims.core.vo.beans.DrawingImageVersionVoBean getImageVersion()
	{
		return this.imageversion;
	}
	public void setImageVersion(ims.core.vo.beans.DrawingImageVersionVoBean value)
	{
		this.imageversion = value;
	}
	public ims.core.vo.beans.ClinicalContactShortVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.beans.ClinicalContactShortVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.authoringcp = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}
	public ims.core.vo.beans.CareContextShortVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextShortVoBean value)
	{
		this.carecontext = value;
	}

	private Integer id;
	private int version;
	private String spinemovements;
	private ims.generalmedical.vo.beans.MskSpineExamFindingVoBean[] examinationfindings;
	private ims.core.vo.beans.DrawingImageVersionVoBean imageversion;
	private ims.core.vo.beans.ClinicalContactShortVoBean clinicalcontact;
	private ims.core.vo.beans.HcpLiteVoBean authoringcp;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
	private ims.core.vo.beans.CareContextShortVoBean carecontext;
}
