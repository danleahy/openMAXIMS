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

package ims.core.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseDocumentWorklistImpl extends DomainImpl implements ims.core.domain.DocumentWorklist, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistPatientDocuments(ims.core.vo.DocumentWorklistSearchCriteriaVo searchCriteria)
	{
		if(searchCriteria == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'searchCriteria' of type 'ims.core.vo.DocumentWorklistSearchCriteriaVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistClinicsforLocation(ims.framework.interfaces.ILocation voLocRef, String strClinicName)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientDocument(ims.core.documents.vo.PatientDocumentRefVo documentID)
	{
	}

	@SuppressWarnings("unused")
	public void validatedeletePatientDocument(ims.core.vo.PatientDocumentVo patDoc)
	{
		if(patDoc == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'patDoc' of type 'ims.core.vo.PatientDocumentVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesavePatientDocument(ims.core.vo.PatientDocumentVo document)
	{
	}

	@SuppressWarnings("unused")
	public void validateisStaleObjectException(ims.core.vo.PatientDocumentVo patientDocument)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientGp(ims.core.patient.vo.PatientRefVo patient)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientShort(ims.core.patient.vo.PatientRefVo patRef)
	{
		if(patRef == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'patRef' of type 'ims.core.patient.vo.PatientRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetLockedUser(ims.core.resource.people.vo.MemberOfStaffRefVo mos)
	{
	}

	@SuppressWarnings("unused")
	public void validategetDocumentCategoryConfig(Integer appFormId)
	{
	}
}
