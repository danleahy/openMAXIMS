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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.admin.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BasePracticeAdminImpl extends DomainImpl implements ims.admin.domain.PracticeAdmin, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelist(Boolean activeOnly)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOrg(ims.core.resource.place.vo.OrganisationRefVo voOrgRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveOrg(ims.core.vo.OrganisationVo orgVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocSite(ims.core.vo.LocSiteVo voLocSiteRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistSearch(ims.core.vo.OrganisationVo filter)
	{
	}

	@SuppressWarnings("unused")
	public void validatedeletePractice(ims.core.vo.OrganisationVo orgToDelete)
	{
	}

	@SuppressWarnings("unused")
	public void validatedeleteLocSite(ims.core.vo.LocSiteVo locSiteToDelete)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistGps(ims.core.resource.place.vo.OrganisationRefVo organisationRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatedeletePractice(ims.core.vo.OrganisationVo orgToDelete, Boolean deleteSurgery)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistPracticeParents(String value, Boolean activeOnly)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistPatients(ims.core.vo.LocSiteVo locationsite)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPractice(ims.core.resource.place.vo.OrganisationRefVo practiceRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatetriggerGPPracticeMasterFileEvent(ims.core.resource.place.vo.OrganisationRefVo gPPractice)
	{
	}
}
