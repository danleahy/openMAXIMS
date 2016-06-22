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

package ims.coe.forms.assesspain;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindanswerBoxExpereincePainLookup();
	abstract protected void defaultanswerBoxExpereincePainLookupValue();
	abstract protected void bindgridPainReliefColRouteLookup();
	abstract protected void bindgridPainReliefColFrequencyLookup();
	abstract protected void bindanswerBoxTakeMedsLookup();
	abstract protected void defaultanswerBoxTakeMedsLookupValue();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLinkPAClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onanswerBoxExpereincePainValueSet(Object value);
	abstract protected void onAnswerBoxExpereincePainValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGridMedSelChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onanswerBoxTakeMedsValueSet(Object value);
	abstract protected void onAnswerBoxTakeMedsValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBPainReliefClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onUpdateMedClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCopyPrevAssessmentValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onInfoLinkClick() throws ims.framework.exceptions.PresentationLogicException;

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
				onDialogClosed(formName, result);
			}
		});
		this.form.linkPA().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLinkPAClick();
			}
		});
		this.form.answerBoxExpereincePain().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onanswerBoxExpereincePainValueSet(value);
			}
		});
		this.form.answerBoxExpereincePain().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onAnswerBoxExpereincePainValueChanged();
			}
		});
		this.form.bCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBCancelClick();
			}
		});
		this.form.bSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBSaveClick();
			}
		});
		this.form.gridPainRelief().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGridMedSelChanged();
			}
		});
		this.form.answerBoxTakeMeds().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onanswerBoxTakeMedsValueSet(value);
			}
		});
		this.form.answerBoxTakeMeds().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onAnswerBoxTakeMedsValueChanged();
			}
		});
		this.form.bPainRelief().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBPainReliefClick();
			}
		});
		this.form.bUpdateMed().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onUpdateMedClick();
			}
		});
		this.form.checkBoxCopy().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCopyPrevAssessmentValueChanged();
			}
		});
		this.form.linkInfo().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onInfoLinkClick();
			}
		});
	}
	protected void bindLookups()
	{
		bindanswerBoxExpereincePainLookup();
		bindgridPainReliefColRouteLookup();
		bindgridPainReliefColFrequencyLookup();
		bindanswerBoxTakeMedsLookup();
	}
	protected void rebindAllLookups()
	{
		bindanswerBoxExpereincePainLookup();
		bindgridPainReliefColRouteLookup();
		bindgridPainReliefColFrequencyLookup();
		bindanswerBoxTakeMedsLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultanswerBoxExpereincePainLookupValue();
		defaultanswerBoxTakeMedsLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
