//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.ocrr.vo.beans;

public class OrderInvestigationWebServiceVoBean extends ims.vo.ValueObjectBean
{
	public OrderInvestigationWebServiceVoBean()
	{
	}
	public OrderInvestigationWebServiceVoBean(ims.ocrr.vo.OrderInvestigationWebServiceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigation = vo.getInvestigation() == null ? null : (ims.ocrr.vo.beans.InvestigationUnderSpecimenVoBean)vo.getInvestigation().getBean();
		if(vo.getSpecimen() != null)
		{
			this.specimen = new ims.vo.RefVoBean[vo.getSpecimen().size()];
			for(int specimen_i = 0; specimen_i < vo.getSpecimen().size(); specimen_i++)
			{
				this.specimen[specimen_i] = new ims.vo.RefVoBean(vo.getSpecimen().get(specimen_i).getBoId(),vo.getSpecimen().get(specimen_i).getBoVersion());
			}
		}
		this.responsibleclinician = vo.getResponsibleClinician() == null ? null : new ims.vo.RefVoBean(vo.getResponsibleClinician().getBoId(), vo.getResponsibleClinician().getBoVersion());
		this.responsiblegp = vo.getResponsibleGp() == null ? null : new ims.vo.RefVoBean(vo.getResponsibleGp().getBoId(), vo.getResponsibleGp().getBoVersion());
		this.patientlocation = vo.getPatientLocation() == null ? null : new ims.vo.RefVoBean(vo.getPatientLocation().getBoId(), vo.getPatientLocation().getBoVersion());
		this.patientclinic = vo.getPatientClinic() == null ? null : new ims.vo.RefVoBean(vo.getPatientClinic().getBoId(), vo.getPatientClinic().getBoVersion());
		this.orderpriority = vo.getOrderPriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getOrderPriority().getBean();
		this.repdatetime = vo.getRepDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRepDateTime().getBean();
		this.reptimesupplied = vo.getRepTimeSupplied();
		this.displaydatetime = vo.getDisplayDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDisplayDateTime().getBean();
		this.displaytimesupplied = vo.getDisplayTimeSupplied();
		this.displayflag = vo.getDisplayFlag() == null ? null : (ims.vo.LookupInstanceBean)vo.getDisplayFlag().getBean();
		this.wasordered = vo.getWasOrdered();
		this.resultdemographics = vo.getResultDemographics() == null ? null : new ims.vo.RefVoBean(vo.getResultDemographics().getBoId(), vo.getResultDemographics().getBoVersion());
		this.resultstatus = vo.getResultStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getResultStatus().getBean();
		this.ordinvcurrentstatus = vo.getOrdInvCurrentStatus() == null ? null : (ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean)vo.getOrdInvCurrentStatus().getBean();
		if(vo.getOrdInvStatusHistory() != null)
		{
			this.ordinvstatushistory = new ims.vo.RefVoBean[vo.getOrdInvStatusHistory().size()];
			for(int ordinvstatushistory_i = 0; ordinvstatushistory_i < vo.getOrdInvStatusHistory().size(); ordinvstatushistory_i++)
			{
				this.ordinvstatushistory[ordinvstatushistory_i] = new ims.vo.RefVoBean(vo.getOrdInvStatusHistory().get(ordinvstatushistory_i).getBoId(),vo.getOrdInvStatusHistory().get(ordinvstatushistory_i).getBoVersion());
			}
		}
		this.fillerordnum = vo.getFillerOrdNum();
		this.radattendanceid = vo.getRadAttendanceId();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAppointmentDate().getBean();
		this.reasonforstudy = vo.getReasonForStudy();
		this.ordinvseq = vo.getOrdInvSeq();
		this.examreqonafterdate = vo.getExamReqOnAfterDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getExamReqOnAfterDate().getBean();
		this.requestedlocation = vo.getRequestedLocation() == null ? null : new ims.vo.RefVoBean(vo.getRequestedLocation().getBoId(), vo.getRequestedLocation().getBoVersion());
		this.performedlocation = vo.getPerformedLocation() == null ? null : new ims.vo.RefVoBean(vo.getPerformedLocation().getBoId(), vo.getPerformedLocation().getBoVersion());
		this.wasprocessed = vo.getWasProcessed();
		if(vo.getResultHistory() != null)
		{
			this.resulthistory = new ims.vo.RefVoBean[vo.getResultHistory().size()];
			for(int resulthistory_i = 0; resulthistory_i < vo.getResultHistory().size(); resulthistory_i++)
			{
				this.resulthistory[resulthistory_i] = new ims.vo.RefVoBean(vo.getResultHistory().get(resulthistory_i).getBoId(),vo.getResultHistory().get(resulthistory_i).getBoVersion());
			}
		}
		this.entertheatredate = vo.getEnterTheatreDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEnterTheatreDate().getBean();
		this.startproceduredate = vo.getStartProcedureDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStartProcedureDate().getBean();
		this.endproceduredate = vo.getEndProcedureDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEndProcedureDate().getBean();
		this.leaverecoverydate = vo.getLeaveRecoveryDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getLeaveRecoveryDate().getBean();
		this.reporturl = vo.getReportUrl();
		this.reportdocumenturl = vo.getReportDocumentUrl();
		this.investigationdatetime = vo.getInvestigationDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getInvestigationDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.OrderInvestigationWebServiceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigation = vo.getInvestigation() == null ? null : (ims.ocrr.vo.beans.InvestigationUnderSpecimenVoBean)vo.getInvestigation().getBean(map);
		if(vo.getSpecimen() != null)
		{
			this.specimen = new ims.vo.RefVoBean[vo.getSpecimen().size()];
			for(int specimen_i = 0; specimen_i < vo.getSpecimen().size(); specimen_i++)
			{
				this.specimen[specimen_i] = new ims.vo.RefVoBean(vo.getSpecimen().get(specimen_i).getBoId(),vo.getSpecimen().get(specimen_i).getBoVersion());
			}
		}
		this.responsibleclinician = vo.getResponsibleClinician() == null ? null : new ims.vo.RefVoBean(vo.getResponsibleClinician().getBoId(), vo.getResponsibleClinician().getBoVersion());
		this.responsiblegp = vo.getResponsibleGp() == null ? null : new ims.vo.RefVoBean(vo.getResponsibleGp().getBoId(), vo.getResponsibleGp().getBoVersion());
		this.patientlocation = vo.getPatientLocation() == null ? null : new ims.vo.RefVoBean(vo.getPatientLocation().getBoId(), vo.getPatientLocation().getBoVersion());
		this.patientclinic = vo.getPatientClinic() == null ? null : new ims.vo.RefVoBean(vo.getPatientClinic().getBoId(), vo.getPatientClinic().getBoVersion());
		this.orderpriority = vo.getOrderPriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getOrderPriority().getBean();
		this.repdatetime = vo.getRepDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRepDateTime().getBean();
		this.reptimesupplied = vo.getRepTimeSupplied();
		this.displaydatetime = vo.getDisplayDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDisplayDateTime().getBean();
		this.displaytimesupplied = vo.getDisplayTimeSupplied();
		this.displayflag = vo.getDisplayFlag() == null ? null : (ims.vo.LookupInstanceBean)vo.getDisplayFlag().getBean();
		this.wasordered = vo.getWasOrdered();
		this.resultdemographics = vo.getResultDemographics() == null ? null : new ims.vo.RefVoBean(vo.getResultDemographics().getBoId(), vo.getResultDemographics().getBoVersion());
		this.resultstatus = vo.getResultStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getResultStatus().getBean();
		this.ordinvcurrentstatus = vo.getOrdInvCurrentStatus() == null ? null : (ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean)vo.getOrdInvCurrentStatus().getBean(map);
		if(vo.getOrdInvStatusHistory() != null)
		{
			this.ordinvstatushistory = new ims.vo.RefVoBean[vo.getOrdInvStatusHistory().size()];
			for(int ordinvstatushistory_i = 0; ordinvstatushistory_i < vo.getOrdInvStatusHistory().size(); ordinvstatushistory_i++)
			{
				this.ordinvstatushistory[ordinvstatushistory_i] = new ims.vo.RefVoBean(vo.getOrdInvStatusHistory().get(ordinvstatushistory_i).getBoId(),vo.getOrdInvStatusHistory().get(ordinvstatushistory_i).getBoVersion());
			}
		}
		this.fillerordnum = vo.getFillerOrdNum();
		this.radattendanceid = vo.getRadAttendanceId();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAppointmentDate().getBean();
		this.reasonforstudy = vo.getReasonForStudy();
		this.ordinvseq = vo.getOrdInvSeq();
		this.examreqonafterdate = vo.getExamReqOnAfterDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getExamReqOnAfterDate().getBean();
		this.requestedlocation = vo.getRequestedLocation() == null ? null : new ims.vo.RefVoBean(vo.getRequestedLocation().getBoId(), vo.getRequestedLocation().getBoVersion());
		this.performedlocation = vo.getPerformedLocation() == null ? null : new ims.vo.RefVoBean(vo.getPerformedLocation().getBoId(), vo.getPerformedLocation().getBoVersion());
		this.wasprocessed = vo.getWasProcessed();
		if(vo.getResultHistory() != null)
		{
			this.resulthistory = new ims.vo.RefVoBean[vo.getResultHistory().size()];
			for(int resulthistory_i = 0; resulthistory_i < vo.getResultHistory().size(); resulthistory_i++)
			{
				this.resulthistory[resulthistory_i] = new ims.vo.RefVoBean(vo.getResultHistory().get(resulthistory_i).getBoId(),vo.getResultHistory().get(resulthistory_i).getBoVersion());
			}
		}
		this.entertheatredate = vo.getEnterTheatreDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEnterTheatreDate().getBean();
		this.startproceduredate = vo.getStartProcedureDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStartProcedureDate().getBean();
		this.endproceduredate = vo.getEndProcedureDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEndProcedureDate().getBean();
		this.leaverecoverydate = vo.getLeaveRecoveryDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getLeaveRecoveryDate().getBean();
		this.reporturl = vo.getReportUrl();
		this.reportdocumenturl = vo.getReportDocumentUrl();
		this.investigationdatetime = vo.getInvestigationDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getInvestigationDateTime().getBean();
	}

	public ims.ocrr.vo.OrderInvestigationWebServiceVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.OrderInvestigationWebServiceVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.OrderInvestigationWebServiceVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.OrderInvestigationWebServiceVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.OrderInvestigationWebServiceVo();
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
	public ims.ocrr.vo.beans.InvestigationUnderSpecimenVoBean getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.beans.InvestigationUnderSpecimenVoBean value)
	{
		this.investigation = value;
	}
	public ims.vo.RefVoBean[] getSpecimen()
	{
		return this.specimen;
	}
	public void setSpecimen(ims.vo.RefVoBean[] value)
	{
		this.specimen = value;
	}
	public ims.vo.RefVoBean getResponsibleClinician()
	{
		return this.responsibleclinician;
	}
	public void setResponsibleClinician(ims.vo.RefVoBean value)
	{
		this.responsibleclinician = value;
	}
	public ims.vo.RefVoBean getResponsibleGp()
	{
		return this.responsiblegp;
	}
	public void setResponsibleGp(ims.vo.RefVoBean value)
	{
		this.responsiblegp = value;
	}
	public ims.vo.RefVoBean getPatientLocation()
	{
		return this.patientlocation;
	}
	public void setPatientLocation(ims.vo.RefVoBean value)
	{
		this.patientlocation = value;
	}
	public ims.vo.RefVoBean getPatientClinic()
	{
		return this.patientclinic;
	}
	public void setPatientClinic(ims.vo.RefVoBean value)
	{
		this.patientclinic = value;
	}
	public ims.vo.LookupInstanceBean getOrderPriority()
	{
		return this.orderpriority;
	}
	public void setOrderPriority(ims.vo.LookupInstanceBean value)
	{
		this.orderpriority = value;
	}
	public ims.framework.utils.beans.DateTimeBean getRepDateTime()
	{
		return this.repdatetime;
	}
	public void setRepDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.repdatetime = value;
	}
	public Boolean getRepTimeSupplied()
	{
		return this.reptimesupplied;
	}
	public void setRepTimeSupplied(Boolean value)
	{
		this.reptimesupplied = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDisplayDateTime()
	{
		return this.displaydatetime;
	}
	public void setDisplayDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.displaydatetime = value;
	}
	public Boolean getDisplayTimeSupplied()
	{
		return this.displaytimesupplied;
	}
	public void setDisplayTimeSupplied(Boolean value)
	{
		this.displaytimesupplied = value;
	}
	public ims.vo.LookupInstanceBean getDisplayFlag()
	{
		return this.displayflag;
	}
	public void setDisplayFlag(ims.vo.LookupInstanceBean value)
	{
		this.displayflag = value;
	}
	public Boolean getWasOrdered()
	{
		return this.wasordered;
	}
	public void setWasOrdered(Boolean value)
	{
		this.wasordered = value;
	}
	public ims.vo.RefVoBean getResultDemographics()
	{
		return this.resultdemographics;
	}
	public void setResultDemographics(ims.vo.RefVoBean value)
	{
		this.resultdemographics = value;
	}
	public ims.vo.LookupInstanceBean getResultStatus()
	{
		return this.resultstatus;
	}
	public void setResultStatus(ims.vo.LookupInstanceBean value)
	{
		this.resultstatus = value;
	}
	public ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean getOrdInvCurrentStatus()
	{
		return this.ordinvcurrentstatus;
	}
	public void setOrdInvCurrentStatus(ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean value)
	{
		this.ordinvcurrentstatus = value;
	}
	public ims.vo.RefVoBean[] getOrdInvStatusHistory()
	{
		return this.ordinvstatushistory;
	}
	public void setOrdInvStatusHistory(ims.vo.RefVoBean[] value)
	{
		this.ordinvstatushistory = value;
	}
	public String getFillerOrdNum()
	{
		return this.fillerordnum;
	}
	public void setFillerOrdNum(String value)
	{
		this.fillerordnum = value;
	}
	public String getRadAttendanceId()
	{
		return this.radattendanceid;
	}
	public void setRadAttendanceId(String value)
	{
		this.radattendanceid = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.appointmentdate = value;
	}
	public String getReasonForStudy()
	{
		return this.reasonforstudy;
	}
	public void setReasonForStudy(String value)
	{
		this.reasonforstudy = value;
	}
	public Integer getOrdInvSeq()
	{
		return this.ordinvseq;
	}
	public void setOrdInvSeq(Integer value)
	{
		this.ordinvseq = value;
	}
	public ims.framework.utils.beans.DateBean getExamReqOnAfterDate()
	{
		return this.examreqonafterdate;
	}
	public void setExamReqOnAfterDate(ims.framework.utils.beans.DateBean value)
	{
		this.examreqonafterdate = value;
	}
	public ims.vo.RefVoBean getRequestedLocation()
	{
		return this.requestedlocation;
	}
	public void setRequestedLocation(ims.vo.RefVoBean value)
	{
		this.requestedlocation = value;
	}
	public ims.vo.RefVoBean getPerformedLocation()
	{
		return this.performedlocation;
	}
	public void setPerformedLocation(ims.vo.RefVoBean value)
	{
		this.performedlocation = value;
	}
	public Boolean getWasProcessed()
	{
		return this.wasprocessed;
	}
	public void setWasProcessed(Boolean value)
	{
		this.wasprocessed = value;
	}
	public ims.vo.RefVoBean[] getResultHistory()
	{
		return this.resulthistory;
	}
	public void setResultHistory(ims.vo.RefVoBean[] value)
	{
		this.resulthistory = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEnterTheatreDate()
	{
		return this.entertheatredate;
	}
	public void setEnterTheatreDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.entertheatredate = value;
	}
	public ims.framework.utils.beans.DateTimeBean getStartProcedureDate()
	{
		return this.startproceduredate;
	}
	public void setStartProcedureDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.startproceduredate = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEndProcedureDate()
	{
		return this.endproceduredate;
	}
	public void setEndProcedureDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.endproceduredate = value;
	}
	public ims.framework.utils.beans.DateTimeBean getLeaveRecoveryDate()
	{
		return this.leaverecoverydate;
	}
	public void setLeaveRecoveryDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.leaverecoverydate = value;
	}
	public String getReportUrl()
	{
		return this.reporturl;
	}
	public void setReportUrl(String value)
	{
		this.reporturl = value;
	}
	public String getReportDocumentUrl()
	{
		return this.reportdocumenturl;
	}
	public void setReportDocumentUrl(String value)
	{
		this.reportdocumenturl = value;
	}
	public ims.framework.utils.beans.DateTimeBean getInvestigationDateTime()
	{
		return this.investigationdatetime;
	}
	public void setInvestigationDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.investigationdatetime = value;
	}

	private Integer id;
	private int version;
	private ims.ocrr.vo.beans.InvestigationUnderSpecimenVoBean investigation;
	private ims.vo.RefVoBean[] specimen;
	private ims.vo.RefVoBean responsibleclinician;
	private ims.vo.RefVoBean responsiblegp;
	private ims.vo.RefVoBean patientlocation;
	private ims.vo.RefVoBean patientclinic;
	private ims.vo.LookupInstanceBean orderpriority;
	private ims.framework.utils.beans.DateTimeBean repdatetime;
	private Boolean reptimesupplied;
	private ims.framework.utils.beans.DateTimeBean displaydatetime;
	private Boolean displaytimesupplied;
	private ims.vo.LookupInstanceBean displayflag;
	private Boolean wasordered;
	private ims.vo.RefVoBean resultdemographics;
	private ims.vo.LookupInstanceBean resultstatus;
	private ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean ordinvcurrentstatus;
	private ims.vo.RefVoBean[] ordinvstatushistory;
	private String fillerordnum;
	private String radattendanceid;
	private ims.framework.utils.beans.DateTimeBean appointmentdate;
	private String reasonforstudy;
	private Integer ordinvseq;
	private ims.framework.utils.beans.DateBean examreqonafterdate;
	private ims.vo.RefVoBean requestedlocation;
	private ims.vo.RefVoBean performedlocation;
	private Boolean wasprocessed;
	private ims.vo.RefVoBean[] resulthistory;
	private ims.framework.utils.beans.DateTimeBean entertheatredate;
	private ims.framework.utils.beans.DateTimeBean startproceduredate;
	private ims.framework.utils.beans.DateTimeBean endproceduredate;
	private ims.framework.utils.beans.DateTimeBean leaverecoverydate;
	private String reporturl;
	private String reportdocumenturl;
	private ims.framework.utils.beans.DateTimeBean investigationdatetime;
}
