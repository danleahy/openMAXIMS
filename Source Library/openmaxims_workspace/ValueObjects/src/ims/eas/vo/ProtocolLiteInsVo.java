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

package ims.eas.vo;

/**
 * Linked to EAS.Configuration.Protocol business object (ID: 1114100003).
 */
public class ProtocolLiteInsVo extends ims.eas.vo.ProtocolNameVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ProtocolLiteInsVo()
	{
	}
	public ProtocolLiteInsVo(Integer id, int version)
	{
		super(id, version);
	}
	public ProtocolLiteInsVo(ims.eas.vo.beans.ProtocolLiteInsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.protocolname = bean.getProtocolName();
		this.treatmentsite = bean.getTreatmentSite() == null ? null : bean.getTreatmentSite().buildVo();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.phases = ims.eas.vo.ProtocolPhaseVoCollection.buildFromBeanCollection(bean.getPhases());
		this.clintrialprotocol = bean.getClinTrialProtocol();
		this.clinicaltrial = bean.getClinicalTrial() == null ? null : ims.oncology.vo.lookups.ClinicalTrialName.buildLookup(bean.getClinicalTrial());
		this.primarytumour = bean.getPrimaryTumour() == null ? null : bean.getPrimaryTumour().buildVo();
		this.appropcccl = bean.getAppropCCCL() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getAppropCCCL());
		this.conssessdefault = bean.getConsSessDefault() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getConsSessDefault());
		this.conssessrequired = bean.getConsSessRequired() == null ? null : ims.eas.vo.lookups.OptionsRequired.buildLookup(bean.getConsSessRequired());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.eas.vo.beans.ProtocolLiteInsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.protocolname = bean.getProtocolName();
		this.treatmentsite = bean.getTreatmentSite() == null ? null : bean.getTreatmentSite().buildVo(map);
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.phases = ims.eas.vo.ProtocolPhaseVoCollection.buildFromBeanCollection(bean.getPhases());
		this.clintrialprotocol = bean.getClinTrialProtocol();
		this.clinicaltrial = bean.getClinicalTrial() == null ? null : ims.oncology.vo.lookups.ClinicalTrialName.buildLookup(bean.getClinicalTrial());
		this.primarytumour = bean.getPrimaryTumour() == null ? null : bean.getPrimaryTumour().buildVo(map);
		this.appropcccl = bean.getAppropCCCL() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getAppropCCCL());
		this.conssessdefault = bean.getConsSessDefault() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getConsSessDefault());
		this.conssessrequired = bean.getConsSessRequired() == null ? null : ims.eas.vo.lookups.OptionsRequired.buildLookup(bean.getConsSessRequired());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.eas.vo.beans.ProtocolLiteInsVoBean bean = null;
		if(map != null)
			bean = (ims.eas.vo.beans.ProtocolLiteInsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.eas.vo.beans.ProtocolLiteInsVoBean();
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
		if(fieldName.equals("TREATMENTSITE"))
			return getTreatmentSite();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("PHASES"))
			return getPhases();
		if(fieldName.equals("CLINTRIALPROTOCOL"))
			return getClinTrialProtocol();
		if(fieldName.equals("CLINICALTRIAL"))
			return getClinicalTrial();
		if(fieldName.equals("PRIMARYTUMOUR"))
			return getPrimaryTumour();
		if(fieldName.equals("APPROPCCCL"))
			return getAppropCCCL();
		if(fieldName.equals("CONSSESSDEFAULT"))
			return getConsSessDefault();
		if(fieldName.equals("CONSSESSREQUIRED"))
			return getConsSessRequired();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTreatmentSiteIsNotNull()
	{
		return this.treatmentsite != null;
	}
	public ims.eas.vo.TreatmentSitesVo getTreatmentSite()
	{
		return this.treatmentsite;
	}
	public void setTreatmentSite(ims.eas.vo.TreatmentSitesVo value)
	{
		this.isValidated = false;
		this.treatmentsite = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getPhasesIsNotNull()
	{
		return this.phases != null;
	}
	public ims.eas.vo.ProtocolPhaseVoCollection getPhases()
	{
		return this.phases;
	}
	public void setPhases(ims.eas.vo.ProtocolPhaseVoCollection value)
	{
		this.isValidated = false;
		this.phases = value;
	}
	public boolean getClinTrialProtocolIsNotNull()
	{
		return this.clintrialprotocol != null;
	}
	public Boolean getClinTrialProtocol()
	{
		return this.clintrialprotocol;
	}
	public void setClinTrialProtocol(Boolean value)
	{
		this.isValidated = false;
		this.clintrialprotocol = value;
	}
	public boolean getClinicalTrialIsNotNull()
	{
		return this.clinicaltrial != null;
	}
	public ims.oncology.vo.lookups.ClinicalTrialName getClinicalTrial()
	{
		return this.clinicaltrial;
	}
	public void setClinicalTrial(ims.oncology.vo.lookups.ClinicalTrialName value)
	{
		this.isValidated = false;
		this.clinicaltrial = value;
	}
	public boolean getPrimaryTumourIsNotNull()
	{
		return this.primarytumour != null;
	}
	public ims.eas.vo.PrimaryTumourNameVo getPrimaryTumour()
	{
		return this.primarytumour;
	}
	public void setPrimaryTumour(ims.eas.vo.PrimaryTumourNameVo value)
	{
		this.isValidated = false;
		this.primarytumour = value;
	}
	public boolean getAppropCCCLIsNotNull()
	{
		return this.appropcccl != null;
	}
	public ims.core.vo.lookups.YesNo getAppropCCCL()
	{
		return this.appropcccl;
	}
	public void setAppropCCCL(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.appropcccl = value;
	}
	public boolean getConsSessDefaultIsNotNull()
	{
		return this.conssessdefault != null;
	}
	public ims.core.vo.lookups.YesNo getConsSessDefault()
	{
		return this.conssessdefault;
	}
	public void setConsSessDefault(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.conssessdefault = value;
	}
	public boolean getConsSessRequiredIsNotNull()
	{
		return this.conssessrequired != null;
	}
	public ims.eas.vo.lookups.OptionsRequired getConsSessRequired()
	{
		return this.conssessrequired;
	}
	public void setConsSessRequired(ims.eas.vo.lookups.OptionsRequired value)
	{
		this.isValidated = false;
		this.conssessrequired = value;
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
		if(this.protocolname == null || this.protocolname.length() == 0)
			listOfErrors.add("ProtocolName is mandatory");
		else if(this.protocolname.length() > 70)
			listOfErrors.add("The length of the field [protocolname] in the value object [ims.eas.vo.ProtocolLiteInsVo] is too big. It should be less or equal to 70");
		if(this.treatmentsite == null)
			listOfErrors.add("TreatmentSite is mandatory");
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
		if(this.phases == null || this.phases.size() == 0)
			listOfErrors.add("Phases are mandatory");
		if(this.primarytumour == null)
			listOfErrors.add("PrimaryTumour is mandatory");
		if(this.appropcccl == null)
			listOfErrors.add("AppropCCCL is mandatory");
		if(this.conssessrequired == null)
			listOfErrors.add("ConsSessRequired is mandatory");
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
	
		ProtocolLiteInsVo clone = new ProtocolLiteInsVo(this.id, this.version);
		
		clone.protocolname = this.protocolname;
		if(this.treatmentsite == null)
			clone.treatmentsite = null;
		else
			clone.treatmentsite = (ims.eas.vo.TreatmentSitesVo)this.treatmentsite.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.status.clone();
		if(this.phases == null)
			clone.phases = null;
		else
			clone.phases = (ims.eas.vo.ProtocolPhaseVoCollection)this.phases.clone();
		clone.clintrialprotocol = this.clintrialprotocol;
		if(this.clinicaltrial == null)
			clone.clinicaltrial = null;
		else
			clone.clinicaltrial = (ims.oncology.vo.lookups.ClinicalTrialName)this.clinicaltrial.clone();
		if(this.primarytumour == null)
			clone.primarytumour = null;
		else
			clone.primarytumour = (ims.eas.vo.PrimaryTumourNameVo)this.primarytumour.clone();
		if(this.appropcccl == null)
			clone.appropcccl = null;
		else
			clone.appropcccl = (ims.core.vo.lookups.YesNo)this.appropcccl.clone();
		if(this.conssessdefault == null)
			clone.conssessdefault = null;
		else
			clone.conssessdefault = (ims.core.vo.lookups.YesNo)this.conssessdefault.clone();
		if(this.conssessrequired == null)
			clone.conssessrequired = null;
		else
			clone.conssessrequired = (ims.eas.vo.lookups.OptionsRequired)this.conssessrequired.clone();
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
		if (!(ProtocolLiteInsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ProtocolLiteInsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ProtocolLiteInsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ProtocolLiteInsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.treatmentsite != null)
			count++;
		if(this.status != null)
			count++;
		if(this.phases != null)
			count++;
		if(this.clintrialprotocol != null)
			count++;
		if(this.clinicaltrial != null)
			count++;
		if(this.primarytumour != null)
			count++;
		if(this.appropcccl != null)
			count++;
		if(this.conssessdefault != null)
			count++;
		if(this.conssessrequired != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 9;
	}
	protected ims.eas.vo.TreatmentSitesVo treatmentsite;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus status;
	protected ims.eas.vo.ProtocolPhaseVoCollection phases;
	protected Boolean clintrialprotocol;
	protected ims.oncology.vo.lookups.ClinicalTrialName clinicaltrial;
	protected ims.eas.vo.PrimaryTumourNameVo primarytumour;
	protected ims.core.vo.lookups.YesNo appropcccl;
	protected ims.core.vo.lookups.YesNo conssessdefault;
	protected ims.eas.vo.lookups.OptionsRequired conssessrequired;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
