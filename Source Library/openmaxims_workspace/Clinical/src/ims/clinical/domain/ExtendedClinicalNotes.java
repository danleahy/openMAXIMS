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
public interface ExtendedClinicalNotes extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* saveClinicalNotes
	*/
	public ims.core.vo.ClinicalNotesVo saveClinicalNotes(ims.core.vo.ClinicalNotesVo clinicalNotesVo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* getClinicalNotes
	*/
	public ims.core.vo.ClinicalNotesVo getClinicalNotes(ims.core.admin.vo.ClinicalContactRefVo contactVo);

	// Generated from form domain interface definition
	public ims.core.vo.MemberOfStaffVo getMemberOfStaff(ims.core.vo.MemberOfStaffShortVo mos);

	// Generated from form domain interface definition
	/**
	* getClinicalContact
	*/
	public ims.core.vo.ClinicalContactVo getClinicalContact(Integer nId);

	// Generated from form domain interface definition
	/**
	* getClinicalNotesForContact
	*/
	public ims.core.vo.ClinicalNotesVo getClinicalNotesForContact(ims.core.admin.vo.ClinicalContactRefVo clinicalContactRefId);

	// Generated from form domain interface definition
	/**
	* getClinicalNote
	*/
	public ims.core.vo.ClinicalNotesVo getClinicalNote(ims.core.clinical.vo.ClinicalNotesRefVo clinicalNoteRefVo);

	// Generated from form domain interface definition
	/**
	* saveClinicalContact
	*/
	public ims.core.vo.ClinicalContactShortVo saveClinicalContact(ims.core.vo.ClinicalContactShortVo clinicalContactVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.ClinicalNotesVo saveClinicalNotesAndClinicalContact(ims.core.vo.ClinicalNotesVo clinicalNote, ims.core.vo.ClinicalContactShortVo clinicalContact) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVo getHcpLiteVoFOrMosID(Integer mosId);
}
