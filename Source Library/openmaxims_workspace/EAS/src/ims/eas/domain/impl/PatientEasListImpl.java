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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4828.20158)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.eas.domain.impl;

import ims.core.patient.vo.PatientRefVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.eas.domain.base.impl.BasePatientEasListImpl;
import ims.eas.domain.objects.ElectronicActionSheet;
import ims.eas.vo.ElectronicActionSheetVo;
import ims.eas.vo.domain.ElectronicActionSheetVoAssembler;
import ims.eas.vo.domain.PatientEasListVoAssembler;
import ims.eas.vo.lookups.EASStatus;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;

public class PatientEasListImpl extends BasePatientEasListImpl
{

	private static final long serialVersionUID = 1L;

	public ims.eas.vo.PatientEasListVoCollection getEasCollectionForPatient(Boolean showCancelledEas, PatientRefVo patientRef)
	{

		DomainFactory factory = getDomainFactory();

		String hql = " select EAS from ElectronicActionSheet as EAS left join EAS.patient as pat left join EAS.easStatus as easStat left join easStat.status as status where pat.id = :patId ";

		StringBuffer condStr = new StringBuffer();
		String andStr = " ";

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		markers.add("patId");
		values.add(patientRef.getID_Patient());

		if (Boolean.FALSE.equals(showCancelledEas))
		{
			condStr.append(andStr + " and status.id <> :statusId ");
			markers.add("statusId");
			values.add(EASStatus.CANCELLED.getID());
		}

		condStr.append("order by EAS.dateSeen desc");
		hql += condStr.toString();

		return PatientEasListVoAssembler.createPatientEasListVoCollectionFromElectronicActionSheet(factory.find(hql, markers, values));
	}

	public ElectronicActionSheetVo getEas(Integer easId)
	{
		if(easId == null)
			throw new CodingRuntimeException("Cannot get Specimen on null Id.");
		
		return ElectronicActionSheetVoAssembler.create((ElectronicActionSheet) getDomainFactory().getDomainObject(ElectronicActionSheet.class, easId));
	}

	public ElectronicActionSheetVo saveEas(ElectronicActionSheetVo eas) throws StaleObjectException
	{
		if (eas == null)
			throw new CodingRuntimeException("Cannot save null EAS");

		DomainFactory factory = getDomainFactory();
		ElectronicActionSheet domainEAS = ElectronicActionSheetVoAssembler.extractElectronicActionSheet(factory, eas);

		factory.save(domainEAS);

		return ElectronicActionSheetVoAssembler.create(domainEAS);
	}
}
