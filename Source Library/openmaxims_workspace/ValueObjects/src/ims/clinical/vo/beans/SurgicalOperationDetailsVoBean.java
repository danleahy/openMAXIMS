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

public class SurgicalOperationDetailsVoBean extends ims.vo.ValueObjectBean
{
	public SurgicalOperationDetailsVoBean()
	{
	}
	public SurgicalOperationDetailsVoBean(ims.clinical.vo.SurgicalOperationDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.surgicalopnote = vo.getSurgicalOpNote() == null ? null : (ims.clinical.vo.beans.SurgicalOperationNotesVoBean)vo.getSurgicalOpNote().getBean();
		this.incision = vo.getIncision();
		this.findings = vo.getFindings();
		this.procedure = vo.getProcedure();
		this.closure = vo.getClosure();
		this.prosthesis = vo.getProsthesis();
		this.drain = vo.getDrain();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.SurgicalOperationDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.surgicalopnote = vo.getSurgicalOpNote() == null ? null : (ims.clinical.vo.beans.SurgicalOperationNotesVoBean)vo.getSurgicalOpNote().getBean(map);
		this.incision = vo.getIncision();
		this.findings = vo.getFindings();
		this.procedure = vo.getProcedure();
		this.closure = vo.getClosure();
		this.prosthesis = vo.getProsthesis();
		this.drain = vo.getDrain();
	}

	public ims.clinical.vo.SurgicalOperationDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.SurgicalOperationDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.SurgicalOperationDetailsVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.SurgicalOperationDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.SurgicalOperationDetailsVo();
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
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.clinical.vo.beans.SurgicalOperationNotesVoBean getSurgicalOpNote()
	{
		return this.surgicalopnote;
	}
	public void setSurgicalOpNote(ims.clinical.vo.beans.SurgicalOperationNotesVoBean value)
	{
		this.surgicalopnote = value;
	}
	public String getIncision()
	{
		return this.incision;
	}
	public void setIncision(String value)
	{
		this.incision = value;
	}
	public String getFindings()
	{
		return this.findings;
	}
	public void setFindings(String value)
	{
		this.findings = value;
	}
	public String getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(String value)
	{
		this.procedure = value;
	}
	public String getClosure()
	{
		return this.closure;
	}
	public void setClosure(String value)
	{
		this.closure = value;
	}
	public String getProsthesis()
	{
		return this.prosthesis;
	}
	public void setProsthesis(String value)
	{
		this.prosthesis = value;
	}
	public String getDrain()
	{
		return this.drain;
	}
	public void setDrain(String value)
	{
		this.drain = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.vo.RefVoBean carecontext;
	private ims.clinical.vo.beans.SurgicalOperationNotesVoBean surgicalopnote;
	private String incision;
	private String findings;
	private String procedure;
	private String closure;
	private String prosthesis;
	private String drain;
}
