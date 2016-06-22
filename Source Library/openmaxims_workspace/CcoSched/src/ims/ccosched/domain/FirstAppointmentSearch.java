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
public interface FirstAppointmentSearch extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listAppointments
	*/
	public ims.dto.client.Sd_appt listAppointments(String first_appt_activity_gr, String first_appt_activity, String first_appt_date) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* getPatient on Pkey
	*/
	public ims.dto.client.Patient getPatient(String pkey) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* list Groups
	*/
	public ims.dto.client.Sd_activity_grp listGroups(String act_ind_grp) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* get the server's DateTime
	*/
	public ims.framework.utils.DateTime getDateTime();

	// Generated from form domain interface definition
	/**
	* get Machine
	*/
	public ims.dto.client.Sd_appt_dts getMachine(String appt_head_id, String appt_id) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* list actvities
	*/
	public ims.dto.client.Sd_activity listActivities(String act_ind, String grp_act_ind) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* get or replicate Patient
	*/
	public ims.core.vo.Patient getPatient(ims.core.vo.PatientShort patient) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;
}
