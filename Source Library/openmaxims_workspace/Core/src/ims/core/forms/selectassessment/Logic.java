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
// This code was generated by Ander Telleria using IMS Development Environment (version 1.70 build 3453.13770)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.core.forms.selectassessment;

import ims.assessment.vo.GraphicAssessmentShortVo;
import ims.assessment.vo.GraphicAssessmentShortVoCollection;
import ims.assessment.vo.UserAssessmentShortVo;
import ims.assessment.vo.UserAssessmentShortVoCollection;
import ims.core.forms.selectassessment.GenForm.grdAssessmentsRow;
import ims.core.forms.selectgraphicalassessment.GenForm.grdGraphicAssessmentsRow;
import ims.framework.MessageButtons;
import ims.framework.enumerations.DialogResult;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Core.setSelectedUserAssessment(null);
		form.getGlobalContext().ICP.setLinkedItem(null);
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Core.setSelectedUserAssessment(null);
		form.getGlobalContext().ICP.setLinkedItem(null);
		
		engine.close(DialogResult.CANCEL);	
	}
	@Override
	protected void onBtnSelectClick() throws ims.framework.exceptions.PresentationLogicException
	{
		for (int i=0;i<form.grdAssessments().getRows().size();i++)
		{
			if (form.grdAssessments().getRows().get(i).getcolSelect())
			{
				form.getGlobalContext().Core.setSelectedUserAssessment(form.grdAssessments().getRows().get(i).getValue());
				form.getGlobalContext().ICP.setLinkedItem(form.grdAssessments().getRows().get(i).getValue());
				
				break;
			}
		}
		if (!form.getGlobalContext().Core.getSelectedUserAssessmentIsNotNull() || !form.getGlobalContext().ICP.getLinkedItemIsNotNull())
		{
			engine.showMessage("Select an Assessment from the Grid", "Message", MessageButtons.OK);
			return;
		}
		engine.close(DialogResult.OK);
	}
	@Override
	protected void onGrdAssessmentsGridCheckBoxClicked(int column, GenForm.grdAssessmentsRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
	{
		for (int i=0;i<form.grdAssessments().getRows().size();i++)
		{
			if (isChecked)
				if (!form.grdAssessments().getRows().get(i).getValue().getID_UserAssessment().equals(row.getValue().getID_UserAssessment()))
					form.grdAssessments().getRows().get(i).setcolSelect(false);
		}
	}
	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.txtName().setValue(null);
		form.grdAssessments().getRows().clear();
	}
	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.txtName().getValue()==null)
		{
			engine.showMessage("Please enter a search criteria", "Message", MessageButtons.OK);
			return;
		}
		form.grdAssessments().getRows().clear();
		UserAssessmentShortVoCollection assessments=null;
		if (form.txtName()!=null)
			assessments = domain.listAssessments(form.txtName().getValue());

		if (assessments!=null)
			for (UserAssessmentShortVo item : assessments)
			{
				grdAssessmentsRow aRow = form.grdAssessments().getRows().newRow();
				aRow.setValue(item);
				aRow.setcolName(item.getName());
				aRow.setcolSelect(false);
			}
		else
			engine.showMessage("No results found", "Message", MessageButtons.OK);
	}
}
