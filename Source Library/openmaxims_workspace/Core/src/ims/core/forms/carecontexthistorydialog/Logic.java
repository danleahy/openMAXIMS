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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.core.forms.carecontexthistorydialog;

import java.util.Comparator;

import ims.core.forms.carecontexthistorydialog.GenForm.grdCareContextHistoryRow;

import ims.core.vo.CareContextHistVo;
import ims.core.vo.CareContextHistVoCollection;
import ims.core.vo.CareContextSmallVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;
import ims.framework.utils.DateTime;


public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.grdCareContextHistory().getRows().clear();
		CareContextSmallVo tempVo = form.getGlobalContext().Clinical.getCareContextWithHistory();
		if(tempVo != null && tempVo.getCareContextHistoryIsNotNull() && tempVo.getCareContextHistory().size() > 0)
		{
			CareContextHistVoCollection tempColl = tempVo.getCareContextHistory();
		
			tempColl.sort(new CreationDateComparator(SortOrder.ASCENDING));
			for(int i = 0;i < tempColl.size();i++)
			{
				CareContextHistVo voHist = tempColl.get(i);
				if(voHist != null)
					populateChildGrid(voHist);
			}
		}
		
	}
	protected void populateChildGrid(CareContextHistVo voHist)
	{
		if(voHist == null)
			return;
		grdCareContextHistoryRow careContextRow = form.grdCareContextHistory().getRows().newRow();
		careContextRow.setColumnContextType(voHist.getContextIsNotNull() ? voHist.getContext().getIItemText():"");
		careContextRow.setTooltipForColumnContextType(voHist.getContextIsNotNull() ? voHist.getContext().getIItemText():"");
		careContextRow.setColumnStartDateTime(voHist.getStartDateTimeIsNotNull() ? voHist.getStartDateTime().toString():"");
		careContextRow.setTooltipForColumnStartDateTime(voHist.getStartDateTimeIsNotNull() ? voHist.getStartDateTime().toString():"");
		careContextRow.setColumnEndDateTime(voHist.getEndDateTimeIsNotNull() ? voHist.getEndDateTime().toString():"");
		careContextRow.setTooltipForColumnEndDateTime(voHist.getEndDateTimeIsNotNull() ? voHist.getEndDateTime().toString():"");
		careContextRow.setColumnResponsibleHCP(voHist.getResponsibleHCPIsNotNull() ? voHist.getResponsibleHCP().getMos().toString():"");
		careContextRow.setTooltipForColumnResponsibleHCP(voHist.getResponsibleHCPIsNotNull() ? voHist.getResponsibleHCP().getMos().toString():"");
		careContextRow.setColumnChangedDateTime(voHist.getSystemInformationIsNotNull() && voHist.getSystemInformation().getCreationDateTime() != null ? voHist.getSystemInformation().getCreationDateTime().toString():"");
		careContextRow.setTooltipForColumnChangedDateTime(voHist.getSystemInformationIsNotNull() && voHist.getSystemInformation().getCreationDateTime() != null ? voHist.getSystemInformation().getCreationDateTime().toString():"");
		
		
		
	}
	
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}
	public class CreationDateComparator implements Comparator
	{
		private int direction = 1;
		
		public CreationDateComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public CreationDateComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			DateTime pdate1 = null;
			DateTime pdate2 = null;
			if(ob1 instanceof CareContextHistVo )
			{
				CareContextHistVo ps1 = (CareContextHistVo)ob1;
				pdate1 = ps1 != null && ps1.getSystemInformationIsNotNull() ? ps1.getSystemInformation().getCreationDateTime():null;
			}
			if(ob2 instanceof CareContextHistVo)
			{
				CareContextHistVo ps2 = (CareContextHistVo)ob2;
				pdate2 = ps2 != null && ps2.getSystemInformationIsNotNull() ? ps2.getSystemInformation().getCreationDateTime():null;
			}
			if(pdate1 != null )
				return  pdate1.compareTo(pdate2)*direction;
			if(pdate2 != null)
				return (-1)*direction;
			
			return 0;
		}
	
	}
}
