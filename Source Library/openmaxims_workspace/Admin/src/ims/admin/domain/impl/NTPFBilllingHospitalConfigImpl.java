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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 4535.14223)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.base.impl.BaseNTPFBilllingHospitalConfigImpl;
import ims.admin.vo.domain.PaymentTreatmentHospitalLinkVoAssembler;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.ntpf.configuration.domain.objects.PaymentTreatingHospitalLink;

import java.util.ArrayList;
import java.util.List;

public class NTPFBilllingHospitalConfigImpl extends BaseNTPFBilllingHospitalConfigImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* List Oraganisations
	*/
	public ims.admin.vo.PaymentTreatmentHospitalLinkVoCollection listPaymentTreatmentHospitalLinks()
	{
		return PaymentTreatmentHospitalLinkVoAssembler.createPaymentTreatmentHospitalLinkVoCollectionFromPaymentTreatingHospitalLink(getDomainFactory().find("from PaymentTreatingHospitalLink"));
	}

	/**
	* Save
	*/
	public ims.admin.vo.PaymentTreatmentHospitalLinkVo savePaymentHospitalLink(ims.admin.vo.PaymentTreatmentHospitalLinkVo paymentVo) throws ims.domain.exceptions.StaleObjectException
	{
		if (!paymentVo.isValidated())
			throw new DomainRuntimeException("paymentVo has not been validated");

		DomainFactory factory = getDomainFactory();

		PaymentTreatingHospitalLink doPay = PaymentTreatmentHospitalLinkVoAssembler.extractPaymentTreatingHospitalLink(factory, paymentVo);

		factory.save(doPay);
		return PaymentTreatmentHospitalLinkVoAssembler.create(doPay);
	}

	public LocationLiteVoCollection listHospitals()
	{
		DomainFactory factory = getDomainFactory();

		String hql = " from Location loc ";
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";

		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		condStr.append(andStr + " loc.type.id = " + LocationType.HOSP.getID());
		andStr = " and ";

		condStr.append(andStr + " loc.treatingHosp = :treating");
		markers.add("treating");
		values.add(Boolean.TRUE);
		andStr = " and ";

		condStr.append(andStr + "loc.isActive = :isActive");
		markers.add("isActive");
		values.add(Boolean.TRUE);	

		if (andStr.equals(" and "))
		{
			hql += " where ";
		}

		hql += condStr.toString();
		List locations = factory.find(hql, markers, values);

		return LocationLiteVoAssembler.createLocationLiteVoCollectionFromLocation(locations).sort();
	}

	/**
	* Get Payment Hospitals
	*/
	public ims.admin.vo.PaymentTreatmentHospitalLinkVo getPaymentHospitalConfig(ims.core.vo.LocationLiteVo voLoc)
	{
		DomainFactory factory = getDomainFactory();

		String hql = "from PaymentTreatingHospitalLink as pt where pt.paymentHospital.id = :ID";

		List list = factory.find(hql, new String[] {"ID"}, new Object[] {voLoc.getID_Location()});
		if(list == null || list.size() == 0)
			return null;

		return PaymentTreatmentHospitalLinkVoAssembler.create((PaymentTreatingHospitalLink) list.get(0));
	}

}
