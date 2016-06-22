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

package ims.ccosched.domain;

// Generated from form domain impl
public interface CancelledAppointments extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* ims.dto.client.Sd_appt_dts
	*/
	public ims.dto.client.Sd_appt_dts listSd_appt_dts(String grp_id, String activ_id, String prty, String appt_stat, String act_comp_flg) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* gets the dto Patient record based on pkey
	*/
	public ims.dto.client.Patient getPatient(String pkey) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* gets the ims.dto.client.Go_ptplact instance
	*/
	public ims.dto.client.Go_ptplact getGo_ptplact(String pt_act_id) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* gets a Sd_appt instance
	*/
	public ims.dto.client.Sd_appt getAndGetForUpdateSd_appt(String appt_head_id) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* gets the Lookup Instance
	*/
	public ims.dto.client.Lkup getLookupInstance(String lkup_typ) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* list Sd_activity
	*/
	public ims.dto.client.Sd_activity listSd_activity(String act_ind, String grp_act_ind) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* list Sd_activity_grp
	*/
	public ims.dto.client.Sd_activity_grp listSd_activity_grp(String act_ind_grp) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* update Sd_appt
	*/
	public ims.dto.client.Sd_appt updateSd_appt(ims.dto.client.Sd_appt sd_appt) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* Get's a specific Patient
	*/
	public ims.core.vo.PatientShort getPatient(ims.core.patient.vo.PatientRefVo patient) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.ccosched.vo.PatTreatmentPlanLiteVo getTreatmentPlan(Integer actionIdFromDTO) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* Get's a specific Patient
	*/
	public ims.core.vo.PatientShort getPatient(ims.core.vo.PatientShort patient) throws ims.domain.exceptions.StaleObjectException;
}
