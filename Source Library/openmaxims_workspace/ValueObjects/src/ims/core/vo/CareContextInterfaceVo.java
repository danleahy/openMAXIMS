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

package ims.core.vo;

/**
 * Linked to core.admin.CareContext business object (ID: 1004100019).
 */
public class CareContextInterfaceVo extends ims.core.admin.vo.CareContextRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CareContextInterfaceVo()
	{
	}
	public CareContextInterfaceVo(Integer id, int version)
	{
		super(id, version);
	}
	public CareContextInterfaceVo(ims.core.vo.beans.CareContextInterfaceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.startdatetime = bean.getStartDateTime() == null ? null : bean.getStartDateTime().buildDateTime();
		this.enddatetime = bean.getEndDateTime() == null ? null : bean.getEndDateTime().buildDateTime();
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getResponsibleHCP().getId()), bean.getResponsibleHCP().getVersion());
		this.orderinghospital = bean.getOrderingHospital() == null ? null : new ims.core.resource.place.vo.LocSiteRefVo(new Integer(bean.getOrderingHospital().getId()), bean.getOrderingHospital().getVersion());
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.statushistory = ims.core.vo.CareContextStatusHistoryVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : bean.getEpisodeOfCare().buildVo();
		this.bednumber = bean.getBedNumber();
		this.estimateddischargedate = bean.getEstimatedDischargeDate() == null ? null : bean.getEstimatedDischargeDate().buildDate();
		this.context = bean.getContext() == null ? null : ims.core.vo.lookups.ContextType.buildLookup(bean.getContext());
		this.locationtype = bean.getLocationType() == null ? null : ims.core.vo.lookups.ContactLocation.buildLookup(bean.getLocationType());
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo();
		this.carecontexthistory = ims.core.vo.CareContextHistoryVoCollection.buildFromBeanCollection(bean.getCareContextHistory());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.CareContextInterfaceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.startdatetime = bean.getStartDateTime() == null ? null : bean.getStartDateTime().buildDateTime();
		this.enddatetime = bean.getEndDateTime() == null ? null : bean.getEndDateTime().buildDateTime();
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getResponsibleHCP().getId()), bean.getResponsibleHCP().getVersion());
		this.orderinghospital = bean.getOrderingHospital() == null ? null : new ims.core.resource.place.vo.LocSiteRefVo(new Integer(bean.getOrderingHospital().getId()), bean.getOrderingHospital().getVersion());
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.statushistory = ims.core.vo.CareContextStatusHistoryVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : bean.getEpisodeOfCare().buildVo(map);
		this.bednumber = bean.getBedNumber();
		this.estimateddischargedate = bean.getEstimatedDischargeDate() == null ? null : bean.getEstimatedDischargeDate().buildDate();
		this.context = bean.getContext() == null ? null : ims.core.vo.lookups.ContextType.buildLookup(bean.getContext());
		this.locationtype = bean.getLocationType() == null ? null : ims.core.vo.lookups.ContactLocation.buildLookup(bean.getLocationType());
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo(map);
		this.carecontexthistory = ims.core.vo.CareContextHistoryVoCollection.buildFromBeanCollection(bean.getCareContextHistory());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.CareContextInterfaceVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.CareContextInterfaceVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.CareContextInterfaceVoBean();
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
		if(fieldName.equals("STARTDATETIME"))
			return getStartDateTime();
		if(fieldName.equals("ENDDATETIME"))
			return getEndDateTime();
		if(fieldName.equals("RESPONSIBLEHCP"))
			return getResponsibleHCP();
		if(fieldName.equals("ORDERINGHOSPITAL"))
			return getOrderingHospital();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("STATUSHISTORY"))
			return getStatusHistory();
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		if(fieldName.equals("BEDNUMBER"))
			return getBedNumber();
		if(fieldName.equals("ESTIMATEDDISCHARGEDATE"))
			return getEstimatedDischargeDate();
		if(fieldName.equals("CONTEXT"))
			return getContext();
		if(fieldName.equals("LOCATIONTYPE"))
			return getLocationType();
		if(fieldName.equals("PASEVENT"))
			return getPasEvent();
		if(fieldName.equals("CARECONTEXTHISTORY"))
			return getCareContextHistory();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStartDateTimeIsNotNull()
	{
		return this.startdatetime != null;
	}
	public ims.framework.utils.DateTime getStartDateTime()
	{
		return this.startdatetime;
	}
	public void setStartDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.startdatetime = value;
	}
	public boolean getEndDateTimeIsNotNull()
	{
		return this.enddatetime != null;
	}
	public ims.framework.utils.DateTime getEndDateTime()
	{
		return this.enddatetime;
	}
	public void setEndDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.enddatetime = value;
	}
	public boolean getResponsibleHCPIsNotNull()
	{
		return this.responsiblehcp != null;
	}
	public ims.core.resource.people.vo.HcpRefVo getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.core.resource.people.vo.HcpRefVo value)
	{
		this.isValidated = false;
		this.responsiblehcp = value;
	}
	public boolean getOrderingHospitalIsNotNull()
	{
		return this.orderinghospital != null;
	}
	public ims.core.resource.place.vo.LocSiteRefVo getOrderingHospital()
	{
		return this.orderinghospital;
	}
	public void setOrderingHospital(ims.core.resource.place.vo.LocSiteRefVo value)
	{
		this.isValidated = false;
		this.orderinghospital = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.core.vo.CareContextStatusHistoryVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.core.vo.CareContextStatusHistoryVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getStatusHistoryIsNotNull()
	{
		return this.statushistory != null;
	}
	public ims.core.vo.CareContextStatusHistoryVoCollection getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.core.vo.CareContextStatusHistoryVoCollection value)
	{
		this.isValidated = false;
		this.statushistory = value;
	}
	public boolean getEpisodeOfCareIsNotNull()
	{
		return this.episodeofcare != null;
	}
	public ims.core.vo.EpisodeOfCareInterfaceVo getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.vo.EpisodeOfCareInterfaceVo value)
	{
		this.isValidated = false;
		this.episodeofcare = value;
	}
	public boolean getBedNumberIsNotNull()
	{
		return this.bednumber != null;
	}
	public String getBedNumber()
	{
		return this.bednumber;
	}
	public static int getBedNumberMaxLength()
	{
		return 10;
	}
	public void setBedNumber(String value)
	{
		this.isValidated = false;
		this.bednumber = value;
	}
	public boolean getEstimatedDischargeDateIsNotNull()
	{
		return this.estimateddischargedate != null;
	}
	public ims.framework.utils.Date getEstimatedDischargeDate()
	{
		return this.estimateddischargedate;
	}
	public void setEstimatedDischargeDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.estimateddischargedate = value;
	}
	public boolean getContextIsNotNull()
	{
		return this.context != null;
	}
	public ims.core.vo.lookups.ContextType getContext()
	{
		return this.context;
	}
	public void setContext(ims.core.vo.lookups.ContextType value)
	{
		this.isValidated = false;
		this.context = value;
	}
	public boolean getLocationTypeIsNotNull()
	{
		return this.locationtype != null;
	}
	public ims.core.vo.lookups.ContactLocation getLocationType()
	{
		return this.locationtype;
	}
	public void setLocationType(ims.core.vo.lookups.ContactLocation value)
	{
		this.isValidated = false;
		this.locationtype = value;
	}
	public boolean getPasEventIsNotNull()
	{
		return this.pasevent != null;
	}
	public ims.core.vo.PasEventLiteVo getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.PasEventLiteVo value)
	{
		this.isValidated = false;
		this.pasevent = value;
	}
	public boolean getCareContextHistoryIsNotNull()
	{
		return this.carecontexthistory != null;
	}
	public ims.core.vo.CareContextHistoryVoCollection getCareContextHistory()
	{
		return this.carecontexthistory;
	}
	public void setCareContextHistory(ims.core.vo.CareContextHistoryVoCollection value)
	{
		this.isValidated = false;
		this.carecontexthistory = value;
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
		if(this.currentstatus != null)
		{
			if(!this.currentstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.statushistory != null)
		{
			if(!this.statushistory.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.episodeofcare != null)
		{
			if(!this.episodeofcare.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.carecontexthistory != null)
		{
			if(!this.carecontexthistory.isValidated())
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
		if(this.startdatetime == null)
			listOfErrors.add("StartDateTime is mandatory");
		if(this.currentstatus != null)
		{
			String[] listOfOtherErrors = this.currentstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.statushistory != null)
		{
			String[] listOfOtherErrors = this.statushistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
		if(this.episodeofcare != null)
		{
			String[] listOfOtherErrors = this.episodeofcare.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.bednumber != null)
			if(this.bednumber.length() > 10)
				listOfErrors.add("The length of the field [bednumber] in the value object [ims.core.vo.CareContextInterfaceVo] is too big. It should be less or equal to 10");
		if(this.context == null)
			listOfErrors.add("Context is mandatory");
		if(this.carecontexthistory != null)
		{
			String[] listOfOtherErrors = this.carecontexthistory.validate();
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
	
		CareContextInterfaceVo clone = new CareContextInterfaceVo(this.id, this.version);
		
		if(this.startdatetime == null)
			clone.startdatetime = null;
		else
			clone.startdatetime = (ims.framework.utils.DateTime)this.startdatetime.clone();
		if(this.enddatetime == null)
			clone.enddatetime = null;
		else
			clone.enddatetime = (ims.framework.utils.DateTime)this.enddatetime.clone();
		clone.responsiblehcp = this.responsiblehcp;
		clone.orderinghospital = this.orderinghospital;
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.core.vo.CareContextStatusHistoryVo)this.currentstatus.clone();
		if(this.statushistory == null)
			clone.statushistory = null;
		else
			clone.statushistory = (ims.core.vo.CareContextStatusHistoryVoCollection)this.statushistory.clone();
		if(this.episodeofcare == null)
			clone.episodeofcare = null;
		else
			clone.episodeofcare = (ims.core.vo.EpisodeOfCareInterfaceVo)this.episodeofcare.clone();
		clone.bednumber = this.bednumber;
		if(this.estimateddischargedate == null)
			clone.estimateddischargedate = null;
		else
			clone.estimateddischargedate = (ims.framework.utils.Date)this.estimateddischargedate.clone();
		if(this.context == null)
			clone.context = null;
		else
			clone.context = (ims.core.vo.lookups.ContextType)this.context.clone();
		if(this.locationtype == null)
			clone.locationtype = null;
		else
			clone.locationtype = (ims.core.vo.lookups.ContactLocation)this.locationtype.clone();
		if(this.pasevent == null)
			clone.pasevent = null;
		else
			clone.pasevent = (ims.core.vo.PasEventLiteVo)this.pasevent.clone();
		if(this.carecontexthistory == null)
			clone.carecontexthistory = null;
		else
			clone.carecontexthistory = (ims.core.vo.CareContextHistoryVoCollection)this.carecontexthistory.clone();
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
		if (!(CareContextInterfaceVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CareContextInterfaceVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CareContextInterfaceVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CareContextInterfaceVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.startdatetime != null)
			count++;
		if(this.enddatetime != null)
			count++;
		if(this.responsiblehcp != null)
			count++;
		if(this.orderinghospital != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.statushistory != null)
			count++;
		if(this.episodeofcare != null)
			count++;
		if(this.bednumber != null)
			count++;
		if(this.estimateddischargedate != null)
			count++;
		if(this.context != null)
			count++;
		if(this.locationtype != null)
			count++;
		if(this.pasevent != null)
			count++;
		if(this.carecontexthistory != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 13;
	}
	protected ims.framework.utils.DateTime startdatetime;
	protected ims.framework.utils.DateTime enddatetime;
	protected ims.core.resource.people.vo.HcpRefVo responsiblehcp;
	protected ims.core.resource.place.vo.LocSiteRefVo orderinghospital;
	protected ims.core.vo.CareContextStatusHistoryVo currentstatus;
	protected ims.core.vo.CareContextStatusHistoryVoCollection statushistory;
	protected ims.core.vo.EpisodeOfCareInterfaceVo episodeofcare;
	protected String bednumber;
	protected ims.framework.utils.Date estimateddischargedate;
	protected ims.core.vo.lookups.ContextType context;
	protected ims.core.vo.lookups.ContactLocation locationtype;
	protected ims.core.vo.PasEventLiteVo pasevent;
	protected ims.core.vo.CareContextHistoryVoCollection carecontexthistory;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
