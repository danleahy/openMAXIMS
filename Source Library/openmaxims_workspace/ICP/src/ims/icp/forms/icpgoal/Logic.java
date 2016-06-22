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
// This code was generated by Ander Telleria using IMS Development Environment (version 1.70 build 3434.21163)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.icp.forms.icpgoal;

import ims.framework.enumerations.DialogResult;
import ims.icp.vo.IcpPhaseGoalVo;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getGlobalContext().ICP.getIcpPhaseGoalIsNotNull())
		{
			if (form.getGlobalContext().ICP.getIcpPhaseGoal().getGoalIsNotNull())
				form.txt1().setValue(form.getGlobalContext().ICP.getIcpPhaseGoal().getGoal());
			if (form.getGlobalContext().ICP.getIcpPhaseGoal().getIsActiveIsNotNull())
				form.chk1().setValue(form.getGlobalContext().ICP.getIcpPhaseGoal().getIsActive());
		}
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	@Override
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if ((form.txt1().getValue() != null && form.txt1().getValue().trim().length() == 0) ||
				form.txt1().getValue() == null)
		{
			engine.showMessage("'Goal' is empty!");
			return;
		}
		
		IcpPhaseGoalVo goal=new IcpPhaseGoalVo();
		if (form.txt1().getValue() != null)
			goal.setGoal(form.txt1().getValue());		
		goal.setIsActive(form.chk1().getValue());
		form.getGlobalContext().ICP.setIcpPhaseGoal(goal);
		
		engine.close(DialogResult.OK);
	}
}
