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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.forms.internalreferral;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbReferralTypeLookup();
	abstract protected void defaultcmbReferralTypeLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onMessageBoxClosed(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnRIEClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnApptBookedClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnRecordInfoClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnRequiresInfoClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnAuthoriseClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrDetailsTabChanged(ims.framework.LayerBridge tab);
	abstract protected void onBtnViewReferralLetterClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnLinkClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnAddReferralLetterClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroupAuthorisationValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnAcceptReqApptClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnAcknowledgeRejectionClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnReqSecondOpinionClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCompleteLinkCorrespondenceClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCompleteAddNoteClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnRejectClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnAcceptClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnAddNoteClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbReferringServiceTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbReferToHcpTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroupConditionValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbReferToServiceValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbReferToServiceTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbReferringHcpTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbReferralTypeValueSet(Object value);
	abstract protected void onCmbReferralTypeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnStatusHistoryClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormModeChangedEvent(new FormModeChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle()
			{
				onFormModeChanged();
			}
		});
		this.form.setMessageBoxClosedEvent(new MessageBoxClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onMessageBoxClosed(messageBoxId, result);
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen(args);
			}
		});
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.btnRIE().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnRIEClick();
			}
		});
		this.form.btnApptBooked().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnApptBookedClick();
			}
		});
		this.form.btnRecordInfo().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnRecordInfoClick();
			}
		});
		this.form.btnRequiresInfo().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnRequiresInfoClick();
			}
		});
		this.form.btnAuthorise().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnAuthoriseClick();
			}
		});
		this.form.lyrDetails().tabClinicalDetails().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabClinicalDetailsActivated();
			}
		});
		this.form.lyrDetails().tabNotes().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabNotesActivated();
			}
		});
		this.form.lyrDetails().tabClinicalDetails().btnViewReferralLetter().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnViewReferralLetterClick();
			}
		});
		this.form.lyrDetails().tabClinicalDetails().btnLink().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnLinkClick();
			}
		});
		this.form.lyrDetails().tabClinicalDetails().btnAddReferralLetter().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnAddReferralLetterClick();
			}
		});
		this.form.lyrDetails().tabClinicalDetails().GroupAuthorisation().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroupAuthorisationValueChanged();
			}
		});
		this.form.btnAcceptReqAppt().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnAcceptReqApptClick();
			}
		});
		this.form.btnAcknowledgeRejection().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnAcknowledgeRejectionClick();
			}
		});
		this.form.btnReqSecondOpinion().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnReqSecondOpinionClick();
			}
		});
		this.form.btnCompleteLinkCorrespondence().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCompleteLinkCorrespondenceClick();
			}
		});
		this.form.btnCompleteAddNote().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCompleteAddNoteClick();
			}
		});
		this.form.btnReject().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnRejectClick();
			}
		});
		this.form.btnAccept().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnAcceptClick();
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelClick();
			}
		});
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveClick();
			}
		});
		this.form.btnClose().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCloseClick();
			}
		});
		this.form.btnEdit().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEditClick();
			}
		});
		this.form.btnNew().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewClick();
			}
		});
		this.form.btnAddNote().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnAddNoteClick();
			}
		});
		this.form.qmbReferringService().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbReferringServiceTextSubmited(value);
			}
		});
		this.form.qmbReferToHcp().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbReferToHcpTextSubmited(value);
			}
		});
		this.form.GroupCondition().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroupConditionValueChanged();
			}
		});
		this.form.qmbReferToService().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbReferToServiceValueChanged();
			}
		});
		this.form.qmbReferToService().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbReferToServiceTextSubmited(value);
			}
		});
		this.form.qmbReferringHcp().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbReferringHcpTextSubmited(value);
			}
		});
		this.form.cmbReferralType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbReferralTypeValueSet(value);
			}
		});
		this.form.cmbReferralType().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbReferralTypeValueChanged();
			}
		});
		this.form.btnStatusHistory().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnStatusHistoryClick();
			}
		});
		this.form.getContextMenus().Clinical.getInternalReferralsNotesNEWItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.InternalReferralsNotes.NEW, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbReferralTypeLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbReferralTypeLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbReferralTypeLookupValue();
	}
	private void onlyrDetailstabClinicalDetailsActivated()
	{
		this.form.lyrDetails().showtabClinicalDetails();
		onlyrDetailsTabChanged(this.form.lyrDetails().tabClinicalDetails());
	}
	private void onlyrDetailstabNotesActivated()
	{
		this.form.lyrDetails().showtabNotes();
		onlyrDetailsTabChanged(this.form.lyrDetails().tabNotes());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
