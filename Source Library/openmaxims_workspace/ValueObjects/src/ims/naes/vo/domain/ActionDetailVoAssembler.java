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
package ims.naes.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Aidan Mc Donnell
 */
public class ActionDetailVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.naes.vo.ActionDetailVo copy(ims.naes.vo.ActionDetailVo valueObjectDest, ims.naes.vo.ActionDetailVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ActionDetail(valueObjectSrc.getID_ActionDetail());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Action
		valueObjectDest.setAction(valueObjectSrc.getAction());
		// StartDate
		valueObjectDest.setStartDate(valueObjectSrc.getStartDate());
		// CurrentStatus
		valueObjectDest.setCurrentStatus(valueObjectSrc.getCurrentStatus());
		// ResponsibleTechnician
		valueObjectDest.setResponsibleTechnician(valueObjectSrc.getResponsibleTechnician());
		// TimeElapsed
		valueObjectDest.setTimeElapsed(valueObjectSrc.getTimeElapsed());
		// Comment
		valueObjectDest.setComment(valueObjectSrc.getComment());
		// StatusHistory
		valueObjectDest.setStatusHistory(valueObjectSrc.getStatusHistory());
		// Sysinfo
		valueObjectDest.setSysinfo(valueObjectSrc.getSysinfo());
		// ActionTemplate
		valueObjectDest.setActionTemplate(valueObjectSrc.getActionTemplate());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createActionDetailVoCollectionFromActionDetail(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.naes.domain.objects.ActionDetail objects.
	 */
	public static ims.naes.vo.ActionDetailVoCollection createActionDetailVoCollectionFromActionDetail(java.util.Set domainObjectSet)	
	{
		return createActionDetailVoCollectionFromActionDetail(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.naes.domain.objects.ActionDetail objects.
	 */
	public static ims.naes.vo.ActionDetailVoCollection createActionDetailVoCollectionFromActionDetail(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.naes.vo.ActionDetailVoCollection voList = new ims.naes.vo.ActionDetailVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.naes.domain.objects.ActionDetail domainObject = (ims.naes.domain.objects.ActionDetail) iterator.next();
			ims.naes.vo.ActionDetailVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.naes.domain.objects.ActionDetail objects.
	 */
	public static ims.naes.vo.ActionDetailVoCollection createActionDetailVoCollectionFromActionDetail(java.util.List domainObjectList) 
	{
		return createActionDetailVoCollectionFromActionDetail(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.naes.domain.objects.ActionDetail objects.
	 */
	public static ims.naes.vo.ActionDetailVoCollection createActionDetailVoCollectionFromActionDetail(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.naes.vo.ActionDetailVoCollection voList = new ims.naes.vo.ActionDetailVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.naes.domain.objects.ActionDetail domainObject = (ims.naes.domain.objects.ActionDetail) domainObjectList.get(i);
			ims.naes.vo.ActionDetailVo vo = create(map, domainObject);

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
	 * Create the ims.naes.domain.objects.ActionDetail set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractActionDetailSet(ims.domain.ILightweightDomainFactory domainFactory, ims.naes.vo.ActionDetailVoCollection voCollection) 
	 {
	 	return extractActionDetailSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractActionDetailSet(ims.domain.ILightweightDomainFactory domainFactory, ims.naes.vo.ActionDetailVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.naes.vo.ActionDetailVo vo = voCollection.get(i);
			ims.naes.domain.objects.ActionDetail domainObject = ActionDetailVoAssembler.extractActionDetail(domainFactory, vo, domMap);

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
	 * Create the ims.naes.domain.objects.ActionDetail list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractActionDetailList(ims.domain.ILightweightDomainFactory domainFactory, ims.naes.vo.ActionDetailVoCollection voCollection) 
	 {
	 	return extractActionDetailList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractActionDetailList(ims.domain.ILightweightDomainFactory domainFactory, ims.naes.vo.ActionDetailVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.naes.vo.ActionDetailVo vo = voCollection.get(i);
			ims.naes.domain.objects.ActionDetail domainObject = ActionDetailVoAssembler.extractActionDetail(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.naes.domain.objects.ActionDetail object.
	 * @param domainObject ims.naes.domain.objects.ActionDetail
	 */
	 public static ims.naes.vo.ActionDetailVo create(ims.naes.domain.objects.ActionDetail domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.naes.domain.objects.ActionDetail object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.naes.vo.ActionDetailVo create(DomainObjectMap map, ims.naes.domain.objects.ActionDetail domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.naes.vo.ActionDetailVo valueObject = (ims.naes.vo.ActionDetailVo) map.getValueObject(domainObject, ims.naes.vo.ActionDetailVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.naes.vo.ActionDetailVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.naes.domain.objects.ActionDetail
	 */
	 public static ims.naes.vo.ActionDetailVo insert(ims.naes.vo.ActionDetailVo valueObject, ims.naes.domain.objects.ActionDetail domainObject) 
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
	 * @param domainObject ims.naes.domain.objects.ActionDetail
	 */
	 public static ims.naes.vo.ActionDetailVo insert(DomainObjectMap map, ims.naes.vo.ActionDetailVo valueObject, ims.naes.domain.objects.ActionDetail domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ActionDetail(domainObject.getId());
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
			
		// Action
		ims.domain.lookups.LookupInstance instance1 = domainObject.getAction();
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

			ims.naes.vo.lookups.Action voLookup1 = new ims.naes.vo.lookups.Action(instance1.getId(),instance1.getText(), instance1.isActive(), null, img, color);
			ims.naes.vo.lookups.Action parentVoLookup1 = voLookup1;
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
								parentVoLookup1.setParent(new ims.naes.vo.lookups.Action(parent1.getId(),parent1.getText(), parent1.isActive(), null, img, color));
				parentVoLookup1 = parentVoLookup1.getParent();
								parent1 = parent1.getParent();
			}			
			valueObject.setAction(voLookup1);
		}
				// StartDate
		java.util.Date StartDate = domainObject.getStartDate();
		if ( null != StartDate ) 
		{
			valueObject.setStartDate(new ims.framework.utils.Date(StartDate) );
		}
		// CurrentStatus
		valueObject.setCurrentStatus(ims.naes.vo.domain.ActionDetailStatusVoAssembler.create(map, domainObject.getCurrentStatus()) );
		// ResponsibleTechnician
		valueObject.setResponsibleTechnician(ims.core.vo.domain.MemberOfStaffLiteVoAssembler.create(map, domainObject.getResponsibleTechnician()) );
		// TimeElapsed
		valueObject.setTimeElapsed(domainObject.getTimeElapsed());
		// Comment
		valueObject.setComment(domainObject.getComment());
		// StatusHistory
		valueObject.setStatusHistory(ims.naes.vo.domain.ActionDetailStatusVoAssembler.createActionDetailStatusVoCollectionFromActionDetailStatus(map, domainObject.getStatusHistory()) );
		// Sysinfo
		// set system information
		valueObject.setSysinfo(ims.vo.domain.SystemInformationAssembler.create(domainObject.getSystemInformation()));
		// ActionTemplate
		valueObject.setActionTemplate(ims.core.vo.domain.ActionPlanTemplateVoAssembler.create(map, domainObject.getActionTemplate()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.naes.domain.objects.ActionDetail extractActionDetail(ims.domain.ILightweightDomainFactory domainFactory, ims.naes.vo.ActionDetailVo valueObject) 
	{
		return 	extractActionDetail(domainFactory, valueObject, new HashMap());
	}

	public static ims.naes.domain.objects.ActionDetail extractActionDetail(ims.domain.ILightweightDomainFactory domainFactory, ims.naes.vo.ActionDetailVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ActionDetail();
		ims.naes.domain.objects.ActionDetail domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.naes.domain.objects.ActionDetail)domMap.get(valueObject);
			}
			// ims.naes.vo.ActionDetailVo ID_ActionDetail field is unknown
			domainObject = new ims.naes.domain.objects.ActionDetail();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ActionDetail());
			if (domMap.get(key) != null)
			{
				return (ims.naes.domain.objects.ActionDetail)domMap.get(key);
			}
			domainObject = (ims.naes.domain.objects.ActionDetail) domainFactory.getDomainObject(ims.naes.domain.objects.ActionDetail.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ActionDetail());

		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value1 = null;
		if ( null != valueObject.getAction() ) 
		{
			value1 =
				domainFactory.getLookupInstance(valueObject.getAction().getID());
		}
		domainObject.setAction(value1);
		java.util.Date value2 = null;
		ims.framework.utils.Date date2 = valueObject.getStartDate();		
		if ( date2 != null ) 
		{
			value2 = date2.getDate();
		}
		domainObject.setStartDate(value2);
		domainObject.setCurrentStatus(ims.naes.vo.domain.ActionDetailStatusVoAssembler.extractActionDetailStatus(domainFactory, valueObject.getCurrentStatus(), domMap));
		domainObject.setResponsibleTechnician(ims.core.vo.domain.MemberOfStaffLiteVoAssembler.extractMemberOfStaff(domainFactory, valueObject.getResponsibleTechnician(), domMap));
		domainObject.setTimeElapsed(valueObject.getTimeElapsed());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getComment() != null && valueObject.getComment().equals(""))
		{
			valueObject.setComment(null);
		}
		domainObject.setComment(valueObject.getComment());
		domainObject.setStatusHistory(ims.naes.vo.domain.ActionDetailStatusVoAssembler.extractActionDetailStatusSet(domainFactory, valueObject.getStatusHistory(), domainObject.getStatusHistory(), domMap));		
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.naes.domain.objects.ActionPlanTemplate value9 = null;
		if ( null != valueObject.getActionTemplate() ) 
		{
			if (valueObject.getActionTemplate().getBoId() == null)
			{
				if (domMap.get(valueObject.getActionTemplate()) != null)
				{
					value9 = (ims.naes.domain.objects.ActionPlanTemplate)domMap.get(valueObject.getActionTemplate());
				}
			}
			else
			{
				value9 = (ims.naes.domain.objects.ActionPlanTemplate)domainFactory.getDomainObject(ims.naes.domain.objects.ActionPlanTemplate.class, valueObject.getActionTemplate().getBoId());
			}
		}
		domainObject.setActionTemplate(value9);

		return domainObject;
	}

}
