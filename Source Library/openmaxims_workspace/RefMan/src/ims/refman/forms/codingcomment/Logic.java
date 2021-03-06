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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5308.16958)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.codingcomment;

import ims.RefMan.forms.codingcomment.GenForm.grdStructuredCommentsRow;
import ims.RefMan.vo.AdmissionDetailForCoderWorklistVo;
import ims.RefMan.vo.ConsultantStayForPatientCodingListVo;
import ims.clinical.vo.CodingCommentVo;
import ims.clinical.vo.CodingCommentVoCollection;
import ims.clinical.vo.lookups.CodingCommentStatus;
import ims.clinical.vo.lookups.CodingCommentType;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open(FormMode.VIEW);
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open(FormMode.VIEW);
	}
	
	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();	
	}
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		FormMode formMode = FormMode.VIEW;
		
		if (args != null && args.length > 0 && args[0] instanceof FormMode)
		{
			formMode = (FormMode) args[0];
		}
		
		open(formMode);
	}
	
	@Override
	protected void onGrdStructuredCommentsSelectionChanged() throws PresentationLogicException
	{
		displayCommentDetails(form.grdStructuredComments().getValue());
		updateControlsState();
	}
	
	private void displayCommentDetails(CodingCommentVo value)
	{
		clearInstanceControls();
		
		if (value == null)
			return;
		
		form.lblAuthoringMosVal().setValue(value.getAuthoringMOSIsNotNull() ? value.getAuthoringMOS().getIMosName() : null);
		form.lblAuthoringDateVal().setValue(value.getAuthoringDateTimeIsNotNull() ? value.getAuthoringDateTime().toString() : null);
		form.cmbComment().setValue(value.getStructuredComment());
		form.txtCommentText().setValue(value.getCommentText());
	}
	
	private void clearInstanceControls()
	{
		form.lblAuthoringMosVal().setValue(null);
		form.lblAuthoringDateVal().setValue(null);
		form.txtCommentText().setValue(null);
		form.cmbComment().setValue(null);
	}

	private void open(FormMode mode) throws FormOpenException
	{
		if(form.getGlobalContext().RefMan.getSelectedFCE() != null)
		{
			form.getLocalContext().setFCE(domain.getFCE(form.getGlobalContext().RefMan.getSelectedFCE()));
			
			if(form.getLocalContext().getFCE() != null)
			{
				populateScreenFromData(form.getLocalContext().getFCE().getCodingComment());
			}
		}
		else if(form.getGlobalContext().RefMan.getAdmissionDetailRef() != null)
		{
			form.getLocalContext().setAdmissionForCoding(domain.getAdmissionDetail(form.getGlobalContext().RefMan.getAdmissionDetailRef()));
			
			if(form.getLocalContext().getAdmissionForCoding() != null)
			{
				populateScreenFromData(form.getLocalContext().getAdmissionForCoding().getCodingComments());
			}
		}
		
		form.setMode(mode);
		
		if(FormMode.EDIT.equals(form.getMode()))
		{
			clearInstanceControls();
			setDefaults();
		}
	}
	
	private CodingCommentVo populateCommentData()
	{		
		CodingCommentVo codingCommentVo = new CodingCommentVo();

		codingCommentVo.setAuthoringDateTime(new DateTime());
		codingCommentVo.setAuthoringMOS((MemberOfStaffLiteVo) domain.getMosUser());
		codingCommentVo.setStructuredComment(form.cmbComment().getValue());
		codingCommentVo.setCommentText(form.txtCommentText().getValue());
		codingCommentVo.setCodingType(CodingCommentType.ADMISISON);
		codingCommentVo.setCommentStatus(CodingCommentStatus.ACTIVE);

		return codingCommentVo;
	}
	
	private AdmissionDetailForCoderWorklistVo populateDataFromScreen(AdmissionDetailForCoderWorklistVo admissionDetailForCoderWorklistVo)
	{
		AdmissionDetailForCoderWorklistVo admissionToSave = null;
		
		if (admissionDetailForCoderWorklistVo == null)
			return null;
		else 
			admissionToSave  = (AdmissionDetailForCoderWorklistVo) admissionDetailForCoderWorklistVo.clone();
		
		CodingCommentVo commentVo = populateCommentData();
		
		CodingCommentVoCollection collComments = admissionToSave.getCodingComments();
		
		if (collComments == null)
			collComments = new CodingCommentVoCollection();
		
		collComments.add(commentVo);
		
		admissionToSave.setCodingComments(collComments);
		admissionToSave.setLastComment(commentVo);

		return admissionToSave;
	}
	
	private void populateScreenFromData(CodingCommentVoCollection codingComments)
	{
		form.grdStructuredComments().getRows().clear();
		
		clearInstanceControls();
		
		if (codingComments == null)
			return;
		
		codingComments.sort(SortOrder.DESCENDING);
		
		for (int i=0; i<codingComments.size();i++)
		{
			if (codingComments.get(i) == null)
				continue;
			
			if(CodingCommentStatus.SUPERCEDED.equals(codingComments.get(i).getCommentStatus()))
				continue;
			
			if(CodingCommentType.EXTERNAL.equals(codingComments.get(i).getCodingType()))
				continue;
			
			grdStructuredCommentsRow row = form.grdStructuredComments().getRows().newRow();
			row.setColAuthoringUser(codingComments.get(i).getAuthoringMOSIsNotNull() ? codingComments.get(i).getAuthoringMOS().getIMosName() : null);
			row.setCellColAuthoringUserTooltip(codingComments.get(i).getAuthoringMOSIsNotNull() ? codingComments.get(i).getAuthoringMOS().getIMosName() : "");
			row.setColAuthoringDate(codingComments.get(i).getAuthoringDateTimeIsNotNull() ? codingComments.get(i).getAuthoringDateTime().toString() : null);
			row.setCellColAuthoringDateTooltip(codingComments.get(i).getAuthoringDateTimeIsNotNull() ? codingComments.get(i).getAuthoringDateTime().toString() : "");
			row.setColComment(codingComments.get(i).getStructuredCommentIsNotNull() ? codingComments.get(i).getStructuredComment().getText() : null );
			row.setCellColCommentTooltip(codingComments.get(i).getStructuredCommentIsNotNull() ? codingComments.get(i).getStructuredComment().getText() : "");
			row.setColCommentText(codingComments.get(i).getCommentTextIsNotNull() ? codingComments.get(i).getCommentText() : null);
			row.setCellColCommentTextTooltip(codingComments.get(i).getCommentTextIsNotNull() ? codingComments.get(i).getCommentText() : "");
			
			row.setValue(codingComments.get(i));
		}	
	}
	
	private boolean save()
	{
		AdmissionDetailForCoderWorklistVo admissionToSave = null;
		ConsultantStayForPatientCodingListVo fceToSave = null;
		String[] errors = null;
		
		if(form.getGlobalContext().RefMan.getSelectedFCE() != null)
		{
			fceToSave = populateFCEWithComments(form.getLocalContext().getFCE());
			errors = fceToSave.validate(validateUiRules());
		}
		else if(form.getGlobalContext().RefMan.getAdmissionDetailRef() != null)
		{
			admissionToSave = populateDataFromScreen(form.getLocalContext().getAdmissionForCoding());
			errors = admissionToSave.validate(validateUiRules());
		}

		if (errors != null)
		{
			engine.showErrors("Coding Comment Validation Errors", errors);
			return false;
		}

		try 
		{
			if(form.getGlobalContext().RefMan.getSelectedFCE() != null && fceToSave != null)
			{
				domain.saveFCE(fceToSave);
			}
			else if(form.getGlobalContext().RefMan.getAdmissionDetailRef() != null && admissionToSave != null)
			{
				domain.saveAdmissionDetailWithCodingComment(admissionToSave);
			}
		}
		catch (StaleObjectException ex)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
		}
		
		return true;
	}
	
	private ConsultantStayForPatientCodingListVo populateFCEWithComments(ConsultantStayForPatientCodingListVo fce)
	{
		if (fce == null)
			return null;
		else 
			fce  = (ConsultantStayForPatientCodingListVo) fce.clone();
		
		CodingCommentVo commentVo = populateCommentData();
		
		CodingCommentVoCollection collComments = fce.getCodingComment();
		
		if (collComments == null)
			collComments = new CodingCommentVoCollection();
		
		collComments.add(commentVo);
		
		fce.setCodingComment(collComments);

		return fce;
	}

	private void setDefaults() 
	{
		Object user = domain.getMosUser();
		
		if (user != null)
			form.lblAuthoringMosVal().setValue(((MemberOfStaffLiteVo)user).getIMosName());
		
		form.lblAuthoringDateVal().setValue(new DateTime().toString());
	}
	
	private void updateControlsState()
	{
		if(FormMode.VIEW.equals(form.getMode()))
		{
			form.btnSuperceded().setVisible(form.grdStructuredComments().getValue() != null);		
		}
	}
	
	private String[] validateUiRules()
	{		
		if (form.txtCommentText().getValue() == null && form.cmbComment().getValue() == null)			
		{
			return new String[]{"Comment or Comment Text is mandatory."};
		}

		return null;
	}
	
	@Override
	protected void onBtnCloseClick() throws PresentationLogicException
	{		
		engine.close(DialogResult.OK);		
	}
	
	@Override
	protected void onBtnNewClick() throws PresentationLogicException
	{
		clearInstanceControls();
		setDefaults();
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onBtnSupercededClick() throws PresentationLogicException
	{
		if(saveComment(CodingCommentStatus.SUPERCEDED))
			open(FormMode.VIEW);
	}

	private boolean saveComment(CodingCommentStatus superceded) throws FormOpenException
	{
		CodingCommentVo comment = form.grdStructuredComments().getValue();
		
		if(comment == null)
			return false;
		
		comment.setCommentStatus(superceded);
		
		String[] errors = comment.validate();
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try
		{
			domain.saveComment(comment, form.getGlobalContext().RefMan.getAdmissionDetailRef());
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open(FormMode.VIEW);
			return false;
		}
		
		return true;
	}
}
