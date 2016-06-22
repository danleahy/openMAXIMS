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

public class OnAdmissionSummaryVoBean extends ims.vo.ValueObjectBean
{
	public OnAdmissionSummaryVoBean()
	{
	}
	public OnAdmissionSummaryVoBean(ims.clinical.vo.OnAdmissionSummaryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.admissionnotes = vo.getAdmissionNotes() == null ? null : (ims.core.vo.beans.ClinicalNotesVoBean)vo.getAdmissionNotes().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.OnAdmissionSummaryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.admissionnotes = vo.getAdmissionNotes() == null ? null : (ims.core.vo.beans.ClinicalNotesVoBean)vo.getAdmissionNotes().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
	}

	public ims.clinical.vo.OnAdmissionSummaryVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.OnAdmissionSummaryVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.OnAdmissionSummaryVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.OnAdmissionSummaryVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.OnAdmissionSummaryVo();
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
	public ims.core.vo.beans.ClinicalNotesVoBean getAdmissionNotes()
	{
		return this.admissionnotes;
	}
	public void setAdmissionNotes(ims.core.vo.beans.ClinicalNotesVoBean value)
	{
		this.admissionnotes = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.RefVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.vo.RefVoBean value)
	{
		this.clinicalcontact = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.ClinicalNotesVoBean admissionnotes;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.RefVoBean clinicalcontact;
}
