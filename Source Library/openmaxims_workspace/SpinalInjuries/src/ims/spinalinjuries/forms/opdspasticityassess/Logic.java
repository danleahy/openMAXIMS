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
// This code was generated by Billy Mahon using IMS Development Environment (version 1.36 build 2111.26314)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.
// 23/11/2005 AU - WDEV-42 and related fixes

package ims.spinalinjuries.forms.opdspasticityassess;

import java.util.ArrayList;

import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.generalmedical.vo.OPDSpasticityAssessTreatGoalVo;
import ims.generalmedical.vo.OPDSpasticityAssessTreatVo;
import ims.generalmedical.vo.OPDSpasticityAssessTreatGoalVoCollection;
import ims.generalmedical.vo.OPDSpasAssLimbsVo;
import ims.generalmedical.vo.OPDSpasAssLimbsVoCollection;
import ims.generalmedical.vo.OPDSpasticityAssessTreatVoCollection;
import ims.spinalinjuries.forms.opdspasticityassess.GenForm.cntDetailsContainer;
import ims.domain.exceptions.StaleObjectException;
import ims.spinalinjuries.vo.lookups.LookupHelper;
import ims.core.vo.CareContextLiteVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.CareContextShortVoCollection;
import ims.core.vo.MskGroupVoCollection;
import ims.core.vo.MskJointVoCollection;
import ims.core.vo.MskJointVo;
import ims.core.vo.PatientShort;
import ims.spinalinjuries.vo.lookups.MSKGroupType;
import ims.spinalinjuries.vo.lookups.MskJointsMovements;
import ims.spinalinjuries.vo.lookups.SATreatmentGoal;
import ims.spinalinjuries.vo.lookups.SATreatmentGoalCollection;
import ims.spinalinjuries.vo.lookups.SATreatmentPlan;
import ims.spinalinjuries.vo.lookups.SATreatmentPlanCollection;
import ims.spinalinjuries.vo.lookups.SABotulinm;
import ims.spinalinjuries.vo.lookups.SABotulinmCollection;
import ims.framework.enumerations.SortOrder;

public class Logic extends BaseLogic
{
	protected void onFormOpen() 
	{
		initialize();
		open();
	}
	private void initialize(){
		form.setMode(FormMode.VIEW);

		PatientShort voPatShort = form.getGlobalContext().Core.getPatientShort();
		if (voPatShort == null)
			try {
				throw new FormOpenException("Error: Patient not selected.");
			} catch (FormOpenException e) {
				e.printStackTrace();
			}
		
		CareContextShortVo currentCareContext = form.getGlobalContext().Core.getCurrentCareContext();
		form.getLocalContext().setSelectedCareContextShort(currentCareContext);
			
		if(currentCareContext!=null)
			form.getLocalContext().setCurrentCareContextId(currentCareContext.getID_CareContext());
		
		loadLookupsIntoGrid();
		
	}
	
	protected void open()
	{
		clearScreen();
		form.setMode(FormMode.VIEW);
				
		fillRecordBrowser();
		
		if(form.getLocalContext().getSelectedCareContextShortIsNotNull()){
			form.recbrSpacticityAssess().setValue(form.getLocalContext().getSelectedCareContextShort());
		
		}
		else{
			form.btnNew().setVisible(false);
			form.btnUpdate().setVisible(false);
		}
		
		if(form.recbrSpacticityAssess().size()>0){
			try {
				onRecbrSpacticityAssessValueChanged();
			} catch (PresentationLogicException e) {
				engine.showMessage("Failed to display selected record.");
			}
		}
		
	}
	private void fillRecordBrowser()
	{
		Integer currentCareContextId = form.getLocalContext().getCurrentCareContextId();
		
		form.recbrSpacticityAssess().clear();
		CareContextShortVoCollection collCareContextShort = domain.listOPDCareContextsByEpisodeOfCare(form.getGlobalContext().Core.getEpisodeofCareShort());
		
		collCareContextShort = addCurrentContextToCollection(currentCareContextId, collCareContextShort);
		for(int i=0; i<collCareContextShort.size(); i++){
			CareContextShortVo voCareContextShort =  collCareContextShort.get(i); 
			if(voCareContextShort.getID_CareContext().equals(currentCareContextId)){
				form.recbrSpacticityAssess().newRow(voCareContextShort, voCareContextShort.getRecordBrowserText(), Color.Green);
			}
			else
				form.recbrSpacticityAssess().newRow(voCareContextShort, voCareContextShort.getRecordBrowserText());
		}
	}

	private CareContextShortVoCollection addCurrentContextToCollection(Integer currentCareContextId, CareContextShortVoCollection collCareContextShort) {
		boolean bRecordExistsForCurrent = false;
		for(int i=0; i<collCareContextShort.size(); i++){
			CareContextShortVo voCareContextShort =  collCareContextShort.get(i); 
			if(voCareContextShort.getID_CareContext().equals(currentCareContextId)){
				bRecordExistsForCurrent = true;
			}
		}
		
		if(!bRecordExistsForCurrent){
			collCareContextShort.add(form.getGlobalContext().Core.getCurrentCareContext());
			collCareContextShort.sort(SortOrder.DESCENDING);
		}
		
		return collCareContextShort;		
	}
	private void browseRecord()
	{
		updateBrowseInformation();
		if(form.recbrSpacticityAssess().getValue() != null)
		{			
			CareContextShortVo voCareContextShort = (CareContextShortVo)form.recbrSpacticityAssess().getValue();
			
			OPDSpasticityAssessTreatVoCollection coll = domain.getAssessTreatByCareContext((CareContextLiteVo) form.recbrSpacticityAssess().getValue());
			OPDSpasticityAssessTreatVo voOpdSpastAssessTreat = null;
			if(coll!=null && coll.size()>0)
				voOpdSpastAssessTreat  = coll.get(0);
			form.getLocalContext().setSelectedCareContextShort(voCareContextShort);
			form.getLocalContext().setvoOpdSpastAssessTreat(voOpdSpastAssessTreat);

			populateScreenFromData();
			checkRecordIsEditable(voOpdSpastAssessTreat, voCareContextShort);
		}
		
	}
	
	private void checkRecordIsEditable(OPDSpasticityAssessTreatVo voOpdSpastAssessTreat, CareContextShortVo voCareContextShort)
	{
		Integer currentCareContextId = form.getLocalContext().getCurrentCareContextId();
		
		if(voOpdSpastAssessTreat!=null){
			form.btnNew().setVisible(false);
			
			if(voCareContextShort.getID_CareContext().equals(currentCareContextId))
				form.btnUpdate().setVisible(true);
			else
				form.btnUpdate().setVisible(false);
		}
		else{
			
			form.getLocalContext().setvoOpdSpastAssessTreat(null);
						
			if(voCareContextShort.getID_CareContext().equals(currentCareContextId))
				form.btnNew().setVisible(true);
			else
				form.btnNew().setVisible(false);
			
			form.btnUpdate().setVisible(false);
		}
	}
	
	private void updateBrowseInformation()
	{
		form.lblBrowser().setValue(form.recbrSpacticityAssess().getRecordState("Assessment", "Assessments"));
	}
	private void populateScreenFromData() 
	{
		clearScreen();
		if (form.getLocalContext().getSelectedCareContextShortIsNotNull())
		{
			OPDSpasticityAssessTreatVo voOpdSATreat = form.getLocalContext().getvoOpdSpastAssessTreat();
			
			if(form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
			{
			
				if (voOpdSATreat != null)
				{
					if (voOpdSATreat.getCareContextIsNotNull())
					{
						if(voOpdSATreat.getAuthoringInformationIsNotNull())
							form.customControlAuthoringInfo().setValue(voOpdSATreat.getAuthoringInformation());
						
						//Limbs
						loadAndPopulateAssessmentGrid(voOpdSATreat.getLimbFinding());
														
						//Joint Contracture
						if (voOpdSATreat.getJointContractureIsNotNull())
							form.cntDetails().txtJointContractures().setValue(voOpdSATreat.getJointContracture());
						
						//Treatment Goal
						if (form.cntDetails().grdTreatGoals().getRows().size()>0)
						{
							if (voOpdSATreat.getTreatGoalsIsNotNull())
							{
								for(int i=0;i<voOpdSATreat.getTreatGoals().size();i++)
								{		
									for(int j=0;j<form.cntDetails().grdTreatGoals().getRows().size();j++)
									{								
										if (voOpdSATreat.getTreatGoals().get(i).getTreatGoal().equals(form.cntDetails().grdTreatGoals().getRows().get(j).getcolGoal()))
										{
											if (voOpdSATreat.getTreatGoals().get(i).getOPDTreatGoalStatusIsNotNull())
												form.cntDetails().grdTreatGoals().getRows().get(j).setcolStatus(voOpdSATreat.getTreatGoals().get(i).getOPDTreatGoalStatus());
											form.cntDetails().grdTreatGoals().getRows().get(j).setValue(voOpdSATreat.getTreatGoals().get(i));
										}
									}								
								}
							}
						}
						
						//Treatment Plan
						if (voOpdSATreat.getTreatmentPlanIsNotNull())
						{
							for(int i=0;i<voOpdSATreat.getTreatmentPlan().size();i++)
							{
								if (form.cntDetails().grdTreatPlan().getRowByValue(voOpdSATreat.getTreatmentPlan().get(i)) != null)
									form.cntDetails().grdTreatPlan().getRowByValue(voOpdSATreat.getTreatmentPlan().get(i)).setcolSelect(true);
							}
						}
						//Botulusim
						if (voOpdSATreat.getBotulismTreatmentIsNotNull())
						{
							for(int i=0;i<voOpdSATreat.getBotulismTreatment().size();i++)
							{
								if (form.cntDetails().grdBotulinm().getRowByValue(voOpdSATreat.getBotulismTreatment().get(i)) != null)
									form.cntDetails().grdBotulinm().getRowByValue(voOpdSATreat.getBotulismTreatment().get(i)).setcolSelect(true);
							}
						}				
					}
				}
				
			}				
		}	
	}	
	private void loadAndPopulateAssessmentGrid(OPDSpasAssLimbsVoCollection limbFinding) {
		//load joint movements
		form.cntDetails().grdAssessment().getRows().clear();
		MskGroupVoCollection voCollMskGroup = form.getLocalContext().getCollMskGroupVo();
		if(form.getMode().equals(FormMode.VIEW)){
			if (voCollMskGroup != null)
			{
				if (voCollMskGroup.size()>0)
				{
					for(int i=0;i<voCollMskGroup.size();i++)
					{
						if (voCollMskGroup.get(i).getJointsIsNotNull() 
								&&  voCollMskGroup.get(i).getGroupTypeIsNotNull() //Wdev-1831 
								&& !voCollMskGroup.get(i).getGroupType().equals(MSKGroupType.DIGIT)) //Wdev-1831
						{
							MskJointVoCollection voCollJoints = voCollMskGroup.get(i).getJoints();
							MskJointVo voMskJoint;
							for(int j=0;j<voCollJoints.size();j++)
							{
								voMskJoint = voCollJoints.get(j);
								if (voMskJoint.getMovementsIsNotNull())
								{
									if (voMskJoint.getMovements().size()>0)
									{
										//if at least one child instantiated add joint as parent
										if(childInstantiated(voMskJoint, limbFinding)){
											GenForm.cntDetailsContainer.grdAssessmentRow row = form.cntDetails().grdAssessment().getRows().newRow();
											row.setColLimbs(voMskJoint.getName());
											row.setObjectId(voMskJoint.getID_MskJoints());
											row.setValue((MskJointVo)voMskJoint);
											row.setReadOnly(true);
											row.setBackColor(Color.AliceBlue);
											row.setColActiveLeft(null);
											row.setColActiveRight(null);
											row.setColPassiveLeft(null);
											row.setColPassiveRight(null);
											row.setColToneLeft(null);
											row.setColToneRight(null);
											row.setColLimbsReadOnly(true);
											MskJointsMovements voJointMovment;
											for(int k=0;k<voMskJoint.getMovements().size();k++)
											{
												voJointMovment = voMskJoint.getMovements().get(k);
												
												for(int l=0;l<limbFinding.size();l++)
												{
													OPDSpasAssLimbsVo voLimb = limbFinding.get(l);
													if (voJointMovment.getId() == voLimb.getMovement().getId() && voMskJoint.equals(voLimb.getJoint()))
													{								
														//add movments as children
														GenForm.cntDetailsContainer.grdAssessmentRow childrow = row.getRows().newRow();
														childrow.setColLimbs(voJointMovment.getText());
														childrow.setColActiveLeft(voLimb.getActiveRomLeft());
														childrow.setColActiveRight(voLimb.getActiveRomRight());
														childrow.setColPassiveLeft(voLimb.getPassiveRomLeft());
														childrow.setColPassiveRight(voLimb.getPassiveRomRight());
														childrow.setColToneLeft(voLimb.getToneLeft());
														childrow.setColToneRight(voLimb.getToneRight());
														childrow.setValue(voJointMovment);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		else{
			loadAssessmentGrid(form.getLocalContext().getCollMskGroupVo());
			populateAssessmentGrid(limbFinding);
		}
		
		form.cntDetails().grdAssessment().expandAll();
		
	}
	private boolean childInstantiated(MskJointVo voMskJoint, OPDSpasAssLimbsVoCollection limbFinding) {
		
		for(int l=0;l<limbFinding.size();l++)
		{
			OPDSpasAssLimbsVo voLimb = limbFinding.get(l);
			if (voLimb.getJoint().equals(voMskJoint))
			{								
				return true;
			}
		}
		return false;
	}
	private void populateAssessmentGrid(OPDSpasAssLimbsVoCollection limbFinding) {
		OPDSpasAssLimbsVo voLimb;
		for(int l=0;l<limbFinding.size();l++)
		{
			voLimb = limbFinding.get(l);
			GenForm.cntDetailsContainer.grdAssessmentRow row;
			GenForm.cntDetailsContainer.grdAssessmentRow rowchild;
			//find in tree by joint and movement							
			for (int k=0;k<form.cntDetails().grdAssessment().getRows().size();k++)
			{
				row = form.cntDetails().grdAssessment().getRows().get(k);
				if (voLimb.getJointIsNotNull())
				{
					if (row.getObjectId().intValue() == voLimb.getJoint().getID_MskJoints().intValue())
					{									
						//this is the joint, mark movments
						for(int m=0;m<row.getRows().size();m++)
						{
							rowchild = row.getRows().get(m);
							if (rowchild.getValue().equals(voLimb.getMovement()))
							{
								if (voLimb.getActiveRomLeftIsNotNull())
									rowchild.setColActiveLeft(voLimb.getActiveRomLeft());
								if (voLimb.getActiveRomRightIsNotNull())
									rowchild.setColActiveRight(voLimb.getActiveRomRight());
								if (voLimb.getPassiveRomLeftIsNotNull())
									rowchild.setColPassiveLeft(voLimb.getPassiveRomLeft());
								if (voLimb.getPassiveRomRightIsNotNull())
									rowchild.setColPassiveRight(voLimb.getPassiveRomRight());
								if (voLimb.getToneLeftIsNotNull())
									rowchild.setColToneLeft(voLimb.getToneLeft());
								if (voLimb.getToneRightIsNotNull())
									rowchild.setColToneRight(voLimb.getToneRight());											
							}
						}
					}
				}
			}
				
		}
			
	}
	private void loadAssessmentGrid(MskGroupVoCollection voCollMskGroup) {
		if (voCollMskGroup != null)
		{
			if (voCollMskGroup.size()>0)
			{
				for(int i=0;i<voCollMskGroup.size();i++)
				{
					if (voCollMskGroup.get(i).getJointsIsNotNull() 
							&&  voCollMskGroup.get(i).getGroupTypeIsNotNull() //Wdev-1831 
							&& !voCollMskGroup.get(i).getGroupType().equals(MSKGroupType.DIGIT)) //Wdev-1831
					{
						MskJointVoCollection voCollJoints = voCollMskGroup.get(i).getJoints();
						MskJointVo voMskJoint;
						for(int j=0;j<voCollJoints.size();j++)
						{
							voMskJoint = voCollJoints.get(j);
							if (voMskJoint.getMovementsIsNotNull())
							{
								if (voMskJoint.getMovements().size()>0)
								{
									//add joint as parent
									GenForm.cntDetailsContainer.grdAssessmentRow row = form.cntDetails().grdAssessment().getRows().newRow();
									row.setColLimbs(voMskJoint.getName());
									row.setObjectId(voMskJoint.getID_MskJoints());
									row.setValue((MskJointVo)voMskJoint);
									row.setReadOnly(true);
									row.setBackColor(Color.AliceBlue);
									row.setColActiveLeft(null);
									row.setColActiveRight(null);
									row.setColPassiveLeft(null);
									row.setColPassiveRight(null);
									row.setColToneLeft(null);
									row.setColToneRight(null);
									row.setColLimbsReadOnly(true);
									MskJointsMovements voJointMovment;
									for(int k=0;k<voMskJoint.getMovements().size();k++)
									{
										voJointMovment = voMskJoint.getMovements().get(k);
										//add movments as children
										GenForm.cntDetailsContainer.grdAssessmentRow childrow = row.getRows().newRow();
										childrow.setColLimbs(voJointMovment.getText());
										childrow.setReadOnly(false);
										childrow.setValue(voJointMovment);
										childrow.setColActiveLeft(null);
										childrow.setColActiveRight(null);
										childrow.setColPassiveLeft(null);
										childrow.setColPassiveRight(null);
										childrow.setColToneLeft(null);
										childrow.setColToneRight(null);
										childrow.setColLimbsReadOnly(true);										
									}
								}
							}
						}
					}
				}
			}
		}
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{

		OPDSpasticityAssessTreatVo voOpdSATreat = form.getLocalContext().getvoOpdSpastAssessTreat();
		
		if (voOpdSATreat == null)
		{
			voOpdSATreat = new OPDSpasticityAssessTreatVo();
		}
		if(voOpdSATreat.getCareContext() == null)
			voOpdSATreat.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		
		if(voOpdSATreat.getCareContext() == null)
			voOpdSATreat.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		if(voOpdSATreat.getAuthoringInformation()==null)
			voOpdSATreat.setAuthoringInformation(form.customControlAuthoringInfo().getValue());
	
		if (voOpdSATreat.getLimbFindingIsNotNull())
			voOpdSATreat.getLimbFinding().clear();
		
		//Limbs
		if (form.cntDetails().grdAssessment().getRows().size()>0)
		{
			//scan for selected joint movements
			OPDSpasAssLimbsVoCollection voCollLimbFindings = new OPDSpasAssLimbsVoCollection();
			GenForm.cntDetailsContainer.grdAssessmentRow row;
			GenForm.cntDetailsContainer.grdAssessmentRow rowchild;
			for(int i=0;i<form.cntDetails().grdAssessment().getRows().size();i++)
			{
				row = form.cntDetails().grdAssessment().getRows().get(i);
				if (row.getRows().size()>0)
				{
					for(int j=0;j<row.getRows().size();j++)
					{
						//make a list for this joint
						rowchild = row.getRows().get(j);	
						//save only instantiated rows
						if(rowchild.getColActiveLeft()!=null || rowchild.getColActiveRight()!=null ||rowchild.getColPassiveLeft()!=null ||
								rowchild.getColPassiveRight()!=null ||rowchild.getColToneLeft()!=null ||rowchild.getColToneRight()!=null ){
							OPDSpasAssLimbsVo voLimbsVo = new OPDSpasAssLimbsVo();
							if (row.getValue() instanceof MskJointVo)
								voLimbsVo.setJoint((MskJointVo)row.getValue());
							if (rowchild.getValue() instanceof MskJointsMovements)
								voLimbsVo.setMovement((MskJointsMovements)rowchild.getValue());
							voLimbsVo.setActiveRomLeft(rowchild.getColActiveLeft());
							voLimbsVo.setActiveRomRight(rowchild.getColActiveRight());
							voLimbsVo.setPassiveRomLeft(rowchild.getColPassiveLeft());
							voLimbsVo.setPassiveRomRight(rowchild.getColPassiveRight());
							voLimbsVo.setToneLeft(rowchild.getColToneLeft());
							voLimbsVo.setToneRight(rowchild.getColToneRight());
							voCollLimbFindings.add(voLimbsVo);
						}
					}
				}
			}
			voOpdSATreat.setLimbFinding(voCollLimbFindings);
		}		
		
		//joint contractures
		voOpdSATreat.setJointContracture(form.cntDetails().txtJointContractures().getValue());
		
		//Treatment Goal
		if (form.cntDetails().grdTreatGoals().getRows().size()>0)
		{
			OPDSpasticityAssessTreatGoalVoCollection voCollGoals = new OPDSpasticityAssessTreatGoalVoCollection();
			OPDSpasticityAssessTreatGoalVo voGoal = null;
			GenForm.cntDetailsContainer.grdTreatGoalsRow gRow = null;
			for(int i=0;i<form.cntDetails().grdTreatGoals().getRows().size();i++)
			{
				gRow = form.cntDetails().grdTreatGoals().getRows().get(i);
				if(gRow.getcolStatus() != null)
				{
					voGoal = gRow.getValue();
					if(voGoal == null)
						voGoal = new OPDSpasticityAssessTreatGoalVo();
					
					voGoal.setOPDTreatGoalStatus(gRow.getcolStatus());
					voGoal.setTreatGoal(gRow.getcolGoal());
					
					
					voCollGoals.add(voGoal);
				}
			}
			voOpdSATreat.setTreatGoals(voCollGoals);
		}
		
		//Treatment Plan - //23/11/2005 - WDEV-42 related
		SATreatmentPlanCollection voCollTreatPlan = new SATreatmentPlanCollection();
		for(int j=0;j<form.cntDetails().grdTreatPlan().getRows().size();j++)
		{								
			if (form.cntDetails().grdTreatPlan().getRows().get(j).getcolSelect())
			{
				voCollTreatPlan.add(form.cntDetails().grdTreatPlan().getRows().get(j).getValue());
			}
		}
		voOpdSATreat.setTreatmentPlan(voCollTreatPlan);			
		
		//Botulusim	//23/11/2005 - WDEV-42 
		SABotulinmCollection voCollBot = new SABotulinmCollection();
		for(int j=0;j<form.cntDetails().grdBotulinm().getRows().size();j++)
		{								
			if (form.cntDetails().grdBotulinm().getRows().get(j).getcolSelect())
			{
				voCollBot.add(form.cntDetails().grdBotulinm().getRows().get(j).getValue());
			}
		}
		voOpdSATreat.setBotulismTreatment(voCollBot);	
		
		ArrayList screenErrors = new ArrayList();
		
		if(form.customControlAuthoringInfo().getValue() == null || form.customControlAuthoringInfo().getValue().getAuthoringHcp() == null) //wdev-11023
		{
			screenErrors.add("Authoring HCP is mandatory.");				
		}
		if(form.customControlAuthoringInfo().getValue() == null || form.customControlAuthoringInfo().getValue().getAuthoringDateTime() == null) //wdev-11023
		{
			screenErrors.add("Authoring Date/Time is mandatory.");				
		}
		
		String[] errors = voOpdSATreat.validate();
		String[] arrScreenAndVoErrors = addScreenErrorsToVOErrors(screenErrors, errors);
				
		//save
		try
		{
			if (arrScreenAndVoErrors.length != 0)
			{
				engine.showErrors("Validation Errors", arrScreenAndVoErrors);
				return;
			}
			voOpdSATreat = domain.saveAssessTreat(voOpdSATreat);
			form.getLocalContext().setvoOpdSpastAssessTreat(voOpdSATreat);
			open();
		}
		catch(StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return;				
		}				
	}	
	private String[] addScreenErrorsToVOErrors(ArrayList screenErrors, String[] arrErrors) {
		String[] arrAllErrors = null;
		
		if(arrErrors != null)
		{
			arrAllErrors = new String[screenErrors.size() + arrErrors.length];
			for(int i=0;i<screenErrors.size();i++)
				arrAllErrors[i] = (String)screenErrors.get(i);
			
			int i=0;	
			for(int p=screenErrors.size();p<arrAllErrors.length;p++)
			{
				arrAllErrors[p] = arrErrors[i];
				i++;
			}
		}	
		else
		{
			arrAllErrors = new String[screenErrors.size()];		
			
			for(int i=0;i<screenErrors.size();i++)
				arrAllErrors[i] = (String)screenErrors.get(i);	
		}	
		
		return arrAllErrors;
	}
	protected void clearScreen()
	{
		form.customControlAuthoringInfo().setValue(null);
		form.cntDetails().txtJointContractures().setValue("");
		
		form.cntDetails().grdAssessment().getRows().clear();
				
		for(int j=0;j<form.cntDetails().grdTreatGoals().getRows().size();j++)
		{								
			form.cntDetails().grdTreatGoals().getRows().get(j).setcolStatus(null);
		}
		for(int j=0;j<form.cntDetails().grdTreatPlan().getRows().size();j++)
		{								
			form.cntDetails().grdTreatPlan().getRows().get(j).setcolSelect(false);
		}
		for(int j=0;j<form.cntDetails().grdBotulinm().getRows().size();j++)
		{								
			form.cntDetails().grdBotulinm().getRows().get(j).setcolSelect(false);
		}	
	}
	protected void loadLookupsIntoGrid()
	{
		//load joint movements
		form.cntDetails().grdAssessment().getRows().clear();
		form.getLocalContext().setCollMskGroupVo(domain.listMskGroup(new Boolean(true)));
		
		form.cntDetails().grdTreatGoals().getRows().clear();
		cntDetailsContainer.grdTreatGoalsRow rowTreatGoals = null;
		SATreatmentGoalCollection sCollTeatGoal = LookupHelper.getSATreatmentGoal(domain.getLookupService());
		SATreatmentGoal voTreaGoal;
		for (int i = 0; i < sCollTeatGoal.size(); i++)
		{
			voTreaGoal = sCollTeatGoal.get(i);
			rowTreatGoals = form.cntDetails().grdTreatGoals().getRows().newRow();
			rowTreatGoals.setcolGoal(voTreaGoal);
		}

		form.cntDetails().grdTreatPlan().getRows().clear();
		cntDetailsContainer.grdTreatPlanRow rowTreatPlans = null;
		SATreatmentPlanCollection sCollTeatPlan = LookupHelper.getSATreatmentPlan(domain.getLookupService());
		SATreatmentPlan voTreaPlan;
		for (int i = 0; i < sCollTeatPlan.size(); i++)
		{
			voTreaPlan = sCollTeatPlan.get(i);
			rowTreatPlans = form.cntDetails().grdTreatPlan().getRows().newRow();
			rowTreatPlans.setcolPlan(voTreaPlan.getText());
			rowTreatPlans.setValue(voTreaPlan);
		}
		
		form.cntDetails().grdBotulinm().getRows().clear();
		cntDetailsContainer.grdBotulinmRow rowBot = null;
		SABotulinmCollection sCollBot = LookupHelper.getSABotulinm(domain.getLookupService());
		SABotulinm voBot;
		for (int i = 0; i < sCollBot.size(); i++)
		{
			voBot = sCollBot.get(i);
			rowBot = form.cntDetails().grdBotulinm().getRows().newRow();
			rowBot.setcolBotulism(voBot.getText());
			rowBot.setValue(voBot);
		}
	}
	protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();		
	}
	protected void onBUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		form.setcustomControlAuthoringInfoEnabled(false);
		loadAndPopulateAssessmentGrid(form.getLocalContext().getvoOpdSpastAssessTreat().getLimbFindingIsNotNull() ? form.getLocalContext().getvoOpdSpastAssessTreat().getLimbFinding() : null);
	}

	protected void onRecbrSpacticityAssessValueChanged() throws PresentationLogicException
	{
		browseRecord();	
	}
	protected void onBtnNewClick() throws PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		form.setcustomControlAuthoringInfoEnabled(true);
		form.customControlAuthoringInfo().setIsRequiredPropertyToControls(true);
		clearScreen();
		loadLookupsIntoGrid();
		setDefaultValues();
		form.getLocalContext().setvoOpdSpastAssessTreat(null);
		form.getLocalContext().setvoOpdSpastAssessTreatColl(null);
		loadAssessmentGrid(form.getLocalContext().getCollMskGroupVo());
		form.cntDetails().grdAssessment().expandAll();
	}

	private void setDefaultValues() 
	{
		form.customControlAuthoringInfo().initializeComponent();
	}
	
	protected void onFormModeChanged() 
	{
		//wdev-1831
		if (form.getMode().equals(FormMode.VIEW))
			form.cntDetails().grdAssessment().expandAll();
		
	}
}
