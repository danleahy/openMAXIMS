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

package ims.pci.vo;

/**
 * Linked to PCI.GpContract business object (ID: 1091100000).
 */
public class GpContractVo extends ims.pci.vo.GpContractRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public GpContractVo()
	{
	}
	public GpContractVo(Integer id, int version)
	{
		super(id, version);
	}
	public GpContractVo(ims.pci.vo.beans.GpContractVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.gp = bean.getGP() == null ? null : bean.getGP().buildVo();
		this.contractid = bean.getContractId();
		this.contractstartdate = bean.getContractStartDate() == null ? null : bean.getContractStartDate().buildDate();
		this.contractenddate = bean.getContractEndDate() == null ? null : bean.getContractEndDate().buildDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pci.vo.beans.GpContractVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.gp = bean.getGP() == null ? null : bean.getGP().buildVo(map);
		this.contractid = bean.getContractId();
		this.contractstartdate = bean.getContractStartDate() == null ? null : bean.getContractStartDate().buildDate();
		this.contractenddate = bean.getContractEndDate() == null ? null : bean.getContractEndDate().buildDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pci.vo.beans.GpContractVoBean bean = null;
		if(map != null)
			bean = (ims.pci.vo.beans.GpContractVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pci.vo.beans.GpContractVoBean();
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
		if(fieldName.equals("GP"))
			return getGP();
		if(fieldName.equals("CONTRACTID"))
			return getContractId();
		if(fieldName.equals("CONTRACTSTARTDATE"))
			return getContractStartDate();
		if(fieldName.equals("CONTRACTENDDATE"))
			return getContractEndDate();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getGPIsNotNull()
	{
		return this.gp != null;
	}
	public ims.core.vo.GpLiteWithNameVo getGP()
	{
		return this.gp;
	}
	public void setGP(ims.core.vo.GpLiteWithNameVo value)
	{
		this.isValidated = false;
		this.gp = value;
	}
	public boolean getContractIdIsNotNull()
	{
		return this.contractid != null;
	}
	public String getContractId()
	{
		return this.contractid;
	}
	public static int getContractIdMaxLength()
	{
		return 50;
	}
	public void setContractId(String value)
	{
		this.isValidated = false;
		this.contractid = value;
	}
	public boolean getContractStartDateIsNotNull()
	{
		return this.contractstartdate != null;
	}
	public ims.framework.utils.Date getContractStartDate()
	{
		return this.contractstartdate;
	}
	public void setContractStartDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.contractstartdate = value;
	}
	public boolean getContractEndDateIsNotNull()
	{
		return this.contractenddate != null;
	}
	public ims.framework.utils.Date getContractEndDate()
	{
		return this.contractenddate;
	}
	public void setContractEndDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.contractenddate = value;
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
		if(this.gp == null)
			listOfErrors.add("GP is mandatory");
		if(this.contractid == null || this.contractid.length() == 0)
			listOfErrors.add("ContractId is mandatory");
		else if(this.contractid.length() > 50)
			listOfErrors.add("The length of the field [contractid] in the value object [ims.pci.vo.GpContractVo] is too big. It should be less or equal to 50");
		if(this.contractstartdate == null)
			listOfErrors.add("ContractStartDate is mandatory");
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
	
		GpContractVo clone = new GpContractVo(this.id, this.version);
		
		if(this.gp == null)
			clone.gp = null;
		else
			clone.gp = (ims.core.vo.GpLiteWithNameVo)this.gp.clone();
		clone.contractid = this.contractid;
		if(this.contractstartdate == null)
			clone.contractstartdate = null;
		else
			clone.contractstartdate = (ims.framework.utils.Date)this.contractstartdate.clone();
		if(this.contractenddate == null)
			clone.contractenddate = null;
		else
			clone.contractenddate = (ims.framework.utils.Date)this.contractenddate.clone();
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
		if (!(GpContractVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A GpContractVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((GpContractVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((GpContractVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.gp != null)
			count++;
		if(this.contractid != null)
			count++;
		if(this.contractstartdate != null)
			count++;
		if(this.contractenddate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.GpLiteWithNameVo gp;
	protected String contractid;
	protected ims.framework.utils.Date contractstartdate;
	protected ims.framework.utils.Date contractenddate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
