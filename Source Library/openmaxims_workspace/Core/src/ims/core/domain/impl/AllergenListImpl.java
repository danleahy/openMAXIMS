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
// This code was generated by Neil McAnaspie using IMS Development Environment (version 1.20 build 40805.1730)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.admin.helper.Keywords;
import ims.core.clinical.domain.objects.Allergen;
import ims.core.clinical.vo.AllergenRefVo;
import ims.core.domain.TaxonomySearch;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.domain.impl.DomainImpl;
import ims.core.vo.AllergenDetails;
import ims.core.vo.AllergenVo;
import ims.core.vo.AllergenVoCollection;
import ims.core.vo.KeywordVoCollection;
import ims.core.vo.domain.AllergenDetailsAssembler;
import ims.core.vo.domain.AllergenVoAssembler;

public class AllergenListImpl extends DomainImpl implements ims.core.domain.AllergenList, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	public AllergenDetails getAllergenDetails(AllergenRefVo refVo)
	{
		DomainFactory factory = getDomainFactory();
		Allergen allergen = (Allergen) factory.getDomainObject(Allergen.class, refVo.getID_Allergen());
		return (AllergenDetailsAssembler.create(allergen));
	}

	public AllergenVo saveAllergenVo(AllergenVo allergenVo) throws StaleObjectException, UniqueKeyViolationException
	{
		AllergenDetails detVo = new AllergenDetails(allergenVo.getID_Allergen(), allergenVo.getVersion_Allergen());
		detVo.setAllergenName(allergenVo.getAllergenName());
		detVo.setAllergenType(allergenVo.getAllergenType());
		detVo.setIsActive(allergenVo.getIsActive());
		detVo.setIsRIE(allergenVo.getIsRIE());
		String[] arrErrors = detVo.validate();
		if( arrErrors != null)
		{
			throw new DomainRuntimeException("Error saving Allergen - Allergen not vlaidated correctly");
		}
		return  saveAllergenDetails(detVo);
	}

	public AllergenDetails saveAllergenDetails(AllergenDetails allergenDetails) throws StaleObjectException, UniqueKeyViolationException
	{
		if (!allergenDetails.isValidated())
		{
			throw new DomainRuntimeException("Allergen Details VO has not be validated.");
		}
		
		DomainFactory factory = getDomainFactory();
		Allergen domAllergen = AllergenDetailsAssembler.extractAllergen(factory, allergenDetails);	
		
		domAllergen.setKeywords(Keywords.setupKeyWords(domAllergen.getKeywords(), domAllergen.getAllergenName()));
		try
		{
			factory.save(domAllergen);
		} 
		catch (UnqViolationUncheckedException e) 
		{	
			//check which constraint was violated (name/taxononmy map)

			//name
			Allergen allergen = Allergen.getAllergenFromAllergenName(factory, allergenDetails.getAllergenName());
			if (allergen != null && allergen.getId() != null && !(allergen.getId().equals(allergenDetails.getID_Allergen())))
			{
				throw new UniqueKeyViolationException("Allergen record called \"" + allergenDetails.getAllergenName() + "\" already exists. Duplicates not allowed.", e);					
			}

			//taxonomy map
			String dupMessage = Keywords.checkDuplicateTaxonomy(factory, domAllergen, allergenDetails.getTaxonomyMap(), "getAllergenName");
			if(dupMessage != null)
				throw new UniqueKeyViolationException(dupMessage);

			throw (e);
		}
		return AllergenDetailsAssembler.create(domAllergen);
	}
	
	/**
	 * The filter is assumed to be one or more keywords seperated by some white space.
	 * Each keyword is used in a seperate query to get back Allergens which have a keyword like it.
	 * Each subsequent keyword query narrows the original returned list so the eventual returned list
	 * only contains Allergens which contain a match on all the keywords.
	 * It would be nice if this could be implemented as a single HQL query but I don't know how.
	 * @param filter
	 * @param activeOnly
	 * @return
	 * @throws DomainInterfaceException 
	 */
	private List listDomAllergen(String filter, boolean activeOnly) throws DomainInterfaceException
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" from Allergen a join a.keywords as kw "); 
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		if (activeOnly)
		{
			hql.append(" where a.isActive = :isActive");
			names.add("isActive");
			values.add(Boolean.TRUE);	
		}
		return Keywords.searchByKeywords(factory, filter, hql.toString(), names, values);			
	}

	private AllergenVoCollection listAllergen(String filter, boolean activeOnly) throws DomainInterfaceException
	{
		return AllergenVoAssembler.createAllergenVoCollectionFromAllergen(listDomAllergen(filter, activeOnly)).sort();		
	}

	public AllergenVoCollection listAllAllergen(String filter) throws DomainInterfaceException
	{
		return listAllergen(filter, false);
	}
	public AllergenVoCollection listActiveAllergen(String filter) throws DomainInterfaceException
	{
		return listAllergen(filter, true);
	}

	public KeywordVoCollection listSnomedKeywords(String snomedCode)
	{
		TaxonomySearch intf = (TaxonomySearch)getDomainImpl(TaxonomySearchImpl.class);
		return intf.listSnomedKeywords(snomedCode);
	}
}
