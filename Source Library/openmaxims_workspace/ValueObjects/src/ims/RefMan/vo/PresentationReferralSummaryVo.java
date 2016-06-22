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

package ims.RefMan.vo;

/**
 * Linked to RefMan.PresentationReferralSummary business object (ID: 1096100001).
 */
public class PresentationReferralSummaryVo extends ims.RefMan.vo.PresentationReferralSummaryRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IPresentationReferralSummary
{
	private static final long serialVersionUID = 1L;

	public PresentationReferralSummaryVo()
	{
	}
	public PresentationReferralSummaryVo(Integer id, int version)
	{
		super(id, version);
	}
	public PresentationReferralSummaryVo(ims.RefMan.vo.beans.PresentationReferralSummaryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.RefMan.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.authoringuser = bean.getAuthoringUser() == null ? null : bean.getAuthoringUser().buildVo();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.presentingissues = ims.clinical.vo.PatientComplaintVoCollection.buildFromBeanCollection(bean.getPresentingIssues());
		this.medicationonreferral = ims.core.vo.PatientMedicationLiteVoCollection.buildFromBeanCollection(bean.getMedicationOnReferral());
		this.allergies = ims.core.vo.PatientAllergyCollection.buildFromBeanCollection(bean.getAllergies());
		this.presentingissuesnonindicated = bean.getPresentingIssuesNonIndicated();
		this.medicationnonindicated = bean.getMedicationNonIndicated();
		this.allergiesissuesnonindicated = bean.getAllergiesIssuesNonIndicated();
		this.comorbiditiesissuesnonindicated = bean.getComorbiditiesIssuesNonIndicated();
		this.comorbidities = ims.core.vo.PatientDiagnosisLiteVoCollection.buildFromBeanCollection(bean.getComorbidities());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.PresentationReferralSummaryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.RefMan.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.authoringuser = bean.getAuthoringUser() == null ? null : bean.getAuthoringUser().buildVo(map);
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.presentingissues = ims.clinical.vo.PatientComplaintVoCollection.buildFromBeanCollection(bean.getPresentingIssues());
		this.medicationonreferral = ims.core.vo.PatientMedicationLiteVoCollection.buildFromBeanCollection(bean.getMedicationOnReferral());
		this.allergies = ims.core.vo.PatientAllergyCollection.buildFromBeanCollection(bean.getAllergies());
		this.presentingissuesnonindicated = bean.getPresentingIssuesNonIndicated();
		this.medicationnonindicated = bean.getMedicationNonIndicated();
		this.allergiesissuesnonindicated = bean.getAllergiesIssuesNonIndicated();
		this.comorbiditiesissuesnonindicated = bean.getComorbiditiesIssuesNonIndicated();
		this.comorbidities = ims.core.vo.PatientDiagnosisLiteVoCollection.buildFromBeanCollection(bean.getComorbidities());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.PresentationReferralSummaryVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.PresentationReferralSummaryVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.PresentationReferralSummaryVoBean();
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
		if(fieldName.equals("CATSREFERRAL"))
			return getCatsReferral();
		if(fieldName.equals("AUTHORINGUSER"))
			return getAuthoringUser();
		if(fieldName.equals("AUTHORINGDATETIME"))
			return getAuthoringDateTime();
		if(fieldName.equals("PRESENTINGISSUES"))
			return getPresentingIssues();
		if(fieldName.equals("MEDICATIONONREFERRAL"))
			return getMedicationOnReferral();
		if(fieldName.equals("ALLERGIES"))
			return getAllergies();
		if(fieldName.equals("PRESENTINGISSUESNONINDICATED"))
			return getPresentingIssuesNonIndicated();
		if(fieldName.equals("MEDICATIONNONINDICATED"))
			return getMedicationNonIndicated();
		if(fieldName.equals("ALLERGIESISSUESNONINDICATED"))
			return getAllergiesIssuesNonIndicated();
		if(fieldName.equals("COMORBIDITIESISSUESNONINDICATED"))
			return getComorbiditiesIssuesNonIndicated();
		if(fieldName.equals("COMORBIDITIES"))
			return getComorbidities();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCatsReferralIsNotNull()
	{
		return this.catsreferral != null;
	}
	public ims.RefMan.vo.CatsReferralRefVo getCatsReferral()
	{
		return this.catsreferral;
	}
	public void setCatsReferral(ims.RefMan.vo.CatsReferralRefVo value)
	{
		this.isValidated = false;
		this.catsreferral = value;
	}
	public boolean getAuthoringUserIsNotNull()
	{
		return this.authoringuser != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getAuthoringUser()
	{
		return this.authoringuser;
	}
	public void setAuthoringUser(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.authoringuser = value;
	}
	public boolean getAuthoringDateTimeIsNotNull()
	{
		return this.authoringdatetime != null;
	}
	public ims.framework.utils.DateTime getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.authoringdatetime = value;
	}
	public boolean getPresentingIssuesIsNotNull()
	{
		return this.presentingissues != null;
	}
	public ims.clinical.vo.PatientComplaintVoCollection getPresentingIssues()
	{
		return this.presentingissues;
	}
	public void setPresentingIssues(ims.clinical.vo.PatientComplaintVoCollection value)
	{
		this.isValidated = false;
		this.presentingissues = value;
	}
	public boolean getMedicationOnReferralIsNotNull()
	{
		return this.medicationonreferral != null;
	}
	public ims.core.vo.PatientMedicationLiteVoCollection getMedicationOnReferral()
	{
		return this.medicationonreferral;
	}
	public void setMedicationOnReferral(ims.core.vo.PatientMedicationLiteVoCollection value)
	{
		this.isValidated = false;
		this.medicationonreferral = value;
	}
	public boolean getAllergiesIsNotNull()
	{
		return this.allergies != null;
	}
	public ims.core.vo.PatientAllergyCollection getAllergies()
	{
		return this.allergies;
	}
	public void setAllergies(ims.core.vo.PatientAllergyCollection value)
	{
		this.isValidated = false;
		this.allergies = value;
	}
	public boolean getPresentingIssuesNonIndicatedIsNotNull()
	{
		return this.presentingissuesnonindicated != null;
	}
	public Boolean getPresentingIssuesNonIndicated()
	{
		return this.presentingissuesnonindicated;
	}
	public void setPresentingIssuesNonIndicated(Boolean value)
	{
		this.isValidated = false;
		this.presentingissuesnonindicated = value;
	}
	public boolean getMedicationNonIndicatedIsNotNull()
	{
		return this.medicationnonindicated != null;
	}
	public Boolean getMedicationNonIndicated()
	{
		return this.medicationnonindicated;
	}
	public void setMedicationNonIndicated(Boolean value)
	{
		this.isValidated = false;
		this.medicationnonindicated = value;
	}
	public boolean getAllergiesIssuesNonIndicatedIsNotNull()
	{
		return this.allergiesissuesnonindicated != null;
	}
	public Boolean getAllergiesIssuesNonIndicated()
	{
		return this.allergiesissuesnonindicated;
	}
	public void setAllergiesIssuesNonIndicated(Boolean value)
	{
		this.isValidated = false;
		this.allergiesissuesnonindicated = value;
	}
	public boolean getComorbiditiesIssuesNonIndicatedIsNotNull()
	{
		return this.comorbiditiesissuesnonindicated != null;
	}
	public Boolean getComorbiditiesIssuesNonIndicated()
	{
		return this.comorbiditiesissuesnonindicated;
	}
	public void setComorbiditiesIssuesNonIndicated(Boolean value)
	{
		this.isValidated = false;
		this.comorbiditiesissuesnonindicated = value;
	}
	public boolean getComorbiditiesIsNotNull()
	{
		return this.comorbidities != null;
	}
	public ims.core.vo.PatientDiagnosisLiteVoCollection getComorbidities()
	{
		return this.comorbidities;
	}
	public void setComorbidities(ims.core.vo.PatientDiagnosisLiteVoCollection value)
	{
		this.isValidated = false;
		this.comorbidities = value;
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
		if(this.authoringuser != null)
		{
			if(!this.authoringuser.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.presentingissues != null)
		{
			if(!this.presentingissues.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.medicationonreferral != null)
		{
			if(!this.medicationonreferral.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.allergies != null)
		{
			if(!this.allergies.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.comorbidities != null)
		{
			if(!this.comorbidities.isValidated())
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
		if(this.catsreferral == null)
			listOfErrors.add("CatsReferral is mandatory");
		if(this.authoringuser == null)
			listOfErrors.add("AuthoringUser is mandatory");
		if(this.authoringuser != null)
		{
			String[] listOfOtherErrors = this.authoringuser.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.authoringdatetime == null)
			listOfErrors.add("AuthoringDateTime is mandatory");
		if(this.presentingissues != null)
		{
			String[] listOfOtherErrors = this.presentingissues.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.medicationonreferral != null)
		{
			String[] listOfOtherErrors = this.medicationonreferral.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.allergies != null)
		{
			String[] listOfOtherErrors = this.allergies.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.presentingissuesnonindicated == null)
			listOfErrors.add("PresentingIssuesNonIndicated is mandatory");
		if(this.medicationnonindicated == null)
			listOfErrors.add("MedicationNonIndicated is mandatory");
		if(this.allergiesissuesnonindicated == null)
			listOfErrors.add("AllergiesIssuesNonIndicated is mandatory");
		if(this.comorbiditiesissuesnonindicated == null)
			listOfErrors.add("ComorbiditiesIssuesNonIndicated is mandatory");
		if(this.comorbidities != null)
		{
			String[] listOfOtherErrors = this.comorbidities.validate();
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
	
		PresentationReferralSummaryVo clone = new PresentationReferralSummaryVo(this.id, this.version);
		
		clone.catsreferral = this.catsreferral;
		if(this.authoringuser == null)
			clone.authoringuser = null;
		else
			clone.authoringuser = (ims.core.vo.MemberOfStaffLiteVo)this.authoringuser.clone();
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		if(this.presentingissues == null)
			clone.presentingissues = null;
		else
			clone.presentingissues = (ims.clinical.vo.PatientComplaintVoCollection)this.presentingissues.clone();
		if(this.medicationonreferral == null)
			clone.medicationonreferral = null;
		else
			clone.medicationonreferral = (ims.core.vo.PatientMedicationLiteVoCollection)this.medicationonreferral.clone();
		if(this.allergies == null)
			clone.allergies = null;
		else
			clone.allergies = (ims.core.vo.PatientAllergyCollection)this.allergies.clone();
		clone.presentingissuesnonindicated = this.presentingissuesnonindicated;
		clone.medicationnonindicated = this.medicationnonindicated;
		clone.allergiesissuesnonindicated = this.allergiesissuesnonindicated;
		clone.comorbiditiesissuesnonindicated = this.comorbiditiesissuesnonindicated;
		if(this.comorbidities == null)
			clone.comorbidities = null;
		else
			clone.comorbidities = (ims.core.vo.PatientDiagnosisLiteVoCollection)this.comorbidities.clone();
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
		if (!(PresentationReferralSummaryVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PresentationReferralSummaryVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PresentationReferralSummaryVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PresentationReferralSummaryVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.catsreferral != null)
			count++;
		if(this.authoringuser != null)
			count++;
		if(this.authoringdatetime != null)
			count++;
		if(this.presentingissues != null)
			count++;
		if(this.medicationonreferral != null)
			count++;
		if(this.allergies != null)
			count++;
		if(this.presentingissuesnonindicated != null)
			count++;
		if(this.medicationnonindicated != null)
			count++;
		if(this.allergiesissuesnonindicated != null)
			count++;
		if(this.comorbiditiesissuesnonindicated != null)
			count++;
		if(this.comorbidities != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected ims.RefMan.vo.CatsReferralRefVo catsreferral;
	protected ims.core.vo.MemberOfStaffLiteVo authoringuser;
	protected ims.framework.utils.DateTime authoringdatetime;
	protected ims.clinical.vo.PatientComplaintVoCollection presentingissues;
	protected ims.core.vo.PatientMedicationLiteVoCollection medicationonreferral;
	protected ims.core.vo.PatientAllergyCollection allergies;
	protected Boolean presentingissuesnonindicated;
	protected Boolean medicationnonindicated;
	protected Boolean allergiesissuesnonindicated;
	protected Boolean comorbiditiesissuesnonindicated;
	protected ims.core.vo.PatientDiagnosisLiteVoCollection comorbidities;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
