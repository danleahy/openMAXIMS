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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4027.29767)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.vo.domain.ReferralForFitForSurgeryVoAssembler;
import ims.clinical.domain.base.impl.BasePatientAppointmentsDialogImpl;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;

public class PatientAppointmentsDialogImpl extends BasePatientAppointmentsDialogImpl
{

	private static final long serialVersionUID = 1L;

	public ims.RefMan.vo.ReferralForFitForSurgeryVo getReferralByCareContext(ims.core.admin.vo.CareContextRefVo careContext)
	{
		if(careContext == null || !careContext.getID_CareContextIsNotNull())
			throw new CodingRuntimeException("Can not get Cats Referral for a null Care Context.");
		
		DomainFactory factory = getDomainFactory();
		
		return ReferralForFitForSurgeryVoAssembler.create((CatsReferral) factory.findFirst("from CatsReferral c where c.careContext.id = :CareContext and c.isRIE is null", new String[] {"CareContext"}, new Object[] {careContext.getID_CareContext()}));
	}
}
