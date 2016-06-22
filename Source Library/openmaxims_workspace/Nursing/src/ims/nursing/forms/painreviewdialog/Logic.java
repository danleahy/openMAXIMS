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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.20 build 40812.900)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.painreviewdialog;

import ims.core.vo.MemberOfStaffShortVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;
import ims.nursing.vo.PainAssessment;
import ims.nursing.vo.PainAssessmentFindings;
import ims.nursing.vo.PainAssessmentReview;
import ims.nursing.vo.lookups.PainSeverity;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		form.setMode(FormMode.EDIT);
		form.txtBoxSiteDetails().setFocus();
		
		if(form.getGlobalContext().COE.PainBodyChart.getReviewPage() != null && 
		   form.getGlobalContext().COE.PainBodyChart.getReviewPage().booleanValue())
			populateReviewData();
		else
		{
			form.chkDiscontinueAssessment().setVisible(false);
			form.labelDiscontinue().setVisible(false);
			populateFindingData();
		}
	}
	protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearGlobalContext();
		engine.close(DialogResult.CANCEL);
	}
	protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(getDataFromControls())
		{
			clearGlobalContext();
			engine.close(DialogResult.OK);
		}
	}
	private void populateFindingData()
	{
		PainAssessmentFindings painAssFindingVO = form.getGlobalContext().COE.PainBodyChart.getAssessmentFinding();
		if(painAssFindingVO != null)
		{
			populateControlsFromVO(painAssFindingVO, null);
		}	
	}
	
	private void populateReviewData()
	{
		PainAssessmentFindings painAssFindingVO = form.getGlobalContext().COE.PainBodyChart.getAssessmentFinding();
		PainAssessmentReview   painAssReviewVO 	= form.getGlobalContext().COE.PainBodyChart.getPainAssReviewVO();
		if(painAssFindingVO != null && painAssReviewVO != null)
		{
			populateControlsFromVO(painAssFindingVO, painAssReviewVO);
		}
	}
	
	private void populateControlsFromVO(PainAssessmentFindings findingVO, PainAssessmentReview painAssRevVO)
	{
		if(findingVO == null)
			return;
		
		if(painAssRevVO == null)
		{
			//Date, Time & HCP
			if(form.getGlobalContext().COE.PainBodyChart.getPainAssessmentVO() != null)
			{
				if(form.getGlobalContext().COE.PainBodyChart.getPainAssessmentVO().getDateTimeInitiated() != null)
				{
					form.dteRecordingDate().setValue(form.getGlobalContext().COE.PainBodyChart.getPainAssessmentVO().getDateTimeInitiated().getDate());
					form.timRecordingTime().setValue(form.getGlobalContext().COE.PainBodyChart.getPainAssessmentVO().getDateTimeInitiated().getTime());
				}
				
				if(form.getGlobalContext().COE.PainBodyChart.getPainAssessmentVO().getAssessmentDateTime() != null)
				{
					form.dteAssessmentDate().setValue(form.getGlobalContext().COE.PainBodyChart.getPainAssessmentVO().getAssessmentDateTime().getDate());
					form.timAssessmentTime().setValue(form.getGlobalContext().COE.PainBodyChart.getPainAssessmentVO().getAssessmentDateTime().getTime());
				}
				
				if(form.getGlobalContext().COE.PainBodyChart.getPainAssessmentVO().getHcpInitiated() != null)
					form.txtHcp().setValue(form.getGlobalContext().COE.PainBodyChart.getPainAssessmentVO().getHcpInitiated().toString());
			}
			
			if(findingVO.getPainHypersensitivity() != null)
				form.txtFinding().setValue(findingVO.getPainHypersensitivity().getText());
			form.txtBoxSite().setValue(findingVO.getSiteName());
			form.txtBoxSiteDetails().setValue(findingVO.getSiteDetails());
			if(findingVO.getType() != null)
				form.cmbType().setValue(findingVO.getType());
			if(findingVO.getSeverity() != null)
			{	
				form.txtSeverity().setValue(findingVO.getSeverity().toString());
				form.getLocalContext().setSeverity(findingVO.getSeverity());
			}
			if(findingVO.getOnset() != null)
				form.cmbOnset().setValue(findingVO.getOnset());
			if(findingVO.getProgression() != null)
				form.cmbProgression().setValue(findingVO.getProgression());
			if(findingVO.getDepth() != null)
				form.cmbDepth().setValue(findingVO.getDepth());
			if(findingVO.getIsDiscontinuedAssess() != null)
				form.chkDiscontinueAssessment().setValue(findingVO.getIsDiscontinuedAssess().booleanValue());
		}
		else
		{
			//Date/Time
			if(painAssRevVO.getRecordingDateTime() != null)
			{
				form.dteRecordingDate().setValue(painAssRevVO.getRecordingDateTime().getDate());
				form.timRecordingTime().setValue(painAssRevVO.getRecordingDateTime().getTime());
			}
			else
			{
				form.dteRecordingDate().setValue(new Date());
				form.timRecordingTime().setValue(new Time());
			}
			
			if(painAssRevVO.getAssessmentDateTime() != null)
			{
				form.dteAssessmentDate().setValue(painAssRevVO.getAssessmentDateTime().getDate());
				form.timAssessmentTime().setValue(painAssRevVO.getAssessmentDateTime().getTime());
			}
			else
			{
				form.dteAssessmentDate().setValue(new Date());
				form.timAssessmentTime().setValue(new Time());
			}
			
			//HCP
			if(painAssRevVO.getRecordingHCP() != null)
				form.txtHcp().setValue(painAssRevVO.getRecordingHCP().toString());
			if(findingVO.getPainHypersensitivity() != null)
				form.txtFinding().setValue(findingVO.getPainHypersensitivity().getText());
			form.txtBoxSite().setValue(findingVO.getSiteName());
			form.txtBoxSiteDetails().setValue(painAssRevVO.getSiteDetails());
			if(painAssRevVO.getType() != null)
				form.cmbType().setValue(painAssRevVO.getType());
			if(painAssRevVO.getSeverity() != null)
			{
				form.txtSeverity().setValue(painAssRevVO.getSeverity().toString());
				form.getLocalContext().setSeverity(painAssRevVO.getSeverity());
			}
			if(painAssRevVO.getOnset() != null)
				form.cmbOnset().setValue(painAssRevVO.getOnset());
			if(painAssRevVO.getProgression() != null)
				form.cmbProgression().setValue(painAssRevVO.getProgression());
			if(painAssRevVO.getDepth() != null)
				form.cmbDepth().setValue(painAssRevVO.getDepth());
			if(findingVO.getIsDiscontinuedAssess() != null)
				form.chkDiscontinueAssessment().setValue(findingVO.getIsDiscontinuedAssess().booleanValue());
		}
	}
	
	private boolean getDataFromControls()
	{
		if(form.getGlobalContext().COE.PainBodyChart.getReviewPage() != null && form.getGlobalContext().COE.PainBodyChart.getReviewPage().booleanValue())
			return getReviewDataFromControls();
		else
			return getFindingDataFromControls();
	}
	
	private boolean getFindingDataFromControls()
	{
		return getPainDetails(form.getGlobalContext().COE.PainBodyChart.getAssessmentFinding(), null);
	}
	
	private boolean getReviewDataFromControls()
	{
		return getPainDetails(form.getGlobalContext().COE.PainBodyChart.getAssessmentFinding(), form.getGlobalContext().COE.PainBodyChart.getPainAssReviewVO());
	}
	
	private boolean getPainDetails(PainAssessmentFindings painDetailsVO, PainAssessmentReview painReviewDetailsVO)
	{
		if(painDetailsVO == null)
			return false;
		if(painReviewDetailsVO == null)
		{
			if(!checkAssessmentDate())
				return false;
			
			PainAssessment painAssVO = form.getGlobalContext().COE.PainBodyChart.getPainAssessmentVO();
			if(painAssVO != null)
				painAssVO.setAssessmentDateTime(new DateTime(form.dteAssessmentDate().getValue(), form.timAssessmentTime().getValue()));
			form.getGlobalContext().COE.PainBodyChart.setPainAssessmentVO(painAssVO);
			
			painDetailsVO.setSiteDetails(form.txtBoxSiteDetails().getValue());
			painDetailsVO.setType(form.cmbType().getValue());
			painDetailsVO.setSeverity(form.getLocalContext().getSeverity());
			painDetailsVO.setOnset(form.cmbOnset().getValue());
			painDetailsVO.setProgression(form.cmbProgression().getValue());
			painDetailsVO.setDepth(form.cmbDepth().getValue());
			painDetailsVO.setIsDiscontinuedAssess(new Boolean(form.chkDiscontinueAssessment().getValue()));
			
			//Set the Findings value back to the context
			form.getGlobalContext().COE.PainBodyChart.setAssessmentFinding(painDetailsVO);
		}
		else
		{
			if(!checkAssessmentDate())
				return false;
			painReviewDetailsVO.setRecordingDateTime(new DateTime(form.dteRecordingDate().getValue(), form.timRecordingTime().getValue()));
			painReviewDetailsVO.setAssessmentDateTime(new DateTime(form.dteAssessmentDate().getValue(), form.timAssessmentTime().getValue()));
			
			painReviewDetailsVO.setSiteDetails(form.txtBoxSiteDetails().getValue());
			painReviewDetailsVO.setType(form.cmbType().getValue());
			painReviewDetailsVO.setSeverity(form.getLocalContext().getSeverity());
			painReviewDetailsVO.setOnset(form.cmbOnset().getValue());
			painReviewDetailsVO.setProgression(form.cmbProgression().getValue());
			painReviewDetailsVO.setDepth(form.cmbDepth().getValue());
			
			MemberOfStaffShortVo memStaffShortVo = (MemberOfStaffShortVo)domain.getMosUser();
			if(memStaffShortVo != null && memStaffShortVo.getHcp() != null)
				painReviewDetailsVO.setRecordingHCP(memStaffShortVo.getHcp());
			
			painDetailsVO.setIsDiscontinuedAssess(new Boolean(form.chkDiscontinueAssessment().getValue()));
			
			//Set the Findings value back to the context
			form.getGlobalContext().COE.PainBodyChart.setAssessmentFinding(painDetailsVO);
			//Set the Review value back to the context
			form.getGlobalContext().COE.PainBodyChart.setPainAssReviewVO(painReviewDetailsVO);
		}
		return true;
	}
	
	private boolean checkAssessmentDate()
	{
		if(form.dteAssessmentDate().getValue() == null)
		{
			engine.showMessage("Please enter assessment date");
			return false;
		}
		if(form.timAssessmentTime().getValue() == null)
		{
			engine.showMessage("Please enter assessment time");
			return false;
		}
		
		return true;
	}
	
	private void clearGlobalContext()
	{
		form.getGlobalContext().COE.PainBodyChart.setReviewPage(new Boolean(false));
	}
	
	protected void onImb1Click() throws PresentationLogicException 
	{
		setSeverity(PainSeverity.NO_PAIN_AT_ALL);	
	}
	protected void onImb2Click() throws PresentationLogicException 
	{
		setSeverity(PainSeverity.NORMAL_ACTIVITIES);
	}
	protected void onImb3Click() throws PresentationLogicException 
	{
		setSeverity(PainSeverity.MILD_STINGING);
	}
	protected void onImb4Click() throws PresentationLogicException 
	{
		setSeverity(PainSeverity.FEW_PROBLEMS);
	}
	protected void onImb5Click() throws PresentationLogicException 
	{
		setSeverity(PainSeverity.NOT_BAD);
	}
	protected void onImb6Click() throws PresentationLogicException 
	{
		setSeverity(PainSeverity.QUITE_BAD);	
	}
	protected void onImb7Click() throws PresentationLogicException 
	{
		setSeverity(PainSeverity.CAUSES_DIFICULTIES);
	}
	protected void onImb8Click() throws PresentationLogicException 
	{
		setSeverity(PainSeverity.VERY_BAD);
	}
	protected void onImb9Click() throws PresentationLogicException 
	{
		setSeverity(PainSeverity.EXCRUITIATING);
	}
	protected void onImb10Click() throws PresentationLogicException 
	{
		setSeverity(PainSeverity.NO_CONTROL);
		
	}
	protected void onImb11Click() throws PresentationLogicException 
	{
		setSeverity(PainSeverity.DISABLING);
	}
	private void setSeverity(PainSeverity severity)
	{
		form.txtSeverity().setValue(severity.toString());
		form.getLocalContext().setSeverity(severity);
	}
}
