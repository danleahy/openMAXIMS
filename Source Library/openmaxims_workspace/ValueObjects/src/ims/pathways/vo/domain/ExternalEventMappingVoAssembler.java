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
 * Generated on 12/10/2015, 13:23
 *
 */
package ims.pathways.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Catalin Tomozei
 */
public class ExternalEventMappingVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.pathways.vo.ExternalEventMappingVo copy(ims.pathways.vo.ExternalEventMappingVo valueObjectDest, ims.pathways.vo.ExternalEventMappingVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ExternalEventMapping(valueObjectSrc.getID_ExternalEventMapping());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// ProviderSystem
		valueObjectDest.setProviderSystem(valueObjectSrc.getProviderSystem());
		// Group
		valueObjectDest.setGroup(valueObjectSrc.getGroup());
		// Detail
		valueObjectDest.setDetail(valueObjectSrc.getDetail());
		// Specialty
		valueObjectDest.setSpecialty(valueObjectSrc.getSpecialty());
		// ClinicCode
		valueObjectDest.setClinicCode(valueObjectSrc.getClinicCode());
		// Consultant
		valueObjectDest.setConsultant(valueObjectSrc.getConsultant());
		// Description
		valueObjectDest.setDescription(valueObjectSrc.getDescription());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createExternalEventMappingVoCollectionFromExternalEventMapping(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.pathways.configuration.domain.objects.ExternalEventMapping objects.
	 */
	public static ims.pathways.vo.ExternalEventMappingVoCollection createExternalEventMappingVoCollectionFromExternalEventMapping(java.util.Set domainObjectSet)	
	{
		return createExternalEventMappingVoCollectionFromExternalEventMapping(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.pathways.configuration.domain.objects.ExternalEventMapping objects.
	 */
	public static ims.pathways.vo.ExternalEventMappingVoCollection createExternalEventMappingVoCollectionFromExternalEventMapping(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.pathways.vo.ExternalEventMappingVoCollection voList = new ims.pathways.vo.ExternalEventMappingVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.pathways.configuration.domain.objects.ExternalEventMapping domainObject = (ims.pathways.configuration.domain.objects.ExternalEventMapping) iterator.next();
			ims.pathways.vo.ExternalEventMappingVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.pathways.configuration.domain.objects.ExternalEventMapping objects.
	 */
	public static ims.pathways.vo.ExternalEventMappingVoCollection createExternalEventMappingVoCollectionFromExternalEventMapping(java.util.List domainObjectList) 
	{
		return createExternalEventMappingVoCollectionFromExternalEventMapping(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.pathways.configuration.domain.objects.ExternalEventMapping objects.
	 */
	public static ims.pathways.vo.ExternalEventMappingVoCollection createExternalEventMappingVoCollectionFromExternalEventMapping(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.pathways.vo.ExternalEventMappingVoCollection voList = new ims.pathways.vo.ExternalEventMappingVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.pathways.configuration.domain.objects.ExternalEventMapping domainObject = (ims.pathways.configuration.domain.objects.ExternalEventMapping) domainObjectList.get(i);
			ims.pathways.vo.ExternalEventMappingVo vo = create(map, domainObject);

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
	 * Create the ims.pathways.configuration.domain.objects.ExternalEventMapping set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractExternalEventMappingSet(ims.domain.ILightweightDomainFactory domainFactory, ims.pathways.vo.ExternalEventMappingVoCollection voCollection) 
	 {
	 	return extractExternalEventMappingSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractExternalEventMappingSet(ims.domain.ILightweightDomainFactory domainFactory, ims.pathways.vo.ExternalEventMappingVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.pathways.vo.ExternalEventMappingVo vo = voCollection.get(i);
			ims.pathways.configuration.domain.objects.ExternalEventMapping domainObject = ExternalEventMappingVoAssembler.extractExternalEventMapping(domainFactory, vo, domMap);

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
	 * Create the ims.pathways.configuration.domain.objects.ExternalEventMapping list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractExternalEventMappingList(ims.domain.ILightweightDomainFactory domainFactory, ims.pathways.vo.ExternalEventMappingVoCollection voCollection) 
	 {
	 	return extractExternalEventMappingList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractExternalEventMappingList(ims.domain.ILightweightDomainFactory domainFactory, ims.pathways.vo.ExternalEventMappingVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.pathways.vo.ExternalEventMappingVo vo = voCollection.get(i);
			ims.pathways.configuration.domain.objects.ExternalEventMapping domainObject = ExternalEventMappingVoAssembler.extractExternalEventMapping(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.pathways.configuration.domain.objects.ExternalEventMapping object.
	 * @param domainObject ims.pathways.configuration.domain.objects.ExternalEventMapping
	 */
	 public static ims.pathways.vo.ExternalEventMappingVo create(ims.pathways.configuration.domain.objects.ExternalEventMapping domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.pathways.configuration.domain.objects.ExternalEventMapping object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.pathways.vo.ExternalEventMappingVo create(DomainObjectMap map, ims.pathways.configuration.domain.objects.ExternalEventMapping domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.pathways.vo.ExternalEventMappingVo valueObject = (ims.pathways.vo.ExternalEventMappingVo) map.getValueObject(domainObject, ims.pathways.vo.ExternalEventMappingVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.pathways.vo.ExternalEventMappingVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.pathways.configuration.domain.objects.ExternalEventMapping
	 */
	 public static ims.pathways.vo.ExternalEventMappingVo insert(ims.pathways.vo.ExternalEventMappingVo valueObject, ims.pathways.configuration.domain.objects.ExternalEventMapping domainObject) 
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
	 * @param domainObject ims.pathways.configuration.domain.objects.ExternalEventMapping
	 */
	 public static ims.pathways.vo.ExternalEventMappingVo insert(DomainObjectMap map, ims.pathways.vo.ExternalEventMappingVo valueObject, ims.pathways.configuration.domain.objects.ExternalEventMapping domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ExternalEventMapping(domainObject.getId());
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
			
		// ProviderSystem
		valueObject.setProviderSystem(ims.ocrr.vo.domain.ProviderSystemVoAssembler.create(map, domainObject.getProviderSystem()) );
		// Group
		ims.domain.lookups.LookupInstance instance2 = domainObject.getGroup();
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

			ims.pathways.vo.lookups.PathwaysGroup voLookup2 = new ims.pathways.vo.lookups.PathwaysGroup(instance2.getId(),instance2.getText(), instance2.isActive(), null, img, color);
			ims.pathways.vo.lookups.PathwaysGroup parentVoLookup2 = voLookup2;
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
								parentVoLookup2.setParent(new ims.pathways.vo.lookups.PathwaysGroup(parent2.getId(),parent2.getText(), parent2.isActive(), null, img, color));
				parentVoLookup2 = parentVoLookup2.getParent();
								parent2 = parent2.getParent();
			}			
			valueObject.setGroup(voLookup2);
		}
				// Detail
		ims.domain.lookups.LookupInstance instance3 = domainObject.getDetail();
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

			ims.pathways.vo.lookups.PathwaysDetail voLookup3 = new ims.pathways.vo.lookups.PathwaysDetail(instance3.getId(),instance3.getText(), instance3.isActive(), null, img, color);
			ims.pathways.vo.lookups.PathwaysDetail parentVoLookup3 = voLookup3;
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
								parentVoLookup3.setParent(new ims.pathways.vo.lookups.PathwaysDetail(parent3.getId(),parent3.getText(), parent3.isActive(), null, img, color));
				parentVoLookup3 = parentVoLookup3.getParent();
								parent3 = parent3.getParent();
			}			
			valueObject.setDetail(voLookup3);
		}
				// Specialty
		ims.domain.lookups.LookupInstance instance4 = domainObject.getSpecialty();
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

			ims.core.vo.lookups.Specialty voLookup4 = new ims.core.vo.lookups.Specialty(instance4.getId(),instance4.getText(), instance4.isActive(), null, img, color);
			ims.core.vo.lookups.Specialty parentVoLookup4 = voLookup4;
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
								parentVoLookup4.setParent(new ims.core.vo.lookups.Specialty(parent4.getId(),parent4.getText(), parent4.isActive(), null, img, color));
				parentVoLookup4 = parentVoLookup4.getParent();
								parent4 = parent4.getParent();
			}			
			valueObject.setSpecialty(voLookup4);
		}
				// ClinicCode
		valueObject.setClinicCode(domainObject.getClinicCode());
		// Consultant
		valueObject.setConsultant(ims.core.vo.domain.MedicLiteVoAssembler.create(map, domainObject.getConsultant()) );
		// Description
		valueObject.setDescription(domainObject.getDescription());
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.pathways.configuration.domain.objects.ExternalEventMapping extractExternalEventMapping(ims.domain.ILightweightDomainFactory domainFactory, ims.pathways.vo.ExternalEventMappingVo valueObject) 
	{
		return 	extractExternalEventMapping(domainFactory, valueObject, new HashMap());
	}

	public static ims.pathways.configuration.domain.objects.ExternalEventMapping extractExternalEventMapping(ims.domain.ILightweightDomainFactory domainFactory, ims.pathways.vo.ExternalEventMappingVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ExternalEventMapping();
		ims.pathways.configuration.domain.objects.ExternalEventMapping domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.pathways.configuration.domain.objects.ExternalEventMapping)domMap.get(valueObject);
			}
			// ims.pathways.vo.ExternalEventMappingVo ID_ExternalEventMapping field is unknown
			domainObject = new ims.pathways.configuration.domain.objects.ExternalEventMapping();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ExternalEventMapping());
			if (domMap.get(key) != null)
			{
				return (ims.pathways.configuration.domain.objects.ExternalEventMapping)domMap.get(key);
			}
			domainObject = (ims.pathways.configuration.domain.objects.ExternalEventMapping) domainFactory.getDomainObject(ims.pathways.configuration.domain.objects.ExternalEventMapping.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ExternalEventMapping());

	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.admin.domain.objects.ProviderSystem value1 = null;
		if ( null != valueObject.getProviderSystem() ) 
		{
			if (valueObject.getProviderSystem().getBoId() == null)
			{
				if (domMap.get(valueObject.getProviderSystem()) != null)
				{
					value1 = (ims.core.admin.domain.objects.ProviderSystem)domMap.get(valueObject.getProviderSystem());
				}
			}
			else
			{
				value1 = (ims.core.admin.domain.objects.ProviderSystem)domainFactory.getDomainObject(ims.core.admin.domain.objects.ProviderSystem.class, valueObject.getProviderSystem().getBoId());
			}
		}
		domainObject.setProviderSystem(value1);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value2 = null;
		if ( null != valueObject.getGroup() ) 
		{
			value2 =
				domainFactory.getLookupInstance(valueObject.getGroup().getID());
		}
		domainObject.setGroup(value2);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value3 = null;
		if ( null != valueObject.getDetail() ) 
		{
			value3 =
				domainFactory.getLookupInstance(valueObject.getDetail().getID());
		}
		domainObject.setDetail(value3);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value4 = null;
		if ( null != valueObject.getSpecialty() ) 
		{
			value4 =
				domainFactory.getLookupInstance(valueObject.getSpecialty().getID());
		}
		domainObject.setSpecialty(value4);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getClinicCode() != null && valueObject.getClinicCode().equals(""))
		{
			valueObject.setClinicCode(null);
		}
		domainObject.setClinicCode(valueObject.getClinicCode());
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.people.domain.objects.Medic value6 = null;
		if ( null != valueObject.getConsultant() ) 
		{
			if (valueObject.getConsultant().getBoId() == null)
			{
				if (domMap.get(valueObject.getConsultant()) != null)
				{
					value6 = (ims.core.resource.people.domain.objects.Medic)domMap.get(valueObject.getConsultant());
				}
			}
			else
			{
				value6 = (ims.core.resource.people.domain.objects.Medic)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.Medic.class, valueObject.getConsultant().getBoId());
			}
		}
		domainObject.setConsultant(value6);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getDescription() != null && valueObject.getDescription().equals(""))
		{
			valueObject.setDescription(null);
		}
		domainObject.setDescription(valueObject.getDescription());

		return domainObject;
	}

}
