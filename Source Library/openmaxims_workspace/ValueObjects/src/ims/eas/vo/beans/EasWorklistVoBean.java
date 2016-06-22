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

package ims.eas.vo.beans;

public class EasWorklistVoBean extends ims.vo.ValueObjectBean
{
	public EasWorklistVoBean()
	{
	}
	public EasWorklistVoBean(ims.eas.vo.EasWorklistVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientListVoBean)vo.getPatient().getBean();
		this.easstatus = vo.getEasStatus() == null ? null : (ims.eas.vo.beans.EasStatusLiteVoBean)vo.getEasStatus().getBean();
		this.responsiblehcp = vo.getResponsibleHcp() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleHcp().getBean();
		this.tpcreated = vo.getTPCreated();
		this.actionrequired = vo.getActionRequired();
		this.seenby = vo.getSeenBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getSeenBy().getBean();
		this.dateseen = vo.getDateSeen() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateSeen().getBean();
		this.datedecisiontotreat = vo.getDateDecisionToTreat() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateDecisionToTreat().getBean();
		this.intent = vo.getIntent() == null ? null : (ims.vo.LookupInstanceBean)vo.getIntent().getBean();
		this.priority = vo.getPriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getPriority().getBean();
		this.patientstatus = vo.getPatientStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientStatus().getBean();
		this.removedstat = vo.getRemovedStat();
		this.delayed = vo.getDelayed();
		this.primarytumour = vo.getPrimaryTumour() == null ? null : (ims.eas.vo.beans.PrimaryTumourNameVoBean)vo.getPrimaryTumour().getBean();
		this.treatmentsite = vo.getTreatmentSite() == null ? null : (ims.eas.vo.beans.TreatmentSiteNameVoBean)vo.getTreatmentSite().getBean();
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
		this.removalreason = vo.getRemovalReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getRemovalReason().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.eas.vo.EasWorklistVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientListVoBean)vo.getPatient().getBean(map);
		this.easstatus = vo.getEasStatus() == null ? null : (ims.eas.vo.beans.EasStatusLiteVoBean)vo.getEasStatus().getBean(map);
		this.responsiblehcp = vo.getResponsibleHcp() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleHcp().getBean(map);
		this.tpcreated = vo.getTPCreated();
		this.actionrequired = vo.getActionRequired();
		this.seenby = vo.getSeenBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getSeenBy().getBean(map);
		this.dateseen = vo.getDateSeen() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateSeen().getBean();
		this.datedecisiontotreat = vo.getDateDecisionToTreat() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateDecisionToTreat().getBean();
		this.intent = vo.getIntent() == null ? null : (ims.vo.LookupInstanceBean)vo.getIntent().getBean();
		this.priority = vo.getPriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getPriority().getBean();
		this.patientstatus = vo.getPatientStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientStatus().getBean();
		this.removedstat = vo.getRemovedStat();
		this.delayed = vo.getDelayed();
		this.primarytumour = vo.getPrimaryTumour() == null ? null : (ims.eas.vo.beans.PrimaryTumourNameVoBean)vo.getPrimaryTumour().getBean(map);
		this.treatmentsite = vo.getTreatmentSite() == null ? null : (ims.eas.vo.beans.TreatmentSiteNameVoBean)vo.getTreatmentSite().getBean(map);
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
		this.removalreason = vo.getRemovalReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getRemovalReason().getBean();
	}

	public ims.eas.vo.EasWorklistVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.eas.vo.EasWorklistVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.eas.vo.EasWorklistVo vo = null;
		if(map != null)
			vo = (ims.eas.vo.EasWorklistVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.eas.vo.EasWorklistVo();
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
	public ims.core.vo.beans.PatientListVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientListVoBean value)
	{
		this.patient = value;
	}
	public ims.eas.vo.beans.EasStatusLiteVoBean getEasStatus()
	{
		return this.easstatus;
	}
	public void setEasStatus(ims.eas.vo.beans.EasStatusLiteVoBean value)
	{
		this.easstatus = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getResponsibleHcp()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHcp(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.responsiblehcp = value;
	}
	public Boolean getTPCreated()
	{
		return this.tpcreated;
	}
	public void setTPCreated(Boolean value)
	{
		this.tpcreated = value;
	}
	public Boolean getActionRequired()
	{
		return this.actionrequired;
	}
	public void setActionRequired(Boolean value)
	{
		this.actionrequired = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getSeenBy()
	{
		return this.seenby;
	}
	public void setSeenBy(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.seenby = value;
	}
	public ims.framework.utils.beans.DateBean getDateSeen()
	{
		return this.dateseen;
	}
	public void setDateSeen(ims.framework.utils.beans.DateBean value)
	{
		this.dateseen = value;
	}
	public ims.framework.utils.beans.DateBean getDateDecisionToTreat()
	{
		return this.datedecisiontotreat;
	}
	public void setDateDecisionToTreat(ims.framework.utils.beans.DateBean value)
	{
		this.datedecisiontotreat = value;
	}
	public ims.vo.LookupInstanceBean getIntent()
	{
		return this.intent;
	}
	public void setIntent(ims.vo.LookupInstanceBean value)
	{
		this.intent = value;
	}
	public ims.vo.LookupInstanceBean getPriority()
	{
		return this.priority;
	}
	public void setPriority(ims.vo.LookupInstanceBean value)
	{
		this.priority = value;
	}
	public ims.vo.LookupInstanceBean getPatientStatus()
	{
		return this.patientstatus;
	}
	public void setPatientStatus(ims.vo.LookupInstanceBean value)
	{
		this.patientstatus = value;
	}
	public Boolean getRemovedStat()
	{
		return this.removedstat;
	}
	public void setRemovedStat(Boolean value)
	{
		this.removedstat = value;
	}
	public Boolean getDelayed()
	{
		return this.delayed;
	}
	public void setDelayed(Boolean value)
	{
		this.delayed = value;
	}
	public ims.eas.vo.beans.PrimaryTumourNameVoBean getPrimaryTumour()
	{
		return this.primarytumour;
	}
	public void setPrimaryTumour(ims.eas.vo.beans.PrimaryTumourNameVoBean value)
	{
		this.primarytumour = value;
	}
	public ims.eas.vo.beans.TreatmentSiteNameVoBean getTreatmentSite()
	{
		return this.treatmentsite;
	}
	public void setTreatmentSite(ims.eas.vo.beans.TreatmentSiteNameVoBean value)
	{
		this.treatmentsite = value;
	}
	public ims.eas.vo.beans.EasStatusLiteVoBean[] getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.eas.vo.beans.EasStatusLiteVoBean[] value)
	{
		this.statushistory = value;
	}
	public ims.vo.LookupInstanceBean getRemovalReason()
	{
		return this.removalreason;
	}
	public void setRemovalReason(ims.vo.LookupInstanceBean value)
	{
		this.removalreason = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PatientListVoBean patient;
	private ims.eas.vo.beans.EasStatusLiteVoBean easstatus;
	private ims.core.vo.beans.HcpLiteVoBean responsiblehcp;
	private Boolean tpcreated;
	private Boolean actionrequired;
	private ims.core.vo.beans.HcpLiteVoBean seenby;
	private ims.framework.utils.beans.DateBean dateseen;
	private ims.framework.utils.beans.DateBean datedecisiontotreat;
	private ims.vo.LookupInstanceBean intent;
	private ims.vo.LookupInstanceBean priority;
	private ims.vo.LookupInstanceBean patientstatus;
	private Boolean removedstat;
	private Boolean delayed;
	private ims.eas.vo.beans.PrimaryTumourNameVoBean primarytumour;
	private ims.eas.vo.beans.TreatmentSiteNameVoBean treatmentsite;
	private ims.eas.vo.beans.EasStatusLiteVoBean[] statushistory;
	private ims.vo.LookupInstanceBean removalreason;
}
