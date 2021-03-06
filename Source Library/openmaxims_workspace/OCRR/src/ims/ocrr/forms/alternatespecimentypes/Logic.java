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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.80 build 3999.26423)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.ocrr.forms.alternatespecimentypes;

import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.ocrr.forms.alternatespecimentypes.GenForm.grdListRow;
import ims.ocrr.forms.alternatespecimentypes.GenForm.grdResultSpecimenTypesRow;
import ims.ocrr.vo.ResultSpecimenTypesVo;
import ims.ocrr.vo.ResultSpecimenTypesVoCollection;
import ims.ocrr.vo.lookups.LookupHelper;
import ims.ocrr.vo.lookups.ResultSpecimenTypesCollection;
import ims.ocrr.vo.lookups.SpecimenTypeCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
		
		open();
	}

	private void initialise()
	{
		form.getContextMenus().getGenericGridUpdateItem().setText("Edit");
		loadResultSpecimenTypes();
	}
	
	private void loadResultSpecimenTypes()
	{
		form.grdResultSpecimenTypes().getRows().clear();
		ResultSpecimenTypesCollection collResTypes = LookupHelper.getResultSpecimenTypes(domain.getLookupService()); 
		
		for(int i=0;i<collResTypes.size(); i++)
		{
			grdResultSpecimenTypesRow row = form.grdResultSpecimenTypes().getRows().newRow();
			row.setColResSpecimenType(collResTypes.get(i));
		}
	}
	
	private void open()
	{
		clearInstanceControls();		
		
		form.grdList().getRows().clear();
		
		ResultSpecimenTypesVoCollection voCollResSpecTypes = domain.listResultSpecimenTypes();
		
		SpecimenTypeCollection collTypes = LookupHelper.getSpecimenType(domain.getLookupService()); 
		for(int i=0;i<collTypes.size(); i++)
		{
			grdListRow row = form.grdList().getRows().newRow();
			row.setColSpecimenType(collTypes.get(i));
			
			//if lookup is already used in persisted record set the value for the row
			if(voCollResSpecTypes != null)
			{
				for(ResultSpecimenTypesVo instance : voCollResSpecTypes)
				{
					if(instance.getSpecimenType().equals(collTypes.get(i)))
						row.setValue(instance);
				}
			}
		}
		
		form.setMode(FormMode.VIEW);
	}
	@Override
	protected void onGrdListSelectionChanged()
	{
		populateScreenFromData(form.grdList().getValue());
		updateControlState();
	}
	
	private void populateScreenFromData(ResultSpecimenTypesVo value)
	{
		clearInstanceControls();		
		
		if(value == null)
			return;
		
		if(value.getAlternateSpecimenTypesIsNotNull())
		{
			for(int i=0;i<value.getAlternateSpecimenTypes().size(); i++)
			{
				for(int p=0;p<form.grdResultSpecimenTypes().getRows().size();p++)
				{
					grdResultSpecimenTypesRow row = form.grdResultSpecimenTypes().getRows().get(p);
					if(row.getColResSpecimenType().equals(value.getAlternateSpecimenTypes().get(i)))
						row.setColSelect(true);
				}
			}
		}
		
	}
	
	private void clearInstanceControls()
	{
		for(int i=0;i<form.grdResultSpecimenTypes().getRows().size();i++)
		{
			grdResultSpecimenTypesRow row = form.grdResultSpecimenTypes().getRows().get(i);
			row.setColSelect(false);
		}
	}
	
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			open();
	}
	
	private boolean save()
	{
		ResultSpecimenTypesVo voResSpecType = populateDataFromScreen(form.grdList().getSelectedRow());
	
		//to delete record when config is cleared
		if(voResSpecType.getAlternateSpecimenTypesIsNotNull() && voResSpecType.getAlternateSpecimenTypes().size() == 0 && voResSpecType.getID_ResultSpecimenTypes() != null)
		{
			try
			{
				domain.deleteResultSpecimenType(voResSpecType);
			}
			catch (ForeignKeyViolationException e)
			{
				engine.showMessage("Delete Failed " + e.getMessage());
				return false;
			}
			return true;
		}
		
		String[] arrErrors = voResSpecType.validate();
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		try
		{
			domain.saveResultSpecimenType(voResSpecType);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return false;
		}
	
		return true;
	}

	private ResultSpecimenTypesVo populateDataFromScreen(ims.ocrr.forms.alternatespecimentypes.GenForm.grdListRow row)
	{
		ResultSpecimenTypesVo voResultSpecType = row.getValue();
		if(voResultSpecType == null)
			voResultSpecType = new ResultSpecimenTypesVo();
		
		voResultSpecType.setSpecimenType(row.getColSpecimenType());
		voResultSpecType.setAlternateSpecimenTypes(new ResultSpecimenTypesCollection());
		
		for(int i=0;i<form.grdResultSpecimenTypes().getRows().size();i++)
		{
			grdResultSpecimenTypesRow rsRow = form.grdResultSpecimenTypes().getRows().get(i);
			if(rsRow.getColSelect())
				voResultSpecType.getAlternateSpecimenTypes().add(rsRow.getColResSpecimenType());
		}
		
		return voResultSpecType;
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlState();	
	}

	private void updateControlState()
	{
		if(form.getMode().equals(FormMode.VIEW))
		{
			form.btnEdit().setVisible(true);
			
			form.btnEdit().setEnabled(form.grdList().getSelectedRow() != null);
			
			form.getContextMenus().getGenericGridUpdateItem().setVisible(form.grdList().getSelectedRow() != null);
		}
		else if(form.getMode().equals(FormMode.EDIT))
			form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
			
	}
}
