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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.62 build 3019.30328)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.domain.impl;

import ims.admin.vo.AppUserShortVo;
import ims.admin.vo.AppUserShortWithNameVoCollection;
import ims.admin.vo.domain.AppUserShortWithNameVoAssembler;
import ims.core.configuration.vo.AppUserRefVo;
import ims.core.vo.ClinicLiteVo;
import ims.core.vo.ClinicLiteVoCollection;
import ims.core.vo.MedicLiteVo;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.domain.ClinicLiteVoAssembler;
import ims.core.vo.domain.MedicLiteVoAssembler;
import ims.core.vo.lookups.Specialty;
import ims.core.vo.lookups.SpecialtyCollection;
import ims.correspondence.configuration.domain.objects.UserAccess;
import ims.correspondence.domain.base.impl.BaseUserProfileConfigurationImpl;
import ims.correspondence.vo.UserAccessVo;
import ims.correspondence.vo.domain.UserAccessVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.DomainObject;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.domain.lookups.LookupService;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class UserProfileConfigurationImpl extends BaseUserProfileConfigurationImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* Domain function to search users based on criteria that are assembled into a filter VO.
	*/
	public AppUserShortWithNameVoCollection searchUsers(AppUserShortVo filterVo) throws DomainInterfaceException
	{
		if (filterVo == null)
			throw new DomainInterfaceException("Can not search on null user surname");
		
		if (filterVo.getUserRealName() == null || filterVo.getUserRealName().length() == 0)
			throw new DomainInterfaceException("Can not search on null or zero lenght surname");
		
		String[] names = filterVo.getUserRealName().split(" ");
		
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		String query = " from AppUser au ";
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		
		// Build search criteria Forename OR Surname
		{
			if (markers.size() > 0)
				hql.append(" AND (");
			else
				hql.append(" (");
			
			for (int i = 0; i < names.length; i++)
			{
				hql.append("au.mos.name.upperSurname like :SURNAME" + i);
				markers.add("SURNAME" + i);
				values.add("%" + names[i].toUpperCase() + "%");

				hql.append(" OR ");

				hql.append("au.mos.name.upperForename like :FORENAME" + i);
				markers.add("FORENAME" + i);
				values.add("%" + names[i].toUpperCase() + "%");
				
				if (i != names.length - 1)
					hql.append(" OR ");
			}
			hql.append(")");
		}
		
		
		if (markers.size() > 0)
			query += " where ";
		
		query += hql.toString();

		try
		{
			List<DomainObject> results = factory.find(query, markers, values);
			
			// We need to create a AppUserVoCollection because we need the name (if we create AppUserShortVoCollection we do not get the name)
			return AppUserShortWithNameVoAssembler.createAppUserShortWithNameVoCollectionFromAppUser(results);
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public UserAccessVo getUserAccess(AppUserRefVo userID)
	{
		if (userID == null)
			throw new CodingRuntimeException("Can not search on null user");
		
		DomainFactory factory = getDomainFactory();
		return UserAccessVoAssembler.create(UserAccess.getUserAccessFromAppUser(factory, userID.getID_AppUser()));	
	}

	public UserAccessVo saveUserAccess(UserAccessVo voUserAccess) throws StaleObjectException, ForeignKeyViolationException, UniqueKeyViolationException
	{
		if (! voUserAccess.isValidated())
			throw new DomainRuntimeException("UserAccessVo has not been validated");
		
		DomainFactory factory = getDomainFactory();
		
		UserAccess domUserAccess = UserAccessVoAssembler.extractUserAccess(factory, voUserAccess);
		
		try
		{
			factory.save(domUserAccess);
		}
		catch (UnqViolationUncheckedException exception)
		{
			throw new UniqueKeyViolationException("User Profile already exists within the system for this user.", exception);
		}
		
		return UserAccessVoAssembler.create(domUserAccess);
	}

	
	public ClinicLiteVoCollection listClinics(ClinicLiteVo filterVo) throws DomainInterfaceException
	{
		if (filterVo == null)
			throw new DomainInterfaceException("Can not search on null clinic filter");
		
		if (filterVo.getClinicName() == null || filterVo.getClinicName().length() == 0)
			throw new DomainInterfaceException("Can not search on null or zero length clinic name");
		
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		String query = " from Clinic c ";
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		
		// Build search criteria
		{
			if (markers.size() > 0)
				hql.append(" and ");
			
				hql.append("c.upperName like :clinicName");
				markers.add("clinicName");
				values.add("%" + filterVo.getClinicName().toUpperCase() + "%");
				
		}
		
		if (markers.size() > 0)
			query += " where ";
		
		query += hql.toString();
		
		
		try
		{
			List<DomainObject> listClinics;
			listClinics = factory.find(query, markers, values);
			return ClinicLiteVoAssembler.createClinicLiteVoCollectionFromClinic(listClinics);
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	
	public MedicLiteVoCollection listConsultants(MedicLiteVo filterVo) throws DomainInterfaceException
	{
		if (filterVo == null)
			throw new DomainInterfaceException("Can not search on null medic filter");
		
		if (filterVo.getName() == null
				|| (filterVo.getName().getSurname() == null && filterVo.getName().getForename() == null)
				|| (filterVo.getName().getSurname().length() == 0 && filterVo.getName().getForename().length() == 0))
			throw new DomainInterfaceException("Can not search on null or zero length consultant name");

		String[] names;
		
		if (filterVo.getName().getSurnameIsNotNull() && filterVo.getName().getSurname().length() > 0)
			names = filterVo.getName().getSurname().split(" ");
		else
			names = filterVo.getName().getForename().split(" ");
			

		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		String query = " from Medic md ";
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		// Build search criteria
		{
			if (markers.size() > 0)
				hql.append(" AND (");
			else
				hql.append("(");
			
			for (int i = 0; i < names.length; i++)
			{
				hql.append("md.mos.name.upperSurname like :SURNAME" + i);
				markers.add("SURNAME" + i);
				values.add("%" + names[i].toUpperCase() + "%");
				
				hql.append(" OR ");
				
				hql.append("md.mos.name.upperForename like :FORENAME" + i);
				markers.add("FORENAME" + i);
				values.add("%" + names[i].toUpperCase() + "%");
				
				if (i != names.length - 1)
					hql.append(" OR ");
			}

			hql.append(")");
		}
		
		if (markers.size() > 0)
			query += " where ";
		
		query += hql.toString();
		
		try
		{
			List<DomainObject> listMedics;
			listMedics = factory.find(query, markers, values);
			
			return MedicLiteVoAssembler.createMedicLiteVoCollectionFromMedic(listMedics);
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	
	public ArrayList<Specialty> listSpecialty(Specialty filterLookup) throws DomainInterfaceException
	{
		if (filterLookup == null)
			throw new DomainInterfaceException("Can not search on null speciality filter");
		
		ArrayList<Specialty> specialtiesList = new ArrayList<Specialty>();


		ArrayList<String> searchWords = new ArrayList<String>();

		filterLookup.setText(filterLookup.getText().replaceAll(" ", "%"));
		String[] split = filterLookup.getText().split("%");

		for (int i = split.length - 1; i >= 0; i--)
		{
			if (!(split[i].equalsIgnoreCase("")))
				searchWords.add(split[i]);
		}
		

		LookupService lookup = this.getLookupService();
		SpecialtyCollection collection = (SpecialtyCollection) lookup.getLookupCollection(Specialty.TYPE_ID, SpecialtyCollection.class, Specialty.class);
		
		for (int i = 0; i < collection.size(); i++)
		{
			Specialty specialty = collection.get(i);
		
			if (containsText(specialty, searchWords))
				specialtiesList.add(specialty);
		}
		
		return specialtiesList;
	}

	
	private boolean containsText(Specialty specialty, ArrayList<String> searchWords)
	{
		for (int i = 0; i < searchWords.size(); i++)
			if (specialty.getText().toUpperCase().indexOf(searchWords.get(i).toUpperCase()) == -1)
				return false;
		
		return true;
	}
}
