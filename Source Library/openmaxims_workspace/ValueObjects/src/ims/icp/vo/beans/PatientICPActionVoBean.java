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

public class PatientICPActionVoBean extends ims.vo.ValueObjectBean
{
	public PatientICPActionVoBean()
	{
	}
	public PatientICPActionVoBean(ims.icp.vo.PatientICPActionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.icp = vo.getICP() == null ? null : new ims.vo.RefVoBean(vo.getICP().getBoId(), vo.getICP().getBoVersion());
		this.parentphase = vo.getParentPhase() == null ? null : new ims.vo.RefVoBean(vo.getParentPhase().getBoId(), vo.getParentPhase().getBoVersion());
		this.action = vo.getAction() == null ? null : (ims.icp.vo.beans.ICPActionLiteVoBean)vo.getAction().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.icp.vo.beans.PatientICPActionStatusVoBean)vo.getCurrentStatus().getBean();
		this.completedondate = vo.getCompletedOnDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletedOnDate().getBean();
		this.requirescountersigning = vo.getRequiresCounterSigning();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.PatientICPActionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.icp = vo.getICP() == null ? null : new ims.vo.RefVoBean(vo.getICP().getBoId(), vo.getICP().getBoVersion());
		this.parentphase = vo.getParentPhase() == null ? null : new ims.vo.RefVoBean(vo.getParentPhase().getBoId(), vo.getParentPhase().getBoVersion());
		this.action = vo.getAction() == null ? null : (ims.icp.vo.beans.ICPActionLiteVoBean)vo.getAction().getBean(map);
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.icp.vo.beans.PatientICPActionStatusVoBean)vo.getCurrentStatus().getBean(map);
		this.completedondate = vo.getCompletedOnDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletedOnDate().getBean();
		this.requirescountersigning = vo.getRequiresCounterSigning();
	}

	public ims.icp.vo.PatientICPActionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.icp.vo.PatientICPActionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.PatientICPActionVo vo = null;
		if(map != null)
			vo = (ims.icp.vo.PatientICPActionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.icp.vo.PatientICPActionVo();
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
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.RefVoBean getICP()
	{
		return this.icp;
	}
	public void setICP(ims.vo.RefVoBean value)
	{
		this.icp = value;
	}
	public ims.vo.RefVoBean getParentPhase()
	{
		return this.parentphase;
	}
	public void setParentPhase(ims.vo.RefVoBean value)
	{
		this.parentphase = value;
	}
	public ims.icp.vo.beans.ICPActionLiteVoBean getAction()
	{
		return this.action;
	}
	public void setAction(ims.icp.vo.beans.ICPActionLiteVoBean value)
	{
		this.action = value;
	}
	public ims.icp.vo.beans.PatientICPActionStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.icp.vo.beans.PatientICPActionStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCompletedOnDate()
	{
		return this.completedondate;
	}
	public void setCompletedOnDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.completedondate = value;
	}
	public Boolean getRequiresCounterSigning()
	{
		return this.requirescountersigning;
	}
	public void setRequiresCounterSigning(Boolean value)
	{
		this.requirescountersigning = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.RefVoBean icp;
	private ims.vo.RefVoBean parentphase;
	private ims.icp.vo.beans.ICPActionLiteVoBean action;
	private ims.icp.vo.beans.PatientICPActionStatusVoBean currentstatus;
	private ims.framework.utils.beans.DateTimeBean completedondate;
	private Boolean requirescountersigning;
}
