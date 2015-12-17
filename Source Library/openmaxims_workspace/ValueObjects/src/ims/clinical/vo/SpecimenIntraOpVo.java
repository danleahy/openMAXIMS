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

/**
 * Linked to clinical.SpecimenIntraOp business object (ID: 1072100143).
 */
public class SpecimenIntraOpVo extends ims.clinical.vo.SpecimenIntraOpRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SpecimenIntraOpVo()
	{
	}
	public SpecimenIntraOpVo(Integer id, int version)
	{
		super(id, version);
	}
	public SpecimenIntraOpVo(ims.clinical.vo.beans.SpecimenIntraOpVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.theatreappointment = bean.getTheatreAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getTheatreAppointment().getId()), bean.getTheatreAppointment().getVersion());
		this.patientprocedure = bean.getPatientProcedure() == null ? null : bean.getPatientProcedure().buildVo();
		this.specimendestination = bean.getSpecimenDestination() == null ? null : ims.clinical.vo.lookups.SpecimenDestinationIntraOp.buildLookup(bean.getSpecimenDestination());
		this.other = bean.getOther();
		this.details = bean.getDetails();
		this.noofspecimens = bean.getNoOfSpecimens();
		this.isdirect = bean.getIsDirect();
		this.isindirect = bean.getIsIndirect();
		this.typecomments = bean.getTypeComments();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.SpecimenIntraOpVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.theatreappointment = bean.getTheatreAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getTheatreAppointment().getId()), bean.getTheatreAppointment().getVersion());
		this.patientprocedure = bean.getPatientProcedure() == null ? null : bean.getPatientProcedure().buildVo(map);
		this.specimendestination = bean.getSpecimenDestination() == null ? null : ims.clinical.vo.lookups.SpecimenDestinationIntraOp.buildLookup(bean.getSpecimenDestination());
		this.other = bean.getOther();
		this.details = bean.getDetails();
		this.noofspecimens = bean.getNoOfSpecimens();
		this.isdirect = bean.getIsDirect();
		this.isindirect = bean.getIsIndirect();
		this.typecomments = bean.getTypeComments();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.SpecimenIntraOpVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.SpecimenIntraOpVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.SpecimenIntraOpVoBean();
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
		if(fieldName.equals("THEATREAPPOINTMENT"))
			return getTheatreAppointment();
		if(fieldName.equals("PATIENTPROCEDURE"))
			return getPatientProcedure();
		if(fieldName.equals("SPECIMENDESTINATION"))
			return getSpecimenDestination();
		if(fieldName.equals("OTHER"))
			return getOther();
		if(fieldName.equals("DETAILS"))
			return getDetails();
		if(fieldName.equals("NOOFSPECIMENS"))
			return getNoOfSpecimens();
		if(fieldName.equals("ISDIRECT"))
			return getIsDirect();
		if(fieldName.equals("ISINDIRECT"))
			return getIsIndirect();
		if(fieldName.equals("TYPECOMMENTS"))
			return getTypeComments();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTheatreAppointmentIsNotNull()
	{
		return this.theatreappointment != null;
	}
	public ims.scheduling.vo.Booking_AppointmentRefVo getTheatreAppointment()
	{
		return this.theatreappointment;
	}
	public void setTheatreAppointment(ims.scheduling.vo.Booking_AppointmentRefVo value)
	{
		this.isValidated = false;
		this.theatreappointment = value;
	}
	public boolean getPatientProcedureIsNotNull()
	{
		return this.patientprocedure != null;
	}
	public ims.core.vo.PatientProcedureMinVo getPatientProcedure()
	{
		return this.patientprocedure;
	}
	public void setPatientProcedure(ims.core.vo.PatientProcedureMinVo value)
	{
		this.isValidated = false;
		this.patientprocedure = value;
	}
	public boolean getSpecimenDestinationIsNotNull()
	{
		return this.specimendestination != null;
	}
	public ims.clinical.vo.lookups.SpecimenDestinationIntraOp getSpecimenDestination()
	{
		return this.specimendestination;
	}
	public void setSpecimenDestination(ims.clinical.vo.lookups.SpecimenDestinationIntraOp value)
	{
		this.isValidated = false;
		this.specimendestination = value;
	}
	public boolean getOtherIsNotNull()
	{
		return this.other != null;
	}
	public Boolean getOther()
	{
		return this.other;
	}
	public void setOther(Boolean value)
	{
		this.isValidated = false;
		this.other = value;
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
		return 100;
	}
	public void setDetails(String value)
	{
		this.isValidated = false;
		this.details = value;
	}
	public boolean getNoOfSpecimensIsNotNull()
	{
		return this.noofspecimens != null;
	}
	public Integer getNoOfSpecimens()
	{
		return this.noofspecimens;
	}
	public void setNoOfSpecimens(Integer value)
	{
		this.isValidated = false;
		this.noofspecimens = value;
	}
	public boolean getIsDirectIsNotNull()
	{
		return this.isdirect != null;
	}
	public Boolean getIsDirect()
	{
		return this.isdirect;
	}
	public void setIsDirect(Boolean value)
	{
		this.isValidated = false;
		this.isdirect = value;
	}
	public boolean getIsIndirectIsNotNull()
	{
		return this.isindirect != null;
	}
	public Boolean getIsIndirect()
	{
		return this.isindirect;
	}
	public void setIsIndirect(Boolean value)
	{
		this.isValidated = false;
		this.isindirect = value;
	}
	public boolean getTypeCommentsIsNotNull()
	{
		return this.typecomments != null;
	}
	public String getTypeComments()
	{
		return this.typecomments;
	}
	public static int getTypeCommentsMaxLength()
	{
		return 2000;
	}
	public void setTypeComments(String value)
	{
		this.isValidated = false;
		this.typecomments = value;
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
		if(this.theatreappointment == null)
			listOfErrors.add("TheatreAppointment is mandatory");
		if(this.patientprocedure == null)
			listOfErrors.add("Procedure is mandatory");
		if(this.details != null)
			if(this.details.length() > 100)
				listOfErrors.add("The length of the field [details] in the value object [ims.clinical.vo.SpecimenIntraOpVo] is too big. It should be less or equal to 100");
		if(this.noofspecimens == null)
			listOfErrors.add("No Of Specimens is mandatory");
		if(this.isdirect == null)
			listOfErrors.add("Direct is mandatory");
		if(this.isindirect == null)
			listOfErrors.add("Indirect is mandatory");
		if(this.typecomments == null || this.typecomments.length() == 0)
			listOfErrors.add("Type Comments is mandatory");
		else if(this.typecomments.length() > 2000)
			listOfErrors.add("The length of the field [typecomments] in the value object [ims.clinical.vo.SpecimenIntraOpVo] is too big. It should be less or equal to 2000");
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
	
		SpecimenIntraOpVo clone = new SpecimenIntraOpVo(this.id, this.version);
		
		clone.theatreappointment = this.theatreappointment;
		if(this.patientprocedure == null)
			clone.patientprocedure = null;
		else
			clone.patientprocedure = (ims.core.vo.PatientProcedureMinVo)this.patientprocedure.clone();
		if(this.specimendestination == null)
			clone.specimendestination = null;
		else
			clone.specimendestination = (ims.clinical.vo.lookups.SpecimenDestinationIntraOp)this.specimendestination.clone();
		clone.other = this.other;
		clone.details = this.details;
		clone.noofspecimens = this.noofspecimens;
		clone.isdirect = this.isdirect;
		clone.isindirect = this.isindirect;
		clone.typecomments = this.typecomments;
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
		if (!(SpecimenIntraOpVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SpecimenIntraOpVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SpecimenIntraOpVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SpecimenIntraOpVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.theatreappointment != null)
			count++;
		if(this.patientprocedure != null)
			count++;
		if(this.specimendestination != null)
			count++;
		if(this.other != null)
			count++;
		if(this.details != null)
			count++;
		if(this.noofspecimens != null)
			count++;
		if(this.isdirect != null)
			count++;
		if(this.isindirect != null)
			count++;
		if(this.typecomments != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.scheduling.vo.Booking_AppointmentRefVo theatreappointment;
	protected ims.core.vo.PatientProcedureMinVo patientprocedure;
	protected ims.clinical.vo.lookups.SpecimenDestinationIntraOp specimendestination;
	protected Boolean other;
	protected String details;
	protected Integer noofspecimens;
	protected Boolean isdirect;
	protected Boolean isindirect;
	protected String typecomments;
	private boolean isValidated = false;
	private boolean isBusy = false;
}