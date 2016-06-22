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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.66 build 3261.22124)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.pas.domain.objects.PendingElectiveAdmission;
import ims.core.admin.pas.vo.PendingElectiveAdmissionRefVo;
import ims.core.domain.Demographics;
import ims.core.domain.WardView;
import ims.core.domain.base.impl.BasePendingElectiveAdmissionsListComponentImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.HcpFilter;
import ims.core.vo.LocMostVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.Patient;
import ims.core.vo.PatientShort;
import ims.core.vo.PendingElectiveAdmissionHl7Vo;
import ims.core.vo.STHKPendingElectiveAdmissionListVo;
import ims.core.vo.domain.LocMostVoAssembler;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.domain.PendingElectiveAdmissionHl7VoAssembler;
import ims.core.vo.domain.STHKPendingElectiveAdmissionListVoAssembler;
import ims.core.vo.lookups.ElectiveAdmissionStatus;
import ims.core.vo.lookups.PatIdType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.ILocation;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;

import java.io.Serializable;
import java.util.ArrayList;

public class STHKPendingElectiveAdmissionsListComponentImpl extends BasePendingElectiveAdmissionsListComponentImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.STHKPendingElectiveAdmissionListVoCollection listPendingInpatients(ims.core.vo.PendingElectiveAdmissionListFilterVo voFilter)
	{
		if (voFilter == null)
			throw new CodingRuntimeException("Invalid voFilter");


		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Serializable> values = new ArrayList<Serializable>();
		boolean isCaseSensitivePatIdSearch = ConfigFlag.DOM.CASE_SENSITIVE_PATID.getValue();  //WDEV-18817

		StringBuffer sb = new StringBuffer();
		String andStr = "";

		String hql = "select pea from PendingElectiveAdmission as pea "; 

		String strSearchSurname = "";
		String strSearchForename = "";

		if (voFilter.getHospNumIsNotNull())
		{
			hql += " join pea.pasEvent.patient.identifiers as ids ";
			
			String idVal = voFilter.getHospNum().trim();			
			if (voFilter.getIDType().equals(PatIdType.NHSN))
			{
				idVal = voFilter.getHospNum().replace(" ", "");//wdev-7305
			}
			if (!isCaseSensitivePatIdSearch) //WDEV-18817
			{	
				idVal = idVal.toUpperCase();
			}
			if (voFilter.getIDType().equals(PatIdType.NHSN))
			{
				sb.append(andStr + (!isCaseSensitivePatIdSearch ? " UPPER(ids.value)" : " ids.value") + " like :idnum"); //WDEV-18817
				idVal += "%";
			}
			else
				sb.append(andStr + (!isCaseSensitivePatIdSearch ? " UPPER(ids.value)" : " ids.value") + " = :idnum"); //WDEV-18817

			markers.add("idnum");
			andStr = " and ";
			sb.append(andStr + " ids.type = :idtype");
			markers.add("idtype");

			values.add(idVal);
			values.add(getDomLookup(voFilter.getIDType()));

			sb.append(andStr + " pea.electiveAdmissionStatus = :stat");
			markers.add("stat");
			values.add(getDomLookup(ElectiveAdmissionStatus.TCI));
			andStr = " and ";
		}
		else
		{
			if(voFilter.getForenameIsNotNull())
			{
				sb.append(andStr + " pea.pasEvent.patient.name.upperForename like :patFore");
				markers.add("patFore");
				andStr = " and ";
				
				strSearchForename = voFilter.getForename().toUpperCase().trim();
				strSearchForename = strSearchForename.replaceAll("[^a-zA-Z]", "");
					
				if(strSearchForename.length() >= 40)
				{
					strSearchForename = strSearchForename.substring(0,40);
					strSearchForename += '%';
				}
				else
				{
					strSearchForename += '%';
				}
				values.add(strSearchForename);
	
			}
	
			if(voFilter.getSurnameIsNotNull())
			{
				sb.append(andStr + " pea.pasEvent.patient.name.upperSurname like :patSur");
				markers.add("patSur");
				andStr = " and ";
	
				strSearchSurname = voFilter.getSurname().toUpperCase().trim();
				strSearchSurname = strSearchSurname.replaceAll("[^a-zA-Z]", "");
					
				if(strSearchSurname.length() >= 40)
				{
					strSearchSurname = strSearchSurname.substring(0,40);
					strSearchSurname += '%';
				}
				else
				{
					strSearchSurname += '%';
				}
				values.add(strSearchSurname);
			}
		}//WDEV-13065
		
		if (voFilter.getAlertIsNotNull())
		{
			hql += " join pea.pasEvent.patient.patientAlerts as patAlerts ";

			sb.append(andStr + "patAlerts.alertType = :alertID");
			markers.add("alertID");
			values.add(getDomLookup(voFilter.getAlert()));
			andStr = " and ";
		}

		if (voFilter.getConsultantIsNotNull())
		{
			sb.append(andStr + " pea.pasEvent.consultant.id = :cons");
			markers.add("cons");
			values.add(voFilter.getConsultant().getID_Hcp());
			andStr = " and ";
		}
		
		if (voFilter.getWardIsNotNull())
		{
			sb.append(andStr + " pea.allocatedWard.id = :ward");
			markers.add("ward");
			values.add(voFilter.getWard().getID_Location());
			andStr = " and ";
		}
		
		else if (voFilter.getHospitalIsNotNull())
		{			
			LocationLiteVoCollection wards = listWards(voFilter.getHospital().getID_Location(), null);
			if (wards.size() > 0)
			{	
				sb.append(andStr + " (pea.pasEvent.location.id in " + getWardIds(wards));
				sb.append(" OR ");
			}
			
			sb.append((wards.size() > 0 ? "" : andStr) + " pea.pasEvent.location.parentLocation.id = :hosp" + (wards.size() > 0 ? ")" : ""));
			markers.add("hosp");
			values.add(voFilter.getHospital().getID_Location());		
			andStr = " and ";
		}		
		if (voFilter.getTCIIsNotNull())
		{ 
			if (voFilter.getTCIDateOnlyIsNotNull()
				&& voFilter.getTCIDateOnly())
			{
				sb.append(andStr + " ( pea.tCIDate >= :tci1 ");
				markers.add("tci1");
				values.add(new DateTime(voFilter.getTCI(), new Time("00:00:00")).getJavaDate());
				andStr = " and ";
				sb.append(andStr + " pea.tCIDate <= :tci2 )");
				markers.add("tci2");
				values.add(new DateTime(voFilter.getTCI(), new Time("23:59:59")).getJavaDate());
				andStr = " and ";
			}
			else
			{
				sb.append(andStr + " pea.tCIDate <= :tci");
				markers.add("tci");
				values.add(new DateTime(voFilter.getTCI(), new Time("23:59:59")).getJavaDate());
				andStr = " and ";
			}
			sb.append(andStr + " pea.tCIDate <= :tci");
			markers.add("tci");
			values.add(new DateTime(voFilter.getTCI(), new Time("23:59:59")).getJavaDate());
			andStr = " and ";
		}
		
		if (voFilter.getSpecialtyIsNotNull())
		{
			sb.append(andStr + " pea.pasEvent.specialty = :spec");
			markers.add("spec");
			values.add(getDomLookup(voFilter.getSpecialty()));
			andStr = " and ";
		}
		

		sb.append(andStr + " pea.electiveAdmissionStatus = :stat");
		markers.add("stat");
		values.add(getDomLookup(ElectiveAdmissionStatus.TCI));
		andStr = " and ";
		
		hql += " where ";
		hql += sb.toString();
		return STHKPendingElectiveAdmissionListVoAssembler.createSTHKPendingElectiveAdmissionListVoCollectionFromPendingElectiveAdmission(getDomainFactory().find(hql.toString(), markers, values));
	}
	//WDEV-20258
	private String getWardIds(LocationLiteVoCollection wards)
	{
		if (wards == null || wards.size() == 0)
			return "";
		
		StringBuilder idList = new StringBuilder();
		idList.append("(");
		
		for (int i=0; i<wards.size();i++)
		{
			if (wards.get(i) == null)
				continue;
			idList.append(wards.get(i).getID_Location().toString()).append(i == wards.size() - 1 ? ")": ", ");			
		}
		
		return idList.toString();
	}
	public ims.core.vo.HcpLiteVoCollection listHCPs(ims.core.vo.HcpFilter filter)
	{
		HcpAdmin implHcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return implHcpAdmin.listHcpLite(filter);
	}

	public ims.core.vo.HcpLiteVo getHCP(Integer idHCP)
	{
		HcpAdmin implHcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		HcpFilter voFilter = new HcpFilter();
		voFilter.setID_Hcp(idHCP);
		return implHcpAdmin.getHcpLite(voFilter);
	}

	public ims.core.vo.LocationLiteVo getWard(ims.core.resource.place.vo.LocationRefVo voWardRef)
	{
		OrganisationAndLocation implLoc = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		return implLoc.getLocation(voWardRef.getID_Location());
	}

	public LocationLiteVoCollection listWards(Integer hospitalID, String searchName)
	{
		OrganisationAndLocation implLoc = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		LocationRefVo voRef = new LocationRefVo();
		voRef.setID_Location(hospitalID);
		return implLoc.listActiveWardsForHospitalByNameLite(voRef, searchName);
	}

	public LocationLiteVoCollection listActiveHospitalsLite()
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.listActiveHospitalsLite();		
	}

	public PatientShort getPatientShort(PatientRefVo patientRefVo) 
	{
		Demographics impl = (Demographics) getDomainImpl(DemographicsImpl.class);
		Patient voPat = impl.getPatient(patientRefVo);		

		if (voPat != null)
			return (PatientShort)voPat;
		else
			return null;
	}

	public LocationLiteVo getHospital(LocationRefVo locationRefvo) 
	{
		DomainFactory factory = getDomainFactory();
		return LocationLiteVoAssembler.create((Location) factory.getDomainObject(Location.class, locationRefvo.getID_Location()));
	}

	public PendingElectiveAdmissionHl7Vo saveDUMMYELECTIVEADMISSION(PendingElectiveAdmissionHl7Vo voToSave)
	{
		if(voToSave == null || !voToSave.isValidated())
			throw new CodingRuntimeException("Object is null or has not been validated");
		
		DomainFactory factory = getDomainFactory();
		PendingElectiveAdmission domSocialHistory = PendingElectiveAdmissionHl7VoAssembler.extractPendingElectiveAdmission(factory,voToSave);
		try {
			factory.save(domSocialHistory);
		} catch (StaleObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return PendingElectiveAdmissionHl7VoAssembler.create(domSocialHistory);
	}

	public STHKPendingElectiveAdmissionListVo getCurrentPendingRecord(PendingElectiveAdmissionRefVo electiveRefVo) 
	{
		DomainFactory factory = getDomainFactory();
		return STHKPendingElectiveAdmissionListVoAssembler.create((PendingElectiveAdmission) factory.getDomainObject(PendingElectiveAdmission.class, electiveRefVo.getID_PendingElectiveAdmission()));
	}

	public STHKPendingElectiveAdmissionListVo savePendingRecord(STHKPendingElectiveAdmissionListVo voPending) throws DomainInterfaceException, StaleObjectException 
	{
		if (!voPending.isValidated())
			throw new CodingRuntimeException("Pending Record has not been validated");
		if(voPending == null)
			throw new CodingRuntimeException("Cannot save null STHKPendingElectiveAdmissionListVo");
		
		DomainFactory factory = getDomainFactory();
		
		PendingElectiveAdmission doElective = STHKPendingElectiveAdmissionListVoAssembler.extractPendingElectiveAdmission(factory, voPending);
		factory.save(doElective);
		return (STHKPendingElectiveAdmissionListVoAssembler.create(doElective));		
	}

	public LocMostVo getLocation(LocationRefVo voLocRef)
	{
		DomainFactory factory = getDomainFactory();
		return LocMostVoAssembler.create((Location) factory.getDomainObject(Location.class, voLocRef.getID_Location()));
	}
	
	//WDEV-20707
	public LocationLiteVo getCurrentHospital(ILocation location) 
	{
		WardView impl = (WardView)getDomainImpl(WardViewImpl.class);
		return impl.getCurrentHospital(location);
	}

}
