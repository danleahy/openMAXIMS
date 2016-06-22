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

package ims.RefMan.domain;

// Generated from form domain impl
public interface ReferralWizard extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralWizardVo getCatsReferral(ims.RefMan.vo.CatsReferralRefVo voCatsRef);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralWizardVo saveCatsReferral(ims.RefMan.vo.CatsReferralWizardVo record) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.Patient getPatient(ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	/**
	* Returns a HcpLiteVo
	*/
	public ims.core.vo.HcpLiteVo getHcpLiteById(ims.core.resource.people.vo.HcpRefVo refId);

	// Generated from form domain interface definition
	/**
	* save Care spell and referral 
	*/
	public ims.RefMan.vo.CatsReferralWizardVo saveCareSpellAndReferralDetails(ims.RefMan.vo.CatsReferralWizardVo referVo, ims.core.vo.CareSpellVo voCareSpell, Boolean bDiagnosticReferral) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.ServiceVo getServiceById(ims.core.vo.ServiceVo voService);

	// Generated from form domain interface definition
	public ims.core.vo.GpShortVo getPatientsGp(Integer idPatient);

	// Generated from form domain interface definition
	/**
	* pukkaJMessaging
	*/
	public void pukkaJMessaging(ims.RefMan.domain.objects.CatsReferral doCatsReferral, Boolean isCreateOrder) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.CareContextShortVo getCareContext(ims.core.admin.vo.CareContextRefVo careContextRef);

	// Generated from form domain interface definition
	/**
	* This method is called to see if the referral urgency saved is TwoWeekWait or ConsultantUpgrade, then 62 day target is to be brought into scope
	* 
	*/
	public void check62dayTarget(ims.RefMan.vo.CatsReferralWizardVo referral, ims.RefMan.vo.lookups.ReferralUrgency prevReferralUrgency, ims.RefMan.vo.lookups.CancerType prevCancerType) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.RefMan.vo.CancerTypeConfigVo getCancerTypeConfig();

	// Generated from form domain interface definition
	public Boolean hasLocationDiagnosicContracts(ims.core.resource.place.vo.LocationRefVo location);

	// Generated from form domain interface definition
	public ims.framework.utils.Date getEndDateKPI(ims.RefMan.vo.CatsReferralWizardVo catsReferral);
}
