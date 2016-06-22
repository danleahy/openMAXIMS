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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.65 build 3195.17642)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.scheduling.domain.impl;

import ims.admin.vo.lookups.HardCodedEvents;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.OrderInvAppt;
import ims.RefMan.vo.CatsReferralListVo;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.domain.CatsReferralListVoAssembler;
import ims.RefMan.vo.lookups.AdditionalInvestigationAppointmentsStatus;
import ims.chooseandbook.vo.lookups.ActionRequestType;
import ims.configuration.gen.ConfigFlag;
import ims.core.clinical.domain.objects.Procedure;
import ims.core.clinical.domain.objects.Service;
import ims.core.domain.PatientSearch;
import ims.core.domain.impl.PatientSearchImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.resource.place.domain.objects.Activity;
import ims.core.resource.place.vo.ActivityRefVo;
import ims.core.vo.ServiceLiteVo;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.PatientListVoAssembler;
import ims.core.vo.domain.ProcedureLiteVoAssembler;
import ims.core.vo.domain.ServiceLiteVoAssembler;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.ServiceCategory;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;
import ims.ocrr.orderingresults.domain.objects.OrderedInvestigationStatus;
import ims.ocrr.orderingresults.vo.OrderInvestigationRefVo;
import ims.ocrr.vo.lookups.OrderInvStatus;
import ims.pathways.configuration.domain.objects.Event;
import ims.pathways.domain.HL7PathwayIf;
import ims.pathways.domain.impl.HL7PathwayIfImpl;
import ims.pathways.domain.objects.PathwayClock;
import ims.pathways.domain.objects.PathwayRTTStatus;
import ims.pathways.domain.objects.PatientPathwayJourney;
import ims.pathways.vo.EventLiteVo;
import ims.pathways.vo.PatientEventVo;
import ims.pathways.vo.domain.EventLiteVoAssembler;
import ims.pathways.vo.domain.PatientEventVoAssembler;
import ims.pathways.vo.domain.PatientJourneyVoAssembler;
import ims.pathways.vo.lookups.EventStatus;
import ims.scheduling.domain.OCSExternalEvents;
import ims.scheduling.domain.SessionAdmin;
import ims.scheduling.domain.base.impl.BasePatientAppointmentManagementImpl;
import ims.scheduling.domain.objects.Booking_Appointment;
import ims.scheduling.helper.CABRequests;
import ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVoCollection;
import ims.scheduling.vo.Booking_AppointmentRefVo;
import ims.scheduling.vo.Booking_AppointmentShortVo;
import ims.scheduling.vo.Booking_AppointmentShortVoCollection;
import ims.scheduling.vo.Booking_AppointmentVo;
import ims.scheduling.vo.Booking_AppointmentVoCollection;
import ims.scheduling.vo.SessionServiceAndSlotActivityVo;
import ims.scheduling.vo.SessionServiceProcedureConsultantVo;
import ims.scheduling.vo.domain.Booking_AppointmentShortVoAssembler;
import ims.scheduling.vo.domain.Booking_AppointmentVoAssembler;
import ims.scheduling.vo.lookups.LookupHelper;
import ims.scheduling.vo.lookups.Status_Reason;

import java.util.Iterator;
import java.util.List;

public class PatientAppointmentMangementRefManImpl extends BasePatientAppointmentManagementImpl
{

	private static final long serialVersionUID = 1L;
	private static final int PATIENT_DNA_NAT_CODE = 33;

	/**
	* searchPatients
	*/
	public ims.core.vo.PatientShortCollection searchPatients(ims.core.vo.PatientFilter filter) throws ims.domain.exceptions.DomainInterfaceException
	{
		if(filter == null)
			throw new CodingRuntimeException("parameter filter is null in method searchPatients");
		
		PatientSearch impl = (PatientSearch) getDomainImpl(PatientSearchImpl.class);
		return impl.searchPatients(filter);
	}

	public Booking_AppointmentShortVoCollection listBookingAppointmentByPatientAndDate(PatientRefVo patient, Date apptDate)
	{
		if(patient == null || patient.getID_Patient() == null)
			throw new CodingRuntimeException("patient parameter is null or id not supplied in method listBookingAppointmentByPatientAndDate");
		
		if(apptDate == null)
			throw new CodingRuntimeException("apptDate parameter is null in method listBookingAppointmentByPatientAndDate");
		
		DomainFactory factory = getDomainFactory();
		List appts = factory.find("select bookingAppt from Sch_Booking as schBook left join schBook.appointments as bookingAppt where (schBook.patient.id = :idPatient and bookingAppt.appointmentDate = :apptDate and bookingAppt.theatreBooking = null)", 
				new String[]{"idPatient","apptDate"}, new Object[]{patient.getID_Patient(), apptDate.getDate()});
		
		return Booking_AppointmentShortVoAssembler.createBooking_AppointmentShortVoCollectionFromBooking_Appointment(appts);
	}

	public Booking_AppointmentVo saveBookingAppt(Booking_AppointmentShortVo appt, Boolean bUndoArrival, Boolean bUndoDNA) throws DomainInterfaceException, StaleObjectException
	{
		if(appt == null)
			throw new CodingRuntimeException("appt parameter is null in method saveBookingAppt");
		
		if(!appt.isValidated())
			throw new CodingRuntimeException("appt parameter has not been validated");
	
		BookingAppointmentForLinkedAppointmentsVoCollection collLinkedApptToBeCancelled = appt.getLinkedApptsToBeCancelledIsNotNull() ? (BookingAppointmentForLinkedAppointmentsVoCollection)appt.getLinkedApptsToBeCancelled().clone() : null;  //WDEV-19543
		
		DomainFactory factory = getDomainFactory();	
		
		//WDEV-11780 - starts here
		if(appt.getID_Booking_AppointmentIsNotNull())
		{
			long count  = getDomainFactory().countWithHQL("select count(b.id) from Booking_Appointment as b where (b.id = :bId and b.version > :bVersion)" ,new String[]{"bId","bVersion"}, new Object[]{appt.getID_Booking_Appointment(),appt.getVersion_Booking_Appointment()});
			
			if(count > 0)
				throw new StaleObjectException(null);
		}
		//WDEV-11780 - ends here
		
		Booking_Appointment doBookAppt = Booking_AppointmentShortVoAssembler.extractBooking_Appointment(factory, appt);
		
		//increment slots remaining if its a cancel
		if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.CANCELLED)))
			doBookAppt.getSession().incrementRemainingSlots(1);
		
		List ordinvList = null;
		if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.DNA)) || doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.ARRIVAL)))
			ordinvList = factory.find("from OrderInvAppt ordInvAppt where ordInvAppt.appointment.id = " + doBookAppt.getId());
		
		if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.DNA)) || doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.CANCELLED)))
		{
			//WDEV-5711 - generateOrderPatientDNAEvent or generateOrderCancelEvent
			if(ordinvList != null && ordinvList.size() >= 0)
			{
				Iterator it = ordinvList.iterator();
				boolean catsReferralUpdated = false;
				while(it.hasNext())
				{
					OrderInvAppt doOrderInvAppt = (OrderInvAppt) it.next();
					OCSExternalEvents impl = (OCSExternalEvents) getDomainImpl(OCSExternalEventsImpl.class); 
					if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.DNA)))
					{
						impl.generateOrderPatientDNAEvent(new Booking_AppointmentRefVo(doOrderInvAppt.getAppointment().getId(), doOrderInvAppt.getAppointment().getVersion()), new OrderInvestigationRefVo(doOrderInvAppt.getOrderInvestigation().getId(), doOrderInvAppt.getOrderInvestigation().getVersion()));
						//WDEV-5727 
						if(!catsReferralUpdated)
						{
							saveCatsReferralwithAddtionalInvApptStatus(factory, doOrderInvAppt, AdditionalInvestigationAppointmentsStatus.DNA);
							catsReferralUpdated = true;
						}
						
						//WDEV-5740
						OrderedInvestigationStatus voOrdInvStatus = new OrderedInvestigationStatus();
						voOrdInvStatus.setChangeDateTime(new Date().getDate());
						voOrdInvStatus.setProcessedDateTime(new java.util.Date());
						voOrdInvStatus.setOrdInvStatus(getDomLookup(OrderInvStatus.HOLD_REQUESTED));
						voOrdInvStatus.setStatusReason("Patient DNA'd associated Appt");
						doOrderInvAppt.getOrderInvestigation().setOrdInvCurrentStatus(voOrdInvStatus);
						doOrderInvAppt.getOrderInvestigation().getOrdInvStatusHistory().add(voOrdInvStatus);
						factory.save(doOrderInvAppt);
					}	
				}
			}
			if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.DNA)))
			{
				if(ConfigFlag.GEN.ICAB_ENABLED.getValue())
				{
					if(doBookAppt.isIsCABBooking() != null && doBookAppt.isIsCABBooking().booleanValue())
						CABRequests.sendRequestandUpdateReferences(factory, getDomLookup(ActionRequestType.NOTIFY_DNA), doBookAppt, "Appt DNA Requested from Patient Appt Management");
				}
			}
			else if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.CANCELLED)))
			{
				SessionAdmin implSessionAdmin = (SessionAdmin) getDomainImpl(SessionAdminImpl.class);
				
				//WDEV-19543
				Booking_AppointmentVo voAppt = Booking_AppointmentVoAssembler.create(doBookAppt);	
				voAppt.setLinkedApptsToBeCancelled(collLinkedApptToBeCancelled);
				
				voAppt = implSessionAdmin.cancelAppt(voAppt , ActionRequestType.NOTIFY_APPT_CANCEL, "Patient Appointment management");
				return voAppt;
			}	
		}
		
		if (bUndoArrival)
		{
			clearLastApptArrivedDate(factory, doBookAppt);
			createNewPatientEvent(doBookAppt, HardCodedEvents.APPOINTMENTUNARRIVED);//WDEV-19772 
		}
		
		//wdev-12090
		if(bUndoDNA)
		{
			//WDEV-22375 clearhasDNAApptsForReview(factory, doBookAppt);
			createNewPatientEvent(doBookAppt, HardCodedEvents.APPOINTMENTUNDNA);//WDEV-19772 
		}
			
		if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.ARRIVAL)))
		{
			//WDEV-6239 - last appt arrived
			if(doBookAppt.getSession() != null &&  doBookAppt.getSession().getService() != null &&  doBookAppt.getSession().getService().getServiceCategory() != null)
			{
				if(doBookAppt.getSession().getService().getServiceCategory().equals( getDomLookup(ServiceCategory.CLINICAL)))
					saveLastApptArrivedDate(factory, doBookAppt);
			}
			
			//WDEV-5711 - generatePatientArrivingEvent 
			OCSExternalEvents impl = (OCSExternalEvents) getDomainImpl(OCSExternalEventsImpl.class); 
			impl.generatePatientArrivingEvent(new Booking_AppointmentRefVo(doBookAppt.getId(), 0), null);
			
			createNewPatientEvent(doBookAppt, HardCodedEvents.APPOINTMENTATTENDED);//WDEV-19772 
		}
		
		factory.save(doBookAppt);
		return Booking_AppointmentVoAssembler.create(doBookAppt);
	}
	
	private void createNewPatientEvent(Booking_Appointment doBookAppt, HardCodedEvents hardCodedEvent) throws StaleObjectException
	{
		if (ConfigFlag.DOM.PATHWAY_ENTITY_EVENT_FUNCTIONALITY.getValue() && doBookAppt!= null && doBookAppt.getActivity() != null && doBookAppt.getActivity().isFirstAppointment() && hardCodedEvent != null)			
		{
			DomainFactory factory = getDomainFactory();	
			EventLiteVo event = getHardCodedEvent(hardCodedEvent.getId());
			PatientEventVo savedPatEv = createPatientEvent(doBookAppt, event);
			if (savedPatEv != null)
				doBookAppt.getPathwayEvents().add(PatientEventVoAssembler.extractPatientEvent(factory, savedPatEv));	    			
		}	
	}
	//WDEV-20603- 
	private DateTime getArrivalDateTime(Booking_Appointment doAppt) 
	{
		if(doAppt == null || !Status_Reason.ARRIVAL.equals(LookupHelper.getStatus_ReasonInstance(getLookupService(), doAppt.getApptStatus().getId())))		
			return null;
		return new DateTime(doAppt.getAppointmentDate()!= null ? new Date( doAppt.getAppointmentDate()): new Date(),
							doAppt.getArrivalTime()!=null ? new Time(doAppt.getArrivalTime()):new Time());
	}
	private PatientEventVo createPatientEvent(Booking_Appointment doBookAppt, EventLiteVo hardCodedEvent) throws StaleObjectException
	{
		CatsReferral catsReferral = getCatsReferralforAppt(doBookAppt);
		PatientPathwayJourney patientJBo = catsReferral != null ? catsReferral.getJourney() : null;
		
		PatientEventVo savedPatEv = null;
		
		if (patientJBo != null && hardCodedEvent != null)
		{				
				DateTime arrivalDateTime = getArrivalDateTime(doBookAppt);
				PatientEventVo patEvent = new PatientEventVo();
				patEvent.setPatient((PatientRefVo)PatientListVoAssembler.create(catsReferral.getPatient()));
				patEvent.setEvent(hardCodedEvent);
				patEvent.setEventDateTime(arrivalDateTime!= null ? arrivalDateTime : new DateTime() );//WDEV-20603- if is not Arrival events the method will return actual date/time 
				patEvent.setEventStatus(EventStatus.ACTIVE);
				patEvent.setJourney(PatientJourneyVoAssembler.create(patientJBo));
				
				HL7PathwayIf implPath = (HL7PathwayIf) getDomainImpl(HL7PathwayIfImpl.class);
				try
				{
					savedPatEv = implPath.instantiatePatientEvent(patEvent);
				}
				catch (DomainInterfaceException e)
				{ throw new DomainRuntimeException("Domain Error occured in save Event " + e.getMessage(), e);}
		}
		
		return savedPatEv;
	}

	public EventLiteVo getHardCodedEvent(int event_Id)
	{
		StringBuilder hqlBuilder = new StringBuilder("select event from Event as event left join event.status as s where event.id = :eventID and s.id = :statusID ");
		
		List <?> list = getDomainFactory().find(hqlBuilder.toString(),new String[] {"eventID", "statusID"},new Object[] {event_Id, PreActiveActiveInactiveStatus.ACTIVE.getID()});
		
		if (list == null || list.size() == 0)
			return null;
		
		return EventLiteVoAssembler.create((Event)list.get(0));
	}

	private void saveLastApptArrivedDate(DomainFactory factory, Booking_Appointment doBookAppt) throws StaleObjectException
	{
		if(factory == null || doBookAppt == null)
			throw new CodingRuntimeException("all mandatory params not populated for method saveLastApptArrivedDate");
		
		List lstCatsRef = factory.find("from CatsReferral catsRef join fetch catsRef.appointments appt where appt.id = '" + doBookAppt.getId() + "'");
		if(lstCatsRef != null && lstCatsRef.size() == 1)
		{
			CatsReferral doCatsRef = (CatsReferral) lstCatsRef.get(0);
			doCatsRef.setLastApptArrivedDate(new Date().getDate());
			factory.save(doCatsRef);
		}
	}

	private void clearLastApptArrivedDate(DomainFactory factory, Booking_Appointment doBookAppt) throws StaleObjectException
	{
		if(factory == null || doBookAppt == null)
			throw new CodingRuntimeException("all mandatory params not populated for method saveLastApptArrivedDate");
		
		List<?> lstCatsRef = factory.find("select referral from CatsReferral as referral where referral.id in (select catsRef from CatsReferral as catsRef left join catsRef.appointments appt where appt.id = '" + doBookAppt.getId() + "')");

		if(lstCatsRef != null && lstCatsRef.size() == 1)
		{
			CatsReferral doCatsRef = (CatsReferral) lstCatsRef.get(0);
			
			//WDEV-17987
			if (canClearLastPatArrivedDate(doCatsRef))
			{
				doCatsRef.setLastApptArrivedDate(null);
			}
			
			factory.save(doCatsRef);
		}
	}
	
	private boolean canClearLastPatArrivedDate(CatsReferral doCatsRef)
	{
		if (doCatsRef.getAppointments() == null)
			return true;

		Iterator<?> it1 = doCatsRef.getAppointments().iterator();

		while (it1.hasNext())
		{
			Booking_Appointment doItem = (Booking_Appointment) it1.next();

			if (doItem.getApptStatus() != null && (doItem.getApptStatus().equals(getDomLookup(Status_Reason.ARRIVAL)) || doItem.getApptStatus().equals(getDomLookup(Status_Reason.SEEN))))
			{
				return false;
			}
		}

		return true;
	}
	/*
	//wdev-12090
	private void clearhasDNAApptsForReview(DomainFactory factory, Booking_Appointment doBookAppt) throws StaleObjectException
	{
		if(factory == null || doBookAppt == null)
			throw new CodingRuntimeException("all mandatory params not populated");

		
		//wdev-12344
		List lstCatsRefId = factory.find("select c1_1.id from CatsReferral as c1_1 left join c1_1.appointments as b1_1 where b1_1.id = '" + doBookAppt.getId() + "'");
		if(lstCatsRefId != null && lstCatsRefId.size() > 0)
		{
			Integer idCatsRef = (Integer)lstCatsRefId.get(0);
		
			List lstCatsRef = factory.find("select c1_1 from CatsReferral as c1_1 left join c1_1.appointments as b1_1 where (b1_1.apptStatus = :statusDNA and c1_1.id = :catsId)",
					new String[]{"statusDNA","catsId"}, new Object[]{getDomLookup(Status_Reason.DNA), idCatsRef});
						
			if(lstCatsRef != null && lstCatsRef.size() == 1)
			{
				CatsReferral doCatsRef = (CatsReferral) lstCatsRef.get(0);
				doCatsRef.setHasDNAApptsForReview(null);
				factory.save(doCatsRef);
			}
		}
		//end wdev-12344
	}
	*/
	//--------------
	//WDEV-5727 update the AddtionalInvApptStatus in the CatsReferral
	private void saveCatsReferralwithAddtionalInvApptStatus(DomainFactory factory, OrderInvAppt doOrderInvAppt, AdditionalInvestigationAppointmentsStatus status) throws StaleObjectException
	{
		if(factory == null || doOrderInvAppt == null || status == null)
			throw new CodingRuntimeException("all mandatory params not populated for method saveCatsReferralwithAddtionalInvApptStatus");
		
		List lstCatsRef = factory.find("from CatsReferral catsRef join fetch catsRef.orderInvAppts ordInvAppt where ordInvAppt.id = '" + doOrderInvAppt.getId() + "'");
		if(lstCatsRef != null && lstCatsRef.size() == 1)
		{
			CatsReferral doCatsRef = (CatsReferral) lstCatsRef.get(0);
			doCatsRef.setAdditionalInvApptsStatus(getDomLookup(status));

			factory.save(doCatsRef);
		}
	}

	/**
	 * getServiceAndActivityByAppt
	 * using the BookingAppointment need to get the slot activity and the session service to facilitate rebooking
	 */
	public SessionServiceAndSlotActivityVo getServiceAndActivityByAppt(Booking_AppointmentRefVo appt, Boolean isFlexible)
	{
		if(appt == null || appt.getID_Booking_Appointment() == null)
			throw new CodingRuntimeException("appt param or if for appt is null in method getServiceAndActivityByAppt");
	
		SessionServiceAndSlotActivityVo voServiceAndSlot = null;
		
		String hql = "select activity, session.service from Booking_Appointment as appt left join appt.activity as activity left join appt.session as session where (appt.id = :idAppt)";
		List items = getDomainFactory().find(hql, new String[]{"idAppt"}, new Object[]{appt.getID_Booking_Appointment()});
		if(items != null && items.size() > 0)
		{
			Iterator it = items.iterator();	
			if(it.hasNext())
			{
				Object[] item = (Object[]) it.next();
				Activity doActivity = (Activity) item[0];
				Service doService = (Service) item[1];
				
				//WDEV-20882
				if(doActivity != null)
				{
					ActivityRefVo voActivity = new ActivityRefVo(doActivity.getId(), doActivity.getVersion());
					ServiceLiteVo voService = ServiceLiteVoAssembler.create(doService);
					
					voServiceAndSlot = new SessionServiceAndSlotActivityVo();
					voServiceAndSlot.setSessionService(voService);
					voServiceAndSlot.setSlotActivity(voActivity);
				}
			}
		}
	
		return voServiceAndSlot;
	}

	public CatsReferralListVo getCatsReferralForAppointment(Booking_AppointmentRefVo appt)
	{
		if(appt == null || appt.getID_Booking_Appointment() == null)
			throw new CodingRuntimeException("appt is null or id not provide for getCatsReferralForAppointment");
		
		DomainFactory factory = getDomainFactory();
		List catsRefId = factory.find("select catsRef.id from CatsReferral as catsRef left join catsRef.appointments as bookAppt where (bookAppt.id = '" + appt.getID_Booking_Appointment() + "')");
		if(catsRefId != null && catsRefId.size() > 0 && catsRefId.get(0) != null)
		{
			Integer val = (Integer) catsRefId.get(0);
			if(val != null && val.intValue() > 0)
			{
			//	return new CatsReferralRefVo(val, 0);//wdev-11902
				return CatsReferralListVoAssembler.create((CatsReferral)getDomainFactory().getDomainObject(CatsReferral.class, val));//voReferralRef.getID_CatsReferral()));
			}
		}	
		return null;		
	}

	@Deprecated
	// Code legacy method - use the new form of the method please
	public void updateCatsReferralAdditionalInvStatus(CatsReferralRefVo catsReferral) throws StaleObjectException
	{
		updateCatsReferralAdditionalInvStatus(catsReferral, null);
	}

	public void updateCatsReferralAdditionalInvStatus(CatsReferralRefVo catsReferral,  Booking_AppointmentRefVo appt) throws StaleObjectException
	{
		SessionAdmin impl = (SessionAdmin) getDomainImpl(SessionAdminImpl.class);
		impl.updateCatsReferralAdditionalInvStatus(catsReferral, appt);		
	}

	public SessionServiceProcedureConsultantVo getServiceProcedureConsultantByAppt(Booking_AppointmentShortVo appt)
	{
		if(appt == null || appt.getID_Booking_Appointment() == null)
			throw new CodingRuntimeException("appt param or if for appt is null in method getServiceAndProcedureByAppt");
	
		SessionServiceProcedureConsultantVo voServiceProcCons = null;
		String hql = "select sess.service, theatreBook.procedure, theatreBook.consultant from Booking_Appointment as bookAppt left join bookAppt.session as sess left join bookAppt.theatreBooking as theatreBook where (bookAppt.id = :idAppt)";
		List items = getDomainFactory().find(hql, new String[]{"idAppt"}, new Object[]{appt.getID_Booking_Appointment()});
		
		if(items != null && items.size() > 0)
		{
			Iterator it = items.iterator();	
			if(it.hasNext())
			{
				Object[] item = (Object[]) it.next();
				Service doService = (Service) item[0];
				Procedure doProc = (Procedure) item[1];
				Hcp doConsultant = (Hcp) item[2];
				
			
				voServiceProcCons = new SessionServiceProcedureConsultantVo();
				voServiceProcCons.setService(ServiceLiteVoAssembler.create(doService));
				voServiceProcCons.setProcedure(ProcedureLiteVoAssembler.create(doProc));
				voServiceProcCons.setConsultant(HcpLiteVoAssembler.create(doConsultant));
			}
		}
		return voServiceProcCons;
	}

	public void updateCatsReferralCancelStatus(CatsReferralRefVo catsReferral) throws StaleObjectException  //WDEV-19543
	{
		SessionAdmin impl = (SessionAdmin) getDomainImpl(SessionAdminImpl.class);
		impl.updateCatsReferralCancelStatus(catsReferral);	
	}

	
	public Booking_AppointmentVo getBookingAppointmet(Booking_AppointmentRefVo bookingApptRef)
	{
		if(bookingApptRef == null || !bookingApptRef.getID_Booking_AppointmentIsNotNull() )
			throw new CodingRuntimeException("bookingApptRef is null ");

		String hql = "from Booking_Appointment as b1_1 where (b1_1.id = :idAppt)";
		List items = getDomainFactory().find(hql, new String[]{"idAppt"}, new Object[]{bookingApptRef.getID_Booking_Appointment()});
		
		if(items != null && items.size() > 0)
		{
			Booking_AppointmentVoCollection tempCol =  Booking_AppointmentVoAssembler.createBooking_AppointmentVoCollectionFromBooking_Appointment(items);
			if(tempCol != null && tempCol.size() > 0)
				return tempCol.get(0);
			
		}

		return null;
	}
	
	public Booking_AppointmentVo saveBookingApptFull(Booking_AppointmentVo bookingApptFull, Boolean isProcessedForRTT) throws DomainInterfaceException, StaleObjectException
	{
		
		if(bookingApptFull == null)
			throw new CodingRuntimeException("appt parameter is null in method saveBookingAppt");
		
		if(!bookingApptFull.isValidated())
			throw new CodingRuntimeException("appt parameter has not been validated");
	
		DomainFactory factory = getDomainFactory();	
		
		//WDEV-11780 - starts here
		if(bookingApptFull.getID_Booking_AppointmentIsNotNull())
		{
			long count  = getDomainFactory().countWithHQL("select count(b.id) from Booking_Appointment as b where (b.id = :bId and b.version > :bVersion)" ,new String[]{"bId","bVersion"}, new Object[]{bookingApptFull.getID_Booking_Appointment(),bookingApptFull.getVersion_Booking_Appointment()});
			
			if(count > 0)
				throw new StaleObjectException(null);
		}
		//WDEV-11780 - ends here
		
		Booking_Appointment doBookAppt = Booking_AppointmentVoAssembler.extractBooking_Appointment(factory, bookingApptFull);
		
		//increment slots remaining if its a cancel
		if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.CANCELLED)))
			doBookAppt.getSession().incrementRemainingSlots(1);
		
		if (isProcessedForRTT)
		{
			CatsReferral catsReferralDO = getCatsReferralforAppt(doBookAppt);

			if (catsReferralDO != null && Boolean.TRUE.equals(catsReferralDO.isRTTClockImpact()))	
			{
				PatientPathwayJourney journeyDO = catsReferralDO.getJourney();

				if  (journeyDO != null)
				{
					if (journeyDO.getCurrentClock() != null)
					{
						PathwayClock ptwClockDO = journeyDO.getCurrentClock();

						if (ptwClockDO.getRTTStatusHistory() != null)
						{	
							int statusHistorySize = ptwClockDO.getRTTStatusHistory().size();
							PathwayRTTStatus prevRTTStatus  = null;	
							if (statusHistorySize >=0)
							{	
								if (statusHistorySize >= 2)
								{
									prevRTTStatus = getCurrentClockPreviousRTTStatus(ptwClockDO);

									if (prevRTTStatus != null)
									{	
										ptwClockDO.setCurrentRTTStatus(prevRTTStatus);
										catsReferralDO.setCurrentRTTStatus(prevRTTStatus);

										ptwClockDO.getRTTStatusHistory().remove(statusHistorySize - 1);
									}
								}		
								else  if (ptwClockDO.getCurrentRTTStatus() != null && ptwClockDO.getCurrentRTTStatus().getRTTStatus().getNationalCode() == PATIENT_DNA_NAT_CODE)//WDEV-20116
								{
									ptwClockDO.setCurrentRTTStatus(null);
									catsReferralDO.setCurrentRTTStatus(null);
								}
								factory.save(catsReferralDO);

							}	
						}

					}
				}
			}	
		}
		
		List ordinvList = null;
		if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.DNA)) || doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.ARRIVAL)))
			ordinvList = factory.find("from OrderInvAppt ordInvAppt where ordInvAppt.appointment.id = " + doBookAppt.getId());
		
		if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.DNA)) || doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.CANCELLED)))
		{
			//WDEV-5711 - generateOrderPatientDNAEvent or generateOrderCancelEvent
			if(ordinvList != null && ordinvList.size() >= 0)
			{
				Iterator it = ordinvList.iterator();
				boolean catsReferralUpdated = false;
				while(it.hasNext())
				{
					OrderInvAppt doOrderInvAppt = (OrderInvAppt) it.next();
					OCSExternalEvents impl = (OCSExternalEvents) getDomainImpl(OCSExternalEventsImpl.class); 
					if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.DNA)))
					{
						impl.generateOrderPatientDNAEvent(new Booking_AppointmentRefVo(doOrderInvAppt.getAppointment().getId(), doOrderInvAppt.getAppointment().getVersion()), new OrderInvestigationRefVo(doOrderInvAppt.getOrderInvestigation().getId(), doOrderInvAppt.getOrderInvestigation().getVersion()));
						//WDEV-5727 
						if(!catsReferralUpdated)
						{
							saveCatsReferralwithAddtionalInvApptStatus(factory, doOrderInvAppt, AdditionalInvestigationAppointmentsStatus.DNA);
							catsReferralUpdated = true;
						}
						
						//WDEV-5740
						OrderedInvestigationStatus voOrdInvStatus = new OrderedInvestigationStatus();
						voOrdInvStatus.setChangeDateTime(new Date().getDate());
						voOrdInvStatus.setProcessedDateTime( new java.util.Date());
						voOrdInvStatus.setOrdInvStatus(getDomLookup(OrderInvStatus.HOLD_REQUESTED));
						voOrdInvStatus.setStatusReason("Patient DNA'd associated Appt");
						doOrderInvAppt.getOrderInvestigation().setOrdInvCurrentStatus(voOrdInvStatus);
						doOrderInvAppt.getOrderInvestigation().getOrdInvStatusHistory().add(voOrdInvStatus);
						factory.save(doOrderInvAppt);
					}	
				}
			}
			if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.DNA)))
			{
				if(ConfigFlag.GEN.ICAB_ENABLED.getValue())
				{
					if(doBookAppt.isIsCABBooking() != null && doBookAppt.isIsCABBooking().booleanValue())
						CABRequests.sendRequestandUpdateReferences(factory, getDomLookup(ActionRequestType.NOTIFY_DNA), doBookAppt, "Appt DNA Requested from Patient Appt Management");
				}
			}
			else if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.CANCELLED)))
			{
				SessionAdmin implSessionAdmin = (SessionAdmin) getDomainImpl(SessionAdminImpl.class);
				Booking_AppointmentVo voAppt = Booking_AppointmentVoAssembler.create(doBookAppt);
				voAppt = implSessionAdmin.cancelAppt(Booking_AppointmentVoAssembler.create(doBookAppt)   , ActionRequestType.NOTIFY_APPT_CANCEL, "Patient Appointment management");
				return voAppt;
			}	
		}
		
		
		
		//wdev-12090
		//WDEV-22375 clearhasDNAApptsForReview(factory, doBookAppt);
		//---
		if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.BOOKED)))
			createNewPatientEvent(doBookAppt, HardCodedEvents.APPOINTMENTUNDNA);//WDEV-19772 
			
		if(doBookAppt.getApptStatus().equals(getDomLookup(Status_Reason.ARRIVAL)))
		{
			//WDEV-6239 - last appt arrived
			if(doBookAppt.getSession() != null &&  doBookAppt.getSession().getService() != null &&  doBookAppt.getSession().getService().getServiceCategory() != null)
			{
				if(doBookAppt.getSession().getService().getServiceCategory().equals( getDomLookup(ServiceCategory.CLINICAL)))
					saveLastApptArrivedDate(factory, doBookAppt);
			}
			
			//WDEV-5711 - generatePatientArrivingEvent 
			OCSExternalEvents impl = (OCSExternalEvents) getDomainImpl(OCSExternalEventsImpl.class); 
			impl.generatePatientArrivingEvent(new Booking_AppointmentRefVo(doBookAppt.getId(), 0), null);			
		}
		
		factory.save(doBookAppt);
		return Booking_AppointmentVoAssembler.create(doBookAppt);

	}
	
	private CatsReferral getCatsReferralforAppt(Booking_Appointment doBookAppt)
	{
		String hql = "select cats from CatsReferral as cats left join cats.appointments as appts where appts.id = :apptID";
		
		List<?> list = getDomainFactory().find(hql, new String[]{"apptID"}, new Object[]{doBookAppt.getId()});
		
		if (list != null && list.size() > 0 && list.get(0) instanceof CatsReferral)
		{
			return (CatsReferral) list.get(0);
		}
		return null;
	}

	private PathwayRTTStatus getCurrentClockPreviousRTTStatus(PathwayClock ptwClockDO) throws StaleObjectException //WDEV-18325 //WDEV-20116
	{
		if (ptwClockDO == null)
			return null;	

		if (isCurrentRTTStatusDNA(ptwClockDO) && ptwClockDO.getRTTStatusHistory() != null)
		{
			int statusHistorySize = ptwClockDO.getRTTStatusHistory().size();

			if (statusHistorySize >= 2)
			{
				PathwayRTTStatus previousRTTStatus = ptwClockDO.getRTTStatusHistory().get(statusHistorySize - 2) != null && ptwClockDO.getRTTStatusHistory().get(statusHistorySize - 2) instanceof PathwayRTTStatus ? (PathwayRTTStatus) ptwClockDO.getRTTStatusHistory().get(statusHistorySize - 2) : null;
				if (previousRTTStatus.getRTTStatus() != null && previousRTTStatus.getRTTStatus().getNationalCode() == PATIENT_DNA_NAT_CODE)
					return previousRTTStatus;

			}
		}
		return null;		

	}
	
	private boolean isCurrentRTTStatusDNA(PathwayClock ptwClockDO)
	{
		int nationalCode = PATIENT_DNA_NAT_CODE; 
		
		if (ptwClockDO == null || ptwClockDO.getCurrentRTTStatus() == null)
		return false;
		
		if (ptwClockDO.getCurrentRTTStatus().getRTTStatus() != null && ptwClockDO.getCurrentRTTStatus().getRTTStatus().getNationalCode() != null && nationalCode == ptwClockDO.getCurrentRTTStatus().getRTTStatus().getNationalCode().intValue())
		{
			return true;
		}
		return false;
	}
}
