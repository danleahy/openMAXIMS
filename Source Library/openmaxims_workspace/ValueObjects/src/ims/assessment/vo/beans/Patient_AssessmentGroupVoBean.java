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

package ims.assessment.vo.beans;

public class Patient_AssessmentGroupVoBean extends ims.vo.ValueObjectBean
{
	public Patient_AssessmentGroupVoBean()
	{
	}
	public Patient_AssessmentGroupVoBean(ims.assessment.vo.Patient_AssessmentGroupVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.assessmentanswers = vo.getAssessmentAnswers() == null ? null : vo.getAssessmentAnswers().getBeanCollection();
		this.assessmentquestiongroup = vo.getAssessmentQuestionGroup() == null ? null : (ims.assessment.vo.beans.Assessment_QuestionGroupVoBean)vo.getAssessmentQuestionGroup().getBean();
		this.currentscore = vo.getCurrentScore();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.Patient_AssessmentGroupVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.assessmentanswers = vo.getAssessmentAnswers() == null ? null : vo.getAssessmentAnswers().getBeanCollection();
		this.assessmentquestiongroup = vo.getAssessmentQuestionGroup() == null ? null : (ims.assessment.vo.beans.Assessment_QuestionGroupVoBean)vo.getAssessmentQuestionGroup().getBean(map);
		this.currentscore = vo.getCurrentScore();
	}

	public ims.assessment.vo.Patient_AssessmentGroupVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.Patient_AssessmentGroupVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.Patient_AssessmentGroupVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.Patient_AssessmentGroupVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.Patient_AssessmentGroupVo();
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
	public ims.assessment.vo.beans.Patient_AssessmentQuestionVoBean[] getAssessmentAnswers()
	{
		return this.assessmentanswers;
	}
	public void setAssessmentAnswers(ims.assessment.vo.beans.Patient_AssessmentQuestionVoBean[] value)
	{
		this.assessmentanswers = value;
	}
	public ims.assessment.vo.beans.Assessment_QuestionGroupVoBean getAssessmentQuestionGroup()
	{
		return this.assessmentquestiongroup;
	}
	public void setAssessmentQuestionGroup(ims.assessment.vo.beans.Assessment_QuestionGroupVoBean value)
	{
		this.assessmentquestiongroup = value;
	}
	public Float getCurrentScore()
	{
		return this.currentscore;
	}
	public void setCurrentScore(Float value)
	{
		this.currentscore = value;
	}

	private Integer id;
	private int version;
	private ims.assessment.vo.beans.Patient_AssessmentQuestionVoBean[] assessmentanswers;
	private ims.assessment.vo.beans.Assessment_QuestionGroupVoBean assessmentquestiongroup;
	private Float currentscore;
}
