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

public class PatientAlertLiteVoBean extends ims.vo.ValueObjectBean
{
	public PatientAlertLiteVoBean()
	{
	}
	public PatientAlertLiteVoBean(ims.core.vo.PatientAlertLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.alerttype = vo.getAlertType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAlertType().getBean();
		this.iscurrentlyactivealert = vo.getIsCurrentlyActiveAlert();
		this.sourceofinformation = vo.getSourceofInformation() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceofInformation().getBean();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.comments = vo.getComments();
		this.dateidentified = vo.getDateIdentified() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDateIdentified().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientAlertLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.alerttype = vo.getAlertType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAlertType().getBean();
		this.iscurrentlyactivealert = vo.getIsCurrentlyActiveAlert();
		this.sourceofinformation = vo.getSourceofInformation() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceofInformation().getBean();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.comments = vo.getComments();
		this.dateidentified = vo.getDateIdentified() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDateIdentified().getBean();
	}

	public ims.core.vo.PatientAlertLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientAlertLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientAlertLiteVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientAlertLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientAlertLiteVo();
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
	public ims.vo.LookupInstanceBean getAlertType()
	{
		return this.alerttype;
	}
	public void setAlertType(ims.vo.LookupInstanceBean value)
	{
		this.alerttype = value;
	}
	public Boolean getIsCurrentlyActiveAlert()
	{
		return this.iscurrentlyactivealert;
	}
	public void setIsCurrentlyActiveAlert(Boolean value)
	{
		this.iscurrentlyactivealert = value;
	}
	public ims.vo.LookupInstanceBean getSourceofInformation()
	{
		return this.sourceofinformation;
	}
	public void setSourceofInformation(ims.vo.LookupInstanceBean value)
	{
		this.sourceofinformation = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public ims.framework.utils.beans.PartialDateBean getDateIdentified()
	{
		return this.dateidentified;
	}
	public void setDateIdentified(ims.framework.utils.beans.PartialDateBean value)
	{
		this.dateidentified = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean alerttype;
	private Boolean iscurrentlyactivealert;
	private ims.vo.LookupInstanceBean sourceofinformation;
	private ims.vo.RefVoBean patient;
	private String comments;
	private ims.framework.utils.beans.PartialDateBean dateidentified;
}
