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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.71 build 3618.29606)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.daycaseadmissiondialog;

import ims.RefMan.vo.CatsReferralWizardVo;
import ims.RefMan.vo.PatientElectiveListBedAdmissionVo;
import ims.RefMan.vo.PatientElectiveListBedAdmissionVoCollection;
import ims.RefMan.vo.TCIOutcomeForPatientElectiveListVo;
import ims.RefMan.vo.lookups.AdmissionOfferOutcome;
import ims.RefMan.vo.lookups.TCIStatusChangeReason;
import ims.configuration.gen.ConfigFlag;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.InpatientEpisodeVo;
import ims.core.vo.LocShortMappingsVo;
import ims.core.vo.LocShortMappingsVoCollection;
import ims.core.vo.MedicLiteVo;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.MedicWithMappingsLiteVo;
import ims.core.vo.PasEventVo;
import ims.core.vo.PatientIdCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.lookups.AdmissionType;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.LookupHelper;
import ims.core.vo.lookups.PasEventType;
import ims.core.vo.lookups.PatIdType;
import ims.core.vo.lookups.PatIdTypeCollection;
import ims.core.vo.lookups.Specialty;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.emergency.vo.lookups.ElectiveListReason;
import ims.framework.MessageButtons;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;


	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
		populateDemographicINfo();
		populateClinicDetails();
		estimateDischargeDate();
	}
	
	@Override
	protected void onMessageBoxClosed(int messageBoxId, DialogResult result) throws PresentationLogicException
	{
		if (DialogResult.YES.equals(result))
		{
			PatientElectiveListBedAdmissionVo patientElectiveList = form.getLocalContext().getPatientElectiveList();
			PatientElectiveListBedAdmissionVoCollection differentPatientElectiveListForService = null;
			
			if (patientElectiveList != null)
			{
				differentPatientElectiveListForService = domain.getDifferentPatientElectiveListForService(form.getGlobalContext().Core.getPatientShort(), patientElectiveList, patientElectiveList.getElectiveList().getService());
				
				for (PatientElectiveListBedAdmissionVo patientElective : differentPatientElectiveListForService)
				{
					TCIOutcomeForPatientElectiveListVo outcome = new TCIOutcomeForPatientElectiveListVo();
					if (patientElective.getTCIDetails().getTCIDate().isLessThan(new ims.framework.utils.Date()))
						outcome.setOutcome(AdmissionOfferOutcome.ADMISSION_CANCELLED_BY_HOSPITAL_BEFORE_6);
					else
						outcome.setOutcome(AdmissionOfferOutcome.ADMISSION_CANCELLED_BY_HOSPITAL_ON_DAY_7);
					outcome.setChangeBy((MemberOfStaffRefVo) domain.getMosUser());
					outcome.setStatusDateTime(new DateTime());
					outcome.setOutcomeReason(TCIStatusChangeReason.CANCELLEDBYREMOVALOFELECTIVELISTRECORD);
					
					patientElective.getTCIDetails().setCurrentOutcome(outcome);
					patientElective.getTCIDetails().getOutcomeHistory().add(outcome);
					patientElective.getTCIDetails().setIsActive(false);
				}
			}
			
			if (saveAdmission(patientElectiveList, differentPatientElectiveListForService))
				engine.close(DialogResult.OK);
		}
		else if (DialogResult.NO.equals(result))
		{
			if (saveAdmission(form.getLocalContext().getPatientElectiveList(), null))
				engine.close(DialogResult.OK);
		}
	}

	private void estimateDischargeDate()
	{
	//	if (form.getGlobalContext().RefMan.getTheatreAdmitDetailsIsNotNull()
	//		&& form.getGlobalContext().RefMan.getTheatreAdmitDetails().getLOSIsNotNull())
	//		form.dteEstDischDate().setValue(new DateTime().addDays(form.getGlobalContext().RefMan.getTheatreAdmitDetails().getLOS()).getDate());
	}

	private void populateClinicDetails()
	{
		form.lblClinicName().setValue(form.getGlobalContext().RefMan.getDayCaseAdmClinicName());
		form.lblApptTime().setValue(form.getGlobalContext().RefMan.getDayCaseAdmApptTime());
	}

	private void populateDemographicINfo() 
	{
		PatientShort pat = form.getGlobalContext().Core.getPatientShort();
		
		if (pat == null)
			throw new DomainRuntimeException("No Patient Supplied");

		if (pat.getNameIsNotNull())
		{
			form.lblSurname().setValue(pat.getName().getSurname());
			form.lblForename().setValue(pat.getName().getForename());
		}

		form.lblSex().setValue(pat.getSexIsNotNull() ? pat.getSex().toString() : "");
		form.lblDOB().setValue(pat.getDobIsNotNull() ? pat.getDob().toString() : "");

		

		PatientIdCollection identifers = pat.getIdentifiers();
		if (identifers != null)
		{
			for (int i = 0; i < identifers.size(); i++)
			{
				ims.core.vo.PatientId id = identifers.get(i);
				ims.RefMan.forms.daycaseadmissiondialog.GenForm.grdIdentifiersRow row = form.grdIdentifiers().getRows().newRow();
				bindColType(row, false);
				row.getcolIdType().setValue(id.getType());
				row.setcolIdValue(id.getValue());
				row.setValue(id);
				if (id.getVerifiedIsNotNull() && !id.getVerified() && id.getType().equals(PatIdType.NHSN))
				{
					row.setBackColor(Color.Orange);
					row.setReadOnly(true);
				}
				if (id.getTypeIsNotNull() && id.getType().equals(PatIdType.NHSN) && !ConfigFlag.GEN.ALLOW_UPDATES_TO_NHS_NO.getValue())
					row.setReadOnly(true);

			}
		}
	}
	private void bindColType(ims.RefMan.forms.daycaseadmissiondialog.GenForm.grdIdentifiersRow row, boolean isNew)
	{
		row.getcolIdType().clear();
		PatIdTypeCollection collTypes = LookupHelper.getPatIdType(domain.getLookupService());
		for(int i=0;i<collTypes.size();i++)
		{
			if(ConfigFlag.DOM.HEARTS_REPLICATE_PATIENTS.getValue())
			{
				if(isNew)
				{
					if(collTypes.get(i).equals(PatIdType.HOSPNUM) || collTypes.get(i).equals(PatIdType.PKEY))
						continue;
				}
			}
			row.getcolIdType().newRow(collTypes.get(i), collTypes.get(i).getText());
		}
	}


	private void initialise() 
	{
		// WDEV-12293 -  Get service for CatsReferral (but we need to pass the CareContext id as the CatsReferral is not available in context)
		// and default the speciality combo box to it
		Specialty specialty = domain.getReferralSpecialty(form.getGlobalContext().Scheduling.getBookingAppointmentRef());
		form.cmbSpecialty().setValue(specialty);
		
		
		if (form.getGlobalContext().RefMan.getDayCaseAdmApptDateIsNotNull() && form.getGlobalContext().RefMan.getDayCaseAdmApptTimeIsNotNull())
			form.dtimAdmDateTime().setValue(new DateTime(form.getGlobalContext().RefMan.getDayCaseAdmApptDate(), new Time(form.getGlobalContext().RefMan.getDayCaseAdmApptTime())));
		else if (form.getGlobalContext().RefMan.getDayCaseAdmApptDateIsNotNull() && form.getGlobalContext().RefMan.getDayCaseAdmApptTime() == null)
			form.dtimAdmDateTime().setValue(new DateTime(form.getGlobalContext().RefMan.getDayCaseAdmApptDate(), new Time()));
		else
			form.dtimAdmDateTime().setValue(new DateTime());
			
		populateWardCombo();
		
		HcpLiteVo hcpLiteVo = (HcpLiteVo) domain.getHcpLiteUser();
		if (hcpLiteVo != null
			&& hcpLiteVo.getHcpTypeIsNotNull() 
			&& hcpLiteVo.getHcpType().equals(HcpDisType.MEDICAL))
		{
			MedicLiteVo vo = new MedicLiteVo(hcpLiteVo.getID_Hcp(), hcpLiteVo.getVersion_Hcp());
			form.qmbConsultant().newRow( vo, hcpLiteVo.getName().toString());
			form.qmbConsultant().setValue(vo);
		}
	}

	private String[] validateUILogic()
	{
		ArrayList<String> errs = new ArrayList<String>();

		if (form.qmbConsultant().getValue() == null)
			errs.add("Admitting Consultant must be specified.");
		if (form.dtimAdmDateTime().getValue() == null)
			errs.add("Admission Date/Time must be specified.");
		if (form.cmbSpecialty().getValue() == null)
			errs.add("Specialty must be specified.");
		if (form.cmbWard().getValue() == null)
			errs.add("Ward must be specified.");
		
		return errs.toArray(new String[errs.size()]);
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		PatientElectiveListBedAdmissionVo patientElectiveList = null;
		if (Boolean.TRUE.equals(ConfigFlag.GEN.USE_ELECTIVE_LIST_FUNCTIONALITY.getValue()))
		{
			// Get current Patient Elective List
			patientElectiveList = domain.getPatientElectiveListForAppointment(form.getGlobalContext().Scheduling.getBookingAppointmentRef());
			
			if (patientElectiveList != null)
			{
				if (Specialty.EMERGENCY.equals(form.cmbSpecialty().getValue()))
				{
					// If there are no other elective list to be cancelled
					TCIOutcomeForPatientElectiveListVo outcome = new TCIOutcomeForPatientElectiveListVo();
					
					if (ElectiveListReason.DIAGNOSTIC.equals(patientElectiveList.getElectiveListReason()))
						outcome.setOutcome(AdmissionOfferOutcome.PATIENT_ADMITTED);
					else
						outcome.setOutcome(AdmissionOfferOutcome.PATIENT_ADMITTED_COMMENCED_8);
					
					outcome.setChangeBy((MemberOfStaffRefVo) domain.getMosUser());
					outcome.setStatusDateTime(new DateTime());
					outcome.setOutcomeReason(null);
					
					patientElectiveList.getTCIDetails().setCurrentOutcome(outcome);
					patientElectiveList.getTCIDetails().getOutcomeHistory().add(outcome);
					patientElectiveList.getTCIDetails().setIsActive(Boolean.FALSE);
					
					if (ElectiveListReason.DIAGNOSTIC.equals(patientElectiveList.getElectiveListReason()))
					{
						if (patientElectiveList.getPathwayClock() != null)
							patientElectiveList.getPathwayClock().setStopDate(form.dtimAdmDateTime().getValue() != null ? form.dtimAdmDateTime().getValue().getDate() : null);
					}

					// Check for existing Patient Elective list
					if (Boolean.TRUE.equals(domain.hasPatientElectiveListsToBeCancelled(form.getGlobalContext().Core.getPatientShort(), patientElectiveList, patientElectiveList.getElectiveList().getService())))
					{
						form.getLocalContext().setPatientElectiveList(patientElectiveList);
						engine.showMessage("Patient has other Patient Elective records for the same service. Cancel these records?", "Warning", MessageButtons.YESNOCANCEL);
						return;
					}
				}
			}
		}

		if (saveAdmission(patientElectiveList, null))
			engine.close(DialogResult.OK);
	}

	private boolean saveAdmission(PatientElectiveListBedAdmissionVo patientElectiveList, PatientElectiveListBedAdmissionVoCollection differentPatientElectiveListForService)
	{
		PasEventVo voPasEvent = new PasEventVo();
		if (form.qmbConsultant().getValue() != null)
		{
			MedicWithMappingsLiteVo medLite = new MedicWithMappingsLiteVo(form.qmbConsultant().getValue().getID_Hcp(), form.qmbConsultant().getValue().getVersion_Hcp());
			voPasEvent.setConsultant(medLite);
		}
		
		voPasEvent.setEventDateTime(form.dtimAdmDateTime().getValue());
		voPasEvent.setEventType(PasEventType.INPATIENT);
		voPasEvent.setIsVip(false);
		voPasEvent.setLocation(form.cmbWard().getValue());
		voPasEvent.setPatient(form.getGlobalContext().Core.getPatientShort());
		voPasEvent.setSpecialty(form.cmbSpecialty().getValue());
		voPasEvent.setPasEventId(new DateTime().toString());
		voPasEvent.setService(patientElectiveList != null && patientElectiveList.getElectiveListIsNotNull() ? patientElectiveList.getElectiveList().getService() : null); //WDEV-20900
		
		InpatientEpisodeVo voInpatientEpis = new InpatientEpisodeVo();
		voInpatientEpis.setIsOnLeave(false);
		voInpatientEpis.setAdmissionDateTime(form.dtimAdmDateTime().getValue());
		voInpatientEpis.setEstDischargeDate(new DateTime(form.dteEstDischDate().getValue(),new Time(0,0)));
		voInpatientEpis.setPasEvent(voPasEvent);
		voInpatientEpis.setBedNo(form.txtBedNo().getValue());
		voInpatientEpis.setAdmissionType(AdmissionType.DAY_CASE);
		
		String[] arrErrors = voInpatientEpis.validate(validateUILogic());
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		arrErrors = form.getGlobalContext().Core.getPatientShort().validate(arrErrors);
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		try
		{
			//CatsReferralWizardVo voCats = domain.getCatsReferralWizardVoForCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			CatsReferralWizardVo voCats = domain.getCatsReferral(form.getGlobalContext().Scheduling.getBookingAppointmentRef());
			if (voCats.getRequiresDischargeRep() == null)
			{
				voCats.setRequiresDischargeRep(null);
				String [] errors2 = voCats.validate();
				if (errors2 != null && errors2.length > 0)
				{
					engine.showErrors(errors2);
					return false;
				}
			}
			
			CareContextShortVo voCC = domain.admitPatient(form.getGlobalContext().Core.getPatientShort(), voInpatientEpis, form.getGlobalContext().Scheduling.getBookingAppointmentRef(), voCats, patientElectiveList, differentPatientElectiveListForService);
			if (voCC != null)
				form.getGlobalContext().Core.setCurrentCareContext(voCC);
			
			return true;
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		catch (ForeignKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
	}
	
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	private void populateWardCombo()
	{
		form.cmbWard().clear();

		if (form.getGlobalContext().Core.getHospitalLocIsNotNull())
		{
			LocShortMappingsVoCollection voLocShortMapColl = domain.listActiveWardsForHospital(form.getGlobalContext().Core.getHospitalLoc());
			if (voLocShortMapColl != null)
			{
				for (int i = 0; i < voLocShortMapColl.size(); i++)
				{
					LocShortMappingsVo voLocShortMap = voLocShortMapColl.get(i);
					form.cmbWard().newRow(voLocShortMap, voLocShortMap.getName());
				}
			}
		}

	}

	@Override
	protected void onQmbConsultantTextSubmited(String value) throws PresentationLogicException 
	{
		form.qmbConsultant().clear();

		if (value != null)
		{
			MedicLiteVo med = null;
			MedicLiteVoCollection voMedicColl = domain.listActiveMedics(value);
			if (voMedicColl != null)
			{
				for (int i = 0; i < voMedicColl.size(); i++)
				{
					med = voMedicColl.get(i);
					form.qmbConsultant().newRow(med, med.toString());			
				}
			}
			if (voMedicColl != null &&
					voMedicColl.size() == 1)
							form.qmbConsultant().setValue(voMedicColl.get(0));
			else if (voMedicColl != null &&
						voMedicColl.size() > 1)
							form.qmbConsultant().showOpened();
			
	
			Integer id = engine.getLoggedInUser().getHcpId();
			if (med != null && id != null && id.equals(med.getID_Hcp()))
				form.qmbConsultant().setValue(med);
		}
	}
}
