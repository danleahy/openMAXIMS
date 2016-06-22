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
 * @author Sean Nesbitt
 */
public class PDSGeneralUpdateConvVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.core.vo.PDSGeneralUpdateConvVo copy(ims.core.vo.PDSGeneralUpdateConvVo valueObjectDest, ims.core.vo.PDSGeneralUpdateConvVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_Conversation(valueObjectSrc.getID_Conversation());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// cid
		valueObjectDest.setCid(valueObjectSrc.getCid());
		// current
		valueObjectDest.setCurrent(valueObjectSrc.getCurrent());
		// points
		valueObjectDest.setPoints(valueObjectSrc.getPoints());
		// msgUids
		valueObjectDest.setMsgUids(valueObjectSrc.getMsgUids());
		// dummy
		valueObjectDest.setDummy(valueObjectSrc.getDummy());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createPDSGeneralUpdateConvVoCollectionFromPDSGeneralUpdateConv(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.choose_book.domain.objects.PDSGeneralUpdateConv objects.
	 */
	public static ims.core.vo.PDSGeneralUpdateConvVoCollection createPDSGeneralUpdateConvVoCollectionFromPDSGeneralUpdateConv(java.util.Set domainObjectSet)	
	{
		return createPDSGeneralUpdateConvVoCollectionFromPDSGeneralUpdateConv(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.choose_book.domain.objects.PDSGeneralUpdateConv objects.
	 */
	public static ims.core.vo.PDSGeneralUpdateConvVoCollection createPDSGeneralUpdateConvVoCollectionFromPDSGeneralUpdateConv(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.core.vo.PDSGeneralUpdateConvVoCollection voList = new ims.core.vo.PDSGeneralUpdateConvVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.choose_book.domain.objects.PDSGeneralUpdateConv domainObject = (ims.choose_book.domain.objects.PDSGeneralUpdateConv) iterator.next();
			ims.core.vo.PDSGeneralUpdateConvVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.choose_book.domain.objects.PDSGeneralUpdateConv objects.
	 */
	public static ims.core.vo.PDSGeneralUpdateConvVoCollection createPDSGeneralUpdateConvVoCollectionFromPDSGeneralUpdateConv(java.util.List domainObjectList) 
	{
		return createPDSGeneralUpdateConvVoCollectionFromPDSGeneralUpdateConv(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.choose_book.domain.objects.PDSGeneralUpdateConv objects.
	 */
	public static ims.core.vo.PDSGeneralUpdateConvVoCollection createPDSGeneralUpdateConvVoCollectionFromPDSGeneralUpdateConv(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.core.vo.PDSGeneralUpdateConvVoCollection voList = new ims.core.vo.PDSGeneralUpdateConvVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.choose_book.domain.objects.PDSGeneralUpdateConv domainObject = (ims.choose_book.domain.objects.PDSGeneralUpdateConv) domainObjectList.get(i);
			ims.core.vo.PDSGeneralUpdateConvVo vo = create(map, domainObject);

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
	 * Create the ims.choose_book.domain.objects.PDSGeneralUpdateConv set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractPDSGeneralUpdateConvSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.PDSGeneralUpdateConvVoCollection voCollection) 
	 {
	 	return extractPDSGeneralUpdateConvSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractPDSGeneralUpdateConvSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.PDSGeneralUpdateConvVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.PDSGeneralUpdateConvVo vo = voCollection.get(i);
			ims.choose_book.domain.objects.PDSGeneralUpdateConv domainObject = PDSGeneralUpdateConvVoAssembler.extractPDSGeneralUpdateConv(domainFactory, vo, domMap);

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
	 * Create the ims.choose_book.domain.objects.PDSGeneralUpdateConv list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractPDSGeneralUpdateConvList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.PDSGeneralUpdateConvVoCollection voCollection) 
	 {
	 	return extractPDSGeneralUpdateConvList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractPDSGeneralUpdateConvList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.PDSGeneralUpdateConvVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.PDSGeneralUpdateConvVo vo = voCollection.get(i);
			ims.choose_book.domain.objects.PDSGeneralUpdateConv domainObject = PDSGeneralUpdateConvVoAssembler.extractPDSGeneralUpdateConv(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.choose_book.domain.objects.PDSGeneralUpdateConv object.
	 * @param domainObject ims.choose_book.domain.objects.PDSGeneralUpdateConv
	 */
	 public static ims.core.vo.PDSGeneralUpdateConvVo create(ims.choose_book.domain.objects.PDSGeneralUpdateConv domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.choose_book.domain.objects.PDSGeneralUpdateConv object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.core.vo.PDSGeneralUpdateConvVo create(DomainObjectMap map, ims.choose_book.domain.objects.PDSGeneralUpdateConv domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.core.vo.PDSGeneralUpdateConvVo valueObject = (ims.core.vo.PDSGeneralUpdateConvVo) map.getValueObject(domainObject, ims.core.vo.PDSGeneralUpdateConvVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.core.vo.PDSGeneralUpdateConvVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.choose_book.domain.objects.PDSGeneralUpdateConv
	 */
	 public static ims.core.vo.PDSGeneralUpdateConvVo insert(ims.core.vo.PDSGeneralUpdateConvVo valueObject, ims.choose_book.domain.objects.PDSGeneralUpdateConv domainObject) 
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
	 * @param domainObject ims.choose_book.domain.objects.PDSGeneralUpdateConv
	 */
	 public static ims.core.vo.PDSGeneralUpdateConvVo insert(DomainObjectMap map, ims.core.vo.PDSGeneralUpdateConvVo valueObject, ims.choose_book.domain.objects.PDSGeneralUpdateConv domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_Conversation(domainObject.getId());
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
			
		// cid
		if (domainObject.getCid() != null)
		{
			if(domainObject.getCid() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getCid();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setCid(new ims.choose_book.vo.ConvIdRefVo(id, -1));				
			}
			else
			{
				valueObject.setCid(new ims.choose_book.vo.ConvIdRefVo(domainObject.getCid().getId(), domainObject.getCid().getVersion()));
			}
		}
		// current
		if (domainObject.getCurrent() != null)
		{
			if(domainObject.getCurrent() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getCurrent();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setCurrent(new ims.choose_book.vo.SeqPointRefVo(id, -1));				
			}
			else
			{
				valueObject.setCurrent(new ims.choose_book.vo.SeqPointRefVo(domainObject.getCurrent().getId(), domainObject.getCurrent().getVersion()));
			}
		}
		// points
		ims.choose_book.vo.ConvPointRefVoCollection points = new ims.choose_book.vo.ConvPointRefVoCollection();
		for(java.util.Iterator iterator = domainObject.getPoints().iterator(); iterator.hasNext(); ) 
		{
			ims.choose_book.domain.objects.ConvPoint tmp = (ims.choose_book.domain.objects.ConvPoint)iterator.next();
			if (tmp != null)
				points.add(new ims.choose_book.vo.ConvPointRefVo(tmp.getId(),tmp.getVersion()));
		}
		valueObject.setPoints(points);
		// msgUids
		ims.choose_book.vo.ConvUidRefVoCollection msgUids = new ims.choose_book.vo.ConvUidRefVoCollection();
		for(java.util.Iterator iterator = domainObject.getMsgUids().iterator(); iterator.hasNext(); ) 
		{
			ims.choose_book.domain.objects.ConvUid tmp = (ims.choose_book.domain.objects.ConvUid)iterator.next();
			if (tmp != null)
				msgUids.add(new ims.choose_book.vo.ConvUidRefVo(tmp.getId(),tmp.getVersion()));
		}
		valueObject.setMsgUids(msgUids);
		// dummy
		valueObject.setDummy( domainObject.isDummy() );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.choose_book.domain.objects.PDSGeneralUpdateConv extractPDSGeneralUpdateConv(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.PDSGeneralUpdateConvVo valueObject) 
	{
		return 	extractPDSGeneralUpdateConv(domainFactory, valueObject, new HashMap());
	}

	public static ims.choose_book.domain.objects.PDSGeneralUpdateConv extractPDSGeneralUpdateConv(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.PDSGeneralUpdateConvVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_Conversation();
		ims.choose_book.domain.objects.PDSGeneralUpdateConv domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.choose_book.domain.objects.PDSGeneralUpdateConv)domMap.get(valueObject);
			}
			// ims.core.vo.PDSGeneralUpdateConvVo ID_PDSGeneralUpdateConv field is unknown
			domainObject = new ims.choose_book.domain.objects.PDSGeneralUpdateConv();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_Conversation());
			if (domMap.get(key) != null)
			{
				return (ims.choose_book.domain.objects.PDSGeneralUpdateConv)domMap.get(key);
			}
			domainObject = (ims.choose_book.domain.objects.PDSGeneralUpdateConv) domainFactory.getDomainObject(ims.choose_book.domain.objects.PDSGeneralUpdateConv.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_Conversation());

		ims.choose_book.domain.objects.ConvId value1 = null;
		if ( null != valueObject.getCid() ) 
		{
			if (valueObject.getCid().getBoId() == null)
			{
				if (domMap.get(valueObject.getCid()) != null)
				{
					value1 = (ims.choose_book.domain.objects.ConvId)domMap.get(valueObject.getCid());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value1 = domainObject.getCid();	
			}
			else
			{
				value1 = (ims.choose_book.domain.objects.ConvId)domainFactory.getDomainObject(ims.choose_book.domain.objects.ConvId.class, valueObject.getCid().getBoId());
			}
		}
		domainObject.setCid(value1);
		ims.choose_book.domain.objects.SeqPoint value2 = null;
		if ( null != valueObject.getCurrent() ) 
		{
			if (valueObject.getCurrent().getBoId() == null)
			{
				if (domMap.get(valueObject.getCurrent()) != null)
				{
					value2 = (ims.choose_book.domain.objects.SeqPoint)domMap.get(valueObject.getCurrent());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value2 = domainObject.getCurrent();	
			}
			else
			{
				value2 = (ims.choose_book.domain.objects.SeqPoint)domainFactory.getDomainObject(ims.choose_book.domain.objects.SeqPoint.class, valueObject.getCurrent().getBoId());
			}
		}
		domainObject.setCurrent(value2);

		ims.choose_book.vo.ConvPointRefVoCollection refCollection3 = valueObject.getPoints();
		int size3 = (null == refCollection3) ? 0 : refCollection3.size();		
		java.util.List domainPoints3 = domainObject.getPoints();
		if (domainPoints3 == null)
		{
			domainPoints3 = new java.util.ArrayList();
		}
		for(int i=0; i < size3; i++) 
		{
			ims.choose_book.vo.ConvPointRefVo vo = refCollection3.get(i);			
			ims.choose_book.domain.objects.ConvPoint dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.choose_book.domain.objects.ConvPoint)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.choose_book.domain.objects.ConvPoint)domainFactory.getDomainObject( ims.choose_book.domain.objects.ConvPoint.class, vo.getBoId());
				}
			}

			int domIdx = domainPoints3.indexOf(dom);
			if (domIdx == -1)
			{
				domainPoints3.add(i, dom);
			}
			else if (i != domIdx && i < domainPoints3.size())
			{
				Object tmp = domainPoints3.get(i);
				domainPoints3.set(i, domainPoints3.get(domIdx));
				domainPoints3.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i3 = domainPoints3.size();
		while (i3 > size3)
		{
			domainPoints3.remove(i3-1);
			i3 = domainPoints3.size();
		}
		
		domainObject.setPoints(domainPoints3);		

		ims.choose_book.vo.ConvUidRefVoCollection refCollection4 = valueObject.getMsgUids();
		int size4 = (null == refCollection4) ? 0 : refCollection4.size();		
		java.util.List domainMsgUids4 = domainObject.getMsgUids();
		if (domainMsgUids4 == null)
		{
			domainMsgUids4 = new java.util.ArrayList();
		}
		for(int i=0; i < size4; i++) 
		{
			ims.choose_book.vo.ConvUidRefVo vo = refCollection4.get(i);			
			ims.choose_book.domain.objects.ConvUid dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.choose_book.domain.objects.ConvUid)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.choose_book.domain.objects.ConvUid)domainFactory.getDomainObject( ims.choose_book.domain.objects.ConvUid.class, vo.getBoId());
				}
			}

			int domIdx = domainMsgUids4.indexOf(dom);
			if (domIdx == -1)
			{
				domainMsgUids4.add(i, dom);
			}
			else if (i != domIdx && i < domainMsgUids4.size())
			{
				Object tmp = domainMsgUids4.get(i);
				domainMsgUids4.set(i, domainMsgUids4.get(domIdx));
				domainMsgUids4.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i4 = domainMsgUids4.size();
		while (i4 > size4)
		{
			domainMsgUids4.remove(i4-1);
			i4 = domainMsgUids4.size();
		}
		
		domainObject.setMsgUids(domainMsgUids4);		
		domainObject.setDummy(valueObject.getDummy());

		return domainObject;
	}

}
