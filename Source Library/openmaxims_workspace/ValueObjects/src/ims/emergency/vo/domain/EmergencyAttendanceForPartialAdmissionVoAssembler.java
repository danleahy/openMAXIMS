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
package ims.emergency.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Florin Blindu
 */
public class EmergencyAttendanceForPartialAdmissionVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo copy(ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo valueObjectDest, ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_EmergencyAttendance(valueObjectSrc.getID_EmergencyAttendance());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// BedTypeRequested
		valueObjectDest.setBedTypeRequested(valueObjectSrc.getBedTypeRequested());
		// PatientAttendanceStatus
		valueObjectDest.setPatientAttendanceStatus(valueObjectSrc.getPatientAttendanceStatus());
		// ConclusionDateTime
		valueObjectDest.setConclusionDateTime(valueObjectSrc.getConclusionDateTime());
		// AccomodationRequestedType
		valueObjectDest.setAccomodationRequestedType(valueObjectSrc.getAccomodationRequestedType());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createEmergencyAttendanceForPartialAdmissionVoCollectionFromEmergencyAttendance(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.admin.domain.objects.EmergencyAttendance objects.
	 */
	public static ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVoCollection createEmergencyAttendanceForPartialAdmissionVoCollectionFromEmergencyAttendance(java.util.Set domainObjectSet)	
	{
		return createEmergencyAttendanceForPartialAdmissionVoCollectionFromEmergencyAttendance(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.admin.domain.objects.EmergencyAttendance objects.
	 */
	public static ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVoCollection createEmergencyAttendanceForPartialAdmissionVoCollectionFromEmergencyAttendance(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVoCollection voList = new ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.admin.domain.objects.EmergencyAttendance domainObject = (ims.core.admin.domain.objects.EmergencyAttendance) iterator.next();
			ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.core.admin.domain.objects.EmergencyAttendance objects.
	 */
	public static ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVoCollection createEmergencyAttendanceForPartialAdmissionVoCollectionFromEmergencyAttendance(java.util.List domainObjectList) 
	{
		return createEmergencyAttendanceForPartialAdmissionVoCollectionFromEmergencyAttendance(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.admin.domain.objects.EmergencyAttendance objects.
	 */
	public static ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVoCollection createEmergencyAttendanceForPartialAdmissionVoCollectionFromEmergencyAttendance(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVoCollection voList = new ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.admin.domain.objects.EmergencyAttendance domainObject = (ims.core.admin.domain.objects.EmergencyAttendance) domainObjectList.get(i);
			ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo vo = create(map, domainObject);

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
	 * Create the ims.core.admin.domain.objects.EmergencyAttendance set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractEmergencyAttendanceSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVoCollection voCollection) 
	 {
	 	return extractEmergencyAttendanceSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractEmergencyAttendanceSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo vo = voCollection.get(i);
			ims.core.admin.domain.objects.EmergencyAttendance domainObject = EmergencyAttendanceForPartialAdmissionVoAssembler.extractEmergencyAttendance(domainFactory, vo, domMap);

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
	 * Create the ims.core.admin.domain.objects.EmergencyAttendance list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractEmergencyAttendanceList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVoCollection voCollection) 
	 {
	 	return extractEmergencyAttendanceList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractEmergencyAttendanceList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo vo = voCollection.get(i);
			ims.core.admin.domain.objects.EmergencyAttendance domainObject = EmergencyAttendanceForPartialAdmissionVoAssembler.extractEmergencyAttendance(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.core.admin.domain.objects.EmergencyAttendance object.
	 * @param domainObject ims.core.admin.domain.objects.EmergencyAttendance
	 */
	 public static ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo create(ims.core.admin.domain.objects.EmergencyAttendance domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.admin.domain.objects.EmergencyAttendance object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo create(DomainObjectMap map, ims.core.admin.domain.objects.EmergencyAttendance domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo valueObject = (ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo) map.getValueObject(domainObject, ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.admin.domain.objects.EmergencyAttendance
	 */
	 public static ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo insert(ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo valueObject, ims.core.admin.domain.objects.EmergencyAttendance domainObject) 
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
	 * @param domainObject ims.core.admin.domain.objects.EmergencyAttendance
	 */
	 public static ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo insert(DomainObjectMap map, ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo valueObject, ims.core.admin.domain.objects.EmergencyAttendance domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_EmergencyAttendance(domainObject.getId());
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
			
		// BedTypeRequested
		ims.domain.lookups.LookupInstance instance1 = domainObject.getBedTypeRequested();
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

			ims.core.vo.lookups.BedTypeRequested voLookup1 = new ims.core.vo.lookups.BedTypeRequested(instance1.getId(),instance1.getText(), instance1.isActive(), null, img, color);
			ims.core.vo.lookups.BedTypeRequested parentVoLookup1 = voLookup1;
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
								parentVoLookup1.setParent(new ims.core.vo.lookups.BedTypeRequested(parent1.getId(),parent1.getText(), parent1.isActive(), null, img, color));
				parentVoLookup1 = parentVoLookup1.getParent();
								parent1 = parent1.getParent();
			}			
			valueObject.setBedTypeRequested(voLookup1);
		}
				// PatientAttendanceStatus
		ims.domain.lookups.LookupInstance instance2 = domainObject.getPatientAttendanceStatus();
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

			ims.emergency.vo.lookups.PatientAttendanceStatus voLookup2 = new ims.emergency.vo.lookups.PatientAttendanceStatus(instance2.getId(),instance2.getText(), instance2.isActive(), null, img, color);
			ims.emergency.vo.lookups.PatientAttendanceStatus parentVoLookup2 = voLookup2;
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
								parentVoLookup2.setParent(new ims.emergency.vo.lookups.PatientAttendanceStatus(parent2.getId(),parent2.getText(), parent2.isActive(), null, img, color));
				parentVoLookup2 = parentVoLookup2.getParent();
								parent2 = parent2.getParent();
			}			
			valueObject.setPatientAttendanceStatus(voLookup2);
		}
				// ConclusionDateTime
		java.util.Date ConclusionDateTime = domainObject.getConclusionDateTime();
		if ( null != ConclusionDateTime ) 
		{
			valueObject.setConclusionDateTime(new ims.framework.utils.DateTime(ConclusionDateTime) );
		}
		// AccomodationRequestedType
		ims.domain.lookups.LookupInstance instance4 = domainObject.getAccomodationRequestedType();
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

			ims.core.vo.lookups.AccomodationRequestedType voLookup4 = new ims.core.vo.lookups.AccomodationRequestedType(instance4.getId(),instance4.getText(), instance4.isActive(), null, img, color);
			ims.core.vo.lookups.AccomodationRequestedType parentVoLookup4 = voLookup4;
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
								parentVoLookup4.setParent(new ims.core.vo.lookups.AccomodationRequestedType(parent4.getId(),parent4.getText(), parent4.isActive(), null, img, color));
				parentVoLookup4 = parentVoLookup4.getParent();
								parent4 = parent4.getParent();
			}			
			valueObject.setAccomodationRequestedType(voLookup4);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.admin.domain.objects.EmergencyAttendance extractEmergencyAttendance(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo valueObject) 
	{
		return 	extractEmergencyAttendance(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.admin.domain.objects.EmergencyAttendance extractEmergencyAttendance(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_EmergencyAttendance();
		ims.core.admin.domain.objects.EmergencyAttendance domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.admin.domain.objects.EmergencyAttendance)domMap.get(valueObject);
			}
			// ims.emergency.vo.EmergencyAttendanceForPartialAdmissionVo ID_EmergencyAttendance field is unknown
			domainObject = new ims.core.admin.domain.objects.EmergencyAttendance();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_EmergencyAttendance());
			if (domMap.get(key) != null)
			{
				return (ims.core.admin.domain.objects.EmergencyAttendance)domMap.get(key);
			}
			domainObject = (ims.core.admin.domain.objects.EmergencyAttendance) domainFactory.getDomainObject(ims.core.admin.domain.objects.EmergencyAttendance.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_EmergencyAttendance());

		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value1 = null;
		if ( null != valueObject.getBedTypeRequested() ) 
		{
			value1 =
				domainFactory.getLookupInstance(valueObject.getBedTypeRequested().getID());
		}
		domainObject.setBedTypeRequested(value1);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value2 = null;
		if ( null != valueObject.getPatientAttendanceStatus() ) 
		{
			value2 =
				domainFactory.getLookupInstance(valueObject.getPatientAttendanceStatus().getID());
		}
		domainObject.setPatientAttendanceStatus(value2);
		ims.framework.utils.DateTime dateTime3 = valueObject.getConclusionDateTime();
		java.util.Date value3 = null;
		if ( dateTime3 != null ) 
		{
			value3 = dateTime3.getJavaDate();
		}
		domainObject.setConclusionDateTime(value3);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value4 = null;
		if ( null != valueObject.getAccomodationRequestedType() ) 
		{
			value4 =
				domainFactory.getLookupInstance(valueObject.getAccomodationRequestedType().getID());
		}
		domainObject.setAccomodationRequestedType(value4);

		return domainObject;
	}

}
