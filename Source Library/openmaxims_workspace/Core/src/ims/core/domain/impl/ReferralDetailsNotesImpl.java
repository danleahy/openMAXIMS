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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.65 build 3225.30788)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import ims.core.admin.vo.CareContextRefVo;
import ims.core.domain.base.impl.BaseReferralDetailsNotesImpl;
import ims.core.domain.objects.CorrespondenceNote;
import ims.core.vo.ReferralNoteVo;
import ims.core.vo.ReferralNoteVoCollection;
import ims.core.vo.domain.ReferralNoteVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;

public class ReferralDetailsNotesImpl extends BaseReferralDetailsNotesImpl
{

	private static final long serialVersionUID = 1L;
	
	public ReferralNoteVo saveReferralNote(ReferralNoteVo voReferralNote) throws DomainInterfaceException, StaleObjectException 
	{
		if(voReferralNote == null)
			throw new DomainRuntimeException("Invalid referral note to save");
		if(!voReferralNote.isValidated())
			throw new DomainRuntimeException("Record not validated before save");
		
		DomainFactory factory = getDomainFactory();
		CorrespondenceNote domainObject = ReferralNoteVoAssembler.extractCorrespondenceNote(factory, voReferralNote);		
		factory.save(domainObject);
		return ReferralNoteVoAssembler.create(domainObject);
	}

	public ReferralNoteVoCollection listReferralNote(CareContextRefVo voCareContextRef)
	{
		DomainFactory factory = getDomainFactory();

		if (voCareContextRef != null && voCareContextRef.getID_CareContextIsNotNull())
		{
			java.util.List list = factory.find("select note from CorrespondenceNote note left join note.careContext as cc where cc.id = :idCC", new String[]{"idCC"}, new Object[]{voCareContextRef.getID_CareContext()});
			return ReferralNoteVoAssembler.createReferralNoteVoCollectionFromCorrespondenceNote(list).sort();
		}

		return null;
	}

}
