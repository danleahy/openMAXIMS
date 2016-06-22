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

public class DrawingGraphicFindingQuestionVoBean extends ims.vo.ValueObjectBean
{
	public DrawingGraphicFindingQuestionVoBean()
	{
	}
	public DrawingGraphicFindingQuestionVoBean(ims.core.vo.DrawingGraphicFindingQuestionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.question = vo.getQuestion() == null ? null : (ims.core.vo.beans.QuestionInformationShortVoBean)vo.getQuestion().getBean();
		this.drawinggraphicfinding = vo.getDrawingGraphicFinding() == null ? null : (ims.core.vo.beans.DrawingGraphicFindingVoBean)vo.getDrawingGraphicFinding().getBean();
		this.order = vo.getOrder();
		this.active = vo.getActive();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.DrawingGraphicFindingQuestionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.question = vo.getQuestion() == null ? null : (ims.core.vo.beans.QuestionInformationShortVoBean)vo.getQuestion().getBean(map);
		this.drawinggraphicfinding = vo.getDrawingGraphicFinding() == null ? null : (ims.core.vo.beans.DrawingGraphicFindingVoBean)vo.getDrawingGraphicFinding().getBean(map);
		this.order = vo.getOrder();
		this.active = vo.getActive();
	}

	public ims.core.vo.DrawingGraphicFindingQuestionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.DrawingGraphicFindingQuestionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.DrawingGraphicFindingQuestionVo vo = null;
		if(map != null)
			vo = (ims.core.vo.DrawingGraphicFindingQuestionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.DrawingGraphicFindingQuestionVo();
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
	public ims.core.vo.beans.QuestionInformationShortVoBean getQuestion()
	{
		return this.question;
	}
	public void setQuestion(ims.core.vo.beans.QuestionInformationShortVoBean value)
	{
		this.question = value;
	}
	public ims.core.vo.beans.DrawingGraphicFindingVoBean getDrawingGraphicFinding()
	{
		return this.drawinggraphicfinding;
	}
	public void setDrawingGraphicFinding(ims.core.vo.beans.DrawingGraphicFindingVoBean value)
	{
		this.drawinggraphicfinding = value;
	}
	public Integer getOrder()
	{
		return this.order;
	}
	public void setOrder(Integer value)
	{
		this.order = value;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.active = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.QuestionInformationShortVoBean question;
	private ims.core.vo.beans.DrawingGraphicFindingVoBean drawinggraphicfinding;
	private Integer order;
	private Boolean active;
}
