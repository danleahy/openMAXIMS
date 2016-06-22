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
// This code was generated by Peter Martin using IMS Development Environment (version 1.60 build 2855.18658)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.coe.forms.infectioncontrolrepeatableassessment;

import ims.coe.forms.infectioncontrolrepeatableassessment.GenForm.grdRecordsRow;
import ims.coe.vo.InfectionControlDetailsVo;
import ims.coe.vo.InfectionControlDetailsVoCollection;
import ims.coe.vo.InfectionControlRepeatableAssessmentVo;
import ims.coe.vo.InfectionControlRepeatableAssessmentVoCollection;
import ims.coe.vo.lookups.LookupHelper;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;
import ims.nursing.vo.AssessmentComponent;
import ims.nursing.vo.AssessmentHeaderInfo;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
	}

	private void initialise() throws FormOpenException
	{
		if (form.getGlobalContext().Core.getCurrentCareContext() == null)
			throw new FormOpenException("Care Context is mandatory for this form.");

		if (!loadRecords(form.getGlobalContext().COE.getInfectionControlAssessment()))
			loadInfectionGridFromLookup();

		if (engine.getPreviousNonDialogFormName().equals(form.getForms().COE.AssessInfectionControl))
		{
			form.btnClose().setVisible(true);
			form.cmbAllRecords().setEnabled(false);
			form.btnNew().setVisible(form.getGlobalContext().COE.getInfectionControlAssessmentIsNotNull() ? false : true);
		}
		else
		{
			form.btnClose().setVisible(false);
			form.cmbAllRecords().setEnabled(true);
			form.btnNew().setVisible(true);
		}

		if (form.cmbAllRecords().getValue() != null)
		{
			AssessmentComponent infectComp = domain.getInfectionComponent(form.cmbAllRecords().getValue());

			if (infectComp != null)
			{
				if (infectComp.getIsComplete())
					form.btnEdit().setEnabled(!(infectComp.getIsComplete()));

			}

		}

	}

	private void loadInfectionGridFromLookup()
	{
		form.grdRecords().populateTree(LookupHelper.getInfectionControlType(domain.getLookupService()), true);
		form.grdRecords().expandAll();

	}

	private boolean loadRecords(InfectionControlRepeatableAssessmentVo voGlobalAssessment)
	{

		InfectionControlRepeatableAssessmentVoCollection collInfectionControl = new InfectionControlRepeatableAssessmentVoCollection();
		collInfectionControl = domain.listInfectionControlByCareContext(form.getGlobalContext().Core.getCurrentCareContext());

		if (collInfectionControl != null && collInfectionControl.size() != 0)
		{
			form.cmbAllRecords().clear();
			for (int i = 0; i < collInfectionControl.size(); i++)
			{
				InfectionControlRepeatableAssessmentVo voInfectionControl = collInfectionControl.get(i);
				// Load ComboBox with Records Retrieved
				form.cmbAllRecords().newRow(voInfectionControl, voInfectionControl.getDateTimeInitiated().toString());
			}

			if (!engine.getPreviousNonDialogFormName().equals(form.getForms().COE.AssessInfectionControl))
			{
				form.cmbAllRecords().setValue(collInfectionControl.get(collInfectionControl.size() - 1));
				if (form.cmbAllRecords().getValue() != null)
				{

					displayInfectionRecord(domain.getInfectionControllAssessment(form.cmbAllRecords().getValue().getID_Assessment()));

				}
				else
				{
					loadInfectionGridFromLookup();
					makeInfectionHeaderInfoNew(Boolean.FALSE);
				}
			}
		}
		else
			return false;

		if (voGlobalAssessment != null)
			form.getLocalContext().setInfectionControlItem(voGlobalAssessment);
		if (form.getLocalContext().getInfectionControlItemIsNotNull() && form.getLocalContext().getInfectionControlItem().getID_AssessmentIsNotNull())
		{
			displayInfectionRecord(domain.getInfectionControllAssessment(form.getLocalContext().getInfectionControlItem().getID_Assessment()));
		}

		return true;
	}

	@Override
	protected void onCmbAllRecordsValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.cmbAllRecords().getValue() != null)
		{

			displayInfectionRecord(domain.getInfectionControllAssessment(form.cmbAllRecords().getValue().getID_Assessment()));

			AssessmentComponent infectComp = domain.getInfectionComponent(form.cmbAllRecords().getValue());

			if (infectComp != null && infectComp.getIsComplete())
			{
				form.btnEdit().setEnabled(!(infectComp.getIsComplete()));
			}
			else if (infectComp == null){
				form.btnEdit().setEnabled(true);
				form.btnEdit().setVisible(true);
			}

		}
		else
		{
			loadInfectionGridFromLookup();
			makeInfectionHeaderInfoNew(Boolean.FALSE);
			form.btnEdit().setVisible(false);
		}
	}

	private void makeInfectionHeaderInfoNew(Boolean bDefaultValues)
	{
		if (bDefaultValues.booleanValue() == true)
		{
			form.dteDate().setValue(new Date());
			form.timTime().setValue(new Time());
			if (domain.getMosUser() != null)
				form.txtRecordingHCP().setValue(((MemberOfStaffShortVo) domain.getMosUser()).toString());
		}
		else
		// null values
		{
			form.dteDate().setValue(null);
			form.timTime().setValue(null);
			form.txtRecordingHCP().setValue(null);
		}

	}

	private void displayInfectionRecord(InfectionControlRepeatableAssessmentVo infectionHeader)
	{

		InfectionControlDetailsVoCollection collDetails = infectionHeader.getInfectionControlDetails();

		form.getGlobalContext().COE.setInfectionControlAssessment(infectionHeader);
		form.cmbAllRecords().setValue(infectionHeader);

		if (collDetails != null)
		{
			form.getLocalContext().setInfectionControlItem(infectionHeader);
			// contine here displaying header info then get the details
			form.dteDate().setValue(infectionHeader.getDateTimeInitiated().getDate());
			form.timTime().setValue(infectionHeader.getDateTimeInitiated().getTime());
			if (infectionHeader.getHcpInitiated() != null)
				form.txtRecordingHCP().setValue(infectionHeader.getHcpInitiated().toString());

			loadInfectionGridFromLookup();

			for (int i = 0; i < collDetails.size(); i++)
			{
				grdRecordsRow row = null;
				int r = 0;
				boolean bInfectionTypeFound = false;
				for (r = 0; r < form.grdRecords().getRows().size(); r++)
				{
					row = form.grdRecords().getRows().get(r);
					for (int s = 0; s < row.getRows().size(); s++)
					{
						grdRecordsRow childRow = row.getRows().get(s);
						if (collDetails.get(i).getInfectionControlType().equals(childRow.getcolType()))
						{
							childRow.setValue(collDetails.get(i));
							childRow.setcolStatus(collDetails.get(i).getStatus());
							childRow.setColResult(collDetails.get(i).getResult());
							childRow.setcolComments(collDetails.get(i).getComments());
							r = form.grdRecords().getRows().size();
							bInfectionTypeFound = true;
							break;
						}
					}
				}
				if (!bInfectionTypeFound)
				{
					boolean bParentFound = true;
					// find parent and add to rows
					for (int t = 0; t < form.grdRecords().getRows().size(); t++)
					{

						row = form.grdRecords().getRows().get(t);
						if (collDetails.get(i).getInfectionControlType().getParent().equals(row.getcolType()))
						{
							grdRecordsRow newChildRow = row.getRows().newRow();
							newChildRow.setValue(collDetails.get(i));
							newChildRow.setcolStatus(collDetails.get(i).getStatus());
							newChildRow.setColResult(collDetails.get(i).getResult());
							newChildRow.setcolComments(collDetails.get(i).getComments());
							bParentFound = true;
						}
					}
					if (!bParentFound)
					{
						// Add Parent & Child
						grdRecordsRow newParentRow = form.grdRecords().getRows().newRow();
						newParentRow.setcolType(collDetails.get(i).getInfectionControlType().getParent());
						newParentRow.setValue(collDetails.get(i));
						grdRecordsRow newChildRow = newParentRow.getRows().newRow();
						newChildRow.setValue(collDetails.get(i));
						newChildRow.setcolStatus(collDetails.get(i).getStatus());
						newChildRow.setColResult(collDetails.get(i).getResult());
						newChildRow.setcolComments(collDetails.get(i).getComments());
					}
				}
			}
		}

	}

	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.cmbAllRecords().setValue(null);
		makeInfectionHeaderInfoNew(Boolean.TRUE);
		loadInfectionGridFromLookup();
		form.btnNew().setVisible(false);
		InfectionControlRepeatableAssessmentVo infectionVo = new InfectionControlRepeatableAssessmentVo();
		form.getLocalContext().setInfectionControlItem(infectionVo);

		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		
		loadRecords(null);
		form.cmbAllRecords().setValue(form.getLocalContext().getInfectionControlItem());

		if (engine.getPreviousNonDialogFormName().equals(form.getForms().COE.AssessInfectionControl))
		{
			form.btnClose().setVisible(true);
			if(form.getLocalContext().getInfectionControlItemIsNotNull() &&
					form.getLocalContext().getInfectionControlItem().getInfectionControlDetailsIsNotNull())
			{
				form.btnNew().setVisible(false);
				form.btnEdit().setVisible(true);
			}
		}
		else{
			form.btnClose().setVisible(false);
			form.cmbAllRecords().setEnabled(true);
			form.btnNew().setVisible(true);
			if(form.getLocalContext().getInfectionControlItemIsNotNull())
				form.btnEdit().setVisible(true);
		}
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		String[] compErrors = null;

		InfectionControlRepeatableAssessmentVo infectionVo = populateDataFromScreen(form.getLocalContext().getInfectionControlItem());
		if (infectionVo == null)
			return;

		if (!infectionVo.getCareContextIsNotNull())
			infectionVo.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		if (!infectionVo.getClinicalContactIsNotNull())
			infectionVo.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());

		String[] arrErrors = infectionVo.validate();
		if (form.getGlobalContext().Nursing.getAssessmentComponentIsNotNull())
		{

			compErrors = form.getGlobalContext().Nursing.getAssessmentComponent().validate();

		}
		if (arrErrors == null && compErrors == null)
		{
			try
			{
				if (form.getGlobalContext().Nursing.getAssessmentComponent() == null)
				{
					form.getLocalContext().setInfectionControlItem(domain.saveInfectionControl(infectionVo));
					
				}
				else
				{
					AssessmentComponent infectComp = form.getGlobalContext().Nursing.getAssessmentComponent();
					AssessmentHeaderInfo infectConComVo = domain.saveInfectionWithAssessment(form.getGlobalContext().Nursing.getAssessmentHeaderInfo(), infectComp, infectionVo);
					form.getGlobalContext().Nursing.setAssessmentHeaderInfo(infectConComVo);
					form.getGlobalContext().Nursing.setAssessmentComponent(infectConComVo.getCurrentComponent());
				}

			}
			catch (StaleObjectException e)
			{
				if (form.cmbAllRecords().getValue() != null)
				{
					engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
					displayInfectionRecord(domain.getInfectionControllAssessment(form.cmbAllRecords().getValue().getID_Assessment()));
					form.setMode(FormMode.VIEW);
					return;
				}
			}
			catch (DomainInterfaceException e)
			{
				if (form.cmbAllRecords().getValue() != null)
				{
					engine.showMessage(e.getMessage());
					displayInfectionRecord(domain.getInfectionControllAssessment(form.cmbAllRecords().getValue().getID_Assessment()));
					form.setMode(FormMode.VIEW);
					return;
				}
			}

		}
		else
		{
			engine.showErrors("Validation Errors", arrErrors);
			return;
		}

		loadRecords(null);
		
		InfectionControlRepeatableAssessmentVo item = form.getLocalContext().getInfectionControlItem();
		
		form.cmbAllRecords().setValue(item);
		form.getGlobalContext().COE.setInfectionControlAssessment(item);

		form.setMode(FormMode.VIEW);

		if (engine.getPreviousNonDialogFormName().equals(form.getForms().COE.AssessInfectionControl))
		{
			form.btnNew().setVisible(false);
			form.btnClose().setVisible(true);
			form.btnEdit().setVisible(true);

		}
		else
		{
			if (form.getGlobalContext().Nursing.getAssessmentComponent() == null)
			{
				form.btnEdit().setEnabled(true);
			}
			form.btnClose().setVisible(false);
			form.btnNew().setVisible(true);
		}

	}

	private InfectionControlRepeatableAssessmentVo populateDataFromScreen(InfectionControlRepeatableAssessmentVo voInfectionControl)
	{
		if (voInfectionControl == null)
			voInfectionControl = new InfectionControlRepeatableAssessmentVo();

		voInfectionControl.setDateTimeInitiated(new DateTime(form.dteDate().getValue(), form.timTime().getValue()));

		Object Object = domain.getHcpLiteUser();
		HcpLiteVo hcpLiteVo = Object != null ? (HcpLiteVo) Object : null;

		voInfectionControl.setHcpInitiated(hcpLiteVo);

		// retrieve details from the grid
		InfectionControlDetailsVoCollection detailsColl = new InfectionControlDetailsVoCollection();

		for (int i = 0; i < form.grdRecords().getRows().size(); i++)
		{
			GenForm.grdRecordsRow row = form.grdRecords().getRows().get(i);

			if (row.getcolType().hasActiveChildren())
				for (int j = 0; j < row.getRows().size(); j++)
				{
					GenForm.grdRecordsRow childRow = row.getRows().get(j);

					InfectionControlDetailsVo voInfectionControlDetailsVo = childRow.getValue();
					if (voInfectionControlDetailsVo == null)
						voInfectionControlDetailsVo = new InfectionControlDetailsVo();
					voInfectionControlDetailsVo.setInfectionControlType(childRow.getcolType());
					voInfectionControlDetailsVo.setResult(childRow.getColResult());
					voInfectionControlDetailsVo.setStatus(childRow.getcolStatus());
					voInfectionControlDetailsVo.setComments(childRow.getcolComments());

					if (voInfectionControlDetailsVo.getStatus() != null || (voInfectionControlDetailsVo.getResult() != null && voInfectionControlDetailsVo.getCommentsIsNotNull() && !voInfectionControlDetailsVo.getComments().equals("")))
						detailsColl.add(voInfectionControlDetailsVo);
				}
		}

		if (detailsColl.size() == 0)
		{
			engine.showMessage("You must save some Infection Control details");
			return null;
		}

		voInfectionControl.setInfectionControlDetails(detailsColl);

		return voInfectionControl;
	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		form.btnNew().setVisible(false);
	}

	@Override
	protected void onBtnCloseClick() throws PresentationLogicException
	{
		if (form.getGlobalContext().Nursing.getAssessmentComponent() != null)
		{
			engine.open(form.getForms().COE.AssessInfectionControl);
			return;
		}
	}

	@Override
	protected void onFormModeChanged()
	{
		boolean isComplete = false;

		if (form.getMode().equals(FormMode.VIEW))
		{
			boolean displayNew = !form.getLocalContext().getInfectionControlItemIsNotNull() || (form.getLocalContext().getInfectionControlItemIsNotNull() && form.getLocalContext().getInfectionControlItem().getID_Assessment() == null);
			if (form.cmbAllRecords().getValue() != null)
			{
				if (form.getGlobalContext().Nursing.getAssessmentComponentIsNotNull())
					isComplete = form.getGlobalContext().Nursing.getAssessmentComponent().getIsComplete();
				form.btnEdit().setVisible(!isComplete);

				// form.btnNew().setVisible(!form.getLocalContext().getInfectionControlItemIsNotNull());
				form.cmbAllRecords().setEnabled(engine.getPreviousNonDialogFormName().equals(form.getForms().COE.AssessInfectionControl) ? false : true);

			}
			else
			{
				form.btnNew().setVisible(displayNew);
				form.btnEdit().setVisible(false);
			}
		}
		
		form.btnPrint().setVisible(form.getMode().equals(FormMode.VIEW) && form.cmbAllRecords().getValue() != null);
	}

	@Override
	protected void onBtnPrintClick() throws PresentationLogicException
	{
		InfectionControlRepeatableAssessmentVo record = form.cmbAllRecords().getValue();

		if (record == null)
		{
			engine.showMessage("There is no record to print !");
			return;
		}
		
		engine.open(form.getForms().Core.Reports);
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (result.equals(DialogResult.OK) && formName.equals(form.getForms().Core.Reports))
		{
			printReport();
		}
	}
	
	private void printReport()
	{
		InfectionControlRepeatableAssessmentVo record = form.cmbAllRecords().getValue();

		if (record == null)
			return;

		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();

		String[] obj = null;
		try
		{
			obj = domain.getReportAndTemplate(form.getGlobalContext().Core.getReportID(), form.getGlobalContext().Core.getTemplateID());
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage("Error retrieving report template !\r\n" + e.getMessage());
			return;
		}

		if (obj == null || obj.length == 0)
		{
			engine.showMessage("I could not get the report and template !");
			return;
		}

		QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());

		client.addSeed(new SeedValue("Assessment_id", record.getID_Assessment(), Integer.class));

		String resultUrl = "";

		try
		{
			resultUrl = client.buildReportAsUrl(obj[0], obj[1], urlReportServer, QueryBuilderClient.PDF, "", 1);
		}
		catch (QueryBuilderClientException e1)
		{
			engine.showMessage("Error creating report: " + e1.getMessage());
			return;
		}

		engine.openUrl(resultUrl);
	}
}
