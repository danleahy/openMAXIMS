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
package ims.core.helper;

import ims.RefMan.vo.CatsReferralRefVo;
import ims.chooseandbook.vo.lookups.ActionRequestType;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.scheduling.vo.Booking_AppointmentRefVo;
import ims.scheduling.vo.Booking_AppointmentVo;

public interface IElectiveListCancelAppt
{
	Booking_AppointmentVo cancelAppt(Booking_AppointmentVo appt, ActionRequestType requestType, String requestSource) throws DomainInterfaceException, StaleObjectException;
	void updateCatsReferralAdditionalInvStatus(CatsReferralRefVo catsReferral, Booking_AppointmentRefVo appointment) throws StaleObjectException;
	void updateCatsReferralCancelStatus(CatsReferralRefVo catsReferral) throws StaleObjectException;
	
}
