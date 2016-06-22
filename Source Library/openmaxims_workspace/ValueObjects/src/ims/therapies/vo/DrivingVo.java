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

package ims.therapies.vo;

/**
 * Linked to therapies.workLeisureDriving.Driving business object (ID: 1019100032).
 */
public class DrivingVo extends ims.therapies.workleisuredriving.vo.DrivingRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DrivingVo()
	{
	}
	public DrivingVo(Integer id, int version)
	{
		super(id, version);
	}
	public DrivingVo(ims.therapies.vo.beans.DrivingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo();
		this.drivingcommenceddate = bean.getDrivingCommencedDate() == null ? null : bean.getDrivingCommencedDate().buildPartialDate();
		this.vehicletype = bean.getVehicleType();
		this.specialistinfoequip = bean.getSpecialistInfoEquip();
		this.drivingaspect = ims.therapies.vo.DrivingAspectVoCollection.buildFromBeanCollection(bean.getDrivingAspect());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.DrivingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo(map);
		this.drivingcommenceddate = bean.getDrivingCommencedDate() == null ? null : bean.getDrivingCommencedDate().buildPartialDate();
		this.vehicletype = bean.getVehicleType();
		this.specialistinfoequip = bean.getSpecialistInfoEquip();
		this.drivingaspect = ims.therapies.vo.DrivingAspectVoCollection.buildFromBeanCollection(bean.getDrivingAspect());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.DrivingVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.DrivingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.DrivingVoBean();
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
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("AUTHORINGDATETIME"))
			return getAuthoringDateTime();
		if(fieldName.equals("AUTHORINGCP"))
			return getAuthoringCP();
		if(fieldName.equals("DRIVINGCOMMENCEDDATE"))
			return getDrivingCommencedDate();
		if(fieldName.equals("VEHICLETYPE"))
			return getVehicleType();
		if(fieldName.equals("SPECIALISTINFOEQUIP"))
			return getSpecialistInfoEquip();
		if(fieldName.equals("DRIVINGASPECT"))
			return getDrivingAspect();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getAuthoringDateTimeIsNotNull()
	{
		return this.authoringdatetime != null;
	}
	public ims.framework.utils.DateTime getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.authoringdatetime = value;
	}
	public boolean getAuthoringCPIsNotNull()
	{
		return this.authoringcp != null;
	}
	public ims.core.vo.Hcp getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.authoringcp = value;
	}
	public boolean getDrivingCommencedDateIsNotNull()
	{
		return this.drivingcommenceddate != null;
	}
	public ims.framework.utils.PartialDate getDrivingCommencedDate()
	{
		return this.drivingcommenceddate;
	}
	public void setDrivingCommencedDate(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.drivingcommenceddate = value;
	}
	public boolean getVehicleTypeIsNotNull()
	{
		return this.vehicletype != null;
	}
	public String getVehicleType()
	{
		return this.vehicletype;
	}
	public static int getVehicleTypeMaxLength()
	{
		return 100;
	}
	public void setVehicleType(String value)
	{
		this.isValidated = false;
		this.vehicletype = value;
	}
	public boolean getSpecialistInfoEquipIsNotNull()
	{
		return this.specialistinfoequip != null;
	}
	public String getSpecialistInfoEquip()
	{
		return this.specialistinfoequip;
	}
	public static int getSpecialistInfoEquipMaxLength()
	{
		return 1000;
	}
	public void setSpecialistInfoEquip(String value)
	{
		this.isValidated = false;
		this.specialistinfoequip = value;
	}
	public boolean getDrivingAspectIsNotNull()
	{
		return this.drivingaspect != null;
	}
	public ims.therapies.vo.DrivingAspectVoCollection getDrivingAspect()
	{
		return this.drivingaspect;
	}
	public void setDrivingAspect(ims.therapies.vo.DrivingAspectVoCollection value)
	{
		this.isValidated = false;
		this.drivingaspect = value;
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
		if(this.authoringcp != null)
		{
			if(!this.authoringcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.drivingaspect != null)
		{
			if(!this.drivingaspect.isValidated())
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.authoringdatetime == null)
			listOfErrors.add("Please enter Authoring Date Time. ");
		if(this.authoringcp == null)
			listOfErrors.add("Please enter Authoring CP.");
		if(this.authoringcp != null)
		{
			String[] listOfOtherErrors = this.authoringcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.vehicletype != null)
			if(this.vehicletype.length() > 100)
				listOfErrors.add("The length of the field [vehicletype] in the value object [ims.therapies.vo.DrivingVo] is too big. It should be less or equal to 100");
		if(this.specialistinfoequip != null)
			if(this.specialistinfoequip.length() > 1000)
				listOfErrors.add("The length of the field [specialistinfoequip] in the value object [ims.therapies.vo.DrivingVo] is too big. It should be less or equal to 1000");
		if(this.drivingaspect != null)
		{
			String[] listOfOtherErrors = this.drivingaspect.validate();
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
	
		DrivingVo clone = new DrivingVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		if(this.authoringcp == null)
			clone.authoringcp = null;
		else
			clone.authoringcp = (ims.core.vo.Hcp)this.authoringcp.clone();
		if(this.drivingcommenceddate == null)
			clone.drivingcommenceddate = null;
		else
			clone.drivingcommenceddate = (ims.framework.utils.PartialDate)this.drivingcommenceddate.clone();
		clone.vehicletype = this.vehicletype;
		clone.specialistinfoequip = this.specialistinfoequip;
		if(this.drivingaspect == null)
			clone.drivingaspect = null;
		else
			clone.drivingaspect = (ims.therapies.vo.DrivingAspectVoCollection)this.drivingaspect.clone();
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
		if (!(DrivingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DrivingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		DrivingVo compareObj = (DrivingVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_Driving() == null && compareObj.getID_Driving() != null)
				return -1;
			if(this.getID_Driving() != null && compareObj.getID_Driving() == null)
				return 1;
			if(this.getID_Driving() != null && compareObj.getID_Driving() != null)
				retVal = this.getID_Driving().compareTo(compareObj.getID_Driving());
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
		if(this.carecontext != null)
			count++;
		if(this.authoringdatetime != null)
			count++;
		if(this.authoringcp != null)
			count++;
		if(this.drivingcommenceddate != null)
			count++;
		if(this.vehicletype != null)
			count++;
		if(this.specialistinfoequip != null)
			count++;
		if(this.drivingaspect != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.framework.utils.DateTime authoringdatetime;
	protected ims.core.vo.Hcp authoringcp;
	protected ims.framework.utils.PartialDate drivingcommenceddate;
	protected String vehicletype;
	protected String specialistinfoequip;
	protected ims.therapies.vo.DrivingAspectVoCollection drivingaspect;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
