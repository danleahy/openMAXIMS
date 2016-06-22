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

public class GraphicAssessmentVoBean extends ims.vo.ValueObjectBean
{
	public GraphicAssessmentVoBean()
	{
	}
	public GraphicAssessmentVoBean(ims.assessment.vo.GraphicAssessmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.assessmenttype = vo.getAssessmentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAssessmentType().getBean();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.helpurl = vo.getHelpUrl();
		this.storeprintedreport = vo.getStorePrintedReport();
		this.assessmentspecialties = vo.getAssessmentSpecialties() == null ? null : vo.getAssessmentSpecialties().getBeanCollection();
		this.associatedreportforprinting = vo.getAssociatedReportForPrinting() == null ? null : new ims.vo.RefVoBean(vo.getAssociatedReportForPrinting().getBoId(), vo.getAssociatedReportForPrinting().getBoVersion());
		this.images = vo.getImages() == null ? null : vo.getImages().getBeanCollection();
		this.findingsandquestions = vo.getFindingsAndQuestions() == null ? null : vo.getFindingsAndQuestions().getBeanCollection();
		this.associatedquestions = vo.getAssociatedQuestions() == null ? null : vo.getAssociatedQuestions().getBeanCollection();
		this.assessmentstage = vo.getAssessmentStage() == null ? null : vo.getAssessmentStage().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.GraphicAssessmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.assessmenttype = vo.getAssessmentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAssessmentType().getBean();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.helpurl = vo.getHelpUrl();
		this.storeprintedreport = vo.getStorePrintedReport();
		this.assessmentspecialties = vo.getAssessmentSpecialties() == null ? null : vo.getAssessmentSpecialties().getBeanCollection();
		this.associatedreportforprinting = vo.getAssociatedReportForPrinting() == null ? null : new ims.vo.RefVoBean(vo.getAssociatedReportForPrinting().getBoId(), vo.getAssociatedReportForPrinting().getBoVersion());
		this.images = vo.getImages() == null ? null : vo.getImages().getBeanCollection();
		this.findingsandquestions = vo.getFindingsAndQuestions() == null ? null : vo.getFindingsAndQuestions().getBeanCollection();
		this.associatedquestions = vo.getAssociatedQuestions() == null ? null : vo.getAssociatedQuestions().getBeanCollection();
		this.assessmentstage = vo.getAssessmentStage() == null ? null : vo.getAssessmentStage().getBeanCollection();
	}

	public ims.assessment.vo.GraphicAssessmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.GraphicAssessmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.GraphicAssessmentVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.GraphicAssessmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.GraphicAssessmentVo();
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
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public ims.vo.LookupInstanceBean getAssessmentType()
	{
		return this.assessmenttype;
	}
	public void setAssessmentType(ims.vo.LookupInstanceBean value)
	{
		this.assessmenttype = value;
	}
	public ims.vo.LookupInstanceBean getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.vo.LookupInstanceBean value)
	{
		this.activestatus = value;
	}
	public String getHelpUrl()
	{
		return this.helpurl;
	}
	public void setHelpUrl(String value)
	{
		this.helpurl = value;
	}
	public Boolean getStorePrintedReport()
	{
		return this.storeprintedreport;
	}
	public void setStorePrintedReport(Boolean value)
	{
		this.storeprintedreport = value;
	}
	public java.util.Collection getAssessmentSpecialties()
	{
		return this.assessmentspecialties;
	}
	public void setAssessmentSpecialties(java.util.Collection value)
	{
		this.assessmentspecialties = value;
	}
	public void addAssessmentSpecialties(java.util.Collection value)
	{
		if(this.assessmentspecialties == null)
			this.assessmentspecialties = new java.util.ArrayList();
		this.assessmentspecialties.add(value);
	}
	public ims.vo.RefVoBean getAssociatedReportForPrinting()
	{
		return this.associatedreportforprinting;
	}
	public void setAssociatedReportForPrinting(ims.vo.RefVoBean value)
	{
		this.associatedreportforprinting = value;
	}
	public ims.core.vo.beans.DrawingGraphicImageVoBean[] getImages()
	{
		return this.images;
	}
	public void setImages(ims.core.vo.beans.DrawingGraphicImageVoBean[] value)
	{
		this.images = value;
	}
	public ims.assessment.vo.beans.GraphicAssessmentFindingVoBean[] getFindingsAndQuestions()
	{
		return this.findingsandquestions;
	}
	public void setFindingsAndQuestions(ims.assessment.vo.beans.GraphicAssessmentFindingVoBean[] value)
	{
		this.findingsandquestions = value;
	}
	public ims.assessment.vo.beans.GraphicAssessmentQuestionVoBean[] getAssociatedQuestions()
	{
		return this.associatedquestions;
	}
	public void setAssociatedQuestions(ims.assessment.vo.beans.GraphicAssessmentQuestionVoBean[] value)
	{
		this.associatedquestions = value;
	}
	public ims.assessment.vo.beans.GraphicAssessmentStageVoBean[] getAssessmentStage()
	{
		return this.assessmentstage;
	}
	public void setAssessmentStage(ims.assessment.vo.beans.GraphicAssessmentStageVoBean[] value)
	{
		this.assessmentstage = value;
	}

	private Integer id;
	private int version;
	private String name;
	private ims.vo.LookupInstanceBean assessmenttype;
	private ims.vo.LookupInstanceBean activestatus;
	private String helpurl;
	private Boolean storeprintedreport;
	private java.util.Collection assessmentspecialties;
	private ims.vo.RefVoBean associatedreportforprinting;
	private ims.core.vo.beans.DrawingGraphicImageVoBean[] images;
	private ims.assessment.vo.beans.GraphicAssessmentFindingVoBean[] findingsandquestions;
	private ims.assessment.vo.beans.GraphicAssessmentQuestionVoBean[] associatedquestions;
	private ims.assessment.vo.beans.GraphicAssessmentStageVoBean[] assessmentstage;
}
