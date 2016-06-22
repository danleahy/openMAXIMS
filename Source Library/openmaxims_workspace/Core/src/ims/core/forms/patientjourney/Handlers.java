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

package ims.core.forms.patientjourney;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void onPatientJourneyControlSelectionChanged(Object entry);
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.patientJourneyControl().setSelectionChangedEvent(new PatientJourneySelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object entry)
			{
				onPatientJourneyControlSelectionChanged(entry);
			}
		});
		this.form.getContextMenus().Core.getPatientJourneyCustomControlFilterByJourneyTargetOrEventItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientJourneyCustomControl.FilterByJourneyTargetOrEvent, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientJourneyCustomControlFilterByPathwayTargetItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientJourneyCustomControl.FilterByPathwayTarget, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientJourneyCustomControlResetFilterItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientJourneyCustomControl.ResetFilter, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientJourneyCustomControlAsociatePathwayItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientJourneyCustomControl.AsociatePathway, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientJourneyCustomControlAddNewEventItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientJourneyCustomControl.AddNewEvent, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientJourneyCustomControlAddEventToTargetItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientJourneyCustomControl.AddEventToTarget, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientJourneyCustomControlViewClockHistoryItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientJourneyCustomControl.ViewClockHistory, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientJourneyCustomControlAddReadjustmentItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientJourneyCustomControl.AddReadjustment, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientJourneyCustomControlEditReadjustmentItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientJourneyCustomControl.EditReadjustment, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientJourneyCustomControlADD_COMMENTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientJourneyCustomControl.ADD_COMMENT, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientJourneyCustomControlADD_EVENTCOMMENTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientJourneyCustomControl.ADD_EVENTCOMMENT, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientJourneyCustomControlADD_TARGETCOMMENTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientJourneyCustomControl.ADD_TARGETCOMMENT, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientJourneyCustomControlRECORD_BREACH_REASONItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientJourneyCustomControl.RECORD_BREACH_REASON, sender);
			}
		});
		this.form.getContextMenus().Core.getPatientJourneyCustomControlREMOVE_TARGET_FROM_SCOPEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.PatientJourneyCustomControl.REMOVE_TARGET_FROM_SCOPE, sender);
			}
		});
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIComponentEngine engine;
	protected GenForm form;
}
