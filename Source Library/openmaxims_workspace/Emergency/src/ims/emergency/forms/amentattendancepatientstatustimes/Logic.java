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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5127.24028)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.amentattendancepatientstatustimes;

import java.util.ArrayList;
import java.util.List;

import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.vo.TrackingAttendanceStatusForEventHistoryVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.utils.DateTime;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	private void open()
	{
		form.getLocalContext().setCurrentRecord(domain.getStatus(form.getGlobalContext().Emergency.getAmendAttendancePatientStatusTimes()));
		
		if(form.getLocalContext().getCurrentRecord() == null)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
		}
		
		populateScreenFromData(form.getLocalContext().getCurrentRecord());
	}

	private void populateScreenFromData(TrackingAttendanceStatusForEventHistoryVo currentRecord)
	{
		clearScreen();
		
		if(currentRecord == null)
			return;
		
		form.txtTrackingArea().setValue(currentRecord.getTrackingArea().getAreaDisplayName());
		form.txtPatientStatus().setValue(currentRecord.getStatus().getText());
		form.dtimStatus().setValue(currentRecord.getStatusDatetime());
	}

	private void clearScreen()
	{
		form.txtTrackingArea().setValue(null);
		form.txtPatientStatus().setValue(null);
		form.dtimStatus().setValue(null);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			engine.close(DialogResult.OK);
	}

	private boolean save()
	{
		TrackingAttendanceStatusForEventHistoryVo record = populateDataFromScreen(form.getLocalContext().getCurrentRecord());
		
		String[] errors = validateUIRules();
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		errors = record.validate();
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try
		{
			domain.save(record);
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
			return false;
		}
		
		return true;
	}

	private String[] validateUIRules()
	{
		List<String> uiErrors = new ArrayList<String>();
		DateTime registrationDateTime = form.getGlobalContext().Emergency.getEmergencyAttendanceForTimeAmendments().getRegistrationDateTime();
		DateTime dischargeDatetime = form.getGlobalContext().Emergency.getEmergencyAttendanceForTimeAmendments().getDischargeDateTime();
		
		if(form.dtimStatus().isEnabled() && form.dtimStatus().getValue() == null)
		{
			uiErrors.add("Status Time is mandatory.");
		}
		
		if (form.dtimStatus().getValue() != null && form.dtimStatus().getValue().isGreaterThan(new DateTime()))
		{
			uiErrors.add("Status Time cannot be set in the future.");
		}
		
		if (form.dtimStatus().getValue() != null && registrationDateTime != null && form.dtimStatus().getValue().isLessThan(registrationDateTime))
		{
			uiErrors.add("Status Time cannot be less than Registration Start Time.");
		}
		if(form.dtimStatus().getValue() != null && dischargeDatetime != null && form.dtimStatus().getValue().isGreaterThan(dischargeDatetime))
		{
			uiErrors.add("Status Time cannot be greater than Departed Date/Time.");
		}
		
		String[] uiResults = new String[uiErrors.size()];
		uiErrors.toArray(uiResults);
		
		return uiResults;
	}

	private TrackingAttendanceStatusForEventHistoryVo populateDataFromScreen(TrackingAttendanceStatusForEventHistoryVo currentRecord)
	{
		if(currentRecord == null)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
		}
		
		currentRecord.setStatusDatetime(form.dtimStatus().getValue());
		
		return currentRecord;
	}
}
