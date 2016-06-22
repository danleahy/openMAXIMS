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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.AppointmentOutcomeAction business object (ID: 1090100020).
 */
public class AppointmentOutcomeActionVo extends ims.scheduling.vo.AppointmentOutcomeActionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AppointmentOutcomeActionVo()
	{
	}
	public AppointmentOutcomeActionVo(Integer id, int version)
	{
		super(id, version);
	}
	public AppointmentOutcomeActionVo(ims.scheduling.vo.beans.AppointmentOutcomeActionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.appointmentaction = bean.getAppointmentAction() == null ? null : ims.scheduling.vo.lookups.AppointmentAction.buildLookup(bean.getAppointmentAction());
		this.remove = bean.getRemove();
		this.waitinglistaction = bean.getWaitingListAction() == null ? null : bean.getWaitingListAction().buildVo();
		this.plannedlistaction = bean.getPlannedListAction() == null ? null : bean.getPlannedListAction().buildVo();
		this.futureappointment = bean.getFutureAppointment() == null ? null : bean.getFutureAppointment().buildVo();
		this.interprovidertransfer = bean.getInterProviderTransfer() == null ? null : bean.getInterProviderTransfer().buildVo();
		this.requestsforservice = ims.RefMan.vo.LinkedCatsReferralForOutcomeVoCollection.buildFromBeanCollection(bean.getRequestsForService());
		this.transferofcare = bean.getTransferOfCare() == null ? null : bean.getTransferOfCare().buildVo();
		this.outcomeofaction = bean.getOutcomeOfAction() == null ? null : ims.scheduling.vo.lookups.OutcomeAction.buildLookup(bean.getOutcomeOfAction());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.AppointmentOutcomeActionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.appointmentaction = bean.getAppointmentAction() == null ? null : ims.scheduling.vo.lookups.AppointmentAction.buildLookup(bean.getAppointmentAction());
		this.remove = bean.getRemove();
		this.waitinglistaction = bean.getWaitingListAction() == null ? null : bean.getWaitingListAction().buildVo(map);
		this.plannedlistaction = bean.getPlannedListAction() == null ? null : bean.getPlannedListAction().buildVo(map);
		this.futureappointment = bean.getFutureAppointment() == null ? null : bean.getFutureAppointment().buildVo(map);
		this.interprovidertransfer = bean.getInterProviderTransfer() == null ? null : bean.getInterProviderTransfer().buildVo(map);
		this.requestsforservice = ims.RefMan.vo.LinkedCatsReferralForOutcomeVoCollection.buildFromBeanCollection(bean.getRequestsForService());
		this.transferofcare = bean.getTransferOfCare() == null ? null : bean.getTransferOfCare().buildVo(map);
		this.outcomeofaction = bean.getOutcomeOfAction() == null ? null : ims.scheduling.vo.lookups.OutcomeAction.buildLookup(bean.getOutcomeOfAction());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.AppointmentOutcomeActionVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.AppointmentOutcomeActionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.AppointmentOutcomeActionVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("APPOINTMENTACTION"))
			return getAppointmentAction();
		if(fieldName.equals("REMOVE"))
			return getRemove();
		if(fieldName.equals("WAITINGLISTACTION"))
			return getWaitingListAction();
		if(fieldName.equals("PLANNEDLISTACTION"))
			return getPlannedListAction();
		if(fieldName.equals("FUTUREAPPOINTMENT"))
			return getFutureAppointment();
		if(fieldName.equals("INTERPROVIDERTRANSFER"))
			return getInterProviderTransfer();
		if(fieldName.equals("REQUESTSFORSERVICE"))
			return getRequestsForService();
		if(fieldName.equals("TRANSFEROFCARE"))
			return getTransferOfCare();
		if(fieldName.equals("OUTCOMEOFACTION"))
			return getOutcomeOfAction();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAppointmentActionIsNotNull()
	{
		return this.appointmentaction != null;
	}
	public ims.scheduling.vo.lookups.AppointmentAction getAppointmentAction()
	{
		return this.appointmentaction;
	}
	public void setAppointmentAction(ims.scheduling.vo.lookups.AppointmentAction value)
	{
		this.isValidated = false;
		this.appointmentaction = value;
	}
	public boolean getRemoveIsNotNull()
	{
		return this.remove != null;
	}
	public Boolean getRemove()
	{
		return this.remove;
	}
	public void setRemove(Boolean value)
	{
		this.isValidated = false;
		this.remove = value;
	}
	public boolean getWaitingListActionIsNotNull()
	{
		return this.waitinglistaction != null;
	}
	public ims.RefMan.vo.PatientElectiveListAddLaterVo getWaitingListAction()
	{
		return this.waitinglistaction;
	}
	public void setWaitingListAction(ims.RefMan.vo.PatientElectiveListAddLaterVo value)
	{
		this.isValidated = false;
		this.waitinglistaction = value;
	}
	public boolean getPlannedListActionIsNotNull()
	{
		return this.plannedlistaction != null;
	}
	public ims.RefMan.vo.PatientElectiveListAddLaterVo getPlannedListAction()
	{
		return this.plannedlistaction;
	}
	public void setPlannedListAction(ims.RefMan.vo.PatientElectiveListAddLaterVo value)
	{
		this.isValidated = false;
		this.plannedlistaction = value;
	}
	public boolean getFutureAppointmentIsNotNull()
	{
		return this.futureappointment != null;
	}
	public ims.scheduling.vo.FutureAppointmentDetailsVo getFutureAppointment()
	{
		return this.futureappointment;
	}
	public void setFutureAppointment(ims.scheduling.vo.FutureAppointmentDetailsVo value)
	{
		this.isValidated = false;
		this.futureappointment = value;
	}
	public boolean getInterProviderTransferIsNotNull()
	{
		return this.interprovidertransfer != null;
	}
	public ims.RefMan.vo.InterProviderTransferOutVo getInterProviderTransfer()
	{
		return this.interprovidertransfer;
	}
	public void setInterProviderTransfer(ims.RefMan.vo.InterProviderTransferOutVo value)
	{
		this.isValidated = false;
		this.interprovidertransfer = value;
	}
	public boolean getRequestsForServiceIsNotNull()
	{
		return this.requestsforservice != null;
	}
	public ims.RefMan.vo.LinkedCatsReferralForOutcomeVoCollection getRequestsForService()
	{
		return this.requestsforservice;
	}
	public void setRequestsForService(ims.RefMan.vo.LinkedCatsReferralForOutcomeVoCollection value)
	{
		this.isValidated = false;
		this.requestsforservice = value;
	}
	public boolean getTransferOfCareIsNotNull()
	{
		return this.transferofcare != null;
	}
	public ims.RefMan.vo.CatsReferralForRequestServiceVo getTransferOfCare()
	{
		return this.transferofcare;
	}
	public void setTransferOfCare(ims.RefMan.vo.CatsReferralForRequestServiceVo value)
	{
		this.isValidated = false;
		this.transferofcare = value;
	}
	public boolean getOutcomeOfActionIsNotNull()
	{
		return this.outcomeofaction != null;
	}
	public ims.scheduling.vo.lookups.OutcomeAction getOutcomeOfAction()
	{
		return this.outcomeofaction;
	}
	public void setOutcomeOfAction(ims.scheduling.vo.lookups.OutcomeAction value)
	{
		this.isValidated = false;
		this.outcomeofaction = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.futureappointment != null)
		{
			if(!this.futureappointment.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.interprovidertransfer != null)
		{
			if(!this.interprovidertransfer.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.appointmentaction == null)
			listOfErrors.add("Appointment Action is mandatory");
		if(this.futureappointment != null)
		{
			String[] listOfOtherErrors = this.futureappointment.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.interprovidertransfer != null)
		{
			String[] listOfOtherErrors = this.interprovidertransfer.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		AppointmentOutcomeActionVo clone = new AppointmentOutcomeActionVo(this.id, this.version);
		
		if(this.appointmentaction == null)
			clone.appointmentaction = null;
		else
			clone.appointmentaction = (ims.scheduling.vo.lookups.AppointmentAction)this.appointmentaction.clone();
		clone.remove = this.remove;
		if(this.waitinglistaction == null)
			clone.waitinglistaction = null;
		else
			clone.waitinglistaction = (ims.RefMan.vo.PatientElectiveListAddLaterVo)this.waitinglistaction.clone();
		if(this.plannedlistaction == null)
			clone.plannedlistaction = null;
		else
			clone.plannedlistaction = (ims.RefMan.vo.PatientElectiveListAddLaterVo)this.plannedlistaction.clone();
		if(this.futureappointment == null)
			clone.futureappointment = null;
		else
			clone.futureappointment = (ims.scheduling.vo.FutureAppointmentDetailsVo)this.futureappointment.clone();
		if(this.interprovidertransfer == null)
			clone.interprovidertransfer = null;
		else
			clone.interprovidertransfer = (ims.RefMan.vo.InterProviderTransferOutVo)this.interprovidertransfer.clone();
		if(this.requestsforservice == null)
			clone.requestsforservice = null;
		else
			clone.requestsforservice = (ims.RefMan.vo.LinkedCatsReferralForOutcomeVoCollection)this.requestsforservice.clone();
		if(this.transferofcare == null)
			clone.transferofcare = null;
		else
			clone.transferofcare = (ims.RefMan.vo.CatsReferralForRequestServiceVo)this.transferofcare.clone();
		if(this.outcomeofaction == null)
			clone.outcomeofaction = null;
		else
			clone.outcomeofaction = (ims.scheduling.vo.lookups.OutcomeAction)this.outcomeofaction.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(AppointmentOutcomeActionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AppointmentOutcomeActionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AppointmentOutcomeActionVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AppointmentOutcomeActionVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.appointmentaction != null)
			count++;
		if(this.remove != null)
			count++;
		if(this.waitinglistaction != null)
			count++;
		if(this.plannedlistaction != null)
			count++;
		if(this.futureappointment != null)
			count++;
		if(this.interprovidertransfer != null)
			count++;
		if(this.requestsforservice != null)
			count++;
		if(this.transferofcare != null)
			count++;
		if(this.outcomeofaction != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.scheduling.vo.lookups.AppointmentAction appointmentaction;
	protected Boolean remove;
	protected ims.RefMan.vo.PatientElectiveListAddLaterVo waitinglistaction;
	protected ims.RefMan.vo.PatientElectiveListAddLaterVo plannedlistaction;
	protected ims.scheduling.vo.FutureAppointmentDetailsVo futureappointment;
	protected ims.RefMan.vo.InterProviderTransferOutVo interprovidertransfer;
	protected ims.RefMan.vo.LinkedCatsReferralForOutcomeVoCollection requestsforservice;
	protected ims.RefMan.vo.CatsReferralForRequestServiceVo transferofcare;
	protected ims.scheduling.vo.lookups.OutcomeAction outcomeofaction;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
