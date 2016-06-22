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
 * Generated on 12/10/2015, 13:24
 *
 */
package ims.correspondence.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Sean Nesbitt
 */
public class RecipientVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.correspondence.vo.RecipientVo copy(ims.correspondence.vo.RecipientVo valueObjectDest, ims.correspondence.vo.RecipientVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_Recipient(valueObjectSrc.getID_Recipient());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// RecipientType
		valueObjectDest.setRecipientType(valueObjectSrc.getRecipientType());
		// name
		valueObjectDest.setName(valueObjectSrc.getName());
		// address
		valueObjectDest.setAddress(valueObjectSrc.getAddress());
		// CommChannels
		valueObjectDest.setCommChannels(valueObjectSrc.getCommChannels());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createRecipientVoCollectionFromRecipient(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.correspondence.domain.objects.Recipient objects.
	 */
	public static ims.correspondence.vo.RecipientVoCollection createRecipientVoCollectionFromRecipient(java.util.Set domainObjectSet)	
	{
		return createRecipientVoCollectionFromRecipient(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.correspondence.domain.objects.Recipient objects.
	 */
	public static ims.correspondence.vo.RecipientVoCollection createRecipientVoCollectionFromRecipient(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.correspondence.vo.RecipientVoCollection voList = new ims.correspondence.vo.RecipientVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.correspondence.domain.objects.Recipient domainObject = (ims.correspondence.domain.objects.Recipient) iterator.next();
			ims.correspondence.vo.RecipientVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.correspondence.domain.objects.Recipient objects.
	 */
	public static ims.correspondence.vo.RecipientVoCollection createRecipientVoCollectionFromRecipient(java.util.List domainObjectList) 
	{
		return createRecipientVoCollectionFromRecipient(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.correspondence.domain.objects.Recipient objects.
	 */
	public static ims.correspondence.vo.RecipientVoCollection createRecipientVoCollectionFromRecipient(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.correspondence.vo.RecipientVoCollection voList = new ims.correspondence.vo.RecipientVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.correspondence.domain.objects.Recipient domainObject = (ims.correspondence.domain.objects.Recipient) domainObjectList.get(i);
			ims.correspondence.vo.RecipientVo vo = create(map, domainObject);

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
	 * Create the ims.correspondence.domain.objects.Recipient set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractRecipientSet(ims.domain.ILightweightDomainFactory domainFactory, ims.correspondence.vo.RecipientVoCollection voCollection) 
	 {
	 	return extractRecipientSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractRecipientSet(ims.domain.ILightweightDomainFactory domainFactory, ims.correspondence.vo.RecipientVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.correspondence.vo.RecipientVo vo = voCollection.get(i);
			ims.correspondence.domain.objects.Recipient domainObject = RecipientVoAssembler.extractRecipient(domainFactory, vo, domMap);

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
	 * Create the ims.correspondence.domain.objects.Recipient list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractRecipientList(ims.domain.ILightweightDomainFactory domainFactory, ims.correspondence.vo.RecipientVoCollection voCollection) 
	 {
	 	return extractRecipientList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractRecipientList(ims.domain.ILightweightDomainFactory domainFactory, ims.correspondence.vo.RecipientVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.correspondence.vo.RecipientVo vo = voCollection.get(i);
			ims.correspondence.domain.objects.Recipient domainObject = RecipientVoAssembler.extractRecipient(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.correspondence.domain.objects.Recipient object.
	 * @param domainObject ims.correspondence.domain.objects.Recipient
	 */
	 public static ims.correspondence.vo.RecipientVo create(ims.correspondence.domain.objects.Recipient domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.correspondence.domain.objects.Recipient object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.correspondence.vo.RecipientVo create(DomainObjectMap map, ims.correspondence.domain.objects.Recipient domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.correspondence.vo.RecipientVo valueObject = (ims.correspondence.vo.RecipientVo) map.getValueObject(domainObject, ims.correspondence.vo.RecipientVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.correspondence.vo.RecipientVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.correspondence.domain.objects.Recipient
	 */
	 public static ims.correspondence.vo.RecipientVo insert(ims.correspondence.vo.RecipientVo valueObject, ims.correspondence.domain.objects.Recipient domainObject) 
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
	 * @param domainObject ims.correspondence.domain.objects.Recipient
	 */
	 public static ims.correspondence.vo.RecipientVo insert(DomainObjectMap map, ims.correspondence.vo.RecipientVo valueObject, ims.correspondence.domain.objects.Recipient domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_Recipient(domainObject.getId());
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
			
		// RecipientType
		ims.domain.lookups.LookupInstance instance1 = domainObject.getRecipientType();
		if ( null != instance1 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance1.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance1.getImage().getImageId(), instance1.getImage().getImagePath());
			}
			color = instance1.getColor();
			if (color != null) 
				color.getValue();

			ims.correspondence.vo.lookups.RecipientType voLookup1 = new ims.correspondence.vo.lookups.RecipientType(instance1.getId(),instance1.getText(), instance1.isActive(), null, img, color);
			ims.correspondence.vo.lookups.RecipientType parentVoLookup1 = voLookup1;
			ims.domain.lookups.LookupInstance parent1 = instance1.getParent();
			while (parent1 != null)
			{
				if (parent1.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent1.getImage().getImageId(), parent1.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent1.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup1.setParent(new ims.correspondence.vo.lookups.RecipientType(parent1.getId(),parent1.getText(), parent1.isActive(), null, img, color));
				parentVoLookup1 = parentVoLookup1.getParent();
								parent1 = parent1.getParent();
			}			
			valueObject.setRecipientType(voLookup1);
		}
				// name
		valueObject.setName(ims.core.vo.domain.PersonNameAssembler.create(map, domainObject.getName()) );
		// address
		valueObject.setAddress(ims.core.vo.domain.PersonAddressAssembler.create(map, domainObject.getAddress()) );
		// CommChannels
		valueObject.setCommChannels(ims.core.vo.domain.CommChannelVoAssembler.createCommChannelVoCollectionFromCommunicationChannel(map, domainObject.getCommChannels()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.correspondence.domain.objects.Recipient extractRecipient(ims.domain.ILightweightDomainFactory domainFactory, ims.correspondence.vo.RecipientVo valueObject) 
	{
		return 	extractRecipient(domainFactory, valueObject, new HashMap());
	}

	public static ims.correspondence.domain.objects.Recipient extractRecipient(ims.domain.ILightweightDomainFactory domainFactory, ims.correspondence.vo.RecipientVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_Recipient();
		ims.correspondence.domain.objects.Recipient domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.correspondence.domain.objects.Recipient)domMap.get(valueObject);
			}
			// ims.correspondence.vo.RecipientVo ID_Recipient field is unknown
			domainObject = new ims.correspondence.domain.objects.Recipient();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_Recipient());
			if (domMap.get(key) != null)
			{
				return (ims.correspondence.domain.objects.Recipient)domMap.get(key);
			}
			domainObject = (ims.correspondence.domain.objects.Recipient) domainFactory.getDomainObject(ims.correspondence.domain.objects.Recipient.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_Recipient());

		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value1 = null;
		if ( null != valueObject.getRecipientType() ) 
		{
			value1 =
				domainFactory.getLookupInstance(valueObject.getRecipientType().getID());
		}
		domainObject.setRecipientType(value1);
		domainObject.setName(ims.core.vo.domain.PersonNameAssembler.extractPersonName(domainFactory, valueObject.getName(), domMap));
		domainObject.setAddress(ims.core.vo.domain.PersonAddressAssembler.extractAddress(domainFactory, valueObject.getAddress(), domMap));
		domainObject.setCommChannels(ims.core.vo.domain.CommChannelVoAssembler.extractCommunicationChannelList(domainFactory, valueObject.getCommChannels(), domainObject.getCommChannels(), domMap));		

		return domainObject;
	}

}
