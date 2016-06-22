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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5332.26009)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.core.domain.base.impl.BaseCaseNoteTrackingBatchTransferImpl;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.PatientCaseNoteBatchTransferVoCollection;
import ims.core.vo.domain.PatientCaseNoteBatchTransferVoAssembler;
import ims.core.vo.lookups.CaseNoteStatus;
import ims.core.vo.lookups.PatIdType;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class CaseNoteTrackingBatchTransferImpl extends BaseCaseNoteTrackingBatchTransferImpl
{

	private static final long serialVersionUID = 1L;

	public LocationLiteVoCollection listCaseNoteLocations(String name)
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listCaseNoteFolderLocations(name);
	}

	private String getValidStatusesIds()
	{

		StringBuilder statusesIds = new StringBuilder();

		statusesIds.append(CaseNoteStatus.ACTIVE.getID());
		statusesIds.append(", " + CaseNoteStatus.REQUIRES_MERGING.getID());
		statusesIds.append(", " + CaseNoteStatus.MARKED_AS_FOUND.getID());

		return statusesIds.toString();
	}

	public Integer getPatientIdForIdentifier(PatIdType idType, String value)
	{
		if (value == null || value.length() == 0)
			throw new CodingRuntimeException("Cannot get Patient on null Identifier");

		List list = getDomainFactory().find("select pat.id from Patient as pat left join pat.identifiers as patIdent left join patIdent.type as identType where identType.id = :typeID and upper(patIdent.value) = :value	", new String[] { "typeID", "value" }, new Object[] { idType.getID(), value.toUpperCase() });

		if (list == null || list.size() == 0)
			return 0;

		return (Integer) list.get(0);
	}

	public Boolean recordExistsForTrackingID(String trackingID)
	{
		if (trackingID == null || trackingID.length() == 0)
			throw new CodingRuntimeException("Cannot get Patient Case Note on null trackingID");

		List list = getDomainFactory().find("select caseNote from PatientCaseNote as caseNote where upper(caseNote.trackingID) = :trackingID ", new String[] { "trackingID" }, new Object[] { trackingID.toUpperCase() });

		if (list == null || list.size() == 0)
			return false;

		return true;
	}
	//WDEV-20122
	
	public PatientCaseNoteBatchTransferVoCollection listCaseNotes(String patientID, String trackingID,ArrayList<Integer> trackingIDsFromGrid) 
	{
		StringBuilder query = new StringBuilder("SELECT caseNote FROM PatientCaseNote AS caseNote LEFT JOIN caseNote.patient AS patient LEFT JOIN  caseNote.status AS caseNoteStatus ");

		String statusesIds = getValidStatusesIds();
		ArrayList<String> id = new ArrayList<String>();
		id.add(trackingID);
		query.append("WHERE caseNoteStatus.id IN ( ").append(statusesIds).append(" ) ");


		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();

		String gridIDs = getGridIDs(trackingIDsFromGrid);
		if (gridIDs != null && gridIDs.length() > 0)
		{
			query.append(" AND (caseNote.id NOT IN ( ").append(gridIDs);
			query.append("))");
		}

		if (patientID != null && patientID.length() > 0)
		{
			query.append(" AND patient.id = " + patientID + " ");
		}

		else if (trackingID != null && trackingID.length() > 0)

		{
			query.append(" AND ( caseNote.trackingID = :TRACKING_ID  ))");
			paramNames.add("TRACKING_ID");
			paramValues.add(trackingID);
		}

		query.append(" ORDER BY caseNote.creationDate DESC");

		return PatientCaseNoteBatchTransferVoAssembler.createPatientCaseNoteBatchTransferVoCollectionFromPatientCaseNote(getDomainFactory().find(query.toString(),paramNames, paramValues));

	}

	private String getGridIDs(ArrayList<Integer> trackingIDsFromGrid)
	{
		if (trackingIDsFromGrid == null)
			return null;
		
		StringBuilder gridIDs = new StringBuilder();

		for (int i = 0; i < trackingIDsFromGrid.size(); i++) 
		{
			gridIDs.append(trackingIDsFromGrid.get(i));

			if (i < trackingIDsFromGrid.size() - 1)
				gridIDs.append(" , ");
		}

		return gridIDs.toString();
	}	
	
	//WDEV-20122
	
	public PatientCaseNoteBatchTransferVoCollection listCaseNotes(ArrayList<Integer> trackingIds)
	{
		StringBuilder query = new StringBuilder("SELECT caseNote FROM PatientCaseNote AS caseNote LEFT JOIN caseNote.patient AS patient LEFT JOIN  caseNote.status AS caseNoteStatus ");

		String statusesIds = getValidStatusesIds();

		query.append("WHERE caseNoteStatus.id IN ( " + statusesIds + " ) ");


		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();

		String gridIDs = getGridIDs(trackingIds);
		if (gridIDs != null && gridIDs.length() > 0)
		{
			query.append(" AND (caseNote.id IN ( ").append(gridIDs);
			query.append("))");
		}

		query.append(" ORDER BY caseNote.creationDate DESC");

		return PatientCaseNoteBatchTransferVoAssembler.createPatientCaseNoteBatchTransferVoCollectionFromPatientCaseNote(getDomainFactory().find(query.toString(),paramNames, paramValues));
	}
	
}
