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
// This code was generated by Peter Martin using IMS Development Environment (version 1.70 build 3545.21176)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.RefMan.domain.base.impl.BaseClinicalNotesComponentImpl;
import ims.RefMan.domain.objects.ConsultationClinicalNotes;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.CodingRuntimeException;
import ims.RefMan.vo.ConsultationClinicalNotesRefVo;
import ims.RefMan.vo.ConsultationClinicalNotesVoCollection;
import ims.RefMan.vo.domain.ConsultationClinicalNotesVoAssembler;
import ims.clinical.domain.Allergies;
import ims.clinical.domain.impl.AllergiesImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.PatientAllergyCollection;
import ims.core.vo.PatientNoAllergyInfoVo;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.PatientShortAssembler;

public class ClinicalNotesComponentImpl extends BaseClinicalNotesComponentImpl
{
	private static final long serialVersionUID = 1L;

	public ims.RefMan.vo.ConsultationClinicalNotesVo getConsultationClinicalNotesVo(ims.RefMan.vo.CatsReferralRefVo refVoCatsReferral)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" from ConsultationClinicalNotes ccn"); 
	
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Integer> values = new ArrayList<Integer>();
	
		hql.append(" where ccn.catsReferral.id = :crId ");
		
		markers.add("crId");
		values.add(refVoCatsReferral.getID_CatsReferral());
		
		List listNotes = factory.find(hql.toString(), markers,values);
		if(listNotes != null && listNotes.size() > 0)
		{ 
			ConsultationClinicalNotesVoCollection voColl = ConsultationClinicalNotesVoAssembler.createConsultationClinicalNotesVoCollectionFromConsultationClinicalNotes(listNotes);
			if(voColl != null && voColl.size() > 0) 
			{
				voColl.sort(SortOrder.DESCENDING);
				return voColl.get(0);
			}
		}
		return null;
		
	}
		
	public ims.RefMan.vo.ConsultationClinicalNotesVo getNote(ConsultationClinicalNotesRefVo note)
	{
		if (note == null)
			throw new RuntimeException("Cannot get ConsultationClinicalNotesVo for null ConsultationClinicalNotesRefVo");

		ConsultationClinicalNotes doConsultationClinicalNotes = (ConsultationClinicalNotes) getDomainFactory().getDomainObject(ConsultationClinicalNotes.class, note.getID_ConsultationClinicalNotes());
		return ConsultationClinicalNotesVoAssembler.create(doConsultationClinicalNotes);		
	}

	public ims.RefMan.vo.ConsultationClinicalNotesVo saveConsultationClinicalNotesVo(ims.RefMan.vo.ConsultationClinicalNotesVo voConsultationClinicalNotes) throws ims.domain.exceptions.StaleObjectException
	{
		if(voConsultationClinicalNotes == null)
			throw new CodingRuntimeException("ConsultationClinicalNotesVo is null");
		if(!voConsultationClinicalNotes.isValidated())
			throw new CodingRuntimeException("ConsultationClinicalNotesVo has not been validated");
		
		DomainFactory factory = getDomainFactory();
		ConsultationClinicalNotes doConsultationClinicalNotes = ConsultationClinicalNotesVoAssembler.extractConsultationClinicalNotes(factory, voConsultationClinicalNotes);
		factory.save(doConsultationClinicalNotes);
		
		return ConsultationClinicalNotesVoAssembler.create(doConsultationClinicalNotes);
	}

	public HcpLiteVoCollection listHcpLiteByName(String hcpName) {
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listHcpLiteByName(hcpName);
	}

	public PatientAllergyCollection listPatientAllergies(PatientShort patient) 
	{
		Allergies allergies = (Allergies)getDomainImpl(AllergiesImpl.class);
		return allergies.listPatientAllergies(patient, true);
	}

	public PatientNoAllergyInfoVo getPatientNoAllergyInfo(PatientRefVo patientRefVo) 
	{
		Allergies allergies = (Allergies)getDomainImpl(AllergiesImpl.class);
		return allergies.getPatientNoAllergyInfo(patientRefVo);
	}

	public PatientNoAllergyInfoVo savePatientNoAllergyInfo(PatientNoAllergyInfoVo patientNoAllergyInfo) throws StaleObjectException, UniqueKeyViolationException 
	{
		Allergies allergies = (Allergies)getDomainImpl(AllergiesImpl.class);
		return allergies.savePatientNoAllergyInfo(patientNoAllergyInfo);
	}

	//wdev-10534
	public PatientShort getPatientShort(PatientRefVo patientRefVo) 
	{
		DomainFactory factory = getDomainFactory();
		ims.core.patient.domain.objects.Patient patBo = (ims.core.patient.domain.objects.Patient) factory.getDomainObject(ims.core.patient.domain.objects.Patient.class, patientRefVo.getID_Patient().intValue());
		return PatientShortAssembler.create(patBo);
	}
}
