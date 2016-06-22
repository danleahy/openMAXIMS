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

package ims.emergency.vo;

/**
 * Linked to emergency.DischargeServicesAndAdvice business object (ID: 1086100026).
 */
public class DischargeServicesAndAdviceForDischargePlanningVo extends ims.emergency.vo.DischargeServicesAndAdviceRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DischargeServicesAndAdviceForDischargePlanningVo()
	{
	}
	public DischargeServicesAndAdviceForDischargePlanningVo(Integer id, int version)
	{
		super(id, version);
	}
	public DischargeServicesAndAdviceForDischargePlanningVo(ims.emergency.vo.beans.DischargeServicesAndAdviceForDischargePlanningVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.supportnetworkfamily = ims.core.vo.SupportNetworkFamilyCollection.buildFromBeanCollection(bean.getSupportNetworkFamily());
		this.supportnetworkprofessionals = ims.core.vo.SupportNetworkProfessionalVoCollection.buildFromBeanCollection(bean.getSupportNetworkProfessionals());
		this.supportnetworkservices = ims.core.vo.SupportNetworkServicesVoCollection.buildFromBeanCollection(bean.getSupportNetworkServices());
		this.patientmobility = ims.core.vo.lookups.PatientMobilityCollection.buildFromBeanCollection(bean.getPatientMobility());
		this.transportarrangedtype = bean.getTransportArrangedType() == null ? null : ims.scheduling.vo.lookups.ApptTransportType.buildLookup(bean.getTransportArrangedType());
		this.transportdatetime = bean.getTransportDateTime() == null ? null : bean.getTransportDateTime().buildDateTime();
		this.comments = bean.getComments();
		this.bookingno = bean.getBookingNo();
		this.adviceleafletsprinted = ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVoCollection.buildFromBeanCollection(bean.getAdviceLeafletsPrinted());
		this.equipment = ims.emergency.vo.lookups.DischargequipmentCollection.buildFromBeanCollection(bean.getEquipment());
		this.preprintedadviceleafletsgiven = ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVoCollection.buildFromBeanCollection(bean.getPrePrintedAdviceLeafletsGiven());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.DischargeServicesAndAdviceForDischargePlanningVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.supportnetworkfamily = ims.core.vo.SupportNetworkFamilyCollection.buildFromBeanCollection(bean.getSupportNetworkFamily());
		this.supportnetworkprofessionals = ims.core.vo.SupportNetworkProfessionalVoCollection.buildFromBeanCollection(bean.getSupportNetworkProfessionals());
		this.supportnetworkservices = ims.core.vo.SupportNetworkServicesVoCollection.buildFromBeanCollection(bean.getSupportNetworkServices());
		this.patientmobility = ims.core.vo.lookups.PatientMobilityCollection.buildFromBeanCollection(bean.getPatientMobility());
		this.transportarrangedtype = bean.getTransportArrangedType() == null ? null : ims.scheduling.vo.lookups.ApptTransportType.buildLookup(bean.getTransportArrangedType());
		this.transportdatetime = bean.getTransportDateTime() == null ? null : bean.getTransportDateTime().buildDateTime();
		this.comments = bean.getComments();
		this.bookingno = bean.getBookingNo();
		this.adviceleafletsprinted = ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVoCollection.buildFromBeanCollection(bean.getAdviceLeafletsPrinted());
		this.equipment = ims.emergency.vo.lookups.DischargequipmentCollection.buildFromBeanCollection(bean.getEquipment());
		this.preprintedadviceleafletsgiven = ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVoCollection.buildFromBeanCollection(bean.getPrePrintedAdviceLeafletsGiven());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.DischargeServicesAndAdviceForDischargePlanningVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.DischargeServicesAndAdviceForDischargePlanningVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.DischargeServicesAndAdviceForDischargePlanningVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("EPISODE"))
			return getEpisode();
		if(fieldName.equals("ATTENDANCE"))
			return getAttendance();
		if(fieldName.equals("SUPPORTNETWORKFAMILY"))
			return getSupportNetworkFamily();
		if(fieldName.equals("SUPPORTNETWORKPROFESSIONALS"))
			return getSupportNetworkProfessionals();
		if(fieldName.equals("SUPPORTNETWORKSERVICES"))
			return getSupportNetworkServices();
		if(fieldName.equals("PATIENTMOBILITY"))
			return getPatientMobility();
		if(fieldName.equals("TRANSPORTARRANGEDTYPE"))
			return getTransportArrangedType();
		if(fieldName.equals("TRANSPORTDATETIME"))
			return getTransportDateTime();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("BOOKINGNO"))
			return getBookingNo();
		if(fieldName.equals("ADVICELEAFLETSPRINTED"))
			return getAdviceLeafletsPrinted();
		if(fieldName.equals("EQUIPMENT"))
			return getEquipment();
		if(fieldName.equals("PREPRINTEDADVICELEAFLETSGIVEN"))
			return getPrePrintedAdviceLeafletsGiven();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getEpisodeIsNotNull()
	{
		return this.episode != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episode = value;
	}
	public boolean getAttendanceIsNotNull()
	{
		return this.attendance != null;
	}
	public ims.core.admin.vo.CareContextRefVo getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.attendance = value;
	}
	public boolean getSupportNetworkFamilyIsNotNull()
	{
		return this.supportnetworkfamily != null;
	}
	public ims.core.vo.SupportNetworkFamilyCollection getSupportNetworkFamily()
	{
		return this.supportnetworkfamily;
	}
	public void setSupportNetworkFamily(ims.core.vo.SupportNetworkFamilyCollection value)
	{
		this.isValidated = false;
		this.supportnetworkfamily = value;
	}
	public boolean getSupportNetworkProfessionalsIsNotNull()
	{
		return this.supportnetworkprofessionals != null;
	}
	public ims.core.vo.SupportNetworkProfessionalVoCollection getSupportNetworkProfessionals()
	{
		return this.supportnetworkprofessionals;
	}
	public void setSupportNetworkProfessionals(ims.core.vo.SupportNetworkProfessionalVoCollection value)
	{
		this.isValidated = false;
		this.supportnetworkprofessionals = value;
	}
	public boolean getSupportNetworkServicesIsNotNull()
	{
		return this.supportnetworkservices != null;
	}
	public ims.core.vo.SupportNetworkServicesVoCollection getSupportNetworkServices()
	{
		return this.supportnetworkservices;
	}
	public void setSupportNetworkServices(ims.core.vo.SupportNetworkServicesVoCollection value)
	{
		this.isValidated = false;
		this.supportnetworkservices = value;
	}
	public boolean getPatientMobilityIsNotNull()
	{
		return this.patientmobility != null;
	}
	public ims.core.vo.lookups.PatientMobilityCollection getPatientMobility()
	{
		return this.patientmobility;
	}
	public void setPatientMobility(ims.core.vo.lookups.PatientMobilityCollection value)
	{
		this.isValidated = false;
		this.patientmobility = value;
	}
	public boolean getTransportArrangedTypeIsNotNull()
	{
		return this.transportarrangedtype != null;
	}
	public ims.scheduling.vo.lookups.ApptTransportType getTransportArrangedType()
	{
		return this.transportarrangedtype;
	}
	public void setTransportArrangedType(ims.scheduling.vo.lookups.ApptTransportType value)
	{
		this.isValidated = false;
		this.transportarrangedtype = value;
	}
	public boolean getTransportDateTimeIsNotNull()
	{
		return this.transportdatetime != null;
	}
	public ims.framework.utils.DateTime getTransportDateTime()
	{
		return this.transportdatetime;
	}
	public void setTransportDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.transportdatetime = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 1500;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getBookingNoIsNotNull()
	{
		return this.bookingno != null;
	}
	public String getBookingNo()
	{
		return this.bookingno;
	}
	public static int getBookingNoMaxLength()
	{
		return 25;
	}
	public void setBookingNo(String value)
	{
		this.isValidated = false;
		this.bookingno = value;
	}
	public boolean getAdviceLeafletsPrintedIsNotNull()
	{
		return this.adviceleafletsprinted != null;
	}
	public ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVoCollection getAdviceLeafletsPrinted()
	{
		return this.adviceleafletsprinted;
	}
	public void setAdviceLeafletsPrinted(ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVoCollection value)
	{
		this.isValidated = false;
		this.adviceleafletsprinted = value;
	}
	public boolean getEquipmentIsNotNull()
	{
		return this.equipment != null;
	}
	public ims.emergency.vo.lookups.DischargequipmentCollection getEquipment()
	{
		return this.equipment;
	}
	public void setEquipment(ims.emergency.vo.lookups.DischargequipmentCollection value)
	{
		this.isValidated = false;
		this.equipment = value;
	}
	public boolean getPrePrintedAdviceLeafletsGivenIsNotNull()
	{
		return this.preprintedadviceleafletsgiven != null;
	}
	public ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVoCollection getPrePrintedAdviceLeafletsGiven()
	{
		return this.preprintedadviceleafletsgiven;
	}
	public void setPrePrintedAdviceLeafletsGiven(ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVoCollection value)
	{
		this.isValidated = false;
		this.preprintedadviceleafletsgiven = value;
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
		if(this.adviceleafletsprinted != null)
		{
			if(!this.adviceleafletsprinted.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.preprintedadviceleafletsgiven != null)
		{
			if(!this.preprintedadviceleafletsgiven.isValidated())
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.episode == null)
			listOfErrors.add("Episode is mandatory");
		if(this.attendance == null)
			listOfErrors.add("Attendance is mandatory");
		if(this.comments != null)
			if(this.comments.length() > 1500)
				listOfErrors.add("The length of the field [comments] in the value object [ims.emergency.vo.DischargeServicesAndAdviceForDischargePlanningVo] is too big. It should be less or equal to 1500");
		if(this.bookingno != null)
			if(this.bookingno.length() > 25)
				listOfErrors.add("The length of the field [bookingno] in the value object [ims.emergency.vo.DischargeServicesAndAdviceForDischargePlanningVo] is too big. It should be less or equal to 25");
		if(this.adviceleafletsprinted != null)
		{
			String[] listOfOtherErrors = this.adviceleafletsprinted.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.preprintedadviceleafletsgiven != null)
		{
			String[] listOfOtherErrors = this.preprintedadviceleafletsgiven.validate();
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
	
		DischargeServicesAndAdviceForDischargePlanningVo clone = new DischargeServicesAndAdviceForDischargePlanningVo(this.id, this.version);
		
		clone.patient = this.patient;
		clone.episode = this.episode;
		clone.attendance = this.attendance;
		if(this.supportnetworkfamily == null)
			clone.supportnetworkfamily = null;
		else
			clone.supportnetworkfamily = (ims.core.vo.SupportNetworkFamilyCollection)this.supportnetworkfamily.clone();
		if(this.supportnetworkprofessionals == null)
			clone.supportnetworkprofessionals = null;
		else
			clone.supportnetworkprofessionals = (ims.core.vo.SupportNetworkProfessionalVoCollection)this.supportnetworkprofessionals.clone();
		if(this.supportnetworkservices == null)
			clone.supportnetworkservices = null;
		else
			clone.supportnetworkservices = (ims.core.vo.SupportNetworkServicesVoCollection)this.supportnetworkservices.clone();
		if(this.patientmobility == null)
			clone.patientmobility = null;
		else
			clone.patientmobility = (ims.core.vo.lookups.PatientMobilityCollection)this.patientmobility.clone();
		if(this.transportarrangedtype == null)
			clone.transportarrangedtype = null;
		else
			clone.transportarrangedtype = (ims.scheduling.vo.lookups.ApptTransportType)this.transportarrangedtype.clone();
		if(this.transportdatetime == null)
			clone.transportdatetime = null;
		else
			clone.transportdatetime = (ims.framework.utils.DateTime)this.transportdatetime.clone();
		clone.comments = this.comments;
		clone.bookingno = this.bookingno;
		if(this.adviceleafletsprinted == null)
			clone.adviceleafletsprinted = null;
		else
			clone.adviceleafletsprinted = (ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVoCollection)this.adviceleafletsprinted.clone();
		if(this.equipment == null)
			clone.equipment = null;
		else
			clone.equipment = (ims.emergency.vo.lookups.DischargequipmentCollection)this.equipment.clone();
		if(this.preprintedadviceleafletsgiven == null)
			clone.preprintedadviceleafletsgiven = null;
		else
			clone.preprintedadviceleafletsgiven = (ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVoCollection)this.preprintedadviceleafletsgiven.clone();
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
		if (!(DischargeServicesAndAdviceForDischargePlanningVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DischargeServicesAndAdviceForDischargePlanningVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DischargeServicesAndAdviceForDischargePlanningVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DischargeServicesAndAdviceForDischargePlanningVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.episode != null)
			count++;
		if(this.attendance != null)
			count++;
		if(this.supportnetworkfamily != null)
			count++;
		if(this.supportnetworkprofessionals != null)
			count++;
		if(this.supportnetworkservices != null)
			count++;
		if(this.patientmobility != null)
			count++;
		if(this.transportarrangedtype != null)
			count++;
		if(this.transportdatetime != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.bookingno != null)
			count++;
		if(this.adviceleafletsprinted != null)
			count++;
		if(this.equipment != null)
			count++;
		if(this.preprintedadviceleafletsgiven != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 14;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episode;
	protected ims.core.admin.vo.CareContextRefVo attendance;
	protected ims.core.vo.SupportNetworkFamilyCollection supportnetworkfamily;
	protected ims.core.vo.SupportNetworkProfessionalVoCollection supportnetworkprofessionals;
	protected ims.core.vo.SupportNetworkServicesVoCollection supportnetworkservices;
	protected ims.core.vo.lookups.PatientMobilityCollection patientmobility;
	protected ims.scheduling.vo.lookups.ApptTransportType transportarrangedtype;
	protected ims.framework.utils.DateTime transportdatetime;
	protected String comments;
	protected String bookingno;
	protected ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVoCollection adviceleafletsprinted;
	protected ims.emergency.vo.lookups.DischargequipmentCollection equipment;
	protected ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVoCollection preprintedadviceleafletsgiven;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
