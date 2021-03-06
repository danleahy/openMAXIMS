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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.kpidataentrydialog;

import ims.core.vo.lookups.YesNo;
import ims.emergency.forms.kpidataentrydialog.GenForm.GroupBreachWarningFlashingTextEnumeration;
import ims.emergency.forms.kpidataentrydialog.GenForm.GroupBreachedKPIFlashingTextEnumeration;
import ims.emergency.vo.TriageKPIUnboundDBVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;

import java.util.ArrayList;
import java.util.List;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private static final String	ROW_PRIORITY1			= "Priority 1";
	private static final String	ROW_PRIORITY2			= "Priority 2";
	private static final String	ROW_PRIORITY3			= "Priority 3";
	private static final String	ROW_PRIORITY4			= "Priority 4";
	private static final String	ROW_PRIORITY5			= "Priority 5";
	private static final String	ROW_SKIPPEDTRIAGE		= "Skipped Triage";

	
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		if(args != null && args.length == 1 && args[0] != null && args[0] instanceof String)
		{
			form.lblKPI().setValue((String) args[0]);
		}
		
		//WDEV-16991
		TriageKPIUnboundDBVo tempVO = form.getGlobalContext().Emergency.getTriageKPI();
		
		form.lblDefaultRowColour().setVisible(tempVO!=null && (tempVO.getTypeRow().equals(ROW_PRIORITY1) || tempVO.getTypeRow().equals(ROW_PRIORITY2) || tempVO.getTypeRow().equals(ROW_PRIORITY3) || tempVO.getTypeRow().equals(ROW_PRIORITY4) || tempVO.getTypeRow().equals(ROW_PRIORITY5)  || tempVO.getTypeRow().equals(ROW_SKIPPEDTRIAGE)));
		form.cmbDefaultRowColour().setVisible(tempVO!=null && (tempVO.getTypeRow().equals(ROW_PRIORITY1) || tempVO.getTypeRow().equals(ROW_PRIORITY2) || tempVO.getTypeRow().equals(ROW_PRIORITY3) || tempVO.getTypeRow().equals(ROW_PRIORITY4) || tempVO.getTypeRow().equals(ROW_PRIORITY5)  || tempVO.getTypeRow().equals(ROW_SKIPPEDTRIAGE)));
		form.lblDefaultFontColour().setVisible(tempVO!=null && (tempVO.getTypeRow().equals(ROW_PRIORITY1) || tempVO.getTypeRow().equals(ROW_PRIORITY2) || tempVO.getTypeRow().equals(ROW_PRIORITY3) || tempVO.getTypeRow().equals(ROW_PRIORITY4) || tempVO.getTypeRow().equals(ROW_PRIORITY5) || tempVO.getTypeRow().equals(ROW_SKIPPEDTRIAGE)));
		form.cmbDefaultFontColour().setVisible(tempVO!=null && (tempVO.getTypeRow().equals(ROW_PRIORITY1) || tempVO.getTypeRow().equals(ROW_PRIORITY2) || tempVO.getTypeRow().equals(ROW_PRIORITY3) || tempVO.getTypeRow().equals(ROW_PRIORITY4) || tempVO.getTypeRow().equals(ROW_PRIORITY5) || tempVO.getTypeRow().equals(ROW_SKIPPEDTRIAGE)));	
		
		open();
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if( form.intBreachedKPI().isRequired() && form.intBreachWaring().isRequired())
		{
			List<String> uiErrors = new ArrayList<String>();		//wdev-16138
			if( form.GroupBreachedKPIFlashingText().getValue() != null && form.GroupBreachedKPIFlashingText().getValue().equals(GroupBreachedKPIFlashingTextEnumeration.rdoBreachedKPIFlashingTextYes))
			{
    			if( form.intBreachedKPI().getValue() == null) 		//wdev-16138
    			{
    				uiErrors.add("Breached KPI is mandatory.");
    			}
    			if(form.cmbBreachedKPITextColour().getValue() == null)
    			{
    				uiErrors.add("Breached KPI Text Colour is mandatory.");
    			}
    			if( form.cmbBreachedKPIFlashingTextColour().getValue() == null)
    			{
    				uiErrors.add("Breached KPI Flashing Text Colour is mandatory.");
    			}
    			if( form.cmbBreachedKPIBackgroundColour().getValue() == null )
    			{
    				uiErrors.add("Breached KPI Background Colour is mandatory.");
    			}
    			
			}
			else
			{
				if( form.intBreachedKPI().getValue() == null) 
    			{
    				uiErrors.add("Breached KPI is mandatory.");
    			}
    			if(form.cmbBreachedKPITextColour().getValue() == null)
    			{
    				uiErrors.add("Breached KPI Text Colour is mandatory.");
    			}
			}
			if( form.GroupBreachWarningFlashingText().getValue() != null && form.GroupBreachWarningFlashingText().getValue().equals(GroupBreachWarningFlashingTextEnumeration.rdoBreachWarningFlashingTextYes))
			{
				if( form.intBreachWaring().getValue() == null) 		
    			{
    				uiErrors.add("Breach Warning is mandatory.");
    			}
				if(form.cmbBreachWarningTextColour().getValue() == null)
    			{
    				uiErrors.add("Breach Warning Text Colour is mandatory.");
    			}
    			if( form.cmbBreachWarningFlashingTextColour().getValue() == null)
    			{
    				uiErrors.add("Breach Warning Flashing Text Colour is mandatory.");//WDEV-21775
    			}
    			if( form.cmbBreachWarningBackgroundColour().getValue() == null )
    			{
    				uiErrors.add("Breach Warning Background Colour is mandatory.");//WDEV-21775
    			}
			}
			else
			{
				if( form.intBreachWaring().getValue() == null) 		
    			{
    				uiErrors.add("Breach Warning is mandatory.");
    			}
				if(form.cmbBreachWarningTextColour().getValue() == null)
    			{
    				uiErrors.add("Breach Warning Text Colour is mandatory.");
    			}
			}
			String[] result = new String[uiErrors.size()];
			uiErrors.toArray(result);
			if( result != null && result.length > 0)
			{
				engine.showErrors(result);
				return;
			}
			
		}
		TriageKPIUnboundDBVo tempVO  = new TriageKPIUnboundDBVo();
		tempVO.setBreachWarning(form.intBreachWaring().getValue());
		tempVO.setBreachedKPI(form.intBreachedKPI().getValue());
		
		
		//wdev-16138
		if( form.GroupBreachWarningFlashingText().getValue() != null && form.GroupBreachWarningFlashingText().getValue().equals(GroupBreachWarningFlashingTextEnumeration.rdoBreachWarningFlashingTextYes))
			tempVO.setBreachWarningFlashingText(YesNo.YES);
		else if( form.GroupBreachWarningFlashingText().getValue() != null && form.GroupBreachWarningFlashingText().getValue().equals(GroupBreachWarningFlashingTextEnumeration.rdoBreachWarningFlashingTextNo))
		{
			tempVO.setBreachWarningFlashingText(YesNo.NO);
			form.cmbBreachWarningFlashingTextColour().setValue(null);
		}
			
		tempVO.setBreachWarningTextColour(form.cmbBreachWarningTextColour().getValue());
		tempVO.setBreachWarningFlashingTextColour(form.cmbBreachWarningFlashingTextColour().getValue());
		tempVO.setBreachWarningBackgroundColour(form.cmbBreachWarningBackgroundColour().getValue());
		
		if( form.GroupBreachedKPIFlashingText().getValue() != null && form.GroupBreachedKPIFlashingText().getValue().equals(GroupBreachedKPIFlashingTextEnumeration.rdoBreachedKPIFlashingTextYes))
			tempVO.setBreachedKPIFlashingText(YesNo.YES);
		else if( form.GroupBreachedKPIFlashingText().getValue() != null && form.GroupBreachedKPIFlashingText().getValue().equals(GroupBreachedKPIFlashingTextEnumeration.rdoBreachedKPIFlashingTextNo))
		{
			tempVO.setBreachedKPIFlashingText(YesNo.NO);
			form.cmbBreachedKPIFlashingTextColour().setValue(null);
		}
		
		tempVO.setBreachedKPITextColour(form.cmbBreachedKPITextColour().getValue());
		tempVO.setBreachedKPIFlashingTextColour(form.cmbBreachedKPIFlashingTextColour().getValue());
		tempVO.setBreachedKPIBackgroundColour(form.cmbBreachedKPIBackgroundColour().getValue());
		
		//WDEV-16991
		tempVO.setDefaultRowColour(form.cmbDefaultRowColour().getValue());
		tempVO.setDefaultFontColour(form.cmbDefaultFontColour().getValue());
		
		form.getGlobalContext().Emergency.setTriageKPI(tempVO);
		engine.close(DialogResult.OK);
	}
	private void open()
	{
		prePopulateBreachColorCmb();
		prePopulateBreachedColorCmb();
		prePopulateDefaultColorCmb();//WDEV-16991
		
		clearInstanceControls();
		if(form.getGlobalContext().Emergency.getTriageKPIIsNotNull())
		{
		
			TriageKPIUnboundDBVo tempVO = form.getGlobalContext().Emergency.getTriageKPI();
			form.intBreachWaring().setValue(tempVO.getBreachWarning());
			form.intBreachedKPI().setValue(tempVO.getBreachedKPI());
			//form.cmbBreach().setValue(tempVO.getBreachColor());
			//form.cmbBreached().setValue(tempVO.getBreachedColor());
			//wdev-16138
			
			form.GroupBreachWarningFlashingText().setValue(tempVO.getBreachWarningFlashingTextIsNotNull() ? ( tempVO.getBreachWarningFlashingText().equals(YesNo.YES) ? GroupBreachWarningFlashingTextEnumeration.rdoBreachWarningFlashingTextYes : GroupBreachWarningFlashingTextEnumeration.rdoBreachWarningFlashingTextNo) : GroupBreachWarningFlashingTextEnumeration.rdoBreachWarningFlashingTextNo );
			form.cmbBreachWarningTextColour().setValue(tempVO.getBreachWarningTextColour());
			form.cmbBreachWarningFlashingTextColour().setValue(tempVO.getBreachWarningFlashingTextColour());
			form.cmbBreachWarningBackgroundColour().setValue(tempVO.getBreachWarningBackgroundColour());
			radioButtonGroupBreachWarningFlashingTextValueChanged();
		
			form.GroupBreachedKPIFlashingText().setValue(tempVO.getBreachedKPIFlashingTextIsNotNull() ? ( tempVO.getBreachedKPIFlashingText().equals(YesNo.YES) ? GroupBreachedKPIFlashingTextEnumeration.rdoBreachedKPIFlashingTextYes : GroupBreachedKPIFlashingTextEnumeration.rdoBreachedKPIFlashingTextNo)  : GroupBreachedKPIFlashingTextEnumeration.rdoBreachedKPIFlashingTextNo);
			form.cmbBreachedKPITextColour().setValue(tempVO.getBreachedKPITextColour());			
			form.cmbBreachedKPIFlashingTextColour().setValue(tempVO.getBreachedKPIFlashingTextColour());
			form.cmbBreachedKPIBackgroundColour().setValue(tempVO.getBreachedKPIBackgroundColour());
			radioButtonGroupBreachedKPIFlashingTextValueChanged();
			//-------
			
			form.intBreachedKPI().setRequired(false);
			//form.cmbBreached().setRequired(false);
			if(tempVO.getTypeRowIsNotNull())
			{
				if(tempVO.getTypeRow().equals(ROW_PRIORITY1) || tempVO.getTypeRow().equals(ROW_PRIORITY2) || tempVO.getTypeRow().equals(ROW_PRIORITY3) || tempVO.getTypeRow().equals(ROW_PRIORITY4) || tempVO.getTypeRow().equals(ROW_PRIORITY5) || tempVO.getTypeRow().equals(ROW_SKIPPEDTRIAGE))
				{
					form.intBreachedKPI().setRequired(true);
					form.intBreachWaring().setRequired(true);
					//form.cmbBreached().setRequired(true);
				}
				
			}
			
			//WDEV-16991
			form.cmbDefaultFontColour().setValue(tempVO.getDefaultFontColour());
			form.cmbDefaultRowColour().setValue(tempVO.getDefaultRowColour());
		}
	}
	private void prePopulateBreachColorCmb()
	{
		Color[] ca = Color.getAllColors();
		for (int i = 0; i < ca.length; i++)
		{
			//form.cmbBreach().newRow(ca[i], ca[i].getName(), ca[i].getImage());
			form.cmbBreachWarningTextColour().newRow(ca[i], ca[i].getName(), ca[i].getImage());			//wdev-16138
			form.cmbBreachWarningFlashingTextColour().newRow(ca[i], ca[i].getName(), ca[i].getImage());
			form.cmbBreachWarningBackgroundColour().newRow(ca[i], ca[i].getName(), ca[i].getImage());
		}
	}
	private void prePopulateBreachedColorCmb()
	{
		Color[] ca = Color.getAllColors();
		for (int i = 0; i < ca.length; i++)
		{
			//form.cmbBreached().newRow(ca[i], ca[i].getName(), ca[i].getImage());
			form.cmbBreachedKPITextColour().newRow(ca[i], ca[i].getName(), ca[i].getImage());			//wdev-16138
			form.cmbBreachedKPIFlashingTextColour().newRow(ca[i], ca[i].getName(), ca[i].getImage());
			form.cmbBreachedKPIBackgroundColour().newRow(ca[i], ca[i].getName(), ca[i].getImage());
		}
	}
	
	//WDEV-16991
	private void prePopulateDefaultColorCmb()
	{
		Color[] ca = Color.getAllColors();
		for (int i = 0; i < ca.length; i++)
		{
			form.cmbDefaultFontColour().newRow(ca[i], ca[i].getName(), ca[i].getImage());	
			form.cmbDefaultRowColour().newRow(ca[i], ca[i].getName(), ca[i].getImage());	
		}
	}
	private void clearInstanceControls()
	{
		form.intBreachWaring().setValue(null);
		form.intBreachedKPI().setValue(null);
		//form.cmbBreach().setValue(null);
		//form.cmbBreached().setValue(null);
	}

	//wdev-16138
	protected void onRadioButtonGroupBreachedKPIFlashingTextValueChanged() throws PresentationLogicException
	{
		radioButtonGroupBreachedKPIFlashingTextValueChanged();
	}
	private void radioButtonGroupBreachedKPIFlashingTextValueChanged()
	{
		TriageKPIUnboundDBVo tempVO = form.getGlobalContext().Emergency.getTriageKPI();
		if( tempVO != null )
		{
    		if(tempVO.getTypeRow().equals(ROW_PRIORITY1) || tempVO.getTypeRow().equals(ROW_PRIORITY2) || tempVO.getTypeRow().equals(ROW_PRIORITY3) || tempVO.getTypeRow().equals(ROW_PRIORITY4) || tempVO.getTypeRow().equals(ROW_PRIORITY5) || tempVO.getTypeRow().equals(ROW_SKIPPEDTRIAGE))
    		{
    			if( form.GroupBreachedKPIFlashingText().getValue() != null && form.GroupBreachedKPIFlashingText().getValue().equals(GroupBreachedKPIFlashingTextEnumeration.rdoBreachedKPIFlashingTextYes))
    			{
    				form.cmbBreachedKPIFlashingTextColour().setRequired(true);
    				form.cmbBreachedKPIBackgroundColour().setRequired(true);
    			}
    			else
    			{
    				form.cmbBreachedKPIFlashingTextColour().setRequired(false);
    				form.cmbBreachedKPIBackgroundColour().setRequired(false);
    			}
    				
    			form.cmbBreachedKPITextColour().setRequired(true);
    		}
		}
		if( form.GroupBreachedKPIFlashingText().getValue() != null && form.GroupBreachedKPIFlashingText().getValue().equals(GroupBreachedKPIFlashingTextEnumeration.rdoBreachedKPIFlashingTextYes))
		{
			form.lblBreachedKPITextColour().setVisible(true);
			form.cmbBreachedKPITextColour().setVisible(true);
			form.lblBreachedKPIFlashingTextColour().setVisible(true);
			form.cmbBreachedKPIFlashingTextColour().setVisible(true);
			form.lblBreachedKPIBackgroundColour().setVisible(true);
			form.cmbBreachedKPIBackgroundColour().setVisible(true);
		}
		else
		{
			form.lblBreachedKPITextColour().setVisible(true);
			form.cmbBreachedKPITextColour().setVisible(true);
			form.lblBreachedKPIFlashingTextColour().setVisible(false);
			form.cmbBreachedKPIFlashingTextColour().setVisible(false);
			form.lblBreachedKPIBackgroundColour().setVisible(true);
			form.cmbBreachedKPIBackgroundColour().setVisible(true);
			
		}

	}

	//wdev-16138
	protected void onRadioButtonGroupBreachWarningFlashingTextValueChanged() throws PresentationLogicException
	{
		
		radioButtonGroupBreachWarningFlashingTextValueChanged();
	}
	private void radioButtonGroupBreachWarningFlashingTextValueChanged()
	{
		TriageKPIUnboundDBVo tempVO = form.getGlobalContext().Emergency.getTriageKPI();
		if( tempVO != null )
		{
    		if(tempVO.getTypeRow().equals(ROW_PRIORITY1) || tempVO.getTypeRow().equals(ROW_PRIORITY2) || tempVO.getTypeRow().equals(ROW_PRIORITY3) || tempVO.getTypeRow().equals(ROW_PRIORITY4) || tempVO.getTypeRow().equals(ROW_PRIORITY5)  || tempVO.getTypeRow().equals(ROW_SKIPPEDTRIAGE))
    		{
    			if( form.GroupBreachWarningFlashingText().getValue() != null && form.GroupBreachWarningFlashingText().getValue().equals(GroupBreachWarningFlashingTextEnumeration.rdoBreachWarningFlashingTextYes))
    			{
    				form.cmbBreachWarningFlashingTextColour().setRequired(true);
    				form.cmbBreachWarningBackgroundColour().setRequired(true);
    			}
    			else
    			{
    				form.cmbBreachWarningFlashingTextColour().setRequired(false);
    				form.cmbBreachWarningBackgroundColour().setRequired(false);
    			}
    				
    			form.cmbBreachWarningTextColour().setRequired(true);
    		}
		}
    	if( form.GroupBreachWarningFlashingText().getValue() != null && form.GroupBreachWarningFlashingText().getValue().equals(GroupBreachWarningFlashingTextEnumeration.rdoBreachWarningFlashingTextYes))
    	{
    		form.lblBreachWarningTextColour().setVisible(true);
    		form.cmbBreachWarningTextColour().setVisible(true);
    		form.lblBreachWarningFlashingTextColour().setVisible(true);
    		form.cmbBreachWarningFlashingTextColour().setVisible(true);
    		form.lblBreachWarningBackgroundColour().setVisible(true);
    		form.cmbBreachWarningBackgroundColour().setVisible(true);
    	}
    	else
    	{
    		form.lblBreachWarningTextColour().setVisible(true);
			form.cmbBreachWarningTextColour().setVisible(true);
			form.lblBreachWarningFlashingTextColour().setVisible(false);
			form.cmbBreachWarningFlashingTextColour().setVisible(false);
			form.lblBreachWarningBackgroundColour().setVisible(true);
			form.cmbBreachWarningBackgroundColour().setVisible(true);
    	}
    			
    		
	}
}
