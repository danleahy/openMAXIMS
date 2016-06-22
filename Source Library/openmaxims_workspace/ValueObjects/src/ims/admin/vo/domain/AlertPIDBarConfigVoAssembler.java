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
package ims.admin.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Florin Blindu
 */
public class AlertPIDBarConfigVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.admin.vo.AlertPIDBarConfigVo copy(ims.admin.vo.AlertPIDBarConfigVo valueObjectDest, ims.admin.vo.AlertPIDBarConfigVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_AlertPIDBarConfig(valueObjectSrc.getID_AlertPIDBarConfig());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// AlertCategoryPosition1
		valueObjectDest.setAlertCategoryPosition1(valueObjectSrc.getAlertCategoryPosition1());
		// AlertCategoryPosition2
		valueObjectDest.setAlertCategoryPosition2(valueObjectSrc.getAlertCategoryPosition2());
		// AlertCategoryPosition3
		valueObjectDest.setAlertCategoryPosition3(valueObjectSrc.getAlertCategoryPosition3());
		// AlertCategoryPosition4
		valueObjectDest.setAlertCategoryPosition4(valueObjectSrc.getAlertCategoryPosition4());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createAlertPIDBarConfigVoCollectionFromAlertPIDBarConfig(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.clinical.configuration.domain.objects.AlertPIDBarConfig objects.
	 */
	public static ims.admin.vo.AlertPIDBarConfigVoCollection createAlertPIDBarConfigVoCollectionFromAlertPIDBarConfig(java.util.Set domainObjectSet)	
	{
		return createAlertPIDBarConfigVoCollectionFromAlertPIDBarConfig(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.clinical.configuration.domain.objects.AlertPIDBarConfig objects.
	 */
	public static ims.admin.vo.AlertPIDBarConfigVoCollection createAlertPIDBarConfigVoCollectionFromAlertPIDBarConfig(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.admin.vo.AlertPIDBarConfigVoCollection voList = new ims.admin.vo.AlertPIDBarConfigVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.clinical.configuration.domain.objects.AlertPIDBarConfig domainObject = (ims.clinical.configuration.domain.objects.AlertPIDBarConfig) iterator.next();
			ims.admin.vo.AlertPIDBarConfigVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.clinical.configuration.domain.objects.AlertPIDBarConfig objects.
	 */
	public static ims.admin.vo.AlertPIDBarConfigVoCollection createAlertPIDBarConfigVoCollectionFromAlertPIDBarConfig(java.util.List domainObjectList) 
	{
		return createAlertPIDBarConfigVoCollectionFromAlertPIDBarConfig(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.clinical.configuration.domain.objects.AlertPIDBarConfig objects.
	 */
	public static ims.admin.vo.AlertPIDBarConfigVoCollection createAlertPIDBarConfigVoCollectionFromAlertPIDBarConfig(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.admin.vo.AlertPIDBarConfigVoCollection voList = new ims.admin.vo.AlertPIDBarConfigVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.clinical.configuration.domain.objects.AlertPIDBarConfig domainObject = (ims.clinical.configuration.domain.objects.AlertPIDBarConfig) domainObjectList.get(i);
			ims.admin.vo.AlertPIDBarConfigVo vo = create(map, domainObject);

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
	 * Create the ims.clinical.configuration.domain.objects.AlertPIDBarConfig set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractAlertPIDBarConfigSet(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.AlertPIDBarConfigVoCollection voCollection) 
	 {
	 	return extractAlertPIDBarConfigSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractAlertPIDBarConfigSet(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.AlertPIDBarConfigVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.admin.vo.AlertPIDBarConfigVo vo = voCollection.get(i);
			ims.clinical.configuration.domain.objects.AlertPIDBarConfig domainObject = AlertPIDBarConfigVoAssembler.extractAlertPIDBarConfig(domainFactory, vo, domMap);

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
	 * Create the ims.clinical.configuration.domain.objects.AlertPIDBarConfig list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractAlertPIDBarConfigList(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.AlertPIDBarConfigVoCollection voCollection) 
	 {
	 	return extractAlertPIDBarConfigList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractAlertPIDBarConfigList(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.AlertPIDBarConfigVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.admin.vo.AlertPIDBarConfigVo vo = voCollection.get(i);
			ims.clinical.configuration.domain.objects.AlertPIDBarConfig domainObject = AlertPIDBarConfigVoAssembler.extractAlertPIDBarConfig(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.clinical.configuration.domain.objects.AlertPIDBarConfig object.
	 * @param domainObject ims.clinical.configuration.domain.objects.AlertPIDBarConfig
	 */
	 public static ims.admin.vo.AlertPIDBarConfigVo create(ims.clinical.configuration.domain.objects.AlertPIDBarConfig domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.clinical.configuration.domain.objects.AlertPIDBarConfig object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.admin.vo.AlertPIDBarConfigVo create(DomainObjectMap map, ims.clinical.configuration.domain.objects.AlertPIDBarConfig domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.admin.vo.AlertPIDBarConfigVo valueObject = (ims.admin.vo.AlertPIDBarConfigVo) map.getValueObject(domainObject, ims.admin.vo.AlertPIDBarConfigVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.admin.vo.AlertPIDBarConfigVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.clinical.configuration.domain.objects.AlertPIDBarConfig
	 */
	 public static ims.admin.vo.AlertPIDBarConfigVo insert(ims.admin.vo.AlertPIDBarConfigVo valueObject, ims.clinical.configuration.domain.objects.AlertPIDBarConfig domainObject) 
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
	 * @param domainObject ims.clinical.configuration.domain.objects.AlertPIDBarConfig
	 */
	 public static ims.admin.vo.AlertPIDBarConfigVo insert(DomainObjectMap map, ims.admin.vo.AlertPIDBarConfigVo valueObject, ims.clinical.configuration.domain.objects.AlertPIDBarConfig domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_AlertPIDBarConfig(domainObject.getId());
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
			
		// AlertCategoryPosition1
		ims.domain.lookups.LookupInstance instance1 = domainObject.getAlertCategoryPosition1();
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

			ims.core.vo.lookups.AlertType voLookup1 = new ims.core.vo.lookups.AlertType(instance1.getId(),instance1.getText(), instance1.isActive(), null, img, color);
			ims.core.vo.lookups.AlertType parentVoLookup1 = voLookup1;
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
								parentVoLookup1.setParent(new ims.core.vo.lookups.AlertType(parent1.getId(),parent1.getText(), parent1.isActive(), null, img, color));
				parentVoLookup1 = parentVoLookup1.getParent();
								parent1 = parent1.getParent();
			}			
			valueObject.setAlertCategoryPosition1(voLookup1);
		}
				// AlertCategoryPosition2
		ims.domain.lookups.LookupInstance instance2 = domainObject.getAlertCategoryPosition2();
		if ( null != instance2 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance2.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance2.getImage().getImageId(), instance2.getImage().getImagePath());
			}
			color = instance2.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.AlertType voLookup2 = new ims.core.vo.lookups.AlertType(instance2.getId(),instance2.getText(), instance2.isActive(), null, img, color);
			ims.core.vo.lookups.AlertType parentVoLookup2 = voLookup2;
			ims.domain.lookups.LookupInstance parent2 = instance2.getParent();
			while (parent2 != null)
			{
				if (parent2.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent2.getImage().getImageId(), parent2.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent2.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup2.setParent(new ims.core.vo.lookups.AlertType(parent2.getId(),parent2.getText(), parent2.isActive(), null, img, color));
				parentVoLookup2 = parentVoLookup2.getParent();
								parent2 = parent2.getParent();
			}			
			valueObject.setAlertCategoryPosition2(voLookup2);
		}
				// AlertCategoryPosition3
		ims.domain.lookups.LookupInstance instance3 = domainObject.getAlertCategoryPosition3();
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

			ims.core.vo.lookups.AlertType voLookup3 = new ims.core.vo.lookups.AlertType(instance3.getId(),instance3.getText(), instance3.isActive(), null, img, color);
			ims.core.vo.lookups.AlertType parentVoLookup3 = voLookup3;
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
								parentVoLookup3.setParent(new ims.core.vo.lookups.AlertType(parent3.getId(),parent3.getText(), parent3.isActive(), null, img, color));
				parentVoLookup3 = parentVoLookup3.getParent();
								parent3 = parent3.getParent();
			}			
			valueObject.setAlertCategoryPosition3(voLookup3);
		}
				// AlertCategoryPosition4
		ims.domain.lookups.LookupInstance instance4 = domainObject.getAlertCategoryPosition4();
		if ( null != instance4 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance4.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance4.getImage().getImageId(), instance4.getImage().getImagePath());
			}
			color = instance4.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.AlertType voLookup4 = new ims.core.vo.lookups.AlertType(instance4.getId(),instance4.getText(), instance4.isActive(), null, img, color);
			ims.core.vo.lookups.AlertType parentVoLookup4 = voLookup4;
			ims.domain.lookups.LookupInstance parent4 = instance4.getParent();
			while (parent4 != null)
			{
				if (parent4.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent4.getImage().getImageId(), parent4.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent4.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup4.setParent(new ims.core.vo.lookups.AlertType(parent4.getId(),parent4.getText(), parent4.isActive(), null, img, color));
				parentVoLookup4 = parentVoLookup4.getParent();
								parent4 = parent4.getParent();
			}			
			valueObject.setAlertCategoryPosition4(voLookup4);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.clinical.configuration.domain.objects.AlertPIDBarConfig extractAlertPIDBarConfig(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.AlertPIDBarConfigVo valueObject) 
	{
		return 	extractAlertPIDBarConfig(domainFactory, valueObject, new HashMap());
	}

	public static ims.clinical.configuration.domain.objects.AlertPIDBarConfig extractAlertPIDBarConfig(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.AlertPIDBarConfigVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_AlertPIDBarConfig();
		ims.clinical.configuration.domain.objects.AlertPIDBarConfig domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.clinical.configuration.domain.objects.AlertPIDBarConfig)domMap.get(valueObject);
			}
			// ims.admin.vo.AlertPIDBarConfigVo ID_AlertPIDBarConfig field is unknown
			domainObject = new ims.clinical.configuration.domain.objects.AlertPIDBarConfig();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_AlertPIDBarConfig());
			if (domMap.get(key) != null)
			{
				return (ims.clinical.configuration.domain.objects.AlertPIDBarConfig)domMap.get(key);
			}
			domainObject = (ims.clinical.configuration.domain.objects.AlertPIDBarConfig) domainFactory.getDomainObject(ims.clinical.configuration.domain.objects.AlertPIDBarConfig.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_AlertPIDBarConfig());

		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value1 = null;
		if ( null != valueObject.getAlertCategoryPosition1() ) 
		{
			value1 =
				domainFactory.getLookupInstance(valueObject.getAlertCategoryPosition1().getID());
		}
		domainObject.setAlertCategoryPosition1(value1);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value2 = null;
		if ( null != valueObject.getAlertCategoryPosition2() ) 
		{
			value2 =
				domainFactory.getLookupInstance(valueObject.getAlertCategoryPosition2().getID());
		}
		domainObject.setAlertCategoryPosition2(value2);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value3 = null;
		if ( null != valueObject.getAlertCategoryPosition3() ) 
		{
			value3 =
				domainFactory.getLookupInstance(valueObject.getAlertCategoryPosition3().getID());
		}
		domainObject.setAlertCategoryPosition3(value3);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value4 = null;
		if ( null != valueObject.getAlertCategoryPosition4() ) 
		{
			value4 =
				domainFactory.getLookupInstance(valueObject.getAlertCategoryPosition4().getID());
		}
		domainObject.setAlertCategoryPosition4(value4);

		return domainObject;
	}

}
