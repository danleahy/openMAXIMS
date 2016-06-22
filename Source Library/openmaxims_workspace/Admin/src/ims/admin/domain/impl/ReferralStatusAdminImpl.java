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
// This code was generated by Aidan Mc Donnell using IMS Development Environment (version 1.64 build 3152.19974)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import java.util.List;

import ims.admin.domain.base.impl.BaseReferralStatusAdminImpl;
import ims.RefMan.vo.ReferralStatusConfigVo;
import ims.RefMan.vo.ReferralStatusConfigVoCollection;
import ims.RefMan.vo.domain.ReferralStatusConfigVoAssembler;
import ims.RefMan.vo.lookups.ReferralApptStatus;
import ims.core.admin.domain.objects.ReferralStatusConfig;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.hibernate3.DomainFactory;

public class ReferralStatusAdminImpl extends BaseReferralStatusAdminImpl
{

	private static final long	serialVersionUID	= 1L;

	public ims.RefMan.vo.ReferralStatusConfigVoCollection getReferralStatus()
	{

		ims.domain.DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer("from ReferralStatusConfig");

		List list = factory.find(hql.toString());

		return ReferralStatusConfigVoAssembler.createReferralStatusConfigVoCollectionFromReferralStatusConfig(list);

	}

	public void saveReferralStatusConfig(ims.RefMan.vo.ReferralStatusConfigVoCollection referralStatusConfigVoColl) throws StaleObjectException, ForeignKeyViolationException
	{

		if (!referralStatusConfigVoColl.isValidated())
			throw new DomainRuntimeException("Referral Status Data has not been validated");

		ims.domain.DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer("from ReferralStatusConfig");

		factory.delete(hql.toString());

		for (int i = 0; i < referralStatusConfigVoColl.size(); i++)
		{

			ReferralStatusConfigVo voRefStatusConfig = referralStatusConfigVoColl.get(i);
			//voRefStatusConfig.setID_ReferralStatusConfig(null);
			ReferralStatusConfig domRefStatusConfig = ReferralStatusConfigVoAssembler.extractReferralStatusConfig(factory, voRefStatusConfig);
			factory.save(domRefStatusConfig);

		}

	}
}
