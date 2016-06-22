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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.22 build 41215.900)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.careplanevalutaionview;

import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.nursing.vo.CarePlanEvaluationFilterVo;
import ims.nursing.vo.CarePlanEvaluationNoteListVo;
import ims.nursing.vo.CarePlanEvaluationNoteListVoCollection;
import ims.nursing.vo.CarePlanTitle;

import java.util.ArrayList;
import java.util.List;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException 
	{
		initialise();
		listEvaluationNotes(form.chkActive().getValue());	//wdev-10789
	}
	
	private void initialise()
	{
		if(form.getGlobalContext().Nursing.getCarePlanEvaluationFilterIsNotNull())		//wdev-10789
		{
			CarePlanEvaluationFilterVo tempVo = form.getGlobalContext().Nursing.getCarePlanEvaluationFilter();
			form.dteFrom().setValue(tempVo.getFromDate());
			form.dteTo().setValue(tempVo.getToDate());
			form.chkActive().setValue(tempVo.getActiveOnly());
		}
		else
		{
			form.dteFrom().setValue(new Date().addDay(-30));
			form.dteTo().setValue(new Date());
			form.chkActive().setValue(true);
		}
	}

	private void listEvaluationNotes(boolean bActiveOnly)
	{
		form.grdNotesView().getRows().clear();
		
		if (form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
		{
			//validaion that dateFrom and dateTo are entered
			List<String> errors = new ArrayList<String>();
			
			if(form.dteFrom().getValue() == null)
				errors.add("'Date From' is mandatory");
			if(form.dteTo().getValue() == null)
				errors.add("'Date To' is mandatory");
			
			if(form.dteFrom().getValue() != null && form.dteTo().getValue() != null)
				if(form.dteFrom().getValue().isGreaterThan(form.dteTo().getValue()))
					errors.add("'Date To' cannot be before 'Date From'");
			
			if(errors.size() > 0)
			{
				engine.showErrors(errors.toArray(new String[0]));
				return;
			}
			
			CarePlanEvaluationNoteListVoCollection voCollNotes = domain.listEvaluationNotesForActiveCarePlansByDateRange(form.getGlobalContext().Core.getCurrentCareContext(), form.dteFrom().getValue(), form.dteTo().getValue(), bActiveOnly);
			if (voCollNotes != null)
			{
				//construct list of CarePlan and Notes for Grouped Display
				List<CarePlanAndEvaluationNotes> cpEvalList = getGroupedList(voCollNotes);
				if(cpEvalList == null)
					return;
				
				GenForm.grdNotesViewRow rowCP;
				GenForm.grdNotesViewRow rowEV;
				form.grdNotesView().getRows().clear();
				for (int i=0; i<cpEvalList.size(); i++)
				{
					CarePlanAndEvaluationNotes cpEval = cpEvalList.get(i);
					rowCP = form.grdNotesView().getRows().newRow();
					if(cpEval.getCarePlan() != null && cpEval.getCarePlan().getTitleIsNotNull())
					{
						String toolTip = "<b>Title: </b>"+ cpEval.getCarePlan().getTitle();
						rowCP.setColTitleDateTime(cpEval.getCarePlan().getTitle());
						rowCP.setTooltip(toolTip);
						rowCP.setExpanded(true);
						rowCP.setValue(cpEval.getCarePlan());
					}
					if(cpEval.getCollEvaluationNotes() != null)
					{
						for (int j = 0; j < cpEval.getCollEvaluationNotes().size(); j++)
						{
							//WDEV-7090 removed old code here that was filtering for 48hrs
							
							rowEV = rowCP.getRows().newRow();
							
							if(cpEval.getCollEvaluationNotes().get(j).getRecordedDateTimeIsNotNull())
								rowEV.setColTitleDateTime(cpEval.getCollEvaluationNotes().get(j).getRecordedDateTime().toString());
							
							if(cpEval.getCollEvaluationNotes().get(j).getRecordedByIsNotNull())
								rowEV.setColHCP(cpEval.getCollEvaluationNotes().get(j).getRecordedBy().toString());
							
							if (cpEval.getCollEvaluationNotes().get(j).getNoteIsNotNull())
							{
								if (cpEval.getCollEvaluationNotes().get(j).getActive().booleanValue() == false) 
								{
									String strCorrectedBy = "";
									String strCorrectedDate = "";
									String strCorrectedTime = "";
									
									if (cpEval.getCollEvaluationNotes().get(j).getCorrectedBy() != null)
										strCorrectedBy = cpEval.getCollEvaluationNotes().get(j).getCorrectedBy().toString();
									if(cpEval.getCollEvaluationNotes().get(j).getCorrectionDateTime()!=null){
										if(cpEval.getCollEvaluationNotes().get(j).getCorrectionDateTime().getDate()!=null)
											strCorrectedDate = cpEval.getCollEvaluationNotes().get(j).getCorrectionDateTime().getDate().toString();
										if(cpEval.getCollEvaluationNotes().get(j).getCorrectionDateTime().getTime()!=null)
											strCorrectedTime = cpEval.getCollEvaluationNotes().get(j).getCorrectionDateTime().getTime().toString();
									}
										
										rowEV.setColNotes(cpEval.getCollEvaluationNotes().get(j).getNote() + "\nCorrected By:" + strCorrectedBy + " on " + strCorrectedDate + " at " + strCorrectedTime + " for the following reason: " + cpEval.getCollEvaluationNotes().get(j).getCorrectionReason());
										rowEV.setSelectable(false);
									}
									else{
										rowEV.setColNotes(cpEval.getCollEvaluationNotes().get(j).getNote());
										rowEV.setTooltip(cpEval.getCollEvaluationNotes().get(j).getNote().toString());
									}
								}
							}
							
					}
				}
			}
		}
		//wdev-10789
		if(form.grdNotesView().getRows().size() < 1)
		{
			form.getGlobalContext().Nursing.setCarePlanEvaluationFilter(null);
			engine.showMessage("No records found.");
		}
		else
			refreshSearchCriteriaFilter();
		//----------
	}
	//wdev-10789
	private void refreshSearchCriteriaFilter()
	{
		CarePlanEvaluationFilterVo tempVo = new CarePlanEvaluationFilterVo();
		tempVo.setActiveOnly(form.chkActive().getValue());
		tempVo.setFromDate(form.dteFrom().getValue());
		tempVo.setToDate(form.dteTo().getValue());
		form.getGlobalContext().Nursing.setCarePlanEvaluationFilter(tempVo);
		
	}
	//-----------------------
	private List<CarePlanAndEvaluationNotes> getGroupedList(CarePlanEvaluationNoteListVoCollection voCollNotes) 
	{
		if(voCollNotes == null)
			return null;
		
		List<CarePlanAndEvaluationNotes> listCpEval = new ArrayList<CarePlanAndEvaluationNotes>();
		
		for (CarePlanEvaluationNoteListVo voCarePlanEvaluationNote : voCollNotes) 
		{
			if(listCpEval.size() == 0)
				addNewItem(voCarePlanEvaluationNote, listCpEval);
			else
			{
				//check list for existing item matching careplan and add notes to it
				boolean bFound = false;
				for (int i = 0; i < listCpEval.size(); i++) 
				{
					if(listCpEval.get(i).getCarePlan().equals(voCarePlanEvaluationNote.getCarePlan()))
					{
						listCpEval.get(i).addEvaluationNote(voCarePlanEvaluationNote);
						bFound = true;
					}
				}
				if(!bFound)
					addNewItem(voCarePlanEvaluationNote, listCpEval);
			}
		}
		return listCpEval;
	}

	private void addNewItem(CarePlanEvaluationNoteListVo voCarePlanEvaluationNote, List<CarePlanAndEvaluationNotes> listCpEval) 
	{
		if(listCpEval == null)
			throw new CodingRuntimeException("listCpEval is null in method addNewItem");
		if(voCarePlanEvaluationNote == null)
			throw new CodingRuntimeException("voCarePlanEvaluationNote is null in method addNewItem");
			
		CarePlanAndEvaluationNotes cpEval = new CarePlanAndEvaluationNotes();	
		cpEval.setCarePlan(voCarePlanEvaluationNote.getCarePlan());
		cpEval.addEvaluationNote(voCarePlanEvaluationNote);
		listCpEval.add(cpEval);
	}
	
	private class CarePlanAndEvaluationNotes
	{
		private CarePlanTitle carePlan;
		private CarePlanEvaluationNoteListVoCollection collEvaluationNotes;
		
		public CarePlanAndEvaluationNotes() 
		{	
		}

		public CarePlanTitle getCarePlan() {
			return carePlan;
		}
		public void setCarePlan(CarePlanTitle carePlan) {
			this.carePlan = carePlan;
		}
		public CarePlanEvaluationNoteListVoCollection getCollEvaluationNotes() {
			return collEvaluationNotes;
		}
		public void setCollEvaluationNotes(
				CarePlanEvaluationNoteListVoCollection collEvaluationNotes) {
			this.collEvaluationNotes = collEvaluationNotes;
		}
		
		public void addEvaluationNote(CarePlanEvaluationNoteListVo value) 
		{
			if(this.collEvaluationNotes == null)
				this.collEvaluationNotes = new CarePlanEvaluationNoteListVoCollection();
			
			this.collEvaluationNotes.add(value);
		}
	}

	@Override
	protected void onBtnSearchClick() throws PresentationLogicException
	{
		listEvaluationNotes(form.chkActive().getValue());
		//wdev-12473
		//if(form.grdNotesView().getRows().size() < 1)
		//	engine.showMessage("No records found.");
		//----------
	}

	@Override
	protected void onChkActiveValueChanged() throws PresentationLogicException {
		listEvaluationNotes(form.chkActive().getValue());
		
	}
}
