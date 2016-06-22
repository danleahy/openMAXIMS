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
// This code was generated by John Pearson using IMS Development Environment (version 1.45 build 2377.27529)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;


import ims.admin.domain.ConfigFlags;
import ims.admin.domain.ProviderSystemAdmin;
import ims.admin.domain.base.impl.BaseHl7AdminImpl;
import ims.admin.vo.DemographicFeedVoCollection;
import ims.admin.vo.HL7AdminVo;
import ims.admin.vo.HL7MessageInfoVo;
import ims.admin.vo.HL7MessageInfoVoCollection;
import ims.admin.vo.QryOrderMsgVoCollection;
import ims.admin.vo.domain.DemographicFeedVoAssembler;
import ims.admin.vo.domain.QryOrderMsgVoAssembler;
import ims.configuration.gen.ConfigFlag;
import ims.configuration.IFlag;
import ims.core.admin.vo.ProviderSystemRefVo;
import ims.core.patient.domain.objects.Patient;
import ims.core.vo.PatientId;
import ims.core.vo.lookups.MsgEventType;
import ims.core.vo.lookups.PatIdType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.factory.ConfigFlagsFactory;
import ims.framework.enumerations.SystemLogLevel;
import ims.framework.enumerations.SystemLogType;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;
import ims.hl7.HL7ControllerFactory;
import ims.hl7.interfaces.IHL7Controller;
import ims.ocrr.vo.ProviderSystemLiteVoCollection;
import ims.ocs_if.vo.OutboundTriggersVo;
import ims.ocs_if.vo.OutboundTriggersVoCollection;
import ims.ocs_if.vo.domain.OutboundTriggersVoAssembler;

import java.util.ArrayList;
import java.util.List;
public class Hl7AdminImpl extends BaseHl7AdminImpl
{

	private static final long serialVersionUID = 1L;
	
	
	/*
	 * PUBLIC INTERFACE METHODS
	 */
	public HL7AdminVo getInboundInfo() throws ims.domain.exceptions.DomainInterfaceException 
	{
		HL7AdminVo retVo = new HL7AdminVo();
		
		try
		{
			IHL7Controller controller = HL7ControllerFactory.getController();	
			retVo.setCfgStartInterface(new Boolean(controller.isInboundEnabled()));
			retVo.setIsRunning(new Boolean(controller.isInboundRunning()));
			
			if (controller.getInbound() != null && controller.getInbound().getStartTime() != null)
			{
				retVo.setStarted(controller.getInbound().getStartTime().toString());
				retVo.setMessages(new HL7MessageInfoVoCollection());
				for (int i = 0; i < controller.getInbound().getEventCodesHandled().length; i++ )				
				{		
					HL7MessageInfoVo infoVo = new HL7MessageInfoVo();
					String messType = "";
					
					messType = controller.getInbound().getEventCodesHandled()[i];						
					infoVo.setMessageType(messType);
					infoVo.setTotal(new Integer(controller.getInbound().getProcessedCount(messType)));
					infoVo.setFailed(new Integer(controller.getInbound().getErrorCount(messType)));
					infoVo.setSuccessful(new Integer(controller.getInbound().getSuccessfulCount(messType)));
					infoVo.setLastFailedDateTime(controller.getInbound().getLastFailedDateTime(messType));
					infoVo.setLastSuccessDateTime(controller.getInbound().getLastSuccesfulDateTime(messType));
					infoVo.setLastFailedMessage(controller.getInbound().getLastFailedMessage(messType));
					infoVo.setLastSuccessMessage(controller.getInbound().getLastSuccesfulMessage(messType));
					
					retVo.getMessages().add(infoVo);
				}				
			}			
		}
		catch (Exception e)
		{
			throw new DomainInterfaceException("Exception  " + e.getMessage() + " occurred getting inbound interface information");		
		}
		
		return retVo;
	}

	public HL7AdminVo getOutboundInfo() throws ims.domain.exceptions.DomainInterfaceException 
	{
		HL7AdminVo retVo = new HL7AdminVo();	
		try
		{
			IHL7Controller controller = HL7ControllerFactory.getController();
			retVo.setCfgStartInterface(new Boolean(controller.isOutboundEnabled()));
			retVo.setIsRunning(new Boolean(controller.isOutboundRunning()));
			
			if (controller.getOutbound() != null && controller.getOutbound().getStartTime() != null)
			{
				retVo.setStarted(controller.getOutbound().getStartTime().toString());
				retVo.setMessages(new HL7MessageInfoVoCollection());
				retVo.setIpAddress(controller.getOutbound().getIpAddress());
				for (int i = 0; i < controller.getOutbound().getEventCodesHandled().length; i++ )				
				{		
					HL7MessageInfoVo infoVo = new HL7MessageInfoVo();
					String messType = "";
					
					messType = controller.getOutbound().getEventCodesHandled()[i];						
					infoVo.setMessageType(messType);
					infoVo.setTotal(new Integer(controller.getOutbound().getProcessedCount(messType)));
					infoVo.setFailed(new Integer(controller.getOutbound().getErrorCount(messType)));
					infoVo.setSuccessful(new Integer(controller.getOutbound().getSuccessfulCount(messType)));
					infoVo.setLastFailedDateTime(controller.getOutbound().getLastFailedDateTime(messType));
					infoVo.setLastSuccessDateTime(controller.getOutbound().getLastSuccesfulDateTime(messType));
					infoVo.setLastFailedMessage(controller.getOutbound().getLastFailedMessage(messType));
					infoVo.setLastSuccessMessage(controller.getOutbound().getLastSuccesfulMessage(messType));
					
					retVo.getMessages().add(infoVo);
				}				
			}			
		}
		catch (Exception e)
		{
			throw new DomainInterfaceException("Exception  " + e.getMessage() + " getting outbound interface information");		
		}
		return retVo;		
	}
	
	public void startInbound() throws ims.domain.exceptions.DomainInterfaceException
	{
		IHL7Controller controller = HL7ControllerFactory.getController();
		try
		{			
			controller.startInbound();			
		}
		catch(Exception e)
		{
			throw new DomainInterfaceException("Exception  " + e.getMessage() + " occurred starting inbound interface");
		}
	}

	public void stopInbound() throws ims.domain.exceptions.DomainInterfaceException
	{
		IHL7Controller controller = HL7ControllerFactory.getController();
		try
		{
			controller.stopInbound();			
		}
		catch(Exception e)
		{
			throw new DomainInterfaceException("Exception  " + e.getMessage() + " occurred stopping inbound interface");
		}		
	}

	public void startOutbound() throws ims.domain.exceptions.DomainInterfaceException
	{
		IHL7Controller controller = HL7ControllerFactory.getController();
		try
		{			
			controller.startOutbound();			
		}
		catch(Exception e)
		{
			throw new DomainInterfaceException("Exception  " + e.getMessage() + " occurred starting outbound interface");
		}
	}

	public void stopOutbound() throws ims.domain.exceptions.DomainInterfaceException
	{
		IHL7Controller controller = HL7ControllerFactory.getController();
		try
		{			
			controller.stopOutbound();			
		}
		catch(Exception e)
		{
			throw new DomainInterfaceException("Exception  " + e.getMessage() + " occurred stopping outbound interface");
		}
	}
		 
	public QryOrderMsgVoCollection listOrdersByDateTimeRange(PatientId patIdVo, DateTime dtFrom, DateTime dtTo)	
	{		
		Patient domPatient = null;
		if (patIdVo != null)
		{
			domPatient = findPatientById(patIdVo);
			if (null==domPatient)
				return null;
		}
		 
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();				
		StringBuffer sb = new StringBuffer("select om from OrderMessage om, OcsOrderSession ord, "
								+ "OrderInvestigation oi where om.orderDetails.id = ord.id "
								+ "and oi.orderDetails = ord.id ");		
				 
		if (domPatient != null)
		{
			sb.append(" and ord.patient = :domPatient");
			markers.add("domPatient");
			values.add(domPatient);		
		}		
		
		if (dtFrom != null && dtTo != null && dtFrom.isLessOrEqualThan(dtTo))
		{
			sb.append(" and ( (ord.systemInformation.creationDateTime >= :fromDate and ord.systemInformation.creationDateTime <= :toDate)");
			sb.append(" or (om.systemInformation.lastUpdateDateTime >= :fromDate and om.systemInformation.lastUpdateDateTime <= :toDate))"); 
			
			markers.add("fromDate");
			values.add(dtFrom.getJavaDate());
			
			markers.add("toDate");
			values.add(dtTo.addDays(1).getJavaDate());											
		}

		sb.append(" order by ord.systemInformation.creationDateTime desc");
		
		List messages = getDomainFactory().find(sb.toString(), markers, values);
		return QryOrderMsgVoAssembler.createQryOrderMsgVoCollectionFromOrderMessage(messages);					
	}
	
	public void setInboundFlag(Boolean bStart) throws  DomainInterfaceException
	{		
		IHL7Controller controller = HL7ControllerFactory.getController();
		if (bStart.booleanValue())	
			controller.enableInbound();
		else
			controller.disableInbound();
	//saveConfigFlag( ConfigFlag.HL7.HL7_START_LISTENER, bStart.toString());
		
		//WDEV-8242 
		try {
			saveConfigFlag2( ConfigFlag.HL7.HL7_START_LISTENER.getName(), bStart.toString(), bStart.toString(), false);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DomainRuntimeException(e);			
		}			
	}

	public void setOutboundFlag(Boolean bStart) throws DomainInterfaceException
	{
		IHL7Controller controller = HL7ControllerFactory.getController();
		if (bStart.booleanValue())	
			controller.enableOutbound();
		else
			controller.disableOutbound();		
	
		//WDEV-8242 
		try {
			saveConfigFlag2( ConfigFlag.HL7.HL7_START_OUTBOUND.getName(), bStart.toString(), bStart.toString(), false);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DomainRuntimeException(e);
		}			
	}
	
	
	public void clearOutboundRegistration()
	{
		DomainFactory factory = this.getDomainFactory();		
		try
		{
			factory.delete("from Hl7OutboundRegister");
		}
		catch (ForeignKeyViolationException e)
		{
			throw new DomainRuntimeException(e);
		}
		
	}

	public String getIpAddress() throws DomainInterfaceException
	{
		
		DomainFactory factory = this.getDomainFactory();		
		
		List lst = factory.find("select ob.ipAddress from Hl7OutboundRegister ob");
		if (lst.size() > 0)
			return (String)lst.get(0);//Hl7OutboundRegVoAssembler.create((Hl7OutboundRegister)lst.get(0)).getIpAddress();
		else
			return "";
		
	}	
	
	/*
	 * PRIVATE METHODS
	 */
		
	private Patient findPatientById(PatientId PatIdVo)
	{		
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer(" from Patient p " +
				" join p.identifiers as ids" +
				" where ids.type = :idType " +
				" and p.isActive = true ");
		
		String idVal = PatIdVo.getValue().trim();			
		if(!ConfigFlag.DOM.CASE_SENSITIVE_PATID.getValue())
		{
			idVal = idVal.toUpperCase();
		}

		if (PatIdVo.getType().equals(PatIdType.NHSN))
		{
			idVal = idVal.replace(" ", "");
			hql.append(" and ids.value like :idValue ");
			idVal += "%";
		}
		else
			hql.append(" and ids.value = :idValue");

		java.util.List patients = factory.find(hql.toString(), new String[]{"idValue", "idType"}, new Object[]{idVal, getDomLookup(PatIdVo.getType())});
		if (patients != null)
		{			
			//if only one returned check it is not a merged patient
			if(patients.size() == 1)
			{
				//recurse to get master patient if this patient was merged
				Patient domPatient = (Patient) patients.get(0);
				boolean isMergedPatient = false;
				while(domPatient.getAssociatedPatient() != null)
				{
					domPatient = domPatient.getAssociatedPatient();
					isMergedPatient = true;
				}
					
				if(isMergedPatient)
				{
					raiseAlert(domPatient.getMergedMessage((ims.core.patient.domain.objects.Patient)patients.get(0)));
					patients.set(0, domPatient);
				}
				return domPatient;
			}
			else if (patients.size() > 1)
				throw new DomainRuntimeException("More than 1 patient found for ID Type = " + PatIdVo.getType().getText() + ", and Value = " + PatIdVo.getValue());
		}
		return null;		
	}

	public DemographicFeedVoCollection getOBFeedEntries(DateTime startDate, DateTime endDate, PatientId patId,  MsgEventType msgType, ProviderSystemRefVo providerSystem)
	{
		DomainFactory factory = getDomainFactory();
		String hql = " from DemographicsMessageQueue queue";
		boolean whereClause = false;
		ArrayList<String> markers = new ArrayList();
		ArrayList values = new ArrayList();
		
		if(startDate != null && endDate != null)
		{
			if(!whereClause)
			{
				whereClause = true;
				hql += " where ";
			}
			else
			{
				hql += " and ";
			}
			
			hql += " queue.systemInformation.creationDateTime between :startDateTimeValue and :endDateTimeValue";
			markers.add("startDateTimeValue");
			values.add(startDate.getJavaDate());
			markers.add("endDateTimeValue");
			values.add(endDate.getJavaDate());
		}	
		
		Patient domPatient = null;
		if (patId != null&&patId.getValueIsNotNull()&&patId.getTypeIsNotNull())
		{
			domPatient = findPatientById(patId);
		if(!whereClause)
		{
			whereClause = true;
			hql += " where ";
		}
		else
		{
			hql += " and ";
		}
		hql+=(" queue.patient = :domPatient");
		markers.add("domPatient");
		values.add(domPatient);		
		}		
		if (msgType!=null)
		{
			if(!whereClause)
			{
				whereClause = true;
				hql += " where ";
			}
			else
			{
				hql += " and ";
			}
			
			hql+=" queue.msgType.id=:msgType";
			markers.add("msgType");
			values.add(msgType.getID());
			
		}
		
		if(providerSystem!=null)
		{
			if(!whereClause)
			{
				whereClause = true;
				hql += " where ";
			}
			else
			{
				hql += " and ";
			}
			hql+="queue.providerSystem.id=:providerSystem";
			markers.add("providerSystem");
			values.add(providerSystem.getID_ProviderSystem());
		}
		
		hql+=(" order by queue.systemInformation.creationDateTime desc");
		
		
		try {
			List entries = factory.find(hql, markers, values, 1000);
			return DemographicFeedVoAssembler.createDemographicFeedVoCollectionFromDemographicsMessageQueue(entries);
		} catch (DomainRuntimeException dre)
		{
			this.createSystemLogEntry(SystemLogType.APPLICATION, SystemLogLevel.INFORMATION, "DomainRuntimeException getting Demographic Feed details"+dre.getMessage());
			
			return null;
		}
	}

	public ProviderSystemLiteVoCollection listProviderSystems()
	{
		ProviderSystemAdmin providers = (ProviderSystemAdmin)getDomainImpl(ProviderSystemAdminImpl.class);
		return providers.listProviderSystemLites();
		
	}

	public String saveConfigFlag(IFlag flag, String flagValue) throws DomainInterfaceException
	{
		ConfigFlags flags = (ConfigFlags)getDomainImpl(ConfigFlagsImpl.class);
		return flags.saveConfigFlag(flag, flagValue);
	}
	//WDEV-8242 
	public void saveConfigFlag2(String key, String value, String defaultValue, boolean isSystem) throws Exception
	{				
		ConfigFlagsFactory ob=new ConfigFlagsFactory();
		ob.getProvider().setValue(key, value, defaultValue, isSystem);				
	}

	public void deleteOutBoundTriggers(OutboundTriggersVo outBoundTriggers) throws ForeignKeyViolationException
	{
		if(outBoundTriggers==null||outBoundTriggers.getID_OutboundTriggers()==null)
			throw new CodingRuntimeException("outBoundTriggers is null or id not provided in method deleteOutBoundTriggers");
		getDomainFactory().delete(getDomainFactory().getDomainObject(outBoundTriggers));	
	}

	public OutboundTriggersVoCollection listOutboundTriggers()
	{
		List items = getDomainFactory().find("from OutboundTriggers");
		return OutboundTriggersVoAssembler.createOutboundTriggersVoCollectionFromOutboundTriggers(items);
		
	}

	public void saveOutBoundTriggers(OutboundTriggersVo outboundTriggers) throws StaleObjectException
	{
		if(outboundTriggers==null)
			throw new CodingRuntimeException("outboundTriggers is null in method saveOutBoundTriggers");
		if(!outboundTriggers.isValidated())
			throw new CodingRuntimeException("outboundTriggers has not been validated in method saveOutBoundTriggers");
		getDomainFactory().save(OutboundTriggersVoAssembler.extractOutboundTriggers(getDomainFactory(), outboundTriggers));
	}

}
