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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.45 build 2257.28884)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.ClinicalContactRefVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.domain.DomainFactory;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.therapies.treatment.domain.objects.StrengtheningProgram;
import ims.therapies.domain.base.impl.BaseStrengtheningProgramImpl;
import ims.therapies.vo.StrengtheningProgramShortVoCollection;
import ims.therapies.vo.StrengtheningProgramVo;
import ims.therapies.vo.StrengtheningProgramVoCollection;
import ims.therapies.vo.domain.StrengtheningProgramShortVoAssembler;
import ims.therapies.vo.domain.StrengtheningProgramVoAssembler;

public class StrengtheningProgramImpl extends BaseStrengtheningProgramImpl
{
	private static final long	serialVersionUID	= 1L;
	
	/**
	 * save StrenghteningProgram
	 * @throws UniqueKeyViolationException 
	 */
	public ims.therapies.vo.StrengtheningProgramVo saveStrenghteningProgram(ims.therapies.vo.StrengtheningProgramVo voStrenghteningProgram) throws ims.domain.exceptions.StaleObjectException, UniqueKeyViolationException
	{
		if (voStrenghteningProgram == null)
			throw new RuntimeException("Cannot save null StrengtheningProgramVo.");
		if (voStrenghteningProgram.isValidated() == false)
			throw new CodingRuntimeException("StrengtheningProgramVo is not validated");

		DomainFactory factory = getDomainFactory();
		if (voStrenghteningProgram.getID_StrengtheningProgram() == null)//Inserting a record
		{
			StrengtheningProgramVo voSP = getStrengthProgByClinicalContact(voStrenghteningProgram.getClinicalContact());
			if(voSP != null)
				throw new UniqueKeyViolationException("A record exists for this clinical contact, the screen will be refreshed");
		}
		StrengtheningProgram doStregtheningProgram = StrengtheningProgramVoAssembler.extractStrengtheningProgram(factory, voStrenghteningProgram);
		factory.save(doStregtheningProgram);
		return StrengtheningProgramVoAssembler.create(doStregtheningProgram);
	}

	public HcpLiteVoCollection listHcpLiteByName(String hcpName)
	{
		HcpAdmin impl = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return impl.listHcpLiteByName(hcpName);

	}

	public StrengtheningProgramVo getStrenghteningProgram(CareContextRefVo careContextRefVo)
	{
		if (careContextRefVo == null)
			throw new CodingRuntimeException("Cannot get CareContextRefVo CareContextRefVo ");

		DomainFactory factory = getDomainFactory();
		String hql = " from StrengtheningProgram sp where sp.clinicalContact.careContext.id = :clinContactId";
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		names.add("clinContactId");
		values.add(careContextRefVo.getID_CareContext());
		List list = factory.find(hql, names, values);

		int listSize = list.size();
		if (listSize == 1)
			return StrengtheningProgramVoAssembler.createStrengtheningProgramVoCollectionFromStrengtheningProgram(list).get(0);

		if (listSize > 1)
			throw new RuntimeException("More than one record for the current Clinical Contact exists.");

		return null;
	}

	public StrengtheningProgramVo getStrengthProgByClinicalContact(ClinicalContactRefVo voClinicalContactRefVo) 
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from StrengtheningProgram sp ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";
		
		if (voClinicalContactRefVo != null)
		{
			hql.append(andStr + " sp.clinicalContact.id = :id_ClinicalContact");
			markers.add("id_ClinicalContact");
			values.add(voClinicalContactRefVo.getID_ClinicalContact());			
			andStr = " and ";
		}
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();
		

		List skills = factory.find(query, markers, values);	
		StrengtheningProgramVoCollection collStrengtheningProgramVo = StrengtheningProgramVoAssembler.createStrengtheningProgramVoCollectionFromStrengtheningProgram(skills);
		if(collStrengtheningProgramVo != null && collStrengtheningProgramVo.size() > 0)
			return collStrengtheningProgramVo.get(0);
		
		return null;
	}

	public StrengtheningProgramShortVoCollection listStrengthProgByCareContext(CareContextRefVo voCareContextRefVo) 
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from StrengtheningProgram sp ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";
		
		if (voCareContextRefVo != null)
		{
			hql.append(andStr + " sp.clinicalContact.careContext.id = :id_cc");
			markers.add("id_cc");
			values.add(voCareContextRefVo.getID_CareContext());			
			andStr = " and ";
		}
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();
		
		List skills = factory.find(query, markers, values);	
		StrengtheningProgramShortVoCollection voStrengtheningProgramShortColl = StrengtheningProgramShortVoAssembler.createStrengtheningProgramShortVoCollectionFromStrengtheningProgram(skills);
		if(voStrengtheningProgramShortColl != null && voStrengtheningProgramShortColl.size()>0)
			return voStrengtheningProgramShortColl;
		
		return null;
	}
}
