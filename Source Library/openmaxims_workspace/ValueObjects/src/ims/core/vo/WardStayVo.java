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
 * Linked to core.admin.pas.Ward Stay business object (ID: 1014100004).
 */
public class WardStayVo extends ims.core.admin.pas.vo.WardStayRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WardStayVo()
	{
	}
	public WardStayVo(Integer id, int version)
	{
		super(id, version);
	}
	public WardStayVo(ims.core.vo.beans.WardStayVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo();
		this.transferdatetime = bean.getTransferDateTime() == null ? null : bean.getTransferDateTime().buildDateTime();
		this.transferoutdatetime = bean.getTransferOutDateTime() == null ? null : bean.getTransferOutDateTime().buildDateTime();
		this.wardtype = bean.getWardType() == null ? null : ims.core.vo.lookups.WardType.buildLookup(bean.getWardType());
		this.bedspace = bean.getBedSpace() == null ? null : new ims.core.layout.vo.BedSpaceRefVo(new Integer(bean.getBedSpace().getId()), bean.getBedSpace().getVersion());
		this.bay = bean.getBay() == null ? null : bean.getBay().buildVo();
		this.patientstatus = bean.getPatientStatus() == null ? null : ims.core.vo.lookups.PatientStatus.buildLookup(bean.getPatientStatus());
		this.reasonprivatebedallocated = bean.getReasonPrivateBedAllocated() == null ? null : ims.core.vo.lookups.ReasonforPrivateBedAllocation.buildLookup(bean.getReasonPrivateBedAllocated());
		this.reasonadmittingoutsidehours = bean.getReasonAdmittingOutsideHours() == null ? null : ims.core.vo.lookups.ReasonForAdmissionOutOfOpeningHours.buildLookup(bean.getReasonAdmittingOutsideHours());
		this.reasongenderbreach = bean.getReasonGenderBreach() == null ? null : ims.core.vo.lookups.ReasonForAdmissionToGenderSpecificBay.buildLookup(bean.getReasonGenderBreach());
		this.admitedinmixedgenderbay = bean.getAdmitedInMixedGenderBay();
		this.reasonprivatebedallocatedcomment = bean.getReasonPrivateBedAllocatedComment();
		this.reasonadmittingoutsidehourscomment = bean.getReasonAdmittingOutsideHoursComment();
		this.reasongenderbreachcomment = bean.getReasonGenderBreachComment();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.transferreason = bean.getTransferReason() == null ? null : ims.core.vo.lookups.TransferReason.buildLookup(bean.getTransferReason());
		this.transfercomment = bean.getTransferComment();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.WardStayVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo(map);
		this.transferdatetime = bean.getTransferDateTime() == null ? null : bean.getTransferDateTime().buildDateTime();
		this.transferoutdatetime = bean.getTransferOutDateTime() == null ? null : bean.getTransferOutDateTime().buildDateTime();
		this.wardtype = bean.getWardType() == null ? null : ims.core.vo.lookups.WardType.buildLookup(bean.getWardType());
		this.bedspace = bean.getBedSpace() == null ? null : new ims.core.layout.vo.BedSpaceRefVo(new Integer(bean.getBedSpace().getId()), bean.getBedSpace().getVersion());
		this.bay = bean.getBay() == null ? null : bean.getBay().buildVo(map);
		this.patientstatus = bean.getPatientStatus() == null ? null : ims.core.vo.lookups.PatientStatus.buildLookup(bean.getPatientStatus());
		this.reasonprivatebedallocated = bean.getReasonPrivateBedAllocated() == null ? null : ims.core.vo.lookups.ReasonforPrivateBedAllocation.buildLookup(bean.getReasonPrivateBedAllocated());
		this.reasonadmittingoutsidehours = bean.getReasonAdmittingOutsideHours() == null ? null : ims.core.vo.lookups.ReasonForAdmissionOutOfOpeningHours.buildLookup(bean.getReasonAdmittingOutsideHours());
		this.reasongenderbreach = bean.getReasonGenderBreach() == null ? null : ims.core.vo.lookups.ReasonForAdmissionToGenderSpecificBay.buildLookup(bean.getReasonGenderBreach());
		this.admitedinmixedgenderbay = bean.getAdmitedInMixedGenderBay();
		this.reasonprivatebedallocatedcomment = bean.getReasonPrivateBedAllocatedComment();
		this.reasonadmittingoutsidehourscomment = bean.getReasonAdmittingOutsideHoursComment();
		this.reasongenderbreachcomment = bean.getReasonGenderBreachComment();
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.transferreason = bean.getTransferReason() == null ? null : ims.core.vo.lookups.TransferReason.buildLookup(bean.getTransferReason());
		this.transfercomment = bean.getTransferComment();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.WardStayVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.WardStayVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.WardStayVoBean();
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
		if(fieldName.equals("WARD"))
			return getWard();
		if(fieldName.equals("TRANSFERDATETIME"))
			return getTransferDateTime();
		if(fieldName.equals("TRANSFEROUTDATETIME"))
			return getTransferOutDateTime();
		if(fieldName.equals("WARDTYPE"))
			return getWardType();
		if(fieldName.equals("BEDSPACE"))
			return getBedSpace();
		if(fieldName.equals("BAY"))
			return getBay();
		if(fieldName.equals("PATIENTSTATUS"))
			return getPatientStatus();
		if(fieldName.equals("REASONPRIVATEBEDALLOCATED"))
			return getReasonPrivateBedAllocated();
		if(fieldName.equals("REASONADMITTINGOUTSIDEHOURS"))
			return getReasonAdmittingOutsideHours();
		if(fieldName.equals("REASONGENDERBREACH"))
			return getReasonGenderBreach();
		if(fieldName.equals("ADMITEDINMIXEDGENDERBAY"))
			return getAdmitedInMixedGenderBay();
		if(fieldName.equals("REASONPRIVATEBEDALLOCATEDCOMMENT"))
			return getReasonPrivateBedAllocatedComment();
		if(fieldName.equals("REASONADMITTINGOUTSIDEHOURSCOMMENT"))
			return getReasonAdmittingOutsideHoursComment();
		if(fieldName.equals("REASONGENDERBREACHCOMMENT"))
			return getReasonGenderBreachComment();
		if(fieldName.equals("SERVICE"))
			return getService();
		if(fieldName.equals("TRANSFERREASON"))
			return getTransferReason();
		if(fieldName.equals("TRANSFERCOMMENT"))
			return getTransferComment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getWardIsNotNull()
	{
		return this.ward != null;
	}
	public ims.core.vo.LocationLiteVo getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.ward = value;
	}
	public boolean getTransferDateTimeIsNotNull()
	{
		return this.transferdatetime != null;
	}
	public ims.framework.utils.DateTime getTransferDateTime()
	{
		return this.transferdatetime;
	}
	public void setTransferDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.transferdatetime = value;
	}
	public boolean getTransferOutDateTimeIsNotNull()
	{
		return this.transferoutdatetime != null;
	}
	public ims.framework.utils.DateTime getTransferOutDateTime()
	{
		return this.transferoutdatetime;
	}
	public void setTransferOutDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.transferoutdatetime = value;
	}
	public boolean getWardTypeIsNotNull()
	{
		return this.wardtype != null;
	}
	public ims.core.vo.lookups.WardType getWardType()
	{
		return this.wardtype;
	}
	public void setWardType(ims.core.vo.lookups.WardType value)
	{
		this.isValidated = false;
		this.wardtype = value;
	}
	public boolean getBedSpaceIsNotNull()
	{
		return this.bedspace != null;
	}
	public ims.core.layout.vo.BedSpaceRefVo getBedSpace()
	{
		return this.bedspace;
	}
	public void setBedSpace(ims.core.layout.vo.BedSpaceRefVo value)
	{
		this.isValidated = false;
		this.bedspace = value;
	}
	public boolean getBayIsNotNull()
	{
		return this.bay != null;
	}
	public ims.core.vo.LocationLiteVo getBay()
	{
		return this.bay;
	}
	public void setBay(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.bay = value;
	}
	public boolean getPatientStatusIsNotNull()
	{
		return this.patientstatus != null;
	}
	public ims.core.vo.lookups.PatientStatus getPatientStatus()
	{
		return this.patientstatus;
	}
	public void setPatientStatus(ims.core.vo.lookups.PatientStatus value)
	{
		this.isValidated = false;
		this.patientstatus = value;
	}
	public boolean getReasonPrivateBedAllocatedIsNotNull()
	{
		return this.reasonprivatebedallocated != null;
	}
	public ims.core.vo.lookups.ReasonforPrivateBedAllocation getReasonPrivateBedAllocated()
	{
		return this.reasonprivatebedallocated;
	}
	public void setReasonPrivateBedAllocated(ims.core.vo.lookups.ReasonforPrivateBedAllocation value)
	{
		this.isValidated = false;
		this.reasonprivatebedallocated = value;
	}
	public boolean getReasonAdmittingOutsideHoursIsNotNull()
	{
		return this.reasonadmittingoutsidehours != null;
	}
	public ims.core.vo.lookups.ReasonForAdmissionOutOfOpeningHours getReasonAdmittingOutsideHours()
	{
		return this.reasonadmittingoutsidehours;
	}
	public void setReasonAdmittingOutsideHours(ims.core.vo.lookups.ReasonForAdmissionOutOfOpeningHours value)
	{
		this.isValidated = false;
		this.reasonadmittingoutsidehours = value;
	}
	public boolean getReasonGenderBreachIsNotNull()
	{
		return this.reasongenderbreach != null;
	}
	public ims.core.vo.lookups.ReasonForAdmissionToGenderSpecificBay getReasonGenderBreach()
	{
		return this.reasongenderbreach;
	}
	public void setReasonGenderBreach(ims.core.vo.lookups.ReasonForAdmissionToGenderSpecificBay value)
	{
		this.isValidated = false;
		this.reasongenderbreach = value;
	}
	public boolean getAdmitedInMixedGenderBayIsNotNull()
	{
		return this.admitedinmixedgenderbay != null;
	}
	public Boolean getAdmitedInMixedGenderBay()
	{
		return this.admitedinmixedgenderbay;
	}
	public void setAdmitedInMixedGenderBay(Boolean value)
	{
		this.isValidated = false;
		this.admitedinmixedgenderbay = value;
	}
	public boolean getReasonPrivateBedAllocatedCommentIsNotNull()
	{
		return this.reasonprivatebedallocatedcomment != null;
	}
	public String getReasonPrivateBedAllocatedComment()
	{
		return this.reasonprivatebedallocatedcomment;
	}
	public static int getReasonPrivateBedAllocatedCommentMaxLength()
	{
		return 250;
	}
	public void setReasonPrivateBedAllocatedComment(String value)
	{
		this.isValidated = false;
		this.reasonprivatebedallocatedcomment = value;
	}
	public boolean getReasonAdmittingOutsideHoursCommentIsNotNull()
	{
		return this.reasonadmittingoutsidehourscomment != null;
	}
	public String getReasonAdmittingOutsideHoursComment()
	{
		return this.reasonadmittingoutsidehourscomment;
	}
	public static int getReasonAdmittingOutsideHoursCommentMaxLength()
	{
		return 250;
	}
	public void setReasonAdmittingOutsideHoursComment(String value)
	{
		this.isValidated = false;
		this.reasonadmittingoutsidehourscomment = value;
	}
	public boolean getReasonGenderBreachCommentIsNotNull()
	{
		return this.reasongenderbreachcomment != null;
	}
	public String getReasonGenderBreachComment()
	{
		return this.reasongenderbreachcomment;
	}
	public static int getReasonGenderBreachCommentMaxLength()
	{
		return 250;
	}
	public void setReasonGenderBreachComment(String value)
	{
		this.isValidated = false;
		this.reasongenderbreachcomment = value;
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.vo.ServiceLiteVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.ServiceLiteVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getTransferReasonIsNotNull()
	{
		return this.transferreason != null;
	}
	public ims.core.vo.lookups.TransferReason getTransferReason()
	{
		return this.transferreason;
	}
	public void setTransferReason(ims.core.vo.lookups.TransferReason value)
	{
		this.isValidated = false;
		this.transferreason = value;
	}
	public boolean getTransferCommentIsNotNull()
	{
		return this.transfercomment != null;
	}
	public String getTransferComment()
	{
		return this.transfercomment;
	}
	public static int getTransferCommentMaxLength()
	{
		return 250;
	}
	public void setTransferComment(String value)
	{
		this.isValidated = false;
		this.transfercomment = value;
	}
	/**
	* WardStayVoIdComparator 
	*/
	public static WardStayVoIdComparator getWardStayVoIdComparator()
	{
		return new WardStayVoIdComparator();
	}
	    	
	public static WardStayVoIdComparator getWardStayVoIdComparator(ims.framework.enumerations.SortOrder order)
	{
		return new WardStayVoIdComparator(order);
	}
	
		public static class WardStayVoIdComparator implements java.util.Comparator<WardStayVo>
		{
			private int direction = 1;
			public WardStayVoIdComparator()
			{
				this(ims.framework.enumerations.SortOrder.DESCENDING);
			}
			public WardStayVoIdComparator(ims.framework.enumerations.SortOrder order)
			{
				if (order == ims.framework.enumerations.SortOrder.DESCENDING)
				{
					direction = -1;
				}
			}
			public int compare(WardStayVo voObj1, WardStayVo voObj2)
			{
				if (voObj1.getBoId() == null)
					return 1;
				if (voObj2.getBoId() == null)
					return -1;
				return direction*(voObj1.getBoId().compareTo(voObj2.getBoId()));
			}
			public boolean equals(Object obj)
			{
				return false;
			}
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
		if(this.reasonprivatebedallocatedcomment != null)
			if(this.reasonprivatebedallocatedcomment.length() > 250)
				listOfErrors.add("The length of the field [reasonprivatebedallocatedcomment] in the value object [ims.core.vo.WardStayVo] is too big. It should be less or equal to 250");
		if(this.reasonadmittingoutsidehourscomment != null)
			if(this.reasonadmittingoutsidehourscomment.length() > 250)
				listOfErrors.add("The length of the field [reasonadmittingoutsidehourscomment] in the value object [ims.core.vo.WardStayVo] is too big. It should be less or equal to 250");
		if(this.reasongenderbreachcomment != null)
			if(this.reasongenderbreachcomment.length() > 250)
				listOfErrors.add("The length of the field [reasongenderbreachcomment] in the value object [ims.core.vo.WardStayVo] is too big. It should be less or equal to 250");
		if(this.transfercomment != null)
			if(this.transfercomment.length() > 250)
				listOfErrors.add("The length of the field [transfercomment] in the value object [ims.core.vo.WardStayVo] is too big. It should be less or equal to 250");
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
	
		WardStayVo clone = new WardStayVo(this.id, this.version);
		
		if(this.ward == null)
			clone.ward = null;
		else
			clone.ward = (ims.core.vo.LocationLiteVo)this.ward.clone();
		if(this.transferdatetime == null)
			clone.transferdatetime = null;
		else
			clone.transferdatetime = (ims.framework.utils.DateTime)this.transferdatetime.clone();
		if(this.transferoutdatetime == null)
			clone.transferoutdatetime = null;
		else
			clone.transferoutdatetime = (ims.framework.utils.DateTime)this.transferoutdatetime.clone();
		if(this.wardtype == null)
			clone.wardtype = null;
		else
			clone.wardtype = (ims.core.vo.lookups.WardType)this.wardtype.clone();
		clone.bedspace = this.bedspace;
		if(this.bay == null)
			clone.bay = null;
		else
			clone.bay = (ims.core.vo.LocationLiteVo)this.bay.clone();
		if(this.patientstatus == null)
			clone.patientstatus = null;
		else
			clone.patientstatus = (ims.core.vo.lookups.PatientStatus)this.patientstatus.clone();
		if(this.reasonprivatebedallocated == null)
			clone.reasonprivatebedallocated = null;
		else
			clone.reasonprivatebedallocated = (ims.core.vo.lookups.ReasonforPrivateBedAllocation)this.reasonprivatebedallocated.clone();
		if(this.reasonadmittingoutsidehours == null)
			clone.reasonadmittingoutsidehours = null;
		else
			clone.reasonadmittingoutsidehours = (ims.core.vo.lookups.ReasonForAdmissionOutOfOpeningHours)this.reasonadmittingoutsidehours.clone();
		if(this.reasongenderbreach == null)
			clone.reasongenderbreach = null;
		else
			clone.reasongenderbreach = (ims.core.vo.lookups.ReasonForAdmissionToGenderSpecificBay)this.reasongenderbreach.clone();
		clone.admitedinmixedgenderbay = this.admitedinmixedgenderbay;
		clone.reasonprivatebedallocatedcomment = this.reasonprivatebedallocatedcomment;
		clone.reasonadmittingoutsidehourscomment = this.reasonadmittingoutsidehourscomment;
		clone.reasongenderbreachcomment = this.reasongenderbreachcomment;
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceLiteVo)this.service.clone();
		if(this.transferreason == null)
			clone.transferreason = null;
		else
			clone.transferreason = (ims.core.vo.lookups.TransferReason)this.transferreason.clone();
		clone.transfercomment = this.transfercomment;
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
		if (!(WardStayVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WardStayVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		WardStayVo compareObj = (WardStayVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getTransferDateTime() == null && compareObj.getTransferDateTime() != null)
				return -1;
			if(this.getTransferDateTime() != null && compareObj.getTransferDateTime() == null)
				return 1;
			if(this.getTransferDateTime() != null && compareObj.getTransferDateTime() != null)
				retVal = this.getTransferDateTime().compareTo(compareObj.getTransferDateTime());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.ward != null)
			count++;
		if(this.transferdatetime != null)
			count++;
		if(this.transferoutdatetime != null)
			count++;
		if(this.wardtype != null)
			count++;
		if(this.bedspace != null)
			count++;
		if(this.bay != null)
			count++;
		if(this.patientstatus != null)
			count++;
		if(this.reasonprivatebedallocated != null)
			count++;
		if(this.reasonadmittingoutsidehours != null)
			count++;
		if(this.reasongenderbreach != null)
			count++;
		if(this.admitedinmixedgenderbay != null)
			count++;
		if(this.reasonprivatebedallocatedcomment != null)
			count++;
		if(this.reasonadmittingoutsidehourscomment != null)
			count++;
		if(this.reasongenderbreachcomment != null)
			count++;
		if(this.service != null)
			count++;
		if(this.transferreason != null)
			count++;
		if(this.transfercomment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 17;
	}
	protected ims.core.vo.LocationLiteVo ward;
	protected ims.framework.utils.DateTime transferdatetime;
	protected ims.framework.utils.DateTime transferoutdatetime;
	protected ims.core.vo.lookups.WardType wardtype;
	protected ims.core.layout.vo.BedSpaceRefVo bedspace;
	protected ims.core.vo.LocationLiteVo bay;
	protected ims.core.vo.lookups.PatientStatus patientstatus;
	protected ims.core.vo.lookups.ReasonforPrivateBedAllocation reasonprivatebedallocated;
	protected ims.core.vo.lookups.ReasonForAdmissionOutOfOpeningHours reasonadmittingoutsidehours;
	protected ims.core.vo.lookups.ReasonForAdmissionToGenderSpecificBay reasongenderbreach;
	protected Boolean admitedinmixedgenderbay;
	protected String reasonprivatebedallocatedcomment;
	protected String reasonadmittingoutsidehourscomment;
	protected String reasongenderbreachcomment;
	protected ims.core.vo.ServiceLiteVo service;
	protected ims.core.vo.lookups.TransferReason transferreason;
	protected String transfercomment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
