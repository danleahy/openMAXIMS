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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.forms.yesnodialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		OCRR = new OCRRContext(context);
		Core = new CoreContext(context);
	}
	public final class OCRRContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OCRRContext(ims.framework.Context context)
		{
			this.context = context;

			SelectAndOrder = new SelectAndOrderContext(context);
		}
		public final class SelectAndOrderContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private SelectAndOrderContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getLaunchYesNoGenderDialogIsNotNull()
			{
				return !cx_OCRRSelectAndOrderLaunchYesNoGenderDialog.getValueIsNull(context);
			}
			public Boolean getLaunchYesNoGenderDialog()
			{
				return (Boolean)cx_OCRRSelectAndOrderLaunchYesNoGenderDialog.getValue(context);
			}
		public void setLaunchYesNoGenderDialog(Boolean value)
		{
				cx_OCRRSelectAndOrderLaunchYesNoGenderDialog.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_OCRRSelectAndOrderLaunchYesNoGenderDialog = new ims.framework.ContextVariable("OCRR.SelectAndOrder.LaunchYesNoGenderDialog", "_cv_OCRR.SelectAndOrder.LaunchYesNoGenderDialog");
			public boolean getLaunchYesNoReOrderDialogIsNotNull()
			{
				return !cx_OCRRSelectAndOrderLaunchYesNoReOrderDialog.getValueIsNull(context);
			}
			public Boolean getLaunchYesNoReOrderDialog()
			{
				return (Boolean)cx_OCRRSelectAndOrderLaunchYesNoReOrderDialog.getValue(context);
			}
		public void setLaunchYesNoReOrderDialog(Boolean value)
		{
				cx_OCRRSelectAndOrderLaunchYesNoReOrderDialog.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_OCRRSelectAndOrderLaunchYesNoReOrderDialog = new ims.framework.ContextVariable("OCRR.SelectAndOrder.LaunchYesNoReOrderDialog", "_cv_OCRR.SelectAndOrder.LaunchYesNoReOrderDialog");
			public boolean getLaunchMyOrderInfoDialogIsNotNull()
			{
				return !cx_OCRRSelectAndOrderLaunchMyOrderInfoDialog.getValueIsNull(context);
			}
			public Boolean getLaunchMyOrderInfoDialog()
			{
				return (Boolean)cx_OCRRSelectAndOrderLaunchMyOrderInfoDialog.getValue(context);
			}

			private ims.framework.ContextVariable cx_OCRRSelectAndOrderLaunchMyOrderInfoDialog = new ims.framework.ContextVariable("OCRR.SelectAndOrder.LaunchMyOrderInfoDialog", "_cv_OCRR.SelectAndOrder.LaunchMyOrderInfoDialog");
			private ims.framework.Context context;
		}


		public SelectAndOrderContext SelectAndOrder;
		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getYesNoDialogMessageIsNotNull()
		{
			return !cx_CoreYesNoDialogMessage.getValueIsNull(context);
		}
		public String getYesNoDialogMessage()
		{
			return (String)cx_CoreYesNoDialogMessage.getValue(context);
		}
		public void setYesNoDialogMessage(String value)
		{
			cx_CoreYesNoDialogMessage.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreYesNoDialogMessage = new ims.framework.ContextVariable("Core.YesNoDialogMessage", "_cv_Core.YesNoDialogMessage");
		public boolean getHideCancelButtonIsNotNull()
		{
			return !cx_CoreHideCancelButton.getValueIsNull(context);
		}
		public Boolean getHideCancelButton()
		{
			return (Boolean)cx_CoreHideCancelButton.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreHideCancelButton = new ims.framework.ContextVariable("Core.HideCancelButton", "_cv_Core.HideCancelButton");
		public boolean getYesNoDialogLaunchedFromSelfIsNotNull()
		{
			return !cx_CoreYesNoDialogLaunchedFromSelf.getValueIsNull(context);
		}
		public Boolean getYesNoDialogLaunchedFromSelf()
		{
			return (Boolean)cx_CoreYesNoDialogLaunchedFromSelf.getValue(context);
		}
		public void setYesNoDialogLaunchedFromSelf(Boolean value)
		{
			cx_CoreYesNoDialogLaunchedFromSelf.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreYesNoDialogLaunchedFromSelf = new ims.framework.ContextVariable("Core.YesNoDialogLaunchedFromSelf", "_cv_Core.YesNoDialogLaunchedFromSelf");
		public boolean getSecondYesNoDialogMessageIsNotNull()
		{
			return !cx_CoreSecondYesNoDialogMessage.getValueIsNull(context);
		}
		public String getSecondYesNoDialogMessage()
		{
			return (String)cx_CoreSecondYesNoDialogMessage.getValue(context);
		}
		public void setSecondYesNoDialogMessage(String value)
		{
			cx_CoreSecondYesNoDialogMessage.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSecondYesNoDialogMessage = new ims.framework.ContextVariable("Core.SecondYesNoDialogMessage", "_cv_Core.SecondYesNoDialogMessage");

		private ims.framework.Context context;
	}
	public boolean getPasswordEnteredIsNotNull()
	{
		return !cx_PasswordEntered.getValueIsNull(context);
	}
	public String getPasswordEntered()
	{
		return (String)cx_PasswordEntered.getValue(context);
	}
		public void setPasswordEntered(String value)
		{
		cx_PasswordEntered.setValue(context, value);
		}

	private ims.framework.ContextVariable cx_PasswordEntered = new ims.framework.ContextVariable("PasswordEntered", "_cv_PasswordEntered");

	public OCRRContext OCRR;
	public CoreContext Core;
}
