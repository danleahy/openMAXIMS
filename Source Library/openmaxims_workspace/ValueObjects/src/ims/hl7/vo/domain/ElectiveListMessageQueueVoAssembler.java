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
public class ElectiveListMessageQueueVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.hl7.vo.ElectiveListMessageQueueVo copy(ims.hl7.vo.ElectiveListMessageQueueVo valueObjectDest, ims.hl7.vo.ElectiveListMessageQueueVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ElectiveListMessageQueue(valueObjectSrc.getID_ElectiveListMessageQueue());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// wasProcessed
		valueObjectDest.setWasProcessed(valueObjectSrc.getWasProcessed());
		// wasDiscarded
		valueObjectDest.setWasDiscarded(valueObjectSrc.getWasDiscarded());
		// msgText
		valueObjectDest.setMsgText(valueObjectSrc.getMsgText());
		// ackText
		valueObjectDest.setAckText(valueObjectSrc.getAckText());
		// failureMsg
		valueObjectDest.setFailureMsg(valueObjectSrc.getFailureMsg());
		// messageStatus
		valueObjectDest.setMessageStatus(valueObjectSrc.getMessageStatus());
		// msgType
		valueObjectDest.setMsgType(valueObjectSrc.getMsgType());
		// queueType
		valueObjectDest.setQueueType(valueObjectSrc.getQueueType());
		// providerSystem
		valueObjectDest.setProviderSystem(valueObjectSrc.getProviderSystem());
		// patientElectiveList
		valueObjectDest.setPatientElectiveList(valueObjectSrc.getPatientElectiveList());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createElectiveListMessageQueueVoCollectionFromElectiveListMessageQueue(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.hl7adtout.domain.objects.ElectiveListMessageQueue objects.
	 */
	public static ims.hl7.vo.ElectiveListMessageQueueVoCollection createElectiveListMessageQueueVoCollectionFromElectiveListMessageQueue(java.util.Set domainObjectSet)	
	{
		return createElectiveListMessageQueueVoCollectionFromElectiveListMessageQueue(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.hl7adtout.domain.objects.ElectiveListMessageQueue objects.
	 */
	public static ims.hl7.vo.ElectiveListMessageQueueVoCollection createElectiveListMessageQueueVoCollectionFromElectiveListMessageQueue(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.hl7.vo.ElectiveListMessageQueueVoCollection voList = new ims.hl7.vo.ElectiveListMessageQueueVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.hl7adtout.domain.objects.ElectiveListMessageQueue domainObject = (ims.hl7adtout.domain.objects.ElectiveListMessageQueue) iterator.next();
			ims.hl7.vo.ElectiveListMessageQueueVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.hl7adtout.domain.objects.ElectiveListMessageQueue objects.
	 */
	public static ims.hl7.vo.ElectiveListMessageQueueVoCollection createElectiveListMessageQueueVoCollectionFromElectiveListMessageQueue(java.util.List domainObjectList) 
	{
		return createElectiveListMessageQueueVoCollectionFromElectiveListMessageQueue(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.hl7adtout.domain.objects.ElectiveListMessageQueue objects.
	 */
	public static ims.hl7.vo.ElectiveListMessageQueueVoCollection createElectiveListMessageQueueVoCollectionFromElectiveListMessageQueue(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.hl7.vo.ElectiveListMessageQueueVoCollection voList = new ims.hl7.vo.ElectiveListMessageQueueVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.hl7adtout.domain.objects.ElectiveListMessageQueue domainObject = (ims.hl7adtout.domain.objects.ElectiveListMessageQueue) domainObjectList.get(i);
			ims.hl7.vo.ElectiveListMessageQueueVo vo = create(map, domainObject);

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
	 * Create the ims.hl7adtout.domain.objects.ElectiveListMessageQueue set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractElectiveListMessageQueueSet(ims.domain.ILightweightDomainFactory domainFactory, ims.hl7.vo.ElectiveListMessageQueueVoCollection voCollection) 
	 {
	 	return extractElectiveListMessageQueueSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractElectiveListMessageQueueSet(ims.domain.ILightweightDomainFactory domainFactory, ims.hl7.vo.ElectiveListMessageQueueVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.hl7.vo.ElectiveListMessageQueueVo vo = voCollection.get(i);
			ims.hl7adtout.domain.objects.ElectiveListMessageQueue domainObject = ElectiveListMessageQueueVoAssembler.extractElectiveListMessageQueue(domainFactory, vo, domMap);

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
	 * Create the ims.hl7adtout.domain.objects.ElectiveListMessageQueue list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractElectiveListMessageQueueList(ims.domain.ILightweightDomainFactory domainFactory, ims.hl7.vo.ElectiveListMessageQueueVoCollection voCollection) 
	 {
	 	return extractElectiveListMessageQueueList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractElectiveListMessageQueueList(ims.domain.ILightweightDomainFactory domainFactory, ims.hl7.vo.ElectiveListMessageQueueVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.hl7.vo.ElectiveListMessageQueueVo vo = voCollection.get(i);
			ims.hl7adtout.domain.objects.ElectiveListMessageQueue domainObject = ElectiveListMessageQueueVoAssembler.extractElectiveListMessageQueue(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.hl7adtout.domain.objects.ElectiveListMessageQueue object.
	 * @param domainObject ims.hl7adtout.domain.objects.ElectiveListMessageQueue
	 */
	 public static ims.hl7.vo.ElectiveListMessageQueueVo create(ims.hl7adtout.domain.objects.ElectiveListMessageQueue domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.hl7adtout.domain.objects.ElectiveListMessageQueue object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.hl7.vo.ElectiveListMessageQueueVo create(DomainObjectMap map, ims.hl7adtout.domain.objects.ElectiveListMessageQueue domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.hl7.vo.ElectiveListMessageQueueVo valueObject = (ims.hl7.vo.ElectiveListMessageQueueVo) map.getValueObject(domainObject, ims.hl7.vo.ElectiveListMessageQueueVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.hl7.vo.ElectiveListMessageQueueVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.hl7adtout.domain.objects.ElectiveListMessageQueue
	 */
	 public static ims.hl7.vo.ElectiveListMessageQueueVo insert(ims.hl7.vo.ElectiveListMessageQueueVo valueObject, ims.hl7adtout.domain.objects.ElectiveListMessageQueue domainObject) 
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
	 * @param domainObject ims.hl7adtout.domain.objects.ElectiveListMessageQueue
	 */
	 public static ims.hl7.vo.ElectiveListMessageQueueVo insert(DomainObjectMap map, ims.hl7.vo.ElectiveListMessageQueueVo valueObject, ims.hl7adtout.domain.objects.ElectiveListMessageQueue domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ElectiveListMessageQueue(domainObject.getId());
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
			
		// wasProcessed
		valueObject.setWasProcessed( domainObject.isWasProcessed() );
		// wasDiscarded
		valueObject.setWasDiscarded( domainObject.isWasDiscarded() );
		// msgText
		valueObject.setMsgText(domainObject.getMsgText());
		// ackText
		valueObject.setAckText(domainObject.getAckText());
		// failureMsg
		valueObject.setFailureMsg(domainObject.getFailureMsg());
		// messageStatus
		ims.domain.lookups.LookupInstance instance6 = domainObject.getMessageStatus();
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

			ims.ocrr.vo.lookups.OrderMessageStatus voLookup6 = new ims.ocrr.vo.lookups.OrderMessageStatus(instance6.getId(),instance6.getText(), instance6.isActive(), null, img, color);
			ims.ocrr.vo.lookups.OrderMessageStatus parentVoLookup6 = voLookup6;
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
								parentVoLookup6.setParent(new ims.ocrr.vo.lookups.OrderMessageStatus(parent6.getId(),parent6.getText(), parent6.isActive(), null, img, color));
				parentVoLookup6 = parentVoLookup6.getParent();
								parent6 = parent6.getParent();
			}			
			valueObject.setMessageStatus(voLookup6);
		}
				// msgType
		ims.domain.lookups.LookupInstance instance7 = domainObject.getMsgType();
		if ( null != instance7 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance7.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance7.getImage().getImageId(), instance7.getImage().getImagePath());
			}
			color = instance7.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.MsgEventType voLookup7 = new ims.core.vo.lookups.MsgEventType(instance7.getId(),instance7.getText(), instance7.isActive(), null, img, color);
			ims.core.vo.lookups.MsgEventType parentVoLookup7 = voLookup7;
			ims.domain.lookups.LookupInstance parent7 = instance7.getParent();
			while (parent7 != null)
			{
				if (parent7.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent7.getImage().getImageId(), parent7.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent7.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup7.setParent(new ims.core.vo.lookups.MsgEventType(parent7.getId(),parent7.getText(), parent7.isActive(), null, img, color));
				parentVoLookup7 = parentVoLookup7.getParent();
								parent7 = parent7.getParent();
			}			
			valueObject.setMsgType(voLookup7);
		}
				// queueType
		ims.domain.lookups.LookupInstance instance8 = domainObject.getQueueType();
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

			ims.core.vo.lookups.QueueType voLookup8 = new ims.core.vo.lookups.QueueType(instance8.getId(),instance8.getText(), instance8.isActive(), null, img, color);
			ims.core.vo.lookups.QueueType parentVoLookup8 = voLookup8;
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
								parentVoLookup8.setParent(new ims.core.vo.lookups.QueueType(parent8.getId(),parent8.getText(), parent8.isActive(), null, img, color));
				parentVoLookup8 = parentVoLookup8.getParent();
								parent8 = parent8.getParent();
			}			
			valueObject.setQueueType(voLookup8);
		}
				// providerSystem
		valueObject.setProviderSystem(ims.ocrr.vo.domain.ProviderSystemVoAssembler.create(map, domainObject.getProviderSystem()) );
		// patientElectiveList
		if (domainObject.getPatientElectiveList() != null)
		{
			if(domainObject.getPatientElectiveList() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getPatientElectiveList();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setPatientElectiveList(new ims.RefMan.vo.PatientElectiveListRefVo(id, -1));				
			}
			else
			{
				valueObject.setPatientElectiveList(new ims.RefMan.vo.PatientElectiveListRefVo(domainObject.getPatientElectiveList().getId(), domainObject.getPatientElectiveList().getVersion()));
			}
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.hl7adtout.domain.objects.ElectiveListMessageQueue extractElectiveListMessageQueue(ims.domain.ILightweightDomainFactory domainFactory, ims.hl7.vo.ElectiveListMessageQueueVo valueObject) 
	{
		return 	extractElectiveListMessageQueue(domainFactory, valueObject, new HashMap());
	}

	public static ims.hl7adtout.domain.objects.ElectiveListMessageQueue extractElectiveListMessageQueue(ims.domain.ILightweightDomainFactory domainFactory, ims.hl7.vo.ElectiveListMessageQueueVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ElectiveListMessageQueue();
		ims.hl7adtout.domain.objects.ElectiveListMessageQueue domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.hl7adtout.domain.objects.ElectiveListMessageQueue)domMap.get(valueObject);
			}
			// ims.hl7.vo.ElectiveListMessageQueueVo ID_ElectiveListMessageQueue field is unknown
			domainObject = new ims.hl7adtout.domain.objects.ElectiveListMessageQueue();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ElectiveListMessageQueue());
			if (domMap.get(key) != null)
			{
				return (ims.hl7adtout.domain.objects.ElectiveListMessageQueue)domMap.get(key);
			}
			domainObject = (ims.hl7adtout.domain.objects.ElectiveListMessageQueue) domainFactory.getDomainObject(ims.hl7adtout.domain.objects.ElectiveListMessageQueue.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ElectiveListMessageQueue());

		domainObject.setWasProcessed(valueObject.getWasProcessed());
		domainObject.setWasDiscarded(valueObject.getWasDiscarded());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getMsgText() != null && valueObject.getMsgText().equals(""))
		{
			valueObject.setMsgText(null);
		}
		domainObject.setMsgText(valueObject.getMsgText());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getAckText() != null && valueObject.getAckText().equals(""))
		{
			valueObject.setAckText(null);
		}
		domainObject.setAckText(valueObject.getAckText());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getFailureMsg() != null && valueObject.getFailureMsg().equals(""))
		{
			valueObject.setFailureMsg(null);
		}
		domainObject.setFailureMsg(valueObject.getFailureMsg());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value6 = null;
		if ( null != valueObject.getMessageStatus() ) 
		{
			value6 =
				domainFactory.getLookupInstance(valueObject.getMessageStatus().getID());
		}
		domainObject.setMessageStatus(value6);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value7 = null;
		if ( null != valueObject.getMsgType() ) 
		{
			value7 =
				domainFactory.getLookupInstance(valueObject.getMsgType().getID());
		}
		domainObject.setMsgType(value7);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value8 = null;
		if ( null != valueObject.getQueueType() ) 
		{
			value8 =
				domainFactory.getLookupInstance(valueObject.getQueueType().getID());
		}
		domainObject.setQueueType(value8);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.admin.domain.objects.ProviderSystem value9 = null;
		if ( null != valueObject.getProviderSystem() ) 
		{
			if (valueObject.getProviderSystem().getBoId() == null)
			{
				if (domMap.get(valueObject.getProviderSystem()) != null)
				{
					value9 = (ims.core.admin.domain.objects.ProviderSystem)domMap.get(valueObject.getProviderSystem());
				}
			}
			else
			{
				value9 = (ims.core.admin.domain.objects.ProviderSystem)domainFactory.getDomainObject(ims.core.admin.domain.objects.ProviderSystem.class, valueObject.getProviderSystem().getBoId());
			}
		}
		domainObject.setProviderSystem(value9);
		ims.RefMan.domain.objects.PatientElectiveList value10 = null;
		if ( null != valueObject.getPatientElectiveList() ) 
		{
			if (valueObject.getPatientElectiveList().getBoId() == null)
			{
				if (domMap.get(valueObject.getPatientElectiveList()) != null)
				{
					value10 = (ims.RefMan.domain.objects.PatientElectiveList)domMap.get(valueObject.getPatientElectiveList());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value10 = domainObject.getPatientElectiveList();	
			}
			else
			{
				value10 = (ims.RefMan.domain.objects.PatientElectiveList)domainFactory.getDomainObject(ims.RefMan.domain.objects.PatientElectiveList.class, valueObject.getPatientElectiveList().getBoId());
			}
		}
		domainObject.setPatientElectiveList(value10);

		return domainObject;
	}

}
