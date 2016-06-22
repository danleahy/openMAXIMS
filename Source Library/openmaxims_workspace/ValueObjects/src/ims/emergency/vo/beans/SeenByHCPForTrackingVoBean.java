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

public class SeenByHCPForTrackingVoBean extends ims.vo.ValueObjectBean
{
	public SeenByHCPForTrackingVoBean()
	{
	}
	public SeenByHCPForTrackingVoBean(ims.emergency.vo.SeenByHCPForTrackingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.allocateddatetime = vo.getAllocatedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAllocatedDateTime().getBean();
		this.allocatedmedic = vo.getAllocatedMedic() == null ? null : (ims.emergency.vo.beans.MedicForTrackingVoBean)vo.getAllocatedMedic().getBean();
		this.allocatednurse = vo.getAllocatedNurse() == null ? null : (ims.emergency.vo.beans.NurseForTrackingVoBean)vo.getAllocatedNurse().getBean();
		this.seendatetime = vo.getSeenDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getSeenDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.SeenByHCPForTrackingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.allocateddatetime = vo.getAllocatedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAllocatedDateTime().getBean();
		this.allocatedmedic = vo.getAllocatedMedic() == null ? null : (ims.emergency.vo.beans.MedicForTrackingVoBean)vo.getAllocatedMedic().getBean(map);
		this.allocatednurse = vo.getAllocatedNurse() == null ? null : (ims.emergency.vo.beans.NurseForTrackingVoBean)vo.getAllocatedNurse().getBean(map);
		this.seendatetime = vo.getSeenDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getSeenDateTime().getBean();
	}

	public ims.emergency.vo.SeenByHCPForTrackingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.SeenByHCPForTrackingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.SeenByHCPForTrackingVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.SeenByHCPForTrackingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.SeenByHCPForTrackingVo();
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
	public ims.framework.utils.beans.DateTimeBean getAllocatedDateTime()
	{
		return this.allocateddatetime;
	}
	public void setAllocatedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.allocateddatetime = value;
	}
	public ims.emergency.vo.beans.MedicForTrackingVoBean getAllocatedMedic()
	{
		return this.allocatedmedic;
	}
	public void setAllocatedMedic(ims.emergency.vo.beans.MedicForTrackingVoBean value)
	{
		this.allocatedmedic = value;
	}
	public ims.emergency.vo.beans.NurseForTrackingVoBean getAllocatedNurse()
	{
		return this.allocatednurse;
	}
	public void setAllocatedNurse(ims.emergency.vo.beans.NurseForTrackingVoBean value)
	{
		this.allocatednurse = value;
	}
	public ims.framework.utils.beans.DateTimeBean getSeenDateTime()
	{
		return this.seendatetime;
	}
	public void setSeenDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.seendatetime = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean allocateddatetime;
	private ims.emergency.vo.beans.MedicForTrackingVoBean allocatedmedic;
	private ims.emergency.vo.beans.NurseForTrackingVoBean allocatednurse;
	private ims.framework.utils.beans.DateTimeBean seendatetime;
}
