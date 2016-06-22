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

package ims.clinical.forms.chronicpainreferral;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindansCurrentLookup();
	abstract protected void defaultansCurrentLookupValue();
	abstract protected void bindansPatientKnownPainServiceLookup();
	abstract protected void defaultansPatientKnownPainServiceLookupValue();
	abstract protected void bindansInappropriateReferralLookup();
	abstract protected void defaultansInappropriateReferralLookupValue();
	abstract protected void bindansReferAsOutPatientLookup();
	abstract protected void defaultansReferAsOutPatientLookupValue();
	abstract protected void bindansSeeOnWardRouondLookup();
	abstract protected void defaultansSeeOnWardRouondLookupValue();
	abstract protected void bindansWrittenReferralLookup();
	abstract protected void defaultansWrittenReferralLookupValue();
	abstract protected void bindansFollowUpLookup();
	abstract protected void defaultansFollowUpLookupValue();
	abstract protected void bindansTelephoneLookup();
	abstract protected void defaultansTelephoneLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onansCurrentValueSet(Object value);
	abstract protected void onansPatientKnownPainServiceValueSet(Object value);
	abstract protected void onGrdInvestigationSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdReasonSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdReasonGridCheckBoxClicked(int column, GenForm.lyr1Layer.tabActionPlanContainer.grdReasonRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onansInappropriateReferralValueSet(Object value);
	abstract protected void onAnsInappropriateReferralValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onansReferAsOutPatientValueSet(Object value);
	abstract protected void onansSeeOnWardRouondValueSet(Object value);
	abstract protected void onAnsSeeOnWardRouondValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onansWrittenReferralValueSet(Object value);
	abstract protected void onGrdWhomSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onansFollowUpValueSet(Object value);
	abstract protected void onAnsFollowUpValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onansTelephoneValueSet(Object value);
	abstract protected void onAnsTelephoneValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdVisitsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
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
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen(args);
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
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelClick();
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
		this.form.lyr1().tabReferralDetails().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabReferralDetailsActivated();
			}
		});
		this.form.lyr1().tabActionPlan().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabActionPlanActivated();
			}
		});
		this.form.lyr1().tabVisitDetails().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabVisitDetailsActivated();
			}
		});
		this.form.lyr1().tabReferralDetails().ansCurrent().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onansCurrentValueSet(value);
			}
		});
		this.form.lyr1().tabReferralDetails().ansPatientKnownPainService().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onansPatientKnownPainServiceValueSet(value);
			}
		});
		this.form.lyr1().tabReferralDetails().grdInvestigation().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdInvestigationSelectionChanged();
			}
		});
		this.form.lyr1().tabActionPlan().grdReason().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdReasonSelectionChanged();
			}
		});
		this.form.lyr1().tabActionPlan().grdReason().setGridCheckBoxClickedEvent(new GridCheckBoxClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdReasonGridCheckBoxClicked(column, new GenForm.lyr1Layer.tabActionPlanContainer.grdReasonRow(row), isChecked);
			}
		});
		this.form.lyr1().tabActionPlan().ansInappropriateReferral().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onansInappropriateReferralValueSet(value);
			}
		});
		this.form.lyr1().tabActionPlan().ansInappropriateReferral().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onAnsInappropriateReferralValueChanged();
			}
		});
		this.form.lyr1().tabActionPlan().ansReferAsOutPatient().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onansReferAsOutPatientValueSet(value);
			}
		});
		this.form.lyr1().tabActionPlan().ansSeeOnWardRouond().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onansSeeOnWardRouondValueSet(value);
			}
		});
		this.form.lyr1().tabActionPlan().ansSeeOnWardRouond().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onAnsSeeOnWardRouondValueChanged();
			}
		});
		this.form.lyr1().tabActionPlan().ansWrittenReferral().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onansWrittenReferralValueSet(value);
			}
		});
		this.form.lyr1().tabActionPlan().grdWhom().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdWhomSelectionChanged();
			}
		});
		this.form.lyr1().tabActionPlan().ansFollowUp().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onansFollowUpValueSet(value);
			}
		});
		this.form.lyr1().tabActionPlan().ansFollowUp().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onAnsFollowUpValueChanged();
			}
		});
		this.form.lyr1().tabActionPlan().ansTelephone().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onansTelephoneValueSet(value);
			}
		});
		this.form.lyr1().tabActionPlan().ansTelephone().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onAnsTelephoneValueChanged();
			}
		});
		this.form.lyr1().tabVisitDetails().grdVisits().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdVisitsSelectionChanged();
			}
		});
		this.form.getContextMenus().Clinical.getChronicReferralInvestigationGridADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.ChronicReferralInvestigationGrid.ADD, sender);
			}
		});
		this.form.getContextMenus().Clinical.getChronicReferralInvestigationGridREMOVEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.ChronicReferralInvestigationGrid.REMOVE, sender);
			}
		});
		this.form.getContextMenus().Clinical.getChronicReferralVisitGridADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.ChronicReferralVisitGrid.ADD, sender);
			}
		});
		this.form.getContextMenus().Clinical.getChronicReferralVisitGridREMOVEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.ChronicReferralVisitGrid.REMOVE, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindansCurrentLookup();
		bindansPatientKnownPainServiceLookup();
		bindansInappropriateReferralLookup();
		bindansReferAsOutPatientLookup();
		bindansSeeOnWardRouondLookup();
		bindansWrittenReferralLookup();
		bindansFollowUpLookup();
		bindansTelephoneLookup();
	}
	protected void rebindAllLookups()
	{
		bindansCurrentLookup();
		bindansPatientKnownPainServiceLookup();
		bindansInappropriateReferralLookup();
		bindansReferAsOutPatientLookup();
		bindansSeeOnWardRouondLookup();
		bindansWrittenReferralLookup();
		bindansFollowUpLookup();
		bindansTelephoneLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultansCurrentLookupValue();
		defaultansPatientKnownPainServiceLookupValue();
		defaultansInappropriateReferralLookupValue();
		defaultansReferAsOutPatientLookupValue();
		defaultansSeeOnWardRouondLookupValue();
		defaultansWrittenReferralLookupValue();
		defaultansFollowUpLookupValue();
		defaultansTelephoneLookupValue();
	}
	private void onlyr1tabReferralDetailsActivated()
	{
		this.form.lyr1().showtabReferralDetails();
	}
	private void onlyr1tabActionPlanActivated()
	{
		this.form.lyr1().showtabActionPlan();
	}
	private void onlyr1tabVisitDetailsActivated()
	{
		this.form.lyr1().showtabVisitDetails();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
