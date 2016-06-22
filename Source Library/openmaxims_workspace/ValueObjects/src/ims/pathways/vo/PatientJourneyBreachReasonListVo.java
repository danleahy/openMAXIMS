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

package ims.pathways.vo;

/**
 * Linked to Pathways.PatientJourneyBreach business object (ID: 1088100014).
 */
public class PatientJourneyBreachReasonListVo extends ims.pathways.vo.PatientJourneyBreachRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientJourneyBreachReasonListVo()
	{
	}
	public PatientJourneyBreachReasonListVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientJourneyBreachReasonListVo(ims.pathways.vo.beans.PatientJourneyBreachReasonListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.breachreason = bean.getBreachReason() == null ? null : ims.pathways.vo.lookups.PatientJourneyBreachReason.buildLookup(bean.getBreachReason());
		this.breachreasoncomment = bean.getBreachReasonComment();
		this.breachreasonrecordingmos = bean.getBreachReasonRecordingMOS() == null ? null : bean.getBreachReasonRecordingMOS().buildVo();
		this.correctionauthoringinfo = bean.getCorrectionAuthoringInfo() == null ? null : bean.getCorrectionAuthoringInfo().buildVo();
		this.corrected = bean.getCorrected();
		this.correctioncomments = bean.getCorrectionComments();
		this.breachreasondate = bean.getBreachReasonDate() == null ? null : bean.getBreachReasonDate().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.beans.PatientJourneyBreachReasonListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.breachreason = bean.getBreachReason() == null ? null : ims.pathways.vo.lookups.PatientJourneyBreachReason.buildLookup(bean.getBreachReason());
		this.breachreasoncomment = bean.getBreachReasonComment();
		this.breachreasonrecordingmos = bean.getBreachReasonRecordingMOS() == null ? null : bean.getBreachReasonRecordingMOS().buildVo(map);
		this.correctionauthoringinfo = bean.getCorrectionAuthoringInfo() == null ? null : bean.getCorrectionAuthoringInfo().buildVo(map);
		this.corrected = bean.getCorrected();
		this.correctioncomments = bean.getCorrectionComments();
		this.breachreasondate = bean.getBreachReasonDate() == null ? null : bean.getBreachReasonDate().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.beans.PatientJourneyBreachReasonListVoBean bean = null;
		if(map != null)
			bean = (ims.pathways.vo.beans.PatientJourneyBreachReasonListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pathways.vo.beans.PatientJourneyBreachReasonListVoBean();
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
		if(fieldName.equals("BREACHREASON"))
			return getBreachReason();
		if(fieldName.equals("BREACHREASONCOMMENT"))
			return getBreachReasonComment();
		if(fieldName.equals("BREACHREASONRECORDINGMOS"))
			return getBreachReasonRecordingMOS();
		if(fieldName.equals("CORRECTIONAUTHORINGINFO"))
			return getCorrectionAuthoringInfo();
		if(fieldName.equals("CORRECTED"))
			return getCorrected();
		if(fieldName.equals("CORRECTIONCOMMENTS"))
			return getCorrectionComments();
		if(fieldName.equals("BREACHREASONDATE"))
			return getBreachReasonDate();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getBreachReasonIsNotNull()
	{
		return this.breachreason != null;
	}
	public ims.pathways.vo.lookups.PatientJourneyBreachReason getBreachReason()
	{
		return this.breachreason;
	}
	public void setBreachReason(ims.pathways.vo.lookups.PatientJourneyBreachReason value)
	{
		this.isValidated = false;
		this.breachreason = value;
	}
	public boolean getBreachReasonCommentIsNotNull()
	{
		return this.breachreasoncomment != null;
	}
	public String getBreachReasonComment()
	{
		return this.breachreasoncomment;
	}
	public static int getBreachReasonCommentMaxLength()
	{
		return 5000;
	}
	public void setBreachReasonComment(String value)
	{
		this.isValidated = false;
		this.breachreasoncomment = value;
	}
	public boolean getBreachReasonRecordingMOSIsNotNull()
	{
		return this.breachreasonrecordingmos != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getBreachReasonRecordingMOS()
	{
		return this.breachreasonrecordingmos;
	}
	public void setBreachReasonRecordingMOS(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.breachreasonrecordingmos = value;
	}
	public boolean getCorrectionAuthoringInfoIsNotNull()
	{
		return this.correctionauthoringinfo != null;
	}
	public ims.core.vo.RecordingUserInformationVo getCorrectionAuthoringInfo()
	{
		return this.correctionauthoringinfo;
	}
	public void setCorrectionAuthoringInfo(ims.core.vo.RecordingUserInformationVo value)
	{
		this.isValidated = false;
		this.correctionauthoringinfo = value;
	}
	public boolean getCorrectedIsNotNull()
	{
		return this.corrected != null;
	}
	public Boolean getCorrected()
	{
		return this.corrected;
	}
	public void setCorrected(Boolean value)
	{
		this.isValidated = false;
		this.corrected = value;
	}
	public boolean getCorrectionCommentsIsNotNull()
	{
		return this.correctioncomments != null;
	}
	public String getCorrectionComments()
	{
		return this.correctioncomments;
	}
	public static int getCorrectionCommentsMaxLength()
	{
		return 5000;
	}
	public void setCorrectionComments(String value)
	{
		this.isValidated = false;
		this.correctioncomments = value;
	}
	public boolean getBreachReasonDateIsNotNull()
	{
		return this.breachreasondate != null;
	}
	public ims.framework.utils.DateTime getBreachReasonDate()
	{
		return this.breachreasondate;
	}
	public void setBreachReasonDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.breachreasondate = value;
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
		if(this.correctionauthoringinfo != null)
		{
			if(!this.correctionauthoringinfo.isValidated())
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
		if(this.correctionauthoringinfo != null)
		{
			String[] listOfOtherErrors = this.correctionauthoringinfo.validate();
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
	
		PatientJourneyBreachReasonListVo clone = new PatientJourneyBreachReasonListVo(this.id, this.version);
		
		if(this.breachreason == null)
			clone.breachreason = null;
		else
			clone.breachreason = (ims.pathways.vo.lookups.PatientJourneyBreachReason)this.breachreason.clone();
		clone.breachreasoncomment = this.breachreasoncomment;
		if(this.breachreasonrecordingmos == null)
			clone.breachreasonrecordingmos = null;
		else
			clone.breachreasonrecordingmos = (ims.core.vo.MemberOfStaffLiteVo)this.breachreasonrecordingmos.clone();
		if(this.correctionauthoringinfo == null)
			clone.correctionauthoringinfo = null;
		else
			clone.correctionauthoringinfo = (ims.core.vo.RecordingUserInformationVo)this.correctionauthoringinfo.clone();
		clone.corrected = this.corrected;
		clone.correctioncomments = this.correctioncomments;
		if(this.breachreasondate == null)
			clone.breachreasondate = null;
		else
			clone.breachreasondate = (ims.framework.utils.DateTime)this.breachreasondate.clone();
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
		if (!(PatientJourneyBreachReasonListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientJourneyBreachReasonListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientJourneyBreachReasonListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientJourneyBreachReasonListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.breachreason != null)
			count++;
		if(this.breachreasoncomment != null)
			count++;
		if(this.breachreasonrecordingmos != null)
			count++;
		if(this.correctionauthoringinfo != null)
			count++;
		if(this.corrected != null)
			count++;
		if(this.correctioncomments != null)
			count++;
		if(this.breachreasondate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.pathways.vo.lookups.PatientJourneyBreachReason breachreason;
	protected String breachreasoncomment;
	protected ims.core.vo.MemberOfStaffLiteVo breachreasonrecordingmos;
	protected ims.core.vo.RecordingUserInformationVo correctionauthoringinfo;
	protected Boolean corrected;
	protected String correctioncomments;
	protected ims.framework.utils.DateTime breachreasondate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
