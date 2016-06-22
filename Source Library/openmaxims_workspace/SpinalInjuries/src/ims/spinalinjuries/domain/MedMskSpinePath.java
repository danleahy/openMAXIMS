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

package ims.spinalinjuries.domain;

// Generated from form domain impl
public interface MedMskSpinePath extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Gets the SpinePathology details for the given contact
	*/
	public ims.generalmedical.vo.MSKSpinePathologyFindingVoCollection getMskSpinePath(ims.core.vo.ClinicalContactShortVo clinicalContact, Boolean activeOnly);

	// Generated from form domain interface definition
	/**
	* Saves the given details
	*/
	public ims.generalmedical.vo.MSKSpinePathologyFindingVo saveMskSpinePath(ims.generalmedical.vo.MSKSpinePathologyFindingVo exam, ims.core.vo.CareContextShortVo careContext) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* List VeretralLevel
	*/
	public ims.core.vo.VertebrallevelVoCollection listVertebralLevel(Boolean activeOnly);

	// Generated from form domain interface definition
	/**
	* get Spine pathology By CareContext
	*/
	public ims.generalmedical.vo.MSKSpinePathologyFindingShortVoCollection listByCareContext(ims.core.vo.CareContextLiteVo voCareContext);

	// Generated from form domain interface definition
	/**
	* get By Care Context
	*/
	public ims.generalmedical.vo.MSKSpinePathologyFindingVoCollection getByCareContext(ims.core.vo.CareContextLiteVo voCareContext, Boolean active);

	// Generated from form domain interface definition
	/**
	* checks if there is a Clinical Contact of type SpinalMedicalAdission that has a Spine pathology within the CareContext, if so it will be displayed
	*/
	public ims.generalmedical.vo.MSKSpinePathologyFindingVoCollection getSpinalMedicalAdmissionPathologyByCareContext(ims.core.admin.vo.CareContextRefVo voCareContextRef);

	// Generated from form domain interface definition
	/**
	* listHcpLiteByName
	*/
	public ims.core.vo.HcpLiteVoCollection listHcpLiteByName(String hcpName);

	// Generated from form domain interface definition
	/**
	* countForPrimaryPathology
	*/
	public Integer countForPrimaryPathology(ims.core.vo.PatientShort pID);

	// Generated from form domain interface definition
	public ims.generalmedical.vo.MSKSpinePathologyFindingVo getMskSpinePathForPrimaryPathology(ims.core.patient.vo.PatientRefVo voRef);
}
