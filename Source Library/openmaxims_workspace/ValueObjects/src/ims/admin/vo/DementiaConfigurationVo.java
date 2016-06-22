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

package ims.admin.vo;

/**
 * Linked to core.admin.DementiaConfiguration business object (ID: 1004100057).
 */
public class DementiaConfigurationVo extends ims.core.admin.vo.DementiaConfigurationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DementiaConfigurationVo()
	{
	}
	public DementiaConfigurationVo(Integer id, int version)
	{
		super(id, version);
	}
	public DementiaConfigurationVo(ims.admin.vo.beans.DementiaConfigurationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.age = bean.getAge();
		this.excludefairperiod = bean.getExcludeFAIRPeriod();
		this.steponeperiod = bean.getStepOnePeriod();
		this.removetimeperiod = bean.getRemoveTimePeriod();
		this.colourconfig = ims.admin.vo.DementiaColourConfigVoCollection.buildFromBeanCollection(bean.getColourConfig());
		this.amtsthresholdscore = bean.getAMTSThresholdScore();
		this.admissiontypes = ims.core.vo.lookups.MethodOfAdmissionCollection.buildFromBeanCollection(bean.getAdmissionTypes());
		this.recentlyassessed = bean.getRecentlyAssessed() == null ? null : bean.getRecentlyAssessed().buildColor();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.DementiaConfigurationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.age = bean.getAge();
		this.excludefairperiod = bean.getExcludeFAIRPeriod();
		this.steponeperiod = bean.getStepOnePeriod();
		this.removetimeperiod = bean.getRemoveTimePeriod();
		this.colourconfig = ims.admin.vo.DementiaColourConfigVoCollection.buildFromBeanCollection(bean.getColourConfig());
		this.amtsthresholdscore = bean.getAMTSThresholdScore();
		this.admissiontypes = ims.core.vo.lookups.MethodOfAdmissionCollection.buildFromBeanCollection(bean.getAdmissionTypes());
		this.recentlyassessed = bean.getRecentlyAssessed() == null ? null : bean.getRecentlyAssessed().buildColor();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.DementiaConfigurationVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.DementiaConfigurationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.DementiaConfigurationVoBean();
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
		if(fieldName.equals("AGE"))
			return getAge();
		if(fieldName.equals("EXCLUDEFAIRPERIOD"))
			return getExcludeFAIRPeriod();
		if(fieldName.equals("STEPONEPERIOD"))
			return getStepOnePeriod();
		if(fieldName.equals("REMOVETIMEPERIOD"))
			return getRemoveTimePeriod();
		if(fieldName.equals("COLOURCONFIG"))
			return getColourConfig();
		if(fieldName.equals("AMTSTHRESHOLDSCORE"))
			return getAMTSThresholdScore();
		if(fieldName.equals("ADMISSIONTYPES"))
			return getAdmissionTypes();
		if(fieldName.equals("RECENTLYASSESSED"))
			return getRecentlyAssessed();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAgeIsNotNull()
	{
		return this.age != null;
	}
	public Integer getAge()
	{
		return this.age;
	}
	public void setAge(Integer value)
	{
		this.isValidated = false;
		this.age = value;
	}
	public boolean getExcludeFAIRPeriodIsNotNull()
	{
		return this.excludefairperiod != null;
	}
	public Integer getExcludeFAIRPeriod()
	{
		return this.excludefairperiod;
	}
	public void setExcludeFAIRPeriod(Integer value)
	{
		this.isValidated = false;
		this.excludefairperiod = value;
	}
	public boolean getStepOnePeriodIsNotNull()
	{
		return this.steponeperiod != null;
	}
	public Integer getStepOnePeriod()
	{
		return this.steponeperiod;
	}
	public void setStepOnePeriod(Integer value)
	{
		this.isValidated = false;
		this.steponeperiod = value;
	}
	public boolean getRemoveTimePeriodIsNotNull()
	{
		return this.removetimeperiod != null;
	}
	public Integer getRemoveTimePeriod()
	{
		return this.removetimeperiod;
	}
	public void setRemoveTimePeriod(Integer value)
	{
		this.isValidated = false;
		this.removetimeperiod = value;
	}
	public boolean getColourConfigIsNotNull()
	{
		return this.colourconfig != null;
	}
	public ims.admin.vo.DementiaColourConfigVoCollection getColourConfig()
	{
		return this.colourconfig;
	}
	public void setColourConfig(ims.admin.vo.DementiaColourConfigVoCollection value)
	{
		this.isValidated = false;
		this.colourconfig = value;
	}
	public boolean getAMTSThresholdScoreIsNotNull()
	{
		return this.amtsthresholdscore != null;
	}
	public Integer getAMTSThresholdScore()
	{
		return this.amtsthresholdscore;
	}
	public void setAMTSThresholdScore(Integer value)
	{
		this.isValidated = false;
		this.amtsthresholdscore = value;
	}
	public boolean getAdmissionTypesIsNotNull()
	{
		return this.admissiontypes != null;
	}
	public ims.core.vo.lookups.MethodOfAdmissionCollection getAdmissionTypes()
	{
		return this.admissiontypes;
	}
	public void setAdmissionTypes(ims.core.vo.lookups.MethodOfAdmissionCollection value)
	{
		this.isValidated = false;
		this.admissiontypes = value;
	}
	public boolean getRecentlyAssessedIsNotNull()
	{
		return this.recentlyassessed != null;
	}
	public ims.framework.utils.Color getRecentlyAssessed()
	{
		return this.recentlyassessed;
	}
	public void setRecentlyAssessed(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.recentlyassessed = value;
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
		if(this.colourconfig != null)
		{
			if(!this.colourconfig.isValidated())
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
		if(this.age == null)
			listOfErrors.add("'Age (in years) at which screening is to start' is mandatory.");
		if(this.excludefairperiod == null)
			listOfErrors.add("'Exclude patients who have had a FAIR assessment within this  number of days' is mandatory.");
		if(this.steponeperiod == null)
			listOfErrors.add("'Period of time (in hours) in which Step 1 is to be completed' is mandatory.");
		if(this.removetimeperiod == null)
			listOfErrors.add("'Length of time (in hours) from admission time when the Remove option becomes available on the worklist' is mandatory.");
		if(this.colourconfig == null || this.colourconfig.size() == 0)
			listOfErrors.add("'Worklist colour configuration' is mandatory.");
		if(this.colourconfig != null)
		{
			String[] listOfOtherErrors = this.colourconfig.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.amtsthresholdscore == null)
			listOfErrors.add("'AMTS Threshold Score' is mandatory.");
		if(this.admissiontypes == null || this.admissiontypes.size() == 0)
			listOfErrors.add("'Admission type(s) to be screened' are mandatory.");
		if(this.recentlyassessed == null)
			listOfErrors.add("RecentlyAssessed is mandatory");
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
	
		DementiaConfigurationVo clone = new DementiaConfigurationVo(this.id, this.version);
		
		clone.age = this.age;
		clone.excludefairperiod = this.excludefairperiod;
		clone.steponeperiod = this.steponeperiod;
		clone.removetimeperiod = this.removetimeperiod;
		if(this.colourconfig == null)
			clone.colourconfig = null;
		else
			clone.colourconfig = (ims.admin.vo.DementiaColourConfigVoCollection)this.colourconfig.clone();
		clone.amtsthresholdscore = this.amtsthresholdscore;
		if(this.admissiontypes == null)
			clone.admissiontypes = null;
		else
			clone.admissiontypes = (ims.core.vo.lookups.MethodOfAdmissionCollection)this.admissiontypes.clone();
		if(this.recentlyassessed == null)
			clone.recentlyassessed = null;
		else
			clone.recentlyassessed = (ims.framework.utils.Color)this.recentlyassessed.clone();
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
		if (!(DementiaConfigurationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DementiaConfigurationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DementiaConfigurationVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DementiaConfigurationVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.age != null)
			count++;
		if(this.excludefairperiod != null)
			count++;
		if(this.steponeperiod != null)
			count++;
		if(this.removetimeperiod != null)
			count++;
		if(this.colourconfig != null)
			count++;
		if(this.amtsthresholdscore != null)
			count++;
		if(this.admissiontypes != null)
			count++;
		if(this.recentlyassessed != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected Integer age;
	protected Integer excludefairperiod;
	protected Integer steponeperiod;
	protected Integer removetimeperiod;
	protected ims.admin.vo.DementiaColourConfigVoCollection colourconfig;
	protected Integer amtsthresholdscore;
	protected ims.core.vo.lookups.MethodOfAdmissionCollection admissiontypes;
	protected ims.framework.utils.Color recentlyassessed;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
