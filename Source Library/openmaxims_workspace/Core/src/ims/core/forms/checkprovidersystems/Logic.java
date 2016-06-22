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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.71 build 3909.24643)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.core.forms.checkprovidersystems;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import ca.uhn.hl7v2.llp.HL7Reader;
import ca.uhn.hl7v2.llp.HL7Writer;
import ca.uhn.hl7v2.llp.MinLLPReader;
import ca.uhn.hl7v2.llp.MinLLPWriter;

import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.ocrr.vo.ProviderSystemVo;
import ims.ocrr.vo.ProviderSystemVoCollection;
import ims.vo.interfaces.IHL7Query;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize(args);
		updateControlsState();
	}
	
	private void updateControlsState()
	{
		form.btnSend().setEnabled(form.txtMessage().getValue() != null && form.txtMessage().getValue().length() > 0 && form.cmbProviderSystem().getValue() instanceof ProviderSystemVo);
		form.btnTest().setEnabled(form.cmbProviderSystem().getValue() instanceof ProviderSystemVo);
		form.txtHost().setTooltip(form.txtHost().getValue() != null ? form.txtHost().getValue(): "Please enter the Provider System Name"); //WDEV-16213
	}

	private void initialize(Object[] args)
	{
		bindCmbProviderSystem();
		
		if (args != null && args.length > 0)
		{
			Object msg = args[0];
			
			if(msg instanceof IHL7Query)
			{
				form.txtMessage().setValue(((IHL7Query)msg).getIHL7Message());
				form.cmbProviderSystem().setValue(((IHL7Query)msg).getIProviderSystem());
			}
			
			populateProviderSystem();
		}
	}

	private void bindCmbProviderSystem()
	{
		ProviderSystemVoCollection providerSystems = domain.listProviderSystems();
		
		if (providerSystems != null)
		{
			for (ProviderSystemVo providerSystemVo : providerSystems)
			{
				form.cmbProviderSystem().newRow(providerSystemVo, providerSystemVo.getSystemName());
			}
		}
	}
	
	@Override
	protected void onBtnTestClick() throws ims.framework.exceptions.PresentationLogicException
	{
		String[] errors = validateTestConnection();
		
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return;
		}
		
		testConnection(form.txtHost().getValue(), form.intPort().getValue());
	}

	private String[] validateTestConnection()
	{
		List<String> uiErrors = new ArrayList<String>();
		
		if(form.txtHost().getValue() == null || form.txtHost().getValue().length() == 0)
		{
			uiErrors.add("Selected provider system doesn't have an IP Address/Host specified.");		
		}
		
		if(form.intPort().getValue() == null)
		{
			uiErrors.add("Selected provider system doesn't have a port number specified.");
		}
		
		String[] uiResults = new String[uiErrors.size()];
		uiErrors.toArray(uiResults);
		
		return uiResults;
	}

	private void testConnection(String host, Integer port)
	{
		Socket sock;
		try
		{
			sock = new Socket(host, port.intValue());
			sock.close();
		}
		catch (UnknownHostException e)
		{
			engine.showMessage("Connection test failed.");	
			return;
		}
		catch (IOException e)
		{
			engine.showMessage("Connection test failed.");
			return;
		}
		
		engine.showMessage("Connection test succeeded.");	
	}

	@Override
	protected void onCmbProviderSystemValueChanged() throws PresentationLogicException
	{
		populateProviderSystem();
		
		updateControlsState();
	}

	private void populateProviderSystem()
	{
		ProviderSystemVo selectedProviderSystem = form.cmbProviderSystem().getValue();
		
		if(selectedProviderSystem instanceof ProviderSystemVo)
		{
			form.txtHost().setValue(selectedProviderSystem.getIPAddress());
			form.intPort().setValue(selectedProviderSystem.getIPPort());
		}
	}

	@Override
	protected void onBtnCancelClick() throws PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onBtnSendClick() throws PresentationLogicException
	{
		sendMessage();
	}

	private void sendMessage()
	{
		String msgTxt = form.txtMessage().getValue();
		String resp = null;
		
		try
		{
			Socket sock = new Socket(form.txtHost().getValue(), form.intPort().getValue().intValue());

			msgTxt = msgTxt.replaceAll("\n", "\r");

			HL7Writer writer = new MinLLPWriter(sock.getOutputStream());
			HL7Reader reader = new MinLLPReader(sock.getInputStream());
			
			writer.writeMessage(msgTxt);
			resp = reader.getMessage();
			
			reader.close();
			writer.close();
			sock.close();
			
			form.txtResponse().setValue(resp);
		}
		catch (Exception e)
		{
			form.txtResponse().setValue(e.getClass().getName() + " occurred. Exception message was " + e.getMessage());
		}
	}
}
