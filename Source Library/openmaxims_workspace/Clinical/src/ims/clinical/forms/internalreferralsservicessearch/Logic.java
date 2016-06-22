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

package ims.clinical.forms.internalreferralsservicessearch;

import ims.clinical.forms.internalreferralsservicessearch.GenForm.grdServicesRow;
import ims.clinical.vo.ServiceConfigIntReferralForIncomingListVo;
import ims.clinical.vo.ServiceConfigIntReferralForIncomingListVoCollection;
import ims.clinical.vo.ServiceForIncomingReferralListVo;
import ims.clinical.vo.ServiceForIncomingReferralListVoCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise(args);
		open();
	}
	
	private void open() 
	{
		if(Boolean.TRUE.equals(form.getLocalContext().getListConfigServices()))
			populateServiceGrid(domain.listServiceConfigs());
		else
			populateServiceGrid(domain.listServices());
		
		updateControlsState();
	}

	private void initialise(Object[] args) 
	{
		boolean listConfigServices = false;
		
		if(args != null && args.length > 0)
		{
			if(Boolean.TRUE.equals(args[0]))
			{
				listConfigServices = true;
			}
		}
		
		form.getLocalContext().setListConfigServices(listConfigServices);
	}

	private void populateServiceGrid(ServiceForIncomingReferralListVoCollection listServices) 
	{
		form.grdServices().getRows().clear();
		
		if(listServices == null)
			return;
			
		for(ServiceForIncomingReferralListVo service : listServices)
		{
			if(service == null)
				continue;
			
			grdServicesRow row = form.grdServices().getRows().newRow();
			row.setColService(service.getServiceName());
			row.setValue(service);
			
			if(form.getGlobalContext().Clinical.getServiceSearchList() != null && form.getGlobalContext().Clinical.getServiceSearchList().contains(service))
				row.setColSelect(true);
		}
	}

	private void populateServiceGrid(ServiceConfigIntReferralForIncomingListVoCollection listServiceConfigs) 
	{
		form.grdServices().getRows().clear();
		
		if(listServiceConfigs == null)
			return;
			
		for(ServiceConfigIntReferralForIncomingListVo serviceConf : listServiceConfigs)
		{
			if(serviceConf == null)
				continue;
			
			grdServicesRow row = form.grdServices().getRows().newRow();
			row.setColService(serviceConf.getService().getServiceName());
			row.setValue(serviceConf);
			
			if(form.getGlobalContext().Clinical.getServiceConfigSearchList() != null && form.getGlobalContext().Clinical.getServiceConfigSearchList().contains(serviceConf))
				row.setColSelect(true);
		}
	}

	@Override
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(Boolean.TRUE.equals(form.getLocalContext().getListConfigServices()))
		{
			form.getGlobalContext().Clinical.setServiceConfigSearchList(getConfigServices());
		}
		else
		{
			form.getGlobalContext().Clinical.setServiceSearchList(getServices());
		}
		
		engine.close(DialogResult.OK);
	}
	
	private ServiceForIncomingReferralListVoCollection getServices() 
	{
		ServiceForIncomingReferralListVoCollection coll = new ServiceForIncomingReferralListVoCollection();
		
		for(int i=0; i<form.grdServices().getRows().size(); i++)
		{
			if(Boolean.TRUE.equals(form.grdServices().getRows().get(i).getColSelect()) && form.grdServices().getRows().get(i).getValue() instanceof ServiceForIncomingReferralListVo)
			{
				coll.add((ServiceForIncomingReferralListVo) form.grdServices().getRows().get(i).getValue());
			}
		}
		
		return coll;
	}

	private ServiceConfigIntReferralForIncomingListVoCollection getConfigServices() 
	{
		ServiceConfigIntReferralForIncomingListVoCollection coll = new ServiceConfigIntReferralForIncomingListVoCollection();
		
		for(int i=0; i<form.grdServices().getRows().size(); i++)
		{
			if(Boolean.TRUE.equals(form.grdServices().getRows().get(i).getColSelect()) && form.grdServices().getRows().get(i).getValue() instanceof ServiceConfigIntReferralForIncomingListVo)
			{
				coll.add((ServiceConfigIntReferralForIncomingListVo) form.grdServices().getRows().get(i).getValue());
			}
		}
		
		return coll;
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onGrdServicesGridCheckBoxClicked(int column,	grdServicesRow row, boolean isChecked)	throws PresentationLogicException 
	{
		updateControlsState();
	}

	private void updateControlsState() 
	{
		form.btnOk().setVisible(isAtLeastOneRowSelected());
	}

	private boolean isAtLeastOneRowSelected() 
	{
		for(int i = 0; i<form.grdServices().getRows().size(); i++)
		{
			if(Boolean.TRUE.equals(form.grdServices().getRows().get(i).getColSelect()))
				return true;
		}
		
		return false;
	}
}
