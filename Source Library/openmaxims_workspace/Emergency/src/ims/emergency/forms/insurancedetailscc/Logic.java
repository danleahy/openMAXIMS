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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 5127.24028)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.insurancedetailscc;

import ims.admin.vo.EDAttendanceControlsConfigVo;
import ims.admin.vo.EDAttendanceControlsConfigVoCollection;
import ims.admin.vo.lookups.EDAttendenceControlType;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.NationalHealthCoverVo;
import ims.core.vo.PatientMedicalInsuranceVo;
import ims.core.vo.PrivateInsuranceCompanyVoCollection;
import ims.core.vo.lookups.PrivateInsurancePolicyType;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.emergency.vo.EmergencyAttendanceNonInsuranceHealthCoverVo;
import ims.emergency.vo.PatientWithNonHealthCoverLiteVo;
import ims.emergency.vo.enums.EmergencyAttendanceEvent;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	private static final String INSURANCE_SCHEME 		= "ID01";
	private static final String REGISTRATION_NUMBER 	= "ID02";
	private static final String POLICY_TYPE				= "ID03";
	private static final String OTHER 					= "ID04";
	private static final String RENEWAL_DATE 			= "ID05";
	private static final String ELIGIBILITY 			= "ID06";
	private static final String MEDICAL_CARD_NO 		= "ID07";
	private static final String PROVED 					= "ID08";
	private static final String ELIGIBILITY_PROOF 		= "ID09";
	private static final String EXPIRY_DATE 			= "ID10";
	private static final String EHIC_NUMBER 			= "ID11";
	private static final String EHIC_EXPIRY 			= "ID12";
	private static final String COUNTRY 				= "ID13";
	private static final String IDRNT_OF_INSTITUTION	= "ID14";
	
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance(false);	//wdev-19085 //WDEV-22956
	}
	//wdev-19085
	public void newInstance(Boolean isNewAttendance)  //WDEV-22801 WDEV-22956
	{
		//WDEV-22956
		clearScreen();
		populateInsuranceSchemeCombo();
		form.getLocalContext().setIsNewAttendance(isNewAttendance);

		form.setMode(FormMode.EDIT);
		
		if( form.getLocalContext().getCurrentEmergencyAttendanceNonInsuranceHealthCoverVoIsNotNull() && form.getLocalContext().getCurrentEmergencyAttendanceNonInsuranceHealthCoverVo().getPatientIsNotNull() )
		{
			PatientWithNonHealthCoverLiteVo tempatVo = domain.getPatientWithNonHealthCoverLiteVo(form.getLocalContext().getCurrentEmergencyAttendanceNonInsuranceHealthCoverVo().getPatient());
			
			if( tempatVo != null && (tempatVo.getCurrentMedicalInsuranceIsNotNull() || tempatVo.getNationalHealthCoverIsNotNull() ))
			{
				populateScreenFromPatient(tempatVo);	
			}
		}
		
		form.getLocalContext().setSelectedEvent(EmergencyAttendanceEvent.NEW);
		form.fireCustomControlValueChanged();
	}
	private void populateScreenFromPatient(PatientWithNonHealthCoverLiteVo tempatVo )
	{
		if( tempatVo == null )
			return;
		if( tempatVo.getNationalHealthCoverIsNotNull() )
		{
    		form.txtMedicalCardNo().setValue(tempatVo.getNationalHealthCover().getMedicalCardNo());
    		form.pdtExpiryDate().setValue(tempatVo.getNationalHealthCover().getMedicalCardExpiryDate());
    		form.cmbEligibility().setValue(tempatVo.getNationalHealthCover().getHealthActCategory());
    		form.cmbProved().setValue(tempatVo.getNationalHealthCover().getMedicalCardProved());
    		form.txtEligibilityProof().setValue(tempatVo.getNationalHealthCover().getEligibilityProof());
			form.txtEHICNumber().setValue(tempatVo.getNationalHealthCover().getEHICNumber());
    		form.pdtEHICExpiry().setValue(tempatVo.getNationalHealthCover().getEHICExpiryDate());
    		form.cmbCountry().setValue(tempatVo.getNationalHealthCover().getEHICCountry());
    		form.txtIdentofInstitution().setValue(tempatVo.getNationalHealthCover().getEHICInstitution());
		}
		
		if( tempatVo.getCurrentMedicalInsuranceIsNotNull())
		{
    		if( form.cmbInsurer().getValues().contains(tempatVo.getCurrentMedicalInsurance().getCompany()))
    			form.cmbInsurer().setValue(tempatVo.getCurrentMedicalInsurance().getCompany());
    		else
    		{
    			if( tempatVo.getCurrentMedicalInsurance().getCompanyIsNotNull() )
    			{
        			form.cmbInsurer().newRow(tempatVo.getCurrentMedicalInsurance().getCompany(), tempatVo.getCurrentMedicalInsurance().getCompany().getIItemText());
        			form.cmbInsurer().setValue(tempatVo.getCurrentMedicalInsurance().getCompany());
    			}
    		}
    		//form.cmbInsuranceScheme().setValue(emergencyAttendInsurance.getPatientMedicalInsurance().getCompany());
    		form.txtPolicyNumber().setValue(tempatVo.getCurrentMedicalInsurance().getPolicyNumber());
    		form.cmbPolicyType().setValue(tempatVo.getCurrentMedicalInsurance().getPolicyType());
    		form.txtOther().setValue(tempatVo.getCurrentMedicalInsurance().getPlanOrUnits());
    		form.dteRenewalDate().setValue(tempatVo.getCurrentMedicalInsurance().getExpiryDate());
		}
		
	}
	
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
				
		form.setMode(FormMode.EDIT);
		form.getLocalContext().setSelectedEvent(EmergencyAttendanceEvent.EDIT);
		form.fireCustomControlValueChanged();
		
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (ConfigFlag.UI.SVUH_MANDATORY_DEMOGRAPHIC_ATTRIBUTES.getValue() && Boolean.TRUE.equals(form.getLocalContext().getIsNewAttendance())) //WDEV-22956
		{
			form.getLocalContext().setSelectedEvent(EmergencyAttendanceEvent.FINISH_SAVE);
			form.fireCustomControlValueChanged();
			return;
		}
		
		if( save())
		{
			form.getLocalContext().setSelectedEvent(EmergencyAttendanceEvent.SAVE);
			form.fireCustomControlValueChanged();
		}
	}


	@Override
	protected void onCmbPolicyTypeValueChanged() throws PresentationLogicException
	{
		if (!PrivateInsurancePolicyType.OTHER.equals(form.cmbPolicyType().getValue()))
			form.txtOther().setValue(null);
		
		updateControlState();
	}
	
	
	private boolean save()
	{
		EmergencyAttendanceNonInsuranceHealthCoverVo emergencyAttendInsurance = populateDataFromScreen(form.getLocalContext().getCurrentEmergencyAttendanceNonInsuranceHealthCoverVo());

		//
		//to do - check if the last attendance is selected , if yes then the insurances should be populated to Patient record
		//
		
		/*EmergencyAttendanceNonInsuranceHealthCoverVo lastemergencyAttendInsurance = domain.getLastEmergencyAttendanceNonInsuranceHealthCover(form.getLocalContext().getPatientRef());  //get the last attendance crteated for the patient
		if( lastemergencyAttendInsurance != null )
		{
			if( lastemergencyAttendInsurance.getID_EmergencyAttendance().equals(emergencyAttendInsurance.getID_EmergencyAttendance() ))  //check if it is the current attendance - the last one
			{
				emergencyAttendInsurance = populateInsuranceForPatient(emergencyAttendInsurance,null);	//populate insurance details  in patient record from screen 
			}
			//else		// if it is not- I.E. the has user selected an old attendancedetails
			//{
			//	emergencyAttendInsurance = populateInsuranceForPatient(emergencyAttendInsurance,lastemergencyAttendInsurance);	//populate insurance details  in patient record from last attendance details for patient
			//}
		}*/
		
		String[] errors = emergencyAttendInsurance.validate(getUIErrors());
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		
			
		
		try
		{
			form.getLocalContext().setCurrentEmergencyAttendanceNonInsuranceHealthCoverVo(domain.saveRecord(emergencyAttendInsurance));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			form.getLocalContext().setSelectedEvent(EmergencyAttendanceEvent.CANCEL);
			form.fireCustomControlValueChanged();
			return false;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			form.getLocalContext().setSelectedEvent(EmergencyAttendanceEvent.CANCEL);
			form.fireCustomControlValueChanged();
			return false;
		}

		return true;
	}
	private EmergencyAttendanceNonInsuranceHealthCoverVo populateInsuranceForPatient(EmergencyAttendanceNonInsuranceHealthCoverVo emergencyAttendInsurance, EmergencyAttendanceNonInsuranceHealthCoverVo lastemergencyAttendInsurance)
	{
		
		if( lastemergencyAttendInsurance == null)
		{
			if( !emergencyAttendInsurance.getPatient().getNationalHealthCoverIsNotNull() )
				emergencyAttendInsurance.getPatient().setNationalHealthCover(new NationalHealthCoverVo());
			
			if( !emergencyAttendInsurance.getPatient().getCurrentMedicalInsuranceIsNotNull())
				emergencyAttendInsurance.getPatient().setCurrentMedicalInsurance(new PatientMedicalInsuranceVo());
			
			emergencyAttendInsurance.getPatient().getNationalHealthCover().setMedicalCardNo(form.txtMedicalCardNo().getValue());
			emergencyAttendInsurance.getPatient().getNationalHealthCover().setMedicalCardExpiryDate(form.pdtExpiryDate().getValue());
			emergencyAttendInsurance.getPatient().getNationalHealthCover().setHealthActCategory(form.cmbEligibility().getValue());
			emergencyAttendInsurance.getPatient().getNationalHealthCover().setMedicalCardProved(form.cmbProved().getValue());
			emergencyAttendInsurance.getPatient().getNationalHealthCover().setEligibilityProof(form.txtEligibilityProof().getValue());
			
			emergencyAttendInsurance.getPatient().getNationalHealthCover().setEHICNumber(form.txtEHICNumber().getValue());
			emergencyAttendInsurance.getPatient().getNationalHealthCover().setEHICExpiryDate(form.pdtEHICExpiry().getValue());
			emergencyAttendInsurance.getPatient().getNationalHealthCover().setEHICCountry(form.cmbCountry().getValue());
			emergencyAttendInsurance.getPatient().getNationalHealthCover().setEHICInstitution(form.txtIdentofInstitution().getValue());
			
			
			emergencyAttendInsurance.getPatient().getCurrentMedicalInsurance().setPatient(emergencyAttendInsurance.getPatient());
			emergencyAttendInsurance.getPatient().getCurrentMedicalInsurance().setCompany(form.cmbInsurer().getValue());
			emergencyAttendInsurance.getPatient().getCurrentMedicalInsurance().setPolicyNumber(form.txtPolicyNumber().getValue());
			emergencyAttendInsurance.getPatient().getCurrentMedicalInsurance().setPolicyType(form.cmbPolicyType().getValue());
			emergencyAttendInsurance.getPatient().getCurrentMedicalInsurance().setPlanOrUnits(form.txtOther().getValue());
			emergencyAttendInsurance.getPatient().getCurrentMedicalInsurance().setExpiryDate(form.dteRenewalDate().getValue());
			//emergencyAttendInsurance.getPatient().setNationalHealthCover(emergencyAttendInsurance.getInsurance());
			//emergencyAttendInsurance.getPatient().setCurrentMedicalInsurance(emergencyAttendInsurance.getPatientMedicalInsurance());
			
		}
		else
		{
			if( lastemergencyAttendInsurance.getInsuranceIsNotNull())
			{
				//emergencyAttendInsurance.getPatient().setNationalHealthCover(lastemergencyAttendInsurance.getInsurance());
				if( !emergencyAttendInsurance.getPatient().getNationalHealthCoverIsNotNull() )
					emergencyAttendInsurance.getPatient().setNationalHealthCover(new NationalHealthCoverVo());
				
    			emergencyAttendInsurance.getPatient().getNationalHealthCover().setMedicalCardNo(lastemergencyAttendInsurance.getInsurance().getMedicalCardNo());
    			emergencyAttendInsurance.getPatient().getNationalHealthCover().setMedicalCardExpiryDate(lastemergencyAttendInsurance.getInsurance().getMedicalCardExpiryDate());
    			emergencyAttendInsurance.getPatient().getNationalHealthCover().setHealthActCategory(lastemergencyAttendInsurance.getInsurance().getHealthActCategory());
    			emergencyAttendInsurance.getPatient().getNationalHealthCover().setMedicalCardProved(lastemergencyAttendInsurance.getInsurance().getMedicalCardProved());
    			emergencyAttendInsurance.getPatient().getNationalHealthCover().setEligibilityProof(lastemergencyAttendInsurance.getInsurance().getEligibilityProof());
    			
    			emergencyAttendInsurance.getPatient().getNationalHealthCover().setEHICNumber(lastemergencyAttendInsurance.getInsurance().getEHICNumber());
    			emergencyAttendInsurance.getPatient().getNationalHealthCover().setEHICExpiryDate(lastemergencyAttendInsurance.getInsurance().getEHICExpiryDate());
    			emergencyAttendInsurance.getPatient().getNationalHealthCover().setEHICCountry(lastemergencyAttendInsurance.getInsurance().getEHICCountry());
    			emergencyAttendInsurance.getPatient().getNationalHealthCover().setEHICInstitution(lastemergencyAttendInsurance.getInsurance().getEHICInstitution()); 
			}
			
			if( emergencyAttendInsurance.getPatient().getCurrentMedicalInsuranceIsNotNull())
			{
				if( !emergencyAttendInsurance.getPatient().getCurrentMedicalInsuranceIsNotNull())
					emergencyAttendInsurance.getPatient().setCurrentMedicalInsurance(new PatientMedicalInsuranceVo());
						
				emergencyAttendInsurance.getPatient().getCurrentMedicalInsurance().setPatient(emergencyAttendInsurance.getPatient());
    			emergencyAttendInsurance.getPatient().getCurrentMedicalInsurance().setCompany(emergencyAttendInsurance.getPatient().getCurrentMedicalInsurance().getCompany());
    			emergencyAttendInsurance.getPatient().getCurrentMedicalInsurance().setPolicyNumber(emergencyAttendInsurance.getPatient().getCurrentMedicalInsurance().getPolicyNumber());
    			emergencyAttendInsurance.getPatient().getCurrentMedicalInsurance().setPlanOrUnits(emergencyAttendInsurance.getPatient().getCurrentMedicalInsurance().getPlanOrUnits());
    			emergencyAttendInsurance.getPatient().getCurrentMedicalInsurance().setExpiryDate(emergencyAttendInsurance.getPatient().getCurrentMedicalInsurance().getExpiryDate()); 
				//emergencyAttendInsurance.getPatient().setCurrentMedicalInsurance(emergencyAttendInsurance.getPatient().getCurrentMedicalInsurance());
				
    			
			}
		}
		
		return emergencyAttendInsurance;
	}
	
	private String[] getUIErrors()
	{
		ArrayList<String> errors = new ArrayList<String>();

		//WDEV-19528 
		if (form.cmbInsurer().getValue() == null)
		{
			errors.add("Insurer is mandatory.");
		}

		if (form.txtPolicyNumber().isRequired() && form.txtPolicyNumber().isVisible() && form.txtPolicyNumber().isEnabled() && form.txtPolicyNumber().getValue() == null)
		{
			errors.add("Policy Number is mandatory.");
		}
		
		if (form.cmbPolicyType().isRequired() && form.cmbPolicyType().getVisible() && form.cmbPolicyType().isEnabled() && form.cmbPolicyType().getValue() == null)
		{
			errors.add("Policy Type is mandatory.");
		}

		if( form.txtOther().isRequired() && form.txtOther().isVisible() && form.txtOther().isEnabled() && form.txtOther().getValue() == null)
		{
			errors.add("Other policy type is mandatory!");
		}

		if( form.dteRenewalDate().isRequired() && form.dteRenewalDate().isVisible() && form.dteRenewalDate().isEnabled() && form.dteRenewalDate().getValue() == null)
		{
			errors.add("Renewal Date is mandatory!");
		}

		if( form.cmbEligibility().isRequired() && form.cmbEligibility().getVisible() && form.cmbEligibility().isEnabled() && form.cmbEligibility().getValue() == null)
		{
			errors.add("Eligibility is mandatory!");
		}

		if( form.txtMedicalCardNo().isRequired() && form.txtMedicalCardNo().isVisible() && form.txtMedicalCardNo().isEnabled() && form.txtMedicalCardNo().getValue() == null)
		{
			errors.add("Medical Card No is mandatory!");
		}

		if( form.cmbProved().isRequired() && form.cmbProved().getVisible() && form.cmbProved().isEnabled() && form.cmbProved().getValue() == null)
		{
			errors.add("Proved is mandatory!");
		}
		if( form.txtEligibilityProof().isRequired() && form.txtEligibilityProof().isVisible() && form.txtEligibilityProof().isEnabled() && form.txtEligibilityProof().getValue() == null)
		{
			errors.add("Eligibility Proof is mandatory!");
		}
		if( form.pdtExpiryDate().isRequired() && form.pdtExpiryDate().isVisible() && form.pdtExpiryDate().isEnabled() && form.pdtExpiryDate().getValue() == null)
		{
			errors.add("Expiry Date is mandatory!");
		}
		if( form.txtEHICNumber().isRequired() && form.txtEHICNumber().isVisible() && form.txtEHICNumber().isEnabled() && form.txtEHICNumber().getValue() == null)
		{
			errors.add("EHIC Number is mandatory!");
		}
		if( form.pdtEHICExpiry().isRequired() && form.pdtEHICExpiry().isVisible() && form.pdtEHICExpiry().isEnabled() && form.pdtEHICExpiry().getValue() == null)
		{
			errors.add("EHIC Expiry is mandatory!");
		}
		if( form.cmbCountry().isRequired() && form.cmbCountry().getVisible() && form.cmbCountry().isEnabled() && form.cmbCountry().getValue() == null)
		{
			errors.add("Country is mandatory!");
		}

		if( form.txtIdentofInstitution().isRequired() && form.txtIdentofInstitution().isVisible() && form.txtIdentofInstitution().isEnabled() && form.txtIdentofInstitution().getValue() == null)
		{
			errors.add("Ident. of Institution is mandatory!");
		}
		//if( form.dteRenewalDate().getValue() != null && form.dteRenewalDate().getValue().isLessThan(new Date()))
		//{
		//	errors.add("Renewal Date cannot be in the past!");
		//}
		if( !form.getLocalContext().getCurrentEmergencyAttendanceNonInsuranceHealthCoverVoIsNotNull() || !form.getLocalContext().getCurrentEmergencyAttendanceNonInsuranceHealthCoverVo().getInsuranceIsNotNull())
		{
    		if( form.pdtEHICExpiry().getValue() != null && form.pdtEHICExpiry().getValue().isLessThan(new Date()))
    		{
    			errors.add("EHIC Expiry cannot be in the past!");
    		}
    		if( form.pdtExpiryDate().getValue() != null && form.pdtExpiryDate().getValue().isLessThan(new Date()))
    		{
    			errors.add("Expiry Date cannot be in the past!");
    		}
		}
		else
		{
			if( form.pdtEHICExpiry().getValue() != null && !form.pdtEHICExpiry().getValue().equals(form.getLocalContext().getCurrentEmergencyAttendanceNonInsuranceHealthCoverVo().getInsurance().getEHICExpiryDate()) && form.pdtEHICExpiry().getValue().isLessThan(new Date()))
    		{
    			errors.add("EHIC Expiry cannot be in the past!");
    		}
    		if( form.pdtExpiryDate().getValue() != null && !form.pdtExpiryDate().getValue().equals(form.getLocalContext().getCurrentEmergencyAttendanceNonInsuranceHealthCoverVo().getInsurance().getMedicalCardExpiryDate())  && form.pdtExpiryDate().getValue().isLessThan(new Date()))
    		{
    			errors.add("Expiry Date cannot be in the past!");
    		}
		}

		if (errors.size() > 0)
		{
			String[] UIErrors = new String[errors.size()];
			errors.toArray(UIErrors);
			return UIErrors;
		}

		return null;
	}
	private EmergencyAttendanceNonInsuranceHealthCoverVo populateDataFromScreen(EmergencyAttendanceNonInsuranceHealthCoverVo emergencyAttendInsurance)
	{
		if (emergencyAttendInsurance == null)
			emergencyAttendInsurance = new EmergencyAttendanceNonInsuranceHealthCoverVo();
		else
			emergencyAttendInsurance = (EmergencyAttendanceNonInsuranceHealthCoverVo) emergencyAttendInsurance.clone();

		if( !emergencyAttendInsurance.getInsuranceIsNotNull())
			emergencyAttendInsurance.setInsurance(new NationalHealthCoverVo());
		
		emergencyAttendInsurance.getInsurance().setMedicalCardNo(form.txtMedicalCardNo().getValue());
		emergencyAttendInsurance.getInsurance().setMedicalCardExpiryDate(form.pdtExpiryDate().getValue());
		emergencyAttendInsurance.getInsurance().setHealthActCategory(form.cmbEligibility().getValue());
		emergencyAttendInsurance.getInsurance().setMedicalCardProved(form.cmbProved().getValue());
		emergencyAttendInsurance.getInsurance().setEligibilityProof(form.txtEligibilityProof().getValue());
		
		emergencyAttendInsurance.getInsurance().setEHICNumber(form.txtEHICNumber().getValue());
		emergencyAttendInsurance.getInsurance().setEHICExpiryDate(form.pdtEHICExpiry().getValue());
		emergencyAttendInsurance.getInsurance().setEHICCountry(form.cmbCountry().getValue());
		emergencyAttendInsurance.getInsurance().setEHICInstitution(form.txtIdentofInstitution().getValue());
		
		if( !emergencyAttendInsurance.getPatientMedicalInsuranceIsNotNull() )
			emergencyAttendInsurance.setPatientMedicalInsurance(new PatientMedicalInsuranceVo());
		
		emergencyAttendInsurance.getPatientMedicalInsurance().setPatient(emergencyAttendInsurance.getPatient());
		emergencyAttendInsurance.getPatientMedicalInsurance().setCompany(form.cmbInsurer().getValue());
		emergencyAttendInsurance.getPatientMedicalInsurance().setPolicyNumber(form.txtPolicyNumber().getValue());
		emergencyAttendInsurance.getPatientMedicalInsurance().setPolicyType(form.cmbPolicyType().getValue());
		emergencyAttendInsurance.getPatientMedicalInsurance().setPlanOrUnits(form.txtOther().getValue());
		emergencyAttendInsurance.getPatientMedicalInsurance().setExpiryDate(form.dteRenewalDate().getValue());
		
		

		return emergencyAttendInsurance;
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setSelectedEvent(EmergencyAttendanceEvent.CANCEL);
		form.fireCustomControlValueChanged();
	}
	public void initialize(ims.core.admin.vo.EmergencyAttendanceRefVo attendanceDetailsRef, ims.core.patient.vo.PatientRefVo patientRef, ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRef, ims.core.admin.vo.CareContextRefVo careContextRef)
	{
		form.getLocalContext().setAttendanceDetailsRef(attendanceDetailsRef);
		form.getLocalContext().setPatientRef(patientRef);
		form.getLocalContext().setEpisodeOfCare(episodeOfCareRef);
		form.getLocalContext().setCareContext(careContextRef);
		
	}

	public void setValue(ims.emergency.vo.EmergencyAttendanceNonInsuranceHealthCoverVo attendanceInsurance)
	{
		form.getLocalContext().setCurrentEmergencyAttendanceNonInsuranceHealthCoverVo(attendanceInsurance);
		populateScreenFromData(form.getLocalContext().getCurrentEmergencyAttendanceNonInsuranceHealthCoverVo());
	}
	private void populateInsuranceSchemeCombo()
	{
		form.cmbInsurer().clear();
		PrivateInsuranceCompanyVoCollection tempColl = domain.listPrivateInsuranceCompanyVo();
		if( tempColl != null && tempColl.size() > 0)
		{
			for(int  i = 0; i < tempColl.size(); i++)
			{
				form.cmbInsurer().newRow(tempColl.get(i), tempColl.get(i).getIItemText());
			}
		}
		 
		
	}
	private void populateScreenFromData(EmergencyAttendanceNonInsuranceHealthCoverVo emergencyAttendInsurance)
	{
		clearScreen();
		populateInsuranceSchemeCombo();
		if( emergencyAttendInsurance == null)
			return;

		if( emergencyAttendInsurance.getInsuranceIsNotNull() )
		{
    		form.txtMedicalCardNo().setValue(emergencyAttendInsurance.getInsurance().getMedicalCardNo());
    		form.pdtExpiryDate().setValue(emergencyAttendInsurance.getInsurance().getMedicalCardExpiryDate());
    		form.cmbEligibility().setValue(emergencyAttendInsurance.getInsurance().getHealthActCategory());
    		form.cmbProved().setValue(emergencyAttendInsurance.getInsurance().getMedicalCardProved());
    		form.txtEligibilityProof().setValue(emergencyAttendInsurance.getInsurance().getEligibilityProof());
    		
    		form.txtEHICNumber().setValue(emergencyAttendInsurance.getInsurance().getEHICNumber());
    		form.pdtEHICExpiry().setValue(emergencyAttendInsurance.getInsurance().getEHICExpiryDate());
    		form.cmbCountry().setValue(emergencyAttendInsurance.getInsurance().getEHICCountry());
    		form.txtIdentofInstitution().setValue(emergencyAttendInsurance.getInsurance().getEHICInstitution());
		}
		
		
		if( emergencyAttendInsurance.getPatientMedicalInsuranceIsNotNull() )
		{
    		if( form.cmbInsurer().getValues().contains(emergencyAttendInsurance.getPatientMedicalInsurance().getCompany()))
    			form.cmbInsurer().setValue(emergencyAttendInsurance.getPatientMedicalInsurance().getCompany());
    		else
    		{
    			if( emergencyAttendInsurance.getPatientMedicalInsurance().getCompanyIsNotNull() )
    			{
        			form.cmbInsurer().newRow(emergencyAttendInsurance.getPatientMedicalInsurance().getCompany(), emergencyAttendInsurance.getPatientMedicalInsurance().getCompany().getIItemText());
        			form.cmbInsurer().setValue(emergencyAttendInsurance.getPatientMedicalInsurance().getCompany());
    			}
    		}
    		//form.cmbInsuranceScheme().setValue(emergencyAttendInsurance.getPatientMedicalInsurance().getCompany());
    		form.txtPolicyNumber().setValue(emergencyAttendInsurance.getPatientMedicalInsurance().getPolicyNumber());
    		form.cmbPolicyType().setValue(emergencyAttendInsurance.getPatientMedicalInsurance().getPolicyType());
    		form.txtOther().setValue(emergencyAttendInsurance.getPatientMedicalInsurance().getPlanOrUnits());
    		form.dteRenewalDate().setValue(emergencyAttendInsurance.getPatientMedicalInsurance().getExpiryDate());
		}

	}
	private void clearScreen()
	{
		form.txtMedicalCardNo().setValue(null);
		form.pdtExpiryDate().setValue(null);
		form.cmbEligibility().setValue(null);
		form.cmbProved().setValue(null);
		form.txtEligibilityProof().setValue(null);
		
		form.txtEHICNumber().setValue(null);
		form.pdtEHICExpiry().setValue(null);
		form.cmbCountry().setValue(null);
		form.txtIdentofInstitution().setValue(null);
		
		form.cmbInsurer().clear();
		form.txtPolicyNumber().setValue(null);
		form.cmbPolicyType().setValue(null);
		form.txtOther().setValue(null);
		form.dteRenewalDate().setValue(null);


	}

	public ims.emergency.vo.enums.EmergencyAttendanceEvent getSelectedEvent()
	{
		return form.getLocalContext().getSelectedEvent();
	}

	public void resetSelectedEvent()
	{
		form.getLocalContext().setSelectedEvent(null);
	}
	protected void onFormModeChanged()
	{
		updateControlState();
		
	}
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		// TODO Auto-generated method stub
		
	}
	private void updateControlState()
	{
		EmergencyAttendanceNonInsuranceHealthCoverVo currentEmergAttInsuranceDet = (form.getLocalContext().getAttendanceDetailsRefIsNotNull() ? domain.getEmergencyAttendanceNonInsuranceHealthCoverVo(form.getLocalContext().getAttendanceDetailsRef()) : null);

		form.btnNew().setVisible(FormMode.VIEW.equals(form.getMode()) && currentEmergAttInsuranceDet != null && currentEmergAttInsuranceDet.getInsurance() == null && currentEmergAttInsuranceDet.getPatientMedicalInsurance() == null );
		form.btnEdit().setVisible(FormMode.VIEW.equals(form.getMode()) && currentEmergAttInsuranceDet != null && (currentEmergAttInsuranceDet.getInsuranceIsNotNull() || currentEmergAttInsuranceDet.getPatientMedicalInsuranceIsNotNull()));
		form.cmbInsurer().setEnabled(FormMode.EDIT.equals(form.getMode()));	//WDEV-19562
		
		EDAttendanceControlsConfigVoCollection attendanceControlsConfig = domain.getEDAttendanceControlsConfig(EDAttendenceControlType.INSURANCE_CONTROLS);

		for (int i = 0; attendanceControlsConfig != null && i < attendanceControlsConfig.size(); i++)
		{
			EDAttendanceControlsConfigVo controlConfig = attendanceControlsConfig.get(i);

			//WDEV-19562 - start
//			if( INSURANCE_SCHEME.equals(controlConfig.getControlIMSID()))
//			{
//				form.lblInsuranceScheme().setVisible(controlConfig.getIsVisible());
//
//				form.cmbInsurer().setVisible(controlConfig.getIsVisible());
//				form.cmbInsurer().setRequired(controlConfig.getIsRequired());
//				form.cmbInsurer().setEnabled(FormMode.EDIT.equals(form.getMode()) && controlConfig.getIsEditable());
//
//			}
			//WDEV-19562 - end
			if( REGISTRATION_NUMBER.equals(controlConfig.getControlIMSID()))
			{
				form.lblRegistrationNumber().setVisible(controlConfig.getIsVisible());

				form.txtPolicyNumber().setVisible(controlConfig.getIsVisible());
				form.txtPolicyNumber().setRequired(controlConfig.getIsRequired());
				form.txtPolicyNumber().setEnabled(FormMode.EDIT.equals(form.getMode()) && controlConfig.getIsEditable());

			}
			else if (POLICY_TYPE.equals(controlConfig.getControlIMSID()))
			{
				form.lblPolicyType().setVisible(controlConfig.getIsVisible());
				
				form.cmbPolicyType().setVisible(controlConfig.getIsVisible());
				form.cmbPolicyType().setRequired(controlConfig.getIsRequired());
				form.cmbPolicyType().setEnabled(FormMode.EDIT.equals(form.getMode()) && controlConfig.getIsEditable());

				form.lblOther().setVisible(controlConfig.getIsVisible() && PrivateInsurancePolicyType.OTHER.equals(form.cmbPolicyType().getValue()));
				form.txtOther().setVisible(controlConfig.getIsVisible() && PrivateInsurancePolicyType.OTHER.equals(form.cmbPolicyType().getValue()));
				form.txtOther().setEnabled(FormMode.EDIT.equals(form.getMode()) && controlConfig.getIsEditable());
			}
			else if( RENEWAL_DATE.equals(controlConfig.getControlIMSID()))
			{
				form.lblRenewalDate().setVisible(controlConfig.getIsVisible());

				form.dteRenewalDate().setVisible(controlConfig.getIsVisible());
				form.dteRenewalDate().setRequired(controlConfig.getIsRequired() );
				form.dteRenewalDate().setEnabled(FormMode.EDIT.equals(form.getMode()) && controlConfig.getIsEditable());

			}
			else if( ELIGIBILITY.equals(controlConfig.getControlIMSID()))
			{
				form.lblEligibility().setVisible(controlConfig.getIsVisible());

				form.cmbEligibility().setVisible(controlConfig.getIsVisible());
				form.cmbEligibility().setRequired(controlConfig.getIsRequired());
				form.cmbEligibility().setEnabled(FormMode.EDIT.equals(form.getMode()) && controlConfig.getIsEditable());

			}
			else if( MEDICAL_CARD_NO.equals(controlConfig.getControlIMSID()))
			{
				form.lblMedicalCardNo().setVisible(controlConfig.getIsVisible());

				form.txtMedicalCardNo().setVisible(controlConfig.getIsVisible());
				form.txtMedicalCardNo().setRequired(controlConfig.getIsRequired());
				form.txtMedicalCardNo().setEnabled(FormMode.EDIT.equals(form.getMode()) && controlConfig.getIsEditable());

			}
			else if( PROVED.equals(controlConfig.getControlIMSID()))
			{
				form.lblProved().setVisible(controlConfig.getIsVisible());

				form.cmbProved().setVisible(controlConfig.getIsVisible());
				form.cmbProved().setRequired(controlConfig.getIsRequired());
				form.cmbProved().setEnabled(FormMode.EDIT.equals(form.getMode()) && controlConfig.getIsEditable());

			}
			else if( ELIGIBILITY_PROOF.equals(controlConfig.getControlIMSID()))
			{
				form.lblEligibilityProof().setVisible(controlConfig.getIsVisible());

				form.txtEligibilityProof().setVisible(controlConfig.getIsVisible());
				form.txtEligibilityProof().setRequired(controlConfig.getIsRequired());
				form.txtEligibilityProof().setEnabled(FormMode.EDIT.equals(form.getMode()) && controlConfig.getIsEditable());

			}
			else if( EXPIRY_DATE.equals(controlConfig.getControlIMSID()))
			{
				form.lblExpiryDate().setVisible(controlConfig.getIsVisible());

				form.pdtExpiryDate().setVisible(controlConfig.getIsVisible());
				form.pdtExpiryDate().setRequired(controlConfig.getIsRequired());
				form.pdtExpiryDate().setEnabled(FormMode.EDIT.equals(form.getMode()) && controlConfig.getIsEditable());

			}
			else if( EHIC_NUMBER.equals(controlConfig.getControlIMSID()))
			{
				form.lblEHICNumber().setVisible(controlConfig.getIsVisible());

				form.txtEHICNumber().setVisible(controlConfig.getIsVisible());
				form.txtEHICNumber().setRequired(controlConfig.getIsRequired());
				form.txtEHICNumber().setEnabled(FormMode.EDIT.equals(form.getMode()) && controlConfig.getIsEditable());

			}
			else if( EHIC_EXPIRY.equals(controlConfig.getControlIMSID()))
			{
				form.lblEHICExpiry().setVisible(controlConfig.getIsVisible());

				form.pdtEHICExpiry().setVisible(controlConfig.getIsVisible());
				form.pdtEHICExpiry().setRequired(controlConfig.getIsRequired());
				form.pdtEHICExpiry().setEnabled(FormMode.EDIT.equals(form.getMode()) && controlConfig.getIsEditable());

			}
			else if( COUNTRY.equals(controlConfig.getControlIMSID()))
			{
				form.lblCountry().setVisible(controlConfig.getIsVisible());

				form.cmbCountry().setVisible(controlConfig.getIsVisible());
				form.cmbCountry().setRequired(controlConfig.getIsRequired());
				form.cmbCountry().setEnabled(FormMode.EDIT.equals(form.getMode()) && controlConfig.getIsEditable());

			}
			else if( IDRNT_OF_INSTITUTION.equals(controlConfig.getControlIMSID()))
			{
				form.lblIdentofInstitution().setVisible(controlConfig.getIsVisible());

				form.txtIdentofInstitution().setVisible(controlConfig.getIsVisible());
				form.txtIdentofInstitution().setRequired(controlConfig.getIsRequired());
				form.txtIdentofInstitution().setEnabled(FormMode.EDIT.equals(form.getMode()) && controlConfig.getIsEditable());

			}
		}

		//WDEV-22956
		boolean SVUH_FUNCTIONALITY	= ConfigFlag.UI.SVUH_MANDATORY_DEMOGRAPHIC_ATTRIBUTES.getValue();
		form.btnSave().setVisible(FormMode.EDIT.equals(form.getMode()) && (!Boolean.TRUE.equals(form.getLocalContext().getIsNewAttendance()) || !SVUH_FUNCTIONALITY || Boolean.TRUE.equals(form.getLocalContext().getIsFinalTab())));
		form.btnCancel().setVisible(FormMode.EDIT.equals(form.getMode()) && (!Boolean.TRUE.equals(form.getLocalContext().getIsNewAttendance()) || !SVUH_FUNCTIONALITY || Boolean.TRUE.equals(form.getLocalContext().getIsFinalTab())));
		form.btnNext().setVisible(FormMode.EDIT.equals(form.getMode()) | form.btnSave().isVisible());
	}
	
	//WDEV-22956
	@Override
	protected void onBtnNextClick() throws PresentationLogicException
	{
		String[] uiErrors = getUIErrors();
		
		if (uiErrors != null && uiErrors.length > 0)
		{
			engine.showErrors(uiErrors);
			return;
		}
		
		form.getLocalContext().setSelectedEvent(EmergencyAttendanceEvent.NEXT);
		form.fireCustomControlValueChanged();
	}
	
	//WDEV-22956
	public void setIsFinalTab(Boolean isFinalTab)
	{
		form.getLocalContext().setIsFinalTab(isFinalTab);
	}
	
	//WDEV-22956
	public EmergencyAttendanceNonInsuranceHealthCoverVo getValue()
	{
		return populateDataFromScreen(form.getLocalContext().getCurrentEmergencyAttendanceNonInsuranceHealthCoverVo());
	}
}
