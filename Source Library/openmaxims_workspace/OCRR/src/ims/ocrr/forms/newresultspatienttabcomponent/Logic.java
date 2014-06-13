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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.ocrr.forms.newresultspatienttabcomponent;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.ServiceLiteVo;
import ims.core.vo.ServiceLiteVoCollection;
import ims.core.vo.enums.MosType;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;
import ims.framework.utils.Date;
import ims.ocrr.forms.newresultspatienttabcomponent.GenForm.ListResultsByEnumeration;
import ims.ocrr.forms.newresultspatienttabcomponent.GenForm.grdDisciplinesRow;
import ims.ocrr.vo.NewResultsCriteriaVo;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private static final int PATIENT = 6;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		// Nothing to do here for a component
		// Keep this event for data binding
	}

	@Override
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getForms().OCRR.SearchDisciplines.equals(formName))
		{
			if (DialogResult.OK.equals(result))
			{
				populateDisciplineGrid(form.getGlobalContext().OCRR.getSelectedDisciplines());
			}
		}
	}

	private void populateDisciplineGrid(ServiceLiteVoCollection disciplines)
	{
		form.grdDisciplines().getRows().clear();

		if (disciplines == null)
			return;

		for (ServiceLiteVo dis : disciplines)
		{
			if (dis == null)
				continue;

			if (!disciplineIsAdded(dis))
			{
				grdDisciplinesRow newRow = form.grdDisciplines().getRows().newRow();
				newRow.setColDis(dis.getServiceName());

				newRow.setValue(dis);
			}
		}
	}

	private boolean disciplineIsAdded(ServiceLiteVo dis)
	{
		if (dis == null)
			return false;

		for (int i = 0; i < form.grdDisciplines().getRows().size(); i++)
		{
			if (dis.equals(form.grdDisciplines().getRows().get(i).getValue()))
				return true;
		}

		return false;
	}

	@Override
	protected void onQmbReviewingHCPValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.qmbReviewingHCP().getValue() != null)
		{
			form.chkReview().setValue(true);
		}
	}

	@Override
	protected void onQmbReviewingHCPTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		populateReviweingHCP(domain.listReviewingHCP(value));
	}

	private void populateReviweingHCP(HcpLiteVoCollection reviewingHCPs)
	{
		form.qmbReviewingHCP().clear();

		if (reviewingHCPs == null)
			return;

		for (HcpLiteVo hcp : reviewingHCPs)
		{
			form.qmbReviewingHCP().newRow(hcp, hcp.getName() != null ? hcp.getName().toString() : "<unknown HCP>");
		}

		if (reviewingHCPs.size() != 1)
		{
			form.qmbReviewingHCP().showOpened();
		}
		else if (reviewingHCPs.size() == 1)
		{
			form.qmbReviewingHCP().setValue(reviewingHCPs.get(0));
			form.chkReview().setValue(true);
		}
	}

	@Override
	protected void onImbRemoveDisciplineClick() throws ims.framework.exceptions.PresentationLogicException
	{
		removeDiscipline();
		updateControlsState();
	}

	private void removeDiscipline()
	{
		if (form.grdDisciplines().getSelectedRowIndex() < 0)
			return;

		form.grdDisciplines().getRows().remove(form.grdDisciplines().getSelectedRowIndex());
	}

	@Override
	protected void onImbAddDisciplineClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().OCRR.setSelectedDisciplines(getDisciplines());
		engine.open(form.getForms().OCRR.SearchDisciplines);
	}

	private ServiceLiteVoCollection getDisciplines()
	{
		if (form.grdDisciplines().getRows().size() == 0)
			return null;

		ServiceLiteVoCollection coll = new ServiceLiteVoCollection();

		for (int i = 0; i < form.grdDisciplines().getRows().size(); i++)
		{
			coll.add(form.grdDisciplines().getRows().get(i).getValue());
		}

		return coll;
	}

	@Override
	protected void onGrdDisciplinesSelectionChanged()
	{
		updateControlsState();
	}

	@Override
	protected void onDteToValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.dteTo().getValue() != null)
		{
			form.cmbDays().setValue(null);
			if (form.dteFrom().getValue() == null)
				form.dteFrom().setValue(form.dteTo().getValue());
		}
	}

	@Override
	protected void onDteFromValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.dteFrom().getValue() != null)
		{
			form.cmbDays().setValue(null);
			if (form.dteTo().getValue() == null)
				form.dteTo().setValue(form.dteFrom().getValue());
		}
	}

	@Override
	protected void onCmbDaysValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		calculateAndSetDateRange();
	}

	public void initialize()
	{
		clear();

		form.ccResponsibleHCP().initializeResponsibleHcp(MosType.HCP, true);
		form.ccOrderingHCP().initialize(MosType.HCP);

		form.chkNew().setValue(true);
		form.chkSeenChecked().setValue(false);
		form.chkChecked().setValue(false);
		form.chkReview().setValue(false);
		form.chkCompleted().setVisible(ConfigFlag.UI.DISPLAY_COMPLETE_FILTER_RESULTS_STATUS.getValue());
		form.chkCompleted().setValue(ConfigFlag.UI.DISPLAY_COMPLETE_FILTER_RESULTS_STATUS.getValue());

		populateDays(ConfigFlag.DOM.OCS_NEWRES_DAYS_MAX.getValue());
		resetDaysToDefault();

		form.ListResultsBy().setValue(ListResultsByEnumeration.rdoNewestFirst);

		updateControlsState();
	}

	private void populateDays(int maxDays)
	{
		form.cmbDays().clear();
		for (int x = 1; x <= maxDays; x++)
		{
			form.cmbDays().newRow(new Integer(x), String.valueOf(x));
		}
	}

	private void resetDaysToDefault()
	{
		form.cmbDays().setValue(new Integer(ConfigFlag.DOM.OCS_NEWRES_DAYS_DEFAULT.getValue()));
		calculateAndSetDateRange();
	}

	private void calculateAndSetDateRange()
	{
		if (form.cmbDays().getValue() != null)
		{
			int days = form.cmbDays().getValue().intValue();
			form.dteTo().setValue(new Date());
			form.dteFrom().setValue(new Date().addDay(-1 * days));
		}
	}

	private void updateControlsState()
	{
		form.imbRemoveDiscipline().setEnabled(form.grdDisciplines().getValue() != null);
		form.chkAbnormalPathologyResultsOnly().setVisible(Boolean.TRUE.equals(ConfigFlag.UI.SHOW_ABNORMAL_RESULTS_SEARCH_FILTER.getValue()));
	}

	public void setValue(ims.ocrr.vo.NewResultsCriteriaVo criteria)
	{
		clear();

		if (criteria == null)
			return;

		form.ccOrderingHCP().setValue(criteria.getOrderingHCP());
		form.ccResponsibleHCP().setValue(criteria.getHCP());

		if (criteria.getReviewingHCP() != null && !form.qmbReviewingHCP().getValues().contains(criteria.getReviewingHCP()))
		{
			form.qmbReviewingHCP().newRow(criteria.getReviewingHCP(), criteria.getReviewingHCP().toString());
		}
		form.qmbReviewingHCP().setValue(criteria.getReviewingHCP());

		form.chkNew().setValue(criteria.getNewUpdated());
		form.chkSeenChecked().setValue(criteria.getSeenChecked());
		form.chkChecked().setValue(criteria.getChecked());
		form.chkReview().setValue(criteria.getForReview());
		form.chkCompleted().setValue(criteria.getCompleted());

		populateDisciplineGrid(criteria.getDiscipline());

		form.dteFrom().setValue(criteria.getFromDate());
		form.dteTo().setValue(criteria.getToDate());
		form.cmbDays().setValue(criteria.getDays());

		form.ListResultsBy().setValue(Boolean.TRUE.equals(criteria.getNewestFirst()) ? ListResultsByEnumeration.rdoNewestFirst : ListResultsByEnumeration.rdoOldestFirst);
		form.chkAbnormalPathologyResultsOnly().setValue(criteria.getAbnormalPathologyResultsOnly());

		updateControlsState();
	}

	public ims.ocrr.vo.NewResultsCriteriaVo getValue()
	{
		NewResultsCriteriaVo newResultsSearchCriteria = new NewResultsCriteriaVo();

		newResultsSearchCriteria.setSelectedTab(PATIENT);
		newResultsSearchCriteria.setPatientId(form.getGlobalContext().Core.getPatientShort() != null ? form.getGlobalContext().Core.getPatientShort().getID_Patient() : null);

		newResultsSearchCriteria.setOrder(true);
		newResultsSearchCriteria.setHCP(form.ccResponsibleHCP().getValue());

		newResultsSearchCriteria.setReviewingHCP(form.qmbReviewingHCP().getValue());
		newResultsSearchCriteria.setOrderingHCP(form.ccOrderingHCP().getValue());

		newResultsSearchCriteria.setNewUpdated(form.chkNew().getValue());
		newResultsSearchCriteria.setSeenChecked(form.chkSeenChecked().getValue());
		newResultsSearchCriteria.setChecked(form.chkChecked().getValue());
		newResultsSearchCriteria.setForReview(form.chkReview().getValue());
		newResultsSearchCriteria.setCompleted(form.chkCompleted().getValue());

		newResultsSearchCriteria.setFromDate(form.dteFrom().getValue());
		newResultsSearchCriteria.setToDate(form.dteTo().getValue());
		newResultsSearchCriteria.setDays(form.cmbDays().getValue());
		newResultsSearchCriteria.setNewestFirst(ListResultsByEnumeration.rdoNewestFirst.equals(form.ListResultsBy().getValue()) ? true : false);

		newResultsSearchCriteria.setDiscipline(getDisciplines());
		newResultsSearchCriteria.setAbnormalPathologyResultsOnly(form.chkAbnormalPathologyResultsOnly().getValue());

		return newResultsSearchCriteria;
	}

	public void setEnabled(Boolean value)
	{
		boolean val = Boolean.TRUE.equals(value);

		form.ccResponsibleHCP().setEnabled(val);
		form.ccOrderingHCP().setEnabled(val);
		form.qmbReviewingHCP().setEnabled(val);
		form.chkNew().setEnabled(val);
		form.chkSeenChecked().setEnabled(val);
		form.chkChecked().setEnabled(val);
		form.chkReview().setEnabled(val);
		form.chkCompleted().setEnabled(val);
		form.dteFrom().setEnabled(val);
		form.dteTo().setEnabled(val);
		form.cmbDays().setEnabled(val);
		form.ListResultsBy().setEnabled(val);
		form.grdDisciplines().setEnabled(val);
		form.imbAddDiscipline().setEnabled(val);
		form.imbRemoveDiscipline().setEnabled(val);
		form.chkAbnormalPathologyResultsOnly().setEnabled(val);

		if (value)
			updateControlsState();
	}

	public void clear()
	{

		form.ccOrderingHCP().clear();
		form.ccResponsibleHCP().clear();
		form.qmbReviewingHCP().clear();

		form.chkNew().setValue(false);
		form.chkSeenChecked().setValue(false);
		form.chkChecked().setValue(false);
		form.chkReview().setValue(false);
		form.chkCompleted().setValue(false);

		form.grdDisciplines().getRows().clear();
		form.dteFrom().setValue(null);
		form.dteTo().setValue(null);
		form.cmbDays().setValue(null);

		form.ListResultsBy().setValue(ListResultsByEnumeration.rdoNewestFirst);
		form.chkAbnormalPathologyResultsOnly().setValue(null);
	}

	public String[] validate()
	{
		ArrayList<String> errors = new ArrayList<String>();

		if (form.dteFrom().getValue() != null && form.dteTo().getValue() != null)
		{
			if (form.dteFrom().getValue().isGreaterThan(form.dteTo().getValue()))
			{
				errors.add("The \"From Date\" is after the \"To Date\"");
			}
		}

		if ((form.dteFrom().getValue() == null || form.dteTo().getValue() == null) && form.cmbDays().getValue() == null)
		{
			errors.add("Invalid date range specified.");
		}

		if ((form.dteFrom().getValue() == null || form.dteTo().getValue() == null) && form.cmbDays().getValue() != null)
		{
			calculateAndSetDateRange();
		}

		if (form.qmbReviewingHCP().getValue() != null && form.chkReview().getValue() == false)
		{
			errors.add("If Reviewing HCP is selected, 'For Review' status must be checked.");
		}

		if (form.chkNew().getValue() == false && form.chkSeenChecked().getValue() == false && form.chkChecked().getValue() == false && form.chkReview().getValue() == false && form.chkCompleted().getValue() == false)
		{
			errors.add("At least one of the checkboxes for Result Status must be checked");
		}

		if (errors != null && errors.size() > 0)
		{
			String[] errorsS = new String[errors.size()];
			errors.toArray(errorsS);

			return errorsS;
		}

		return null;
	}

	public SortOrder getSortOrder()
	{
		if (ListResultsByEnumeration.rdoNewestFirst.equals(form.ListResultsBy().getValue()))
			return SortOrder.DESCENDING;
		else if (ListResultsByEnumeration.rdoOldestFirst.equals(form.ListResultsBy().getValue()))
			return SortOrder.ASCENDING;

		return SortOrder.DESCENDING;
	}
}