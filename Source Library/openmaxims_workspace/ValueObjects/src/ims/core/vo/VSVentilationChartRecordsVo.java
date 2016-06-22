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
 * Linked to core.vitals.VitalSigns business object (ID: 1022100004).
 */
public class VSVentilationChartRecordsVo extends ims.core.vitals.vo.VitalSignsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public VSVentilationChartRecordsVo()
	{
	}
	public VSVentilationChartRecordsVo(Integer id, int version)
	{
		super(id, version);
	}
	public VSVentilationChartRecordsVo(ims.core.vo.beans.VSVentilationChartRecordsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.vitalstakendatetime = bean.getVitalsTakenDateTime() == null ? null : bean.getVitalsTakenDateTime().buildDateTime();
		this.bloodpressure = bean.getBloodPressure() == null ? null : bean.getBloodPressure().buildVo();
		this.pulse = bean.getPulse() == null ? null : bean.getPulse().buildVo();
		this.spontaneousrespiratoryrate = bean.getSpontaneousRespiratoryRate() == null ? null : bean.getSpontaneousRespiratoryRate().buildVo();
		this.temperature = bean.getTemperature() == null ? null : bean.getTemperature().buildVo();
		this.oxygensaturation = bean.getOxygenSaturation() == null ? null : bean.getOxygenSaturation().buildVo();
		this.lungfunctiontest = bean.getLungFunctionTest() == null ? null : bean.getLungFunctionTest().buildVo();
		this.ventilationchart = bean.getVentilationChart() == null ? null : bean.getVentilationChart().buildVo();
		this.isventilationchartrecord = bean.getIsVentilationChartRecord();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.VSVentilationChartRecordsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.vitalstakendatetime = bean.getVitalsTakenDateTime() == null ? null : bean.getVitalsTakenDateTime().buildDateTime();
		this.bloodpressure = bean.getBloodPressure() == null ? null : bean.getBloodPressure().buildVo(map);
		this.pulse = bean.getPulse() == null ? null : bean.getPulse().buildVo(map);
		this.spontaneousrespiratoryrate = bean.getSpontaneousRespiratoryRate() == null ? null : bean.getSpontaneousRespiratoryRate().buildVo(map);
		this.temperature = bean.getTemperature() == null ? null : bean.getTemperature().buildVo(map);
		this.oxygensaturation = bean.getOxygenSaturation() == null ? null : bean.getOxygenSaturation().buildVo(map);
		this.lungfunctiontest = bean.getLungFunctionTest() == null ? null : bean.getLungFunctionTest().buildVo(map);
		this.ventilationchart = bean.getVentilationChart() == null ? null : bean.getVentilationChart().buildVo(map);
		this.isventilationchartrecord = bean.getIsVentilationChartRecord();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.VSVentilationChartRecordsVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.VSVentilationChartRecordsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.VSVentilationChartRecordsVoBean();
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
		if(fieldName.equals("VITALSTAKENDATETIME"))
			return getVitalsTakenDateTime();
		if(fieldName.equals("BLOODPRESSURE"))
			return getBloodPressure();
		if(fieldName.equals("PULSE"))
			return getPulse();
		if(fieldName.equals("SPONTANEOUSRESPIRATORYRATE"))
			return getSpontaneousRespiratoryRate();
		if(fieldName.equals("TEMPERATURE"))
			return getTemperature();
		if(fieldName.equals("OXYGENSATURATION"))
			return getOxygenSaturation();
		if(fieldName.equals("LUNGFUNCTIONTEST"))
			return getLungFunctionTest();
		if(fieldName.equals("VENTILATIONCHART"))
			return getVentilationChart();
		if(fieldName.equals("ISVENTILATIONCHARTRECORD"))
			return getIsVentilationChartRecord();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getVitalsTakenDateTimeIsNotNull()
	{
		return this.vitalstakendatetime != null;
	}
	public ims.framework.utils.DateTime getVitalsTakenDateTime()
	{
		return this.vitalstakendatetime;
	}
	public void setVitalsTakenDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.vitalstakendatetime = value;
	}
	public boolean getBloodPressureIsNotNull()
	{
		return this.bloodpressure != null;
	}
	public ims.core.vo.VSBloodPressure getBloodPressure()
	{
		return this.bloodpressure;
	}
	public void setBloodPressure(ims.core.vo.VSBloodPressure value)
	{
		this.isValidated = false;
		this.bloodpressure = value;
	}
	public boolean getPulseIsNotNull()
	{
		return this.pulse != null;
	}
	public ims.core.vo.VSPulse getPulse()
	{
		return this.pulse;
	}
	public void setPulse(ims.core.vo.VSPulse value)
	{
		this.isValidated = false;
		this.pulse = value;
	}
	public boolean getSpontaneousRespiratoryRateIsNotNull()
	{
		return this.spontaneousrespiratoryrate != null;
	}
	public ims.core.vo.VSRespirations getSpontaneousRespiratoryRate()
	{
		return this.spontaneousrespiratoryrate;
	}
	public void setSpontaneousRespiratoryRate(ims.core.vo.VSRespirations value)
	{
		this.isValidated = false;
		this.spontaneousrespiratoryrate = value;
	}
	public boolean getTemperatureIsNotNull()
	{
		return this.temperature != null;
	}
	public ims.core.vo.VSTemperature getTemperature()
	{
		return this.temperature;
	}
	public void setTemperature(ims.core.vo.VSTemperature value)
	{
		this.isValidated = false;
		this.temperature = value;
	}
	public boolean getOxygenSaturationIsNotNull()
	{
		return this.oxygensaturation != null;
	}
	public ims.core.vo.VSOxygenSaturation getOxygenSaturation()
	{
		return this.oxygensaturation;
	}
	public void setOxygenSaturation(ims.core.vo.VSOxygenSaturation value)
	{
		this.isValidated = false;
		this.oxygensaturation = value;
	}
	public boolean getLungFunctionTestIsNotNull()
	{
		return this.lungfunctiontest != null;
	}
	public ims.core.vo.VSLungFunctionTestVo getLungFunctionTest()
	{
		return this.lungfunctiontest;
	}
	public void setLungFunctionTest(ims.core.vo.VSLungFunctionTestVo value)
	{
		this.isValidated = false;
		this.lungfunctiontest = value;
	}
	public boolean getVentilationChartIsNotNull()
	{
		return this.ventilationchart != null;
	}
	public ims.core.vo.VSVentilationChartVo getVentilationChart()
	{
		return this.ventilationchart;
	}
	public void setVentilationChart(ims.core.vo.VSVentilationChartVo value)
	{
		this.isValidated = false;
		this.ventilationchart = value;
	}
	public boolean getIsVentilationChartRecordIsNotNull()
	{
		return this.isventilationchartrecord != null;
	}
	public Boolean getIsVentilationChartRecord()
	{
		return this.isventilationchartrecord;
	}
	public void setIsVentilationChartRecord(Boolean value)
	{
		this.isValidated = false;
		this.isventilationchartrecord = value;
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
		if(this.bloodpressure != null)
		{
			if(!this.bloodpressure.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.pulse != null)
		{
			if(!this.pulse.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.spontaneousrespiratoryrate != null)
		{
			if(!this.spontaneousrespiratoryrate.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.temperature != null)
		{
			if(!this.temperature.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.oxygensaturation != null)
		{
			if(!this.oxygensaturation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.lungfunctiontest != null)
		{
			if(!this.lungfunctiontest.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.ventilationchart != null)
		{
			if(!this.ventilationchart.isValidated())
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
		if(this.vitalstakendatetime == null)
			listOfErrors.add("VitalsTakenDateTime is mandatory");
		if(this.bloodpressure != null)
		{
			String[] listOfOtherErrors = this.bloodpressure.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.pulse != null)
		{
			String[] listOfOtherErrors = this.pulse.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.spontaneousrespiratoryrate != null)
		{
			String[] listOfOtherErrors = this.spontaneousrespiratoryrate.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.temperature != null)
		{
			String[] listOfOtherErrors = this.temperature.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.oxygensaturation != null)
		{
			String[] listOfOtherErrors = this.oxygensaturation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.lungfunctiontest != null)
		{
			String[] listOfOtherErrors = this.lungfunctiontest.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ventilationchart != null)
		{
			String[] listOfOtherErrors = this.ventilationchart.validate();
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
	
		VSVentilationChartRecordsVo clone = new VSVentilationChartRecordsVo(this.id, this.version);
		
		if(this.vitalstakendatetime == null)
			clone.vitalstakendatetime = null;
		else
			clone.vitalstakendatetime = (ims.framework.utils.DateTime)this.vitalstakendatetime.clone();
		if(this.bloodpressure == null)
			clone.bloodpressure = null;
		else
			clone.bloodpressure = (ims.core.vo.VSBloodPressure)this.bloodpressure.clone();
		if(this.pulse == null)
			clone.pulse = null;
		else
			clone.pulse = (ims.core.vo.VSPulse)this.pulse.clone();
		if(this.spontaneousrespiratoryrate == null)
			clone.spontaneousrespiratoryrate = null;
		else
			clone.spontaneousrespiratoryrate = (ims.core.vo.VSRespirations)this.spontaneousrespiratoryrate.clone();
		if(this.temperature == null)
			clone.temperature = null;
		else
			clone.temperature = (ims.core.vo.VSTemperature)this.temperature.clone();
		if(this.oxygensaturation == null)
			clone.oxygensaturation = null;
		else
			clone.oxygensaturation = (ims.core.vo.VSOxygenSaturation)this.oxygensaturation.clone();
		if(this.lungfunctiontest == null)
			clone.lungfunctiontest = null;
		else
			clone.lungfunctiontest = (ims.core.vo.VSLungFunctionTestVo)this.lungfunctiontest.clone();
		if(this.ventilationchart == null)
			clone.ventilationchart = null;
		else
			clone.ventilationchart = (ims.core.vo.VSVentilationChartVo)this.ventilationchart.clone();
		clone.isventilationchartrecord = this.isventilationchartrecord;
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
		if (!(VSVentilationChartRecordsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A VSVentilationChartRecordsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		VSVentilationChartRecordsVo compareObj = (VSVentilationChartRecordsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getVitalsTakenDateTime() == null && compareObj.getVitalsTakenDateTime() != null)
				return -1;
			if(this.getVitalsTakenDateTime() != null && compareObj.getVitalsTakenDateTime() == null)
				return 1;
			if(this.getVitalsTakenDateTime() != null && compareObj.getVitalsTakenDateTime() != null)
				retVal = this.getVitalsTakenDateTime().compareTo(compareObj.getVitalsTakenDateTime());
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
		if(this.vitalstakendatetime != null)
			count++;
		if(this.bloodpressure != null)
			count++;
		if(this.pulse != null)
			count++;
		if(this.spontaneousrespiratoryrate != null)
			count++;
		if(this.temperature != null)
			count++;
		if(this.oxygensaturation != null)
			count++;
		if(this.lungfunctiontest != null)
			count++;
		if(this.ventilationchart != null)
			count++;
		if(this.isventilationchartrecord != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.framework.utils.DateTime vitalstakendatetime;
	protected ims.core.vo.VSBloodPressure bloodpressure;
	protected ims.core.vo.VSPulse pulse;
	protected ims.core.vo.VSRespirations spontaneousrespiratoryrate;
	protected ims.core.vo.VSTemperature temperature;
	protected ims.core.vo.VSOxygenSaturation oxygensaturation;
	protected ims.core.vo.VSLungFunctionTestVo lungfunctiontest;
	protected ims.core.vo.VSVentilationChartVo ventilationchart;
	protected Boolean isventilationchartrecord;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
