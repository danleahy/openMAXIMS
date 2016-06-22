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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.22 build 41222.900)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.spinalinjuries.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.clinicaladmin.domain.Vertebrallevels;
import ims.clinicaladmin.domain.impl.VertebrallevelsImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.CareContextLiteVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.VertebrallevelVoCollection;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.lookups.ContactType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.impl.DomainImpl;
import ims.framework.enumerations.SortOrder;
import ims.generalmedical.vo.MSKSpinePathologyFindingShortVoCollection;
import ims.generalmedical.vo.MSKSpinePathologyFindingVo;
import ims.generalmedical.vo.MSKSpinePathologyFindingVoCollection;
import ims.generalmedical.vo.domain.MSKSpinePathologyFindingShortVoAssembler;
import ims.generalmedical.vo.domain.MSKSpinePathologyFindingVoAssembler;
import ims.medical.domain.objects.MskSpinePath;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.clinical.domain.objects.PatientProblem;

public class MedMskSpinePathImpl extends DomainImpl implements ims.spinalinjuries.domain.MedMskSpinePath, ims.domain.impl.Transactional
{
	/**
	 * Gets the SpinePathology details for the given episode
	 */
	public MSKSpinePathologyFindingVoCollection getMskSpinePath(ClinicalContactShortVo contact, Boolean activeOnly)
	{
		DomainFactory factory = getDomainFactory();

		String hql = " from MskSpinePath mskSpinePath ";
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";

		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		if (contact != null)
		{
			condStr.append(andStr + " mskSpinePath.clinicalContact.id = :id_ClinicalContact ");
			markers.add("id_ClinicalContact");
			values.add(contact.getID_ClinicalContact());
			andStr = " and ";
		}

		if (activeOnly != null)
		{
			condStr.append(andStr + " mskSpinePath.isActive = :active");
			markers.add("active");
			values.add(activeOnly);
			andStr = " and ";
		}

		if (andStr.equals(" and "))
			hql += " where ";

		hql += condStr.toString();

		MSKSpinePathologyFindingVoCollection voSpinePathology = MSKSpinePathologyFindingVoAssembler.createMSKSpinePathologyFindingVoCollectionFromMskSpinePath(factory.find(hql, markers, values));
		if(voSpinePathology != null && voSpinePathology.size()>0)
			return voSpinePathology;
		else
			return null;

	}

	/**
	 * Saves the given details
	 */
	public MSKSpinePathologyFindingVo saveMskSpinePath(MSKSpinePathologyFindingVo exam, CareContextShortVo careContext) throws StaleObjectException
	{
		if (!exam.isValidated())
			throw new DomainRuntimeException("Examination has not been validated!");
		
		DomainFactory factory = getDomainFactory();		
		CareContext domCareContext = CareContextShortVoAssembler.extractCareContext(factory, careContext);
		
		MskSpinePath domPath = MSKSpinePathologyFindingVoAssembler.extractMskSpinePath(factory, exam);
		if (exam.getIsProblem().booleanValue() == true)
		{
			PatientProblem prob = new PatientProblem();
			prob.setIsActive(Boolean.TRUE);
			prob.setPatientProblem("MSK Spine Pathology - Level:" +  exam.getPathSite().getName() + " of injury");
			prob.setProblemContext("Spine Pathology");
			prob.setCareContext(domCareContext);
			factory.save(prob);
		}
		factory.save(domPath);			
		return MSKSpinePathologyFindingVoAssembler.create(domPath);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see ims.spinalinjuries.domain.MedMskSpinePath#listVertebralLevel(java.lang.Boolean)
	 */
	public VertebrallevelVoCollection listVertebralLevel(Boolean activeOnly)
	{
		Vertebrallevels impl = (Vertebrallevels) getDomainImpl(VertebrallevelsImpl.class);
		return impl.listVertebralLevel(Boolean.TRUE);
	}

	public HcpLiteVoCollection listHcpLiteByName(String hcpName)
	{
		HcpAdmin impl = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return impl.listHcpLiteByName(hcpName);

	}
	
	public MSKSpinePathologyFindingShortVoCollection listByCareContext(CareContextLiteVo voCareContext)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		String query = "from MskSpinePath msp";
		ArrayList markers= new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if(voCareContext != null)
		{
			hql.append(andStr + " msp.careContext.id = :cc");
			markers.add("cc");
			values.add(voCareContext.getID_CareContext());
			andStr = " and ";
		}

		if (markers.size() > 0) query += " where ";
		query += hql.toString();	
		
		List spine = factory.find(query,markers,values);

		MSKSpinePathologyFindingShortVoCollection voSpinePathologyFinding = MSKSpinePathologyFindingShortVoAssembler.createMSKSpinePathologyFindingShortVoCollectionFromMskSpinePath(spine);
		if(voSpinePathologyFinding != null && voSpinePathologyFinding.size()>0)
			return voSpinePathologyFinding;
		else
			return null;
		
	}

	public MSKSpinePathologyFindingVoCollection getByCareContext(CareContextLiteVo voCareContext, Boolean active)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		String query = "from MskSpinePath msp ";
		ArrayList markers= new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if(voCareContext != null)
		{
			hql.append(andStr + " msp.careContext.id = :cc");
			markers.add("cc");
			values.add(voCareContext.getID_CareContext());
			andStr = " and ";
		}
		
		if (active != null)
		{
			hql.append(andStr + " msp.isActive = :active");
			markers.add("active");
			values.add(active);
			andStr = " and ";
		}
		
		hql.append(andStr + "msp.clinicalContact is null");
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();	
		
		List neuros = factory.find(query,markers,values);
		MSKSpinePathologyFindingVoCollection voSpinePathologyFindingColl = MSKSpinePathologyFindingVoAssembler.createMSKSpinePathologyFindingVoCollectionFromMskSpinePath(neuros);
		if(voSpinePathologyFindingColl != null && voSpinePathologyFindingColl.size()>0)
			return voSpinePathologyFindingColl.sort(SortOrder.DESCENDING);
		else	
			return null;
	}

	public MSKSpinePathologyFindingVoCollection getSpinalMedicalAdmissionPathologyByCareContext(CareContextRefVo voCareContextRef)
	{
		DomainFactory factory = getDomainFactory();
	
		List spine =   factory.find(" from MskSpinePath spine where spine.clinicalContact.id = " + 
				"( select cons.id from CareContext con join con.clinicalContacts cons where cons.contactType = :type and con.id = :idcare)",
				new String[]{"type", "idcare" },
				new Object[]{ getDomLookup(ContactType.SPINALMEDICALADMISSION),voCareContextRef.getID_CareContext()});
		
		MSKSpinePathologyFindingVoCollection collSpinePathology = MSKSpinePathologyFindingVoAssembler.createMSKSpinePathologyFindingVoCollectionFromMskSpinePath(spine);
		if(collSpinePathology != null && collSpinePathology.size()>0)
			return collSpinePathology.sort(SortOrder.DESCENDING);
		else	
			return null;
	}
	
	public Integer countForPrimaryPathology(ims.core.vo.PatientShort pID)
	{
		DomainFactory factory = getDomainFactory();
		
		List spine =   factory.find("select count (m1_1.id) from MskSpinePath as m1_1 left join m1_1.careContext as c1_1 left join c1_1.episodeOfCare as e1_1 left join e1_1.careSpell as c2_1 where (c2_1.patient.id = :PID and m1_1.isPrimaryPathology = 1)",
				new String[]{"PID" }, new Object[]{pID.getID_Patient()});
		
		if(spine != null && spine.size() > 0)
		{
			Object value = spine.get(0);
			if(value instanceof Long){
				Long lValue = (Long)spine.get(0);
				if(lValue.intValue()>0)
					return new Integer(1);
			}
		}
		
		return null;
	}

	
	//wdev-11015
	public MSKSpinePathologyFindingVo getMskSpinePathForPrimaryPathology(PatientRefVo voRef) 
	{
		if(voRef == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		List spine =   factory.find("select m1_1 from MskSpinePath as m1_1 left join m1_1.careContext as c1_1 left join c1_1.episodeOfCare as e1_1 left join e1_1.careSpell as c2_1 where (c2_1.patient.id = :PID and m1_1.isPrimaryPathology = 1)",
				new String[]{"PID" }, new Object[]{voRef.getID_Patient()});
		MSKSpinePathologyFindingVoCollection collSpinePathology = MSKSpinePathologyFindingVoAssembler.createMSKSpinePathologyFindingVoCollectionFromMskSpinePath(spine);
		if(collSpinePathology != null && collSpinePathology.size() > 0)
		{
			return collSpinePathology.get(0);
		}
		
		return null;
	}
}
