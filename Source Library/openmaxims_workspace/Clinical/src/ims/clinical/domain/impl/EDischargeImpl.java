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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.70 build 3341.28572)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.EDischargePatientReadyToLeaveComponent;
import ims.clinical.domain.base.impl.BaseEDischargeImpl;
import ims.clinical.helper.EDischargeHelper;
import ims.clinical.helper.IEDischargeHelper;
import ims.clinical.vo.DischargeDetailsVo;
import ims.clinical.vo.DischargeDetailsVoCollection;
import ims.clinical.vo.DischargeReadyToLeaveVo;
import ims.clinical.vo.DischargeReportDetailVo;
import ims.clinical.vo.DischargeReportDetailVoCollection;
import ims.clinical.vo.DischargeSupplementaryNotesVo;
import ims.clinical.vo.DischargeSupplementaryNotesVoCollection;
import ims.clinical.vo.RTLSummaryVo;
import ims.clinical.vo.domain.DischargeDetailsVoAssembler;
import ims.clinical.vo.domain.DischargeReportDetailVoAssembler;
import ims.clinical.vo.domain.DischargeSupplementaryNotesVoAssembler;
import ims.clinical.vo.domain.RTLSummaryVoAssembler;
import ims.clinical.vo.lookups.DischargeLetterStatus;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.Specialty;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.edischarge.domain.objects.DischargeDetails;
import ims.edischarge.domain.objects.DischargeSupplementaryNotes;
import ims.edischarge.domain.objects.RTLSummary;
import ims.framework.exceptions.CodingRuntimeException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EDischargeImpl extends BaseEDischargeImpl
{
	private static final long serialVersionUID = 1L;

	/**
	* get Discharge Details
	*/
	public ims.clinical.vo.DischargeDetailsVo getDischargeDetails(ims.core.admin.vo.CareContextRefVo careContextRefvo)
	{
		if(careContextRefvo == null)
			throw new CodingRuntimeException("careContextRefVo Filter not provided for list call. ");

		if(careContextRefvo != null)
		{
			DomainFactory factory = getDomainFactory();
			StringBuffer hql = new StringBuffer(" from DischargeDetails dd where "); 
			String andStr = " ";
		
			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();
		
			hql.append(andStr + " dd.careContext.id = :careContextId");
 			markers.add("careContextId");
			values.add(careContextRefvo.getID_CareContext());
			andStr = " and ";	

			List list = factory.find(hql.toString(), markers,values);
			if(list != null && list.size() > 0)
			{ 
				DischargeDetailsVoCollection voColl = DischargeDetailsVoAssembler.createDischargeDetailsVoCollectionFromDischargeDetails(list);
				if(voColl != null && voColl.size() > 0)
					return voColl.get(0);
			}
		}
		return null;
	}

	public DischargeDetailsVo saveDischargeDetails(DischargeDetailsVo voDischargeDetails) throws DomainInterfaceException, StaleObjectException 
	{
		if(voDischargeDetails == null)
			throw new CodingRuntimeException("DischargeDetailsVo is null");
		
		if(!voDischargeDetails.isValidated())
			throw new CodingRuntimeException("DischargeDetailsVo Value Object has not been validated");

		DomainFactory factory = getDomainFactory();
		DischargeDetails doDD = DischargeDetailsVoAssembler.extractDischargeDetails(factory, voDischargeDetails);
		
		factory.save(doDD);
		
		//WDEV-19871 - create RTLSummary when starting e-Discharge process only if one does not already exist for the care context
		IEDischargeHelper eDischImpl = (IEDischargeHelper) getDomainImpl(EDischargeHelper.class);
		RTLSummaryVo rtlSummary = eDischImpl.getRTLSummaryForCareContext(voDischargeDetails.getCareContext());
		if (voDischargeDetails.getID_DischargeDetails() == null && rtlSummary == null) 
		{	
			rtlSummary = new RTLSummaryVo();
			rtlSummary.setCareContext(voDischargeDetails.getCareContext());

			RTLSummary rTLSummaryDO = RTLSummaryVoAssembler.extractRTLSummary(factory, rtlSummary);

			factory.save(rTLSummaryDO);
		}
		//WDEV-19871 -- ends here
		
		return DischargeDetailsVoAssembler.create(doDD);
	}

	public DischargeReadyToLeaveVo getReadyToLeave(CareContextRefVo careContextRefvo) 
	{
		EDischargePatientReadyToLeaveComponent impl = (EDischargePatientReadyToLeaveComponent) getDomainImpl(EDischargePatientReadyToLeaveComponentImpl.class);
		return impl.getReadyToLeave(careContextRefvo);
	}

	public DischargeSupplementaryNotesVo getSupplementary(CareContextRefVo voCareContextRefVo) 
	{
		if(voCareContextRefVo == null)
			throw new CodingRuntimeException("voCareContextRefVo Filter not provided for list call. ");

		if(voCareContextRefVo != null)
		{
			DomainFactory factory = getDomainFactory();
			StringBuffer hql = new StringBuffer(" from DischargeSupplementaryNotes ds where "); 
			String andStr = " ";
		
			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();
		
			hql.append(andStr + " ds.careContext.id = :careContextId");
 			markers.add("careContextId");
			values.add(voCareContextRefVo.getID_CareContext());
			andStr = " and ";	

			List list = factory.find(hql.toString(), markers,values);
			if(list != null && list.size() > 0)
			{ 
				DischargeSupplementaryNotesVoCollection voColl = DischargeSupplementaryNotesVoAssembler.createDischargeSupplementaryNotesVoCollectionFromDischargeSupplementaryNotes(list);
				if(voColl != null && voColl.size() > 0)
					return voColl.get(0);
			}
		}
		return null;
	}

	public String[] getSystemReportAndTemplate(Integer imsId) 
	{
		String[] result = null;		
		DomainFactory factory = getDomainFactory();
		
		List lst = factory.find("select r1_1.reportXml, t1_1.templateXml, r1_1.reportName, r1_1.reportDescription, t1_1.name, t1_1.description from ReportBo as r1_1 left join r1_1.templates as t1_1 where (r1_1.imsId= :imsid) order by t1_1.name", new String[] {"imsid"}, new Object[] {imsId});
		
		if(lst.iterator().hasNext())
		{
			Object[] obj = (Object[])lst.iterator().next();
			
			result = new String[] {(String)obj[0], (String)obj[1], (String)obj[2], (String)obj[3], (String)obj[4], (String)obj[5]};
		}
		
		return result;
	}

	public DischargeSupplementaryNotesVo saveSupplementaryAndDD(DischargeSupplementaryNotesVo voDischSupp, DischargeDetailsVo voDD) throws DomainInterfaceException, StaleObjectException 
	{
		if(voDischSupp == null)
			throw new CodingRuntimeException("DischargeSupplementaryNotesVo is null");
		
		if(!voDischSupp.isValidated())
			throw new CodingRuntimeException("DischargeSupplementaryNotesVo Value Object has not been validated");

		DomainFactory factory = getDomainFactory();
		DischargeSupplementaryNotes doDSN = DischargeSupplementaryNotesVoAssembler.extractDischargeSupplementaryNotes(factory, voDischSupp);
		
		//WDEV-8813
		// Workaround for the case when 2 users save in the same time a new DischargeSupplementaryNotesVO
		//In this case the domain.save call doesn't throw a StaleObjectExeption, even if it is the case
		if (!voDischSupp.getID_DischargeSupplementaryNotesIsNotNull())
		{
			DischargeSupplementaryNotesVo voDischargeSupp = getSupplementary(voDischSupp.getCareContext());
			if (voDischargeSupp!=null)
			{
				throw new StaleObjectException(doDSN,"A DischargeSupplementaryNotesVo was already saved by another user");
			}
		}
		
		
		factory.save(doDSN);
		
		
		if (voDD != null)
		{
			DischargeDetails doDD = DischargeDetailsVoAssembler.extractDischargeDetails(factory, voDD);
			factory.save(doDD);
		}
		return DischargeSupplementaryNotesVoAssembler.create(doDSN);
	}

	public DischargeReportDetailVo getDischargeReportDetailsForCareContext(	CareContextRefVo careContext) 
	{
		if(careContext == null ||
				careContext.getID_CareContext() == null)
			throw new CodingRuntimeException("CareContext is null or id not provided for getDischargeDetailsForCareContext");	
		
		DomainFactory factory = getDomainFactory();
		List domainObjectList = factory.find("select drd from DischargeReportDetail as drd left join drd.careContext as cc where cc.id = :idCareContext", new String[]{"idCareContext"}, new Object[]{careContext.getID_CareContext()});
		DischargeReportDetailVoCollection reportDetail = DischargeReportDetailVoAssembler.createDischargeReportDetailVoCollectionFromDischargeReportDetail(domainObjectList);		
		
		return reportDetail != null && reportDetail.size() > 0 ? (reportDetail.get(0) != null ? reportDetail.get(0) : null) : null;
	}

	public Boolean hasAssessmentSavedOrOneConfiguredForSpecialty(CareContextRefVo careContext, Specialty specialty) 
	{
		DomainFactory factory = getDomainFactory();
		
		String query = "select count(dd.id) from DischargeDetails dd where dd.careContext.id = :careContextId and dd.patientAssessment is not null"; 
		
		Object[] count = factory.find(query, new String[] {"careContextId"}, new Object[] {careContext.getID_CareContext()}).toArray();
		if(count != null && count.length > 0 && ((Long) count[0]).intValue() > 0)
		{
			return true;
		}
		else
		{
			query = "select count(dd.id) from DischargeDetails dd left join dd.dischargeLetterStatus as dls where dd.careContext.id = :careContextId and dls.id = :Generated"; 
			
			count = factory.find(query, new String[] {"careContextId", "Generated"}, new Object[] {careContext.getID_CareContext(), DischargeLetterStatus.GENERATED.getID()}).toArray();
			if(count != null && count.length > 0 && ((Long) count[0]).intValue() > 0)
			{
				return false;
			}
			
			query = "select count(u.id) from UserAssessment u left join u.assessmentSpecialties assSpec where assSpec.instance = :assessmentSpec and u.activeStatus = :actStat";
	
			count = factory.find(query, new String[] {"assessmentSpec", "actStat"}, new Object[] {getDomLookup(specialty), getDomLookup(PreActiveActiveInactiveStatus.ACTIVE)}).toArray();
			
			if(count != null && count.length > 0 && ((Long) count[0]).intValue() > 0)
				return true;
			
			return false;
		}
	}
}
