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
// This code was generated by Neil McAnaspie using IMS Development Environment (version 1.22 build 41124.1200)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.spinalinjuries.forms.nurassessmentpersonaldetails;

import ims.core.vo.lookups.Occupation;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.nursing.vo.AssessmentHeaderInfo;
import ims.nursing.vo.CarePlanTemplate;
import ims.nursing.vo.CarePlanTemplateCollection;
import ims.nursing.vo.CarePlanTemplateTitle;
import ims.nursing.vo.CarePlanTemplateTitleCollection;
import ims.nursing.vo.lookups.AssessmentComponentType;
import ims.spinalinjuries.vo.NurAssessmentPersonalDetailsVo;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		open();
	}
	
	private void open() 
	{
		if(form.getGlobalContext().Core.getAssessmentIsReadOnly() == null || form.getGlobalContext().Core.getAssessmentIsReadOnly() == false )
			form.setMode(FormMode.EDIT);
		else
			form.setMode(FormMode.VIEW);
		form.chkCopy().setEnabled(false);
		
		AssessmentHeaderInfo assmnt = form.getGlobalContext().Nursing.getAssessmentHeaderInfo();
		form.getLocalContext().setAssessment(assmnt);
	
		NurAssessmentPersonalDetailsVo voPersonal = null;
		if (assmnt != null && assmnt.getCurrentComponent() != null)
		{
			voPersonal = (NurAssessmentPersonalDetailsVo)domain.getComponent(assmnt.getCurrentComponent());
			form.getLocalContext().setAssessmentPersonal(voPersonal);
		}
	
		// Care Plans
		CarePlanTemplateTitleCollection tempColl = domain.listCarePlanTemplates(AssessmentComponentType.SPINAL_PERSONAL_DETAILS);
		if (tempColl != null)
		{
			form.grdCarePlan().getRows().clear();
			GenForm.grdCarePlanRow tempRow;
			for (int i=0; i<tempColl.size(); i++)
			{
				CarePlanTemplateTitle template = tempColl.get(i);
				tempRow = form.grdCarePlan().getRows().newRow();
				tempRow.setValue(template);
				tempRow.setcolCarePlans(template.getTitle());
			}
		 }
		 
		checkForPreviousAssessent();
		
		if(voPersonal != null)
			populateScreenFromData(voPersonal); 
		else
		{
			if(form.getMode().equals(FormMode.EDIT))
				form.txtOtherOccupation().setEnabled(false);
		}
		
	}
	
	protected void checkForPreviousAssessent()
	{
		NurAssessmentPersonalDetailsVo assessAccDetails = (NurAssessmentPersonalDetailsVo) domain.getLastAssessmentComponentByCareContext(form.getGlobalContext().Core.getCurrentCareContext(), AssessmentComponentType.SPINAL_PERSONAL_DETAILS);
	
		if (assessAccDetails == null)
		{
			this.form.chkCopy().setValue(false);
			return;
		}
		
		form.getLocalContext().setPreviousAssPersonal(assessAccDetails);
		if(form.getMode().equals(FormMode.EDIT))
			form.chkCopy().setEnabled(true);
	}
	
	protected void populateScreenFromData(NurAssessmentPersonalDetailsVo voPersonal) 
	{
		super.populateScreenFromData(voPersonal);
		
		//Care Plans
		if (voPersonal.getCarePlanTemplate() != null && voPersonal.getCarePlanTemplate().size() > 0)
		{
			GenForm.grdCarePlanRow cpRow;
			CarePlanTemplateCollection templateColl = voPersonal.getCarePlanTemplate(); 
			CarePlanTemplate template;
			int i=0;
			// Find the correct row to set to selected
			for (int j=0; j<form.grdCarePlan().getRows().size(); j++)
			{
				cpRow = form.grdCarePlan().getRows().get(j);
				for (i=0; i<templateColl.size(); i++)
				{
					template = templateColl.get(i);
					if (cpRow.getValue().getID_CarePlanTemplate().equals(template.getID_CarePlanTemplate()))
					{
						cpRow.setcolSelect(true);
						cpRow.setReadOnly(true);
						break;
					}
				}
			}
		}
		
		if (voPersonal.getIsComplete().booleanValue() == true)  // Complete
		{
			form.setMode(FormMode.VIEW);
		}
		else
		{
			if ((form.cmbOccupation().getValue() != null))
				if(form.getMode().equals(FormMode.EDIT))
					form.txtOtherOccupation().setEnabled(form.cmbOccupation().getValue().equals(Occupation.OTHER));
		}
		form.chkCopy().setEnabled(false);
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.open(form.getForms().Nursing.AdmissionAssessOverview);
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		NurAssessmentPersonalDetailsVo voPersonal = populateDataFromScreen();
		
		String[] arrErrors = voPersonal.validate();
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return;
		}
		//if AssessmentHeaderInfo id == null, check if in the meantime another user from another session has created a new assessment for selected care context
		if(form.getLocalContext().getAssessment() != null)
			if(form.getLocalContext().getAssessment().getID_Assessment() == null)
				if(form.getGlobalContext().Core.getCurrentCareContext() != null)
				{
					AssessmentHeaderInfo tempvo = domain.getAssessmentHeaderInfoByCareContext(form.getGlobalContext().Core.getCurrentCareContext());
					if(tempvo != null)
					{
						form.getLocalContext().setAssessment(tempvo);
						form.getGlobalContext().Nursing.setAssessmentHeaderInfo(form.getLocalContext().getAssessment());
					}
				}

		try
		{
			AssessmentHeaderInfo newAssmnt = domain.saveComponent(form.getLocalContext().getAssessment(), voPersonal);
			form.getGlobalContext().Nursing.setAssessmentHeaderInfo(newAssmnt);
		}catch(StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			// We may need to reset the current component value in GC for onFormOpen - if there was none previously
			if (e.getStaleObject() != null)
			{
				 AssessmentHeaderInfo assmnt = form.getGlobalContext().Nursing.getAssessmentHeaderInfo();
				 if (assmnt != null && assmnt.getCurrentComponent() == null)
				 {
					 ims.nursing.vo.AssessmentComponent comp = new ims.nursing.vo.AssessmentComponent();
					 comp.setID_AssessmentComponent(e.getStaleObject().getId());
					 assmnt.setCurrentComponent(comp);
					 form.getGlobalContext().Nursing.setAssessmentHeaderInfo(assmnt);
				 }
			}
			open();
			return;								
		}
		catch(DomainRuntimeException e)
		{
			engine.showMessage(e.getMessage());
			AssessmentHeaderInfo newAssmnt = form.getGlobalContext().Nursing.getAssessmentHeaderInfo();
			AssessmentHeaderInfo assessheaderinfoVo = form.getLocalContext().getAssessment();	
			newAssmnt.setCurrentComponent( domain.getAssessComponent(assessheaderinfoVo.getID_Assessment(),AssessmentComponentType.SPINAL_PERSONAL_DETAILS));
			form.getGlobalContext().Nursing.setAssessmentHeaderInfo(newAssmnt);
			open();
			return;
		}
//		If the careplan grid is not readonly, we may need to go to the careplanstep2 form
		if (form.grdCarePlan().getReadOnly() == false)
		{
			 CarePlanTemplateTitleCollection templList = new CarePlanTemplateTitleCollection();
			 GenForm.grdCarePlanRow cpRow;
			 for (int i=0; i<form.grdCarePlan().getRows().size(); i++)
			 {
				 cpRow = form.grdCarePlan().getRows().get(i);
				 if (cpRow.getcolSelect() && !cpRow.isReadOnly())
					templList.add(cpRow.getValue());
			 }
			 if (templList.size() > 0)
			 {
				 form.getGlobalContext().COE.CarePlan.setTemplateList(templList);
				 engine.open(form.getForms().Nursing.CarePlanStep2);
			 }
			 else
				 engine.open(form.getForms().Nursing.AdmissionAssessOverview);
		}
		else
			 engine.open(form.getForms().Nursing.AdmissionAssessOverview);	
	}
	
	protected NurAssessmentPersonalDetailsVo populateDataFromScreen() 
	{
		NurAssessmentPersonalDetailsVo voPersonal = form.getLocalContext().getAssessmentPersonal();
		if (voPersonal == null)
			voPersonal = new NurAssessmentPersonalDetailsVo();
			
		voPersonal = super.populateDataFromScreen(voPersonal);	
		
		return voPersonal;
	}

	protected void onChkCopyValueChanged() throws PresentationLogicException 
	{
		if(form.getLocalContext().getPreviousAssPersonalIsNotNull())
		{
			NurAssessmentPersonalDetailsVo previousAssDetailsVo = new NurAssessmentPersonalDetailsVo();
			previousAssDetailsVo = form.getLocalContext().getPreviousAssPersonal();
			form.chkCopy().setValue(true);
			form.chkCopy().setEnabled(false);
			previousAssDetailsVo.setIsComplete(Boolean.FALSE);
			previousAssDetailsVo.setCopy(Boolean.TRUE);
			previousAssDetailsVo.setCarePlanTemplate(null);
			populateScreenFromData(previousAssDetailsVo);
		}
		else
		{
			form.chkCopy().setValue(false);
			return;
		}

	}

	protected void onLnkInfoClick() throws PresentationLogicException 
	{
		if (form.getLocalContext().getAssessmentPersonal() != null && form.getLocalContext().getAssessmentPersonal().getAssessmentInfo() != null)
		{
			form.getGlobalContext().Nursing.setAssessmentInfo(form.getLocalContext().getAssessmentPersonal().getAssessmentInfo());
			engine.open(form.getForms().Nursing.AssessmentInfo);
		}			
	}

	protected void onCmbOccupationValueChanged() throws PresentationLogicException
	{
		if (form.getMode().equals(FormMode.EDIT))
		{
			if (form.cmbOccupation().getValue() != null)
				form.txtOtherOccupation().setEnabled(form.cmbOccupation().getValue().equals(Occupation.OTHER));
			else
			{
				form.txtOtherOccupation().setEnabled(false);
				form.txtOtherOccupation().setValue(null);
			}
		}		
	}
}
