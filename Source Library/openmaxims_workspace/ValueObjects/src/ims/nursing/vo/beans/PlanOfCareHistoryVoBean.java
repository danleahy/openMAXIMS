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

package ims.nursing.vo.beans;

public class PlanOfCareHistoryVoBean extends ims.vo.ValueObjectBean
{
	public PlanOfCareHistoryVoBean()
	{
	}
	public PlanOfCareHistoryVoBean(ims.nursing.vo.PlanOfCareHistoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.answertext = vo.getAnswerText();
		this.levelofintervention = vo.getLevelOfIntervention() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getLevelOfIntervention().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.PlanOfCareHistoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.answertext = vo.getAnswerText();
		this.levelofintervention = vo.getLevelOfIntervention() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getLevelOfIntervention().getBean();
	}

	public ims.nursing.vo.PlanOfCareHistoryVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.PlanOfCareHistoryVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.PlanOfCareHistoryVo vo = null;
		if(map != null)
			vo = (ims.nursing.vo.PlanOfCareHistoryVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.PlanOfCareHistoryVo();
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
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public String getAnswerText()
	{
		return this.answertext;
	}
	public void setAnswerText(String value)
	{
		this.answertext = value;
	}
	public ims.framework.utils.beans.ColorBean getLevelOfIntervention()
	{
		return this.levelofintervention;
	}
	public void setLevelOfIntervention(ims.framework.utils.beans.ColorBean value)
	{
		this.levelofintervention = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private String answertext;
	private ims.framework.utils.beans.ColorBean levelofintervention;
}
