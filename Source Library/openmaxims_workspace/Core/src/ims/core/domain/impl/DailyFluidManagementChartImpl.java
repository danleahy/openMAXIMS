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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.45 build 2272.27859)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.admin.vo.ReportVoCollection;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.domain.Reports;
import ims.core.domain.VitalSignsVentilationChart;
import ims.core.domain.base.impl.BaseDailyFluidManagementChartImpl;
import ims.core.vo.ShiftDetailsVoCollection;
import ims.core.vo.domain.ShiftDetailsVoAssembler;
import ims.domain.DomainFactory;
import ims.framework.enumerations.SortOrder;

public class DailyFluidManagementChartImpl extends BaseDailyFluidManagementChartImpl
{
	private static final long serialVersionUID = 1L;

	/**
	* listShiftDetails
	*/
	public ims.core.vo.ShiftDetailsVoCollection listShiftDetails(CareContextRefVo voCareContextRef)
	{
		return ((VitalSignsVentilationChart)getDomainImpl(VitalSignsVentilationChartImpl.class)).listShiftDetails(voCareContextRef);
	}

	public ReportVoCollection listAssignedReports(Integer formId)
	{
		return ((Reports)getDomainImpl(ReportsImpl.class)).listAssignedReports(formId);
	}

	public String[] getReportAndTemplate(Integer reportId, Integer templateId)
	{
		String[] result = null;
		
		DomainFactory factory = getDomainFactory();
		
		List lst = factory.find("select r1_1.reportXml, t1_1.templateXml, r1_1.reportName, r1_1.reportDescription, t1_1.name, t1_1.description from ReportBo as r1_1 left join r1_1.templates as t1_1 where (r1_1.id = :rid  and t1_1.id = :tid)", new String[] {"rid", "tid"}, new Object[] {reportId, templateId});
		
		if(lst.iterator().hasNext())
		{
			Object[] obj = (Object[])lst.iterator().next();
			
			result = new String[] {(String)obj[0], (String)obj[1], (String)obj[2], (String)obj[3], (String)obj[4], (String)obj[5]};
		}
		
		return result;
	}

	public ShiftDetailsVoCollection listShiftDetailsByCareContext(CareContextRefVo refCareContext) 
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from ShiftDetails t ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		if (refCareContext == null)
			return null;
		
		hql.append(" t.careContext.id = :cc");
		markers.add("cc");
		values.add(refCareContext.getID_CareContext());
		query += " where ";
		
		query += hql.toString();
		List shiftList = factory.find(query, markers, values);
		return ShiftDetailsVoAssembler.createShiftDetailsVoCollectionFromShiftDetails(shiftList).sort(SortOrder.DESCENDING);
	}


}
