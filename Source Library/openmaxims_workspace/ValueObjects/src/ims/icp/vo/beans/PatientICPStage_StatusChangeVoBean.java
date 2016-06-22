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

public class PatientICPStage_StatusChangeVoBean extends ims.vo.ValueObjectBean
{
	public PatientICPStage_StatusChangeVoBean()
	{
	}
	public PatientICPStage_StatusChangeVoBean(ims.icp.vo.PatientICPStage_StatusChangeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.icp.vo.beans.PatientICPStageStatusVoBean)vo.getCurrentStatus().getBean();
		if(vo.getStatusHistory() != null)
		{
			this.statushistory = new ims.vo.RefVoBean[vo.getStatusHistory().size()];
			for(int statushistory_i = 0; statushistory_i < vo.getStatusHistory().size(); statushistory_i++)
			{
				this.statushistory[statushistory_i] = new ims.vo.RefVoBean(vo.getStatusHistory().get(statushistory_i).getBoId(),vo.getStatusHistory().get(statushistory_i).getBoVersion());
			}
		}
		this.stagephases = vo.getStagePhases() == null ? null : vo.getStagePhases().getBeanCollection();
		this.stage = vo.getStage() == null ? null : new ims.vo.RefVoBean(vo.getStage().getBoId(), vo.getStage().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.PatientICPStage_StatusChangeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.icp.vo.beans.PatientICPStageStatusVoBean)vo.getCurrentStatus().getBean(map);
		if(vo.getStatusHistory() != null)
		{
			this.statushistory = new ims.vo.RefVoBean[vo.getStatusHistory().size()];
			for(int statushistory_i = 0; statushistory_i < vo.getStatusHistory().size(); statushistory_i++)
			{
				this.statushistory[statushistory_i] = new ims.vo.RefVoBean(vo.getStatusHistory().get(statushistory_i).getBoId(),vo.getStatusHistory().get(statushistory_i).getBoVersion());
			}
		}
		this.stagephases = vo.getStagePhases() == null ? null : vo.getStagePhases().getBeanCollection();
		this.stage = vo.getStage() == null ? null : new ims.vo.RefVoBean(vo.getStage().getBoId(), vo.getStage().getBoVersion());
	}

	public ims.icp.vo.PatientICPStage_StatusChangeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.icp.vo.PatientICPStage_StatusChangeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.PatientICPStage_StatusChangeVo vo = null;
		if(map != null)
			vo = (ims.icp.vo.PatientICPStage_StatusChangeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.icp.vo.PatientICPStage_StatusChangeVo();
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
	public ims.icp.vo.beans.PatientICPStageStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.icp.vo.beans.PatientICPStageStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.vo.RefVoBean[] getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.vo.RefVoBean[] value)
	{
		this.statushistory = value;
	}
	public ims.icp.vo.beans.PatientICPPhase_StatusChangeVoBean[] getStagePhases()
	{
		return this.stagephases;
	}
	public void setStagePhases(ims.icp.vo.beans.PatientICPPhase_StatusChangeVoBean[] value)
	{
		this.stagephases = value;
	}
	public ims.vo.RefVoBean getStage()
	{
		return this.stage;
	}
	public void setStage(ims.vo.RefVoBean value)
	{
		this.stage = value;
	}

	private Integer id;
	private int version;
	private ims.icp.vo.beans.PatientICPStageStatusVoBean currentstatus;
	private ims.vo.RefVoBean[] statushistory;
	private ims.icp.vo.beans.PatientICPPhase_StatusChangeVoBean[] stagephases;
	private ims.vo.RefVoBean stage;
}
