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
package ims.RefMan.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Gabriel Maxim
 */
public class AwaitingHistologyVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.RefMan.vo.AwaitingHistologyVo copy(ims.RefMan.vo.AwaitingHistologyVo valueObjectDest, ims.RefMan.vo.AwaitingHistologyVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_AwaitingHistology(valueObjectSrc.getID_AwaitingHistology());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// AuthoringDateTime
		valueObjectDest.setAuthoringDateTime(valueObjectSrc.getAuthoringDateTime());
		// AuthoringMOS
		valueObjectDest.setAuthoringMOS(valueObjectSrc.getAuthoringMOS());
		// AwaitingHistology
		valueObjectDest.setAwaitingHistology(valueObjectSrc.getAwaitingHistology());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createAwaitingHistologyVoCollectionFromAwaitingHistology(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.clinical.domain.objects.AwaitingHistology objects.
	 */
	public static ims.RefMan.vo.AwaitingHistologyVoCollection createAwaitingHistologyVoCollectionFromAwaitingHistology(java.util.Set domainObjectSet)	
	{
		return createAwaitingHistologyVoCollectionFromAwaitingHistology(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.clinical.domain.objects.AwaitingHistology objects.
	 */
	public static ims.RefMan.vo.AwaitingHistologyVoCollection createAwaitingHistologyVoCollectionFromAwaitingHistology(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.RefMan.vo.AwaitingHistologyVoCollection voList = new ims.RefMan.vo.AwaitingHistologyVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.clinical.domain.objects.AwaitingHistology domainObject = (ims.clinical.domain.objects.AwaitingHistology) iterator.next();
			ims.RefMan.vo.AwaitingHistologyVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.clinical.domain.objects.AwaitingHistology objects.
	 */
	public static ims.RefMan.vo.AwaitingHistologyVoCollection createAwaitingHistologyVoCollectionFromAwaitingHistology(java.util.List domainObjectList) 
	{
		return createAwaitingHistologyVoCollectionFromAwaitingHistology(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.clinical.domain.objects.AwaitingHistology objects.
	 */
	public static ims.RefMan.vo.AwaitingHistologyVoCollection createAwaitingHistologyVoCollectionFromAwaitingHistology(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.RefMan.vo.AwaitingHistologyVoCollection voList = new ims.RefMan.vo.AwaitingHistologyVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.clinical.domain.objects.AwaitingHistology domainObject = (ims.clinical.domain.objects.AwaitingHistology) domainObjectList.get(i);
			ims.RefMan.vo.AwaitingHistologyVo vo = create(map, domainObject);

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
	 * Create the ims.clinical.domain.objects.AwaitingHistology set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractAwaitingHistologySet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.AwaitingHistologyVoCollection voCollection) 
	 {
	 	return extractAwaitingHistologySet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractAwaitingHistologySet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.AwaitingHistologyVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.AwaitingHistologyVo vo = voCollection.get(i);
			ims.clinical.domain.objects.AwaitingHistology domainObject = AwaitingHistologyVoAssembler.extractAwaitingHistology(domainFactory, vo, domMap);

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
	 * Create the ims.clinical.domain.objects.AwaitingHistology list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractAwaitingHistologyList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.AwaitingHistologyVoCollection voCollection) 
	 {
	 	return extractAwaitingHistologyList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractAwaitingHistologyList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.AwaitingHistologyVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.AwaitingHistologyVo vo = voCollection.get(i);
			ims.clinical.domain.objects.AwaitingHistology domainObject = AwaitingHistologyVoAssembler.extractAwaitingHistology(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.clinical.domain.objects.AwaitingHistology object.
	 * @param domainObject ims.clinical.domain.objects.AwaitingHistology
	 */
	 public static ims.RefMan.vo.AwaitingHistologyVo create(ims.clinical.domain.objects.AwaitingHistology domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.clinical.domain.objects.AwaitingHistology object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.RefMan.vo.AwaitingHistologyVo create(DomainObjectMap map, ims.clinical.domain.objects.AwaitingHistology domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.RefMan.vo.AwaitingHistologyVo valueObject = (ims.RefMan.vo.AwaitingHistologyVo) map.getValueObject(domainObject, ims.RefMan.vo.AwaitingHistologyVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.RefMan.vo.AwaitingHistologyVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.clinical.domain.objects.AwaitingHistology
	 */
	 public static ims.RefMan.vo.AwaitingHistologyVo insert(ims.RefMan.vo.AwaitingHistologyVo valueObject, ims.clinical.domain.objects.AwaitingHistology domainObject) 
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
	 * @param domainObject ims.clinical.domain.objects.AwaitingHistology
	 */
	 public static ims.RefMan.vo.AwaitingHistologyVo insert(DomainObjectMap map, ims.RefMan.vo.AwaitingHistologyVo valueObject, ims.clinical.domain.objects.AwaitingHistology domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_AwaitingHistology(domainObject.getId());
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
			
		// AuthoringDateTime
		java.util.Date AuthoringDateTime = domainObject.getAuthoringDateTime();
		if ( null != AuthoringDateTime ) 
		{
			valueObject.setAuthoringDateTime(new ims.framework.utils.DateTime(AuthoringDateTime) );
		}
		// AuthoringMOS
		valueObject.setAuthoringMOS(ims.core.vo.domain.MemberOfStaffLiteVoAssembler.create(map, domainObject.getAuthoringMOS()) );
		// AwaitingHistology
		valueObject.setAwaitingHistology( domainObject.isAwaitingHistology() );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.clinical.domain.objects.AwaitingHistology extractAwaitingHistology(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.AwaitingHistologyVo valueObject) 
	{
		return 	extractAwaitingHistology(domainFactory, valueObject, new HashMap());
	}

	public static ims.clinical.domain.objects.AwaitingHistology extractAwaitingHistology(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.AwaitingHistologyVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_AwaitingHistology();
		ims.clinical.domain.objects.AwaitingHistology domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.clinical.domain.objects.AwaitingHistology)domMap.get(valueObject);
			}
			// ims.RefMan.vo.AwaitingHistologyVo ID_AwaitingHistology field is unknown
			domainObject = new ims.clinical.domain.objects.AwaitingHistology();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_AwaitingHistology());
			if (domMap.get(key) != null)
			{
				return (ims.clinical.domain.objects.AwaitingHistology)domMap.get(key);
			}
			domainObject = (ims.clinical.domain.objects.AwaitingHistology) domainFactory.getDomainObject(ims.clinical.domain.objects.AwaitingHistology.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_AwaitingHistology());

		ims.framework.utils.DateTime dateTime1 = valueObject.getAuthoringDateTime();
		java.util.Date value1 = null;
		if ( dateTime1 != null ) 
		{
			value1 = dateTime1.getJavaDate();
		}
		domainObject.setAuthoringDateTime(value1);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.people.domain.objects.MemberOfStaff value2 = null;
		if ( null != valueObject.getAuthoringMOS() ) 
		{
			if (valueObject.getAuthoringMOS().getBoId() == null)
			{
				if (domMap.get(valueObject.getAuthoringMOS()) != null)
				{
					value2 = (ims.core.resource.people.domain.objects.MemberOfStaff)domMap.get(valueObject.getAuthoringMOS());
				}
			}
			else
			{
				value2 = (ims.core.resource.people.domain.objects.MemberOfStaff)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.MemberOfStaff.class, valueObject.getAuthoringMOS().getBoId());
			}
		}
		domainObject.setAuthoringMOS(value2);
		domainObject.setAwaitingHistology(valueObject.getAwaitingHistology());

		return domainObject;
	}

}
