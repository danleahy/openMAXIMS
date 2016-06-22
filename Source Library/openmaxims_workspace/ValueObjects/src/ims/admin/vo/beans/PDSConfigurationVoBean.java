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

package ims.admin.vo.beans;

public class PDSConfigurationVoBean extends ims.vo.ValueObjectBean
{
	public PDSConfigurationVoBean()
	{
	}
	public PDSConfigurationVoBean(ims.admin.vo.PDSConfigurationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dob_date_range = vo.getDOB_DATE_RANGE();
		this.dod_date_range = vo.getDOD_DATE_RANGE();
		this.trace_advanced_ignore_history = vo.getTRACE_ADVANCED_IGNORE_HISTORY();
		this.trace_history_data_indicator = vo.getTRACE_HISTORY_DATA_INDICATOR();
		this.use_lpi_crosscheck = vo.getUSE_LPI_CROSSCHECK();
		this.no_fixed_abode_postcode = vo.getNO_FIXED_ABODE_POSTCODE();
		this.advanced_search_timer_interval = vo.getADVANCED_SEARCH_TIMER_INTERVAL();
		this.pds_backoffice_notificati = vo.getPDS_BACKOFFICE_NOTIFICATI() == null ? null : new ims.vo.RefVoBean(vo.getPDS_BACKOFFICE_NOTIFICATI().getBoId(), vo.getPDS_BACKOFFICE_NOTIFICATI().getBoVersion());
		this.numofdaysappointbatchtrace = vo.getNumOfDaysAppointBatchTrace();
		this.numofdaystcibatchtrace = vo.getNumOfDaysTCIBatchTrace();
		this.numofdaysfornextpdscheck = vo.getNumOfDaysForNextPDSCheck();
		this.synchronise_with_backoffice = vo.getSYNCHRONISE_WITH_BACKOFFICE();
		this.frompdsaccreditedsystemid = vo.getFromPDSAccreditedSystemId();
		this.topdsaccreditedsystemid = vo.getToPDSAccreditedSystemId();
		this.pds_config_file = vo.getPDS_CONFIG_FILE();
		this.pds_store_message_loc = vo.getPDS_STORE_MESSAGE_LOC();
		this.pds_store_message = vo.getPDS_STORE_MESSAGE();
		this.start_pds_gateway = vo.getSTART_PDS_GATEWAY();
		this.pds_msh_repository = vo.getPDS_MSH_REPOSITORY();
		this.pds_msh_url = vo.getPDS_MSH_URL();
		this.create_bo_notifications = vo.getCREATE_BO_NOTIFICATIONS();
		this.sdshost = vo.getSDSHost();
		this.sdsport = vo.getSDSPort();
		this.pds_url = vo.getPDS_URL();
		this.pds_host = vo.getPDS_HOST();
		this.pds_store_sync_message = vo.getPDS_STORE_SYNC_MESSAGE();
		this.pds_store_sync_message_loc = vo.getPDS_STORE_SYNC_MESSAGE_LOC();
		this.consentchangemessage = vo.getConsentChangeMessage();
		this.inactivepatientrecordbgcolour = vo.getInactivePatientRecordBgColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getInactivePatientRecordBgColour().getBean();
		this.decouple_on_decease = vo.getDECOUPLE_ON_DECEASE();
		this.notify_on_decease = vo.getNOTIFY_ON_DECEASE();
		this.decouple_on_sync_required = vo.getDECOUPLE_ON_SYNC_REQUIRED();
		this.pds_authentication = vo.getPDS_AUTHENTICATION();
		this.rbac_pdssearchforpatient = vo.getRBAC_PdsSearchForPatient();
		this.rbac_pdssearchpatientadvanced = vo.getRBAC_PdsSearchPatientAdvanced();
		this.rbac_pdsretrieval = vo.getRBAC_PdsRetrieval();
		this.rbac_accesssensitivedata = vo.getRBAC_AccessSensitiveData();
		this.rbac_amendpatient = vo.getRBAC_AmendPatient();
		this.rbac_controlconsent = vo.getRBAC_ControlConsent();
		this.rbac_amendpatientdecease = vo.getRBAC_AmendPatientDecease();
		this.rbac_postcodesearch = vo.getRBAC_PostcodeSearch();
		this.pds_display_consent = vo.getPDS_DISPLAY_CONSENT();
		this.dob_date_range_type = vo.getDOB_DATE_RANGE_TYPE() == null ? null : (ims.vo.LookupInstanceBean)vo.getDOB_DATE_RANGE_TYPE().getBean();
		this.dod_date_range_type = vo.getDOD_DATE_RANGE_TYPE() == null ? null : (ims.vo.LookupInstanceBean)vo.getDOD_DATE_RANGE_TYPE().getBean();
		this.tp_bookoutpatientappt = vo.getTP_BookOutpatientAppt();
		this.tp_bookwardattenderappt = vo.getTP_BookWardAttenderAppt();
		this.tp_createtciandtheatrebooking = vo.getTP_CreateTCIAndTheatreBooking();
		this.tp_anyadmission = vo.getTP_AnyAdmission();
		this.tp_anyapptarrival = vo.getTP_AnyApptArrival();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.PDSConfigurationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dob_date_range = vo.getDOB_DATE_RANGE();
		this.dod_date_range = vo.getDOD_DATE_RANGE();
		this.trace_advanced_ignore_history = vo.getTRACE_ADVANCED_IGNORE_HISTORY();
		this.trace_history_data_indicator = vo.getTRACE_HISTORY_DATA_INDICATOR();
		this.use_lpi_crosscheck = vo.getUSE_LPI_CROSSCHECK();
		this.no_fixed_abode_postcode = vo.getNO_FIXED_ABODE_POSTCODE();
		this.advanced_search_timer_interval = vo.getADVANCED_SEARCH_TIMER_INTERVAL();
		this.pds_backoffice_notificati = vo.getPDS_BACKOFFICE_NOTIFICATI() == null ? null : new ims.vo.RefVoBean(vo.getPDS_BACKOFFICE_NOTIFICATI().getBoId(), vo.getPDS_BACKOFFICE_NOTIFICATI().getBoVersion());
		this.numofdaysappointbatchtrace = vo.getNumOfDaysAppointBatchTrace();
		this.numofdaystcibatchtrace = vo.getNumOfDaysTCIBatchTrace();
		this.numofdaysfornextpdscheck = vo.getNumOfDaysForNextPDSCheck();
		this.synchronise_with_backoffice = vo.getSYNCHRONISE_WITH_BACKOFFICE();
		this.frompdsaccreditedsystemid = vo.getFromPDSAccreditedSystemId();
		this.topdsaccreditedsystemid = vo.getToPDSAccreditedSystemId();
		this.pds_config_file = vo.getPDS_CONFIG_FILE();
		this.pds_store_message_loc = vo.getPDS_STORE_MESSAGE_LOC();
		this.pds_store_message = vo.getPDS_STORE_MESSAGE();
		this.start_pds_gateway = vo.getSTART_PDS_GATEWAY();
		this.pds_msh_repository = vo.getPDS_MSH_REPOSITORY();
		this.pds_msh_url = vo.getPDS_MSH_URL();
		this.create_bo_notifications = vo.getCREATE_BO_NOTIFICATIONS();
		this.sdshost = vo.getSDSHost();
		this.sdsport = vo.getSDSPort();
		this.pds_url = vo.getPDS_URL();
		this.pds_host = vo.getPDS_HOST();
		this.pds_store_sync_message = vo.getPDS_STORE_SYNC_MESSAGE();
		this.pds_store_sync_message_loc = vo.getPDS_STORE_SYNC_MESSAGE_LOC();
		this.consentchangemessage = vo.getConsentChangeMessage();
		this.inactivepatientrecordbgcolour = vo.getInactivePatientRecordBgColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getInactivePatientRecordBgColour().getBean();
		this.decouple_on_decease = vo.getDECOUPLE_ON_DECEASE();
		this.notify_on_decease = vo.getNOTIFY_ON_DECEASE();
		this.decouple_on_sync_required = vo.getDECOUPLE_ON_SYNC_REQUIRED();
		this.pds_authentication = vo.getPDS_AUTHENTICATION();
		this.rbac_pdssearchforpatient = vo.getRBAC_PdsSearchForPatient();
		this.rbac_pdssearchpatientadvanced = vo.getRBAC_PdsSearchPatientAdvanced();
		this.rbac_pdsretrieval = vo.getRBAC_PdsRetrieval();
		this.rbac_accesssensitivedata = vo.getRBAC_AccessSensitiveData();
		this.rbac_amendpatient = vo.getRBAC_AmendPatient();
		this.rbac_controlconsent = vo.getRBAC_ControlConsent();
		this.rbac_amendpatientdecease = vo.getRBAC_AmendPatientDecease();
		this.rbac_postcodesearch = vo.getRBAC_PostcodeSearch();
		this.pds_display_consent = vo.getPDS_DISPLAY_CONSENT();
		this.dob_date_range_type = vo.getDOB_DATE_RANGE_TYPE() == null ? null : (ims.vo.LookupInstanceBean)vo.getDOB_DATE_RANGE_TYPE().getBean();
		this.dod_date_range_type = vo.getDOD_DATE_RANGE_TYPE() == null ? null : (ims.vo.LookupInstanceBean)vo.getDOD_DATE_RANGE_TYPE().getBean();
		this.tp_bookoutpatientappt = vo.getTP_BookOutpatientAppt();
		this.tp_bookwardattenderappt = vo.getTP_BookWardAttenderAppt();
		this.tp_createtciandtheatrebooking = vo.getTP_CreateTCIAndTheatreBooking();
		this.tp_anyadmission = vo.getTP_AnyAdmission();
		this.tp_anyapptarrival = vo.getTP_AnyApptArrival();
	}

	public ims.admin.vo.PDSConfigurationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.PDSConfigurationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.PDSConfigurationVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.PDSConfigurationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.PDSConfigurationVo();
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
	public Integer getDOB_DATE_RANGE()
	{
		return this.dob_date_range;
	}
	public void setDOB_DATE_RANGE(Integer value)
	{
		this.dob_date_range = value;
	}
	public Integer getDOD_DATE_RANGE()
	{
		return this.dod_date_range;
	}
	public void setDOD_DATE_RANGE(Integer value)
	{
		this.dod_date_range = value;
	}
	public Boolean getTRACE_ADVANCED_IGNORE_HISTORY()
	{
		return this.trace_advanced_ignore_history;
	}
	public void setTRACE_ADVANCED_IGNORE_HISTORY(Boolean value)
	{
		this.trace_advanced_ignore_history = value;
	}
	public Boolean getTRACE_HISTORY_DATA_INDICATOR()
	{
		return this.trace_history_data_indicator;
	}
	public void setTRACE_HISTORY_DATA_INDICATOR(Boolean value)
	{
		this.trace_history_data_indicator = value;
	}
	public Boolean getUSE_LPI_CROSSCHECK()
	{
		return this.use_lpi_crosscheck;
	}
	public void setUSE_LPI_CROSSCHECK(Boolean value)
	{
		this.use_lpi_crosscheck = value;
	}
	public String getNO_FIXED_ABODE_POSTCODE()
	{
		return this.no_fixed_abode_postcode;
	}
	public void setNO_FIXED_ABODE_POSTCODE(String value)
	{
		this.no_fixed_abode_postcode = value;
	}
	public Integer getADVANCED_SEARCH_TIMER_INTERVAL()
	{
		return this.advanced_search_timer_interval;
	}
	public void setADVANCED_SEARCH_TIMER_INTERVAL(Integer value)
	{
		this.advanced_search_timer_interval = value;
	}
	public ims.vo.RefVoBean getPDS_BACKOFFICE_NOTIFICATI()
	{
		return this.pds_backoffice_notificati;
	}
	public void setPDS_BACKOFFICE_NOTIFICATI(ims.vo.RefVoBean value)
	{
		this.pds_backoffice_notificati = value;
	}
	public Integer getNumOfDaysAppointBatchTrace()
	{
		return this.numofdaysappointbatchtrace;
	}
	public void setNumOfDaysAppointBatchTrace(Integer value)
	{
		this.numofdaysappointbatchtrace = value;
	}
	public Integer getNumOfDaysTCIBatchTrace()
	{
		return this.numofdaystcibatchtrace;
	}
	public void setNumOfDaysTCIBatchTrace(Integer value)
	{
		this.numofdaystcibatchtrace = value;
	}
	public Integer getNumOfDaysForNextPDSCheck()
	{
		return this.numofdaysfornextpdscheck;
	}
	public void setNumOfDaysForNextPDSCheck(Integer value)
	{
		this.numofdaysfornextpdscheck = value;
	}
	public Boolean getSYNCHRONISE_WITH_BACKOFFICE()
	{
		return this.synchronise_with_backoffice;
	}
	public void setSYNCHRONISE_WITH_BACKOFFICE(Boolean value)
	{
		this.synchronise_with_backoffice = value;
	}
	public String getFromPDSAccreditedSystemId()
	{
		return this.frompdsaccreditedsystemid;
	}
	public void setFromPDSAccreditedSystemId(String value)
	{
		this.frompdsaccreditedsystemid = value;
	}
	public String getToPDSAccreditedSystemId()
	{
		return this.topdsaccreditedsystemid;
	}
	public void setToPDSAccreditedSystemId(String value)
	{
		this.topdsaccreditedsystemid = value;
	}
	public String getPDS_CONFIG_FILE()
	{
		return this.pds_config_file;
	}
	public void setPDS_CONFIG_FILE(String value)
	{
		this.pds_config_file = value;
	}
	public String getPDS_STORE_MESSAGE_LOC()
	{
		return this.pds_store_message_loc;
	}
	public void setPDS_STORE_MESSAGE_LOC(String value)
	{
		this.pds_store_message_loc = value;
	}
	public Boolean getPDS_STORE_MESSAGE()
	{
		return this.pds_store_message;
	}
	public void setPDS_STORE_MESSAGE(Boolean value)
	{
		this.pds_store_message = value;
	}
	public Boolean getSTART_PDS_GATEWAY()
	{
		return this.start_pds_gateway;
	}
	public void setSTART_PDS_GATEWAY(Boolean value)
	{
		this.start_pds_gateway = value;
	}
	public String getPDS_MSH_REPOSITORY()
	{
		return this.pds_msh_repository;
	}
	public void setPDS_MSH_REPOSITORY(String value)
	{
		this.pds_msh_repository = value;
	}
	public String getPDS_MSH_URL()
	{
		return this.pds_msh_url;
	}
	public void setPDS_MSH_URL(String value)
	{
		this.pds_msh_url = value;
	}
	public Boolean getCREATE_BO_NOTIFICATIONS()
	{
		return this.create_bo_notifications;
	}
	public void setCREATE_BO_NOTIFICATIONS(Boolean value)
	{
		this.create_bo_notifications = value;
	}
	public String getSDSHost()
	{
		return this.sdshost;
	}
	public void setSDSHost(String value)
	{
		this.sdshost = value;
	}
	public String getSDSPort()
	{
		return this.sdsport;
	}
	public void setSDSPort(String value)
	{
		this.sdsport = value;
	}
	public String getPDS_URL()
	{
		return this.pds_url;
	}
	public void setPDS_URL(String value)
	{
		this.pds_url = value;
	}
	public String getPDS_HOST()
	{
		return this.pds_host;
	}
	public void setPDS_HOST(String value)
	{
		this.pds_host = value;
	}
	public Boolean getPDS_STORE_SYNC_MESSAGE()
	{
		return this.pds_store_sync_message;
	}
	public void setPDS_STORE_SYNC_MESSAGE(Boolean value)
	{
		this.pds_store_sync_message = value;
	}
	public String getPDS_STORE_SYNC_MESSAGE_LOC()
	{
		return this.pds_store_sync_message_loc;
	}
	public void setPDS_STORE_SYNC_MESSAGE_LOC(String value)
	{
		this.pds_store_sync_message_loc = value;
	}
	public String getConsentChangeMessage()
	{
		return this.consentchangemessage;
	}
	public void setConsentChangeMessage(String value)
	{
		this.consentchangemessage = value;
	}
	public ims.framework.utils.beans.ColorBean getInactivePatientRecordBgColour()
	{
		return this.inactivepatientrecordbgcolour;
	}
	public void setInactivePatientRecordBgColour(ims.framework.utils.beans.ColorBean value)
	{
		this.inactivepatientrecordbgcolour = value;
	}
	public Boolean getDECOUPLE_ON_DECEASE()
	{
		return this.decouple_on_decease;
	}
	public void setDECOUPLE_ON_DECEASE(Boolean value)
	{
		this.decouple_on_decease = value;
	}
	public Boolean getNOTIFY_ON_DECEASE()
	{
		return this.notify_on_decease;
	}
	public void setNOTIFY_ON_DECEASE(Boolean value)
	{
		this.notify_on_decease = value;
	}
	public Boolean getDECOUPLE_ON_SYNC_REQUIRED()
	{
		return this.decouple_on_sync_required;
	}
	public void setDECOUPLE_ON_SYNC_REQUIRED(Boolean value)
	{
		this.decouple_on_sync_required = value;
	}
	public Boolean getPDS_AUTHENTICATION()
	{
		return this.pds_authentication;
	}
	public void setPDS_AUTHENTICATION(Boolean value)
	{
		this.pds_authentication = value;
	}
	public String getRBAC_PdsSearchForPatient()
	{
		return this.rbac_pdssearchforpatient;
	}
	public void setRBAC_PdsSearchForPatient(String value)
	{
		this.rbac_pdssearchforpatient = value;
	}
	public String getRBAC_PdsSearchPatientAdvanced()
	{
		return this.rbac_pdssearchpatientadvanced;
	}
	public void setRBAC_PdsSearchPatientAdvanced(String value)
	{
		this.rbac_pdssearchpatientadvanced = value;
	}
	public String getRBAC_PdsRetrieval()
	{
		return this.rbac_pdsretrieval;
	}
	public void setRBAC_PdsRetrieval(String value)
	{
		this.rbac_pdsretrieval = value;
	}
	public String getRBAC_AccessSensitiveData()
	{
		return this.rbac_accesssensitivedata;
	}
	public void setRBAC_AccessSensitiveData(String value)
	{
		this.rbac_accesssensitivedata = value;
	}
	public String getRBAC_AmendPatient()
	{
		return this.rbac_amendpatient;
	}
	public void setRBAC_AmendPatient(String value)
	{
		this.rbac_amendpatient = value;
	}
	public String getRBAC_ControlConsent()
	{
		return this.rbac_controlconsent;
	}
	public void setRBAC_ControlConsent(String value)
	{
		this.rbac_controlconsent = value;
	}
	public String getRBAC_AmendPatientDecease()
	{
		return this.rbac_amendpatientdecease;
	}
	public void setRBAC_AmendPatientDecease(String value)
	{
		this.rbac_amendpatientdecease = value;
	}
	public String getRBAC_PostcodeSearch()
	{
		return this.rbac_postcodesearch;
	}
	public void setRBAC_PostcodeSearch(String value)
	{
		this.rbac_postcodesearch = value;
	}
	public Boolean getPDS_DISPLAY_CONSENT()
	{
		return this.pds_display_consent;
	}
	public void setPDS_DISPLAY_CONSENT(Boolean value)
	{
		this.pds_display_consent = value;
	}
	public ims.vo.LookupInstanceBean getDOB_DATE_RANGE_TYPE()
	{
		return this.dob_date_range_type;
	}
	public void setDOB_DATE_RANGE_TYPE(ims.vo.LookupInstanceBean value)
	{
		this.dob_date_range_type = value;
	}
	public ims.vo.LookupInstanceBean getDOD_DATE_RANGE_TYPE()
	{
		return this.dod_date_range_type;
	}
	public void setDOD_DATE_RANGE_TYPE(ims.vo.LookupInstanceBean value)
	{
		this.dod_date_range_type = value;
	}
	public Boolean getTP_BookOutpatientAppt()
	{
		return this.tp_bookoutpatientappt;
	}
	public void setTP_BookOutpatientAppt(Boolean value)
	{
		this.tp_bookoutpatientappt = value;
	}
	public Boolean getTP_BookWardAttenderAppt()
	{
		return this.tp_bookwardattenderappt;
	}
	public void setTP_BookWardAttenderAppt(Boolean value)
	{
		this.tp_bookwardattenderappt = value;
	}
	public Boolean getTP_CreateTCIAndTheatreBooking()
	{
		return this.tp_createtciandtheatrebooking;
	}
	public void setTP_CreateTCIAndTheatreBooking(Boolean value)
	{
		this.tp_createtciandtheatrebooking = value;
	}
	public Boolean getTP_AnyAdmission()
	{
		return this.tp_anyadmission;
	}
	public void setTP_AnyAdmission(Boolean value)
	{
		this.tp_anyadmission = value;
	}
	public Boolean getTP_AnyApptArrival()
	{
		return this.tp_anyapptarrival;
	}
	public void setTP_AnyApptArrival(Boolean value)
	{
		this.tp_anyapptarrival = value;
	}

	private Integer id;
	private int version;
	private Integer dob_date_range;
	private Integer dod_date_range;
	private Boolean trace_advanced_ignore_history;
	private Boolean trace_history_data_indicator;
	private Boolean use_lpi_crosscheck;
	private String no_fixed_abode_postcode;
	private Integer advanced_search_timer_interval;
	private ims.vo.RefVoBean pds_backoffice_notificati;
	private Integer numofdaysappointbatchtrace;
	private Integer numofdaystcibatchtrace;
	private Integer numofdaysfornextpdscheck;
	private Boolean synchronise_with_backoffice;
	private String frompdsaccreditedsystemid;
	private String topdsaccreditedsystemid;
	private String pds_config_file;
	private String pds_store_message_loc;
	private Boolean pds_store_message;
	private Boolean start_pds_gateway;
	private String pds_msh_repository;
	private String pds_msh_url;
	private Boolean create_bo_notifications;
	private String sdshost;
	private String sdsport;
	private String pds_url;
	private String pds_host;
	private Boolean pds_store_sync_message;
	private String pds_store_sync_message_loc;
	private String consentchangemessage;
	private ims.framework.utils.beans.ColorBean inactivepatientrecordbgcolour;
	private Boolean decouple_on_decease;
	private Boolean notify_on_decease;
	private Boolean decouple_on_sync_required;
	private Boolean pds_authentication;
	private String rbac_pdssearchforpatient;
	private String rbac_pdssearchpatientadvanced;
	private String rbac_pdsretrieval;
	private String rbac_accesssensitivedata;
	private String rbac_amendpatient;
	private String rbac_controlconsent;
	private String rbac_amendpatientdecease;
	private String rbac_postcodesearch;
	private Boolean pds_display_consent;
	private ims.vo.LookupInstanceBean dob_date_range_type;
	private ims.vo.LookupInstanceBean dod_date_range_type;
	private Boolean tp_bookoutpatientappt;
	private Boolean tp_bookwardattenderappt;
	private Boolean tp_createtciandtheatrebooking;
	private Boolean tp_anyadmission;
	private Boolean tp_anyapptarrival;
}
