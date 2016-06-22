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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4828.20158)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.eddischargedetailstasksettings;

import ims.configuration.gen.ConfigFlag;
import ims.emergency.vo.EDDischargeSummaryScheduleVo;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.IDynamicFormDataOperations;

import java.util.ArrayList;

import com.ims.query.builder.client.PrinterAvailableCollection;
import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

public class Logic extends BaseLogic implements IDynamicFormDataOperations 
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
		loadData();
		updateControlsState();
	}

	private void initialise() 
	{
		loadPrinterList();
	}
	
	private void loadPrinterList()
	{
		form.cmbPrint().clear();		
		QueryBuilderClient qbc = new QueryBuilderClient(ConfigFlag.GEN.QUERY_SERVER_URL.getValue(), engine.getSessionId());

		try
		{
			PrinterAvailableCollection printers = qbc.listPrinters(ConfigFlag.GEN.REPORT_SERVER_URL.getValue());
			String[] printersColl = new String[printers.size()];

			for (int i = 0; i < printers.size(); i++)
			{
				form.cmbPrint().newRow(printers.get(i).getName(), printers.get(i).getName());
				printersColl[i] = printers.get(i).getName();
			}
		}
		catch (QueryBuilderClientException e)
		{
			engine.showMessage("Error getting the printers list: " + e.toString());
			return;
		}
	}

	public void loadData() 
	{
		EDDischargeSummaryScheduleVo record = domain.getConfiguration(form.getGlobalContext().Admin.getCurrentJobConfiguration());
		form.getLocalContext().setRecord(record);
		populateScreenFromData(record);
	}

	private void populateScreenFromData(EDDischargeSummaryScheduleVo record) 
	{
		clear();
		
		if(record == null)
			return;

		form.cmbPrint().setValue(record.getPrintAgentTo());
		if (!Boolean.TRUE.equals(record.getPrintLettersOnly()))
		{	
			form.intFailedEmailsNo().setValue(record.getFailedEmailsNo());
			form.intSuccessfulEmailsNo().setValue(record.getSuccessfulEmailsNo());
		}
		form.intGeneratedLettersNo().setValue(record.getGeneratedLettersNo());
		form.intPrintedLettersNo().setValue(record.getPrintedLettersNo());
		form.chkDisableEmail().setValue(record.getPrintLettersOnly());
		form.lblPrinter().setValue(Boolean.TRUE.equals(record.getPrintLettersOnly()) ? "Print all discharge summary reports to:" : "For GPs without e-mail, print the discharge summary report to:");
	}
	
	private void clear() 
	{
		form.cmbPrint().setValue(null);
		form.chkDisableEmail().setValue(false);
		
		form.intFailedEmailsNo().setValue(null);
		form.intGeneratedLettersNo().setValue(null);
		form.intPrintedLettersNo().setValue(null);
		form.intSuccessfulEmailsNo().setValue(null);
	}

	public void saveData() throws Exception 
	{
		EDDischargeSummaryScheduleVo record  = getData();
		
		String[] errors = record.validate(getUIErrors());
		if(errors != null && errors.length > 0)
			throw new Exception("Validation Errors");
		
		domain.saveConfiguration(record);
	}

	public EDDischargeSummaryScheduleVo getData() 
	{
		EDDischargeSummaryScheduleVo record = populateDataFromScreen(form.getLocalContext().getRecord());
		record.setConfiguredJobDetails(form.getGlobalContext().Admin.getCurrentJobConfiguration());
		
		return record;
	}
	
	public String[] validateData() 
	{
		return getData().validate(getUIErrors());
	}

	private String[] getUIErrors() 
	{
		ArrayList<String> errors = new ArrayList<String>();
		if (form.cmbPrint().getValue() ==null)
		{
			errors.add("Printer is mandatory!");
		}
		
		if (errors.size() > 0) 
		{
			String[] searchErrors = new String[errors.size()];
			errors.toArray(searchErrors);
			engine.showErrors("Invalid EDDischargeSummarySchedule record", searchErrors);
			return searchErrors;
		}
		return null;
	}

	private EDDischargeSummaryScheduleVo populateDataFromScreen(EDDischargeSummaryScheduleVo record) 
	{
		if(record == null)
			record = new EDDischargeSummaryScheduleVo();
		
		record.setPrintAgentTo(form.cmbPrint().getValue());
		record.setPrintLettersOnly(form.chkDisableEmail().getValue());
		
		return record;
	}

	@Override
	protected void onChkDisableEmailValueChanged()	throws PresentationLogicException
	{
		form.lblPrinter().setValue(form.chkDisableEmail().getValue() ? "Print all discharge summary reports to:" : "For GPs without e-mail, print the discharge summary report to:");
		updateControlsState();
		
	}

	private void updateControlsState()
	{
		form.intSuccessfulEmailsNo().setVisible(form.getLocalContext().getRecord() == null || !Boolean.TRUE.equals(form.getLocalContext().getRecord().getPrintLettersOnly()));
		form.intFailedEmailsNo().setVisible(form.getLocalContext().getRecord() == null || !Boolean.TRUE.equals(form.getLocalContext().getRecord().getPrintLettersOnly()));
		form.lblFailedEmails().setVisible(form.getLocalContext().getRecord() == null || !Boolean.TRUE.equals(form.getLocalContext().getRecord().getPrintLettersOnly()));
		form.lblSuccessfulEmails().setVisible(form.getLocalContext().getRecord() == null || !Boolean.TRUE.equals(form.getLocalContext().getRecord().getPrintLettersOnly()));
		form.intFailedEmailsNo().setEnabled(false);
		form.intSuccessfulEmailsNo().setEnabled(false);
	}
}
