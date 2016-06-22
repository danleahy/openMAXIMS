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
// This code was generated by Billy Mahon using IMS Development Environment (version 1.45 build 2418.19363)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.oncology.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.SortOrder;
import ims.oncology.domain.MDTDetails;
import ims.oncology.domain.base.impl.BaseCarePlanDetailsImpl;
import ims.oncology.domain.objects.CancerCarePlan;
import ims.oncology.domain.objects.CancerMDTMeeting;
import ims.oncology.vo.CancerCarePlanLiteVo;
import ims.oncology.vo.CancerCarePlanLiteVoCollection;
import ims.oncology.vo.CancerCarePlanShortVo;
import ims.oncology.vo.CancerCarePlanShortVoCollection;
import ims.oncology.vo.CancerCarePlanVo;
import ims.oncology.vo.CancerCarePlanVoCollection;
import ims.oncology.vo.CancerMDTMeetingVoCollection;
import ims.oncology.vo.domain.CancerCarePlanLiteVoAssembler;
import ims.oncology.vo.domain.CancerCarePlanShortVoAssembler;
import ims.oncology.vo.domain.CancerCarePlanVoAssembler;
import ims.oncology.vo.domain.CancerMDTMeetingVoAssembler;

import java.util.ArrayList;
import java.util.List;

public class CarePlanDetailsImpl extends BaseCarePlanDetailsImpl
{
	private static final long serialVersionUID = 1L;

	public HcpLiteVoCollection listHcps(String name) 
	{
		HcpAdmin hcpAdmin = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listHcpLiteByName(name);
	}

	public CancerCarePlanVo saveCancerCarePlan(CancerCarePlanVo voCancerCarePlan) throws StaleObjectException 
	{
		if (!voCancerCarePlan.isValidated())
		{
			throw new DomainRuntimeException("CancerCarePlan has not been validated");
		}
		DomainFactory factory = getDomainFactory();
		
		CancerCarePlan domCancerCarePlan = null;
		CancerMDTMeeting domCancerMdt = null;
		
		if(voCancerCarePlan.getID_CancerCarePlanIsNotNull())
		{
			//clearing associations
			domCancerCarePlan = (CancerCarePlan) factory.getDomainObject(voCancerCarePlan);
			domCancerMdt = domCancerCarePlan.getMdtMeeting();
			if(domCancerMdt != null)
				domCancerMdt.setAssociatedCarePlan(null);
			domCancerCarePlan.setMdtMeeting(null);
		}

		domCancerCarePlan = CancerCarePlanVoAssembler.extractCancerCarePlan(factory, voCancerCarePlan);
		if(voCancerCarePlan.getMdtMeetingIsNotNull())
		{
			domCancerMdt = CancerMDTMeetingVoAssembler.extractCancerMDTMeeting(factory, voCancerCarePlan.getMdtMeeting()); 
			domCancerMdt.setAssociatedCarePlan(domCancerCarePlan);
			factory.save(domCancerMdt);
		}

		factory.save(domCancerCarePlan);
		return CancerCarePlanVoAssembler.create(domCancerCarePlan);
	}

	public CancerCarePlanVo getCancerCarePlanByClinicalContact(ClinicalContactShortVo voClinicalContactShort, CancerCarePlanShortVo voCancerCarePlan) 
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from CancerCarePlan ccp ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";
		
		if (voClinicalContactShort != null)
		{
			hql.append(andStr + " ccp.clinicalContact.id = :id_ClinicalContact");
			markers.add("id_ClinicalContact");
			values.add(voClinicalContactShort.getID_ClinicalContact());			
			andStr = " and ";
		}
		if (voCancerCarePlan != null)
		{
			hql.append(andStr + " ccp.id = :id_CancerCarePlan");
			markers.add("id_CancerCarePlan");
			values.add(voCancerCarePlan.getID_CancerCarePlan());			
			andStr = " and ";
		}

		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();
		
		CancerCarePlanVo voCarePlan = new CancerCarePlanVo();
		List carePlans = factory.find(query, markers, values);	
		CancerCarePlanVoCollection collCancerCarePlanVo = CancerCarePlanVoAssembler.createCancerCarePlanVoCollectionFromCancerCarePlan(carePlans).sort(SortOrder.DESCENDING);
		if(collCancerCarePlanVo != null && collCancerCarePlanVo.size() > 0)
		{
			voCarePlan = collCancerCarePlanVo.get(0);
			return voCarePlan;
		}
		return null;
	}

	public CancerCarePlanVo getCancerCarePlanByCareContext(CareContextShortVo voCareContextShort, CancerCarePlanShortVo voCancerCarePlanShort) 
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from CancerCarePlan ccp ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";
		
		if (voCareContextShort != null)
		{
			hql.append(andStr + " ccp.careContext.id = :id_CareContext");
			markers.add("id_CareContext");
			values.add(voCareContextShort.getID_CareContext());			
			andStr = " and ";
		}
		if (voCancerCarePlanShort != null)
		{
			hql.append(andStr + " ccp.id = :id_CancerCarePlan");
			markers.add("id_CancerCarePlan");
			values.add(voCancerCarePlanShort.getID_CancerCarePlan());			
			andStr = " and ";
		}
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();
		
		CancerCarePlanVo voCancerCarePlan = new CancerCarePlanVo();

		List visit = factory.find(query, markers, values);	
		CancerCarePlanVoCollection collCancerCarePlanVo = CancerCarePlanVoAssembler.createCancerCarePlanVoCollectionFromCancerCarePlan(visit);
		if(collCancerCarePlanVo != null)
		{
			voCancerCarePlan = collCancerCarePlanVo.get(0);
			return voCancerCarePlan;
		}
		return null;
	}

	public CancerCarePlanLiteVoCollection listCancerCarePlans(EpisodeOfCareRefVo episodeOfCareRef) 
	{
		if (episodeOfCareRef != null)
		{
			DomainFactory factory = getDomainFactory();
			List cancerCarePlan  = factory.find(" from CancerCarePlan ccp where ccp.episodeOfCare.id = :ccId",
					new String[]{"ccId"},
					new Object[]{episodeOfCareRef.getID_EpisodeOfCare()});
	
			return CancerCarePlanLiteVoAssembler.createCancerCarePlanLiteVoCollectionFromCancerCarePlan(cancerCarePlan).sort(SortOrder.DESCENDING);
		}
		return null;
	}

	public CancerCarePlanVo getCancerCarePlan(CancerCarePlanLiteVo voCancerCarePlanLite) 
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from CancerCarePlan ccp ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";
		
		if (voCancerCarePlanLite != null)
		{
			hql.append(andStr + " ccp.id = :id_CarePlan");
			markers.add("id_CarePlan");
			values.add(voCancerCarePlanLite.getID_CancerCarePlan());			
			andStr = " and ";
		}
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();
		
		CancerCarePlanVo voCancerCarePlan = new CancerCarePlanVo();

		List visit = factory.find(query, markers, values);	
		CancerCarePlanVoCollection collCancerCarePlanVo = CancerCarePlanVoAssembler.createCancerCarePlanVoCollectionFromCancerCarePlan(visit);
		if(collCancerCarePlanVo != null)
		{
			voCancerCarePlan = collCancerCarePlanVo.get(0);
			return voCancerCarePlan;
		}
		return null;
	}

	public CancerMDTMeetingVoCollection listCancerMDTMeeting(EpisodeOfCareRefVo eocRef) 
	{
		MDTDetails mdtDetails = (MDTDetails) getDomainImpl(MDTDetailsImpl.class);
		return mdtDetails.listCancerMDTMeeting(eocRef);
	}

	public CancerCarePlanShortVoCollection listCancerCarePlanByEpisdoeOfCare(EpisodeOfCareRefVo episodeRefVo) 
	{
		if (episodeRefVo == null)
			throw new DomainRuntimeException("episodeRefVo is null for call to listCancerCarePlanByEpisdoeOfCare");

		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		String query = " from CancerCarePlan ccp ";
		ArrayList markers= new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		hql.append(andStr + " ccp.careContext.episodeOfCare.id = :ec");
		markers.add("ec");
		values.add(episodeRefVo.getID_EpisodeOfCare());
		andStr = " and ";
		
		if (markers.size() > 0) 
			query += " where ";
		
		query += hql.toString();	
		
		java.util.List cancerCarePlan = factory.find(query,markers,values);
		CancerCarePlanShortVoCollection voCancerCarePlanShortColl = CancerCarePlanShortVoAssembler.createCancerCarePlanShortVoCollectionFromCancerCarePlan(cancerCarePlan).sort(SortOrder.ASCENDING);
		
		if(voCancerCarePlanShortColl.size()>0)
			return voCancerCarePlanShortColl;
		else
			return null;	
	}

	public CancerCarePlanShortVoCollection listCancerCarePlanByCareContext(CareContextRefVo voCareContextRef)
	{
		if (voCareContextRef == null || voCareContextRef.getID_CareContext() == null)
			throw new DomainRuntimeException("Care Context RefVo is null for call to listCancerCarePlanByCareContext");
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		String query = " from CancerCarePlan ccp ";
		ArrayList markers= new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		
			hql.append(andStr + " ccp.careContext.id = :ec");
			markers.add("ec");
			values.add(voCareContextRef.getID_CareContext());
			andStr = " and ";
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();	
		
		java.util.List cancerCarePlan = factory.find(query,markers,values);
		CancerCarePlanShortVoCollection voCancerCarePlanShortColl = CancerCarePlanShortVoAssembler.createCancerCarePlanShortVoCollectionFromCancerCarePlan(cancerCarePlan).sort(SortOrder.ASCENDING);
		
		if(voCancerCarePlanShortColl.size()>0)
			return voCancerCarePlanShortColl;
		else
			return null;
	}


}
