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

package ims.clinical.domain;

// Generated from form domain impl
public interface ClinicalDiAssociations extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* List all Diagnosis Complications for a Patient
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listComplications(ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	/**
	* listByPatient
	*/
	public ims.core.vo.PatientProblemVoCollection listProblems(ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	/**
	* listProcedureByPatient
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProcedures(ims.core.patient.vo.PatientRefVo patient, ims.core.vo.lookups.PatientProcedureStatus status);

	// Generated from form domain interface definition
	public ims.core.vo.PatientDiagnosisShortVoCollection listDiagnosis(ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	public ims.clinical.vo.ClinicalDIAssociationVoCollection listClinicalDiAssociation(ims.core.clinical.vo.PatientDiagnosisRefVo filter);

	// Generated from form domain interface definition
	public ims.clinical.vo.ClinicalDIAssociationVoCollection listClinicalDiAssociation(ims.core.clinical.vo.PatientProcedureRefVo filter);

	// Generated from form domain interface definition
	public ims.clinical.vo.ClinicalDIAssociationVoCollection listClinicalDiAssociation(ims.core.clinical.vo.PatientProblemRefVo filter);

	// Generated from form domain interface definition
	public ims.clinical.vo.ClinicalDIAssociationVoCollection saveClinicalDiAssociation(ims.clinical.vo.ClinicalDIAssociationVoCollection list) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* save Diagnosis 
	*/
	public ims.core.vo.PatientDiagnosisShortVo saveDiagnosis(ims.core.vo.PatientDiagnosisShortVo patientDiagnosisShortVO) throws ims.domain.exceptions.StaleObjectException;
}
