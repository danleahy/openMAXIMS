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

package ims.clinical.forms.patient_summary;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdListCellButtonClicked(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onDyngrdListRowSelectionChanged(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdListRowSelectionCleared() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbContextValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewICPClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTxtWorkflowIDValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdDiagnosisSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroupProcedureValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroupDiagnosisValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdProcedureSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSearchWorkflowIDClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkPatientViewValueChanged() throws ims.framework.exceptions.PresentationLogicException;
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
		this.form.dyngrdList().setDynamicGridCellButtonClickedEvent(new DynamicGridCellButtonClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdListCellButtonClicked(cell);
			}
		});
		this.form.dyngrdList().setDynamicGridRowSelectionChangedEvent(new DynamicGridRowSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row, ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdListRowSelectionChanged(row);
			}
		});
		this.form.dyngrdList().setDynamicGridRowSelectionClearedEvent(new DynamicGridRowSelectionCleared()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdListRowSelectionCleared();
			}
		});
		this.form.imbClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbClearClick();
			}
		});
		this.form.imbSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbSearchClick();
			}
		});
		this.form.cmbContext().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbContextValueChanged();
			}
		});
		this.form.btnNewICP().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewICPClick();
			}
		});
		this.form.txtWorkflowID().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onTxtWorkflowIDValueChanged();
			}
		});
		this.form.ctnSummary().grdDiagnosis().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdDiagnosisSelectionChanged();
			}
		});
		this.form.ctnSummary().GroupProcedure().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroupProcedureValueChanged();
			}
		});
		this.form.ctnSummary().GroupDiagnosis().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroupDiagnosisValueChanged();
			}
		});
		this.form.ctnSummary().grdProcedure().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdProcedureSelectionChanged();
			}
		});
		this.form.btnSearchWorkflowID().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSearchWorkflowIDClick();
			}
		});
		this.form.chkPatientView().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkPatientViewValueChanged();
			}
		});
		this.form.getContextMenus().getClinicalContactsListNewCareGroupingItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.NewCareGrouping, sender);
			}
		});
		this.form.getContextMenus().getClinicalContactsListEditCareGroupingItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.EditCareGrouping, sender);
			}
		});
		this.form.getContextMenus().getClinicalContactsListNewEpisodeOfCareItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.NewEpisodeOfCare, sender);
			}
		});
		this.form.getContextMenus().getClinicalContactsListEditEpisodeofCareItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.EditEpisodeofCare, sender);
			}
		});
		this.form.getContextMenus().getClinicalContactsListAddContactContextDetailsItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.AddContactContextDetails, sender);
			}
		});
		this.form.getContextMenus().getClinicalContactsListEditContactContextDetailsItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.EditContactContextDetails, sender);
			}
		});
		this.form.getContextMenus().getClinicalContactsListAddContactItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.AddContact, sender);
			}
		});
		this.form.getContextMenus().getClinicalContactsListEditContactItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.EditContact, sender);
			}
		});
		this.form.getContextMenus().getClinicalContactsListViewClinicalNotesItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.ViewClinicalNotes, sender);
			}
		});
		this.form.getContextMenus().getClinicalContactsListCancelCareContextItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.CancelCareContext, sender);
			}
		});
		this.form.getContextMenus().getClinicalContactsListUndoCancelCareContextItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.UndoCancelCareContext, sender);
			}
		});
		this.form.getContextMenus().getClinicalContactsListCancelClinicalContactItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.CancelClinicalContact, sender);
			}
		});
		this.form.getContextMenus().getClinicalContactsListUndoCancelClinicalContactItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.UndoCancelClinicalContact, sender);
			}
		});
		this.form.getContextMenus().getClinicalContactsListCancelProblemGroupItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.CancelProblemGroup, sender);
			}
		});
		this.form.getContextMenus().getClinicalContactsListUndoCancelProblemGroupItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.UndoCancelProblemGroup, sender);
			}
		});
		this.form.getContextMenus().getClinicalContactsListCancelEpisodeOfCareItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.CancelEpisodeOfCare, sender);
			}
		});
		this.form.getContextMenus().getClinicalContactsListUndoCancelEpisodeOfCareItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.UndoCancelEpisodeOfCare, sender);
			}
		});
		this.form.getContextMenus().getClinicalContactsListViewCancelledContextsItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.ViewCancelledContexts, sender);
			}
		});
		this.form.getContextMenus().getClinicalContactsListHideCancelledContextsItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalContactsList.HideCancelledContexts, sender);
			}
		});
		this.form.getContextMenus().getPatSummaryDiagCompVIEWItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatSummaryDiagComp.VIEW, sender);
			}
		});
		this.form.getContextMenus().getPatSummaryDiagCompVIEWLINKSDIALOGItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatSummaryDiagComp.VIEWLINKSDIALOG, sender);
			}
		});
		this.form.getContextMenus().getPatSummaryDiagCompDISPLAYLINKSSUMMARYItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatSummaryDiagComp.DISPLAYLINKSSUMMARY, sender);
			}
		});
		this.form.getContextMenus().getPatSummaryDiagCompNEWDIAGNOSISItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatSummaryDiagComp.NEWDIAGNOSIS, sender);
			}
		});
		this.form.getContextMenus().getPatSummaryDiagCompNEWPROBLEMItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatSummaryDiagComp.NEWPROBLEM, sender);
			}
		});
		this.form.getContextMenus().getPatSummaryProcVIEWItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatSummaryProc.VIEW, sender);
			}
		});
		this.form.getContextMenus().getPatSummaryProcVIEWLINKSDIALOGItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatSummaryProc.VIEWLINKSDIALOG, sender);
			}
		});
		this.form.getContextMenus().getPatSummaryProcDISPLAYLINKSUMMARYItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatSummaryProc.DISPLAYLINKSUMMARY, sender);
			}
		});
		this.form.getContextMenus().getPatSummaryProcNEWPROCEDUREItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatSummaryProc.NEWPROCEDURE, sender);
			}
		});
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
