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
 * Linked to RefMan.SurgicalOpNotes business object (ID: 1096100053).
 */
public class SurgicalOpNotesVo extends ims.RefMan.vo.SurgicalOpNotesRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SurgicalOpNotesVo()
	{
	}
	public SurgicalOpNotesVo(Integer id, int version)
	{
		super(id, version);
	}
	public SurgicalOpNotesVo(ims.RefMan.vo.beans.SurgicalOpNotesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.intraoperativecarerecord = bean.getIntraOperativeCareRecord() == null ? null : new ims.core.clinical.vo.IntraOperativeCareRecordRefVo(new Integer(bean.getIntraOperativeCareRecord().getId()), bean.getIntraOperativeCareRecord().getVersion());
		this.incision = bean.getIncision();
		this.findings = bean.getFindings();
		this.procedure = bean.getProcedure();
		this.closure = bean.getClosure();
		this.postopinstructions = bean.getPostOpInstructions();
		this.complications = bean.getComplications();
		this.lainfiltration = bean.getLAInfiltration();
		this.preoperativediagnosis = bean.getPreOperativeDiagnosis();
		this.antibiotics = bean.getAntibiotics();
		this.vte = bean.getVTE();
		this.ebi = bean.getEBI();
		this.followuptype = bean.getFollowUpType() == null ? null : ims.RefMan.vo.lookups.SurgicalOpFollowUpType.buildLookup(bean.getFollowUpType());
		this.followuptypein = bean.getFollowUpTypeIn() == null ? null : ims.RefMan.vo.lookups.SurgicalOpFollowUpIn.buildLookup(bean.getFollowUpTypeIn());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.SurgicalOpNotesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.intraoperativecarerecord = bean.getIntraOperativeCareRecord() == null ? null : new ims.core.clinical.vo.IntraOperativeCareRecordRefVo(new Integer(bean.getIntraOperativeCareRecord().getId()), bean.getIntraOperativeCareRecord().getVersion());
		this.incision = bean.getIncision();
		this.findings = bean.getFindings();
		this.procedure = bean.getProcedure();
		this.closure = bean.getClosure();
		this.postopinstructions = bean.getPostOpInstructions();
		this.complications = bean.getComplications();
		this.lainfiltration = bean.getLAInfiltration();
		this.preoperativediagnosis = bean.getPreOperativeDiagnosis();
		this.antibiotics = bean.getAntibiotics();
		this.vte = bean.getVTE();
		this.ebi = bean.getEBI();
		this.followuptype = bean.getFollowUpType() == null ? null : ims.RefMan.vo.lookups.SurgicalOpFollowUpType.buildLookup(bean.getFollowUpType());
		this.followuptypein = bean.getFollowUpTypeIn() == null ? null : ims.RefMan.vo.lookups.SurgicalOpFollowUpIn.buildLookup(bean.getFollowUpTypeIn());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.SurgicalOpNotesVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.SurgicalOpNotesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.SurgicalOpNotesVoBean();
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
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("INTRAOPERATIVECARERECORD"))
			return getIntraOperativeCareRecord();
		if(fieldName.equals("INCISION"))
			return getIncision();
		if(fieldName.equals("FINDINGS"))
			return getFindings();
		if(fieldName.equals("PROCEDURE"))
			return getProcedure();
		if(fieldName.equals("CLOSURE"))
			return getClosure();
		if(fieldName.equals("POSTOPINSTRUCTIONS"))
			return getPostOpInstructions();
		if(fieldName.equals("COMPLICATIONS"))
			return getComplications();
		if(fieldName.equals("LAINFILTRATION"))
			return getLAInfiltration();
		if(fieldName.equals("PREOPERATIVEDIAGNOSIS"))
			return getPreOperativeDiagnosis();
		if(fieldName.equals("ANTIBIOTICS"))
			return getAntibiotics();
		if(fieldName.equals("VTE"))
			return getVTE();
		if(fieldName.equals("EBI"))
			return getEBI();
		if(fieldName.equals("FOLLOWUPTYPE"))
			return getFollowUpType();
		if(fieldName.equals("FOLLOWUPTYPEIN"))
			return getFollowUpTypeIn();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getIntraOperativeCareRecordIsNotNull()
	{
		return this.intraoperativecarerecord != null;
	}
	public ims.core.clinical.vo.IntraOperativeCareRecordRefVo getIntraOperativeCareRecord()
	{
		return this.intraoperativecarerecord;
	}
	public void setIntraOperativeCareRecord(ims.core.clinical.vo.IntraOperativeCareRecordRefVo value)
	{
		this.isValidated = false;
		this.intraoperativecarerecord = value;
	}
	public boolean getIncisionIsNotNull()
	{
		return this.incision != null;
	}
	public String getIncision()
	{
		return this.incision;
	}
	public static int getIncisionMaxLength()
	{
		return 5000;
	}
	public void setIncision(String value)
	{
		this.isValidated = false;
		this.incision = value;
	}
	public boolean getFindingsIsNotNull()
	{
		return this.findings != null;
	}
	public String getFindings()
	{
		return this.findings;
	}
	public static int getFindingsMaxLength()
	{
		return 5000;
	}
	public void setFindings(String value)
	{
		this.isValidated = false;
		this.findings = value;
	}
	public boolean getProcedureIsNotNull()
	{
		return this.procedure != null;
	}
	public String getProcedure()
	{
		return this.procedure;
	}
	public static int getProcedureMaxLength()
	{
		return 5000;
	}
	public void setProcedure(String value)
	{
		this.isValidated = false;
		this.procedure = value;
	}
	public boolean getClosureIsNotNull()
	{
		return this.closure != null;
	}
	public String getClosure()
	{
		return this.closure;
	}
	public static int getClosureMaxLength()
	{
		return 5000;
	}
	public void setClosure(String value)
	{
		this.isValidated = false;
		this.closure = value;
	}
	public boolean getPostOpInstructionsIsNotNull()
	{
		return this.postopinstructions != null;
	}
	public String getPostOpInstructions()
	{
		return this.postopinstructions;
	}
	public static int getPostOpInstructionsMaxLength()
	{
		return 5000;
	}
	public void setPostOpInstructions(String value)
	{
		this.isValidated = false;
		this.postopinstructions = value;
	}
	public boolean getComplicationsIsNotNull()
	{
		return this.complications != null;
	}
	public String getComplications()
	{
		return this.complications;
	}
	public static int getComplicationsMaxLength()
	{
		return 5000;
	}
	public void setComplications(String value)
	{
		this.isValidated = false;
		this.complications = value;
	}
	public boolean getLAInfiltrationIsNotNull()
	{
		return this.lainfiltration != null;
	}
	public String getLAInfiltration()
	{
		return this.lainfiltration;
	}
	public static int getLAInfiltrationMaxLength()
	{
		return 2000;
	}
	public void setLAInfiltration(String value)
	{
		this.isValidated = false;
		this.lainfiltration = value;
	}
	public boolean getPreOperativeDiagnosisIsNotNull()
	{
		return this.preoperativediagnosis != null;
	}
	public String getPreOperativeDiagnosis()
	{
		return this.preoperativediagnosis;
	}
	public static int getPreOperativeDiagnosisMaxLength()
	{
		return 255;
	}
	public void setPreOperativeDiagnosis(String value)
	{
		this.isValidated = false;
		this.preoperativediagnosis = value;
	}
	public boolean getAntibioticsIsNotNull()
	{
		return this.antibiotics != null;
	}
	public String getAntibiotics()
	{
		return this.antibiotics;
	}
	public static int getAntibioticsMaxLength()
	{
		return 255;
	}
	public void setAntibiotics(String value)
	{
		this.isValidated = false;
		this.antibiotics = value;
	}
	public boolean getVTEIsNotNull()
	{
		return this.vte != null;
	}
	public String getVTE()
	{
		return this.vte;
	}
	public static int getVTEMaxLength()
	{
		return 255;
	}
	public void setVTE(String value)
	{
		this.isValidated = false;
		this.vte = value;
	}
	public boolean getEBIIsNotNull()
	{
		return this.ebi != null;
	}
	public String getEBI()
	{
		return this.ebi;
	}
	public static int getEBIMaxLength()
	{
		return 10;
	}
	public void setEBI(String value)
	{
		this.isValidated = false;
		this.ebi = value;
	}
	public boolean getFollowUpTypeIsNotNull()
	{
		return this.followuptype != null;
	}
	public ims.RefMan.vo.lookups.SurgicalOpFollowUpType getFollowUpType()
	{
		return this.followuptype;
	}
	public void setFollowUpType(ims.RefMan.vo.lookups.SurgicalOpFollowUpType value)
	{
		this.isValidated = false;
		this.followuptype = value;
	}
	public boolean getFollowUpTypeInIsNotNull()
	{
		return this.followuptypein != null;
	}
	public ims.RefMan.vo.lookups.SurgicalOpFollowUpIn getFollowUpTypeIn()
	{
		return this.followuptypein;
	}
	public void setFollowUpTypeIn(ims.RefMan.vo.lookups.SurgicalOpFollowUpIn value)
	{
		this.isValidated = false;
		this.followuptypein = value;
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
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
		if(this.intraoperativecarerecord == null)
			listOfErrors.add("IntraOperativeCareRecord is mandatory");
		if(this.lainfiltration != null)
			if(this.lainfiltration.length() > 2000)
				listOfErrors.add("The length of the field [lainfiltration] in the value object [ims.RefMan.vo.SurgicalOpNotesVo] is too big. It should be less or equal to 2000");
		if(this.preoperativediagnosis != null)
			if(this.preoperativediagnosis.length() > 255)
				listOfErrors.add("The length of the field [preoperativediagnosis] in the value object [ims.RefMan.vo.SurgicalOpNotesVo] is too big. It should be less or equal to 255");
		if(this.antibiotics != null)
			if(this.antibiotics.length() > 255)
				listOfErrors.add("The length of the field [antibiotics] in the value object [ims.RefMan.vo.SurgicalOpNotesVo] is too big. It should be less or equal to 255");
		if(this.vte != null)
			if(this.vte.length() > 255)
				listOfErrors.add("The length of the field [vte] in the value object [ims.RefMan.vo.SurgicalOpNotesVo] is too big. It should be less or equal to 255");
		if(this.ebi != null)
			if(this.ebi.length() > 10)
				listOfErrors.add("The length of the field [ebi] in the value object [ims.RefMan.vo.SurgicalOpNotesVo] is too big. It should be less or equal to 10");
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
	
		SurgicalOpNotesVo clone = new SurgicalOpNotesVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		clone.intraoperativecarerecord = this.intraoperativecarerecord;
		clone.incision = this.incision;
		clone.findings = this.findings;
		clone.procedure = this.procedure;
		clone.closure = this.closure;
		clone.postopinstructions = this.postopinstructions;
		clone.complications = this.complications;
		clone.lainfiltration = this.lainfiltration;
		clone.preoperativediagnosis = this.preoperativediagnosis;
		clone.antibiotics = this.antibiotics;
		clone.vte = this.vte;
		clone.ebi = this.ebi;
		if(this.followuptype == null)
			clone.followuptype = null;
		else
			clone.followuptype = (ims.RefMan.vo.lookups.SurgicalOpFollowUpType)this.followuptype.clone();
		if(this.followuptypein == null)
			clone.followuptypein = null;
		else
			clone.followuptypein = (ims.RefMan.vo.lookups.SurgicalOpFollowUpIn)this.followuptypein.clone();
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
		if (!(SurgicalOpNotesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SurgicalOpNotesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SurgicalOpNotesVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SurgicalOpNotesVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.carecontext != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.intraoperativecarerecord != null)
			count++;
		if(this.incision != null)
			count++;
		if(this.findings != null)
			count++;
		if(this.procedure != null)
			count++;
		if(this.closure != null)
			count++;
		if(this.postopinstructions != null)
			count++;
		if(this.complications != null)
			count++;
		if(this.lainfiltration != null)
			count++;
		if(this.preoperativediagnosis != null)
			count++;
		if(this.antibiotics != null)
			count++;
		if(this.vte != null)
			count++;
		if(this.ebi != null)
			count++;
		if(this.followuptype != null)
			count++;
		if(this.followuptypein != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 16;
	}
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.core.clinical.vo.IntraOperativeCareRecordRefVo intraoperativecarerecord;
	protected String incision;
	protected String findings;
	protected String procedure;
	protected String closure;
	protected String postopinstructions;
	protected String complications;
	protected String lainfiltration;
	protected String preoperativediagnosis;
	protected String antibiotics;
	protected String vte;
	protected String ebi;
	protected ims.RefMan.vo.lookups.SurgicalOpFollowUpType followuptype;
	protected ims.RefMan.vo.lookups.SurgicalOpFollowUpIn followuptypein;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
