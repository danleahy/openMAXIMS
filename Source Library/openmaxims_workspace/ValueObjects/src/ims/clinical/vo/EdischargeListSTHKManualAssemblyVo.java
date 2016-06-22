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

package ims.clinical.vo;


public class EdischargeListSTHKManualAssemblyVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EdischargeListSTHKManualAssemblyVo()
	{
	}
	public EdischargeListSTHKManualAssemblyVo(ims.clinical.vo.beans.EdischargeListSTHKManualAssemblyVoBean bean)
	{
		this.carecontextrefvo = bean.getCareContextRefVo() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContextRefVo().getId()), bean.getCareContextRefVo().getVersion());
		this.responsiblehcpname = bean.getResponsibleHCPName();
		this.ward = bean.getWard();
		this.dischargedate = bean.getDischargeDate() == null ? null : bean.getDischargeDate().buildDate();
		this.patientname = bean.getPatientName();
		this.patienthospnum = bean.getPatientHospnum();
		this.letterstatus = bean.getLetterStatus();
		this.issummaryrecordcomplete = bean.getIsSummaryRecordComplete();
		this.juliandate = bean.getJulianDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.EdischargeListSTHKManualAssemblyVoBean bean)
	{
		this.carecontextrefvo = bean.getCareContextRefVo() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContextRefVo().getId()), bean.getCareContextRefVo().getVersion());
		this.responsiblehcpname = bean.getResponsibleHCPName();
		this.ward = bean.getWard();
		this.dischargedate = bean.getDischargeDate() == null ? null : bean.getDischargeDate().buildDate();
		this.patientname = bean.getPatientName();
		this.patienthospnum = bean.getPatientHospnum();
		this.letterstatus = bean.getLetterStatus();
		this.issummaryrecordcomplete = bean.getIsSummaryRecordComplete();
		this.juliandate = bean.getJulianDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.EdischargeListSTHKManualAssemblyVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.EdischargeListSTHKManualAssemblyVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.EdischargeListSTHKManualAssemblyVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getCareContextRefVoIsNotNull()
	{
		return this.carecontextrefvo != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContextRefVo()
	{
		return this.carecontextrefvo;
	}
	public void setCareContextRefVo(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontextrefvo = value;
	}
	public boolean getResponsibleHCPNameIsNotNull()
	{
		return this.responsiblehcpname != null;
	}
	public String getResponsibleHCPName()
	{
		return this.responsiblehcpname;
	}
	public static int getResponsibleHCPNameMaxLength()
	{
		return 255;
	}
	public void setResponsibleHCPName(String value)
	{
		this.isValidated = false;
		this.responsiblehcpname = value;
	}
	public boolean getWardIsNotNull()
	{
		return this.ward != null;
	}
	public String getWard()
	{
		return this.ward;
	}
	public static int getWardMaxLength()
	{
		return 255;
	}
	public void setWard(String value)
	{
		this.isValidated = false;
		this.ward = value;
	}
	public boolean getDischargeDateIsNotNull()
	{
		return this.dischargedate != null;
	}
	public ims.framework.utils.Date getDischargeDate()
	{
		return this.dischargedate;
	}
	public void setDischargeDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dischargedate = value;
	}
	public boolean getPatientNameIsNotNull()
	{
		return this.patientname != null;
	}
	public String getPatientName()
	{
		return this.patientname;
	}
	public static int getPatientNameMaxLength()
	{
		return 255;
	}
	public void setPatientName(String value)
	{
		this.isValidated = false;
		this.patientname = value;
	}
	public boolean getPatientHospnumIsNotNull()
	{
		return this.patienthospnum != null;
	}
	public String getPatientHospnum()
	{
		return this.patienthospnum;
	}
	public static int getPatientHospnumMaxLength()
	{
		return 255;
	}
	public void setPatientHospnum(String value)
	{
		this.isValidated = false;
		this.patienthospnum = value;
	}
	public boolean getLetterStatusIsNotNull()
	{
		return this.letterstatus != null;
	}
	public String getLetterStatus()
	{
		return this.letterstatus;
	}
	public static int getLetterStatusMaxLength()
	{
		return 255;
	}
	public void setLetterStatus(String value)
	{
		this.isValidated = false;
		this.letterstatus = value;
	}
	public boolean getIsSummaryRecordCompleteIsNotNull()
	{
		return this.issummaryrecordcomplete != null;
	}
	public Boolean getIsSummaryRecordComplete()
	{
		return this.issummaryrecordcomplete;
	}
	public void setIsSummaryRecordComplete(Boolean value)
	{
		this.isValidated = false;
		this.issummaryrecordcomplete = value;
	}
	public boolean getJulianDateIsNotNull()
	{
		return this.juliandate != null;
	}
	public String getJulianDate()
	{
		return this.juliandate;
	}
	public static int getJulianDateMaxLength()
	{
		return 255;
	}
	public void setJulianDate(String value)
	{
		this.isValidated = false;
		this.juliandate = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof EdischargeListSTHKManualAssemblyVo))
			return false;
		EdischargeListSTHKManualAssemblyVo compareObj = (EdischargeListSTHKManualAssemblyVo)obj;
		if(this.getCareContextRefVo() == null && compareObj.getCareContextRefVo() != null)
			return false;
		if(this.getCareContextRefVo() != null && compareObj.getCareContextRefVo() == null)
			return false;
		if(this.getCareContextRefVo() != null && compareObj.getCareContextRefVo() != null)
			return this.getCareContextRefVo().equals(compareObj.getCareContextRefVo());
		return super.equals(obj);
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		EdischargeListSTHKManualAssemblyVo clone = new EdischargeListSTHKManualAssemblyVo();
		
		clone.carecontextrefvo = this.carecontextrefvo;
		clone.responsiblehcpname = this.responsiblehcpname;
		clone.ward = this.ward;
		if(this.dischargedate == null)
			clone.dischargedate = null;
		else
			clone.dischargedate = (ims.framework.utils.Date)this.dischargedate.clone();
		clone.patientname = this.patientname;
		clone.patienthospnum = this.patienthospnum;
		clone.letterstatus = this.letterstatus;
		clone.issummaryrecordcomplete = this.issummaryrecordcomplete;
		clone.juliandate = this.juliandate;
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
		if (!(EdischargeListSTHKManualAssemblyVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EdischargeListSTHKManualAssemblyVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		EdischargeListSTHKManualAssemblyVo compareObj = (EdischargeListSTHKManualAssemblyVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getJulianDate() == null && compareObj.getJulianDate() != null)
				return -1;
			if(this.getJulianDate() != null && compareObj.getJulianDate() == null)
				return 1;
			if(this.getJulianDate() != null && compareObj.getJulianDate() != null)
			{
				if(caseInsensitive)
					retVal = this.getJulianDate().toLowerCase().compareTo(compareObj.getJulianDate().toLowerCase());
				else
					retVal = this.getJulianDate().compareTo(compareObj.getJulianDate());
			}
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
		if(this.carecontextrefvo != null)
			count++;
		if(this.responsiblehcpname != null)
			count++;
		if(this.ward != null)
			count++;
		if(this.dischargedate != null)
			count++;
		if(this.patientname != null)
			count++;
		if(this.patienthospnum != null)
			count++;
		if(this.letterstatus != null)
			count++;
		if(this.issummaryrecordcomplete != null)
			count++;
		if(this.juliandate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.core.admin.vo.CareContextRefVo carecontextrefvo;
	protected String responsiblehcpname;
	protected String ward;
	protected ims.framework.utils.Date dischargedate;
	protected String patientname;
	protected String patienthospnum;
	protected String letterstatus;
	protected Boolean issummaryrecordcomplete;
	protected String juliandate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
