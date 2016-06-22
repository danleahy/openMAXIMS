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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.25 build 1935.23909)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.domain.impl;

import ims.admin.vo.AppUserShortVoCollection;
import ims.admin.vo.AppUserShortVo;
import ims.core.resource.place.domain.objects.Clinic;
import ims.core.vo.ClinicLiteVoCollection;
import ims.core.vo.ClinicVoCollection;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.MemberOfStaffShortVoCollection;
import ims.core.vo.domain.ClinicLiteVoAssembler;
import ims.core.vo.domain.ClinicVoAssembler;
import ims.core.vo.lookups.Specialty;
import ims.core.vo.lookups.SpecialtyCollection;
import ims.admin.domain.ApplicationUsers;
import ims.admin.domain.MosAdmin;
import ims.admin.domain.impl.ApplicationUsersImpl;
import ims.admin.domain.impl.MosAdminImpl;
import ims.correspondence.configuration.domain.objects.UserAccess;
import ims.correspondence.helper.SpecifierAdapter;
import ims.correspondence.vo.domain.UserAccessFullVoAssembler;
import ims.correspondence.vo.domain.UserAccessVoAssembler;
import ims.correspondence.vo.lookups.ProfileType;
import ims.correspondence.vo.UserAccessFullVo;
import ims.correspondence.vo.UserAccessVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.domain.impl.DomainImpl;
import ims.domain.lookups.LookupService;
import ims.framework.exceptions.CodingRuntimeException;
import ims.vo.interfaces.ICspTypeSpecifier;

public class UserProfileImpl extends DomainImpl implements ims.correspondence.domain.UserProfile, ims.domain.impl.Transactional
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/* (non-Javadoc)
	 * @see ims.dischargeletters.domain.UserProfile#listMembrsOfStaff(ims.core.vo.MemberOfStaffShortVo)
	 */
	public MemberOfStaffShortVoCollection listMembrsOfStaff(MemberOfStaffShortVo filter) 
	{
		MosAdmin impl = (MosAdmin)getDomainImpl(MosAdminImpl.class); 
		return impl.listMembersOfStaff(filter);
	}


	/* (non-Javadoc)
	 * @see ims.dischargeletters.domain.UserProfile#listConsultants()
	 */
	public MedicLiteVoCollection listConsultants() 
	{
		MosAdmin impl = (MosAdmin) getDomainImpl(MosAdminImpl.class);
		return impl.listMedicsLite();
	}

	/* (non-Javadoc)
	 * @see ims.dischargeletters.domain.UserProfile#listClinics()
	 */
	public ClinicVoCollection listClinics() 
	{
		DomainFactory factory = getDomainFactory();
		return ClinicVoAssembler.createClinicVoCollectionFromClinic(factory.listDomainObjects(Clinic.class));
	}


	public UserAccessVo saveUserAccess(UserAccessVo voUserAccess) throws StaleObjectException, ForeignKeyViolationException,UniqueKeyViolationException 
	{
		if (!voUserAccess.isValidated())			
				throw new DomainRuntimeException("UserAccessVo has not been validated.");

		DomainFactory factory = getDomainFactory();		
		UserAccess domUserAccess = UserAccessVoAssembler.extractUserAccess(factory, voUserAccess);
		try
		{
			factory.save(domUserAccess);
		}
		catch(UnqViolationUncheckedException e)
		{
			throw new UniqueKeyViolationException("User Profie already exists within the system for this user.", e);
		}
		
		return UserAccessVoAssembler.create(domUserAccess);		
	}


	public AppUserShortVoCollection listAppUsers(AppUserShortVo voAppUser) 
	{
		ApplicationUsers impl = (ApplicationUsers) getDomainImpl(ApplicationUsersImpl.class);
		return impl.listAppUsers(voAppUser);
	}


	public UserAccessFullVo getFullUserAccessForUser(Integer appUserID) 
	{
		DomainFactory factory = getDomainFactory();
		return UserAccessFullVoAssembler.create(UserAccess.getUserAccessFromAppUser(factory, appUserID));
	}


	public UserAccessVo getUserAccessForUser(Integer appUserID) 
	{
		DomainFactory factory = getDomainFactory();
		return UserAccessVoAssembler.create(UserAccess.getUserAccessFromAppUser(factory, appUserID));		
	}


	public ICspTypeSpecifier[] listSpecifiers(ProfileType profileType) 
	{
		if (profileType == null)
			throw new CodingRuntimeException("Invalid Profile Type passed in as argument");
		
		if (profileType.equals(ProfileType.SPECIALTY))			
		{
			return listProfileSpecialties();
		}
		else if (profileType.equals(ProfileType.CONSULTANT))			
		{
			return listProfileConsultants();
		}
		else if (profileType.equals(ProfileType.CLINICNEW))
		{
			return listProfileClinics();
		}
		
		throw new CodingRuntimeException("Unsupported Profile Type");
	}


	private ICspTypeSpecifier[] listProfileClinics() 
	{
		DomainFactory factory = getDomainFactory();
		ClinicLiteVoCollection voCollClinics = ClinicLiteVoAssembler.createClinicLiteVoCollectionFromClinic(factory.listDomainObjects(Clinic.class));		
		return voCollClinics.toICspTypeSpecifierArray();		
	}


	private ICspTypeSpecifier[] listProfileConsultants() 
	{
		MosAdmin mosAdmin = (MosAdmin)getDomainImpl(MosAdminImpl.class);
		MedicLiteVoCollection voCollMedics = mosAdmin.listMedicsLite();
		return voCollMedics.toICspTypeSpecifierArray();
	}


	private ICspTypeSpecifier[] listProfileSpecialties() 
	{
		LookupService lookup = this.getLookupService();
		SpecialtyCollection collection = (SpecialtyCollection) lookup.getLookupCollection(Specialty.TYPE_ID,SpecialtyCollection.class, Specialty.class);		
		ICspTypeSpecifier[] result = new ICspTypeSpecifier[collection.size()];
		for(int x = 0; x < collection.size(); x++)
			result[x] = new SpecifierAdapter(collection.get(x));		
		
		return result;
	}

}

