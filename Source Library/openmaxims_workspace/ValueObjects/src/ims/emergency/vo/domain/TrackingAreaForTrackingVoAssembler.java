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
package ims.emergency.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Cristian Belciug
 */
public class TrackingAreaForTrackingVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.emergency.vo.TrackingAreaForTrackingVo copy(ims.emergency.vo.TrackingAreaForTrackingVo valueObjectDest, ims.emergency.vo.TrackingAreaForTrackingVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_TrackingArea(valueObjectSrc.getID_TrackingArea());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Columns
		valueObjectDest.setColumns(valueObjectSrc.getColumns());
		// PatientRefreshRate
		valueObjectDest.setPatientRefreshRate(valueObjectSrc.getPatientRefreshRate());
		// EDLocation
		valueObjectDest.setEDLocation(valueObjectSrc.getEDLocation());
		// AreaNameDescription
		valueObjectDest.setAreaNameDescription(valueObjectSrc.getAreaNameDescription());
		// AreaDisplayName
		valueObjectDest.setAreaDisplayName(valueObjectSrc.getAreaDisplayName());
		// Status
		valueObjectDest.setStatus(valueObjectSrc.getStatus());
		// isOverallView
		valueObjectDest.setIsOverallView(valueObjectSrc.getIsOverallView());
		// isRegistrationArea
		valueObjectDest.setIsRegistrationArea(valueObjectSrc.getIsRegistrationArea());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createTrackingAreaForTrackingVoCollectionFromTrackingArea(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.emergency.configuration.domain.objects.TrackingArea objects.
	 */
	public static ims.emergency.vo.TrackingAreaForTrackingVoCollection createTrackingAreaForTrackingVoCollectionFromTrackingArea(java.util.Set domainObjectSet)	
	{
		return createTrackingAreaForTrackingVoCollectionFromTrackingArea(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.emergency.configuration.domain.objects.TrackingArea objects.
	 */
	public static ims.emergency.vo.TrackingAreaForTrackingVoCollection createTrackingAreaForTrackingVoCollectionFromTrackingArea(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.emergency.vo.TrackingAreaForTrackingVoCollection voList = new ims.emergency.vo.TrackingAreaForTrackingVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.emergency.configuration.domain.objects.TrackingArea domainObject = (ims.emergency.configuration.domain.objects.TrackingArea) iterator.next();
			ims.emergency.vo.TrackingAreaForTrackingVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.emergency.configuration.domain.objects.TrackingArea objects.
	 */
	public static ims.emergency.vo.TrackingAreaForTrackingVoCollection createTrackingAreaForTrackingVoCollectionFromTrackingArea(java.util.List domainObjectList) 
	{
		return createTrackingAreaForTrackingVoCollectionFromTrackingArea(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.emergency.configuration.domain.objects.TrackingArea objects.
	 */
	public static ims.emergency.vo.TrackingAreaForTrackingVoCollection createTrackingAreaForTrackingVoCollectionFromTrackingArea(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.emergency.vo.TrackingAreaForTrackingVoCollection voList = new ims.emergency.vo.TrackingAreaForTrackingVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.emergency.configuration.domain.objects.TrackingArea domainObject = (ims.emergency.configuration.domain.objects.TrackingArea) domainObjectList.get(i);
			ims.emergency.vo.TrackingAreaForTrackingVo vo = create(map, domainObject);

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
	 * Create the ims.emergency.configuration.domain.objects.TrackingArea set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractTrackingAreaSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TrackingAreaForTrackingVoCollection voCollection) 
	 {
	 	return extractTrackingAreaSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractTrackingAreaSet(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TrackingAreaForTrackingVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.TrackingAreaForTrackingVo vo = voCollection.get(i);
			ims.emergency.configuration.domain.objects.TrackingArea domainObject = TrackingAreaForTrackingVoAssembler.extractTrackingArea(domainFactory, vo, domMap);

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
	 * Create the ims.emergency.configuration.domain.objects.TrackingArea list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractTrackingAreaList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TrackingAreaForTrackingVoCollection voCollection) 
	 {
	 	return extractTrackingAreaList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractTrackingAreaList(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TrackingAreaForTrackingVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.emergency.vo.TrackingAreaForTrackingVo vo = voCollection.get(i);
			ims.emergency.configuration.domain.objects.TrackingArea domainObject = TrackingAreaForTrackingVoAssembler.extractTrackingArea(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.emergency.configuration.domain.objects.TrackingArea object.
	 * @param domainObject ims.emergency.configuration.domain.objects.TrackingArea
	 */
	 public static ims.emergency.vo.TrackingAreaForTrackingVo create(ims.emergency.configuration.domain.objects.TrackingArea domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.emergency.configuration.domain.objects.TrackingArea object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.emergency.vo.TrackingAreaForTrackingVo create(DomainObjectMap map, ims.emergency.configuration.domain.objects.TrackingArea domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.emergency.vo.TrackingAreaForTrackingVo valueObject = (ims.emergency.vo.TrackingAreaForTrackingVo) map.getValueObject(domainObject, ims.emergency.vo.TrackingAreaForTrackingVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.emergency.vo.TrackingAreaForTrackingVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.emergency.configuration.domain.objects.TrackingArea
	 */
	 public static ims.emergency.vo.TrackingAreaForTrackingVo insert(ims.emergency.vo.TrackingAreaForTrackingVo valueObject, ims.emergency.configuration.domain.objects.TrackingArea domainObject) 
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
	 * @param domainObject ims.emergency.configuration.domain.objects.TrackingArea
	 */
	 public static ims.emergency.vo.TrackingAreaForTrackingVo insert(DomainObjectMap map, ims.emergency.vo.TrackingAreaForTrackingVo valueObject, ims.emergency.configuration.domain.objects.TrackingArea domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_TrackingArea(domainObject.getId());
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
			
		// Columns
		valueObject.setColumns(ims.emergency.vo.domain.ColumnDetailVoAssembler.createColumnDetailVoCollectionFromColumnDetail(map, domainObject.getColumns()) );
		// PatientRefreshRate
		valueObject.setPatientRefreshRate(domainObject.getPatientRefreshRate());
		// EDLocation
		if (domainObject.getEDLocation() != null)
		{
			if(domainObject.getEDLocation() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getEDLocation();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setEDLocation(new ims.core.resource.place.vo.LocationRefVo(id, -1));				
			}
			else
			{
				valueObject.setEDLocation(new ims.core.resource.place.vo.LocationRefVo(domainObject.getEDLocation().getId(), domainObject.getEDLocation().getVersion()));
			}
		}
		// AreaNameDescription
		valueObject.setAreaNameDescription(domainObject.getAreaNameDescription());
		// AreaDisplayName
		valueObject.setAreaDisplayName(domainObject.getAreaDisplayName());
		// Status
		ims.domain.lookups.LookupInstance instance6 = domainObject.getStatus();
		if ( null != instance6 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance6.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance6.getImage().getImageId(), instance6.getImage().getImagePath());
			}
			color = instance6.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.PreActiveActiveInactiveStatus voLookup6 = new ims.core.vo.lookups.PreActiveActiveInactiveStatus(instance6.getId(),instance6.getText(), instance6.isActive(), null, img, color);
			ims.core.vo.lookups.PreActiveActiveInactiveStatus parentVoLookup6 = voLookup6;
			ims.domain.lookups.LookupInstance parent6 = instance6.getParent();
			while (parent6 != null)
			{
				if (parent6.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent6.getImage().getImageId(), parent6.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent6.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup6.setParent(new ims.core.vo.lookups.PreActiveActiveInactiveStatus(parent6.getId(),parent6.getText(), parent6.isActive(), null, img, color));
				parentVoLookup6 = parentVoLookup6.getParent();
								parent6 = parent6.getParent();
			}			
			valueObject.setStatus(voLookup6);
		}
				// isOverallView
		valueObject.setIsOverallView( domainObject.isIsOverallView() );
		// isRegistrationArea
		valueObject.setIsRegistrationArea( domainObject.isIsRegistrationArea() );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.emergency.configuration.domain.objects.TrackingArea extractTrackingArea(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TrackingAreaForTrackingVo valueObject) 
	{
		return 	extractTrackingArea(domainFactory, valueObject, new HashMap());
	}

	public static ims.emergency.configuration.domain.objects.TrackingArea extractTrackingArea(ims.domain.ILightweightDomainFactory domainFactory, ims.emergency.vo.TrackingAreaForTrackingVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_TrackingArea();
		ims.emergency.configuration.domain.objects.TrackingArea domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.emergency.configuration.domain.objects.TrackingArea)domMap.get(valueObject);
			}
			// ims.emergency.vo.TrackingAreaForTrackingVo ID_TrackingArea field is unknown
			domainObject = new ims.emergency.configuration.domain.objects.TrackingArea();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_TrackingArea());
			if (domMap.get(key) != null)
			{
				return (ims.emergency.configuration.domain.objects.TrackingArea)domMap.get(key);
			}
			domainObject = (ims.emergency.configuration.domain.objects.TrackingArea) domainFactory.getDomainObject(ims.emergency.configuration.domain.objects.TrackingArea.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_TrackingArea());


		// SaveAsRefVO treated as RefValueObject
		ims.emergency.configuration.vo.ColumnDetailRefVoCollection refCollection1 = new ims.emergency.configuration.vo.ColumnDetailRefVoCollection();
		if (valueObject.getColumns() != null)
		{
			for (int i1=0; i1<valueObject.getColumns().size(); i1++)
			{
				ims.emergency.configuration.vo.ColumnDetailRefVo ref1 = (ims.emergency.configuration.vo.ColumnDetailRefVo)valueObject.getColumns().get(i1);
				refCollection1.add(ref1);
			}
		}
		int size1 = (null == refCollection1) ? 0 : refCollection1.size();		
		java.util.List domainColumns1 = domainObject.getColumns();
		if (domainColumns1 == null)
		{
			domainColumns1 = new java.util.ArrayList();
		}
		for(int i=0; i < size1; i++) 
		{
			ims.emergency.configuration.vo.ColumnDetailRefVo vo = refCollection1.get(i);			
			ims.emergency.configuration.domain.objects.ColumnDetail dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.emergency.configuration.domain.objects.ColumnDetail)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.emergency.configuration.domain.objects.ColumnDetail)domainFactory.getDomainObject( ims.emergency.configuration.domain.objects.ColumnDetail.class, vo.getBoId());
				}
			}

			int domIdx = domainColumns1.indexOf(dom);
			if (domIdx == -1)
			{
				domainColumns1.add(i, dom);
			}
			else if (i != domIdx && i < domainColumns1.size())
			{
				Object tmp = domainColumns1.get(i);
				domainColumns1.set(i, domainColumns1.get(domIdx));
				domainColumns1.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1 = domainColumns1.size();
		while (i1 > size1)
		{
			domainColumns1.remove(i1-1);
			i1 = domainColumns1.size();
		}
		
		domainObject.setColumns(domainColumns1);		
		domainObject.setPatientRefreshRate(valueObject.getPatientRefreshRate());
		ims.core.resource.place.domain.objects.Location value3 = null;
		if ( null != valueObject.getEDLocation() ) 
		{
			if (valueObject.getEDLocation().getBoId() == null)
			{
				if (domMap.get(valueObject.getEDLocation()) != null)
				{
					value3 = (ims.core.resource.place.domain.objects.Location)domMap.get(valueObject.getEDLocation());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value3 = domainObject.getEDLocation();	
			}
			else
			{
				value3 = (ims.core.resource.place.domain.objects.Location)domainFactory.getDomainObject(ims.core.resource.place.domain.objects.Location.class, valueObject.getEDLocation().getBoId());
			}
		}
		domainObject.setEDLocation(value3);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getAreaNameDescription() != null && valueObject.getAreaNameDescription().equals(""))
		{
			valueObject.setAreaNameDescription(null);
		}
		domainObject.setAreaNameDescription(valueObject.getAreaNameDescription());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getAreaDisplayName() != null && valueObject.getAreaDisplayName().equals(""))
		{
			valueObject.setAreaDisplayName(null);
		}
		domainObject.setAreaDisplayName(valueObject.getAreaDisplayName());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value6 = null;
		if ( null != valueObject.getStatus() ) 
		{
			value6 =
				domainFactory.getLookupInstance(valueObject.getStatus().getID());
		}
		domainObject.setStatus(value6);
		domainObject.setIsOverallView(valueObject.getIsOverallView());
		domainObject.setIsRegistrationArea(valueObject.getIsRegistrationArea());

		return domainObject;
	}

}
