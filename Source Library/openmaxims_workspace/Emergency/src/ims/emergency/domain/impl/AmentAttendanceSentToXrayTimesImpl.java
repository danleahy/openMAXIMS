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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5127.24028)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.domain.DomainFactory;
import ims.emergency.domain.base.impl.BaseAmentAttendanceSentToXrayTimesImpl;
import ims.emergency.domain.objects.SentToXray;
import ims.emergency.vo.domain.SentToXrayVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

public class AmentAttendanceSentToXrayTimesImpl extends BaseAmentAttendanceSentToXrayTimesImpl
{
	private static final long serialVersionUID = 1L;

	public ims.emergency.vo.SentToXrayVo get(ims.emergency.vo.SentToXrayRefVo sentToXrayRef)
	{
		if(sentToXrayRef == null || sentToXrayRef.getID_SentToXray() == null)
			return null;
		
		SentToXray doSentToXray = (SentToXray) getDomainFactory().getDomainObject(SentToXray.class, sentToXrayRef.getID_SentToXray());
		
		return SentToXrayVoAssembler.create(doSentToXray);
	}

	public ims.emergency.vo.SentToXrayVo save(ims.emergency.vo.SentToXrayVo sentToXray) throws ims.domain.exceptions.StaleObjectException
	{
		if(sentToXray == null)
			throw new CodingRuntimeException("Cannot save a null SentToXrayVo.");
		
		if(!sentToXray.isValidated())
			throw new CodingRuntimeException("SentToXrayVo is not validated.");
		
		DomainFactory factory = getDomainFactory();
		
		SentToXray doSeenBy = SentToXrayVoAssembler.extractSentToXray(factory, sentToXray);
		
		factory.save(doSeenBy);
		
		return SentToXrayVoAssembler.create(doSeenBy);
	}
}
