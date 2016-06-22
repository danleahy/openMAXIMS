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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4972.23166)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.core.forms.gpdetailsindemographicscc;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.CommChannelVo;
import ims.core.vo.DemographicControlsConfigVo;
import ims.core.vo.DemographicControlsConfigVoCollection;
import ims.core.vo.GpShortVo;
import ims.core.vo.LocShortVo;
import ims.core.vo.LocSiteShortVo;
import ims.core.vo.LocSiteVo;
import ims.core.vo.OrganisationVo;
import ims.core.vo.OrganisationWithSitesVo;
import ims.core.vo.Patient;
import ims.core.vo.PersonAddress;
import ims.core.vo.enums.PatientDetailsTab;
import ims.core.vo.lookups.ChannelType;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.utils.textile.Textile;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	//wdev-19528
	private static final String GP_NAME_DEMOGR 			= "DEM45";
	//------------------------------

	
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (formName.equals(form.getForms().Core.GPSelection) && result.equals(DialogResult.OK))
		{
			
			Patient patient = form.getLocalContext().getPatient();
			if (patient == null)
				patient = new Patient();

			if (form.getGlobalContext().Core.getGPPracticeIsNotNull())
			{
				OrganisationWithSitesVo gpPractice = domain.getGPPractice(form.getGlobalContext().Core.getGPPractice());
				patient.setPractice(gpPractice);
				form.getGlobalContext().Core.setGPPracticeWithComm(gpPractice);
			}
			
			refreshGpDetails(form.getGlobalContext().Core.getGPDetails(), form.getGlobalContext().Core.getGPPracticeWithComm(), form.getGlobalContext().Core.getGPSurgery(), !ConfigFlag.DOM.GP_USE_SURGERIES.getValue());

			patient.setGp(form.getGlobalContext().Core.getGPDetails());
			if (form.getGlobalContext().Core.getGPSurgeryIsNotNull() && form.getGlobalContext().Core.getGPSurgery().getID_LocationIsNotNull())
				patient.setGpSurgery(form.getGlobalContext().Core.getGPSurgery());
			else
				patient.setGpSurgery(null);

			displayGp();
			form.getLocalContext().setPatient(patient);
			form.getLocalContext().setPatientDetailsTabAction(PatientDetailsTab.GPBUTTON);
			form.fireCustomControlValueChanged();
		}
	}
	
	protected void onImbClearGPClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Core.setGPSurgery(null);
		form.getGlobalContext().Core.setGPDetails(null);
		
		if(form.getLocalContext().getPatientIsNotNull())
		{
			form.getLocalContext().getPatient().setGp(null);
			form.getLocalContext().getPatient().setGpSurgery(null); 
		}

		form.txtGPName().setValue(null);
		form.txtGPName().setTooltip(null);
		form.txtGPPractice().setValue(null);
		form.txtGPPractice().setTooltip(null);
		form.imbGP().setTooltip(null);	
		clearControls();
		form.getLocalContext().setPatientDetailsTabAction(PatientDetailsTab.GPCLEARGPBUTTON);
		form.fireCustomControlValueChanged();
	}
	
	protected void onImbGPClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getMode().equals(FormMode.VIEW))
			engine.open(form.getForms().Core.GPDetails);
		else if (form.getMode().equals(FormMode.EDIT))
			engine.open(form.getForms().Core.GPSelection);
	}
	private void refreshGpDetails(GpShortVo gp, OrganisationWithSitesVo gpPractice, LocSiteShortVo gpSurgery, boolean usePractice)
	{
		if (usePractice) //WDEV-16051
		{
			form.getGlobalContext().Core.setGPDetails(gp);

			if (gp != null)
			{
				form.txtGPName().setValue(gp.getName().toString());
				form.txtGPName().setTooltip(gp.getName().toString());

				// Because some of the patients may not have the field Practice saved yet in the BO, we will display the first practice - as it used to work
				if (gpPractice == null && gp.getPracticesIsNotNull() && gp.getPractices().size() > 0 && gp.getPractices().get(0) != null && gp.getPractices().get(0).getPracticeIsNotNull())
				{
					gpPractice = gp.getPractices().get(0).getPractice();
				}

				form.getGlobalContext().Core.setGPPracticeWithComm(gpPractice);
				form.txtGPPractice().setValue(gpPractice.getName());
				form.txtGPPractice().setTooltip(gpPractice.getName());
			}
			else
			// wdev-12889
			{
				if (gpSurgery != null)
				{
					LocSiteVo tempVo = domain.getLocationSite(gpSurgery);
					if (tempVo != null)
					{
						OrganisationVo orgVo = tempVo.getParentOrganisation();
						if (orgVo != null)
						{
							form.txtGPPractice().setValue(orgVo.getName());
							form.txtGPPractice().setTooltip(orgVo.getName());
						}

					}
				}
			}

			form.imbGP().setTooltip(getGpTooltip(gp, gpPractice, gpSurgery, usePractice));
		}
		else
		{
			form.getGlobalContext().Core.setGPDetails(gp);
			form.getGlobalContext().Core.setGPSurgery(gpSurgery);
			
			form.imbGP().setTooltip(getGpTooltip(gp, gpPractice, gpSurgery, false));
			if (gpSurgery != null)
			{
				form.txtGPPractice().setValue(gpSurgery.getName());
				form.txtGPPractice().setTooltip(gpSurgery.getName());
			}
			if (gp != null)
			{
				form.txtGPName().setValue(gp.getName().toString());
				form.txtGPName().setTooltip(gp.getName().toString());
			}
		}
	}
	private String getGpTooltip(GpShortVo gp, OrganisationWithSitesVo gpPractice, LocSiteShortVo gpSurgery, boolean usePractice)
	{
		if (gp == null)
		{
			if (form.getMode().equals(FormMode.EDIT))
				form.imbGP().setVisible(true);
			else
			{
				form.imbGP().setVisible(false);
			}
			return "No GP Details";
		}

		StringBuffer sbGPDetails = new StringBuffer();
		if (gp.getNameIsNotNull())
		{
			sbGPDetails.append(Textile.setBold("GP DETAILS") + "\r" + Textile.setBold("GP Name: ") + gp.getName().toString());
			form.txtGPName().setValue(gp.getName().toString());
			form.txtGPName().setTooltip(gp.getName().toString());
		}

		if (!usePractice)
		{
			LocShortVo surgery = gpSurgery;
			if (surgery != null)
			{
				if (surgery.getAddressIsNotNull() && isAddressDetailsNotNullOrEmpty(surgery.getAddress())) //WDEV-20006
				{
					//WDEV-15527
					sbGPDetails.append("\n" + Textile.setBold("Surgery Address: "));
					//WDEV-15527
					if (surgery.getAddress().getLine1IsNotNull())
						sbGPDetails.append("\n" + surgery.getAddress().getLine1());
					if (surgery.getAddress().getLine2IsNotNull())
						sbGPDetails.append("\n" + surgery.getAddress().getLine2());
					if (surgery.getAddress().getLine3IsNotNull())
						sbGPDetails.append("\n" + surgery.getAddress().getLine3());
					if (surgery.getAddress().getLine4IsNotNull())
						sbGPDetails.append("\n" + surgery.getAddress().getLine4());
					if (surgery.getAddress().getLine5IsNotNull())
						sbGPDetails.append("\n" + surgery.getAddress().getLine5());
					if (surgery.getAddress().getPostCodeIsNotNull())
						sbGPDetails.append("\n" + surgery.getAddress().getPostCode());
					if (surgery.getAddress().getCountyIsNotNull())
						sbGPDetails.append("\n" + surgery.getAddress().getCounty());
				}

				// WDEV-13614
				if (gp.getCommChannelsIsNotNull())
				{
					CommChannelVo gpWorkPhone = gp.getCommChannels().getCommunicationChannel(ChannelType.WORK_PHONE);
					CommChannelVo gpFax = gp.getCommChannels().getCommunicationChannel(ChannelType.FAX);

					// WORK PHONE
					if (gpWorkPhone != null && gpWorkPhone.getCommValueIsNotNull())
					{
						sbGPDetails.append("\n" + Textile.setBold("GP Phone: ") + gpWorkPhone.toString());
					}
					else if (gpSurgery.getCommChannelsIsNotNull())
					{
						CommChannelVo surgeryWork = gpSurgery.getCommChannels().getCommunicationChannel(ChannelType.WORK_PHONE);

						if (surgeryWork != null && surgeryWork.getCommValueIsNotNull())
						{
							sbGPDetails.append("\n" + Textile.setBold("Surgery Phone: ") + surgeryWork.toString());
						}
					}

					// FAX NUMBER
					if (gpFax != null && gpFax.getCommValueIsNotNull())
					{
						sbGPDetails.append("\n" + Textile.setBold("GP Fax: ") + gpFax);
					}
					else if (gpSurgery.getCommChannelsIsNotNull())
					{
						CommChannelVo surgeryFax = gpSurgery.getCommChannels().getCommunicationChannel(ChannelType.FAX);

						if (surgeryFax != null && surgeryFax.getCommValueIsNotNull())
						{
							sbGPDetails.append("\n" + Textile.setBold("Surgery Fax: ") + surgeryFax);
						}
					}

				}
				else if (gpSurgery.getCommChannelsIsNotNull())
				{
					CommChannelVo surgeryFax = gpSurgery.getCommChannels().getCommunicationChannel(ChannelType.FAX);
					CommChannelVo surgeryWork = gpSurgery.getCommChannels().getCommunicationChannel(ChannelType.WORK_PHONE);

					if (surgeryWork != null && surgeryWork.getCommValueIsNotNull())
					{
						sbGPDetails.append("\n" + Textile.setBold("Surgery Phone: ") + surgeryWork.toString());
					}

					if (surgeryFax != null && surgeryFax.getCommValueIsNotNull())
					{
						sbGPDetails.append("\n" + Textile.setBold("Surgery Fax: ") + surgeryFax);
					}

				}
			}
		}
		else
		{
			if (gp.getPracticesIsNotNull() && gpPractice != null)
			{
				if (gpPractice.getAddressIsNotNull() && isAddressDetailsNotNullOrEmpty(gpPractice.getAddress())) //WDEV-20006
				{
					//WDEV-15527
					sbGPDetails.append("\n" + Textile.setBold("Practice Address: "));
					//WDEV-15527
					if (gpPractice.getAddress().getLine1IsNotNull())
						sbGPDetails.append("\n" + gpPractice.getAddress().getLine1());
					if (gpPractice.getAddress().getLine2IsNotNull())
						sbGPDetails.append("\n" + gpPractice.getAddress().getLine2());
					if (gpPractice.getAddress().getLine3IsNotNull())
						sbGPDetails.append("\n" + gpPractice.getAddress().getLine3());
					if (gpPractice.getAddress().getLine4IsNotNull())
						sbGPDetails.append("\n" + gpPractice.getAddress().getLine4());
					if (gpPractice.getAddress().getLine5IsNotNull())
						sbGPDetails.append("\n" + gpPractice.getAddress().getLine5());
					if (gpPractice.getAddress().getPostCodeIsNotNull())
						sbGPDetails.append("\n" + gpPractice.getAddress().getPostCode());
					if (gpPractice.getAddress().getCountyIsNotNull())
						sbGPDetails.append("\n" + gpPractice.getAddress().getCounty());
				}

				// WDEV-13614 //WDEV-16051
				if (gpPractice.getCommChannelsIsNotNull())
				{
					// WORK PHONE
					CommChannelVo gpWorkPhone = gp.getCommChannels().getCommunicationChannel(ChannelType.WORK_PHONE);
					CommChannelVo practiceWorkPhone = gpPractice.getCommChannels().getCommunicationChannel(ChannelType.WORK_PHONE);

					if (gpWorkPhone != null && gpWorkPhone.getCommValueIsNotNull())
					{
						sbGPDetails.append("\n" + Textile.setBold("GP Phone: ") + gpWorkPhone.toString());
					}
					else if (practiceWorkPhone != null && practiceWorkPhone.getCommValueIsNotNull())
					{
						sbGPDetails.append("\n" + Textile.setBold("Practice Phone: ") + practiceWorkPhone.toString());
					}

					// FAX NUMBER
					CommChannelVo gpFax = gp.getCommChannels().getCommunicationChannel(ChannelType.FAX);
					CommChannelVo practiceFax = gpPractice.getCommChannels().getCommunicationChannel(ChannelType.FAX);

					if (gpFax != null && gpFax.getCommValueIsNotNull())
					{
						sbGPDetails.append("\n" + Textile.setBold("GP Fax: ") + gpFax.getCommValue());
					}
					else if (practiceFax != null && practiceFax.getCommValueIsNotNull())
					{
						sbGPDetails.append("\n" + Textile.setBold("Practice Fax: ") + practiceFax.getCommValue());
					}
				}
			}
		}

		return new Textile().process(sbGPDetails.toString());
	}
	//WDEV-20006
	private boolean isAddressDetailsNotNullOrEmpty(PersonAddress address)
	{
		if ((address.getLine1IsNotNull() && address.getLine1().length() > 0) ||
			(address.getLine2IsNotNull() && address.getLine2().length() > 0) ||
			(address.getLine3IsNotNull() && address.getLine3().length() > 0) ||
			(address.getLine4IsNotNull() && address.getLine4().length() > 0) ||
			(address.getLine5IsNotNull() && address.getLine5().length() > 0) ||
			(address.getPostCodeIsNotNull() && address.getPostCode().length() > 0) ||
			address.getAreaOfResidenceIsNotNull() ||
			address.getCountyIsNotNull())
				return true;
		return false;
	}
	//WDEV-20006 ---- ends here.
	
	public PatientDetailsTab getAction()
	{
		return form.getLocalContext().getPatientDetailsTabAction();
	}

	
	public void setAction(PatientDetailsTab action)
	{
		form.getLocalContext().setPatientDetailsTabAction(action);
		
	}

	
	public void showHideGPButton(Boolean showhide)
	{
		form.imbGP().setVisible(showhide);
		
	}

	
	public void requiredGPName(Boolean requir)
	{
		form.txtGPName().setRequired(requir);
		
	}

	
	protected void onFormModeChanged()
	{
		updateControlsState();
		
	}
	private void updateControlsState()
	{
		if( form.getMode().equals(FormMode.VIEW))
		{			
			if( form.getGlobalContext().Core.getGPDetails() == null)
				form.imbGP().setVisible(false);
		}
		else
			form.imbGP().setVisible(true);	//wdev-19472
		//form.cmbHealthBoard().setEnabled(form.getMode().equals(FormMode.EDIT));	//wdev-19176
	}

	
	public void setvalue(Patient pat)
	{
		populateScreenFromData(pat);
		form.getLocalContext().setPatient(pat);
		if( form.getGlobalContext().Core.getGPDetailsIsNotNull())
		{
			displayGp();
		}
		
	}
	
	private void populateScreenFromData(Patient pat)
	{
		if( pat == null )
			return;
		
		refreshGpDetails(pat.getGp(),pat.getPractice(), pat.getGpSurgery(), !ConfigFlag.DOM.GP_USE_SURGERIES.getValue());
		//form.cmbHealthBoard().setValue(pat.getHealthBoard());	//wdev-19176
		
	}

	
	public Boolean validateGPDetails()
	{
		if(ConfigFlag.UI.BED_INFO_UI_TYPE.getValue().equals("CCO"))
		{
			//WDEV-13424 
			if(form.txtGPName().getValue()==null || form.txtGPName().getValue()==""){
				engine.showMessage("Please enter the Registered GP Name.");
				return false;
			}
		}
		return true;
	}

	
	public void initialize()
	{
		form.txtCounty().setEnabled(false);
		form.txtCounty().setValue(null);
		form.txtPostCode().setValue(null);	//wdev-19176
		
		//form.txtViewingAddress().setValue("No address Details");
		if (ConfigFlag.UI.DEMOGRAPHICS_TYPE.getValue().equals("IRISH"))
		{
			//form.lblPostcodeorCounty().setValue("County:");
			form.lblPostcodeorCounty().setVisible(true);	//wdev-19176
			form.txtCounty().setVisible(true);				//wdev-19176
		}
		else
		{
			//form.lblPostcodeorCounty().setValue("Postcode:");
			form.lblPostcodeorCounty().setVisible(false);	//wdev-19176
			form.txtCounty().setVisible(false);				//wdev-19176
		}
		
		if(ConfigFlag.DOM.HEARTS_REPLICATE_PATIENTS.getValue())
		{
			form.lblAddress().setValue("Practice Address:");
			form.lblPhone().setValue("Practice Phone:");
			form.lblFax().setValue("Practice Fax:");
		}
		
	}
	private void displayGp()
	{
		clearControls();

		if (form.getGlobalContext().Core.getGPDetails() == null)
			return;

		if (form.getGlobalContext().Core.getGPDetails().getNameIsNotNull())
		{
			form.txtGPName().setValue(form.getGlobalContext().Core.getGPDetails().getName().toString());
			form.txtGPName().setTooltip(form.getGlobalContext().Core.getGPDetails().getName().toString());
		}

		// WDEV-15527
		if (!ConfigFlag.DOM.GP_USE_SURGERIES.getValue())
		{
			if (form.getGlobalContext().Core.getGPPracticeWithCommIsNotNull()) //WDEV-16051
			{
				OrganisationWithSitesVo practice = form.getGlobalContext().Core.getGPPracticeWithComm();
				displayPracticeAddress(practice);
			}

			form.lblSurgeryName().setValue("Practice Name:");
			form.lblAddress().setValue("Practice Address:");
		}
		else if (form.getGlobalContext().Core.getGPSurgeryIsNotNull())
		{
			// WDEV-15527
			displaySurgeryAddress();
			
			form.lblAddress().setValue("Surgery Name:");
			form.lblAddress().setValue("Surgery Address:");
		}
	}
	private void clearControls()
	{
		form.txtAddr1().setValue(null);
		form.txtAddr1().setTooltip(null);
		form.txtAddr2().setValue(null);
		form.txtAddr2().setTooltip(null);
		form.txtAddr3().setValue(null);
		form.txtAddr3().setTooltip(null);
		form.txtAddr4().setValue(null);
		form.txtAddr4().setTooltip(null);
		form.txtAddr5().setValue(null);
		form.txtAddr5().setTooltip(null);
		form.txtCounty().setValue(null);
		form.txtCounty().setTooltip(null);
		form.txtPhone().setValue(null);
		form.txtPhone().setTooltip(null);
		form.txtFax().setValue(null);
		form.txtFax().setTooltip(null);
		form.txtPostCode().setValue(null);		//wdev-19176
		form.txtPostCode().setTooltip(null);	//wdev-19176	
		
	}
	private void displaySurgeryAddress()
	{
		if (form.getGlobalContext().Core.getGPSurgeryIsNotNull() && form.getGlobalContext().Core.getGPSurgery().getNameIsNotNull())
		{
			
			//form.txtViewingAddress().setValue(form.getGlobalContext().Core.getGPSurgery().getName().toString());
				
			PersonAddress address = form.getGlobalContext().Core.getGPSurgery().getAddress();
			if (address != null)
			{
				form.txtAddr1().setValue(address.getLine1());
				form.txtAddr1().setTooltip(address.getLine1());
				form.txtAddr2().setValue(address.getLine2());
				form.txtAddr2().setTooltip(address.getLine2());
				form.txtAddr3().setValue(address.getLine3());
				form.txtAddr3().setTooltip(address.getLine3());
				form.txtAddr4().setValue(address.getLine4());
				form.txtAddr4().setTooltip(address.getLine4());
				form.txtAddr5().setValue(address.getLine5());
				form.txtAddr5().setTooltip(address.getLine5());
				
				if (ConfigFlag.UI.DEMOGRAPHICS_TYPE.getValue().equals("IRISH") && address.getCounty() != null)
				{
					form.txtCounty().setValue(address.getCounty().getText());
					form.txtCounty().setTooltip(address.getCounty().getText());
					form.txtPostCode().setValue(address.getPostCode());		//wdev-19176
					form.txtPostCode().setTooltip(address.getPostCode());	//wdev-19176
				}
				else
				{
					//form.txtCounty().setValue(address.getPostCode());
					//form.txtCounty().setTooltip(address.getPostCode());
					form.txtPostCode().setValue(address.getPostCode());		//wdev-19176
					form.txtPostCode().setTooltip(address.getPostCode());	//wdev-19176
				}
			}
			
			//WDEV-16041
			setSurgeryPhoneAndFax();
		}
	}
	private void setSurgeryPhoneAndFax()
	{
		GpShortVo gp = form.getGlobalContext().Core.getGPDetails();
		LocSiteShortVo gpSurgery = form.getGlobalContext().Core.getGPSurgery();

		if (gp.getCommChannelsIsNotNull())
		{
			CommChannelVo gpWorkPhone = gp.getCommChannels().getCommunicationChannel(ChannelType.WORK_PHONE);
			CommChannelVo gpFax = gp.getCommChannels().getCommunicationChannel(ChannelType.FAX);

			// WORK PHONE
			if (gpWorkPhone != null && gpWorkPhone.getCommValueIsNotNull())
			{
				form.txtPhone().setValue(gpWorkPhone.toString());
				form.txtPhone().setTooltip(gpWorkPhone.toString());
				form.lblPhone().setValue("GP Phone:");
			}
			else if (gpSurgery.getCommChannelsIsNotNull())
			{
				CommChannelVo surgeryWork = gpSurgery.getCommChannels().getCommunicationChannel(ChannelType.WORK_PHONE);

				if (surgeryWork != null && surgeryWork.getCommValueIsNotNull())
				{
					form.txtPhone().setValue(surgeryWork.toString());
					form.txtPhone().setTooltip(surgeryWork.toString());
					form.lblPhone().setValue("Surgery Phone:");
				}
			}

			// FAX NUMBER
			if (gpFax != null && gpFax.getCommValueIsNotNull())
			{
				form.txtFax().setValue(gpFax.toString());
				form.txtFax().setTooltip(gpFax.toString());
				form.lblFax().setValue("GP Fax:");
			}
			else if (gpSurgery.getCommChannelsIsNotNull())
			{
				CommChannelVo surgeryFax = gpSurgery.getCommChannels().getCommunicationChannel(ChannelType.FAX);

				if (surgeryFax != null && surgeryFax.getCommValueIsNotNull())
				{
					form.txtFax().setValue(surgeryFax.toString());
					form.txtFax().setTooltip(surgeryFax.toString());
					form.lblFax().setValue("Surgery Fax:");
				}
			}
		}
		else if (gpSurgery.getCommChannelsIsNotNull())
		{
			CommChannelVo surgeryFax = gpSurgery.getCommChannels().getCommunicationChannel(ChannelType.FAX);
			CommChannelVo surgeryWork = gpSurgery.getCommChannels().getCommunicationChannel(ChannelType.WORK_PHONE);

			if (surgeryWork != null && surgeryWork.getCommValueIsNotNull())
			{
				form.txtPhone().setValue(surgeryWork.toString());
				form.txtPhone().setTooltip(surgeryWork.toString());
				form.lblPhone().setValue("Surgery Phone:");
			}

			if (surgeryFax != null && surgeryFax.getCommValueIsNotNull())
			{
				form.txtFax().setValue(surgeryFax.toString());
				form.txtFax().setTooltip(surgeryFax.toString());
				form.lblFax().setValue("Surgery Fax:");
			}
		}
	}
	private void setPracticePhoneAndFax(OrganisationWithSitesVo practice)
	{
		if (practice.getCommChannelsIsNotNull()) //WDEV-16051
		{
			GpShortVo gp = form.getGlobalContext().Core.getGPDetails();
			// WORK PHONE
			CommChannelVo gpWorkPhone = gp.getCommChannels().getCommunicationChannel(ChannelType.WORK_PHONE);
			CommChannelVo practiceWorkPhone = practice.getCommChannels().getCommunicationChannel(ChannelType.WORK_PHONE);

			if (gpWorkPhone != null && gpWorkPhone.getCommValueIsNotNull())
			{
				form.txtPhone().setValue(gpWorkPhone.toString());
				form.txtPhone().setTooltip(gpWorkPhone.toString());
				form.lblPhone().setValue("GP Phone:");
			}
			else if (practiceWorkPhone != null && practiceWorkPhone.getCommValueIsNotNull())
			{
				form.txtPhone().setValue(practiceWorkPhone.toString());
				form.txtPhone().setTooltip(practiceWorkPhone.toString());
				form.lblPhone().setValue("Practice Phone:");
			}
			else
				form.lblPhone().setValue("Practice Phone:");

			// FAX NUMBER
			CommChannelVo gpFax = gp.getCommChannels().getCommunicationChannel(ChannelType.FAX);
			CommChannelVo practiceFax = practice.getCommChannels().getCommunicationChannel(ChannelType.FAX);

			if (gpFax != null && gpFax.getCommValueIsNotNull())
			{
				form.txtFax().setValue(gpFax.toString());
				form.txtFax().setTooltip(gpFax.toString());
				form.lblFax().setValue("GP Fax:");
			}
			else if (practiceFax != null && practiceFax.getCommValueIsNotNull())
			{
				form.txtFax().setValue(practiceFax.toString());
				form.txtFax().setTooltip(practiceFax.toString());
				form.lblFax().setValue("Practice Fax:");
			}
			else
				form.lblFax().setValue("Practice Fax:");
		}
	}
	private void displayPracticeAddress(OrganisationWithSitesVo practice)
	{
		if (practice!=null) //WDEV-16051
		{
			//form.txtViewingAddress().setValue(practice.getName());
		
			PersonAddress address = practice.getAddress();
			
			if (address != null)
			{
				form.txtAddr1().setValue(address.getLine1());
				form.txtAddr1().setTooltip(address.getLine1());
				form.txtAddr2().setValue(address.getLine2());
				form.txtAddr2().setTooltip(address.getLine2());
				form.txtAddr3().setValue(address.getLine3());
				form.txtAddr3().setTooltip(address.getLine3());
				form.txtAddr4().setValue(address.getLine4());
				form.txtAddr4().setTooltip(address.getLine4());
				form.txtAddr5().setValue(address.getLine5());
				form.txtAddr5().setTooltip(address.getLine5());
				
				if (ConfigFlag.UI.DEMOGRAPHICS_TYPE.getValue().equals("IRISH") && address.getCounty() != null)
				{
					form.txtCounty().setValue(address.getCounty().getText());
					form.txtCounty().setTooltip(address.getCounty().getText());
					form.txtPostCode().setValue(address.getPostCode());		//wdev-19176
					form.txtPostCode().setTooltip(address.getPostCode());	//wdev-19176
				}
				else
				{
					//form.txtCounty().setValue(address.getPostCode());
					//form.txtCounty().setTooltip(address.getPostCode());
					form.txtPostCode().setValue(address.getPostCode());		//wdev-19176
					form.txtPostCode().setTooltip(address.getPostCode());	//wdev-19176
				}
			}
			
			//WDEV-16041
			setPracticePhoneAndFax(practice);
		}
	}

	public void clearScreen()
	{
		form.txtGPName().setValue(null);
		form.txtGPName().setTooltip(null);
		form.txtGPPractice().setValue(null);
		form.txtGPPractice().setTooltip(null);
		clearControls();
		
	}

	public Patient getPatientWithGPetails()
	{
		return form.getLocalContext().getPatient();
	}

	
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		// TODO Auto-generated method stub
		
	}

	//wdev-19528
	public void setConfigurableFields(DemographicControlsConfigVoCollection collfields)
	{
		if( collfields == null || collfields.size() == 0)
			return;
		
		for(int i = 0; i < collfields.size(); i++ )
		{
			DemographicControlsConfigVo tempVo = collfields.get(i); 
			if( tempVo != null )
			{
				if( GP_NAME_DEMOGR.equals(tempVo.getControlIMSID()))
				{
					form.txtGPName().setRequired(tempVo.getIsMandatory());
					break;
				}
			}
		}
		
	}

	//wdev-19528
	public String[] getUIErrorsForConfigurableMode()
	{
		ArrayList<String> errors = new ArrayList<String>();

		if( form.txtGPName().isVisible() && form.txtGPName().isRequired() && (form.txtGPName().getValue() == null || form.txtGPName().getValue() == ""))
		{
			errors.add("GP Name is mandatory.");
		}
		if( errors.size() > 0)
		{
			String[] UIErrors = new String[errors.size()];
			errors.toArray(UIErrors);
			return UIErrors;
		}

		return null;
	}
	
	
}
