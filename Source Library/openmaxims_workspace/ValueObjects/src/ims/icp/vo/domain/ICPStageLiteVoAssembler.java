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
package ims.icp.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Vasile Purdila
 */
public class ICPStageLiteVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.icp.vo.ICPStageLiteVo copy(ims.icp.vo.ICPStageLiteVo valueObjectDest, ims.icp.vo.ICPStageLiteVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ICPStage(valueObjectSrc.getID_ICPStage());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Name
		valueObjectDest.setName(valueObjectSrc.getName());
		// Description
		valueObjectDest.setDescription(valueObjectSrc.getDescription());
		// Sequence
		valueObjectDest.setSequence(valueObjectSrc.getSequence());
		// Status
		valueObjectDest.setStatus(valueObjectSrc.getStatus());
		// HelpURL
		valueObjectDest.setHelpURL(valueObjectSrc.getHelpURL());
		// IsActivatedOnInitiation
		valueObjectDest.setIsActivatedOnInitiation(valueObjectSrc.getIsActivatedOnInitiation());
		// HasPhase
		valueObjectDest.setHasPhase(valueObjectSrc.getHasPhase());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createICPStageLiteVoCollectionFromICPStage(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.icps.configuration.domain.objects.ICPStage objects.
	 */
	public static ims.icp.vo.ICPStageLiteVoCollection createICPStageLiteVoCollectionFromICPStage(java.util.Set domainObjectSet)	
	{
		return createICPStageLiteVoCollectionFromICPStage(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.icps.configuration.domain.objects.ICPStage objects.
	 */
	public static ims.icp.vo.ICPStageLiteVoCollection createICPStageLiteVoCollectionFromICPStage(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.icp.vo.ICPStageLiteVoCollection voList = new ims.icp.vo.ICPStageLiteVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.icps.configuration.domain.objects.ICPStage domainObject = (ims.icps.configuration.domain.objects.ICPStage) iterator.next();
			ims.icp.vo.ICPStageLiteVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.icps.configuration.domain.objects.ICPStage objects.
	 */
	public static ims.icp.vo.ICPStageLiteVoCollection createICPStageLiteVoCollectionFromICPStage(java.util.List domainObjectList) 
	{
		return createICPStageLiteVoCollectionFromICPStage(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.icps.configuration.domain.objects.ICPStage objects.
	 */
	public static ims.icp.vo.ICPStageLiteVoCollection createICPStageLiteVoCollectionFromICPStage(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.icp.vo.ICPStageLiteVoCollection voList = new ims.icp.vo.ICPStageLiteVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.icps.configuration.domain.objects.ICPStage domainObject = (ims.icps.configuration.domain.objects.ICPStage) domainObjectList.get(i);
			ims.icp.vo.ICPStageLiteVo vo = create(map, domainObject);

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
	 * Create the ims.icps.configuration.domain.objects.ICPStage set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractICPStageSet(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPStageLiteVoCollection voCollection) 
	 {
	 	return extractICPStageSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractICPStageSet(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPStageLiteVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.icp.vo.ICPStageLiteVo vo = voCollection.get(i);
			ims.icps.configuration.domain.objects.ICPStage domainObject = ICPStageLiteVoAssembler.extractICPStage(domainFactory, vo, domMap);

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
	 * Create the ims.icps.configuration.domain.objects.ICPStage list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractICPStageList(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPStageLiteVoCollection voCollection) 
	 {
	 	return extractICPStageList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractICPStageList(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPStageLiteVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.icp.vo.ICPStageLiteVo vo = voCollection.get(i);
			ims.icps.configuration.domain.objects.ICPStage domainObject = ICPStageLiteVoAssembler.extractICPStage(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.icps.configuration.domain.objects.ICPStage object.
	 * @param domainObject ims.icps.configuration.domain.objects.ICPStage
	 */
	 public static ims.icp.vo.ICPStageLiteVo create(ims.icps.configuration.domain.objects.ICPStage domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.icps.configuration.domain.objects.ICPStage object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.icp.vo.ICPStageLiteVo create(DomainObjectMap map, ims.icps.configuration.domain.objects.ICPStage domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.icp.vo.ICPStageLiteVo valueObject = (ims.icp.vo.ICPStageLiteVo) map.getValueObject(domainObject, ims.icp.vo.ICPStageLiteVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.icp.vo.ICPStageLiteVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.icps.configuration.domain.objects.ICPStage
	 */
	 public static ims.icp.vo.ICPStageLiteVo insert(ims.icp.vo.ICPStageLiteVo valueObject, ims.icps.configuration.domain.objects.ICPStage domainObject) 
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
	 * @param domainObject ims.icps.configuration.domain.objects.ICPStage
	 */
	 public static ims.icp.vo.ICPStageLiteVo insert(DomainObjectMap map, ims.icp.vo.ICPStageLiteVo valueObject, ims.icps.configuration.domain.objects.ICPStage domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ICPStage(domainObject.getId());
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
		// Description
		valueObject.setDescription(domainObject.getDescription());
		// Sequence
		valueObject.setSequence(domainObject.getSequence());
		// Status
		ims.domain.lookups.LookupInstance instance4 = domainObject.getStatus();
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

			ims.core.vo.lookups.PreActiveActiveInactiveStatus voLookup4 = new ims.core.vo.lookups.PreActiveActiveInactiveStatus(instance4.getId(),instance4.getText(), instance4.isActive(), null, img, color);
			ims.core.vo.lookups.PreActiveActiveInactiveStatus parentVoLookup4 = voLookup4;
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
								parentVoLookup4.setParent(new ims.core.vo.lookups.PreActiveActiveInactiveStatus(parent4.getId(),parent4.getText(), parent4.isActive(), null, img, color));
				parentVoLookup4 = parentVoLookup4.getParent();
								parent4 = parent4.getParent();
			}			
			valueObject.setStatus(voLookup4);
		}
				// HelpURL
		valueObject.setHelpURL(domainObject.getHelpURL());
		// IsActivatedOnInitiation
		valueObject.setIsActivatedOnInitiation( domainObject.isIsActivatedOnInitiation() );
		// HasPhase
		valueObject.setHasPhase( domainObject.isHasPhase() );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.icps.configuration.domain.objects.ICPStage extractICPStage(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPStageLiteVo valueObject) 
	{
		return 	extractICPStage(domainFactory, valueObject, new HashMap());
	}

	public static ims.icps.configuration.domain.objects.ICPStage extractICPStage(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPStageLiteVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ICPStage();
		ims.icps.configuration.domain.objects.ICPStage domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.icps.configuration.domain.objects.ICPStage)domMap.get(valueObject);
			}
			// ims.icp.vo.ICPStageLiteVo ID_ICPStage field is unknown
			domainObject = new ims.icps.configuration.domain.objects.ICPStage();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ICPStage());
			if (domMap.get(key) != null)
			{
				return (ims.icps.configuration.domain.objects.ICPStage)domMap.get(key);
			}
			domainObject = (ims.icps.configuration.domain.objects.ICPStage) domainFactory.getDomainObject(ims.icps.configuration.domain.objects.ICPStage.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ICPStage());

		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getName() != null && valueObject.getName().equals(""))
		{
			valueObject.setName(null);
		}
		domainObject.setName(valueObject.getName());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getDescription() != null && valueObject.getDescription().equals(""))
		{
			valueObject.setDescription(null);
		}
		domainObject.setDescription(valueObject.getDescription());
		domainObject.setSequence(valueObject.getSequence());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value4 = null;
		if ( null != valueObject.getStatus() ) 
		{
			value4 =
				domainFactory.getLookupInstance(valueObject.getStatus().getID());
		}
		domainObject.setStatus(value4);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getHelpURL() != null && valueObject.getHelpURL().equals(""))
		{
			valueObject.setHelpURL(null);
		}
		domainObject.setHelpURL(valueObject.getHelpURL());
		domainObject.setIsActivatedOnInitiation(valueObject.getIsActivatedOnInitiation());
		domainObject.setHasPhase(valueObject.getHasPhase());

		return domainObject;
	}

}
