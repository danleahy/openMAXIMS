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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.55 build 2767.27581)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.oncology.domain.impl;

import ims.domain.DomainFactory;
import ims.oncology.domain.base.impl.BasePrimaryTumourSelectDialogImpl;
import ims.oncology.vo.domain.PrimaryTumourDetailsShortVoAssembler;

public class PrimaryTumourSelectDialogImpl extends BasePrimaryTumourSelectDialogImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* listPrimaryTumourForCareContext
	*/
	public ims.oncology.vo.PrimaryTumourDetailsShortVoCollection listPrimaryTumourForCareContext(ims.core.admin.vo.CareContextRefVo careContextRefVo)
	{
		DomainFactory factory = getDomainFactory();
		String hql = "from PrimaryTumourDetails ptd where ptd.careContext.id = " + careContextRefVo.getID_CareContext();
		
		return PrimaryTumourDetailsShortVoAssembler.createPrimaryTumourDetailsShortVoCollectionFromPrimaryTumourDetails((factory.find(hql))).sort();
	}
}
