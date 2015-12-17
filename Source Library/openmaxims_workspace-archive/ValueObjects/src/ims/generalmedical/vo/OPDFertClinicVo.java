//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.generalmedical.vo;

/**
 * Linked to medical.OPDFertClinic business object (ID: 1023100027).
 */
public class OPDFertClinicVo extends ims.medical.vo.OPDFertClinicRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OPDFertClinicVo()
	{
	}
	public OPDFertClinicVo(Integer id, int version)
	{
		super(id, version);
	}
	public OPDFertClinicVo(ims.generalmedical.vo.beans.OPDFertClinicVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.achieveerection = bean.getAchieveErection() == null ? null : ims.spinalinjuries.vo.lookups.FCAchieveErection.buildLookup(bean.getAchieveErection());
		this.erectdysfxtreatments = ims.spinalinjuries.vo.lookups.FCErectDysTreatmentsCollection.buildFromBeanCollection(bean.getErectDysfxTreatments());
		this.sexdrive = bean.getSexDrive() == null ? null : ims.spinalinjuries.vo.lookups.FCSexDrive.buildLookup(bean.getSexDrive());
		this.ejaculation = bean.getEjaculation() == null ? null : ims.spinalinjuries.vo.lookups.FCEjaculation.buildLookup(bean.getEjaculation());
		this.bladderdrainage = ims.spinalinjuries.vo.lookups.FCBladderDrainageCollection.buildFromBeanCollection(bean.getBladderDrainage());
		this.bladderdrainagetxt = bean.getBladderDrainagetxt();
		this.testatrophy = bean.getTestAtrophy() == null ? null : ims.spinalinjuries.vo.lookups.FCTestAtrophy.buildLookup(bean.getTestAtrophy());
		this.endoevalperf = ims.spinalinjuries.vo.lookups.FCEndoEvalCollection.buildFromBeanCollection(bean.getEndoEvalPerf());
		this.infxnscreening = ims.spinalinjuries.vo.lookups.FCInfectionScreeningCollection.buildFromBeanCollection(bean.getInfxnScreening());
		this.screenconsent = bean.getScreenConsent() == null ? null : ims.spinalinjuries.vo.lookups.FCConsentForScreen.buildLookup(bean.getScreenConsent());
		this.semenculture = bean.getSemenCulture() == null ? null : ims.spinalinjuries.vo.lookups.FCSemenCulture.buildLookup(bean.getSemenCulture());
		this.semenfindings = ims.generalmedical.vo.OPDFertCLinicSemenAnaCollection.buildFromBeanCollection(bean.getSemenFindings());
		this.elisa = bean.getElisa() == null ? null : ims.spinalinjuries.vo.lookups.FCElisa.buildLookup(bean.getElisa());
		this.methodssuccesswith = ims.spinalinjuries.vo.lookups.FCmethodsSuccessWithCollection.buildFromBeanCollection(bean.getMethodssuccessWith());
		this.spermfrozen = bean.getSpermFrozen() == null ? null : ims.spinalinjuries.vo.lookups.FCSpermfrozen.buildLookup(bean.getSpermFrozen());
		this.treatmentsoffered = ims.spinalinjuries.vo.lookups.FCTreatmentsOfferedCollection.buildFromBeanCollection(bean.getTreatmentsoffered());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.beans.OPDFertClinicVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.achieveerection = bean.getAchieveErection() == null ? null : ims.spinalinjuries.vo.lookups.FCAchieveErection.buildLookup(bean.getAchieveErection());
		this.erectdysfxtreatments = ims.spinalinjuries.vo.lookups.FCErectDysTreatmentsCollection.buildFromBeanCollection(bean.getErectDysfxTreatments());
		this.sexdrive = bean.getSexDrive() == null ? null : ims.spinalinjuries.vo.lookups.FCSexDrive.buildLookup(bean.getSexDrive());
		this.ejaculation = bean.getEjaculation() == null ? null : ims.spinalinjuries.vo.lookups.FCEjaculation.buildLookup(bean.getEjaculation());
		this.bladderdrainage = ims.spinalinjuries.vo.lookups.FCBladderDrainageCollection.buildFromBeanCollection(bean.getBladderDrainage());
		this.bladderdrainagetxt = bean.getBladderDrainagetxt();
		this.testatrophy = bean.getTestAtrophy() == null ? null : ims.spinalinjuries.vo.lookups.FCTestAtrophy.buildLookup(bean.getTestAtrophy());
		this.endoevalperf = ims.spinalinjuries.vo.lookups.FCEndoEvalCollection.buildFromBeanCollection(bean.getEndoEvalPerf());
		this.infxnscreening = ims.spinalinjuries.vo.lookups.FCInfectionScreeningCollection.buildFromBeanCollection(bean.getInfxnScreening());
		this.screenconsent = bean.getScreenConsent() == null ? null : ims.spinalinjuries.vo.lookups.FCConsentForScreen.buildLookup(bean.getScreenConsent());
		this.semenculture = bean.getSemenCulture() == null ? null : ims.spinalinjuries.vo.lookups.FCSemenCulture.buildLookup(bean.getSemenCulture());
		this.semenfindings = ims.generalmedical.vo.OPDFertCLinicSemenAnaCollection.buildFromBeanCollection(bean.getSemenFindings());
		this.elisa = bean.getElisa() == null ? null : ims.spinalinjuries.vo.lookups.FCElisa.buildLookup(bean.getElisa());
		this.methodssuccesswith = ims.spinalinjuries.vo.lookups.FCmethodsSuccessWithCollection.buildFromBeanCollection(bean.getMethodssuccessWith());
		this.spermfrozen = bean.getSpermFrozen() == null ? null : ims.spinalinjuries.vo.lookups.FCSpermfrozen.buildLookup(bean.getSpermFrozen());
		this.treatmentsoffered = ims.spinalinjuries.vo.lookups.FCTreatmentsOfferedCollection.buildFromBeanCollection(bean.getTreatmentsoffered());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.beans.OPDFertClinicVoBean bean = null;
		if(map != null)
			bean = (ims.generalmedical.vo.beans.OPDFertClinicVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.generalmedical.vo.beans.OPDFertClinicVoBean();
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
		if(fieldName.equals("ACHIEVEERECTION"))
			return getAchieveErection();
		if(fieldName.equals("ERECTDYSFXTREATMENTS"))
			return getErectDysfxTreatments();
		if(fieldName.equals("SEXDRIVE"))
			return getSexDrive();
		if(fieldName.equals("EJACULATION"))
			return getEjaculation();
		if(fieldName.equals("BLADDERDRAINAGE"))
			return getBladderDrainage();
		if(fieldName.equals("BLADDERDRAINAGETXT"))
			return getBladderDrainagetxt();
		if(fieldName.equals("TESTATROPHY"))
			return getTestAtrophy();
		if(fieldName.equals("ENDOEVALPERF"))
			return getEndoEvalPerf();
		if(fieldName.equals("INFXNSCREENING"))
			return getInfxnScreening();
		if(fieldName.equals("SCREENCONSENT"))
			return getScreenConsent();
		if(fieldName.equals("SEMENCULTURE"))
			return getSemenCulture();
		if(fieldName.equals("SEMENFINDINGS"))
			return getSemenFindings();
		if(fieldName.equals("ELISA"))
			return getElisa();
		if(fieldName.equals("METHODSSUCCESSWITH"))
			return getMethodssuccessWith();
		if(fieldName.equals("SPERMFROZEN"))
			return getSpermFrozen();
		if(fieldName.equals("TREATMENTSOFFERED"))
			return getTreatmentsoffered();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAchieveErectionIsNotNull()
	{
		return this.achieveerection != null;
	}
	public ims.spinalinjuries.vo.lookups.FCAchieveErection getAchieveErection()
	{
		return this.achieveerection;
	}
	public void setAchieveErection(ims.spinalinjuries.vo.lookups.FCAchieveErection value)
	{
		this.isValidated = false;
		this.achieveerection = value;
	}
	public boolean getErectDysfxTreatmentsIsNotNull()
	{
		return this.erectdysfxtreatments != null;
	}
	public ims.spinalinjuries.vo.lookups.FCErectDysTreatmentsCollection getErectDysfxTreatments()
	{
		return this.erectdysfxtreatments;
	}
	public void setErectDysfxTreatments(ims.spinalinjuries.vo.lookups.FCErectDysTreatmentsCollection value)
	{
		this.isValidated = false;
		this.erectdysfxtreatments = value;
	}
	public boolean getSexDriveIsNotNull()
	{
		return this.sexdrive != null;
	}
	public ims.spinalinjuries.vo.lookups.FCSexDrive getSexDrive()
	{
		return this.sexdrive;
	}
	public void setSexDrive(ims.spinalinjuries.vo.lookups.FCSexDrive value)
	{
		this.isValidated = false;
		this.sexdrive = value;
	}
	public boolean getEjaculationIsNotNull()
	{
		return this.ejaculation != null;
	}
	public ims.spinalinjuries.vo.lookups.FCEjaculation getEjaculation()
	{
		return this.ejaculation;
	}
	public void setEjaculation(ims.spinalinjuries.vo.lookups.FCEjaculation value)
	{
		this.isValidated = false;
		this.ejaculation = value;
	}
	public boolean getBladderDrainageIsNotNull()
	{
		return this.bladderdrainage != null;
	}
	public ims.spinalinjuries.vo.lookups.FCBladderDrainageCollection getBladderDrainage()
	{
		return this.bladderdrainage;
	}
	public void setBladderDrainage(ims.spinalinjuries.vo.lookups.FCBladderDrainageCollection value)
	{
		this.isValidated = false;
		this.bladderdrainage = value;
	}
	public boolean getBladderDrainagetxtIsNotNull()
	{
		return this.bladderdrainagetxt != null;
	}
	public String getBladderDrainagetxt()
	{
		return this.bladderdrainagetxt;
	}
	public static int getBladderDrainagetxtMaxLength()
	{
		return 100;
	}
	public void setBladderDrainagetxt(String value)
	{
		this.isValidated = false;
		this.bladderdrainagetxt = value;
	}
	public boolean getTestAtrophyIsNotNull()
	{
		return this.testatrophy != null;
	}
	public ims.spinalinjuries.vo.lookups.FCTestAtrophy getTestAtrophy()
	{
		return this.testatrophy;
	}
	public void setTestAtrophy(ims.spinalinjuries.vo.lookups.FCTestAtrophy value)
	{
		this.isValidated = false;
		this.testatrophy = value;
	}
	public boolean getEndoEvalPerfIsNotNull()
	{
		return this.endoevalperf != null;
	}
	public ims.spinalinjuries.vo.lookups.FCEndoEvalCollection getEndoEvalPerf()
	{
		return this.endoevalperf;
	}
	public void setEndoEvalPerf(ims.spinalinjuries.vo.lookups.FCEndoEvalCollection value)
	{
		this.isValidated = false;
		this.endoevalperf = value;
	}
	public boolean getInfxnScreeningIsNotNull()
	{
		return this.infxnscreening != null;
	}
	public ims.spinalinjuries.vo.lookups.FCInfectionScreeningCollection getInfxnScreening()
	{
		return this.infxnscreening;
	}
	public void setInfxnScreening(ims.spinalinjuries.vo.lookups.FCInfectionScreeningCollection value)
	{
		this.isValidated = false;
		this.infxnscreening = value;
	}
	public boolean getScreenConsentIsNotNull()
	{
		return this.screenconsent != null;
	}
	public ims.spinalinjuries.vo.lookups.FCConsentForScreen getScreenConsent()
	{
		return this.screenconsent;
	}
	public void setScreenConsent(ims.spinalinjuries.vo.lookups.FCConsentForScreen value)
	{
		this.isValidated = false;
		this.screenconsent = value;
	}
	public boolean getSemenCultureIsNotNull()
	{
		return this.semenculture != null;
	}
	public ims.spinalinjuries.vo.lookups.FCSemenCulture getSemenCulture()
	{
		return this.semenculture;
	}
	public void setSemenCulture(ims.spinalinjuries.vo.lookups.FCSemenCulture value)
	{
		this.isValidated = false;
		this.semenculture = value;
	}
	public boolean getSemenFindingsIsNotNull()
	{
		return this.semenfindings != null;
	}
	public ims.generalmedical.vo.OPDFertCLinicSemenAnaCollection getSemenFindings()
	{
		return this.semenfindings;
	}
	public void setSemenFindings(ims.generalmedical.vo.OPDFertCLinicSemenAnaCollection value)
	{
		this.isValidated = false;
		this.semenfindings = value;
	}
	public boolean getElisaIsNotNull()
	{
		return this.elisa != null;
	}
	public ims.spinalinjuries.vo.lookups.FCElisa getElisa()
	{
		return this.elisa;
	}
	public void setElisa(ims.spinalinjuries.vo.lookups.FCElisa value)
	{
		this.isValidated = false;
		this.elisa = value;
	}
	public boolean getMethodssuccessWithIsNotNull()
	{
		return this.methodssuccesswith != null;
	}
	public ims.spinalinjuries.vo.lookups.FCmethodsSuccessWithCollection getMethodssuccessWith()
	{
		return this.methodssuccesswith;
	}
	public void setMethodssuccessWith(ims.spinalinjuries.vo.lookups.FCmethodsSuccessWithCollection value)
	{
		this.isValidated = false;
		this.methodssuccesswith = value;
	}
	public boolean getSpermFrozenIsNotNull()
	{
		return this.spermfrozen != null;
	}
	public ims.spinalinjuries.vo.lookups.FCSpermfrozen getSpermFrozen()
	{
		return this.spermfrozen;
	}
	public void setSpermFrozen(ims.spinalinjuries.vo.lookups.FCSpermfrozen value)
	{
		this.isValidated = false;
		this.spermfrozen = value;
	}
	public boolean getTreatmentsofferedIsNotNull()
	{
		return this.treatmentsoffered != null;
	}
	public ims.spinalinjuries.vo.lookups.FCTreatmentsOfferedCollection getTreatmentsoffered()
	{
		return this.treatmentsoffered;
	}
	public void setTreatmentsoffered(ims.spinalinjuries.vo.lookups.FCTreatmentsOfferedCollection value)
	{
		this.isValidated = false;
		this.treatmentsoffered = value;
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
		if(this.semenfindings != null)
		{
			if(!this.semenfindings.isValidated())
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
		if(this.bladderdrainagetxt != null)
			if(this.bladderdrainagetxt.length() > 100)
				listOfErrors.add("The length of the field [bladderdrainagetxt] in the value object [ims.generalmedical.vo.OPDFertClinicVo] is too big. It should be less or equal to 100");
		if(this.semenfindings != null)
		{
			String[] listOfOtherErrors = this.semenfindings.validate();
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
	
		OPDFertClinicVo clone = new OPDFertClinicVo(this.id, this.version);
		
		if(this.achieveerection == null)
			clone.achieveerection = null;
		else
			clone.achieveerection = (ims.spinalinjuries.vo.lookups.FCAchieveErection)this.achieveerection.clone();
		if(this.erectdysfxtreatments == null)
			clone.erectdysfxtreatments = null;
		else
			clone.erectdysfxtreatments = (ims.spinalinjuries.vo.lookups.FCErectDysTreatmentsCollection)this.erectdysfxtreatments.clone();
		if(this.sexdrive == null)
			clone.sexdrive = null;
		else
			clone.sexdrive = (ims.spinalinjuries.vo.lookups.FCSexDrive)this.sexdrive.clone();
		if(this.ejaculation == null)
			clone.ejaculation = null;
		else
			clone.ejaculation = (ims.spinalinjuries.vo.lookups.FCEjaculation)this.ejaculation.clone();
		if(this.bladderdrainage == null)
			clone.bladderdrainage = null;
		else
			clone.bladderdrainage = (ims.spinalinjuries.vo.lookups.FCBladderDrainageCollection)this.bladderdrainage.clone();
		clone.bladderdrainagetxt = this.bladderdrainagetxt;
		if(this.testatrophy == null)
			clone.testatrophy = null;
		else
			clone.testatrophy = (ims.spinalinjuries.vo.lookups.FCTestAtrophy)this.testatrophy.clone();
		if(this.endoevalperf == null)
			clone.endoevalperf = null;
		else
			clone.endoevalperf = (ims.spinalinjuries.vo.lookups.FCEndoEvalCollection)this.endoevalperf.clone();
		if(this.infxnscreening == null)
			clone.infxnscreening = null;
		else
			clone.infxnscreening = (ims.spinalinjuries.vo.lookups.FCInfectionScreeningCollection)this.infxnscreening.clone();
		if(this.screenconsent == null)
			clone.screenconsent = null;
		else
			clone.screenconsent = (ims.spinalinjuries.vo.lookups.FCConsentForScreen)this.screenconsent.clone();
		if(this.semenculture == null)
			clone.semenculture = null;
		else
			clone.semenculture = (ims.spinalinjuries.vo.lookups.FCSemenCulture)this.semenculture.clone();
		if(this.semenfindings == null)
			clone.semenfindings = null;
		else
			clone.semenfindings = (ims.generalmedical.vo.OPDFertCLinicSemenAnaCollection)this.semenfindings.clone();
		if(this.elisa == null)
			clone.elisa = null;
		else
			clone.elisa = (ims.spinalinjuries.vo.lookups.FCElisa)this.elisa.clone();
		if(this.methodssuccesswith == null)
			clone.methodssuccesswith = null;
		else
			clone.methodssuccesswith = (ims.spinalinjuries.vo.lookups.FCmethodsSuccessWithCollection)this.methodssuccesswith.clone();
		if(this.spermfrozen == null)
			clone.spermfrozen = null;
		else
			clone.spermfrozen = (ims.spinalinjuries.vo.lookups.FCSpermfrozen)this.spermfrozen.clone();
		if(this.treatmentsoffered == null)
			clone.treatmentsoffered = null;
		else
			clone.treatmentsoffered = (ims.spinalinjuries.vo.lookups.FCTreatmentsOfferedCollection)this.treatmentsoffered.clone();
		clone.carecontext = this.carecontext;
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
		if (!(OPDFertClinicVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OPDFertClinicVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		OPDFertClinicVo compareObj = (OPDFertClinicVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_OPDFertClinic() == null && compareObj.getID_OPDFertClinic() != null)
				return -1;
			if(this.getID_OPDFertClinic() != null && compareObj.getID_OPDFertClinic() == null)
				return 1;
			if(this.getID_OPDFertClinic() != null && compareObj.getID_OPDFertClinic() != null)
				retVal = this.getID_OPDFertClinic().compareTo(compareObj.getID_OPDFertClinic());
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
		if(this.achieveerection != null)
			count++;
		if(this.erectdysfxtreatments != null)
			count++;
		if(this.sexdrive != null)
			count++;
		if(this.ejaculation != null)
			count++;
		if(this.bladderdrainage != null)
			count++;
		if(this.bladderdrainagetxt != null)
			count++;
		if(this.testatrophy != null)
			count++;
		if(this.endoevalperf != null)
			count++;
		if(this.infxnscreening != null)
			count++;
		if(this.screenconsent != null)
			count++;
		if(this.semenculture != null)
			count++;
		if(this.semenfindings != null)
			count++;
		if(this.elisa != null)
			count++;
		if(this.methodssuccesswith != null)
			count++;
		if(this.spermfrozen != null)
			count++;
		if(this.treatmentsoffered != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 18;
	}
	protected ims.spinalinjuries.vo.lookups.FCAchieveErection achieveerection;
	protected ims.spinalinjuries.vo.lookups.FCErectDysTreatmentsCollection erectdysfxtreatments;
	protected ims.spinalinjuries.vo.lookups.FCSexDrive sexdrive;
	protected ims.spinalinjuries.vo.lookups.FCEjaculation ejaculation;
	protected ims.spinalinjuries.vo.lookups.FCBladderDrainageCollection bladderdrainage;
	protected String bladderdrainagetxt;
	protected ims.spinalinjuries.vo.lookups.FCTestAtrophy testatrophy;
	protected ims.spinalinjuries.vo.lookups.FCEndoEvalCollection endoevalperf;
	protected ims.spinalinjuries.vo.lookups.FCInfectionScreeningCollection infxnscreening;
	protected ims.spinalinjuries.vo.lookups.FCConsentForScreen screenconsent;
	protected ims.spinalinjuries.vo.lookups.FCSemenCulture semenculture;
	protected ims.generalmedical.vo.OPDFertCLinicSemenAnaCollection semenfindings;
	protected ims.spinalinjuries.vo.lookups.FCElisa elisa;
	protected ims.spinalinjuries.vo.lookups.FCmethodsSuccessWithCollection methodssuccesswith;
	protected ims.spinalinjuries.vo.lookups.FCSpermfrozen spermfrozen;
	protected ims.spinalinjuries.vo.lookups.FCTreatmentsOfferedCollection treatmentsoffered;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}