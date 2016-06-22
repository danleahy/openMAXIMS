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
// This code was generated by Charlotte Murphy using IMS Development Environment (version 1.45 build 2245.35199)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.therapies.domain.base.impl.BaseWheelchairReferralImpl;
import ims.therapies.mobilitytransfers.domain.objects.WheelchairReferral;
import ims.therapies.vo.WheelchairReferralVoCollection;
import ims.therapies.vo.domain.WheelchairReferralVoAssembler;

public class WheelchairReferralImpl extends BaseWheelchairReferralImpl
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	* save WheelchairReferral
	 * @throws UniqueKeyViolationException 
	*/
	public void save(ims.therapies.vo.WheelchairReferralVo voWheelchairReferral) throws ims.domain.exceptions.StaleObjectException, UniqueKeyViolationException
	{
		if (!voWheelchairReferral.isValidated())
			throw new DomainRuntimeException("This Wheelchair Referral has not been validated");
		
		DomainFactory factory = getDomainFactory();	
		
		WheelchairReferral doWheelchairReferral = WheelchairReferralVoAssembler.extractWheelchairReferral(factory, voWheelchairReferral);
		
		factory.save(doWheelchairReferral);
	}

	/**
	* list
	*/
	public WheelchairReferralVoCollection getWheelchairReferralVoByCareContext(CareContextShortVo voCareContext) {
		if (voCareContext == null)
			throw new RuntimeException("Cannot get WheelchairReferralVo for null CareContextShortVo");

		StringBuffer hql = new StringBuffer();
		hql.append("from WheelchairReferral as w1_1 where w1_1.careContext.id = :CCID");
		java.util.List list = getDomainFactory().find(hql.toString(), "CCID", voCareContext.getID_CareContext());
		if (list == null || list.size() == 0)
			return null;
		
		return WheelchairReferralVoAssembler.createWheelchairReferralVoCollectionFromWheelchairReferral(list);
	}

	public HcpCollection listHCPs(HcpFilter voHcpFilter)
	{
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listHCPs(voHcpFilter);
	}

}
