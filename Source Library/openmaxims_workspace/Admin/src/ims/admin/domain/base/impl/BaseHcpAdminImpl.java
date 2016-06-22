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

public abstract class BaseHcpAdminImpl extends DomainImpl implements ims.admin.domain.HcpAdmin, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatesaveHCP(ims.core.vo.Hcp hcp)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHCPs(ims.core.vo.HcpFilter hcpFilter)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHcpByPasId(String hcpPasCode)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistExternalHcps(ims.core.vo.HcpFilter filter)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistMedics(ims.core.vo.HcpFilter filter)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHcps(ims.core.vo.HcpFilter filter, ims.core.vo.lookups.HcpDisType subType)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHcp(ims.core.vo.HcpFilter filter)
	{
	}

	@SuppressWarnings("unused")
	public void validategetMedicByNationalCode(String natCode)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveMedics(String strMedicName)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistMedicsForLocation(ims.core.resource.place.vo.LocationRefVo location)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHcpLiteByName(String hcpName)
	{
	}

	@SuppressWarnings("unused")
	public void validategetMedicMedicMappingsByExternalCode(ims.core.vo.lookups.TaxonomyType taxType, String codeVal)
	{
	}

	@SuppressWarnings("unused")
	public void validategetMedicMedicMappingsByPasCode(String pasCode)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHcpLiteByNameAndDisciplineType(String hcpName, ims.core.vo.lookups.HcpDisType hcpDisciplineType)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHcpLiteByDisciplineType(ims.core.vo.lookups.HcpDisType hcpDisciplineType)
	{
	}

	@SuppressWarnings("unused")
	public void validategetMedicLiteByExternalCode(ims.core.vo.lookups.TaxonomyType externalType, String externalCode)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHcpLite(ims.core.vo.HcpFilter filter)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHcpByExternalCode(ims.core.vo.lookups.TaxonomyType taxType, String codeVal)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHcpLiteByExternalCode(ims.core.vo.lookups.TaxonomyType taxType, String codeVal)
	{
		if(taxType == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'taxType' of type 'ims.core.vo.lookups.TaxonomyType' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetHcpLite(ims.core.vo.HcpFilter filter)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHcpLiteByName(String hcpName, Integer max)
	{
		if(max == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'max' of type 'Integer' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistResponsibleMedics(ims.core.vo.HcpFilter hcpFilter)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistMedicsForLocation(ims.core.resource.place.vo.LocationRefVo location, ims.ntpf.vo.lookups.CaseType caseType)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistReferringMedicsForLocation(ims.core.resource.place.vo.LocationRefVo location)
	{
	}
}
