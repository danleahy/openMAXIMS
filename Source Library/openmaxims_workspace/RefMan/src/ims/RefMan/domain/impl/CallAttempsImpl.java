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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.65 build 3182.26548)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.base.impl.BaseCallAttemptsImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.ReferralService;
import ims.RefMan.vo.AppointmentCallAttemptsVoCollection;
import ims.RefMan.vo.CatsReferralCallAttemptsVo;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.ReferralServiceFullVo;
import ims.RefMan.vo.domain.AppointmentCallAttemptsVoAssembler;
import ims.RefMan.vo.domain.CatsReferralCallAttemptsVoAssembler;
import ims.RefMan.vo.domain.ReferralServiceFullVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class CallAttempsImpl extends BaseCallAttemptsImpl
{

	private static final long serialVersionUID = 1L;


	/**
	* get
	*/
	public CatsReferralCallAttemptsVo getCatsReferral(ims.RefMan.vo.CatsReferralRefVo voCatsRef)
	{
		if(voCatsRef == null || voCatsRef.getID_CatsReferral() == null)
			throw new CodingRuntimeException("catsReferall is null or id not provided");

		return CatsReferralCallAttemptsVoAssembler.create((CatsReferral)getDomainFactory().getDomainObject(CatsReferral.class, voCatsRef.getID_CatsReferral()));
	}

	public ReferralServiceFullVo getReferralServices() 
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("from ReferralService");
	
		List list = factory.find(hql.toString());
		if(list.size()>0)
			return ReferralServiceFullVoAssembler.create((ReferralService) list.get(0));
		else
			return null;
	}

	public CatsReferralCallAttemptsVo saveCATSReferral(CatsReferralCallAttemptsVo voCatsReferral) throws StaleObjectException 
	{
		if(voCatsReferral == null)
			throw new DomainRuntimeException("Invalid referral to save");
		if(!voCatsReferral.isValidated())
			throw new DomainRuntimeException("Record not validated before save");
		
		DomainFactory factory = getDomainFactory();
		CatsReferral domainObject = CatsReferralCallAttemptsVoAssembler.extractCatsReferral(factory, voCatsReferral);		
		factory.save(domainObject);
		return CatsReferralCallAttemptsVoAssembler.create(domainObject);
	}

	//WDEV-15485
	public AppointmentCallAttemptsVoCollection getCallAttempts(CatsReferralRefVo catsReferralRef)
	{
		if (catsReferralRef == null || catsReferralRef.getID_CatsReferral() == null)
		{
			throw new CodingRuntimeException("Cannot get CallAttempts on null Id ");
		}

		DomainFactory factory = getDomainFactory();
		
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		StringBuffer hql = new StringBuffer();
 
		hql.append(" select calls from CatsReferral as referral left join referral.callAttempts as calls where referral.id = :referralID ");

		markers.add("referralID");
		values.add(catsReferralRef.getID_CatsReferral());

		return AppointmentCallAttemptsVoAssembler.createAppointmentCallAttemptsVoCollectionFromAppointmentCallAttempts(factory.find(hql.toString(), markers, values));
	}
	
}
