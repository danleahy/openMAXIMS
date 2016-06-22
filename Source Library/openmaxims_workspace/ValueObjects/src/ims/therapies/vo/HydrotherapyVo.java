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

package ims.therapies.vo;

/**
 * Linked to therapies.treatment.Hydrotherapy business object (ID: 1019100005).
 */
public class HydrotherapyVo extends ims.therapies.treatment.vo.HydrotherapyRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public HydrotherapyVo()
	{
	}
	public HydrotherapyVo(Integer id, int version)
	{
		super(id, version);
	}
	public HydrotherapyVo(ims.therapies.vo.beans.HydrotherapyVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.levelofassistance = bean.getLevelOfAssistance() == null ? null : ims.spinalinjuries.vo.lookups.HydrotherapyLevelOfAssistance.buildLookup(bean.getLevelOfAssistance());
		this.transferin = bean.getTransferIn() == null ? null : ims.spinalinjuries.vo.lookups.HydrotherapyTransferIn.buildLookup(bean.getTransferIn());
		this.transferout = bean.getTransferOut() == null ? null : ims.spinalinjuries.vo.lookups.HydrotherapyTransferOut.buildLookup(bean.getTransferOut());
		this.comment = bean.getComment();
		this.modalities = ims.spinalinjuries.vo.lookups.HydrotherapyModalitiesCollection.buildFromBeanCollection(bean.getModalities());
		this.equipment = ims.spinalinjuries.vo.lookups.HydrotherapyEquipmentCollection.buildFromBeanCollection(bean.getEquipment());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.HydrotherapyVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo(map);
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.levelofassistance = bean.getLevelOfAssistance() == null ? null : ims.spinalinjuries.vo.lookups.HydrotherapyLevelOfAssistance.buildLookup(bean.getLevelOfAssistance());
		this.transferin = bean.getTransferIn() == null ? null : ims.spinalinjuries.vo.lookups.HydrotherapyTransferIn.buildLookup(bean.getTransferIn());
		this.transferout = bean.getTransferOut() == null ? null : ims.spinalinjuries.vo.lookups.HydrotherapyTransferOut.buildLookup(bean.getTransferOut());
		this.comment = bean.getComment();
		this.modalities = ims.spinalinjuries.vo.lookups.HydrotherapyModalitiesCollection.buildFromBeanCollection(bean.getModalities());
		this.equipment = ims.spinalinjuries.vo.lookups.HydrotherapyEquipmentCollection.buildFromBeanCollection(bean.getEquipment());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.HydrotherapyVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.HydrotherapyVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.HydrotherapyVoBean();
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
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("AUTHORINGCP"))
			return getAuthoringCP();
		if(fieldName.equals("AUTHORINGDATETIME"))
			return getAuthoringDateTime();
		if(fieldName.equals("LEVELOFASSISTANCE"))
			return getLevelOfAssistance();
		if(fieldName.equals("TRANSFERIN"))
			return getTransferIn();
		if(fieldName.equals("TRANSFEROUT"))
			return getTransferOut();
		if(fieldName.equals("COMMENT"))
			return getComment();
		if(fieldName.equals("MODALITIES"))
			return getModalities();
		if(fieldName.equals("EQUIPMENT"))
			return getEquipment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.vo.ClinicalContactShortVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.ClinicalContactShortVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getAuthoringCPIsNotNull()
	{
		return this.authoringcp != null;
	}
	public ims.core.vo.Hcp getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.authoringcp = value;
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
	public boolean getLevelOfAssistanceIsNotNull()
	{
		return this.levelofassistance != null;
	}
	public ims.spinalinjuries.vo.lookups.HydrotherapyLevelOfAssistance getLevelOfAssistance()
	{
		return this.levelofassistance;
	}
	public void setLevelOfAssistance(ims.spinalinjuries.vo.lookups.HydrotherapyLevelOfAssistance value)
	{
		this.isValidated = false;
		this.levelofassistance = value;
	}
	public boolean getTransferInIsNotNull()
	{
		return this.transferin != null;
	}
	public ims.spinalinjuries.vo.lookups.HydrotherapyTransferIn getTransferIn()
	{
		return this.transferin;
	}
	public void setTransferIn(ims.spinalinjuries.vo.lookups.HydrotherapyTransferIn value)
	{
		this.isValidated = false;
		this.transferin = value;
	}
	public boolean getTransferOutIsNotNull()
	{
		return this.transferout != null;
	}
	public ims.spinalinjuries.vo.lookups.HydrotherapyTransferOut getTransferOut()
	{
		return this.transferout;
	}
	public void setTransferOut(ims.spinalinjuries.vo.lookups.HydrotherapyTransferOut value)
	{
		this.isValidated = false;
		this.transferout = value;
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
		return 1000;
	}
	public void setComment(String value)
	{
		this.isValidated = false;
		this.comment = value;
	}
	public boolean getModalitiesIsNotNull()
	{
		return this.modalities != null;
	}
	public ims.spinalinjuries.vo.lookups.HydrotherapyModalitiesCollection getModalities()
	{
		return this.modalities;
	}
	public void setModalities(ims.spinalinjuries.vo.lookups.HydrotherapyModalitiesCollection value)
	{
		this.isValidated = false;
		this.modalities = value;
	}
	public boolean getEquipmentIsNotNull()
	{
		return this.equipment != null;
	}
	public ims.spinalinjuries.vo.lookups.HydrotherapyEquipmentCollection getEquipment()
	{
		return this.equipment;
	}
	public void setEquipment(ims.spinalinjuries.vo.lookups.HydrotherapyEquipmentCollection value)
	{
		this.isValidated = false;
		this.equipment = value;
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
		if(this.authoringcp != null)
		{
			if(!this.authoringcp.isValidated())
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
		if(this.clinicalcontact == null)
			listOfErrors.add("ClinicalContact is mandatory");
		if(this.authoringcp == null)
			listOfErrors.add("Authoring HCP is a mandatory field");
		if(this.authoringcp != null)
		{
			String[] listOfOtherErrors = this.authoringcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.authoringdatetime == null)
			listOfErrors.add("Authoring Date/Time is a mandatory field");
		if(this.levelofassistance == null)
			listOfErrors.add("Level Of Assistance is a mandatory field");
		if(this.transferin == null)
			listOfErrors.add("Transfer In is a mandatory field");
		if(this.transferout == null)
			listOfErrors.add("Transfer Out is a mandatory field");
		if(this.comment != null)
			if(this.comment.length() > 1000)
				listOfErrors.add("The length of the field [comment] in the value object [ims.therapies.vo.HydrotherapyVo] is too big. It should be less or equal to 1000");
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
	
		HydrotherapyVo clone = new HydrotherapyVo(this.id, this.version);
		
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
		if(this.authoringcp == null)
			clone.authoringcp = null;
		else
			clone.authoringcp = (ims.core.vo.Hcp)this.authoringcp.clone();
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		if(this.levelofassistance == null)
			clone.levelofassistance = null;
		else
			clone.levelofassistance = (ims.spinalinjuries.vo.lookups.HydrotherapyLevelOfAssistance)this.levelofassistance.clone();
		if(this.transferin == null)
			clone.transferin = null;
		else
			clone.transferin = (ims.spinalinjuries.vo.lookups.HydrotherapyTransferIn)this.transferin.clone();
		if(this.transferout == null)
			clone.transferout = null;
		else
			clone.transferout = (ims.spinalinjuries.vo.lookups.HydrotherapyTransferOut)this.transferout.clone();
		clone.comment = this.comment;
		if(this.modalities == null)
			clone.modalities = null;
		else
			clone.modalities = (ims.spinalinjuries.vo.lookups.HydrotherapyModalitiesCollection)this.modalities.clone();
		if(this.equipment == null)
			clone.equipment = null;
		else
			clone.equipment = (ims.spinalinjuries.vo.lookups.HydrotherapyEquipmentCollection)this.equipment.clone();
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
		if (!(HydrotherapyVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A HydrotherapyVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		HydrotherapyVo compareObj = (HydrotherapyVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_Hydrotherapy() == null && compareObj.getID_Hydrotherapy() != null)
				return -1;
			if(this.getID_Hydrotherapy() != null && compareObj.getID_Hydrotherapy() == null)
				return 1;
			if(this.getID_Hydrotherapy() != null && compareObj.getID_Hydrotherapy() != null)
				retVal = this.getID_Hydrotherapy().compareTo(compareObj.getID_Hydrotherapy());
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
		if(this.clinicalcontact != null)
			count++;
		if(this.authoringcp != null)
			count++;
		if(this.authoringdatetime != null)
			count++;
		if(this.levelofassistance != null)
			count++;
		if(this.transferin != null)
			count++;
		if(this.transferout != null)
			count++;
		if(this.comment != null)
			count++;
		if(this.modalities != null)
			count++;
		if(this.equipment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.core.vo.ClinicalContactShortVo clinicalcontact;
	protected ims.core.vo.Hcp authoringcp;
	protected ims.framework.utils.DateTime authoringdatetime;
	protected ims.spinalinjuries.vo.lookups.HydrotherapyLevelOfAssistance levelofassistance;
	protected ims.spinalinjuries.vo.lookups.HydrotherapyTransferIn transferin;
	protected ims.spinalinjuries.vo.lookups.HydrotherapyTransferOut transferout;
	protected String comment;
	protected ims.spinalinjuries.vo.lookups.HydrotherapyModalitiesCollection modalities;
	protected ims.spinalinjuries.vo.lookups.HydrotherapyEquipmentCollection equipment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
