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
 * Linked to core.admin.Referral business object (ID: 1004100001).
 */
public class PASReferralVo extends ims.core.admin.vo.ReferralRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PASReferralVo()
	{
	}
	public PASReferralVo(Integer id, int version)
	{
		super(id, version);
	}
	public PASReferralVo(ims.core.vo.beans.PASReferralVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.details = bean.getDetails();
		this.referralreceiveddate = bean.getReferralReceivedDate() == null ? null : bean.getReferralReceivedDate().buildDate();
		this.originalreferraldate = bean.getOriginalReferralDate() == null ? null : bean.getOriginalReferralDate().buildDate();
		this.firstapptdate = bean.getFirstApptDate() == null ? null : bean.getFirstApptDate().buildDateTime();
		this.sourceofreferral = bean.getSourceOfReferral() == null ? null : ims.core.vo.lookups.SourceOfReferral.buildLookup(bean.getSourceOfReferral());
		this.referringgp = bean.getReferringGP() == null ? null : bean.getReferringGP().buildVo();
		this.referringclinician = bean.getReferringClinician() == null ? null : bean.getReferringClinician().buildVo();
		this.referredto = bean.getReferredTo() == null ? null : bean.getReferredTo().buildVo();
		this.referraldetails = bean.getReferralDetails();
		this.dateofreferral = bean.getDateOfReferral() == null ? null : bean.getDateOfReferral().buildDate();
		this.referrallocation = bean.getReferralLocation();
		this.referraltype = bean.getReferralType() == null ? null : ims.core.vo.lookups.ReferralType.buildLookup(bean.getReferralType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PASReferralVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.details = bean.getDetails();
		this.referralreceiveddate = bean.getReferralReceivedDate() == null ? null : bean.getReferralReceivedDate().buildDate();
		this.originalreferraldate = bean.getOriginalReferralDate() == null ? null : bean.getOriginalReferralDate().buildDate();
		this.firstapptdate = bean.getFirstApptDate() == null ? null : bean.getFirstApptDate().buildDateTime();
		this.sourceofreferral = bean.getSourceOfReferral() == null ? null : ims.core.vo.lookups.SourceOfReferral.buildLookup(bean.getSourceOfReferral());
		this.referringgp = bean.getReferringGP() == null ? null : bean.getReferringGP().buildVo(map);
		this.referringclinician = bean.getReferringClinician() == null ? null : bean.getReferringClinician().buildVo(map);
		this.referredto = bean.getReferredTo() == null ? null : bean.getReferredTo().buildVo(map);
		this.referraldetails = bean.getReferralDetails();
		this.dateofreferral = bean.getDateOfReferral() == null ? null : bean.getDateOfReferral().buildDate();
		this.referrallocation = bean.getReferralLocation();
		this.referraltype = bean.getReferralType() == null ? null : ims.core.vo.lookups.ReferralType.buildLookup(bean.getReferralType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PASReferralVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PASReferralVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PASReferralVoBean();
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
		if(fieldName.equals("DETAILS"))
			return getDetails();
		if(fieldName.equals("REFERRALRECEIVEDDATE"))
			return getReferralReceivedDate();
		if(fieldName.equals("ORIGINALREFERRALDATE"))
			return getOriginalReferralDate();
		if(fieldName.equals("FIRSTAPPTDATE"))
			return getFirstApptDate();
		if(fieldName.equals("SOURCEOFREFERRAL"))
			return getSourceOfReferral();
		if(fieldName.equals("REFERRINGGP"))
			return getReferringGP();
		if(fieldName.equals("REFERRINGCLINICIAN"))
			return getReferringClinician();
		if(fieldName.equals("REFERREDTO"))
			return getReferredTo();
		if(fieldName.equals("REFERRALDETAILS"))
			return getReferralDetails();
		if(fieldName.equals("DATEOFREFERRAL"))
			return getDateOfReferral();
		if(fieldName.equals("REFERRALLOCATION"))
			return getReferralLocation();
		if(fieldName.equals("REFERRALTYPE"))
			return getReferralType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDetailsIsNotNull()
	{
		return this.details != null;
	}
	public String getDetails()
	{
		return this.details;
	}
	public static int getDetailsMaxLength()
	{
		return 255;
	}
	public void setDetails(String value)
	{
		this.isValidated = false;
		this.details = value;
	}
	public boolean getReferralReceivedDateIsNotNull()
	{
		return this.referralreceiveddate != null;
	}
	public ims.framework.utils.Date getReferralReceivedDate()
	{
		return this.referralreceiveddate;
	}
	public void setReferralReceivedDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.referralreceiveddate = value;
	}
	public boolean getOriginalReferralDateIsNotNull()
	{
		return this.originalreferraldate != null;
	}
	public ims.framework.utils.Date getOriginalReferralDate()
	{
		return this.originalreferraldate;
	}
	public void setOriginalReferralDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.originalreferraldate = value;
	}
	public boolean getFirstApptDateIsNotNull()
	{
		return this.firstapptdate != null;
	}
	public ims.framework.utils.DateTime getFirstApptDate()
	{
		return this.firstapptdate;
	}
	public void setFirstApptDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.firstapptdate = value;
	}
	public boolean getSourceOfReferralIsNotNull()
	{
		return this.sourceofreferral != null;
	}
	public ims.core.vo.lookups.SourceOfReferral getSourceOfReferral()
	{
		return this.sourceofreferral;
	}
	public void setSourceOfReferral(ims.core.vo.lookups.SourceOfReferral value)
	{
		this.isValidated = false;
		this.sourceofreferral = value;
	}
	public boolean getReferringGPIsNotNull()
	{
		return this.referringgp != null;
	}
	public ims.core.vo.GpLiteVo getReferringGP()
	{
		return this.referringgp;
	}
	public void setReferringGP(ims.core.vo.GpLiteVo value)
	{
		this.isValidated = false;
		this.referringgp = value;
	}
	public boolean getReferringClinicianIsNotNull()
	{
		return this.referringclinician != null;
	}
	public ims.core.vo.HcpLiteVo getReferringClinician()
	{
		return this.referringclinician;
	}
	public void setReferringClinician(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.referringclinician = value;
	}
	public boolean getReferredToIsNotNull()
	{
		return this.referredto != null;
	}
	public ims.core.vo.HcpLiteVo getReferredTo()
	{
		return this.referredto;
	}
	public void setReferredTo(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.referredto = value;
	}
	public boolean getReferralDetailsIsNotNull()
	{
		return this.referraldetails != null;
	}
	public String getReferralDetails()
	{
		return this.referraldetails;
	}
	public static int getReferralDetailsMaxLength()
	{
		return 250;
	}
	public void setReferralDetails(String value)
	{
		this.isValidated = false;
		this.referraldetails = value;
	}
	public boolean getDateOfReferralIsNotNull()
	{
		return this.dateofreferral != null;
	}
	public ims.framework.utils.Date getDateOfReferral()
	{
		return this.dateofreferral;
	}
	public void setDateOfReferral(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateofreferral = value;
	}
	public boolean getReferralLocationIsNotNull()
	{
		return this.referrallocation != null;
	}
	public String getReferralLocation()
	{
		return this.referrallocation;
	}
	public static int getReferralLocationMaxLength()
	{
		return 100;
	}
	public void setReferralLocation(String value)
	{
		this.isValidated = false;
		this.referrallocation = value;
	}
	public boolean getReferralTypeIsNotNull()
	{
		return this.referraltype != null;
	}
	public ims.core.vo.lookups.ReferralType getReferralType()
	{
		return this.referraltype;
	}
	public void setReferralType(ims.core.vo.lookups.ReferralType value)
	{
		this.isValidated = false;
		this.referraltype = value;
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
		if(this.details != null)
			if(this.details.length() > 255)
				listOfErrors.add("The length of the field [details] in the value object [ims.core.vo.PASReferralVo] is too big. It should be less or equal to 255");
		if(this.referraldetails != null)
			if(this.referraldetails.length() > 250)
				listOfErrors.add("The length of the field [referraldetails] in the value object [ims.core.vo.PASReferralVo] is too big. It should be less or equal to 250");
		if(this.referrallocation != null)
			if(this.referrallocation.length() > 100)
				listOfErrors.add("The length of the field [referrallocation] in the value object [ims.core.vo.PASReferralVo] is too big. It should be less or equal to 100");
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
	
		PASReferralVo clone = new PASReferralVo(this.id, this.version);
		
		clone.details = this.details;
		if(this.referralreceiveddate == null)
			clone.referralreceiveddate = null;
		else
			clone.referralreceiveddate = (ims.framework.utils.Date)this.referralreceiveddate.clone();
		if(this.originalreferraldate == null)
			clone.originalreferraldate = null;
		else
			clone.originalreferraldate = (ims.framework.utils.Date)this.originalreferraldate.clone();
		if(this.firstapptdate == null)
			clone.firstapptdate = null;
		else
			clone.firstapptdate = (ims.framework.utils.DateTime)this.firstapptdate.clone();
		if(this.sourceofreferral == null)
			clone.sourceofreferral = null;
		else
			clone.sourceofreferral = (ims.core.vo.lookups.SourceOfReferral)this.sourceofreferral.clone();
		if(this.referringgp == null)
			clone.referringgp = null;
		else
			clone.referringgp = (ims.core.vo.GpLiteVo)this.referringgp.clone();
		if(this.referringclinician == null)
			clone.referringclinician = null;
		else
			clone.referringclinician = (ims.core.vo.HcpLiteVo)this.referringclinician.clone();
		if(this.referredto == null)
			clone.referredto = null;
		else
			clone.referredto = (ims.core.vo.HcpLiteVo)this.referredto.clone();
		clone.referraldetails = this.referraldetails;
		if(this.dateofreferral == null)
			clone.dateofreferral = null;
		else
			clone.dateofreferral = (ims.framework.utils.Date)this.dateofreferral.clone();
		clone.referrallocation = this.referrallocation;
		if(this.referraltype == null)
			clone.referraltype = null;
		else
			clone.referraltype = (ims.core.vo.lookups.ReferralType)this.referraltype.clone();
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
		if (!(PASReferralVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PASReferralVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PASReferralVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PASReferralVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.details != null)
			count++;
		if(this.referralreceiveddate != null)
			count++;
		if(this.originalreferraldate != null)
			count++;
		if(this.firstapptdate != null)
			count++;
		if(this.sourceofreferral != null)
			count++;
		if(this.referringgp != null)
			count++;
		if(this.referringclinician != null)
			count++;
		if(this.referredto != null)
			count++;
		if(this.referraldetails != null)
			count++;
		if(this.dateofreferral != null)
			count++;
		if(this.referrallocation != null)
			count++;
		if(this.referraltype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 12;
	}
	protected String details;
	protected ims.framework.utils.Date referralreceiveddate;
	protected ims.framework.utils.Date originalreferraldate;
	protected ims.framework.utils.DateTime firstapptdate;
	protected ims.core.vo.lookups.SourceOfReferral sourceofreferral;
	protected ims.core.vo.GpLiteVo referringgp;
	protected ims.core.vo.HcpLiteVo referringclinician;
	protected ims.core.vo.HcpLiteVo referredto;
	protected String referraldetails;
	protected ims.framework.utils.Date dateofreferral;
	protected String referrallocation;
	protected ims.core.vo.lookups.ReferralType referraltype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
