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

public abstract class BaseDMDImpl extends DomainImpl implements ims.admin.domain.DMD, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatesearchVMP(ims.vo.interfaces.IDMDValue vtm)
	{
		if(vtm == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'vtm' of type 'ims.vo.interfaces.IDMDValue' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesearchAMP(ims.vo.interfaces.IDMDValue vmp)
	{
		if(vmp == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'vmp' of type 'ims.vo.interfaces.IDMDValue' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetVMP(ims.clinical.configuration.vo.VMPRefVo vmp)
	{
		if(vmp == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'vmp' of type 'ims.clinical.configuration.vo.VMPRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetVTM(ims.clinical.configuration.vo.VTMRefVo vtm)
	{
		if(vtm == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'vtm' of type 'ims.clinical.configuration.vo.VTMRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateaddToHotlist(ims.core.vo.lookups.Specialty specialty, ims.clinical.vo.VTMVo vtm)
	{
		if(specialty == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'specialty' of type 'ims.core.vo.lookups.Specialty' cannot be null.");
		if(vtm == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'vtm' of type 'ims.clinical.vo.VTMVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateremoveFromHotlist(ims.core.vo.lookups.Specialty specialty, ims.clinical.configuration.vo.VTMRefVo vtm)
	{
	}
}
