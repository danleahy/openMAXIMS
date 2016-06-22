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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.22 build 50118.1100)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import ims.core.clinical.domain.objects.MskGroups;
import ims.core.clinical.domain.objects.MskJoints;
import ims.core.clinical.vo.MskGroupsRefVo;
import ims.core.clinical.vo.MskJointsRefVo;
import ims.core.vo.MskGroupLiteVo;
import ims.core.vo.MskGroupLiteVoCollection;
import ims.core.vo.MskJointVo;
import ims.core.vo.MskJointVoCollection;
import ims.core.vo.domain.MskGroupLiteVoAssembler;
import ims.core.vo.domain.MskGroupVoAssembler;
import ims.core.vo.domain.MskJointVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.impl.DomainImpl;
import ims.generalmedical.vo.RangeOfMovementJointVo;
import ims.generalmedical.vo.RangeOfMovementJointVoCollection;
import ims.spinalinjuries.vo.lookups.MSKGroupType;
import ims.spinalinjuries.vo.lookups.MskJointsMovementsCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MuscleJointConfigurationImpl extends DomainImpl implements ims.core.domain.BoneJointConfiguration, ims.domain.impl.Transactional
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ims.core.vo.MskGroupVoCollection listMskGroup(Boolean activeOnly)
	{
		DomainFactory factory = getDomainFactory();		
		return MskGroupVoAssembler.createMskGroupVoCollectionFromMskGroups(factory.listDomainObjects(MskGroups.class));
	}

	
	
	public RangeOfMovementJointVoCollection listJoints()  
	{
		DomainFactory factory = getDomainFactory();
		String hql;
		hql = " from MskGroups m where m.isActive = true and m.isJoint = true";
		List lstGroups = factory.find(hql);				
		
		RangeOfMovementJointVoCollection voCollJoints = new RangeOfMovementJointVoCollection();		
		
		for (Iterator iter = lstGroups.iterator(); iter.hasNext();) 
		{
			MskGroups domGroup = (MskGroups) iter.next();						
			
			if (domGroup.isIsJoint().equals(Boolean.TRUE) &&
					domGroup.isIsJoint().equals(Boolean.TRUE))
			{
				MskGroupLiteVo voGroup = MskGroupLiteVoAssembler.create(domGroup);
				for (Iterator iterator = domGroup.getJoints().iterator(); iterator.hasNext();) 
				{
					RangeOfMovementJointVo voJoint = new RangeOfMovementJointVo();
					MskJoints domJoint = (MskJoints) iterator.next();
					voJoint.setJoint(MskJointVoAssembler.create(domJoint));					
					voJoint.setGroup(voGroup);
					voCollJoints.add(voJoint);
				}
				
			}			
		}

		return voCollJoints;
	}

	public ims.core.vo.MskGroupVo saveMskGroup(ims.core.vo.MskGroupVo group) throws ims.domain.exceptions.StaleObjectException
	{
		if (!group.isValidated())
		{
			throw new DomainRuntimeException("MskGroupVo has not been validated");
		}
		DomainFactory factory = getDomainFactory();
		MskGroups doGroup = MskGroupVoAssembler.extractMskGroups(factory, group);
		try 
		{
			factory.save(doGroup);
		} 
		catch (DomainException e) 
		{
			throw new DomainRuntimeException("Error saving MskGroup",e);
		}
		
		group.setID_MskGroups(doGroup.getId());
		return group;
	}

	public MskJointsMovementsCollection listMovementsForJoint(MskJointsRefVo refJoint) 
	{
		// WDEV-4490 - Check for nulls
		if (refJoint == null || !refJoint.getID_MskJointsIsNotNull())
			return null;
		
		DomainFactory factory = getDomainFactory();		
		MskJoints domJoint = (MskJoints) factory.getDomainObject(MskJoints.class, refJoint.getID_MskJoints());
		MskJointVo voJoint = MskJointVoAssembler.create(domJoint);
		return voJoint.getMovements();		
	}

	public MskJointVoCollection listJointsForGroupType(MSKGroupType groupType) 
	{
		DomainFactory factory = getDomainFactory();
		String hql = " select joints from MskGroups m "; 
		StringBuffer condStr = new StringBuffer();
		
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		
		condStr.append(" where m.groupType = :groupType"); 
		markers.add("groupType");
		values.add(getDomLookup(groupType));

		hql += condStr.toString();
		return  MskJointVoAssembler.createMskJointVoCollectionFromMskJoints(factory.find(hql, markers, values)).sort();		
	}

	public MskJointVoCollection listJoints(String strName) 
	{
		DomainFactory factory = getDomainFactory();
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		String hql;
		hql = " from MskJoints m where m.isActive = true and upper(m.name) like :Name";		
		markers.add("Name");
		values.add(strName.toUpperCase() + "%");				
		List lstJoints = factory.find(hql, markers, values);				
		return MskJointVoAssembler.createMskJointVoCollectionFromMskJoints(lstJoints);		
	}

	public MskJointVoCollection listJointsForGroup(MskGroupsRefVo voRefMskGroup) 
	{
		// WDEV-4490 - Check for null parameter
		if (voRefMskGroup == null || !voRefMskGroup.getID_MskGroupsIsNotNull())
			return null;
		
		DomainFactory factory = getDomainFactory();
		String hql = " select m.joints from MskGroups m where m.isActive = true and m.id = " + voRefMskGroup.getID_MskGroups(); 
		return  MskJointVoAssembler.createMskJointVoCollectionFromMskJoints(factory.find(hql)).sort();
	}

	public MskGroupLiteVoCollection listGroupsForGroupType(MSKGroupType lkpGroupType) 
	{
		DomainFactory factory = getDomainFactory();

		String hql = " from MskGroups m where m.isActive = true and m.groupType.id = " + lkpGroupType.getId();
		return MskGroupLiteVoAssembler.createMskGroupLiteVoCollectionFromMskGroups(factory.find(hql)).sort();
	}

	public MskJointVoCollection listJointWithGroupTypeDigit(Boolean isDigitType)
	{
		DomainFactory factory = getDomainFactory();
		String strSQL = new String();
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
		strSQL = "select m2_1 from MskGroups as m1_1 left join m1_1.groupType as l1_1 join m1_1.joints as m2_1 where m1_1.isActive = 1";
		if (isDigitType.equals(Boolean.TRUE))
		{
			andStr = " and ";
			condStr.append(andStr + "m1_1.groupType.id = -855");
		}
		
		strSQL += condStr.toString();

		return ims.core.vo.domain.MskJointVoAssembler.createMskJointVoCollectionFromMskJoints(factory.find(strSQL));
	}
}
