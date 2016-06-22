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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.18 build 40623.1500)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.clinicalnotesview;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.ClinicalContactFilterVo;
import ims.core.vo.ClinicalNotesFilterVo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.nursing.vo.ClinicalNotesViewFilterVo;
import ims.nursing.vo.NursingClinicalNotesListVo;
import ims.nursing.vo.NursingClinicalNotesListVoCollection;

import java.util.Comparator;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		//wdev-10788
		if(form.getGlobalContext().Nursing.getClinicalNotesViewFilterIsNotNull())
		{
			ClinicalNotesViewFilterVo tempVo = form.getGlobalContext().Nursing.getClinicalNotesViewFilter();
			form.chkActiveOnly().setValue(tempVo.getActive());
			form.dateFrom().setValue(tempVo.getFromDate());
			form.dateTo().setValue(tempVo.getToDate());
			
		}
		else	//wdev-10788
		{
		
			form.chkActiveOnly().setValue(true);
			Date lastMonth = new Date();
			lastMonth.setMonth(lastMonth.getMonth() - 1);
			form.dateFrom().setValue(lastMonth);
			form.dateTo().setValue(new Date());
		}

		if (domain.getHcpLiteUser() == null)//WDEV-15037
		{
			form.bNew().setEnabled(false);
		}
		else
		{
			form.bNew().setEnabled(true);
		}
		
		listNotes();

		setVisibilityForLinkCarePlan();
	}

	private void listNotes()
	{
		form.getLocalContext().setsortOrder(0);
		form.btnPrintReport().setEnabled(false);
		form.gridNotes().getRows().clear();

		CareContextShortVo careContextVo = form.getGlobalContext().Core.getCurrentCareContext();

		NursingClinicalNotesListVoCollection notesColl = domain.listClinicNotes(form.dateFrom().getValue(), form.dateTo().getValue(), new Boolean(form.chkActiveOnly().getValue()), careContextVo);
		form.getLocalContext().setClinicalNotesColl(notesColl);
		
		if (notesColl != null)
		{

			GenForm.gridNotesRow row;
			NursingClinicalNotesListVo notes;
			for (int i = 0; i < notesColl.size(); i++)
			{
				notes = notesColl.get(i);
				row = form.gridNotes().getRows().newRow();
				if (notes.getAuthoringInformationIsNotNull())
				{
					if (notes.getAuthoringInformation().getAuthoringHcpIsNotNull())
						row.setcolBy(notes.getAuthoringInformation().getAuthoringHcp().toString());
				}
				if (notes.getRecordingDateTime() != null)
				{
					row.setcolDate(notes.getRecordingDateTime().toString());
				}

				if (notes.getIsCorrected() != null && notes.getIsCorrected().booleanValue() == true && notes.getCurrentStatus().getCorrectionReasonIsNotNull() && notes.getCurrentStatus().getCorrectedByIsNotNull() && notes.getCurrentStatus().getDateTimeIsNotNull()) // Correction has been added
				{
					String strHCPCorrection = "";

					if (notes.getCurrentStatusIsNotNull())
					{
						if (notes.getCurrentStatus().getCorrectedByIsNotNull())

							strHCPCorrection = notes.getCurrentStatus().getCorrectedBy().getName().toString();
					}
					row.setcolNote(notes.getClinicalNote() + "\nCorrected By: " + strHCPCorrection + " on " + notes.getCurrentStatus().getDateTime().getDate() + " at " + notes.getCurrentStatus().getDateTime().getTime() + " for the following reason:\n" + notes.getCurrentStatus().getCorrectionReason());
				}
				else
				{
					row.setcolNote(notes.getClinicalNote());
				}

				row.setValue(notes);
				refreshSearchCriteriaFilter();	//wdev-10788
			}
			form.btnPrintReport().setEnabled(! engine.isRIEMode()); //WDEV-15079
			form.gridNotes().setSelectable(! engine.isRIEMode()); //WDEV-15114
		}
		if(form.gridNotes().getRows().size() < 1)
			form.getGlobalContext().Nursing.setClinicalNotesViewFilter(null);	//wdev-10788
	}

	//wdev-10788
	private void refreshSearchCriteriaFilter()
	{
		ClinicalNotesViewFilterVo tempVo = new ClinicalNotesViewFilterVo();
		tempVo.setActive(form.chkActiveOnly().getValue());
		tempVo.setFromDate(form.dateFrom().getValue());
		tempVo.setToDate(form.dateTo().getValue());
		form.getGlobalContext().Nursing.setClinicalNotesViewFilter(tempVo);
		
	}
	//------------
	protected void onGridNotesSelectionChanged()
	{
		if(form.gridNotes().getValue() != null)
		{
			form.getGlobalContext().COE.setClinicalNotesVo( domain.getClinicalNoteById(form.gridNotes().getValue().getID_ClinicalNotes()));
			engine.open(form.getForms().Nursing.ClinicalNotes);
		}
	}

	protected void onButtonNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Set clinical notes to null so the form will know it's for a new note
		form.getGlobalContext().COE.setClinicalNotesVo(null);
		engine.open(form.getForms().Nursing.ClinicalNotes);
	}

	protected void onButtonOKClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.dateFrom().getValue() != null && form.dateTo().getValue() != null && form.dateFrom().getValue().isGreaterThan(form.dateTo().getValue()))
		{
			engine.showErrors(new String[]{"Please enter From and To dates that are in chronological order."});
			return;
		}
		listNotes();
	}

	protected void onChkActiveOnlyValueChanged() throws PresentationLogicException
	{
		// listNotes();
	}

	protected void onBtnPrintReportClick() throws PresentationLogicException
	{
		/*
		 * if(ConfigFlag.GEN.REPORTS_TYPE.getValue().equals("Crystal")) { form.getGlobalContext().Core.Reports.setStartDate(form.dateFrom().getValue()); form.getGlobalContext().Core.Reports.setEndDate(form.dateTo().getValue()); engine.open(form.getForms().COE.RptClinicalNotes); } else if(ConfigFlag.GEN.REPORTS_TYPE.getValue().equals("QueryBuilder")) engine.open(form.getForms().Core.Reports);
		 */

		engine.open(form.getForms().Core.Reports);
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (result.equals(DialogResult.OK) && formName.equals(form.getForms().Core.Reports))
		{
			printReport();
		}
	}

	private void printReport()
	{
		if (form.gridNotes().getRows().size() == 0)
		{
			engine.showMessage("No data to print");
			return;
		}

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

		CareContextShortVo careContext = form.getGlobalContext().Core.getCurrentCareContext();

		if (careContext == null)
		{
			engine.showMessage("There is no care context selected !");
			return;
		}
		
		if (form.dateFrom().getValue() == null)
		{
			engine.showMessage("There is no date from selected !");
			return;
		}
		
		if (form.dateTo().getValue() == null)
		{
			engine.showMessage("There is no date to selected !");
			return;
		}
		
		QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());

		client.addSeed(new SeedValue("ID_CareContext", careContext.getID_CareContext(), Integer.class));
		client.addSeed(new SeedValue("DATE_START", form.dateFrom().getValue().getDate(), java.util.Date.class));
		Date d = new Date(form.dateTo().getValue());
		d.addDay(1);
		client.addSeed(new SeedValue("DATE_END", d.getDate(), java.util.Date.class));

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

	private class ClinicalNotesListVoComparator implements Comparator
	{
		int	order;

		public ClinicalNotesListVoComparator(Integer getsortOrder)
		{
			this.order = getsortOrder;
		}

		public int compare(Object obj1, Object obj2)
		{

			NursingClinicalNotesListVo voObject1 = (NursingClinicalNotesListVo) obj1;
			NursingClinicalNotesListVo voObject2 = (NursingClinicalNotesListVo) obj2;

			if (order == 0)
			{
				return -1 * (voObject1.getRecordingDateTime().getJavaDate().compareTo(voObject2.getRecordingDateTime().getJavaDate()));
			}
			else if (order == 1)
			{
				return (voObject1.getRecordingDateTime().getJavaDate().compareTo(voObject2.getRecordingDateTime().getJavaDate()));

			}
			return 1;
		}
		
	}

	@Override
	protected void onGridHeaderClicked(int column) throws PresentationLogicException
	{

		if (column == 0)
		{
			sortDates();

		}

	}

	private void sortDates()
	{
		NursingClinicalNotesListVoCollection gridContents = form.getLocalContext().getClinicalNotesColl();

		if (form.getLocalContext().getsortOrder() == 0)
		{
			form.getLocalContext().setsortOrder(1);
		}
		else if (form.getLocalContext().getsortOrder() == 1)
		{
			form.getLocalContext().setsortOrder(0);

		}

		gridContents.sort(new ClinicalNotesListVoComparator(form.getLocalContext().getsortOrder()));
		populateGrid(gridContents);
	}

	private void populateGrid(NursingClinicalNotesListVoCollection gridContents)
	{
		form.gridNotes().getRows().clear();

		if (gridContents != null)
		{

			GenForm.gridNotesRow row;
			NursingClinicalNotesListVo notes;
			for (int i = 0; i < gridContents.size(); i++)
			{
				notes = gridContents.get(i);
				row = form.gridNotes().getRows().newRow();
				if (notes.getAuthoringInformationIsNotNull())
				{
					if (notes.getAuthoringInformation().getAuthoringHcpIsNotNull())
						row.setcolBy(notes.getAuthoringInformation().getAuthoringHcp().toString());
				}
				if (notes.getRecordingDateTime() != null)
				{
					row.setcolDate(notes.getRecordingDateTime().toString());
				}

				if (notes.getIsCorrected() != null && notes.getIsCorrected().booleanValue() == true && notes.getCurrentStatus().getCorrectionReasonIsNotNull() && notes.getCurrentStatus().getCorrectedByIsNotNull() && notes.getCurrentStatus().getDateTimeIsNotNull()) // Correction has been added
				{
					String strHCPCorrection = "";

					if (notes.getCurrentStatusIsNotNull())
					{
						if (notes.getCurrentStatus().getCorrectedByIsNotNull())

							strHCPCorrection = notes.getCurrentStatus().getCorrectedBy().getName().toString();
					}
					row.setcolNote(notes.getClinicalNote() + "\nCorrected By: " + strHCPCorrection + " on " + notes.getCurrentStatus().getDateTime().getDate() + " at " + notes.getCurrentStatus().getDateTime().getTime() + " for the following reason:\n" + notes.getCurrentStatus().getCorrectionReason());
				}
				else
				{
					row.setcolNote(notes.getClinicalNote());
				}

				row.setValue(notes);
			}

		}

	}

	@Override
	protected void onLnkCarePlanClick() throws PresentationLogicException 
	{
		engine.open(form.getForms().Nursing.CarePlanDetails);
	}
	
	private void setVisibilityForLinkCarePlan() 
	{
		form.lnkCarePlan().setVisible(FormMode.VIEW.equals(form.getMode()) && isClinicalNotesViewCarePlanDetailsAlias());
	}
	
	private boolean isClinicalNotesViewCarePlanDetailsAlias() 
	{
		return engine.getFormName().equals(form.getForms().Nursing.ClinicalNotesViewCarePlanDetails);
	}
}
