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
package ims.clinical.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Daniel Laffan
 */
public class NeonatalVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.clinical.vo.NeonatalVo copy(ims.clinical.vo.NeonatalVo valueObjectDest, ims.clinical.vo.NeonatalVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_NeoNatal(valueObjectSrc.getID_NeoNatal());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// CareContext
		valueObjectDest.setCareContext(valueObjectSrc.getCareContext());
		// DischargingNurse
		valueObjectDest.setDischargingNurse(valueObjectSrc.getDischargingNurse());
		// GestationWeeks
		valueObjectDest.setGestationWeeks(valueObjectSrc.getGestationWeeks());
		// IsMidwife
		valueObjectDest.setIsMidwife(valueObjectSrc.getIsMidwife());
		// IsHealthVisitor
		valueObjectDest.setIsHealthVisitor(valueObjectSrc.getIsHealthVisitor());
		// Feeding
		valueObjectDest.setFeeding(valueObjectSrc.getFeeding());
		// IsVitaminKGiven
		valueObjectDest.setIsVitaminKGiven(valueObjectSrc.getIsVitaminKGiven());
		// Route
		valueObjectDest.setRoute(valueObjectSrc.getRoute());
		// FirstPKUTestDate
		valueObjectDest.setFirstPKUTestDate(valueObjectSrc.getFirstPKUTestDate());
		// SecondPKUTestDate
		valueObjectDest.setSecondPKUTestDate(valueObjectSrc.getSecondPKUTestDate());
		// Apgar1Minute
		valueObjectDest.setApgar1Minute(valueObjectSrc.getApgar1Minute());
		// Apgar5Minute
		valueObjectDest.setApgar5Minute(valueObjectSrc.getApgar5Minute());
		// BirthWeight
		valueObjectDest.setBirthWeight(valueObjectSrc.getBirthWeight());
		// Length
		valueObjectDest.setLength(valueObjectSrc.getLength());
		// DischargeWeight
		valueObjectDest.setDischargeWeight(valueObjectSrc.getDischargeWeight());
		// IsComplete
		valueObjectDest.setIsComplete(valueObjectSrc.getIsComplete());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createNeonatalVoCollectionFromNeoNatal(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.edischarge.domain.objects.NeoNatal objects.
	 */
	public static ims.clinical.vo.NeonatalVoCollection createNeonatalVoCollectionFromNeoNatal(java.util.Set domainObjectSet)	
	{
		return createNeonatalVoCollectionFromNeoNatal(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.edischarge.domain.objects.NeoNatal objects.
	 */
	public static ims.clinical.vo.NeonatalVoCollection createNeonatalVoCollectionFromNeoNatal(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.clinical.vo.NeonatalVoCollection voList = new ims.clinical.vo.NeonatalVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.edischarge.domain.objects.NeoNatal domainObject = (ims.edischarge.domain.objects.NeoNatal) iterator.next();
			ims.clinical.vo.NeonatalVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.edischarge.domain.objects.NeoNatal objects.
	 */
	public static ims.clinical.vo.NeonatalVoCollection createNeonatalVoCollectionFromNeoNatal(java.util.List domainObjectList) 
	{
		return createNeonatalVoCollectionFromNeoNatal(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.edischarge.domain.objects.NeoNatal objects.
	 */
	public static ims.clinical.vo.NeonatalVoCollection createNeonatalVoCollectionFromNeoNatal(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.clinical.vo.NeonatalVoCollection voList = new ims.clinical.vo.NeonatalVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.edischarge.domain.objects.NeoNatal domainObject = (ims.edischarge.domain.objects.NeoNatal) domainObjectList.get(i);
			ims.clinical.vo.NeonatalVo vo = create(map, domainObject);

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
	 * Create the ims.edischarge.domain.objects.NeoNatal set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractNeoNatalSet(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.NeonatalVoCollection voCollection) 
	 {
	 	return extractNeoNatalSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractNeoNatalSet(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.NeonatalVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.clinical.vo.NeonatalVo vo = voCollection.get(i);
			ims.edischarge.domain.objects.NeoNatal domainObject = NeonatalVoAssembler.extractNeoNatal(domainFactory, vo, domMap);

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
	 * Create the ims.edischarge.domain.objects.NeoNatal list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractNeoNatalList(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.NeonatalVoCollection voCollection) 
	 {
	 	return extractNeoNatalList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractNeoNatalList(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.NeonatalVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.clinical.vo.NeonatalVo vo = voCollection.get(i);
			ims.edischarge.domain.objects.NeoNatal domainObject = NeonatalVoAssembler.extractNeoNatal(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.edischarge.domain.objects.NeoNatal object.
	 * @param domainObject ims.edischarge.domain.objects.NeoNatal
	 */
	 public static ims.clinical.vo.NeonatalVo create(ims.edischarge.domain.objects.NeoNatal domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.edischarge.domain.objects.NeoNatal object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.clinical.vo.NeonatalVo create(DomainObjectMap map, ims.edischarge.domain.objects.NeoNatal domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.clinical.vo.NeonatalVo valueObject = (ims.clinical.vo.NeonatalVo) map.getValueObject(domainObject, ims.clinical.vo.NeonatalVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.clinical.vo.NeonatalVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.edischarge.domain.objects.NeoNatal
	 */
	 public static ims.clinical.vo.NeonatalVo insert(ims.clinical.vo.NeonatalVo valueObject, ims.edischarge.domain.objects.NeoNatal domainObject) 
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
	 * @param domainObject ims.edischarge.domain.objects.NeoNatal
	 */
	 public static ims.clinical.vo.NeonatalVo insert(DomainObjectMap map, ims.clinical.vo.NeonatalVo valueObject, ims.edischarge.domain.objects.NeoNatal domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_NeoNatal(domainObject.getId());
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
			
		// CareContext
		if (domainObject.getCareContext() != null)
		{
			if(domainObject.getCareContext() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getCareContext();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setCareContext(new ims.core.admin.vo.CareContextRefVo(id, -1));				
			}
			else
			{
				valueObject.setCareContext(new ims.core.admin.vo.CareContextRefVo(domainObject.getCareContext().getId(), domainObject.getCareContext().getVersion()));
			}
		}
		// DischargingNurse
		valueObject.setDischargingNurse((ims.core.vo.NurseVo)ims.core.vo.domain.NurseVoAssembler.create(map, domainObject.getDischargingNurse()) );
		// GestationWeeks
		valueObject.setGestationWeeks(domainObject.getGestationWeeks());
		// IsMidwife
		valueObject.setIsMidwife( domainObject.isIsMidwife() );
		// IsHealthVisitor
		valueObject.setIsHealthVisitor( domainObject.isIsHealthVisitor() );
		// Feeding
		ims.domain.lookups.LookupInstance instance6 = domainObject.getFeeding();
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

			ims.pci.vo.lookups.BreastFeedingStatus voLookup6 = new ims.pci.vo.lookups.BreastFeedingStatus(instance6.getId(),instance6.getText(), instance6.isActive(), null, img, color);
			ims.pci.vo.lookups.BreastFeedingStatus parentVoLookup6 = voLookup6;
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
								parentVoLookup6.setParent(new ims.pci.vo.lookups.BreastFeedingStatus(parent6.getId(),parent6.getText(), parent6.isActive(), null, img, color));
				parentVoLookup6 = parentVoLookup6.getParent();
								parent6 = parent6.getParent();
			}			
			valueObject.setFeeding(voLookup6);
		}
				// IsVitaminKGiven
		valueObject.setIsVitaminKGiven( domainObject.isIsVitaminKGiven() );
		// Route
		ims.domain.lookups.LookupInstance instance8 = domainObject.getRoute();
		if ( null != instance8 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance8.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance8.getImage().getImageId(), instance8.getImage().getImagePath());
			}
			color = instance8.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.MedicationRoute voLookup8 = new ims.core.vo.lookups.MedicationRoute(instance8.getId(),instance8.getText(), instance8.isActive(), null, img, color);
			ims.core.vo.lookups.MedicationRoute parentVoLookup8 = voLookup8;
			ims.domain.lookups.LookupInstance parent8 = instance8.getParent();
			while (parent8 != null)
			{
				if (parent8.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent8.getImage().getImageId(), parent8.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent8.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup8.setParent(new ims.core.vo.lookups.MedicationRoute(parent8.getId(),parent8.getText(), parent8.isActive(), null, img, color));
				parentVoLookup8 = parentVoLookup8.getParent();
								parent8 = parent8.getParent();
			}			
			valueObject.setRoute(voLookup8);
		}
				// FirstPKUTestDate
		java.util.Date FirstPKUTestDate = domainObject.get_1stPKUTestDate();
		if ( null != FirstPKUTestDate ) 
		{
			valueObject.setFirstPKUTestDate(new ims.framework.utils.Date(FirstPKUTestDate) );
		}
		// SecondPKUTestDate
		java.util.Date SecondPKUTestDate = domainObject.get_2ndPKUTestDate();
		if ( null != SecondPKUTestDate ) 
		{
			valueObject.setSecondPKUTestDate(new ims.framework.utils.Date(SecondPKUTestDate) );
		}
		// Apgar1Minute
		valueObject.setApgar1Minute(domainObject.getApgar1Minute());
		// Apgar5Minute
		valueObject.setApgar5Minute(domainObject.getApgar5Minute());
		// BirthWeight
		valueObject.setBirthWeight(domainObject.getBirthWeight());
		// Length
		valueObject.setLength(domainObject.getLength());
		// DischargeWeight
		valueObject.setDischargeWeight(domainObject.getDischargeWeight());
		// IsComplete
		valueObject.setIsComplete( domainObject.isIsComplete() );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.edischarge.domain.objects.NeoNatal extractNeoNatal(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.NeonatalVo valueObject) 
	{
		return 	extractNeoNatal(domainFactory, valueObject, new HashMap());
	}

	public static ims.edischarge.domain.objects.NeoNatal extractNeoNatal(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.NeonatalVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_NeoNatal();
		ims.edischarge.domain.objects.NeoNatal domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.edischarge.domain.objects.NeoNatal)domMap.get(valueObject);
			}
			// ims.clinical.vo.NeonatalVo ID_NeoNatal field is unknown
			domainObject = new ims.edischarge.domain.objects.NeoNatal();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_NeoNatal());
			if (domMap.get(key) != null)
			{
				return (ims.edischarge.domain.objects.NeoNatal)domMap.get(key);
			}
			domainObject = (ims.edischarge.domain.objects.NeoNatal) domainFactory.getDomainObject(ims.edischarge.domain.objects.NeoNatal.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_NeoNatal());

		ims.core.admin.domain.objects.CareContext value1 = null;
		if ( null != valueObject.getCareContext() ) 
		{
			if (valueObject.getCareContext().getBoId() == null)
			{
				if (domMap.get(valueObject.getCareContext()) != null)
				{
					value1 = (ims.core.admin.domain.objects.CareContext)domMap.get(valueObject.getCareContext());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value1 = domainObject.getCareContext();	
			}
			else
			{
				value1 = (ims.core.admin.domain.objects.CareContext)domainFactory.getDomainObject(ims.core.admin.domain.objects.CareContext.class, valueObject.getCareContext().getBoId());
			}
		}
		domainObject.setCareContext(value1);
		domainObject.setDischargingNurse(ims.core.vo.domain.NurseVoAssembler.extractNurse(domainFactory, (ims.core.vo.NurseVo)valueObject.getDischargingNurse(), domMap));
		domainObject.setGestationWeeks(valueObject.getGestationWeeks());
		domainObject.setIsMidwife(valueObject.getIsMidwife());
		domainObject.setIsHealthVisitor(valueObject.getIsHealthVisitor());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value6 = null;
		if ( null != valueObject.getFeeding() ) 
		{
			value6 =
				domainFactory.getLookupInstance(valueObject.getFeeding().getID());
		}
		domainObject.setFeeding(value6);
		domainObject.setIsVitaminKGiven(valueObject.getIsVitaminKGiven());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value8 = null;
		if ( null != valueObject.getRoute() ) 
		{
			value8 =
				domainFactory.getLookupInstance(valueObject.getRoute().getID());
		}
		domainObject.setRoute(value8);
		java.util.Date value9 = null;
		ims.framework.utils.Date date9 = valueObject.getFirstPKUTestDate();		
		if ( date9 != null ) 
		{
			value9 = date9.getDate();
		}
		domainObject.set_1stPKUTestDate(value9);
		java.util.Date value10 = null;
		ims.framework.utils.Date date10 = valueObject.getSecondPKUTestDate();		
		if ( date10 != null ) 
		{
			value10 = date10.getDate();
		}
		domainObject.set_2ndPKUTestDate(value10);
		domainObject.setApgar1Minute(valueObject.getApgar1Minute());
		domainObject.setApgar5Minute(valueObject.getApgar5Minute());
		domainObject.setBirthWeight(valueObject.getBirthWeight());
		domainObject.setLength(valueObject.getLength());
		domainObject.setDischargeWeight(valueObject.getDischargeWeight());
		domainObject.setIsComplete(valueObject.getIsComplete());

		return domainObject;
	}

}
