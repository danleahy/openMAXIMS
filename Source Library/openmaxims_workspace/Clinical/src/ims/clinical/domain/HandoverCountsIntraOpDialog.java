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
public interface HandoverCountsIntraOpDialog extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listIntraOpPlannedProcedureByAppointment
	*/
	public ims.clinical.vo.IntraOpPlannedProcedureVoCollection listIntraOpPlannedProcedureByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt);

	// Generated from form domain interface definition
	/**
	* saveHandoverIntraOp
	*/
	public void saveHandoverIntraOp(ims.clinical.vo.HandoverCountsIntraOpVo handover) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* getHandoverIntraOp
	*/
	public ims.clinical.vo.HandoverCountsIntraOpVo getHandoverIntraOp(ims.clinical.vo.HandoverCountIntraOpRefVo handoverIntraOp);

	// Generated from form domain interface definition
	/**
	* listCaseScrubPractitioners
	*/
	public ims.core.vo.NurseLiteVoCollection listCaseScrubPractitioners(ims.clinical.vo.IntraOpCaseStaffDetailsRefVo caseStaffDetail);

	// Generated from form domain interface definition
	/**
	* listCaseCirculatorScrubNurses
	*/
	public ims.core.vo.NurseLiteVoCollection listCaseCirculatorScrubNurses(ims.clinical.vo.IntraOpCaseStaffDetailsRefVo caseStaffDetail);
}
