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
package ims.ocrr.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author George Cristian Josan
 */
public class OrderSpecimenLabSpecCommentsVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo copy(ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo valueObjectDest, ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_OrderSpecimen(valueObjectSrc.getID_OrderSpecimen());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// SpecimenSource
		valueObjectDest.setSpecimenSource(valueObjectSrc.getSpecimenSource());
		// LabSpecComments
		valueObjectDest.setLabSpecComments(valueObjectSrc.getLabSpecComments());
		// CollDateTimeFiller
		valueObjectDest.setCollDateTimeFiller(valueObjectSrc.getCollDateTimeFiller());
		// ColTimeFillerSupplied
		valueObjectDest.setColTimeFillerSupplied(valueObjectSrc.getColTimeFillerSupplied());
		// ReceivedDateTime
		valueObjectDest.setReceivedDateTime(valueObjectSrc.getReceivedDateTime());
		// ReceivedTimeSupplied
		valueObjectDest.setReceivedTimeSupplied(valueObjectSrc.getReceivedTimeSupplied());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createOrderSpecimenLabSpecCommentsVoCollectionFromOrderSpecimen(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.ocrr.orderingresults.domain.objects.OrderSpecimen objects.
	 */
	public static ims.ocrr.vo.OrderSpecimenLabSpecCommentsVoCollection createOrderSpecimenLabSpecCommentsVoCollectionFromOrderSpecimen(java.util.Set domainObjectSet)	
	{
		return createOrderSpecimenLabSpecCommentsVoCollectionFromOrderSpecimen(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.ocrr.orderingresults.domain.objects.OrderSpecimen objects.
	 */
	public static ims.ocrr.vo.OrderSpecimenLabSpecCommentsVoCollection createOrderSpecimenLabSpecCommentsVoCollectionFromOrderSpecimen(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.ocrr.vo.OrderSpecimenLabSpecCommentsVoCollection voList = new ims.ocrr.vo.OrderSpecimenLabSpecCommentsVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.ocrr.orderingresults.domain.objects.OrderSpecimen domainObject = (ims.ocrr.orderingresults.domain.objects.OrderSpecimen) iterator.next();
			ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.ocrr.orderingresults.domain.objects.OrderSpecimen objects.
	 */
	public static ims.ocrr.vo.OrderSpecimenLabSpecCommentsVoCollection createOrderSpecimenLabSpecCommentsVoCollectionFromOrderSpecimen(java.util.List domainObjectList) 
	{
		return createOrderSpecimenLabSpecCommentsVoCollectionFromOrderSpecimen(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.ocrr.orderingresults.domain.objects.OrderSpecimen objects.
	 */
	public static ims.ocrr.vo.OrderSpecimenLabSpecCommentsVoCollection createOrderSpecimenLabSpecCommentsVoCollectionFromOrderSpecimen(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.ocrr.vo.OrderSpecimenLabSpecCommentsVoCollection voList = new ims.ocrr.vo.OrderSpecimenLabSpecCommentsVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.ocrr.orderingresults.domain.objects.OrderSpecimen domainObject = (ims.ocrr.orderingresults.domain.objects.OrderSpecimen) domainObjectList.get(i);
			ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo vo = create(map, domainObject);

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
	 * Create the ims.ocrr.orderingresults.domain.objects.OrderSpecimen set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractOrderSpecimenSet(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.OrderSpecimenLabSpecCommentsVoCollection voCollection) 
	 {
	 	return extractOrderSpecimenSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractOrderSpecimenSet(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.OrderSpecimenLabSpecCommentsVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo vo = voCollection.get(i);
			ims.ocrr.orderingresults.domain.objects.OrderSpecimen domainObject = OrderSpecimenLabSpecCommentsVoAssembler.extractOrderSpecimen(domainFactory, vo, domMap);

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
	 * Create the ims.ocrr.orderingresults.domain.objects.OrderSpecimen list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractOrderSpecimenList(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.OrderSpecimenLabSpecCommentsVoCollection voCollection) 
	 {
	 	return extractOrderSpecimenList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractOrderSpecimenList(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.OrderSpecimenLabSpecCommentsVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo vo = voCollection.get(i);
			ims.ocrr.orderingresults.domain.objects.OrderSpecimen domainObject = OrderSpecimenLabSpecCommentsVoAssembler.extractOrderSpecimen(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.ocrr.orderingresults.domain.objects.OrderSpecimen object.
	 * @param domainObject ims.ocrr.orderingresults.domain.objects.OrderSpecimen
	 */
	 public static ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo create(ims.ocrr.orderingresults.domain.objects.OrderSpecimen domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.ocrr.orderingresults.domain.objects.OrderSpecimen object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo create(DomainObjectMap map, ims.ocrr.orderingresults.domain.objects.OrderSpecimen domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo valueObject = (ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo) map.getValueObject(domainObject, ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.ocrr.orderingresults.domain.objects.OrderSpecimen
	 */
	 public static ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo insert(ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo valueObject, ims.ocrr.orderingresults.domain.objects.OrderSpecimen domainObject) 
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
	 * @param domainObject ims.ocrr.orderingresults.domain.objects.OrderSpecimen
	 */
	 public static ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo insert(DomainObjectMap map, ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo valueObject, ims.ocrr.orderingresults.domain.objects.OrderSpecimen domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_OrderSpecimen(domainObject.getId());
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
			
		// SpecimenSource
		ims.domain.lookups.LookupInstance instance1 = domainObject.getSpecimenSource();
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

			ims.ocrr.vo.lookups.SpecimenType voLookup1 = new ims.ocrr.vo.lookups.SpecimenType(instance1.getId(),instance1.getText(), instance1.isActive(), null, img, color);
			ims.ocrr.vo.lookups.SpecimenType parentVoLookup1 = voLookup1;
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
								parentVoLookup1.setParent(new ims.ocrr.vo.lookups.SpecimenType(parent1.getId(),parent1.getText(), parent1.isActive(), null, img, color));
				parentVoLookup1 = parentVoLookup1.getParent();
								parent1 = parent1.getParent();
			}			
			valueObject.setSpecimenSource(voLookup1);
		}
				// LabSpecComments
		valueObject.setLabSpecComments(ims.ocrr.vo.domain.ResultComponentCommentsVoAssembler.createResultComponentCommentsVoCollectionFromResultComment(map, domainObject.getLabSpecComments()) );
		// CollDateTimeFiller
		java.util.Date CollDateTimeFiller = domainObject.getCollDateTimeFiller();
		if ( null != CollDateTimeFiller ) 
		{
			valueObject.setCollDateTimeFiller(new ims.framework.utils.DateTime(CollDateTimeFiller) );
		}
		// ColTimeFillerSupplied
		valueObject.setColTimeFillerSupplied( domainObject.isColTimeFillerSupplied() );
		// ReceivedDateTime
		java.util.Date ReceivedDateTime = domainObject.getReceivedDateTime();
		if ( null != ReceivedDateTime ) 
		{
			valueObject.setReceivedDateTime(new ims.framework.utils.DateTime(ReceivedDateTime) );
		}
		// ReceivedTimeSupplied
		valueObject.setReceivedTimeSupplied( domainObject.isReceivedTimeSupplied() );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.ocrr.orderingresults.domain.objects.OrderSpecimen extractOrderSpecimen(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo valueObject) 
	{
		return 	extractOrderSpecimen(domainFactory, valueObject, new HashMap());
	}

	public static ims.ocrr.orderingresults.domain.objects.OrderSpecimen extractOrderSpecimen(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_OrderSpecimen();
		ims.ocrr.orderingresults.domain.objects.OrderSpecimen domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.ocrr.orderingresults.domain.objects.OrderSpecimen)domMap.get(valueObject);
			}
			// ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo ID_OrderSpecimen field is unknown
			domainObject = new ims.ocrr.orderingresults.domain.objects.OrderSpecimen();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_OrderSpecimen());
			if (domMap.get(key) != null)
			{
				return (ims.ocrr.orderingresults.domain.objects.OrderSpecimen)domMap.get(key);
			}
			domainObject = (ims.ocrr.orderingresults.domain.objects.OrderSpecimen) domainFactory.getDomainObject(ims.ocrr.orderingresults.domain.objects.OrderSpecimen.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_OrderSpecimen());

		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value1 = null;
		if ( null != valueObject.getSpecimenSource() ) 
		{
			value1 =
				domainFactory.getLookupInstance(valueObject.getSpecimenSource().getID());
		}
		domainObject.setSpecimenSource(value1);

		// SaveAsRefVO treated as RefValueObject
		ims.ocrr.orderingresults.vo.ResultCommentRefVoCollection refCollection2 = new ims.ocrr.orderingresults.vo.ResultCommentRefVoCollection();
		if (valueObject.getLabSpecComments() != null)
		{
			for (int i2=0; i2<valueObject.getLabSpecComments().size(); i2++)
			{
				ims.ocrr.orderingresults.vo.ResultCommentRefVo ref2 = (ims.ocrr.orderingresults.vo.ResultCommentRefVo)valueObject.getLabSpecComments().get(i2);
				refCollection2.add(ref2);
			}
		}
		int size2 = (null == refCollection2) ? 0 : refCollection2.size();		
		java.util.List domainLabSpecComments2 = domainObject.getLabSpecComments();
		if (domainLabSpecComments2 == null)
		{
			domainLabSpecComments2 = new java.util.ArrayList();
		}
		for(int i=0; i < size2; i++) 
		{
			ims.ocrr.orderingresults.vo.ResultCommentRefVo vo = refCollection2.get(i);			
			ims.ocrr.orderingresults.domain.objects.ResultComment dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.ocrr.orderingresults.domain.objects.ResultComment)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.ocrr.orderingresults.domain.objects.ResultComment)domainFactory.getDomainObject( ims.ocrr.orderingresults.domain.objects.ResultComment.class, vo.getBoId());
				}
			}

			int domIdx = domainLabSpecComments2.indexOf(dom);
			if (domIdx == -1)
			{
				domainLabSpecComments2.add(i, dom);
			}
			else if (i != domIdx && i < domainLabSpecComments2.size())
			{
				Object tmp = domainLabSpecComments2.get(i);
				domainLabSpecComments2.set(i, domainLabSpecComments2.get(domIdx));
				domainLabSpecComments2.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i2 = domainLabSpecComments2.size();
		while (i2 > size2)
		{
			domainLabSpecComments2.remove(i2-1);
			i2 = domainLabSpecComments2.size();
		}
		
		domainObject.setLabSpecComments(domainLabSpecComments2);		
		ims.framework.utils.DateTime dateTime3 = valueObject.getCollDateTimeFiller();
		java.util.Date value3 = null;
		if ( dateTime3 != null ) 
		{
			value3 = dateTime3.getJavaDate();
		}
		domainObject.setCollDateTimeFiller(value3);
		domainObject.setColTimeFillerSupplied(valueObject.getColTimeFillerSupplied());
		ims.framework.utils.DateTime dateTime5 = valueObject.getReceivedDateTime();
		java.util.Date value5 = null;
		if ( dateTime5 != null ) 
		{
			value5 = dateTime5.getJavaDate();
		}
		domainObject.setReceivedDateTime(value5);
		domainObject.setReceivedTimeSupplied(valueObject.getReceivedTimeSupplied());

		return domainObject;
	}

}
