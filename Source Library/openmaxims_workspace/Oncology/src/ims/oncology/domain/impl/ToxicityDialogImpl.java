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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 4050.19540)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.oncology.domain.impl;

import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.oncology.domain.base.impl.BaseToxicityDialogImpl;
import ims.oncology.domain.objects.ChemotherapyToxicityDetails;
import ims.oncology.domain.objects.RadiotherapyToxicityDetails;
import ims.oncology.vo.RadiotherapyToxicityDetailsRefVo;
import ims.oncology.vo.RadiotherapyToxicityDetailsVo;
import ims.oncology.vo.domain.ChemotherapyToxicityDetailsVoAssembler;
import ims.oncology.vo.domain.RadiotherapyToxicityDetailsVoAssembler;

public class ToxicityDialogImpl extends BaseToxicityDialogImpl
{

	private static final long serialVersionUID = 1L;

	public ims.oncology.vo.ChemotherapyToxicityDetailsVo saveChemoToxicity(ims.oncology.vo.ChemotherapyToxicityDetailsVo voToxicity) throws ims.domain.exceptions.StaleObjectException
	{
		if (!voToxicity.isValidated())
			throw new CodingRuntimeException("ChemotherapyToxicityDetailsVo has not been validated");
		if(voToxicity == null)
			throw new CodingRuntimeException("Cannot save null ChemotherapyToxicityDetailsVo");
		
		DomainFactory factory = getDomainFactory();
		
		ChemotherapyToxicityDetails doTox = ChemotherapyToxicityDetailsVoAssembler.extractChemotherapyToxicityDetails(factory, voToxicity);
		factory.save(doTox);
		return (ChemotherapyToxicityDetailsVoAssembler.create(doTox));		
	}

	public ims.oncology.vo.ChemotherapyToxicityDetailsVo getChemoToxicity(ims.oncology.vo.ChemotherapyToxicityDetailsRefVo voToxicityRef)
	{
		DomainFactory factory = getDomainFactory();
		return ChemotherapyToxicityDetailsVoAssembler.create((ChemotherapyToxicityDetails)factory.getDomainObject((ChemotherapyToxicityDetails.class), voToxicityRef.getID_ChemotherapyToxicityDetails()));
	}

	public RadiotherapyToxicityDetailsVo getRadioToxicity(RadiotherapyToxicityDetailsRefVo voToxicityRef) 
	{
		DomainFactory factory = getDomainFactory();
		return RadiotherapyToxicityDetailsVoAssembler.create((RadiotherapyToxicityDetails)factory.getDomainObject((RadiotherapyToxicityDetails.class), voToxicityRef.getID_RadiotherapyToxicityDetails()));
	}

	public RadiotherapyToxicityDetailsVo saveRadioToxicity(RadiotherapyToxicityDetailsVo voToxicity) throws StaleObjectException 
	{
		if (!voToxicity.isValidated())
			throw new CodingRuntimeException("RadiotherapyToxicityDetailsVo has not been validated");
		if(voToxicity == null)
			throw new CodingRuntimeException("Cannot save null RadiotherapyToxicityDetailsVo");
		
		DomainFactory factory = getDomainFactory();
		
		RadiotherapyToxicityDetails doTox = RadiotherapyToxicityDetailsVoAssembler.extractRadiotherapyToxicityDetails(factory, voToxicity);
		factory.save(doTox);
		return (RadiotherapyToxicityDetailsVoAssembler.create(doTox));		
	}
}
