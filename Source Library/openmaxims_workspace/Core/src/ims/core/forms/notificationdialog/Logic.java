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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.71 build 3607.22976)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.core.forms.notificationdialog;

import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.interfaces.INotification;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	private void open() 
	{
		form.setMode(FormMode.VIEW);
		
		populateScreenFromData(form.getGlobalContext().Core.getNotification());
	}
	
	private void populateScreenFromData(INotification notification) 
	{
		if(notification == null)
			return;
		
		form.txtDateNotification().setValue(notification.getINotificationDateTime().toString());
		form.txtPriority().setValue(notification.getINotificationPriority() != null ? notification.getINotificationPriority().getText() : null);
		form.txtSource().setValue(notification.getINotificationSource());
		form.txtMessage().setValue(notification.getINotificationMessage());
	}
	
	@Override
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}
}
