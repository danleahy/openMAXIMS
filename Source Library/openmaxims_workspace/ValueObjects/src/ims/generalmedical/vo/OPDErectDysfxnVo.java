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

package ims.generalmedical.vo;

/**
 * Linked to medical.OPDErectDysfxn business object (ID: 1031100008).
 */
public class OPDErectDysfxnVo extends ims.medical.vo.OPDErectDysfxnRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OPDErectDysfxnVo()
	{
	}
	public OPDErectDysfxnVo(Integer id, int version)
	{
		super(id, version);
	}
	public OPDErectDysfxnVo(ims.generalmedical.vo.beans.OPDErectDysfxnVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.erectionqual = bean.getErectionQual() == null ? null : ims.spinalinjuries.vo.lookups.ErectDysfxnErectQual.buildLookup(bean.getErectionQual());
		this.consetnformsigned = bean.getConsetnFormSigned() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getConsetnFormSigned());
		this.treatdiscussed = bean.getTreatDiscussed() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getTreatDiscussed());
		this.advleafletgiven = bean.getAdvLeafletGiven() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getAdvLeafletGiven());
		this.actualleafletsgiven = ims.core.vo.lookups.AdviceLeafletsCollection.buildFromBeanCollection(bean.getActualLeafletsGiven());
		this.actualtreatmentdiscussed = ims.spinalinjuries.vo.lookups.ErectDysTreatmentsGivenCollection.buildFromBeanCollection(bean.getActualTreatmentDiscussed());
		this.treatmenthistory = ims.generalmedical.vo.OPDErectDysTreatmentsVoCollection.buildFromBeanCollection(bean.getTreatmentHistory());
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.beans.OPDErectDysfxnVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.erectionqual = bean.getErectionQual() == null ? null : ims.spinalinjuries.vo.lookups.ErectDysfxnErectQual.buildLookup(bean.getErectionQual());
		this.consetnformsigned = bean.getConsetnFormSigned() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getConsetnFormSigned());
		this.treatdiscussed = bean.getTreatDiscussed() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getTreatDiscussed());
		this.advleafletgiven = bean.getAdvLeafletGiven() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getAdvLeafletGiven());
		this.actualleafletsgiven = ims.core.vo.lookups.AdviceLeafletsCollection.buildFromBeanCollection(bean.getActualLeafletsGiven());
		this.actualtreatmentdiscussed = ims.spinalinjuries.vo.lookups.ErectDysTreatmentsGivenCollection.buildFromBeanCollection(bean.getActualTreatmentDiscussed());
		this.treatmenthistory = ims.generalmedical.vo.OPDErectDysTreatmentsVoCollection.buildFromBeanCollection(bean.getTreatmentHistory());
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.beans.OPDErectDysfxnVoBean bean = null;
		if(map != null)
			bean = (ims.generalmedical.vo.beans.OPDErectDysfxnVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.generalmedical.vo.beans.OPDErectDysfxnVoBean();
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
		if(fieldName.equals("ERECTIONQUAL"))
			return getErectionQual();
		if(fieldName.equals("CONSETNFORMSIGNED"))
			return getConsetnFormSigned();
		if(fieldName.equals("TREATDISCUSSED"))
			return getTreatDiscussed();
		if(fieldName.equals("ADVLEAFLETGIVEN"))
			return getAdvLeafletGiven();
		if(fieldName.equals("ACTUALLEAFLETSGIVEN"))
			return getActualLeafletsGiven();
		if(fieldName.equals("ACTUALTREATMENTDISCUSSED"))
			return getActualTreatmentDiscussed();
		if(fieldName.equals("TREATMENTHISTORY"))
			return getTreatmentHistory();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getErectionQualIsNotNull()
	{
		return this.erectionqual != null;
	}
	public ims.spinalinjuries.vo.lookups.ErectDysfxnErectQual getErectionQual()
	{
		return this.erectionqual;
	}
	public void setErectionQual(ims.spinalinjuries.vo.lookups.ErectDysfxnErectQual value)
	{
		this.isValidated = false;
		this.erectionqual = value;
	}
	public boolean getConsetnFormSignedIsNotNull()
	{
		return this.consetnformsigned != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getConsetnFormSigned()
	{
		return this.consetnformsigned;
	}
	public void setConsetnFormSigned(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.consetnformsigned = value;
	}
	public boolean getTreatDiscussedIsNotNull()
	{
		return this.treatdiscussed != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getTreatDiscussed()
	{
		return this.treatdiscussed;
	}
	public void setTreatDiscussed(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.treatdiscussed = value;
	}
	public boolean getAdvLeafletGivenIsNotNull()
	{
		return this.advleafletgiven != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getAdvLeafletGiven()
	{
		return this.advleafletgiven;
	}
	public void setAdvLeafletGiven(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.advleafletgiven = value;
	}
	public boolean getActualLeafletsGivenIsNotNull()
	{
		return this.actualleafletsgiven != null;
	}
	public ims.core.vo.lookups.AdviceLeafletsCollection getActualLeafletsGiven()
	{
		return this.actualleafletsgiven;
	}
	public void setActualLeafletsGiven(ims.core.vo.lookups.AdviceLeafletsCollection value)
	{
		this.isValidated = false;
		this.actualleafletsgiven = value;
	}
	public boolean getActualTreatmentDiscussedIsNotNull()
	{
		return this.actualtreatmentdiscussed != null;
	}
	public ims.spinalinjuries.vo.lookups.ErectDysTreatmentsGivenCollection getActualTreatmentDiscussed()
	{
		return this.actualtreatmentdiscussed;
	}
	public void setActualTreatmentDiscussed(ims.spinalinjuries.vo.lookups.ErectDysTreatmentsGivenCollection value)
	{
		this.isValidated = false;
		this.actualtreatmentdiscussed = value;
	}
	public boolean getTreatmentHistoryIsNotNull()
	{
		return this.treatmenthistory != null;
	}
	public ims.generalmedical.vo.OPDErectDysTreatmentsVoCollection getTreatmentHistory()
	{
		return this.treatmenthistory;
	}
	public void setTreatmentHistory(ims.generalmedical.vo.OPDErectDysTreatmentsVoCollection value)
	{
		this.isValidated = false;
		this.treatmenthistory = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.vo.CareContextShortVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.CareContextShortVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
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
		if(this.treatmenthistory != null)
		{
			if(!this.treatmenthistory.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
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
		if(this.treatmenthistory != null)
		{
			String[] listOfOtherErrors = this.treatmenthistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
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
	
		OPDErectDysfxnVo clone = new OPDErectDysfxnVo(this.id, this.version);
		
		if(this.erectionqual == null)
			clone.erectionqual = null;
		else
			clone.erectionqual = (ims.spinalinjuries.vo.lookups.ErectDysfxnErectQual)this.erectionqual.clone();
		if(this.consetnformsigned == null)
			clone.consetnformsigned = null;
		else
			clone.consetnformsigned = (ims.core.vo.lookups.YesNoUnknown)this.consetnformsigned.clone();
		if(this.treatdiscussed == null)
			clone.treatdiscussed = null;
		else
			clone.treatdiscussed = (ims.core.vo.lookups.YesNoUnknown)this.treatdiscussed.clone();
		if(this.advleafletgiven == null)
			clone.advleafletgiven = null;
		else
			clone.advleafletgiven = (ims.core.vo.lookups.YesNoUnknown)this.advleafletgiven.clone();
		if(this.actualleafletsgiven == null)
			clone.actualleafletsgiven = null;
		else
			clone.actualleafletsgiven = (ims.core.vo.lookups.AdviceLeafletsCollection)this.actualleafletsgiven.clone();
		if(this.actualtreatmentdiscussed == null)
			clone.actualtreatmentdiscussed = null;
		else
			clone.actualtreatmentdiscussed = (ims.spinalinjuries.vo.lookups.ErectDysTreatmentsGivenCollection)this.actualtreatmentdiscussed.clone();
		if(this.treatmenthistory == null)
			clone.treatmenthistory = null;
		else
			clone.treatmenthistory = (ims.generalmedical.vo.OPDErectDysTreatmentsVoCollection)this.treatmenthistory.clone();
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextShortVo)this.carecontext.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
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
		if (!(OPDErectDysfxnVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OPDErectDysfxnVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		OPDErectDysfxnVo compareObj = (OPDErectDysfxnVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_OPDErectDysfxn() == null && compareObj.getID_OPDErectDysfxn() != null)
				return -1;
			if(this.getID_OPDErectDysfxn() != null && compareObj.getID_OPDErectDysfxn() == null)
				return 1;
			if(this.getID_OPDErectDysfxn() != null && compareObj.getID_OPDErectDysfxn() != null)
				retVal = this.getID_OPDErectDysfxn().compareTo(compareObj.getID_OPDErectDysfxn());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.erectionqual != null)
			count++;
		if(this.consetnformsigned != null)
			count++;
		if(this.treatdiscussed != null)
			count++;
		if(this.advleafletgiven != null)
			count++;
		if(this.actualleafletsgiven != null)
			count++;
		if(this.actualtreatmentdiscussed != null)
			count++;
		if(this.treatmenthistory != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.spinalinjuries.vo.lookups.ErectDysfxnErectQual erectionqual;
	protected ims.core.vo.lookups.YesNoUnknown consetnformsigned;
	protected ims.core.vo.lookups.YesNoUnknown treatdiscussed;
	protected ims.core.vo.lookups.YesNoUnknown advleafletgiven;
	protected ims.core.vo.lookups.AdviceLeafletsCollection actualleafletsgiven;
	protected ims.spinalinjuries.vo.lookups.ErectDysTreatmentsGivenCollection actualtreatmentdiscussed;
	protected ims.generalmedical.vo.OPDErectDysTreatmentsVoCollection treatmenthistory;
	protected ims.core.vo.CareContextShortVo carecontext;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
