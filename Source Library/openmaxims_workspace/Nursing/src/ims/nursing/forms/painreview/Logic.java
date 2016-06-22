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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.20 build 40813.1400)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.painreview;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.MemberOfStaffShortVo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.FormName;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateFormat;
import ims.framework.utils.TimeFormat;
import ims.nursing.forms.painreview.GenForm.FilterEnumeration;
import ims.nursing.vo.PainAssessment;
import ims.nursing.vo.PainAssessmentCollection;
import ims.nursing.vo.PainAssessmentFindings;
import ims.nursing.vo.PainAssessmentReview;
import ims.nursing.vo.PainAssessmentReviewCollection;
import ims.nursing.vo.PainReviewSearchCriteriaVo;
import ims.nursing.vo.lookups.PainStatus;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.CareContextShortVoCollection;

public class Logic extends BaseLogic
{
	private static final int LIST_ALL			= 2;
	private static final int LIST_ACTIVE		= 1;
	
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		initialize();
		//WDEV-19389 
		if (!(form.getGlobalContext().Core.getCurrentCareContextIsNotNull() && form.getGlobalContext().Nursing.getPainReviewSearchCriteriaIsNotNull() && form.getGlobalContext().Core.getCurrentCareContext().equals(form.getGlobalContext().Nursing.getPainReviewSearchCriteria().getCareContext())))
			form.getGlobalContext().Nursing.setPainReviewSearchCriteria(null);
		
		if(form.getGlobalContext().Nursing.getPainReviewSearchCriteriaIsNotNull())
		{
			try
			{
				setSearchCriteria(form.getGlobalContext().Nursing.getPainReviewSearchCriteria());
				onCmbSiteValueChanged();
			}
			catch (PresentationLogicException e)
			{e.printStackTrace();}

		}
		else
			open();
		//WDEV-19389 - end
		

	}
	private void initialize()
	{
		
		//WDEV-4470 
		
		if(ConfigFlag.UI.CONTEXT_SEARCH_ENABLED.getValue())
		{	
			form.recbrAssessment().setVisible(true);
			form.lbl1().setVisible(true);
		}
		else
		{
			form.recbrAssessment().setVisible(false);
			form.lbl1().setVisible(false);
		}
		
		
		CareContextShortVoCollection voCareContextList = domain.listPainReviewCareContexts(form.getGlobalContext().Core.getPatientShort().getID_Patient());
		if (voCareContextList != null && voCareContextList.size() > 0)
		{
			form.recbrAssessment().newRow(null,null); //empty row
			
			
			
			for (int i=0;i<voCareContextList.size();i++)
			{
				String hcpName ="";
				if(voCareContextList.get(i).getEpisodeOfCare().getHcpDisplayString()!= null)
					hcpName = voCareContextList.get(i).getEpisodeOfCare().getHcpDisplayString();
				
				form.recbrAssessment().newRow(voCareContextList.get(i),voCareContextList.get(i).getStartDateTime().getDate().toString() + " " + voCareContextList.get(i).getStartDateTime().getTime().toString()+" "+hcpName);
			
				
			
			
			}
		
		}
		
		clearGlobalContext();
		populatePainGrid();
		prepopulateDetailsGrid();
		setControlDefaultState();
		open();
		
		
		
		
		if(ims.configuration.gen.ConfigFlag.UI.DISPLAY_CAREPLAN_NOTE_LINK.getValue())
		{
			form.lnkClinicalNotes().setVisible(true);
		}
		else
			form.lnkClinicalNotes().setVisible(false);
		
	}
	
	private PainReviewSearchCriteriaVo getSearchCriteria()
	{
		PainReviewSearchCriteriaVo searchCriteria = new PainReviewSearchCriteriaVo();
		
		searchCriteria.setViewType(getViewType());
		searchCriteria.setSelectedCareContext(form.recbrAssessment().getValue());
		searchCriteria.setAssessment(form.cmbAssessment().getValue());
		searchCriteria.setFindings(form.cmbSite().getValue());
		searchCriteria.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		return searchCriteria;
	}
	
	
	private void setSearchCriteria(PainReviewSearchCriteriaVo painReviewSearchCriteriaVo) throws PresentationLogicException
	{
		form.recbrAssessment().setValue(painReviewSearchCriteriaVo.getSelectedCareContext());
		onRecbrAssessmentValueChanged();
		form.cmbAssessment().setValue(painReviewSearchCriteriaVo.getAssessment());
		onCmbAssessmentValueChanged();
		setViewType(painReviewSearchCriteriaVo.getViewType());
		onRadioButtonFilterValueChanged();
		form.cmbSite().setValue(painReviewSearchCriteriaVo.getFindings());
	}

	private void setViewType(Integer searchType)
	{
		if (searchType == null)
			return;
		
		switch (searchType)
		{
		case LIST_ALL:
			form.Filter().setValue(FilterEnumeration.rdoAll);
			break;
		case LIST_ACTIVE:
			form.Filter().setValue(FilterEnumeration.rdoActive);
			break;
		}				
	}

	private Integer getViewType()
	{
		FilterEnumeration searchType = form.Filter().getValue();
		if (FilterEnumeration.rdoAll.equals(searchType))
		{
			return LIST_ALL;
		}
		if (FilterEnumeration.rdoActive.equals(searchType))
		{
			return LIST_ACTIVE;
		}
		
		return null;
	}
	
	protected void onBNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		//------- Add a new review VO and set it in the Context to be used in the dialog
		PainAssessmentReview reviewVO = new PainAssessmentReview();
		
		MemberOfStaffShortVo memStaffShortVo = (MemberOfStaffShortVo)domain.getMosUser();
		if(memStaffShortVo != null && memStaffShortVo.getHcp() != null)
			reviewVO.setRecordingHCP(memStaffShortVo.getHcp());
		
		form.getGlobalContext().COE.PainBodyChart.setPainAssReviewVO(reviewVO);
		//------------------------------------------------------------------------------

		//set the to be used in the Review dialog
		form.getGlobalContext().COE.PainBodyChart.setReviewPage(new Boolean(true));
		//Open the dialog
		engine.open(form.getForms().Nursing.PainReviewDialog);
	}
	protected void onLnkClinicalNotesClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().COE.ClinicalNotes.setCallingForm(form.getForms().Nursing.PainReview);
		engine.open(form.getForms().Nursing.ClinicalNotes);
	}
	protected void onBBodyChartClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.cmbAssessment().getValue() == null)
		{
			displayError("Please select an Assessment");
			return;
		}
		else
			form.getGlobalContext().COE.PainBodyChart.setReadOnlyAssessment(form.cmbAssessment().getValue());
		
		engine.open(form.getForms().Nursing.PainBodyChart);
	}
	protected void onCmbAssessmentValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		String hyper, site, discont, continuedAssess;
		boolean dispActive = form.Filter().getValue().equals(GenForm.FilterEnumeration.rdoActive);
		
		clearGrids();
		form.cmbSite().clear();
				
		if(form.cmbAssessment().getValue() != null && form.cmbAssessment().getValue().getSiteDetails() != null)
		{
			for(int i=0; i<form.cmbAssessment().getValue().getSiteDetails().size(); i++)
			{	
				//Skip the inactive when the case
				if(dispActive && form.cmbAssessment().getValue().getSiteDetails().get(i).getIsDiscontinuedAssess() != null &&
							 form.cmbAssessment().getValue().getSiteDetails().get(i).getIsDiscontinuedAssess().booleanValue())
					continue;
					
				hyper = form.cmbAssessment().getValue().getSiteDetails().get(i).getPainHypersensitivity() != null?form.cmbAssessment().getValue().getSiteDetails().get(i).getPainHypersensitivity().getText():"";
				site  = form.cmbAssessment().getValue().getSiteDetails().get(i).getSiteName() != null?form.cmbAssessment().getValue().getSiteDetails().get(i).getSiteName():"";
				discont = form.cmbAssessment().getValue().getSiteDetails().get(i).getIsDiscontinuedAssess() != null && form.cmbAssessment().getValue().getSiteDetails().get(i).getIsDiscontinuedAssess().booleanValue()?discontinued:"";
				continuedAssess	  = form.cmbAssessment().getValue().getSiteDetails().get(i).getIsContinuedAssessment() != null && form.cmbAssessment().getValue().getSiteDetails().get(i).getIsContinuedAssessment().booleanValue()?contAssmnt:"";
				form.cmbSite().newRow(form.cmbAssessment().getValue().getSiteDetails().get(i), hyper + " - " + site + continuedAssess + discont);
			}
		}
		if(form.cmbAssessment().getValue() != null){
			form.getGlobalContext().COE.PainBodyChart.setPainAssessmentVO(form.cmbAssessment().getValue());
			form.getLocalContext().setPainAssessment(form.cmbAssessment().getValue());
			form.getGlobalContext().Nursing.setPainReviewSearchCriteria(getSearchCriteria()); // WDEV-19389 
		}
		else
		{
			form.getLocalContext().setPainAssessment(null);		
			form.getGlobalContext().Nursing.setPainReviewSearchCriteria(null); // WDEV-19389 
		}
		
		
		form.btnNext().setEnabled(false);
		form.btnPrevious().setEnabled(false);
		form.btnNew().setEnabled(false);
	}
	
	protected void onCmbSiteValueChanged() throws PresentationLogicException 
	{
		clearGrids();
		form.getLocalContext().setCurrentVOIndex(new Integer(0));
		if(form.cmbSite().getValue() != null)
		{
			//Build the Review List
			PainAssessmentReviewCollection painAssColl = new PainAssessmentReviewCollection();
			//Copy the data from PainAssVO to a ReviewVO and copy at the ebginning of 
			//the list to be displayed e.g. reverse chronological order  
			//painAssColl.add(getHeaderVO());
			if(form.cmbSite().getValue().getPainAssessmentReview() != null)
			{
				//form.cmbSite().getValue().getPainAssessmentReview().sort(SortOrder.DESCENDING);
				for(int i=0; i<form.cmbSite().getValue().getPainAssessmentReview().size(); i++)
					painAssColl.add(form.cmbSite().getValue().getPainAssessmentReview().get(i));
			}
			painAssColl.sort(SortOrder.ASCENDING);
			form.getLocalContext().setReviewCollection(painAssColl);
			//Set the findingVO to be used in Review Dialog
			form.getGlobalContext().COE.PainBodyChart.setAssessmentFinding(form.cmbSite().getValue());
			
			//------------------------------------------------------
			//set the current index to be the one that's displaying the last records first
			int recIndex = 0;
			if(painAssColl.size()%maxcolumns == 0)
				recIndex = (painAssColl.size()/maxcolumns)*maxcolumns - maxcolumns;
			else
				recIndex = (painAssColl.size()/maxcolumns)*maxcolumns;
			
			recIndex = recIndex<0?0:recIndex;
			form.getLocalContext().setCurrentVOIndex(new Integer(recIndex));
			//--------------------------------------------------------
			
			populateReviewDetails();
			
			form.btnNext().setEnabled(false);
			if(painAssColl.size() > maxcolumns)
				form.btnPrevious().setEnabled(true);
			else
				form.btnPrevious().setEnabled(false);
			
			//Check if it's the first record
			if(form.getLocalContext().getPainAssessments().get(0).equals(form.cmbAssessment().getValue())) 
			{
				//Check if discontinued
				if(form.cmbSite().getValue().getIsDiscontinuedAssess() != null && 
				   form.cmbSite().getValue().getIsDiscontinuedAssess().booleanValue())
					form.btnNew().setEnabled(false);
				else
					form.btnNew().setEnabled(true);
				
			}
			else
				form.btnNew().setEnabled(false);
		}
		else
		{
			form.btnNew().setEnabled(false);
			form.btnNext().setEnabled(false);
			form.btnPrevious().setEnabled(false); 
		}
		form.getGlobalContext().Nursing.setPainReviewSearchCriteria(getSearchCriteria()); // WDEV-19389 
	}
	
	private void populateReviewDetails()
	{
		PainAssessmentReviewCollection painReviewCollection = form.getLocalContext().getReviewCollection();
		clearGrids();
		
		if(painReviewCollection != null)
		{
			PainAssessmentFindings finding = form.cmbSite().getValue();
			int currentIndex = form.getLocalContext().getCurrentVOIndex() != null?form.getLocalContext().getCurrentVOIndex().intValue():0;
			int i = currentIndex;
			GenForm.grdDetailsRowCollection rowsColl = form.grdDetails().getRows();
			
			if(currentIndex < painReviewCollection.size())
			{
				PainAssessmentReview painAssRev = null;
				for(i=currentIndex; i<painReviewCollection.size(); i++)
				{
					painAssRev = painReviewCollection.get(i);
					if(i<(currentIndex + maxcolumns))
					{
						switch(i-currentIndex)
						{
						case 0:
							//"Recording Date/Time"
							if(painAssRev.getRecordingDateTime() != null)
								rowsColl.get(0).setColumn1(painAssRev.getRecordingDateTime().getDate().toString(DateFormat.STANDARD) + "; " + painAssRev.getRecordingDateTime().getTime().toString(TimeFormat.DEFAULT) + "hrs");
							if(painAssRev.getAssessmentDateTime() != null)
								rowsColl.get(1).setColumn1(painAssRev.getAssessmentDateTime().getDate().toString(DateFormat.STANDARD) + "; " + painAssRev.getAssessmentDateTime().getTime().toString(TimeFormat.DEFAULT) + "hrs");
							//"HCP"
							if(painAssRev.getRecordingHCP() != null)
								rowsColl.get(2).setColumn1(painAssRev.getRecordingHCP().toString());
							//Site
							rowsColl.get(3).setColumn1(finding.getSiteName());
							//Site Details
							rowsColl.get(4).setColumn1(painAssRev.getSiteDetails());
							//"Type"
							if(painAssRev.getType() != null)
								rowsColl.get(5).setColumn1(painAssRev.getType().getText());
							//"Severity"
							if(painAssRev.getSeverity() != null)
								rowsColl.get(6).setColumn1(painAssRev.getSeverity().getText());
							//"Onset"
							if(painAssRev.getOnset() != null)
								rowsColl.get(7).setColumn1(painAssRev.getOnset().getText());
							//"Progression"
							if(painAssRev.getProgression() != null)
								rowsColl.get(8).setColumn1(painAssRev.getProgression().getText());
							//"Depth"
							if(painAssRev.getDepth() != null)
								rowsColl.get(9).setColumn1(painAssRev.getDepth().getText());
							break;
						case 1:
							//"Recording Date/Time"
							if(painAssRev.getRecordingDateTime() != null)
								rowsColl.get(0).setColumn2(painAssRev.getRecordingDateTime().getDate().toString(DateFormat.STANDARD) + "; " + painAssRev.getRecordingDateTime().getTime().toString(TimeFormat.DEFAULT) + "hrs");
							if(painAssRev.getAssessmentDateTime() != null)
								rowsColl.get(1).setColumn2(painAssRev.getAssessmentDateTime().getDate().toString(DateFormat.STANDARD) + "; " + painAssRev.getAssessmentDateTime().getTime().toString(TimeFormat.DEFAULT) + "hrs");
							//"HCP"
							if(painAssRev.getRecordingHCP() != null)
								rowsColl.get(2).setColumn2(painAssRev.getRecordingHCP().toString());
							//Site
							rowsColl.get(3).setColumn2(finding.getSiteName());
							//Site Details
							rowsColl.get(4).setColumn2(painAssRev.getSiteDetails());
							//"Type"
							if(painAssRev.getType() != null)
								rowsColl.get(5).setColumn2(painAssRev.getType().getText());
							//"Severity"
							if(painAssRev.getSeverity() != null)
								rowsColl.get(6).setColumn2(painAssRev.getSeverity().getText());
							//"Onset"
							if(painAssRev.getOnset() != null)
								rowsColl.get(7).setColumn2(painAssRev.getOnset().getText());
							//"Progression"
							if(painAssRev.getProgression() != null)
								rowsColl.get(8).setColumn2(painAssRev.getProgression().getText());
							//"Depth"
							if(painAssRev.getDepth() != null)
								rowsColl.get(9).setColumn2(painAssRev.getDepth().getText());
							break;
						case 2:
							//"Recording Date/Time"
							if(painAssRev.getRecordingDateTime() != null)
								rowsColl.get(0).setColumn3(painAssRev.getRecordingDateTime().getDate().toString(DateFormat.STANDARD) + "; " + painAssRev.getRecordingDateTime().getTime().toString(TimeFormat.DEFAULT) + "hrs");
							if(painAssRev.getAssessmentDateTime() != null)
								rowsColl.get(1).setColumn3(painAssRev.getAssessmentDateTime().getDate().toString(DateFormat.STANDARD) + "; " + painAssRev.getAssessmentDateTime().getTime().toString(TimeFormat.DEFAULT) + "hrs");
							//"HCP"
							if(painAssRev.getRecordingHCP() != null)
								rowsColl.get(2).setColumn3(painAssRev.getRecordingHCP().toString());
							//Site
							rowsColl.get(3).setColumn3(finding.getSiteName());
							//Site Details
							rowsColl.get(4).setColumn3(painAssRev.getSiteDetails());
							//"Type"
							if(painAssRev.getType() != null)
								rowsColl.get(5).setColumn3(painAssRev.getType().getText());
							//"Severity"
							if(painAssRev.getSeverity() != null)
								rowsColl.get(6).setColumn3(painAssRev.getSeverity().getText());
							//"Onset"
							if(painAssRev.getOnset() != null)
								rowsColl.get(7).setColumn3(painAssRev.getOnset().getText());
							//"Progression"
							if(painAssRev.getProgression() != null)
								rowsColl.get(8).setColumn3(painAssRev.getProgression().getText());
							//"Depth"
							if(painAssRev.getDepth() != null)
								rowsColl.get(9).setColumn3(painAssRev.getDepth().getText());
							break;
						case 3:
							//"Recording Date/Time"
							if(painAssRev.getRecordingDateTime() != null)
								rowsColl.get(0).setColumn4(painAssRev.getRecordingDateTime().getDate().toString(DateFormat.STANDARD) + "; " + painAssRev.getRecordingDateTime().getTime().toString(TimeFormat.DEFAULT) + "hrs");
							if(painAssRev.getAssessmentDateTime() != null)
								rowsColl.get(1).setColumn4(painAssRev.getAssessmentDateTime().getDate().toString(DateFormat.STANDARD) + "; " + painAssRev.getAssessmentDateTime().getTime().toString(TimeFormat.DEFAULT) + "hrs");
							//"HCP"
							if(painAssRev.getRecordingHCP() != null)
								rowsColl.get(2).setColumn4(painAssRev.getRecordingHCP().toString());
							//Site
							rowsColl.get(3).setColumn4(finding.getSiteName());
							//Site Details
							rowsColl.get(4).setColumn4(painAssRev.getSiteDetails());
							//"Type"
							if(painAssRev.getType() != null)
								rowsColl.get(5).setColumn4(painAssRev.getType().getText());
							//"Severity"
							if(painAssRev.getSeverity() != null)
								rowsColl.get(6).setColumn4(painAssRev.getSeverity().getText());
							//"Onset"
							if(painAssRev.getOnset() != null)
								rowsColl.get(7).setColumn4(painAssRev.getOnset().getText());
							//"Progression"
							if(painAssRev.getProgression() != null)
								rowsColl.get(8).setColumn4(painAssRev.getProgression().getText());
							//"Depth"
							if(painAssRev.getDepth() != null)
								rowsColl.get(9).setColumn4(painAssRev.getDepth().getText());
							break;
						case 4:
							//"Recording Date/Time"
							if(painAssRev.getRecordingDateTime() != null)
								rowsColl.get(0).setColumn5(painAssRev.getRecordingDateTime().getDate().toString(DateFormat.STANDARD) + "; " + painAssRev.getRecordingDateTime().getTime().toString(TimeFormat.DEFAULT) + "hrs");
							if(painAssRev.getAssessmentDateTime() != null)
								rowsColl.get(1).setColumn5(painAssRev.getAssessmentDateTime().getDate().toString(DateFormat.STANDARD) + "; " + painAssRev.getAssessmentDateTime().getTime().toString(TimeFormat.DEFAULT) + "hrs");
							//"HCP"
							if(painAssRev.getRecordingHCP() != null)
								rowsColl.get(2).setColumn5(painAssRev.getRecordingHCP().toString());
							//Site
							rowsColl.get(3).setColumn5(finding.getSiteName());
							//Site Details
							rowsColl.get(4).setColumn5(painAssRev.getSiteDetails());
							//"Type"
							if(painAssRev.getType() != null)
								rowsColl.get(5).setColumn5(painAssRev.getType().getText());
							//"Severity"
							if(painAssRev.getSeverity() != null)
								rowsColl.get(6).setColumn5(painAssRev.getSeverity().getText());
							//"Onset"
							if(painAssRev.getOnset() != null)
								rowsColl.get(7).setColumn5(painAssRev.getOnset().getText());
							//"Progression"
							if(painAssRev.getProgression() != null)
								rowsColl.get(8).setColumn5(painAssRev.getProgression().getText());
							//"Depth"
							if(painAssRev.getDepth() != null)
								rowsColl.get(9).setColumn5(painAssRev.getDepth().getText());
							break;
						}
					}
					else
						break;
				}
			}
		}
	}
	private void populatePainGrid()
	{
		GenForm.grdPainRow row;
		for(int i=0; i<painRows.length; i++)
		{
			row = form.grdPain().getRows().newRow();
			row.setColPainDetails(painRows[i]);
		}
	}
	
	private void clearCombos()
	{
		form.cmbAssessment().clear();
		form.cmbSite().clear();
	}
	
	private void setControlDefaultState()
	{
		form.Filter().setValue(GenForm.FilterEnumeration.rdoActive);
	}
	
	private void prepopulateDetailsGrid()
	{
		for(int i=0; i<painRows.length; i++)
		{
			//Add dummy rows in Details grid 
			form.grdDetails().getRows().newRow();
		}	
	}
	
	private void open()
	{
	
		
		form.setMode(FormMode.VIEW);
		form.recbrAssessment().setValue(form.getGlobalContext().Core.getCurrentCareContext());
		populateInstance(form.getGlobalContext().Core.getCurrentCareContext(),true);
	}
	
	private boolean populateInstance(CareContextShortVo voContext,boolean bListRecords)
	{
		clearScreen();
		
		if (voContext != null)
		{	

			PainAssessmentCollection assmtCollection;
			PainAssessment painAss;
			
			
			form.btnNew().setEnabled(false);
			form.btnNext().setEnabled(false);
			form.btnPrevious().setEnabled(false);
			
			//List the assessment if they were not listed before.
			if(bListRecords || form.getLocalContext().getPainAssessments() == null)
			{ 
				assmtCollection = domain.listPain(voContext);
				assmtCollection.sort(SortOrder.DESCENDING);
				form.getLocalContext().setPainAssessments(assmtCollection);
			}
			else
			{
				//Get the assessment from the context
				assmtCollection = form.getLocalContext().getPainAssessments();
			}
					
			if(assmtCollection != null)
			{
				for(int i=0; i<assmtCollection.size(); i++)
				{
					painAss = assmtCollection.get(i); 
					//Assessment Date/Time
					if(painAss.getDateTimeInitiated() != null && painAss.getDateTimeInitiated().getDate() != null && painAss.getDateTimeInitiated().getTime() != null)
						form.cmbAssessment().newRow(painAss, painAss.getDateTimeInitiated().getDate().toString(DateFormat.STANDARD) + " / " + painAss.getDateTimeInitiated().getTime().toString(TimeFormat.DEFAULT));
				}
			}
			//Set the current value in the combo
			if(form.cmbAssessment().getValues() != null && form.cmbAssessment().getValues().size() > 0)
			{
				//Set the context value or the first
				if(form.getGlobalContext().COE.PainBodyChart.getPainAssessmentVO() != null)
					form.cmbAssessment().setValue(form.getGlobalContext().COE.PainBodyChart.getPainAssessmentVO());
				else
					form.cmbAssessment().setValue((PainAssessment)form.cmbAssessment().getValues().get(0));
				
				if(form.cmbAssessment().getValue() != null)
					refreshSite();
			}
		}
		
		return true;
	}
	private void clearScreen()
	{		
		clearCombos();
		clearGrids();		
	}

	//forces a SiteCombo Refresh
	private void refreshSite()
	{
		try 
		{
			onCmbAssessmentValueChanged();
		}
		catch (PresentationLogicException e) 
		{	
			showMessage(e.getMessage());
		}
	}
	
	private void showMessage(String message)
	{
		engine.showMessage(message);
	}

	protected void onRadioButtonFilterValueChanged() throws PresentationLogicException 
	{
		refreshSite();
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if(formName.equals(form.getForms().Nursing.PainReviewDialog) && result.equals(DialogResult.OK))
		{
			PainAssessmentFindings findingVO = form.getGlobalContext().COE.PainBodyChart.getAssessmentFinding();
			if(findingVO.getPainAssessmentReview() == null)
				findingVO.setPainAssessmentReview(new PainAssessmentReviewCollection());
			
			//Find the Assessment VO to be saved
			PainAssessment painAssVO = form.cmbAssessment().getValue();
			
			//Replace the findingVO
			for(int i=0; i<painAssVO.getSiteDetails().size(); i++)
			{
				if(painAssVO.getSiteDetails().get(i).equals(findingVO))
				{
					painAssVO.getSiteDetails().remove(i);
					painAssVO.getSiteDetails().add(findingVO);
					break;
				}
			}
			
			boolean bRecordFound = false;
			for(int i=0; i<painAssVO.getSiteDetails().size(); i++)
			{
				if(painAssVO.getSiteDetails().get(i).equals(findingVO))
				{
					if(painAssVO.getSiteDetails().get(i).getPainAssessmentReview() == null)
						painAssVO.getSiteDetails().get(i).setPainAssessmentReview(new PainAssessmentReviewCollection());
					
					//Add the Review DTO to the PainAssVO 
					painAssVO.getSiteDetails().get(i).getPainAssessmentReview().add(form.getGlobalContext().COE.PainBodyChart.getPainAssReviewVO());
					bRecordFound = true;
					break;
				}
			}

			//set the Filter to be all - in order to display the values
			if(findingVO.getIsDiscontinuedAssess() != null && findingVO.getIsDiscontinuedAssess().booleanValue())
				form.Filter().setValue(GenForm.FilterEnumeration.rdoAll);
				
			if(!bRecordFound)
			{
				displayError("Pain Assessment Finding Record not found.");
				return;
			}	
			
			try {
								
				if (painAssVO.getClinicalContact() == null)
					painAssVO.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
				
				if (painAssVO.getCareContext() == null)
					painAssVO.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());				
				
				String[] error = painAssVO.validate();
				if(error != null)
				{
					displayErrors(error);
					return;
				}
				
				try 
				{
					domain.savePain(painAssVO);
				} 
				catch (UniqueKeyViolationException e) 
				{
					engine.showMessage(e.getMessage());
					return;
				}
				
			} catch (StaleObjectException e) 
			{
				displayError(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			}
			catch (DomainInterfaceException e)
			{
				displayError(e.getMessage());
			}
			
			open();
			if(form.cmbSite().getValues() != null)
			{
				form.cmbSite().setValue(form.getGlobalContext().COE.PainBodyChart.getAssessmentFinding());
				if(form.cmbSite().getValue() != null)
					onCmbSiteValueChanged();
			}
		}
	}
	
	
	protected void onGrdDetailsGridHeaderClicked(int column) 
	{
		engine.showMessage("Column " + Integer.toString(column) + " clicked!");	
	}
	
	private void clearGrids()
	{
		form.grdDetails().getRows().clear();
		prepopulateDetailsGrid();
	}
	
	private void displayError(String message)
	{
		engine.showMessage(message);
	}
	
	private void displayErrors(String [] errors)
	{
		engine.showErrors(errors);
	}
	
	protected void onBtnPreviousClick() throws PresentationLogicException 
	{
		if(form.getLocalContext().getCurrentVOIndex() != null)
		{
			int prevIndex = form.getLocalContext().getCurrentVOIndex().intValue() - maxcolumns;
			if(prevIndex <= 0)
			{
				prevIndex = 0;
				form.btnPrevious().setEnabled(false);
			}
			form.getLocalContext().setCurrentVOIndex(new Integer(prevIndex));
			
			if(form.getLocalContext().getReviewCollection().size() > maxcolumns && 
			   form.getLocalContext().getCurrentVOIndex().intValue() <= (form.getLocalContext().getReviewCollection().size() - maxcolumns))
				form.btnNext().setEnabled(true);
			else
				form.btnNext().setEnabled(false);
			
			populateReviewDetails();
		}
	}
	
	protected void onBtnNextClick() throws PresentationLogicException 
	{
		if(form.getLocalContext().getCurrentVOIndex() != null)
		{
			int nextIndex = form.getLocalContext().getCurrentVOIndex().intValue() + maxcolumns;
			if(nextIndex >= form.getLocalContext().getReviewCollection().size())
			{
				nextIndex = form.getLocalContext().getReviewCollection().size();
				form.btnNext().setEnabled(false);
			}
	
			if((nextIndex + maxcolumns) >= form.getLocalContext().getReviewCollection().size())
				form.btnNext().setEnabled(false);
			
			form.getLocalContext().setCurrentVOIndex(new Integer((nextIndex)));
			
			if(form.getLocalContext().getCurrentVOIndex().intValue() >= maxcolumns)
				form.btnPrevious().setEnabled(true);
			else
				form.btnPrevious().setEnabled(false);
			
			populateReviewDetails();
		}
	}
	
	private void clearGlobalContext()
	{
		form.getGlobalContext().COE.ClinicalNotes.setCallingForm(null);
		form.getGlobalContext().COE.PainBodyChart.setAssessmentFinding(null);
		form.getGlobalContext().COE.PainBodyChart.setPainAssessmentVO(null);
	}
	protected void onRecbrAssessmentValueChanged() throws PresentationLogicException
	{
		clearGlobalContext();
		form.getGlobalContext().Nursing.setPainReviewSearchCriteria(null); // WDEV-19389 
		populateInstance(form.recbrAssessment().getValue(),true);
		
		updateControlStatus();		
	}
	private void updateControlStatus()
	{

		if (form.recbrAssessment().getValue() == null)
		{
			form.btnNew().setVisible(false);
		}
		else
		{
			if (form.recbrAssessment().getValue().equals(form.getGlobalContext().Core.getCurrentCareContext()))
			{
				form.btnNew().setVisible(true);
			}
			else
			{
				form.btnNew().setVisible(false);
			}
		}
	}	

	private String[] painRows = new String[] {"Recording Date/Time", "Assessment Date/Time", "HCP", "Site", "Site Details", "Type", "Severity", "Onset", "Progression", "Depth"};
	private int maxcolumns = 5;
	private String discontinued = new String("  (" + PainStatus.DISCONTINUED.toString() + ")");
	private String contAssmnt	= new String("  (" + PainStatus.CONTINUED.toString() 	+ ")");
}
