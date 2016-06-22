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
 * Linked to core.admin.pas.WardBayClosingDetails business object (ID: 1014100022).
 */
public class WardBayClosingDetailsVo extends ims.core.admin.pas.vo.WardBayClosingDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WardBayClosingDetailsVo()
	{
	}
	public WardBayClosingDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public WardBayClosingDetailsVo(ims.core.vo.beans.WardBayClosingDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.closedby = bean.getClosedBy() == null ? null : bean.getClosedBy().buildVo();
		this.closuredate = bean.getClosureDate() == null ? null : bean.getClosureDate().buildDateTime();
		this.reasonforclosure = bean.getReasonForClosure() == null ? null : ims.core.vo.lookups.WardBayClosingReason.buildLookup(bean.getReasonForClosure());
		this.estimatedreopeningdate = bean.getEstimatedReopeningDate() == null ? null : bean.getEstimatedReopeningDate().buildDateTime();
		this.reopenreason = bean.getReopenReason() == null ? null : ims.core.vo.lookups.WardBayReopenReason.buildLookup(bean.getReopenReason());
		this.reopendate = bean.getReopenDate() == null ? null : bean.getReopenDate().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.WardBayClosingDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.closedby = bean.getClosedBy() == null ? null : bean.getClosedBy().buildVo(map);
		this.closuredate = bean.getClosureDate() == null ? null : bean.getClosureDate().buildDateTime();
		this.reasonforclosure = bean.getReasonForClosure() == null ? null : ims.core.vo.lookups.WardBayClosingReason.buildLookup(bean.getReasonForClosure());
		this.estimatedreopeningdate = bean.getEstimatedReopeningDate() == null ? null : bean.getEstimatedReopeningDate().buildDateTime();
		this.reopenreason = bean.getReopenReason() == null ? null : ims.core.vo.lookups.WardBayReopenReason.buildLookup(bean.getReopenReason());
		this.reopendate = bean.getReopenDate() == null ? null : bean.getReopenDate().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.WardBayClosingDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.WardBayClosingDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.WardBayClosingDetailsVoBean();
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
		if(fieldName.equals("CLOSEDBY"))
			return getClosedBy();
		if(fieldName.equals("CLOSUREDATE"))
			return getClosureDate();
		if(fieldName.equals("REASONFORCLOSURE"))
			return getReasonForClosure();
		if(fieldName.equals("ESTIMATEDREOPENINGDATE"))
			return getEstimatedReopeningDate();
		if(fieldName.equals("REOPENREASON"))
			return getReopenReason();
		if(fieldName.equals("REOPENDATE"))
			return getReopenDate();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getClosedByIsNotNull()
	{
		return this.closedby != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getClosedBy()
	{
		return this.closedby;
	}
	public void setClosedBy(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.closedby = value;
	}
	public boolean getClosureDateIsNotNull()
	{
		return this.closuredate != null;
	}
	public ims.framework.utils.DateTime getClosureDate()
	{
		return this.closuredate;
	}
	public void setClosureDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.closuredate = value;
	}
	public boolean getReasonForClosureIsNotNull()
	{
		return this.reasonforclosure != null;
	}
	public ims.core.vo.lookups.WardBayClosingReason getReasonForClosure()
	{
		return this.reasonforclosure;
	}
	public void setReasonForClosure(ims.core.vo.lookups.WardBayClosingReason value)
	{
		this.isValidated = false;
		this.reasonforclosure = value;
	}
	public boolean getEstimatedReopeningDateIsNotNull()
	{
		return this.estimatedreopeningdate != null;
	}
	public ims.framework.utils.DateTime getEstimatedReopeningDate()
	{
		return this.estimatedreopeningdate;
	}
	public void setEstimatedReopeningDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.estimatedreopeningdate = value;
	}
	public boolean getReopenReasonIsNotNull()
	{
		return this.reopenreason != null;
	}
	public ims.core.vo.lookups.WardBayReopenReason getReopenReason()
	{
		return this.reopenreason;
	}
	public void setReopenReason(ims.core.vo.lookups.WardBayReopenReason value)
	{
		this.isValidated = false;
		this.reopenreason = value;
	}
	public boolean getReopenDateIsNotNull()
	{
		return this.reopendate != null;
	}
	public ims.framework.utils.DateTime getReopenDate()
	{
		return this.reopendate;
	}
	public void setReopenDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.reopendate = value;
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
		if(this.closedby == null)
			listOfErrors.add("Closed By is mandatory");
		if(this.closuredate == null)
			listOfErrors.add("Closure Date/Time is mandatory");
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
	
		WardBayClosingDetailsVo clone = new WardBayClosingDetailsVo(this.id, this.version);
		
		if(this.closedby == null)
			clone.closedby = null;
		else
			clone.closedby = (ims.core.vo.MemberOfStaffLiteVo)this.closedby.clone();
		if(this.closuredate == null)
			clone.closuredate = null;
		else
			clone.closuredate = (ims.framework.utils.DateTime)this.closuredate.clone();
		if(this.reasonforclosure == null)
			clone.reasonforclosure = null;
		else
			clone.reasonforclosure = (ims.core.vo.lookups.WardBayClosingReason)this.reasonforclosure.clone();
		if(this.estimatedreopeningdate == null)
			clone.estimatedreopeningdate = null;
		else
			clone.estimatedreopeningdate = (ims.framework.utils.DateTime)this.estimatedreopeningdate.clone();
		if(this.reopenreason == null)
			clone.reopenreason = null;
		else
			clone.reopenreason = (ims.core.vo.lookups.WardBayReopenReason)this.reopenreason.clone();
		if(this.reopendate == null)
			clone.reopendate = null;
		else
			clone.reopendate = (ims.framework.utils.DateTime)this.reopendate.clone();
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
		if (!(WardBayClosingDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WardBayClosingDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((WardBayClosingDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((WardBayClosingDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.closedby != null)
			count++;
		if(this.closuredate != null)
			count++;
		if(this.reasonforclosure != null)
			count++;
		if(this.estimatedreopeningdate != null)
			count++;
		if(this.reopenreason != null)
			count++;
		if(this.reopendate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.vo.MemberOfStaffLiteVo closedby;
	protected ims.framework.utils.DateTime closuredate;
	protected ims.core.vo.lookups.WardBayClosingReason reasonforclosure;
	protected ims.framework.utils.DateTime estimatedreopeningdate;
	protected ims.core.vo.lookups.WardBayReopenReason reopenreason;
	protected ims.framework.utils.DateTime reopendate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
