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
 * @author Billy Mahon
 */
public class PatientPMHChecklistProcedureVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.clinical.vo.PatientPMHChecklistProcedureVo copy(ims.clinical.vo.PatientPMHChecklistProcedureVo valueObjectDest, ims.clinical.vo.PatientPMHChecklistProcedureVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_PatientPMHChecklistProcedure(valueObjectSrc.getID_PatientPMHChecklistProcedure());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Procedure
		valueObjectDest.setProcedure(valueObjectSrc.getProcedure());
		// Selected
		valueObjectDest.setSelected(valueObjectSrc.getSelected());
		// Notes
		valueObjectDest.setNotes(valueObjectSrc.getNotes());
		// SourceofInformation
		valueObjectDest.setSourceofInformation(valueObjectSrc.getSourceofInformation());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createPatientPMHChecklistProcedureVoCollectionFromPatientPMHChecklistProcedure(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.clinical.domain.objects.PatientPMHChecklistProcedure objects.
	 */
	public static ims.clinical.vo.PatientPMHChecklistProcedureVoCollection createPatientPMHChecklistProcedureVoCollectionFromPatientPMHChecklistProcedure(java.util.Set domainObjectSet)	
	{
		return createPatientPMHChecklistProcedureVoCollectionFromPatientPMHChecklistProcedure(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.clinical.domain.objects.PatientPMHChecklistProcedure objects.
	 */
	public static ims.clinical.vo.PatientPMHChecklistProcedureVoCollection createPatientPMHChecklistProcedureVoCollectionFromPatientPMHChecklistProcedure(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.clinical.vo.PatientPMHChecklistProcedureVoCollection voList = new ims.clinical.vo.PatientPMHChecklistProcedureVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.clinical.domain.objects.PatientPMHChecklistProcedure domainObject = (ims.clinical.domain.objects.PatientPMHChecklistProcedure) iterator.next();
			ims.clinical.vo.PatientPMHChecklistProcedureVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.clinical.domain.objects.PatientPMHChecklistProcedure objects.
	 */
	public static ims.clinical.vo.PatientPMHChecklistProcedureVoCollection createPatientPMHChecklistProcedureVoCollectionFromPatientPMHChecklistProcedure(java.util.List domainObjectList) 
	{
		return createPatientPMHChecklistProcedureVoCollectionFromPatientPMHChecklistProcedure(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.clinical.domain.objects.PatientPMHChecklistProcedure objects.
	 */
	public static ims.clinical.vo.PatientPMHChecklistProcedureVoCollection createPatientPMHChecklistProcedureVoCollectionFromPatientPMHChecklistProcedure(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.clinical.vo.PatientPMHChecklistProcedureVoCollection voList = new ims.clinical.vo.PatientPMHChecklistProcedureVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.clinical.domain.objects.PatientPMHChecklistProcedure domainObject = (ims.clinical.domain.objects.PatientPMHChecklistProcedure) domainObjectList.get(i);
			ims.clinical.vo.PatientPMHChecklistProcedureVo vo = create(map, domainObject);

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
	 * Create the ims.clinical.domain.objects.PatientPMHChecklistProcedure set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractPatientPMHChecklistProcedureSet(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.PatientPMHChecklistProcedureVoCollection voCollection) 
	 {
	 	return extractPatientPMHChecklistProcedureSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractPatientPMHChecklistProcedureSet(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.PatientPMHChecklistProcedureVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.clinical.vo.PatientPMHChecklistProcedureVo vo = voCollection.get(i);
			ims.clinical.domain.objects.PatientPMHChecklistProcedure domainObject = PatientPMHChecklistProcedureVoAssembler.extractPatientPMHChecklistProcedure(domainFactory, vo, domMap);

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
	 * Create the ims.clinical.domain.objects.PatientPMHChecklistProcedure list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractPatientPMHChecklistProcedureList(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.PatientPMHChecklistProcedureVoCollection voCollection) 
	 {
	 	return extractPatientPMHChecklistProcedureList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractPatientPMHChecklistProcedureList(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.PatientPMHChecklistProcedureVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.clinical.vo.PatientPMHChecklistProcedureVo vo = voCollection.get(i);
			ims.clinical.domain.objects.PatientPMHChecklistProcedure domainObject = PatientPMHChecklistProcedureVoAssembler.extractPatientPMHChecklistProcedure(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.clinical.domain.objects.PatientPMHChecklistProcedure object.
	 * @param domainObject ims.clinical.domain.objects.PatientPMHChecklistProcedure
	 */
	 public static ims.clinical.vo.PatientPMHChecklistProcedureVo create(ims.clinical.domain.objects.PatientPMHChecklistProcedure domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.clinical.domain.objects.PatientPMHChecklistProcedure object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.clinical.vo.PatientPMHChecklistProcedureVo create(DomainObjectMap map, ims.clinical.domain.objects.PatientPMHChecklistProcedure domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.clinical.vo.PatientPMHChecklistProcedureVo valueObject = (ims.clinical.vo.PatientPMHChecklistProcedureVo) map.getValueObject(domainObject, ims.clinical.vo.PatientPMHChecklistProcedureVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.clinical.vo.PatientPMHChecklistProcedureVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.clinical.domain.objects.PatientPMHChecklistProcedure
	 */
	 public static ims.clinical.vo.PatientPMHChecklistProcedureVo insert(ims.clinical.vo.PatientPMHChecklistProcedureVo valueObject, ims.clinical.domain.objects.PatientPMHChecklistProcedure domainObject) 
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
	 * @param domainObject ims.clinical.domain.objects.PatientPMHChecklistProcedure
	 */
	 public static ims.clinical.vo.PatientPMHChecklistProcedureVo insert(DomainObjectMap map, ims.clinical.vo.PatientPMHChecklistProcedureVo valueObject, ims.clinical.domain.objects.PatientPMHChecklistProcedure domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_PatientPMHChecklistProcedure(domainObject.getId());
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
			
		// Procedure
		valueObject.setProcedure(ims.core.vo.domain.ProcedureLiteVoAssembler.create(map, domainObject.getProcedure()) );
		// Selected
		ims.domain.lookups.LookupInstance instance2 = domainObject.getSelected();
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
			valueObject.setSelected(voLookup2);
		}
				// Notes
		valueObject.setNotes(domainObject.getNotes());
		// SourceofInformation
		ims.domain.lookups.LookupInstance instance4 = domainObject.getSourceofInformation();
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

			ims.core.vo.lookups.SourceofInformation voLookup4 = new ims.core.vo.lookups.SourceofInformation(instance4.getId(),instance4.getText(), instance4.isActive(), null, img, color);
			ims.core.vo.lookups.SourceofInformation parentVoLookup4 = voLookup4;
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
								parentVoLookup4.setParent(new ims.core.vo.lookups.SourceofInformation(parent4.getId(),parent4.getText(), parent4.isActive(), null, img, color));
				parentVoLookup4 = parentVoLookup4.getParent();
								parent4 = parent4.getParent();
			}			
			valueObject.setSourceofInformation(voLookup4);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.clinical.domain.objects.PatientPMHChecklistProcedure extractPatientPMHChecklistProcedure(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.PatientPMHChecklistProcedureVo valueObject) 
	{
		return 	extractPatientPMHChecklistProcedure(domainFactory, valueObject, new HashMap());
	}

	public static ims.clinical.domain.objects.PatientPMHChecklistProcedure extractPatientPMHChecklistProcedure(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.PatientPMHChecklistProcedureVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_PatientPMHChecklistProcedure();
		ims.clinical.domain.objects.PatientPMHChecklistProcedure domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.clinical.domain.objects.PatientPMHChecklistProcedure)domMap.get(valueObject);
			}
			// ims.clinical.vo.PatientPMHChecklistProcedureVo ID_PatientPMHChecklistProcedure field is unknown
			domainObject = new ims.clinical.domain.objects.PatientPMHChecklistProcedure();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_PatientPMHChecklistProcedure());
			if (domMap.get(key) != null)
			{
				return (ims.clinical.domain.objects.PatientPMHChecklistProcedure)domMap.get(key);
			}
			domainObject = (ims.clinical.domain.objects.PatientPMHChecklistProcedure) domainFactory.getDomainObject(ims.clinical.domain.objects.PatientPMHChecklistProcedure.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_PatientPMHChecklistProcedure());

		domainObject.setProcedure(ims.core.vo.domain.ProcedureLiteVoAssembler.extractProcedure(domainFactory, valueObject.getProcedure(), domMap));
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value2 = null;
		if ( null != valueObject.getSelected() ) 
		{
			value2 =
				domainFactory.getLookupInstance(valueObject.getSelected().getID());
		}
		domainObject.setSelected(value2);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getNotes() != null && valueObject.getNotes().equals(""))
		{
			valueObject.setNotes(null);
		}
		domainObject.setNotes(valueObject.getNotes());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value4 = null;
		if ( null != valueObject.getSourceofInformation() ) 
		{
			value4 =
				domainFactory.getLookupInstance(valueObject.getSourceofInformation().getID());
		}
		domainObject.setSourceofInformation(value4);

		return domainObject;
	}

}
