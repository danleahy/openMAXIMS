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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseIntraOperativeCaseDetailsDialogImpl extends DomainImpl implements ims.clinical.domain.IntraOperativeCaseDetailsDialog, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetSafetyBriefByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientSentForByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientArrivedByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validategetAnaesRFSByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validategetTimeOutCompletedByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSurgeryStartByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSurgeryStopByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientLeftTheatreByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validategetReadyForDischargeByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validategetTimeOutOfRecoveryByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPeriOpAnaestheticSignInByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCaseStaffDetails(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesaveCaseStaffDetails(ims.clinical.vo.IntraOpCaseStaffDetailsVo caseStaffDetails)
	{
		if(caseStaffDetails == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'caseStaffDetails' of type 'ims.clinical.vo.IntraOpCaseStaffDetailsVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetTheatreSessionStaffDetails(ims.scheduling.vo.Sch_SessionRefVo session)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistMedicLiteVo(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistNurseLiteVo(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistIntraOpPlannedProcedureByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveIntraOpPlannedProcedure(ims.clinical.vo.IntraOpPlannedProcedureVo intraOpPlanned, ims.scheduling.vo.Booking_AppointmentRefVo theatreAppt)
	{
		if(intraOpPlanned == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'intraOpPlanned' of type 'ims.clinical.vo.IntraOpPlannedProcedureVo' cannot be null.");
		if(theatreAppt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'theatreAppt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistProcedures(String filterProcedure)
	{
	}

	@SuppressWarnings("unused")
	public void validatesetPrimaryPlannedProcedure(java.util.Map<ims.core.clinical.vo.PatientProcedureRefVo, Boolean> plannedProcedureList)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientPreparation(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesaveLaserDetails(ims.clinical.vo.LaserDetailIntraOpVo laserDetail)
	{
		if(laserDetail == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'laserDetail' of type 'ims.clinical.vo.LaserDetailIntraOpVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesaveSkinPreparation(ims.clinical.vo.SkinPreparationIntraOpVo skinPrep)
	{
		if(skinPrep == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'skinPrep' of type 'ims.clinical.vo.SkinPreparationIntraOpVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistSkinPreparation(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatedoesChartableOccuranceTypeExistForAppt(ims.scheduling.vo.Booking_AppointmentRefVo appt, ims.clinical.vo.lookups.ChartableOccuranceType lkpInstance)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
		if(lkpInstance == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'lkpInstance' of type 'ims.clinical.vo.lookups.ChartableOccuranceType' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesaveDiathermy(ims.clinical.vo.DiathermyDetailIntraOpVo diathermy)
	{
		if(diathermy == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'diathermy' of type 'ims.clinical.vo.DiathermyDetailIntraOpVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistDiathermy(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetLaserDetails(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesavePatientPreparation(ims.clinical.vo.PatientPreperationIntraOpVo patientPreparation)
	{
		if(patientPreparation == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'patientPreparation' of type 'ims.clinical.vo.PatientPreperationIntraOpVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistCaseStaffHcps(String hcpName, ims.clinical.vo.IntraOpCaseStaffDetailsRefVo caseStaffDetail)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveIrrigant(ims.clinical.vo.IrrigantIntraOpVo irrigant)
	{
		if(irrigant == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'irrigant' of type 'ims.clinical.vo.IrrigantIntraOpVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetIrrigant(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistCatheter(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesaveCatheter(ims.clinical.vo.CatheterDrainsTubeIntraOpVo catheter)
	{
		if(catheter == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'catheter' of type 'ims.clinical.vo.CatheterDrainsTubeIntraOpVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistSpecimenIntraOpByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistWoundPackingByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistSkinClosuresAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateremoveSpecimenIntraOP(ims.clinical.vo.SpecimenIntraOpRefVo specimenIntraOp)
	{
		if(specimenIntraOp == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'specimenIntraOp' of type 'ims.clinical.vo.SpecimenIntraOpRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateremoveWoundPackingIntraOp(ims.clinical.vo.WoundPackingIntraOpRefVo woundIntraOp)
	{
		if(woundIntraOp == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'woundIntraOp' of type 'ims.clinical.vo.WoundPackingIntraOpRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateremoveSkinClosureIntraOp(ims.clinical.vo.SkinClosureIntraOpRefVo skinClosure)
	{
		if(skinClosure == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'skinClosure' of type 'ims.clinical.vo.SkinClosureIntraOpRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistImplantIntraOpByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistAreterialClampIntraOpByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistOtherEquipIntraOpByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateremoveImplantIntraOP(ims.clinical.vo.ImplantsIntraOpRefVo implant)
	{
		if(implant == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'implant' of type 'ims.clinical.vo.ImplantsIntraOpRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateremoveArterialClampIntraOp(ims.clinical.vo.ArterialClampIntraOpRefVo arterial)
	{
		if(arterial == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'arterial' of type 'ims.clinical.vo.ArterialClampIntraOpRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateremoveOtherEquipmentIntraOp(ims.clinical.vo.EquipmentIntraOpRefVo otherEquipment)
	{
		if(otherEquipment == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'otherEquipment' of type 'ims.clinical.vo.EquipmentIntraOpRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistTourniquetByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesaveTourniquet(ims.clinical.vo.TourniquetIntraOpVo tourniquet)
	{
		if(tourniquet == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'tourniquet' of type 'ims.clinical.vo.TourniquetIntraOpVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetIntoRecoveryByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validategetRecoveryDetails(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesaveRecoveryDetails(ims.clinical.vo.PeriOpRecoveryDetailVo recoveryDetails)
	{
		if(recoveryDetails == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'recoveryDetails' of type 'ims.clinical.vo.PeriOpRecoveryDetailVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistHandoverByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateremoveHandoverIntraOp(ims.clinical.vo.HandoverCountIntraOpRefVo handoverIntraOp)
	{
		if(handoverIntraOp == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'handoverIntraOp' of type 'ims.clinical.vo.HandoverCountIntraOpRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistFinalCountByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateremoveFinalCountIntraOp(ims.clinical.vo.FinalCountIntraOpRefVo finalCountIntraOp)
	{
		if(finalCountIntraOp == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'finalCountIntraOp' of type 'ims.clinical.vo.FinalCountIntraOpRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatelistPerformedProceduresByAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validatesavePerformedProcedure(ims.clinical.vo.PerformedProceduresIntraOpVo performed, ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(performed == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'performed' of type 'ims.clinical.vo.PerformedProceduresIntraOpVo' cannot be null.");
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesavePerformedSignOut(ims.clinical.vo.PerformedProcAndSignOutIntraOpVo performedSignOut)
	{
		if(performedSignOut == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'performedSignOut' of type 'ims.clinical.vo.PerformedProcAndSignOutIntraOpVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetPerformedSignOut(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetTheatreBooking(ims.scheduling.vo.TheatreBookingRefVo theatreBooking)
	{
		if(theatreBooking == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'theatreBooking' of type 'ims.scheduling.vo.TheatreBookingRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetUserAssessment(ims.assessment.configuration.vo.UserAssessmentRefVo userAssessment)
	{
	}

	@SuppressWarnings("unused")
	public void validateisPatientAssessmentCompleted(ims.assessment.instantiation.vo.PatientAssessmentRefVo patientAssessment)
	{
	}

	@SuppressWarnings("unused")
	public void validategetAnaestheticSignInvo(ims.scheduling.vo.Booking_AppointmentRefVo apptRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validateisDiabeticFromPreAssessmentOutcome(ims.scheduling.vo.Booking_AppointmentRefVo booking_AppointmentRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveService(ims.core.resource.people.vo.HcpRefVo hcpRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveBookingState(ims.scheduling.vo.TheatreBookingRefVo theatreBooking, ims.scheduling.vo.lookups.AcuteTheateListBookingState state)
	{
		if(theatreBooking == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'theatreBooking' of type 'ims.scheduling.vo.TheatreBookingRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateisAnaestheticSignInIntraOpFluidsYes(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		if(appt == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'appt' of type 'ims.scheduling.vo.Booking_AppointmentRefVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateisPlannedOrPerformedProcedureAddedAlready(ims.scheduling.vo.Booking_AppointmentRefVo appt, ims.core.clinical.vo.ProcedureRefVo procedureRef)
	{
	}

	@SuppressWarnings("unused")
	public void validateisAnyProcedurePerormed(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
	}

	@SuppressWarnings("unused")
	public void validateisStale(ims.clinical.vo.PerformedProceduresIntraORefVo performedProcedure)
	{
	}

	@SuppressWarnings("unused")
	public void validategetTheatreSession(ims.scheduling.vo.Booking_AppointmentRefVo schSession)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPrimaryPlannedProc(ims.scheduling.vo.Booking_AppointmentRefVo apptRef)
	{
	}

	@SuppressWarnings("unused")
	public void validateisPocedurePerformedAlready(ims.scheduling.vo.Booking_AppointmentRefVo appt, ims.core.clinical.vo.ProcedureRefVo procedureRef)
	{
	}

	@SuppressWarnings("unused")
	public void validateremoveSkinPrep(ims.clinical.vo.SkinPrepIntraOpRefVo skinPrepRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSkinPrep(ims.clinical.vo.SkinPrepIntraOpRefVo skinPrepRef)
	{
	}
}
