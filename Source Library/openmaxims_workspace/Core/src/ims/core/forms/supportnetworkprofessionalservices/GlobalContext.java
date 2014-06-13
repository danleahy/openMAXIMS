//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.forms.supportnetworkprofessionalservices;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		COE = new COEContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getGPDetailsIsNotNull()
		{
			return !cx_CoreGPDetails.getValueIsNull(context);
		}
		public ims.core.vo.GpShortVo getGPDetails()
		{
			return (ims.core.vo.GpShortVo)cx_CoreGPDetails.getValue(context);
		}
		public void setGPDetails(ims.core.vo.GpShortVo value)
		{
			cx_CoreGPDetails.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreGPDetails = new ims.framework.ContextVariable("Core.GPDetails", "_cv_Core.GPDetails");
		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
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
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getParentFormModeIsNotNull()
		{
			return !cx_CoreParentFormMode.getValueIsNull(context);
		}
		public ims.framework.enumerations.FormMode getParentFormMode()
		{
			return (ims.framework.enumerations.FormMode)cx_CoreParentFormMode.getValue(context);
		}
		public void setParentFormMode(ims.framework.enumerations.FormMode value)
		{
			cx_CoreParentFormMode.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreParentFormMode = new ims.framework.ContextVariable("Core.ParentFormMode", "_cv_Core.ParentFormMode");
		public boolean getGPSurgeryIsNotNull()
		{
			return !cx_CoreGPSurgery.getValueIsNull(context);
		}
		public ims.core.vo.LocSiteShortVo getGPSurgery()
		{
			return (ims.core.vo.LocSiteShortVo)cx_CoreGPSurgery.getValue(context);
		}
		public void setGPSurgery(ims.core.vo.LocSiteShortVo value)
		{
			cx_CoreGPSurgery.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreGPSurgery = new ims.framework.ContextVariable("Core.GPSurgery", "_cv_Core.GPSurgery");
		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");
		public boolean getSupportNetworkPreviousCareContextsIsNotNull()
		{
			return !cx_CoreSupportNetworkPreviousCareContexts.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVoCollection getSupportNetworkPreviousCareContexts()
		{
			return (ims.core.vo.CareContextShortVoCollection)cx_CoreSupportNetworkPreviousCareContexts.getValue(context);
		}
		public void setSupportNetworkPreviousCareContexts(ims.core.vo.CareContextShortVoCollection value)
		{
			cx_CoreSupportNetworkPreviousCareContexts.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSupportNetworkPreviousCareContexts = new ims.framework.ContextVariable("Core.SupportNetworkPreviousCareContexts", "_cv_Core.SupportNetworkPreviousCareContexts");

		private ims.framework.Context context;
	}
	public final class COEContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private COEContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSupportNetworkProfessionalCollectionIsNotNull()
		{
			return !cx_COESupportNetworkProfessionalCollection.getValueIsNull(context);
		}
		public ims.core.vo.SupportNetworkProfessionalVoCollection getSupportNetworkProfessionalCollection()
		{
			return (ims.core.vo.SupportNetworkProfessionalVoCollection)cx_COESupportNetworkProfessionalCollection.getValue(context);
		}
		public void setSupportNetworkProfessionalCollection(ims.core.vo.SupportNetworkProfessionalVoCollection value)
		{
			cx_COESupportNetworkProfessionalCollection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_COESupportNetworkProfessionalCollection = new ims.framework.ContextVariable("COE.SupportNetworkProfessionalCollection", "_cv_COE.SupportNetworkProfessionalCollection");
		public boolean getSupportNetworkSelectedLocationIsNotNull()
		{
			return !cx_COESupportNetworkSelectedLocation.getValueIsNull(context);
		}
		public ims.core.vo.LocShortVo getSupportNetworkSelectedLocation()
		{
			return (ims.core.vo.LocShortVo)cx_COESupportNetworkSelectedLocation.getValue(context);
		}
		public void setSupportNetworkSelectedLocation(ims.core.vo.LocShortVo value)
		{
			cx_COESupportNetworkSelectedLocation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_COESupportNetworkSelectedLocation = new ims.framework.ContextVariable("COE.SupportNetworkSelectedLocation", "_cv_COE.SupportNetworkSelectedLocation");
		public boolean getSupportNetworkServiceCollectionIsNotNull()
		{
			return !cx_COESupportNetworkServiceCollection.getValueIsNull(context);
		}
		public ims.core.vo.SupportNetworkServicesVoCollection getSupportNetworkServiceCollection()
		{
			return (ims.core.vo.SupportNetworkServicesVoCollection)cx_COESupportNetworkServiceCollection.getValue(context);
		}
		public void setSupportNetworkServiceCollection(ims.core.vo.SupportNetworkServicesVoCollection value)
		{
			cx_COESupportNetworkServiceCollection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_COESupportNetworkServiceCollection = new ims.framework.ContextVariable("COE.SupportNetworkServiceCollection", "_cv_COE.SupportNetworkServiceCollection");
		public boolean getSupportNetworkPreviousClinicalContactsIsNotNull()
		{
			return !cx_COESupportNetworkPreviousClinicalContacts.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVoCollection getSupportNetworkPreviousClinicalContacts()
		{
			return (ims.core.vo.ClinicalContactShortVoCollection)cx_COESupportNetworkPreviousClinicalContacts.getValue(context);
		}
		public void setSupportNetworkPreviousClinicalContacts(ims.core.vo.ClinicalContactShortVoCollection value)
		{
			cx_COESupportNetworkPreviousClinicalContacts.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_COESupportNetworkPreviousClinicalContacts = new ims.framework.ContextVariable("COE.SupportNetworkPreviousClinicalContacts", "_cv_COE.SupportNetworkPreviousClinicalContacts");
		public boolean getSupportNetworkMosIsNotNull()
		{
			return !cx_COESupportNetworkMos.getValueIsNull(context);
		}
		public ims.core.vo.MemberOfStaffShortVo getSupportNetworkMos()
		{
			return (ims.core.vo.MemberOfStaffShortVo)cx_COESupportNetworkMos.getValue(context);
		}
		public void setSupportNetworkMos(ims.core.vo.MemberOfStaffShortVo value)
		{
			cx_COESupportNetworkMos.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_COESupportNetworkMos = new ims.framework.ContextVariable("COE.SupportNetworkMos", "_cv_COE.SupportNetworkMos");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public COEContext COE;
}