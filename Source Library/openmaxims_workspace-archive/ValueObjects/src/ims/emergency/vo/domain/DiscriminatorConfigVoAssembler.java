//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 16/04/2014, 12:31
 *
 */
package ims.emergency.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Bogdan Tofei
 */
public class DiscriminatorConfigVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.emergency.vo.DiscriminatorConfigVo copy(ims.emergency.vo.DiscriminatorConfigVo valueObjectDest, ims.emergency.vo.DiscriminatorConfigVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_DiscriminatorConfig(valueObjectSrc.getID_DiscriminatorConfig());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// DiscriminatorName
		valueObjectDest.setDiscriminatorName(valueObjectSrc.getDiscriminatorName());
		// DiscriminatorDescription
		valueObjectDest.setDiscriminatorDescription(valueObjectSrc.getDiscriminatorDescription());
		// TaxonomyMap
		valueObjectDest.setTaxonomyMap(valueObjectSrc.getTaxonomyMap());
		// isActive
		valueObjectDest.setIsActive(valueObjectSrc.getIsActive());
		// Keywords
		valueObjectDest.setKeywords(valueObjectSrc.getKeywords());
		// DefaultTriagePriority
		valueObjectDest.setDefaultTriagePriority(valueObjectSrc.getDefaultTriagePriority());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createDiscriminatorConfigVoCollectionFromDiscriminatorConfig(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.emergency.configuration.domain.objects.DiscriminatorConfig objects.
	 */
	public static ims.emergency.vo.DiscriminatorConfigVoCollection createDiscriminatorConfigVoCollectionFromDiscriminatorConfig(java.util.Set domainObjectSet)	
	{
		return createDiscriminatorConfigVoCollectionFromDiscriminatorConfig(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.emergency.configuration.domain.objects.DiscriminatorConfig objects.
	 */
	public static ims.emergency.vo.DiscriminatorConfigVoCollection createDiscriminatorConfigVoCollectionFromDiscriminatorConfig(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.emergency.vo.DiscriminatorConfigVoCollection voList = new ims.emergency.vo.DiscriminatorConfigVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.emergency.configuration.domain.objects.DiscriminatorConfig domainObject = (ims.emergency.configuration.domain.objects.DiscriminatorConfig) iterator.next();
			ims.emergency.vo.DiscriminatorConfigVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.emergency.configuration.domain.objects.DiscriminatorConfig objects.
	 */
	public static ims.emergency.vo.DiscriminatorConfigVoCollection createDiscriminatorConfigVoCollectionFromDiscriminatorConfig(java.util.List domainObjectList) 
	{
		return createDiscriminatorConfigVoCollectionFromDiscriminatorConfig(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.emergency.configuration.domain.objects.DiscriminatorConfig objects.
	 */
	public static ims.emergency.vo.DiscriminatorConfigVoCollection createDiscriminatorConfigVoCollectionFromDiscriminatorConfig(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.emergency.vo.DiscriminatorConfigVoCollection voList = new ims.emergency.vo.DiscriminatorConfigVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.emergency.configuration.domain.objects.DiscriminatorConfig domainObject = (ims.emergency.configuration.domain.objects.DiscriminatorConfig) domainObjectList.get(i);
			ims.emergency.vo.DiscriminatorConfigVo vo = create(map, domainObject);

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
	 * Create the ims.emergency.configuration.domain.objects.DiscriminatorConfig set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractDiscriminatorConfigSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.DiscriminatorConfigVoCollection voCollection) 
	 {
	 	return extractDiscriminatorConfigSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractDiscriminatorConfigSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.DiscriminatorConfigVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.DiscriminatorConfigVo vo = voCollection.get(i);
			ims.emergency.configuration.domain.objects.DiscriminatorConfig domainObject = DiscriminatorConfigVoAssembler.extractDiscriminatorConfig(domainFactory, vo, domMap);

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
	 * Create the ims.emergency.configuration.domain.objects.DiscriminatorConfig list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractDiscriminatorConfigList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.DiscriminatorConfigVoCollection voCollection) 
	 {
	 	return extractDiscriminatorConfigList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractDiscriminatorConfigList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.DiscriminatorConfigVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.DiscriminatorConfigVo vo = voCollection.get(i);
			ims.emergency.configuration.domain.objects.DiscriminatorConfig domainObject = DiscriminatorConfigVoAssembler.extractDiscriminatorConfig(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.emergency.configuration.domain.objects.DiscriminatorConfig object.
	 * @param domainObject ims.emergency.configuration.domain.objects.DiscriminatorConfig
	 */
	 public static ims.emergency.vo.DiscriminatorConfigVo create(ims.emergency.configuration.domain.objects.DiscriminatorConfig domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.emergency.configuration.domain.objects.DiscriminatorConfig object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.emergency.vo.DiscriminatorConfigVo create(DomainObjectMap map, ims.emergency.configuration.domain.objects.DiscriminatorConfig domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.emergency.vo.DiscriminatorConfigVo valueObject = (ims.emergency.vo.DiscriminatorConfigVo) map.getValueObject(domainObject, ims.emergency.vo.DiscriminatorConfigVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.emergency.vo.DiscriminatorConfigVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.emergency.configuration.domain.objects.DiscriminatorConfig
	 */
	 public static ims.emergency.vo.DiscriminatorConfigVo insert(ims.emergency.vo.DiscriminatorConfigVo valueObject, ims.emergency.configuration.domain.objects.DiscriminatorConfig domainObject) 
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
	 * @param domainObject ims.emergency.configuration.domain.objects.DiscriminatorConfig
	 */
	 public static ims.emergency.vo.DiscriminatorConfigVo insert(DomainObjectMap map, ims.emergency.vo.DiscriminatorConfigVo valueObject, ims.emergency.configuration.domain.objects.DiscriminatorConfig domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_DiscriminatorConfig(domainObject.getId());
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
			
		// DiscriminatorName
		valueObject.setDiscriminatorName(domainObject.getDiscriminatorName());
		// DiscriminatorDescription
		valueObject.setDiscriminatorDescription(domainObject.getDiscriminatorDescription());
		// TaxonomyMap
		valueObject.setTaxonomyMap(ims.core.vo.domain.TaxonomyMapAssembler.createTaxonomyMapCollectionFromTaxonomyMap(map, domainObject.getTaxonomyMap()) );
		// isActive
		valueObject.setIsActive( domainObject.isIsActive() );
		// Keywords
		valueObject.setKeywords(ims.core.vo.domain.KeywordVoAssembler.createKeywordVoCollectionFromKeyword(map, domainObject.getKeywords()) );
		// DefaultTriagePriority
		ims.domain.lookups.LookupInstance instance6 = domainObject.getDefaultTriagePriority();
		if ( null != instance6 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance6.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance6.getImage().getImageId(), instance6.getImage().getImagePath());
			}
			color = instance6.getColor();
			if (color != null) 
				color.getValue();

			ims.emergency.vo.lookups.TriagePriority voLookup6 = new ims.emergency.vo.lookups.TriagePriority(instance6.getId(),instance6.getText(), instance6.isActive(), null, img, color);
			ims.emergency.vo.lookups.TriagePriority parentVoLookup6 = voLookup6;
			ims.domain.lookups.LookupInstance parent6 = instance6.getParent();
			while (parent6 != null)
			{
				if (parent6.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent6.getImage().getImageId(), parent6.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent6.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup6.setParent(new ims.emergency.vo.lookups.TriagePriority(parent6.getId(),parent6.getText(), parent6.isActive(), null, img, color));
				parentVoLookup6 = parentVoLookup6.getParent();
								parent6 = parent6.getParent();
			}			
			valueObject.setDefaultTriagePriority(voLookup6);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.emergency.configuration.domain.objects.DiscriminatorConfig extractDiscriminatorConfig(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.DiscriminatorConfigVo valueObject) 
	{
		return 	extractDiscriminatorConfig(domainFactory, valueObject, new HashMap());
	}

	public static ims.emergency.configuration.domain.objects.DiscriminatorConfig extractDiscriminatorConfig(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.DiscriminatorConfigVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_DiscriminatorConfig();
		ims.emergency.configuration.domain.objects.DiscriminatorConfig domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.emergency.configuration.domain.objects.DiscriminatorConfig)domMap.get(valueObject);
			}
			// ims.emergency.vo.DiscriminatorConfigVo ID_DiscriminatorConfig field is unknown
			domainObject = new ims.emergency.configuration.domain.objects.DiscriminatorConfig();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_DiscriminatorConfig());
			if (domMap.get(key) != null)
			{
				return (ims.emergency.configuration.domain.objects.DiscriminatorConfig)domMap.get(key);
			}
			domainObject = (ims.emergency.configuration.domain.objects.DiscriminatorConfig) domainFactory.getDomainObject(ims.emergency.configuration.domain.objects.DiscriminatorConfig.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_DiscriminatorConfig());

		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getDiscriminatorName() != null && valueObject.getDiscriminatorName().equals(""))
		{
			valueObject.setDiscriminatorName(null);
		}
		domainObject.setDiscriminatorName(valueObject.getDiscriminatorName());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getDiscriminatorDescription() != null && valueObject.getDiscriminatorDescription().equals(""))
		{
			valueObject.setDiscriminatorDescription(null);
		}
		domainObject.setDiscriminatorDescription(valueObject.getDiscriminatorDescription());
		domainObject.setTaxonomyMap(ims.core.vo.domain.TaxonomyMapAssembler.extractTaxonomyMapList(domainFactory, valueObject.getTaxonomyMap(), domainObject.getTaxonomyMap(), domMap));		
		domainObject.setIsActive(valueObject.getIsActive());
		domainObject.setKeywords(ims.core.vo.domain.KeywordVoAssembler.extractKeywordList(domainFactory, valueObject.getKeywords(), domainObject.getKeywords(), domMap));		
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value6 = null;
		if ( null != valueObject.getDefaultTriagePriority() ) 
		{
			value6 =
				domainFactory.getLookupInstance(valueObject.getDefaultTriagePriority().getID());
		}
		domainObject.setDefaultTriagePriority(value6);

		return domainObject;
	}

}
