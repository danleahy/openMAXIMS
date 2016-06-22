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

public class SessionSlotCatsReferralClinicListWrapperVoBean extends ims.vo.ValueObjectBean
{
	public SessionSlotCatsReferralClinicListWrapperVoBean()
	{
	}
	public SessionSlotCatsReferralClinicListWrapperVoBean(ims.RefMan.vo.SessionSlotCatsReferralClinicListWrapperVo vo)
	{
		this.slot = vo.getSlot() == null ? null : (ims.scheduling.vo.beans.SessionSlotClinicListListVoBean)vo.getSlot().getBean();
		this.referral = vo.getReferral() == null ? null : (ims.RefMan.vo.beans.CatsReferralClinicListListVoBean)vo.getReferral().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.SessionSlotCatsReferralClinicListWrapperVo vo)
	{
		this.slot = vo.getSlot() == null ? null : (ims.scheduling.vo.beans.SessionSlotClinicListListVoBean)vo.getSlot().getBean(map);
		this.referral = vo.getReferral() == null ? null : (ims.RefMan.vo.beans.CatsReferralClinicListListVoBean)vo.getReferral().getBean(map);
	}

	public ims.RefMan.vo.SessionSlotCatsReferralClinicListWrapperVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.SessionSlotCatsReferralClinicListWrapperVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.SessionSlotCatsReferralClinicListWrapperVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.SessionSlotCatsReferralClinicListWrapperVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.SessionSlotCatsReferralClinicListWrapperVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.scheduling.vo.beans.SessionSlotClinicListListVoBean getSlot()
	{
		return this.slot;
	}
	public void setSlot(ims.scheduling.vo.beans.SessionSlotClinicListListVoBean value)
	{
		this.slot = value;
	}
	public ims.RefMan.vo.beans.CatsReferralClinicListListVoBean getReferral()
	{
		return this.referral;
	}
	public void setReferral(ims.RefMan.vo.beans.CatsReferralClinicListListVoBean value)
	{
		this.referral = value;
	}

	private ims.scheduling.vo.beans.SessionSlotClinicListListVoBean slot;
	private ims.RefMan.vo.beans.CatsReferralClinicListListVoBean referral;
}
