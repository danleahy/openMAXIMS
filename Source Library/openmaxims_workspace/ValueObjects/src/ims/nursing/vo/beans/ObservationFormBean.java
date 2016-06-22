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

package ims.nursing.vo.beans;

public class ObservationFormBean extends ims.vo.ValueObjectBean
{
	public ObservationFormBean()
	{
	}
	public ObservationFormBean(ims.nursing.vo.ObservationForm vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.formtype = vo.getFormType() == null ? null : (ims.vo.LookupInstanceBean)vo.getFormType().getBean();
		this.details = vo.getDetails();
		this.datetimestart = vo.getDateTimeStart() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeStart().getBean();
		this.hcpstart = vo.getHCPStart() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHCPStart().getBean();
		this.datetimestop = vo.getDateTimeStop() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeStop().getBean();
		this.hcpstop = vo.getHCPStop() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHCPStop().getBean();
		this.isstopped = vo.getIsStopped();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.ObservationForm vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.formtype = vo.getFormType() == null ? null : (ims.vo.LookupInstanceBean)vo.getFormType().getBean();
		this.details = vo.getDetails();
		this.datetimestart = vo.getDateTimeStart() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeStart().getBean();
		this.hcpstart = vo.getHCPStart() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHCPStart().getBean(map);
		this.datetimestop = vo.getDateTimeStop() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeStop().getBean();
		this.hcpstop = vo.getHCPStop() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHCPStop().getBean(map);
		this.isstopped = vo.getIsStopped();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
	}

	public ims.nursing.vo.ObservationForm buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.ObservationForm buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.ObservationForm vo = null;
		if(map != null)
			vo = (ims.nursing.vo.ObservationForm)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.ObservationForm();
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
	public ims.vo.LookupInstanceBean getFormType()
	{
		return this.formtype;
	}
	public void setFormType(ims.vo.LookupInstanceBean value)
	{
		this.formtype = value;
	}
	public String getDetails()
	{
		return this.details;
	}
	public void setDetails(String value)
	{
		this.details = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateTimeStart()
	{
		return this.datetimestart;
	}
	public void setDateTimeStart(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datetimestart = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getHCPStart()
	{
		return this.hcpstart;
	}
	public void setHCPStart(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.hcpstart = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateTimeStop()
	{
		return this.datetimestop;
	}
	public void setDateTimeStop(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datetimestop = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getHCPStop()
	{
		return this.hcpstop;
	}
	public void setHCPStop(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.hcpstop = value;
	}
	public Boolean getIsStopped()
	{
		return this.isstopped;
	}
	public void setIsStopped(Boolean value)
	{
		this.isstopped = value;
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
	private ims.vo.LookupInstanceBean formtype;
	private String details;
	private ims.framework.utils.beans.DateTimeBean datetimestart;
	private ims.core.vo.beans.HcpLiteVoBean hcpstart;
	private ims.framework.utils.beans.DateTimeBean datetimestop;
	private ims.core.vo.beans.HcpLiteVoBean hcpstop;
	private Boolean isstopped;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.RefVoBean clinicalcontact;
}
