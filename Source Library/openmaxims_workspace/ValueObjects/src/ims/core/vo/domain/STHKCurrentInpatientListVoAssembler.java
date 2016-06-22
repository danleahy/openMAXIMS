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
package ims.core.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Rory Fitzpatrick
 */
public class STHKCurrentInpatientListVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.core.vo.STHKCurrentInpatientListVo copy(ims.core.vo.STHKCurrentInpatientListVo valueObjectDest, ims.core.vo.STHKCurrentInpatientListVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_InpatientEpisode(valueObjectSrc.getID_InpatientEpisode());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// pasEvent
		valueObjectDest.setPasEvent(valueObjectSrc.getPasEvent());
		// EstDischargeDate
		valueObjectDest.setEstDischargeDate(valueObjectSrc.getEstDischargeDate());
		// Comments
		valueObjectDest.setComments(valueObjectSrc.getComments());
		// WardType
		valueObjectDest.setWardType(valueObjectSrc.getWardType());
		// Bed
		valueObjectDest.setBed(valueObjectSrc.getBed());
		// isConfirmedDischarge
		valueObjectDest.setIsConfirmedDischarge(valueObjectSrc.getIsConfirmedDischarge());
		// ConfirmedDischargeDateTime
		valueObjectDest.setConfirmedDischargeDateTime(valueObjectSrc.getConfirmedDischargeDateTime());
		// isOnHomeLeave
		valueObjectDest.setIsOnHomeLeave(valueObjectSrc.getIsOnHomeLeave());
		// ExpectedDateOfReturn
		valueObjectDest.setExpectedDateOfReturn(valueObjectSrc.getExpectedDateOfReturn());
		// ExpectedTimeOfReturn
		valueObjectDest.setExpectedTimeOfReturn(valueObjectSrc.getExpectedTimeOfReturn());
		// LatestSECSScore
		valueObjectDest.setLatestSECSScore(valueObjectSrc.getLatestSECSScore());
		// CurrentTrackingMovement
		valueObjectDest.setCurrentTrackingMovement(valueObjectSrc.getCurrentTrackingMovement());
		// DateOnHomeLeave
		valueObjectDest.setDateOnHomeLeave(valueObjectSrc.getDateOnHomeLeave());
		// TimeOnHomeLeave
		valueObjectDest.setTimeOnHomeLeave(valueObjectSrc.getTimeOnHomeLeave());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createSTHKCurrentInpatientListVoCollectionFromInpatientEpisode(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.admin.pas.domain.objects.InpatientEpisode objects.
	 */
	public static ims.core.vo.STHKCurrentInpatientListVoCollection createSTHKCurrentInpatientListVoCollectionFromInpatientEpisode(java.util.Set domainObjectSet)	
	{
		return createSTHKCurrentInpatientListVoCollectionFromInpatientEpisode(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.admin.pas.domain.objects.InpatientEpisode objects.
	 */
	public static ims.core.vo.STHKCurrentInpatientListVoCollection createSTHKCurrentInpatientListVoCollectionFromInpatientEpisode(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.core.vo.STHKCurrentInpatientListVoCollection voList = new ims.core.vo.STHKCurrentInpatientListVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.admin.pas.domain.objects.InpatientEpisode domainObject = (ims.core.admin.pas.domain.objects.InpatientEpisode) iterator.next();
			ims.core.vo.STHKCurrentInpatientListVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.core.admin.pas.domain.objects.InpatientEpisode objects.
	 */
	public static ims.core.vo.STHKCurrentInpatientListVoCollection createSTHKCurrentInpatientListVoCollectionFromInpatientEpisode(java.util.List domainObjectList) 
	{
		return createSTHKCurrentInpatientListVoCollectionFromInpatientEpisode(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.admin.pas.domain.objects.InpatientEpisode objects.
	 */
	public static ims.core.vo.STHKCurrentInpatientListVoCollection createSTHKCurrentInpatientListVoCollectionFromInpatientEpisode(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.core.vo.STHKCurrentInpatientListVoCollection voList = new ims.core.vo.STHKCurrentInpatientListVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.admin.pas.domain.objects.InpatientEpisode domainObject = (ims.core.admin.pas.domain.objects.InpatientEpisode) domainObjectList.get(i);
			ims.core.vo.STHKCurrentInpatientListVo vo = create(map, domainObject);

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
	 * Create the ims.core.admin.pas.domain.objects.InpatientEpisode set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractInpatientEpisodeSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.STHKCurrentInpatientListVoCollection voCollection) 
	 {
	 	return extractInpatientEpisodeSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractInpatientEpisodeSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.STHKCurrentInpatientListVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.STHKCurrentInpatientListVo vo = voCollection.get(i);
			ims.core.admin.pas.domain.objects.InpatientEpisode domainObject = STHKCurrentInpatientListVoAssembler.extractInpatientEpisode(domainFactory, vo, domMap);

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
	 * Create the ims.core.admin.pas.domain.objects.InpatientEpisode list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractInpatientEpisodeList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.STHKCurrentInpatientListVoCollection voCollection) 
	 {
	 	return extractInpatientEpisodeList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractInpatientEpisodeList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.STHKCurrentInpatientListVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.STHKCurrentInpatientListVo vo = voCollection.get(i);
			ims.core.admin.pas.domain.objects.InpatientEpisode domainObject = STHKCurrentInpatientListVoAssembler.extractInpatientEpisode(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.core.admin.pas.domain.objects.InpatientEpisode object.
	 * @param domainObject ims.core.admin.pas.domain.objects.InpatientEpisode
	 */
	 public static ims.core.vo.STHKCurrentInpatientListVo create(ims.core.admin.pas.domain.objects.InpatientEpisode domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.admin.pas.domain.objects.InpatientEpisode object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.core.vo.STHKCurrentInpatientListVo create(DomainObjectMap map, ims.core.admin.pas.domain.objects.InpatientEpisode domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.core.vo.STHKCurrentInpatientListVo valueObject = (ims.core.vo.STHKCurrentInpatientListVo) map.getValueObject(domainObject, ims.core.vo.STHKCurrentInpatientListVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.core.vo.STHKCurrentInpatientListVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.admin.pas.domain.objects.InpatientEpisode
	 */
	 public static ims.core.vo.STHKCurrentInpatientListVo insert(ims.core.vo.STHKCurrentInpatientListVo valueObject, ims.core.admin.pas.domain.objects.InpatientEpisode domainObject) 
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
	 * @param domainObject ims.core.admin.pas.domain.objects.InpatientEpisode
	 */
	 public static ims.core.vo.STHKCurrentInpatientListVo insert(DomainObjectMap map, ims.core.vo.STHKCurrentInpatientListVo valueObject, ims.core.admin.pas.domain.objects.InpatientEpisode domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_InpatientEpisode(domainObject.getId());
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
			
		// pasEvent
		valueObject.setPasEvent(ims.core.vo.domain.PasEventForSTHKListVoAssembler.create(map, domainObject.getPasEvent()) );
		// EstDischargeDate
		java.util.Date EstDischargeDate = domainObject.getEstDischargeDate();
		if ( null != EstDischargeDate ) 
		{
			valueObject.setEstDischargeDate(new ims.framework.utils.DateTime(EstDischargeDate) );
		}
		// Comments
		valueObject.setComments(domainObject.getComments());
		// WardType
		ims.domain.lookups.LookupInstance instance4 = domainObject.getWardType();
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

			ims.core.vo.lookups.WardType voLookup4 = new ims.core.vo.lookups.WardType(instance4.getId(),instance4.getText(), instance4.isActive(), null, img, color);
			ims.core.vo.lookups.WardType parentVoLookup4 = voLookup4;
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
								parentVoLookup4.setParent(new ims.core.vo.lookups.WardType(parent4.getId(),parent4.getText(), parent4.isActive(), null, img, color));
				parentVoLookup4 = parentVoLookup4.getParent();
								parent4 = parent4.getParent();
			}			
			valueObject.setWardType(voLookup4);
		}
				// Bed
		valueObject.setBed(ims.core.vo.domain.BedSpaceStateListVoAssembler.create(map, domainObject.getBed()) );
		// isConfirmedDischarge
		valueObject.setIsConfirmedDischarge( domainObject.isIsConfirmedDischarge() );
		// ConfirmedDischargeDateTime
		java.util.Date ConfirmedDischargeDateTime = domainObject.getConfirmedDischargeDateTime();
		if ( null != ConfirmedDischargeDateTime ) 
		{
			valueObject.setConfirmedDischargeDateTime(new ims.framework.utils.DateTime(ConfirmedDischargeDateTime) );
		}
		// isOnHomeLeave
		valueObject.setIsOnHomeLeave( domainObject.isIsOnHomeLeave() );
		// ExpectedDateOfReturn
		java.util.Date ExpectedDateOfReturn = domainObject.getExpectedDateOfReturn();
		if ( null != ExpectedDateOfReturn ) 
		{
			valueObject.setExpectedDateOfReturn(new ims.framework.utils.Date(ExpectedDateOfReturn) );
		}
		// ExpectedTimeOfReturn
		String ExpectedTimeOfReturn = domainObject.getExpectedTimeOfReturn();
		if ( null != ExpectedTimeOfReturn ) 
		{
			valueObject.setExpectedTimeOfReturn(new ims.framework.utils.Time(ExpectedTimeOfReturn) );
		}
		// LatestSECSScore
		valueObject.setLatestSECSScore(ims.clinical.vo.domain.PatientSECSLiteVoAssembler.create(map, domainObject.getLatestSECSScore()) );
		// CurrentTrackingMovement
		valueObject.setCurrentTrackingMovement(ims.core.vo.domain.TrackingMovementLiteVoAssembler.create(map, domainObject.getCurrentTrackingMovement()) );
		// DateOnHomeLeave
		java.util.Date DateOnHomeLeave = domainObject.getDateOnHomeLeave();
		if ( null != DateOnHomeLeave ) 
		{
			valueObject.setDateOnHomeLeave(new ims.framework.utils.Date(DateOnHomeLeave) );
		}
		// TimeOnHomeLeave
		String TimeOnHomeLeave = domainObject.getTimeOnHomeLeave();
		if ( null != TimeOnHomeLeave ) 
		{
			valueObject.setTimeOnHomeLeave(new ims.framework.utils.Time(TimeOnHomeLeave) );
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.admin.pas.domain.objects.InpatientEpisode extractInpatientEpisode(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.STHKCurrentInpatientListVo valueObject) 
	{
		return 	extractInpatientEpisode(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.admin.pas.domain.objects.InpatientEpisode extractInpatientEpisode(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.STHKCurrentInpatientListVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_InpatientEpisode();
		ims.core.admin.pas.domain.objects.InpatientEpisode domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.admin.pas.domain.objects.InpatientEpisode)domMap.get(valueObject);
			}
			// ims.core.vo.STHKCurrentInpatientListVo ID_InpatientEpisode field is unknown
			domainObject = new ims.core.admin.pas.domain.objects.InpatientEpisode();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_InpatientEpisode());
			if (domMap.get(key) != null)
			{
				return (ims.core.admin.pas.domain.objects.InpatientEpisode)domMap.get(key);
			}
			domainObject = (ims.core.admin.pas.domain.objects.InpatientEpisode) domainFactory.getDomainObject(ims.core.admin.pas.domain.objects.InpatientEpisode.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_InpatientEpisode());

		domainObject.setPasEvent(ims.core.vo.domain.PasEventForSTHKListVoAssembler.extractPASEvent(domainFactory, valueObject.getPasEvent(), domMap));
		ims.framework.utils.DateTime dateTime2 = valueObject.getEstDischargeDate();
		java.util.Date value2 = null;
		if ( dateTime2 != null ) 
		{
			value2 = dateTime2.getJavaDate();
		}
		domainObject.setEstDischargeDate(value2);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getComments() != null && valueObject.getComments().equals(""))
		{
			valueObject.setComments(null);
		}
		domainObject.setComments(valueObject.getComments());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value4 = null;
		if ( null != valueObject.getWardType() ) 
		{
			value4 =
				domainFactory.getLookupInstance(valueObject.getWardType().getID());
		}
		domainObject.setWardType(value4);
		domainObject.setBed(ims.core.vo.domain.BedSpaceStateListVoAssembler.extractBedSpaceState(domainFactory, valueObject.getBed(), domMap));
		domainObject.setIsConfirmedDischarge(valueObject.getIsConfirmedDischarge());
		ims.framework.utils.DateTime dateTime7 = valueObject.getConfirmedDischargeDateTime();
		java.util.Date value7 = null;
		if ( dateTime7 != null ) 
		{
			value7 = dateTime7.getJavaDate();
		}
		domainObject.setConfirmedDischargeDateTime(value7);
		domainObject.setIsOnHomeLeave(valueObject.getIsOnHomeLeave());
		java.util.Date value9 = null;
		ims.framework.utils.Date date9 = valueObject.getExpectedDateOfReturn();		
		if ( date9 != null ) 
		{
			value9 = date9.getDate();
		}
		domainObject.setExpectedDateOfReturn(value9);
		ims.framework.utils.Time time10 = valueObject.getExpectedTimeOfReturn();
		String value10 = null;
		if ( time10 != null ) 
		{
			value10 = time10.toString();
		}
		domainObject.setExpectedTimeOfReturn(value10);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.clinical.domain.objects.PatientSECS value11 = null;
		if ( null != valueObject.getLatestSECSScore() ) 
		{
			if (valueObject.getLatestSECSScore().getBoId() == null)
			{
				if (domMap.get(valueObject.getLatestSECSScore()) != null)
				{
					value11 = (ims.clinical.domain.objects.PatientSECS)domMap.get(valueObject.getLatestSECSScore());
				}
			}
			else
			{
				value11 = (ims.clinical.domain.objects.PatientSECS)domainFactory.getDomainObject(ims.clinical.domain.objects.PatientSECS.class, valueObject.getLatestSECSScore().getBoId());
			}
		}
		domainObject.setLatestSECSScore(value11);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.admin.pas.domain.objects.TrackingMovement value12 = null;
		if ( null != valueObject.getCurrentTrackingMovement() ) 
		{
			if (valueObject.getCurrentTrackingMovement().getBoId() == null)
			{
				if (domMap.get(valueObject.getCurrentTrackingMovement()) != null)
				{
					value12 = (ims.core.admin.pas.domain.objects.TrackingMovement)domMap.get(valueObject.getCurrentTrackingMovement());
				}
			}
			else
			{
				value12 = (ims.core.admin.pas.domain.objects.TrackingMovement)domainFactory.getDomainObject(ims.core.admin.pas.domain.objects.TrackingMovement.class, valueObject.getCurrentTrackingMovement().getBoId());
			}
		}
		domainObject.setCurrentTrackingMovement(value12);
		java.util.Date value13 = null;
		ims.framework.utils.Date date13 = valueObject.getDateOnHomeLeave();		
		if ( date13 != null ) 
		{
			value13 = date13.getDate();
		}
		domainObject.setDateOnHomeLeave(value13);
		ims.framework.utils.Time time14 = valueObject.getTimeOnHomeLeave();
		String value14 = null;
		if ( time14 != null ) 
		{
			value14 = time14.toString();
		}
		domainObject.setTimeOnHomeLeave(value14);

		return domainObject;
	}

}
