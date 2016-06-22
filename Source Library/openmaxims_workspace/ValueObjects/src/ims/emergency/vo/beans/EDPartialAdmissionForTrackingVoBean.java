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

package ims.emergency.vo.beans;

public class EDPartialAdmissionForTrackingVoBean extends ims.vo.ValueObjectBean
{
	public EDPartialAdmissionForTrackingVoBean()
	{
	}
	public EDPartialAdmissionForTrackingVoBean(ims.emergency.vo.EDPartialAdmissionForTrackingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.admittingconsultant = vo.getAdmittingConsultant() == null ? null : (ims.core.vo.beans.HcpMinVoBean)vo.getAdmittingConsultant().getBean();
		this.allocatedward = vo.getAllocatedWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getAllocatedWard().getBean();
		this.admissionward = vo.getAdmissionWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getAdmissionWard().getBean();
		this.allocateddatetime = vo.getAllocatedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAllocatedDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.EDPartialAdmissionForTrackingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.admittingconsultant = vo.getAdmittingConsultant() == null ? null : (ims.core.vo.beans.HcpMinVoBean)vo.getAdmittingConsultant().getBean(map);
		this.allocatedward = vo.getAllocatedWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getAllocatedWard().getBean(map);
		this.admissionward = vo.getAdmissionWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getAdmissionWard().getBean(map);
		this.allocateddatetime = vo.getAllocatedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAllocatedDateTime().getBean();
	}

	public ims.emergency.vo.EDPartialAdmissionForTrackingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.EDPartialAdmissionForTrackingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.EDPartialAdmissionForTrackingVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.EDPartialAdmissionForTrackingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.EDPartialAdmissionForTrackingVo();
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
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public ims.core.vo.beans.HcpMinVoBean getAdmittingConsultant()
	{
		return this.admittingconsultant;
	}
	public void setAdmittingConsultant(ims.core.vo.beans.HcpMinVoBean value)
	{
		this.admittingconsultant = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getAllocatedWard()
	{
		return this.allocatedward;
	}
	public void setAllocatedWard(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.allocatedward = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getAdmissionWard()
	{
		return this.admissionward;
	}
	public void setAdmissionWard(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.admissionward = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAllocatedDateTime()
	{
		return this.allocateddatetime;
	}
	public void setAllocatedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.allocateddatetime = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean specialty;
	private ims.core.vo.beans.HcpMinVoBean admittingconsultant;
	private ims.core.vo.beans.LocationLiteVoBean allocatedward;
	private ims.core.vo.beans.LocationLiteVoBean admissionward;
	private ims.framework.utils.beans.DateTimeBean allocateddatetime;
}
