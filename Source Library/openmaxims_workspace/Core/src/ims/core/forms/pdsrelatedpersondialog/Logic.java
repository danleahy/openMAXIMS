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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.80 build 5427.27524)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.forms.pdsrelatedpersondialog;

import ims.configuration.gen.ConfigFlag;
import ims.core.forms.pdsrelatedpersondialog.GenForm.GroupCopyCorrespondenceEnumeration;
import ims.core.forms.pdsrelatedpersondialog.GenForm.lyrContactLayer.tabPageContactContainer.grdCommChannelsRow;
import ims.core.helper.CommChannelHelper;
import ims.core.helper.PdsAuthenticationHelper;
import ims.core.helper.PdsAuthenticationHelper.PdsCheck;
import ims.core.helper.PdsAuthenticationHelper.PdsRight;
import ims.core.vo.CommChannelVo;
import ims.core.vo.CommChannelVoCollection;
import ims.core.vo.PDSRelativeContactPrefVo;
import ims.core.vo.PatRelative;
import ims.core.vo.PatRelativeCollection;
import ims.core.vo.PersonName;
import ims.core.vo.lookups.AddressType;
import ims.core.vo.lookups.ChannelType;
import ims.framework.Control;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logic extends BaseLogic
{
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		ArrayList<String> col = new ArrayList<String>();
		
		form.lyrAddress().tabAddress().ccAddress().setOtherAddressesButtonVisibility(false);
		form.lyrAddress().tabAddress().ccAddress().setRequireAdress(Boolean.FALSE);
		
		PatRelativeCollection colRelatives = form.getGlobalContext().Core.getPatientRelatives();
		
		
		if(form.getGlobalContext().Core.getPdsRelatedPerson() == null)
		{
			//new relative
		}
		else
		{
			//edit relative
			populateScreenFromData(form.getGlobalContext().Core.getPdsRelatedPerson());
		}
		
		if(colRelatives != null)
		{
    		for(int i = 0; i < colRelatives.size();i++)
    		{
    			if(colRelatives.get(i).getContactRank()!= null)
    				col.add(colRelatives.get(i).getContactRank());
    		}
		}

		//form.cmbContactRanking().clear();
		
		for(int i = 1; i <= 99; i++)
		{
			if (!col.contains(String.valueOf(i)))
				form.cmbContactRanking().newRow(String.valueOf(i), String.valueOf(i));
		}

		form.getContextMenus().Core.getIdentifierGridAddItem().setVisible(form.getMode().equals(FormMode.EDIT));
		setRemoveCommunicationMenuVisibility();
		
		if(Boolean.TRUE.equals(form.getGlobalContext().Core.getViewRelatedPerson()))
		{
			form.btnCancel().setText("Close");
			form.btnSave().setVisible(false);
			form.setMode(FormMode.VIEW);
			
			//form.lyrAddress().tabAddress().ccAddress().setMode(FormMode.VIEW);
			form.lyrAddress().tabAddress().ccAddress().setComponentEnabled(false);
			changeControlsStatus(false);
		}
		
		form.lyrAddress().tabAddress().ccAddress().setCheckBoxesVisibility(Boolean.FALSE);
		form.lyrAddress().tabAddress().ccAddress().setRequireAdress(Boolean.FALSE);

		//WDEV-22199
		//hide address and location info if NHS Number linked record is confidential and user has no access to view.
		boolean activityB1611 = false;
		if(form.getGlobalContext().Core.getPdsRelatedPerson()!=null 
				&& Boolean.TRUE.equals(form.getGlobalContext().Core.getPdsRelatedPerson().getNhsNumIsNotNull())
				&& Boolean.TRUE.equals(form.getGlobalContext().Core.getPdsRelatedPerson().getIsConfidential()))
		{

			form.lyrAddress().tabAddress().setVisible(false);
			form.lyrContact().tabPageContact().setVisible(false);

			if (isPds() && engine.getLoggedInRole().getRequiresPDS() && engine.getLoggedInRole().getSpineRbacRole()!=null)
			{
				//check B1611 activity
				// PDS AUTHENTICATION				
	    		PdsAuthenticationHelper pdsAuth = new PdsAuthenticationHelper(engine, domain);
	    		activityB1611 = pdsAuth.hasRightsFor(PdsRight.ACCESS_SENSITIVE_DATA, PdsCheck.CHECK_ACTIVITY, null);
				// END PDS AUTHENTICATION	    		
				form.lyrAddress().tabAddress().setVisible(true);
				form.lyrContact().tabPageContact().setVisible(true);	    		
			}			
		}
		else
		{
			form.lyrAddress().tabAddress().setVisible(true);
			form.lyrContact().tabPageContact().setVisible(true);
		}
		
 
		if (form.getMode().equals(FormMode.EDIT))
		{
			//WDEV-22172 - allow updates to non demographic data if nhs number linked
			boolean enable = form.getGlobalContext().Core.getPdsRelatedPerson()!=null?Boolean.FALSE.equals(form.getGlobalContext().Core.getPdsRelatedPerson().getNhsNumIsNotNull()):true;
			form.lyrAddress().tabAddress().setEnabled(enable);
			form.lyrAddress().tabAddress().ccAddress().setComponentEnabled(enable);

			form.txtSurname().setEnabled(enable);
			form.txtForename().setEnabled(enable);
			form.txtMiddlename().setEnabled(enable);
			form.cmbTitle().setEnabled(enable);
			form.txtPreferredContactTimes().setEnabled(enable);
			form.cmbPreferredContactMethod().setEnabled(enable);
			form.cmbPreferredWrittenCommMethod().setEnabled(enable);	
			form.lyrContact().tabPageContact().setEnabled(enable);
			changeControlsStatus(enable);

		}
		else if (form.getMode().equals(FormMode.VIEW))
		{
			form.lyrAddress().tabAddress().setEnabled(false);
			form.lyrAddress().tabAddress().ccAddress().setComponentEnabled(false);
			form.lyrAddress().tabAddress().ccAddress().setEnabled(false);
		}
						
		
		/*
		form.lblNHSNumber().setVisible(!isPds());
		form.txtNHSNumber().setVisible(!isPds());

		form.txtNHSNumber().setEnabled(!isPds() && form.getMode().equals(FormMode.EDIT));
		*/
	}
	
	private void changeControlsStatus(boolean enable)
	{
		form.getContextMenus().Core.getIdentifierGridAddItem().setVisible(enable);
		form.getContextMenus().Core.getIdentifierGridCOPYItem().setVisible(enable);
		form.getContextMenus().Core.getIdentifierGridRemoveItem().setVisible(enable);
	}

	/*
	private boolean isPds()
	{
		return !"None".equals(ConfigFlag.DOM.USE_PDS.getValue());
	}
	*/

	@Override
	protected void onBtnCancelClick() throws PresentationLogicException
	{
		form.getGlobalContext().Core.setPdsRelatedPerson(null);
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onBtnSaveClick() throws PresentationLogicException
	{
		if(validateData())
		{
			form.getGlobalContext().Core.setPdsRelatedPerson(populateDataFromScreen());
			engine.close(DialogResult.OK);
		}
	}

	@Override
	protected void onGrdCommChannelsSelectionChanged() throws PresentationLogicException
	{
		setRemoveCommunicationMenuVisibility();
	}
	
	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		if (sender.equals(form.lyrContact().tabPageContact().grdCommChannels()))
		{			
			switch (menuItemID)
			{
				case ims.core.forms.pdsrelatedpersondialog.GenForm.ContextMenus.CoreNamespace.IdentifierGrid.Add :
					grdCommChannelsRow rowComm = form.lyrContact().tabPageContact().grdCommChannels().getRows().newRow(true);
					rowComm.setValue(new CommChannelVo());
					setRemoveCommunicationMenuVisibility();
				break;
				case ims.core.forms.pdsrelatedpersondialog.GenForm.ContextMenus.CoreNamespace.IdentifierGrid.Remove :
					removeCommChannel();
					setRemoveCommunicationMenuVisibility();
				break;
			}
		}
	}

	private void removeCommChannel()
	{
		int index = form.lyrContact().tabPageContact().grdCommChannels().getSelectedRowIndex();

		if (index < 0)
		{
			engine.showMessage("Please select a Contact Type to remove");
			return;
		}
		
		form.lyrContact().tabPageContact().grdCommChannels().getRows().remove(index);
	}
	private void setRemoveCommunicationMenuVisibility()
	{
		boolean bVisible = form.lyrContact().tabPageContact().grdCommChannels().getSelectedRowIndex() != -1 && form.getMode().equals(FormMode.EDIT);
		
		form.getContextMenus().Core.getIdentifierGridRemoveItem().setVisible(bVisible);
	}
	
	/*
	private void populateCorrespondenceAddress(PatRelative person)
	{
		
	}
	*/
	
	private void populateScreenFromData(PatRelative person)
	{
		if(person.getNameIsNotNull())
		{
			form.txtSurname().setValue(person.getName().getSurname());
			form.txtForename().setValue(person.getName().getForename());
			form.txtMiddlename().setValue(person.getName().getMiddleName());
			//form.txtNHSNumber().setValue(person.getNhsNum());
			form.cmbTitle().setValue(person.getName().getTitle());
			
			form.cmbRelationshipRole().setValue(person.getRole());
			form.cmbRelationshipType().setValue(person.getRelationship());
			
			if(person.getObjectidentifierIsNotNull() && person.getObjectidentifier().length() > 0)
			{
				form.cmbRelationshipRole().setEnabled(false);
				form.cmbRelationshipType().setEnabled(false);
			}
			
			form.chkIsNOK().setValue(person.getNokInd());
			
			if(person.getCpyCorresp() != null)
				form.GroupCopyCorrespondence().setValue(Boolean.TRUE.equals(person.getCpyCorresp()) ? GroupCopyCorrespondenceEnumeration.rdoYes : GroupCopyCorrespondenceEnumeration.rdoNo);
			else
				form.GroupCopyCorrespondence().setValue(GroupCopyCorrespondenceEnumeration.None);
			
			form.dteEffectiveFrom().setValue(person.getBeffdate());
			form.dteEffectiveTo().setValue(person.getBetdate());
			
			form.lyrAddress().tabAddress().ccAddress().setValue(person.getAddress());
			form.lyrAddress().tabAddress().ccAddress().setRequireAdress(false);
			
			populateCommChanels(person.getCommChannels());
			
			if (person.getContactRank() != null)
			{
				form.cmbContactRanking().newRow(person.getContactRank(), person.getContactRank());
				form.cmbContactRanking().setValue(person.getContactRank());
			}
		}
		
		if(person.getPDScontactPreferencesIsNotNull())
		{
			PDSRelativeContactPrefVo tempPatContctVo  = person.getPDScontactPreferences(); 
			
			if( tempPatContctVo != null )
			{
				form.cmbPreferredContactMethod().setValue(tempPatContctVo.getPreferredContactMethod());
				form.txtPreferredContactTimes().setValue(tempPatContctVo.getPdsPreferredContactTimes());
				form.cmbPreferredWrittenCommMethod().setValue(tempPatContctVo.getPdsPreferredWrittenComm());
			}
			
		}
	}

	private void populateCommChanels(CommChannelVoCollection commChannels)
	{
		form.lyrContact().tabPageContact().grdCommChannels().getRows().clear();
		
		if(form.lyrContact().tabPageContact().grdCommChannels().colTypeComboBox().size() == 0)
		{
			ChannelType[] instances = ChannelType.getNegativeInstances();
			
			for(ChannelType inst : instances)
			{
				form.lyrContact().tabPageContact().grdCommChannels().colTypeComboBox().newRow(inst, inst.getText());
			}
		}
		
		grdCommChannelsRow rowCommChannel;

		if (commChannels != null)
		{
			for (int i = 0; i < commChannels.size(); i++)
			{
				CommChannelVo voCommChannel = commChannels.get(i);

				if (voCommChannel.getChannelTypeIsNotNull())
				{
					rowCommChannel = form.lyrContact().tabPageContact().grdCommChannels().getRows().newRow();
					rowCommChannel.setcolType(voCommChannel.getChannelType());
					rowCommChannel.setcolContactValue(voCommChannel.getCommValue());
					rowCommChannel.setcolUsage(voCommChannel.getChannelUsage());
					rowCommChannel.setValue(voCommChannel);
					
					//WDEV-21540 - if comm channel has an object identifier then the channeltype cannot be changed
					if(voCommChannel.getObjectidentifierIsNotNull() && voCommChannel.getObjectidentifier().length() > 0)
					{
						rowCommChannel.setcolTypeReadOnly(true);
					}
				}
			}

		}
	}

	public String[] getUIErrorsForConfigurableMode()
	{
		ArrayList<String> errors = new ArrayList<String>();

		if( form.cmbTitle().getVisible() && form.cmbTitle().isRequired() && form.cmbTitle().getValue() == null)
		{
			errors.add("Title is mandatory.");
		}
		if( form.txtForename().isVisible() && form.txtForename().isRequired() && (form.txtForename().getValue() == null || form.txtForename().getValue().length() == 0))
		{
			errors.add("Forename is mandatory.");
		}
		if( form.txtMiddlename().isVisible() && form.txtMiddlename().isRequired() && (form.txtMiddlename().getValue() == null || form.txtMiddlename().getValue().length() == 0))
		{
			errors.add("Middlename is mandatory.");
		}
		if( form.txtSurname().isVisible() && form.txtSurname().isRequired() && (form.txtSurname().getValue() == null || form.txtSurname().getValue().length() == 0))
		{
			errors.add("Surname is mandatory.");
		}
		if( form.cmbRelationshipRole().getVisible() && form.cmbRelationshipRole().isRequired() && (form.cmbRelationshipRole().getValue() == null))
		{
			errors.add("Relationship Role is mandatory.");
		}
		if( form.cmbRelationshipType().getVisible() && form.cmbRelationshipType().isRequired() && (form.cmbRelationshipType().getValue() == null))
		{
			errors.add("Relationship Type is mandatory.");
		}
		
		if(form.dteEffectiveFrom().getValue() != null && form.dteEffectiveTo().getValue() != null)
		{
			if (form.dteEffectiveFrom().getValue().isGreaterThan(form.dteEffectiveTo().getValue()))
			{
				errors.add("Effective from is after Effective to.");
			}
		}
		//the code below is to enforce that one NOK is allowed
		//apparently we don't have to enforce that anymore
		
		//WDEV-22172
		//When checking this contraint we need to take business effective dates into account
		if(Boolean.TRUE.equals(form.chkIsNOK().getValue()))
		{
			PatRelative editedRelative = form.getGlobalContext().Core.getPdsRelatedPerson();
			PatRelativeCollection coll = form.getGlobalContext().Core.getPatientRelatives();
			
			PatRelative nok = null;
			
			//WDEV-22180
			if(coll != null)
			{
				for(PatRelative rl : coll)
				{
					if(Boolean.TRUE.equals(rl.getNokInd()))
					{
						if (rl.getBeffdateIsNotNull() && rl.getBetdateIsNotNull())
						{
        	    			if (!rl.getBetdate().isLessOrEqualThan(new ims.framework.utils.Date()))
								nok = rl;
								break;
						}
					}
				}
			}
			
			if(nok != null)
			{
				if(editedRelative == null)
				{
					errors.add("Only one NOK record is allowed.");
				}
				else
				{
					//the below statement is correct, we compare two pointers
					if(nok != editedRelative)
					{
						errors.add("Only one NOK record is allowed.");
					}
				}
			}
		}
		
		//WDEV-22186
		//For PDS Address is mandatory for relatives
		if (isPds())
		{
			if (form.lyrAddress().tabAddress().ccAddress().getValue()==null)
			{
				errors.add("Please enter an address.");
			}
		}
		//WDEV-22186
		
		if( errors.size() > 0)
		{
			String[] UIErrors = new String[errors.size()];
			errors.toArray(UIErrors);
			return UIErrors;
		}

		return null;
	}
		
	//WDEV-21991
	private boolean checkConsecutiveSpace(String string) 
	{
		if (string==null)
			return false;
		
		Pattern pattern = Pattern.compile("\\p{javaWhitespace}{2,}");
		Matcher m = pattern.matcher(string);
		if (m.find())
			return true;
		
		if (Character.isWhitespace(string.charAt(0)) || Character.isWhitespace(string.charAt(string.length() - 1))) {
	        return true;
	    }
		
		return false;
	}
	//WDEV-21991

	private boolean validateData()
	{
		java.util.ArrayList<String> errors = new ArrayList<String>();
		
		String[] UIErrors = getUIErrorsForConfigurableMode();
		
		if( UIErrors != null && UIErrors.length > 0)
		{
			for(String err: UIErrors)
			{
				errors.add(err);
			}
		}
		
		//WDEV-21991
		if (checkConsecutiveSpace(form.txtSurname().getValue()))
				errors.add("Please remove consecutive and or leading/trailing spaces in Surname");

		if (checkConsecutiveSpace(form.txtForename().getValue()))
			errors.add("Please remove consecutive and or leading/trailing spaces in Forename");

		if (checkConsecutiveSpace(form.txtMiddlename().getValue()))
			errors.add("Please remove consecutive and or leading/trailing spaces in Middlename");
		//WDEV-21991
		
		
		for (int i = 0; i < form.lyrContact().tabPageContact().grdCommChannels().getRows().size(); i++)
		{
			if (((form.lyrContact().tabPageContact().grdCommChannels().getRows().get(i).getcolType() != null) && (form.lyrContact().tabPageContact().grdCommChannels().getRows().get(i).getcolContactValue() != null && form.lyrContact().tabPageContact().grdCommChannels().getRows().get(i).getcolContactValue().trim().length() == 0)) || (form.lyrContact().tabPageContact().grdCommChannels().getRows().get(i).getcolType() != null && form.lyrContact().tabPageContact().grdCommChannels().getRows().get(i).getcolContactValue() == null) || (form.lyrContact().tabPageContact().grdCommChannels().getRows().get(i).getcolType() == null && (form.lyrContact().tabPageContact().grdCommChannels().getRows().get(i).getcolContactValue() != null && form.lyrContact().tabPageContact().grdCommChannels().getRows().get(i).getcolContactValue().trim().length() != 0)))
			{
				errors.add("Please enter a valid Contact type and Value");
				break;
				//return false;
			}
		}
		
		CommChannelHelper validator = new CommChannelHelper();
		
		//validate email addresses
		//if(isPds())
		{
    		for(int i = 0; i < form.lyrContact().tabPageContact().grdCommChannels().getRows().size(); i++)
    		{
    			grdCommChannelsRow row = form.lyrContact().tabPageContact().grdCommChannels().getRows().get(i);
    			
    			if(row.getcolType() != null && ChannelType.EMAIL.equals(row.getcolType()) && row.getcolContactValue() != null && row.getcolContactValue().length() > 0)
    			{
    				if(!validator.isValidEmailAddress(row.getcolContactValue()))
    				{
    					errors.add("The email address '" + row.getcolContactValue() + "' is not valid !");
    				}
    			}
    		}
		}
		
		//WDEV-22188
		ArrayList<ChannelType> channelTypes = new ArrayList<ChannelType>();
		boolean moreThanOneType = false;
		
		//validate telephone numbers if demographics = UK
		if (isPds() && ConfigFlag.UI.DEMOGRAPHICS_TYPE.getValue().equals("UK"))
		{
    		for(int i = 0; i < form.lyrContact().tabPageContact().grdCommChannels().getRows().size(); i++)
    		{
    			grdCommChannelsRow row = form.lyrContact().tabPageContact().grdCommChannels().getRows().get(i);
    
    			//check for duplicate types
    			if (channelTypes!=null && channelTypes.size()>0)
    			{
    				for (ChannelType ch : channelTypes)
    				{
    					if (ch.equals(row.getcolType()))
    						moreThanOneType = true;
    				}
    			}
    			
    			channelTypes.add(row.getcolType());
    			
    			//isValidTelephoneNumber
    			if(row.getcolType() != null && 
    					(ChannelType.FAX.equals(row.getcolType()) || 
    							ChannelType.GEN_PHONE.equals(row.getcolType()) ||
    							ChannelType.HOME_PHONE.equals(row.getcolType()) ||
    							ChannelType.MOBILE.equals(row.getcolType()) ||
    							ChannelType.WORK_PHONE.equals(row.getcolType())) 
    					&& row.getcolContactValue() != null && row.getcolContactValue().length() > 0)
    			{
    				if(!validator.isValidTelephoneNumber(row.getcolContactValue()))
    				{
    					errors.add("The communication channel '" + row.getcolContactValue() + "' is not STD compliant !");
    				}
    			}
    		}
    		
    		if (moreThanOneType)
    			errors.add("More than one communication channel of the same type added. \r\nOnly one contact type per contact value allowed.");
		}
		//WDEV-22188
		
		if(!form.lyrAddress().tabAddress().ccAddress().validateData(errors))
		{
			//return false;
		}
		
		if(errors.size() > 0)
		{
			String[] UIErrors1 = new String[errors.size()];
			errors.toArray(UIErrors1);
			engine.showErrors(UIErrors1);
			
			return false;
		}

		return true;
	}

	private PatRelative populateDataFromScreen()
	{
		PatRelative rel = form.getGlobalContext().Core.getPdsRelatedPerson();
		
		if(rel == null)
		{
			rel = new PatRelative();
			
			rel.setTimestamp(String.valueOf(System.currentTimeMillis()));
		}
		
		if(rel.getName() == null)
			rel.setName(new PersonName());
		
		rel.getName().setSurname(form.txtSurname().getValue());
		rel.getName().setForename(form.txtForename().getValue());
		rel.getName().setMiddleName(form.txtMiddlename().getValue());
		rel.getName().setTitle(form.cmbTitle().getValue());
		//rel.setNhsNum(form.txtNHSNumber().getValue());
		rel.setRole(form.cmbRelationshipRole().getValue());
		rel.setRelationship(form.cmbRelationshipType().getValue());
		rel.setNokInd(form.chkIsNOK().getValue());
		
		if(GroupCopyCorrespondenceEnumeration.None.equals(form.GroupCopyCorrespondence().getValue()))
			rel.setCpyCorresp(null);
		else
			rel.setCpyCorresp(GroupCopyCorrespondenceEnumeration.rdoYes.equals(form.GroupCopyCorrespondence().getValue()));

		rel.setBeffdate(form.dteEffectiveFrom().getValue());
		rel.setBetdate(form.dteEffectiveTo().getValue());
		
		rel.setAddress(form.lyrAddress().tabAddress().ccAddress().getValue());
		
		//WDEV-21327 - default to permanent for PDS
		if (rel.getAddressIsNotNull() && !rel.getAddress().getAddressTypeIsNotNull())
			rel.getAddress().setAddressType(AddressType.PERMANENT);

		rel.setCommChannels(getCommChannels());
		
		boolean hasPcm = false;
		if(form.cmbPreferredContactMethod().getValue() != null || form.cmbPreferredWrittenCommMethod().getValue() != null || (form.txtPreferredContactTimes().getValue() != null && form.txtPreferredContactTimes().getValue().length() > 0))
				hasPcm = true;

		if(rel.getPDScontactPreferences() == null && hasPcm)
			rel.setPDScontactPreferences(new PDSRelativeContactPrefVo());
		
		if(rel.getPDScontactPreferencesIsNotNull())
		{
			rel.getPDScontactPreferences().setPdsPreferredContactTimes(form.txtPreferredContactTimes().getValue());
			rel.getPDScontactPreferences().setPdsPreferredWrittenComm(form.cmbPreferredWrittenCommMethod().getValue());
			rel.getPDScontactPreferences().setPreferredContactMethod(form.cmbPreferredContactMethod().getValue());
		}
		
		rel.setContactRank(form.cmbContactRanking().getValue());
		
		return rel;
	}

	private CommChannelVoCollection getCommChannels()
	{
		CommChannelVoCollection voCommChannelColl = new CommChannelVoCollection();
		grdCommChannelsRow rowComm;

		for (int i = 0; i < form.lyrContact().tabPageContact().grdCommChannels().getRows().size(); i++)
		{
			rowComm = form.lyrContact().tabPageContact().grdCommChannels().getRows().get(i);
			CommChannelVo voCommChannel = rowComm.getValue();
			boolean existCommChannels = false;
			// WDEV-2496
			if (rowComm.getcolType() != null && (rowComm.getcolContactValue() != null && rowComm.getcolContactValue().trim().length() != 0))
			{
				voCommChannel.setChannelType(rowComm.getcolType());
				voCommChannel.setCommValue(rowComm.getcolContactValue());
				voCommChannel.setChannelUsage(rowComm.getcolUsage());

				for (int k = 0; k < voCommChannelColl.size(); k++)
				{
					if (voCommChannelColl.get(k).getChannelType().equals(rowComm.getcolType()) && voCommChannelColl.get(k).getCommValue().equals(rowComm.getcolContactValue()))
					{
						existCommChannels = true;
						break;
					}
				}

				if (!existCommChannels)
					voCommChannelColl.add(voCommChannel);
			}
		}
		
		return voCommChannelColl;
	}
	
	private boolean isPds()
	{
		return !"None".equals(ConfigFlag.DOM.USE_PDS.getValue());
	}
	

	/*
	@Override
	protected void onImbClearWaitClick() throws PresentationLogicException
	{
		form.cmbIdType().setValue(null);
		form.txtIdValue().setValue(null);
		form.txtForenameSearch().setValue(null);
		form.txtSurnameSearch().setValue(null);
		
		form.grdPatients().getRows().clear();
	}

	@Override
	protected void onImbSearchWaitClick() throws PresentationLogicException
	{
		searchWaiting();		
	}
	private void populateGridWithPatients(PatientShortCollection psColl)
	{
		form.grdPatients().getRows().clear();

		if (psColl==null || psColl.size()==0)
			return;
		
		for (PatientShort ps : psColl)
		{
			addRowToDynGrid(ps);
		}
	}
	
	
	private void addRowToDynGrid(PatientShort ps) 
	{
		if (ps == null)
			return;
		
		ims.core.forms.pdsrelatedpersondialog.GenForm.grdPatientsRow row = form.grdPatients().getRows().newRow();
		
		if(ps.getNameIsNotNull())
		{
			row.setColForename(ps.getName().getForename());
			row.setColSurname(ps.getName().getSurname());
		}
		
		PatientId patId = ps.getDisplayId();
		row.setColDisplayId(patId != null ? patId.getValue() : null);
		row.setColSex(ps.getSexIsNotNull() ? ps.getSex().toString() : null);
	
		Integer age = ps.calculateAge();
		if(age != null)
			row.setColAge(String.valueOf(age));
		
		row.setColDob(ps.getDobIsNotNull() ? ps.getDob().toString() : null);
		
		//WDEV-8000
		if(ps.getAssociatedPatientIsNotNull())
			row.setBackColor(ConfigFlag.UI.MERGED_COLOUR.getValue());
			
		if(ps.getDodIsNotNull())
			row.setBackColor(ConfigFlag.UI.RIP_COLOUR.getValue());		
				
		row.setValue(ps);	
		
	}

	private void searchWaiting()
	{
		if(validateWaitingSearchCriteria())
		{
			PatientFilter voPatFilter = new PatientFilter();
			if (form.txtIdValue().getValue() != null && form.txtIdValue().getValue().length() > 0)
			{
				PatientId pid = new PatientId();
				pid.setType(form.cmbIdType().getValue());	
				pid.setValue(form.txtIdValue().getValue());			
				voPatFilter.setPersId(pid);
				//wdev-11258
				form.txtForenameSearch().setValue("");
				form.txtSurnameSearch().setValue("");
				//------------
			}
			else
			{
				voPatFilter.setForename(form.txtForenameSearch().getValue());
				voPatFilter.setSurname(form.txtSurnameSearch().getValue());
			}
			
			//WDEV-17167
			voPatFilter.setExcludeQuickRegistrationPatients(Boolean.TRUE);
			
			form.grdPatients().getRows().clear();
			PatientShortCollection voCollPatients = null;
			try
			{
				voCollPatients = domain.searchPatients(voPatFilter);
			}
			catch (DomainInterfaceException e)
			{
				engine.showMessage(e.getMessage());
				return;
			}
			
			if(voCollPatients == null || voCollPatients.size() == 0)
			{
				engine.showMessage("No matching records found");
				return;
			}
			for (PatientShort voPatient : voCollPatients)
			{
				ims.core.forms.pdsrelatedpersondialog.GenForm.grdPatientsRow row = form.grdPatients().getRows().newRow();
	
				if(voPatient.getNameIsNotNull())
				{
					row.setColForename(voPatient.getName().getForename());
					row.setColSurname(voPatient.getName().getSurname());
				}
				
				PatientId patId = voPatient.getDisplayId();
				row.setColDisplayId(patId != null ? patId.getValue() : null);
				row.setColSex(voPatient.getSexIsNotNull() ? voPatient.getSex().toString() : null);
			
				Integer age = voPatient.calculateAge();
				if(age != null)
					row.setColAge(String.valueOf(age));
				
				row.setColDob(voPatient.getDobIsNotNull() ? voPatient.getDob().toString() : null);
				
				//WDEV-8000
				if(voPatient.getAssociatedPatientIsNotNull())
					row.setBackColor(ConfigFlag.UI.MERGED_COLOUR.getValue());
					
				if(voPatient.getDodIsNotNull())
					row.setBackColor(ConfigFlag.UI.RIP_COLOUR.getValue());		
						
				row.setValue(voPatient);	
			}	
		}
	}

	private boolean validateWaitingSearchCriteria()
	{
		List<String> errors = new ArrayList<String>();
	
		if (form.txtIdValue().getValue() != null && form.txtIdValue().getValue().length() > 0)
		{
			if (form.cmbIdType().getValue() == null)
			{
				errors.add("Please select an ID Type");
				form.cmbIdType().setFocus();
			}
		}
		else
		{
			if(form.txtSurnameSearch().getValue() == null)
				errors.add("Surname is mandatory");
			if(form.txtForenameSearch().getValue() == null
				&& ConfigFlag.UI.SEARCH_REQ_FORENAME.getValue()) //WDEV-20257
				errors.add("Forename is mandatory");
		}
		
		String[] strErrors = errors.toArray(new String[0]);
		if(strErrors != null && strErrors.length > 0)
		{
			engine.showErrors(strErrors);
			//http://jira/browse/WDEV-20484
			if (form.grdPatients().getRows().size() > 0)
			{
				form.grdPatients().getRows().clear();
			} 
			return false;
		}
		
		return true;
	}

	@Override
	protected void onGrdPatientsSelectionChanged() throws PresentationLogicException
	{
		Patient pat = null;
		
		try
		{
			pat = domain.getPatient(form.grdPatients().getValue());
		}
		catch (DomainInterfaceException e)
		{
			e.printStackTrace();
			engine.showErrors(new String[] {"Error getting patient record: " + e.toString()});
			return;
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();
			engine.showErrors(new String[] {"Error getting patient record: " + e.toString()});
			return;
		}
		
		populateDetailsFromLocalSearch(pat);
	}

	private void populateDetailsFromLocalSearch(Patient pat)
	{
		form.txtForename().setValue(pat.getName().getForename());
		form.txtSurname().setValue(pat.getName().getSurname());
		form.txtMiddlename().setValue(pat.getName().getMiddleName());
		form.cmbTitle().setValue(pat.getName().getTitle());
		//if(pat.getNhsn() != null)
		//	form.txtNHSNumber().setValue(pat.getNhsn().getValue());
		form.lyrAddress().tabAddress().ccAddress().setValue(pat.getAddress());
		populateCommChanels(pat.getCommChannels());
		
		PatientContactPreferenceVo tempPatContctVo  = pat.getAlternativeContact();   
		
		if( tempPatContctVo != null )
		{
			form.cmbPreferredContactMethod().setValue(tempPatContctVo.getPdsPreferredContactMethod());
			form.txtPreferredContactTimes().setValue(tempPatContctVo.getPdsPreferredContactTimes());
			form.cmbPreferredWrittenCommMethod().setValue(tempPatContctVo.getPdsPreferredWrittenComm());
		}
	}
	
	private PatientShortCollection manualSortDOB(SortOrder sortOrder)
	{
		PatientShortCollection tempColl = new PatientShortCollection();

		for(int i = 0;i < form.grdPatients().getRows().size();i++)
		{
			tempColl.add((PatientShort) form.grdPatients().getRows().get(i).getValue());
		}
		form.grdPatients().getRows().clear();
		tempColl.sort(new DobComparator(sortOrder));
		return tempColl;
	}
	
	private PatientShortCollection manualSortAge(SortOrder sortOrder)
	{
		PatientShortCollection tempColl = new PatientShortCollection();

		for(int i = 0;i < form.grdPatients().getRows().size();i++)
		{
			tempColl.add((PatientShort) form.grdPatients().getRows().get(i).getValue());
		}
		form.grdPatients().getRows().clear();
		tempColl.sort(new AgeComparator(sortOrder));
		return tempColl;
	}
	
	public class DobComparator implements Comparator
	{
		private int direction = 1;

		public DobComparator()
		{
			this(SortOrder.ASCENDING);
		}

		public DobComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
		}
		public int compare(Object ob1, Object ob2) 
		{
			PartialDate pdate1 = null;
			PartialDate pdate2 = null;
			if(ob1 instanceof PatientShort )
			{
				PatientShort ps1 = (PatientShort)ob1;
				pdate1 = ps1.getDob();
			}
			if(ob2 instanceof PatientShort)
			{
				PatientShort ps2 = (PatientShort)ob2;
				pdate2 = ps2.getDob();
			}
			if(pdate1 != null )
				return  pdate1.compareTo(pdate2)*direction;
			if(pdate2 != null)
				return (-1)*direction;

			return 0;
		}
	}
	
	public class AgeComparator implements Comparator
	{
		private int direction = 1;

		public AgeComparator()
		{
			this(SortOrder.ASCENDING);
		}

		public AgeComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
		}
		public int compare(Object ob1, Object ob2) 
		{
			Integer age1 = null;
			Integer age2 = null;
			if(ob1 instanceof PatientShort )
			{
				PatientShort ps1 = (PatientShort)ob1;
				age1 = ps1.getAge();
			}
			if(ob2 instanceof PatientShort)
			{
				PatientShort ps2 = (PatientShort)ob2;
				age2 = ps2.getAge();
			}
			if(age1 != null && age2 != null)
				return  age1.compareTo(age2)*direction;
			
			if(age1 != null && age2 == null)
				return direction;
			
			if(age2 != null && age1 == null)
				return (-1)*direction;
			
			return 0;
		}
	}

	@Override
	protected void onGrdPatientsGridHeaderClicked(int column) throws PresentationLogicException 
	{
		if(column == 5)
		{
			PatientShort temp = null;
			if (form.grdPatients().getValue() instanceof PatientShort)
				temp = (PatientShort) form.grdPatients().getValue();
			
			Boolean isSortModeDescending = form.getLocalContext().getSortOrderDoB() == null || !form.getLocalContext().getSortOrderDoB().equals(SortOrder.ASCENDING);
			form.getLocalContext().setSortOrderDoB(isSortModeDescending ? SortOrder.ASCENDING : SortOrder.DESCENDING);
			populateGridWithPatients(manualSortDOB(form.getLocalContext().getSortOrderDoB()));
			form.grdPatients().setValue(temp);
		}
		
		else if (column == 4)
		{
			PatientShort temp = null;
			if (form.grdPatients().getValue() instanceof PatientShort)
				temp = (PatientShort) form.grdPatients().getValue();
			
			Boolean isSortModeDescending = form.getLocalContext().getSortOrderAge() == null || !form.getLocalContext().getSortOrderAge().equals(SortOrder.ASCENDING);
			form.getLocalContext().setSortOrderAge(isSortModeDescending ? SortOrder.ASCENDING : SortOrder.DESCENDING);
			populateGridWithPatients(manualSortAge(form.getLocalContext().getSortOrderAge()));
			form.grdPatients().setValue(temp);
		}
	}
	*/
}
