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
 * @author Catalin Tomozei
 */
public class TltSummaryNoteVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.RefMan.vo.TltSummaryNoteVo copy(ims.RefMan.vo.TltSummaryNoteVo valueObjectDest, ims.RefMan.vo.TltSummaryNoteVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_TltSummaryNote(valueObjectSrc.getID_TltSummaryNote());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// SummaryNote
		valueObjectDest.setSummaryNote(valueObjectSrc.getSummaryNote());
		// CatsReferral
		valueObjectDest.setCatsReferral(valueObjectSrc.getCatsReferral());
		// AuthoringInformation
		valueObjectDest.setAuthoringInformation(valueObjectSrc.getAuthoringInformation());
		// RecordingInformation
		valueObjectDest.setRecordingInformation(valueObjectSrc.getRecordingInformation());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createTltSummaryNoteVoCollectionFromTltSummaryNote(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.TltSummaryNote objects.
	 */
	public static ims.RefMan.vo.TltSummaryNoteVoCollection createTltSummaryNoteVoCollectionFromTltSummaryNote(java.util.Set domainObjectSet)	
	{
		return createTltSummaryNoteVoCollectionFromTltSummaryNote(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.TltSummaryNote objects.
	 */
	public static ims.RefMan.vo.TltSummaryNoteVoCollection createTltSummaryNoteVoCollectionFromTltSummaryNote(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.RefMan.vo.TltSummaryNoteVoCollection voList = new ims.RefMan.vo.TltSummaryNoteVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.RefMan.domain.objects.TltSummaryNote domainObject = (ims.RefMan.domain.objects.TltSummaryNote) iterator.next();
			ims.RefMan.vo.TltSummaryNoteVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.RefMan.domain.objects.TltSummaryNote objects.
	 */
	public static ims.RefMan.vo.TltSummaryNoteVoCollection createTltSummaryNoteVoCollectionFromTltSummaryNote(java.util.List domainObjectList) 
	{
		return createTltSummaryNoteVoCollectionFromTltSummaryNote(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.RefMan.domain.objects.TltSummaryNote objects.
	 */
	public static ims.RefMan.vo.TltSummaryNoteVoCollection createTltSummaryNoteVoCollectionFromTltSummaryNote(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.RefMan.vo.TltSummaryNoteVoCollection voList = new ims.RefMan.vo.TltSummaryNoteVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.RefMan.domain.objects.TltSummaryNote domainObject = (ims.RefMan.domain.objects.TltSummaryNote) domainObjectList.get(i);
			ims.RefMan.vo.TltSummaryNoteVo vo = create(map, domainObject);

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
	 * Create the ims.RefMan.domain.objects.TltSummaryNote set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractTltSummaryNoteSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.TltSummaryNoteVoCollection voCollection) 
	 {
	 	return extractTltSummaryNoteSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractTltSummaryNoteSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.TltSummaryNoteVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.TltSummaryNoteVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.TltSummaryNote domainObject = TltSummaryNoteVoAssembler.extractTltSummaryNote(domainFactory, vo, domMap);

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
	 * Create the ims.RefMan.domain.objects.TltSummaryNote list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractTltSummaryNoteList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.TltSummaryNoteVoCollection voCollection) 
	 {
	 	return extractTltSummaryNoteList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractTltSummaryNoteList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.TltSummaryNoteVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.TltSummaryNoteVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.TltSummaryNote domainObject = TltSummaryNoteVoAssembler.extractTltSummaryNote(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.RefMan.domain.objects.TltSummaryNote object.
	 * @param domainObject ims.RefMan.domain.objects.TltSummaryNote
	 */
	 public static ims.RefMan.vo.TltSummaryNoteVo create(ims.RefMan.domain.objects.TltSummaryNote domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.RefMan.domain.objects.TltSummaryNote object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.RefMan.vo.TltSummaryNoteVo create(DomainObjectMap map, ims.RefMan.domain.objects.TltSummaryNote domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.RefMan.vo.TltSummaryNoteVo valueObject = (ims.RefMan.vo.TltSummaryNoteVo) map.getValueObject(domainObject, ims.RefMan.vo.TltSummaryNoteVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.RefMan.vo.TltSummaryNoteVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.RefMan.domain.objects.TltSummaryNote
	 */
	 public static ims.RefMan.vo.TltSummaryNoteVo insert(ims.RefMan.vo.TltSummaryNoteVo valueObject, ims.RefMan.domain.objects.TltSummaryNote domainObject) 
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
	 * @param domainObject ims.RefMan.domain.objects.TltSummaryNote
	 */
	 public static ims.RefMan.vo.TltSummaryNoteVo insert(DomainObjectMap map, ims.RefMan.vo.TltSummaryNoteVo valueObject, ims.RefMan.domain.objects.TltSummaryNote domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_TltSummaryNote(domainObject.getId());
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
			
		// SummaryNote
		valueObject.setSummaryNote(domainObject.getSummaryNote());
		// CatsReferral
		if (domainObject.getCatsReferral() != null)
		{
			if(domainObject.getCatsReferral() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getCatsReferral();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setCatsReferral(new ims.RefMan.vo.CatsReferralRefVo(id, -1));				
			}
			else
			{
				valueObject.setCatsReferral(new ims.RefMan.vo.CatsReferralRefVo(domainObject.getCatsReferral().getId(), domainObject.getCatsReferral().getVersion()));
			}
		}
		// AuthoringInformation
		valueObject.setAuthoringInformation(ims.core.vo.domain.AuthoringInformationVoAssembler.create(map, domainObject.getAuthoringInformation()) );
		// RecordingInformation
		valueObject.setRecordingInformation(ims.core.vo.domain.AuthoringInformationVoAssembler.create(map, domainObject.getRecordingInformation()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.RefMan.domain.objects.TltSummaryNote extractTltSummaryNote(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.TltSummaryNoteVo valueObject) 
	{
		return 	extractTltSummaryNote(domainFactory, valueObject, new HashMap());
	}

	public static ims.RefMan.domain.objects.TltSummaryNote extractTltSummaryNote(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.TltSummaryNoteVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_TltSummaryNote();
		ims.RefMan.domain.objects.TltSummaryNote domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.RefMan.domain.objects.TltSummaryNote)domMap.get(valueObject);
			}
			// ims.RefMan.vo.TltSummaryNoteVo ID_TltSummaryNote field is unknown
			domainObject = new ims.RefMan.domain.objects.TltSummaryNote();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_TltSummaryNote());
			if (domMap.get(key) != null)
			{
				return (ims.RefMan.domain.objects.TltSummaryNote)domMap.get(key);
			}
			domainObject = (ims.RefMan.domain.objects.TltSummaryNote) domainFactory.getDomainObject(ims.RefMan.domain.objects.TltSummaryNote.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_TltSummaryNote());

		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getSummaryNote() != null && valueObject.getSummaryNote().equals(""))
		{
			valueObject.setSummaryNote(null);
		}
		domainObject.setSummaryNote(valueObject.getSummaryNote());
		ims.RefMan.domain.objects.CatsReferral value2 = null;
		if ( null != valueObject.getCatsReferral() ) 
		{
			if (valueObject.getCatsReferral().getBoId() == null)
			{
				if (domMap.get(valueObject.getCatsReferral()) != null)
				{
					value2 = (ims.RefMan.domain.objects.CatsReferral)domMap.get(valueObject.getCatsReferral());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value2 = domainObject.getCatsReferral();	
			}
			else
			{
				value2 = (ims.RefMan.domain.objects.CatsReferral)domainFactory.getDomainObject(ims.RefMan.domain.objects.CatsReferral.class, valueObject.getCatsReferral().getBoId());
			}
		}
		domainObject.setCatsReferral(value2);
		domainObject.setAuthoringInformation(ims.core.vo.domain.AuthoringInformationVoAssembler.extractAuthoringInformation(domainFactory, valueObject.getAuthoringInformation(), domMap));
		domainObject.setRecordingInformation(ims.core.vo.domain.AuthoringInformationVoAssembler.extractAuthoringInformation(domainFactory, valueObject.getRecordingInformation(), domMap));

		return domainObject;
	}

}
