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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.removeintraopcasetimesdialog;

import ims.clinical.forms.removeintraopcasetimesdialog.GenForm.grdRemoveItemsRow;
import ims.clinical.helper.TheatreCaseTimeHelper;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		if(args != null && args.length == 1)
		{
			form.getLocalContext().setRemovableTimes( (Map<Integer, DateTime>) args[0]);
		}
		else
			throw new CodingRuntimeException("mandatory form args missing");
			
		open();
	}
	
	/**
	 * Display options to select from the TheatreCaseTimeHelper
	 */
	private void open()
	{
		form.grdRemoveItems().getRows().clear();
		
		Map<Integer, DateTime> coll = form.getLocalContext().getRemovableTimes();
		
		Iterator<Entry<Integer, DateTime>> it = coll.entrySet().iterator();
		while(it.hasNext())
		{
			Entry<Integer, DateTime> item = it.next(); 
			if(item.getValue() != null)
			{	
				grdRemoveItemsRow row = form.grdRemoveItems().getRows().newRow();
				row.setColStage(TheatreCaseTimeHelper.getLabel(item.getKey()));
				row.setColTime(item.getValue().toString());
				row.setValue(item.getKey());
			}
		}
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		//build a list of TheatreCaseTime constant references for the times selected to remove
		List<Integer> items = new ArrayList<Integer>();
		for(int i=0;i<form.grdRemoveItems().getRows().size(); i++)
		{
			grdRemoveItemsRow row = form.grdRemoveItems().getRows().get(i);
			if(row.getColSelect())
			{
				items.add(row.getValue());
			}
		}
		
		if(items.size() > 0)
		{
			try
			{
				domain.removeTimes(items.toArray(new Integer[0]), form.getGlobalContext().Clinical.getTheatreAppointmentRef());
			}
			catch (StaleObjectException e)
			{
				String message = ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue();
				message.replace("refreshed", "closed");
				engine.showMessage(message);
			}
		}
		else
		{
			engine.showMessage("Please Select at least one time to remove");
			return;
		}
		
		engine.close(DialogResult.OK);
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
}
