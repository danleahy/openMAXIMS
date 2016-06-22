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

package ims.RefMan.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseReferralTriageImpl extends DomainImpl implements ims.RefMan.domain.ReferralTriage, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetCatsReferral(ims.RefMan.vo.CatsReferralRefVo catsReferral)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatient(ims.core.patient.vo.PatientRefVo patient)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveCatsReferral(ims.RefMan.vo.CatsReferralForReferralTriageVo catsReferral, Boolean isReferralRejected)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistRedirectedHCPs(String value, ims.core.clinical.vo.ServiceRefVo service, ims.core.resource.people.vo.HcpRefVo currentResponsibleHcpRef, ims.core.vo.lookups.ServiceFunction serviceFunction)
	{
	}

	@SuppressWarnings("unused")
	public void validategetServicesForCatsReferral(ims.RefMan.vo.CatsReferralRefVo getServicesForCatsReferral)
	{
	}

	@SuppressWarnings("unused")
	public void validateundoTriageOutcome(ims.RefMan.vo.CatsReferralForReferralTriageVo catsReferral, ims.framework.FormName formName)
	{
	}

	@SuppressWarnings("unused")
	public void validategetFormMenuAction(Integer formId)
	{
	}

	@SuppressWarnings("unused")
	public void validateisConsultantAssociatedToRedirectedService(ims.core.clinical.vo.ServiceRefVo serviceRef, ims.core.resource.people.vo.HcpRefVo hcpRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatecreateCaseNoteFolderIfNone(ims.core.patient.vo.PatientRefVo patient)
	{
	}
}
