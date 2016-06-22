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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.

package ims.core.forms.fullsdstasksettings;

import ims.core.vo.FullSDSBatchVo;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.IDynamicFormDataOperations;

public class Logic extends BaseLogic implements IDynamicFormDataOperations
{
	private static final long serialVersionUID = 1L;

	public String[] validateData()
	{
		return getData().validate(getUIErrors());
	}

	public void saveData() throws Exception
	{
		FullSDSBatchVo record  = getData();
		
		String[] errors = record.validate(getUIErrors());
		if(errors != null && errors.length > 0)
			throw new Exception("Validation Errors");
		
		domain.save(record);
	}

	private String[] getUIErrors()
	{
		return null;
	}

	public FullSDSBatchVo getData()
	{
		FullSDSBatchVo record = populateDataFromScreen(form.getLocalContext().getCurrentRecord());
		record.setConfiguredJobDetails(form.getGlobalContext().Admin.getCurrentJobConfiguration());
		
		return record;
	}

	private FullSDSBatchVo populateDataFromScreen(FullSDSBatchVo currentRecord)
	{
		if (currentRecord == null)
			currentRecord = new FullSDSBatchVo();
		
		currentRecord.setProcessedGPRequestsNo(form.intGPs().getValue());
		currentRecord.setSuccessfulGPRequestsUpdatedNo(form.intSGPs().getValue());
		currentRecord.setProcessedPracticeRequestsNo(form.intPractices().getValue());
		currentRecord.setSuccessfulPracticeRequestsUpdatedNo(form.intSPractices().getValue());
		
		return currentRecord;
	}

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		loadData();
	}

	private void loadData()
	{
		FullSDSBatchVo record = domain.get(form.getGlobalContext().Admin.getCurrentJobConfiguration());
		form.getLocalContext().setCurrentRecord(record);
		
		populateScreenFromData(record);
	}

	private void populateScreenFromData(FullSDSBatchVo record)
	{
		clear();
		
		if(record == null)
			return;
		
		form.intGPs().setValue(record.getProcessedGPRequestsNo());
		form.intSGPs().setValue(record.getSuccessfulGPRequestsUpdatedNo());
		form.intPractices().setValue(record.getProcessedPracticeRequestsNo());
		form.intSPractices().setValue(record.getSuccessfulPracticeRequestsUpdatedNo());
	}

	private void clear()
	{
		form.intGPs().setValue(null);
		form.intSGPs().setValue(null);
		form.intPractices().setValue(null);
		form.intSPractices().setValue(null);
	}
}
