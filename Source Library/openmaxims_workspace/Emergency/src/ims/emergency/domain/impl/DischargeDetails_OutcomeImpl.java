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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4471.18200)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.clinical.domain.DeathDetails;
import ims.clinical.domain.impl.DeathDetailsImpl;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.domain.objects.EmergencyAttendance;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.domain.Demographics;
import ims.core.domain.VitalSignsAll;
import ims.core.domain.impl.DemographicsImpl;
import ims.core.domain.impl.VitalSignsImpl;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.DeathDetailsVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.PatientShort;
import ims.core.vo.Patient_DODVo;
import ims.core.vo.VSMetrics;
import ims.core.vo.domain.PatientShortAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.emergency.configuration.domain.objects.MandatoryEDOutcomeCoding;
import ims.emergency.domain.EDPartialAdmissionDialog;
import ims.emergency.domain.EmergencyAttendanceDetailsCc;
import ims.emergency.domain.base.impl.BaseDischargeDetails_OutcomeImpl;
import ims.emergency.domain.objects.AttendanceRequiringContracting;
import ims.emergency.domain.objects.EDPartialAdmission;
import ims.emergency.domain.objects.Tracking;
import ims.emergency.helper.EmergencyHelper;
import ims.emergency.helper.IEmergencyHelper;
import ims.emergency.vo.EDPartialAdmissionForDischargeDetailOutcomeVo;
import ims.emergency.vo.EmergencyAttendanceOutcomeVo;
import ims.emergency.vo.MandatoryEDOutcomeCodingVo;
import ims.emergency.vo.TrackingAttendanceOutcomeVo;
import ims.emergency.vo.TrackingForClinicianWorklistAndTriageVo;
import ims.emergency.vo.TrackingRefVo;
import ims.emergency.vo.domain.EDPartialAdmissionForDischargeDetailOutcomeVoAssembler;
import ims.emergency.vo.domain.EmergencyAttendanceOutcomeVoAssembler;
import ims.emergency.vo.domain.MandatoryEDOutcomeCodingVoAssembler;
import ims.emergency.vo.domain.TrackingAttendanceOutcomeVoAssembler;
import ims.emergency.vo.domain.TrackingForClinicianWorklistAndTriageVoAssembler;
import ims.emergency.vo.enums.Discharge_Action;
import ims.emergency.vo.lookups.AllocationStatus;
import ims.emergency.vo.lookups.AttendanceOutcome;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.ILocation;

import java.util.Date;
import java.util.List;

public class DischargeDetails_OutcomeImpl extends BaseDischargeDetails_OutcomeImpl
{
	private static final long serialVersionUID = 1L;
	private static int ED_ASSESSMENT_FORM_ID = 129185;

	/**
	 *	Function used to retrieve the Tracking record based on CareContext provided (must be equal to Tracking.Attendance.CareContext)
	 */
	public TrackingAttendanceOutcomeVo getTrackingAttendanceOutcomeVo(CareContextRefVo careContext)
	{
		// Check care context parameter
		if (careContext == null || careContext.getID_CareContext() == null)
			return null;
		
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT track FROM Tracking AS track ");
		
		query.append(" LEFT JOIN FETCH track.attendance AS attend ");
		query.append(" LEFT JOIN FETCH attend.careContext as context ");
		query.append(" LEFT JOIN FETCH track.currentStatus ");
		query.append(" LEFT JOIN FETCH attend.emergencyEpisode ");
		query.append(" LEFT JOIN FETCH attend.patient ");
				
		query.append(" WHERE context.id = :CONTEXT_ID ");
		
		return TrackingAttendanceOutcomeVoAssembler.create((Tracking) getDomainFactory().findFirst(query.toString(), "CONTEXT_ID", careContext.getID_CareContext()));
	}

	/**
	 * Function used to save the Tracking record
	 * @return 
	 * @throws DomainInterfaceException 
	 */
	public void saveTrackingAttendanceOutcome(TrackingAttendanceOutcomeVo trackingAttendance, Discharge_Action action, DeathDetailsVo deathDetails, Boolean cancelFutureAppointments) throws StaleObjectException, DomainInterfaceException
	{
		// Check parameter to save
		if (trackingAttendance == null)
			throw new CodingRuntimeException("Can not save null record to data base.");
		
		if (!trackingAttendance.isValidated())
			throw new CodingRuntimeException("Can not save record not validated to data base.");
		//wdev-18061
		
		if (deathDetails != null)
		{
			Demographics demoImpl = (Demographics) getDomainImpl(DemographicsImpl.class);
			
			ims.core.vo.Patient patient = demoImpl.getPatient(trackingAttendance.getAttendance().getPatient());
			boolean wasPatientAlreadySavedAsDeceased = patient.getDod() != null;
			
			patient.setDod(trackingAttendance.getAttendance().getPatient().getDod());
			patient.setTimeOfDeath(trackingAttendance.getAttendance().getPatient().getTimeOfDeath());
			
			String[] errors = patient.validate();
			if (errors == null)
			{
				try 
				{
					demoImpl.savePatient(patient, false);
					
				} 
				catch (DomainInterfaceException e) 
				{
					throw new DomainInterfaceException("Error occurred Saving Patient : " + e.getMessage());
				} 
				catch (UniqueKeyViolationException e) 
				{
					throw new DomainInterfaceException("Error occurred Saving Patient : " + e.getMessage());
				}
				
				try
				{
					demoImpl.updatePatientDeceasedData(patient, deathDetails, cancelFutureAppointments, wasPatientAlreadySavedAsDeceased);
				}
				catch (DomainInterfaceException ex) 
				{
					throw new DomainInterfaceException("Error occurred Saving Death Details : " + ex.getMessage());
				}				
			}			
			
			if (wasPatientAlreadySavedAsDeceased && Discharge_Action.UNDO_DISCHARGE.equals(action) && deathDetails != null && trackingAttendance.getAttendance().getPatientIsNotNull() && trackingAttendance.getAttendance().getPatient().getDod() == null)
			{
				markAsRie(deathDetails, new ims.domain.FormName(ED_ASSESSMENT_FORM_ID),patient.getID_Patient(),null,null, "Undo of BID/DID/DOA/Mortuary ED Discharge Outcome");
			}
		}
		//WDEV-17661
		if (ConfigFlag.GEN.ED_DTA_ADMISSION_FUNCTIONALITY.getValue().equals("PARTIAL") && !AttendanceOutcome.ADMISSIONS.equals(trackingAttendance.getAttendance().getOutcome())  && trackingAttendance.getCurrentPartialAdmissionIsNotNull())
		{
			EDPartialAdmissionForDischargeDetailOutcomeVo edPartialAdmission = trackingAttendance.getCurrentPartialAdmission();
			
			edPartialAdmission.setAllocatedStatus(AllocationStatus.CANCELLED_ADMISSION);
			EDPartialAdmission domEdPartialAdm=EDPartialAdmissionForDischargeDetailOutcomeVoAssembler.extractEDPartialAdmission(getDomainFactory(), edPartialAdmission);
			getDomainFactory().save(domEdPartialAdm);
			
			trackingAttendance.setCurrentPartialAdmission(null);
			
			EDPartialAdmissionDialog impl= (EDPartialAdmissionDialog) getDomainImpl(EDPartialAdmissionDialogImpl.class);
			impl.triggerCancelPartialAdmission(trackingAttendance.getAttendance(), edPartialAdmission);
		}
		
		//wdev-18061
		// Extract domain objectt
		Tracking domTracking = TrackingAttendanceOutcomeVoAssembler.extractTracking(getDomainFactory(), trackingAttendance);
		
		getDomainFactory().save(domTracking);
		
		//WDEV-17513
		if (Boolean.TRUE.equals(ConfigFlag.UI.USE_HEARTS_CONTRACTING.getValue()))
		{
			//if ( !attendanceFoundInAttendanceReqContracting(trackingAttendance.getAttendance()))
			AttendanceRequiringContracting tempAttReqContracting = attendanceFoundInAttendanceReqContracting(trackingAttendance.getAttendance());
			if (tempAttReqContracting==null )
			{
    			AttendanceRequiringContracting doAttendanceRequiringContracting=new AttendanceRequiringContracting();
    			doAttendanceRequiringContracting.setPatient(domTracking.getAttendance().getPatient());
    			doAttendanceRequiringContracting.setAttendance(domTracking.getAttendance());
    			
    			getDomainFactory().save(doAttendanceRequiringContracting);
			}
			else //if found, set the status to null
			{
				tempAttReqContracting.setStatus(null);
				getDomainFactory().save(tempAttReqContracting);
			}
		}
		//wdev-17949
		if( action != null )
		{
			if( action.equals(ims.emergency.vo.enums.Discharge_Action.UNDO_DISCHARGE))
			{
				EmergencyAttendanceDetailsCc tempImpl = (EmergencyAttendanceDetailsCc)getDomainImpl(EmergencyAttendanceDetailsCcImpl.class);
				tempImpl.triggerAttendanceCancelDischargeEvent(trackingAttendance.getAttendance());
			}
			else if( action.equals(ims.emergency.vo.enums.Discharge_Action.DISCHARGE))
			{
				EmergencyAttendanceDetailsCc tempImpl = (EmergencyAttendanceDetailsCc)getDomainImpl(EmergencyAttendanceDetailsCcImpl.class);
				tempImpl.triggerAttendanceDischargeEvent(trackingAttendance.getAttendance());
				
			}
		}
		//---
		
		return;
	}

	//WDEV-17513
	private AttendanceRequiringContracting attendanceFoundInAttendanceReqContracting(EmergencyAttendanceOutcomeVo attendance)
	{
		if(attendance == null || attendance.getID_EmergencyAttendance() == null)
			throw new CodingRuntimeException("Cannot list Attendance Requiring Contracting for a null attendance Id.");
		
		String query = "select attReqContr from AttendanceRequiringContracting as attReqContr where attReqContr.attendance.id = :attId ";
		
		List list=getDomainFactory().find(query, new String[] {"attId"}, new Object[] {attendance.getID_EmergencyAttendance()});
		if (list!=null && list.size()>0)
		{
			//return true;
			return (AttendanceRequiringContracting)list.get(0);
		}
		//return false;
		return null;
	}

	//WDEV-17119
	public EmergencyAttendanceOutcomeVo getLatestEmergencyAttendance(PatientRefVo patientRef)
	{
		if(patientRef == null || patientRef.getID_Patient() == null)
			throw new CodingRuntimeException("Cannot list Emergency Episodes for a null Patient Id.");
		
		String query = "select ea from EmergencyAttendance as ea left join ea.careContext as cc left join cc.episodeOfCare as ec left join ec.careSpell as cs left join cs.patient as p where p.id = :PatientId order by ec.startDate desc, ea.arrivalDateTime desc ";  //wdev-16070
		
		List list=getDomainFactory().find(query, new String[] {"PatientId"}, new Object[] {patientRef.getID_Patient()});
		if (list!=null && list.size()>0)
		{
			return EmergencyAttendanceOutcomeVoAssembler.create(((EmergencyAttendance)list.get(0)));
		}
		return null;
	}

	//wdev-17231
	public PatientShort getPatientShort(PatientRefVo patRef) 
	{
		if( patRef == null )
			throw new CodingRuntimeException("PatientRefVo cannot be null");
		return PatientShortAssembler.create((Patient)getDomainFactory().getDomainObject(Patient.class, patRef.getID_Patient()) );
	}

	//wdev-17231
	public TrackingForClinicianWorklistAndTriageVo getTrackingForClinicianWorklistAndTriageVo(TrackingRefVo trackRef) 
	{
		if(trackRef == null )
			throw new CodingRuntimeException("TrackingRefVo cannot be null");
	
		return TrackingForClinicianWorklistAndTriageVoAssembler.create((Tracking) getDomainFactory().getDomainObject(Tracking.class, trackRef.getID_Tracking()));
	
	}

	
	/**
	 *	Function to check for Diagnoses, Treatments, Interventions or Investigations for the attendance
	 */
	public Boolean hasDiagnosesTreatmentsInterventionsOrInvestigations(PatientRefVo patient, CareContextRefVo careContext)
	{
		String queryDiagnoses = "SELECT COUNT (pDiag.id) FROM PatientDiagnosis AS pDiag WHERE pDiag.careContext.id = :CARE_CONTEXT AND (pDiag.isRIE is null OR pDiag.isRIE = 0)";
		long countDiagnoses = getDomainFactory().countWithHQL(queryDiagnoses, new String[] {"CARE_CONTEXT"}, new Object[] {careContext.getID_CareContext()});
		
		String queryInterventionTreatment = "SELECT COUNT (interventionTreatAttend.id) FROM InterventionsTreatmentsForAttendence AS interventionTreatAttend LEFT JOIN interventionTreatAttend.interventionTreatments AS interventionTreat WHERE interventionTreatAttend.attendance.id = :CARE_CONTEXT AND interventionTreat.id is not null";
		long countInterventionTreatment = getDomainFactory().countWithHQL(queryInterventionTreatment, new String[] {"CARE_CONTEXT"}, new Object[] {careContext.getID_CareContext()});
		
		String queryInvestigationAttendance = "SELECT COUNT (invAttend.id) FROM InvestigationsForAttend as invForAttend left join invForAttend.investigations AS invAttend WHERE invForAttend.attendance.id = :CARE_CONTEXT AND invAttend.active = 1";
		long countInvestigationAttendance = getDomainFactory().countWithHQL(queryInvestigationAttendance, new String[] {"CARE_CONTEXT"}, new Object[] {careContext.getID_CareContext()});
		
		CareContext careContextDO = (CareContext) getDomainFactory().getDomainObject(CareContext.class, careContext.getID_CareContext());
		Date startDateTime = careContextDO.getStartDateTime();
		Date endDateTime = careContextDO.getEndDateTime();
		if (endDateTime == null) endDateTime = new Date();
		String queryOrderInvestigations = "SELECT COUNT (ordInv.id) FROM OrderInvestigation AS ordInv LEFT JOIN ordInv.orderDetails AS ordDet WHERE ordDet.patient.id = :PATIENT_ID AND ordInv.systemInformation.creationDateTime BETWEEN :START_DATE AND :END_DATE";
		long countOrderInvestigation = getDomainFactory().countWithHQL(queryOrderInvestigations, new String[] {"PATIENT_ID", "START_DATE", "END_DATE"}, new Object[] {patient.getID_Patient(), startDateTime, endDateTime});
		
		//WDEV-19059
		String queryInvestigationsNotRecorded = "SELECT attendDiagInvTreatStatus  from AttendDiagInvTreatStatus as attendDiagInvTreatStatus left join attendDiagInvTreatStatus.attendance as at where (at.id = :AttendenceId and (attendDiagInvTreatStatus.investigationNotRecorded = 1 or attendDiagInvTreatStatus.noInvestigations = 1) and (attendDiagInvTreatStatus.isRIE is null OR attendDiagInvTreatStatus.isRIE = 0) ) ";
		List<?> list1 = getDomainFactory().find(queryInvestigationsNotRecorded, new String[] {"AttendenceId"}, new Object[] {careContext.getID_CareContext()});
		boolean noKnownInvestigationSaved = ((list1!=null && list1.size()>0) ? true : false);
		
		String queryTreatmentNotRecorded = "SELECT attendDiagInvTreatStatus  from AttendDiagInvTreatStatus as attendDiagInvTreatStatus left join attendDiagInvTreatStatus.attendance as at where (at.id = :AttendenceId and (attendDiagInvTreatStatus.treatmentsNotRecorded = 1 or attendDiagInvTreatStatus.noTreatments = 1) and (attendDiagInvTreatStatus.isRIE is null OR attendDiagInvTreatStatus.isRIE = 0) ) ";
		List<?> list2 = getDomainFactory().find(queryTreatmentNotRecorded, new String[] {"AttendenceId"}, new Object[] {careContext.getID_CareContext()});
		boolean noKnownInterventionTreatmentSaved = ((list2!=null && list2.size()>0) ? true : false);
		
		String queryDiagnosisNotRecorded = "SELECT attendDiagInvTreatStatus  from AttendDiagInvTreatStatus as attendDiagInvTreatStatus left join attendDiagInvTreatStatus.attendance as at where (at.id = :AttendenceId and (attendDiagInvTreatStatus.diagnosesNotRecorded = 1 or attendDiagInvTreatStatus.noDiagnoses = 1) and (attendDiagInvTreatStatus.isRIE is null OR attendDiagInvTreatStatus.isRIE = 0) ) ";
		List<?> list3 = getDomainFactory().find(queryDiagnosisNotRecorded, new String[] {"AttendenceId"}, new Object[] {careContext.getID_CareContext()});
		boolean noKnownDiagnosisSaved = ((list3!=null && list3.size()>0) ? true : false);
		
		//WDEV-17806
		if ((countDiagnoses >0 || noKnownDiagnosisSaved) && (countInterventionTreatment >0 || noKnownInterventionTreatmentSaved) && ( (countInvestigationAttendance + countOrderInvestigation > 0) || noKnownInvestigationSaved )) //WDEV-19059
			return Boolean.TRUE;
		
		return Boolean.FALSE;
	}

	//WDEV-17615
	public LocationLiteVo getCurrentHospital(ILocation currentLocation)
	{
		IEmergencyHelper impl = (IEmergencyHelper)getDomainImpl(EmergencyHelper.class);
		return impl.getCurrentHospital(currentLocation);
	}

	//WDEV-17822
	public Boolean dischargePlanningAdviceHasComments(CareContextRefVo careContextRef)
	{
		String query = "SELECT COUNT (dsaa.id) FROM DischargeServicesAndAdvice AS dsaa WHERE dsaa.attendance.id = :CARE_CONTEXT AND (dsaa.isRIE is null OR dsaa.isRIE = 0) AND dsaa.comments is not null";
		long count = getDomainFactory().countWithHQL(query, new String[] {"CARE_CONTEXT"}, new Object[] {careContextRef.getID_CareContext()});
		
		if (count==0)
			return false;
		
		return true;
	}

	//WDEV-19013
	public Boolean isCodingRequiredForDischarge(AttendanceOutcome lookup)
	{
		if (lookup == null )
			return false;
		
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		hql.append("select lookInst from LookupInstance as lookInst left join lookInst.mappings as mappings where (lookInst.id = "+lookup.getID() +" and mappings.extSystem = 'MAXIMS' and mappings.extCode like 'CODING%' )");

		List<?> list = factory.find(hql.toString());

		if (list!=null && list.size()>0)
		{
			return true;
		}
		
		return false;
	}

	//WDEV-19013
	public MandatoryEDOutcomeCodingVo getMandatoryEDOutcomeCoding()
	{
		List list = getDomainFactory().find(" from MandatoryEDOutcomeCoding  ");
		
		if (list == null || list.size() == 0)
			return null;
		
		return MandatoryEDOutcomeCodingVoAssembler.create((MandatoryEDOutcomeCoding)list.get(0));
	}
	
	public DeathDetailsVo getDeathDetails(Patient_DODVo patientVo)
	{
		if (patientVo == null)
			throw new CodingRuntimeException("Cannot retrieve Death Details for null PatientShort argument");
		
		DeathDetails deathRecordsImpl = (DeathDetails) getDomainImpl(DeathDetailsImpl.class);
		
		return deathRecordsImpl.getDeathDetails(patientVo);
	}
	
	//WDEV-21082
	public VSMetrics getMetricsFromPatient(PatientRefVo patientRef) 
	{
		VitalSignsAll vs = (VitalSignsAll)getDomainImpl(VitalSignsImpl.class);
		return vs.getMetricsFromPatient(patientRef);
	}
	
}
