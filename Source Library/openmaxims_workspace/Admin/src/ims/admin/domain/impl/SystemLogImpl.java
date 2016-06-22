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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.65 build 3198.21681)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.admin.domain.base.impl.BaseSystemLogImpl;
import ims.admin.vo.SystemLogVo;
import ims.admin.vo.SystemLogVoCollection;
import ims.admin.vo.domain.SystemLogVoAssembler;
import ims.domain.DomainFactory;
import ims.core.admin.domain.objects.SystemLog;

public class SystemLogImpl extends BaseSystemLogImpl
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public ims.admin.vo.SystemLogVoCollection getEntries(ims.framework.utils.DateTime startDateTime, ims.framework.utils.DateTime endDateTime, String user, String computer, ims.framework.enumerations.SystemLogType eventType, ims.framework.enumerations.SystemLogLevel level)
	{
		DomainFactory factory = getDomainFactory();
		String hql = " from SystemLog sl";
		boolean whereClause = false;
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		
		if(startDateTime != null && endDateTime != null)
		{
			if(!whereClause)
			{
				whereClause = true;
				hql += " where ";
			}
			else
			{
				hql += " and ";
			}
			
			hql += " sl.eventDateTime between :startDateTimeValue and :endDateTimeValue";
			markers.add("startDateTimeValue");
			values.add(startDateTime.getJavaDate());
			markers.add("endDateTimeValue");
			values.add(endDateTime.getJavaDate());
		}		
		if(user != null && user.trim().length() > 0)
		{
			if(!whereClause)
			{
				whereClause = true;
				hql += " where ";
			}
			else
			{
				hql += " and ";
			}
			
			hql += " sl.user like :userValue";
			markers.add("userValue");
			values.add(user + "%");
		}
		if(computer != null && computer.trim().length() > 0)
		{
			if(!whereClause)
			{
				whereClause = true;
				hql += " where ";
			}
			else
			{
				hql += " and ";
			}
			
			hql += " sl.computer like :computerValue";
			markers.add("computerValue");
			values.add("%" + computer + "%");
		}
		if(level != null)
		{
			if(!whereClause)
			{
				whereClause = true;
				hql += " where ";
			}
			else
			{
				hql += " and ";
			}
			
			hql += " sl.eventLevel = :levelValue";
			markers.add("levelValue");
			values.add(level.getId());
		}
		if(eventType != null)
		{
			if(!whereClause)
			{
				whereClause = true;
				hql += " where ";
			}
			else
			{
				hql += " and ";
			}
			
			hql += " sl.eventType = :typeValue";
			markers.add("typeValue");
			values.add(eventType.getId());
		}
		
		hql += " order by sl.id desc";
		
		
		List entries = factory.find(hql, markers, values, 1000);
		return SystemLogVoAssembler.createSystemLogVoCollectionFromSystemLog(entries);		
	}
	@SuppressWarnings("unchecked")
	public SystemLogVoCollection getEntries(String sessionId)
	{
		if(sessionId == null || sessionId.trim().length() == 0)
			return new SystemLogVoCollection();
		
		DomainFactory factory = getDomainFactory();
		String hql = " from SystemLog sl where sl.sessionId = '" + sessionId + "' order by sl.id desc";
		List entries = factory.find(hql);
		return SystemLogVoAssembler.createSystemLogVoCollectionFromSystemLog(entries);		
	}
	public SystemLogVo getEntry(Integer eventId) 
	{
		return SystemLogVoAssembler.create((SystemLog)getDomainFactory().getDomainObject(SystemLog.class, eventId));
	}
}
