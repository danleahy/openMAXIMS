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

public class MassageVoBean extends ims.vo.ValueObjectBean
{
	public MassageVoBean()
	{
	}
	public MassageVoBean(ims.therapies.vo.MassageVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean();
		this.softtissuemassage = vo.getSoftTissueMassage() == null ? null : vo.getSoftTissueMassage().getBeanCollection();
		this.deepfriction = vo.getDeepFriction() == null ? null : vo.getDeepFriction().getBeanCollection();
		this.connectivetissuemassage = vo.getConnectiveTissueMassage() == null ? null : vo.getConnectiveTissueMassage().getBeanCollection();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.authoringcp = vo.getAuthoringCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringCP().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.MassageVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean(map);
		this.softtissuemassage = vo.getSoftTissueMassage() == null ? null : vo.getSoftTissueMassage().getBeanCollection();
		this.deepfriction = vo.getDeepFriction() == null ? null : vo.getDeepFriction().getBeanCollection();
		this.connectivetissuemassage = vo.getConnectiveTissueMassage() == null ? null : vo.getConnectiveTissueMassage().getBeanCollection();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.authoringcp = vo.getAuthoringCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringCP().getBean(map);
	}

	public ims.therapies.vo.MassageVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.MassageVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.MassageVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.MassageVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.MassageVo();
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
	public ims.core.vo.beans.ClinicalContactShortVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.beans.ClinicalContactShortVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.therapies.vo.beans.SoftTissueMassageVoBean[] getSoftTissueMassage()
	{
		return this.softtissuemassage;
	}
	public void setSoftTissueMassage(ims.therapies.vo.beans.SoftTissueMassageVoBean[] value)
	{
		this.softtissuemassage = value;
	}
	public ims.therapies.vo.beans.DeepFrictionMassageVoBean[] getDeepFriction()
	{
		return this.deepfriction;
	}
	public void setDeepFriction(ims.therapies.vo.beans.DeepFrictionMassageVoBean[] value)
	{
		this.deepfriction = value;
	}
	public ims.therapies.vo.beans.ConnectiveTissueMassageVoBean[] getConnectiveTissueMassage()
	{
		return this.connectivetissuemassage;
	}
	public void setConnectiveTissueMassage(ims.therapies.vo.beans.ConnectiveTissueMassageVoBean[] value)
	{
		this.connectivetissuemassage = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}
	public ims.core.vo.beans.HcpBean getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.beans.HcpBean value)
	{
		this.authoringcp = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.ClinicalContactShortVoBean clinicalcontact;
	private ims.therapies.vo.beans.SoftTissueMassageVoBean[] softtissuemassage;
	private ims.therapies.vo.beans.DeepFrictionMassageVoBean[] deepfriction;
	private ims.therapies.vo.beans.ConnectiveTissueMassageVoBean[] connectivetissuemassage;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
	private ims.core.vo.beans.HcpBean authoringcp;
}
