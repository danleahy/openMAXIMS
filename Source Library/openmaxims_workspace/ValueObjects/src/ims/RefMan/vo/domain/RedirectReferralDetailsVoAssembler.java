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
 * @author Cristian Belciug
 */
public class RedirectReferralDetailsVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.RefMan.vo.RedirectReferralDetailsVo copy(ims.RefMan.vo.RedirectReferralDetailsVo valueObjectDest, ims.RefMan.vo.RedirectReferralDetailsVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_RedirectReferralDetails(valueObjectSrc.getID_RedirectReferralDetails());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// RedirectService
		valueObjectDest.setRedirectService(valueObjectSrc.getRedirectService());
		// RedirectReason
		valueObjectDest.setRedirectReason(valueObjectSrc.getRedirectReason());
		// RedirectComment
		valueObjectDest.setRedirectComment(valueObjectSrc.getRedirectComment());
		// AuthoringUser
		valueObjectDest.setAuthoringUser(valueObjectSrc.getAuthoringUser());
		// RedirectDateTime
		valueObjectDest.setRedirectDateTime(valueObjectSrc.getRedirectDateTime());
		// RedirectHCP
		valueObjectDest.setRedirectHCP(valueObjectSrc.getRedirectHCP());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createRedirectReferralDetailsVoCollectionFromRedirectReferralDetails(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.RedirectReferralDetails objects.
	 */
	public static ims.RefMan.vo.RedirectReferralDetailsVoCollection createRedirectReferralDetailsVoCollectionFromRedirectReferralDetails(java.util.Set domainObjectSet)	
	{
		return createRedirectReferralDetailsVoCollectionFromRedirectReferralDetails(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.RedirectReferralDetails objects.
	 */
	public static ims.RefMan.vo.RedirectReferralDetailsVoCollection createRedirectReferralDetailsVoCollectionFromRedirectReferralDetails(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.RefMan.vo.RedirectReferralDetailsVoCollection voList = new ims.RefMan.vo.RedirectReferralDetailsVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.RefMan.domain.objects.RedirectReferralDetails domainObject = (ims.RefMan.domain.objects.RedirectReferralDetails) iterator.next();
			ims.RefMan.vo.RedirectReferralDetailsVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.RefMan.domain.objects.RedirectReferralDetails objects.
	 */
	public static ims.RefMan.vo.RedirectReferralDetailsVoCollection createRedirectReferralDetailsVoCollectionFromRedirectReferralDetails(java.util.List domainObjectList) 
	{
		return createRedirectReferralDetailsVoCollectionFromRedirectReferralDetails(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.RefMan.domain.objects.RedirectReferralDetails objects.
	 */
	public static ims.RefMan.vo.RedirectReferralDetailsVoCollection createRedirectReferralDetailsVoCollectionFromRedirectReferralDetails(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.RefMan.vo.RedirectReferralDetailsVoCollection voList = new ims.RefMan.vo.RedirectReferralDetailsVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.RefMan.domain.objects.RedirectReferralDetails domainObject = (ims.RefMan.domain.objects.RedirectReferralDetails) domainObjectList.get(i);
			ims.RefMan.vo.RedirectReferralDetailsVo vo = create(map, domainObject);

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
	 * Create the ims.RefMan.domain.objects.RedirectReferralDetails set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractRedirectReferralDetailsSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.RedirectReferralDetailsVoCollection voCollection) 
	 {
	 	return extractRedirectReferralDetailsSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractRedirectReferralDetailsSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.RedirectReferralDetailsVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.RedirectReferralDetailsVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.RedirectReferralDetails domainObject = RedirectReferralDetailsVoAssembler.extractRedirectReferralDetails(domainFactory, vo, domMap);

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
	 * Create the ims.RefMan.domain.objects.RedirectReferralDetails list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractRedirectReferralDetailsList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.RedirectReferralDetailsVoCollection voCollection) 
	 {
	 	return extractRedirectReferralDetailsList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractRedirectReferralDetailsList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.RedirectReferralDetailsVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.RedirectReferralDetailsVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.RedirectReferralDetails domainObject = RedirectReferralDetailsVoAssembler.extractRedirectReferralDetails(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.RefMan.domain.objects.RedirectReferralDetails object.
	 * @param domainObject ims.RefMan.domain.objects.RedirectReferralDetails
	 */
	 public static ims.RefMan.vo.RedirectReferralDetailsVo create(ims.RefMan.domain.objects.RedirectReferralDetails domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.RefMan.domain.objects.RedirectReferralDetails object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.RefMan.vo.RedirectReferralDetailsVo create(DomainObjectMap map, ims.RefMan.domain.objects.RedirectReferralDetails domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.RefMan.vo.RedirectReferralDetailsVo valueObject = (ims.RefMan.vo.RedirectReferralDetailsVo) map.getValueObject(domainObject, ims.RefMan.vo.RedirectReferralDetailsVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.RefMan.vo.RedirectReferralDetailsVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.RefMan.domain.objects.RedirectReferralDetails
	 */
	 public static ims.RefMan.vo.RedirectReferralDetailsVo insert(ims.RefMan.vo.RedirectReferralDetailsVo valueObject, ims.RefMan.domain.objects.RedirectReferralDetails domainObject) 
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
	 * @param domainObject ims.RefMan.domain.objects.RedirectReferralDetails
	 */
	 public static ims.RefMan.vo.RedirectReferralDetailsVo insert(DomainObjectMap map, ims.RefMan.vo.RedirectReferralDetailsVo valueObject, ims.RefMan.domain.objects.RedirectReferralDetails domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_RedirectReferralDetails(domainObject.getId());
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
			
		// RedirectService
		valueObject.setRedirectService(ims.core.vo.domain.ServiceLiteVoAssembler.create(map, domainObject.getRedirectService()) );
		// RedirectReason
		ims.domain.lookups.LookupInstance instance2 = domainObject.getRedirectReason();
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

			ims.RefMan.vo.lookups.RedirectReason voLookup2 = new ims.RefMan.vo.lookups.RedirectReason(instance2.getId(),instance2.getText(), instance2.isActive(), null, img, color);
			ims.RefMan.vo.lookups.RedirectReason parentVoLookup2 = voLookup2;
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
								parentVoLookup2.setParent(new ims.RefMan.vo.lookups.RedirectReason(parent2.getId(),parent2.getText(), parent2.isActive(), null, img, color));
				parentVoLookup2 = parentVoLookup2.getParent();
								parent2 = parent2.getParent();
			}			
			valueObject.setRedirectReason(voLookup2);
		}
				// RedirectComment
		valueObject.setRedirectComment(domainObject.getRedirectComment());
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
		// RedirectDateTime
		java.util.Date RedirectDateTime = domainObject.getRedirectDateTime();
		if ( null != RedirectDateTime ) 
		{
			valueObject.setRedirectDateTime(new ims.framework.utils.DateTime(RedirectDateTime) );
		}
		// RedirectHCP
		valueObject.setRedirectHCP(ims.core.vo.domain.HcpLiteVoAssembler.create(map, domainObject.getRedirectHCP()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.RefMan.domain.objects.RedirectReferralDetails extractRedirectReferralDetails(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.RedirectReferralDetailsVo valueObject) 
	{
		return 	extractRedirectReferralDetails(domainFactory, valueObject, new HashMap());
	}

	public static ims.RefMan.domain.objects.RedirectReferralDetails extractRedirectReferralDetails(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.RedirectReferralDetailsVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_RedirectReferralDetails();
		ims.RefMan.domain.objects.RedirectReferralDetails domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.RefMan.domain.objects.RedirectReferralDetails)domMap.get(valueObject);
			}
			// ims.RefMan.vo.RedirectReferralDetailsVo ID_RedirectReferralDetails field is unknown
			domainObject = new ims.RefMan.domain.objects.RedirectReferralDetails();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_RedirectReferralDetails());
			if (domMap.get(key) != null)
			{
				return (ims.RefMan.domain.objects.RedirectReferralDetails)domMap.get(key);
			}
			domainObject = (ims.RefMan.domain.objects.RedirectReferralDetails) domainFactory.getDomainObject(ims.RefMan.domain.objects.RedirectReferralDetails.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_RedirectReferralDetails());

	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.clinical.domain.objects.Service value1 = null;
		if ( null != valueObject.getRedirectService() ) 
		{
			if (valueObject.getRedirectService().getBoId() == null)
			{
				if (domMap.get(valueObject.getRedirectService()) != null)
				{
					value1 = (ims.core.clinical.domain.objects.Service)domMap.get(valueObject.getRedirectService());
				}
			}
			else
			{
				value1 = (ims.core.clinical.domain.objects.Service)domainFactory.getDomainObject(ims.core.clinical.domain.objects.Service.class, valueObject.getRedirectService().getBoId());
			}
		}
		domainObject.setRedirectService(value1);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value2 = null;
		if ( null != valueObject.getRedirectReason() ) 
		{
			value2 =
				domainFactory.getLookupInstance(valueObject.getRedirectReason().getID());
		}
		domainObject.setRedirectReason(value2);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getRedirectComment() != null && valueObject.getRedirectComment().equals(""))
		{
			valueObject.setRedirectComment(null);
		}
		domainObject.setRedirectComment(valueObject.getRedirectComment());
		ims.core.resource.people.domain.objects.MemberOfStaff value4 = null;
		if ( null != valueObject.getAuthoringUser() ) 
		{
			if (valueObject.getAuthoringUser().getBoId() == null)
			{
				if (domMap.get(valueObject.getAuthoringUser()) != null)
				{
					value4 = (ims.core.resource.people.domain.objects.MemberOfStaff)domMap.get(valueObject.getAuthoringUser());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value4 = domainObject.getAuthoringUser();	
			}
			else
			{
				value4 = (ims.core.resource.people.domain.objects.MemberOfStaff)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.MemberOfStaff.class, valueObject.getAuthoringUser().getBoId());
			}
		}
		domainObject.setAuthoringUser(value4);
		ims.framework.utils.DateTime dateTime5 = valueObject.getRedirectDateTime();
		java.util.Date value5 = null;
		if ( dateTime5 != null ) 
		{
			value5 = dateTime5.getJavaDate();
		}
		domainObject.setRedirectDateTime(value5);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.people.domain.objects.Hcp value6 = null;
		if ( null != valueObject.getRedirectHCP() ) 
		{
			if (valueObject.getRedirectHCP().getBoId() == null)
			{
				if (domMap.get(valueObject.getRedirectHCP()) != null)
				{
					value6 = (ims.core.resource.people.domain.objects.Hcp)domMap.get(valueObject.getRedirectHCP());
				}
			}
			else
			{
				value6 = (ims.core.resource.people.domain.objects.Hcp)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.Hcp.class, valueObject.getRedirectHCP().getBoId());
			}
		}
		domainObject.setRedirectHCP(value6);

		return domainObject;
	}

}
