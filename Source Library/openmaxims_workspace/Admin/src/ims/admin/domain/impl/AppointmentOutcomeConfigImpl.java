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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.base.impl.BaseAppointmentOutcomeConfigImpl;
import ims.admin.vo.AppointmentOutcomeConfigVo;
import ims.admin.vo.AppointmentOutcomeConfigVoCollection;
import ims.admin.vo.domain.AppointmentOutcomeConfigVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.pathways.configuration.domain.objects.AppointmentOutcomeConfig;
import ims.pathways.configuration.domain.objects.Event;
import ims.pathways.configuration.vo.AppointmentOutcomeConfigRefVo;
import ims.pathways.vo.EventLiteVo;
import ims.pathways.vo.EventLiteVoCollection;
import ims.pathways.vo.domain.EventLiteVoAssembler;
import ims.scheduling.vo.lookups.ApptOutcome;

import java.util.List;

public class AppointmentOutcomeConfigImpl extends BaseAppointmentOutcomeConfigImpl
{

	private static final long serialVersionUID = 1L;

	public AppointmentOutcomeConfigVo getAppointmentOutcomeConfig(AppointmentOutcomeConfigRefVo appOutcomeConfigRef)
	{
		if (appOutcomeConfigRef==null ||appOutcomeConfigRef.getID_AppointmentOutcomeConfig()==null)
		{
			throw new CodingRuntimeException("Cannot get AppointmentOutcomeConfigVo on null Id ");
		}

		DomainFactory factory = getDomainFactory();

		ims.pathways.configuration.domain.objects.AppointmentOutcomeConfig domainApptOutcomeConfig = (ims.pathways.configuration.domain.objects.AppointmentOutcomeConfig) factory.getDomainObject(ims.pathways.configuration.domain.objects.AppointmentOutcomeConfig.class,appOutcomeConfigRef.getID_AppointmentOutcomeConfig());

		return AppointmentOutcomeConfigVoAssembler.create(domainApptOutcomeConfig);
	}

	public AppointmentOutcomeConfigVo save(AppointmentOutcomeConfigVo appOutcomeConfigToSave) throws StaleObjectException
	{
		if (appOutcomeConfigToSave == null)
		{
			throw new CodingRuntimeException("Cannot save null AppointmentOutcomeConfig");
		}

		DomainFactory factory = getDomainFactory();
		
		ims.pathways.configuration.domain.objects.AppointmentOutcomeConfig domainApptOutcomeConfig = AppointmentOutcomeConfigVoAssembler.extractAppointmentOutcomeConfig(factory, appOutcomeConfigToSave);
		factory.save(domainApptOutcomeConfig);
		
		return AppointmentOutcomeConfigVoAssembler.create(domainApptOutcomeConfig);
	}

	public AppointmentOutcomeConfigVoCollection listAppointmentsOutcomeConfig(Boolean active)
	{
		StringBuilder hqlBuilder = new StringBuilder("from AppointmentOutcomeConfig as appOutcomeConfig ");
		
		List <?> list = getDomainFactory().find(hqlBuilder.toString());
		
		return AppointmentOutcomeConfigVoAssembler.createAppointmentOutcomeConfigVoCollectionFromAppointmentOutcomeConfig(list);
	}

	public AppointmentOutcomeConfigVo getAppointmentOutcomeConfigByApptOutcomeLookup(ApptOutcome apptOutcomeLookup)
	{
		StringBuilder hqlBuilder = new StringBuilder("select appOutcomeConfig from AppointmentOutcomeConfig as appOutcomeConfig left join appOutcomeConfig.appointmentOutcome as appOutcome where appOutcome.id= :AppOutcomeID ");
		
		List <?> list = getDomainFactory().find(hqlBuilder.toString(),new String[] {"AppOutcomeID"},new Object[] {apptOutcomeLookup.getID()});
		
		if (list == null || list.size() == 0)
			return null;
		
		return AppointmentOutcomeConfigVoAssembler.create((AppointmentOutcomeConfig) list.get(0));
	}

	public EventLiteVoCollection listEvents(String name)
	{
		StringBuilder hqlBuilder = new StringBuilder("select event from Event as event where event.upperName like :eventName ");
		
		List <?> list = getDomainFactory().find(hqlBuilder.toString(),new String[] {"eventName"},new Object[] {name.toUpperCase()+"%"});
		
		return EventLiteVoAssembler.createEventLiteVoCollectionFromEvent(list);
		
	}

	public EventLiteVo getFirstDefinitiveTreatmentEvent(Integer event_Id)
	{
		StringBuilder hqlBuilder = new StringBuilder("select event from Event as event where event.id = :eventID ");
		
		List <?> list = getDomainFactory().find(hqlBuilder.toString(),new String[] {"eventID"},new Object[] {event_Id});
		
		if (list == null || list.size() == 0)
			return null;
		
		return EventLiteVoAssembler.create((Event) list.get(0));
	}

	

	
}
