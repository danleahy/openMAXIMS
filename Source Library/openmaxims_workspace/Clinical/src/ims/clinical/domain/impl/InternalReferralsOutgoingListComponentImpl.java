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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.configuration.domain.objects.InternalReferralSettings;
import ims.clinical.domain.base.impl.BaseInternalReferralsOutgoingListComponentImpl;
import ims.clinical.vo.ClinicalReferralsForIncomingReferralListVo;
import ims.clinical.vo.ClinicalReferralsForIncomingReferralListVoCollection;
import ims.clinical.vo.OutgoingReferralListSearchCriteriaVo;
import ims.clinical.vo.ServiceConfigIntReferralForIncomingListVoCollection;
import ims.clinical.vo.domain.ClinicalReferralsForIncomingReferralListVoAssembler;
import ims.clinical.vo.domain.ServiceConfigIntReferralForIncomingListVoAssembler;
import ims.clinical.vo.lookups.ClinicalReferralType;
import ims.clinicaladmin.vo.InternalReferralSettingsVo;
import ims.clinicaladmin.vo.domain.InternalReferralSettingsVoAssembler;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.ServiceLiteVoCollection;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.ServiceLiteVoAssembler;
import ims.core.vo.lookups.InternalReferralStatus;
import ims.core.vo.lookups.ServiceCategory;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class InternalReferralsOutgoingListComponentImpl extends BaseInternalReferralsOutgoingListComponentImpl
{

	private static final long serialVersionUID = 1L;

	private static final String INPATIENT_REFERRAL = "I/P";
	private static final String OUTPATIENT_REFERRAL = "O/P";

	public HcpLiteVoCollection listHCPs(String name)
	{
		if (name == null || (name != null && name.length() == 0))
			throw new DomainRuntimeException("Cannot search on null name.");

		DomainFactory factory = getDomainFactory();

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		String hql = "select h from Hcp h ";

		hql += "where h.isActive = :isActive and (h.mos.name.upperSurname like :hcpSname or h.mos.name.upperForename like :hcpFname)";

		markers.add("isActive");
		values.add(Boolean.TRUE);
		markers.add("hcpSname");
		values.add(name.toUpperCase() + "%");
		markers.add("hcpFname");
		values.add(name.toUpperCase() + "%");

		hql += " order by h.mos.name.upperSurname,h.mos.name.upperForename";

		return HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(factory.find(hql, markers, values));
	}

	public ClinicalReferralsForIncomingReferralListVoCollection listClinicalReferrals(OutgoingReferralListSearchCriteriaVo criteria)
	{
		if (criteria == null && new OutgoingReferralListSearchCriteriaVo().equals(criteria))
			throw new CodingRuntimeException("At least one search criteria must be provided");

		String statusesIds = getStatusesIds(criteria);
		String excludedStatusesIds = getExcludedStatusesIds(criteria);
		String servicesIds = getServicesIds(criteria);

		StringBuilder hqlJoins = new StringBuilder("select clinicReferral from ClinicalReferrals as clinicReferral");
		StringBuilder hqlConditions = new StringBuilder();

		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();

		String and = " ";
		boolean skipSearchAfterRejection = ((Boolean.TRUE.equals(criteria.getRejectionNotAcknowledged()) && Boolean.TRUE.equals(criteria.getRejectionAcknowledged())) || (Boolean.FALSE.equals(criteria.getRejectionNotAcknowledged()) && Boolean.FALSE.equals(criteria.getRejectionAcknowledged())));
		boolean searchAfterReqAppOrApptBooked = !Boolean.TRUE.equals(criteria.getAccepted()) && (Boolean.TRUE.equals(criteria.getRequiresAppt()) || Boolean.TRUE.equals(criteria.getAppointmentBooked()));

		if ((statusesIds != null && statusesIds.length() > 0) || (excludedStatusesIds != null && excludedStatusesIds.length() > 0))
		{
			hqlJoins.append(" left join clinicReferral.currentReferralStatus as clinicReferralStatus left join clinicReferralStatus.referralStatus as status ");
		}

		if ((statusesIds != null && statusesIds.length() > 0) || searchAfterReqAppOrApptBooked || !skipSearchAfterRejection)
			hqlConditions.append(" ( ");

		if (statusesIds != null && statusesIds.length() > 0)
		{
			hqlConditions.append(" status.id in ( " + statusesIds + " ) ");
			and = " and ";
		}

		if (searchAfterReqAppOrApptBooked)
		{
			if (Boolean.TRUE.equals(criteria.getAppointmentBooked()))
			{
				if (statusesIds != null && statusesIds.length() > 0)
					hqlConditions.append(" OR ");
				else
					hqlConditions.append(and);

				hqlConditions.append(" (status.id = :acceptedStatus and clinicReferralStatus.appointmentBooked = :apptBooked) ");

				paramNames.add("acceptedStatus");
				paramValues.add(InternalReferralStatus.ACCEPTED.getID());
				paramNames.add("apptBooked");
				paramValues.add(criteria.getAppointmentBooked());

				and = " and ";

			}

			if (Boolean.TRUE.equals(criteria.getRequiresAppt()))
			{
				if ((statusesIds != null && statusesIds.length() > 0) || Boolean.TRUE.equals(criteria.getAppointmentBooked()))
					hqlConditions.append(" OR ");
				else
					hqlConditions.append(and);

				hqlConditions.append(" (status.id = :acceptedStatus and clinicReferralStatus.appointmentRequired = :apptRequired) ");

				paramNames.add("acceptedStatus");
				paramValues.add(InternalReferralStatus.ACCEPTED.getID());
				paramNames.add("apptRequired");
				paramValues.add(criteria.getRequiresAppt());

				and = " and ";

			}
		}

		if (!skipSearchAfterRejection)
		{
			if ((statusesIds != null && statusesIds.length() > 0) || searchAfterReqAppOrApptBooked)
				hqlConditions.append(" OR ");
			else
				hqlConditions.append(and);

			if (Boolean.TRUE.equals(criteria.getRejectionAcknowledged()))
			{
				hqlConditions.append(" (status.id = :rejectedStatus and clinicReferral.acknowledgeRejection = :ackRejection) ");

				paramNames.add("rejectedStatus");
				paramValues.add(InternalReferralStatus.REJECTED.getID());
				paramNames.add("ackRejection");
				paramValues.add(Boolean.TRUE);
			}
			else if (Boolean.TRUE.equals(criteria.getRejectionNotAcknowledged()))
			{
				hqlConditions.append(" (status.id = :rejectedStatus and (clinicReferral.acknowledgeRejection = :ackRejection or clinicReferral.acknowledgeRejection is null)) ");

				paramNames.add("rejectedStatus");
				paramValues.add(InternalReferralStatus.REJECTED.getID());
				paramNames.add("ackRejection");
				paramValues.add(Boolean.FALSE);
			}

			and = " and ";
		}

		if ((statusesIds != null && statusesIds.length() > 0) || searchAfterReqAppOrApptBooked || !skipSearchAfterRejection)
			hqlConditions.append(" ) ");

		if (excludedStatusesIds != null && excludedStatusesIds.length() > 0)
		{
			hqlConditions.append(and);
			hqlConditions.append(" status.id not in ( " + excludedStatusesIds + " ) ");
			and = " and ";
		}

		if (criteria.getHcpBy() != null)
		{
			hqlJoins.append(" left join clinicReferral.referringHCP as refByHcp ");
			hqlConditions.append(and);
			hqlConditions.append(" refByHcp.id = :ReferralByHCP ");

			paramNames.add("ReferralByHCP");
			paramValues.add(criteria.getHcpBy().getIMosHcpId());
			and = " and ";
		}

		if (criteria.getHcpTo() != null)
		{
			hqlJoins.append(" left join clinicReferral.referToHCP as refToHcp ");
			hqlConditions.append(and);
			hqlConditions.append(" refToHcp.id = :ReferralToHCP ");

			paramNames.add("ReferralToHCP");
			paramValues.add(criteria.getHcpTo().getIMosHcpId());
			and = " and ";
		}

		if (criteria.getServiceBy() != null || (servicesIds != null && servicesIds.length() > 0))
		{
			hqlJoins.append(" left join clinicReferral.referringService as refByService ");
		}

		if (criteria.getServiceBy() != null)
		{
			hqlConditions.append(and);
			hqlConditions.append(" refByService.id = :ReferralByService ");

			paramNames.add("ReferralByService");
			paramValues.add(criteria.getServiceBy().getID_Service());
			and = " and ";
		}
		else if (servicesIds != null && servicesIds.length() > 0)
		{
			hqlConditions.append(and);
			hqlConditions.append(" refByService.id in ( " + servicesIds + " ) ");
			and = " and ";
		}

		if (criteria.getServiceTo() != null)
		{
			hqlJoins.append(" left join clinicReferral.referToService as refToService ");
			hqlConditions.append(and);
			hqlConditions.append(" refToService.id = :ReferralToService ");

			paramNames.add("ReferralToService");
			paramValues.add(criteria.getServiceTo().getID_ServiceConfigIntReferral());
			and = " and ";
		}

		if (criteria.getDateFrom() != null)
		{
			hqlConditions.append(and);
			hqlConditions.append(" clinicReferral.dateDecisionToRefer >= :DateFrom ");

			paramNames.add("DateFrom");
			paramValues.add(criteria.getDateFrom().getDate());
			and = " and ";
		}

		if (criteria.getDateTo() != null)
		{
			hqlConditions.append(and);
			hqlConditions.append(" clinicReferral.dateDecisionToRefer <= :DateTo ");

			paramNames.add("DateTo");
			paramValues.add(criteria.getDateTo().getDate());
			and = " and ";
		}

		if (!(Boolean.TRUE.equals(criteria.getInpatient()) && Boolean.TRUE.equals(criteria.getOutpatient())))
		{
			if (Boolean.TRUE.equals(criteria.getInpatient()))
			{
				hqlJoins.append(" left join clinicReferral.referralType as refType ");
				hqlConditions.append(and);
				hqlConditions.append(" refType.id = :ReferralTypeId ");

				paramNames.add("ReferralTypeId");
				paramValues.add(ClinicalReferralType.IP_TO_BE_SEEN_AS_INPATIENT.getID());
				and = " and ";
			}
			else if (Boolean.TRUE.equals(criteria.getOutpatient()))
			{
				hqlJoins.append(" left join clinicReferral.referralType as refType ");
				hqlConditions.append(and);
				hqlConditions.append(" (refType.id = :ReferralTypeId1 or  refType.id = :ReferralTypeId2) ");

				paramNames.add("ReferralTypeId1");
				paramValues.add(ClinicalReferralType.IP_TO_BE_SEEN_AS_OUTPATIENT.getID());
				paramNames.add("ReferralTypeId2");
				paramValues.add(ClinicalReferralType.OP_TO_BE_SEEN_AS_OUTPATIENT.getID());
				and = " and ";
			}
		}

		hqlConditions.insert(0, " where (clinicReferral.isRIE is null or clinicReferral.isRIE = 0) and ");

		DomainFactory factory = getDomainFactory();

		List<?> referralsList = factory.find(hqlJoins.append(hqlConditions.toString()).toString(), paramNames, paramValues);

		ClinicalReferralsForIncomingReferralListVoCollection referrals = ClinicalReferralsForIncomingReferralListVoAssembler.createClinicalReferralsForIncomingReferralListVoCollectionFromClinicalReferrals(referralsList);

		if (referrals == null)
			return null;

		for (ClinicalReferralsForIncomingReferralListVo referral : referrals)
		{
			if (referral == null)
				continue;

			referral.setReferralTypeText(getReferralType(referral.getReferralType()));
		}

		return referrals;
	}

	private String getServicesIds(OutgoingReferralListSearchCriteriaVo criteria)
	{
		if (criteria == null || criteria.getServicesByCollection() == null)
			return null;

		StringBuilder servicesIds = new StringBuilder();

		for (int i = 0; i < criteria.getServicesByCollection().size(); i++)
		{
			if (servicesIds != null && servicesIds.length() > 0)
				servicesIds.append(",");

			servicesIds.append(criteria.getServicesByCollection().get(i).getID_Service());
		}

		return servicesIds.toString();

	}

	private String getReferralType(ClinicalReferralType clinicalReferralType)
	{
		if (clinicalReferralType == null)
			return null;

		if (ClinicalReferralType.IP_TO_BE_SEEN_AS_INPATIENT.equals(clinicalReferralType))
			return INPATIENT_REFERRAL;

		return OUTPATIENT_REFERRAL;
	}

	private String getStatusesIds(OutgoingReferralListSearchCriteriaVo criteria)
	{
		if (criteria == null)
			return null;

		StringBuilder statusesIds = new StringBuilder();

		boolean searchAfterRejection = Boolean.TRUE.equals(criteria.getRejectionNotAcknowledged()) && Boolean.TRUE.equals(criteria.getRejectionAcknowledged());

		if (Boolean.TRUE.equals(criteria.getAwaitingReferralLetter()))
		{
			statusesIds.append(InternalReferralStatus.AWAITING_REFERRAL_LETTER.getID());
		}

		if (Boolean.TRUE.equals(criteria.getAwaitingSignOff()))
		{
			if (statusesIds != null && statusesIds.length() > 0)
				statusesIds.append(",");

			statusesIds.append(InternalReferralStatus.AWAITING_AUTHORISATION.getID());
		}

		if (Boolean.TRUE.equals(criteria.getRequiringFurtherInfo()))
		{
			if (statusesIds != null && statusesIds.length() > 0)
				statusesIds.append(",");

			statusesIds.append(InternalReferralStatus.REQUIRES_FURTHER_INFORMATION.getID());
		}

		if (Boolean.TRUE.equals(criteria.getAwaitingAcceptance()))
		{
			if (statusesIds != null && statusesIds.length() > 0)
				statusesIds.append(",");

			statusesIds.append(InternalReferralStatus.AWAITING_ACCEPTANCE.getID());
		}

		if (Boolean.TRUE.equals(searchAfterRejection))
		{
			if (statusesIds != null && statusesIds.length() > 0)
				statusesIds.append(",");

			statusesIds.append(InternalReferralStatus.REJECTED.getID());
		}

		if (Boolean.TRUE.equals(criteria.getRequiresSecondOpinion()))
		{
			if (statusesIds != null && statusesIds.length() > 0)
				statusesIds.append(",");

			statusesIds.append(InternalReferralStatus.SECOND_OPINION_REQUIRED.getID());
		}

		if (Boolean.TRUE.equals(criteria.getCompleted()))
		{
			if (statusesIds != null && statusesIds.length() > 0)
				statusesIds.append(",");

			statusesIds.append(InternalReferralStatus.COMPLETED.getID());
		}

		if (Boolean.TRUE.equals(criteria.getAccepted()))
		{
			if (statusesIds != null && statusesIds.length() > 0)
				statusesIds.append(",");

			statusesIds.append(InternalReferralStatus.ACCEPTED.getID());
		}

		return statusesIds.toString();
	}

	public InternalReferralSettingsVo getInternalReferralsSettings()
	{
		DomainFactory factory = getDomainFactory();

		List<?> list = factory.find("select settings from InternalReferralSettings as settings");

		if (list != null && list.size() > 0)
		{
			return InternalReferralSettingsVoAssembler.create((InternalReferralSettings) list.get(0));
		}

		return null;
	}

	private String getExcludedStatusesIds(OutgoingReferralListSearchCriteriaVo criteria)
	{
		StringBuilder statusesIds = new StringBuilder();

		statusesIds.append(InternalReferralStatus.ABANDONED.getID());

		return statusesIds.toString();
	}

	public ServiceLiteVoCollection listServices(String name)
	{
		if (name == null || (name != null && name.length() == 0))
			throw new DomainRuntimeException("Cannot search on null name.");

		DomainFactory factory = getDomainFactory();

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		String hql = "select service from Service as service left join service.serviceCategory as servCateg where service.isActive = :isActive and servCateg.id =:serviceCategId and service.upperName like :servName "; //WDEV-20219  UPPER(service.serviceName)

		markers.add("isActive");
		values.add(Boolean.TRUE);

		markers.add("serviceCategId");
		values.add(ServiceCategory.CLINICAL.getID());

		markers.add("servName");
		values.add("%" + name.toUpperCase() + "%");

		hql += " order by service.upperName asc"; //WDEV-20219  service.serviceName

		return ServiceLiteVoAssembler.createServiceLiteVoCollectionFromService(factory.find(hql, markers, values));
	}

	public ServiceConfigIntReferralForIncomingListVoCollection listReferralServicesConfig(String name)
	{
		if (name == null || (name != null && name.length() == 0))
			throw new DomainRuntimeException("Cannot search on null name.");

		DomainFactory factory = getDomainFactory();

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		String hql = "select serviceConf from ServiceConfigIntReferral as serviceConf left join serviceConf.service as service where serviceConf.active = :isActive and service.upperName like :servName "; //WDEV-20219 UPPER(service.serviceName)

		markers.add("isActive");
		values.add(Boolean.TRUE);
		markers.add("servName");
		values.add("%" + name.toUpperCase() + "%");

		hql += " order by service.serviceName asc";

		return ServiceConfigIntReferralForIncomingListVoAssembler.createServiceConfigIntReferralForIncomingListVoCollectionFromServiceConfigIntReferral(factory.find(hql, markers, values));
	}
}
