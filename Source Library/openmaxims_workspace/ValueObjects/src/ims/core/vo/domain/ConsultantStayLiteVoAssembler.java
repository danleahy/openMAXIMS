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
 * @author Gabriel Maxim
 */
public class ConsultantStayLiteVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.core.vo.ConsultantStayLiteVo copy(ims.core.vo.ConsultantStayLiteVo valueObjectDest, ims.core.vo.ConsultantStayLiteVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ConsultantStay(valueObjectSrc.getID_ConsultantStay());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// transferDateTime
		valueObjectDest.setTransferDateTime(valueObjectSrc.getTransferDateTime());
		// endDateTime
		valueObjectDest.setEndDateTime(valueObjectSrc.getEndDateTime());
		// Specialty
		valueObjectDest.setSpecialty(valueObjectSrc.getSpecialty());
		// service
		valueObjectDest.setService(valueObjectSrc.getService());
		// PatientStatus
		valueObjectDest.setPatientStatus(valueObjectSrc.getPatientStatus());
		// consultant
		valueObjectDest.setConsultant(valueObjectSrc.getConsultant());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createConsultantStayLiteVoCollectionFromConsultantStay(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.admin.pas.domain.objects.ConsultantStay objects.
	 */
	public static ims.core.vo.ConsultantStayLiteVoCollection createConsultantStayLiteVoCollectionFromConsultantStay(java.util.Set domainObjectSet)	
	{
		return createConsultantStayLiteVoCollectionFromConsultantStay(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.admin.pas.domain.objects.ConsultantStay objects.
	 */
	public static ims.core.vo.ConsultantStayLiteVoCollection createConsultantStayLiteVoCollectionFromConsultantStay(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.core.vo.ConsultantStayLiteVoCollection voList = new ims.core.vo.ConsultantStayLiteVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.admin.pas.domain.objects.ConsultantStay domainObject = (ims.core.admin.pas.domain.objects.ConsultantStay) iterator.next();
			ims.core.vo.ConsultantStayLiteVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.core.admin.pas.domain.objects.ConsultantStay objects.
	 */
	public static ims.core.vo.ConsultantStayLiteVoCollection createConsultantStayLiteVoCollectionFromConsultantStay(java.util.List domainObjectList) 
	{
		return createConsultantStayLiteVoCollectionFromConsultantStay(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.admin.pas.domain.objects.ConsultantStay objects.
	 */
	public static ims.core.vo.ConsultantStayLiteVoCollection createConsultantStayLiteVoCollectionFromConsultantStay(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.core.vo.ConsultantStayLiteVoCollection voList = new ims.core.vo.ConsultantStayLiteVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.admin.pas.domain.objects.ConsultantStay domainObject = (ims.core.admin.pas.domain.objects.ConsultantStay) domainObjectList.get(i);
			ims.core.vo.ConsultantStayLiteVo vo = create(map, domainObject);

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
	 * Create the ims.core.admin.pas.domain.objects.ConsultantStay set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractConsultantStaySet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.ConsultantStayLiteVoCollection voCollection) 
	 {
	 	return extractConsultantStaySet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractConsultantStaySet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.ConsultantStayLiteVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.ConsultantStayLiteVo vo = voCollection.get(i);
			ims.core.admin.pas.domain.objects.ConsultantStay domainObject = ConsultantStayLiteVoAssembler.extractConsultantStay(domainFactory, vo, domMap);

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
	 * Create the ims.core.admin.pas.domain.objects.ConsultantStay list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractConsultantStayList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.ConsultantStayLiteVoCollection voCollection) 
	 {
	 	return extractConsultantStayList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractConsultantStayList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.ConsultantStayLiteVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.ConsultantStayLiteVo vo = voCollection.get(i);
			ims.core.admin.pas.domain.objects.ConsultantStay domainObject = ConsultantStayLiteVoAssembler.extractConsultantStay(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.core.admin.pas.domain.objects.ConsultantStay object.
	 * @param domainObject ims.core.admin.pas.domain.objects.ConsultantStay
	 */
	 public static ims.core.vo.ConsultantStayLiteVo create(ims.core.admin.pas.domain.objects.ConsultantStay domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.admin.pas.domain.objects.ConsultantStay object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.core.vo.ConsultantStayLiteVo create(DomainObjectMap map, ims.core.admin.pas.domain.objects.ConsultantStay domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.core.vo.ConsultantStayLiteVo valueObject = (ims.core.vo.ConsultantStayLiteVo) map.getValueObject(domainObject, ims.core.vo.ConsultantStayLiteVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.core.vo.ConsultantStayLiteVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.admin.pas.domain.objects.ConsultantStay
	 */
	 public static ims.core.vo.ConsultantStayLiteVo insert(ims.core.vo.ConsultantStayLiteVo valueObject, ims.core.admin.pas.domain.objects.ConsultantStay domainObject) 
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
	 * @param domainObject ims.core.admin.pas.domain.objects.ConsultantStay
	 */
	 public static ims.core.vo.ConsultantStayLiteVo insert(DomainObjectMap map, ims.core.vo.ConsultantStayLiteVo valueObject, ims.core.admin.pas.domain.objects.ConsultantStay domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ConsultantStay(domainObject.getId());
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
			
		// transferDateTime
		java.util.Date transferDateTime = domainObject.getTransferDateTime();
		if ( null != transferDateTime ) 
		{
			valueObject.setTransferDateTime(new ims.framework.utils.DateTime(transferDateTime) );
		}
		// endDateTime
		java.util.Date endDateTime = domainObject.getEndDateTime();
		if ( null != endDateTime ) 
		{
			valueObject.setEndDateTime(new ims.framework.utils.DateTime(endDateTime) );
		}
		// Specialty
		ims.domain.lookups.LookupInstance instance3 = domainObject.getSpecialty();
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

			ims.core.vo.lookups.Specialty voLookup3 = new ims.core.vo.lookups.Specialty(instance3.getId(),instance3.getText(), instance3.isActive(), null, img, color);
			ims.core.vo.lookups.Specialty parentVoLookup3 = voLookup3;
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
								parentVoLookup3.setParent(new ims.core.vo.lookups.Specialty(parent3.getId(),parent3.getText(), parent3.isActive(), null, img, color));
				parentVoLookup3 = parentVoLookup3.getParent();
								parent3 = parent3.getParent();
			}			
			valueObject.setSpecialty(voLookup3);
		}
				// service
		valueObject.setService(ims.core.vo.domain.ServiceLiteVoAssembler.create(map, domainObject.getService()) );
		// PatientStatus
		ims.domain.lookups.LookupInstance instance5 = domainObject.getPatientStatus();
		if ( null != instance5 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance5.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance5.getImage().getImageId(), instance5.getImage().getImagePath());
			}
			color = instance5.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.PatientStatus voLookup5 = new ims.core.vo.lookups.PatientStatus(instance5.getId(),instance5.getText(), instance5.isActive(), null, img, color);
			ims.core.vo.lookups.PatientStatus parentVoLookup5 = voLookup5;
			ims.domain.lookups.LookupInstance parent5 = instance5.getParent();
			while (parent5 != null)
			{
				if (parent5.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent5.getImage().getImageId(), parent5.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent5.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup5.setParent(new ims.core.vo.lookups.PatientStatus(parent5.getId(),parent5.getText(), parent5.isActive(), null, img, color));
				parentVoLookup5 = parentVoLookup5.getParent();
								parent5 = parent5.getParent();
			}			
			valueObject.setPatientStatus(voLookup5);
		}
				// consultant
		valueObject.setConsultant(ims.core.vo.domain.MedicVoAssembler.create(map, domainObject.getConsultant()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.admin.pas.domain.objects.ConsultantStay extractConsultantStay(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.ConsultantStayLiteVo valueObject) 
	{
		return 	extractConsultantStay(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.admin.pas.domain.objects.ConsultantStay extractConsultantStay(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.ConsultantStayLiteVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ConsultantStay();
		ims.core.admin.pas.domain.objects.ConsultantStay domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.admin.pas.domain.objects.ConsultantStay)domMap.get(valueObject);
			}
			// ims.core.vo.ConsultantStayLiteVo ID_ConsultantStay field is unknown
			domainObject = new ims.core.admin.pas.domain.objects.ConsultantStay();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ConsultantStay());
			if (domMap.get(key) != null)
			{
				return (ims.core.admin.pas.domain.objects.ConsultantStay)domMap.get(key);
			}
			domainObject = (ims.core.admin.pas.domain.objects.ConsultantStay) domainFactory.getDomainObject(ims.core.admin.pas.domain.objects.ConsultantStay.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ConsultantStay());

		ims.framework.utils.DateTime dateTime1 = valueObject.getTransferDateTime();
		java.util.Date value1 = null;
		if ( dateTime1 != null ) 
		{
			value1 = dateTime1.getJavaDate();
		}
		domainObject.setTransferDateTime(value1);
		ims.framework.utils.DateTime dateTime2 = valueObject.getEndDateTime();
		java.util.Date value2 = null;
		if ( dateTime2 != null ) 
		{
			value2 = dateTime2.getJavaDate();
		}
		domainObject.setEndDateTime(value2);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value3 = null;
		if ( null != valueObject.getSpecialty() ) 
		{
			value3 =
				domainFactory.getLookupInstance(valueObject.getSpecialty().getID());
		}
		domainObject.setSpecialty(value3);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.clinical.domain.objects.Service value4 = null;
		if ( null != valueObject.getService() ) 
		{
			if (valueObject.getService().getBoId() == null)
			{
				if (domMap.get(valueObject.getService()) != null)
				{
					value4 = (ims.core.clinical.domain.objects.Service)domMap.get(valueObject.getService());
				}
			}
			else
			{
				value4 = (ims.core.clinical.domain.objects.Service)domainFactory.getDomainObject(ims.core.clinical.domain.objects.Service.class, valueObject.getService().getBoId());
			}
		}
		domainObject.setService(value4);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value5 = null;
		if ( null != valueObject.getPatientStatus() ) 
		{
			value5 =
				domainFactory.getLookupInstance(valueObject.getPatientStatus().getID());
		}
		domainObject.setPatientStatus(value5);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.people.domain.objects.Medic value6 = null;
		if ( null != valueObject.getConsultant() ) 
		{
			if (valueObject.getConsultant().getBoId() == null)
			{
				if (domMap.get(valueObject.getConsultant()) != null)
				{
					value6 = (ims.core.resource.people.domain.objects.Medic)domMap.get(valueObject.getConsultant());
				}
			}
			else
			{
				value6 = (ims.core.resource.people.domain.objects.Medic)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.Medic.class, valueObject.getConsultant().getBoId());
			}
		}
		domainObject.setConsultant(value6);

		return domainObject;
	}

}
