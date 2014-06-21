// This code was generated by Cristian Belciug using IMS Development Environment (version 1.66 build 3233.21563)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.base.impl.BaseReferralStatusHistoryImpl;
import ims.core.resource.people.domain.objects.MemberOfStaff;
import ims.core.vo.domain.MemberOfStaffLiteVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;

public class ReferralStatusHistoryImpl extends BaseReferralStatusHistoryImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.MemberOfStaffLiteVo getMemberOfStaff(ims.core.resource.people.vo.MemberOfStaffRefVo memberOfStaffReff) throws ims.domain.exceptions.DomainInterfaceException
	{
		if(memberOfStaffReff == null || (memberOfStaffReff != null && !memberOfStaffReff.getID_MemberOfStaffIsNotNull()))
			throw new DomainRuntimeException("Cannot get MemberOfStaff on null ID.");
		
		DomainFactory factory = getDomainFactory();
		
		return MemberOfStaffLiteVoAssembler.create((MemberOfStaff) factory.getDomainObject(MemberOfStaff.class, memberOfStaffReff.getID_MemberOfStaff()));
	}
}