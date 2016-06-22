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

package ims.spinalinjuries.forms.nurassessmentskin;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindgrdTurnsColDurationLookup();
	abstract protected void bindgrdTurnsColPositionLookup();
	abstract protected void bindcmbTurnsPreformedByLookup();
	abstract protected void defaultcmbTurnsPreformedByLookupValue();
	abstract protected void bindcmbTypeOfTurnLookup();
	abstract protected void defaultcmbTypeOfTurnLookupValue();
	abstract protected void bindcmbCushionTypeLookup();
	abstract protected void defaultcmbCushionTypeLookupValue();
	abstract protected void bindcmbChairTypeLookup();
	abstract protected void defaultcmbChairTypeLookupValue();
	abstract protected void bindcmbBedTypeLookup();
	abstract protected void defaultcmbBedTypeLookupValue();
	abstract protected void bindcmbMatressTypeLookup();
	abstract protected void defaultcmbMatressTypeLookupValue();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkSkinAssessmentClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkBradenClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdTurnsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdTurnsSelectionCleared() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbTurnsPreformedByValueSet(Object value);
	abstract protected void oncmbTypeOfTurnValueSet(Object value);
	abstract protected void onImbDeleteTurnClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbNewTurnClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbCushionTypeValueSet(Object value);
	abstract protected void oncmbChairTypeValueSet(Object value);
	abstract protected void oncmbBedTypeValueSet(Object value);
	abstract protected void oncmbMatressTypeValueSet(Object value);
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkInfoClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkCopyValueChanged() throws ims.framework.exceptions.PresentationLogicException;

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
				onFormOpen();
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
		this.form.lnkSkinAssessment().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkSkinAssessmentClick();
			}
		});
		this.form.lnkBraden().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkBradenClick();
			}
		});
		this.form.grdTurns().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdTurnsSelectionChanged();
			}
		});
		this.form.grdTurns().setSelectionClearedEvent(new SelectionCleared()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdTurnsSelectionCleared();
			}
		});
		this.form.cmbTurnsPreformedBy().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTurnsPreformedByValueSet(value);
			}
		});
		this.form.cmbTypeOfTurn().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTypeOfTurnValueSet(value);
			}
		});
		this.form.imbDeleteTurn().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbDeleteTurnClick();
			}
		});
		this.form.imbNewTurn().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbNewTurnClick();
			}
		});
		this.form.cmbCushionType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbCushionTypeValueSet(value);
			}
		});
		this.form.cmbChairType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbChairTypeValueSet(value);
			}
		});
		this.form.cmbBedType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbBedTypeValueSet(value);
			}
		});
		this.form.cmbMatressType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbMatressTypeValueSet(value);
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
		this.form.lnkInfo().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkInfoClick();
			}
		});
		this.form.chkCopy().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkCopyValueChanged();
			}
		});
	}
	protected void bindLookups()
	{
		bindgrdTurnsColDurationLookup();
		bindgrdTurnsColPositionLookup();
		bindcmbTurnsPreformedByLookup();
		bindcmbTypeOfTurnLookup();
		bindcmbCushionTypeLookup();
		bindcmbChairTypeLookup();
		bindcmbBedTypeLookup();
		bindcmbMatressTypeLookup();
	}
	protected void rebindAllLookups()
	{
		bindgrdTurnsColDurationLookup();
		bindgrdTurnsColPositionLookup();
		bindcmbTurnsPreformedByLookup();
		bindcmbTypeOfTurnLookup();
		bindcmbCushionTypeLookup();
		bindcmbChairTypeLookup();
		bindcmbBedTypeLookup();
		bindcmbMatressTypeLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbTurnsPreformedByLookupValue();
		defaultcmbTypeOfTurnLookupValue();
		defaultcmbCushionTypeLookupValue();
		defaultcmbChairTypeLookupValue();
		defaultcmbBedTypeLookupValue();
		defaultcmbMatressTypeLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
