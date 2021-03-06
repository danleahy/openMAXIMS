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

package ims.core.vo.beans;

public class VitalSignsWebServiceVoBean extends ims.vo.ValueObjectBean
{
	public VitalSignsWebServiceVoBean()
	{
	}
	public VitalSignsWebServiceVoBean(ims.core.vo.VitalSignsWebServiceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.vitalstakendatetime = vo.getVitalsTakenDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getVitalsTakenDateTime().getBean();
		this.bloodpressure = vo.getBloodPressure() == null ? null : (ims.core.vo.beans.VSBloodPressureBean)vo.getBloodPressure().getBean();
		this.pulse = vo.getPulse() == null ? null : (ims.core.vo.beans.VSPulseBean)vo.getPulse().getBean();
		this.temperature = vo.getTemperature() == null ? null : (ims.core.vo.beans.VSTemperatureBean)vo.getTemperature().getBean();
		this.recordedsigns = vo.getRecordedSigns() == null ? null : vo.getRecordedSigns().getBeanCollection();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.VitalSignsWebServiceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.vitalstakendatetime = vo.getVitalsTakenDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getVitalsTakenDateTime().getBean();
		this.bloodpressure = vo.getBloodPressure() == null ? null : (ims.core.vo.beans.VSBloodPressureBean)vo.getBloodPressure().getBean(map);
		this.pulse = vo.getPulse() == null ? null : (ims.core.vo.beans.VSPulseBean)vo.getPulse().getBean(map);
		this.temperature = vo.getTemperature() == null ? null : (ims.core.vo.beans.VSTemperatureBean)vo.getTemperature().getBean(map);
		this.recordedsigns = vo.getRecordedSigns() == null ? null : vo.getRecordedSigns().getBeanCollection();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public ims.core.vo.VitalSignsWebServiceVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.VitalSignsWebServiceVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.VitalSignsWebServiceVo vo = null;
		if(map != null)
			vo = (ims.core.vo.VitalSignsWebServiceVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.VitalSignsWebServiceVo();
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
	public ims.framework.utils.beans.DateTimeBean getVitalsTakenDateTime()
	{
		return this.vitalstakendatetime;
	}
	public void setVitalsTakenDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.vitalstakendatetime = value;
	}
	public ims.core.vo.beans.VSBloodPressureBean getBloodPressure()
	{
		return this.bloodpressure;
	}
	public void setBloodPressure(ims.core.vo.beans.VSBloodPressureBean value)
	{
		this.bloodpressure = value;
	}
	public ims.core.vo.beans.VSPulseBean getPulse()
	{
		return this.pulse;
	}
	public void setPulse(ims.core.vo.beans.VSPulseBean value)
	{
		this.pulse = value;
	}
	public ims.core.vo.beans.VSTemperatureBean getTemperature()
	{
		return this.temperature;
	}
	public void setTemperature(ims.core.vo.beans.VSTemperatureBean value)
	{
		this.temperature = value;
	}
	public java.util.Collection getRecordedSigns()
	{
		return this.recordedsigns;
	}
	public void setRecordedSigns(java.util.Collection value)
	{
		this.recordedsigns = value;
	}
	public void addRecordedSigns(java.util.Collection value)
	{
		if(this.recordedsigns == null)
			this.recordedsigns = new java.util.ArrayList();
		this.recordedsigns.add(value);
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

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean vitalstakendatetime;
	private ims.core.vo.beans.VSBloodPressureBean bloodpressure;
	private ims.core.vo.beans.VSPulseBean pulse;
	private ims.core.vo.beans.VSTemperatureBean temperature;
	private java.util.Collection recordedsigns;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.vo.RefVoBean carecontext;
}
