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

package ims.core.forms.printpatientdocument;

import ims.configuration.gen.ConfigFlag;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.PrinterScope;
import ims.framework.interfaces.ILocation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
	}
	
	private void initialise()
	{
		ILocation locs = domain.getCurrentLocation();
		form.lblHospital().setValue(locs != null ? locs.getName() : "No location selected");

		form.ccPrinter().initialize(locs, PrinterScope.DEFAULT);
		form.ccPrinter().setIsRequired(true);
		form.intNumberOfCopies().setValue(1);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onBtnPrintClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(validateReportConfigFlags())
		{
			if(printDocument())
				engine.close(DialogResult.OK);
		}
	}
	
	private String[] validateUIRules()
	{
		ArrayList<String> loE = new ArrayList<String>();

		if (form.ccPrinter().getSelectedPrinter() == null)
			loE.add("Please select a printer.");
		
		if (form.intNumberOfCopies().getValue() == null)
		{
			loE.add("Number of Copies is mandatory.");
		}
			
		if (form.intNumberOfCopies().getValue() != null && form.intNumberOfCopies().getValue() ==0)
		{
			loE.add("Number of Copies must be greater than zero.");
		}
		
		if (loE.size() == 0)
			return null;
		
		String[] result = new String[loE.size()];
		loE.toArray(result);
		
		return result;
	}
	
	private boolean validateReportConfigFlags() 
	{
		String queryServerUrl = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String reportServerUrl = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
		
		ArrayList<String> errors = new ArrayList<String>();
		
		if(queryServerUrl == null || queryServerUrl.length() == 0 || queryServerUrl.equals(ConfigFlag.GEN.QUERY_SERVER_URL.getDefaultValue()))
		{
			errors.add("The config flag QUERY_SERVER_URL is not set!");
		}
		
		if(reportServerUrl == null || reportServerUrl.length() == 0 || reportServerUrl.equals(ConfigFlag.GEN.REPORT_SERVER_URL.getDefaultValue()))
		{
			errors.add("The config flag REPORT_SERVER_URL is not set !");
		}
		
		if(errors.size() == 0)
			return true;
		
		engine.showMessage(getErrors(errors.toArray(new String[errors.size()])), "Errors", MessageButtons.OK, MessageIcon.ERROR);
		
		return false;
	}
	
	private String getErrors(String[] uiErrors) 
	{
		if(uiErrors == null || uiErrors.length == 0)
			return "";
		
		String errors = "";
		
		for(int i=0; i<uiErrors.length; i++)
		{
			if(uiErrors[i] == null)
				continue;
			
			errors += uiErrors[i] + "\n";
		}
		
		return errors;
	}

	private boolean printDocument()
	{
		String[] errors = validateUIRules();
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
		QueryBuilderClient cl = new QueryBuilderClient(urlQueryServer, engine.getSessionId());
			
		String fileName = form.getGlobalContext().Core.getPatientDocumentToPrint().getServerDocument().getFileName();

		try
		{
			cl.printReport(readFile(getFilePath(fileName)), urlReportServer, form.ccPrinter().getSelectedPrinter().getIPrinterName(), form.intNumberOfCopies().getValue());
		}
		catch (QueryBuilderClientException e)
		{
			e.printStackTrace();
			engine.showMessage(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	private String getFilePath(String fileName)
	{
		return getPDFStorePath() + fileName;
	}	
	
	private String getPDFStorePath()
	{
		String storePath = ConfigFlag.GEN.PDF_STORE_PATH.getValue();
		
		if(!(storePath.endsWith("/") || storePath.endsWith("\\")))
			storePath = storePath + "/";
				
		return storePath;
	}
	
	private byte[] readFile(String filePath)
	{
		File pdf = new File(filePath);
		long size = pdf.length();

		if (size == 0)
		{
			return null;
		}

		FileInputStream fileInputStream = null;
		byte[] buffer = null;

		try
		{
			fileInputStream = new FileInputStream(pdf);
			int bytesAvailable = fileInputStream.available();
			int maxBufferSize = (int) size;
			int bufferSize = Math.min(bytesAvailable, maxBufferSize);
			buffer = new byte[bufferSize];
			int bytesRead = fileInputStream.read(buffer, 0, bufferSize);
			while (bytesRead > 0)
			{
				bytesAvailable = fileInputStream.available();
				bufferSize = Math.min(bytesAvailable, maxBufferSize);
				bytesRead = fileInputStream.read(buffer, 0, bufferSize);
			}

		}
		catch (IOException e)
		{
			buffer = null;
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fileInputStream.close();
			}
			catch (IOException e)
			{

			}
		}

		return buffer;
	}
}
