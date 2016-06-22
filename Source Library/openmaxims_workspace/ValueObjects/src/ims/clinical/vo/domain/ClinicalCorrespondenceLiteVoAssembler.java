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
 * @author Rory Fitzpatrick
 */
public class ClinicalCorrespondenceLiteVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.clinical.vo.ClinicalCorrespondenceLiteVo copy(ims.clinical.vo.ClinicalCorrespondenceLiteVo valueObjectDest, ims.clinical.vo.ClinicalCorrespondenceLiteVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ClinicalCorrespondence(valueObjectSrc.getID_ClinicalCorrespondence());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// ClinicalContact
		valueObjectDest.setClinicalContact(valueObjectSrc.getClinicalContact());
		// CareContext
		valueObjectDest.setCareContext(valueObjectSrc.getCareContext());
		// VerifyingHCP
		valueObjectDest.setVerifyingHCP(valueObjectSrc.getVerifyingHCP());
		// VerifyingDateTime
		valueObjectDest.setVerifyingDateTime(valueObjectSrc.getVerifyingDateTime());
		// CurrentStatus
		valueObjectDest.setCurrentStatus(valueObjectSrc.getCurrentStatus());
		// OPDNotes
		valueObjectDest.setOPDNotes(valueObjectSrc.getOPDNotes());
		// hasObjectiveNote
		valueObjectDest.setHasObjectiveNote(valueObjectSrc.getHasObjectiveNote());
		// hasPlanNote
		valueObjectDest.setHasPlanNote(valueObjectSrc.getHasPlanNote());
		// hasInstructionsNote
		valueObjectDest.setHasInstructionsNote(valueObjectSrc.getHasInstructionsNote());
		// InpatientDischargeSummary
		valueObjectDest.setInpatientDischargeSummary(valueObjectSrc.getInpatientDischargeSummary());
		// Type
		valueObjectDest.setType(valueObjectSrc.getType());
		// EpisodeOfCare
		valueObjectDest.setEpisodeOfCare(valueObjectSrc.getEpisodeOfCare());
		// AuthoringInformation
		valueObjectDest.setAuthoringInformation(valueObjectSrc.getAuthoringInformation());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createClinicalCorrespondenceLiteVoCollectionFromClinicalCorrespondence(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.clinical.domain.objects.ClinicalCorrespondence objects.
	 */
	public static ims.clinical.vo.ClinicalCorrespondenceLiteVoCollection createClinicalCorrespondenceLiteVoCollectionFromClinicalCorrespondence(java.util.Set domainObjectSet)	
	{
		return createClinicalCorrespondenceLiteVoCollectionFromClinicalCorrespondence(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.clinical.domain.objects.ClinicalCorrespondence objects.
	 */
	public static ims.clinical.vo.ClinicalCorrespondenceLiteVoCollection createClinicalCorrespondenceLiteVoCollectionFromClinicalCorrespondence(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.clinical.vo.ClinicalCorrespondenceLiteVoCollection voList = new ims.clinical.vo.ClinicalCorrespondenceLiteVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.clinical.domain.objects.ClinicalCorrespondence domainObject = (ims.clinical.domain.objects.ClinicalCorrespondence) iterator.next();
			ims.clinical.vo.ClinicalCorrespondenceLiteVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.clinical.domain.objects.ClinicalCorrespondence objects.
	 */
	public static ims.clinical.vo.ClinicalCorrespondenceLiteVoCollection createClinicalCorrespondenceLiteVoCollectionFromClinicalCorrespondence(java.util.List domainObjectList) 
	{
		return createClinicalCorrespondenceLiteVoCollectionFromClinicalCorrespondence(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.clinical.domain.objects.ClinicalCorrespondence objects.
	 */
	public static ims.clinical.vo.ClinicalCorrespondenceLiteVoCollection createClinicalCorrespondenceLiteVoCollectionFromClinicalCorrespondence(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.clinical.vo.ClinicalCorrespondenceLiteVoCollection voList = new ims.clinical.vo.ClinicalCorrespondenceLiteVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.clinical.domain.objects.ClinicalCorrespondence domainObject = (ims.clinical.domain.objects.ClinicalCorrespondence) domainObjectList.get(i);
			ims.clinical.vo.ClinicalCorrespondenceLiteVo vo = create(map, domainObject);

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
	 * Create the ims.clinical.domain.objects.ClinicalCorrespondence set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractClinicalCorrespondenceSet(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.ClinicalCorrespondenceLiteVoCollection voCollection) 
	 {
	 	return extractClinicalCorrespondenceSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractClinicalCorrespondenceSet(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.ClinicalCorrespondenceLiteVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.clinical.vo.ClinicalCorrespondenceLiteVo vo = voCollection.get(i);
			ims.clinical.domain.objects.ClinicalCorrespondence domainObject = ClinicalCorrespondenceLiteVoAssembler.extractClinicalCorrespondence(domainFactory, vo, domMap);

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
	 * Create the ims.clinical.domain.objects.ClinicalCorrespondence list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractClinicalCorrespondenceList(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.ClinicalCorrespondenceLiteVoCollection voCollection) 
	 {
	 	return extractClinicalCorrespondenceList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractClinicalCorrespondenceList(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.ClinicalCorrespondenceLiteVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.clinical.vo.ClinicalCorrespondenceLiteVo vo = voCollection.get(i);
			ims.clinical.domain.objects.ClinicalCorrespondence domainObject = ClinicalCorrespondenceLiteVoAssembler.extractClinicalCorrespondence(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.clinical.domain.objects.ClinicalCorrespondence object.
	 * @param domainObject ims.clinical.domain.objects.ClinicalCorrespondence
	 */
	 public static ims.clinical.vo.ClinicalCorrespondenceLiteVo create(ims.clinical.domain.objects.ClinicalCorrespondence domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.clinical.domain.objects.ClinicalCorrespondence object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.clinical.vo.ClinicalCorrespondenceLiteVo create(DomainObjectMap map, ims.clinical.domain.objects.ClinicalCorrespondence domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.clinical.vo.ClinicalCorrespondenceLiteVo valueObject = (ims.clinical.vo.ClinicalCorrespondenceLiteVo) map.getValueObject(domainObject, ims.clinical.vo.ClinicalCorrespondenceLiteVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.clinical.vo.ClinicalCorrespondenceLiteVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.clinical.domain.objects.ClinicalCorrespondence
	 */
	 public static ims.clinical.vo.ClinicalCorrespondenceLiteVo insert(ims.clinical.vo.ClinicalCorrespondenceLiteVo valueObject, ims.clinical.domain.objects.ClinicalCorrespondence domainObject) 
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
	 * @param domainObject ims.clinical.domain.objects.ClinicalCorrespondence
	 */
	 public static ims.clinical.vo.ClinicalCorrespondenceLiteVo insert(DomainObjectMap map, ims.clinical.vo.ClinicalCorrespondenceLiteVo valueObject, ims.clinical.domain.objects.ClinicalCorrespondence domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ClinicalCorrespondence(domainObject.getId());
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
			
		// ClinicalContact
		valueObject.setClinicalContact(ims.core.vo.domain.ClinicalContactShortVoAssembler.create(map, domainObject.getClinicalContact()) );
		// CareContext
		valueObject.setCareContext(ims.core.vo.domain.CareContextListVoAssembler.create(map, domainObject.getCareContext()) );
		// VerifyingHCP
		valueObject.setVerifyingHCP(ims.core.vo.domain.HcpLiteVoAssembler.create(map, domainObject.getVerifyingHCP()) );
		// VerifyingDateTime
		java.util.Date VerifyingDateTime = domainObject.getVerifyingDateTime();
		if ( null != VerifyingDateTime ) 
		{
			valueObject.setVerifyingDateTime(new ims.framework.utils.DateTime(VerifyingDateTime) );
		}
		// CurrentStatus
		valueObject.setCurrentStatus(ims.clinical.vo.domain.CorrespondenceStatusVoAssembler.create(map, domainObject.getCurrentStatus()) );
		// OPDNotes
		valueObject.setOPDNotes(ims.clinical.vo.domain.OutpatientNotesOutcomeVoAssembler.create(map, domainObject.getOPDNotes()) );
		// hasObjectiveNote
		valueObject.setHasObjectiveNote( domainObject.isHasObjectiveNote() );
		// hasPlanNote
		valueObject.setHasPlanNote( domainObject.isHasPlanNote() );
		// hasInstructionsNote
		valueObject.setHasInstructionsNote( domainObject.isHasInstructionsNote() );
		// InpatientDischargeSummary
		valueObject.setInpatientDischargeSummary(ims.clinical.vo.domain.InpatientDischargeNoteFollowupVoAssembler.create(map, domainObject.getInpatientDischargeSummary()) );
		// Type
		ims.domain.lookups.LookupInstance instance11 = domainObject.getType();
		if ( null != instance11 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance11.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance11.getImage().getImageId(), instance11.getImage().getImagePath());
			}
			color = instance11.getColor();
			if (color != null) 
				color.getValue();

			ims.clinical.vo.lookups.ClinicalCorrespondenceType voLookup11 = new ims.clinical.vo.lookups.ClinicalCorrespondenceType(instance11.getId(),instance11.getText(), instance11.isActive(), null, img, color);
			ims.clinical.vo.lookups.ClinicalCorrespondenceType parentVoLookup11 = voLookup11;
			ims.domain.lookups.LookupInstance parent11 = instance11.getParent();
			while (parent11 != null)
			{
				if (parent11.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent11.getImage().getImageId(), parent11.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent11.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup11.setParent(new ims.clinical.vo.lookups.ClinicalCorrespondenceType(parent11.getId(),parent11.getText(), parent11.isActive(), null, img, color));
				parentVoLookup11 = parentVoLookup11.getParent();
								parent11 = parent11.getParent();
			}			
			valueObject.setType(voLookup11);
		}
				// EpisodeOfCare
		valueObject.setEpisodeOfCare(ims.core.vo.domain.EpisodeofCareShortVoAssembler.create(map, domainObject.getEpisodeOfCare()) );
		// AuthoringInformation
		valueObject.setAuthoringInformation(ims.core.vo.domain.AuthoringInformationVoAssembler.create(map, domainObject.getAuthoringInformation()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.clinical.domain.objects.ClinicalCorrespondence extractClinicalCorrespondence(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.ClinicalCorrespondenceLiteVo valueObject) 
	{
		return 	extractClinicalCorrespondence(domainFactory, valueObject, new HashMap());
	}

	public static ims.clinical.domain.objects.ClinicalCorrespondence extractClinicalCorrespondence(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.ClinicalCorrespondenceLiteVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ClinicalCorrespondence();
		ims.clinical.domain.objects.ClinicalCorrespondence domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.clinical.domain.objects.ClinicalCorrespondence)domMap.get(valueObject);
			}
			// ims.clinical.vo.ClinicalCorrespondenceLiteVo ID_ClinicalCorrespondence field is unknown
			domainObject = new ims.clinical.domain.objects.ClinicalCorrespondence();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ClinicalCorrespondence());
			if (domMap.get(key) != null)
			{
				return (ims.clinical.domain.objects.ClinicalCorrespondence)domMap.get(key);
			}
			domainObject = (ims.clinical.domain.objects.ClinicalCorrespondence) domainFactory.getDomainObject(ims.clinical.domain.objects.ClinicalCorrespondence.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ClinicalCorrespondence());

	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.admin.domain.objects.ClinicalContact value1 = null;
		if ( null != valueObject.getClinicalContact() ) 
		{
			if (valueObject.getClinicalContact().getBoId() == null)
			{
				if (domMap.get(valueObject.getClinicalContact()) != null)
				{
					value1 = (ims.core.admin.domain.objects.ClinicalContact)domMap.get(valueObject.getClinicalContact());
				}
			}
			else
			{
				value1 = (ims.core.admin.domain.objects.ClinicalContact)domainFactory.getDomainObject(ims.core.admin.domain.objects.ClinicalContact.class, valueObject.getClinicalContact().getBoId());
			}
		}
		domainObject.setClinicalContact(value1);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.admin.domain.objects.CareContext value2 = null;
		if ( null != valueObject.getCareContext() ) 
		{
			if (valueObject.getCareContext().getBoId() == null)
			{
				if (domMap.get(valueObject.getCareContext()) != null)
				{
					value2 = (ims.core.admin.domain.objects.CareContext)domMap.get(valueObject.getCareContext());
				}
			}
			else
			{
				value2 = (ims.core.admin.domain.objects.CareContext)domainFactory.getDomainObject(ims.core.admin.domain.objects.CareContext.class, valueObject.getCareContext().getBoId());
			}
		}
		domainObject.setCareContext(value2);
		domainObject.setVerifyingHCP(ims.core.vo.domain.HcpLiteVoAssembler.extractHcp(domainFactory, valueObject.getVerifyingHCP(), domMap));
		ims.framework.utils.DateTime dateTime4 = valueObject.getVerifyingDateTime();
		java.util.Date value4 = null;
		if ( dateTime4 != null ) 
		{
			value4 = dateTime4.getJavaDate();
		}
		domainObject.setVerifyingDateTime(value4);
		domainObject.setCurrentStatus(ims.clinical.vo.domain.CorrespondenceStatusVoAssembler.extractCorrespondenceStatus(domainFactory, valueObject.getCurrentStatus(), domMap));
		domainObject.setOPDNotes(ims.clinical.vo.domain.OutpatientNotesOutcomeVoAssembler.extractOutpatientNotesOutcome(domainFactory, valueObject.getOPDNotes(), domMap));
		domainObject.setHasObjectiveNote(valueObject.getHasObjectiveNote());
		domainObject.setHasPlanNote(valueObject.getHasPlanNote());
		domainObject.setHasInstructionsNote(valueObject.getHasInstructionsNote());
		domainObject.setInpatientDischargeSummary(ims.clinical.vo.domain.InpatientDischargeNoteFollowupVoAssembler.extractInpatientDischargeNoteFollowup(domainFactory, valueObject.getInpatientDischargeSummary(), domMap));
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value11 = null;
		if ( null != valueObject.getType() ) 
		{
			value11 =
				domainFactory.getLookupInstance(valueObject.getType().getID());
		}
		domainObject.setType(value11);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.admin.domain.objects.EpisodeOfCare value12 = null;
		if ( null != valueObject.getEpisodeOfCare() ) 
		{
			if (valueObject.getEpisodeOfCare().getBoId() == null)
			{
				if (domMap.get(valueObject.getEpisodeOfCare()) != null)
				{
					value12 = (ims.core.admin.domain.objects.EpisodeOfCare)domMap.get(valueObject.getEpisodeOfCare());
				}
			}
			else
			{
				value12 = (ims.core.admin.domain.objects.EpisodeOfCare)domainFactory.getDomainObject(ims.core.admin.domain.objects.EpisodeOfCare.class, valueObject.getEpisodeOfCare().getBoId());
			}
		}
		domainObject.setEpisodeOfCare(value12);
		domainObject.setAuthoringInformation(ims.core.vo.domain.AuthoringInformationVoAssembler.extractAuthoringInformation(domainFactory, valueObject.getAuthoringInformation(), domMap));

		return domainObject;
	}

}
