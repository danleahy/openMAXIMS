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
package ims.admin.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Catalin Tomozei
 */
public class AppFormListVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.admin.vo.AppFormListVo copy(ims.admin.vo.AppFormListVo valueObjectDest, ims.admin.vo.AppFormListVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_AppForm(valueObjectSrc.getID_AppForm());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Lookups
		valueObjectDest.setLookups(valueObjectSrc.getLookups());
		// CodeMappings
		valueObjectDest.setCodeMappings(valueObjectSrc.getCodeMappings());
		// CanBeInNavigation
		valueObjectDest.setCanBeInNavigation(valueObjectSrc.getCanBeInNavigation());
		// CanBeInTopButtons
		valueObjectDest.setCanBeInTopButtons(valueObjectSrc.getCanBeInTopButtons());
		// LogicClass
		valueObjectDest.setLogicClass(valueObjectSrc.getLogicClass());
		// AccessClass
		valueObjectDest.setAccessClass(valueObjectSrc.getAccessClass());
		// DomainImpl
		valueObjectDest.setDomainImpl(valueObjectSrc.getDomainImpl());
		// HelpLink
		valueObjectDest.setHelpLink(valueObjectSrc.getHelpLink());
		// rieBoClassName
		valueObjectDest.setRieBoClassName(valueObjectSrc.getRieBoClassName());
		// namespace
		valueObjectDest.setNamespace(valueObjectSrc.getNamespace());
		// IsSystem
		valueObjectDest.setIsSystem(valueObjectSrc.getIsSystem());
		// InformationBarVisible
		valueObjectDest.setInformationBarVisible(valueObjectSrc.getInformationBarVisible());
		// Image
		valueObjectDest.setImage(valueObjectSrc.getImage());
		// Name
		valueObjectDest.setName(valueObjectSrc.getName());
		// AliasName
		valueObjectDest.setAliasName(valueObjectSrc.getAliasName());
		// Caption
		valueObjectDest.setCaption(valueObjectSrc.getCaption());
		// IsDialog
		valueObjectDest.setIsDialog(valueObjectSrc.getIsDialog());
		// IsAlias
		valueObjectDest.setIsAlias(valueObjectSrc.getIsAlias());
		// IsComponent
		valueObjectDest.setIsComponent(valueObjectSrc.getIsComponent());
		// Description
		valueObjectDest.setDescription(valueObjectSrc.getDescription());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createAppFormListVoCollectionFromAppForm(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.configuration.domain.objects.AppForm objects.
	 */
	public static ims.admin.vo.AppFormListVoCollection createAppFormListVoCollectionFromAppForm(java.util.Set domainObjectSet)	
	{
		return createAppFormListVoCollectionFromAppForm(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.configuration.domain.objects.AppForm objects.
	 */
	public static ims.admin.vo.AppFormListVoCollection createAppFormListVoCollectionFromAppForm(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.admin.vo.AppFormListVoCollection voList = new ims.admin.vo.AppFormListVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.configuration.domain.objects.AppForm domainObject = (ims.core.configuration.domain.objects.AppForm) iterator.next();
			ims.admin.vo.AppFormListVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.core.configuration.domain.objects.AppForm objects.
	 */
	public static ims.admin.vo.AppFormListVoCollection createAppFormListVoCollectionFromAppForm(java.util.List domainObjectList) 
	{
		return createAppFormListVoCollectionFromAppForm(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.configuration.domain.objects.AppForm objects.
	 */
	public static ims.admin.vo.AppFormListVoCollection createAppFormListVoCollectionFromAppForm(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.admin.vo.AppFormListVoCollection voList = new ims.admin.vo.AppFormListVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.configuration.domain.objects.AppForm domainObject = (ims.core.configuration.domain.objects.AppForm) domainObjectList.get(i);
			ims.admin.vo.AppFormListVo vo = create(map, domainObject);

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
	 * Create the ims.core.configuration.domain.objects.AppForm set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractAppFormSet(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.AppFormListVoCollection voCollection) 
	 {
	 	return extractAppFormSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractAppFormSet(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.AppFormListVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.admin.vo.AppFormListVo vo = voCollection.get(i);
			ims.core.configuration.domain.objects.AppForm domainObject = AppFormListVoAssembler.extractAppForm(domainFactory, vo, domMap);

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
	 * Create the ims.core.configuration.domain.objects.AppForm list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractAppFormList(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.AppFormListVoCollection voCollection) 
	 {
	 	return extractAppFormList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractAppFormList(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.AppFormListVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.admin.vo.AppFormListVo vo = voCollection.get(i);
			ims.core.configuration.domain.objects.AppForm domainObject = AppFormListVoAssembler.extractAppForm(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.core.configuration.domain.objects.AppForm object.
	 * @param domainObject ims.core.configuration.domain.objects.AppForm
	 */
	 public static ims.admin.vo.AppFormListVo create(ims.core.configuration.domain.objects.AppForm domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.configuration.domain.objects.AppForm object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.admin.vo.AppFormListVo create(DomainObjectMap map, ims.core.configuration.domain.objects.AppForm domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.admin.vo.AppFormListVo valueObject = (ims.admin.vo.AppFormListVo) map.getValueObject(domainObject, ims.admin.vo.AppFormListVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.admin.vo.AppFormListVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.configuration.domain.objects.AppForm
	 */
	 public static ims.admin.vo.AppFormListVo insert(ims.admin.vo.AppFormListVo valueObject, ims.core.configuration.domain.objects.AppForm domainObject) 
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
	 * @param domainObject ims.core.configuration.domain.objects.AppForm
	 */
	 public static ims.admin.vo.AppFormListVo insert(DomainObjectMap map, ims.admin.vo.AppFormListVo valueObject, ims.core.configuration.domain.objects.AppForm domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_AppForm(domainObject.getId());
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
			
		// Lookups
		valueObject.setLookups(ims.admin.vo.domain.FormLookupVoAssembler.createFormLookupVoCollectionFromAppFormLookup(map, domainObject.getLookups()) );
		// CodeMappings
		valueObject.setCodeMappings(ims.core.vo.domain.TaxonomyMapAssembler.createTaxonomyMapCollectionFromTaxonomyMap(map, domainObject.getCodeMappings()) );
		// CanBeInNavigation
		valueObject.setCanBeInNavigation( domainObject.isCanBeInNavigation() );
		// CanBeInTopButtons
		valueObject.setCanBeInTopButtons( domainObject.isCanBeInTopButtons() );
		// LogicClass
		valueObject.setLogicClass(domainObject.getLogicClass());
		// AccessClass
		valueObject.setAccessClass(domainObject.getAccessClass());
		// DomainImpl
		valueObject.setDomainImpl(domainObject.getDomainClass());
		// HelpLink
		valueObject.setHelpLink(domainObject.getHelpLink());
		// rieBoClassName
		valueObject.setRieBoClassName(domainObject.getRieBoClassName());
		// namespace
		valueObject.setNamespace(ims.admin.vo.domain.AppNamespaceAssembler.create(map, domainObject.getNamespace()) );
		// IsSystem
		valueObject.setIsSystem( domainObject.isIsSystem() );
		// InformationBarVisible
		valueObject.setInformationBarVisible( domainObject.isInformationBarVisible() );
		// Image
		valueObject.setImage(ims.admin.vo.domain.AppImageVoAssembler.create(map, domainObject.getImage()) );
		// Name
		valueObject.setName(domainObject.getName());
		// AliasName
		valueObject.setAliasName(domainObject.getAliasName());
		// Caption
		valueObject.setCaption(domainObject.getCaption());
		// IsDialog
		valueObject.setIsDialog( domainObject.isIsDialog() );
		// IsAlias
		valueObject.setIsAlias( domainObject.isIsAlias() );
		// IsComponent
		valueObject.setIsComponent( domainObject.isIsComponent() );
		// Description
		valueObject.setDescription(domainObject.getDescription());
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.configuration.domain.objects.AppForm extractAppForm(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.AppFormListVo valueObject) 
	{
		return 	extractAppForm(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.configuration.domain.objects.AppForm extractAppForm(ims.domain.ILightweightDomainFactory domainFactory, ims.admin.vo.AppFormListVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_AppForm();
		ims.core.configuration.domain.objects.AppForm domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.configuration.domain.objects.AppForm)domMap.get(valueObject);
			}
			// ims.admin.vo.AppFormListVo ID_AppForm field is unknown
			domainObject = new ims.core.configuration.domain.objects.AppForm();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_AppForm());
			if (domMap.get(key) != null)
			{
				return (ims.core.configuration.domain.objects.AppForm)domMap.get(key);
			}
			domainObject = (ims.core.configuration.domain.objects.AppForm) domainFactory.getDomainObject(ims.core.configuration.domain.objects.AppForm.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_AppForm());

		domainObject.setLookups(ims.admin.vo.domain.FormLookupVoAssembler.extractAppFormLookupList(domainFactory, valueObject.getLookups(), domainObject.getLookups(), domMap));		
		domainObject.setCodeMappings(ims.core.vo.domain.TaxonomyMapAssembler.extractTaxonomyMapList(domainFactory, valueObject.getCodeMappings(), domainObject.getCodeMappings(), domMap));		
		domainObject.setCanBeInNavigation(valueObject.getCanBeInNavigation());
		domainObject.setCanBeInTopButtons(valueObject.getCanBeInTopButtons());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getLogicClass() != null && valueObject.getLogicClass().equals(""))
		{
			valueObject.setLogicClass(null);
		}
		domainObject.setLogicClass(valueObject.getLogicClass());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getAccessClass() != null && valueObject.getAccessClass().equals(""))
		{
			valueObject.setAccessClass(null);
		}
		domainObject.setAccessClass(valueObject.getAccessClass());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getDomainImpl() != null && valueObject.getDomainImpl().equals(""))
		{
			valueObject.setDomainImpl(null);
		}
		domainObject.setDomainClass(valueObject.getDomainImpl());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getHelpLink() != null && valueObject.getHelpLink().equals(""))
		{
			valueObject.setHelpLink(null);
		}
		domainObject.setHelpLink(valueObject.getHelpLink());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getRieBoClassName() != null && valueObject.getRieBoClassName().equals(""))
		{
			valueObject.setRieBoClassName(null);
		}
		domainObject.setRieBoClassName(valueObject.getRieBoClassName());
		domainObject.setNamespace(ims.admin.vo.domain.AppNamespaceAssembler.extractAppNameSpace(domainFactory, valueObject.getNamespace(), domMap));
		domainObject.setIsSystem(valueObject.getIsSystem());
		domainObject.setInformationBarVisible(valueObject.getInformationBarVisible());
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.configuration.domain.objects.AppImage value13 = null;
		if ( null != valueObject.getImage() ) 
		{
			if (valueObject.getImage().getBoId() == null)
			{
				if (domMap.get(valueObject.getImage()) != null)
				{
					value13 = (ims.core.configuration.domain.objects.AppImage)domMap.get(valueObject.getImage());
				}
			}
			else
			{
				value13 = (ims.core.configuration.domain.objects.AppImage)domainFactory.getDomainObject(ims.core.configuration.domain.objects.AppImage.class, valueObject.getImage().getBoId());
			}
		}
		domainObject.setImage(value13);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getName() != null && valueObject.getName().equals(""))
		{
			valueObject.setName(null);
		}
		domainObject.setName(valueObject.getName());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getAliasName() != null && valueObject.getAliasName().equals(""))
		{
			valueObject.setAliasName(null);
		}
		domainObject.setAliasName(valueObject.getAliasName());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getCaption() != null && valueObject.getCaption().equals(""))
		{
			valueObject.setCaption(null);
		}
		domainObject.setCaption(valueObject.getCaption());
		domainObject.setIsDialog(valueObject.getIsDialog());
		domainObject.setIsAlias(valueObject.getIsAlias());
		domainObject.setIsComponent(valueObject.getIsComponent());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getDescription() != null && valueObject.getDescription().equals(""))
		{
			valueObject.setDescription(null);
		}
		domainObject.setDescription(valueObject.getDescription());

		return domainObject;
	}

}
