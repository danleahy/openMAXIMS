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

public class DrivingVoBean extends ims.vo.ValueObjectBean
{
	public DrivingVoBean()
	{
	}
	public DrivingVoBean(ims.therapies.vo.DrivingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.authoringcp = vo.getAuthoringCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringCP().getBean();
		this.drivingcommenceddate = vo.getDrivingCommencedDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDrivingCommencedDate().getBean();
		this.vehicletype = vo.getVehicleType();
		this.specialistinfoequip = vo.getSpecialistInfoEquip();
		this.drivingaspect = vo.getDrivingAspect() == null ? null : vo.getDrivingAspect().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.DrivingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.authoringcp = vo.getAuthoringCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringCP().getBean(map);
		this.drivingcommenceddate = vo.getDrivingCommencedDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDrivingCommencedDate().getBean();
		this.vehicletype = vo.getVehicleType();
		this.specialistinfoequip = vo.getSpecialistInfoEquip();
		this.drivingaspect = vo.getDrivingAspect() == null ? null : vo.getDrivingAspect().getBeanCollection();
	}

	public ims.therapies.vo.DrivingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.DrivingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.DrivingVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.DrivingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.DrivingVo();
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
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
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
	public ims.framework.utils.beans.PartialDateBean getDrivingCommencedDate()
	{
		return this.drivingcommenceddate;
	}
	public void setDrivingCommencedDate(ims.framework.utils.beans.PartialDateBean value)
	{
		this.drivingcommenceddate = value;
	}
	public String getVehicleType()
	{
		return this.vehicletype;
	}
	public void setVehicleType(String value)
	{
		this.vehicletype = value;
	}
	public String getSpecialistInfoEquip()
	{
		return this.specialistinfoequip;
	}
	public void setSpecialistInfoEquip(String value)
	{
		this.specialistinfoequip = value;
	}
	public ims.therapies.vo.beans.DrivingAspectVoBean[] getDrivingAspect()
	{
		return this.drivingaspect;
	}
	public void setDrivingAspect(ims.therapies.vo.beans.DrivingAspectVoBean[] value)
	{
		this.drivingaspect = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean carecontext;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
	private ims.core.vo.beans.HcpBean authoringcp;
	private ims.framework.utils.beans.PartialDateBean drivingcommenceddate;
	private String vehicletype;
	private String specialistinfoequip;
	private ims.therapies.vo.beans.DrivingAspectVoBean[] drivingaspect;
}
