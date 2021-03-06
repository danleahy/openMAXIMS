//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.22 build 50107.1300)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.spinalinjuries.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.clinical.domain.objects.PatientProblem;
import ims.clinicaladmin.domain.Vertebrallevels;
import ims.clinicaladmin.domain.impl.VertebrallevelsImpl;
import ims.core.vo.CareContextLiteVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.lookups.ContactType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.impl.DomainImpl;
import ims.framework.enumerations.SortOrder;
import ims.generalmedical.vo.MedicalProbOnAdmisVo;
import ims.generalmedical.vo.MedicalProbOnAdmisVoCollection;
import ims.generalmedical.vo.NeuroSenastionFindingsVo;
import ims.generalmedical.vo.NeuroSenastionFindingsVoCollection;
import ims.generalmedical.vo.NeuroSensationExaminationVo;
import ims.generalmedical.vo.NeuroSensationFindingsShortVo;
import ims.generalmedical.vo.NeuroSensationFindingsShortVoCollection;
import ims.generalmedical.vo.domain.MedicalProbOnAdmisVoAssembler;
import ims.generalmedical.vo.domain.NeuroSenastionFindingsVoAssembler;
import ims.generalmedical.vo.domain.NeuroSensationFindingsShortVoAssembler;
import ims.medical.domain.objects.NeuExamSens;


public class MedNeuroSensationImpl extends DomainImpl implements ims.spinalinjuries.domain.MedNeuroSensation, ims.domain.impl.Transactional
{
	public NeuroSensationExaminationVo saveNeuroSensationRecord(NeuroSensationExaminationVo exam) throws StaleObjectException
	{
		if (!exam.isValidated())
			throw new DomainRuntimeException("Sensation Exam has not been validated");

		DomainFactory factory = getDomainFactory();
		
		if (exam.getNeuroSens().getClinicalContactIsNotNull())
		{
			StringBuffer hql = new StringBuffer("from NeuExamSens ner");
			if(exam.getNeuroSens().getID_NeuExamSens() == null)
				hql.append(" where (ner.clinicalContact.id = " + exam.getNeuroSens().getClinicalContact().getID_ClinicalContact() + ") and ner.isRIE is null");
			else
				hql.append(" where (ner.clinicalContact.id = " + exam.getNeuroSens().getClinicalContact().getID_ClinicalContact() + ") and ner.id <> " +  exam.getNeuroSens().getID_NeuExamSens()+ " and ner.isRIE is null");
			
			List list = (factory.find(hql.toString()));
			
			if(list.size() > 0)
				throw new DomainRuntimeException("A record exists for this clinical contact, the screen will be refreshed");
		}
		
		if(exam.getNeuroSensIsNotNull())
		{
			NeuExamSens doNeuExamSens = NeuroSenastionFindingsVoAssembler.extractNeuExamSens(factory, exam.getNeuroSens());
			
			factory.save(doNeuExamSens);
			
			exam.setNeuroSens(NeuroSenastionFindingsVoAssembler.create(doNeuExamSens));
		}
		
		MedicalProbOnAdmisVoCollection collMedicalProbOnAdmis = new MedicalProbOnAdmisVoCollection(); 
		
		if(exam.getProblemIsNotNull())
		{
			PatientProblem doMedicalProbOnAdmis = MedicalProbOnAdmisVoAssembler.extractPatientProblem(factory, exam.getProblem());
	
			factory.save(doMedicalProbOnAdmis);	
				
			collMedicalProbOnAdmis.add(MedicalProbOnAdmisVoAssembler.create(doMedicalProbOnAdmis));
		}
				
		return exam;
	}

	public ims.core.vo.VertebrallevelVoCollection listVertebralLevel(Boolean activeOnly)
	{
		Vertebrallevels impl = (Vertebrallevels) getDomainImpl(VertebrallevelsImpl.class);
		return impl.listVertebralLevel(Boolean.TRUE);
	}

	public NeuroSensationFindingsShortVoCollection listByCareContext(CareContextLiteVo voCareContext)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		String query = "from NeuExamSens ner ";
		ArrayList markers= new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if(voCareContext != null)
		{
			hql.append(andStr + " ner.careContext.id = :cc");
			markers.add("cc");
			values.add(voCareContext.getID_CareContext());
			andStr = " and ";
		}
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();	
		
		List neuros = factory.find(query,markers,values);
		NeuroSensationFindingsShortVoCollection voNeuroSenseFindShortColl = NeuroSensationFindingsShortVoAssembler.createNeuroSensationFindingsShortVoCollectionFromNeuExamSens(neuros);
		if(voNeuroSenseFindShortColl != null)
			return voNeuroSenseFindShortColl.sort(SortOrder.DESCENDING);
		else	
			return null;
	}

	public HcpLiteVoCollection listHCPs(String strHcpName)
	{
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listHcpLiteByName(strHcpName);
	}

	public NeuroSensationExaminationVo getNeuroSensationRecord(ClinicalContactShortVo voClinicalContact, NeuroSensationFindingsShortVo voNeuroSensation)
	{
		DomainFactory factory = getDomainFactory();

		NeuroSensationExaminationVo voNeuroSensationExamination = new NeuroSensationExaminationVo();
		
		String hql = " from PatientProblem medicalProbOnAdmis "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		if(voClinicalContact != null)
		{
			condStr.append(andStr + " medicalProbOnAdmis.clinicalContact.id = :id_ClinicalContact"); 
			markers.add("id_ClinicalContact");
			values.add(voClinicalContact.getID_ClinicalContact());
			andStr = " and ";
		}	
		
		condStr.append(andStr + " medicalProbOnAdmis.problemContext = :problemContext"); 
		markers.add("problemContext");
		values.add("Neuro - Motor");
		andStr = " and ";
		
		if (andStr.equals(" and "))
			hql += " where ";
	
		hql += condStr.toString();
		MedicalProbOnAdmisVoCollection collMedicalProbOnAdmis = MedicalProbOnAdmisVoAssembler.createMedicalProbOnAdmisVoCollectionFromPatientProblem(factory.find(hql, markers, values));
		if(collMedicalProbOnAdmis.size()>0)
			voNeuroSensationExamination.setProblem(collMedicalProbOnAdmis.get(0));
		
		if(voNeuroSensation != null)
		{
			voNeuroSensationExamination.setNeuroSens(get(voNeuroSensation));
			return voNeuroSensationExamination;
		}
		else
		{
		
			NeuroSenastionFindingsVoCollection collNeuroSensationFindings = new NeuroSenastionFindingsVoCollection();
			hql = " from NeuExamSens neuExamSens"; 
			condStr = new StringBuffer();
			andStr = " ";
		
			markers = new ArrayList();
			values = new ArrayList();
		
			if(voClinicalContact.getID_ClinicalContactIsNotNull())
			{
				condStr.append(andStr + " neuExamSens.clinicalContact.id = :id_ClinicalContact"); 
				markers.add("id_ClinicalContact");
				values.add(voClinicalContact.getID_ClinicalContact());
				andStr = " and ";
			}	
			
			if (andStr.equals(" and "))
				hql += " where ";
		
			hql += condStr.toString();
			collNeuroSensationFindings = NeuroSenastionFindingsVoAssembler.createNeuroSenastionFindingsVoCollectionFromNeuExamSens(factory.find(hql, markers, values));
			if(collNeuroSensationFindings.size()>0)
			{
				collNeuroSensationFindings.sort(SortOrder.DESCENDING);
				voNeuroSensationExamination.setNeuroSens(collNeuroSensationFindings.get(0));
			}
		}
		
		return voNeuroSensationExamination;
	}

	private NeuroSenastionFindingsVo get(NeuroSensationFindingsShortVo voNeuroSensation)
	{
		if(voNeuroSensation == null)
			throw new DomainRuntimeException("Invalid need neuro - sensation record to get");

		return NeuroSenastionFindingsVoAssembler.create((NeuExamSens) getDomainFactory().getDomainObject(NeuExamSens.class,voNeuroSensation.getID_NeuExamSens()));
	}
	//wdev-13418
	private NeuroSenastionFindingsVoCollection getNeuroCollection(NeuroSensationFindingsShortVo voNeuroSensation)
	{
		if(voNeuroSensation == null)
			throw new DomainRuntimeException("Invalid need neuro - sensation record to get");

		DomainFactory factory = getDomainFactory();

		String hql ; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
			
		hql = " from NeuExamSens neuExamSens"; 
		condStr = new StringBuffer();
		andStr = " ";
	
		markers = new ArrayList();
		values = new ArrayList();
	
		if(voNeuroSensation.getID_NeuExamSensIsNotNull())
		{
			condStr.append(andStr + " neuExamSens.id = :id_ClinicalContact"); 
			markers.add("id_ClinicalContact");
			values.add(voNeuroSensation.getID_NeuExamSens());
			andStr = " and ";
		}	
		
		if (andStr.equals(" and "))
			hql += " where ";
	
		hql += condStr.toString();
		NeuroSenastionFindingsVoCollection collNeuroSensationFindings = NeuroSenastionFindingsVoAssembler.createNeuroSenastionFindingsVoCollectionFromNeuExamSens(factory.find(hql, markers, values));
		return collNeuroSensationFindings;
	
		
	}

	
	public NeuroSensationExaminationVo getNeuroSensationByCareContext(CareContextRefVo voCareContext, NeuroSensationFindingsShortVo voNeuroSensation)
	{
		DomainFactory factory = getDomainFactory();

		NeuroSensationExaminationVo voNeuroSensationExamination = new NeuroSensationExaminationVo();
		
		String hql = " from PatientProblem medicalProbOnAdmis "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		if(voCareContext != null)
		{
			condStr.append(andStr + " medicalProbOnAdmis.careContext.id = :id"); 
			markers.add("id");
			values.add(voCareContext.getID_CareContext());
			andStr = " and ";
		}	
		
		condStr.append(andStr + " medicalProbOnAdmis.problemContext = :problemContext"); 
		markers.add("problemContext");
		values.add("Neuro - Motor");
		andStr = " and ";
		
		if (andStr.equals(" and "))
			hql += " where ";
	
		hql += condStr.toString();
		MedicalProbOnAdmisVoCollection collMedicalProbOnAdmis = MedicalProbOnAdmisVoAssembler.createMedicalProbOnAdmisVoCollectionFromPatientProblem(factory.find(hql, markers, values));
		if(collMedicalProbOnAdmis.size()>0)
			voNeuroSensationExamination.setProblem(collMedicalProbOnAdmis.get(0));
		
		if(voNeuroSensation != null)
		{
			voNeuroSensationExamination.setNeuroSens(get(voNeuroSensation));
			return voNeuroSensationExamination;
		}
		else
		{
			NeuroSenastionFindingsVoCollection collNeuroSensationFindings = new NeuroSenastionFindingsVoCollection();
			hql = " from NeuExamSens neuExamSens"; 
			condStr = new StringBuffer();
			andStr = " ";
		
			markers = new ArrayList();
			values = new ArrayList();
		
			if(voCareContext.getID_CareContextIsNotNull())
			{
				condStr.append(andStr + " neuExamSens.careContext.id = :id"); 
				markers.add("id");
				values.add(voCareContext.getID_CareContext());
				andStr = " and ";
			}	
			
			condStr.append(andStr + " neuExamSens.clinicalContact.id is null"); 
			
			if (andStr.equals(" and "))
				hql += " where ";
		
			hql += condStr.toString();
			collNeuroSensationFindings = NeuroSenastionFindingsVoAssembler.createNeuroSenastionFindingsVoCollectionFromNeuExamSens(factory.find(hql, markers, values));
			if(collNeuroSensationFindings.size()>0)
			{
				collNeuroSensationFindings.sort(SortOrder.DESCENDING);
				voNeuroSensationExamination.setNeuroSens(collNeuroSensationFindings.get(0));
			}
		}
		
		return voNeuroSensationExamination;
	}

	public NeuroSensationExaminationVo getSpinalMedicalAdmissionSensationByCareContext(CareContextRefVo voCareContextRef)
	{
		DomainFactory factory = getDomainFactory();

		NeuroSensationExaminationVo voNeuroSensationExamination = null;
		
		List sense =   factory.find(" from NeuExamSens sense where sense.clinicalContact.id = " + 
				"( select cons.id from CareContext con join con.clinicalContacts cons where cons.contactType = :type and con.id = :idcare)",
				new String[]{"type", "idcare" },
				new Object[]{ getDomLookup(ContactType.SPINALMEDICALADMISSION),voCareContextRef.getID_CareContext()});
		
		NeuroSenastionFindingsVoCollection voNeuroSenseFindingsColl = NeuroSenastionFindingsVoAssembler.createNeuroSenastionFindingsVoCollectionFromNeuExamSens(sense);
		if(voNeuroSenseFindingsColl != null && voNeuroSenseFindingsColl.size()>0)
		{
			voNeuroSensationExamination = new NeuroSensationExaminationVo();
			voNeuroSensationExamination.setNeuroSens(voNeuroSenseFindingsColl.get(0));
		}
		
		return voNeuroSensationExamination;
	}

	//wdev-13418
	public MedicalProbOnAdmisVo getPatientProblemByClinicalContact(	ClinicalContactShortVo voClinicalContact) 
	{
		DomainFactory factory = getDomainFactory();

		NeuroSensationExaminationVo voNeuroSensationExamination = new NeuroSensationExaminationVo();
		
		String hql = " from PatientProblem medicalProbOnAdmis "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		if(voClinicalContact != null)
		{
			condStr.append(andStr + " medicalProbOnAdmis.clinicalContact.id = :id_ClinicalContact"); 
			markers.add("id_ClinicalContact");
			values.add(voClinicalContact.getID_ClinicalContact());
			andStr = " and ";
		}	
		
		condStr.append(andStr + " medicalProbOnAdmis.problemContext = :problemContext"); 
		markers.add("problemContext");
		values.add("Neuro - Motor");
		andStr = " and ";
		
		if (andStr.equals(" and "))
			hql += " where ";
	
		hql += condStr.toString();
		MedicalProbOnAdmisVoCollection collMedicalProbOnAdmis = MedicalProbOnAdmisVoAssembler.createMedicalProbOnAdmisVoCollectionFromPatientProblem(factory.find(hql, markers, values));
		if(collMedicalProbOnAdmis.size()>0)
			return collMedicalProbOnAdmis.get(0);
		
		return null;

	}

	//wdev-13418
	public NeuroSenastionFindingsVoCollection getNeuroSensationRecordCollByClinCont(ClinicalContactShortVo voClinicalContact,NeuroSensationFindingsShortVo voNeuroSens) 
	{
		DomainFactory factory = getDomainFactory();

		String hql ; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
			
		if(voNeuroSens != null)
		{
			return getNeuroCollection(voNeuroSens);
			
		}
		else
		{
		
			NeuroSenastionFindingsVoCollection collNeuroSensationFindings = new NeuroSenastionFindingsVoCollection();
			hql = " from NeuExamSens neuExamSens"; 
			condStr = new StringBuffer();
			andStr = " ";
		
			markers = new ArrayList();
			values = new ArrayList();
		
			if(voClinicalContact.getID_ClinicalContactIsNotNull())
			{
				condStr.append(andStr + " neuExamSens.clinicalContact.id = :id_ClinicalContact"); 
				markers.add("id_ClinicalContact");
				values.add(voClinicalContact.getID_ClinicalContact());
				andStr = " and ";
			}	
			
			if (andStr.equals(" and "))
				hql += " where ";
		
			hql += condStr.toString();
			hql +=" order by neuExamSens.systemInformation.creationDateTime desc ";
			collNeuroSensationFindings = NeuroSenastionFindingsVoAssembler.createNeuroSenastionFindingsVoCollectionFromNeuExamSens(factory.find(hql, markers, values));
			return collNeuroSensationFindings;
		}
		
		

	}

	//wdev-13418
	public MedicalProbOnAdmisVo getPatientProblemByCareContext(	CareContextRefVo voCareContext) 
	{
		DomainFactory factory = getDomainFactory();

		NeuroSensationExaminationVo voNeuroSensationExamination = new NeuroSensationExaminationVo();
		
		String hql = " from PatientProblem medicalProbOnAdmis "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		if(voCareContext != null)
		{
			condStr.append(andStr + " medicalProbOnAdmis.careContext.id = :id"); 
			markers.add("id");
			values.add(voCareContext.getID_CareContext());
			andStr = " and ";
		}	
		
		condStr.append(andStr + " medicalProbOnAdmis.problemContext = :problemContext"); 
		markers.add("problemContext");
		values.add("Neuro - Motor");
		andStr = " and ";
		
		if (andStr.equals(" and "))
			hql += " where ";
	
		hql += condStr.toString();
		MedicalProbOnAdmisVoCollection collMedicalProbOnAdmis = MedicalProbOnAdmisVoAssembler.createMedicalProbOnAdmisVoCollectionFromPatientProblem(factory.find(hql, markers, values));
		if(collMedicalProbOnAdmis.size()>0)
			return collMedicalProbOnAdmis.get(0);
		
		return null;

	}

	//wdev-13418
	public NeuroSenastionFindingsVoCollection getNeuroSensationCollByCareContext(CareContextRefVo voCareContext,NeuroSensationFindingsShortVo voNeuroSensation) 
	{
		DomainFactory factory = getDomainFactory();

		String hql ; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
				
		if(voNeuroSensation != null)
		{
			return getNeuroCollection(voNeuroSensation);
			
		}
		else
		{
			NeuroSenastionFindingsVoCollection collNeuroSensationFindings = new NeuroSenastionFindingsVoCollection();
			hql = " from NeuExamSens neuExamSens"; 
			condStr = new StringBuffer();
			andStr = " ";
		
			markers = new ArrayList();
			values = new ArrayList();
		
			if(voCareContext.getID_CareContextIsNotNull())
			{
				condStr.append(andStr + " neuExamSens.careContext.id = :id"); 
				markers.add("id");
				values.add(voCareContext.getID_CareContext());
				andStr = " and ";
			}	
			
			condStr.append(andStr + " neuExamSens.clinicalContact.id is null"); 
			
			if (andStr.equals(" and "))
				hql += " where ";
		
			hql += condStr.toString();
			hql +=" order by neuExamSens.systemInformation.creationDateTime desc ";
			collNeuroSensationFindings = NeuroSenastionFindingsVoAssembler.createNeuroSenastionFindingsVoCollectionFromNeuExamSens(factory.find(hql, markers, values));
			return collNeuroSensationFindings;
		}

	}

	//wdev-13418
	public NeuroSenastionFindingsVoCollection getSpinalMedicalAdmissionSensationByCareContextColl(CareContextRefVo voCareContextRef) 
	{
		if (voCareContextRef == null || (voCareContextRef != null && voCareContextRef.getID_CareContext() == null))
			return null;

		DomainFactory factory = getDomainFactory();

		NeuroSensationExaminationVo voNeuroSensationExamination = null;
		
		List sense =   factory.find(" from NeuExamSens sense where sense.clinicalContact.id = " + 
				"( select cons.id from CareContext con join con.clinicalContacts cons where cons.contactType = :type and con.id = :idcare) order by sense.systemInformation.creationDateTime desc",
				new String[]{"type", "idcare" },
				new Object[]{ getDomLookup(ContactType.SPINALMEDICALADMISSION),voCareContextRef.getID_CareContext()});
		
		NeuroSenastionFindingsVoCollection voNeuroSenseFindingsColl = NeuroSenastionFindingsVoAssembler.createNeuroSenastionFindingsVoCollectionFromNeuExamSens(sense);
		
		
		return voNeuroSenseFindingsColl;
	}

}
