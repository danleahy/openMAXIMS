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

package ims.clinical.vo;

/**
 * Linked to eDischarge.MedicationDetails business object (ID: 1099100002).
 */
public class DischargeMedicationDetailsVo extends ims.edischarge.vo.MedicationDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DischargeMedicationDetailsVo()
	{
	}
	public DischargeMedicationDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public DischargeMedicationDetailsVo(ims.clinical.vo.beans.DischargeMedicationDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.medicationrecommendations = bean.getMedicationRecommendations();
		this.ttarequired = bean.getTTARequired() == null ? null : ims.clinical.vo.lookups.TTORequired.buildLookup(bean.getTTARequired());
		this.ttas = ims.clinical.vo.TTAMedicationVoCollection.buildFromBeanCollection(bean.getTTAs());
		this.admissionmedicationchanges = ims.clinical.vo.AdmissionMedicationChangesVoCollection.buildFromBeanCollection(bean.getAdmissionMedicationChanges());
		if(bean.getTTAComments() != null)
		{
			this.ttacomments = new ims.edischarge.vo.TTANoteRefVoCollection();
			for(int ttacomments_i = 0; ttacomments_i < bean.getTTAComments().length; ttacomments_i++)
			{
				this.ttacomments.add(new ims.edischarge.vo.TTANoteRefVo(new Integer(bean.getTTAComments()[ttacomments_i].getId()), bean.getTTAComments()[ttacomments_i].getVersion()));
			}
		}
		this.ttareceived = bean.getTTAReceived();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.DischargeMedicationDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.medicationrecommendations = bean.getMedicationRecommendations();
		this.ttarequired = bean.getTTARequired() == null ? null : ims.clinical.vo.lookups.TTORequired.buildLookup(bean.getTTARequired());
		this.ttas = ims.clinical.vo.TTAMedicationVoCollection.buildFromBeanCollection(bean.getTTAs());
		this.admissionmedicationchanges = ims.clinical.vo.AdmissionMedicationChangesVoCollection.buildFromBeanCollection(bean.getAdmissionMedicationChanges());
		if(bean.getTTAComments() != null)
		{
			this.ttacomments = new ims.edischarge.vo.TTANoteRefVoCollection();
			for(int ttacomments_i = 0; ttacomments_i < bean.getTTAComments().length; ttacomments_i++)
			{
				this.ttacomments.add(new ims.edischarge.vo.TTANoteRefVo(new Integer(bean.getTTAComments()[ttacomments_i].getId()), bean.getTTAComments()[ttacomments_i].getVersion()));
			}
		}
		this.ttareceived = bean.getTTAReceived();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.DischargeMedicationDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.DischargeMedicationDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.DischargeMedicationDetailsVoBean();
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
		if(fieldName.equals("MEDICATIONRECOMMENDATIONS"))
			return getMedicationRecommendations();
		if(fieldName.equals("TTAREQUIRED"))
			return getTTARequired();
		if(fieldName.equals("TTAS"))
			return getTTAs();
		if(fieldName.equals("ADMISSIONMEDICATIONCHANGES"))
			return getAdmissionMedicationChanges();
		if(fieldName.equals("TTACOMMENTS"))
			return getTTAComments();
		if(fieldName.equals("TTARECEIVED"))
			return getTTAReceived();
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
	public boolean getMedicationRecommendationsIsNotNull()
	{
		return this.medicationrecommendations != null;
	}
	public String getMedicationRecommendations()
	{
		return this.medicationrecommendations;
	}
	public static int getMedicationRecommendationsMaxLength()
	{
		return 3500;
	}
	public void setMedicationRecommendations(String value)
	{
		this.isValidated = false;
		this.medicationrecommendations = value;
	}
	public boolean getTTARequiredIsNotNull()
	{
		return this.ttarequired != null;
	}
	public ims.clinical.vo.lookups.TTORequired getTTARequired()
	{
		return this.ttarequired;
	}
	public void setTTARequired(ims.clinical.vo.lookups.TTORequired value)
	{
		this.isValidated = false;
		this.ttarequired = value;
	}
	public boolean getTTAsIsNotNull()
	{
		return this.ttas != null;
	}
	public ims.clinical.vo.TTAMedicationVoCollection getTTAs()
	{
		return this.ttas;
	}
	public void setTTAs(ims.clinical.vo.TTAMedicationVoCollection value)
	{
		this.isValidated = false;
		this.ttas = value;
	}
	public boolean getAdmissionMedicationChangesIsNotNull()
	{
		return this.admissionmedicationchanges != null;
	}
	public ims.clinical.vo.AdmissionMedicationChangesVoCollection getAdmissionMedicationChanges()
	{
		return this.admissionmedicationchanges;
	}
	public void setAdmissionMedicationChanges(ims.clinical.vo.AdmissionMedicationChangesVoCollection value)
	{
		this.isValidated = false;
		this.admissionmedicationchanges = value;
	}
	public boolean getTTACommentsIsNotNull()
	{
		return this.ttacomments != null;
	}
	public ims.edischarge.vo.TTANoteRefVoCollection getTTAComments()
	{
		return this.ttacomments;
	}
	public void setTTAComments(ims.edischarge.vo.TTANoteRefVoCollection value)
	{
		this.isValidated = false;
		this.ttacomments = value;
	}
	public boolean getTTAReceivedIsNotNull()
	{
		return this.ttareceived != null;
	}
	public Boolean getTTAReceived()
	{
		return this.ttareceived;
	}
	public void setTTAReceived(Boolean value)
	{
		this.isValidated = false;
		this.ttareceived = value;
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.medicationrecommendations != null)
			if(this.medicationrecommendations.length() > 3500)
				listOfErrors.add("The length of the field [medicationrecommendations] in the value object [ims.clinical.vo.DischargeMedicationDetailsVo] is too big. It should be less or equal to 3500");
		if(this.ttarequired == null)
			listOfErrors.add("TTARequired is mandatory");
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
	
		DischargeMedicationDetailsVo clone = new DischargeMedicationDetailsVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		clone.medicationrecommendations = this.medicationrecommendations;
		if(this.ttarequired == null)
			clone.ttarequired = null;
		else
			clone.ttarequired = (ims.clinical.vo.lookups.TTORequired)this.ttarequired.clone();
		if(this.ttas == null)
			clone.ttas = null;
		else
			clone.ttas = (ims.clinical.vo.TTAMedicationVoCollection)this.ttas.clone();
		if(this.admissionmedicationchanges == null)
			clone.admissionmedicationchanges = null;
		else
			clone.admissionmedicationchanges = (ims.clinical.vo.AdmissionMedicationChangesVoCollection)this.admissionmedicationchanges.clone();
		clone.ttacomments = this.ttacomments;
		clone.ttareceived = this.ttareceived;
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
		if (!(DischargeMedicationDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DischargeMedicationDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DischargeMedicationDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DischargeMedicationDetailsVo)obj).getBoId());
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
		if(this.medicationrecommendations != null)
			count++;
		if(this.ttarequired != null)
			count++;
		if(this.ttas != null)
			count++;
		if(this.admissionmedicationchanges != null)
			count++;
		if(this.ttacomments != null)
			count++;
		if(this.ttareceived != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected String medicationrecommendations;
	protected ims.clinical.vo.lookups.TTORequired ttarequired;
	protected ims.clinical.vo.TTAMedicationVoCollection ttas;
	protected ims.clinical.vo.AdmissionMedicationChangesVoCollection admissionmedicationchanges;
	protected ims.edischarge.vo.TTANoteRefVoCollection ttacomments;
	protected Boolean ttareceived;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
