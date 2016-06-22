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

package ims.scheduling.domain;

// Generated from form domain impl
public interface OCSExternalEvents extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* This should be called when an order is ready to be sent. i.e. at the same time the order status is set to AUTHORISED
	*/
	public void generateNewOrderEvent(ims.scheduling.vo.Booking_AppointmentRefVo appointment, ims.ocrr.orderingresults.vo.OrderInvestigationRefVo investigation) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Should be called when a patient arrives in clinic 
	*/
	public void generatePatientArrivingEvent(ims.scheduling.vo.Booking_AppointmentRefVo appointment, ims.ocrr.orderingresults.vo.OrderInvestigationRefVo investigation) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Should be called in when an order is cancelled in MAXIMS UI
	*/
	public void generateOrderCancelEvent(ims.scheduling.vo.Booking_AppointmentRefVo appointment, ims.ocrr.orderingresults.vo.OrderInvestigationRefVo investigation) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* This should be called in when an appointment associated with the order is changed/rebooked 
	*/
	public void generateOrderUpdateEvent(ims.scheduling.vo.Booking_AppointmentRefVo appointment, ims.ocrr.orderingresults.vo.OrderInvestigationRefVo investigation) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Should be called in RefMan when a patient NDAs 
	*/
	public void generateOrderPatientDNAEvent(ims.scheduling.vo.Booking_AppointmentRefVo appointment, ims.ocrr.orderingresults.vo.OrderInvestigationRefVo investigation) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Call this method when you want to send the provider system a ORR_O02 CR Cancelled as requested usually in respose to a message to cancel an Investigation
	*/
	public void generateOrderCancelAsRequestedEvent(ims.scheduling.vo.Booking_AppointmentRefVo appointment, ims.ocrr.orderingresults.vo.OrderInvestigationRefVo investigation) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void generateOrderNumberAllocatedEvent(ims.scheduling.vo.Booking_AppointmentRefVo appointment, ims.ocrr.orderingresults.vo.OrderInvestigationRefVo investigation) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* This method must be called before any update is applied to the appointment
	*/
	public void generateAppointmentCancelEvent(ims.scheduling.vo.Booking_AppointmentRefVo appointment, ims.ocrr.orderingresults.vo.OrderInvestigationRefVo investigation) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public Boolean isRebookApptWithCancelandFullXOSetForProviderSystem(ims.core.admin.vo.ProviderSystemRefVo providerSystem);
}
