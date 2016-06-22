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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5214.17710)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.admin.domain.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ims.admin.domain.base.impl.BaseCaseNoteFolderTrackingConfigurationImpl;
import ims.admin.vo.CaseNoteTrackingConfigVo;
import ims.admin.vo.LocationShortVoCollection;
import ims.admin.vo.domain.CaseNoteTrackingConfigVoAssembler;
import ims.admin.vo.domain.LocationShortVoAssembler;
import ims.core.configuration.domain.objects.CaseNoteTrackingConfig;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.framework.exceptions.CodingRuntimeException;

public class CaseNoteFolderTrackingConfigurationImpl extends BaseCaseNoteFolderTrackingConfigurationImpl
{

	private static final long serialVersionUID = 1L;

	public ims.admin.vo.CaseNoteTrackingConfigVo saveCaseNoteTrackingConfig(ims.admin.vo.CaseNoteTrackingConfigVo caseNoteConfigVo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException
	{
		if (caseNoteConfigVo == null)
			throw new CodingRuntimeException(" Cannot save a null CaseNoteTrackingConfigVo object.");
		if (!caseNoteConfigVo.isValidated())
			throw new CodingRuntimeException(" Cannot save CaseNoteTrackingConfigVo object that was not validated.");
		
		DomainFactory factory = getDomainFactory();
		CaseNoteTrackingConfigVo existingRec = getTrackingConfig(caseNoteConfigVo);
			
		if (existingRec != null)
			throw new DomainInterfaceException("An existing Case Note Folder Tracking Configuration record has already been created.");
		
		CaseNoteTrackingConfig caseNoteDO = CaseNoteTrackingConfigVoAssembler.extractCaseNoteTrackingConfig(factory, caseNoteConfigVo);
		
		factory.save(caseNoteDO);
		
		return CaseNoteTrackingConfigVoAssembler.create(caseNoteDO);
	}

	public ims.admin.vo.CaseNoteTrackingConfigVo getTrackingConfig()
	{
		return getTrackingConfig(null);
	}

	private CaseNoteTrackingConfigVo getTrackingConfig(ims.admin.vo.CaseNoteTrackingConfigVo caseNoteConfigVo)
	{
		String hql = "from CaseNoteTrackingConfig as cnconf";
		
		if (caseNoteConfigVo != null && caseNoteConfigVo.getID_CaseNoteTrackingConfig() != null)
		{
			hql += " where cnconf.id <> :REC_ID ";
		}
		
		DomainFactory factory = getDomainFactory();
		
		List<?> results = caseNoteConfigVo != null && caseNoteConfigVo.getID_CaseNoteTrackingConfig() != null ?  factory.find(hql, new String[]{"REC_ID"}, new Object[]{caseNoteConfigVo.getID_CaseNoteTrackingConfig()}) : factory.find(hql);
		
		if (results == null || results.isEmpty())
			return null;
		
		return CaseNoteTrackingConfigVoAssembler.create((CaseNoteTrackingConfig) results.get(0));
	}

	//WDEV-21207
	public LocationShortVoCollection listMedicalRecordLocations(String textTofind) 
	{
			DomainFactory factory = getDomainFactory();
	
			String hql = " from Location loc ";
			StringBuffer condStr = new StringBuffer();
	
			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();
	
		
			condStr.append(" where loc.type = :locType ");
			markers.add("locType");
			values.add(getDomLookup(LocationType.MEDICAL_RECORDS));
			
			condStr.append(" and loc.isActive = :locActive ");
			markers.add("locActive");
			values.add(Boolean.TRUE);
	
			if (textTofind != null)
			{
				condStr.append(" and loc.upperName like :name ");
				markers.add("name");
				values.add("%" + textTofind + "%");
			}

			hql += condStr.toString();
			hql += " ORDER BY loc.upperName";	
			
			return  LocationShortVoAssembler.createLocationShortVoCollectionFromLocation(factory.find(hql, markers, values));
	}
}
