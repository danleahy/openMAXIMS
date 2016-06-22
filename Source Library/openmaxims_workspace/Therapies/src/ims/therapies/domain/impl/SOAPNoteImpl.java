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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.52 build 2508.29436)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.domain.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ims.admin.domain.MosAdmin;
import ims.admin.domain.impl.MosAdminImpl;
import ims.clinical.domain.ClinicalNoteDrawing;
import ims.clinical.domain.ClinicalNotes;
import ims.clinical.domain.impl.ClinicalNoteDrawingImpl;
import ims.clinical.domain.impl.ClinicalNotesImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.ClinicalContactRefVo;
import ims.core.clinical.vo.ClinicalNotesRefVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.ClinicalContactVo;
import ims.core.vo.ClinicalNotesVo;
import ims.core.vo.ClinicalNotesVoCollection;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.MemberOfStaffVo;
import ims.domain.DomainFactory;
import ims.core.vo.domain.ClinicalNotesVoAssembler;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.therapies.domain.base.impl.BaseSOAPNoteImpl;

public class SOAPNoteImpl extends BaseSOAPNoteImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* saveClinicalNotes
	 * @throws DomainInterfaceException 
	 * @throws UniqueKeyViolationException 
	*/
	public ims.core.vo.ClinicalNotesVo saveClinicalNotes(ims.core.vo.ClinicalNotesVo clinicalNotesVo) throws ims.domain.exceptions.StaleObjectException, DomainInterfaceException, UniqueKeyViolationException
	{
		// WDEV-20525 If no clinical contact, we will save the clinical note here to prevent validation at CC level
		if (clinicalNotesVo != null && clinicalNotesVo.getClinicalContactIsNotNull())
		{
			ClinicalNoteDrawing impl = (ClinicalNoteDrawing) getDomainImpl(ClinicalNoteDrawingImpl.class);
			return impl.saveClinicalNotesOnly(clinicalNotesVo);
		}
		else
			return saveClinicalNoteAtCareContextLevel(clinicalNotesVo);
	}

	private ClinicalNotesVo saveClinicalNoteAtCareContextLevel(ClinicalNotesVo clinicalNotesVo) throws StaleObjectException 
	{
		DomainFactory factory = getDomainFactory();
		
		ims.core.clinical.domain.objects.ClinicalNotes domClinicalNote = ClinicalNotesVoAssembler.extractClinicalNotes(factory, clinicalNotesVo);
		factory.save(domClinicalNote);
		return ClinicalNotesVoAssembler.create(domClinicalNote);
	}

	/**
	* getClinicalNotes
	*/
	public ims.core.vo.ClinicalNotesVo getClinicalNotes(ims.core.admin.vo.ClinicalContactRefVo contactVo)
	{
		ClinicalNotes impl = (ClinicalNotes) getDomainImpl(ClinicalNotesImpl.class);
		
		ClinicalNotesVoCollection ClinicalNotes = impl.getClinicalNotes(contactVo); //WDEV-15382
		
		if (ClinicalNotes != null && ClinicalNotes.size() > 0) //WDEV-16953
			return ClinicalNotes.get(0);
		
		return null;
	}

	/**
	* Save the SOAPVo
	*/
	public void saveSOAPsVo(ims.core.vo.SOAPVo voSOAP) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException
	{
		ClinicalNoteDrawing impl = (ClinicalNoteDrawing) getDomainImpl(ClinicalNoteDrawingImpl.class);
		impl.saveSOAPsVo(voSOAP);
	}

	/**
	* Get SOAPVo
	*/
	public ims.core.vo.SOAPVo getSOAPsVo(ims.core.clinical.vo.ClinicalNotesRefVo clinnoteRefVo)
	{
		ClinicalNoteDrawing impl = (ClinicalNoteDrawing) getDomainImpl(ClinicalNoteDrawingImpl.class);
		return impl.getSOAPsVo(clinnoteRefVo);
	}

	public ClinicalContactVo getClinicalContact(Integer nId) 
	{
		ClinicalNoteDrawing clinImpl = (ClinicalNoteDrawing)getDomainImpl(ClinicalNoteDrawingImpl.class);
		return clinImpl.getClinicalContact(nId);
	}
	
	public MemberOfStaffVo getMemberOfStaff(MemberOfStaffShortVo mos)
	{
		MosAdmin mosAdmin = (MosAdmin)getDomainImpl(MosAdminImpl.class);
		return mosAdmin.getMemberOfStaff(mos);
	}

	public ClinicalContactShortVo saveClinicalContact(ClinicalContactShortVo clinicalContactVo) throws StaleObjectException 
	{
		ClinicalNoteDrawing clinImpl = (ClinicalNoteDrawing)getDomainImpl(ClinicalNoteDrawingImpl.class);
		return clinImpl.saveClinicalContact(clinicalContactVo);
	}
	
	public ClinicalNotesVo getClinicalNotesForContact(ClinicalContactRefVo clinicalContactRefId) 
	{
		ClinicalNoteDrawing impl = (ClinicalNoteDrawing)getDomainImpl(ClinicalNoteDrawingImpl.class);
		return impl.getClinicalNotesForContact(clinicalContactRefId);
	}

	public ims.core.vo.ClinicalNotesVo getClinicalNote(ClinicalNotesRefVo clinicalNoteRefVo)
	{
		ClinicalNoteDrawing impl = (ClinicalNoteDrawing)getDomainImpl(ClinicalNoteDrawingImpl.class);
		return impl.getClinicalNotes(clinicalNoteRefVo.getID_ClinicalNotes());

	}

	// WDEV-20525 - Can now record soap note at carecontext level
	public ClinicalNotesVo getClinicalNotesForCareContext(CareContextRefVo careContext) 
	{
		if(careContext != null)
		{
			DomainFactory factory = getDomainFactory();
//WDEV-20525			StringBuffer hql = new StringBuffer(" from ClinicalNotes clinnote where "); 
//WDEV-20525			String andStr = " ";
			StringBuffer hql = new StringBuffer("select clinnote from ClinicalNotes as clinnote left join clinnote.sourceOfNote as source where source.id=-1161"); 
			String andStr = " and ";

		
			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();
		
			hql.append(andStr + " clinnote.careContext.id = :careContextId");
 			markers.add("careContextId");
			values.add(careContext.getID_CareContext());
			andStr = " and ";	
			hql.append(andStr).append(" clinnote.clinicalContact is null "); // We only want to see the carecontext level record

			List listNotes = factory.find(hql.toString(), markers,values);
			if(listNotes != null && listNotes.size() > 0)
			{ 
				ClinicalNotesVoCollection voColl = ClinicalNotesVoAssembler.createClinicalNotesVoCollectionFromClinicalNotes(listNotes);
				if(voColl != null && voColl.size() > 0)
					return voColl.get(0);
			}
		}
		return null;
	}

}
