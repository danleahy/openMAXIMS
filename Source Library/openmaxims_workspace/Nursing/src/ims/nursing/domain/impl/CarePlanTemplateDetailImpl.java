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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.18 build 40614.1100)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import ims.domain.impl.DomainImpl;
import ims.domain.DomainFactory;
import ims.nursing.careplans.domain.objects.CarePlanTemplate;
import ims.nursing.vo.CarePlanTemplateTitle;
import ims.nursing.vo.domain.CarePlanTemplateAssembler;
import ims.domain.exceptions.DomainRuntimeException;

public class CarePlanTemplateDetailImpl extends DomainImpl implements ims.nursing.domain.CarePlanTemplateDetail, ims.domain.impl.Transactional
{
	/**
	* Get a care plan template
	*/
	public ims.nursing.vo.CarePlanTemplate getCarePlanTemplate(CarePlanTemplateTitle carePlanTemplate)
	{
		
		DomainFactory factory = getDomainFactory();
		CarePlanTemplate domCpt = (CarePlanTemplate)factory.getDomainObject(CarePlanTemplate.class,carePlanTemplate.getID_CarePlanTemplate());
		if (domCpt == null)
			return null;
		
		ims.nursing.vo.CarePlanTemplate voCpt = CarePlanTemplateAssembler.create(domCpt);
		voCpt.getInterventions().sort();
		return voCpt;
		
	}
	
	public ims.nursing.vo.CarePlanTemplate saveCarePlanTemplate(ims.nursing.vo.CarePlanTemplate cpt) throws ims.domain.exceptions.StaleObjectException
	{
		if (!cpt.isValidated())
		{
			throw new DomainRuntimeException("CarePlanTemplate VO not validated.");
		}
		DomainFactory factory = getDomainFactory();
		CarePlanTemplate domCpt = CarePlanTemplateAssembler.extractCarePlanTemplate(factory,cpt);
		
		factory.save(domCpt);
		return CarePlanTemplateAssembler.create(domCpt);
	}
}
