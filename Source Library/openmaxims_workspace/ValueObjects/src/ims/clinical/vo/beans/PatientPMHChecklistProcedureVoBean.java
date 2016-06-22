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

public class PatientPMHChecklistProcedureVoBean extends ims.vo.ValueObjectBean
{
	public PatientPMHChecklistProcedureVoBean()
	{
	}
	public PatientPMHChecklistProcedureVoBean(ims.clinical.vo.PatientPMHChecklistProcedureVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.ProcedureLiteVoBean)vo.getProcedure().getBean();
		this.selected = vo.getSelected() == null ? null : (ims.vo.LookupInstanceBean)vo.getSelected().getBean();
		this.notes = vo.getNotes();
		this.sourceofinformation = vo.getSourceofInformation() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceofInformation().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.PatientPMHChecklistProcedureVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.ProcedureLiteVoBean)vo.getProcedure().getBean(map);
		this.selected = vo.getSelected() == null ? null : (ims.vo.LookupInstanceBean)vo.getSelected().getBean();
		this.notes = vo.getNotes();
		this.sourceofinformation = vo.getSourceofInformation() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceofInformation().getBean();
	}

	public ims.clinical.vo.PatientPMHChecklistProcedureVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.PatientPMHChecklistProcedureVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.PatientPMHChecklistProcedureVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.PatientPMHChecklistProcedureVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.PatientPMHChecklistProcedureVo();
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
	public ims.core.vo.beans.ProcedureLiteVoBean getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.beans.ProcedureLiteVoBean value)
	{
		this.procedure = value;
	}
	public ims.vo.LookupInstanceBean getSelected()
	{
		return this.selected;
	}
	public void setSelected(ims.vo.LookupInstanceBean value)
	{
		this.selected = value;
	}
	public String getNotes()
	{
		return this.notes;
	}
	public void setNotes(String value)
	{
		this.notes = value;
	}
	public ims.vo.LookupInstanceBean getSourceofInformation()
	{
		return this.sourceofinformation;
	}
	public void setSourceofInformation(ims.vo.LookupInstanceBean value)
	{
		this.sourceofinformation = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.ProcedureLiteVoBean procedure;
	private ims.vo.LookupInstanceBean selected;
	private String notes;
	private ims.vo.LookupInstanceBean sourceofinformation;
}
