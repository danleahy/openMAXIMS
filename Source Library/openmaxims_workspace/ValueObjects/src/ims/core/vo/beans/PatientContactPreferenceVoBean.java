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

public class PatientContactPreferenceVoBean extends ims.vo.ValueObjectBean
{
	public PatientContactPreferenceVoBean()
	{
	}
	public PatientContactPreferenceVoBean(ims.core.vo.PatientContactPreferenceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.contactname = vo.getContactName();
		this.preferredcontacttimes = vo.getPreferredContactTimes() == null ? null : (ims.vo.LookupInstanceBean)vo.getPreferredContactTimes().getBean();
		this.patientcallbackconsent = vo.getPatientCallBackConsent();
		this.pdspreferredcontacttimes = vo.getPdsPreferredContactTimes();
		this.pdspreferredwrittencomm = vo.getPdsPreferredWrittenComm() == null ? null : (ims.vo.LookupInstanceBean)vo.getPdsPreferredWrittenComm().getBean();
		this.pdsconsent = vo.getPdsConsent() == null ? null : (ims.vo.LookupInstanceBean)vo.getPdsConsent().getBean();
		this.pdsdatelastchanged = vo.getPdsDateLastChanged() == null ? null : (ims.framework.utils.beans.DateBean)vo.getPdsDateLastChanged().getBean();
		this.preferredcontactmethod = vo.getPreferredContactMethod() == null ? null : (ims.vo.LookupInstanceBean)vo.getPreferredContactMethod().getBean();
		this.pdspreferredcontactmethod = vo.getPdsPreferredContactMethod() == null ? null : (ims.vo.LookupInstanceBean)vo.getPdsPreferredContactMethod().getBean();
		this.optoutofreminders = vo.getOptOutOfReminders();
		this.pdsconsenttype = vo.getPdsConsentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getPdsConsentType().getBean();
		this.pdsupdatemode = vo.getPdsUpdateMode() == null ? null : (ims.vo.LookupInstanceBean)vo.getPdsUpdateMode().getBean();
		this.comment = vo.getComment();
		this.consenthistory = vo.getConsentHistory() == null ? null : vo.getConsentHistory().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientContactPreferenceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.contactname = vo.getContactName();
		this.preferredcontacttimes = vo.getPreferredContactTimes() == null ? null : (ims.vo.LookupInstanceBean)vo.getPreferredContactTimes().getBean();
		this.patientcallbackconsent = vo.getPatientCallBackConsent();
		this.pdspreferredcontacttimes = vo.getPdsPreferredContactTimes();
		this.pdspreferredwrittencomm = vo.getPdsPreferredWrittenComm() == null ? null : (ims.vo.LookupInstanceBean)vo.getPdsPreferredWrittenComm().getBean();
		this.pdsconsent = vo.getPdsConsent() == null ? null : (ims.vo.LookupInstanceBean)vo.getPdsConsent().getBean();
		this.pdsdatelastchanged = vo.getPdsDateLastChanged() == null ? null : (ims.framework.utils.beans.DateBean)vo.getPdsDateLastChanged().getBean();
		this.preferredcontactmethod = vo.getPreferredContactMethod() == null ? null : (ims.vo.LookupInstanceBean)vo.getPreferredContactMethod().getBean();
		this.pdspreferredcontactmethod = vo.getPdsPreferredContactMethod() == null ? null : (ims.vo.LookupInstanceBean)vo.getPdsPreferredContactMethod().getBean();
		this.optoutofreminders = vo.getOptOutOfReminders();
		this.pdsconsenttype = vo.getPdsConsentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getPdsConsentType().getBean();
		this.pdsupdatemode = vo.getPdsUpdateMode() == null ? null : (ims.vo.LookupInstanceBean)vo.getPdsUpdateMode().getBean();
		this.comment = vo.getComment();
		this.consenthistory = vo.getConsentHistory() == null ? null : vo.getConsentHistory().getBeanCollection();
	}

	public ims.core.vo.PatientContactPreferenceVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientContactPreferenceVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientContactPreferenceVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientContactPreferenceVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientContactPreferenceVo();
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
	public String getContactName()
	{
		return this.contactname;
	}
	public void setContactName(String value)
	{
		this.contactname = value;
	}
	public ims.vo.LookupInstanceBean getPreferredContactTimes()
	{
		return this.preferredcontacttimes;
	}
	public void setPreferredContactTimes(ims.vo.LookupInstanceBean value)
	{
		this.preferredcontacttimes = value;
	}
	public Boolean getPatientCallBackConsent()
	{
		return this.patientcallbackconsent;
	}
	public void setPatientCallBackConsent(Boolean value)
	{
		this.patientcallbackconsent = value;
	}
	public String getPdsPreferredContactTimes()
	{
		return this.pdspreferredcontacttimes;
	}
	public void setPdsPreferredContactTimes(String value)
	{
		this.pdspreferredcontacttimes = value;
	}
	public ims.vo.LookupInstanceBean getPdsPreferredWrittenComm()
	{
		return this.pdspreferredwrittencomm;
	}
	public void setPdsPreferredWrittenComm(ims.vo.LookupInstanceBean value)
	{
		this.pdspreferredwrittencomm = value;
	}
	public ims.vo.LookupInstanceBean getPdsConsent()
	{
		return this.pdsconsent;
	}
	public void setPdsConsent(ims.vo.LookupInstanceBean value)
	{
		this.pdsconsent = value;
	}
	public ims.framework.utils.beans.DateBean getPdsDateLastChanged()
	{
		return this.pdsdatelastchanged;
	}
	public void setPdsDateLastChanged(ims.framework.utils.beans.DateBean value)
	{
		this.pdsdatelastchanged = value;
	}
	public ims.vo.LookupInstanceBean getPreferredContactMethod()
	{
		return this.preferredcontactmethod;
	}
	public void setPreferredContactMethod(ims.vo.LookupInstanceBean value)
	{
		this.preferredcontactmethod = value;
	}
	public ims.vo.LookupInstanceBean getPdsPreferredContactMethod()
	{
		return this.pdspreferredcontactmethod;
	}
	public void setPdsPreferredContactMethod(ims.vo.LookupInstanceBean value)
	{
		this.pdspreferredcontactmethod = value;
	}
	public Boolean getOptOutOfReminders()
	{
		return this.optoutofreminders;
	}
	public void setOptOutOfReminders(Boolean value)
	{
		this.optoutofreminders = value;
	}
	public ims.vo.LookupInstanceBean getPdsConsentType()
	{
		return this.pdsconsenttype;
	}
	public void setPdsConsentType(ims.vo.LookupInstanceBean value)
	{
		this.pdsconsenttype = value;
	}
	public ims.vo.LookupInstanceBean getPdsUpdateMode()
	{
		return this.pdsupdatemode;
	}
	public void setPdsUpdateMode(ims.vo.LookupInstanceBean value)
	{
		this.pdsupdatemode = value;
	}
	public String getComment()
	{
		return this.comment;
	}
	public void setComment(String value)
	{
		this.comment = value;
	}
	public ims.core.vo.beans.PDSConsentHistoryVoBean[] getConsentHistory()
	{
		return this.consenthistory;
	}
	public void setConsentHistory(ims.core.vo.beans.PDSConsentHistoryVoBean[] value)
	{
		this.consenthistory = value;
	}

	private Integer id;
	private int version;
	private String contactname;
	private ims.vo.LookupInstanceBean preferredcontacttimes;
	private Boolean patientcallbackconsent;
	private String pdspreferredcontacttimes;
	private ims.vo.LookupInstanceBean pdspreferredwrittencomm;
	private ims.vo.LookupInstanceBean pdsconsent;
	private ims.framework.utils.beans.DateBean pdsdatelastchanged;
	private ims.vo.LookupInstanceBean preferredcontactmethod;
	private ims.vo.LookupInstanceBean pdspreferredcontactmethod;
	private Boolean optoutofreminders;
	private ims.vo.LookupInstanceBean pdsconsenttype;
	private ims.vo.LookupInstanceBean pdsupdatemode;
	private String comment;
	private ims.core.vo.beans.PDSConsentHistoryVoBean[] consenthistory;
}
