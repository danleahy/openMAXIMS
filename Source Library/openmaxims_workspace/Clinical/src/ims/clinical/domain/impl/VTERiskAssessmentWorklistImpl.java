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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.clinical.domain.base.impl.BaseVTERiskAssessmentWorklistImpl;
import ims.clinical.vo.VTERemoveDeclineReasonVo;
import ims.clinical.vo.VTERiskAssessmentTCIVo;
import ims.clinical.vo.VTERiskAssessmentTCIVoCollection;
import ims.clinical.vo.VTERiskAssessmentWorklistCriteriaVo;
import ims.clinical.vo.WasVTERiskAssessmentStatusChangedVo;
import ims.clinical.vo.domain.PatientSummaryRecordForVteVoAssembler;
import ims.clinical.vo.domain.TCIForVTEWorklistVoAssembler;
import ims.clinical.vo.lookups.VTEAsessmentStatus;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.pas.domain.objects.DischargedEpisode;
import ims.core.admin.pas.domain.objects.InpatientEpisode;
import ims.core.admin.pas.domain.objects.PendingElectiveAdmission;
import ims.core.domain.objects.PatientSummaryRecord;
import ims.core.patient.domain.objects.Patient;
import ims.core.resource.place.domain.objects.LocSite;
import ims.core.resource.place.domain.objects.Location;
import ims.core.vo.DischargedEpisodeForVTERiskAssessmentWorklistVo;
import ims.core.vo.LocSiteLiteVo;
import ims.core.vo.VTEAssessmentConfigVo;
import ims.core.vo.VTERiskAssessmentWorklistVo;
import ims.core.vo.domain.DischargedEpisodeForVTERiskAssessmentWorklistVoAssembler;
import ims.core.vo.domain.LocSiteLiteVoAssembler;
import ims.core.vo.domain.PatientForVTERiskAssessmentVoAssembler;
import ims.core.vo.domain.VTEAssessmentConfigVoAssembler;
import ims.core.vo.domain.VTERiskAssessmentWorklistVoAssembler;
import ims.core.vo.lookups.ElectiveAdmissionStatus;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.PatIdType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.ILocation;
import ims.framework.utils.DateTime;
import ims.vo.interfaces.IVTERiskAssessment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VTERiskAssessmentWorklistImpl extends BaseVTERiskAssessmentWorklistImpl
{
	private static final long serialVersionUID = 1L;

	public ims.core.vo.LocSiteLiteVoCollection listHospitals()
	{
		DomainFactory factory = getDomainFactory();

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		StringBuffer hql = new StringBuffer();

		hql.append(" select hosp from LocSite as hosp left join hosp.type as hosptype");
		hql.append(" where hosp.isActive = 1 and hosp.isVirtual = 0 and hosptype.id=:HospType");
		hql.append(" order by hosp.upperName asc"); //WDEV-20219 UPPER(hosp.name)

		markers.add("HospType");
		values.add(LocationType.HOSP.getID());

		return LocSiteLiteVoAssembler.createLocSiteLiteVoCollectionFromLocSite(factory.find(hql.toString(), markers, values));
	}

	public ims.core.vo.LocationLiteVoCollection listWards(ims.core.resource.place.vo.LocationRefVo hospital, String wardName)
	{
		OrganisationAndLocation implLoc = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		return implLoc.listActiveWardsForHospitalByNameLite(hospital, wardName);
	}

	//WDEV-15414
	public List<IVTERiskAssessment> listPatients(VTERiskAssessmentWorklistCriteriaVo criteria) 
	{
		if(new VTERiskAssessmentWorklistCriteriaVo().equals(criteria))
			throw new CodingRuntimeException("At least one search criteria must be provided");
		
		//WDEV-15414 - starts here
		IVTERiskAssessment[] vteInatientList = null;
		IVTERiskAssessment[] vteDischargeList = null;
		
		if (!Boolean.TRUE.equals(criteria.getDischargedPatients()) && !Boolean.TRUE.equals(criteria.getCurrentInpatients()))
		{
			vteInatientList = listFromInpatientEpisode(criteria);
			vteDischargeList = listFromDischargeEpisode(criteria);
		}
		else 
		{
			if (Boolean.TRUE.equals(criteria.getCurrentInpatients()))
				vteInatientList = listFromInpatientEpisode(criteria);
			
			if (Boolean.TRUE.equals(criteria.getDischargedPatients()))
				vteDischargeList = listFromDischargeEpisode(criteria);
		}
		
		
		if(vteInatientList == null && vteDischargeList == null)
			return null;
		
		List<IVTERiskAssessment> vteList = new ArrayList<IVTERiskAssessment>();
		
		if(vteInatientList != null)
		{
			for(int i=0; i<vteInatientList.length; i++)
			{
				vteList.add(vteInatientList[i]);
			}
		}
		
		if(vteDischargeList != null)
		{
			for(int i=0; i<vteDischargeList.length; i++)
			{
				vteList.add(vteDischargeList[i]);
			}
		}
		
		return vteList;
		//WDEV-15414 - ends here
	}

	//WDEV-15414
	private IVTERiskAssessment[] listFromDischargeEpisode(VTERiskAssessmentWorklistCriteriaVo criteria) 
	{
		if(criteria != null && criteria.getCurrentWard() != null)
			return null;
		
		StringBuilder hqlJoins = new StringBuilder("select dis from DischargedEpisode as dis left join dis.admissionDetail as ad left join dis.wardStays as w1_1 left join w1_1.ward as l1_1 left join dis.pasEvent as pe left join pe.location as l left join dis.vTEAssessmentStatus as vteStatus"); 
		StringBuilder hqlConditions = new StringBuilder(" where vteStatus is not null and vteStatus.id <> :vteStatusDeclinedId ");  
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("vteStatusDeclinedId");
		paramValues.add(VTEAsessmentStatus.VALIDATION_DECLINED.getID());
		
		boolean isCaseSensitivePatIdSearch = ConfigFlag.DOM.CASE_SENSITIVE_PATID.getValue(); //WDEV-18817
		String and = " and ";
		
		boolean patientJoin = false;
		
		if(criteria.getWardIsNotNull())
		{
			hqlConditions.append(and);
			hqlConditions.append(" (w1_1.id = (select min (w1_2.id) from DischargedEpisode as d1_2 left join d1_2.wardStays as w1_2 where (d1_2.id = dis.id)) and l1_1.id = :wardId) "); //wdev-14922
			paramNames.add("wardId");
			paramValues.add(criteria.getWard().getID());
		}
		else if(criteria.getHospitalIsNotNull())
		{
			hqlConditions.append(and);
			hqlConditions.append(" (w1_1.id = (select min (w1_2.id) from DischargedEpisode as d1_2 left join d1_2.wardStays as w1_2 where (d1_2.id = dis.id)) and l1_1.parentLocation.id = :hospId) ");//	WDEV-15040
			paramNames.add("hospId");
			paramValues.add(criteria.getHospital().getID());
		}
		
		if(criteria.getAdmissionDateFromIsNotNull())
		{
				hqlConditions.append(and);
				hqlConditions.append(" ad.admissionDateTime >= :DateFrom ");
				paramNames.add("DateFrom");
				paramValues.add(criteria.getAdmissionDateFrom().getJavaDate());
		}
			
		if (criteria.getAdmissionDateToIsNotNull())
		{
				hqlConditions.append(and);
				hqlConditions.append(" ad.admissionDateTime <= :DateTo ");
				paramNames.add("DateTo");
				paramValues.add(criteria.getAdmissionDateTo().getJavaDate());
		}
		
		if(Boolean.TRUE.equals(criteria.getOver24Hours()))
		{
			DateTime currentTime = new DateTime();
			currentTime.addDays(-1);
			
			hqlConditions.append(and);
			hqlConditions.append(" ad.admissionDateTime < :Over24Hours ");
			paramNames.add("Over24Hours");
			paramValues.add(currentTime.getJavaDate());
		}
		
		if(criteria.getConsultantIsNotNull())
		{
			hqlJoins.append(" left join pe.consultant as consultant ");
			hqlConditions.append(and);
			hqlConditions.append("consultant.id = :consultantId");
			paramNames.add("consultantId");
			paramValues.add(criteria.getConsultant().getIMosHcpId());
		}
	
		if (criteria.getSpecialtyIsNotNull())
		{
			hqlJoins.append(" left join pe.specialty as spec ");
			hqlConditions.append(and);
			hqlConditions.append("spec.id = :specId");
			paramNames.add("specId");
			paramValues.add(criteria.getSpecialty().getID());
		}
		
		if (criteria.getVTEStatusIsNotNull())
		{
			hqlConditions.append(and);
			
			//search for both Completed and Validated VTEs
			if (VTEAsessmentStatus.COMPLETED.equals(criteria.getVTEStatus()))
			{
				hqlConditions.append("(vteStatus.id = :completedStatusId or vteStatus.id = :validatedStatusId) ");
				
				paramNames.add("completedStatusId");
				paramValues.add(VTEAsessmentStatus.COMPLETED.getID());
				
				paramNames.add("validatedStatusId");
				paramValues.add(VTEAsessmentStatus.VALIDATED.getID());
			}
			else
			{
				hqlConditions.append("vteStatus.id = :vteStatusId");
				paramNames.add("vteStatusId");
				paramValues.add(criteria.getVTEStatus().getID());
			}
			
		}
		
		if(criteria.getSurnameIsNotNull())
		{
			if(!patientJoin)
			{
				hqlJoins.append(" left join pe.patient as pat ");
				patientJoin = true;
			}
			
			hqlConditions.append(and);
			hqlConditions.append("pat.name.upperSurname like :Surname");
			paramNames.add("Surname");
			paramValues.add(formatName(criteria.getSurname()));
		}
		
		if(criteria.getForenameIsNotNull())
		{
			if(!patientJoin)
			{
				hqlJoins.append(" left join pe.patient as pat ");
				patientJoin = true;
			}
			
			hqlConditions.append(and);
			hqlConditions.append("pat.name.upperForename like :Forename");
			paramNames.add("Forename");
			paramValues.add(formatName(criteria.getForename()));
		}
		
		if(criteria.getPatIdValueIsNotNull() && criteria.getPatIdTypeIsNotNull())
		{
			if(!patientJoin)
			{
				hqlJoins.append(" left join pe.patient as pat ");
				patientJoin = true;
			}
			
			hqlJoins.append(" left join pat.identifiers as patId left join patId.type as type ");
			hqlConditions.append(and);
			hqlConditions.append(" type.id = :patTypeId ");
			paramNames.add("patTypeId");
			paramValues.add(criteria.getPatIdType().getID());
			hqlConditions.append(and);
			if (!isCaseSensitivePatIdSearch) //WDEV-18817
			{
				criteria.setPatIdValue(criteria.getPatIdValue().toUpperCase());
			}
			hqlConditions.append((!isCaseSensitivePatIdSearch ? " UPPER(patId.value)" : " patId.value" ) + " = :patId "); //WDEV-18817
			paramNames.add("patId");
			if (criteria.getPatIdType().equals(PatIdType.NHSN))
			{
				
				paramValues.add(criteria.getPatIdValue().replace(" ", ""));
			}
			else
			{
				paramValues.add(criteria.getPatIdValue().trim()); //WDEV-18817
			}
		}
		
		if (criteria.getDOB() != null && !criteria.getDOB().toString().equals("__/__/____"))
		{
			if(!patientJoin)
			{
				hqlJoins.append(" left join pe.patient as pat ");
				patientJoin = true;
			}
			
			hqlConditions.append(and);
			hqlConditions.append(" pat.dob  between :dobFrom and :dobTo ");
			
			paramNames.add("dobFrom");
			paramNames.add("dobTo");
			Integer[] range = criteria.getDOB().toSearchRange();
			paramValues.add(range[0]);
			paramValues.add(range[1]);
		}
		
		hqlConditions.append(" order by ad.admissionDateTime asc");
		
		List<?> dischargeList = getDomainFactory().find(hqlJoins.append(hqlConditions.toString()).toString(), paramNames, paramValues);
		
		return DischargedEpisodeForVTERiskAssessmentWorklistVoAssembler.createDischargedEpisodeForVTERiskAssessmentWorklistVoCollectionFromDischargedEpisode(dischargeList).toIVTERiskAssessmentArray();
	}

	//WDEV-15414
	private IVTERiskAssessment[] listFromInpatientEpisode(VTERiskAssessmentWorklistCriteriaVo criteria) 
	{
		StringBuilder hqlJoins = new StringBuilder("select inpat from InpatientEpisode as inpat left join inpat.wardStays as w1_1 left join w1_1.ward as l1_1 left join inpat.pasEvent as pe left join inpat.vTEAssessmentStatus as vteStatus"); //wdev-14922
		StringBuilder hqlConditions = new StringBuilder(" where vteStatus is not null ");  //wdev-14992
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		String and = " and ";
		boolean isCaseSensitivePatIdSearch = ConfigFlag.DOM.CASE_SENSITIVE_PATID.getValue();
		
		boolean patientJoin = false;
		
		if(criteria.getWardIsNotNull())
		{
			hqlConditions.append(and);
			hqlConditions.append(" (w1_1.id = (select min (w1_2.id) from InpatientEpisode as i1_2 left join i1_2.wardStays as w1_2 where (i1_2.id = inpat.id)) and l1_1.id = :wardId) "); //wdev-14922
			//hqlConditions.append(" l.id = :wardId ");
			paramNames.add("wardId");
			paramValues.add(criteria.getWard().getID());
		}
		if(criteria.getCurrentWard() != null)
		{
			if(!patientJoin)
			{
				hqlJoins.append(" left join pe.patient as pat ");
				patientJoin = true;
			}
			
			hqlJoins.append(" left join pat.ward as currentWard ");
			hqlConditions.append(and);
			hqlConditions.append(" currentWard.id = :currentWardId ");
			paramNames.add("currentWardId");
			paramValues.add(criteria.getCurrentWard().getID());
		}
		
		if(criteria.getWard() == null && criteria.getCurrentWard() == null && criteria.getHospitalIsNotNull())
		{
			hqlConditions.append(and);
			hqlConditions.append(" (w1_1.id = (select min (w1_2.id) from InpatientEpisode as i1_2 left join i1_2.wardStays as w1_2 where (i1_2.id = inpat.id)) and l1_1.parentLocation.id = :hospId) ");//	WDEV-15040
			//hqlConditions.append(" l.parentLocation.id = :hospId ");
			paramNames.add("hospId");
			paramValues.add(criteria.getHospital().getID());
		}
		
		if(criteria.getAdmissionDateFromIsNotNull())
		{
				hqlConditions.append(and);
				hqlConditions.append(" inpat.admissionDateTime >= :DateFrom ");
				paramNames.add("DateFrom");
				paramValues.add(criteria.getAdmissionDateFrom().getJavaDate());
		}
			
		if (criteria.getAdmissionDateToIsNotNull())
		{
				hqlConditions.append(and);
				hqlConditions.append(" inpat.admissionDateTime <= :DateTo ");
				paramNames.add("DateTo");
				paramValues.add(criteria.getAdmissionDateTo().getJavaDate());
		}
		
		if(Boolean.TRUE.equals(criteria.getOver24Hours()))
		{
			DateTime currentTime = new DateTime();
			currentTime.addDays(-1);
			
			hqlConditions.append(and);
			hqlConditions.append(" inpat.admissionDateTime < :Over24Hours ");
			paramNames.add("Over24Hours");
			paramValues.add(currentTime.getJavaDate());
		}
		
		if(criteria.getConsultantIsNotNull())
		{
			hqlJoins.append(" left join pe.consultant as consultant ");
			hqlConditions.append(and);
			hqlConditions.append("consultant.id = :consultantId");
			paramNames.add("consultantId");
			paramValues.add(criteria.getConsultant().getIMosHcpId());
		}
	
		if (criteria.getSpecialtyIsNotNull())
		{
			hqlJoins.append(" left join pe.specialty as spec ");
			hqlConditions.append(and);
			hqlConditions.append("spec.id = :specId");
			paramNames.add("specId");
			paramValues.add(criteria.getSpecialty().getID());
		}
		
		if (criteria.getVTEStatusIsNotNull())
		{
			hqlConditions.append(and);
			
			//search for both Completed and Validated VTEs
			if (VTEAsessmentStatus.COMPLETED.equals(criteria.getVTEStatus()))
			{
				hqlConditions.append("(vteStatus.id = :completedStatusId or vteStatus.id = :validatedStatusId) ");
				
				paramNames.add("completedStatusId");
				paramValues.add(VTEAsessmentStatus.COMPLETED.getID());
				
				paramNames.add("validatedStatusId");
				paramValues.add(VTEAsessmentStatus.VALIDATED.getID());
			}
			else
			{
				hqlConditions.append("vteStatus.id = :vteStatusId");
				paramNames.add("vteStatusId");
				paramValues.add(criteria.getVTEStatus().getID());
			}
		}
		
		if(criteria.getSurnameIsNotNull())
		{
			if(!patientJoin)
			{
				hqlJoins.append(" left join pe.patient as pat ");
				patientJoin = true;
			}
			
			hqlConditions.append(and);
			hqlConditions.append("pat.name.upperSurname like :Surname");
			paramNames.add("Surname");
			paramValues.add(formatName(criteria.getSurname()));
		}
		
		if(criteria.getForenameIsNotNull())
		{
			if(!patientJoin)
			{
				hqlJoins.append(" left join pe.patient as pat ");
				patientJoin = true;
			}
			
			hqlConditions.append(and);
			hqlConditions.append("pat.name.upperForename like :Forename");
			paramNames.add("Forename");
			paramValues.add(formatName(criteria.getForename()));
		}
		
		if(criteria.getPatIdValueIsNotNull() && criteria.getPatIdTypeIsNotNull())
		{
			if(!patientJoin)
			{
				hqlJoins.append(" left join pe.patient as pat ");
				patientJoin = true;
			}
			
			hqlJoins.append(" left join pat.identifiers as patId left join patId.type as type ");
			hqlConditions.append(and);
			hqlConditions.append(" type.id = :patTypeId ");
			paramNames.add("patTypeId");
			paramValues.add(criteria.getPatIdType().getID());
			hqlConditions.append(and);
			if (!isCaseSensitivePatIdSearch) //WDEV-18817
			{
				criteria.setPatIdValue(criteria.getPatIdValue().toUpperCase());
			}
				
			hqlConditions.append((!isCaseSensitivePatIdSearch ? " UPPER(patId.value)" : " patId.value" ) + " = :patId "); //WDEV-18817
			paramNames.add("patId");
			if (criteria.getPatIdType().equals(PatIdType.NHSN))
			{
				
				paramValues.add(criteria.getPatIdValue().replace(" ", "")); //WDEV-18817
			}
			else
			{
				paramValues.add(criteria.getPatIdValue().trim()); //WDEV-18817
			}
		}
		
		if (criteria.getDOB() != null && !criteria.getDOB().toString().equals("__/__/____"))
		{
			if(!patientJoin)
			{
				hqlJoins.append(" left join pe.patient as pat ");
				patientJoin = true;
			}
			
			hqlConditions.append(and);
			hqlConditions.append(" pat.dob  between :dobFrom and :dobTo ");
			
			paramNames.add("dobFrom");
			paramNames.add("dobTo");
			Integer[] range = criteria.getDOB().toSearchRange();
			paramValues.add(range[0]);
			paramValues.add(range[1]);
		}
		
		hqlConditions.append(" order by inpat.admissionDateTime asc");
		
		List<?> inpatList = getDomainFactory().find(hqlJoins.append(hqlConditions.toString()).toString(), paramNames, paramValues);
		
		return VTERiskAssessmentWorklistVoAssembler.createVTERiskAssessmentWorklistVoCollectionFromInpatientEpisode(inpatList).toIVTERiskAssessmentArray();
	}

	public LocSiteLiteVo getCurrentHospital(ILocation location) 
	{
		if(location == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		Location currentHospital = getHospital((Location) factory.getDomainObject(Location.class, location.getID()));
		
		if(currentHospital instanceof LocSite)
			return LocSiteLiteVoAssembler.create((LocSite) currentHospital);
		
		return null;
	}
	
	private Location getHospital(Location doLocation)
	{
		if(doLocation == null)
			return null;
		
		if(doLocation instanceof Location && doLocation.getType().equals(getDomLookup(LocationType.HOSP)))
			return doLocation;
	
		while(doLocation.getParentLocation() != null) 
		{
			doLocation = doLocation.getParentLocation();
			if(doLocation instanceof Location && doLocation.getType().equals(getDomLookup(LocationType.HOSP)))
				return doLocation;
		}
		
		return null;
	}
	
	private Object formatName(String surname)
	{
		if(surname == null)
			return null;
		
		String strSearch = surname.toUpperCase().trim();
		strSearch = strSearch.replaceAll("[^a-zA-Z]", "");
			
		strSearch += '%';
			
		return strSearch;
	}

	//WDEV-15414, WDEV-15986
	public WasVTERiskAssessmentStatusChangedVo wasStatusChanged(IVTERiskAssessment episode,  VTEAsessmentStatus currentStatus)
	{
		if(episode == null || episode.getId() == null)
			throw new CodingRuntimeException("Cannot check the status for a null Episode ID.");
		
		DomainFactory factory = getDomainFactory();
		String query = null;//WDEV-15414
		List<?> list = null;//WDEV-15414
		
		//WDEV-15414
		if(episode instanceof VTERiskAssessmentWorklistVo)
		{
			query = "select ie from InpatientEpisode as ie where ie.id = :EpisodeId";
		}
		//WDEV-15414
		else if(episode instanceof DischargedEpisodeForVTERiskAssessmentWorklistVo)
		{
			query = "select de from DischargedEpisode as de where de.id = :EpisodeId";
		}
		
		list = factory.find(query, new String[] {"EpisodeId"}, new Object[] {episode.getId()});//WDEV-15414
		
		IVTERiskAssessment currentEpisode = null;
		if(list != null && list.size() > 0)
		{
			if(episode instanceof VTERiskAssessmentWorklistVo)
			{
				currentEpisode = VTERiskAssessmentWorklistVoAssembler.create((InpatientEpisode) list.get(0));
			}
			else if(episode instanceof DischargedEpisodeForVTERiskAssessmentWorklistVo)
			{
				currentEpisode = DischargedEpisodeForVTERiskAssessmentWorklistVoAssembler.create((DischargedEpisode) list.get(0));
			}
		}
		
		if(currentEpisode == null || currentStatus == null)
			return null;
		
		WasVTERiskAssessmentStatusChangedVo wasChanged = new WasVTERiskAssessmentStatusChangedVo();
		if(currentStatus.equals(currentEpisode.getVTEAssessmentStatus()))
		{
			wasChanged.setWasStatusChanged(false);
			wasChanged.setVTEStatus(null);
		}
		else
		{
			wasChanged.setWasStatusChanged(true);
			wasChanged.setVTEStatus(currentEpisode.getVTEAssessmentStatus());
		}
		
		return wasChanged;
	}

	//WDEV-15414
	public IVTERiskAssessment saveEpisode(IVTERiskAssessment vteRiskAssessment, VTERemoveDeclineReasonVo removedReason)	throws StaleObjectException 
	{
		if(vteRiskAssessment == null)
			throw new CodingRuntimeException("Cannot save a null Episode.");
		
		DomainFactory factory = getDomainFactory();
		
		// Try to see if an Inpatient Episode is found for the PasEvent
		String queryInpatient = "SELECT inpEp FROM InpatientEpisode AS inpEp LEFT JOIN inpEp.pasEvent AS pasEv WHERE pasEv.id = :PAS_ID";
		InpatientEpisode inpEpisode = (InpatientEpisode) factory.findFirst(queryInpatient, "PAS_ID", vteRiskAssessment.getPasEvent().getID_PASEvent());
		
		if (inpEpisode != null)
		{
			inpEpisode.setVTEAssessmentStatus(getDomLookup(VTEAsessmentStatus.COMPLETED));
			
			if (removedReason != null && removedReason.getReason() != null)
				inpEpisode.setVTEAssessmentStatusReason(getDomLookup(removedReason.getReason()));
			
			factory.save(inpEpisode);
			return VTERiskAssessmentWorklistVoAssembler.create(inpEpisode);
		}
		
		// If no Inpatient Episode is found, try to find a Discharged Episode for the PasEvent
		String queryDischarge = "SELECT disEp FROM DischargedEpisode AS disEp LEFT JOIN disEp.pasEvent AS pasEv WHERE pasEv.id = :PAS_ID";
		DischargedEpisode disEpisode = (DischargedEpisode) factory.findFirst(queryDischarge, "PAS_ID", vteRiskAssessment.getPasEvent().getID_PASEvent());
		
		if (disEpisode != null)
		{
			disEpisode.setVTEAssessmentStatus(getDomLookup(VTEAsessmentStatus.COMPLETED));
			
			if (removedReason != null && removedReason.getReason() != null)
				disEpisode.setVTEAssessmentStatusReason(getDomLookup(removedReason.getReason()));
			
			factory.save(disEpisode);
			return DischargedEpisodeForVTERiskAssessmentWorklistVoAssembler.create(disEpisode);
		}
			
		return null;
	}

	public VTERiskAssessmentTCIVoCollection listFromTCI(VTERiskAssessmentWorklistCriteriaVo criteria)
	{
		StringBuilder hqlJoins =  new StringBuilder("select pea, pat, summaryRec from PendingElectiveAdmission as pea left join pea.electiveAdmissionStatus as admissionStatus left join pea.pasEvent as pasEv left join pasEv.patient as pat ");
					  hqlJoins.append(", PatientSummaryRecord as summaryRec right join summaryRec.patient as summaryRecPat left join summaryRec.preOpVTEAssessment as preOpVteAssessment left join summaryRec.inpatientVTEAssessment as inpVTEAssessment");
		
		StringBuilder hqlConditions = new StringBuilder(" where pea.tCIDate = :tciDate and admissionStatus.id = :admissionStatusID and pat.id = summaryRecPat.id and (preOpVteAssessment.isRIE is null or preOpVteAssessment.isRIE = 0) and (inpVTEAssessment.isRIE is null or inpVTEAssessment.isRIE = 0)");
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		boolean isCaseSensitivePatIdSearch = ConfigFlag.DOM.CASE_SENSITIVE_PATID.getValue();
		
		if(criteria.getCurrentWard() != null)
		{
			hqlJoins.append(" left join pea.allocatedWard as tciW ");
			hqlConditions.append("and tciW.id = :wardId ");
			paramNames.add("wardId");
			paramValues.add(criteria.getCurrentWard().getID());
		}
		
		if(criteria.getConsultant() != null)
		{
			hqlJoins.append(" left join pea.referringConsultant as tciCons ");
			hqlConditions.append("and tciCons.id = :consultantId ");
			paramNames.add("consultantId");
			paramValues.add(criteria.getConsultant().getIMosHcpId());
		}
		
		if(criteria.getSurnameIsNotNull())
		{
			hqlConditions.append("and pat.name.upperSurname like :Surname ");
			paramNames.add("Surname");
			paramValues.add(formatName(criteria.getSurname()));
		}
		
		if(criteria.getForenameIsNotNull())
		{
			
			hqlConditions.append("and pat.name.upperForename like :Forename ");
			paramNames.add("Forename");
			paramValues.add(formatName(criteria.getForename()));
		}
		
		if(criteria.getPatIdValueIsNotNull() && criteria.getPatIdTypeIsNotNull())
		{
			
			hqlJoins.append(" left join pat.identifiers as patId left join patId.type as type ");
			hqlConditions.append("and  type.id = :patTypeId ");
			paramNames.add("patTypeId");
			paramValues.add(criteria.getPatIdType().getID());
			
			if (!isCaseSensitivePatIdSearch)
			{
				criteria.setPatIdValue(criteria.getPatIdValue().toUpperCase());
			}
			
			hqlConditions.append("and ");	
			hqlConditions.append((!isCaseSensitivePatIdSearch ? " UPPER(patId.value)" : " patId.value" ) + " = :patId "); //WDEV-18817
			paramNames.add("patId");
			if (criteria.getPatIdType().equals(PatIdType.NHSN))
			{
				
				paramValues.add(criteria.getPatIdValue().replace(" ", ""));
			}
			else
			{
				paramValues.add(criteria.getPatIdValue().trim());
			}
		}
		
		if (criteria.getDOB() != null && !criteria.getDOB().toString().equals("__/__/____"))
		{
			
			hqlConditions.append("and pat.dob  between :dobFrom and :dobTo ");
			
			paramNames.add("dobFrom");
			paramNames.add("dobTo");
			Integer[] range = criteria.getDOB().toSearchRange();
			paramValues.add(range[0]);
			paramValues.add(range[1]);
		}
		
		paramNames.add("tciDate");
		paramValues.add(new Date());
		
		paramNames.add("admissionStatusID");
		paramValues.add(ElectiveAdmissionStatus.TCI.getID());
		
		List<?> items = getDomainFactory().find(hqlJoins.append(hqlConditions).toString(), paramNames, paramValues);
		
		if (items == null || items.size() == 0)
			return null;
		
		VTERiskAssessmentTCIVoCollection tciColl = new VTERiskAssessmentTCIVoCollection();
		
		for (int i = 0; i < items.size(); i++)
		{
			VTERiskAssessmentTCIVo tciToAdd = new VTERiskAssessmentTCIVo();
			
			Object[] element = (Object[]) items.get(i);
			
			tciToAdd.setTCI(element[0] != null ?  TCIForVTEWorklistVoAssembler.create((PendingElectiveAdmission) element[0]) : null);
			tciToAdd.setPatient(element[1] != null ? PatientForVTERiskAssessmentVoAssembler.create((Patient) element[1]) : null);
			tciToAdd.setPatientSummaryRecord(element[2] != null ? PatientSummaryRecordForVteVoAssembler.create((PatientSummaryRecord) element[2]) : null);			
			tciColl.add(tciToAdd);
		}
		
		return tciColl;
	}
	
	public VTEAssessmentConfigVo getVteConfig()
	{

		List list = getDomainFactory().find("select config from VTEAssessmentConfig as config ");
			
		if (list == null || list.size() == 0)
			return null;
		
		return VTEAssessmentConfigVoAssembler.createVTEAssessmentConfigVoCollectionFromVTEAssessmentConfig(list).get(0);
	}
}
