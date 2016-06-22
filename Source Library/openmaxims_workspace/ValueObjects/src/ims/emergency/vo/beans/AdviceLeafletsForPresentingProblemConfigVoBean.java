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

public class AdviceLeafletsForPresentingProblemConfigVoBean extends ims.vo.ValueObjectBean
{
	public AdviceLeafletsForPresentingProblemConfigVoBean()
	{
	}
	public AdviceLeafletsForPresentingProblemConfigVoBean(ims.emergency.vo.AdviceLeafletsForPresentingProblemConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.template = vo.getTemplate() == null ? null : (ims.core.vo.beans.TemplateForReportTemplateSearchVoBean)vo.getTemplate().getBean();
		this.problems = vo.getProblems() == null ? null : vo.getProblems().getBeanCollection();
		this.isgenericadviceleaflet = vo.getIsGenericAdviceLeaflet();
		this.adviceleafletname = vo.getAdviceLeafletName();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.AdviceLeafletsForPresentingProblemConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.template = vo.getTemplate() == null ? null : (ims.core.vo.beans.TemplateForReportTemplateSearchVoBean)vo.getTemplate().getBean(map);
		this.problems = vo.getProblems() == null ? null : vo.getProblems().getBeanCollection();
		this.isgenericadviceleaflet = vo.getIsGenericAdviceLeaflet();
		this.adviceleafletname = vo.getAdviceLeafletName();
	}

	public ims.emergency.vo.AdviceLeafletsForPresentingProblemConfigVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.AdviceLeafletsForPresentingProblemConfigVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.AdviceLeafletsForPresentingProblemConfigVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.AdviceLeafletsForPresentingProblemConfigVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.AdviceLeafletsForPresentingProblemConfigVo();
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
	public ims.core.vo.beans.TemplateForReportTemplateSearchVoBean getTemplate()
	{
		return this.template;
	}
	public void setTemplate(ims.core.vo.beans.TemplateForReportTemplateSearchVoBean value)
	{
		this.template = value;
	}
	public ims.clinical.vo.beans.ClinicalProblemShortVoBean[] getProblems()
	{
		return this.problems;
	}
	public void setProblems(ims.clinical.vo.beans.ClinicalProblemShortVoBean[] value)
	{
		this.problems = value;
	}
	public Boolean getIsGenericAdviceLeaflet()
	{
		return this.isgenericadviceleaflet;
	}
	public void setIsGenericAdviceLeaflet(Boolean value)
	{
		this.isgenericadviceleaflet = value;
	}
	public String getAdviceLeafletName()
	{
		return this.adviceleafletname;
	}
	public void setAdviceLeafletName(String value)
	{
		this.adviceleafletname = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.TemplateForReportTemplateSearchVoBean template;
	private ims.clinical.vo.beans.ClinicalProblemShortVoBean[] problems;
	private Boolean isgenericadviceleaflet;
	private String adviceleafletname;
}
