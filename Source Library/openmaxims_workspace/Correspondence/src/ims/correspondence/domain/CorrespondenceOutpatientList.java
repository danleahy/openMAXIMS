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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.correspondence.domain;

// Generated from form domain impl
public interface CorrespondenceOutpatientList extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.correspondence.vo.CorrespondencePatientListsVoCollection listOutpatients(ims.core.vo.OutPatientListSearchCriteriaVo filter, Boolean listByReqAndNotReqStatus);

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVoCollection listActiveLocations();

	// Generated from form domain interface definition
	public ims.core.vo.ClinicLiteVoCollection listClinicsforLocation(ims.core.resource.place.vo.LocationRefVo voLocRef, String strClinicName);

	// Generated from form domain interface definition
	public ims.core.vo.MedicLiteVoCollection listActiveMedics(String strMedicName);

	// Generated from form domain interface definition
	public ims.correspondence.vo.UserAccessVo getUserAccess(Integer userID);

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVoCollection listActiveHospitalsLite();

	// Generated from form domain interface definition
	/**
	* get Correspondence record for specified pasEvent
	*/
	public ims.correspondence.vo.CorrespondenceDetailsVo getCorrespondenceDetailsByPasEvent(ims.core.admin.pas.vo.PASEventRefVo pasEventRef);

	// Generated from form domain interface definition
	/**
	* Returns a MosList based on the search criteria in the passed in filter
	*/
	public ims.core.vo.MemberOfStaffShortVoCollection listMembersOfStaff(ims.core.vo.MemberOfStaffShortVo filter);
}