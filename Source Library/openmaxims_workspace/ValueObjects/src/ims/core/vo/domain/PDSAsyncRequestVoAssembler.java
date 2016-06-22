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
package ims.core.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Sean Nesbitt
 */
public class PDSAsyncRequestVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.core.vo.PDSAsyncRequestVo copy(ims.core.vo.PDSAsyncRequestVo valueObjectDest, ims.core.vo.PDSAsyncRequestVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_PDSAsyncRequest(valueObjectSrc.getID_PDSAsyncRequest());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// SDSRoleProfileId
		valueObjectDest.setSDSRoleProfileId(valueObjectSrc.getSDSRoleProfileId());
		// SDSUserId
		valueObjectDest.setSDSUserId(valueObjectSrc.getSDSUserId());
		// PDSAck
		valueObjectDest.setPDSAck(valueObjectSrc.getPDSAck());
		// PDSAckDetailType
		valueObjectDest.setPDSAckDetailType(valueObjectSrc.getPDSAckDetailType());
		// Active
		valueObjectDest.setActive(valueObjectSrc.getActive());
		// Comment
		valueObjectDest.setComment(valueObjectSrc.getComment());
		// requestType
		valueObjectDest.setRequestType(valueObjectSrc.getRequestType());
		// requestDate
		valueObjectDest.setRequestDate(valueObjectSrc.getRequestDate());
		// ConvId
		valueObjectDest.setConvId(valueObjectSrc.getConvId());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createPDSAsyncRequestVoCollectionFromPDSAsyncRequest(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.patient.domain.objects.PDSAsyncRequest objects.
	 */
	public static ims.core.vo.PDSAsyncRequestVoCollection createPDSAsyncRequestVoCollectionFromPDSAsyncRequest(java.util.Set domainObjectSet)	
	{
		return createPDSAsyncRequestVoCollectionFromPDSAsyncRequest(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.patient.domain.objects.PDSAsyncRequest objects.
	 */
	public static ims.core.vo.PDSAsyncRequestVoCollection createPDSAsyncRequestVoCollectionFromPDSAsyncRequest(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.core.vo.PDSAsyncRequestVoCollection voList = new ims.core.vo.PDSAsyncRequestVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.patient.domain.objects.PDSAsyncRequest domainObject = (ims.core.patient.domain.objects.PDSAsyncRequest) iterator.next();
			ims.core.vo.PDSAsyncRequestVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.core.patient.domain.objects.PDSAsyncRequest objects.
	 */
	public static ims.core.vo.PDSAsyncRequestVoCollection createPDSAsyncRequestVoCollectionFromPDSAsyncRequest(java.util.List domainObjectList) 
	{
		return createPDSAsyncRequestVoCollectionFromPDSAsyncRequest(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.patient.domain.objects.PDSAsyncRequest objects.
	 */
	public static ims.core.vo.PDSAsyncRequestVoCollection createPDSAsyncRequestVoCollectionFromPDSAsyncRequest(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.core.vo.PDSAsyncRequestVoCollection voList = new ims.core.vo.PDSAsyncRequestVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.patient.domain.objects.PDSAsyncRequest domainObject = (ims.core.patient.domain.objects.PDSAsyncRequest) domainObjectList.get(i);
			ims.core.vo.PDSAsyncRequestVo vo = create(map, domainObject);

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
	 * Create the ims.core.patient.domain.objects.PDSAsyncRequest set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractPDSAsyncRequestSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.PDSAsyncRequestVoCollection voCollection) 
	 {
	 	return extractPDSAsyncRequestSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractPDSAsyncRequestSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.PDSAsyncRequestVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.PDSAsyncRequestVo vo = voCollection.get(i);
			ims.core.patient.domain.objects.PDSAsyncRequest domainObject = PDSAsyncRequestVoAssembler.extractPDSAsyncRequest(domainFactory, vo, domMap);

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
	 * Create the ims.core.patient.domain.objects.PDSAsyncRequest list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractPDSAsyncRequestList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.PDSAsyncRequestVoCollection voCollection) 
	 {
	 	return extractPDSAsyncRequestList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractPDSAsyncRequestList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.PDSAsyncRequestVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.PDSAsyncRequestVo vo = voCollection.get(i);
			ims.core.patient.domain.objects.PDSAsyncRequest domainObject = PDSAsyncRequestVoAssembler.extractPDSAsyncRequest(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.core.patient.domain.objects.PDSAsyncRequest object.
	 * @param domainObject ims.core.patient.domain.objects.PDSAsyncRequest
	 */
	 public static ims.core.vo.PDSAsyncRequestVo create(ims.core.patient.domain.objects.PDSAsyncRequest domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.patient.domain.objects.PDSAsyncRequest object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.core.vo.PDSAsyncRequestVo create(DomainObjectMap map, ims.core.patient.domain.objects.PDSAsyncRequest domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.core.vo.PDSAsyncRequestVo valueObject = (ims.core.vo.PDSAsyncRequestVo) map.getValueObject(domainObject, ims.core.vo.PDSAsyncRequestVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.core.vo.PDSAsyncRequestVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.patient.domain.objects.PDSAsyncRequest
	 */
	 public static ims.core.vo.PDSAsyncRequestVo insert(ims.core.vo.PDSAsyncRequestVo valueObject, ims.core.patient.domain.objects.PDSAsyncRequest domainObject) 
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
	 * @param domainObject ims.core.patient.domain.objects.PDSAsyncRequest
	 */
	 public static ims.core.vo.PDSAsyncRequestVo insert(DomainObjectMap map, ims.core.vo.PDSAsyncRequestVo valueObject, ims.core.patient.domain.objects.PDSAsyncRequest domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_PDSAsyncRequest(domainObject.getId());
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
			
		// SDSRoleProfileId
		valueObject.setSDSRoleProfileId(domainObject.getSDSRoleProfileId());
		// SDSUserId
		valueObject.setSDSUserId(domainObject.getSDSUserId());
		// PDSAck
		ims.domain.lookups.LookupInstance instance3 = domainObject.getPDSAck();
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

			ims.core.vo.lookups.PDSRequestAckStatus voLookup3 = new ims.core.vo.lookups.PDSRequestAckStatus(instance3.getId(),instance3.getText(), instance3.isActive(), null, img, color);
			ims.core.vo.lookups.PDSRequestAckStatus parentVoLookup3 = voLookup3;
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
								parentVoLookup3.setParent(new ims.core.vo.lookups.PDSRequestAckStatus(parent3.getId(),parent3.getText(), parent3.isActive(), null, img, color));
				parentVoLookup3 = parentVoLookup3.getParent();
								parent3 = parent3.getParent();
			}			
			valueObject.setPDSAck(voLookup3);
		}
				// PDSAckDetailType
		ims.domain.lookups.LookupInstance instance4 = domainObject.getPDSAckDetailType();
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

			ims.core.vo.lookups.PDSAckDetailType voLookup4 = new ims.core.vo.lookups.PDSAckDetailType(instance4.getId(),instance4.getText(), instance4.isActive(), null, img, color);
			ims.core.vo.lookups.PDSAckDetailType parentVoLookup4 = voLookup4;
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
								parentVoLookup4.setParent(new ims.core.vo.lookups.PDSAckDetailType(parent4.getId(),parent4.getText(), parent4.isActive(), null, img, color));
				parentVoLookup4 = parentVoLookup4.getParent();
								parent4 = parent4.getParent();
			}			
			valueObject.setPDSAckDetailType(voLookup4);
		}
				// Active
		valueObject.setActive( domainObject.isActive() );
		// Comment
		valueObject.setComment(domainObject.getComment());
		// requestType
		ims.domain.lookups.LookupInstance instance7 = domainObject.getRequestType();
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

			ims.core.vo.lookups.PDSAsyncRequestType voLookup7 = new ims.core.vo.lookups.PDSAsyncRequestType(instance7.getId(),instance7.getText(), instance7.isActive(), null, img, color);
			ims.core.vo.lookups.PDSAsyncRequestType parentVoLookup7 = voLookup7;
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
								parentVoLookup7.setParent(new ims.core.vo.lookups.PDSAsyncRequestType(parent7.getId(),parent7.getText(), parent7.isActive(), null, img, color));
				parentVoLookup7 = parentVoLookup7.getParent();
								parent7 = parent7.getParent();
			}			
			valueObject.setRequestType(voLookup7);
		}
				// requestDate
		java.util.Date requestDate = domainObject.getRequestDate();
		if ( null != requestDate ) 
		{
			valueObject.setRequestDate(new ims.framework.utils.DateTime(requestDate) );
		}
		// ConvId
		if (domainObject.getConvId() != null)
		{
			if(domainObject.getConvId() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getConvId();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setConvId(new ims.choose_book.vo.PDSConvRefVo(id, -1));				
			}
			else
			{
				valueObject.setConvId(new ims.choose_book.vo.PDSConvRefVo(domainObject.getConvId().getId(), domainObject.getConvId().getVersion()));
			}
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.patient.domain.objects.PDSAsyncRequest extractPDSAsyncRequest(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.PDSAsyncRequestVo valueObject) 
	{
		return 	extractPDSAsyncRequest(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.patient.domain.objects.PDSAsyncRequest extractPDSAsyncRequest(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.PDSAsyncRequestVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_PDSAsyncRequest();
		ims.core.patient.domain.objects.PDSAsyncRequest domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.patient.domain.objects.PDSAsyncRequest)domMap.get(valueObject);
			}
			// ims.core.vo.PDSAsyncRequestVo ID_PDSAsyncRequest field is unknown
			domainObject = new ims.core.patient.domain.objects.PDSAsyncRequest();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_PDSAsyncRequest());
			if (domMap.get(key) != null)
			{
				return (ims.core.patient.domain.objects.PDSAsyncRequest)domMap.get(key);
			}
			domainObject = (ims.core.patient.domain.objects.PDSAsyncRequest) domainFactory.getDomainObject(ims.core.patient.domain.objects.PDSAsyncRequest.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_PDSAsyncRequest());

		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getSDSRoleProfileId() != null && valueObject.getSDSRoleProfileId().equals(""))
		{
			valueObject.setSDSRoleProfileId(null);
		}
		domainObject.setSDSRoleProfileId(valueObject.getSDSRoleProfileId());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getSDSUserId() != null && valueObject.getSDSUserId().equals(""))
		{
			valueObject.setSDSUserId(null);
		}
		domainObject.setSDSUserId(valueObject.getSDSUserId());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value3 = null;
		if ( null != valueObject.getPDSAck() ) 
		{
			value3 =
				domainFactory.getLookupInstance(valueObject.getPDSAck().getID());
		}
		domainObject.setPDSAck(value3);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value4 = null;
		if ( null != valueObject.getPDSAckDetailType() ) 
		{
			value4 =
				domainFactory.getLookupInstance(valueObject.getPDSAckDetailType().getID());
		}
		domainObject.setPDSAckDetailType(value4);
		domainObject.setActive(valueObject.getActive());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getComment() != null && valueObject.getComment().equals(""))
		{
			valueObject.setComment(null);
		}
		domainObject.setComment(valueObject.getComment());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value7 = null;
		if ( null != valueObject.getRequestType() ) 
		{
			value7 =
				domainFactory.getLookupInstance(valueObject.getRequestType().getID());
		}
		domainObject.setRequestType(value7);
		ims.framework.utils.DateTime dateTime8 = valueObject.getRequestDate();
		java.util.Date value8 = null;
		if ( dateTime8 != null ) 
		{
			value8 = dateTime8.getJavaDate();
		}
		domainObject.setRequestDate(value8);
		ims.choose_book.domain.objects.PDSConv value9 = null;
		if ( null != valueObject.getConvId() ) 
		{
			if (valueObject.getConvId().getBoId() == null)
			{
				if (domMap.get(valueObject.getConvId()) != null)
				{
					value9 = (ims.choose_book.domain.objects.PDSConv)domMap.get(valueObject.getConvId());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value9 = domainObject.getConvId();	
			}
			else
			{
				value9 = (ims.choose_book.domain.objects.PDSConv)domainFactory.getDomainObject(ims.choose_book.domain.objects.PDSConv.class, valueObject.getConvId().getBoId());
			}
		}
		domainObject.setConvId(value9);

		return domainObject;
	}

}
