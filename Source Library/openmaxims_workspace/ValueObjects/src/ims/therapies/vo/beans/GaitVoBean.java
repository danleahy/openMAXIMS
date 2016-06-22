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

package ims.therapies.vo.beans;

public class GaitVoBean extends ims.vo.ValueObjectBean
{
	public GaitVoBean()
	{
	}
	public GaitVoBean(ims.therapies.vo.GaitVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.authoringhcp = vo.getAuthoringHCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringHCP().getBean();
		this.gaittreatment = vo.getGaitTreatment() == null ? null : vo.getGaitTreatment().getBeanCollection();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.GaitVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.authoringhcp = vo.getAuthoringHCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringHCP().getBean(map);
		this.gaittreatment = vo.getGaitTreatment() == null ? null : vo.getGaitTreatment().getBeanCollection();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
	}

	public ims.therapies.vo.GaitVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.GaitVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.GaitVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.GaitVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.GaitVo();
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
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}
	public ims.core.vo.beans.HcpBean getAuthoringHCP()
	{
		return this.authoringhcp;
	}
	public void setAuthoringHCP(ims.core.vo.beans.HcpBean value)
	{
		this.authoringhcp = value;
	}
	public ims.therapies.vo.beans.GaitTreatmentVoBean[] getGaitTreatment()
	{
		return this.gaittreatment;
	}
	public void setGaitTreatment(ims.therapies.vo.beans.GaitTreatmentVoBean[] value)
	{
		this.gaittreatment = value;
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
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
	private ims.core.vo.beans.HcpBean authoringhcp;
	private ims.therapies.vo.beans.GaitTreatmentVoBean[] gaittreatment;
	private ims.vo.RefVoBean clinicalcontact;
}
