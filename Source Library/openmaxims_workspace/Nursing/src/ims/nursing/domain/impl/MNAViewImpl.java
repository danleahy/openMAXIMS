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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.20 build 40820.730)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.nursing.domain.MNAInput;
import ims.nursing.vo.MiniNutritionalAssessment;
import ims.nursing.vo.MiniNutritionalAssessmentCollection;
import ims.nursing.vo.domain.MiniNutritionalAssessmentAssembler;
import ims.core.domain.Reports;
import ims.core.domain.impl.ReportsImpl;
import ims.core.vo.CareContextLiteVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.impl.DomainImpl;
import ims.framework.utils.Date;

public class MNAViewImpl extends DomainImpl implements ims.nursing.domain.MNAView, ims.domain.impl.Transactional
{
	public Boolean isPartOfEatingAssessment(MiniNutritionalAssessment mnaRecord) throws DomainInterfaceException
	{
		MNAInput impl = (MNAInput) getDomainImpl(MNAInputImpl.class);

		return impl.isPartOfEatingAssessment(mnaRecord);
	}

	/**
	 * call getReportAndTemplate form Core.Reports domainImpl
	 */
	public String[] getReportAndTemplate(Integer nReportId, Integer nTemplateId) throws DomainInterfaceException
	{
		Reports impl = (Reports) getDomainImpl(ReportsImpl.class);
		return impl.getReportAndTemplate(nReportId, nTemplateId);
	}

	public MiniNutritionalAssessmentCollection listAssessments(Date dateFrom,Date dateTo, CareContextLiteVo careContextref)
			throws DomainInterfaceException {
		DomainFactory factory = getDomainFactory();

		String filter = " from MiniNutritionalAssessment mna ";
		StringBuffer filterString = new StringBuffer();

		boolean conditionFound = false;

		ArrayList markerNames = new ArrayList();
		ArrayList markerValues = new ArrayList();

		if (dateFrom != null && dateTo != null)
		{
			filterString.append(" mna.dateTimeInitiated > :fromDate and mna.dateTimeInitiated < :toDate ");
			conditionFound = true;
			markerNames.add("fromDate");
			markerNames.add("toDate");
			markerValues.add(dateFrom.addDay(-1).getDate());
			markerValues.add(dateTo.addDay(1).getDate());
		}
		else if (dateFrom != null)
		{
			filterString.append(" mna.dateTimeInitiated > :fromDate ");
			conditionFound = true;
			markerNames.add("fromDate");

			markerValues.add(dateFrom.addDay(-1).getDate());
		}

		if (careContextref != null)
		{
			if (conditionFound)
				filterString.append(" and ");

			
			
			filterString.append(" mna.careContext.id = :careContext ");
			markerNames.add("careContext");
			markerValues.add(careContextref.getID_CareContext());
		}

		String[] names = new String[markerNames.size()];
		markerNames.toArray(names);
		filter += " where ";

		filter += filterString.toString();

		List procs = factory.find(filter, markerNames, markerValues);

		return MiniNutritionalAssessmentAssembler.createMiniNutritionalAssessmentCollectionFromMiniNutritionalAssessment(procs).sort();
	
		
	}
}
