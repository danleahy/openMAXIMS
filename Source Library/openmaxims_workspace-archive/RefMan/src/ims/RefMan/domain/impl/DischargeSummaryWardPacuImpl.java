// This code was generated by George Cristian Josan using IMS Development Environment (version 1.70 build 3530.26969)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.ReferralAppointmentDetailsComponent;
import ims.RefMan.domain.ReferralWizard;
import ims.RefMan.domain.base.impl.BaseDischargeSummaryWardPacuImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.DischargeSummaryPacuAndWard;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.CatsReferralReportsVo;
import ims.RefMan.vo.CatsReferralWizardVo;
import ims.RefMan.vo.DischargeSummaryPacuAndWardLiteVo;
import ims.RefMan.vo.DischargeSummaryPacuAndWardLiteVoCollection;
import ims.RefMan.vo.DischargeSummaryPacuAndWardRefVo;
import ims.RefMan.vo.DischargeSummaryPacuAndWardVo;
import ims.RefMan.vo.TheatreProcedureServiceAndConsultantLiteVo;
import ims.RefMan.vo.domain.CatsReferralReportsVoAssembler;
import ims.RefMan.vo.domain.CatsReferralWizardVoAssembler;
import ims.RefMan.vo.domain.DischargeSummaryPacuAndWardLiteVoAssembler;
import ims.RefMan.vo.domain.DischargeSummaryPacuAndWardVoAssembler;
import ims.RefMan.vo.lookups.ReferralApptStatus;
import ims.chooseandbook.vo.lookups.ActionRequestType;
import ims.clinical.vo.IntraOperativeCareRecordVo;
import ims.clinical.vo.domain.IntraOperativeCareRecordVoAssembler;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.domain.objects.EpisodeOfCare;
import ims.core.admin.pas.domain.objects.DischargedEpisode;
import ims.core.admin.pas.domain.objects.InpatientEpisode;
import ims.core.admin.pas.vo.DischargedEpisodeRefVo;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.clinical.domain.objects.IntraOperativeCareRecord;
import ims.core.clinical.domain.objects.PatientDiagnosis;
import ims.core.clinical.vo.PatientProcedureRefVo;
import ims.core.documents.domain.objects.PatientDocument;
import ims.core.domain.ADT;
import ims.core.domain.impl.ADTImpl;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.DischargedEpisodeVo;
import ims.core.vo.InpatientEpisodeVo;
import ims.core.vo.PatientDiagnosisLiteVoCollection;
import ims.core.vo.PatientDocumentSaveVo;
import ims.core.vo.PatientDocumentVo;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.CareContextLiteVoAssembler;
import ims.core.vo.domain.DischargedEpisodeVoAssembler;
import ims.core.vo.domain.EpisodeofCareLiteVoAssembler;
import ims.core.vo.domain.InpatientEpisodeVoAssembler;
import ims.core.vo.domain.PatientDiagnosisLiteVoAssembler;
import ims.core.vo.domain.PatientDocumentVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.DocumentCategory;
import ims.domain.DomainFactory;
import ims.domain.DomainFactory.ORDERMODE;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.hibernate3.IMSCriteria;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.scheduling.domain.PatientAppointmentManagement;
import ims.scheduling.domain.SessionAdmin;
import ims.scheduling.domain.impl.PatientAppointmentMangementRefManImpl;
import ims.scheduling.domain.impl.SessionAdminImpl;
import ims.scheduling.domain.objects.Booking_Appointment;
import ims.scheduling.vo.BookingAppointmentTheatreVo;
import ims.scheduling.vo.Booking_AppointmentRefVo;
import ims.scheduling.vo.Booking_AppointmentVo;
import ims.scheduling.vo.ReferralAppointmentDetailsBookingAppointmentVoCollection;
import ims.scheduling.vo.SessionServiceAndSlotActivityVo;
import ims.scheduling.vo.domain.BookingAppointmentTheatreVoAssembler;
import ims.scheduling.vo.domain.Booking_AppointmentVoAssembler;
import ims.scheduling.vo.domain.ReferralAppointmentDetailsBookingAppointmentVoAssembler;

import java.util.ArrayList;
import java.util.List;

public class DischargeSummaryWardPacuImpl extends BaseDischargeSummaryWardPacuImpl
{

	private static final long serialVersionUID = 1L;

	// WDEV-12134 We need to retrieve all records for current referral + the current record
	public DischargeSummaryPacuAndWardLiteVoCollection listDischargeSummaryWardAndPacu(CatsReferralRefVo referral)
	{
		if (referral == null || !referral.getID_CatsReferralIsNotNull())
			return null;
		
		String query = "select discharge from DischargeSummaryPacuAndWard as discharge left join discharge.catsReferral as referral where referral.id = :REF_ID or (referral.patient.id = (select pat.id from CatsReferral as cats left join cats.patient as pat where cats.id = :REF_ID) and discharge.isCurrent = 1) order by discharge.systemInformation.creationDateTime desc";
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("REF_ID");
		paramValues.add(referral.getID_CatsReferral());
		
		return DischargeSummaryPacuAndWardLiteVoAssembler.createDischargeSummaryPacuAndWardLiteVoCollectionFromDischargeSummaryPacuAndWard(getDomainFactory().find(query, paramNames, paramValues));
	}

	public DischargeSummaryPacuAndWardVo getDischargeSummaryWardAndPacu(DischargeSummaryPacuAndWardRefVo dischargeSummaryRef)
	{
		if (dischargeSummaryRef == null || !dischargeSummaryRef.getID_DischargeSummaryPacuAndWardIsNotNull())
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		return DischargeSummaryPacuAndWardVoAssembler.create((DischargeSummaryPacuAndWard) factory.getDomainObject(DischargeSummaryPacuAndWard.class, dischargeSummaryRef.getID_DischargeSummaryPacuAndWard()));
	}

	public DischargeSummaryPacuAndWardVo saveDischargeSummaryWardAndPacu(DischargeSummaryPacuAndWardVo dischargeSummary) throws DomainInterfaceException, StaleObjectException, ForeignKeyViolationException, UniqueKeyViolationException
	{
		if (dischargeSummary == null)
			throw new CodingRuntimeException("Logical error - discharge summary is null in domain.save");
		
		if (!dischargeSummary.isValidated())
			throw new CodingRuntimeException("Logical error - Validate the Vo before saving");
		
		DomainFactory factory = getDomainFactory();
		DischargeSummaryPacuAndWard domDischargeSummary = DischargeSummaryPacuAndWardVoAssembler.extractDischargeSummaryPacuAndWard(factory, dischargeSummary);
		
		factory.save(domDischargeSummary);
		
		return DischargeSummaryPacuAndWardVoAssembler.create(domDischargeSummary);
	}

	public ReferralAppointmentDetailsBookingAppointmentVoCollection getAppointments(CatsReferralRefVo referral)
	{
		if (referral ==  null)
			return null;
		
		DomainFactory factory = getDomainFactory();

		StringBuilder hqlQuery = new StringBuilder("from Booking_Appointment as book where (book.id in (select bk.id from CatsReferral as cats left join cats.appointments as bk where cats.id = :ID) and book.appointmentDate >= :DATE and book.apptStatus.id = -1469)");
		
		ArrayList<String> paramNames = new ArrayList<String>();
		paramNames.add("ID");
		paramNames.add("DATE");
		
		ArrayList<Object> paramValues = new ArrayList<Object>();
		paramValues.add(referral.getID_CatsReferral());
		paramValues.add(new Date().getDate());

		
//		CatsReferral cats = (CatsReferral) factory.getDomainObject(CatsReferral.class, referral.getID_CatsReferral());
//		
//		if (cats.getOrderInvAppts() != null && cats.getOrderInvAppts().size() > 0)
//		{
//			hqlQuery.append(" and book.id not in (select bk2.id from CatsReferral as cats2 left join cats2.orderInvAppts as ord left join ord.appointment as bk2 where cats2.id = :ID) ");
//		}
		
		hqlQuery.append(") order by book.appointmentDate desc");
		
		ReferralAppointmentDetailsBookingAppointmentVoCollection list = ReferralAppointmentDetailsBookingAppointmentVoAssembler.createReferralAppointmentDetailsBookingAppointmentVoCollectionFromBooking_Appointment(factory.find(hqlQuery.toString(), paramNames, paramValues));
		
		if (list == null || list.size() == 0)
			return null;
		
		return list;
	}

	public Boolean getReferralAccepted(CatsReferralRefVo referral) throws DomainInterfaceException
	{
		if (referral == null)
			throw new DomainInterfaceException("No referral selected");

		DomainFactory factory = getDomainFactory();
		
		CatsReferralWizardVo referralWizzard = CatsReferralWizardVoAssembler.create((CatsReferral) factory.getDomainObject(CatsReferral.class, referral.getID_CatsReferral()));
		
		if (!referralWizzard.getCurrentStatusIsNotNull())
			throw new DomainInterfaceException("Referral has no status");
		
		if (ReferralApptStatus.REFERRAL_ACCEPTED.equals(referralWizzard.getCurrentStatus().getReferralStatus()))
			return Boolean.TRUE;
		
		return Boolean.FALSE;
	}

	public SessionServiceAndSlotActivityVo getServiceAndActivityByAppt(Booking_AppointmentRefVo booking) throws DomainInterfaceException
	{
		PatientAppointmentManagement impl = (PatientAppointmentManagement) getDomainImpl(PatientAppointmentMangementRefManImpl.class);
		return impl.getServiceAndActivityByAppt(booking, null);
	}

	public Booking_AppointmentVo getAppointmentFull(Booking_AppointmentRefVo booking) throws DomainInterfaceException
	{
		if (booking == null)
			throw new DomainInterfaceException("No booking selected");
		
		DomainFactory factory = getDomainFactory();
		
		return Booking_AppointmentVoAssembler.create((Booking_Appointment) factory.getDomainObject(Booking_Appointment.class, booking.getID_Booking_Appointment()));
	}

	public Booking_AppointmentVo cancelAppointment(Booking_AppointmentVo appointment, ActionRequestType requestType, String requestSource) throws StaleObjectException
	{
		SessionAdmin impl = (SessionAdmin) getDomainImpl(SessionAdminImpl.class);
		return impl.cancelAppt(appointment, requestType, requestSource);
	}

	public void updateCatsReferralAdditionalInvStatus(CatsReferralRefVo referral) throws StaleObjectException
	{
		SessionAdmin impl = (SessionAdmin) getDomainImpl(SessionAdminImpl.class);
		impl.updateCatsReferralAdditionalInvStatus(referral);
	}

	public BookingAppointmentTheatreVo getTheatreAppointment(Booking_AppointmentRefVo appointment)
	{
		if (appointment == null || appointment.getID_Booking_Appointment() == null)
			throw new CodingRuntimeException("Booking Appointment is null");
		
		return BookingAppointmentTheatreVoAssembler.create((Booking_Appointment) getDomainFactory().getDomainObject(Booking_Appointment.class, appointment.getID_Booking_Appointment())); 
	}

	public TheatreProcedureServiceAndConsultantLiteVo getTheatreServiceProcedureAndConsultant(Booking_AppointmentRefVo booking)
	{
		ReferralAppointmentDetailsComponent impl = (ReferralAppointmentDetailsComponent) getDomainImpl(ReferralAppointmentDetailsComponentImpl.class);
		return impl.getTheatreServiceProcedureAndConsultant(booking);
	}

	public InpatientEpisodeVo getInpatientEpisode(CatsReferralRefVo referral)
	{
		if (referral == null || referral.getID_CatsReferral() == null)
			throw new CodingRuntimeException("Logical error - provided referral is null or has no id");
		
		DomainFactory factory = getDomainFactory();
		
		String hql = "from InpatientEpisode as ip where (ip.isRIE is null and ip.pasEvent.id in (select cr.careContext.pasEvent.id from CatsReferral as cr where cr.id = :refID))";
		
		ArrayList<String> paramNames = new ArrayList<String>();
		paramNames.add("refID");
		
		ArrayList<Object> paramValues = new ArrayList<Object>();
		paramValues.add(referral.getID_CatsReferral());
		
		return InpatientEpisodeVoAssembler.create((InpatientEpisode) factory.findFirst(hql, paramNames, paramValues));
	}

	public DischargedEpisodeVo dischargePatient(CatsReferralRefVo referral, DischargedEpisodeVo dischargeEpisode) throws DomainInterfaceException, StaleObjectException, ForeignKeyViolationException
	{
		if (referral == null || referral.getID_CatsReferral() == null)
			throw new CodingRuntimeException("Logical error - Provided referral is null or has no id");
		
		if (dischargeEpisode == null)
			throw new CodingRuntimeException("Logical error - Discharge episode is null");

		DomainFactory factory = getDomainFactory();
		
		String hql = "from Patient as pat where (pat.id in (select cr.patient.id from CatsReferral as cr where cr.id = :refID))";
		
		ArrayList<String> paramNames = new ArrayList<String>();
		paramNames.add("refID");
		
		ArrayList<Object> paramValues = new ArrayList<Object>();
		paramValues.add(referral.getID_CatsReferral());
		
		PatientShort pat = PatientShortAssembler.create((Patient) (factory.find(hql, paramNames, paramValues)).get(0));

		if (pat == null)
			throw new DomainRuntimeException("Corresponding patient for referral is null");
		
		String[] errors = pat.validate();
		if (errors != null && errors.length > 0)
		{
			throw new DomainRuntimeException("Patient can not be validated");
		}
		
		try
		{
    		ADT implADT = (ADT) getDomainImpl(ADTImpl.class);
    		return implADT.dischargePatient(pat, dischargeEpisode,null);
		}
		catch (DomainRuntimeException exception)
		{
			if (exception.getMessage().equals("Inpatient episode not found for patient."))
			{
				throw new StaleObjectException(new DischargedEpisode());
			}
			else
				throw new DomainRuntimeException(exception.getMessage());
		}
	}

	public String[] getSystemReportAndTemplate(Integer imsID)
	{
		String[] result = null;
		
		DomainFactory factory = getDomainFactory();
		
		List list = factory.find("select r1_1.reportXml, t1_1.templateXml, r1_1.reportName, r1_1.reportDescription, t1_1.name, t1_1.description from ReportBo as r1_1 left join r1_1.templates as t1_1 where (r1_1.imsId= :imsid) order by t1_1.name", new String[] {"imsid"}, new Object[] {imsID});

		if(list.iterator().hasNext())
		{
			Object[] obj = (Object[])list.iterator().next();
			
			result = new String[] {(String)obj[0], (String)obj[1], (String)obj[2], (String)obj[3], (String)obj[4], (String)obj[5]};
		}
		
		return result;
	}

	public CatsReferralReportsVo getCatsReferralReport(CatsReferralRefVo referral)
	{
		if (referral == null || referral.getID_CatsReferral() == null)
			throw new CodingRuntimeException("Logical error - referral is null or missing ID");
		
		return CatsReferralReportsVoAssembler.create((CatsReferral) getDomainFactory().getDomainObject(CatsReferral.class, referral.getID_CatsReferral()));		
	}

	public void saveDocument(PatientDocumentVo document, CatsReferralRefVo referral, Boolean bIsCurrent) throws StaleObjectException
	{
		if (document != null)
		{
			if (!document.isValidated())
				throw new DomainRuntimeException("PatientDocumentVo not validated");
		}
		
		DomainFactory factory = getDomainFactory();
		
		PatientDocument domDocument = PatientDocumentVoAssembler.extractPatientDocument(factory, document);
		
		factory.save(domDocument);
		
		CatsReferral domCats = (CatsReferral) factory.getDomainObject(CatsReferral.class, referral.getID_CatsReferral());
		
		//wdev-8305
		if (document.getCategoryIsNotNull()
			&& document.getCategory().equals(DocumentCategory.DISCHARGE_SUPPLEMENTARY)
			&& bIsCurrent != null
			&& bIsCurrent)
			domCats.setRequiresDischargeRep(Boolean.FALSE);

		domCats.getReferralDocuments().add(domDocument);
		
		factory.save(domCats);
		
		PatientDocumentSaveVo vo = new PatientDocumentSaveVo();
		vo.setPatientDocumentVo(PatientDocumentVoAssembler.create(domDocument));
		vo.setCatsReferralWizardVo(CatsReferralWizardVoAssembler.create(domCats));
	}

	public PatientRefVo getPatientRef(CatsReferralRefVo referral)
	{
		if (referral == null || referral.getID_CatsReferral() == null)
			throw new CodingRuntimeException("Logical error - referral is null or missing ID");
		
		String hql = "from Patient as pat where (pat.id in (select cr.patient.id from CatsReferral as cr where cr.id = :refID))";
		
		ArrayList<String> paramNames = new ArrayList<String>();
		paramNames.add("refID");
		
		ArrayList<Object> paramValues = new ArrayList<Object>();
		paramValues.add(referral.getID_CatsReferral());
		
		DomainFactory factory = getDomainFactory();
		
		return PatientShortAssembler.create((Patient) (factory.find(hql, paramNames, paramValues)).get(0));
	}

	public CareContextRefVo getCareContextRef(CatsReferralRefVo referral)
	{
		if (referral == null || referral.getID_CatsReferral() == null)
			throw new CodingRuntimeException("Logical error - referral is null or missing ID");
		
		String hql = "from CareContext as care where (care.id in (select cr.careContext.id from CatsReferral as cr where cr.id = :refID))";

		ArrayList<String> paramNames = new ArrayList<String>();
		paramNames.add("refID");
		
		ArrayList<Object> paramValues = new ArrayList<Object>();
		paramValues.add(referral.getID_CatsReferral());
		
		DomainFactory factory = getDomainFactory();
		
		return CareContextLiteVoAssembler.create((CareContext) (factory.find(hql, paramNames, paramValues)).get(0));
	}

	public EpisodeOfCareRefVo getEpisodeOfCareRef(CatsReferralRefVo referral)
	{
		if (referral == null || referral.getID_CatsReferral() == null)
			throw new CodingRuntimeException("Logical error - referral is null or missing ID");
		
		String hql = "from EpisodeOfCare as ep where (ep.id in (select cr.careContext.episodeOfCare.id from CatsReferral as cr where cr.id = :refID))";

		ArrayList<String> paramNames = new ArrayList<String>();
		paramNames.add("refID");
		
		ArrayList<Object> paramValues = new ArrayList<Object>();
		paramValues.add(referral.getID_CatsReferral());
		
		DomainFactory factory = getDomainFactory();

		return EpisodeofCareLiteVoAssembler.create((EpisodeOfCare) factory.find(hql, paramNames, paramValues).get(0));
	}

	public CatsReferralWizardVo getCatsReferral(CatsReferralRefVo voCatsRef) 
	{
		ReferralWizard impl = (ReferralWizard) getDomainImpl(ReferralWizardImpl.class);
		return impl.getCatsReferral(voCatsRef);
	}

	public DischargeSummaryPacuAndWardVo saveDischargeSummaryWardAndPacuPlusCatsReferral(DischargeSummaryPacuAndWardVo dischargeSummary, DischargeSummaryPacuAndWardLiteVo currentDischarge, CatsReferralWizardVo voCatsReferralWizard, InpatientEpisodeVo inpatep) throws DomainInterfaceException, StaleObjectException
	{
		if (dischargeSummary == null)
			throw new CodingRuntimeException("Logical error - discharge summary is null in domain.save");
		
		if (!dischargeSummary.isValidated())
			throw new CodingRuntimeException("Logical error - Validate the Vo before saving");
		
		
		DomainFactory factory = getDomainFactory();
		//wdev-11839
		if(!dischargeSummary.getID_DischargeSummaryPacuAndWardIsNotNull())  //check if a new record must be created
		{
			if(getListDIschargeSummaryWP(dischargeSummary).equals(Boolean.TRUE))
				throw new StaleObjectException(null);
			if(getListDIschargeSummaryWPByPasEvent(inpatep).equals(Boolean.TRUE))
				throw new StaleObjectException(null);
		}
		//---------------
		if (voCatsReferralWizard != null)
		{
			if (voCatsReferralWizard == null)
				throw new CodingRuntimeException("Logical error - Cats Referral is null in domain.");
			
			if (!voCatsReferralWizard.isValidated())
				throw new CodingRuntimeException("Logical error - Validate the Cats Referral Vo before saving");

			ReferralWizard impl = (ReferralWizard) getDomainImpl(ReferralWizardImpl.class);
			impl.saveCatsReferral(voCatsReferralWizard);
		}
		
		// WDEV-12134
		if (!dischargeSummary.getID_DischargeSummaryPacuAndWardIsNotNull()
				&& currentDischarge != null && currentDischarge.getID_DischargeSummaryPacuAndWardIsNotNull())
		{
			currentDischarge.setIsCurrent(Boolean.FALSE);
			currentDischarge.validate();
			
			
			DischargeSummaryPacuAndWard domCurrentDischarge = DischargeSummaryPacuAndWardLiteVoAssembler.extractDischargeSummaryPacuAndWard(factory, currentDischarge);
			
			factory.save(domCurrentDischarge);
		}

		DischargeSummaryPacuAndWard domDischargeSummary = DischargeSummaryPacuAndWardVoAssembler.extractDischargeSummaryPacuAndWard(factory, dischargeSummary);
		
		factory.save(domDischargeSummary);
	

		return DischargeSummaryPacuAndWardVoAssembler.create(domDischargeSummary);
	}
	
	//wdev-11839
	private Boolean getListDIschargeSummaryWP(DischargeSummaryPacuAndWardVo dischargeSummary)
	{
		if(dischargeSummary == null)
			return false;
		DomainFactory factory = getDomainFactory();
		String hql = "select d1_1 from DischargeSummaryPacuAndWard as d1_1 left join d1_1.catsReferral as c1_1 left join d1_1.dischargeEpisode as d2_1 where (c1_1.id = :refID and d2_1.id = null) ";
		
		ArrayList<String> paramNames = new ArrayList<String>();
		paramNames.add("refID");
		
		ArrayList<Object> paramValues = new ArrayList<Object>();
		paramValues.add(dischargeSummary.getCatsReferral().getID_CatsReferral());
		List list = factory.find(hql.toString(), paramNames,paramValues);
		DischargeSummaryPacuAndWardLiteVoCollection listpw = DischargeSummaryPacuAndWardLiteVoAssembler.createDischargeSummaryPacuAndWardLiteVoCollectionFromDischargeSummaryPacuAndWard(list);
		if(listpw != null && listpw.size() > 0 )
			return true;
		else
			return false;
	}
	private Boolean getListDIschargeSummaryWPByPasEvent(InpatientEpisodeVo inpat)
	{
		if(inpat == null)
			return false;
		DomainFactory factory = getDomainFactory();
		String hql = "select d1_1 from DischargeSummaryPacuAndWard as d1_1 left join d1_1.dischargeEpisode as d2_1 left join d2_1.pasEvent as p1_1 where (p1_1.id = :pasID) ";
		
		ArrayList<String> paramNames = new ArrayList<String>();
		paramNames.add("pasID");
		
		ArrayList<Object> paramValues = new ArrayList<Object>();
		paramValues.add(inpat.getPasEvent().getID_PASEvent());
		List list = factory.find(hql.toString(), paramNames,paramValues);
		DischargeSummaryPacuAndWardLiteVoCollection listpw = DischargeSummaryPacuAndWardLiteVoAssembler.createDischargeSummaryPacuAndWardLiteVoCollectionFromDischargeSummaryPacuAndWard(list);
		if(listpw != null && listpw.size() > 0 )
			return true;
		else
			return false;
	}
	
	public DischargeSummaryPacuAndWardVo saveAndDischarge(DischargeSummaryPacuAndWardVo dischargeSummary, DischargeSummaryPacuAndWardLiteVo currentDischarge, CatsReferralWizardVo voCatsReferralWizard, DischargedEpisodeVo dischargeEpisode, InpatientEpisodeVo pasEvent) throws DomainInterfaceException, StaleObjectException, ForeignKeyViolationException
	{
		try
		{
			if (voCatsReferralWizard == null || voCatsReferralWizard.getID_CatsReferral() == null)
				throw new CodingRuntimeException(
						"Logical error - Provided referral is null or has no id");

			if (dischargeEpisode == null)
				throw new CodingRuntimeException(
						"Logical error - Discharge episode is null");

			DomainFactory factory = getDomainFactory();
			
			//wdev-11839
			if(!dischargeSummary.getID_DischargeSummaryPacuAndWardIsNotNull())  //check if a new record must be created
			{
				if(getListDIschargeSummaryWP(dischargeSummary).equals(Boolean.TRUE))
					throw new StaleObjectException(null);
				if(getListDIschargeSummaryWPByPasEvent(pasEvent).equals(Boolean.TRUE))
					throw new StaleObjectException(null);
			}
			//---------------
			
			if (!dischargeSummary.getID_DischargeSummaryPacuAndWardIsNotNull()
					&& currentDischarge != null && currentDischarge.getID_DischargeSummaryPacuAndWardIsNotNull())
			{
				currentDischarge.setIsCurrent(Boolean.FALSE);
				currentDischarge.validate();
				
				DischargeSummaryPacuAndWard domCurrentEpisode = DischargeSummaryPacuAndWardLiteVoAssembler.extractDischargeSummaryPacuAndWard(factory, currentDischarge);
				
				factory.save(domCurrentEpisode);
			}
			
			String hql = "from Patient as pat where (pat.id in (select cr.patient.id from CatsReferral as cr where cr.id = :refID))";

			ArrayList<String> paramNames = new ArrayList<String>();
			paramNames.add("refID");

			ArrayList<Object> paramValues = new ArrayList<Object>();
			paramValues.add(voCatsReferralWizard.getID_CatsReferral());

			PatientShort pat = PatientShortAssembler.create((Patient) (factory
					.find(hql, paramNames, paramValues)).get(0));

			if (pat == null)
				throw new DomainRuntimeException(
						"Corresponding patient for referral is null");

			String[] errors = pat.validate();
			if (errors != null && errors.length > 0) {
				throw new DomainRuntimeException("Patient can not be validated");
			}

			DischargedEpisodeVo dischargePatient =  null;
			if (dischargeEpisode.getID_DischargedEpisode() == null)
			{
		 		ADT implADT = (ADT) getDomainImpl(ADTImpl.class);
	    		dischargePatient = implADT.dischargePatient(pat, dischargeEpisode,null);
	       		dischargeSummary.setDischargeEpisode(dischargePatient);
	    		
	   		}
			else
			{
	    		dischargeEpisode.validate();
				DischargedEpisode domDischEpisode = DischargedEpisodeVoAssembler.extractDischargedEpisode(factory, dischargeEpisode);
				factory.save(domDischEpisode);
			}
    		
     		dischargeSummary.validate();
    		
    		if (!dischargeSummary.isValidated())
    			throw new CodingRuntimeException("Logical error - Validate the Vo before saving");
    		
    		if (voCatsReferralWizard != null)
    		{
    			if (!voCatsReferralWizard.isValidated())
    				throw new CodingRuntimeException("Logical error - Validate the Cats Referral Vo before saving");

    			ReferralWizard impl = (ReferralWizard) getDomainImpl(ReferralWizardImpl.class);
    			impl.saveCatsReferral(voCatsReferralWizard);
    		}

    		DischargeSummaryPacuAndWard domDischargeSummary = DischargeSummaryPacuAndWardVoAssembler.extractDischargeSummaryPacuAndWard(factory, dischargeSummary);
    		
    		factory.save(domDischargeSummary);
    	

    		return DischargeSummaryPacuAndWardVoAssembler.create(domDischargeSummary);
		}
		catch (DomainRuntimeException exception)
		{
			if (exception.getMessage().equals("Inpatient episode not found for patient."))
			{
				throw new StaleObjectException(new DischargedEpisode());
			}
			else
				throw new DomainRuntimeException(exception.getMessage());
		}

	}
	//---------------

	public Date getCurrentAddmissionDate(DischargedEpisodeRefVo dischargedEpisode)
	{
		if (dischargedEpisode == null || !dischargedEpisode.getID_DischargedEpisodeIsNotNull())
			throw new DomainRuntimeException("Logical error - Discharged episode pass is null");
		
		DischargedEpisode episode = (DischargedEpisode) getDomainFactory().getDomainObject(DischargedEpisode.class, dischargedEpisode.getID_DischargedEpisode());
		
		if (episode == null || episode.getPasEvent() == null)
			return null;

		return new Date(episode.getPasEvent().getEventDateTime());
	}

	public Date getAdmissionDate(CatsReferralRefVo voCatsRef)
	{
		if (voCatsRef == null)
			throw new DomainRuntimeException("Logical error - Cats Referral passed is null");
		
		CatsReferral referral = (CatsReferral) getDomainFactory().getDomainObject(CatsReferral.class, voCatsRef.getID_CatsReferral());
		
		if (referral.getCareContext() == null || referral.getCareContext().getPasEvent() == null)
			return null;
		
		return new Date(referral.getCareContext().getPasEvent().getEventDateTime());
	}

	public PatientDiagnosisLiteVoCollection getDiagnosis(CareContextRefVo careContextRef)
	{
		if (careContextRef == null || !careContextRef.getID_CareContextIsNotNull())
			return null;
		
		IMSCriteria criteria = new IMSCriteria(PatientDiagnosis.class, getDomainFactory());
		
		criteria.equal("this.careContext.id", careContextRef.getID_CareContext());

		return PatientDiagnosisLiteVoAssembler.createPatientDiagnosisLiteVoCollectionFromPatientDiagnosis(criteria.find());
	}

	public PatientProcedureRefVo getPerformedProcedureFromLastIntraOperativeRecordForCareContext(CareContextRefVo careContextRef) 
	{
		if (careContextRef == null || !careContextRef.getID_CareContextIsNotNull())
			throw new CodingRuntimeException("A care context must be selected");

		IMSCriteria criteria = new IMSCriteria(IntraOperativeCareRecord.class, getDomainFactory());	
		criteria.equal("this.careContext.id", careContextRef.getID_CareContext());
		criteria.addOrder("this.systemInformation.creationDateTime", ORDERMODE.DESC);
		
		List<IntraOperativeCareRecord> listIntraOperativeCareRecord = criteria.find();
		IntraOperativeCareRecordVo voIntra = listIntraOperativeCareRecord.size() > 0 ? IntraOperativeCareRecordVoAssembler.create((IntraOperativeCareRecord)listIntraOperativeCareRecord.get(0)) : null;
		return voIntra != null ? voIntra.getActualProcedure() : null;
	}

	public Boolean hasInapatientEpisode(PatientRefVo patient)
	{
		if (patient == null || !patient.getID_PatientIsNotNull())
			throw new DomainRuntimeException("Invalid patient record in domain");
		
		String query = "select count(inpatient) from InpatientEpisode as inpatient left join inpatient.pasEvent as pas left join pas.patient as patient where patient.id = :PAT_ID";
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("PAT_ID");
		paramValues.add(patient.getID_Patient());
		
		@SuppressWarnings("unchecked")
		List<Object> results = getDomainFactory().find(query, paramNames, paramValues);
		
		if (results == null || results.size() == 0)
			return Boolean.FALSE;
		
		if(results.size() > 0 && results.get(0) instanceof Long && (Long)(results.get(0)) > 0)
			return Boolean.TRUE;

		return Boolean.FALSE;
	}

	public DischargedEpisodeVo getDischargedEpisode(DischargedEpisodeRefVo dischargedEpisodeRef)
	{
		if (dischargedEpisodeRef == null || !dischargedEpisodeRef.getID_DischargedEpisodeIsNotNull())
			return null;
		
		return DischargedEpisodeVoAssembler.create((DischargedEpisode) getDomainFactory().getDomainObject(DischargedEpisode.class, dischargedEpisodeRef.getID_DischargedEpisode())); 
	}

	/**
	 * WDEV-11987
	 * Function used to mark the CATS Referral a having cancelled appointments
	 */
	public void updateCatsReferralCancelStatus(CatsReferralRefVo referral) throws StaleObjectException
	{
		if(referral == null || referral.getID_CatsReferral() == null)
			throw new CodingRuntimeException("catsReferral is null or id not provided in method updateCatsReferralAdditionalInvStatus");
		
		DomainFactory factory = getDomainFactory();
		
		CatsReferral doCatsReferral = (CatsReferral) factory.getDomainObject(referral);
		
		doCatsReferral.setHasCancelledApptsForReview(true);
		factory.save(doCatsReferral);
	}

	public Boolean isLinkedICPCompleted(CatsReferralRefVo catsReferral)
	{
		if (!ConfigFlag.GEN.CREATE_ICP_ON_ACCEPTANCE_OF_REFERRAL.getValue())
		{
			return false;
		}
		if (catsReferral == null || !catsReferral.getID_CatsReferralIsNotNull())
			return false;
		String hql = "select count(patICP.id) from PatientICP as patICP left join patICP.careContext as careC," +
				" CatsReferral as cats left join cats.careContext as catsCC " +
				"where (cats.id = :catsId and patICP.completedDateTime is not null and catsCC.id = careC.id)";
		long count = getDomainFactory().countWithHQL(hql,new String[]{"catsId"},new Object[]{catsReferral.getID_CatsReferral()});
		return count > 0;
	}
}