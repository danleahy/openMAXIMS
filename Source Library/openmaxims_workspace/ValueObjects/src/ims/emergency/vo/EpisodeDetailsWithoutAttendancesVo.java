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
 * Linked to core.admin.EmergencyEpisode business object (ID: 1004100024).
 */
public class EpisodeDetailsWithoutAttendancesVo extends ims.core.admin.vo.EmergencyEpisodeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EpisodeDetailsWithoutAttendancesVo()
	{
	}
	public EpisodeDetailsWithoutAttendancesVo(Integer id, int version)
	{
		super(id, version);
	}
	public EpisodeDetailsWithoutAttendancesVo(ims.emergency.vo.beans.EpisodeDetailsWithoutAttendancesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.injurydatetime = bean.getInjuryDateTime() == null ? null : bean.getInjuryDateTime().buildDateTime();
		this.sourceofreferral = bean.getSourceOfReferral() == null ? null : ims.emergency.vo.lookups.ReferredBy.buildLookup(bean.getSourceOfReferral());
		this.incidentlocation = bean.getIncidentLocation() == null ? null : ims.emergency.vo.lookups.IncidentLocation.buildLookup(bean.getIncidentLocation());
		this.locationdetails = bean.getLocationDetails();
		this.elapsedtime = bean.getElapsedTime();
		this.elapsedperiod = bean.getElapsedPeriod() == null ? null : ims.emergency.vo.lookups.ElapsedInjuryPeriod.buildLookup(bean.getElapsedPeriod());
		this.category = bean.getCategory() == null ? null : ims.emergency.vo.lookups.PatientCategory.buildLookup(bean.getCategory());
		this.mobility = bean.getMobility() == null ? null : ims.core.vo.lookups.PatientMobility.buildLookup(bean.getMobility());
		this.referringgp = bean.getReferringGP() == null ? null : new ims.core.resource.people.vo.GpRefVo(new Integer(bean.getReferringGP().getId()), bean.getReferringGP().getVersion());
		this.presentingcomplaint = bean.getPresentingComplaint() == null ? null : ims.emergency.vo.lookups.PresentingComplaint.buildLookup(bean.getPresentingComplaint());
		this.school = bean.getSchool() == null ? null : ims.emergency.vo.lookups.School.buildLookup(bean.getSchool());
		this.occupation = bean.getOccupation() == null ? null : ims.core.vo.lookups.Occupation.buildLookup(bean.getOccupation());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.occupationstatus = bean.getOccupationStatus() == null ? null : ims.core.vo.lookups.OccupationStatus.buildLookup(bean.getOccupationStatus());
		this.placeofemployment = bean.getPlaceofEmployment();
		this.triagecategorytype = bean.getTriageCategoryType() == null ? null : ims.emergency.vo.lookups.TriagePatientStatus.buildLookup(bean.getTriageCategoryType());
		this.specialinterestdetails = ims.emergency.vo.SpecialInterestDetailsVoCollection.buildFromBeanCollection(bean.getSpecialInterestDetails());
		this.rtadetails = bean.getRTADetails() == null ? null : bean.getRTADetails().buildVo();
		this.tiig = bean.getTiig() == null ? null : bean.getTiig().buildVo();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.EpisodeDetailsWithoutAttendancesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.injurydatetime = bean.getInjuryDateTime() == null ? null : bean.getInjuryDateTime().buildDateTime();
		this.sourceofreferral = bean.getSourceOfReferral() == null ? null : ims.emergency.vo.lookups.ReferredBy.buildLookup(bean.getSourceOfReferral());
		this.incidentlocation = bean.getIncidentLocation() == null ? null : ims.emergency.vo.lookups.IncidentLocation.buildLookup(bean.getIncidentLocation());
		this.locationdetails = bean.getLocationDetails();
		this.elapsedtime = bean.getElapsedTime();
		this.elapsedperiod = bean.getElapsedPeriod() == null ? null : ims.emergency.vo.lookups.ElapsedInjuryPeriod.buildLookup(bean.getElapsedPeriod());
		this.category = bean.getCategory() == null ? null : ims.emergency.vo.lookups.PatientCategory.buildLookup(bean.getCategory());
		this.mobility = bean.getMobility() == null ? null : ims.core.vo.lookups.PatientMobility.buildLookup(bean.getMobility());
		this.referringgp = bean.getReferringGP() == null ? null : new ims.core.resource.people.vo.GpRefVo(new Integer(bean.getReferringGP().getId()), bean.getReferringGP().getVersion());
		this.presentingcomplaint = bean.getPresentingComplaint() == null ? null : ims.emergency.vo.lookups.PresentingComplaint.buildLookup(bean.getPresentingComplaint());
		this.school = bean.getSchool() == null ? null : ims.emergency.vo.lookups.School.buildLookup(bean.getSchool());
		this.occupation = bean.getOccupation() == null ? null : ims.core.vo.lookups.Occupation.buildLookup(bean.getOccupation());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.occupationstatus = bean.getOccupationStatus() == null ? null : ims.core.vo.lookups.OccupationStatus.buildLookup(bean.getOccupationStatus());
		this.placeofemployment = bean.getPlaceofEmployment();
		this.triagecategorytype = bean.getTriageCategoryType() == null ? null : ims.emergency.vo.lookups.TriagePatientStatus.buildLookup(bean.getTriageCategoryType());
		this.specialinterestdetails = ims.emergency.vo.SpecialInterestDetailsVoCollection.buildFromBeanCollection(bean.getSpecialInterestDetails());
		this.rtadetails = bean.getRTADetails() == null ? null : bean.getRTADetails().buildVo(map);
		this.tiig = bean.getTiig() == null ? null : bean.getTiig().buildVo(map);
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.EpisodeDetailsWithoutAttendancesVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.EpisodeDetailsWithoutAttendancesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.EpisodeDetailsWithoutAttendancesVoBean();
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
		if(fieldName.equals("INJURYDATETIME"))
			return getInjuryDateTime();
		if(fieldName.equals("SOURCEOFREFERRAL"))
			return getSourceOfReferral();
		if(fieldName.equals("INCIDENTLOCATION"))
			return getIncidentLocation();
		if(fieldName.equals("LOCATIONDETAILS"))
			return getLocationDetails();
		if(fieldName.equals("ELAPSEDTIME"))
			return getElapsedTime();
		if(fieldName.equals("ELAPSEDPERIOD"))
			return getElapsedPeriod();
		if(fieldName.equals("CATEGORY"))
			return getCategory();
		if(fieldName.equals("MOBILITY"))
			return getMobility();
		if(fieldName.equals("REFERRINGGP"))
			return getReferringGP();
		if(fieldName.equals("PRESENTINGCOMPLAINT"))
			return getPresentingComplaint();
		if(fieldName.equals("SCHOOL"))
			return getSchool();
		if(fieldName.equals("OCCUPATION"))
			return getOccupation();
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		if(fieldName.equals("OCCUPATIONSTATUS"))
			return getOccupationStatus();
		if(fieldName.equals("PLACEOFEMPLOYMENT"))
			return getPlaceofEmployment();
		if(fieldName.equals("TRIAGECATEGORYTYPE"))
			return getTriageCategoryType();
		if(fieldName.equals("SPECIALINTERESTDETAILS"))
			return getSpecialInterestDetails();
		if(fieldName.equals("RTADETAILS"))
			return getRTADetails();
		if(fieldName.equals("TIIG"))
			return getTiig();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getInjuryDateTimeIsNotNull()
	{
		return this.injurydatetime != null;
	}
	public ims.framework.utils.DateTime getInjuryDateTime()
	{
		return this.injurydatetime;
	}
	public void setInjuryDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.injurydatetime = value;
	}
	public boolean getSourceOfReferralIsNotNull()
	{
		return this.sourceofreferral != null;
	}
	public ims.emergency.vo.lookups.ReferredBy getSourceOfReferral()
	{
		return this.sourceofreferral;
	}
	public void setSourceOfReferral(ims.emergency.vo.lookups.ReferredBy value)
	{
		this.isValidated = false;
		this.sourceofreferral = value;
	}
	public boolean getIncidentLocationIsNotNull()
	{
		return this.incidentlocation != null;
	}
	public ims.emergency.vo.lookups.IncidentLocation getIncidentLocation()
	{
		return this.incidentlocation;
	}
	public void setIncidentLocation(ims.emergency.vo.lookups.IncidentLocation value)
	{
		this.isValidated = false;
		this.incidentlocation = value;
	}
	public boolean getLocationDetailsIsNotNull()
	{
		return this.locationdetails != null;
	}
	public String getLocationDetails()
	{
		return this.locationdetails;
	}
	public static int getLocationDetailsMaxLength()
	{
		return 255;
	}
	public void setLocationDetails(String value)
	{
		this.isValidated = false;
		this.locationdetails = value;
	}
	public boolean getElapsedTimeIsNotNull()
	{
		return this.elapsedtime != null;
	}
	public Integer getElapsedTime()
	{
		return this.elapsedtime;
	}
	public void setElapsedTime(Integer value)
	{
		this.isValidated = false;
		this.elapsedtime = value;
	}
	public boolean getElapsedPeriodIsNotNull()
	{
		return this.elapsedperiod != null;
	}
	public ims.emergency.vo.lookups.ElapsedInjuryPeriod getElapsedPeriod()
	{
		return this.elapsedperiod;
	}
	public void setElapsedPeriod(ims.emergency.vo.lookups.ElapsedInjuryPeriod value)
	{
		this.isValidated = false;
		this.elapsedperiod = value;
	}
	public boolean getCategoryIsNotNull()
	{
		return this.category != null;
	}
	public ims.emergency.vo.lookups.PatientCategory getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.emergency.vo.lookups.PatientCategory value)
	{
		this.isValidated = false;
		this.category = value;
	}
	public boolean getMobilityIsNotNull()
	{
		return this.mobility != null;
	}
	public ims.core.vo.lookups.PatientMobility getMobility()
	{
		return this.mobility;
	}
	public void setMobility(ims.core.vo.lookups.PatientMobility value)
	{
		this.isValidated = false;
		this.mobility = value;
	}
	public boolean getReferringGPIsNotNull()
	{
		return this.referringgp != null;
	}
	public ims.core.resource.people.vo.GpRefVo getReferringGP()
	{
		return this.referringgp;
	}
	public void setReferringGP(ims.core.resource.people.vo.GpRefVo value)
	{
		this.isValidated = false;
		this.referringgp = value;
	}
	public boolean getPresentingComplaintIsNotNull()
	{
		return this.presentingcomplaint != null;
	}
	public ims.emergency.vo.lookups.PresentingComplaint getPresentingComplaint()
	{
		return this.presentingcomplaint;
	}
	public void setPresentingComplaint(ims.emergency.vo.lookups.PresentingComplaint value)
	{
		this.isValidated = false;
		this.presentingcomplaint = value;
	}
	public boolean getSchoolIsNotNull()
	{
		return this.school != null;
	}
	public ims.emergency.vo.lookups.School getSchool()
	{
		return this.school;
	}
	public void setSchool(ims.emergency.vo.lookups.School value)
	{
		this.isValidated = false;
		this.school = value;
	}
	public boolean getOccupationIsNotNull()
	{
		return this.occupation != null;
	}
	public ims.core.vo.lookups.Occupation getOccupation()
	{
		return this.occupation;
	}
	public void setOccupation(ims.core.vo.lookups.Occupation value)
	{
		this.isValidated = false;
		this.occupation = value;
	}
	public boolean getEpisodeOfCareIsNotNull()
	{
		return this.episodeofcare != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episodeofcare = value;
	}
	public boolean getOccupationStatusIsNotNull()
	{
		return this.occupationstatus != null;
	}
	public ims.core.vo.lookups.OccupationStatus getOccupationStatus()
	{
		return this.occupationstatus;
	}
	public void setOccupationStatus(ims.core.vo.lookups.OccupationStatus value)
	{
		this.isValidated = false;
		this.occupationstatus = value;
	}
	public boolean getPlaceofEmploymentIsNotNull()
	{
		return this.placeofemployment != null;
	}
	public String getPlaceofEmployment()
	{
		return this.placeofemployment;
	}
	public static int getPlaceofEmploymentMaxLength()
	{
		return 150;
	}
	public void setPlaceofEmployment(String value)
	{
		this.isValidated = false;
		this.placeofemployment = value;
	}
	public boolean getTriageCategoryTypeIsNotNull()
	{
		return this.triagecategorytype != null;
	}
	public ims.emergency.vo.lookups.TriagePatientStatus getTriageCategoryType()
	{
		return this.triagecategorytype;
	}
	public void setTriageCategoryType(ims.emergency.vo.lookups.TriagePatientStatus value)
	{
		this.isValidated = false;
		this.triagecategorytype = value;
	}
	public boolean getSpecialInterestDetailsIsNotNull()
	{
		return this.specialinterestdetails != null;
	}
	public ims.emergency.vo.SpecialInterestDetailsVoCollection getSpecialInterestDetails()
	{
		return this.specialinterestdetails;
	}
	public void setSpecialInterestDetails(ims.emergency.vo.SpecialInterestDetailsVoCollection value)
	{
		this.isValidated = false;
		this.specialinterestdetails = value;
	}
	public boolean getRTADetailsIsNotNull()
	{
		return this.rtadetails != null;
	}
	public ims.emergency.vo.RTAVo getRTADetails()
	{
		return this.rtadetails;
	}
	public void setRTADetails(ims.emergency.vo.RTAVo value)
	{
		this.isValidated = false;
		this.rtadetails = value;
	}
	public boolean getTiigIsNotNull()
	{
		return this.tiig != null;
	}
	public ims.emergency.vo.TIIGVo getTiig()
	{
		return this.tiig;
	}
	public void setTiig(ims.emergency.vo.TIIGVo value)
	{
		this.isValidated = false;
		this.tiig = value;
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
		if(this.rtadetails != null)
		{
			if(!this.rtadetails.isValidated())
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
		if(this.sourceofreferral == null)
			listOfErrors.add("SourceOfReferral is mandatory");
		if(this.locationdetails != null)
			if(this.locationdetails.length() > 255)
				listOfErrors.add("The length of the field [locationdetails] in the value object [ims.emergency.vo.EpisodeDetailsWithoutAttendancesVo] is too big. It should be less or equal to 255");
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
		if(this.placeofemployment != null)
			if(this.placeofemployment.length() > 150)
				listOfErrors.add("The length of the field [placeofemployment] in the value object [ims.emergency.vo.EpisodeDetailsWithoutAttendancesVo] is too big. It should be less or equal to 150");
		if(this.rtadetails != null)
		{
			String[] listOfOtherErrors = this.rtadetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
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
	
		EpisodeDetailsWithoutAttendancesVo clone = new EpisodeDetailsWithoutAttendancesVo(this.id, this.version);
		
		if(this.injurydatetime == null)
			clone.injurydatetime = null;
		else
			clone.injurydatetime = (ims.framework.utils.DateTime)this.injurydatetime.clone();
		if(this.sourceofreferral == null)
			clone.sourceofreferral = null;
		else
			clone.sourceofreferral = (ims.emergency.vo.lookups.ReferredBy)this.sourceofreferral.clone();
		if(this.incidentlocation == null)
			clone.incidentlocation = null;
		else
			clone.incidentlocation = (ims.emergency.vo.lookups.IncidentLocation)this.incidentlocation.clone();
		clone.locationdetails = this.locationdetails;
		clone.elapsedtime = this.elapsedtime;
		if(this.elapsedperiod == null)
			clone.elapsedperiod = null;
		else
			clone.elapsedperiod = (ims.emergency.vo.lookups.ElapsedInjuryPeriod)this.elapsedperiod.clone();
		if(this.category == null)
			clone.category = null;
		else
			clone.category = (ims.emergency.vo.lookups.PatientCategory)this.category.clone();
		if(this.mobility == null)
			clone.mobility = null;
		else
			clone.mobility = (ims.core.vo.lookups.PatientMobility)this.mobility.clone();
		clone.referringgp = this.referringgp;
		if(this.presentingcomplaint == null)
			clone.presentingcomplaint = null;
		else
			clone.presentingcomplaint = (ims.emergency.vo.lookups.PresentingComplaint)this.presentingcomplaint.clone();
		if(this.school == null)
			clone.school = null;
		else
			clone.school = (ims.emergency.vo.lookups.School)this.school.clone();
		if(this.occupation == null)
			clone.occupation = null;
		else
			clone.occupation = (ims.core.vo.lookups.Occupation)this.occupation.clone();
		clone.episodeofcare = this.episodeofcare;
		if(this.occupationstatus == null)
			clone.occupationstatus = null;
		else
			clone.occupationstatus = (ims.core.vo.lookups.OccupationStatus)this.occupationstatus.clone();
		clone.placeofemployment = this.placeofemployment;
		if(this.triagecategorytype == null)
			clone.triagecategorytype = null;
		else
			clone.triagecategorytype = (ims.emergency.vo.lookups.TriagePatientStatus)this.triagecategorytype.clone();
		if(this.specialinterestdetails == null)
			clone.specialinterestdetails = null;
		else
			clone.specialinterestdetails = (ims.emergency.vo.SpecialInterestDetailsVoCollection)this.specialinterestdetails.clone();
		if(this.rtadetails == null)
			clone.rtadetails = null;
		else
			clone.rtadetails = (ims.emergency.vo.RTAVo)this.rtadetails.clone();
		if(this.tiig == null)
			clone.tiig = null;
		else
			clone.tiig = (ims.emergency.vo.TIIGVo)this.tiig.clone();
		clone.patient = this.patient;
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
		if (!(EpisodeDetailsWithoutAttendancesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EpisodeDetailsWithoutAttendancesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EpisodeDetailsWithoutAttendancesVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EpisodeDetailsWithoutAttendancesVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.injurydatetime != null)
			count++;
		if(this.sourceofreferral != null)
			count++;
		if(this.incidentlocation != null)
			count++;
		if(this.locationdetails != null)
			count++;
		if(this.elapsedtime != null)
			count++;
		if(this.elapsedperiod != null)
			count++;
		if(this.category != null)
			count++;
		if(this.mobility != null)
			count++;
		if(this.referringgp != null)
			count++;
		if(this.presentingcomplaint != null)
			count++;
		if(this.school != null)
			count++;
		if(this.occupation != null)
			count++;
		if(this.episodeofcare != null)
			count++;
		if(this.occupationstatus != null)
			count++;
		if(this.placeofemployment != null)
			count++;
		if(this.triagecategorytype != null)
			count++;
		if(this.specialinterestdetails != null)
			count++;
		if(this.rtadetails != null)
			count++;
		if(this.tiig != null)
			count++;
		if(this.patient != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 20;
	}
	protected ims.framework.utils.DateTime injurydatetime;
	protected ims.emergency.vo.lookups.ReferredBy sourceofreferral;
	protected ims.emergency.vo.lookups.IncidentLocation incidentlocation;
	protected String locationdetails;
	protected Integer elapsedtime;
	protected ims.emergency.vo.lookups.ElapsedInjuryPeriod elapsedperiod;
	protected ims.emergency.vo.lookups.PatientCategory category;
	protected ims.core.vo.lookups.PatientMobility mobility;
	protected ims.core.resource.people.vo.GpRefVo referringgp;
	protected ims.emergency.vo.lookups.PresentingComplaint presentingcomplaint;
	protected ims.emergency.vo.lookups.School school;
	protected ims.core.vo.lookups.Occupation occupation;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episodeofcare;
	protected ims.core.vo.lookups.OccupationStatus occupationstatus;
	protected String placeofemployment;
	protected ims.emergency.vo.lookups.TriagePatientStatus triagecategorytype;
	protected ims.emergency.vo.SpecialInterestDetailsVoCollection specialinterestdetails;
	protected ims.emergency.vo.RTAVo rtadetails;
	protected ims.emergency.vo.TIIGVo tiig;
	protected ims.core.patient.vo.PatientRefVo patient;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
