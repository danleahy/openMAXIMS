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

public class InpatientDischargeNoteFollowupVoBean extends ims.vo.ValueObjectBean
{
	public InpatientDischargeNoteFollowupVoBean()
	{
	}
	public InpatientDischargeNoteFollowupVoBean(ims.clinical.vo.InpatientDischargeNoteFollowupVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.clinicalnote = vo.getClinicalNote() == null ? null : (ims.core.vo.beans.ClinicalNotesVoBean)vo.getClinicalNote().getBean();
		this.outcome = vo.getOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcome().getBean();
		this.reviewin = vo.getReviewIn();
		this.reviewinunits = vo.getReviewinUnits() == null ? null : (ims.vo.LookupInstanceBean)vo.getReviewinUnits().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.InpatientDischargeNoteFollowupVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.clinicalnote = vo.getClinicalNote() == null ? null : (ims.core.vo.beans.ClinicalNotesVoBean)vo.getClinicalNote().getBean(map);
		this.outcome = vo.getOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcome().getBean();
		this.reviewin = vo.getReviewIn();
		this.reviewinunits = vo.getReviewinUnits() == null ? null : (ims.vo.LookupInstanceBean)vo.getReviewinUnits().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public ims.clinical.vo.InpatientDischargeNoteFollowupVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.InpatientDischargeNoteFollowupVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.InpatientDischargeNoteFollowupVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.InpatientDischargeNoteFollowupVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.InpatientDischargeNoteFollowupVo();
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
	public ims.core.vo.beans.ClinicalNotesVoBean getClinicalNote()
	{
		return this.clinicalnote;
	}
	public void setClinicalNote(ims.core.vo.beans.ClinicalNotesVoBean value)
	{
		this.clinicalnote = value;
	}
	public ims.vo.LookupInstanceBean getOutcome()
	{
		return this.outcome;
	}
	public void setOutcome(ims.vo.LookupInstanceBean value)
	{
		this.outcome = value;
	}
	public Integer getReviewIn()
	{
		return this.reviewin;
	}
	public void setReviewIn(Integer value)
	{
		this.reviewin = value;
	}
	public ims.vo.LookupInstanceBean getReviewinUnits()
	{
		return this.reviewinunits;
	}
	public void setReviewinUnits(ims.vo.LookupInstanceBean value)
	{
		this.reviewinunits = value;
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
	private ims.core.vo.beans.ClinicalNotesVoBean clinicalnote;
	private ims.vo.LookupInstanceBean outcome;
	private Integer reviewin;
	private ims.vo.LookupInstanceBean reviewinunits;
	private ims.vo.RefVoBean carecontext;
}
