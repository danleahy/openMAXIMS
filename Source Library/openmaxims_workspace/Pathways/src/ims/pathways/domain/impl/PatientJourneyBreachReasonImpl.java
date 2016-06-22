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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5308.16958)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.pathways.domain.impl;

import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.pathways.domain.base.impl.BasePatientJourneyBreachReasonImpl;
import ims.pathways.domain.objects.PatientPathwayJourney;
import ims.pathways.vo.PatientJourneyWithBreachReasonVo;
import ims.pathways.vo.domain.PatientJourneyWithBreachReasonVoAssembler;

public class PatientJourneyBreachReasonImpl extends BasePatientJourneyBreachReasonImpl
{
	private static final long serialVersionUID = 1L;

	public PatientJourneyWithBreachReasonVo getPatientJourney(ims.pathways.vo.PatientPathwayJourneyRefVo patientJourney)
	{
		if(patientJourney == null || patientJourney.getID_PatientPathwayJourney() == null)
			return null;
		
		return PatientJourneyWithBreachReasonVoAssembler.create((PatientPathwayJourney) getDomainFactory().getDomainObject(PatientPathwayJourney.class, patientJourney.getID_PatientPathwayJourney()));
	}

	public PatientJourneyWithBreachReasonVo save(PatientJourneyWithBreachReasonVo patientJourney) throws StaleObjectException
	{
		if(patientJourney == null)
			throw new CodingRuntimeException("Cannot save a null PatientPathwayJourney.");
		
		if(!patientJourney.isValidated())
			throw new CodingRuntimeException("PatientPathwayJourney is not validated.");
		
		DomainFactory factory = getDomainFactory();
		PatientPathwayJourney doPatientPathwayJourney = PatientJourneyWithBreachReasonVoAssembler.extractPatientPathwayJourney(factory, patientJourney);
		
		factory.save(doPatientPathwayJourney);
		
		return PatientJourneyWithBreachReasonVoAssembler.create(doPatientPathwayJourney);
	}
}
