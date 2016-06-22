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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.ocrr.forms.analyteconfiguration;

import java.util.ArrayList;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.ServiceLiteVoCollection;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.FormMode;
import ims.ocrr.forms.analyteconfiguration.GenForm.grdAnalytesRow;
import ims.ocrr.vo.AnalyteConfigurationSearchCriteriaVo;
import ims.ocrr.vo.AnalyteConfigurationVo;
import ims.ocrr.vo.AnalyteConfigurationVoCollection;
import ims.ocrr.vo.ProviderSystemLiteVoCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
	}

	private void initialise()
	{
		populateServiceCombo();
		populateProviderSystemCombo();

	}

	private void populateServiceCombo()
	{
		form.cmbService().clear();

		ServiceLiteVoCollection services = domain.getServices();

		for (int i = 0; i < services.size(); i++)
		{
			form.cmbService().newRow(services.get(i), services.get(i).getServiceName());
		}

	}

	private void populateProviderSystemCombo()
	{
		form.cmbProviderSystem().clear();

		ProviderSystemLiteVoCollection providerSystems = domain.getProviderSystems();

		for (int i = 0; i < providerSystems.size(); i++)
		{
			form.cmbProviderSystem().newRow(providerSystems.get(i), providerSystems.get(i).getSystemName());
		}

	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	private void updateControlsState()
	{
		form.btnEdit().setVisible(FormMode.VIEW.equals(form.getMode()));
		form.btnEdit().setEnabled(form.grdAnalytes().getValue() != null);
		form.ctnAnalyteDetails().setCollapsed(form.grdAnalytes().getValue() == null);
	}

	@Override
	protected void onGrdAnalytesSelectionChanged()
	{
		form.getLocalContext().setSelectedAnalyte(form.grdAnalytes().getValue());
		populateAnalyteContainer(form.getLocalContext().getSelectedAnalyte());
		updateControlsState();
	}

	private void populateAnalyteContainer(AnalyteConfigurationVo analyteConfigurationVo)
	{
		if (analyteConfigurationVo == null)
			return;

		clearContainer();

		form.ctnAnalyteDetails().txtName().setValue(analyteConfigurationVo.getAnalyteExtText());
		form.ctnAnalyteDetails().txtCode().setValue(analyteConfigurationVo.getAnalyteExtCode());
		form.ctnAnalyteDetails().txtProviderSystem().setValue(analyteConfigurationVo.getProviderSystem() != null ? analyteConfigurationVo.getProviderSystem().getSystemName() : "");
		form.ctnAnalyteDetails().txtService().setValue(analyteConfigurationVo.getService() != null ? analyteConfigurationVo.getService().getServiceName() : "");
	}

	private void clearContainer()
	{
		form.ctnAnalyteDetails().txtName().setValue(null);
		form.ctnAnalyteDetails().txtCode().setValue(null);
		form.ctnAnalyteDetails().txtService().setValue(null);
		form.ctnAnalyteDetails().txtProviderSystem().setValue(null);

	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{

		form.grdAnalytes().setValue(form.getLocalContext().getSelectedAnalyte());
		populateAnalyteContainer(form.getLocalContext().getSelectedAnalyte());
		form.setMode(FormMode.VIEW);
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			doSearch();;

	}

	private boolean save()
	{
		if (!validateUiRules())
			return false;

		String datasetName = getDataSetName(form.ctnAnalyteDetails().txtName().getValue());

		AnalyteConfigurationVo analyteToSave = new AnalyteConfigurationVo();
		analyteToSave = (AnalyteConfigurationVo) form.getLocalContext().getSelectedAnalyte().clone();

		analyteToSave.setAnalyteExtText(form.ctnAnalyteDetails().txtName().getValue());

		if (analyteToSave.getDatasetType() != null)
		{
			analyteToSave.getDatasetType().setName(datasetName);
		}

		if (domain.analyteAlreadyExists(analyteToSave.getDatasetType()))
		{
			engine.showMessage("Analyte Configuration already exists.", "Warning", MessageButtons.OK, MessageIcon.WARNING);
			return false;
		}

		String[] errors = analyteToSave.validate();
		if (errors != null)
		{
			engine.showErrors(errors);
			return false;
		}

		try
		{
			form.getLocalContext().setSelectedAnalyte(domain.saveAnalyte(analyteToSave));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			form.getLocalContext().setSelectedAnalyte(null);//WDEV-19158
			doSearch();
			form.setMode(FormMode.VIEW);
			return false;
		}

		form.setMode(FormMode.VIEW);

		return true;
	}

	private boolean validateUiRules()
	{
		ArrayList<String> listOfErrors = new ArrayList<String>();

		if (form.ctnAnalyteDetails().txtName().getValue() == null)
		{
			listOfErrors.add("Name is mandatory.");
		}

		int errorCount = listOfErrors.size();
		String[] result = new String[errorCount];

		for (int x = 0; x < errorCount; x++)
			result[x] = (String) listOfErrors.get(x);

		if (result != null && result.length > 0)
		{
			engine.showErrors(result);
			return false;
		}

		return true;
	}

	private String getDataSetName(String analyteName)
	{
		String datasetName = analyteName;

		AnalyteConfigurationVo analyte = form.getLocalContext().getSelectedAnalyte();

		if (ConfigFlag.DOM.ANALYTE_UNIQUENESS.getValue().equals("SVC") && analyte.getService() != null)
		{
			datasetName += " (" + analyte.getService().getServiceName() + " - " + analyte.getAnalyteExtCode() + ")";
		}
		else if (ConfigFlag.DOM.ANALYTE_UNIQUENESS.getValue().equals("LOC_SVC") && analyte.getLocationService() != null && analyte.getService() != null)
		{
			datasetName += " (" + analyte.getLocationService().getLocation().getName() + " - " + analyte.getService().getServiceName() + " - " + analyte.getAnalyteExtCode() + ")";
		}
		else if (ConfigFlag.DOM.ANALYTE_UNIQUENESS.getValue().equals("PROV_SYS") && analyte.getProviderSystem() != null)
		{
			datasetName += " (" + analyte.getProviderSystem().getSystemName() + " - " + analyte.getAnalyteExtCode() + ")";
		}

		return datasetName;

	}

	private void doSearch()
	{
		AnalyteConfigurationSearchCriteriaVo searchCriteria = new AnalyteConfigurationSearchCriteriaVo();

		searchCriteria.setProviderSystem(form.cmbProviderSystem().getValue());
		searchCriteria.setService(form.cmbService().getValue());
		searchCriteria.setAnalyteCode(form.txtCodeSearch().getValue());

		populateAnalytesGrid(domain.getAnalites(searchCriteria));

	}

	private void populateAnalytesGrid(AnalyteConfigurationVoCollection analites)
	{
		form.grdAnalytes().getRows().clear();
		clearContainer();

		if (analites == null || analites.size() == 0)
		{
			engine.showMessage("No records match your search criteria.", "No data found", MessageButtons.OK, MessageIcon.WARNING);
			form.getLocalContext().setSelectedAnalyte(null);
			updateControlsState();
			return;
		}

		for (int i = 0; i < analites.size(); i++)
		{
			grdAnalytesRow newRow = form.grdAnalytes().getRows().newRow();

			newRow.setColName(analites.get(i).getAnalyteExtText());
			newRow.setColCode(analites.get(i).getAnalyteExtCode());
			newRow.setColProvSystem(analites.get(i).getProviderSystem() != null ? analites.get(i).getProviderSystem().getSystemName() : "");
			newRow.setColService(analites.get(i).getService() != null ? analites.get(i).getService().getServiceName() : "");

			newRow.setValue(analites.get(i));
		}

		form.grdAnalytes().setValue(form.getLocalContext().getSelectedAnalyte());
		populateAnalyteContainer(form.getLocalContext().getSelectedAnalyte());

	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearScreen();
		updateControlsState();
	}

	private void clearScreen()
	{
		form.cmbProviderSystem().setValue(null);
		form.cmbService().setValue(null);
		form.txtCodeSearch().setValue(null);
		form.grdAnalytes().getRows().clear();

		clearContainer();
		form.getLocalContext().setSelectedAnalyte(null);
	}

	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setSelectedAnalyte(null);
		doSearch();
		updateControlsState();
	}
}
