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

package ims.RefMan.vo.beans;

public class AdmissionDetailUndoClockImpactVoBean extends ims.vo.ValueObjectBean
{
	public AdmissionDetailUndoClockImpactVoBean()
	{
	}
	public AdmissionDetailUndoClockImpactVoBean(ims.RefMan.vo.AdmissionDetailUndoClockImpactVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : new ims.vo.RefVoBean(vo.getPasEvent().getBoId(), vo.getPasEvent().getBoVersion());
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.admissionepisode = vo.getAdmissionEpisode() == null ? null : new ims.vo.RefVoBean(vo.getAdmissionEpisode().getBoId(), vo.getAdmissionEpisode().getBoVersion());
		this.admissionrttoutcome = vo.getAdmissionRTTOutcome() == null ? null : new ims.vo.RefVoBean(vo.getAdmissionRTTOutcome().getBoId(), vo.getAdmissionRTTOutcome().getBoVersion());
		this.dischargerttoutcome = vo.getDischargeRTTOutcome() == null ? null : new ims.vo.RefVoBean(vo.getDischargeRTTOutcome().getBoId(), vo.getDischargeRTTOutcome().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.AdmissionDetailUndoClockImpactVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : new ims.vo.RefVoBean(vo.getPasEvent().getBoId(), vo.getPasEvent().getBoVersion());
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.admissionepisode = vo.getAdmissionEpisode() == null ? null : new ims.vo.RefVoBean(vo.getAdmissionEpisode().getBoId(), vo.getAdmissionEpisode().getBoVersion());
		this.admissionrttoutcome = vo.getAdmissionRTTOutcome() == null ? null : new ims.vo.RefVoBean(vo.getAdmissionRTTOutcome().getBoId(), vo.getAdmissionRTTOutcome().getBoVersion());
		this.dischargerttoutcome = vo.getDischargeRTTOutcome() == null ? null : new ims.vo.RefVoBean(vo.getDischargeRTTOutcome().getBoId(), vo.getDischargeRTTOutcome().getBoVersion());
	}

	public ims.RefMan.vo.AdmissionDetailUndoClockImpactVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.AdmissionDetailUndoClockImpactVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.AdmissionDetailUndoClockImpactVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.AdmissionDetailUndoClockImpactVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.AdmissionDetailUndoClockImpactVo();
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
	public ims.vo.RefVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.vo.RefVoBean value)
	{
		this.pasevent = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAdmissionDateTime()
	{
		return this.admissiondatetime;
	}
	public void setAdmissionDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.admissiondatetime = value;
	}
	public ims.vo.RefVoBean getAdmissionEpisode()
	{
		return this.admissionepisode;
	}
	public void setAdmissionEpisode(ims.vo.RefVoBean value)
	{
		this.admissionepisode = value;
	}
	public ims.vo.RefVoBean getAdmissionRTTOutcome()
	{
		return this.admissionrttoutcome;
	}
	public void setAdmissionRTTOutcome(ims.vo.RefVoBean value)
	{
		this.admissionrttoutcome = value;
	}
	public ims.vo.RefVoBean getDischargeRTTOutcome()
	{
		return this.dischargerttoutcome;
	}
	public void setDischargeRTTOutcome(ims.vo.RefVoBean value)
	{
		this.dischargerttoutcome = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean pasevent;
	private ims.framework.utils.beans.DateTimeBean admissiondatetime;
	private ims.vo.RefVoBean admissionepisode;
	private ims.vo.RefVoBean admissionrttoutcome;
	private ims.vo.RefVoBean dischargerttoutcome;
}
