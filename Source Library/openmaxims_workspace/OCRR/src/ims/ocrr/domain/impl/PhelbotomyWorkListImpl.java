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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.45 build 2389.25607)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.domain.impl;

import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.core.patient.domain.objects.Patient;
import ims.core.resource.place.domain.objects.LocSite;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.LocShortMappingsVo;
import ims.core.vo.LocShortMappingsVoCollection;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.LocShortMappingsVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.ILocation;
import ims.framework.utils.Date;
import ims.ocrr.domain.SpecimenCollectionConfig;
import ims.ocrr.domain.base.impl.BasePhlebotomyWorkListImpl;
import ims.ocrr.vo.SpecimenCollectionListConfigDetailsVoCollection;
import ims.ocrr.vo.SpecimenWorkListitemCustomVo;
import ims.ocrr.vo.SpecimenWorkListitemCustomVoCollection;
import ims.ocrr.vo.lookups.OrderInvStatus;
import ims.ocrr.vo.lookups.SpecimenCollectionMethod;
import ims.ocrr.vo.lookups.SpecimenCollectionStatus;
import ims.ocrr.vo.lookups.SpecimenCollectionTime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhelbotomyWorkListImpl extends BasePhlebotomyWorkListImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* listActiveTreatingHospitals
	*/
	public ims.core.vo.LocShortMappingsVoCollection listActiveTreatingHospitals()
	{
		OrganisationAndLocation impl  = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		
		return impl.listActiveHospitals();
	}

	public LocShortMappingsVoCollection listActiveWardsForHospital(LocationRefVo hospital, Date dateToCollect, SpecimenCollectionTime roundToCollect)
	{
		List locations = listLocations(LocationType.WARD,hospital,Boolean.TRUE,null,null,null, dateToCollect, roundToCollect);
		return  LocShortMappingsVoAssembler.createLocShortMappingsVoCollectionFromLocation(locations).sort();
	}

	public SpecimenCollectionListConfigDetailsVoCollection listSpecimenCollectionDetails(SpecimenCollectionMethod type, Date date)
	{
		SpecimenCollectionConfig impl = (SpecimenCollectionConfig) getDomainImpl(SpecimenCollectionConfigImpl.class);
		
		return impl.listSpecimenCollectionDetails(type, date);
	}

	public SpecimenWorkListitemCustomVoCollection listWorkListItems(Integer[] wards, Date dateToCollect, SpecimenCollectionTime roundToCollect)
	{
		String hql = "select s1_1.id, o1_1.instructionsToCollector, s2_1.id, s2_1.serviceName, i2_1.name, p1_1.id, p1_1.name.surname, p1_1.name.forename, l1_1.id, l1_1.name, o4_1.id, o4_1.containerQuantity, p3_1.name, dftServ.id, dftServ.serviceName, dftInvIdx.name, dftPat.id, dftPat.name.surname, dftPat.name.forename, dftPatWard.id, dftPatWard.name, dftAdultCont.id, dftAdultSpecCont.name, dftPaedCont.id, dftPaedSpecCont.name, o4_1.requiredVolume, dftAdultCont.volume, dftAdultSpecCont.volume, dftPaedCont.volume, dftPaedSpecCont.volume, dftInv.noLabelSets, o2_1.placerOrdNum, dft.placerOrdNum, o2_1.id, dft.id, o1_1.id " + 
				"from SpecimenWorkListItem as s1_1 left join s1_1.specimen as o1_1 left join o1_1.discipline as s2_1 left join o1_1.investigations as o2_1 left join o2_1.investigation as i1_1 left join i1_1.investigationIndex as i2_1 left join o1_1.order as o3_1 left join o3_1.patient as p1_1 left join p1_1.ward as l1_1 left join o1_1.containers as o4_1 left join o4_1.container as p3_1 left join s1_1.listType as l2_1 left join s1_1.roundToCollect as l3_1 left join s1_1.collectionStatus as l4_1 " +
				"left join o2_1.ordInvCurrentStatus.ordInvStatus as invCurInvStat left join s1_1.dFTOrderInvestigation as dft left join dft.ordInvCurrentStatus.ordInvStatus as dftOrdInvStat left join dft.investigation as dftInv left join dftInv.pathInvDetails as dftPathInvDet left join dftPathInvDet.specimens as dftSpec left join dftSpec.adultContainers as dftAdultCont " + 
				"left join dftAdultCont.specContainer as dftAdultSpecCont left join dftSpec.paediatricContainers as dftPaedCont left join dftPaedCont.specContainer as dftPaedSpecCont left join dftInv.providerService as provServ " +
				"left join provServ.locationService as locServ left join locServ.service as dftServ left join dftInv.investigationIndex as dftInvIdx left join dft.orderDetails as dftOrdDet left join dftOrdDet.patient as dftPat left join dftPat.ward as dftPatWard";
		
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";

		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		condStr.append(andStr + " l2_1 = :LT");
		markers.add("LT");
		values.add(getDomLookup(SpecimenCollectionMethod.INPATIENT));
		andStr = " and ";

		condStr.append(andStr + " l4_1 = :COLSTAT");
		markers.add("COLSTAT");
		values.add(getDomLookup(SpecimenCollectionStatus.FORCOLLECTION));
		andStr = " and ";
		
		//WDEV-12898
		condStr.append(andStr + " ((s1_1.specimen is not null and invCurInvStat.id <> :CANCELLEDID and invCurInvStat.id <> :CANCELREQUESTID) or ( s1_1.specimen is null and dftOrdInvStat.id <> :CANCELLEDID and dftOrdInvStat.id <> :CANCELREQUESTID)) ");
		markers.add("CANCELLEDID");
		markers.add("CANCELREQUESTID");
		values.add(OrderInvStatus.CANCELLED.getID());
		values.add(OrderInvStatus.CANCEL_REQUEST.getID());
		andStr = " and ";
		
		if (roundToCollect != null)
		{
			condStr.append(andStr + " l3_1 = :ROUND");
			markers.add("ROUND");
			values.add(getDomLookup(roundToCollect));
			andStr = " and ";
		}

		if (dateToCollect != null)
		{
			condStr.append(andStr + " s1_1.dateToCollect = :DTC");
			markers.add("DTC");
			values.add(dateToCollect.getDate());
			andStr = " and ";
		}

		if (wards != null && wards.length > 0)
		{
			condStr.append(andStr + "((s1_1.specimen is not null and l1_1.id in (");
			
			for (int i = 0; i < wards.length; i++)
			{
				if(i > 0)
					condStr.append(",");
				
				condStr.append(wards[i]);
			}
			condStr.append(" )");
			
			condStr.append(") or (s1_1.specimen is null and dftPatWard.id in (");
			
			for (int i = 0; i < wards.length; i++)
			{
				if(i > 0)
					condStr.append(",");
				
				condStr.append(wards[i]);
			}
			condStr.append(" )))");
			
			andStr = " and ";
		}
		
		if (andStr.equals(" and "))
		{
			hql += " where ";
		}
		
		hql += condStr.toString();
		hql += " order by dftPatWard.name asc, l1_1.name asc, dftPat.name.surname asc, dftPat.name.forename asc, p1_1.name.surname asc, p1_1.name.forename asc, s1_1.id, s2_1.serviceName asc, dftInvIdx.name, i2_1.name asc";

		List items = getDomainFactory().find(hql, markers, values);

		SpecimenWorkListitemCustomVoCollection coll = new SpecimenWorkListitemCustomVoCollection();
		
		for (Iterator iter = items.iterator(); iter.hasNext();)
		{
			Object[] element = (Object[]) iter.next();
			
			SpecimenWorkListitemCustomVo item = new SpecimenWorkListitemCustomVo();
			
			item.setWorkListitemId((Integer) element[0]);
			item.setInstructionsToCollector((String) element[1]);
			
			item.setServiceId(element[2] != null ? (Integer) element[2] : (Integer) element[13]);
			item.setServiceName(element[3] != null ? (String) element[3] : (String) element[14]);
			item.setInvestigation(element[4] != null ? (String) element[4] : (String) element[15]);
			item.setPatientId(element[5] != null ? (Integer) element[5] : (Integer) element[16]);
			item.setPatientSurname(element[6] != null ? (String) element[6] : (String) element[17]);
			item.setPatientForename(element[7] != null ? (String) element[7] : (String) element[18]);
			item.setWardId(element[8] != null ? (Integer) element[8] : (Integer) element[19]);
			item.setWard(element[9] != null ? (String) element[9] : (String) element[20]);
			
			item.setSpecimenContainerId(element[10] != null ? (Integer) element[10] : (Integer) element[21]);
			item.setContainerQuantity((Integer) element[11]);
			item.setAdultContainer(element[12] != null ? (String) element[12]: (String) element[22]);
			item.setAdultVolume(element[25] != null ? (Float) element[25] : (Float) element[26]);
			item.setContainerAdultVolume((Float) element[27]);
			
			item.setPaediatricContainerId((Integer) element[23]);
			item.setPaediatricContainer((String) element[24]);
			item.setPaediatricVolume((Float) element[28]);
			item.setContainerPaediatricVolume((Float) element[29]);
			item.setDftNoOfLabelSets((Integer) element[30]);
			item.setPlacerOrdNum(element[31] != null ? (String) element[31] : (String) element[32]);
			item.setOrderInvestigationId(element[33] != null ? (Integer) element[33] : (Integer) element[34]);
			item.setOrderSpecimenId(element[35] != null ? (Integer) element[35] : (Integer) element[35]);
			
			coll.add(item);
		}
		/*
		return SpecimenWorkListItemVoAssembler.createSpecimenWorkListItemVoCollectionFromSpecimenWorkListItem(
				getDomainFactory().find(hql, markers, values));
			*/
		

		return coll;
	}

	private List listLocations(LocationType locType, LocationRefVo parentLocation, Boolean activeOnly, Boolean includeReferringHosp, Boolean includeTreatingHosp, String name, Date dateToCollect, SpecimenCollectionTime roundToCollect)
	{
		DomainFactory factory = getDomainFactory();
		
		List locations;

		String hql = " from Location loc ";
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";

		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		if (locType != null)
		{
			condStr.append(andStr + " loc.type = :locType");
			markers.add("locType");
			values.add(getDomLookup(locType));
			andStr = " and ";
		}
		if (parentLocation != null)
		{
			condStr.append(andStr + " loc.parentLocation.id = :parentID");
			markers.add("parentID");
			values.add(parentLocation.getID_Location());
			andStr = " and ";
		}
		if (activeOnly != null && activeOnly.booleanValue())
		{
			condStr.append(andStr + " loc.isActive = :active");
			markers.add("active");
			values.add(activeOnly);
			andStr = " and ";
		}
		if (includeReferringHosp != null && includeReferringHosp.booleanValue())
		{
			condStr.append(andStr + " loc.referringHospital = :referring");
			markers.add("referring");
			values.add(includeReferringHosp);
			andStr = " and ";
		}
		if (includeTreatingHosp != null && includeTreatingHosp.booleanValue())
		{
			condStr.append(andStr + " loc.treatingHosp = :treating");
			markers.add("treating");
			values.add(includeTreatingHosp);
			andStr = " and ";
		}
		if (name != null)
		{
			condStr.append(andStr + " loc.upperName like :name"); //WDEV-20219
			markers.add("name");
			values.add("%" + name.toUpperCase() + "%");
			andStr = " and ";
		}
		if(dateToCollect != null && roundToCollect != null)
		{
			condStr.append(andStr + " loc.id not in (select l1_1.id " + 
					" from PhlebotomyRound as p1_1 join p1_1.wards as l1_1" + //WDEV-12893
					" where " + 
					" p1_1.date = :DATE and p1_1.roundToCollect.id = :ROUND and p1_1.isRIE is null)");
			markers.add("DATE");
			values.add(dateToCollect.getDate());
			markers.add("ROUND");
			values.add(new Integer(roundToCollect.getID()));
			andStr = " and ";
		}

		if (andStr.equals(" and "))
		{
			hql += " where ";
		}

		hql += condStr.toString();
		locations = factory.find(hql, markers, values);
		return locations;
	}

	//	WDEV-14957
	public LocationLiteVo getHospitalForCurrentLocation(ILocation currentLocation) 
	{
		if(currentLocation == null)
			throw new CodingRuntimeException("Can not get the Hospital for a null Location.");
		
		DomainFactory factory = getDomainFactory();
		Location doLocation = (Location) factory.getDomainObject(Location.class, currentLocation.getID());
		
		return getHospital(doLocation);
	}
	
	//	WDEV-14957
	private LocShortMappingsVo getHospital(Location doLocation)
	{
		if(doLocation instanceof LocSite && doLocation.getType().equals(getDomLookup(LocationType.HOSP)))
			return LocShortMappingsVoAssembler.create((LocSite) doLocation);

		while(doLocation.getParentLocation() != null)
		{
			doLocation = doLocation.getParentLocation();
			if(doLocation instanceof LocSite && doLocation.getType().equals(getDomLookup(LocationType.HOSP)))
				return LocShortMappingsVoAssembler.create((LocSite) doLocation);
		}

		return null;
	}

	public PatientShort getPatientById(Integer patientId)
	{
		
		if(patientId == null)
			throw new CodingRuntimeException("Cannot get Patient on null Id.");
		
		return PatientShortAssembler.create((Patient)getDomainFactory().getDomainObject(Patient.class, patientId));
	}
}
