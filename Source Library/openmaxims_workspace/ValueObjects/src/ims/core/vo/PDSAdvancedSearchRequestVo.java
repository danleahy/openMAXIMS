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

/**
 * Linked to core.patient.PDSAdvancedSearchRequest business object (ID: 1001100016).
 */
public class PDSAdvancedSearchRequestVo extends ims.core.patient.vo.PDSAdvancedSearchRequestRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PDSAdvancedSearchRequestVo()
	{
	}
	public PDSAdvancedSearchRequestVo(Integer id, int version)
	{
		super(id, version);
	}
	public PDSAdvancedSearchRequestVo(ims.core.vo.beans.PDSAdvancedSearchRequestVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.sdsroleprofileid = bean.getSDSRoleProfileId();
		this.sdsuserid = bean.getSDSUserId();
		this.pdsack = bean.getPDSAck() == null ? null : ims.core.vo.lookups.PDSRequestAckStatus.buildLookup(bean.getPDSAck());
		this.pdsackdetailtype = bean.getPDSAckDetailType() == null ? null : ims.core.vo.lookups.PDSAckDetailType.buildLookup(bean.getPDSAckDetailType());
		this.active = bean.getActive();
		this.comment = bean.getComment();
		this.requesttype = bean.getRequestType() == null ? null : ims.core.vo.lookups.PDSAsyncRequestType.buildLookup(bean.getRequestType());
		this.requestdate = bean.getRequestDate() == null ? null : bean.getRequestDate().buildDateTime();
		this.searchstatus = bean.getSearchStatus() == null ? null : ims.core.vo.lookups.PDSSearchStatus.buildLookup(bean.getSearchStatus());
		this.searchtype = bean.getSearchType() == null ? null : ims.core.vo.lookups.PDSSearchType.buildLookup(bean.getSearchType());
		this.historicdataflag = bean.getHistoricDataFlag() == null ? null : ims.core.vo.lookups.PDSHistoryDataFlag.buildLookup(bean.getHistoricDataFlag());
		this.ignorehistoryindicator = bean.getIgnoreHistoryIndicator() == null ? null : ims.core.vo.lookups.PDSIgnoreHistoryIndicator.buildLookup(bean.getIgnoreHistoryIndicator());
		this.nhsnumber = bean.getNHSNumber();
		this.surname = bean.getSurname();
		this.forename = bean.getForename();
		this.gender = bean.getGender() == null ? null : ims.core.vo.lookups.Sex.buildLookup(bean.getGender());
		this.fromdateofbirth = bean.getFromDateOfBirth() == null ? null : bean.getFromDateOfBirth().buildDate();
		this.todateofbirth = bean.getToDateOfBirth() == null ? null : bean.getToDateOfBirth().buildDate();
		this.fromdateofdeath = bean.getFromDateOfDeath() == null ? null : bean.getFromDateOfDeath().buildDate();
		this.todateofdeath = bean.getToDateOfDeath() == null ? null : bean.getToDateOfDeath().buildDate();
		this.searchresult = ims.core.vo.PDSAdvancedSearchResultVoCollection.buildFromBeanCollection(bean.getSearchResult());
		this.convid = bean.getConvId() == null ? null : new ims.choose_book.vo.PDSConvRefVo(new Integer(bean.getConvId().getId()), bean.getConvId().getVersion());
		this.address = bean.getAddress() == null ? null : bean.getAddress().buildVo();
		this.gppracticecode = bean.getGpPracticeCode();
		this.sdsjobrolecode = bean.getSDSJobRoleCode();
		this.postcode = bean.getPostcode();
		this.middlename = bean.getMiddleName();
		this.dobrangeunit = bean.getDOBRangeUnit() == null ? null : ims.core.vo.lookups.TimeUnitsSecondsToYears.buildLookup(bean.getDOBRangeUnit());
		this.dodrangeunit = bean.getDODRangeUnit() == null ? null : ims.core.vo.lookups.TimeUnitsSecondsToYears.buildLookup(bean.getDODRangeUnit());
		this.dobrangevalue = bean.getDOBRangeValue();
		this.dodrangevalue = bean.getDODRangeValue();
		this.dobpartialsearchby = bean.getDOBPartialSearchBy() == null ? null : ims.core.vo.lookups.TimeUnitsSecondsToYears.buildLookup(bean.getDOBPartialSearchBy());
		this.dodpartialsearchby = bean.getDODPartialSearchBy() == null ? null : ims.core.vo.lookups.TimeUnitsSecondsToYears.buildLookup(bean.getDODPartialSearchBy());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PDSAdvancedSearchRequestVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.sdsroleprofileid = bean.getSDSRoleProfileId();
		this.sdsuserid = bean.getSDSUserId();
		this.pdsack = bean.getPDSAck() == null ? null : ims.core.vo.lookups.PDSRequestAckStatus.buildLookup(bean.getPDSAck());
		this.pdsackdetailtype = bean.getPDSAckDetailType() == null ? null : ims.core.vo.lookups.PDSAckDetailType.buildLookup(bean.getPDSAckDetailType());
		this.active = bean.getActive();
		this.comment = bean.getComment();
		this.requesttype = bean.getRequestType() == null ? null : ims.core.vo.lookups.PDSAsyncRequestType.buildLookup(bean.getRequestType());
		this.requestdate = bean.getRequestDate() == null ? null : bean.getRequestDate().buildDateTime();
		this.searchstatus = bean.getSearchStatus() == null ? null : ims.core.vo.lookups.PDSSearchStatus.buildLookup(bean.getSearchStatus());
		this.searchtype = bean.getSearchType() == null ? null : ims.core.vo.lookups.PDSSearchType.buildLookup(bean.getSearchType());
		this.historicdataflag = bean.getHistoricDataFlag() == null ? null : ims.core.vo.lookups.PDSHistoryDataFlag.buildLookup(bean.getHistoricDataFlag());
		this.ignorehistoryindicator = bean.getIgnoreHistoryIndicator() == null ? null : ims.core.vo.lookups.PDSIgnoreHistoryIndicator.buildLookup(bean.getIgnoreHistoryIndicator());
		this.nhsnumber = bean.getNHSNumber();
		this.surname = bean.getSurname();
		this.forename = bean.getForename();
		this.gender = bean.getGender() == null ? null : ims.core.vo.lookups.Sex.buildLookup(bean.getGender());
		this.fromdateofbirth = bean.getFromDateOfBirth() == null ? null : bean.getFromDateOfBirth().buildDate();
		this.todateofbirth = bean.getToDateOfBirth() == null ? null : bean.getToDateOfBirth().buildDate();
		this.fromdateofdeath = bean.getFromDateOfDeath() == null ? null : bean.getFromDateOfDeath().buildDate();
		this.todateofdeath = bean.getToDateOfDeath() == null ? null : bean.getToDateOfDeath().buildDate();
		this.searchresult = ims.core.vo.PDSAdvancedSearchResultVoCollection.buildFromBeanCollection(bean.getSearchResult());
		this.convid = bean.getConvId() == null ? null : new ims.choose_book.vo.PDSConvRefVo(new Integer(bean.getConvId().getId()), bean.getConvId().getVersion());
		this.address = bean.getAddress() == null ? null : bean.getAddress().buildVo(map);
		this.gppracticecode = bean.getGpPracticeCode();
		this.sdsjobrolecode = bean.getSDSJobRoleCode();
		this.postcode = bean.getPostcode();
		this.middlename = bean.getMiddleName();
		this.dobrangeunit = bean.getDOBRangeUnit() == null ? null : ims.core.vo.lookups.TimeUnitsSecondsToYears.buildLookup(bean.getDOBRangeUnit());
		this.dodrangeunit = bean.getDODRangeUnit() == null ? null : ims.core.vo.lookups.TimeUnitsSecondsToYears.buildLookup(bean.getDODRangeUnit());
		this.dobrangevalue = bean.getDOBRangeValue();
		this.dodrangevalue = bean.getDODRangeValue();
		this.dobpartialsearchby = bean.getDOBPartialSearchBy() == null ? null : ims.core.vo.lookups.TimeUnitsSecondsToYears.buildLookup(bean.getDOBPartialSearchBy());
		this.dodpartialsearchby = bean.getDODPartialSearchBy() == null ? null : ims.core.vo.lookups.TimeUnitsSecondsToYears.buildLookup(bean.getDODPartialSearchBy());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PDSAdvancedSearchRequestVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PDSAdvancedSearchRequestVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PDSAdvancedSearchRequestVoBean();
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
		if(fieldName.equals("SDSROLEPROFILEID"))
			return getSDSRoleProfileId();
		if(fieldName.equals("SDSUSERID"))
			return getSDSUserId();
		if(fieldName.equals("PDSACK"))
			return getPDSAck();
		if(fieldName.equals("PDSACKDETAILTYPE"))
			return getPDSAckDetailType();
		if(fieldName.equals("ACTIVE"))
			return getActive();
		if(fieldName.equals("COMMENT"))
			return getComment();
		if(fieldName.equals("REQUESTTYPE"))
			return getRequestType();
		if(fieldName.equals("REQUESTDATE"))
			return getRequestDate();
		if(fieldName.equals("SEARCHSTATUS"))
			return getSearchStatus();
		if(fieldName.equals("SEARCHTYPE"))
			return getSearchType();
		if(fieldName.equals("HISTORICDATAFLAG"))
			return getHistoricDataFlag();
		if(fieldName.equals("IGNOREHISTORYINDICATOR"))
			return getIgnoreHistoryIndicator();
		if(fieldName.equals("NHSNUMBER"))
			return getNHSNumber();
		if(fieldName.equals("SURNAME"))
			return getSurname();
		if(fieldName.equals("FORENAME"))
			return getForename();
		if(fieldName.equals("GENDER"))
			return getGender();
		if(fieldName.equals("FROMDATEOFBIRTH"))
			return getFromDateOfBirth();
		if(fieldName.equals("TODATEOFBIRTH"))
			return getToDateOfBirth();
		if(fieldName.equals("FROMDATEOFDEATH"))
			return getFromDateOfDeath();
		if(fieldName.equals("TODATEOFDEATH"))
			return getToDateOfDeath();
		if(fieldName.equals("SEARCHRESULT"))
			return getSearchResult();
		if(fieldName.equals("CONVID"))
			return getConvId();
		if(fieldName.equals("ADDRESS"))
			return getAddress();
		if(fieldName.equals("GPPRACTICECODE"))
			return getGpPracticeCode();
		if(fieldName.equals("SDSJOBROLECODE"))
			return getSDSJobRoleCode();
		if(fieldName.equals("POSTCODE"))
			return getPostcode();
		if(fieldName.equals("MIDDLENAME"))
			return getMiddleName();
		if(fieldName.equals("DOBRANGEUNIT"))
			return getDOBRangeUnit();
		if(fieldName.equals("DODRANGEUNIT"))
			return getDODRangeUnit();
		if(fieldName.equals("DOBRANGEVALUE"))
			return getDOBRangeValue();
		if(fieldName.equals("DODRANGEVALUE"))
			return getDODRangeValue();
		if(fieldName.equals("DOBPARTIALSEARCHBY"))
			return getDOBPartialSearchBy();
		if(fieldName.equals("DODPARTIALSEARCHBY"))
			return getDODPartialSearchBy();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSDSRoleProfileIdIsNotNull()
	{
		return this.sdsroleprofileid != null;
	}
	public String getSDSRoleProfileId()
	{
		return this.sdsroleprofileid;
	}
	public static int getSDSRoleProfileIdMaxLength()
	{
		return 50;
	}
	public void setSDSRoleProfileId(String value)
	{
		this.isValidated = false;
		this.sdsroleprofileid = value;
	}
	public boolean getSDSUserIdIsNotNull()
	{
		return this.sdsuserid != null;
	}
	public String getSDSUserId()
	{
		return this.sdsuserid;
	}
	public static int getSDSUserIdMaxLength()
	{
		return 50;
	}
	public void setSDSUserId(String value)
	{
		this.isValidated = false;
		this.sdsuserid = value;
	}
	public boolean getPDSAckIsNotNull()
	{
		return this.pdsack != null;
	}
	public ims.core.vo.lookups.PDSRequestAckStatus getPDSAck()
	{
		return this.pdsack;
	}
	public void setPDSAck(ims.core.vo.lookups.PDSRequestAckStatus value)
	{
		this.isValidated = false;
		this.pdsack = value;
	}
	public boolean getPDSAckDetailTypeIsNotNull()
	{
		return this.pdsackdetailtype != null;
	}
	public ims.core.vo.lookups.PDSAckDetailType getPDSAckDetailType()
	{
		return this.pdsackdetailtype;
	}
	public void setPDSAckDetailType(ims.core.vo.lookups.PDSAckDetailType value)
	{
		this.isValidated = false;
		this.pdsackdetailtype = value;
	}
	public boolean getActiveIsNotNull()
	{
		return this.active != null;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.isValidated = false;
		this.active = value;
	}
	public boolean getCommentIsNotNull()
	{
		return this.comment != null;
	}
	public String getComment()
	{
		return this.comment;
	}
	public static int getCommentMaxLength()
	{
		return 200;
	}
	public void setComment(String value)
	{
		this.isValidated = false;
		this.comment = value;
	}
	public boolean getRequestTypeIsNotNull()
	{
		return this.requesttype != null;
	}
	public ims.core.vo.lookups.PDSAsyncRequestType getRequestType()
	{
		return this.requesttype;
	}
	public void setRequestType(ims.core.vo.lookups.PDSAsyncRequestType value)
	{
		this.isValidated = false;
		this.requesttype = value;
	}
	public boolean getRequestDateIsNotNull()
	{
		return this.requestdate != null;
	}
	public ims.framework.utils.DateTime getRequestDate()
	{
		return this.requestdate;
	}
	public void setRequestDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.requestdate = value;
	}
	public boolean getSearchStatusIsNotNull()
	{
		return this.searchstatus != null;
	}
	public ims.core.vo.lookups.PDSSearchStatus getSearchStatus()
	{
		return this.searchstatus;
	}
	public void setSearchStatus(ims.core.vo.lookups.PDSSearchStatus value)
	{
		this.isValidated = false;
		this.searchstatus = value;
	}
	public boolean getSearchTypeIsNotNull()
	{
		return this.searchtype != null;
	}
	public ims.core.vo.lookups.PDSSearchType getSearchType()
	{
		return this.searchtype;
	}
	public void setSearchType(ims.core.vo.lookups.PDSSearchType value)
	{
		this.isValidated = false;
		this.searchtype = value;
	}
	public boolean getHistoricDataFlagIsNotNull()
	{
		return this.historicdataflag != null;
	}
	public ims.core.vo.lookups.PDSHistoryDataFlag getHistoricDataFlag()
	{
		return this.historicdataflag;
	}
	public void setHistoricDataFlag(ims.core.vo.lookups.PDSHistoryDataFlag value)
	{
		this.isValidated = false;
		this.historicdataflag = value;
	}
	public boolean getIgnoreHistoryIndicatorIsNotNull()
	{
		return this.ignorehistoryindicator != null;
	}
	public ims.core.vo.lookups.PDSIgnoreHistoryIndicator getIgnoreHistoryIndicator()
	{
		return this.ignorehistoryindicator;
	}
	public void setIgnoreHistoryIndicator(ims.core.vo.lookups.PDSIgnoreHistoryIndicator value)
	{
		this.isValidated = false;
		this.ignorehistoryindicator = value;
	}
	public boolean getNHSNumberIsNotNull()
	{
		return this.nhsnumber != null;
	}
	public String getNHSNumber()
	{
		return this.nhsnumber;
	}
	public static int getNHSNumberMaxLength()
	{
		return 12;
	}
	public void setNHSNumber(String value)
	{
		this.isValidated = false;
		this.nhsnumber = value;
	}
	public boolean getSurnameIsNotNull()
	{
		return this.surname != null;
	}
	public String getSurname()
	{
		return this.surname;
	}
	public static int getSurnameMaxLength()
	{
		return 40;
	}
	public void setSurname(String value)
	{
		this.isValidated = false;
		this.surname = value;
	}
	public boolean getForenameIsNotNull()
	{
		return this.forename != null;
	}
	public String getForename()
	{
		return this.forename;
	}
	public static int getForenameMaxLength()
	{
		return 40;
	}
	public void setForename(String value)
	{
		this.isValidated = false;
		this.forename = value;
	}
	public boolean getGenderIsNotNull()
	{
		return this.gender != null;
	}
	public ims.core.vo.lookups.Sex getGender()
	{
		return this.gender;
	}
	public void setGender(ims.core.vo.lookups.Sex value)
	{
		this.isValidated = false;
		this.gender = value;
	}
	public boolean getFromDateOfBirthIsNotNull()
	{
		return this.fromdateofbirth != null;
	}
	public ims.framework.utils.Date getFromDateOfBirth()
	{
		return this.fromdateofbirth;
	}
	public void setFromDateOfBirth(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.fromdateofbirth = value;
	}
	public boolean getToDateOfBirthIsNotNull()
	{
		return this.todateofbirth != null;
	}
	public ims.framework.utils.Date getToDateOfBirth()
	{
		return this.todateofbirth;
	}
	public void setToDateOfBirth(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.todateofbirth = value;
	}
	public boolean getFromDateOfDeathIsNotNull()
	{
		return this.fromdateofdeath != null;
	}
	public ims.framework.utils.Date getFromDateOfDeath()
	{
		return this.fromdateofdeath;
	}
	public void setFromDateOfDeath(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.fromdateofdeath = value;
	}
	public boolean getToDateOfDeathIsNotNull()
	{
		return this.todateofdeath != null;
	}
	public ims.framework.utils.Date getToDateOfDeath()
	{
		return this.todateofdeath;
	}
	public void setToDateOfDeath(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.todateofdeath = value;
	}
	public boolean getSearchResultIsNotNull()
	{
		return this.searchresult != null;
	}
	public ims.core.vo.PDSAdvancedSearchResultVoCollection getSearchResult()
	{
		return this.searchresult;
	}
	public void setSearchResult(ims.core.vo.PDSAdvancedSearchResultVoCollection value)
	{
		this.isValidated = false;
		this.searchresult = value;
	}
	public boolean getConvIdIsNotNull()
	{
		return this.convid != null;
	}
	public ims.choose_book.vo.PDSConvRefVo getConvId()
	{
		return this.convid;
	}
	public void setConvId(ims.choose_book.vo.PDSConvRefVo value)
	{
		this.isValidated = false;
		this.convid = value;
	}
	public boolean getAddressIsNotNull()
	{
		return this.address != null;
	}
	public ims.core.vo.AddressVo getAddress()
	{
		return this.address;
	}
	public void setAddress(ims.core.vo.AddressVo value)
	{
		this.isValidated = false;
		this.address = value;
	}
	public boolean getGpPracticeCodeIsNotNull()
	{
		return this.gppracticecode != null;
	}
	public String getGpPracticeCode()
	{
		return this.gppracticecode;
	}
	public static int getGpPracticeCodeMaxLength()
	{
		return 25;
	}
	public void setGpPracticeCode(String value)
	{
		this.isValidated = false;
		this.gppracticecode = value;
	}
	public boolean getSDSJobRoleCodeIsNotNull()
	{
		return this.sdsjobrolecode != null;
	}
	public String getSDSJobRoleCode()
	{
		return this.sdsjobrolecode;
	}
	public static int getSDSJobRoleCodeMaxLength()
	{
		return 20;
	}
	public void setSDSJobRoleCode(String value)
	{
		this.isValidated = false;
		this.sdsjobrolecode = value;
	}
	public boolean getPostcodeIsNotNull()
	{
		return this.postcode != null;
	}
	public String getPostcode()
	{
		return this.postcode;
	}
	public static int getPostcodeMaxLength()
	{
		return 10;
	}
	public void setPostcode(String value)
	{
		this.isValidated = false;
		this.postcode = value;
	}
	public boolean getMiddleNameIsNotNull()
	{
		return this.middlename != null;
	}
	public String getMiddleName()
	{
		return this.middlename;
	}
	public static int getMiddleNameMaxLength()
	{
		return 40;
	}
	public void setMiddleName(String value)
	{
		this.isValidated = false;
		this.middlename = value;
	}
	public boolean getDOBRangeUnitIsNotNull()
	{
		return this.dobrangeunit != null;
	}
	public ims.core.vo.lookups.TimeUnitsSecondsToYears getDOBRangeUnit()
	{
		return this.dobrangeunit;
	}
	public void setDOBRangeUnit(ims.core.vo.lookups.TimeUnitsSecondsToYears value)
	{
		this.isValidated = false;
		this.dobrangeunit = value;
	}
	public boolean getDODRangeUnitIsNotNull()
	{
		return this.dodrangeunit != null;
	}
	public ims.core.vo.lookups.TimeUnitsSecondsToYears getDODRangeUnit()
	{
		return this.dodrangeunit;
	}
	public void setDODRangeUnit(ims.core.vo.lookups.TimeUnitsSecondsToYears value)
	{
		this.isValidated = false;
		this.dodrangeunit = value;
	}
	public boolean getDOBRangeValueIsNotNull()
	{
		return this.dobrangevalue != null;
	}
	public Integer getDOBRangeValue()
	{
		return this.dobrangevalue;
	}
	public void setDOBRangeValue(Integer value)
	{
		this.isValidated = false;
		this.dobrangevalue = value;
	}
	public boolean getDODRangeValueIsNotNull()
	{
		return this.dodrangevalue != null;
	}
	public Integer getDODRangeValue()
	{
		return this.dodrangevalue;
	}
	public void setDODRangeValue(Integer value)
	{
		this.isValidated = false;
		this.dodrangevalue = value;
	}
	public boolean getDOBPartialSearchByIsNotNull()
	{
		return this.dobpartialsearchby != null;
	}
	public ims.core.vo.lookups.TimeUnitsSecondsToYears getDOBPartialSearchBy()
	{
		return this.dobpartialsearchby;
	}
	public void setDOBPartialSearchBy(ims.core.vo.lookups.TimeUnitsSecondsToYears value)
	{
		this.isValidated = false;
		this.dobpartialsearchby = value;
	}
	public boolean getDODPartialSearchByIsNotNull()
	{
		return this.dodpartialsearchby != null;
	}
	public ims.core.vo.lookups.TimeUnitsSecondsToYears getDODPartialSearchBy()
	{
		return this.dodpartialsearchby;
	}
	public void setDODPartialSearchBy(ims.core.vo.lookups.TimeUnitsSecondsToYears value)
	{
		this.isValidated = false;
		this.dodpartialsearchby = value;
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
		if(this.searchresult != null)
		{
			if(!this.searchresult.isValidated())
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
		if(this.sdsroleprofileid != null)
			if(this.sdsroleprofileid.length() > 50)
				listOfErrors.add("The length of the field [sdsroleprofileid] in the value object [ims.core.vo.PDSAdvancedSearchRequestVo] is too big. It should be less or equal to 50");
		if(this.sdsuserid != null)
			if(this.sdsuserid.length() > 50)
				listOfErrors.add("The length of the field [sdsuserid] in the value object [ims.core.vo.PDSAdvancedSearchRequestVo] is too big. It should be less or equal to 50");
		if(this.comment != null)
			if(this.comment.length() > 200)
				listOfErrors.add("The length of the field [comment] in the value object [ims.core.vo.PDSAdvancedSearchRequestVo] is too big. It should be less or equal to 200");
		if(this.requesttype == null)
			listOfErrors.add("requestType is mandatory");
		if(this.requestdate == null)
			listOfErrors.add("requestDate is mandatory");
		if(this.nhsnumber != null)
			if(this.nhsnumber.length() > 12)
				listOfErrors.add("The length of the field [nhsnumber] in the value object [ims.core.vo.PDSAdvancedSearchRequestVo] is too big. It should be less or equal to 12");
		if(this.surname != null)
			if(this.surname.length() > 40)
				listOfErrors.add("The length of the field [surname] in the value object [ims.core.vo.PDSAdvancedSearchRequestVo] is too big. It should be less or equal to 40");
		if(this.forename != null)
			if(this.forename.length() > 40)
				listOfErrors.add("The length of the field [forename] in the value object [ims.core.vo.PDSAdvancedSearchRequestVo] is too big. It should be less or equal to 40");
		if(this.searchresult != null)
		{
			String[] listOfOtherErrors = this.searchresult.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.gppracticecode != null)
			if(this.gppracticecode.length() > 25)
				listOfErrors.add("The length of the field [gppracticecode] in the value object [ims.core.vo.PDSAdvancedSearchRequestVo] is too big. It should be less or equal to 25");
		if(this.sdsjobrolecode != null)
			if(this.sdsjobrolecode.length() > 20)
				listOfErrors.add("The length of the field [sdsjobrolecode] in the value object [ims.core.vo.PDSAdvancedSearchRequestVo] is too big. It should be less or equal to 20");
		if(this.postcode != null)
			if(this.postcode.length() > 10)
				listOfErrors.add("The length of the field [postcode] in the value object [ims.core.vo.PDSAdvancedSearchRequestVo] is too big. It should be less or equal to 10");
		if(this.middlename != null)
			if(this.middlename.length() > 40)
				listOfErrors.add("The length of the field [middlename] in the value object [ims.core.vo.PDSAdvancedSearchRequestVo] is too big. It should be less or equal to 40");
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
	
		PDSAdvancedSearchRequestVo clone = new PDSAdvancedSearchRequestVo(this.id, this.version);
		
		clone.sdsroleprofileid = this.sdsroleprofileid;
		clone.sdsuserid = this.sdsuserid;
		if(this.pdsack == null)
			clone.pdsack = null;
		else
			clone.pdsack = (ims.core.vo.lookups.PDSRequestAckStatus)this.pdsack.clone();
		if(this.pdsackdetailtype == null)
			clone.pdsackdetailtype = null;
		else
			clone.pdsackdetailtype = (ims.core.vo.lookups.PDSAckDetailType)this.pdsackdetailtype.clone();
		clone.active = this.active;
		clone.comment = this.comment;
		if(this.requesttype == null)
			clone.requesttype = null;
		else
			clone.requesttype = (ims.core.vo.lookups.PDSAsyncRequestType)this.requesttype.clone();
		if(this.requestdate == null)
			clone.requestdate = null;
		else
			clone.requestdate = (ims.framework.utils.DateTime)this.requestdate.clone();
		if(this.searchstatus == null)
			clone.searchstatus = null;
		else
			clone.searchstatus = (ims.core.vo.lookups.PDSSearchStatus)this.searchstatus.clone();
		if(this.searchtype == null)
			clone.searchtype = null;
		else
			clone.searchtype = (ims.core.vo.lookups.PDSSearchType)this.searchtype.clone();
		if(this.historicdataflag == null)
			clone.historicdataflag = null;
		else
			clone.historicdataflag = (ims.core.vo.lookups.PDSHistoryDataFlag)this.historicdataflag.clone();
		if(this.ignorehistoryindicator == null)
			clone.ignorehistoryindicator = null;
		else
			clone.ignorehistoryindicator = (ims.core.vo.lookups.PDSIgnoreHistoryIndicator)this.ignorehistoryindicator.clone();
		clone.nhsnumber = this.nhsnumber;
		clone.surname = this.surname;
		clone.forename = this.forename;
		if(this.gender == null)
			clone.gender = null;
		else
			clone.gender = (ims.core.vo.lookups.Sex)this.gender.clone();
		if(this.fromdateofbirth == null)
			clone.fromdateofbirth = null;
		else
			clone.fromdateofbirth = (ims.framework.utils.Date)this.fromdateofbirth.clone();
		if(this.todateofbirth == null)
			clone.todateofbirth = null;
		else
			clone.todateofbirth = (ims.framework.utils.Date)this.todateofbirth.clone();
		if(this.fromdateofdeath == null)
			clone.fromdateofdeath = null;
		else
			clone.fromdateofdeath = (ims.framework.utils.Date)this.fromdateofdeath.clone();
		if(this.todateofdeath == null)
			clone.todateofdeath = null;
		else
			clone.todateofdeath = (ims.framework.utils.Date)this.todateofdeath.clone();
		if(this.searchresult == null)
			clone.searchresult = null;
		else
			clone.searchresult = (ims.core.vo.PDSAdvancedSearchResultVoCollection)this.searchresult.clone();
		clone.convid = this.convid;
		if(this.address == null)
			clone.address = null;
		else
			clone.address = (ims.core.vo.AddressVo)this.address.clone();
		clone.gppracticecode = this.gppracticecode;
		clone.sdsjobrolecode = this.sdsjobrolecode;
		clone.postcode = this.postcode;
		clone.middlename = this.middlename;
		if(this.dobrangeunit == null)
			clone.dobrangeunit = null;
		else
			clone.dobrangeunit = (ims.core.vo.lookups.TimeUnitsSecondsToYears)this.dobrangeunit.clone();
		if(this.dodrangeunit == null)
			clone.dodrangeunit = null;
		else
			clone.dodrangeunit = (ims.core.vo.lookups.TimeUnitsSecondsToYears)this.dodrangeunit.clone();
		clone.dobrangevalue = this.dobrangevalue;
		clone.dodrangevalue = this.dodrangevalue;
		if(this.dobpartialsearchby == null)
			clone.dobpartialsearchby = null;
		else
			clone.dobpartialsearchby = (ims.core.vo.lookups.TimeUnitsSecondsToYears)this.dobpartialsearchby.clone();
		if(this.dodpartialsearchby == null)
			clone.dodpartialsearchby = null;
		else
			clone.dodpartialsearchby = (ims.core.vo.lookups.TimeUnitsSecondsToYears)this.dodpartialsearchby.clone();
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
		if (!(PDSAdvancedSearchRequestVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PDSAdvancedSearchRequestVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PDSAdvancedSearchRequestVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PDSAdvancedSearchRequestVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.sdsroleprofileid != null)
			count++;
		if(this.sdsuserid != null)
			count++;
		if(this.pdsack != null)
			count++;
		if(this.pdsackdetailtype != null)
			count++;
		if(this.active != null)
			count++;
		if(this.comment != null)
			count++;
		if(this.requesttype != null)
			count++;
		if(this.requestdate != null)
			count++;
		if(this.searchstatus != null)
			count++;
		if(this.searchtype != null)
			count++;
		if(this.historicdataflag != null)
			count++;
		if(this.ignorehistoryindicator != null)
			count++;
		if(this.nhsnumber != null)
			count++;
		if(this.surname != null)
			count++;
		if(this.forename != null)
			count++;
		if(this.gender != null)
			count++;
		if(this.fromdateofbirth != null)
			count++;
		if(this.todateofbirth != null)
			count++;
		if(this.fromdateofdeath != null)
			count++;
		if(this.todateofdeath != null)
			count++;
		if(this.searchresult != null)
			count++;
		if(this.convid != null)
			count++;
		if(this.address != null)
			count++;
		if(this.gppracticecode != null)
			count++;
		if(this.sdsjobrolecode != null)
			count++;
		if(this.postcode != null)
			count++;
		if(this.middlename != null)
			count++;
		if(this.dobrangeunit != null)
			count++;
		if(this.dodrangeunit != null)
			count++;
		if(this.dobrangevalue != null)
			count++;
		if(this.dodrangevalue != null)
			count++;
		if(this.dobpartialsearchby != null)
			count++;
		if(this.dodpartialsearchby != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 33;
	}
	protected String sdsroleprofileid;
	protected String sdsuserid;
	protected ims.core.vo.lookups.PDSRequestAckStatus pdsack;
	protected ims.core.vo.lookups.PDSAckDetailType pdsackdetailtype;
	protected Boolean active;
	protected String comment;
	protected ims.core.vo.lookups.PDSAsyncRequestType requesttype;
	protected ims.framework.utils.DateTime requestdate;
	protected ims.core.vo.lookups.PDSSearchStatus searchstatus;
	protected ims.core.vo.lookups.PDSSearchType searchtype;
	protected ims.core.vo.lookups.PDSHistoryDataFlag historicdataflag;
	protected ims.core.vo.lookups.PDSIgnoreHistoryIndicator ignorehistoryindicator;
	protected String nhsnumber;
	protected String surname;
	protected String forename;
	protected ims.core.vo.lookups.Sex gender;
	protected ims.framework.utils.Date fromdateofbirth;
	protected ims.framework.utils.Date todateofbirth;
	protected ims.framework.utils.Date fromdateofdeath;
	protected ims.framework.utils.Date todateofdeath;
	protected ims.core.vo.PDSAdvancedSearchResultVoCollection searchresult;
	protected ims.choose_book.vo.PDSConvRefVo convid;
	protected ims.core.vo.AddressVo address;
	protected String gppracticecode;
	protected String sdsjobrolecode;
	protected String postcode;
	protected String middlename;
	protected ims.core.vo.lookups.TimeUnitsSecondsToYears dobrangeunit;
	protected ims.core.vo.lookups.TimeUnitsSecondsToYears dodrangeunit;
	protected Integer dobrangevalue;
	protected Integer dodrangevalue;
	protected ims.core.vo.lookups.TimeUnitsSecondsToYears dobpartialsearchby;
	protected ims.core.vo.lookups.TimeUnitsSecondsToYears dodpartialsearchby;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
