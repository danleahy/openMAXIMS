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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.30 build 2043.20884)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.domain.impl;

import ims.admin.domain.ApplicationRoles;
import ims.admin.domain.impl.ApplicationRolesImpl;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.impl.DomainImpl;
import ims.ocrr.configuration.domain.objects.OrderEntryTemplate;
import ims.ocrr.configuration.domain.objects.OrderSet;
import ims.ocrr.configuration.vo.OrderSetRefVo;
import ims.ocrr.domain.OrderEntryTemplateList;
import ims.ocrr.vo.OrderSetForHelpTextVo;
import ims.ocrr.vo.domain.OrderEntryTemplateVoAssembler;
import ims.ocrr.vo.domain.OrderSetForHelpTextVoAssembler;

public class OrderEntryTemplateEditImpl extends DomainImpl implements ims.ocrr.domain.OrderEntryTemplateEdit, ims.domain.impl.Transactional
{
	private static final long	serialVersionUID	= 1L;

	/**
	* getOrderEntryTemplate
	*/
	public ims.ocrr.vo.OrderEntryTemplateVo getOrderEntryTemplate(Integer recordID)
	{
		if(recordID == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		OrderEntryTemplate record = (OrderEntryTemplate)factory.getDomainObject(OrderEntryTemplate.class, recordID);
		if(record != null)
			return OrderEntryTemplateVoAssembler.create(record);
		
		return null;
	}

	/**
	* saveOrderEntryTemplate
	*/
	public ims.ocrr.vo.OrderEntryTemplateVo saveOrderEntryTemplate(ims.ocrr.vo.OrderEntryTemplateVo record) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException
	{
		DomainFactory factory = getDomainFactory();
		
		if(record.isValidated() == false)
			throw new DomainRuntimeException("Order entry template not validated");
		
		OrderEntryTemplate doRecord = OrderEntryTemplateVoAssembler.extractOrderEntryTemplate(factory, record);
		
		factory.save(doRecord);
		
		return OrderEntryTemplateVoAssembler.create(doRecord);
	}

	public ims.core.vo.LocSiteShortVoCollection getLocations() 
	{
		OrderEntryTemplateList impl = (OrderEntryTemplateList)getDomainImpl(OrderEntryTemplateListImpl.class);
		if(impl != null)
			return impl.getLocations();
		return null;
	}
	
	public ims.admin.vo.AppRoleShortVoCollection listRolesShort()
	{
		ApplicationRoles impl = (ApplicationRoles)getDomainImpl(ApplicationRolesImpl.class);
		if(impl != null)
			return impl.listRoles();
		return null;
	}

	public OrderSetForHelpTextVo getOrderSet(OrderSetRefVo orderSet) 
	{
		if(orderSet == null || !orderSet.getID_OrderSetIsNotNull())
			return null;
		
		DomainFactory factory = getDomainFactory();
		return OrderSetForHelpTextVoAssembler.create((OrderSet) factory.getDomainObject(OrderSet.class, orderSet.getID_OrderSet()));
	}
}

