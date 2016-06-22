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


public class PendingTransfersFilterVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PendingTransfersFilterVo()
	{
	}
	public PendingTransfersFilterVo(ims.core.vo.beans.PendingTransfersFilterVoBean bean)
	{
		this.patientforename = bean.getPatientForename();
		this.patientsurname = bean.getPatientSurname();
		this.patienthospnumber = bean.getPatientHospNumber();
		this.currentward = bean.getCurrentWard() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getCurrentWard().getId()), bean.getCurrentWard().getVersion());
		this.destinationward = bean.getDestinationWard() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getDestinationWard().getId()), bean.getDestinationWard().getVersion());
		this.alert = bean.getAlert() == null ? null : ims.core.vo.lookups.AlertType.buildLookup(bean.getAlert());
		this.consultant = bean.getConsultant() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getConsultant().getId()), bean.getConsultant().getVersion());
		this.currenthospital = bean.getCurrentHospital() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getCurrentHospital().getId()), bean.getCurrentHospital().getVersion());
		this.desthospital = bean.getDestHospital() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getDestHospital().getId()), bean.getDestHospital().getVersion());
		this.pendingtransfer = bean.getPendingTransfer();
		this.idtype = bean.getIDType() == null ? null : ims.core.vo.lookups.PatIdType.buildLookup(bean.getIDType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PendingTransfersFilterVoBean bean)
	{
		this.patientforename = bean.getPatientForename();
		this.patientsurname = bean.getPatientSurname();
		this.patienthospnumber = bean.getPatientHospNumber();
		this.currentward = bean.getCurrentWard() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getCurrentWard().getId()), bean.getCurrentWard().getVersion());
		this.destinationward = bean.getDestinationWard() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getDestinationWard().getId()), bean.getDestinationWard().getVersion());
		this.alert = bean.getAlert() == null ? null : ims.core.vo.lookups.AlertType.buildLookup(bean.getAlert());
		this.consultant = bean.getConsultant() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getConsultant().getId()), bean.getConsultant().getVersion());
		this.currenthospital = bean.getCurrentHospital() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getCurrentHospital().getId()), bean.getCurrentHospital().getVersion());
		this.desthospital = bean.getDestHospital() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getDestHospital().getId()), bean.getDestHospital().getVersion());
		this.pendingtransfer = bean.getPendingTransfer();
		this.idtype = bean.getIDType() == null ? null : ims.core.vo.lookups.PatIdType.buildLookup(bean.getIDType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PendingTransfersFilterVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PendingTransfersFilterVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PendingTransfersFilterVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getPatientForenameIsNotNull()
	{
		return this.patientforename != null;
	}
	public String getPatientForename()
	{
		return this.patientforename;
	}
	public static int getPatientForenameMaxLength()
	{
		return 255;
	}
	public void setPatientForename(String value)
	{
		this.isValidated = false;
		this.patientforename = value;
	}
	public boolean getPatientSurnameIsNotNull()
	{
		return this.patientsurname != null;
	}
	public String getPatientSurname()
	{
		return this.patientsurname;
	}
	public static int getPatientSurnameMaxLength()
	{
		return 255;
	}
	public void setPatientSurname(String value)
	{
		this.isValidated = false;
		this.patientsurname = value;
	}
	public boolean getPatientHospNumberIsNotNull()
	{
		return this.patienthospnumber != null;
	}
	public String getPatientHospNumber()
	{
		return this.patienthospnumber;
	}
	public static int getPatientHospNumberMaxLength()
	{
		return 255;
	}
	public void setPatientHospNumber(String value)
	{
		this.isValidated = false;
		this.patienthospnumber = value;
	}
	public boolean getCurrentWardIsNotNull()
	{
		return this.currentward != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getCurrentWard()
	{
		return this.currentward;
	}
	public void setCurrentWard(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.currentward = value;
	}
	public boolean getDestinationWardIsNotNull()
	{
		return this.destinationward != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getDestinationWard()
	{
		return this.destinationward;
	}
	public void setDestinationWard(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.destinationward = value;
	}
	public boolean getAlertIsNotNull()
	{
		return this.alert != null;
	}
	public ims.core.vo.lookups.AlertType getAlert()
	{
		return this.alert;
	}
	public void setAlert(ims.core.vo.lookups.AlertType value)
	{
		this.isValidated = false;
		this.alert = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.core.resource.people.vo.HcpRefVo getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.resource.people.vo.HcpRefVo value)
	{
		this.isValidated = false;
		this.consultant = value;
	}
	public boolean getCurrentHospitalIsNotNull()
	{
		return this.currenthospital != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getCurrentHospital()
	{
		return this.currenthospital;
	}
	public void setCurrentHospital(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.currenthospital = value;
	}
	public boolean getDestHospitalIsNotNull()
	{
		return this.desthospital != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getDestHospital()
	{
		return this.desthospital;
	}
	public void setDestHospital(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.desthospital = value;
	}
	public boolean getPendingTransferIsNotNull()
	{
		return this.pendingtransfer != null;
	}
	public Boolean getPendingTransfer()
	{
		return this.pendingtransfer;
	}
	public void setPendingTransfer(Boolean value)
	{
		this.isValidated = false;
		this.pendingtransfer = value;
	}
	public boolean getIDTypeIsNotNull()
	{
		return this.idtype != null;
	}
	public ims.core.vo.lookups.PatIdType getIDType()
	{
		return this.idtype;
	}
	public void setIDType(ims.core.vo.lookups.PatIdType value)
	{
		this.isValidated = false;
		this.idtype = value;
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
		if(!(obj instanceof PendingTransfersFilterVo))
			return false;
		PendingTransfersFilterVo compareObj = (PendingTransfersFilterVo)obj;
		if(this.getPatientForename() == null && compareObj.getPatientForename() != null)
			return false;
		if(this.getPatientForename() != null && compareObj.getPatientForename() == null)
			return false;
		if(this.getPatientForename() != null && compareObj.getPatientForename() != null)
			return this.getPatientForename().equals(compareObj.getPatientForename());
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
	
		PendingTransfersFilterVo clone = new PendingTransfersFilterVo();
		
		clone.patientforename = this.patientforename;
		clone.patientsurname = this.patientsurname;
		clone.patienthospnumber = this.patienthospnumber;
		clone.currentward = this.currentward;
		clone.destinationward = this.destinationward;
		if(this.alert == null)
			clone.alert = null;
		else
			clone.alert = (ims.core.vo.lookups.AlertType)this.alert.clone();
		clone.consultant = this.consultant;
		clone.currenthospital = this.currenthospital;
		clone.desthospital = this.desthospital;
		clone.pendingtransfer = this.pendingtransfer;
		if(this.idtype == null)
			clone.idtype = null;
		else
			clone.idtype = (ims.core.vo.lookups.PatIdType)this.idtype.clone();
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
		if (!(PendingTransfersFilterVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PendingTransfersFilterVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PendingTransfersFilterVo compareObj = (PendingTransfersFilterVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getPatientForename() == null && compareObj.getPatientForename() != null)
				return -1;
			if(this.getPatientForename() != null && compareObj.getPatientForename() == null)
				return 1;
			if(this.getPatientForename() != null && compareObj.getPatientForename() != null)
			{
				if(caseInsensitive)
					retVal = this.getPatientForename().toLowerCase().compareTo(compareObj.getPatientForename().toLowerCase());
				else
					retVal = this.getPatientForename().compareTo(compareObj.getPatientForename());
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
		if(this.patientforename != null)
			count++;
		if(this.patientsurname != null)
			count++;
		if(this.patienthospnumber != null)
			count++;
		if(this.currentward != null)
			count++;
		if(this.destinationward != null)
			count++;
		if(this.alert != null)
			count++;
		if(this.consultant != null)
			count++;
		if(this.currenthospital != null)
			count++;
		if(this.desthospital != null)
			count++;
		if(this.pendingtransfer != null)
			count++;
		if(this.idtype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected String patientforename;
	protected String patientsurname;
	protected String patienthospnumber;
	protected ims.core.resource.place.vo.LocationRefVo currentward;
	protected ims.core.resource.place.vo.LocationRefVo destinationward;
	protected ims.core.vo.lookups.AlertType alert;
	protected ims.core.resource.people.vo.HcpRefVo consultant;
	protected ims.core.resource.place.vo.LocationRefVo currenthospital;
	protected ims.core.resource.place.vo.LocationRefVo desthospital;
	protected Boolean pendingtransfer;
	protected ims.core.vo.lookups.PatIdType idtype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
