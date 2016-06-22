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

package ims.scheduling.vo.beans;

public class Appointment_StatusVoBean extends ims.vo.ValueObjectBean
{
	public Appointment_StatusVoBean()
	{
	}
	public Appointment_StatusVoBean(ims.scheduling.vo.Appointment_StatusVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.statusreason = vo.getStatusReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatusReason().getBean();
		this.apptdate = vo.getApptDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getApptDate().getBean();
		this.appttime = vo.getApptTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptTime().getBean();
		this.pasclinic = vo.getPASClinic() == null ? null : (ims.vo.LookupInstanceBean)vo.getPASClinic().getBean();
		this.dos = vo.getDoS() == null ? null : new ims.vo.RefVoBean(vo.getDoS().getBoId(), vo.getDoS().getBoVersion());
		this.priority = vo.getPriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getPriority().getBean();
		this.cancellationreason = vo.getCancellationReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancellationReason().getBean();
		this.comment = vo.getComment();
		this.rebookselected = vo.getRebookSelected();
		this.earliestoffereddate = vo.getEarliestOfferedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEarliestOfferedDate().getBean();
		this.statuschangedatetime = vo.getStatusChangeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStatusChangeDateTime().getBean();
		this.sysinformation = vo.getSysInformation() == null ? null : (ims.vo.SysInfoBean)vo.getSysInformation().getBean();
		this.canceltci = vo.getCancelTCI();
		this.cancelledfornonmedicalreason = vo.getCancelledForNonMedicalReason();
		this.tcidate = vo.getTCIDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTCIDate().getBean();
		this.wasletterprinted = vo.getWasLetterPrinted();
		this.couldnotbeseen = vo.getCouldnotbeseen();
		this.careprofessionalreadytosee = vo.getCareProfessionalReadyToSee();
		this.careprofessionalnotreadytosee = vo.getCareProfessionalNotReadyToSee();
		this.session = vo.getSession() == null ? null : new ims.vo.RefVoBean(vo.getSession().getBoId(), vo.getSession().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.Appointment_StatusVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.statusreason = vo.getStatusReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatusReason().getBean();
		this.apptdate = vo.getApptDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getApptDate().getBean();
		this.appttime = vo.getApptTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptTime().getBean();
		this.pasclinic = vo.getPASClinic() == null ? null : (ims.vo.LookupInstanceBean)vo.getPASClinic().getBean();
		this.dos = vo.getDoS() == null ? null : new ims.vo.RefVoBean(vo.getDoS().getBoId(), vo.getDoS().getBoVersion());
		this.priority = vo.getPriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getPriority().getBean();
		this.cancellationreason = vo.getCancellationReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancellationReason().getBean();
		this.comment = vo.getComment();
		this.rebookselected = vo.getRebookSelected();
		this.earliestoffereddate = vo.getEarliestOfferedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEarliestOfferedDate().getBean();
		this.statuschangedatetime = vo.getStatusChangeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStatusChangeDateTime().getBean();
		this.sysinformation = vo.getSysInformation() == null ? null : (ims.vo.SysInfoBean)vo.getSysInformation().getBean();
		this.canceltci = vo.getCancelTCI();
		this.cancelledfornonmedicalreason = vo.getCancelledForNonMedicalReason();
		this.tcidate = vo.getTCIDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTCIDate().getBean();
		this.wasletterprinted = vo.getWasLetterPrinted();
		this.couldnotbeseen = vo.getCouldnotbeseen();
		this.careprofessionalreadytosee = vo.getCareProfessionalReadyToSee();
		this.careprofessionalnotreadytosee = vo.getCareProfessionalNotReadyToSee();
		this.session = vo.getSession() == null ? null : new ims.vo.RefVoBean(vo.getSession().getBoId(), vo.getSession().getBoVersion());
	}

	public ims.scheduling.vo.Appointment_StatusVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.Appointment_StatusVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.Appointment_StatusVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.Appointment_StatusVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.Appointment_StatusVo();
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
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.vo.LookupInstanceBean getStatusReason()
	{
		return this.statusreason;
	}
	public void setStatusReason(ims.vo.LookupInstanceBean value)
	{
		this.statusreason = value;
	}
	public ims.framework.utils.beans.DateBean getApptDate()
	{
		return this.apptdate;
	}
	public void setApptDate(ims.framework.utils.beans.DateBean value)
	{
		this.apptdate = value;
	}
	public ims.framework.utils.beans.TimeBean getApptTime()
	{
		return this.appttime;
	}
	public void setApptTime(ims.framework.utils.beans.TimeBean value)
	{
		this.appttime = value;
	}
	public ims.vo.LookupInstanceBean getPASClinic()
	{
		return this.pasclinic;
	}
	public void setPASClinic(ims.vo.LookupInstanceBean value)
	{
		this.pasclinic = value;
	}
	public ims.vo.RefVoBean getDoS()
	{
		return this.dos;
	}
	public void setDoS(ims.vo.RefVoBean value)
	{
		this.dos = value;
	}
	public ims.vo.LookupInstanceBean getPriority()
	{
		return this.priority;
	}
	public void setPriority(ims.vo.LookupInstanceBean value)
	{
		this.priority = value;
	}
	public ims.vo.LookupInstanceBean getCancellationReason()
	{
		return this.cancellationreason;
	}
	public void setCancellationReason(ims.vo.LookupInstanceBean value)
	{
		this.cancellationreason = value;
	}
	public String getComment()
	{
		return this.comment;
	}
	public void setComment(String value)
	{
		this.comment = value;
	}
	public Boolean getRebookSelected()
	{
		return this.rebookselected;
	}
	public void setRebookSelected(Boolean value)
	{
		this.rebookselected = value;
	}
	public ims.framework.utils.beans.DateBean getEarliestOfferedDate()
	{
		return this.earliestoffereddate;
	}
	public void setEarliestOfferedDate(ims.framework.utils.beans.DateBean value)
	{
		this.earliestoffereddate = value;
	}
	public ims.framework.utils.beans.DateTimeBean getStatusChangeDateTime()
	{
		return this.statuschangedatetime;
	}
	public void setStatusChangeDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.statuschangedatetime = value;
	}
	public ims.vo.SysInfoBean getSysInformation()
	{
		return this.sysinformation;
	}
	public void setSysInformation(ims.vo.SysInfoBean value)
	{
		this.sysinformation = value;
	}
	public Boolean getCancelTCI()
	{
		return this.canceltci;
	}
	public void setCancelTCI(Boolean value)
	{
		this.canceltci = value;
	}
	public Boolean getCancelledForNonMedicalReason()
	{
		return this.cancelledfornonmedicalreason;
	}
	public void setCancelledForNonMedicalReason(Boolean value)
	{
		this.cancelledfornonmedicalreason = value;
	}
	public ims.framework.utils.beans.DateBean getTCIDate()
	{
		return this.tcidate;
	}
	public void setTCIDate(ims.framework.utils.beans.DateBean value)
	{
		this.tcidate = value;
	}
	public Boolean getWasLetterPrinted()
	{
		return this.wasletterprinted;
	}
	public void setWasLetterPrinted(Boolean value)
	{
		this.wasletterprinted = value;
	}
	public Boolean getCouldnotbeseen()
	{
		return this.couldnotbeseen;
	}
	public void setCouldnotbeseen(Boolean value)
	{
		this.couldnotbeseen = value;
	}
	public Boolean getCareProfessionalReadyToSee()
	{
		return this.careprofessionalreadytosee;
	}
	public void setCareProfessionalReadyToSee(Boolean value)
	{
		this.careprofessionalreadytosee = value;
	}
	public Boolean getCareProfessionalNotReadyToSee()
	{
		return this.careprofessionalnotreadytosee;
	}
	public void setCareProfessionalNotReadyToSee(Boolean value)
	{
		this.careprofessionalnotreadytosee = value;
	}
	public ims.vo.RefVoBean getSession()
	{
		return this.session;
	}
	public void setSession(ims.vo.RefVoBean value)
	{
		this.session = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean status;
	private ims.vo.LookupInstanceBean statusreason;
	private ims.framework.utils.beans.DateBean apptdate;
	private ims.framework.utils.beans.TimeBean appttime;
	private ims.vo.LookupInstanceBean pasclinic;
	private ims.vo.RefVoBean dos;
	private ims.vo.LookupInstanceBean priority;
	private ims.vo.LookupInstanceBean cancellationreason;
	private String comment;
	private Boolean rebookselected;
	private ims.framework.utils.beans.DateBean earliestoffereddate;
	private ims.framework.utils.beans.DateTimeBean statuschangedatetime;
	private ims.vo.SysInfoBean sysinformation;
	private Boolean canceltci;
	private Boolean cancelledfornonmedicalreason;
	private ims.framework.utils.beans.DateBean tcidate;
	private Boolean wasletterprinted;
	private Boolean couldnotbeseen;
	private Boolean careprofessionalreadytosee;
	private Boolean careprofessionalnotreadytosee;
	private ims.vo.RefVoBean session;
}
