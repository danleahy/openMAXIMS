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

package ims.core.vo.beans;

public class ifInpatientEpisodeVoBean extends ims.vo.ValueObjectBean
{
	public ifInpatientEpisodeVoBean()
	{
	}
	public ifInpatientEpisodeVoBean(ims.core.vo.ifInpatientEpisodeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientBean)vo.getPatient().getBean();
		this.paseventid = vo.getPasEventId();
		this.consultant = vo.getConsultant() == null ? null : (ims.core.vo.beans.MedicWithMappingsLiteVoBean)vo.getConsultant().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.sourceofreferral = vo.getSourceOfReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfReferral().getBean();
		this.isvip = vo.getIsVip();
		this.referringgp = vo.getReferringGP() == null ? null : (ims.core.vo.beans.GpLiteVoBean)vo.getReferringGP().getBean();
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
		this.pasepisodeid = vo.getPasEpisodeId();
		this.episodefinancialclass = vo.getEpisodeFinancialClass() == null ? null : (ims.vo.LookupInstanceBean)vo.getEpisodeFinancialClass().getBean();
		this.attendinghcp = vo.getAttendingHCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAttendingHCP().getBean();
		this.pointofcare = vo.getPointOfCare();
		this.bedno = vo.getBedNo();
		this.facility = vo.getFacility();
		this.locationdescription = vo.getLocationDescription();
		this.hospitalservice = vo.getHospitalService();
		this.admitsource = vo.getAdmitSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdmitSource().getBean();
		this.patienttype = vo.getPatientType() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientType().getBean();
		this.ischaplainrequired = vo.getIsChaplainRequired();
		this.tcitype = vo.getTCIType() == null ? null : (ims.vo.LookupInstanceBean)vo.getTCIType().getBean();
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.wardtype = vo.getWardType() == null ? null : (ims.vo.LookupInstanceBean)vo.getWardType().getBean();
		this.admissionreason = vo.getAdmissionReason();
		this.dischargedisposition = vo.getDischargeDisposition() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeDisposition().getBean();
		this.dischargedestination = vo.getDischargeDestination() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeDestination().getBean();
		this.dischargedatetime = vo.getDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargeDateTime().getBean();
		this.expectedloareturndatetime = vo.getExpectedLOAReturnDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getExpectedLOAReturnDateTime().getBean();
		this.priorpointofcare = vo.getPriorPointOfCare();
		this.priorbedno = vo.getPriorBedNo();
		this.priorfacilty = vo.getPriorFacilty();
		this.priorlocationdescription = vo.getPriorLocationDescription();
		this.preadmissionnumber = vo.getPreadmissionNumber();
		this.datetimeonhomeleave = vo.getDateTimeOnHomeLeave() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeOnHomeLeave().getBean();
		this.methodofadmission = vo.getMethodOfAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getMethodOfAdmission().getBean();
		this.wardlocation = vo.getWardLocation() == null ? null : (ims.core.vo.beans.LocMostVoBean)vo.getWardLocation().getBean();
		this.priorwardlocation = vo.getPriorWardLocation() == null ? null : (ims.core.vo.beans.LocMostVoBean)vo.getPriorWardLocation().getBean();
		this.electiveadmissiontype = vo.getElectiveAdmissionType() == null ? null : (ims.vo.LookupInstanceBean)vo.getElectiveAdmissionType().getBean();
		this.pendingtransfer = vo.getPendingTransfer() == null ? null : (ims.core.vo.beans.ifPendingTransferVoBean)vo.getPendingTransfer().getBean();
		this.estlengthofstay = vo.getEstLengthOfStay();
		this.bedspacestatebay = vo.getBedSpaceStateBay() == null ? null : (ims.core.vo.beans.LocShortMappingsVoBean)vo.getBedSpaceStateBay().getBean();
		this.expecteddischargedatetime = vo.getExpectedDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getExpectedDischargeDateTime().getBean();
		this.methodofdischarge = vo.getMethodOfDischarge() == null ? null : (ims.vo.LookupInstanceBean)vo.getMethodOfDischarge().getBean();
		this.currentwardstayadmissiondatetime = vo.getCurrentWardStayAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCurrentWardStayAdmissionDateTime().getBean();
		this.priortransferreason = vo.getPriorTransferReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getPriorTransferReason().getBean();
		this.sourceofemergencyreferral = vo.getSourceOfEmergencyReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfEmergencyReferral().getBean();
		this.admissioneventdatetime = vo.getAdmissionEventDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionEventDateTime().getBean();
		this.dischargeeventdatetime = vo.getDischargeEventDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargeEventDateTime().getBean();
		this.transfereventdatetime = vo.getTransferEventDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTransferEventDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ifInpatientEpisodeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientBean)vo.getPatient().getBean(map);
		this.paseventid = vo.getPasEventId();
		this.consultant = vo.getConsultant() == null ? null : (ims.core.vo.beans.MedicWithMappingsLiteVoBean)vo.getConsultant().getBean(map);
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.sourceofreferral = vo.getSourceOfReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfReferral().getBean();
		this.isvip = vo.getIsVip();
		this.referringgp = vo.getReferringGP() == null ? null : (ims.core.vo.beans.GpLiteVoBean)vo.getReferringGP().getBean(map);
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
		this.pasepisodeid = vo.getPasEpisodeId();
		this.episodefinancialclass = vo.getEpisodeFinancialClass() == null ? null : (ims.vo.LookupInstanceBean)vo.getEpisodeFinancialClass().getBean();
		this.attendinghcp = vo.getAttendingHCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAttendingHCP().getBean(map);
		this.pointofcare = vo.getPointOfCare();
		this.bedno = vo.getBedNo();
		this.facility = vo.getFacility();
		this.locationdescription = vo.getLocationDescription();
		this.hospitalservice = vo.getHospitalService();
		this.admitsource = vo.getAdmitSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdmitSource().getBean();
		this.patienttype = vo.getPatientType() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientType().getBean();
		this.ischaplainrequired = vo.getIsChaplainRequired();
		this.tcitype = vo.getTCIType() == null ? null : (ims.vo.LookupInstanceBean)vo.getTCIType().getBean();
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.wardtype = vo.getWardType() == null ? null : (ims.vo.LookupInstanceBean)vo.getWardType().getBean();
		this.admissionreason = vo.getAdmissionReason();
		this.dischargedisposition = vo.getDischargeDisposition() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeDisposition().getBean();
		this.dischargedestination = vo.getDischargeDestination() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeDestination().getBean();
		this.dischargedatetime = vo.getDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargeDateTime().getBean();
		this.expectedloareturndatetime = vo.getExpectedLOAReturnDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getExpectedLOAReturnDateTime().getBean();
		this.priorpointofcare = vo.getPriorPointOfCare();
		this.priorbedno = vo.getPriorBedNo();
		this.priorfacilty = vo.getPriorFacilty();
		this.priorlocationdescription = vo.getPriorLocationDescription();
		this.preadmissionnumber = vo.getPreadmissionNumber();
		this.datetimeonhomeleave = vo.getDateTimeOnHomeLeave() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeOnHomeLeave().getBean();
		this.methodofadmission = vo.getMethodOfAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getMethodOfAdmission().getBean();
		this.wardlocation = vo.getWardLocation() == null ? null : (ims.core.vo.beans.LocMostVoBean)vo.getWardLocation().getBean(map);
		this.priorwardlocation = vo.getPriorWardLocation() == null ? null : (ims.core.vo.beans.LocMostVoBean)vo.getPriorWardLocation().getBean(map);
		this.electiveadmissiontype = vo.getElectiveAdmissionType() == null ? null : (ims.vo.LookupInstanceBean)vo.getElectiveAdmissionType().getBean();
		this.pendingtransfer = vo.getPendingTransfer() == null ? null : (ims.core.vo.beans.ifPendingTransferVoBean)vo.getPendingTransfer().getBean(map);
		this.estlengthofstay = vo.getEstLengthOfStay();
		this.bedspacestatebay = vo.getBedSpaceStateBay() == null ? null : (ims.core.vo.beans.LocShortMappingsVoBean)vo.getBedSpaceStateBay().getBean(map);
		this.expecteddischargedatetime = vo.getExpectedDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getExpectedDischargeDateTime().getBean();
		this.methodofdischarge = vo.getMethodOfDischarge() == null ? null : (ims.vo.LookupInstanceBean)vo.getMethodOfDischarge().getBean();
		this.currentwardstayadmissiondatetime = vo.getCurrentWardStayAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCurrentWardStayAdmissionDateTime().getBean();
		this.priortransferreason = vo.getPriorTransferReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getPriorTransferReason().getBean();
		this.sourceofemergencyreferral = vo.getSourceOfEmergencyReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfEmergencyReferral().getBean();
		this.admissioneventdatetime = vo.getAdmissionEventDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionEventDateTime().getBean();
		this.dischargeeventdatetime = vo.getDischargeEventDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargeEventDateTime().getBean();
		this.transfereventdatetime = vo.getTransferEventDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTransferEventDateTime().getBean();
	}

	public ims.core.vo.ifInpatientEpisodeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ifInpatientEpisodeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ifInpatientEpisodeVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ifInpatientEpisodeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ifInpatientEpisodeVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.core.vo.beans.PatientBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientBean value)
	{
		this.patient = value;
	}
	public String getPasEventId()
	{
		return this.paseventid;
	}
	public void setPasEventId(String value)
	{
		this.paseventid = value;
	}
	public ims.core.vo.beans.MedicWithMappingsLiteVoBean getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.beans.MedicWithMappingsLiteVoBean value)
	{
		this.consultant = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public ims.vo.LookupInstanceBean getSourceOfReferral()
	{
		return this.sourceofreferral;
	}
	public void setSourceOfReferral(ims.vo.LookupInstanceBean value)
	{
		this.sourceofreferral = value;
	}
	public Boolean getIsVip()
	{
		return this.isvip;
	}
	public void setIsVip(Boolean value)
	{
		this.isvip = value;
	}
	public ims.core.vo.beans.GpLiteVoBean getReferringGP()
	{
		return this.referringgp;
	}
	public void setReferringGP(ims.core.vo.beans.GpLiteVoBean value)
	{
		this.referringgp = value;
	}
	public ims.vo.LookupInstanceBean getEventType()
	{
		return this.eventtype;
	}
	public void setEventType(ims.vo.LookupInstanceBean value)
	{
		this.eventtype = value;
	}
	public String getPasEpisodeId()
	{
		return this.pasepisodeid;
	}
	public void setPasEpisodeId(String value)
	{
		this.pasepisodeid = value;
	}
	public ims.vo.LookupInstanceBean getEpisodeFinancialClass()
	{
		return this.episodefinancialclass;
	}
	public void setEpisodeFinancialClass(ims.vo.LookupInstanceBean value)
	{
		this.episodefinancialclass = value;
	}
	public ims.core.vo.beans.HcpBean getAttendingHCP()
	{
		return this.attendinghcp;
	}
	public void setAttendingHCP(ims.core.vo.beans.HcpBean value)
	{
		this.attendinghcp = value;
	}
	public String getPointOfCare()
	{
		return this.pointofcare;
	}
	public void setPointOfCare(String value)
	{
		this.pointofcare = value;
	}
	public String getBedNo()
	{
		return this.bedno;
	}
	public void setBedNo(String value)
	{
		this.bedno = value;
	}
	public String getFacility()
	{
		return this.facility;
	}
	public void setFacility(String value)
	{
		this.facility = value;
	}
	public String getLocationDescription()
	{
		return this.locationdescription;
	}
	public void setLocationDescription(String value)
	{
		this.locationdescription = value;
	}
	public String getHospitalService()
	{
		return this.hospitalservice;
	}
	public void setHospitalService(String value)
	{
		this.hospitalservice = value;
	}
	public ims.vo.LookupInstanceBean getAdmitSource()
	{
		return this.admitsource;
	}
	public void setAdmitSource(ims.vo.LookupInstanceBean value)
	{
		this.admitsource = value;
	}
	public ims.vo.LookupInstanceBean getPatientType()
	{
		return this.patienttype;
	}
	public void setPatientType(ims.vo.LookupInstanceBean value)
	{
		this.patienttype = value;
	}
	public Boolean getIsChaplainRequired()
	{
		return this.ischaplainrequired;
	}
	public void setIsChaplainRequired(Boolean value)
	{
		this.ischaplainrequired = value;
	}
	public ims.vo.LookupInstanceBean getTCIType()
	{
		return this.tcitype;
	}
	public void setTCIType(ims.vo.LookupInstanceBean value)
	{
		this.tcitype = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAdmissionDateTime()
	{
		return this.admissiondatetime;
	}
	public void setAdmissionDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.admissiondatetime = value;
	}
	public ims.vo.LookupInstanceBean getWardType()
	{
		return this.wardtype;
	}
	public void setWardType(ims.vo.LookupInstanceBean value)
	{
		this.wardtype = value;
	}
	public String getAdmissionReason()
	{
		return this.admissionreason;
	}
	public void setAdmissionReason(String value)
	{
		this.admissionreason = value;
	}
	public ims.vo.LookupInstanceBean getDischargeDisposition()
	{
		return this.dischargedisposition;
	}
	public void setDischargeDisposition(ims.vo.LookupInstanceBean value)
	{
		this.dischargedisposition = value;
	}
	public ims.vo.LookupInstanceBean getDischargeDestination()
	{
		return this.dischargedestination;
	}
	public void setDischargeDestination(ims.vo.LookupInstanceBean value)
	{
		this.dischargedestination = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDischargeDateTime()
	{
		return this.dischargedatetime;
	}
	public void setDischargeDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.dischargedatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getExpectedLOAReturnDateTime()
	{
		return this.expectedloareturndatetime;
	}
	public void setExpectedLOAReturnDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.expectedloareturndatetime = value;
	}
	public String getPriorPointOfCare()
	{
		return this.priorpointofcare;
	}
	public void setPriorPointOfCare(String value)
	{
		this.priorpointofcare = value;
	}
	public String getPriorBedNo()
	{
		return this.priorbedno;
	}
	public void setPriorBedNo(String value)
	{
		this.priorbedno = value;
	}
	public String getPriorFacilty()
	{
		return this.priorfacilty;
	}
	public void setPriorFacilty(String value)
	{
		this.priorfacilty = value;
	}
	public String getPriorLocationDescription()
	{
		return this.priorlocationdescription;
	}
	public void setPriorLocationDescription(String value)
	{
		this.priorlocationdescription = value;
	}
	public String getPreadmissionNumber()
	{
		return this.preadmissionnumber;
	}
	public void setPreadmissionNumber(String value)
	{
		this.preadmissionnumber = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateTimeOnHomeLeave()
	{
		return this.datetimeonhomeleave;
	}
	public void setDateTimeOnHomeLeave(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datetimeonhomeleave = value;
	}
	public ims.vo.LookupInstanceBean getMethodOfAdmission()
	{
		return this.methodofadmission;
	}
	public void setMethodOfAdmission(ims.vo.LookupInstanceBean value)
	{
		this.methodofadmission = value;
	}
	public ims.core.vo.beans.LocMostVoBean getWardLocation()
	{
		return this.wardlocation;
	}
	public void setWardLocation(ims.core.vo.beans.LocMostVoBean value)
	{
		this.wardlocation = value;
	}
	public ims.core.vo.beans.LocMostVoBean getPriorWardLocation()
	{
		return this.priorwardlocation;
	}
	public void setPriorWardLocation(ims.core.vo.beans.LocMostVoBean value)
	{
		this.priorwardlocation = value;
	}
	public ims.vo.LookupInstanceBean getElectiveAdmissionType()
	{
		return this.electiveadmissiontype;
	}
	public void setElectiveAdmissionType(ims.vo.LookupInstanceBean value)
	{
		this.electiveadmissiontype = value;
	}
	public ims.core.vo.beans.ifPendingTransferVoBean getPendingTransfer()
	{
		return this.pendingtransfer;
	}
	public void setPendingTransfer(ims.core.vo.beans.ifPendingTransferVoBean value)
	{
		this.pendingtransfer = value;
	}
	public Integer getEstLengthOfStay()
	{
		return this.estlengthofstay;
	}
	public void setEstLengthOfStay(Integer value)
	{
		this.estlengthofstay = value;
	}
	public ims.core.vo.beans.LocShortMappingsVoBean getBedSpaceStateBay()
	{
		return this.bedspacestatebay;
	}
	public void setBedSpaceStateBay(ims.core.vo.beans.LocShortMappingsVoBean value)
	{
		this.bedspacestatebay = value;
	}
	public ims.framework.utils.beans.DateTimeBean getExpectedDischargeDateTime()
	{
		return this.expecteddischargedatetime;
	}
	public void setExpectedDischargeDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.expecteddischargedatetime = value;
	}
	public ims.vo.LookupInstanceBean getMethodOfDischarge()
	{
		return this.methodofdischarge;
	}
	public void setMethodOfDischarge(ims.vo.LookupInstanceBean value)
	{
		this.methodofdischarge = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCurrentWardStayAdmissionDateTime()
	{
		return this.currentwardstayadmissiondatetime;
	}
	public void setCurrentWardStayAdmissionDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.currentwardstayadmissiondatetime = value;
	}
	public ims.vo.LookupInstanceBean getPriorTransferReason()
	{
		return this.priortransferreason;
	}
	public void setPriorTransferReason(ims.vo.LookupInstanceBean value)
	{
		this.priortransferreason = value;
	}
	public ims.vo.LookupInstanceBean getSourceOfEmergencyReferral()
	{
		return this.sourceofemergencyreferral;
	}
	public void setSourceOfEmergencyReferral(ims.vo.LookupInstanceBean value)
	{
		this.sourceofemergencyreferral = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAdmissionEventDateTime()
	{
		return this.admissioneventdatetime;
	}
	public void setAdmissionEventDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.admissioneventdatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDischargeEventDateTime()
	{
		return this.dischargeeventdatetime;
	}
	public void setDischargeEventDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.dischargeeventdatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getTransferEventDateTime()
	{
		return this.transfereventdatetime;
	}
	public void setTransferEventDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.transfereventdatetime = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PatientBean patient;
	private String paseventid;
	private ims.core.vo.beans.MedicWithMappingsLiteVoBean consultant;
	private ims.vo.LookupInstanceBean specialty;
	private ims.vo.LookupInstanceBean sourceofreferral;
	private Boolean isvip;
	private ims.core.vo.beans.GpLiteVoBean referringgp;
	private ims.vo.LookupInstanceBean eventtype;
	private String pasepisodeid;
	private ims.vo.LookupInstanceBean episodefinancialclass;
	private ims.core.vo.beans.HcpBean attendinghcp;
	private String pointofcare;
	private String bedno;
	private String facility;
	private String locationdescription;
	private String hospitalservice;
	private ims.vo.LookupInstanceBean admitsource;
	private ims.vo.LookupInstanceBean patienttype;
	private Boolean ischaplainrequired;
	private ims.vo.LookupInstanceBean tcitype;
	private ims.framework.utils.beans.DateTimeBean admissiondatetime;
	private ims.vo.LookupInstanceBean wardtype;
	private String admissionreason;
	private ims.vo.LookupInstanceBean dischargedisposition;
	private ims.vo.LookupInstanceBean dischargedestination;
	private ims.framework.utils.beans.DateTimeBean dischargedatetime;
	private ims.framework.utils.beans.DateTimeBean expectedloareturndatetime;
	private String priorpointofcare;
	private String priorbedno;
	private String priorfacilty;
	private String priorlocationdescription;
	private String preadmissionnumber;
	private ims.framework.utils.beans.DateTimeBean datetimeonhomeleave;
	private ims.vo.LookupInstanceBean methodofadmission;
	private ims.core.vo.beans.LocMostVoBean wardlocation;
	private ims.core.vo.beans.LocMostVoBean priorwardlocation;
	private ims.vo.LookupInstanceBean electiveadmissiontype;
	private ims.core.vo.beans.ifPendingTransferVoBean pendingtransfer;
	private Integer estlengthofstay;
	private ims.core.vo.beans.LocShortMappingsVoBean bedspacestatebay;
	private ims.framework.utils.beans.DateTimeBean expecteddischargedatetime;
	private ims.vo.LookupInstanceBean methodofdischarge;
	private ims.framework.utils.beans.DateTimeBean currentwardstayadmissiondatetime;
	private ims.vo.LookupInstanceBean priortransferreason;
	private ims.vo.LookupInstanceBean sourceofemergencyreferral;
	private ims.framework.utils.beans.DateTimeBean admissioneventdatetime;
	private ims.framework.utils.beans.DateTimeBean dischargeeventdatetime;
	private ims.framework.utils.beans.DateTimeBean transfereventdatetime;
}