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
 * @author Michael Noonan
 */
public class CATSReferralRTTManagementVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.RefMan.vo.CATSReferralRTTManagementVo copy(ims.RefMan.vo.CATSReferralRTTManagementVo valueObjectDest, ims.RefMan.vo.CATSReferralRTTManagementVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_CatsReferral(valueObjectSrc.getID_CatsReferral());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// ReferralDetails
		valueObjectDest.setReferralDetails(valueObjectSrc.getReferralDetails());
		// Journey
		valueObjectDest.setJourney(valueObjectSrc.getJourney());
		// current31TargetDate
		valueObjectDest.setCurrent31TargetDate(valueObjectSrc.getCurrent31TargetDate());
		// current62TargetDate
		valueObjectDest.setCurrent62TargetDate(valueObjectSrc.getCurrent62TargetDate());
		// RTTClockImpacts
		valueObjectDest.setRTTClockImpacts(valueObjectSrc.getRTTClockImpacts());
		// PathwayID
		valueObjectDest.setPathwayID(valueObjectSrc.getPathwayID());
		// RTTClockImpact
		valueObjectDest.setRTTClockImpact(valueObjectSrc.getRTTClockImpact());
		// ManuallyMarkedAsNotRTTImpact
		valueObjectDest.setManuallyMarkedAsNotRTTImpact(valueObjectSrc.getManuallyMarkedAsNotRTTImpact());
		// CurrentRTTStatus
		valueObjectDest.setCurrentRTTStatus(valueObjectSrc.getCurrentRTTStatus());
		// Patient
		valueObjectDest.setPatient(valueObjectSrc.getPatient());
		// CurrentStatus
		valueObjectDest.setCurrentStatus(valueObjectSrc.getCurrentStatus());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createCATSReferralRTTManagementVoCollectionFromCatsReferral(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.CatsReferral objects.
	 */
	public static ims.RefMan.vo.CATSReferralRTTManagementVoCollection createCATSReferralRTTManagementVoCollectionFromCatsReferral(java.util.Set domainObjectSet)	
	{
		return createCATSReferralRTTManagementVoCollectionFromCatsReferral(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.CatsReferral objects.
	 */
	public static ims.RefMan.vo.CATSReferralRTTManagementVoCollection createCATSReferralRTTManagementVoCollectionFromCatsReferral(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.RefMan.vo.CATSReferralRTTManagementVoCollection voList = new ims.RefMan.vo.CATSReferralRTTManagementVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.RefMan.domain.objects.CatsReferral domainObject = (ims.RefMan.domain.objects.CatsReferral) iterator.next();
			ims.RefMan.vo.CATSReferralRTTManagementVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.RefMan.domain.objects.CatsReferral objects.
	 */
	public static ims.RefMan.vo.CATSReferralRTTManagementVoCollection createCATSReferralRTTManagementVoCollectionFromCatsReferral(java.util.List domainObjectList) 
	{
		return createCATSReferralRTTManagementVoCollectionFromCatsReferral(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.RefMan.domain.objects.CatsReferral objects.
	 */
	public static ims.RefMan.vo.CATSReferralRTTManagementVoCollection createCATSReferralRTTManagementVoCollectionFromCatsReferral(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.RefMan.vo.CATSReferralRTTManagementVoCollection voList = new ims.RefMan.vo.CATSReferralRTTManagementVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.RefMan.domain.objects.CatsReferral domainObject = (ims.RefMan.domain.objects.CatsReferral) domainObjectList.get(i);
			ims.RefMan.vo.CATSReferralRTTManagementVo vo = create(map, domainObject);

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
	 * Create the ims.RefMan.domain.objects.CatsReferral set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractCatsReferralSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.CATSReferralRTTManagementVoCollection voCollection) 
	 {
	 	return extractCatsReferralSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractCatsReferralSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.CATSReferralRTTManagementVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.CATSReferralRTTManagementVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.CatsReferral domainObject = CATSReferralRTTManagementVoAssembler.extractCatsReferral(domainFactory, vo, domMap);

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
	 * Create the ims.RefMan.domain.objects.CatsReferral list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractCatsReferralList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.CATSReferralRTTManagementVoCollection voCollection) 
	 {
	 	return extractCatsReferralList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractCatsReferralList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.CATSReferralRTTManagementVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.CATSReferralRTTManagementVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.CatsReferral domainObject = CATSReferralRTTManagementVoAssembler.extractCatsReferral(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.RefMan.domain.objects.CatsReferral object.
	 * @param domainObject ims.RefMan.domain.objects.CatsReferral
	 */
	 public static ims.RefMan.vo.CATSReferralRTTManagementVo create(ims.RefMan.domain.objects.CatsReferral domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.RefMan.domain.objects.CatsReferral object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.RefMan.vo.CATSReferralRTTManagementVo create(DomainObjectMap map, ims.RefMan.domain.objects.CatsReferral domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.RefMan.vo.CATSReferralRTTManagementVo valueObject = (ims.RefMan.vo.CATSReferralRTTManagementVo) map.getValueObject(domainObject, ims.RefMan.vo.CATSReferralRTTManagementVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.RefMan.vo.CATSReferralRTTManagementVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.RefMan.domain.objects.CatsReferral
	 */
	 public static ims.RefMan.vo.CATSReferralRTTManagementVo insert(ims.RefMan.vo.CATSReferralRTTManagementVo valueObject, ims.RefMan.domain.objects.CatsReferral domainObject) 
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
	 * @param domainObject ims.RefMan.domain.objects.CatsReferral
	 */
	 public static ims.RefMan.vo.CATSReferralRTTManagementVo insert(DomainObjectMap map, ims.RefMan.vo.CATSReferralRTTManagementVo valueObject, ims.RefMan.domain.objects.CatsReferral domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_CatsReferral(domainObject.getId());
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
			
		// ReferralDetails
		valueObject.setReferralDetails(ims.RefMan.vo.domain.ReferralLetterDetailsLiteVoAssembler.create(map, domainObject.getReferralDetails()) );
		// Journey
		valueObject.setJourney(ims.RefMan.vo.domain.RTTManagementPatientPathwayJourneyVoAssembler.create(map, domainObject.getJourney()) );
		// current31TargetDate
		java.util.Date current31TargetDate = domainObject.getCurrent31TargetDate();
		if ( null != current31TargetDate ) 
		{
			valueObject.setCurrent31TargetDate(new ims.framework.utils.Date(current31TargetDate) );
		}
		// current62TargetDate
		java.util.Date current62TargetDate = domainObject.getCurrent62TargetDate();
		if ( null != current62TargetDate ) 
		{
			valueObject.setCurrent62TargetDate(new ims.framework.utils.Date(current62TargetDate) );
		}
		// RTTClockImpacts
		valueObject.setRTTClockImpacts(ims.pathways.vo.domain.PathwayRTTClockImpactUndoVoAssembler.createPathwayRTTClockImpactUndoVoCollectionFromPathwaysRTTClockImpact(map, domainObject.getRTTClockImpacts()) );
		// PathwayID
		valueObject.setPathwayID(domainObject.getPathwayID());
		// RTTClockImpact
		valueObject.setRTTClockImpact( domainObject.isRTTClockImpact() );
		// ManuallyMarkedAsNotRTTImpact
		valueObject.setManuallyMarkedAsNotRTTImpact( domainObject.isManuallyMarkedAsNotRTTImpact() );
		// CurrentRTTStatus
		valueObject.setCurrentRTTStatus(ims.pathways.vo.domain.PathwayRTTStatusLiteVoAssembler.create(map, domainObject.getCurrentRTTStatus()) );
		// Patient
		if (domainObject.getPatient() != null)
		{
			if(domainObject.getPatient() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getPatient();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setPatient(new ims.core.patient.vo.PatientRefVo(id, -1));				
			}
			else
			{
				valueObject.setPatient(new ims.core.patient.vo.PatientRefVo(domainObject.getPatient().getId(), domainObject.getPatient().getVersion()));
			}
		}
		// CurrentStatus
		valueObject.setCurrentStatus(ims.RefMan.vo.domain.CatsReferralStatusLiteVoAssembler.create(map, domainObject.getCurrentStatus()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.RefMan.domain.objects.CatsReferral extractCatsReferral(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.CATSReferralRTTManagementVo valueObject) 
	{
		return 	extractCatsReferral(domainFactory, valueObject, new HashMap());
	}

	public static ims.RefMan.domain.objects.CatsReferral extractCatsReferral(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.CATSReferralRTTManagementVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_CatsReferral();
		ims.RefMan.domain.objects.CatsReferral domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.RefMan.domain.objects.CatsReferral)domMap.get(valueObject);
			}
			// ims.RefMan.vo.CATSReferralRTTManagementVo ID_CatsReferral field is unknown
			domainObject = new ims.RefMan.domain.objects.CatsReferral();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_CatsReferral());
			if (domMap.get(key) != null)
			{
				return (ims.RefMan.domain.objects.CatsReferral)domMap.get(key);
			}
			domainObject = (ims.RefMan.domain.objects.CatsReferral) domainFactory.getDomainObject(ims.RefMan.domain.objects.CatsReferral.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_CatsReferral());

		domainObject.setReferralDetails(ims.RefMan.vo.domain.ReferralLetterDetailsLiteVoAssembler.extractReferralLetterDetails(domainFactory, valueObject.getReferralDetails(), domMap));
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.pathways.domain.objects.PatientPathwayJourney value2 = null;
		if ( null != valueObject.getJourney() ) 
		{
			if (valueObject.getJourney().getBoId() == null)
			{
				if (domMap.get(valueObject.getJourney()) != null)
				{
					value2 = (ims.pathways.domain.objects.PatientPathwayJourney)domMap.get(valueObject.getJourney());
				}
			}
			else
			{
				value2 = (ims.pathways.domain.objects.PatientPathwayJourney)domainFactory.getDomainObject(ims.pathways.domain.objects.PatientPathwayJourney.class, valueObject.getJourney().getBoId());
			}
		}
		domainObject.setJourney(value2);
		java.util.Date value3 = null;
		ims.framework.utils.Date date3 = valueObject.getCurrent31TargetDate();		
		if ( date3 != null ) 
		{
			value3 = date3.getDate();
		}
		domainObject.setCurrent31TargetDate(value3);
		java.util.Date value4 = null;
		ims.framework.utils.Date date4 = valueObject.getCurrent62TargetDate();		
		if ( date4 != null ) 
		{
			value4 = date4.getDate();
		}
		domainObject.setCurrent62TargetDate(value4);

		// SaveAsRefVO treated as RefValueObject
		ims.pathways.vo.PathwaysRTTClockImpactRefVoCollection refCollection5 = new ims.pathways.vo.PathwaysRTTClockImpactRefVoCollection();
		if (valueObject.getRTTClockImpacts() != null)
		{
			for (int i5=0; i5<valueObject.getRTTClockImpacts().size(); i5++)
			{
				ims.pathways.vo.PathwaysRTTClockImpactRefVo ref5 = (ims.pathways.vo.PathwaysRTTClockImpactRefVo)valueObject.getRTTClockImpacts().get(i5);
				refCollection5.add(ref5);
			}
		}
		int size5 = (null == refCollection5) ? 0 : refCollection5.size();		
		java.util.List domainRTTClockImpacts5 = domainObject.getRTTClockImpacts();
		if (domainRTTClockImpacts5 == null)
		{
			domainRTTClockImpacts5 = new java.util.ArrayList();
		}
		for(int i=0; i < size5; i++) 
		{
			ims.pathways.vo.PathwaysRTTClockImpactRefVo vo = refCollection5.get(i);			
			ims.pathways.domain.objects.PathwaysRTTClockImpact dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.pathways.domain.objects.PathwaysRTTClockImpact)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.pathways.domain.objects.PathwaysRTTClockImpact)domainFactory.getDomainObject( ims.pathways.domain.objects.PathwaysRTTClockImpact.class, vo.getBoId());
				}
			}

			int domIdx = domainRTTClockImpacts5.indexOf(dom);
			if (domIdx == -1)
			{
				domainRTTClockImpacts5.add(i, dom);
			}
			else if (i != domIdx && i < domainRTTClockImpacts5.size())
			{
				Object tmp = domainRTTClockImpacts5.get(i);
				domainRTTClockImpacts5.set(i, domainRTTClockImpacts5.get(domIdx));
				domainRTTClockImpacts5.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i5 = domainRTTClockImpacts5.size();
		while (i5 > size5)
		{
			domainRTTClockImpacts5.remove(i5-1);
			i5 = domainRTTClockImpacts5.size();
		}
		
		domainObject.setRTTClockImpacts(domainRTTClockImpacts5);		
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getPathwayID() != null && valueObject.getPathwayID().equals(""))
		{
			valueObject.setPathwayID(null);
		}
		domainObject.setPathwayID(valueObject.getPathwayID());
		domainObject.setRTTClockImpact(valueObject.getRTTClockImpact());
		domainObject.setManuallyMarkedAsNotRTTImpact(valueObject.getManuallyMarkedAsNotRTTImpact());
		domainObject.setCurrentRTTStatus(ims.pathways.vo.domain.PathwayRTTStatusLiteVoAssembler.extractPathwayRTTStatus(domainFactory, valueObject.getCurrentRTTStatus(), domMap));
		ims.core.patient.domain.objects.Patient value10 = null;
		if ( null != valueObject.getPatient() ) 
		{
			if (valueObject.getPatient().getBoId() == null)
			{
				if (domMap.get(valueObject.getPatient()) != null)
				{
					value10 = (ims.core.patient.domain.objects.Patient)domMap.get(valueObject.getPatient());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value10 = domainObject.getPatient();	
			}
			else
			{
				value10 = (ims.core.patient.domain.objects.Patient)domainFactory.getDomainObject(ims.core.patient.domain.objects.Patient.class, valueObject.getPatient().getBoId());
			}
		}
		domainObject.setPatient(value10);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.RefMan.domain.objects.CATSReferralStatus value11 = null;
		if ( null != valueObject.getCurrentStatus() ) 
		{
			if (valueObject.getCurrentStatus().getBoId() == null)
			{
				if (domMap.get(valueObject.getCurrentStatus()) != null)
				{
					value11 = (ims.RefMan.domain.objects.CATSReferralStatus)domMap.get(valueObject.getCurrentStatus());
				}
			}
			else
			{
				value11 = (ims.RefMan.domain.objects.CATSReferralStatus)domainFactory.getDomainObject(ims.RefMan.domain.objects.CATSReferralStatus.class, valueObject.getCurrentStatus().getBoId());
			}
		}
		domainObject.setCurrentStatus(value11);

		return domainObject;
	}

}
