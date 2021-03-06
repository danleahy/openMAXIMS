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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4785.23502)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.edseenbyandcompletedialog;

import ims.configuration.gen.ConfigFlag;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.MedicVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.enums.MosType;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.forms.edseenbyandcompletedialog.GenForm.grdNotesRow;
import ims.emergency.vo.AttendanceClinicalNotesVo;
import ims.emergency.vo.AttendanceClinicalNotesVoCollection;
import ims.emergency.vo.AttendanceForSeenByHCPVo;
import ims.emergency.vo.SeenByHCPVo;
import ims.emergency.vo.SeenByHCPVoCollection;
import ims.emergency.vo.TrackingAttendanceStatusVo;
import ims.emergency.vo.TrackingForSeenByHCPVo;
import ims.emergency.vo.enums.EDSeenByAndCompleteEvent;
import ims.emergency.vo.lookups.AttendanceClinicalNoteType;
import ims.emergency.vo.lookups.RequiresSignOff;
import ims.emergency.vo.lookups.TrackingStatus;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;

import java.util.ArrayList;
import java.util.Comparator;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	private static final String EDIT_CAPTION = "Edit Note";
	private static final String CORRECT_CAPTION = "Correct Note";

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}
	
	private void updateControlsState() //WDEV-17253
	{
		boolean noteWasCreatedByCurrentUser = form.grdNotes().getValue()!=null && form.grdNotes().getValue().getAuthoringInformation()!=null && form.grdNotes().getValue().getAuthoringInformation().getAuthoringHcp()!=null && form.grdNotes().getValue().getAuthoringInformation().getAuthoringHcp().equals(form.getLocalContext().getLoggedHCP()); ////WDEV-17304
		
		SeenByHCPVo selectedSeenByHCP = form.getLocalContext().getselectedSeenByHCP();
		form.imbAdd().setVisible(false);
		form.imbEdit().setVisible(false);
		
		form.ccSeenByMedic().setEnabled(FormMode.EDIT.equals(form.getMode()) && (!EDSeenByAndCompleteEvent.EDIT.equals(form.getLocalContext().getselectedEvent()) || (selectedSeenByHCP!=null && selectedSeenByHCP.getAllocatedMedic()!=null && EDSeenByAndCompleteEvent.EDIT.equals(form.getLocalContext().getselectedEvent()))));//WDEV-17239 //WDEV-17410
		form.ccSeenByMedic().isRequired(form.ccSeenByMedic().isEnabled()); //WDEV-20429
		form.dtimSeen().setEnabled(FormMode.EDIT.equals(form.getMode()));
		form.dtimCompleted().setEnabled(FormMode.EDIT.equals(form.getMode()) && (!EDSeenByAndCompleteEvent.EDIT.equals(form.getLocalContext().getselectedEvent()) || (selectedSeenByHCP!=null && selectedSeenByHCP.getCompletedDateTime()!=null && EDSeenByAndCompleteEvent.EDIT.equals(form.getLocalContext().getselectedEvent()))));//WDEV-17239 //WDEV-17410
		
		form.dtimCompleted().setRequired(FormMode.EDIT.equals(form.getMode()) && (EDSeenByAndCompleteEvent.COMPLETED.equals(form.getLocalContext().getselectedEvent()) || (selectedSeenByHCP!=null && selectedSeenByHCP.getCompletedDateTime()!=null && EDSeenByAndCompleteEvent.EDIT.equals(form.getLocalContext().getselectedEvent()))));//WDEV-17239 //WDEV-17410
		
		form.btnSeen().setEnabled(FormMode.VIEW.equals(form.getMode()));//WDEV-17354
		form.btnSeen().setVisible(FormMode.VIEW.equals(form.getMode()));//WDEV-17354
		if (form.btnSeen().isEnabled())
		{
			form.btnSeen().setBackgroundColor(Color.LightYellow);
		}
		else
		{
			form.btnSeen().clearBackgroundColor();
		}
		//form.btnCompleted().setEnabled(FormMode.VIEW.equals(form.getMode()) && selectedSeenByHCP!=null && form.dtimCompleted().getValue()==null);
		form.btnCompleted().setEnabled((FormMode.VIEW.equals(form.getMode()) && selectedSeenByHCP!=null && form.dtimCompleted().getValue()==null) || (FormMode.EDIT.equals(form.getMode()) && form.dtimCompleted().getValue()==null && !EDSeenByAndCompleteEvent.EDIT.equals(form.getLocalContext().getselectedEvent())));//WDEV-17239
		
		if (form.btnCompleted().isEnabled())
		{
			form.btnCompleted().setBackgroundColor(Color.Coral);
		}
		else
		{
			form.btnCompleted().clearBackgroundColor();
		}
		
		form.btnNewNote().setEnabled(!(selectedSeenByHCP==null && FormMode.VIEW.equals(form.getMode())));
		form.imbAdd().setEnabled(!(selectedSeenByHCP==null && FormMode.VIEW.equals(form.getMode())));
		form.getContextMenus().Emergency.getEDSeenByAndCompleteMenuAddItem().setVisible(!(selectedSeenByHCP==null && FormMode.VIEW.equals(form.getMode())));
		
		form.btnEditNote().setVisible(form.grdNotes().getValue()!=null);
		
		if(FormMode.EDIT.equals(form.getMode()))
		{
			form.btnEditNote().setEnabled(form.grdNotes().getValue()!=null && form.grdNotes().getValue().getID_AttendanceClinicalNotes() == null);
		}
		else
		{
			form.btnEditNote().setEnabled(form.grdNotes().getValue()!=null && !Boolean.TRUE.equals(form.grdNotes().getValue().getIsCorrected()) && noteWasCreatedByCurrentUser);//WDEV-17304
		}
		form.btnEditNote().setText(getEditCorrectButtonText(form.grdNotes().getValue()));
		
		form.getContextMenus().Emergency.getEDSeenByAndCompleteMenuEDITItem().setVisible(FormMode.EDIT.equals(form.getMode()) && form.grdNotes().getValue()!=null && form.grdNotes().getValue().getID_AttendanceClinicalNotes() == null);
		form.getContextMenus().Emergency.getEDSeenByAndCompleteMenuCORRECTItem().setVisible(FormMode.VIEW.equals(form.getMode()) && form.grdNotes().getValue()!=null && !Boolean.TRUE.equals(form.grdNotes().getValue().getIsCorrected()) && noteWasCreatedByCurrentUser);//WDEV-17304
		
		form.imbEdit().setEnabled(form.grdNotes().getValue()!=null);
		
		//WDEV17239
		form.btnEdit().setVisible(FormMode.VIEW.equals(form.getMode()) && form.recbrSeenByHCP().getValue() != null);
		
		if(FormMode.VIEW.equals(form.getMode()))
		{
			form.btnRIE().setVisible(form.recbrSeenByHCP().getValue() != null);
		}
		
		form.btnSave().setVisible(FormMode.EDIT.equals(form.getMode()) && EDSeenByAndCompleteEvent.EDIT.equals(form.getLocalContext().getselectedEvent()));
		form.btnSaveAndClose().setVisible(FormMode.EDIT.equals(form.getMode()) && !EDSeenByAndCompleteEvent.EDIT.equals(form.getLocalContext().getselectedEvent()));
		
		//WDEV-19293
		Object hcp = domain.getHcpUser();
		boolean isUserEdResponsibleClinician = hcp !=null && hcp instanceof MedicVo && Boolean.TRUE.equals(((MedicVo)hcp).getIsAResponsibleEDClinician())? true : false;
		
		form.chkSignedOff().setVisible(RequiresSignOff.REQUIRES_SIGN_OFF.equals(form.getLocalContext().getcurrentTracking().getAttendance().getRequiresSignOff()) && isUserEdResponsibleClinician); 
		form.chkSignedOff().setEnabled(FormMode.EDIT.equals(form.getMode()));
	}
	
	private String getEditCorrectButtonText(AttendanceClinicalNotesVo note) 
	{
		if(note == null)
			return FormMode.EDIT.equals(form.getMode()) ? EDIT_CAPTION : CORRECT_CAPTION;
		
		if(note.getID_AttendanceClinicalNotes() == null)
			return EDIT_CAPTION;
		
		return CORRECT_CAPTION;
	}
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		//WDEV-17304
		Object hcp = domain.getHcpLiteUser();
		if (hcp !=null && hcp instanceof HcpLiteVo)
		{
			form.getLocalContext().setLoggedHCP((HcpRefVo) hcp);
		}
		
		initializeControls();
		
		form.getLocalContext().setcurrentTracking(domain.getTracking(form.getGlobalContext().Emergency.getTracking()));
		open();
		
		if(form.getLocalContext().getselectedSeenByHCP() == null || form.getLocalContext().getselectedSeenByHCP().getCompletedDateTimeIsNotNull() )
		{
			newInstance();
		}
		
	}
	
	private void newInstance() //WDEV-17253
	{
		clearInstanceControls();
		form.recbrSeenByHCP().clear();//WDEV-17348
		
		form.getLocalContext().setselectedSeenByHCP(null);

		Object mos = domain.getHcpUser();

		if (mos instanceof MedicVo)
		{
			form.ccSeenByMedic().setValue((MedicVo) mos);
		}

		form.dtimSeen().setValue(new DateTime());
		
		form.setMode(FormMode.EDIT);
	}

	private void initializeControls() //WDEV-17253
	{
		form.btnRIE().setImage(form.getImages().Core.Alert_RedTriangle2);
		form.ccSeenByMedic().initialize(MosType.MEDIC);
	}
	
	private void clearInstanceControls() //WDEV-17253
	{
		form.ccSeenByMedic().setValue(null);
		form.dtimSeen().setValue(null);
		form.dtimCompleted().setValue(null);
		form.grdNotes().getRows().clear();
		
		form.chkSignedOff().setValue(null);//WDEV-19293
		
		//form.getLocalContext().setSelectedComment(null);
	}

	private void open()
	{
		form.getLocalContext().setselectedEvent(null);
		populateScreenFromData();
		form.setMode(FormMode.VIEW);
	}

	private void populateScreenFromData()
	{
		populateRecordBrowser();
		form.getLocalContext().setselectedSeenByHCP(form.getLocalContext().getselectedSeenByHCP()!=null ? domain.getSeenByHCP(form.getLocalContext().getselectedSeenByHCP()) : null);
		populateInstanceControls(form.getLocalContext().getselectedSeenByHCP());
	}

	private void populateInstanceControls(SeenByHCPVo seenByHCP) //WDEV-17253
	{
		clearInstanceControls();
		
		if (seenByHCP==null)
			return;
		
		form.ccSeenByMedic().setValue(seenByHCP.getAllocatedMedic());
		form.dtimSeen().setValue(seenByHCP.getSeenDateTime());
		form.dtimCompleted().setValue(seenByHCP.getCompletedDateTime());
		form.chkSignedOff().setValue(seenByHCP.getSignOff()); //WDEV-19293
		
		populateCommentGrid(seenByHCP.getSeenByHCPNotes());
	}

	private void populateCommentGrid(AttendanceClinicalNotesVoCollection notes)
	{
		if (notes == null)
			return;

		notes.sort(new CommentsDateComparator(SortOrder.DESCENDING));
		
		for (int i = 0; i < notes.size(); i++)
		{
			addRowToNotesGrid(notes.get(i));
		}
	}

	private void addRowToNotesGrid(AttendanceClinicalNotesVo referralNote)
	{
		if (referralNote==null)
			return;
		
		StringBuffer tooltip = new StringBuffer();
		
		grdNotesRow newrow = form.grdNotes().getRows().newRow();
		
		if (Boolean.TRUE.equals(referralNote.getIsCorrected()))
		{
			newrow.setBackColor(ConfigFlag.UI.CORRECTION_ROW_COLOUR.getValue());
			
			if(referralNote.getCorrectedAuthoringInformation() != null)
			{
				tooltip.append("<br><b>Correction HCP: </b>" + referralNote.getCorrectedAuthoringInformation().getAuthoringHcp());
				tooltip.append("<br><b>Corrected Date/Time: </b>" + referralNote.getCorrectedAuthoringInformation().getAuthoringDateTime());
				tooltip.append(referralNote.getCorrectionCommentsIsNotNull() ? "<br><b>Correction comments: </b>" + referralNote.getCorrectionComments(): "<br><b>No Comments</b>");
			}
		}
		
		if(referralNote.getAuthoringInformation().getAuthoringHcp() != null)
		{
			newrow.setcolAuthoringHCP(Boolean.TRUE.equals(referralNote.getIsCorrected()) ? "<s>" + referralNote.getAuthoringInformation().getAuthoringHcp().toString().toString() + "</s>" : referralNote.getAuthoringInformation().getAuthoringHcp().toString());
			newrow.setCellcolAuthoringHCPTooltip(referralNote.getAuthoringInformation().getAuthoringHcp().toString() + tooltip.toString());
		}
		
		if(referralNote.getAuthoringInformation().getAuthoringDateTime() != null)
		{
			newrow.setcolDate(Boolean.TRUE.equals(referralNote.getIsCorrected()) ? "<s>" + referralNote.getAuthoringInformation().getAuthoringDateTime().toString() + "</s>" : referralNote.getAuthoringInformation().getAuthoringDateTime().toString());
			newrow.setCellcolDateTooltip(referralNote.getAuthoringInformation().getAuthoringDateTime().toString() + tooltip.toString());
		}
		
		newrow.setcolComments(Boolean.TRUE.equals(referralNote.getIsCorrected()) ? "<s>" + referralNote.getClinicalNote() + "</s>" : referralNote.getClinicalNote());
		newrow.setCellcolCommentsTooltip(referralNote.getClinicalNote() + tooltip.toString());
		
		newrow.setValue(referralNote);
	}

	private void populateRecordBrowser()
	{
		SeenByHCPVoCollection allSennByHcp = domain.getAllSeenByHCP(form.getGlobalContext().Core.getCurrentCareContext());

		form.recbrSeenByHCP().clear();

		if (allSennByHcp == null || allSennByHcp.size() == 0)
		{
			return;
		}

		for (int i = 0; i < allSennByHcp.size(); i++)
		{
			SeenByHCPVo seenByHcp = allSennByHcp.get(i);

			if (seenByHcp == null)
				return;

			StringBuffer string = new StringBuffer();

			if (seenByHcp.getAllocatedDateTimeIsNotNull())
			{
				string.append("Allocated on: "+seenByHcp.getAllocatedDateTime());
			}

			if (seenByHcp.getAllocatedMedicIsNotNull())
			{
				string.append(" - "+seenByHcp.getAllocatedMedic().getName());
			}

			if (seenByHcp.getAllocatedNurseIsNotNull())
			{
				string.append(" - "+seenByHcp.getAllocatedNurse().getName());
			}
			
			if (seenByHcp.getSeenDateTimeIsNotNull())
			{
				string.append(" - Seen on: "+seenByHcp.getSeenDateTime());
			}

			if (seenByHcp.getCompletedDateTimeIsNotNull())
			{
				string.append(" - Completed on: "+seenByHcp.getCompletedDateTime());
			}

			//WDEV-17239
			if (i==0)
			{
				form.recbrSeenByHCP().newRow(i, seenByHcp, string.toString(),Color.Green);
			}
			else 
			{
				form.recbrSeenByHCP().newRow(i, seenByHcp, string.toString());
			}
				
		}

		if (allSennByHcp.size() > 0 && form.getLocalContext().getselectedSeenByHCP() == null)
		{
			form.getLocalContext().setselectedSeenByHCP(allSennByHcp.get(0));
		}

		form.recbrSeenByHCP().setValue(form.getLocalContext().getselectedSeenByHCP());	
	}
	
	@Override
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getForms().Emergency.TrackingStatusDialog.equals(formName) && DialogResult.OK.equals(result))
		{
			if (save())
			{
				if (EDSeenByAndCompleteEvent.SAVE.equals(form.getLocalContext().getselectedEvent()))
				{
					engine.close(DialogResult.OK);
				}
				else
				{
					open();
				}
			}
		}
		else if (form.getForms().Emergency.TrackingStatusDialog.equals(formName) && DialogResult.CANCEL.equals(result) && FormMode.VIEW.equals(form.getMode()))
		{
			open();
		}
	
		if ((form.getForms().Emergency.AttendanceClinicalNoteDialog.equals(formName) || form.getForms().Emergency.NoteCorrectionDialog.equals(formName)) && FormMode.VIEW.equals(form.getMode()))
		{
			open();
			form.grdNotes().setValue(form.getGlobalContext().Emergency.getAttendanceClinicalNotes());
			updateControlsState();
		}
		else if (form.getForms().Emergency.AttendanceClinicalNoteDialog.equals(formName) && DialogResult.OK.equals(result) && FormMode.EDIT.equals(form.getMode())) 
		{
			if (form.grdNotes().getValue() != null)
			{
				updateRowToNotesGrid(form.getGlobalContext().Emergency.getAttendanceClinicalNotes());
			}
			else
			{
				addRowToNotesGrid(form.getGlobalContext().Emergency.getAttendanceClinicalNotes());
				form.grdNotes().setValue(form.getGlobalContext().Emergency.getAttendanceClinicalNotes());
			}
			updateControlsState();
		}
		else if(form.getForms().Core.RieConfirmationDialog.equals(formName))
		{
			if(DialogResult.OK.equals(result))
			{
				if(markAsRIE())
				{
					form.getLocalContext().setselectedSeenByHCP(null);
					open();
					
					form.getLocalContext().setcurrentTracking(domain.getTracking(form.getLocalContext().getcurrentTracking())); //wdev-19587
				}
			}
		}
	}
	
	private boolean markAsRIE()
	{
		if (form.getLocalContext().getselectedSeenByHCP() == null)
			return false;
		
		if (domain.isStale(form.getLocalContext().getselectedSeenByHCP()))
        {
        	engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
        	form.getLocalContext().setselectedSeenByHCP(null);
        	open();
        	return false;
        }
		
		TrackingForSeenByHCPVo tracking = null;
		
		if(form.getLocalContext().getcurrentTracking() != null && form.recbrSeenByHCP().getValue().equals(form.getLocalContext().getcurrentTracking().getSeenBy()))
		{
			tracking = form.getLocalContext().getcurrentTracking();
			tracking.setSeenBy(null);
		}
     
		try 
		{
			domain.markSeenByHCPAsRIE(form.getLocalContext().getselectedSeenByHCP(), tracking, engine.getFormName(), form.getGlobalContext().Core.getPatientShort() != null ? form.getGlobalContext().Core.getPatientShort().getID_Patient() : null, form.getGlobalContext().Core.getCurrentCareContext() != null ? form.getGlobalContext().Core.getCurrentCareContext().getID_CareContext() : null, form.getGlobalContext().Core.getRieMessage());
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			form.getLocalContext().setselectedSeenByHCP(null);
			open();
			return false;
		}
		
		return true;
	}

	private void updateRowToNotesGrid(AttendanceClinicalNotesVo attClinicalNote)
	{
		grdNotesRow row = form.grdNotes().getSelectedRow();
		row.setcolAuthoringHCP(attClinicalNote.getAuthoringInformation().getAuthoringHcp().toString());
		row.setcolDate(attClinicalNote.getAuthoringInformation().getAuthoringDateTime().toString());
		row.setcolComments(attClinicalNote.getClinicalNote());
		
		//WDEV-17302
		row.setCellcolAuthoringHCPTooltip(attClinicalNote.getAuthoringInformation().getAuthoringHcp().toString());
		row.setCellcolDateTooltip(attClinicalNote.getAuthoringInformation().getAuthoringDateTime().toString());
		row.setCellcolCommentsTooltip(attClinicalNote.getClinicalNote());
		
		row.setValue(attClinicalNote);
	}

	@Override
	protected void onImbAddClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newAttendanceClinicalNote();
	}
	@Override
	protected void onBtnNewNoteClick() throws PresentationLogicException
	{
		newAttendanceClinicalNote();
	}
	private void newAttendanceClinicalNote() //WDEV-20429
	{
		form.getGlobalContext().Emergency.setAttendanceClinicalNotes(null);
		form.grdNotes().setValue(null);
		if (FormMode.EDIT.equals(form.getMode()))
		{
			engine.open(form.getForms().Emergency.AttendanceClinicalNoteDialog, new Object[] {AttendanceClinicalNoteType.MEDIC,form.getLocalContext().getselectedSeenByHCP(),null,form.getMode()});
		}
		else
		{
			engine.open(form.getForms().Emergency.AttendanceClinicalNoteDialog, new Object[] {AttendanceClinicalNoteType.MEDIC,form.getLocalContext().getselectedSeenByHCP()});
		}
	}
	@Override
	protected void onImbEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		editAttendanceClinicalNote();
	}
	
	@Override
	protected void onBtnEditNoteClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.grdNotes().getValue() == null)
			return;
		
		if(form.grdNotes().getValue().getID_AttendanceClinicalNotes() != null)
		{
			correctNote();
		}
		else
		{
			editAttendanceClinicalNote();
		}
	}
	
	private void correctNote() 
	{
		form.getGlobalContext().Emergency.setAttendanceClinicalNotes(form.grdNotes().getValue());
		engine.open(form.getForms().Emergency.NoteCorrectionDialog,new Object[] {form.grdNotes().getValue()}); 
	}
	
	private void editAttendanceClinicalNote()
	{
		form.getGlobalContext().Emergency.setAttendanceClinicalNotes(form.grdNotes().getValue());
		if (FormMode.EDIT.equals(form.getMode()))
		{
			engine.open(form.getForms().Emergency.AttendanceClinicalNoteDialog, new Object[] {null,null,null,form.getMode()});
		}
		else
		{
			engine.open(form.getForms().Emergency.AttendanceClinicalNoteDialog);
		}
	}
	@Override
	protected void onGrdNotesSelectionChanged()
	{
		updateControlsState();
	}
	@Override
	protected void onBtnCompletedClick() throws ims.framework.exceptions.PresentationLogicException
	{		
		form.getLocalContext().setselectedEvent(EDSeenByAndCompleteEvent.COMPLETED);//WDEV-17239
		form.dtimCompleted().setValue(new DateTime());
		
		if (FormMode.EDIT.equals(form.getMode()))
		{
			defaultSeenControls();
			updateControlsState();//WDEV-17239
			return;
		}
		
		validateUI();
		
		//WDEV-17925
		if (Boolean.TRUE.equals(form.getLocalContext().getcurrentTracking().getIsDischarged()))
		{
			if (save())
			{
				if (EDSeenByAndCompleteEvent.SAVE.equals(form.getLocalContext().getselectedEvent()))
				{
					engine.close(DialogResult.OK);
				}
				else
				{
					open();
				}
			}
		}
		else
		{
			engine.open(form.getForms().Emergency.TrackingStatusDialog);
		}
		
	}
	@Override
	protected void onBtnSeenClick() throws ims.framework.exceptions.PresentationLogicException //WDEV-17253
	{
		
		clearInstanceControls();//WDEV-17253
		defaultSeenControls();
		form.getLocalContext().setselectedSeenByHCP(null);
		
		if (form.ccSeenByMedic().getValue()==null)
		{
			form.setMode(FormMode.EDIT);
			return;
		}
		
		if (FormMode.EDIT.equals(form.getMode()))
		{
			return;
		}
		
		if (save())
		{
			open();
		}
	}

	private void defaultSeenControls() //WDEV-17253
	{
		Object mos = domain.getHcpUser();

		if (form.ccSeenByMedic().getValue()==null && mos instanceof MedicVo)
		{
			form.ccSeenByMedic().setValue((MedicVo) mos);
		}

		if (form.dtimSeen().getValue()==null)
		{
			form.dtimSeen().setValue(new DateTime());
		}
	}

	private boolean save()
	{
		SeenByHCPVo seenByHcpToSave = populateDataFromScreen(form.getLocalContext().getselectedSeenByHCP());

		String[] errors = seenByHcpToSave.validate(getUIErrors());
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}

		// Check SOE
		if (seenByHcpToSave.getID_SeenByHCPIsNotNull() && domain.isStale(seenByHcpToSave))
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			if (form.getLocalContext().getselectedSeenByHCPIsNotNull())
			{
				form.getLocalContext().setselectedSeenByHCP(domain.getSeenByHCP(form.getLocalContext().getselectedSeenByHCP()));
			}
			if (form.getLocalContext().getcurrentTrackingIsNotNull())
			{
				form.getLocalContext().setcurrentTracking(domain.getTracking(form.getLocalContext().getcurrentTracking()));
			}
			open();
			return false;
		}

		TrackingForSeenByHCPVo trackingToSave = null;
		AttendanceForSeenByHCPVo attendanceToSave = null;//WDEV-19293

		// for a new TrackingForReferalToSpecialty set the current referral in
		// tracking and set Tracking.CurrentStatus
		if (seenByHcpToSave.getID_SeenByHCP()==null && form.getLocalContext().getcurrentTracking().getCurrentAreaIsNotNull() && !Boolean.TRUE.equals(form.getLocalContext().getcurrentTracking().getIsDischarged()) && form.getGlobalContext().Emergency.getTrackingAttendanceStatus()==null )//WDEV-17171
		{
			trackingToSave = form.getLocalContext().getcurrentTracking();
			trackingToSave.setSeenBy(seenByHcpToSave);
			//wdev-17606
			if( form.getLocalContext().getcurrentTrackingIsNotNull() && form.getLocalContext().getcurrentTracking().getTriageDetailsIsNotNull() && !form.getLocalContext().getcurrentTracking().getTriageDetails().getMedicInterventionStartDateTimeIsNotNull() && seenByHcpToSave.getAllocatedMedicIsNotNull())   //wdev-17627
			{
				form.getLocalContext().getcurrentTracking().getTriageDetails().setMedicInterventionStartDateTime(new DateTime());
			}
			//
			
			//WDEV-17253
			if (form.ccSeenByMedic().getValue()!=null)
			{	
				TrackingAttendanceStatusVo trackingStatusToSave = populateTrackingAttendanceStatus(TrackingStatus.BEING_ATTENDED_TO);
				trackingToSave.setCurrentStatus(trackingStatusToSave);
			}
			
				
		}
		// set the current referral to null if referral record is marked as
		// completed
		else if (seenByHcpToSave.getCompletedDateTimeIsNotNull() &&
				form.getLocalContext().getcurrentTrackingIsNotNull() && //WDEV-18336
				form.getLocalContext().getcurrentTracking().getCurrentAreaIsNotNull() &&
				!Boolean.TRUE.equals(form.getLocalContext().getcurrentTracking().getIsDischarged())&&
				form.getGlobalContext().Emergency.getTrackingAttendanceStatusIsNotNull())//WDEV-17171
		{
			trackingToSave = form.getLocalContext().getcurrentTracking();
			trackingToSave.setCurrentStatus(form.getGlobalContext().Emergency.getTrackingAttendanceStatus());
			form.getGlobalContext().Emergency.setTrackingAttendanceStatus(null);//WDEV-17171
			trackingToSave.setSeenBy(null);
		}
		//WDEV-17925
		else if (seenByHcpToSave.getID_SeenByHCP()==null && Boolean.TRUE.equals(form.getLocalContext().getcurrentTracking().getIsDischarged()))
		{
			trackingToSave = form.getLocalContext().getcurrentTracking();
			trackingToSave.setSeenBy(seenByHcpToSave);
		}
		else if (seenByHcpToSave.getCompletedDateTimeIsNotNull() && Boolean.TRUE.equals(form.getLocalContext().getcurrentTracking().getIsDischarged()))//WDEV-17171
		{
			trackingToSave = form.getLocalContext().getcurrentTracking();
			trackingToSave.setSeenBy(null);
		}
		
		//WDEV-19293
		if (form.chkSignedOff().isVisible() && form.chkSignedOff().isEnabled() && form.chkSignedOff().getValue())
		{
			if (trackingToSave!=null)
			{
				trackingToSave.getAttendance().setRequiresSignOff(RequiresSignOff.SIGNED_OFF);
			}
			else
			{
				attendanceToSave = form.getLocalContext().getcurrentTracking().getAttendance();
				attendanceToSave.setRequiresSignOff(RequiresSignOff.SIGNED_OFF);
			}
		}
		
		try
		{
			if (trackingToSave != null && !seenByHcpToSave.getCompletedDateTimeIsNotNull())
			{
				String[] errors1 = trackingToSave.validate();

				if (errors1 != null && errors1.length > 0)
				{
					engine.showErrors(errors1);
					return false;
				}
				
				SeenByHCPVo previousRecordNotCompleted = domain.getUncompletedSeenByHCPCareContext(form.getGlobalContext().Core.getCurrentCareContext());
				//if Seen is pressed and the previous record is not completed, save previusRecord with completedDateTime set to currentDateTime and create another SeenByHcp that is saved in SeenBy in Tracking
				if (seenByHcpToSave.getID_SeenByHCP()==null && previousRecordNotCompleted!=null)
				{
					previousRecordNotCompleted.setCompletedDateTime(new DateTime());
					form.getLocalContext().setselectedSeenByHCP(domain.save(null, trackingToSave,previousRecordNotCompleted, null)); //WDEV-19293
				}
				else
				{
					form.getLocalContext().setselectedSeenByHCP(domain.save(null, trackingToSave,null, null)); //WDEV-19293
				}
				
				form.getLocalContext().setcurrentTracking(domain.getTracking(trackingToSave));
			}
			else if (trackingToSave != null && seenByHcpToSave.getCompletedDateTimeIsNotNull())
			{
				String[] errors1 = trackingToSave.validate();

				if (errors1 != null && errors1.length > 0)
				{
					engine.showErrors(errors1);
					return false;
				}
				form.getLocalContext().setselectedSeenByHCP(domain.save(seenByHcpToSave, trackingToSave,null, null)); //WDEV-19293
				form.getLocalContext().setcurrentTracking(domain.getTracking(trackingToSave));
			}
			else if (trackingToSave==null && attendanceToSave!=null) //WDEV-19293
			{
				form.getLocalContext().setselectedSeenByHCP(domain.save(seenByHcpToSave, null,null, attendanceToSave));
			}
			else
				form.getLocalContext().setselectedSeenByHCP(domain.save(seenByHcpToSave, null,null, null)); //WDEV-19293
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());

			if (form.getLocalContext().getselectedSeenByHCPIsNotNull())
			{
				form.getLocalContext().setselectedSeenByHCP(domain.getSeenByHCP(form.getLocalContext().getselectedSeenByHCP()));
			}
			if (trackingToSave != null)
			{
				form.getLocalContext().setcurrentTracking(domain.getTracking(trackingToSave));
			}
			open();
			return false;
		}

		return true;
	}
	
	private TrackingAttendanceStatusVo populateTrackingAttendanceStatus(TrackingStatus status)
	{
		TrackingAttendanceStatusVo trackingAttStatus = new TrackingAttendanceStatusVo();

		trackingAttStatus.setPatient(form.getGlobalContext().Core.getPatientShort());
		trackingAttStatus.setEpisode(form.getGlobalContext().Core.getEpisodeofCareShort());
		trackingAttStatus.setAttendance(form.getGlobalContext().Core.getCurrentCareContext());
		trackingAttStatus.setTrackingArea(form.getLocalContext().getcurrentTracking().getCurrentArea());

		trackingAttStatus.setStatusDatetime(new DateTime());

		Object mos = domain.getMosUser();
		if (mos instanceof MemberOfStaffLiteVo)
		{
			trackingAttStatus.setCreatedBy((MemberOfStaffLiteVo) mos);
		}

		trackingAttStatus.setStatus(status);
		trackingAttStatus.setPrevStatus((form.getLocalContext().getcurrentTracking()!=null && form.getLocalContext().getcurrentTracking().getCurrentStatus()!=null  ) ? form.getLocalContext().getcurrentTracking().getCurrentStatus().getStatus() : null);
		
		return trackingAttStatus;
	}
	
	private String[] getUIErrors() //WDEV-17253
	{
		ArrayList<String> errors = new ArrayList<String>();

		if (form.ccSeenByMedic().getValue()==null )
		{
			errors.add("'Seen by Medic' is mandatory");
		}
		
		if (form.dtimSeen().getValue() != null)
		{
			if (form.dtimSeen().getValue().isGreaterThan(new DateTime()))
			{
				errors.add("'Date and time Patient Seen' cannot be set in the future.");
			}
			DateTime registrationDateTime = domain.getAttendanceRegistrationDateTime(form.getGlobalContext().Core.getCurrentCareContext());

			if (registrationDateTime.isGreaterThan(form.dtimSeen().getValue()))
			{
				errors.add("'Date and time Patient Seen' must be after Registration Date/Time for the selected attendance.");
			}
			
			if (form.dtimCompleted().getValue() != null)
			{
				if (form.dtimSeen().getValue().getDate().isGreaterThan(form.dtimCompleted().getValue().getDate()) || (form.dtimSeen().getValue().getDate().equals(form.dtimCompleted().getValue().getDate()) && form.dtimSeen().getValue().getTime().isGreaterThan(form.dtimCompleted().getValue().getTime())))
				{
					errors.add("'Date and time Patient Seen' cannot be greater than 'Current HCP finished with Patient'!");
				}
			}
		}

		if (form.dtimCompleted().getValue() != null && form.dtimCompleted().getValue().isGreaterThan(new DateTime()))
		{
			errors.add("'Current HCP finished with Patient' cannot be set in the future.");
		}
		
		//WDEV-17239
		if (EDSeenByAndCompleteEvent.EDIT.equals(form.getLocalContext().getselectedEvent()) && form.getLocalContext().getselectedSeenByHCP()!=null)
		{
			SeenByHCPVo selectedSeenByHCP = form.getLocalContext().getselectedSeenByHCP();
			if (selectedSeenByHCP!=null && selectedSeenByHCP.getSeenDateTimeIsNotNull() && form.dtimSeen().getValue()==null)
			{
				errors.add("You are allowed only to edit, not to remove the value from 'Date and time Patient Seen'.");
			}	
			if (selectedSeenByHCP!=null && selectedSeenByHCP.getCompletedDateTimeIsNotNull() && form.dtimCompleted().getValue()==null)
			{
				errors.add("You are allowed only to edit, not to remove the value from 'Current HCP finished with Patient'.");
			}
		}
		
		if (!EDSeenByAndCompleteEvent.EDIT.equals(form.getLocalContext().getselectedEvent()) && form.dtimSeen().getValue()==null)
		{
			errors.add("'Date and time Patient Seen' is mandatory.");
		}
		
		if (FormMode.EDIT.equals(form.getMode()) && EDSeenByAndCompleteEvent.COMPLETED.equals(form.getLocalContext().getselectedEvent()) && form.dtimCompleted().getValue()==null)
		{
			errors.add("'Current HCP finished with Patient' is mandatory.");
		}
		
		if (errors.size() > 0)
		{
			String[] UIErrors = new String[errors.size()];
			errors.toArray(UIErrors);
			return UIErrors;
		}

		return null;
	}
	private SeenByHCPVo populateDataFromScreen(SeenByHCPVo seenByHCP) //WDEV-17253
	{
		if (seenByHCP == null)
		{
			seenByHCP = new SeenByHCPVo();
		}
		else
			seenByHCP=(SeenByHCPVo) seenByHCP.clone();

		seenByHCP.setPatient(form.getGlobalContext().Core.getPatientShort());
		seenByHCP.setEpisode(form.getGlobalContext().Core.getEpisodeofCareShort());
		seenByHCP.setAttendance(form.getGlobalContext().Core.getCurrentCareContext());
		seenByHCP.setTrackingArea(form.getLocalContext().getcurrentTracking().getCurrentArea());

		if (seenByHCP.getAllocatedDateTime()==null)
		{
			seenByHCP.setAllocatedDateTime(new DateTime());
		}
		seenByHCP.setAllocatedMedic((MedicVo)form.ccSeenByMedic().getValue());
		seenByHCP.setSeenDateTime(form.dtimSeen().getValue());
		seenByHCP.setCompletedDateTime(form.dtimCompleted().getValue());
		seenByHCP.setSeenByHCPNotes(populateCommentsFromScreen());

		seenByHCP.setSignOff(form.chkSignedOff().getValue()); //WDEV-19293
		
		return seenByHCP;
	}

	private AttendanceClinicalNotesVoCollection populateCommentsFromScreen()
	{
		AttendanceClinicalNotesVoCollection commentsCollection = new AttendanceClinicalNotesVoCollection();

		for (int i = 0; i < form.grdNotes().getRows().size(); i++)
		{
			commentsCollection.add(form.grdNotes().getRows().get(i).getValue());
		}
		
		return commentsCollection;
	}
	@Override
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	@Override
	protected void onBtnSaveAndCloseClick() throws ims.framework.exceptions.PresentationLogicException //WDEV-17239
	{
		//WDEV-17195
		if (!validateUI())
		{
			return;
		}
		
		form.getLocalContext().setselectedEvent(EDSeenByAndCompleteEvent.SAVE);
		if (form.dtimCompleted().getValue()!=null && !Boolean.TRUE.equals(form.getLocalContext().getcurrentTracking().getIsDischarged()))//WDEV-17925
		{
			engine.open(form.getForms().Emergency.TrackingStatusDialog);
			return;
		}
		
		if (save())
		{
			//open();
			engine.close(DialogResult.CANCEL);	
		}
	}

	//WDEV-17195
	private boolean validateUI()
	{
		String[] errors = getUIErrors();
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false ;
		}
		return true;
	}
	@Override
	protected void onRecbrSeenByHCPValueChanged() throws PresentationLogicException
	{
		getSelectedInstance();
		updateControlsState();
	}	
	
	private void getSelectedInstance()
	{
		form.getLocalContext().setselectedSeenByHCP(domain.getSeenByHCP(form.recbrSeenByHCP().getValue()));
	
		form.getGlobalContext().Emergency.setAttendanceClinicalNotes(null);
		populateInstanceControls(form.getLocalContext().getselectedSeenByHCP());
	}
	
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.EmergencyNamespace.EDSeenByAndCompleteMenu.Add:
				newAttendanceClinicalNote();
			break;
			
			case GenForm.ContextMenus.EmergencyNamespace.EDSeenByAndCompleteMenu.EDIT:
				editAttendanceClinicalNote();
			break;
			
			case GenForm.ContextMenus.EmergencyNamespace.EDSeenByAndCompleteMenu.CORRECT:
				correctNote();
			break;
		}
	}

	public class CommentsDateComparator implements Comparator
	{
		private int direction = 1;
		
		public CommentsDateComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public CommentsDateComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			DateTime date1 = null;
			DateTime date2 = null;
			if(ob1 instanceof AttendanceClinicalNotesVo )
			{
				AttendanceClinicalNotesVo note1 = (AttendanceClinicalNotesVo)ob1;
				date1 = note1 != null ? note1.getAuthoringInformation().getAuthoringDateTime():null;
			}
			if(ob2 instanceof AttendanceClinicalNotesVo )
			{
				AttendanceClinicalNotesVo note2 = (AttendanceClinicalNotesVo)ob2;
				date2 = note2 != null ? note2.getAuthoringInformation().getAuthoringDateTime():null;
			}
			if(date1 != null )
				return  date1.compareTo(date2)*direction;
			if(date2 != null)
				return (-1)*direction;
			
			return 0;
		}
	
	}

	@Override
	protected void onCcSeenByMedicValueChanged() throws PresentationLogicException //WDEV-17253
	{
		
	}
	//WDEV-17239
	@Override
	protected void onBtnEditClick() throws PresentationLogicException
	{
		form.getLocalContext().setselectedEvent(EDSeenByAndCompleteEvent.EDIT);
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onBtnSaveClick() throws PresentationLogicException
	{
		////WDEV-17239
		if (!validateUI())
		{
			return;
		}
		
		if (save())
		{
			open();
		}
	}

	@Override
	protected void onBtnRIEClick() throws PresentationLogicException
	{
		engine.open(form.getForms().Core.RieConfirmationDialog);
	}
}
