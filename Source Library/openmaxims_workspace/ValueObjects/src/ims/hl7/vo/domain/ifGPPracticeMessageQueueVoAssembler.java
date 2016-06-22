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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5589.25814)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 12/10/2015, 13:25
 *
 */
package ims.hl7.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Richard Reynolds
 */
public class ifGPPracticeMessageQueueVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.hl7.vo.ifGPPracticeMessageQueueVo copy(ims.hl7.vo.ifGPPracticeMessageQueueVo valueObjectDest, ims.hl7.vo.ifGPPracticeMessageQueueVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_Organisation(valueObjectSrc.getID_Organisation());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Name
		valueObjectDest.setName(valueObjectSrc.getName());
		// Address
		valueObjectDest.setAddress(valueObjectSrc.getAddress());
		// Type
		valueObjectDest.setType(valueObjectSrc.getType());
		// isActive
		valueObjectDest.setIsActive(valueObjectSrc.getIsActive());
		// CodeMappings
		valueObjectDest.setCodeMappings(valueObjectSrc.getCodeMappings());
		// CommChannels
		valueObjectDest.setCommChannels(valueObjectSrc.getCommChannels());
		// systemInformation
		valueObjectDest.setSystemInformation(valueObjectSrc.getSystemInformation());
		// PctCode
		valueObjectDest.setPctCode(valueObjectSrc.getPctCode());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createifGPPracticeMessageQueueVoCollectionFromOrganisation(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.resource.place.domain.objects.Organisation objects.
	 */
	public static ims.hl7.vo.ifGPPracticeMessageQueueVoCollection createifGPPracticeMessageQueueVoCollectionFromOrganisation(java.util.Set domainObjectSet)	
	{
		return createifGPPracticeMessageQueueVoCollectionFromOrganisation(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.resource.place.domain.objects.Organisation objects.
	 */
	public static ims.hl7.vo.ifGPPracticeMessageQueueVoCollection createifGPPracticeMessageQueueVoCollectionFromOrganisation(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.hl7.vo.ifGPPracticeMessageQueueVoCollection voList = new ims.hl7.vo.ifGPPracticeMessageQueueVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.resource.place.domain.objects.Organisation domainObject = (ims.core.resource.place.domain.objects.Organisation) iterator.next();
			ims.hl7.vo.ifGPPracticeMessageQueueVo vo = create(map, domainObject);
			
			if (vo != null)
				voList.add(vo);
				
			if (domainObject != null)
			{				
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param domainObjectList - List of ims.core.resource.place.domain.objects.Organisation objects.
	 */
	public static ims.hl7.vo.ifGPPracticeMessageQueueVoCollection createifGPPracticeMessageQueueVoCollectionFromOrganisation(java.util.List domainObjectList) 
	{
		return createifGPPracticeMessageQueueVoCollectionFromOrganisation(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.resource.place.domain.objects.Organisation objects.
	 */
	public static ims.hl7.vo.ifGPPracticeMessageQueueVoCollection createifGPPracticeMessageQueueVoCollectionFromOrganisation(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.hl7.vo.ifGPPracticeMessageQueueVoCollection voList = new ims.hl7.vo.ifGPPracticeMessageQueueVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.resource.place.domain.objects.Organisation domainObject = (ims.core.resource.place.domain.objects.Organisation) domainObjectList.get(i);
			ims.hl7.vo.ifGPPracticeMessageQueueVo vo = create(map, domainObject);

			if (vo != null)
				voList.add(vo);
			
			if (domainObject != null)
			{
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ims.core.resource.place.domain.objects.Organisation set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractOrganisationSet(ims.domain.ILightweightDomainFactory domainFactory, ims.hl7.vo.ifGPPracticeMessageQueueVoCollection voCollection) 
	 {
	 	return extractOrganisationSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractOrganisationSet(ims.domain.ILightweightDomainFactory domainFactory, ims.hl7.vo.ifGPPracticeMessageQueueVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.hl7.vo.ifGPPracticeMessageQueueVo vo = voCollection.get(i);
			ims.core.resource.place.domain.objects.Organisation domainObject = ifGPPracticeMessageQueueVoAssembler.extractOrganisation(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainObjectSet.contains(domainObject)) domainObjectSet.add(domainObject);
			newSet.add(domainObject);			
		}
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = domainObjectSet.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			domainObjectSet.remove(iter.next());
		}
		return domainObjectSet;	 
	 }


	/**
	 * Create the ims.core.resource.place.domain.objects.Organisation list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractOrganisationList(ims.domain.ILightweightDomainFactory domainFactory, ims.hl7.vo.ifGPPracticeMessageQueueVoCollection voCollection) 
	 {
	 	return extractOrganisationList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractOrganisationList(ims.domain.ILightweightDomainFactory domainFactory, ims.hl7.vo.ifGPPracticeMessageQueueVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.hl7.vo.ifGPPracticeMessageQueueVo vo = voCollection.get(i);
			ims.core.resource.place.domain.objects.Organisation domainObject = ifGPPracticeMessageQueueVoAssembler.extractOrganisation(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}

			int domIdx = domainObjectList.indexOf(domainObject);
			if (domIdx == -1)
			{
				domainObjectList.add(i, domainObject);
			}
			else if (i != domIdx && i < domainObjectList.size())
			{
				Object tmp = domainObjectList.get(i);
				domainObjectList.set(i, domainObjectList.get(domIdx));
				domainObjectList.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=domainObjectList.size();
		while (i1 > size)
		{
			domainObjectList.remove(i1-1);
			i1=domainObjectList.size();
		}
		return domainObjectList;	 
	 }

 

	/**
	 * Create the ValueObject from the ims.core.resource.place.domain.objects.Organisation object.
	 * @param domainObject ims.core.resource.place.domain.objects.Organisation
	 */
	 public static ims.hl7.vo.ifGPPracticeMessageQueueVo create(ims.core.resource.place.domain.objects.Organisation domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.resource.place.domain.objects.Organisation object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.hl7.vo.ifGPPracticeMessageQueueVo create(DomainObjectMap map, ims.core.resource.place.domain.objects.Organisation domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.hl7.vo.ifGPPracticeMessageQueueVo valueObject = (ims.hl7.vo.ifGPPracticeMessageQueueVo) map.getValueObject(domainObject, ims.hl7.vo.ifGPPracticeMessageQueueVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.hl7.vo.ifGPPracticeMessageQueueVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.resource.place.domain.objects.Organisation
	 */
	 public static ims.hl7.vo.ifGPPracticeMessageQueueVo insert(ims.hl7.vo.ifGPPracticeMessageQueueVo valueObject, ims.core.resource.place.domain.objects.Organisation domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
		DomainObjectMap map = new DomainObjectMap();
		return insert(map, valueObject, domainObject);
	 }
	 
	/**
	 * Update the ValueObject with the Domain Object.
	 * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.resource.place.domain.objects.Organisation
	 */
	 public static ims.hl7.vo.ifGPPracticeMessageQueueVo insert(DomainObjectMap map, ims.hl7.vo.ifGPPracticeMessageQueueVo valueObject, ims.core.resource.place.domain.objects.Organisation domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_Organisation(domainObject.getId());
		valueObject.setIsRIE(domainObject.getIsRIE());
		
		// If this is a recordedInError record, and the domainObject
		// value isIncludeRecord has not been set, then we return null and
		// not the value object
		if (valueObject.getIsRIE() != null && valueObject.getIsRIE().booleanValue() == true && !domainObject.isIncludeRecord())
			return null;
			
		// If this is not a recordedInError record, and the domainObject
		// value isIncludeRecord has been set, then we return null and
		// not the value object
		if ((valueObject.getIsRIE() == null || valueObject.getIsRIE().booleanValue() == false) && domainObject.isIncludeRecord())
			return null;
			
		// Name
		valueObject.setName(domainObject.getName());
		// Address
		valueObject.setAddress(ims.core.vo.domain.AddressVoAssembler.create(map, domainObject.getAddress()) );
		// Type
		ims.domain.lookups.LookupInstance instance3 = domainObject.getType();
		if ( null != instance3 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance3.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance3.getImage().getImageId(), instance3.getImage().getImagePath());
			}
			color = instance3.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.OrganisationType voLookup3 = new ims.core.vo.lookups.OrganisationType(instance3.getId(),instance3.getText(), instance3.isActive(), null, img, color);
			ims.core.vo.lookups.OrganisationType parentVoLookup3 = voLookup3;
			ims.domain.lookups.LookupInstance parent3 = instance3.getParent();
			while (parent3 != null)
			{
				if (parent3.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent3.getImage().getImageId(), parent3.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent3.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup3.setParent(new ims.core.vo.lookups.OrganisationType(parent3.getId(),parent3.getText(), parent3.isActive(), null, img, color));
				parentVoLookup3 = parentVoLookup3.getParent();
								parent3 = parent3.getParent();
			}			
			valueObject.setType(voLookup3);
		}
				// isActive
		valueObject.setIsActive( domainObject.isIsActive() );
		// CodeMappings
		valueObject.setCodeMappings(ims.core.vo.domain.TaxonomyMapAssembler.createTaxonomyMapCollectionFromTaxonomyMap(map, domainObject.getCodeMappings()) );
		// CommChannels
		valueObject.setCommChannels(ims.core.vo.domain.CommChannelVoAssembler.createCommChannelVoCollectionFromCommunicationChannel(map, domainObject.getCommChannels()) );
		// systemInformation
		// set system information
		valueObject.setSystemInformation(ims.vo.domain.SystemInformationAssembler.create(domainObject.getSystemInformation()));
		// PctCode
		valueObject.setPctCode(domainObject.getPctCode());
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.resource.place.domain.objects.Organisation extractOrganisation(ims.domain.ILightweightDomainFactory domainFactory, ims.hl7.vo.ifGPPracticeMessageQueueVo valueObject) 
	{
		return 	extractOrganisation(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.resource.place.domain.objects.Organisation extractOrganisation(ims.domain.ILightweightDomainFactory domainFactory, ims.hl7.vo.ifGPPracticeMessageQueueVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_Organisation();
		ims.core.resource.place.domain.objects.Organisation domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.resource.place.domain.objects.Organisation)domMap.get(valueObject);
			}
			// ims.hl7.vo.ifGPPracticeMessageQueueVo ID_Organisation field is unknown
			domainObject = new ims.core.resource.place.domain.objects.Organisation();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_Organisation());
			if (domMap.get(key) != null)
			{
				return (ims.core.resource.place.domain.objects.Organisation)domMap.get(key);
			}
			domainObject = (ims.core.resource.place.domain.objects.Organisation) domainFactory.getDomainObject(ims.core.resource.place.domain.objects.Organisation.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_Organisation());

		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getName() != null && valueObject.getName().equals(""))
		{
			valueObject.setName(null);
		}
		domainObject.setName(valueObject.getName());
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.generic.domain.objects.Address value2 = null;
		if ( null != valueObject.getAddress() ) 
		{
			if (valueObject.getAddress().getBoId() == null)
			{
				if (domMap.get(valueObject.getAddress()) != null)
				{
					value2 = (ims.core.generic.domain.objects.Address)domMap.get(valueObject.getAddress());
				}
			}
			else
			{
				value2 = (ims.core.generic.domain.objects.Address)domainFactory.getDomainObject(ims.core.generic.domain.objects.Address.class, valueObject.getAddress().getBoId());
			}
		}
		domainObject.setAddress(value2);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value3 = null;
		if ( null != valueObject.getType() ) 
		{
			value3 =
				domainFactory.getLookupInstance(valueObject.getType().getID());
		}
		domainObject.setType(value3);
		domainObject.setIsActive(valueObject.getIsActive());

		// SaveAsRefVO treated as RefValueObject
		ims.core.clinical.vo.TaxonomyMapRefVoCollection refCollection5 = new ims.core.clinical.vo.TaxonomyMapRefVoCollection();
		if (valueObject.getCodeMappings() != null)
		{
			for (int i5=0; i5<valueObject.getCodeMappings().size(); i5++)
			{
				ims.core.clinical.vo.TaxonomyMapRefVo ref5 = (ims.core.clinical.vo.TaxonomyMapRefVo)valueObject.getCodeMappings().get(i5);
				refCollection5.add(ref5);
			}
		}
		int size5 = (null == refCollection5) ? 0 : refCollection5.size();		
		java.util.List domainCodeMappings5 = domainObject.getCodeMappings();
		if (domainCodeMappings5 == null)
		{
			domainCodeMappings5 = new java.util.ArrayList();
		}
		for(int i=0; i < size5; i++) 
		{
			ims.core.clinical.vo.TaxonomyMapRefVo vo = refCollection5.get(i);			
			ims.core.clinical.domain.objects.TaxonomyMap dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.core.clinical.domain.objects.TaxonomyMap)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.core.clinical.domain.objects.TaxonomyMap)domainFactory.getDomainObject( ims.core.clinical.domain.objects.TaxonomyMap.class, vo.getBoId());
				}
			}

			int domIdx = domainCodeMappings5.indexOf(dom);
			if (domIdx == -1)
			{
				domainCodeMappings5.add(i, dom);
			}
			else if (i != domIdx && i < domainCodeMappings5.size())
			{
				Object tmp = domainCodeMappings5.get(i);
				domainCodeMappings5.set(i, domainCodeMappings5.get(domIdx));
				domainCodeMappings5.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i5 = domainCodeMappings5.size();
		while (i5 > size5)
		{
			domainCodeMappings5.remove(i5-1);
			i5 = domainCodeMappings5.size();
		}
		
		domainObject.setCodeMappings(domainCodeMappings5);		

		// SaveAsRefVO treated as RefValueObject
		ims.core.generic.vo.CommunicationChannelRefVoCollection refCollection6 = new ims.core.generic.vo.CommunicationChannelRefVoCollection();
		if (valueObject.getCommChannels() != null)
		{
			for (int i6=0; i6<valueObject.getCommChannels().size(); i6++)
			{
				ims.core.generic.vo.CommunicationChannelRefVo ref6 = (ims.core.generic.vo.CommunicationChannelRefVo)valueObject.getCommChannels().get(i6);
				refCollection6.add(ref6);
			}
		}
		int size6 = (null == refCollection6) ? 0 : refCollection6.size();		
		java.util.List domainCommChannels6 = domainObject.getCommChannels();
		if (domainCommChannels6 == null)
		{
			domainCommChannels6 = new java.util.ArrayList();
		}
		for(int i=0; i < size6; i++) 
		{
			ims.core.generic.vo.CommunicationChannelRefVo vo = refCollection6.get(i);			
			ims.core.generic.domain.objects.CommunicationChannel dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.core.generic.domain.objects.CommunicationChannel)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.core.generic.domain.objects.CommunicationChannel)domainFactory.getDomainObject( ims.core.generic.domain.objects.CommunicationChannel.class, vo.getBoId());
				}
			}

			int domIdx = domainCommChannels6.indexOf(dom);
			if (domIdx == -1)
			{
				domainCommChannels6.add(i, dom);
			}
			else if (i != domIdx && i < domainCommChannels6.size())
			{
				Object tmp = domainCommChannels6.get(i);
				domainCommChannels6.set(i, domainCommChannels6.get(domIdx));
				domainCommChannels6.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i6 = domainCommChannels6.size();
		while (i6 > size6)
		{
			domainCommChannels6.remove(i6-1);
			i6 = domainCommChannels6.size();
		}
		
		domainObject.setCommChannels(domainCommChannels6);		
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getPctCode() != null && valueObject.getPctCode().equals(""))
		{
			valueObject.setPctCode(null);
		}
		domainObject.setPctCode(valueObject.getPctCode());

		return domainObject;
	}

}
