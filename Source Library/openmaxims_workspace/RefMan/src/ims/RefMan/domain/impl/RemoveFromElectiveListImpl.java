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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.BookAppointment;
import ims.RefMan.domain.ReferralAppointmentDetailsComponent;
import ims.RefMan.domain.ReferralStatusList;
import ims.RefMan.domain.base.impl.BaseRemoveFromElectiveListImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.PatientElectiveList;
import ims.RefMan.domain.objects.ReferralEROD;
import ims.RefMan.domain.objects.TCIForPatientElectiveList;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.PatientElectiveListForTCIDetailsDialogVo;
import ims.RefMan.vo.PatientElectiveListVo;
import ims.RefMan.vo.domain.PatientElectiveListForTCIDetailsDialogVoAssembler;
import ims.RefMan.vo.domain.PatientElectiveListVoAssembler;
import ims.RefMan.vo.lookups.ERODStatus;
import ims.RefMan.vo.lookups.ElectiveListStatusReason;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.domain.objects.ProviderSystem;
import ims.core.domain.PatientCaseNotes;
import ims.core.domain.impl.PatientCaseNotesImpl;
import ims.core.resource.people.domain.objects.MemberOfStaff;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.PatientCaseNoteRequestLiteVoCollection;
import ims.core.vo.domain.MemberOfStaffLiteVoAssembler;
import ims.core.vo.domain.PatientCaseNoteRequestLiteVoAssembler;
import ims.core.vo.lookups.CaseNoteRequestCancellationReason;
import ims.core.vo.lookups.CaseNoteRequestStatus;
import ims.core.vo.lookups.MsgEventType;
import ims.core.vo.lookups.QueueType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;
import ims.hl7adtout.domain.objects.ElectiveListMessageQueue;
import ims.ocrr.vo.lookups.OrderMessageStatus;
import ims.pathways.configuration.domain.objects.RTTStatusPoint;
import ims.pathways.domain.HL7PathwayIf;
import ims.pathways.domain.impl.HL7PathwayIfImpl;
import ims.pathways.domain.objects.PathwayClock;
import ims.pathways.domain.objects.PathwayRTTStatus;
import ims.pathways.domain.objects.PathwaysRTTClockImpact;
import ims.pathways.domain.objects.PatientPathwayJourney;
import ims.pathways.domain.objects.PauseDetails;
import ims.pathways.domain.objects.RTTStatusEventMap;
import ims.pathways.vo.PatientEventVo;
import ims.pathways.vo.RTTStatusEventMapVo;
import ims.pathways.vo.domain.PatientJourneyVoAssembler;
import ims.pathways.vo.domain.RTTStatusEventMapVoAssembler;
import ims.pathways.vo.lookups.EventStatus;
import ims.pathways.vo.lookups.RTTClockImpactSource;
import ims.pathways.vo.lookups.RTTClockState;
import ims.scheduling.domain.SessionAdmin;
import ims.scheduling.domain.impl.SessionAdminImpl;
import ims.scheduling.vo.Booking_AppointmentRefVo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RemoveFromElectiveListImpl extends BaseRemoveFromElectiveListImpl
{
	private static final long serialVersionUID = 1L;
	
	private static final int START_OF_FIRST_DEFINITIVE_TREATMENT = 30;

	public ims.scheduling.vo.Booking_AppointmentVo getBookingAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt)
	{
		BookAppointment impl = (BookAppointment) getDomainImpl(BookAppointmentImpl.class);
		return impl.getBookingAppointment(appt);
	}

	public ims.RefMan.vo.CatsReferralListVo getCatsReferral(ims.RefMan.vo.CatsReferralRefVo voReferralRef)
	{
		ReferralStatusList impl = (ReferralStatusList) getDomainImpl(ReferralStatusListImpl.class);
		return impl.getCatsReferral(voReferralRef);		
	}

	public ims.scheduling.vo.Booking_AppointmentVo cancelAppt(ims.scheduling.vo.Booking_AppointmentVo appt, ims.chooseandbook.vo.lookups.ActionRequestType requestType, String requestSource) throws DomainInterfaceException, ims.domain.exceptions.StaleObjectException
	{
		SessionAdmin impl = (SessionAdmin) getDomainImpl(SessionAdminImpl.class);
		return impl.cancelAppt(appt, requestType, requestSource);
	}

	public void updateCatsReferralAdditionalInvStatus(CatsReferralRefVo catsReferral, Booking_AppointmentRefVo appt) throws ims.domain.exceptions.StaleObjectException
	{
		SessionAdmin impl = (SessionAdmin) getDomainImpl(SessionAdminImpl.class);
		impl.updateCatsReferralAdditionalInvStatus(catsReferral,appt);	
	}

	public void updateCatsReferralCancelStatus(ims.RefMan.vo.CatsReferralRefVo catsReferral) throws ims.domain.exceptions.StaleObjectException
	{
		ReferralAppointmentDetailsComponent impl = (ReferralAppointmentDetailsComponent) getDomainImpl(ReferralAppointmentDetailsComponentImpl.class);
		impl.updateCatsReferralCancelStatus(catsReferral);
	}

	public void cancelReferralEROD(ims.RefMan.vo.CatsReferralRefVo catsReferral, ims.scheduling.vo.Booking_AppointmentRefVo apptRef) throws ims.domain.exceptions.StaleObjectException
	{
		if(catsReferral == null || catsReferral.getID_CatsReferral() == null)
			throw new CodingRuntimeException("catsReferral is null or id not provided in method cancelReferralEROD");
		
		if(apptRef == null || apptRef.getID_Booking_Appointment() == null)
			throw new CodingRuntimeException("apptRef is null or id not provided in method getTheatreAppointment");
		
		DomainFactory factory = getDomainFactory();
		CatsReferral doCatsReferral = (CatsReferral) factory.getDomainObject(catsReferral);
		
		if(doCatsReferral.getElectiveEROD() == null)
			return;
		
		ReferralEROD doErod = null;
		
		for(int i=0; i<doCatsReferral.getElectiveEROD().size(); i++)
		{
			if(doCatsReferral.getElectiveEROD().get(i) instanceof ReferralEROD)
			{
				if(((ReferralEROD) doCatsReferral.getElectiveEROD().get(i)).getAppointment() != null && ((ReferralEROD) doCatsReferral.getElectiveEROD().get(i)).getAppointment().getId().equals(apptRef.getID_Booking_Appointment()))
				{
					doErod = (ReferralEROD) doCatsReferral.getElectiveEROD().get(i);
					doCatsReferral.getElectiveEROD().remove(doErod);
					break;
				}
			}
		}
		
		if(doErod != null)
		{
			doErod.setErodStatus(getDomLookup(ERODStatus.CANCELLED));
		
			if(doCatsReferral.getElectiveERODHistory() == null)
				doCatsReferral.setElectiveERODHistory(new java.util.ArrayList());
		
			doCatsReferral.getElectiveERODHistory().add(doErod);
		
			factory.save(doCatsReferral);
		}
	}
	
	
	// WDEV-23646 - Ensure the correct event Date Time is used when creating a new RTT Status
	private PathwayRTTStatus createPathwayRTTStatus(CatsReferral record, Date eventDateTime) throws DomainInterfaceException
	{
		if(!ConfigFlag.DOM.RTT_STATUS_POINT_FUNCTIONALITY.getValue())
			return null;
		
		if(record == null)
			return null;
		
		RTTStatusPoint rttStatusPoint = getRTTStatusPoint(START_OF_FIRST_DEFINITIVE_TREATMENT);
		
		if (rttStatusPoint == null)
			throw new DomainInterfaceException("No RTT Status Point was found for National Code: " + START_OF_FIRST_DEFINITIVE_TREATMENT);
		
		Object mos = getMosUser();
		MemberOfStaff doMos = null;
		
		if(mos instanceof MemberOfStaffLiteVo)
		{
			doMos = MemberOfStaffLiteVoAssembler.extractMemberOfStaff(getDomainFactory(), (MemberOfStaffLiteVo) mos);
		}
		
		PathwayRTTStatus pathwayRTTStatus = new PathwayRTTStatus();
		pathwayRTTStatus.setRTTStatus(rttStatusPoint);
		pathwayRTTStatus.setStatusBy(doMos);
		pathwayRTTStatus.setStatusDateTime(eventDateTime);
		
		if(record.getJourney() != null && record.getJourney().getCurrentClock() != null)
    	{
			record.getJourney().getCurrentClock().setCurrentRTTStatus(pathwayRTTStatus);
    			
    		if(record.getJourney().getCurrentClock().getRTTStatusHistory() == null)
    			record.getJourney().getCurrentClock().setRTTStatusHistory(new java.util.ArrayList());
    			
    		record.getJourney().getCurrentClock().getRTTStatusHistory().add(pathwayRTTStatus);
    		
    	}
		
		return pathwayRTTStatus;
	}
	
	private RTTStatusPoint getRTTStatusPoint(int nationalCode)
	{
		String query = "select rtt from RTTStatusPoint as rtt where rtt.nationalCode = :NationalCode";
		
		List<?> rttList = getDomainFactory().find(query, new String[] {"NationalCode"}, new Object[] {nationalCode});
		
		if(rttList != null && rttList.size() > 0 && rttList.get(0) instanceof RTTStatusPoint)
		{
			return (RTTStatusPoint) rttList.get(0);
		}
		
		return null;
	}
	
	//WDEV-19704 Create message queue trigger record(s) for each provider system for A38 HL7 message for removal of Patient Elective List
	public void triggerElectiveListEvent(PatientElectiveListVo patientElectiveList) throws StaleObjectException
	{	
		if (patientElectiveList != null)
		{
			DomainFactory factory = getDomainFactory();
			String hqlString = "select ot.providerSystem from OutboundTriggers as ot left join ot.queueType as qt left join qt.instance as i"
					+ " where(i.id = "+QueueType.ELECTIVELIST.getId()+")";

			java.util.List<ProviderSystem> list = factory.find(hqlString);
			for (ProviderSystem providerSystem : list)
			{
				ElectiveListMessageQueue messageQueue = new ElectiveListMessageQueue();
				messageQueue.setPatientElectiveList((PatientElectiveList)factory.getDomainObject(patientElectiveList));
				messageQueue.setProviderSystem(providerSystem);
				messageQueue.setWasProcessed(Boolean.FALSE);
				messageQueue.setMessageStatus(getDomLookup(OrderMessageStatus.CREATED));
				messageQueue.setMsgType(getDomLookup(MsgEventType.A38));
				messageQueue.setQueueType(getDomLookup(QueueType.ELECTIVELIST));

				//WDEV-20680
				Boolean unProcessedCancelledTCI = checkForUnprocessedCancelledTCIForPatElectList(patientElectiveList);
				if(unProcessedCancelledTCI)
				{
					factory.save(messageQueue);
				} //WDEV-20680
			}
		}
	}

	
	//WDEV-20680
	private Boolean checkForUnprocessedCancelledTCIForPatElectList(PatientElectiveListVo patientElectiveList)
	{
		DomainFactory factory = getDomainFactory();
		
		PatientElectiveList patReferral = (PatientElectiveList) factory.getDomainObject(patientElectiveList);

		// Following check probably not needed..
		if(patReferral.getTCIDetails() != null
				&& patReferral.getTCIDetails().getTCIDate() != null)
		{
			// An active TCI exists for the referral
			return false;
		}
		
		// Check to see if a cancelled TCI exists for the referral
		java.util.List<TCIForPatientElectiveList> histPatElectListTCI = patReferral.getTCIHistory();
		
		if(histPatElectListTCI == null)
			return false;
		
		// Loop thru historic TCI(s) and check for unprocessed row
		for (TCIForPatientElectiveList tciDetail : histPatElectListTCI)
		{
			if (tciDetail.isCancelMsgProcessed() == null
					|| tciDetail.isCancelMsgProcessed()  == Boolean.FALSE)
			{
				return true;
			}
		}			
		return false;
	} //WDEV-20680
	
	
	

	public ims.RefMan.vo.PatientElectiveListForTCIDetailsDialogVo getPatientElectiveList(ims.RefMan.vo.PatientElectiveListRefVo record)
	{
		if( record == null )
			throw new CodingRuntimeException("PatientElectiveListRefVo cannot be null");
		
		PatientElectiveList doPatientElectiveList = (PatientElectiveList) getDomainFactory().getDomainObject(PatientElectiveList.class, record.getID_PatientElectiveList());
		return PatientElectiveListForTCIDetailsDialogVoAssembler.create(doPatientElectiveList);
	}

	public void cancelCaseNoteRequests(Integer tciId) throws StaleObjectException
	{
		PatientCaseNoteRequestLiteVoCollection requestsForCancellation = getLinkedCaseNoteOpenRequests(tciId);
		
		if (requestsForCancellation == null || requestsForCancellation.size() == 0)
			return;
		
		Object mos = getMosUser();
		
		PatientCaseNotes impl = (PatientCaseNotes) getDomainImpl(PatientCaseNotesImpl.class);
		
		for (int i = 0; i < requestsForCancellation.size(); i++)
		{
			impl.cancelRequest(requestsForCancellation.get(i), (MemberOfStaffRefVo) mos, CaseNoteRequestCancellationReason.TCI_CANCELLED);
		}
		
	}
	
	private PatientCaseNoteRequestLiteVoCollection getLinkedCaseNoteOpenRequests(Integer tciId)
	{
		if(tciId == null)
			   return null;
		
		List<?> list = getDomainFactory().find("select req from PatientCaseNoteRequest as req left join req.tCIDetail as tci left join req.requestStatus as status " +
				"where (tci.id = :tciID and status.id = :requestStatusID)", new String[] {"tciID", "requestStatusID"}, new Object[] {tciId, CaseNoteRequestStatus.OPEN.getID()});
		
		return PatientCaseNoteRequestLiteVoAssembler.createPatientCaseNoteRequestLiteVoCollectionFromPatientCaseNoteRequest(list);
	}

	public PatientElectiveListForTCIDetailsDialogVo save(PatientElectiveListForTCIDetailsDialogVo record, Boolean isPatientTreatedAsEmergency) throws DomainInterfaceException, StaleObjectException, UniqueKeyViolationException
	{
		DomainFactory factory = getDomainFactory();
		PatientElectiveList doPatientElectiveList = PatientElectiveListForTCIDetailsDialogVoAssembler.extractPatientElectiveList(factory, record);
		
		if(record != null && record.getElectiveListStatus() != null && ElectiveListStatusReason.PATIENT_REMOVED_FOR_OTHER_REASONS.equals(record.getElectiveListStatus().getRemovalReason()))
		{
			ReferralEROD doEROD = (ReferralEROD)doPatientElectiveList.getEROD();
			
			if(doEROD != null)
			{
    			doEROD.setErodStatus(getDomLookup(ERODStatus.CANCELLED));
    			doEROD.setIsActive(Boolean.FALSE);
    
    			if(doPatientElectiveList.getERODHistory() == null)
    				doPatientElectiveList.setERODHistory(new java.util.ArrayList());
    			doPatientElectiveList.getERODHistory().add(doEROD);
    			
    			doPatientElectiveList.setEROD(null);
    			
    			ReferralEROD doMoveErod = null;
        		for(int i=0; i < doPatientElectiveList.getReferral().getElectiveEROD().size(); i++)
        		{
        			if(doPatientElectiveList.getReferral().getElectiveEROD().get(i) instanceof ReferralEROD)
        			{
        				if(doPatientElectiveList.getPathwayClock()!=null
        					&& ((ReferralEROD) doPatientElectiveList.getReferral().getElectiveEROD().get(i)).getPathWayClock() != null 
        					&& ((ReferralEROD) doPatientElectiveList.getReferral().getElectiveEROD().get(i)).getPathWayClock().getId().equals(doPatientElectiveList.getPathwayClock().getId()))
        				{
        					doMoveErod = (ReferralEROD) doPatientElectiveList.getReferral().getElectiveEROD().get(i);
        					doPatientElectiveList.getReferral().getElectiveEROD().remove(i);
        					break;
        				}
        			}
        		}
        		    		
        		if(doMoveErod != null)
        		{
        			doMoveErod.setErodStatus(getDomLookup(ERODStatus.CANCELLED));
        		
        			if(doPatientElectiveList.getReferral().getElectiveERODHistory() == null)
        				doPatientElectiveList.getReferral().setElectiveERODHistory(new java.util.ArrayList());
        		
        			doPatientElectiveList.getReferral().getElectiveERODHistory().add(doMoveErod);
        		}
    
    			if(doPatientElectiveList.getReferral().getJourney() != null 
    					&& doPatientElectiveList.getReferral().getJourney().getCurrentClock() != null
    					&& doEROD.getPathWayClock() != null
    					&& doPatientElectiveList.getReferral().getJourney().getCurrentClock().getId().equals(doEROD.getPathWayClock().getId())
    					&& doPatientElectiveList.getReferral().getJourney().getCurrentClock().getCurrentPause() != null)
    			{
    				PauseDetails currentPause = doPatientElectiveList.getReferral().getJourney().getCurrentClock().getCurrentPause();
    				
    				if(doPatientElectiveList.getReferral().getJourney().getCurrentClock().getPauseDetails() != null)
    				{
    					for(int i=0; i<doPatientElectiveList.getReferral().getJourney().getCurrentClock().getPauseDetails().size(); i++)
    					{
    						PauseDetails pause = (PauseDetails) doPatientElectiveList.getReferral().getJourney().getCurrentClock().getPauseDetails().get(i);
    						if(pause != null && Boolean.TRUE.equals(pause.isActive()) && pause.getPauseStart().equals(doEROD.getERODDate1()))
    						{
    							pause.setActive(false);
    							break;
    						}
    					}
    				}
    				
    				if(currentPause != null && Boolean.TRUE.equals(currentPause.isActive()) && currentPause.getPauseStart().equals(doEROD.getERODDate1()))
    				{
    					doPatientElectiveList.getReferral().getJourney().getCurrentClock().setCurrentPause(null);
    				}
    			}
			}
		}
		
		//WDEV-19704 Trigger Hl7 message
		if(doPatientElectiveList != null)
		{
			PatientElectiveListVo patientElectiveList = PatientElectiveListVoAssembler.create(doPatientElectiveList);
			triggerElectiveListEvent(patientElectiveList);
		}

		if( doPatientElectiveList != null)
			factory.save(doPatientElectiveList);
		
		if(Boolean.TRUE.equals(isPatientTreatedAsEmergency))
		{
			CatsReferral catsReferral = (CatsReferral) factory.getDomainObject(CatsReferral.class, record.getReferral().getID_CatsReferral());
			
    		PathwayRTTStatus initialStatus = null;
			PathwayClock initialClock = null;
			RTTClockState initialClockState = null;
			PathwayClock finalClock = null;
			PathwayRTTStatus finalStatus = null;
			boolean shouldReferralBeSaved = false;
			
    		if(ConfigFlag.DOM.RTT_STATUS_POINT_FUNCTIONALITY.getValue() && Boolean.TRUE.equals(catsReferral.isRTTClockImpact()))
    		{
    			initialClock = catsReferral.getJourney() != null ? catsReferral.getJourney().getCurrentClock() : null;
    			initialClockState = getClockState(initialClock);
    			initialStatus = catsReferral.getJourney() != null && catsReferral.getJourney().getCurrentClock() != null ? catsReferral.getJourney().getCurrentClock().getCurrentRTTStatus() : null;
    			
    			// WDEV-23646 - Ensure the correct event Date Time is used when creating a new RTT Status
    			// When a patient is explicitly removed from Patient Elective list use user entered date time
    			Date eventDateTime = record.getElectiveListStatus().getStatusDateTime().getJavaDate();
				finalStatus = createPathwayRTTStatus(catsReferral, eventDateTime);
    			catsReferral.setCurrentRTTStatus(finalStatus);
    			
    			shouldReferralBeSaved = true;
    		}
    		
    		if(catsReferral.getJourney() != null && catsReferral.getJourney().getCurrentClock() != null)
    		{
    			finalClock = catsReferral.getJourney().getCurrentClock();
    			
    			if (finalClock.getStartDate() != null && finalClock.getStopDate() == null)
    			{
    				finalClock.setStopDate(record.getElectiveListStatus().getStatusDateTime().getJavaDate());
    				finalClock.setCurrentRTTStatus(finalStatus);
    				
    				if(finalClock.getRTTStatusHistory() == null)
    				{
    					finalClock.setRTTStatusHistory(new ArrayList());
    				}
    				
    				finalClock.getRTTStatusHistory().add(finalStatus);
    				
    				shouldReferralBeSaved = true;
    			}
    		}
    		
    		
    		if(shouldReferralBeSaved)
    		{
				RTTClockState finalClockState = getClockState(finalClock);
				PathwaysRTTClockImpact clockImpact = createRTTClockImpactRecord(initialClock, initialClockState, finalClock, finalClockState, initialStatus, finalStatus, null, catsReferral.getJourney(), RTTClockImpactSource.PATIENT_TREATED_AS_EMERGENCY);
    			
    			if (catsReferral.getRTTClockImpacts() == null) catsReferral.setRTTClockImpacts(new ArrayList());
    			catsReferral.getRTTClockImpacts().add(clockImpact);
    			
    			factory.save(catsReferral);
    		}
    		
    		if(ConfigFlag.DOM.RTT_STATUS_POINT_FUNCTIONALITY.getValue() && finalStatus != null && Boolean.TRUE.equals(catsReferral.isRTTClockImpact()))
    		{
    			createPatientEvent(record, catsReferral, finalStatus, record.getElectiveListStatus().getStatusDateTime());
    		}
		}
		
		return PatientElectiveListForTCIDetailsDialogVoAssembler.create(doPatientElectiveList);
	}
	
	private void createPatientEvent(PatientElectiveListForTCIDetailsDialogVo record, CatsReferral domCatsReferral, PathwayRTTStatus rttStatus, DateTime eventDateTime) throws DomainInterfaceException, StaleObjectException
	{
		RTTStatusEventMapVo rttMap = getRTTStatusEventMap(rttStatus.getRTTStatus());
		
		if(rttMap != null && rttMap.getEvent() != null)
		{
			PatientEventVo patEvent = new PatientEventVo();
			patEvent.setPatient(record.getPatient());
			patEvent.setEvent(rttMap.getEvent());
			patEvent.setEventDateTime(eventDateTime);
			patEvent.setEventStatus(EventStatus.ACTIVE);
			patEvent.setJourney(PatientJourneyVoAssembler.create(domCatsReferral.getJourney()));
			
			HL7PathwayIf impl = (HL7PathwayIf) getDomainImpl(HL7PathwayIfImpl.class);
			impl.instantiatePatientEvent(patEvent);
		}
	}
	
	private RTTStatusEventMapVo getRTTStatusEventMap(RTTStatusPoint rttStatusPoint)
	{
		if(rttStatusPoint == null)
			return null;
		
		String query = "select rttMap from RTTStatusEventMap as rttMap left join rttMap.currentRTTStatus as rtt where rtt.id = :RTTStatusPoint and rttMap.event is not null and rttMap.active = 1 and rttMap.encounterType is null";
		List<?> listRTTMap = getDomainFactory().find(query, new String[] {"RTTStatusPoint"}, new Object[] {rttStatusPoint.getId()});
		
		if(listRTTMap != null && listRTTMap.size() > 0 && listRTTMap.get(0) instanceof RTTStatusEventMap)
		{
			return RTTStatusEventMapVoAssembler.create((RTTStatusEventMap) listRTTMap.get(0));
		}
		
		return null;
	}
	
	
	
	private PathwaysRTTClockImpact createRTTClockImpactRecord(PathwayClock initialClock, RTTClockState initialClockState, PathwayClock finalClock, RTTClockState finalClockState, PathwayRTTStatus initialStatus, PathwayRTTStatus finalStatus,
			RTTStatusEventMap eventMap, PatientPathwayJourney journey, RTTClockImpactSource source)
	{
		PathwaysRTTClockImpact clockImpact = new PathwaysRTTClockImpact();

		clockImpact.setInitialClock(initialClock);
		clockImpact.setFinalClock(finalClock);
		clockImpact.setInitialRTTStatus(initialStatus);
		clockImpact.setFinalRTTStatus(finalStatus);

		clockImpact.setOutcomeEvent(eventMap);
		clockImpact.setJourney(journey);
		clockImpact.setSource(getDomLookup(source));

		clockImpact.setInitialClockState(getDomLookup(initialClockState));
		clockImpact.setFinalClockState(getDomLookup(finalClockState));


		clockImpact.setClockStarted(Boolean.FALSE);
		clockImpact.setClockStopped(Boolean.FALSE);

		//  Case 1 - If there was not clock initially and one clock was created
		if (initialClock == null && finalClock != null)
		{
			// New clock has a start date - mark the Clock Impact
			if (finalClock.getStartDate() != null)
				clockImpact.setClockStarted(Boolean.TRUE);

			if (finalClock.getStopDate() != null)
				clockImpact.setClockStopped(Boolean.TRUE);
		}

		// Case 2 - If there was a clock initially and there is no clock now
		if (initialClock != null && finalClock == null)
		{
			clockImpact.setClockStopped(Boolean.TRUE);
		}

		// Case 3 - If there was an initial clock and a clock is present now
		if (initialClock != null && finalClock != null)
		{
			// Case 3.1 - Initial and current clock are the same one
			if (initialClock.getId() == finalClock.getId())
			{
				if (initialClock.getStopDate() == null && finalClock.getStopDate() != null)
					clockImpact.setClockStopped(Boolean.TRUE);

				if (initialClock.getStopDate() != null && finalClock.getStopDate() == null)
					clockImpact.setClockStarted(Boolean.TRUE);

				if (initialClock.getStartDate() == null && finalClock.getStartDate() != null)
					clockImpact.setClockStarted(Boolean.TRUE);
			}

			// Case 3.2 - Initial and current clock are not ehe same one
			if (initialClock.getId() != finalClock.getId())
			{
				if (initialClock.getStopDate() == null)
					clockImpact.setClockStopped(Boolean.TRUE);

				if (finalClock.getStartDate() != null)
					clockImpact.setClockStarted(Boolean.TRUE);

				if (finalClock.getStopDate() != null)
					clockImpact.setClockStopped(Boolean.TRUE);
			}

		}

		return clockImpact;
	}
	

	private RTTClockState getClockState(PathwayClock clock)
	{
		if (clock == null)
			return RTTClockState.NOT_PRESENT;
		
		if (clock.getStopDate() != null)
			return RTTClockState.STOPPED;

		return RTTClockState.STARTED;
	}
}
