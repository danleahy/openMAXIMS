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
package ims.RefMan.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Cristian Belciug
 */
public class PreAssessmentOutcomeForElectiveListDetailsVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo copy(ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo valueObjectDest, ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_PreAssessmentOutcome(valueObjectSrc.getID_PreAssessmentOutcome());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// PaceMakerDefib
		valueObjectDest.setPaceMakerDefib(valueObjectSrc.getPaceMakerDefib());
		// ReceivingAntiCoag
		valueObjectDest.setReceivingAntiCoag(valueObjectSrc.getReceivingAntiCoag());
		// ShortNotice
		valueObjectDest.setShortNotice(valueObjectSrc.getShortNotice());
		// NoticePeriodValue
		valueObjectDest.setNoticePeriodValue(valueObjectSrc.getNoticePeriodValue());
		// PreOpOvernight
		valueObjectDest.setPreOpOvernight(valueObjectSrc.getPreOpOvernight());
		// Nights
		valueObjectDest.setNights(valueObjectSrc.getNights());
		// PostOpStay
		valueObjectDest.setPostOpStay(valueObjectSrc.getPostOpStay());
		// AnaestheticType
		valueObjectDest.setAnaestheticType(valueObjectSrc.getAnaestheticType());
		// FitToProceed
		valueObjectDest.setFitToProceed(valueObjectSrc.getFitToProceed());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createPreAssessmentOutcomeForElectiveListDetailsVoCollectionFromPreAssessmentOutcome(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.PreAssessmentOutcome objects.
	 */
	public static ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVoCollection createPreAssessmentOutcomeForElectiveListDetailsVoCollectionFromPreAssessmentOutcome(java.util.Set domainObjectSet)	
	{
		return createPreAssessmentOutcomeForElectiveListDetailsVoCollectionFromPreAssessmentOutcome(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.PreAssessmentOutcome objects.
	 */
	public static ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVoCollection createPreAssessmentOutcomeForElectiveListDetailsVoCollectionFromPreAssessmentOutcome(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVoCollection voList = new ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.RefMan.domain.objects.PreAssessmentOutcome domainObject = (ims.RefMan.domain.objects.PreAssessmentOutcome) iterator.next();
			ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.RefMan.domain.objects.PreAssessmentOutcome objects.
	 */
	public static ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVoCollection createPreAssessmentOutcomeForElectiveListDetailsVoCollectionFromPreAssessmentOutcome(java.util.List domainObjectList) 
	{
		return createPreAssessmentOutcomeForElectiveListDetailsVoCollectionFromPreAssessmentOutcome(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.RefMan.domain.objects.PreAssessmentOutcome objects.
	 */
	public static ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVoCollection createPreAssessmentOutcomeForElectiveListDetailsVoCollectionFromPreAssessmentOutcome(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVoCollection voList = new ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.RefMan.domain.objects.PreAssessmentOutcome domainObject = (ims.RefMan.domain.objects.PreAssessmentOutcome) domainObjectList.get(i);
			ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo vo = create(map, domainObject);

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
	 * Create the ims.RefMan.domain.objects.PreAssessmentOutcome set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractPreAssessmentOutcomeSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVoCollection voCollection) 
	 {
	 	return extractPreAssessmentOutcomeSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractPreAssessmentOutcomeSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.PreAssessmentOutcome domainObject = PreAssessmentOutcomeForElectiveListDetailsVoAssembler.extractPreAssessmentOutcome(domainFactory, vo, domMap);

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
	 * Create the ims.RefMan.domain.objects.PreAssessmentOutcome list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractPreAssessmentOutcomeList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVoCollection voCollection) 
	 {
	 	return extractPreAssessmentOutcomeList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractPreAssessmentOutcomeList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.PreAssessmentOutcome domainObject = PreAssessmentOutcomeForElectiveListDetailsVoAssembler.extractPreAssessmentOutcome(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.RefMan.domain.objects.PreAssessmentOutcome object.
	 * @param domainObject ims.RefMan.domain.objects.PreAssessmentOutcome
	 */
	 public static ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo create(ims.RefMan.domain.objects.PreAssessmentOutcome domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.RefMan.domain.objects.PreAssessmentOutcome object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo create(DomainObjectMap map, ims.RefMan.domain.objects.PreAssessmentOutcome domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo valueObject = (ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo) map.getValueObject(domainObject, ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.RefMan.domain.objects.PreAssessmentOutcome
	 */
	 public static ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo insert(ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo valueObject, ims.RefMan.domain.objects.PreAssessmentOutcome domainObject) 
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
	 * @param domainObject ims.RefMan.domain.objects.PreAssessmentOutcome
	 */
	 public static ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo insert(DomainObjectMap map, ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo valueObject, ims.RefMan.domain.objects.PreAssessmentOutcome domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_PreAssessmentOutcome(domainObject.getId());
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
			
		// PaceMakerDefib
		ims.domain.lookups.LookupInstance instance1 = domainObject.getPaceMakerDefib();
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

			ims.core.vo.lookups.YesNo voLookup1 = new ims.core.vo.lookups.YesNo(instance1.getId(),instance1.getText(), instance1.isActive(), null, img, color);
			ims.core.vo.lookups.YesNo parentVoLookup1 = voLookup1;
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
								parentVoLookup1.setParent(new ims.core.vo.lookups.YesNo(parent1.getId(),parent1.getText(), parent1.isActive(), null, img, color));
				parentVoLookup1 = parentVoLookup1.getParent();
								parent1 = parent1.getParent();
			}			
			valueObject.setPaceMakerDefib(voLookup1);
		}
				// ReceivingAntiCoag
		ims.domain.lookups.LookupInstance instance2 = domainObject.getReceivingAntiCoag();
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

			ims.core.vo.lookups.YesNoUnknown voLookup2 = new ims.core.vo.lookups.YesNoUnknown(instance2.getId(),instance2.getText(), instance2.isActive(), null, img, color);
			ims.core.vo.lookups.YesNoUnknown parentVoLookup2 = voLookup2;
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
								parentVoLookup2.setParent(new ims.core.vo.lookups.YesNoUnknown(parent2.getId(),parent2.getText(), parent2.isActive(), null, img, color));
				parentVoLookup2 = parentVoLookup2.getParent();
								parent2 = parent2.getParent();
			}			
			valueObject.setReceivingAntiCoag(voLookup2);
		}
				// ShortNotice
		valueObject.setShortNotice( domainObject.isShortNotice() );
		// NoticePeriodValue
		valueObject.setNoticePeriodValue(domainObject.getNoticePeriodValue());
		// PreOpOvernight
		valueObject.setPreOpOvernight( domainObject.isPreOpOvernight() );
		// Nights
		valueObject.setNights(domainObject.getNights());
		// PostOpStay
		valueObject.setPostOpStay(domainObject.getPostOpStay());
		// AnaestheticType
		ims.domain.lookups.LookupInstance instance8 = domainObject.getAnaestheticType();
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

			ims.clinical.vo.lookups.AnaestheticType voLookup8 = new ims.clinical.vo.lookups.AnaestheticType(instance8.getId(),instance8.getText(), instance8.isActive(), null, img, color);
			ims.clinical.vo.lookups.AnaestheticType parentVoLookup8 = voLookup8;
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
								parentVoLookup8.setParent(new ims.clinical.vo.lookups.AnaestheticType(parent8.getId(),parent8.getText(), parent8.isActive(), null, img, color));
				parentVoLookup8 = parentVoLookup8.getParent();
								parent8 = parent8.getParent();
			}			
			valueObject.setAnaestheticType(voLookup8);
		}
				// FitToProceed
		valueObject.setFitToProceed( domainObject.isFitToProceed() );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.RefMan.domain.objects.PreAssessmentOutcome extractPreAssessmentOutcome(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo valueObject) 
	{
		return 	extractPreAssessmentOutcome(domainFactory, valueObject, new HashMap());
	}

	public static ims.RefMan.domain.objects.PreAssessmentOutcome extractPreAssessmentOutcome(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_PreAssessmentOutcome();
		ims.RefMan.domain.objects.PreAssessmentOutcome domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.RefMan.domain.objects.PreAssessmentOutcome)domMap.get(valueObject);
			}
			// ims.RefMan.vo.PreAssessmentOutcomeForElectiveListDetailsVo ID_PreAssessmentOutcome field is unknown
			domainObject = new ims.RefMan.domain.objects.PreAssessmentOutcome();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_PreAssessmentOutcome());
			if (domMap.get(key) != null)
			{
				return (ims.RefMan.domain.objects.PreAssessmentOutcome)domMap.get(key);
			}
			domainObject = (ims.RefMan.domain.objects.PreAssessmentOutcome) domainFactory.getDomainObject(ims.RefMan.domain.objects.PreAssessmentOutcome.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_PreAssessmentOutcome());

		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value1 = null;
		if ( null != valueObject.getPaceMakerDefib() ) 
		{
			value1 =
				domainFactory.getLookupInstance(valueObject.getPaceMakerDefib().getID());
		}
		domainObject.setPaceMakerDefib(value1);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value2 = null;
		if ( null != valueObject.getReceivingAntiCoag() ) 
		{
			value2 =
				domainFactory.getLookupInstance(valueObject.getReceivingAntiCoag().getID());
		}
		domainObject.setReceivingAntiCoag(value2);
		domainObject.setShortNotice(valueObject.getShortNotice());
		domainObject.setNoticePeriodValue(valueObject.getNoticePeriodValue());
		domainObject.setPreOpOvernight(valueObject.getPreOpOvernight());
		domainObject.setNights(valueObject.getNights());
		domainObject.setPostOpStay(valueObject.getPostOpStay());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value8 = null;
		if ( null != valueObject.getAnaestheticType() ) 
		{
			value8 =
				domainFactory.getLookupInstance(valueObject.getAnaestheticType().getID());
		}
		domainObject.setAnaestheticType(value8);
		domainObject.setFitToProceed(valueObject.getFitToProceed());

		return domainObject;
	}

}
