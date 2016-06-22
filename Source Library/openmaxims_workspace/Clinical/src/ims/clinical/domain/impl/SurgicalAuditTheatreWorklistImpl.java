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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4535.14223)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.base.impl.BaseSurgicalAuditTheatreWorklistImpl;
import ims.clinical.helper.IESurgicalAuditHelper;
import ims.clinical.helper.SurgicalAuditHelper;
import ims.clinical.vo.SurgicalAuditTheatreWorklistSearchCriteriaVo;
import ims.clinical.vo.SurgicalAuditTheatreWorklistVoCollection;
import ims.clinical.vo.domain.SurgicalAuditTheatreWorklistVoAssembler;
import ims.configuration.gen.ConfigFlag;
import ims.core.resource.place.vo.LocSiteRefVo;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.domain.DomainFactory;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;

import java.util.ArrayList;
import java.util.List;

public class SurgicalAuditTheatreWorklistImpl extends BaseSurgicalAuditTheatreWorklistImpl
{

	private static final long serialVersionUID = 1L;

	public SurgicalAuditTheatreWorklistVoCollection listSurgicalAudit(SurgicalAuditTheatreWorklistSearchCriteriaVo searchCriteria)
	{

		String hql = "select surgAudit from SurgicalAuditOperationDetail as surgAudit left join surgAudit.patient as patient left join patient.identifiers as identifiers left join surgAudit.currentStatus as status left join status.operationStatus as opStatus left join surgAudit.preOpChecksTheatreNurse.theatreName as theatre ";

		StringBuffer hqlConditions = new StringBuffer();

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		boolean isCaseSensitivePatIdSearch = ConfigFlag.DOM.CASE_SENSITIVE_PATID.getValue();  //WDEV-18817

		String andStr = "";

		if (searchCriteria.getSurnameIsNotNull())
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" patient.name.upperSurname like :msurname ");
			markers.add("msurname");
			values.add(searchCriteria.getSurname().toUpperCase() + "%");
			andStr = " and ";
		}

		String ret = "";
		if (searchCriteria != null && searchCriteria.getForenameIsNotNull())
			ret = searchCriteria.getForename().replaceAll("%", "");

		if (searchCriteria.getForenameIsNotNull() && ret.length() != 0)
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" patient.name.upperForename like :mforename ");
			markers.add("mforename");
			values.add(searchCriteria.getForename().toUpperCase() + "%");
			andStr = " and ";
		}

		if (searchCriteria.getIdTypeIsNotNull() && searchCriteria.getIdValueIsNotNull())
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" identifiers.type = :idType and " + (!isCaseSensitivePatIdSearch ? "UPPER(identifiers.value)" : "identifiers.value") + " = :idValue "); //WDEV-18817
			markers.add("idType");
			values.add(getDomLookup(searchCriteria.getIdType()));
			markers.add("idValue");
			values.add(!isCaseSensitivePatIdSearch ? searchCriteria.getIdValue().trim().toUpperCase() : searchCriteria.getIdValue().trim()); //WDEV-18817
			andStr = " and ";
		}

		if (searchCriteria.getTheatreIsNotNull())
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" theatre.id = :theatre ");
			markers.add("theatre");
			values.add(searchCriteria.getTheatre().getID_Location());
			andStr = " and ";
		}

		if (searchCriteria.getStatusIsNotNull())
		{
			hqlConditions.append(andStr);
			hqlConditions.append("status.operationStatus = :Status ");
			markers.add("Status");
			values.add(getDomLookup(searchCriteria.getStatus()));
			andStr = " and ";
		}

		if (searchCriteria.getDateFromIsNotNull())
		{
			DateTime dateTimeFrom = new DateTime(searchCriteria.getDateFrom(), new Time(0, 0, 0));
			hqlConditions.append(andStr);
			hqlConditions.append(" surgAudit.systemInformation.creationDateTime >= :dateFrom ");
			markers.add("dateFrom");
			values.add(dateTimeFrom.getJavaDate());
			andStr = " and ";
		}

		if (searchCriteria.getDateToIsNotNull())
		{
			DateTime dateTimeTo = new DateTime(searchCriteria.getDateTo(), new Time(23, 59, 59));
			hqlConditions.append(andStr);
			hqlConditions.append(" surgAudit.systemInformation.creationDateTime <= :dateTo ");
			markers.add("dateTo");
			values.add(dateTimeTo.getJavaDate());
			andStr = " and ";
		}

		if (hqlConditions.length() > 0)
		{
			hqlConditions.insert(0, " where (");
			hqlConditions.append(" ) ");
		}

		DomainFactory factory = getDomainFactory();

		List<?> list = factory.find((hql + hqlConditions.toString() + " order by surgAudit.systemInformation.creationDateTime desc").toString(), markers, values, 2000);

		return SurgicalAuditTheatreWorklistVoAssembler.createSurgicalAuditTheatreWorklistVoCollectionFromSurgicalAuditOperationDetail(list);

	}

	public LocationLiteVoCollection listTheatre(LocationRefVo locationRef)
	{
		IESurgicalAuditHelper impl = (IESurgicalAuditHelper) getDomainImpl(SurgicalAuditHelper.class);
		return impl.getTheatre(locationRef);
	}

	public LocationLiteVo getLocationLiteVo(LocSiteRefVo loSiteRef)
	{
		IESurgicalAuditHelper impl = (IESurgicalAuditHelper) getDomainImpl(SurgicalAuditHelper.class);
		return impl.getLocationLiteVo(loSiteRef);
	}

}
