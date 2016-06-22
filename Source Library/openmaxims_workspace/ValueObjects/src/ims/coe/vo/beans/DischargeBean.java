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

package ims.coe.vo.beans;

public class DischargeBean extends ims.vo.ValueObjectBean
{
	public DischargeBean()
	{
	}
	public DischargeBean(ims.coe.vo.Discharge vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.datecommenced = vo.getDateCommenced() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateCommenced().getBean();
		this.destination = vo.getDestination() == null ? null : (ims.vo.LookupInstanceBean)vo.getDestination().getBean();
		this.datetimedischarged = vo.getDateTimeDischarged() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeDischarged().getBean();
		this.hcp = vo.getHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHCP().getBean();
		this.notes = vo.getNotes();
		this.actions = vo.getActions() == null ? null : vo.getActions().getBeanCollection();
		this.assessment = vo.getAssessment() == null ? null : (ims.coe.vo.beans.DischargeAssessmentBean)vo.getAssessment().getBean();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.Discharge vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.datecommenced = vo.getDateCommenced() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateCommenced().getBean();
		this.destination = vo.getDestination() == null ? null : (ims.vo.LookupInstanceBean)vo.getDestination().getBean();
		this.datetimedischarged = vo.getDateTimeDischarged() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeDischarged().getBean();
		this.hcp = vo.getHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHCP().getBean(map);
		this.notes = vo.getNotes();
		this.actions = vo.getActions() == null ? null : vo.getActions().getBeanCollection();
		this.assessment = vo.getAssessment() == null ? null : (ims.coe.vo.beans.DischargeAssessmentBean)vo.getAssessment().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean(map);
	}

	public ims.coe.vo.Discharge buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.coe.vo.Discharge buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.Discharge vo = null;
		if(map != null)
			vo = (ims.coe.vo.Discharge)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.coe.vo.Discharge();
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
	public ims.framework.utils.beans.DateBean getDateCommenced()
	{
		return this.datecommenced;
	}
	public void setDateCommenced(ims.framework.utils.beans.DateBean value)
	{
		this.datecommenced = value;
	}
	public ims.vo.LookupInstanceBean getDestination()
	{
		return this.destination;
	}
	public void setDestination(ims.vo.LookupInstanceBean value)
	{
		this.destination = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateTimeDischarged()
	{
		return this.datetimedischarged;
	}
	public void setDateTimeDischarged(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datetimedischarged = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getHCP()
	{
		return this.hcp;
	}
	public void setHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.hcp = value;
	}
	public String getNotes()
	{
		return this.notes;
	}
	public void setNotes(String value)
	{
		this.notes = value;
	}
	public ims.coe.vo.beans.DischargeActionsBean[] getActions()
	{
		return this.actions;
	}
	public void setActions(ims.coe.vo.beans.DischargeActionsBean[] value)
	{
		this.actions = value;
	}
	public ims.coe.vo.beans.DischargeAssessmentBean getAssessment()
	{
		return this.assessment;
	}
	public void setAssessment(ims.coe.vo.beans.DischargeAssessmentBean value)
	{
		this.assessment = value;
	}
	public ims.core.vo.beans.CareContextShortVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextShortVoBean value)
	{
		this.carecontext = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean datecommenced;
	private ims.vo.LookupInstanceBean destination;
	private ims.framework.utils.beans.DateTimeBean datetimedischarged;
	private ims.core.vo.beans.HcpLiteVoBean hcp;
	private String notes;
	private ims.coe.vo.beans.DischargeActionsBean[] actions;
	private ims.coe.vo.beans.DischargeAssessmentBean assessment;
	private ims.core.vo.beans.CareContextShortVoBean carecontext;
}
