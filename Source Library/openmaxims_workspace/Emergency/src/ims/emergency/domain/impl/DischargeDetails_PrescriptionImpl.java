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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5127.24028)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.clinical.domain.objects.PatientMedication;
import ims.core.configuration.domain.objects.AppForm;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.PatientMedicationLiteVo;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.domain.base.impl.BaseDischargeDetails_PrescriptionImpl;
import ims.emergency.domain.objects.EDPrescription;
import ims.emergency.vo.AppFormForPrescriptionVo;
import ims.emergency.vo.EDPrescriptionRefVo;
import ims.emergency.vo.EDPrescriptionVo;
import ims.emergency.vo.domain.AppFormForPrescriptionVoAssembler;
import ims.emergency.vo.domain.EDPrescriptionVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;
import ims.vo.ValueObject;

import java.util.List;

public class DischargeDetails_PrescriptionImpl extends BaseDischargeDetails_PrescriptionImpl
{

	private static final long serialVersionUID = 1L;

	public ims.emergency.vo.EDPrescriptionVoCollection listPrescriptions(ims.core.admin.vo.CareContextRefVo careContextRef)
	{
		if (careContextRef == null)
			throw new CodingRuntimeException(" The care context reference must be provided");
	
		StringBuilder mainHql = new StringBuilder();
			
		mainHql.append("select presc from EDPrescription as presc LEFT JOIN presc.attendance as cc WHERE cc.id = :CONTEXTID AND presc.isRIE is null OR presc.isRIE = 0 ORDER BY presc.authoringInformation.authoringDateTime DESC");
		
		DomainFactory domainFactory = getDomainFactory();
		
		List<?> prescriptionsList = domainFactory.find(mainHql.toString(), new String[] {"CONTEXTID"}, new Object[] {careContextRef.getID_CareContext()});
		
		return EDPrescriptionVoAssembler.createEDPrescriptionVoCollectionFromEDPrescription(prescriptionsList);
	}

	public EDPrescriptionVo getPrescription(EDPrescriptionRefVo prescRefVo)
	{
		if (prescRefVo == null || prescRefVo.getID_EDPrescription() == null)
			throw new CodingRuntimeException("Cannot retrieve Prescription for null reference.");
		
		DomainFactory factory = getDomainFactory();
		
		EDPrescription prescriptionDO = (EDPrescription)factory.getDomainObject(EDPrescription.class, prescRefVo.getID_EDPrescription());
		
		return EDPrescriptionVoAssembler.create(prescriptionDO);
	}

	
	public EDPrescriptionVo savePrescription(EDPrescriptionVo prescVo)	throws StaleObjectException
	{
		if (prescVo == null)
			throw new CodingRuntimeException("Cannot save a null EDPrescriptionVo object.");
		if (!prescVo.isValidated())
			throw new CodingRuntimeException("Cannot save an invalid EDPrescriptionVo object.");
		
		DomainFactory factory = getDomainFactory();
		
		EDPrescription prescriptionDO = EDPrescriptionVoAssembler.extractEDPrescription(factory, prescVo);
		
		factory.save(prescriptionDO);
		
		return EDPrescriptionVoAssembler.create(prescriptionDO);
	}

	public CareContextShortVo getCareContextShort(CareContextRefVo careContextRef)
	{
		if (careContextRef == null)
			throw new CodingRuntimeException("Cannot retrieve Care Context for null reference.");
		
		DomainFactory factory = getDomainFactory();
		
		CareContext careContextDO = (CareContext)factory.getDomainObject(CareContext.class, careContextRef.getID_CareContext());
		
		return CareContextShortVoAssembler.create(careContextDO);
	}

	public AppFormForPrescriptionVo getAppFormWithMenuActions(Integer formID)
	{
		AppForm appForm = (AppForm) getDomainFactory().getDomainObject(AppForm.class, formID);
		
		return AppFormForPrescriptionVoAssembler.create(appForm);
	}
	//WDEV-19588
	public Boolean isStale(ValueObject objectVo)
	{
		if (objectVo == null || !(objectVo instanceof ValueObject))
			throw new CodingRuntimeException("Cannot retrieve value for null reference or invalid object.");
		
		EDPrescription prescriptionDO = null;
		PatientMedication medicationDO = null;
		DomainFactory factory = getDomainFactory();
		
		if (objectVo instanceof EDPrescriptionVo)
		{	
			prescriptionDO = (EDPrescription) factory.findFirst("select prescription from EDPrescription as prescription where prescription.id = :PRESC_ID " , "PRESC_ID", ((EDPrescriptionVo) objectVo).getID_EDPrescription());
			return  prescriptionDO != null && prescriptionDO.getVersion() > ((EDPrescriptionVo) objectVo).getVersion_EDPrescription();
		}		 
		else if (objectVo instanceof PatientMedicationLiteVo)
		{	
			medicationDO = (PatientMedication) factory.findFirst("select med from PatientMedication as med where med.id = :MED_ID " , "MED_ID", ((PatientMedicationLiteVo) objectVo).getID_PatientMedication());
			return medicationDO != null && medicationDO.getVersion() > ((PatientMedicationLiteVo) objectVo).getVersion_PatientMedication();
 		}			
	    return false;				
	}
}
