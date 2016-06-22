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
 * @author Daniel Laffan
 */
public class VSABGO2SatsVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.core.vo.VSABGO2SatsVo copy(ims.core.vo.VSABGO2SatsVo valueObjectDest, ims.core.vo.VSABGO2SatsVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_VitalSigns(valueObjectSrc.getID_VitalSigns());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// OxygenSaturation
		valueObjectDest.setOxygenSaturation(valueObjectSrc.getOxygenSaturation());
		// ArterialBloodGas
		valueObjectDest.setArterialBloodGas(valueObjectSrc.getArterialBloodGas());
		// VitalsTakenDateTime
		valueObjectDest.setVitalsTakenDateTime(valueObjectSrc.getVitalsTakenDateTime());
		// SysInfo
		valueObjectDest.setSysInfo(valueObjectSrc.getSysInfo());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createVSABGO2SatsVoCollectionFromVitalSigns(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.vitals.domain.objects.VitalSigns objects.
	 */
	public static ims.core.vo.VSABGO2SatsVoCollection createVSABGO2SatsVoCollectionFromVitalSigns(java.util.Set domainObjectSet)	
	{
		return createVSABGO2SatsVoCollectionFromVitalSigns(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.vitals.domain.objects.VitalSigns objects.
	 */
	public static ims.core.vo.VSABGO2SatsVoCollection createVSABGO2SatsVoCollectionFromVitalSigns(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.core.vo.VSABGO2SatsVoCollection voList = new ims.core.vo.VSABGO2SatsVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.vitals.domain.objects.VitalSigns domainObject = (ims.core.vitals.domain.objects.VitalSigns) iterator.next();
			ims.core.vo.VSABGO2SatsVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.core.vitals.domain.objects.VitalSigns objects.
	 */
	public static ims.core.vo.VSABGO2SatsVoCollection createVSABGO2SatsVoCollectionFromVitalSigns(java.util.List domainObjectList) 
	{
		return createVSABGO2SatsVoCollectionFromVitalSigns(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.vitals.domain.objects.VitalSigns objects.
	 */
	public static ims.core.vo.VSABGO2SatsVoCollection createVSABGO2SatsVoCollectionFromVitalSigns(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.core.vo.VSABGO2SatsVoCollection voList = new ims.core.vo.VSABGO2SatsVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.vitals.domain.objects.VitalSigns domainObject = (ims.core.vitals.domain.objects.VitalSigns) domainObjectList.get(i);
			ims.core.vo.VSABGO2SatsVo vo = create(map, domainObject);

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
	 * Create the ims.core.vitals.domain.objects.VitalSigns set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractVitalSignsSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.VSABGO2SatsVoCollection voCollection) 
	 {
	 	return extractVitalSignsSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractVitalSignsSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.VSABGO2SatsVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.VSABGO2SatsVo vo = voCollection.get(i);
			ims.core.vitals.domain.objects.VitalSigns domainObject = VSABGO2SatsVoAssembler.extractVitalSigns(domainFactory, vo, domMap);

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
	 * Create the ims.core.vitals.domain.objects.VitalSigns list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractVitalSignsList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.VSABGO2SatsVoCollection voCollection) 
	 {
	 	return extractVitalSignsList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractVitalSignsList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.VSABGO2SatsVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.VSABGO2SatsVo vo = voCollection.get(i);
			ims.core.vitals.domain.objects.VitalSigns domainObject = VSABGO2SatsVoAssembler.extractVitalSigns(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.core.vitals.domain.objects.VitalSigns object.
	 * @param domainObject ims.core.vitals.domain.objects.VitalSigns
	 */
	 public static ims.core.vo.VSABGO2SatsVo create(ims.core.vitals.domain.objects.VitalSigns domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.vitals.domain.objects.VitalSigns object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.core.vo.VSABGO2SatsVo create(DomainObjectMap map, ims.core.vitals.domain.objects.VitalSigns domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.core.vo.VSABGO2SatsVo valueObject = (ims.core.vo.VSABGO2SatsVo) map.getValueObject(domainObject, ims.core.vo.VSABGO2SatsVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.core.vo.VSABGO2SatsVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.vitals.domain.objects.VitalSigns
	 */
	 public static ims.core.vo.VSABGO2SatsVo insert(ims.core.vo.VSABGO2SatsVo valueObject, ims.core.vitals.domain.objects.VitalSigns domainObject) 
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
	 * @param domainObject ims.core.vitals.domain.objects.VitalSigns
	 */
	 public static ims.core.vo.VSABGO2SatsVo insert(DomainObjectMap map, ims.core.vo.VSABGO2SatsVo valueObject, ims.core.vitals.domain.objects.VitalSigns domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_VitalSigns(domainObject.getId());
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
			
		// OxygenSaturation
		valueObject.setOxygenSaturation(ims.core.vo.domain.VSOxygenSaturationAssembler.create(map, domainObject.getOxygenSaturation()) );
		// ArterialBloodGas
		valueObject.setArterialBloodGas(ims.core.vo.domain.VSArterialBloodGasAssembler.create(map, domainObject.getArterialBloodGas()) );
		// VitalsTakenDateTime
		java.util.Date VitalsTakenDateTime = domainObject.getVitalsTakenDateTime();
		if ( null != VitalsTakenDateTime ) 
		{
			valueObject.setVitalsTakenDateTime(new ims.framework.utils.DateTime(VitalsTakenDateTime) );
		}
		// SysInfo
		// set system information
		valueObject.setSysInfo(ims.vo.domain.SystemInformationAssembler.create(domainObject.getSystemInformation()));
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.vitals.domain.objects.VitalSigns extractVitalSigns(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.VSABGO2SatsVo valueObject) 
	{
		return 	extractVitalSigns(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.vitals.domain.objects.VitalSigns extractVitalSigns(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.VSABGO2SatsVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_VitalSigns();
		ims.core.vitals.domain.objects.VitalSigns domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.vitals.domain.objects.VitalSigns)domMap.get(valueObject);
			}
			// ims.core.vo.VSABGO2SatsVo ID_VitalSigns field is unknown
			domainObject = new ims.core.vitals.domain.objects.VitalSigns();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_VitalSigns());
			if (domMap.get(key) != null)
			{
				return (ims.core.vitals.domain.objects.VitalSigns)domMap.get(key);
			}
			domainObject = (ims.core.vitals.domain.objects.VitalSigns) domainFactory.getDomainObject(ims.core.vitals.domain.objects.VitalSigns.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_VitalSigns());

		domainObject.setOxygenSaturation(ims.core.vo.domain.VSOxygenSaturationAssembler.extractOxygenSaturation(domainFactory, valueObject.getOxygenSaturation(), domMap));
		domainObject.setArterialBloodGas(ims.core.vo.domain.VSArterialBloodGasAssembler.extractArterialBloodGas(domainFactory, valueObject.getArterialBloodGas(), domMap));
		ims.framework.utils.DateTime dateTime3 = valueObject.getVitalsTakenDateTime();
		java.util.Date value3 = null;
		if ( dateTime3 != null ) 
		{
			value3 = dateTime3.getJavaDate();
		}
		domainObject.setVitalsTakenDateTime(value3);

		return domainObject;
	}

}
