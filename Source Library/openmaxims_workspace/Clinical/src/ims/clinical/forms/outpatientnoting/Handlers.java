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

package ims.clinical.forms.outpatientnoting;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmb3Lookup();
	abstract protected void defaultcmb3LookupValue();
	abstract protected void bindcmbOutcomeLookup();
	abstract protected void defaultcmbOutcomeLookupValue();
	abstract protected void bindgrdProHighCostcolProcHighCostLookup();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnStartClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkReturnClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrDetailsTabChanged(ims.framework.LayerBridge tab);
	abstract protected void onBtnEditClincalNotingClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNextClinicalNotingClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmb3ValueSet(Object value);
	abstract protected void oncmbOutcomeValueSet(Object value);
	abstract protected void onBtnEditMedicationClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditCorrespondenceClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelCorrespondenceClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditPreviewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkClinicalDetailsValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen(args);
			}
		});
		this.form.btnStart().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnStartClick();
			}
		});
		this.form.lnkReturn().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkReturnClick();
			}
		});
		this.form.lyrDetails().tabDocuments().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabDocumentsActivated();
			}
		});
		this.form.lyrDetails().tabClinicalNoting().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabClinicalNotingActivated();
			}
		});
		this.form.lyrDetails().tabPageAssessment().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabPageAssessmentActivated();
			}
		});
		this.form.lyrDetails().tabPageMedication().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabPageMedicationActivated();
			}
		});
		this.form.lyrDetails().tabPageReady().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabPageReadyActivated();
			}
		});
		this.form.lyrDetails().tabPagePreview().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabPagePreviewActivated();
			}
		});
		this.form.lyrDetails().tabClinicalNoting().btnEditClincalNoting().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEditClincalNotingClick();
			}
		});
		this.form.lyrDetails().tabClinicalNoting().btnNextClinicalNoting().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNextClinicalNotingClick();
			}
		});
		this.form.lyrDetails().tabPageMedication().cmb3().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmb3ValueSet(value);
			}
		});
		this.form.lyrDetails().tabPageMedication().cmbOutcome().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbOutcomeValueSet(value);
			}
		});
		this.form.lyrDetails().tabPageMedication().btnEditMedication().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEditMedicationClick();
			}
		});
		this.form.lyrDetails().tabPageMedication().btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelClick();
			}
		});
		this.form.lyrDetails().tabPageReady().btnEditCorrespondence().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEditCorrespondenceClick();
			}
		});
		this.form.lyrDetails().tabPageReady().btnCancelCorrespondence().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelCorrespondenceClick();
			}
		});
		this.form.lyrDetails().tabPagePreview().btnEditPreview().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEditPreviewClick();
			}
		});
		this.form.lyrDetails().tabPagePreview().chk6().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkClinicalDetailsValueChanged();
			}
		});
		this.form.getContextMenus().Clinical.getPatientCoADDDIAGNOSISItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.PatientCo.ADDDIAGNOSIS, sender);
			}
		});
		this.form.getContextMenus().Clinical.getPatientCoADDCOMORBIDITYItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.PatientCo.ADDCOMORBIDITY, sender);
			}
		});
		this.form.getContextMenus().Clinical.getProcedureHighMenuADDPROCEDUREItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.ProcedureHighMenu.ADDPROCEDURE, sender);
			}
		});
		this.form.getContextMenus().Clinical.getProcedureHighMenuADDHIGHCOSTDRUGItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.ProcedureHighMenu.ADDHIGHCOSTDRUG, sender);
			}
		});
		this.form.getContextMenus().Clinical.getOutOfCountyRecipientAddOutOfCountyRecipientItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.OutOfCountyRecipient.AddOutOfCountyRecipient, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmb3Lookup();
		bindcmbOutcomeLookup();
		bindgrdProHighCostcolProcHighCostLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmb3Lookup();
		bindcmbOutcomeLookup();
		bindgrdProHighCostcolProcHighCostLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmb3LookupValue();
		defaultcmbOutcomeLookupValue();
	}
	private void onlyrDetailstabDocumentsActivated()
	{
		this.form.lyrDetails().showtabDocuments();
		onlyrDetailsTabChanged(this.form.lyrDetails().tabDocuments());
	}
	private void onlyrDetailstabClinicalNotingActivated()
	{
		this.form.lyrDetails().showtabClinicalNoting();
		onlyrDetailsTabChanged(this.form.lyrDetails().tabClinicalNoting());
	}
	private void onlyrDetailstabPageAssessmentActivated()
	{
		this.form.lyrDetails().showtabPageAssessment();
		onlyrDetailsTabChanged(this.form.lyrDetails().tabPageAssessment());
	}
	private void onlyrDetailstabPageMedicationActivated()
	{
		this.form.lyrDetails().showtabPageMedication();
		onlyrDetailsTabChanged(this.form.lyrDetails().tabPageMedication());
	}
	private void onlyrDetailstabPageReadyActivated()
	{
		this.form.lyrDetails().showtabPageReady();
		onlyrDetailsTabChanged(this.form.lyrDetails().tabPageReady());
	}
	private void onlyrDetailstabPagePreviewActivated()
	{
		this.form.lyrDetails().showtabPagePreview();
		onlyrDetailsTabChanged(this.form.lyrDetails().tabPagePreview());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
