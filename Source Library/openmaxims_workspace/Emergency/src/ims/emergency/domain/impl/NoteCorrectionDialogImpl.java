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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4828.20158)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.domain.base.impl.BaseNoteCorrectionDialogImpl;
import ims.emergency.domain.objects.AttendanceClinicalNotes;
import ims.emergency.domain.objects.SystemsReview;
import ims.emergency.vo.AttendanceClinicalNotesVo;
import ims.emergency.vo.domain.AttendanceClinicalNotesVoAssembler;
import ims.emergency.vo.domain.SystemReviewVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

public class NoteCorrectionDialogImpl extends BaseNoteCorrectionDialogImpl
{

	private static final long serialVersionUID = 1L;

	public void saveSystemReview(ims.emergency.vo.SystemReviewVo systemReview) throws ims.domain.exceptions.StaleObjectException
	{
		if(systemReview == null )
			throw new CodingRuntimeException("SystemReviewVo not provided");
		
		DomainFactory factory = getDomainFactory();
	
		SystemsReview doSystemReview = SystemReviewVoAssembler.extractSystemsReview(factory, systemReview);
		factory.save(doSystemReview);
	}

	//wdev-17113
	public void saveAttendanceClinicalNotes(AttendanceClinicalNotesVo record) throws StaleObjectException 
	{
		if(record == null )
			throw new CodingRuntimeException("AttendanceClinicalNotesVo not provided");
		
		DomainFactory factory = getDomainFactory();
	
		AttendanceClinicalNotes doAttendanceClinicalNotes = AttendanceClinicalNotesVoAssembler.extractAttendanceClinicalNotes(factory, record);
		factory.save(doAttendanceClinicalNotes);
		
	}
}
