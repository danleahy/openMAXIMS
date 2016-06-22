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
 * Linked to core.patient.PDSAdvancedSearchResult business object (ID: 1001100017).
 */
public class PDSAdvancedSearchResultVo extends ims.core.patient.vo.PDSAdvancedSearchResultRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PDSAdvancedSearchResultVo()
	{
	}
	public PDSAdvancedSearchResultVo(Integer id, int version)
	{
		super(id, version);
	}
	public PDSAdvancedSearchResultVo(ims.core.vo.beans.PDSAdvancedSearchResultVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.nhsnumber = bean.getNHSNumber();
		this.surname = bean.getSurname();
		this.uppersurname = bean.getUpperSurname();
		this.forename = bean.getForename();
		this.upperforename = bean.getUpperForename();
		this.preferredname = bean.getPreferredName();
		this.gender = bean.getGender() == null ? null : ims.core.vo.lookups.Sex.buildLookup(bean.getGender());
		this.dateofbirth = bean.getDateOfBirth() == null ? null : bean.getDateOfBirth().buildDate();
		this.dateofdeath = bean.getDateOfDeath() == null ? null : bean.getDateOfDeath().buildDate();
		this.primarycareinfo = bean.getPrimaryCareInfo();
		this.confidentialitycode = bean.getConfidentialityCode();
		this.nhsnumbertype = bean.getNHSNumberType() == null ? null : ims.core.vo.lookups.PatIdType.buildLookup(bean.getNHSNumberType());
		this.title = bean.getTitle() == null ? null : ims.core.vo.lookups.PersonTitle.buildLookup(bean.getTitle());
		this.nametype = bean.getNameType() == null ? null : ims.core.vo.lookups.NameType.buildLookup(bean.getNameType());
		this.namesuffix = bean.getNamesuffix();
		this.pdsaddresses = ims.core.vo.PDSAddrVoCollection.buildFromBeanCollection(bean.getPDSAddresses());
		this.pdstellecoms = ims.core.vo.PDSTelecomVoCollection.buildFromBeanCollection(bean.getPDSTellecoms());
		this.pdserrcreationtime = bean.getPdsErrCreationTime() == null ? null : bean.getPdsErrCreationTime().buildDateTime();
		this.pdserrinteractionid = bean.getPdsErrInteractionId();
		this.pdserrprocessingcode = bean.getPdsErrProcessingCode();
		this.pdserrqueryresponsecode = bean.getPdsErrQueryResponseCode();
		this.pdserrid = bean.getPdsErrId();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PDSAdvancedSearchResultVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.nhsnumber = bean.getNHSNumber();
		this.surname = bean.getSurname();
		this.uppersurname = bean.getUpperSurname();
		this.forename = bean.getForename();
		this.upperforename = bean.getUpperForename();
		this.preferredname = bean.getPreferredName();
		this.gender = bean.getGender() == null ? null : ims.core.vo.lookups.Sex.buildLookup(bean.getGender());
		this.dateofbirth = bean.getDateOfBirth() == null ? null : bean.getDateOfBirth().buildDate();
		this.dateofdeath = bean.getDateOfDeath() == null ? null : bean.getDateOfDeath().buildDate();
		this.primarycareinfo = bean.getPrimaryCareInfo();
		this.confidentialitycode = bean.getConfidentialityCode();
		this.nhsnumbertype = bean.getNHSNumberType() == null ? null : ims.core.vo.lookups.PatIdType.buildLookup(bean.getNHSNumberType());
		this.title = bean.getTitle() == null ? null : ims.core.vo.lookups.PersonTitle.buildLookup(bean.getTitle());
		this.nametype = bean.getNameType() == null ? null : ims.core.vo.lookups.NameType.buildLookup(bean.getNameType());
		this.namesuffix = bean.getNamesuffix();
		this.pdsaddresses = ims.core.vo.PDSAddrVoCollection.buildFromBeanCollection(bean.getPDSAddresses());
		this.pdstellecoms = ims.core.vo.PDSTelecomVoCollection.buildFromBeanCollection(bean.getPDSTellecoms());
		this.pdserrcreationtime = bean.getPdsErrCreationTime() == null ? null : bean.getPdsErrCreationTime().buildDateTime();
		this.pdserrinteractionid = bean.getPdsErrInteractionId();
		this.pdserrprocessingcode = bean.getPdsErrProcessingCode();
		this.pdserrqueryresponsecode = bean.getPdsErrQueryResponseCode();
		this.pdserrid = bean.getPdsErrId();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PDSAdvancedSearchResultVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PDSAdvancedSearchResultVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PDSAdvancedSearchResultVoBean();
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
		if(fieldName.equals("NHSNUMBER"))
			return getNHSNumber();
		if(fieldName.equals("SURNAME"))
			return getSurname();
		if(fieldName.equals("UPPERSURNAME"))
			return getUpperSurname();
		if(fieldName.equals("FORENAME"))
			return getForename();
		if(fieldName.equals("UPPERFORENAME"))
			return getUpperForename();
		if(fieldName.equals("PREFERREDNAME"))
			return getPreferredName();
		if(fieldName.equals("GENDER"))
			return getGender();
		if(fieldName.equals("DATEOFBIRTH"))
			return getDateOfBirth();
		if(fieldName.equals("DATEOFDEATH"))
			return getDateOfDeath();
		if(fieldName.equals("PRIMARYCAREINFO"))
			return getPrimaryCareInfo();
		if(fieldName.equals("CONFIDENTIALITYCODE"))
			return getConfidentialityCode();
		if(fieldName.equals("NHSNUMBERTYPE"))
			return getNHSNumberType();
		if(fieldName.equals("TITLE"))
			return getTitle();
		if(fieldName.equals("NAMETYPE"))
			return getNameType();
		if(fieldName.equals("NAMESUFFIX"))
			return getNamesuffix();
		if(fieldName.equals("PDSADDRESSES"))
			return getPDSAddresses();
		if(fieldName.equals("PDSTELLECOMS"))
			return getPDSTellecoms();
		if(fieldName.equals("PDSERRCREATIONTIME"))
			return getPdsErrCreationTime();
		if(fieldName.equals("PDSERRINTERACTIONID"))
			return getPdsErrInteractionId();
		if(fieldName.equals("PDSERRPROCESSINGCODE"))
			return getPdsErrProcessingCode();
		if(fieldName.equals("PDSERRQUERYRESPONSECODE"))
			return getPdsErrQueryResponseCode();
		if(fieldName.equals("PDSERRID"))
			return getPdsErrId();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getUpperSurnameIsNotNull()
	{
		return this.uppersurname != null;
	}
	public String getUpperSurname()
	{
		return this.uppersurname;
	}
	public static int getUpperSurnameMaxLength()
	{
		return 40;
	}
	public void setUpperSurname(String value)
	{
		this.isValidated = false;
		this.uppersurname = value;
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
	public boolean getUpperForenameIsNotNull()
	{
		return this.upperforename != null;
	}
	public String getUpperForename()
	{
		return this.upperforename;
	}
	public static int getUpperForenameMaxLength()
	{
		return 40;
	}
	public void setUpperForename(String value)
	{
		this.isValidated = false;
		this.upperforename = value;
	}
	public boolean getPreferredNameIsNotNull()
	{
		return this.preferredname != null;
	}
	public String getPreferredName()
	{
		return this.preferredname;
	}
	public static int getPreferredNameMaxLength()
	{
		return 40;
	}
	public void setPreferredName(String value)
	{
		this.isValidated = false;
		this.preferredname = value;
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
	public boolean getDateOfBirthIsNotNull()
	{
		return this.dateofbirth != null;
	}
	public ims.framework.utils.Date getDateOfBirth()
	{
		return this.dateofbirth;
	}
	public void setDateOfBirth(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateofbirth = value;
	}
	public boolean getDateOfDeathIsNotNull()
	{
		return this.dateofdeath != null;
	}
	public ims.framework.utils.Date getDateOfDeath()
	{
		return this.dateofdeath;
	}
	public void setDateOfDeath(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateofdeath = value;
	}
	public boolean getPrimaryCareInfoIsNotNull()
	{
		return this.primarycareinfo != null;
	}
	public String getPrimaryCareInfo()
	{
		return this.primarycareinfo;
	}
	public static int getPrimaryCareInfoMaxLength()
	{
		return 40;
	}
	public void setPrimaryCareInfo(String value)
	{
		this.isValidated = false;
		this.primarycareinfo = value;
	}
	public boolean getConfidentialityCodeIsNotNull()
	{
		return this.confidentialitycode != null;
	}
	public String getConfidentialityCode()
	{
		return this.confidentialitycode;
	}
	public static int getConfidentialityCodeMaxLength()
	{
		return 1;
	}
	public void setConfidentialityCode(String value)
	{
		this.isValidated = false;
		this.confidentialitycode = value;
	}
	public boolean getNHSNumberTypeIsNotNull()
	{
		return this.nhsnumbertype != null;
	}
	public ims.core.vo.lookups.PatIdType getNHSNumberType()
	{
		return this.nhsnumbertype;
	}
	public void setNHSNumberType(ims.core.vo.lookups.PatIdType value)
	{
		this.isValidated = false;
		this.nhsnumbertype = value;
	}
	public boolean getTitleIsNotNull()
	{
		return this.title != null;
	}
	public ims.core.vo.lookups.PersonTitle getTitle()
	{
		return this.title;
	}
	public void setTitle(ims.core.vo.lookups.PersonTitle value)
	{
		this.isValidated = false;
		this.title = value;
	}
	public boolean getNameTypeIsNotNull()
	{
		return this.nametype != null;
	}
	public ims.core.vo.lookups.NameType getNameType()
	{
		return this.nametype;
	}
	public void setNameType(ims.core.vo.lookups.NameType value)
	{
		this.isValidated = false;
		this.nametype = value;
	}
	public boolean getNamesuffixIsNotNull()
	{
		return this.namesuffix != null;
	}
	public String getNamesuffix()
	{
		return this.namesuffix;
	}
	public static int getNamesuffixMaxLength()
	{
		return 35;
	}
	public void setNamesuffix(String value)
	{
		this.isValidated = false;
		this.namesuffix = value;
	}
	public boolean getPDSAddressesIsNotNull()
	{
		return this.pdsaddresses != null;
	}
	public ims.core.vo.PDSAddrVoCollection getPDSAddresses()
	{
		return this.pdsaddresses;
	}
	public void setPDSAddresses(ims.core.vo.PDSAddrVoCollection value)
	{
		this.isValidated = false;
		this.pdsaddresses = value;
	}
	public boolean getPDSTellecomsIsNotNull()
	{
		return this.pdstellecoms != null;
	}
	public ims.core.vo.PDSTelecomVoCollection getPDSTellecoms()
	{
		return this.pdstellecoms;
	}
	public void setPDSTellecoms(ims.core.vo.PDSTelecomVoCollection value)
	{
		this.isValidated = false;
		this.pdstellecoms = value;
	}
	public boolean getPdsErrCreationTimeIsNotNull()
	{
		return this.pdserrcreationtime != null;
	}
	public ims.framework.utils.DateTime getPdsErrCreationTime()
	{
		return this.pdserrcreationtime;
	}
	public void setPdsErrCreationTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.pdserrcreationtime = value;
	}
	public boolean getPdsErrInteractionIdIsNotNull()
	{
		return this.pdserrinteractionid != null;
	}
	public String getPdsErrInteractionId()
	{
		return this.pdserrinteractionid;
	}
	public static int getPdsErrInteractionIdMaxLength()
	{
		return 100;
	}
	public void setPdsErrInteractionId(String value)
	{
		this.isValidated = false;
		this.pdserrinteractionid = value;
	}
	public boolean getPdsErrProcessingCodeIsNotNull()
	{
		return this.pdserrprocessingcode != null;
	}
	public String getPdsErrProcessingCode()
	{
		return this.pdserrprocessingcode;
	}
	public static int getPdsErrProcessingCodeMaxLength()
	{
		return 100;
	}
	public void setPdsErrProcessingCode(String value)
	{
		this.isValidated = false;
		this.pdserrprocessingcode = value;
	}
	public boolean getPdsErrQueryResponseCodeIsNotNull()
	{
		return this.pdserrqueryresponsecode != null;
	}
	public String getPdsErrQueryResponseCode()
	{
		return this.pdserrqueryresponsecode;
	}
	public static int getPdsErrQueryResponseCodeMaxLength()
	{
		return 2000;
	}
	public void setPdsErrQueryResponseCode(String value)
	{
		this.isValidated = false;
		this.pdserrqueryresponsecode = value;
	}
	public boolean getPdsErrIdIsNotNull()
	{
		return this.pdserrid != null;
	}
	public String getPdsErrId()
	{
		return this.pdserrid;
	}
	public static int getPdsErrIdMaxLength()
	{
		return 100;
	}
	public void setPdsErrId(String value)
	{
		this.isValidated = false;
		this.pdserrid = value;
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
		if(this.nhsnumber != null)
			if(this.nhsnumber.length() > 12)
				listOfErrors.add("The length of the field [nhsnumber] in the value object [ims.core.vo.PDSAdvancedSearchResultVo] is too big. It should be less or equal to 12");
		if(this.surname != null)
			if(this.surname.length() > 40)
				listOfErrors.add("The length of the field [surname] in the value object [ims.core.vo.PDSAdvancedSearchResultVo] is too big. It should be less or equal to 40");
		if(this.uppersurname != null)
			if(this.uppersurname.length() > 40)
				listOfErrors.add("The length of the field [uppersurname] in the value object [ims.core.vo.PDSAdvancedSearchResultVo] is too big. It should be less or equal to 40");
		if(this.forename != null)
			if(this.forename.length() > 40)
				listOfErrors.add("The length of the field [forename] in the value object [ims.core.vo.PDSAdvancedSearchResultVo] is too big. It should be less or equal to 40");
		if(this.upperforename != null)
			if(this.upperforename.length() > 40)
				listOfErrors.add("The length of the field [upperforename] in the value object [ims.core.vo.PDSAdvancedSearchResultVo] is too big. It should be less or equal to 40");
		if(this.preferredname != null)
			if(this.preferredname.length() > 40)
				listOfErrors.add("The length of the field [preferredname] in the value object [ims.core.vo.PDSAdvancedSearchResultVo] is too big. It should be less or equal to 40");
		if(this.primarycareinfo != null)
			if(this.primarycareinfo.length() > 40)
				listOfErrors.add("The length of the field [primarycareinfo] in the value object [ims.core.vo.PDSAdvancedSearchResultVo] is too big. It should be less or equal to 40");
		if(this.confidentialitycode != null)
			if(this.confidentialitycode.length() > 1)
				listOfErrors.add("The length of the field [confidentialitycode] in the value object [ims.core.vo.PDSAdvancedSearchResultVo] is too big. It should be less or equal to 1");
		if(this.namesuffix != null)
			if(this.namesuffix.length() > 35)
				listOfErrors.add("The length of the field [namesuffix] in the value object [ims.core.vo.PDSAdvancedSearchResultVo] is too big. It should be less or equal to 35");
		if(this.pdserrinteractionid != null)
			if(this.pdserrinteractionid.length() > 100)
				listOfErrors.add("The length of the field [pdserrinteractionid] in the value object [ims.core.vo.PDSAdvancedSearchResultVo] is too big. It should be less or equal to 100");
		if(this.pdserrprocessingcode != null)
			if(this.pdserrprocessingcode.length() > 100)
				listOfErrors.add("The length of the field [pdserrprocessingcode] in the value object [ims.core.vo.PDSAdvancedSearchResultVo] is too big. It should be less or equal to 100");
		if(this.pdserrqueryresponsecode != null)
			if(this.pdserrqueryresponsecode.length() > 2000)
				listOfErrors.add("The length of the field [pdserrqueryresponsecode] in the value object [ims.core.vo.PDSAdvancedSearchResultVo] is too big. It should be less or equal to 2000");
		if(this.pdserrid != null)
			if(this.pdserrid.length() > 100)
				listOfErrors.add("The length of the field [pdserrid] in the value object [ims.core.vo.PDSAdvancedSearchResultVo] is too big. It should be less or equal to 100");
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
	
		PDSAdvancedSearchResultVo clone = new PDSAdvancedSearchResultVo(this.id, this.version);
		
		clone.nhsnumber = this.nhsnumber;
		clone.surname = this.surname;
		clone.uppersurname = this.uppersurname;
		clone.forename = this.forename;
		clone.upperforename = this.upperforename;
		clone.preferredname = this.preferredname;
		if(this.gender == null)
			clone.gender = null;
		else
			clone.gender = (ims.core.vo.lookups.Sex)this.gender.clone();
		if(this.dateofbirth == null)
			clone.dateofbirth = null;
		else
			clone.dateofbirth = (ims.framework.utils.Date)this.dateofbirth.clone();
		if(this.dateofdeath == null)
			clone.dateofdeath = null;
		else
			clone.dateofdeath = (ims.framework.utils.Date)this.dateofdeath.clone();
		clone.primarycareinfo = this.primarycareinfo;
		clone.confidentialitycode = this.confidentialitycode;
		if(this.nhsnumbertype == null)
			clone.nhsnumbertype = null;
		else
			clone.nhsnumbertype = (ims.core.vo.lookups.PatIdType)this.nhsnumbertype.clone();
		if(this.title == null)
			clone.title = null;
		else
			clone.title = (ims.core.vo.lookups.PersonTitle)this.title.clone();
		if(this.nametype == null)
			clone.nametype = null;
		else
			clone.nametype = (ims.core.vo.lookups.NameType)this.nametype.clone();
		clone.namesuffix = this.namesuffix;
		if(this.pdsaddresses == null)
			clone.pdsaddresses = null;
		else
			clone.pdsaddresses = (ims.core.vo.PDSAddrVoCollection)this.pdsaddresses.clone();
		if(this.pdstellecoms == null)
			clone.pdstellecoms = null;
		else
			clone.pdstellecoms = (ims.core.vo.PDSTelecomVoCollection)this.pdstellecoms.clone();
		if(this.pdserrcreationtime == null)
			clone.pdserrcreationtime = null;
		else
			clone.pdserrcreationtime = (ims.framework.utils.DateTime)this.pdserrcreationtime.clone();
		clone.pdserrinteractionid = this.pdserrinteractionid;
		clone.pdserrprocessingcode = this.pdserrprocessingcode;
		clone.pdserrqueryresponsecode = this.pdserrqueryresponsecode;
		clone.pdserrid = this.pdserrid;
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
		if (!(PDSAdvancedSearchResultVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PDSAdvancedSearchResultVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PDSAdvancedSearchResultVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PDSAdvancedSearchResultVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.nhsnumber != null)
			count++;
		if(this.surname != null)
			count++;
		if(this.uppersurname != null)
			count++;
		if(this.forename != null)
			count++;
		if(this.upperforename != null)
			count++;
		if(this.preferredname != null)
			count++;
		if(this.gender != null)
			count++;
		if(this.dateofbirth != null)
			count++;
		if(this.dateofdeath != null)
			count++;
		if(this.primarycareinfo != null)
			count++;
		if(this.confidentialitycode != null)
			count++;
		if(this.nhsnumbertype != null)
			count++;
		if(this.title != null)
			count++;
		if(this.nametype != null)
			count++;
		if(this.namesuffix != null)
			count++;
		if(this.pdsaddresses != null)
			count++;
		if(this.pdstellecoms != null)
			count++;
		if(this.pdserrcreationtime != null)
			count++;
		if(this.pdserrinteractionid != null)
			count++;
		if(this.pdserrprocessingcode != null)
			count++;
		if(this.pdserrqueryresponsecode != null)
			count++;
		if(this.pdserrid != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 22;
	}
	protected String nhsnumber;
	protected String surname;
	protected String uppersurname;
	protected String forename;
	protected String upperforename;
	protected String preferredname;
	protected ims.core.vo.lookups.Sex gender;
	protected ims.framework.utils.Date dateofbirth;
	protected ims.framework.utils.Date dateofdeath;
	protected String primarycareinfo;
	protected String confidentialitycode;
	protected ims.core.vo.lookups.PatIdType nhsnumbertype;
	protected ims.core.vo.lookups.PersonTitle title;
	protected ims.core.vo.lookups.NameType nametype;
	protected String namesuffix;
	protected ims.core.vo.PDSAddrVoCollection pdsaddresses;
	protected ims.core.vo.PDSTelecomVoCollection pdstellecoms;
	protected ims.framework.utils.DateTime pdserrcreationtime;
	protected String pdserrinteractionid;
	protected String pdserrprocessingcode;
	protected String pdserrqueryresponsecode;
	protected String pdserrid;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
