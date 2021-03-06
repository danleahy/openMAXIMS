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
 * Linked to Assessment.Instantiation.PatientEWS business object (ID: 1022100022).
 */
public class PatientEWSVo extends ims.assessment.instantiation.vo.PatientEWSRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientEWSVo()
	{
	}
	public PatientEWSVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientEWSVo(ims.core.vo.beans.PatientEWSVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.vitalsign = bean.getVitalSign() == null ? null : new ims.core.vitals.vo.VitalSignsRefVo(new Integer(bean.getVitalSign().getId()), bean.getVitalSign().getVersion());
		this.patientassessment = bean.getPatientAssessment() == null ? null : bean.getPatientAssessment().buildVo();
		this.secsscore = bean.getSECSScore();
		this.scoredetails = bean.getScoreDetails();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientEWSVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.vitalsign = bean.getVitalSign() == null ? null : new ims.core.vitals.vo.VitalSignsRefVo(new Integer(bean.getVitalSign().getId()), bean.getVitalSign().getVersion());
		this.patientassessment = bean.getPatientAssessment() == null ? null : bean.getPatientAssessment().buildVo(map);
		this.secsscore = bean.getSECSScore();
		this.scoredetails = bean.getScoreDetails();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientEWSVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientEWSVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientEWSVoBean();
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
		if(fieldName.equals("VITALSIGN"))
			return getVitalSign();
		if(fieldName.equals("PATIENTASSESSMENT"))
			return getPatientAssessment();
		if(fieldName.equals("SECSSCORE"))
			return getSECSScore();
		if(fieldName.equals("SCOREDETAILS"))
			return getScoreDetails();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getVitalSignIsNotNull()
	{
		return this.vitalsign != null;
	}
	public ims.core.vitals.vo.VitalSignsRefVo getVitalSign()
	{
		return this.vitalsign;
	}
	public void setVitalSign(ims.core.vitals.vo.VitalSignsRefVo value)
	{
		this.isValidated = false;
		this.vitalsign = value;
	}
	public boolean getPatientAssessmentIsNotNull()
	{
		return this.patientassessment != null;
	}
	public ims.assessment.vo.PatientAssessmentVo getPatientAssessment()
	{
		return this.patientassessment;
	}
	public void setPatientAssessment(ims.assessment.vo.PatientAssessmentVo value)
	{
		this.isValidated = false;
		this.patientassessment = value;
	}
	public boolean getSECSScoreIsNotNull()
	{
		return this.secsscore != null;
	}
	public Integer getSECSScore()
	{
		return this.secsscore;
	}
	public void setSECSScore(Integer value)
	{
		this.isValidated = false;
		this.secsscore = value;
	}
	public boolean getScoreDetailsIsNotNull()
	{
		return this.scoredetails != null;
	}
	public String getScoreDetails()
	{
		return this.scoredetails;
	}
	public static int getScoreDetailsMaxLength()
	{
		return 500;
	}
	public void setScoreDetails(String value)
	{
		this.isValidated = false;
		this.scoredetails = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getSysInfoIsNotNull()
	{
		return this.sysinfo != null;
	}
	public ims.vo.SystemInformation getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinfo = value;
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
		if(this.patientassessment != null)
		{
			if(!this.patientassessment.isValidated())
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
		if(this.patientassessment != null)
		{
			String[] listOfOtherErrors = this.patientassessment.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.scoredetails != null)
			if(this.scoredetails.length() > 500)
				listOfErrors.add("The length of the field [scoredetails] in the value object [ims.core.vo.PatientEWSVo] is too big. It should be less or equal to 500");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
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
	
		PatientEWSVo clone = new PatientEWSVo(this.id, this.version);
		
		clone.vitalsign = this.vitalsign;
		if(this.patientassessment == null)
			clone.patientassessment = null;
		else
			clone.patientassessment = (ims.assessment.vo.PatientAssessmentVo)this.patientassessment.clone();
		clone.secsscore = this.secsscore;
		clone.scoredetails = this.scoredetails;
		clone.carecontext = this.carecontext;
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
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
		if (!(PatientEWSVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientEWSVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientEWSVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientEWSVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.vitalsign != null)
			count++;
		if(this.patientassessment != null)
			count++;
		if(this.secsscore != null)
			count++;
		if(this.scoredetails != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.sysinfo != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.vitals.vo.VitalSignsRefVo vitalsign;
	protected ims.assessment.vo.PatientAssessmentVo patientassessment;
	protected Integer secsscore;
	protected String scoredetails;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.vo.SystemInformation sysinfo;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
