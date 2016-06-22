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

package ims.pci.vo;

/**
 * Linked to PCI.ClientBirthDetails business object (ID: 1091100001).
 */
public class ClientBirthDetailsVo extends ims.pci.vo.ClientBirthDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClientBirthDetailsVo()
	{
	}
	public ClientBirthDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClientBirthDetailsVo(ims.pci.vo.beans.ClientBirthDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.client = bean.getClient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getClient().getId()), bean.getClient().getVersion());
		this.placeofbirth = bean.getPlaceOfBirth() == null ? null : ims.pci.vo.lookups.PlaceOfBirth.buildLookup(bean.getPlaceOfBirth());
		this.weightatbirth = bean.getWeightAtBirth();
		this.datenotified = bean.getDateNotified() == null ? null : bean.getDateNotified().buildDate();
		this.durationofpregnancy = bean.getDurationOfPregnancy();
		this.deliverymethod = bean.getDeliveryMethod() == null ? null : ims.pci.vo.lookups.DeliveryMethodBirth.buildLookup(bean.getDeliveryMethod());
		this.episiotomy = bean.getEpisiotomy() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getEpisiotomy());
		this.epidural = bean.getEpidural() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getEpidural());
		this.orderofbirthorder = bean.getOrderOfBirthOrder();
		this.orderofbirthnr = bean.getOrderOfBirthNr();
		this.apgar1 = bean.getApgar1();
		this.apgar5 = bean.getApgar5();
		this.apgar10 = bean.getApgar10();
		this.stillborn = bean.getStillborn();
		this.live = bean.getLive();
		this.miscarriages = bean.getMiscarriages();
		this.maritalstatusatbirth = bean.getMaritalStatusAtBirth() == null ? null : ims.pci.vo.lookups.MaritalStatusAtBirth.buildLookup(bean.getMaritalStatusAtBirth());
		this.pkutest = bean.getPKUTest() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getPKUTest());
		this.stillbornindicator = bean.getStillBornIndicator();
		this.breastfeeding = bean.getBreastFeeding() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getBreastFeeding());
		this.breastfeedingatdischarge = bean.getBreastFeedingAtDischarge() == null ? null : ims.pci.vo.lookups.BreastFeedingStatus.buildLookup(bean.getBreastFeedingAtDischarge());
		this.breastfeedingat3months = bean.getBreastFeedingAt3months() == null ? null : ims.pci.vo.lookups.BreastFeedingStatus.buildLookup(bean.getBreastFeedingAt3months());
		this.breastfeedingatphn = bean.getBreastFeedingAtPHN() == null ? null : ims.pci.vo.lookups.BreastFeedingStatus.buildLookup(bean.getBreastFeedingAtPHN());
		this.clientnotes = bean.getClientNotes();
		this.clientidofmother = bean.getClientIDOfMother();
		this.timeofbirth = bean.getTimeOfBirth();
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.firstphnvisitdatetime = bean.getFirstPHNVisitDateTime() == null ? null : bean.getFirstPHNVisitDateTime().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pci.vo.beans.ClientBirthDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.client = bean.getClient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getClient().getId()), bean.getClient().getVersion());
		this.placeofbirth = bean.getPlaceOfBirth() == null ? null : ims.pci.vo.lookups.PlaceOfBirth.buildLookup(bean.getPlaceOfBirth());
		this.weightatbirth = bean.getWeightAtBirth();
		this.datenotified = bean.getDateNotified() == null ? null : bean.getDateNotified().buildDate();
		this.durationofpregnancy = bean.getDurationOfPregnancy();
		this.deliverymethod = bean.getDeliveryMethod() == null ? null : ims.pci.vo.lookups.DeliveryMethodBirth.buildLookup(bean.getDeliveryMethod());
		this.episiotomy = bean.getEpisiotomy() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getEpisiotomy());
		this.epidural = bean.getEpidural() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getEpidural());
		this.orderofbirthorder = bean.getOrderOfBirthOrder();
		this.orderofbirthnr = bean.getOrderOfBirthNr();
		this.apgar1 = bean.getApgar1();
		this.apgar5 = bean.getApgar5();
		this.apgar10 = bean.getApgar10();
		this.stillborn = bean.getStillborn();
		this.live = bean.getLive();
		this.miscarriages = bean.getMiscarriages();
		this.maritalstatusatbirth = bean.getMaritalStatusAtBirth() == null ? null : ims.pci.vo.lookups.MaritalStatusAtBirth.buildLookup(bean.getMaritalStatusAtBirth());
		this.pkutest = bean.getPKUTest() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getPKUTest());
		this.stillbornindicator = bean.getStillBornIndicator();
		this.breastfeeding = bean.getBreastFeeding() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getBreastFeeding());
		this.breastfeedingatdischarge = bean.getBreastFeedingAtDischarge() == null ? null : ims.pci.vo.lookups.BreastFeedingStatus.buildLookup(bean.getBreastFeedingAtDischarge());
		this.breastfeedingat3months = bean.getBreastFeedingAt3months() == null ? null : ims.pci.vo.lookups.BreastFeedingStatus.buildLookup(bean.getBreastFeedingAt3months());
		this.breastfeedingatphn = bean.getBreastFeedingAtPHN() == null ? null : ims.pci.vo.lookups.BreastFeedingStatus.buildLookup(bean.getBreastFeedingAtPHN());
		this.clientnotes = bean.getClientNotes();
		this.clientidofmother = bean.getClientIDOfMother();
		this.timeofbirth = bean.getTimeOfBirth();
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.firstphnvisitdatetime = bean.getFirstPHNVisitDateTime() == null ? null : bean.getFirstPHNVisitDateTime().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pci.vo.beans.ClientBirthDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.pci.vo.beans.ClientBirthDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pci.vo.beans.ClientBirthDetailsVoBean();
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
		if(fieldName.equals("CLIENT"))
			return getClient();
		if(fieldName.equals("PLACEOFBIRTH"))
			return getPlaceOfBirth();
		if(fieldName.equals("WEIGHTATBIRTH"))
			return getWeightAtBirth();
		if(fieldName.equals("DATENOTIFIED"))
			return getDateNotified();
		if(fieldName.equals("DURATIONOFPREGNANCY"))
			return getDurationOfPregnancy();
		if(fieldName.equals("DELIVERYMETHOD"))
			return getDeliveryMethod();
		if(fieldName.equals("EPISIOTOMY"))
			return getEpisiotomy();
		if(fieldName.equals("EPIDURAL"))
			return getEpidural();
		if(fieldName.equals("ORDEROFBIRTHORDER"))
			return getOrderOfBirthOrder();
		if(fieldName.equals("ORDEROFBIRTHNR"))
			return getOrderOfBirthNr();
		if(fieldName.equals("APGAR1"))
			return getApgar1();
		if(fieldName.equals("APGAR5"))
			return getApgar5();
		if(fieldName.equals("APGAR10"))
			return getApgar10();
		if(fieldName.equals("STILLBORN"))
			return getStillborn();
		if(fieldName.equals("LIVE"))
			return getLive();
		if(fieldName.equals("MISCARRIAGES"))
			return getMiscarriages();
		if(fieldName.equals("MARITALSTATUSATBIRTH"))
			return getMaritalStatusAtBirth();
		if(fieldName.equals("PKUTEST"))
			return getPKUTest();
		if(fieldName.equals("STILLBORNINDICATOR"))
			return getStillBornIndicator();
		if(fieldName.equals("BREASTFEEDING"))
			return getBreastFeeding();
		if(fieldName.equals("BREASTFEEDINGATDISCHARGE"))
			return getBreastFeedingAtDischarge();
		if(fieldName.equals("BREASTFEEDINGAT3MONTHS"))
			return getBreastFeedingAt3months();
		if(fieldName.equals("BREASTFEEDINGATPHN"))
			return getBreastFeedingAtPHN();
		if(fieldName.equals("CLIENTNOTES"))
			return getClientNotes();
		if(fieldName.equals("CLIENTIDOFMOTHER"))
			return getClientIDOfMother();
		if(fieldName.equals("TIMEOFBIRTH"))
			return getTimeOfBirth();
		if(fieldName.equals("DISCHARGEDATETIME"))
			return getDischargeDateTime();
		if(fieldName.equals("FIRSTPHNVISITDATETIME"))
			return getFirstPHNVisitDateTime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getClientIsNotNull()
	{
		return this.client != null;
	}
	public ims.core.patient.vo.PatientRefVo getClient()
	{
		return this.client;
	}
	public void setClient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.client = value;
	}
	public boolean getPlaceOfBirthIsNotNull()
	{
		return this.placeofbirth != null;
	}
	public ims.pci.vo.lookups.PlaceOfBirth getPlaceOfBirth()
	{
		return this.placeofbirth;
	}
	public void setPlaceOfBirth(ims.pci.vo.lookups.PlaceOfBirth value)
	{
		this.isValidated = false;
		this.placeofbirth = value;
	}
	public boolean getWeightAtBirthIsNotNull()
	{
		return this.weightatbirth != null;
	}
	public Integer getWeightAtBirth()
	{
		return this.weightatbirth;
	}
	public void setWeightAtBirth(Integer value)
	{
		this.isValidated = false;
		this.weightatbirth = value;
	}
	public boolean getDateNotifiedIsNotNull()
	{
		return this.datenotified != null;
	}
	public ims.framework.utils.Date getDateNotified()
	{
		return this.datenotified;
	}
	public void setDateNotified(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datenotified = value;
	}
	public boolean getDurationOfPregnancyIsNotNull()
	{
		return this.durationofpregnancy != null;
	}
	public Integer getDurationOfPregnancy()
	{
		return this.durationofpregnancy;
	}
	public void setDurationOfPregnancy(Integer value)
	{
		this.isValidated = false;
		this.durationofpregnancy = value;
	}
	public boolean getDeliveryMethodIsNotNull()
	{
		return this.deliverymethod != null;
	}
	public ims.pci.vo.lookups.DeliveryMethodBirth getDeliveryMethod()
	{
		return this.deliverymethod;
	}
	public void setDeliveryMethod(ims.pci.vo.lookups.DeliveryMethodBirth value)
	{
		this.isValidated = false;
		this.deliverymethod = value;
	}
	public boolean getEpisiotomyIsNotNull()
	{
		return this.episiotomy != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getEpisiotomy()
	{
		return this.episiotomy;
	}
	public void setEpisiotomy(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.episiotomy = value;
	}
	public boolean getEpiduralIsNotNull()
	{
		return this.epidural != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getEpidural()
	{
		return this.epidural;
	}
	public void setEpidural(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.epidural = value;
	}
	public boolean getOrderOfBirthOrderIsNotNull()
	{
		return this.orderofbirthorder != null;
	}
	public Integer getOrderOfBirthOrder()
	{
		return this.orderofbirthorder;
	}
	public void setOrderOfBirthOrder(Integer value)
	{
		this.isValidated = false;
		this.orderofbirthorder = value;
	}
	public boolean getOrderOfBirthNrIsNotNull()
	{
		return this.orderofbirthnr != null;
	}
	public Integer getOrderOfBirthNr()
	{
		return this.orderofbirthnr;
	}
	public void setOrderOfBirthNr(Integer value)
	{
		this.isValidated = false;
		this.orderofbirthnr = value;
	}
	public boolean getApgar1IsNotNull()
	{
		return this.apgar1 != null;
	}
	public Integer getApgar1()
	{
		return this.apgar1;
	}
	public void setApgar1(Integer value)
	{
		this.isValidated = false;
		this.apgar1 = value;
	}
	public boolean getApgar5IsNotNull()
	{
		return this.apgar5 != null;
	}
	public Integer getApgar5()
	{
		return this.apgar5;
	}
	public void setApgar5(Integer value)
	{
		this.isValidated = false;
		this.apgar5 = value;
	}
	public boolean getApgar10IsNotNull()
	{
		return this.apgar10 != null;
	}
	public Integer getApgar10()
	{
		return this.apgar10;
	}
	public void setApgar10(Integer value)
	{
		this.isValidated = false;
		this.apgar10 = value;
	}
	public boolean getStillbornIsNotNull()
	{
		return this.stillborn != null;
	}
	public Integer getStillborn()
	{
		return this.stillborn;
	}
	public void setStillborn(Integer value)
	{
		this.isValidated = false;
		this.stillborn = value;
	}
	public boolean getLiveIsNotNull()
	{
		return this.live != null;
	}
	public Integer getLive()
	{
		return this.live;
	}
	public void setLive(Integer value)
	{
		this.isValidated = false;
		this.live = value;
	}
	public boolean getMiscarriagesIsNotNull()
	{
		return this.miscarriages != null;
	}
	public Integer getMiscarriages()
	{
		return this.miscarriages;
	}
	public void setMiscarriages(Integer value)
	{
		this.isValidated = false;
		this.miscarriages = value;
	}
	public boolean getMaritalStatusAtBirthIsNotNull()
	{
		return this.maritalstatusatbirth != null;
	}
	public ims.pci.vo.lookups.MaritalStatusAtBirth getMaritalStatusAtBirth()
	{
		return this.maritalstatusatbirth;
	}
	public void setMaritalStatusAtBirth(ims.pci.vo.lookups.MaritalStatusAtBirth value)
	{
		this.isValidated = false;
		this.maritalstatusatbirth = value;
	}
	public boolean getPKUTestIsNotNull()
	{
		return this.pkutest != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getPKUTest()
	{
		return this.pkutest;
	}
	public void setPKUTest(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.pkutest = value;
	}
	public boolean getStillBornIndicatorIsNotNull()
	{
		return this.stillbornindicator != null;
	}
	public Boolean getStillBornIndicator()
	{
		return this.stillbornindicator;
	}
	public void setStillBornIndicator(Boolean value)
	{
		this.isValidated = false;
		this.stillbornindicator = value;
	}
	public boolean getBreastFeedingIsNotNull()
	{
		return this.breastfeeding != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getBreastFeeding()
	{
		return this.breastfeeding;
	}
	public void setBreastFeeding(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.breastfeeding = value;
	}
	public boolean getBreastFeedingAtDischargeIsNotNull()
	{
		return this.breastfeedingatdischarge != null;
	}
	public ims.pci.vo.lookups.BreastFeedingStatus getBreastFeedingAtDischarge()
	{
		return this.breastfeedingatdischarge;
	}
	public void setBreastFeedingAtDischarge(ims.pci.vo.lookups.BreastFeedingStatus value)
	{
		this.isValidated = false;
		this.breastfeedingatdischarge = value;
	}
	public boolean getBreastFeedingAt3monthsIsNotNull()
	{
		return this.breastfeedingat3months != null;
	}
	public ims.pci.vo.lookups.BreastFeedingStatus getBreastFeedingAt3months()
	{
		return this.breastfeedingat3months;
	}
	public void setBreastFeedingAt3months(ims.pci.vo.lookups.BreastFeedingStatus value)
	{
		this.isValidated = false;
		this.breastfeedingat3months = value;
	}
	public boolean getBreastFeedingAtPHNIsNotNull()
	{
		return this.breastfeedingatphn != null;
	}
	public ims.pci.vo.lookups.BreastFeedingStatus getBreastFeedingAtPHN()
	{
		return this.breastfeedingatphn;
	}
	public void setBreastFeedingAtPHN(ims.pci.vo.lookups.BreastFeedingStatus value)
	{
		this.isValidated = false;
		this.breastfeedingatphn = value;
	}
	public boolean getClientNotesIsNotNull()
	{
		return this.clientnotes != null;
	}
	public String getClientNotes()
	{
		return this.clientnotes;
	}
	public static int getClientNotesMaxLength()
	{
		return 1000;
	}
	public void setClientNotes(String value)
	{
		this.isValidated = false;
		this.clientnotes = value;
	}
	public boolean getClientIDOfMotherIsNotNull()
	{
		return this.clientidofmother != null;
	}
	public String getClientIDOfMother()
	{
		return this.clientidofmother;
	}
	public static int getClientIDOfMotherMaxLength()
	{
		return 10;
	}
	public void setClientIDOfMother(String value)
	{
		this.isValidated = false;
		this.clientidofmother = value;
	}
	public boolean getTimeOfBirthIsNotNull()
	{
		return this.timeofbirth != null;
	}
	public String getTimeOfBirth()
	{
		return this.timeofbirth;
	}
	public static int getTimeOfBirthMaxLength()
	{
		return 50;
	}
	public void setTimeOfBirth(String value)
	{
		this.isValidated = false;
		this.timeofbirth = value;
	}
	public boolean getDischargeDateTimeIsNotNull()
	{
		return this.dischargedatetime != null;
	}
	public ims.framework.utils.DateTime getDischargeDateTime()
	{
		return this.dischargedatetime;
	}
	public void setDischargeDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.dischargedatetime = value;
	}
	public boolean getFirstPHNVisitDateTimeIsNotNull()
	{
		return this.firstphnvisitdatetime != null;
	}
	public ims.framework.utils.DateTime getFirstPHNVisitDateTime()
	{
		return this.firstphnvisitdatetime;
	}
	public void setFirstPHNVisitDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.firstphnvisitdatetime = value;
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
		if(this.client == null)
			listOfErrors.add("Client is mandatory");
		if(this.clientnotes != null)
			if(this.clientnotes.length() > 1000)
				listOfErrors.add("The length of the field [clientnotes] in the value object [ims.pci.vo.ClientBirthDetailsVo] is too big. It should be less or equal to 1000");
		if(this.clientidofmother != null)
			if(this.clientidofmother.length() > 10)
				listOfErrors.add("The length of the field [clientidofmother] in the value object [ims.pci.vo.ClientBirthDetailsVo] is too big. It should be less or equal to 10");
		if(this.timeofbirth != null)
			if(this.timeofbirth.length() > 50)
				listOfErrors.add("The length of the field [timeofbirth] in the value object [ims.pci.vo.ClientBirthDetailsVo] is too big. It should be less or equal to 50");
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
	
		ClientBirthDetailsVo clone = new ClientBirthDetailsVo(this.id, this.version);
		
		clone.client = this.client;
		if(this.placeofbirth == null)
			clone.placeofbirth = null;
		else
			clone.placeofbirth = (ims.pci.vo.lookups.PlaceOfBirth)this.placeofbirth.clone();
		clone.weightatbirth = this.weightatbirth;
		if(this.datenotified == null)
			clone.datenotified = null;
		else
			clone.datenotified = (ims.framework.utils.Date)this.datenotified.clone();
		clone.durationofpregnancy = this.durationofpregnancy;
		if(this.deliverymethod == null)
			clone.deliverymethod = null;
		else
			clone.deliverymethod = (ims.pci.vo.lookups.DeliveryMethodBirth)this.deliverymethod.clone();
		if(this.episiotomy == null)
			clone.episiotomy = null;
		else
			clone.episiotomy = (ims.core.vo.lookups.YesNoUnknown)this.episiotomy.clone();
		if(this.epidural == null)
			clone.epidural = null;
		else
			clone.epidural = (ims.core.vo.lookups.YesNoUnknown)this.epidural.clone();
		clone.orderofbirthorder = this.orderofbirthorder;
		clone.orderofbirthnr = this.orderofbirthnr;
		clone.apgar1 = this.apgar1;
		clone.apgar5 = this.apgar5;
		clone.apgar10 = this.apgar10;
		clone.stillborn = this.stillborn;
		clone.live = this.live;
		clone.miscarriages = this.miscarriages;
		if(this.maritalstatusatbirth == null)
			clone.maritalstatusatbirth = null;
		else
			clone.maritalstatusatbirth = (ims.pci.vo.lookups.MaritalStatusAtBirth)this.maritalstatusatbirth.clone();
		if(this.pkutest == null)
			clone.pkutest = null;
		else
			clone.pkutest = (ims.core.vo.lookups.YesNoUnknown)this.pkutest.clone();
		clone.stillbornindicator = this.stillbornindicator;
		if(this.breastfeeding == null)
			clone.breastfeeding = null;
		else
			clone.breastfeeding = (ims.core.vo.lookups.YesNoUnknown)this.breastfeeding.clone();
		if(this.breastfeedingatdischarge == null)
			clone.breastfeedingatdischarge = null;
		else
			clone.breastfeedingatdischarge = (ims.pci.vo.lookups.BreastFeedingStatus)this.breastfeedingatdischarge.clone();
		if(this.breastfeedingat3months == null)
			clone.breastfeedingat3months = null;
		else
			clone.breastfeedingat3months = (ims.pci.vo.lookups.BreastFeedingStatus)this.breastfeedingat3months.clone();
		if(this.breastfeedingatphn == null)
			clone.breastfeedingatphn = null;
		else
			clone.breastfeedingatphn = (ims.pci.vo.lookups.BreastFeedingStatus)this.breastfeedingatphn.clone();
		clone.clientnotes = this.clientnotes;
		clone.clientidofmother = this.clientidofmother;
		clone.timeofbirth = this.timeofbirth;
		if(this.dischargedatetime == null)
			clone.dischargedatetime = null;
		else
			clone.dischargedatetime = (ims.framework.utils.DateTime)this.dischargedatetime.clone();
		if(this.firstphnvisitdatetime == null)
			clone.firstphnvisitdatetime = null;
		else
			clone.firstphnvisitdatetime = (ims.framework.utils.DateTime)this.firstphnvisitdatetime.clone();
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
		if (!(ClientBirthDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClientBirthDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ClientBirthDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ClientBirthDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.client != null)
			count++;
		if(this.placeofbirth != null)
			count++;
		if(this.weightatbirth != null)
			count++;
		if(this.datenotified != null)
			count++;
		if(this.durationofpregnancy != null)
			count++;
		if(this.deliverymethod != null)
			count++;
		if(this.episiotomy != null)
			count++;
		if(this.epidural != null)
			count++;
		if(this.orderofbirthorder != null)
			count++;
		if(this.orderofbirthnr != null)
			count++;
		if(this.apgar1 != null)
			count++;
		if(this.apgar5 != null)
			count++;
		if(this.apgar10 != null)
			count++;
		if(this.stillborn != null)
			count++;
		if(this.live != null)
			count++;
		if(this.miscarriages != null)
			count++;
		if(this.maritalstatusatbirth != null)
			count++;
		if(this.pkutest != null)
			count++;
		if(this.stillbornindicator != null)
			count++;
		if(this.breastfeeding != null)
			count++;
		if(this.breastfeedingatdischarge != null)
			count++;
		if(this.breastfeedingat3months != null)
			count++;
		if(this.breastfeedingatphn != null)
			count++;
		if(this.clientnotes != null)
			count++;
		if(this.clientidofmother != null)
			count++;
		if(this.timeofbirth != null)
			count++;
		if(this.dischargedatetime != null)
			count++;
		if(this.firstphnvisitdatetime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 28;
	}
	protected ims.core.patient.vo.PatientRefVo client;
	protected ims.pci.vo.lookups.PlaceOfBirth placeofbirth;
	protected Integer weightatbirth;
	protected ims.framework.utils.Date datenotified;
	protected Integer durationofpregnancy;
	protected ims.pci.vo.lookups.DeliveryMethodBirth deliverymethod;
	protected ims.core.vo.lookups.YesNoUnknown episiotomy;
	protected ims.core.vo.lookups.YesNoUnknown epidural;
	protected Integer orderofbirthorder;
	protected Integer orderofbirthnr;
	protected Integer apgar1;
	protected Integer apgar5;
	protected Integer apgar10;
	protected Integer stillborn;
	protected Integer live;
	protected Integer miscarriages;
	protected ims.pci.vo.lookups.MaritalStatusAtBirth maritalstatusatbirth;
	protected ims.core.vo.lookups.YesNoUnknown pkutest;
	protected Boolean stillbornindicator;
	protected ims.core.vo.lookups.YesNoUnknown breastfeeding;
	protected ims.pci.vo.lookups.BreastFeedingStatus breastfeedingatdischarge;
	protected ims.pci.vo.lookups.BreastFeedingStatus breastfeedingat3months;
	protected ims.pci.vo.lookups.BreastFeedingStatus breastfeedingatphn;
	protected String clientnotes;
	protected String clientidofmother;
	protected String timeofbirth;
	protected ims.framework.utils.DateTime dischargedatetime;
	protected ims.framework.utils.DateTime firstphnvisitdatetime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
