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
// This code was generated by Peter Martin using IMS Development Environment (version 1.35 build 2103.16649)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.spinalinjuries.domain.impl;

import java.util.ArrayList;
import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.impl.DomainImpl;
import ims.framework.enumerations.SortOrder;
import ims.spinalinjuries.domain.objects.PatientSocialStatus;
import ims.spinalinjuries.vo.SocialStatusVoCollection;
import ims.spinalinjuries.vo.domain.SocialStatusVoAssembler;

public class OPDSocialStatusImpl extends DomainImpl implements ims.spinalinjuries.domain.OPDSocialStatus, ims.domain.impl.Transactional
{
	
	public ims.spinalinjuries.vo.SocialStatusVo saveSocialStatus(ims.spinalinjuries.vo.SocialStatusVo socialStatus) throws StaleObjectException {
		if (!socialStatus.isValidated())
			throw new DomainRuntimeException("Social Status has not been validated");

		DomainFactory factory = getDomainFactory();

		PatientSocialStatus doSocialStatus = SocialStatusVoAssembler.extractPatientSocialStatus(factory, socialStatus);
		
		factory.save(doSocialStatus);
			
		return SocialStatusVoAssembler.create(doSocialStatus);
	}

	public SocialStatusVoCollection listSocialStatusByEpisodeOfCare(EpisodeOfCareRefVo voEpisodeOfCareRef)
	{
		DomainFactory factory = getDomainFactory();

		String query = " from PatientSocialStatus pss ";
		StringBuffer hql = new StringBuffer();
		String andStr = " ";
		
		ArrayList markers= new ArrayList();
		ArrayList values = new ArrayList();
		

		if(voEpisodeOfCareRef != null)
		{
			hql.append(andStr + " pss.careContext.episodeOfCare.id = :ec");
			markers.add("ec");
			values.add(voEpisodeOfCareRef.getID_EpisodeOfCare());
			andStr = " and ";
		}
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();	
		
		java.util.List pssList = factory.find(query,markers,values);
		SocialStatusVoCollection voSocialStatusColl = SocialStatusVoAssembler.createSocialStatusVoCollectionFromPatientSocialStatus(pssList);
		
		if(voSocialStatusColl.size()>0)
			return voSocialStatusColl.sort(SortOrder.DESCENDING);
		else
			return voSocialStatusColl; //wdev-13637
	}

	public HcpCollection listMedics(HcpFilter voHcpFilter)
	{
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listMedics(voHcpFilter);
	}

}
