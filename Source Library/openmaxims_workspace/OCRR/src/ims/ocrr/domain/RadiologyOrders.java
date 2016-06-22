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

package ims.ocrr.domain;

// Generated from form domain impl
public interface RadiologyOrders extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* list Order Investigation
	*/
	public ims.ocrr.vo.RadiologyOrderVoCollection listRadOrderInvestigation(ims.core.clinical.vo.ServiceRefVo serviceRefVo, ims.core.resource.place.vo.LocationRefVo voLocationRef, ims.ocrr.vo.lookups.Category category, Boolean bCompleted, ims.framework.utils.Date fromDate, ims.framework.utils.Date toDate);

	// Generated from form domain interface definition
	/**
	* List Location
	*/
	public ims.core.vo.LocationLiteVoCollection listLocation(ims.core.vo.lookups.LocationType type, Boolean active);

	// Generated from form domain interface definition
	/**
	* list Service
	*/
	public ims.core.vo.ServiceLiteVoCollection listService(ims.core.resource.place.vo.LocationRefVo locationRefVo, ims.core.vo.lookups.ServiceCategory serviceCategory);

	// Generated from form domain interface definition
	/**
	* getReportAndTemplate
	*/
	public String[] getReportAndTemplate(Integer reportId, Integer templateId) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* listAssignedReports
	*/
	public ims.admin.vo.ReportVoCollection listAssignedReports(Integer formId);

	// Generated from form domain interface definition
	/**
	* List of Pathology Tests
	*/
	public ims.ocrr.vo.PathologyOrderVoCollection listPathOrderInvestigation(ims.core.clinical.vo.ServiceRefVo serviceRefVo, ims.ocrr.vo.lookups.Category category);

	// Generated from form domain interface definition
	/**
	* getRoleDisciplineSecurityLevels
	*/
	public ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo getRoleDisciplineSecurityLevels(ims.framework.interfaces.IAppRole role);

	// Generated from form domain interface definition
	/**
	* getCatsReferralByOrder
	*/
	public ims.RefMan.vo.CatsReferralListVo getCatsReferralByOrder(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo voOcsOrder);
}
