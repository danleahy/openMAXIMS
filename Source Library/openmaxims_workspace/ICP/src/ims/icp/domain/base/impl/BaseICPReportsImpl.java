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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.icp.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseICPReportsImpl extends DomainImpl implements ims.icp.domain.ICPReports, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetReportAndTemplateByImsId(Integer imsId)
	{
	}

	@SuppressWarnings("unused")
	public void validateexistsRecordsForType(ims.icps.instantiation.vo.PatientICPRefVo patientIcpRef, java.lang.Object objType)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCareContext(ims.icps.instantiation.vo.PatientICPRefVo patientIcpRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientDocuments(ims.icps.instantiation.vo.PatientICPRefVo patientICPRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistOrderSpecimens(ims.icps.instantiation.vo.PatientICPRefVo patientIcpRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistOrderInvestigations(ims.icps.instantiation.vo.PatientICPRefVo patientIcpRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistPatientAssessments(ims.icps.instantiation.vo.PatientICPRefVo patientIcpRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistPrinters(Integer locationId)
	{
	}
}
