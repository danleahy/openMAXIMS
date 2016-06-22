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
// This code was generated by Dara Hickey using IMS Development Environment (version 1.39 build 2145.28324)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import java.util.List;

import ims.clinical.domain.objects.SystemReview;
import ims.clinical.vo.SystemReviewVoCollection;
import ims.clinical.vo.domain.SystemReviewVoAssembler;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.impl.DomainImpl;

public class SystemsReviewImpl extends DomainImpl implements ims.clinical.domain.SystemsReview, ims.domain.impl.Transactional
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1006478144091576456L;

	/**
	* getSystemReview for a clinical contact.
	*/
	public ims.clinical.vo.SystemReviewVo getSystemReview(ims.core.vo.ClinicalContactShortVo voClinicalContactShort)
	{
		if(voClinicalContactShort == null || voClinicalContactShort.getID_ClinicalContact() == null)
			throw new DomainRuntimeException("Contact not provided for get call. ");
		
		DomainFactory factory = getDomainFactory();
		List sysReviewList =   factory.find(" from SystemReview sr where sr.clinicalContact.id = :idCC )",
				new String[]{"idCC" },
				new Object[]{ voClinicalContactShort.getID_ClinicalContact()});

		SystemReviewVoCollection voColl = SystemReviewVoAssembler.createSystemReviewVoCollectionFromSystemReview(sysReviewList);
		
		if(voColl.size()>0)
			return voColl.get(0);
		else 
			return null;

	}

	/**
	* saveSystemReview
	*/
	public ims.clinical.vo.SystemReviewVo saveSystemReview(ims.clinical.vo.SystemReviewVo voSystemReview) throws StaleObjectException
	{
		if (!voSystemReview.isValidated())
		{
			throw new DomainRuntimeException("Systemreview VO has not been validated.");
		}
		
		DomainFactory factory = getDomainFactory();		
		
		StringBuffer hql = new StringBuffer("from SystemReview sr ");
		if(voSystemReview.getID_SystemReview() == null)
			hql.append(" where (sr.clinicalContact.id = " + voSystemReview.getClinicalContact().getID_ClinicalContact() + ")");
		else
			hql.append(" where (sr.clinicalContact.id = " + voSystemReview.getClinicalContact().getID_ClinicalContact() + ") and sr.id <> " +  voSystemReview.getID_SystemReview());
		
		List list = (factory.find(hql.toString()));
		
		if(list.size() > 0)
			throw new DomainRuntimeException("A record exists for this clinical contact, the screen will be refreshed");
		
		
		
		SystemReview doSystemReview = SystemReviewVoAssembler.extractSystemReview(factory, voSystemReview);		
		
		factory.save(doSystemReview);
		
		return SystemReviewVoAssembler.create(doSystemReview);
	}
}
