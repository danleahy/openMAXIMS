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

package ims.icp.vo.beans;

public class PatientICPEvaluationNoteVoBean extends ims.vo.ValueObjectBean
{
	public PatientICPEvaluationNoteVoBean()
	{
	}
	public PatientICPEvaluationNoteVoBean(ims.icp.vo.PatientICPEvaluationNoteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.datetime = vo.getDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTime().getBean();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.discipline = vo.getDiscipline() == null ? null : (ims.vo.LookupInstanceBean)vo.getDiscipline().getBean();
		this.note = vo.getNote();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.PatientICPEvaluationNoteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.datetime = vo.getDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTime().getBean();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.discipline = vo.getDiscipline() == null ? null : (ims.vo.LookupInstanceBean)vo.getDiscipline().getBean();
		this.note = vo.getNote();
	}

	public ims.icp.vo.PatientICPEvaluationNoteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.icp.vo.PatientICPEvaluationNoteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.PatientICPEvaluationNoteVo vo = null;
		if(map != null)
			vo = (ims.icp.vo.PatientICPEvaluationNoteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.icp.vo.PatientICPEvaluationNoteVo();
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
	public ims.framework.utils.beans.DateTimeBean getDateTime()
	{
		return this.datetime;
	}
	public void setDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datetime = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.vo.LookupInstanceBean getDiscipline()
	{
		return this.discipline;
	}
	public void setDiscipline(ims.vo.LookupInstanceBean value)
	{
		this.discipline = value;
	}
	public String getNote()
	{
		return this.note;
	}
	public void setNote(String value)
	{
		this.note = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean datetime;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.vo.LookupInstanceBean discipline;
	private String note;
}
