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
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.internalreferralstatushistory;

import ims.clinical.forms.internalreferralstatushistory.GenForm.grdStatusRow;
import ims.clinical.vo.ClinicalReferralStatusLiteVo;
import ims.clinical.vo.ClinicalReferralStatusVo;
import ims.clinical.vo.ClinicalReferralStatusVoCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;
import ims.framework.utils.DateTime;

import java.util.Comparator;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		populateScreenFromData();
	}

	private void populateScreenFromData()
	{
		form.grdStatus().getRows().clear();

		if (form.getGlobalContext().Clinical.getClinicalReferralStatusHistory() == null)
			return;

		ClinicalReferralStatusVoCollection statusHistory = form.getGlobalContext().Clinical.getClinicalReferralStatusHistory();

		statusHistory.sort(new RecordingDateTimeComparator(SortOrder.DESCENDING));

		for (int i = 0; i < statusHistory.size(); i++)
		{
			grdStatusRow newRow = form.grdStatus().getRows().newRow();
			ClinicalReferralStatusLiteVo status = (ClinicalReferralStatusLiteVo) statusHistory.get(i); //WDEV-18958 

			newRow.setColStatus(status.getReferralStatus().getText());
			//WDEV-18958 -- start
			newRow.setCellColStatusTooltip(status.getReferralStatus().getText());
			newRow.setColStatusChangeReason(status.getInternalReferralStatusChangeReasonIsNotNull() ? status.getInternalReferralStatusChangeReason().getText() : "");
			newRow.setCellColStatusChangeReasonTooltip(status.getInternalReferralStatusChangeReasonIsNotNull() ? status.getInternalReferralStatusChangeReason().getText() : "");

			if (status.getRecordingInfo() != null)
			{
				newRow.setColRecordingUser(status.getRecordingInfo().getRecordingUser() != null ? status.getRecordingInfo().getRecordingUser().getIItemText() : "");
				newRow.setCellColRecordingUserTooltip(status.getRecordingInfo().getRecordingUser() != null ? status.getRecordingInfo().getRecordingUser().getIItemText() : ""); //WDEV-18958 
				newRow.setColRecordingDateTime(status.getRecordingInfo().getRecordingDateTime() != null ? status.getRecordingInfo().getRecordingDateTime().toString() : "");
				newRow.setCellColRecordingDateTimeTooltip(status.getRecordingInfo().getRecordingDateTime() != null ? status.getRecordingInfo().getRecordingDateTime().toString() : ""); //WDEV-18958 
			}
			////WDEV-18958 -- end
		}
	}

	@Override
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}

	public class RecordingDateTimeComparator implements Comparator<Object>
	{
		private int direction = 1;

		public RecordingDateTimeComparator()
		{
			this(SortOrder.ASCENDING);
		}

		public RecordingDateTimeComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;

		}

		public int compare(Object ob1, Object ob2)
		{
			DateTime rez1 = null;
			DateTime rez2 = null;

			if (ob1 instanceof ClinicalReferralStatusVo)
			{
				ClinicalReferralStatusVo ps1 = (ClinicalReferralStatusVo) ob1;
				rez1 = ps1.getRecordingInfo() != null && ps1.getRecordingInfo().getRecordingDateTime() != null ? ps1.getRecordingInfo().getRecordingDateTime() : null;
			}

			if (ob2 instanceof ClinicalReferralStatusVo)
			{
				ClinicalReferralStatusVo ps2 = (ClinicalReferralStatusVo) ob2;
				rez2 = ps2.getRecordingInfo() != null && ps2.getRecordingInfo().getRecordingDateTime() != null ? ps2.getRecordingInfo().getRecordingDateTime() : null;
			}

			if (rez1 != null && rez2 != null)
				return rez1.compareTo(rez2) * direction;

			if (rez1 != null && rez2 == null)
				return direction;

			if (rez2 != null && rez1 == null)
				return (-1) * direction;

			return 0;
		}
	}
}
