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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 3947.28740)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.base.impl.BasePharmacyApprovalWorklistImpl;
import ims.clinical.vo.domain.TTAMedicationAndPharmacyShortVoAssembler;
import ims.clinical.vo.lookups.TTAStatus;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.lookups.CareContextStatus;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.PatIdType;
import ims.domain.exceptions.DomainRuntimeException;

import java.util.ArrayList;

public class PharmacyApprovalWorklistImpl extends BasePharmacyApprovalWorklistImpl
{

	private static final long serialVersionUID = 1L;

	/**
	 * Function used to search TTAMedicationAndPharmacy records matching search
	 * criteria
	 */
	public ims.clinical.vo.TTAMedicationAndPharmacyShortVoCollection listTTAMedicationAndPharmacy(ims.clinical.vo.PharmacyApprovalSearchCriteriaVo searchCriteria)
	{
		if (searchCriteria == null)
			throw new DomainRuntimeException("Can not search after null criteria");

		boolean and = false;

		StringBuilder query = new StringBuilder();
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		boolean isCaseSensitivePatIdSearch = ConfigFlag.DOM.CASE_SENSITIVE_PATID.getValue();  //WDEV-18817

		query.append("select ttaMed FROM TTAMedicationAndPharmacy AS ttaMed left join ttaMed.careContext as cCtxt left join cCtxt.currentStatus as cStat left join ttaMed.patient as pat left join pat.identifiers as ids " +
				"left join ids.type as t WHERE (ttaMed.currentTTAStatus.status.id <> :DRAFT_STATUS AND ttaMed.currentTTAStatus.status.id <> :NOT_REQUIRED_STATUS) and cStat.status not in (:idStat) AND ");
		
		paramNames.add("idStat");	
		paramValues.add(getDomLookup(CareContextStatus.CANCELLED));

		paramNames.add("DRAFT_STATUS");					paramNames.add("NOT_REQUIRED_STATUS");
		paramValues.add(TTAStatus.DRAFT.getID());		paramValues.add(TTAStatus.NOT_REQUIRED.getID());

		if (searchCriteria.getFromDateIsNotNull() && searchCriteria.getToDateIsNotNull())
		{
			query.append("ttaMed.dateSubmittedToPharmacy between :DATE_FROM and :DATE_TO");

			paramNames.add("DATE_FROM");
			paramValues.add(searchCriteria.getFromDate().getDate());

			paramNames.add("DATE_TO");
			paramValues.add(searchCriteria.getToDate().getDate());

			and = true;
		}

		if (searchCriteria.getLocationIsNotNull())
		{
			// Add " AND " to query if required
			if (and) query.append(" AND ");

			query.append("ttaMed.careContext.pasEvent.location.id = :WARD");

			paramNames.add("WARD");
			paramValues.add(searchCriteria.getLocation().getID());

			and = true;
		}

		if (searchCriteria.getHCPIsNotNull())
		{
			// Add " AND " to query if required
			if (and) query.append(" AND ");
			
			query.append("ttaMed.orderingClinician.id = :HCP");

			paramNames.add("HCP");
			paramValues.add(searchCriteria.getHCP().getID_Hcp());

			and = true;
		}
		
		if (searchCriteria.getHospitalNumberIsNotNull())
		{
			// Add " AND " to query if required
			if (and) query.append(" AND ");
							   
			query.append("(" + (!isCaseSensitivePatIdSearch ? "UPPER(ids.value)" : "ids.value") + " = :HOSPNUM AND t.id = " + PatIdType.HOSPNUM.getID() + ")"); //WDEV-18817
			
			paramNames.add("HOSPNUM");
			paramValues.add(!isCaseSensitivePatIdSearch ? searchCriteria.getHospitalNumber().trim().toUpperCase() : searchCriteria.getHospitalNumber().trim()); //WDEV-18817
			
			and = true;
		}
		
		if (searchCriteria.getStatusIsNotNull())
		{
			// Add " AND " to query if required
			if (and) query.append(" AND ");

			query.append("ttaMed.currentTTAStatus.status.id = :STATUS");
			
			paramNames.add("STATUS");
			paramValues.add(searchCriteria.getStatus().getID());
		}
		
		// Add search order
		query.append(" order by ttaMed.dateSubmittedToPharmacy asc");
		
		return TTAMedicationAndPharmacyShortVoAssembler.createTTAMedicationAndPharmacyShortVoCollectionFromTTAMedicationAndPharmacy(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}

	/**
	 * Domain function used to search for wards
	 */
	public ims.core.vo.LocationLiteVoCollection listWards(String wardName)
	{
		if (wardName == null)
			throw new DomainRuntimeException("Can not search ward after null name.");

		String query = " FROM Location AS loc WHERE loc.upperName LIKE :NAME AND loc.isActive = 1 AND loc.isVirtual = 0 AND loc.type.id = " + LocationType.WARD.getID() + " order by loc.name asc";

		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();

		paramNames.add("NAME");
		paramValues.add("%" + wardName.toUpperCase() + "%");

		return LocationLiteVoAssembler.createLocationLiteVoCollectionFromLocation(getDomainFactory().find(query, paramNames, paramValues));
	}

	/**
	 * Domain function to search for HCPs matching name
	 */
	public ims.core.vo.HcpLiteVoCollection listHcp(String name)
	{
		if (name == null)
			throw new DomainRuntimeException("Can not search after null name.");

		String query = " FROM Hcp AS hcp WHERE (hcp.mos.name.upperSurname LIKE :SNAME OR hcp.mos.name.upperForename LIKE :FNAME) AND hcp.isActive = 1 order by hcp.mos.name.upperSurname asc, hcp.mos.name.upperForename asc";

		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();

		paramNames.add("SNAME");
		paramNames.add("FNAME");

		paramValues.add("%" + name.toUpperCase() + "%");
		paramValues.add("%" + name.toUpperCase() + "%");

		return HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(getDomainFactory().find(query, paramNames, paramValues));
	}

	
	public CareContextShortVo getCareContext(CareContextRefVo careContext)
	{
		if (careContext == null || !careContext.getID_CareContextIsNotNull())
			throw new DomainRuntimeException("Can not retrieve null care context or care context that has no ID");
		
		return CareContextShortVoAssembler.create((CareContext) getDomainFactory().getDomainObject(CareContext.class, careContext.getID_CareContext()));
	}
}
