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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 5360.17707)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.PatientElectiveList;
import ims.RefMan.vo.BookAppointmentForWardAttendersVoCollection;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.PatientElectiveListBedAdmissionVo;
import ims.RefMan.vo.PatientElectiveListBedInfoVoCollection;
import ims.RefMan.vo.PatientElectiveListRefVo;
import ims.RefMan.vo.domain.PatientElectiveListBedAdmissionVoAssembler;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.domain.objects.CareSpell;
import ims.core.admin.pas.domain.objects.PASEvent;
import ims.core.admin.pas.vo.PendingEmergencyAdmissionRefVo;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.clinical.vo.ServiceRefVo;
import ims.core.domain.BedAdmissionComponent;
import ims.core.domain.base.impl.BaseAdmitToWardImpl;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.resource.people.domain.objects.Medic;
import ims.core.resource.people.vo.MedicRefVo;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.AdmissionDetailVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.CareContextShortVoCollection;
import ims.core.vo.CareSpellAdmitVo;
import ims.core.vo.CatsReferralEmergencyAdmissionVo;
import ims.core.vo.CatsReferralPendingEmergencyNonEDAdmissionListVo;
import ims.core.vo.CatsReferralPendingEmergencyNonEDAdmissionListVoCollection;
import ims.core.vo.ConsultantStayVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.MedicLiteVo;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.MedicVo;
import ims.core.vo.PasEventAdmitVo;
import ims.core.vo.PatientCaseNoteTransferVoCollection;
import ims.core.vo.PatientCaseNoteVoCollection;
import ims.core.vo.PatientLite_IdentifiersVo;
import ims.core.vo.PatientLite_IdentifiersVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.PatientWithGPForCCGVo;
import ims.core.vo.PendingElectiveAdmissionAdmitVo;
import ims.core.vo.PendingEmergencyAdmissionAdmitVo;
import ims.core.vo.ServiceLiteVoCollection;
import ims.core.vo.TrackingForPendingEmergencyAdmitVoCollection;
import ims.core.vo.WardStayVo;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.CareSpellAdmitVoAssembler;
import ims.core.vo.domain.CatsReferralEmergencyAdmissionVoAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.domain.MedicLiteVoAssembler;
import ims.core.vo.domain.MedicVoAssembler;
import ims.core.vo.domain.PatientCaseNoteVoAssembler;
import ims.core.vo.domain.PatientLite_IdentifiersVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.enums.AdmissionType;
import ims.core.vo.lookups.AlertType;
import ims.core.vo.lookups.CaseNoteStatus;
import ims.core.vo.lookups.ContextType;
import ims.core.vo.lookups.MedicGrade;
import ims.core.vo.lookups.PatIdType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.interfaces.ILocation;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.scheduling.vo.Booking_AppointmentRefVo;
import ims.vo.interfaces.IMos;

import java.util.ArrayList;
import java.util.List;

public class AdmitToWardImpl extends BaseAdmitToWardImpl
{
	private static final long serialVersionUID = 1L;
	
	public ims.core.vo.LocationLiteVo getLocationLite(ims.core.resource.place.vo.LocationRefVo location)
	{
		if (location == null || location.getID_Location() == null)
			return null;
		
		return LocationLiteVoAssembler.create((Location) getDomainFactory().getDomainObject(Location.class, location.getID_Location()));
	}


	public String checkForPatientAlreadyAdmited(PatientRefVo patient)
	{
		BedAdmissionComponent impl = (BedAdmissionComponent) getDomainImpl(BedAdmissionComponentImpl.class);
		return impl.checkForPatientAlreadyAdmited(patient);
	}

	public Boolean saveAdmissionAndUpdateList(AdmissionDetailVo admissionDetail, WardStayVo wardStay, ConsultantStayVo consultantStay, CareSpellAdmitVo careSpell, CatsReferralEmergencyAdmissionVo referral, Object selectedAdmissionData, PatientCaseNoteTransferVoCollection caseNoteTransfers) throws DomainInterfaceException, StaleObjectException, UniqueKeyViolationException
	{
//		AdmissionDetail domAdmissionDetail = AdmissionDetailShortVoAssembler.extractAdmissionDetail(getDomainFactory(), admissionDetail);
//		getDomainFactory().save(domAdmissionDetail);
		
//		AdmissionDetailVo admissionDetails = AdmissionDetailVoAssembler.create(domAdmissionDetail);
//		admissionDetails.validate();
		

		PendingElectiveAdmissionAdmitVo pendingBookedElectiveAdmission = selectedAdmissionData instanceof PendingElectiveAdmissionAdmitVo ? (PendingElectiveAdmissionAdmitVo) selectedAdmissionData : null;
		PendingEmergencyAdmissionAdmitVo pendingEDEmergency = selectedAdmissionData instanceof PendingEmergencyAdmissionAdmitVo ? (PendingEmergencyAdmissionAdmitVo) selectedAdmissionData : null;
		PendingElectiveAdmissionAdmitVo pendingElectiveAdmission = selectedAdmissionData instanceof PendingElectiveAdmissionAdmitVo ? (PendingElectiveAdmissionAdmitVo) selectedAdmissionData : null;
		CatsReferralPendingEmergencyNonEDAdmissionListVo pendingEmergencyAdmission = selectedAdmissionData instanceof CatsReferralPendingEmergencyNonEDAdmissionListVo ? (CatsReferralPendingEmergencyNonEDAdmissionListVo) selectedAdmissionData : null;

		
		PatientElectiveListBedAdmissionVo patientTCI_ElectiveList = selectedAdmissionData instanceof PatientElectiveListBedAdmissionVo ? (PatientElectiveListBedAdmissionVo) selectedAdmissionData : null;
		
		AdmissionType admissionType = AdmissionType.EMERGENCY;
		
		
		BedAdmissionComponent impl = (BedAdmissionComponent) getDomainImpl(BedAdmissionComponentImpl.class);

		if (Boolean.TRUE.equals(ConfigFlag.GEN.USE_ELECTIVE_LIST_FUNCTIONALITY.getValue()) && selectedAdmissionData instanceof PatientElectiveListBedAdmissionVo)
		{
			PatientElectiveListBedAdmissionVo electiveAdmission = impl.saveTCIAdmissionAndUpdateList(patientTCI_ElectiveList, null, wardStay, consultantStay, null, null, null, caseNoteTransfers);
			
			impl.createCaseNoteRequests(electiveAdmission);
		}
//		else if (Boolean.TRUE.equals(ConfigFlag.GEN.USE_ELECTIVE_LIST_FUNCTIONALITY.getValue()) && selectedAdmissionData instanceof PatientLite_IdentifiersVo)
//		{
//			CareSpellVo careSpell = createCareSpell((PatientLite_IdentifiersVo) selectedAdmissionData, admissionDetail.getPasEvent(), admissionDetail.getAdmissionDateTime(), admissionDetail.getConsultant(), admissionDetail.getService());
//			CatsReferralEmergencyAdmissionVo catsReferral = createCatsReferral((PatientLite_IdentifiersVo) selectedAdmissionData, admissionDetail, careSpell);
//			
//			impl.saveEmergencyAdmissionInElectiveCase(admissionDetail,				// Admission Detail 
//													  careSpell,					// Care Spell
//													  catsReferral,					// Cats Referral
//													  null,							// Bed Space State - null when Admitting to Ward
//													  wardStay,						// Ward Stay
//													  consultantStay,				// Consultant Stay
//													  null,							// Admission Reason 
//													  null,							// Ward Mixed Sex Breach 
//													  null,							// Ward Bay Config
//													  caseNoteTransfers);			// Patient Case Note Transfer
//		}
		else
		{
			impl.saveAdmissionAndUpdateList(admissionDetail,						// Admission Detail
											null,									// Bed Space State - null when Admitting to Ward
											careSpell,
											referral,
											wardStay,								// Ward Stay
											consultantStay,							// Consultant Stay
											pendingBookedElectiveAdmission,			// Pending Elective Admission - Planned (Booked)
											pendingEDEmergency,						// Pending Emergency Admission - ED
											pendingElectiveAdmission,				// Pending Elective Admission - (TCI)
											pendingEmergencyAdmission,				// Pending Emergency Admission - Non ED
											admissionType,							// Admission Type
											null,									// Admission Reason
											null,									// Ward Mixed Sex Breach
											null,									// Ward Bay Config
											caseNoteTransfers);						// Patient Case Note Transfer
		}

		//WDEV-21973 make sure patient has a Case Note Folder
		impl.createCaseNoteFolderIfNone(admissionDetail.getPasEvent().getPatient());
		
		return true;
	}

	public HcpLiteVo getHcpFromIMos(IMos iMos)
	{
		if (iMos == null || iMos.getIMosHcpId() == null)
			return null;
		
		return HcpLiteVoAssembler.create((Hcp) getDomainFactory().getDomainObject(Hcp.class, iMos.getIMosHcpId()));
	}

	public CatsReferralPendingEmergencyNonEDAdmissionListVoCollection listPendingEmergencies(Date dateFrom, Date dateTo, LocationRefVo ward,LocationRefVo hospital)
	{
		BedAdmissionComponent impl = (BedAdmissionComponent) getDomainImpl(BedAdmissionComponentImpl.class);
		
		return impl.listPendingEmergencies(dateFrom, dateTo, ward, hospital);
	}
	

	public PendingEmergencyAdmissionAdmitVo automaticDischarge(PendingEmergencyAdmissionRefVo pendingEmergencyAdmission, DateTime admissionDateTime, HcpLiteVo consultant) throws StaleObjectException
	{
		BedAdmissionComponent impl = (BedAdmissionComponent) getDomainImpl(BedAdmissionComponentImpl.class);
		return impl.automaticDischarge(pendingEmergencyAdmission, admissionDateTime, consultant);
	}

	public PatientLite_IdentifiersVoCollection listPatients(PatIdType idType, String idValue)
	{
		if (idType == null || idValue == null)
			return null;
		//WDEV-22567
		boolean bShowMergedPatients = !ConfigFlag.UI.HIDE_MERGED_PATIENTS_ON_PATIENT_SEARCH.getValue();
		
		StringBuilder query = new StringBuilder("SELECT patient ");
		query.append(" FROM Patient AS patient LEFT JOIN patient.identifiers AS patIdent LEFT JOIN patIdent.type AS identType ");
		query.append(" WHERE ");
		query.append(" identType.id = :PAT_ID_TYPE AND patIdent.value = :PAT_ID_VALUE ");
		
		//WDEV-22567
		if (bShowMergedPatients)
			query.append(" AND (patient.isActive = :ACTIVE or patient.associatedPatient is not null)");
		else
			query.append(" AND patient.isActive = :ACTIVE and patient.associatedPatient is null");
				
		query.append(" ORDER BY patient.name.upperSurname, patient.name.upperForename");
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		if (PatIdType.NHSN.equals(idType))//WDEV-22934
			idValue = idValue.replace(" ", "");
		
		paramNames.add("PAT_ID_TYPE");			paramValues.add(idType.getID());
		paramNames.add("PAT_ID_VALUE");			paramValues.add(idValue);
		paramNames.add("ACTIVE");			paramValues.add(Boolean.TRUE);
		
		return PatientLite_IdentifiersVoAssembler.createPatientLite_IdentifiersVoCollectionFromPatient(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}


	public PatientLite_IdentifiersVoCollection listPatients(String surname, String forename)
	{
		if (surname == null)
			return null;
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		//WDEV-22567
		boolean bShowMergedPatients = !ConfigFlag.UI.HIDE_MERGED_PATIENTS_ON_PATIENT_SEARCH.getValue();
		
		StringBuilder query = new StringBuilder("SELECT patient ");
		query.append(" FROM Patient AS patient ");
		query.append(" WHERE ");
		query.append(" patient.name.upperSurname LIKE :SURNAME ");

		paramNames.add("SURNAME");			paramValues.add(surname.toUpperCase() + "%");

		
		if (forename != null)
		{
			query.append(" AND patient.name.upperForename LIKE :FORENAME ");

			paramNames.add("FORENAME");			paramValues.add(forename.toUpperCase() + "%");
		}
		//WDEV-22567
		if (bShowMergedPatients)
			query.append(" AND (patient.isActive = :ACTIVE or patient.associatedPatient is not null)");
		else
			query.append(" AND patient.isActive = :ACTIVE and patient.associatedPatient is null");
		
		paramNames.add("ACTIVE");			paramValues.add(Boolean.TRUE);
		
		query.append(" ORDER BY patient.name.upperSurname, patient.name.upperForename ");
		
		return PatientLite_IdentifiersVoAssembler.createPatientLite_IdentifiersVoCollectionFromPatient(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}


	public PatientShort getPatient(PatientRefVo patient)
	{
		if (patient == null || patient.getID_Patient() == null)
			return null;
		
		return PatientShortAssembler.create((Patient) getDomainFactory().getDomainObject(Patient.class, patient.getID_Patient()));
	}


	public PatientElectiveListBedInfoVoCollection listPatientElectives(Date fromDate, Date toDate, LocationRefVo ward, LocationRefVo hospital)
	{
		BedAdmissionComponent impl = (BedAdmissionComponent) getDomainImpl(BedAdmissionComponentImpl.class);
		return impl.listPatientElective(ward, fromDate, toDate, hospital);
	}

	public ServiceLiteVoCollection listServices(String name)
	{
		BedAdmissionComponent impl = (BedAdmissionComponent) getDomainImpl(BedAdmissionComponentImpl.class);
		return impl.listServices(name);
	}

	
	public MedicLiteVoCollection listConsultants(ServiceRefVo service, String name)
	{
		if (service == null || service.getID_Service() == null)
			return null;

		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		StringBuilder query = new StringBuilder("SELECT medic FROM Medic AS medic ");
		query.append(" LEFT JOIN medic.mos AS mos ");
		query.append(" LEFT JOIN medic.grade AS medicGrade ");
		query.append(" LEFT JOIN medic.serviceFunction AS servFunction ");
		query.append(" LEFT JOIN servFunction.service AS service ");
		query.append(" WHERE ");
		query.append(" service.id = :SERVICE_ID AND medicGrade.id = :CONSULTANT ");
		
		paramNames.add("SERVICE_ID");		paramValues.add(service.getID_Service());
		paramNames.add("CONSULTANT");		paramValues.add(MedicGrade.CONS.getID());
		
		if (name != null && name.length() > 0)
		{
			query.append(" AND (mos.name.upperSurname LIKE :SURNAME OR mos.name.upperForename LIKE :FORENAME) ");
			
			paramNames.add("SURNAME");		paramValues.add(name.toUpperCase() + "%");
			paramNames.add("FORENAME");		paramValues.add(name.toUpperCase() + "%");
		}
		
		query.append(" ORDER BY mos.name.upperSurname, mos.name.upperForename ");
		
		return MedicLiteVoAssembler.createMedicLiteVoCollectionFromMedic(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}


	public MedicLiteVoCollection listReferringConsultants(String name)
	{
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		StringBuilder query = new StringBuilder("SELECT medic FROM Medic AS medic ");
		query.append(" LEFT JOIN medic.mos AS mos ");
		query.append(" LEFT JOIN medic.grade AS medicGrade ");
		query.append(" WHERE ");
		query.append(" medicGrade.id = :CONSULTANT ");
		
		paramNames.add("CONSULTANT");			paramValues.add(MedicGrade.CONS.getID());
		
		if (name != null && name.length() > 0)
		{
			query.append(" AND mos.name.upperSurname LIKE :SURNAME AND mos.name.upperForename LIKE :FORENAME " );
			
			paramNames.add("SURNAME");			paramValues.add(name.toUpperCase() + "%");
			paramNames.add("FORENAME");			paramValues.add(name.toUpperCase() + "%");
		}
		
		query.append(" ORDER BY mos.name.upperSurname, mos.name.upperForename ");

		return MedicLiteVoAssembler.createMedicLiteVoCollectionFromMedic(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}


	public BookAppointmentForWardAttendersVoCollection listWardAttenders(LocationRefVo ward, Date date)
	{
		BedAdmissionComponent impl = (BedAdmissionComponent) getDomainImpl(BedAdmissionComponentImpl.class);
		return impl.listWardAttenders(ward, date);
	}


	public PatientElectiveListBedAdmissionVo getPatientElectiveList(PatientElectiveListRefVo patientElectiveList)
	{
		if (patientElectiveList == null || patientElectiveList.getID_PatientElectiveList() == null)
			return null;
		
		return PatientElectiveListBedAdmissionVoAssembler.create((PatientElectiveList) getDomainFactory().getDomainObject(PatientElectiveList.class, patientElectiveList.getID_PatientElectiveList()));
	}


	public TrackingForPendingEmergencyAdmitVoCollection listPendingEDAdmission(LocationRefVo location)
	{
		BedAdmissionComponent impl = (BedAdmissionComponent) getDomainImpl(BedAdmissionComponentImpl.class);
		return impl.listEmergencyAdmission(location);
	}


	public MedicVo getMedicFull(MedicRefVo medic)
	{
		if (medic == null || medic.getID_Hcp() == null)
			return null;
		
		return MedicVoAssembler.create((Medic) getDomainFactory().getDomainObject(Medic.class, medic.getID_Hcp()));
	}

	
	public MedicLiteVo getMedic(MemberOfStaffRefVo memberOfStaff)
	{
		if (memberOfStaff == null || memberOfStaff.getID_MemberOfStaff() == null)
			return null;
		
		StringBuilder query = new StringBuilder("SELECT medic FROM Medic AS medic ");
		query.append(" LEFT JOIN medic.mos AS mos ");
		query.append(" WHERE ");
		query.append(" mos.id = :MOS_ID ");
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("MOS_ID");		paramValues.add(memberOfStaff.getID_MemberOfStaff());
		
		
		return MedicLiteVoAssembler.create((Medic) getDomainFactory().findFirst(query.toString(), paramNames, paramValues));
	}


	public Boolean isPatientAlive(PatientRefVo patient)
	{
		if (patient == null || patient.getID_Patient() == null)
			return false; 												// If the patient is not recorded, then it is not alive
		
		String query = "SELECT COUNT(patient.id) FROM Patient AS patient WHERE patient.id = :PAT_ID AND patient.dod is not null";
		
		long count = getDomainFactory().countWithHQL(query, new String[] {"PAT_ID"}, new Object[] {patient.getID_Patient()});
		
		if (count > 0)
			return false;

		return true;
	}


	public Boolean hasPatientActiveSelfAdmit(PatientRefVo patient)
	{
		if (patient == null || patient.getID_Patient() == null)
			return false;
		
		String hql = "SELECT COUNT(alert.id) FROM PatientAlert AS alert LEFT JOIN alert.patient AS pat LEFT JOIN alert.alertType AS aType LEFT JOIN aType.parent AS aCategory WHERE (alert.isRIE is null OR alert.isRIE = 0) AND aCategory.id = :SELF_ADMIT_ALERT AND alert.isCurrentlyActiveAlert = :ACTIVE_ALERT AND pat.id = :PATIENT";
		
		long count = getDomainFactory().countWithHQL(hql, new String[]{"SELF_ADMIT_ALERT","ACTIVE_ALERT", "PATIENT" }, new Object[]{AlertType.SELF_ADMIT_PATIENT.getID(), Boolean.TRUE, patient.getID_Patient()});
		
		return count > 0;
	}



	public PatientCaseNoteVoCollection getCaseNoteFolders(PatientRefVo patient)
	{
		BedAdmissionComponent impl = (BedAdmissionComponent) getDomainImpl(BedAdmissionComponentImpl.class);
		return impl.getCaseNoteFolders(patient, null);
	}


	public LocationLiteVo getHospitalForLocation(LocationRefVo location)
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return impl.getHospitalLiteForLocation(getLocationLite(location));
	}


	public CareSpellAdmitVo getCareSpellForAdmission(CareContextRefVo careContext)
	{
		if (careContext == null || careContext.getID_CareContext() == null)
			return null;
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		StringBuilder query = new StringBuilder("SELECT careSpell ");
		query.append(" FROM CareSpell AS careSpell ");
		query.append(" LEFT JOIN careSpell.episodes AS episode ");
		query.append(" LEFT JOIN episode.careContexts AS carecontext ");
		
		query.append(" WHERE ");
		
		query.append(" carecontext.id = :CONTEXT_ID ");
		
		paramNames.add("CONTEXT_ID");
		paramValues.add(careContext.getID_CareContext());
		
		return CareSpellAdmitVoAssembler.create((CareSpell) getDomainFactory().findFirst(query.toString(), paramNames, paramValues));
	}
	

	public CareSpellAdmitVo getCareSpellForAdmission(CatsReferralRefVo referral)
	{
		if (referral == null || referral.getID_CatsReferral() == null)
			return null;
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		StringBuilder query = new StringBuilder("SELECT carespell ");
		query.append(" FROM CatsReferral AS referral LEFT JOIN referral.careContext AS carecontext ");
		query.append(" LEFT JOIN carecontext.episodeOfCare AS episodeofcare LEFT JOIN episodeofcare.careSpell AS carespell ");
		
		query.append(" WHERE ");
		
		query.append(" referral.id = :REFERRAL_ID ");
		
		paramNames.add("REFERRAL_ID");
		paramValues.add(referral.getID_CatsReferral());
		
		return CareSpellAdmitVoAssembler.create((CareSpell) getDomainFactory().findFirst(query.toString(), paramNames, paramValues));
	}


	public CareSpellAdmitVo getCareSpellForAdmission(Booking_AppointmentRefVo appointment)
	{
		if (appointment == null || appointment.getID_Booking_Appointment() == null)
			return null;
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		StringBuilder query = new StringBuilder("SELECT careSpell ");
		query.append(" FROM CatsReferral AS referral LEFT JOIN referral.appointments AS appointment ");
		query.append(" LEFT JOIN referral.careContext AS carecontext ");
		query.append(" LEFT JOIN carecontext.episodeOfCare AS episodeofcare ");
		query.append(" LEFT JOIN episodeofcare.careSpell AS careSpell ");
		
		query.append(" WHERE ");
		
		query.append(" appointment.id = :APPOINTMENT_ID ");
		
		paramNames.add("APPOINTMENT_ID");
		paramValues.add(appointment.getID_Booking_Appointment());
		
		return CareSpellAdmitVoAssembler.create((CareSpell) getDomainFactory().findFirst(query.toString(), paramNames, paramValues));
	}


	public CatsReferralEmergencyAdmissionVo getReferralForAdmission(CatsReferralRefVo referral)
	{
		if (referral == null || referral.getID_CatsReferral() == null)
			return null;
		
		return CatsReferralEmergencyAdmissionVoAssembler.create((CatsReferral) getDomainFactory().getDomainObject(CatsReferral.class, referral.getID_CatsReferral()));
	}


	public CatsReferralEmergencyAdmissionVo getReferralForAdmission(Booking_AppointmentRefVo appointment)
	{
		if (appointment == null || appointment.getID_Booking_Appointment() == null)
			return null;
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		StringBuilder query = new StringBuilder("SELECT referral ");
		query.append(" FROM CatsReferral AS referral LEFT JOIN referral.appointments AS appointment");
		
		query.append(" WHERE ");
		
		query.append(" appointment.id = :APPOINTMENT_ID ");
		
		paramNames.add("APPOINTMENT_ID");
		paramValues.add(appointment.getID_Booking_Appointment());
		
		return CatsReferralEmergencyAdmissionVoAssembler.create((CatsReferral) getDomainFactory().findFirst(query.toString(), paramNames, paramValues));
	}

	public LocationRefVo getHospitalForWard(LocationRefVo wardRef)
	{
		BedAdmissionComponent impl = (BedAdmissionComponent) getDomainImpl(BedAdmissionComponentImpl.class);
		return impl.getHospitalLoc(wardRef);
	}


	public Boolean patientHasTCIWithinNextMonth(PatientRefVo patient)
	{
		BedAdmissionComponent impl = (BedAdmissionComponent) getDomainImpl(BedAdmissionComponentImpl.class);
		return impl.hasPatientTCIWithinNextMonth(patient);
	}


	public Boolean patientHasAppointmentsWithinNextMonth(PatientRefVo patient)
	{
		BedAdmissionComponent impl = (BedAdmissionComponent) getDomainImpl(BedAdmissionComponentImpl.class);
		return impl.hasPatientAppointmentsWithinNextMonth(patient);
	}
	
	//WDEV-21544 
	public PatientLite_IdentifiersVo getPatientLite(PatientRefVo patientRef)
	{
		if (patientRef == null)
			return null;
		DomainFactory fact = getDomainFactory();
		
		Patient doPatient = (Patient) fact.getDomainObject(Patient.class, patientRef.getID_Patient());
		
		if (doPatient != null)
			return PatientLite_IdentifiersVoAssembler.create(doPatient);
		
		return null;
	}


	//wdev-21464
	public CareContextShortVo getCareContextShort(PatientRefVo patRef)
	{
		if( patRef == null  )
			return null;
		 
		
		String query = "select p1_1 from InpatientEpisode as i1_1 left join i1_1.pasEvent as p1_1 left join p1_1.patient as p2_1 where (p2_1.id = :patientId)";
		
		List<?> pasEv = getDomainFactory().find(query, new String[] {"patientId"}, new Object[] {patRef.getID_Patient()});
		
		if( pasEv != null && pasEv.size() > 0 && pasEv.get(0) instanceof PASEvent)
		{						
			query = "select c1_1 from CareContext as c1_1 left join c1_1.pasEvent as pas_1 where (pas_1.id = :pasEventId)";
			
			List<?> careContext = getDomainFactory().find(query, new String[] {"pasEventId"}, new Object[] {((PASEvent)pasEv.get(0)).getId()});
			
			if( careContext != null && careContext.size() > 0 )
			{
				CareContextShortVoCollection tempCol = CareContextShortVoAssembler.createCareContextShortVoCollectionFromCareContext(careContext);
				if( tempCol != null && tempCol.size() > 0)
				{					
					for(int i = 0 ; i < tempCol.size();i++)
					{
						if( tempCol.get(i).getContextIsNotNull() && ContextType.INPATIENT.equals(tempCol.get(i).getContext()))
							return tempCol.get(i);
					}
				}
			}
			
		}
		
		return null;
	}

	//wdev-21464
	public PatientShort getPatientShort(PatientRefVo patRef)
	{
		if( patRef == null )
			return null;
		
		DomainFactory factory = getDomainFactory();
		Patient doPatient = (Patient) factory.getDomainObject(Patient.class, patRef.getID_Patient());
		return PatientShortAssembler.create(doPatient);
	}


	@Override
	public PatientWithGPForCCGVo getPatientForCCG(PatientRefVo patientRef)
	{
		BedAdmissionComponent implBedAdmissionComponent = (BedAdmissionComponent) getDomainImpl(BedAdmissionComponentImpl.class);
		return implBedAdmissionComponent.getPatientForCCG(patientRef);//WDEV-22214
	}


	@Override
	public String getCodeCCGFromPostalCode(String postCode)
	{
		BedAdmissionComponent implBedAdmissionComponent = (BedAdmissionComponent) getDomainImpl(BedAdmissionComponentImpl.class);
		return implBedAdmissionComponent.getCodeCCGFromPostalCode(postCode);//WDEV-22214
	}


	@Override
	public String getCCGCodeForCurrentLocationOrg(ILocation iCurrentLoc)
	{
		BedAdmissionComponent implBedAdmissionComponent = (BedAdmissionComponent) getDomainImpl(BedAdmissionComponentImpl.class);
		return implBedAdmissionComponent.getCCGCodeForCurrentLocationOrg(iCurrentLoc);//WDEV-22214
	}


	@Override
	//http://jira/browse/WDEV-22615
	public AdmissionDetailVo getAdmissionDetail(PasEventAdmitVo pasEvent)
	{
		BedAdmissionComponent implBedAdmissionComponent = (BedAdmissionComponent) getDomainImpl(BedAdmissionComponentImpl.class);
		return implBedAdmissionComponent.getAdmissionDetailByPasEvent(pasEvent);
	}


	@Override
	public Boolean isCaseNoteFolderLocation(PatientRefVo patientRef)
	{
		if(patientRef == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer("select count(patCaseNote) from PatientCaseNote as patCaseNote where (patCaseNote.status.id = :ACTIVE OR patCaseNote.status.id = :REQUIRES_MERGING OR patCaseNote.status.id = :MARKED_AS_FOUND) ");
		
		String andStr = " AND ";
		
		if (patientRef!=null)
		{
			hql.append(andStr);
			hql.append(" patCaseNote.patient.id = :PatId ");
			andStr = " AND ";
		}
		


		Long countWithHQL = factory.countWithHQL((hql.toString()).toString(), new String[] { "ACTIVE" ,"MARKED_AS_FOUND","REQUIRES_MERGING","PatId" },
							new Object[] { CaseNoteStatus.ACTIVE.getID(),CaseNoteStatus.MARKED_AS_FOUND.getID(),CaseNoteStatus.REQUIRES_MERGING.getID(),patientRef.getID_Patient()});
		
		return countWithHQL>0;
		
		
	}
}
