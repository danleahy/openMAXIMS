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
package ims.RefMan.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Daniel Laffan
 */
public class CatsReferralStatusVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.RefMan.vo.CatsReferralStatusVo copy(ims.RefMan.vo.CatsReferralStatusVo valueObjectDest, ims.RefMan.vo.CatsReferralStatusVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_CATSReferralStatus(valueObjectSrc.getID_CATSReferralStatus());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// AuthoringUser
		valueObjectDest.setAuthoringUser(valueObjectSrc.getAuthoringUser());
		// Comment
		valueObjectDest.setComment(valueObjectSrc.getComment());
		// SecondOpinionCategory
		valueObjectDest.setSecondOpinionCategory(valueObjectSrc.getSecondOpinionCategory());
		// ReferralStatus
		valueObjectDest.setReferralStatus(valueObjectSrc.getReferralStatus());
		// StatusDateTime
		valueObjectDest.setStatusDateTime(valueObjectSrc.getStatusDateTime());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createCatsReferralStatusVoCollectionFromCATSReferralStatus(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.CATSReferralStatus objects.
	 */
	public static ims.RefMan.vo.CatsReferralStatusVoCollection createCatsReferralStatusVoCollectionFromCATSReferralStatus(java.util.Set domainObjectSet)	
	{
		return createCatsReferralStatusVoCollectionFromCATSReferralStatus(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.CATSReferralStatus objects.
	 */
	public static ims.RefMan.vo.CatsReferralStatusVoCollection createCatsReferralStatusVoCollectionFromCATSReferralStatus(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.RefMan.vo.CatsReferralStatusVoCollection voList = new ims.RefMan.vo.CatsReferralStatusVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.RefMan.domain.objects.CATSReferralStatus domainObject = (ims.RefMan.domain.objects.CATSReferralStatus) iterator.next();
			ims.RefMan.vo.CatsReferralStatusVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.RefMan.domain.objects.CATSReferralStatus objects.
	 */
	public static ims.RefMan.vo.CatsReferralStatusVoCollection createCatsReferralStatusVoCollectionFromCATSReferralStatus(java.util.List domainObjectList) 
	{
		return createCatsReferralStatusVoCollectionFromCATSReferralStatus(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.RefMan.domain.objects.CATSReferralStatus objects.
	 */
	public static ims.RefMan.vo.CatsReferralStatusVoCollection createCatsReferralStatusVoCollectionFromCATSReferralStatus(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.RefMan.vo.CatsReferralStatusVoCollection voList = new ims.RefMan.vo.CatsReferralStatusVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.RefMan.domain.objects.CATSReferralStatus domainObject = (ims.RefMan.domain.objects.CATSReferralStatus) domainObjectList.get(i);
			ims.RefMan.vo.CatsReferralStatusVo vo = create(map, domainObject);

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
	 * Create the ims.RefMan.domain.objects.CATSReferralStatus set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractCATSReferralStatusSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.CatsReferralStatusVoCollection voCollection) 
	 {
	 	return extractCATSReferralStatusSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractCATSReferralStatusSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.CatsReferralStatusVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.CatsReferralStatusVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.CATSReferralStatus domainObject = CatsReferralStatusVoAssembler.extractCATSReferralStatus(domainFactory, vo, domMap);

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
	 * Create the ims.RefMan.domain.objects.CATSReferralStatus list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractCATSReferralStatusList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.CatsReferralStatusVoCollection voCollection) 
	 {
	 	return extractCATSReferralStatusList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractCATSReferralStatusList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.CatsReferralStatusVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.CatsReferralStatusVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.CATSReferralStatus domainObject = CatsReferralStatusVoAssembler.extractCATSReferralStatus(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.RefMan.domain.objects.CATSReferralStatus object.
	 * @param domainObject ims.RefMan.domain.objects.CATSReferralStatus
	 */
	 public static ims.RefMan.vo.CatsReferralStatusVo create(ims.RefMan.domain.objects.CATSReferralStatus domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.RefMan.domain.objects.CATSReferralStatus object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.RefMan.vo.CatsReferralStatusVo create(DomainObjectMap map, ims.RefMan.domain.objects.CATSReferralStatus domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.RefMan.vo.CatsReferralStatusVo valueObject = (ims.RefMan.vo.CatsReferralStatusVo) map.getValueObject(domainObject, ims.RefMan.vo.CatsReferralStatusVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.RefMan.vo.CatsReferralStatusVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.RefMan.domain.objects.CATSReferralStatus
	 */
	 public static ims.RefMan.vo.CatsReferralStatusVo insert(ims.RefMan.vo.CatsReferralStatusVo valueObject, ims.RefMan.domain.objects.CATSReferralStatus domainObject) 
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
	 * @param domainObject ims.RefMan.domain.objects.CATSReferralStatus
	 */
	 public static ims.RefMan.vo.CatsReferralStatusVo insert(DomainObjectMap map, ims.RefMan.vo.CatsReferralStatusVo valueObject, ims.RefMan.domain.objects.CATSReferralStatus domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_CATSReferralStatus(domainObject.getId());
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
			
		// AuthoringUser
		if (domainObject.getAuthoringUser() != null)
		{
			if(domainObject.getAuthoringUser() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getAuthoringUser();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setAuthoringUser(new ims.core.resource.people.vo.MemberOfStaffRefVo(id, -1));				
			}
			else
			{
				valueObject.setAuthoringUser(new ims.core.resource.people.vo.MemberOfStaffRefVo(domainObject.getAuthoringUser().getId(), domainObject.getAuthoringUser().getVersion()));
			}
		}
		// Comment
		valueObject.setComment(domainObject.getComment());
		// SecondOpinionCategory
		ims.domain.lookups.LookupInstance instance3 = domainObject.getSecondOpinionCategory();
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

			ims.RefMan.vo.lookups.SecondOpinionCategory voLookup3 = new ims.RefMan.vo.lookups.SecondOpinionCategory(instance3.getId(),instance3.getText(), instance3.isActive(), null, img, color);
			ims.RefMan.vo.lookups.SecondOpinionCategory parentVoLookup3 = voLookup3;
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
								parentVoLookup3.setParent(new ims.RefMan.vo.lookups.SecondOpinionCategory(parent3.getId(),parent3.getText(), parent3.isActive(), null, img, color));
				parentVoLookup3 = parentVoLookup3.getParent();
								parent3 = parent3.getParent();
			}			
			valueObject.setSecondOpinionCategory(voLookup3);
		}
				// ReferralStatus
		ims.domain.lookups.LookupInstance instance4 = domainObject.getReferralStatus();
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

			ims.RefMan.vo.lookups.ReferralApptStatus voLookup4 = new ims.RefMan.vo.lookups.ReferralApptStatus(instance4.getId(),instance4.getText(), instance4.isActive(), null, img, color);
			ims.RefMan.vo.lookups.ReferralApptStatus parentVoLookup4 = voLookup4;
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
								parentVoLookup4.setParent(new ims.RefMan.vo.lookups.ReferralApptStatus(parent4.getId(),parent4.getText(), parent4.isActive(), null, img, color));
				parentVoLookup4 = parentVoLookup4.getParent();
								parent4 = parent4.getParent();
			}			
			valueObject.setReferralStatus(voLookup4);
		}
				// StatusDateTime
		java.util.Date StatusDateTime = domainObject.getStatusDateTime();
		if ( null != StatusDateTime ) 
		{
			valueObject.setStatusDateTime(new ims.framework.utils.DateTime(StatusDateTime) );
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.RefMan.domain.objects.CATSReferralStatus extractCATSReferralStatus(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.CatsReferralStatusVo valueObject) 
	{
		return 	extractCATSReferralStatus(domainFactory, valueObject, new HashMap());
	}

	public static ims.RefMan.domain.objects.CATSReferralStatus extractCATSReferralStatus(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.CatsReferralStatusVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_CATSReferralStatus();
		ims.RefMan.domain.objects.CATSReferralStatus domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.RefMan.domain.objects.CATSReferralStatus)domMap.get(valueObject);
			}
			// ims.RefMan.vo.CatsReferralStatusVo ID_CATSReferralStatus field is unknown
			domainObject = new ims.RefMan.domain.objects.CATSReferralStatus();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_CATSReferralStatus());
			if (domMap.get(key) != null)
			{
				return (ims.RefMan.domain.objects.CATSReferralStatus)domMap.get(key);
			}
			domainObject = (ims.RefMan.domain.objects.CATSReferralStatus) domainFactory.getDomainObject(ims.RefMan.domain.objects.CATSReferralStatus.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_CATSReferralStatus());

		ims.core.resource.people.domain.objects.MemberOfStaff value1 = null;
		if ( null != valueObject.getAuthoringUser() ) 
		{
			if (valueObject.getAuthoringUser().getBoId() == null)
			{
				if (domMap.get(valueObject.getAuthoringUser()) != null)
				{
					value1 = (ims.core.resource.people.domain.objects.MemberOfStaff)domMap.get(valueObject.getAuthoringUser());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value1 = domainObject.getAuthoringUser();	
			}
			else
			{
				value1 = (ims.core.resource.people.domain.objects.MemberOfStaff)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.MemberOfStaff.class, valueObject.getAuthoringUser().getBoId());
			}
		}
		domainObject.setAuthoringUser(value1);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getComment() != null && valueObject.getComment().equals(""))
		{
			valueObject.setComment(null);
		}
		domainObject.setComment(valueObject.getComment());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value3 = null;
		if ( null != valueObject.getSecondOpinionCategory() ) 
		{
			value3 =
				domainFactory.getLookupInstance(valueObject.getSecondOpinionCategory().getID());
		}
		domainObject.setSecondOpinionCategory(value3);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value4 = null;
		if ( null != valueObject.getReferralStatus() ) 
		{
			value4 =
				domainFactory.getLookupInstance(valueObject.getReferralStatus().getID());
		}
		domainObject.setReferralStatus(value4);
		ims.framework.utils.DateTime dateTime5 = valueObject.getStatusDateTime();
		java.util.Date value5 = null;
		if ( dateTime5 != null ) 
		{
			value5 = dateTime5.getJavaDate();
		}
		domainObject.setStatusDateTime(value5);

		return domainObject;
	}

}
