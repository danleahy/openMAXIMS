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

package ims.ocrr.forms.testedit;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Admin = new AdminContext(context);
		OCRR = new OCRRContext(context);
		Core = new CoreContext(context);
	}
	public final class AdminContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private AdminContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getColourChosenIsNotNull()
		{
			return !cx_AdminColourChosen.getValueIsNull(context);
		}
		public ims.framework.utils.Color getColourChosen()
		{
			return (ims.framework.utils.Color)cx_AdminColourChosen.getValue(context);
		}
		public void setColourChosen(ims.framework.utils.Color value)
		{
			cx_AdminColourChosen.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AdminColourChosen = new ims.framework.ContextVariable("Admin.ColourChosen", "_cv_Admin.ColourChosen");
		public boolean getLookupTypeIsNotNull()
		{
			return !cx_AdminLookupType.getValueIsNull(context);
		}
		public ims.vo.LookupTypeVo getLookupType()
		{
			return (ims.vo.LookupTypeVo)cx_AdminLookupType.getValue(context);
		}

		private ims.framework.ContextVariable cx_AdminLookupType = new ims.framework.ContextVariable("Admin.LookupType", "_cv_Admin.LookupType");
		public boolean getSelectedQuestionsIsNotNull()
		{
			return !cx_AdminSelectedQuestions.getValueIsNull(context);
		}
		public ims.core.vo.QuestionInformationShortVoCollection getSelectedQuestions()
		{
			return (ims.core.vo.QuestionInformationShortVoCollection)cx_AdminSelectedQuestions.getValue(context);
		}
		public void setSelectedQuestions(ims.core.vo.QuestionInformationShortVoCollection value)
		{
			cx_AdminSelectedQuestions.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AdminSelectedQuestions = new ims.framework.ContextVariable("Admin.SelectedQuestions", "_cv_Admin.SelectedQuestions");

		private ims.framework.Context context;
	}
	public final class OCRRContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OCRRContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getNewProfileIsNotNull()
		{
			return !cx_OCRRNewProfile.getValueIsNull(context);
		}
		public Boolean getNewProfile()
		{
			return (Boolean)cx_OCRRNewProfile.getValue(context);
		}
		public void setNewProfile(Boolean value)
		{
			cx_OCRRNewProfile.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRNewProfile = new ims.framework.ContextVariable("OCRR.NewProfile", "_cv_OCRR.NewProfile");
		public boolean getCurrentInvestigationIsNotNull()
		{
			return !cx_OCRRCurrentInvestigation.getValueIsNull(context);
		}
		public ims.ocrr.vo.InvestigationVo getCurrentInvestigation()
		{
			return (ims.ocrr.vo.InvestigationVo)cx_OCRRCurrentInvestigation.getValue(context);
		}
		public void setCurrentInvestigation(ims.ocrr.vo.InvestigationVo value)
		{
			cx_OCRRCurrentInvestigation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRCurrentInvestigation = new ims.framework.ContextVariable("OCRR.CurrentInvestigation", "_cv_OCRR.CurrentInvestigation");
		public boolean getItemSelectionTypeIsNotNull()
		{
			return !cx_OCRRItemSelectionType.getValueIsNull(context);
		}
		public ims.ocrr.vo.lookups.ItemSelectionType getItemSelectionType()
		{
			return (ims.ocrr.vo.lookups.ItemSelectionType)cx_OCRRItemSelectionType.getValue(context);
		}
		public void setItemSelectionType(ims.ocrr.vo.lookups.ItemSelectionType value)
		{
			cx_OCRRItemSelectionType.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRItemSelectionType = new ims.framework.ContextVariable("OCRR.ItemSelectionType", "_cv_OCRR.ItemSelectionType");
		public boolean getProfileListSearchCriteriaIsNotNull()
		{
			return !cx_OCRRProfileListSearchCriteria.getValueIsNull(context);
		}
		public ims.ocrr.vo.InvestigationProfileListSearchCriteriaVo getProfileListSearchCriteria()
		{
			return (ims.ocrr.vo.InvestigationProfileListSearchCriteriaVo)cx_OCRRProfileListSearchCriteria.getValue(context);
		}

		private ims.framework.ContextVariable cx_OCRRProfileListSearchCriteria = new ims.framework.ContextVariable("OCRR.ProfileListSearchCriteria", "_cv_OCRR.ProfileListSearchCriteria");
		public boolean getNewInvestigationIsNotNull()
		{
			return !cx_OCRRNewInvestigation.getValueIsNull(context);
		}
		public Boolean getNewInvestigation()
		{
			return (Boolean)cx_OCRRNewInvestigation.getValue(context);
		}
		public void setNewInvestigation(Boolean value)
		{
			cx_OCRRNewInvestigation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRNewInvestigation = new ims.framework.ContextVariable("OCRR.NewInvestigation", "_cv_OCRR.NewInvestigation");
		public boolean getPreselectedInvestigationsIsNotNull()
		{
			return !cx_OCRRPreselectedInvestigations.getValueIsNull(context);
		}
		public ims.ocrr.vo.InvestShortVoCollection getPreselectedInvestigations()
		{
			return (ims.ocrr.vo.InvestShortVoCollection)cx_OCRRPreselectedInvestigations.getValue(context);
		}
		public void setPreselectedInvestigations(ims.ocrr.vo.InvestShortVoCollection value)
		{
			cx_OCRRPreselectedInvestigations.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRPreselectedInvestigations = new ims.framework.ContextVariable("OCRR.PreselectedInvestigations", "_cv_OCRR.PreselectedInvestigations");
		public boolean getInvestigationListSearchCriteriaIsNotNull()
		{
			return !cx_OCRRInvestigationListSearchCriteria.getValueIsNull(context);
		}
		public ims.ocrr.vo.InvestigationProfileListSearchCriteriaVo getInvestigationListSearchCriteria()
		{
			return (ims.ocrr.vo.InvestigationProfileListSearchCriteriaVo)cx_OCRRInvestigationListSearchCriteria.getValue(context);
		}

		private ims.framework.ContextVariable cx_OCRRInvestigationListSearchCriteria = new ims.framework.ContextVariable("OCRR.InvestigationListSearchCriteria", "_cv_OCRR.InvestigationListSearchCriteria");
		public boolean getSelectedTestIsNotNull()
		{
			return !cx_OCRRSelectedTest.getValueIsNull(context);
		}
		public ims.ocrr.vo.InvestigationIndexVo getSelectedTest()
		{
			return (ims.ocrr.vo.InvestigationIndexVo)cx_OCRRSelectedTest.getValue(context);
		}
		public void setSelectedTest(ims.ocrr.vo.InvestigationIndexVo value)
		{
			cx_OCRRSelectedTest.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRSelectedTest = new ims.framework.ContextVariable("OCRR.SelectedTest", "_cv_OCRR.SelectedTest");
		public boolean getSelectedInvestigationsIsNotNull()
		{
			return !cx_OCRRSelectedInvestigations.getValueIsNull(context);
		}
		public ims.ocrr.vo.InvestShortVoCollection getSelectedInvestigations()
		{
			return (ims.ocrr.vo.InvestShortVoCollection)cx_OCRRSelectedInvestigations.getValue(context);
		}
		public void setSelectedInvestigations(ims.ocrr.vo.InvestShortVoCollection value)
		{
			cx_OCRRSelectedInvestigations.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRSelectedInvestigations = new ims.framework.ContextVariable("OCRR.SelectedInvestigations", "_cv_OCRR.SelectedInvestigations");
		public boolean getProviderIsNotNull()
		{
			return !cx_OCRRProvider.getValueIsNull(context);
		}
		public ims.core.vo.LocationLiteVo getProvider()
		{
			return (ims.core.vo.LocationLiteVo)cx_OCRRProvider.getValue(context);
		}
		public void setProvider(ims.core.vo.LocationLiteVo value)
		{
			cx_OCRRProvider.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRProvider = new ims.framework.ContextVariable("OCRR.Provider", "_cv_OCRR.Provider");
		public boolean getCategoryIsNotNull()
		{
			return !cx_OCRRCategory.getValueIsNull(context);
		}
		public ims.ocrr.vo.lookups.Category getCategory()
		{
			return (ims.ocrr.vo.lookups.Category)cx_OCRRCategory.getValue(context);
		}
		public void setCategory(ims.ocrr.vo.lookups.Category value)
		{
			cx_OCRRCategory.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRCategory = new ims.framework.ContextVariable("OCRR.Category", "_cv_OCRR.Category");
		public boolean getProviderServiceIsNotNull()
		{
			return !cx_OCRRProviderService.getValueIsNull(context);
		}
		public ims.core.vo.ServiceShortVo getProviderService()
		{
			return (ims.core.vo.ServiceShortVo)cx_OCRRProviderService.getValue(context);
		}
		public void setProviderService(ims.core.vo.ServiceShortVo value)
		{
			cx_OCRRProviderService.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRProviderService = new ims.framework.ContextVariable("OCRR.ProviderService", "_cv_OCRR.ProviderService");
		public boolean getAlternativePaedContainerIsNotNull()
		{
			return !cx_OCRRAlternativePaedContainer.getValueIsNull(context);
		}
		public ims.ocrr.vo.SpecimenContainerVo getAlternativePaedContainer()
		{
			return (ims.ocrr.vo.SpecimenContainerVo)cx_OCRRAlternativePaedContainer.getValue(context);
		}
		public void setAlternativePaedContainer(ims.ocrr.vo.SpecimenContainerVo value)
		{
			cx_OCRRAlternativePaedContainer.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRAlternativePaedContainer = new ims.framework.ContextVariable("OCRR.AlternativePaedContainer", "_cv_OCRR.AlternativePaedContainer");
		public boolean getSpecimenContainersIsNotNull()
		{
			return !cx_OCRRSpecimenContainers.getValueIsNull(context);
		}
		public ims.ocrr.vo.PathSpecimenContainerDetailVoCollection getSpecimenContainers()
		{
			return (ims.ocrr.vo.PathSpecimenContainerDetailVoCollection)cx_OCRRSpecimenContainers.getValue(context);
		}
		public void setSpecimenContainers(ims.ocrr.vo.PathSpecimenContainerDetailVoCollection value)
		{
			cx_OCRRSpecimenContainers.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRSpecimenContainers = new ims.framework.ContextVariable("OCRR.SpecimenContainers", "_cv_OCRR.SpecimenContainers");
		public boolean getAlternativeAdultContainerIsNotNull()
		{
			return !cx_OCRRAlternativeAdultContainer.getValueIsNull(context);
		}
		public ims.ocrr.vo.AlternativeAdultContainerVo getAlternativeAdultContainer()
		{
			return (ims.ocrr.vo.AlternativeAdultContainerVo)cx_OCRRAlternativeAdultContainer.getValue(context);
		}
		public void setAlternativeAdultContainer(ims.ocrr.vo.AlternativeAdultContainerVo value)
		{
			cx_OCRRAlternativeAdultContainer.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRAlternativeAdultContainer = new ims.framework.ContextVariable("OCRR.AlternativeAdultContainer", "_cv_OCRR.AlternativeAdultContainer");

		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getEditedQuestionsIsNotNull()
		{
			return !cx_CoreEditedQuestions.getValueIsNull(context);
		}
		public ims.core.vo.QuestionInformationVoCollection getEditedQuestions()
		{
			return (ims.core.vo.QuestionInformationVoCollection)cx_CoreEditedQuestions.getValue(context);
		}
		public void setEditedQuestions(ims.core.vo.QuestionInformationVoCollection value)
		{
			cx_CoreEditedQuestions.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreEditedQuestions = new ims.framework.ContextVariable("Core.EditedQuestions", "_cv_Core.EditedQuestions");
		public boolean getQuestionTypeIsNotNull()
		{
			return !cx_CoreQuestionType.getValueIsNull(context);
		}
		public ims.core.vo.lookups.QuestionType getQuestionType()
		{
			return (ims.core.vo.lookups.QuestionType)cx_CoreQuestionType.getValue(context);
		}
		public void setQuestionType(ims.core.vo.lookups.QuestionType value)
		{
			cx_CoreQuestionType.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreQuestionType = new ims.framework.ContextVariable("Core.QuestionType", "_cv_Core.QuestionType");
		public boolean getTaxonomyMapIsNotNull()
		{
			return !cx_CoreTaxonomyMap.getValueIsNull(context);
		}
		public ims.core.vo.TaxonomyMap getTaxonomyMap()
		{
			return (ims.core.vo.TaxonomyMap)cx_CoreTaxonomyMap.getValue(context);
		}
		public void setTaxonomyMap(ims.core.vo.TaxonomyMap value)
		{
			cx_CoreTaxonomyMap.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreTaxonomyMap = new ims.framework.ContextVariable("Core.TaxonomyMap", "_cv_Core.TaxonomyMap");
		public boolean getSelectedLookupInstancesIsNotNull()
		{
			return !cx_CoreSelectedLookupInstances.getValueIsNull(context);
		}
		public ims.vo.LookupInstanceCollection getSelectedLookupInstances()
		{
			return (ims.vo.LookupInstanceCollection)cx_CoreSelectedLookupInstances.getValue(context);
		}
		public void setSelectedLookupInstances(ims.vo.LookupInstanceCollection value)
		{
			cx_CoreSelectedLookupInstances.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectedLookupInstances = new ims.framework.ContextVariable("Core.SelectedLookupInstances", "_cv_Core.SelectedLookupInstances");
		public boolean getSelectLookupTypeIsNotNull()
		{
			return !cx_CoreSelectLookupType.getValueIsNull(context);
		}
		public ims.vo.LookupTypeVo getSelectLookupType()
		{
			return (ims.vo.LookupTypeVo)cx_CoreSelectLookupType.getValue(context);
		}
		public void setSelectLookupType(ims.vo.LookupTypeVo value)
		{
			cx_CoreSelectLookupType.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectLookupType = new ims.framework.ContextVariable("Core.SelectLookupType", "_cv_Core.SelectLookupType");

		private ims.framework.Context context;
	}

	public AdminContext Admin;
	public OCRRContext OCRR;
	public CoreContext Core;
}
