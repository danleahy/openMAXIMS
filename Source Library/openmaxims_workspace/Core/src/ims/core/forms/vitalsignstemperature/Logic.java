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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.20 build 40806.900)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.vitalsignstemperature;

import ims.core.forms.vitalsignstemperature.GenForm.grpShowByEnumeration;
import ims.core.vo.VSTemperature;
import ims.core.vo.VitalSignsFormsSearchCriteriaVo;
import ims.core.vo.VitalSignsVo;
import ims.core.vo.VitalSignsVoCollection;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateFormat;
import ims.framework.utils.graphing.GraphingHighlight;
import ims.framework.utils.graphing.GraphingPoint;
import ims.framework.utils.graphing.GraphingPointType;
import ims.framework.utils.graphing.GraphingTemperature;


public class Logic extends BaseLogic
{
	private static final int LIST_BY_DAY			= 1;
	private static final int LIST_BY_DATES			= 2;
	
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		//WDEV-14429
		if(isVitalSignsTemperatureForTriage())
		{
			form.setMode(FormMode.VIEW);
		}
		
		form.grpShowBy().setValue(GenForm.grpShowByEnumeration.rdoDay); 
		form.btnUpdate().setEnabled(false);
		
		//WDEV-7526
		if(form.getGlobalContext().Core.getIdForm() != null && form.getGlobalContext().Core.getIdForm().equals(form.getForms().Core.BaselineObservations.getID()))
		{
			form.lnkReturn().setTooltip("Return to Baseline Observations");
		}
		else
		{
			form.lnkReturn().setTooltip("Return to Vital Signs");
		}
		//ends here 
		
		//form.btnPrint().setEnabled(false);
		

		if(form.getGlobalContext().Core.getVitalSign() != null  && form.getGlobalContext().Core.getVitalSign().getTemperature() != null)
		{
			form.dteShowByDay().setValue(form.getGlobalContext().Core.getVitalSign().getVitalsTakenDateTime() != null ? form.getGlobalContext().Core.getVitalSign().getVitalsTakenDateTime().getDate() : null);//	WDEV-13117
			form.getLocalContext().setvitalSign(form.getGlobalContext().Core.getVitalSign());
			displayRecord(form.getGlobalContext().Core.getVitalSign());
			form.btnUpdate().setEnabled(true);
			//form.btnPrint().setEnabled(true);
			listTemperatures();	
		}
		else
		{
			if (form.getGlobalContext().Core.getVitalSign() == null && form.getGlobalContext().Core.getVitalSignsTemperatureSearchCriteriaIsNotNull())
			{
				if (form.getGlobalContext().Core.getVitalSign() == null && !(form.getGlobalContext().Core.getCurrentCareContextIsNotNull() && form.getGlobalContext().Core.getCurrentCareContext().equals(form.getGlobalContext().Core.getVitalSignsTemperatureSearchCriteria().getCareContext())))
					form.getGlobalContext().Core.setVitalSignsTemperatureSearchCriteria(null);
				
				doSearchCriteria(form.getGlobalContext().Core.getVitalSignsTemperatureSearchCriteria());
			}
			else
			{
				try {
    				onRadioButtongrpShowByValueChanged();
    			} catch (PresentationLogicException e) {
    				throw new DomainRuntimeException();
    			}
			}
		}

		updatePrevNextButtons();
		dateIntervalStatus();//	WDEV-13117
	}
	
	private void doSearchCriteria(VitalSignsFormsSearchCriteriaVo vitalSignsTemperatureSearchCriteria)
	{
		if (vitalSignsTemperatureSearchCriteria != null)
		{
			try
			{
				setSearchCriteria(vitalSignsTemperatureSearchCriteria);
				onBtnViewClick();
			}
			catch (PresentationLogicException e) {
				throw new DomainRuntimeException();
			}
		}
		else
		{
			try {
				onRadioButtongrpShowByValueChanged();
			} catch (PresentationLogicException e) {
				throw new DomainRuntimeException();
			}
		}
	}

	private VitalSignsFormsSearchCriteriaVo getSearchCriteria()
	{
		VitalSignsFormsSearchCriteriaVo searchCriteria = new VitalSignsFormsSearchCriteriaVo();
		
		searchCriteria.setViewBy(getViewType());
		searchCriteria.setByDay(form.dteShowByDay().getValue());
		searchCriteria.setFromDate(form.dteFrom().getValue());
		searchCriteria.setToDate(form.dteTo().getValue());
		searchCriteria.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		return searchCriteria;
	}
	
	
	private void setSearchCriteria(VitalSignsFormsSearchCriteriaVo vitalSignsFormsSearchCriteriaVo) throws PresentationLogicException
	{
		setViewType(vitalSignsFormsSearchCriteriaVo.getViewBy());
		onRadioButtongrpShowByValueChanged();
		form.dteShowByDay().setValue(vitalSignsFormsSearchCriteriaVo.getByDay());
		form.dteFrom().setValue(vitalSignsFormsSearchCriteriaVo.getFromDate());
		form.dteTo().setValue(vitalSignsFormsSearchCriteriaVo.getToDate());
	}

	private void setViewType(Integer searchType)
	{
		if (searchType == null)
			return;
		
		switch (searchType)
		{
		case LIST_BY_DAY:
			form.grpShowBy().setValue(grpShowByEnumeration.rdoDay);
			break;
		case LIST_BY_DATES:
			form.grpShowBy().setValue(grpShowByEnumeration.rdoDates);
			break;
		}				
	}

	private Integer getViewType()
	{
		grpShowByEnumeration searchType = form.grpShowBy().getValue();
		if (grpShowByEnumeration.rdoDay.equals(searchType))
		{
			return LIST_BY_DAY;
		}
		if (grpShowByEnumeration.rdoDates.equals(searchType))
		{
			return LIST_BY_DATES;
		}
		
		return null;
	}
	
	protected void onBtnViewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.grpShowBy().getValue().equals(GenForm.grpShowByEnumeration.rdoDay))
		{
			if(form.dteShowByDay().getValue() == null)
			{
				engine.showMessage("Please enter a date to show by");
				return;
			}
		}
		else
		{
			if(form.dteFrom().getValue() == null || form.dteTo().getValue() == null)
			{
				engine.showMessage("Please enter a date range (From and To) to show by");
				return;				
			}
			if(form.dteFrom().getValue().isGreaterThan(form.dteTo().getValue()))
			{
				engine.showMessage("The date From entered cannot be greater than the date To entered");
				return;
			}
		}

		clearFields();
		listTemperatures();
		
		//WDEV-19389 
		if (form.getGlobalContext().Core.getVitalSign() == null )
			form.getGlobalContext().Core.setVitalSignsTemperatureSearchCriteria(getSearchCriteria());

		//form.btnUpdate().setEnabled(false);
	}
	protected void onBtnCanelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		displayRecord(form.getLocalContext().getvitalSign());
		form.setMode(FormMode.VIEW);
		
		dateIntervalStatus();
		updatePrevNextButtons();
	}
	private void dateIntervalStatus()
	{
		form.dteShowByDay().setEnabled(GenForm.grpShowByEnumeration.rdoDay.equals(form.grpShowBy().getValue()));	//WDEV-13117
		
		form.dteFrom().setEnabled(!GenForm.grpShowByEnumeration.rdoDay.equals(form.grpShowBy().getValue()));	//WDEV-13117
		form.dteTo().setEnabled(!GenForm.grpShowByEnumeration.rdoDay.equals(form.grpShowBy().getValue()));	//WDEV-13117
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		VitalSignsVo voVitalSign = form.getLocalContext().getvitalSign();
		
		VSTemperature voTemp = new VSTemperature();
		
		//voTemp.setRecordingSite(form.cmbSite().getValue());
		//voTemp.setInstrument(form.cmbInstrument().getValue());
		voTemp.setTemperature(form.decTemperature().getValue());
		
		voVitalSign.setTemperature(voTemp);
		
		String[] arrErrors = voVitalSign.validate();
		if(arrErrors == null)
		{
			try 
			{
				domain.modifyTemperature(voVitalSign);
			} catch (StaleObjectException e) {
				engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				refresh();
				return;
			}
		}
		else
		{
			engine.showErrors("Validation Errors", arrErrors);
			return;	
		}
		
		form.getGlobalContext().Core.setVitalSign(voVitalSign);

		form.setMode(FormMode.VIEW);
		
		listTemperatures();
		
		dateIntervalStatus();
	
		//form.btnUpdate().setEnabled(false);
	}

	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);	
		form.btnUpdate().setEnabled(false);	
		form.dteShowByDay().setEnabled(false);
		form.dteFrom().setEnabled(false);
		form.dteTo().setEnabled(false);
		form.btnNext().setEnabled(false);
		form.btnPrev().setEnabled(false);
		//form.btnPrint().setEnabled(false);
	}

	protected void onRadioButtongrpShowByValueChanged() throws PresentationLogicException 
	{
		if(form.grpShowBy().getValue().equals(GenForm.grpShowByEnumeration.rdoDay))
		{
			form.dteShowByDay().setEnabled(true);
			form.dteShowByDay().setValue(new Date());
			form.dteFrom().setEnabled(false);
			form.dteTo().setEnabled(false);
			form.dteFrom().setValue(null);
			form.dteTo().setValue(null);
		}
		else
		{
			form.dteShowByDay().setEnabled(false);
			form.dteShowByDay().setValue(null);
			form.dteFrom().setEnabled(true);
			form.dteTo().setEnabled(true);
			form.dteFrom().setValue(new Date());
			form.dteTo().setValue(new Date());
		}
		
		onBtnViewClick();
	}
	
	private void listTemperatures()
	{
		VitalSignsVoCollection voCollVitals = null;
		String subTitle = "Temperature";
		
		if(form.grpShowBy().getValue().equals(GenForm.grpShowByEnumeration.rdoDay))
		{
			voCollVitals = domain.listTemperatures(form.dteShowByDay().getValue(),form.getGlobalContext().Core.getCurrentCareContext());
			subTitle = "Temperature for " + form.dteShowByDay().getValue().toString(DateFormat.STANDARD);
		}
		else
		{
			voCollVitals = domain.listTemperatures(form.dteFrom().getValue(),form.dteTo().getValue(),form.getGlobalContext().Core.getCurrentCareContext());
			subTitle = "Temperature between " + form.dteFrom().getValue().toString(DateFormat.STANDARD) + " - " +  form.dteTo().getValue().toString(DateFormat.STANDARD);
		}
		 
		//form.grhTemp().setSubTitle(subTitle);
		form.lblTemperature().setValue(subTitle);
		form.grhTemp().clearAllPoints();

		GraphingHighlight highlight = new GraphingHighlight(37);
		form.grhTemp().addHighlightedY(highlight);		
		form.grhTemp().showYAxisValues();
		
		form.grhTemp().setPrintHeaderInfo(subTitle + "\r\n" + form.getGlobalContext().Core.getPatientShort().getPatientInfo());
		
		VitalSignsVo voVitalSign;
		GraphingTemperature point;
		if(voCollVitals != null && voCollVitals.size() > 0) //WDEV-16175 
		{
			voCollVitals.sort(SortOrder.ASCENDING);
			
			int nIndex = voCollVitals.size() - 1;
			
			for(int i=0;i<voCollVitals.size();i++)
			{
				voVitalSign = voCollVitals.get(i);
				point = new GraphingTemperature(voVitalSign.getVitalsTakenDateTime(),  voVitalSign.getTemperature().getTemperature(),  voVitalSign);
				form.grhTemp().addPoint(point);
				
				if( form.getGlobalContext().Core.getVitalSign() != null && form.getGlobalContext().Core.getVitalSign().getID_VitalSigns() != null && voVitalSign != null && voVitalSign.getID_VitalSigns() != null && voVitalSign.getID_VitalSigns().intValue() == form.getGlobalContext().Core.getVitalSign().getID_VitalSigns().intValue())
					nIndex = i;
			}

			form.getLocalContext().setTemperatures(voCollVitals);
			form.getLocalContext().setCurrentIndex(new Integer(nIndex));
			displayCurrentTemperature();
		}
		else
		{
			form.btnNext().setEnabled(false);
			form.btnPrev().setEnabled(false);
			form.getLocalContext().setTemperatures(null);
			form.btnUpdate().setEnabled(false);
			//form.btnPrint().setEnabled(false);
		}
	}
	
	private void displayCurrentTemperature()
	{
		VitalSignsVoCollection voTemperatures = form.getLocalContext().getTemperatures();
		Integer nIndex = form.getLocalContext().getCurrentIndex();
		
		if(voTemperatures == null || nIndex == null || nIndex.intValue() == -1 || nIndex.intValue() >= voTemperatures.size())
			return;

		form.getLocalContext().setvitalSign(voTemperatures.get(nIndex.intValue()));
		displayRecord(voTemperatures.get(nIndex.intValue()));
		
		updatePrevNextButtons();
	}
	private void updatePrevNextButtons()
	{
		VitalSignsVoCollection voTemperatures = form.getLocalContext().getTemperatures();
		Integer nIndex = form.getLocalContext().getCurrentIndex();

		form.btnNext().setEnabled(true);
		form.btnPrev().setEnabled(true);
		
		if(voTemperatures == null || nIndex == null)
		{
			form.btnNext().setEnabled(false);
			form.btnPrev().setEnabled(false);
			return;
		}
		
		if(nIndex.intValue() <= 0)
			form.btnPrev().setEnabled(false);

		if(nIndex.intValue() >= voTemperatures.size() - 1)
			form.btnNext().setEnabled(false);
	}
	private void clearFields()
	{
		form.decTemperature().setValue(null);
		form.dteTaken().setValue(null);
		form.timTaken().setValue(null);
		form.txtHCP().setValue("");
	}
	
	protected void onGrhTempPointClicked(GraphingPoint point) 
	{	
		if(point.getType() == GraphingPointType.TEMPERATURE)
		{ 			
			GraphingTemperature pointTemp = (GraphingTemperature)point;
			form.getLocalContext().setvitalSign((VitalSignsVo)pointTemp.getTag());
			displayRecord((VitalSignsVo)pointTemp.getTag());
			form.btnUpdate().setEnabled(true);
			
			//update the Prev/Next buttons
			VitalSignsVoCollection voTemperatures = form.getLocalContext().getTemperatures();
			for(int i = 0; i < voTemperatures.size(); i++)
			{
				if(form.getLocalContext().getvitalSign().getID_VitalSigns().intValue() == voTemperatures.get(i).getID_VitalSigns().intValue())
				{
					form.getLocalContext().setCurrentIndex(new Integer(i));
					updatePrevNextButtons();
					break;
				}
			}
		}
	}
	
	private void displayRecord(VitalSignsVo voVitalSign)
	{
		clearFields();		
		
		form.decTemperature().setValue(voVitalSign.getTemperature().getTemperature());
		form.dteTaken().setValue(voVitalSign.getVitalsTakenDateTime().getDate());
		form.timTaken().setValue(voVitalSign.getVitalsTakenDateTime().getTime());
		form.txtHCP().setValue(voVitalSign.getAuthoringInformation().getAuthoringHcp() != null ? voVitalSign.getAuthoringInformation().getAuthoringHcp().toString() : "");
		
		form.btnUpdate().setEnabled(true);
		//form.btnPrint().setEnabled(true);
	}
	
	private void refresh()
	{
		clearFields();
		listTemperatures();
		form.setMode(FormMode.VIEW);
	}
	
	protected void onBtnNextClick() throws PresentationLogicException
	{
		Integer nIndex = form.getLocalContext().getCurrentIndex();
		form.getLocalContext().setCurrentIndex(new Integer(nIndex.intValue() + 1));
		displayCurrentTemperature();
	}
	protected void onBtnPrevClick() throws PresentationLogicException
	{
		Integer nIndex = form.getLocalContext().getCurrentIndex();
		form.getLocalContext().setCurrentIndex(new Integer(nIndex.intValue() - 1));
		displayCurrentTemperature();
	}
	
	protected void onLnkReturnClick() throws PresentationLogicException 
	{
		//WDEV-14429
		if(isVitalSignsTemperatureForTriage())
		{
			engine.close(DialogResult.OK);
			return;
		}
		
		//WDEV-7526
		if(form.getGlobalContext().Core.getIdForm() != null && form.getGlobalContext().Core.getIdForm().equals(form.getForms().Core.BaselineObservations.getID()))
		{
			engine.open(form.getForms().Core.BaselineObservations);
			
		}
		//ends here
		
		else if(form.getGlobalContext().Core.getIdForm() != null && form.getGlobalContext().Core.getIdForm().equals(form.getForms().Core.VitalSignsBaselineAndAll.getID()))
		{
			engine.open(form.getForms().Core.VitalSignsBaselineAndAll);
			
		}
		else
		{
			engine.open(form.getForms().Core.VitalSignsAll);
		}
	}
	
	//WDEV-14429
	private boolean isVitalSignsTemperatureForTriage()
	{
		if(engine.getFormName().equals(form.getForms().Core.VitalSignsTemperatureForTriage))
			return true;
		
		return false;
	}
}
