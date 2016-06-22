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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4847.21738)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.ocrr.forms.viewpacsimagesdialog;

import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.ocrr.forms.viewpacsimagesdialog.GenForm.grdInvestigationsRow;
import ims.ocrr.vo.OrderInvestigationListVo;
import ims.ocrr.vo.OrderInvestigationListVoCollection;
import ims.ocrr.vo.lookups.Category;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	
	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{
		OrderInvestigationListVoCollection ordInvVoColl = null;
		if( args != null && args.length > 0 && args[0] instanceof OrderInvestigationListVoCollection )
		{
			ordInvVoColl = (OrderInvestigationListVoCollection) args[0];
		}
		populategrdInvestigations(ordInvVoColl);
	}
	private void populategrdInvestigations(OrderInvestigationListVoCollection ordInvVoColl)
	{
		if( ordInvVoColl == null || ordInvVoColl.size() == 0)
			return;
		for(int i = 0; i < ordInvVoColl.size();i++)
		{
			addtogrid(ordInvVoColl.get(i));
		}
	}
	private void addtogrid( OrderInvestigationListVo ordInvVo)
	{
		if( ordInvVo == null)
			return;
		if( ordInvVo.getInvestigation().getInvestigationIndex().getCategoryIsNotNull() && (ordInvVo.getInvestigation().getInvestigationIndex().getCategory().equals(Category.CLINICALIMAGING)) )
		{
			StringBuilder szDisplayText = new StringBuilder();
			szDisplayText.append(ordInvVo.getInvestigation().getInvestigationIndex().getName());
			
			if (ordInvVo.getRequestedLocationIsNotNull())
			{
				szDisplayText.append(" (");
				szDisplayText.append(ordInvVo.getRequestedLocation());
				szDisplayText.append(")");
			}
			
			if (ordInvVo.getOrdInvCurrentStatus() != null)
			{
				szDisplayText.append(" - Current Status: ").append(ordInvVo.getOrdInvCurrentStatus().getOrdInvStatus().getText());
			}
			
			//WDEV-16457 
			szDisplayText.append(ordInvVo.getPlacerOrdNum() != null ?  " - OCS Number: " + ordInvVo.getPlacerOrdNum() : "");
		
			grdInvestigationsRow row = form.grdInvestigations().getRows().newRow();
			row.setColumnInvestigation(szDisplayText.toString());
			row.setCellColumnInvestigationTooltip(szDisplayText.toString());
			row.setValue(ordInvVo);
		}
	}
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	protected void onGrdInvestigationsGridCheckBoxClicked(int column, GenForm.grdInvestigationsRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
	{
		
	}
	
	
	protected void onGrdInvestigationsGridButtonClicked(int column,	grdInvestigationsRow row) throws PresentationLogicException 
	{
		if( row.getValue() != null && row.getValue().getAccessionNumberIsNotNull())
		{
			form.getGlobalContext().OCRR.CentricityWebPACS.setAccessionNumber(row.getValue().getAccessionNumber());
			engine.open(form.getForms().OCRR.CentricityWebPACSViewer,true,true);
		}
		
	}

	
	
}
