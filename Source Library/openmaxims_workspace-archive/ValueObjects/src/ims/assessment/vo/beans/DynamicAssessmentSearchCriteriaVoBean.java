//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.assessment.vo.beans;

public class DynamicAssessmentSearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public DynamicAssessmentSearchCriteriaVoBean()
	{
	}
	public DynamicAssessmentSearchCriteriaVoBean(ims.assessment.vo.DynamicAssessmentSearchCriteriaVo vo)
	{
		this.fromdate = vo.getFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFromDate().getBean();
		this.todate = vo.getToDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getToDate().getBean();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.userassessment = vo.getUserAssessment() == null ? null : new ims.vo.RefVoBean(vo.getUserAssessment().getBoId(), vo.getUserAssessment().getBoVersion());
		this.graphicassessment = vo.getGraphicAssessment() == null ? null : new ims.vo.RefVoBean(vo.getGraphicAssessment().getBoId(), vo.getGraphicAssessment().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.DynamicAssessmentSearchCriteriaVo vo)
	{
		this.fromdate = vo.getFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFromDate().getBean();
		this.todate = vo.getToDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getToDate().getBean();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.userassessment = vo.getUserAssessment() == null ? null : new ims.vo.RefVoBean(vo.getUserAssessment().getBoId(), vo.getUserAssessment().getBoVersion());
		this.graphicassessment = vo.getGraphicAssessment() == null ? null : new ims.vo.RefVoBean(vo.getGraphicAssessment().getBoId(), vo.getGraphicAssessment().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
	}

	public ims.assessment.vo.DynamicAssessmentSearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.DynamicAssessmentSearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.DynamicAssessmentSearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.DynamicAssessmentSearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.DynamicAssessmentSearchCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.framework.utils.beans.DateBean getFromDate()
	{
		return this.fromdate;
	}
	public void setFromDate(ims.framework.utils.beans.DateBean value)
	{
		this.fromdate = value;
	}
	public ims.framework.utils.beans.DateBean getToDate()
	{
		return this.todate;
	}
	public void setToDate(ims.framework.utils.beans.DateBean value)
	{
		this.todate = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.RefVoBean getUserAssessment()
	{
		return this.userassessment;
	}
	public void setUserAssessment(ims.vo.RefVoBean value)
	{
		this.userassessment = value;
	}
	public ims.vo.RefVoBean getGraphicAssessment()
	{
		return this.graphicassessment;
	}
	public void setGraphicAssessment(ims.vo.RefVoBean value)
	{
		this.graphicassessment = value;
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
	public ims.vo.RefVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.vo.RefVoBean value)
	{
		this.clinicalcontact = value;
	}

	private ims.framework.utils.beans.DateBean fromdate;
	private ims.framework.utils.beans.DateBean todate;
	private ims.vo.RefVoBean patient;
	private ims.vo.RefVoBean userassessment;
	private ims.vo.RefVoBean graphicassessment;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.RefVoBean episodeofcare;
	private ims.vo.RefVoBean clinicalcontact;
}