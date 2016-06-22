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
public interface PhlebotomyCollect extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listRoundsByDate
	*/
	public ims.ocrr.vo.PhlebotomyRoundShortVoCollection listRoundsByDate(ims.framework.utils.Date date);

	// Generated from form domain interface definition
	/**
	* getPhlebotomyRecord
	*/
	public ims.ocrr.vo.PhlebotomyRoundVo getPhlebotomyRecord(ims.ocrr.orderingresults.vo.PhlebotomyRoundRefVo ref);

	// Generated from form domain interface definition
	/**
	* listWorkListItems
	*/
	public ims.ocrr.vo.SpecimenWorkListitemCustomVoCollection listWorkListItems(ims.ocrr.orderingresults.vo.PhlebotomyRoundRefVo round, ims.ocrr.vo.lookups.SpecimenCollectionStatus status);

	// Generated from form domain interface definition
	/**
	* listHcp
	*/
	public ims.core.vo.HcpCollection listHcp(String name);

	// Generated from form domain interface definition
	/**
	* getWorkListItemRecord
	*/
	public ims.ocrr.vo.SpecimenWorkListItemVo getWorkListItemRecord(Integer id);

	// Generated from form domain interface definition
	/**
	* saveWorkListItemRecord
	*/
	public ims.ocrr.vo.SpecimenWorkListItemListVo saveWorkListItemRecord(ims.ocrr.vo.SpecimenWorkListItemVo record, ims.ocrr.vo.OrderSpecimenVo specimen) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* getSpecimentRecord
	*/
	public ims.ocrr.vo.OrderSpecimenVo getSpecimentRecord(ims.ocrr.orderingresults.vo.OrderSpecimenRefVo refId);

	// Generated from form domain interface definition
	/**
	* getHcpByMosId
	*/
	public ims.core.vo.Hcp getHcpByMosId(Integer mosId);

	// Generated from form domain interface definition
	/**
	* getPatientByWorkListItemId
	*/
	public ims.core.vo.PatientShort getPatientByWorkListItemId(Integer id);

	// Generated from form domain interface definition
	public ims.ocrr.vo.SpecimenWorkListItemListVo getWorkListItemListRecord(Integer itemId);

	// Generated from form domain interface definition
	public ims.core.vo.PatientShort getPatientById(Integer patientId);
}
