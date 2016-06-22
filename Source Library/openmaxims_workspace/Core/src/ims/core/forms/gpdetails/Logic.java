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
// This code was generated by Neil McAnaspie using IMS Development Environment (version 1.21 build 41008.1030)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.gpdetails; 

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.CommChannelVo;
import ims.core.vo.GpShortVo;
import ims.core.vo.LocSiteShortVo;
import ims.core.vo.OrganisationWithSitesVo;
import ims.core.vo.PersonAddress;
import ims.core.vo.lookups.ChannelType;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws FormOpenException
	{
		initialize();
		if (form.getGlobalContext().Core.getGPDetailsIsNotNull())
		{
			displayGp();
		}
		form.setMode(FormMode.VIEW);
	}

	private void initialize() 
	{		
		form.txtCounty().setEnabled(false);
		form.txtCounty().setValue(null);
		
		form.txtViewingAddress().setValue("No address Details");
		if (ConfigFlag.UI.DEMOGRAPHICS_TYPE.getValue().equals("IRISH"))
		{
			form.lblPostcodeorCounty().setValue("County:");
		}
		else
		{
			form.lblPostcodeorCounty().setValue("Postcode:");
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
		clearScreen();

		if (form.getGlobalContext().Core.getGPDetails() == null)
			return;

		if (form.getGlobalContext().Core.getGPDetails().getNameIsNotNull())
		{
			form.txtGPName().setValue(form.getGlobalContext().Core.getGPDetails().getName().toString());
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

	private void displayPracticeAddress(OrganisationWithSitesVo practice)
	{
		if (practice!=null) //WDEV-16051
		{
			form.txtViewingAddress().setValue(practice.getName());
		
			PersonAddress address = practice.getAddress();
			
			if (address != null)
			{
				form.txtAddr1().setValue(address.getLine1());
				form.txtAddr2().setValue(address.getLine2());
				form.txtAddr3().setValue(address.getLine3());
				form.txtAddr4().setValue(address.getLine4());
				form.txtAddr5().setValue(address.getLine5());
				
				if (ConfigFlag.UI.DEMOGRAPHICS_TYPE.getValue().equals("IRISH") && address.getCounty() != null)
				{
					form.txtCounty().setValue(address.getCounty().getText());
				}
				else
				{
					form.txtCounty().setValue(address.getPostCode());
				}
			}
			
			//WDEV-16041
			setPracticePhoneAndFax(practice);
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
				form.lblPhone().setValue("GP Phone:");
			}
			else if (practiceWorkPhone != null && practiceWorkPhone.getCommValueIsNotNull())
			{
				form.txtPhone().setValue(practiceWorkPhone.toString());
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
				form.lblFax().setValue("GP Fax:");
			}
			else if (practiceFax != null && practiceFax.getCommValueIsNotNull())
			{
				form.txtFax().setValue(practiceFax.toString());
				form.lblFax().setValue("Practice Fax:");
			}
			else
				form.lblFax().setValue("Practice Fax:");
		}
	}

	private void clearScreen()
	{
		form.txtAddr1().setValue(null);
		form.txtAddr2().setValue(null);
		form.txtAddr3().setValue(null);
		form.txtAddr4().setValue(null);
		form.txtAddr5().setValue(null);
		form.txtCounty().setValue(null);
		form.txtFax().setValue(null);
		form.txtGPName().setValue(null);
		form.txtPhone().setValue(null);
		
		form.txtViewingAddress().setValue("No Address details");
	}

	/**
	 * 
	 */
	private void displaySurgeryAddress()
	{
		if (form.getGlobalContext().Core.getGPSurgeryIsNotNull() && form.getGlobalContext().Core.getGPSurgery().getNameIsNotNull())
		{
			
			form.txtViewingAddress().setValue(form.getGlobalContext().Core.getGPSurgery().getName().toString());
				
			PersonAddress address = form.getGlobalContext().Core.getGPSurgery().getAddress();
			if (address != null)
			{
				form.txtAddr1().setValue(address.getLine1());
				form.txtAddr2().setValue(address.getLine2());
				form.txtAddr3().setValue(address.getLine3());
				form.txtAddr4().setValue(address.getLine4());
				form.txtAddr5().setValue(address.getLine5());
				
				if (ConfigFlag.UI.DEMOGRAPHICS_TYPE.getValue().equals("IRISH") && address.getCounty() != null)
				{
					form.txtCounty().setValue(address.getCounty().getText());
				}
				else
				{
					form.txtCounty().setValue(address.getPostCode());
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
				form.lblPhone().setValue("GP Phone:");
			}
			else if (gpSurgery.getCommChannelsIsNotNull())
			{
				CommChannelVo surgeryWork = gpSurgery.getCommChannels().getCommunicationChannel(ChannelType.WORK_PHONE);

				if (surgeryWork != null && surgeryWork.getCommValueIsNotNull())
				{
					form.txtPhone().setValue(surgeryWork.toString());
					form.lblPhone().setValue("Surgery Phone:");
				}
			}

			// FAX NUMBER
			if (gpFax != null && gpFax.getCommValueIsNotNull())
			{
				form.txtFax().setValue(gpFax.toString());
				form.lblFax().setValue("GP Fax:");
			}
			else if (gpSurgery.getCommChannelsIsNotNull())
			{
				CommChannelVo surgeryFax = gpSurgery.getCommChannels().getCommunicationChannel(ChannelType.FAX);

				if (surgeryFax != null && surgeryFax.getCommValueIsNotNull())
				{
					form.txtFax().setValue(surgeryFax.toString());
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
				form.lblPhone().setValue("Surgery Phone:");
			}

			if (surgeryFax != null && surgeryFax.getCommValueIsNotNull())
			{
				form.txtFax().setValue(surgeryFax.toString());
				form.lblFax().setValue("Surgery Fax:");
			}
		}
	}
	
	protected void onBtnOKClick() throws PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}
}
