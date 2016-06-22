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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.64 build 3155.28032)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.forms.atconsultationcomponent;

import java.util.Vector;
import ims.RefMan.forms.atconsultationcomponent.GenForm.grdDiagnosisRow;
import ims.RefMan.forms.atconsultationcomponent.GenForm.grdProcedureRow;
import ims.RefMan.vo.AtConsultationVo;
import ims.configuration.AppRight;
import ims.core.vo.MedicationVo;
import ims.core.vo.PatientDiagnosisAtConsultationVo;
import ims.core.vo.PatientDiagnosisAtConsultationVoCollection;
import ims.core.vo.PatientProcedureLiteVo;
import ims.core.vo.PatientProcedureLiteVoCollection;
import ims.core.vo.ProcedureLiteVo;
import ims.core.vo.ProcedureLiteVoCollection;
import ims.core.vo.ServiceShortVo;
import ims.core.vo.lookups.SourceofInformation;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override 
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		manageMenus();
	}
	
	@Override
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (formName.equals(form.getForms().Clinical.DiagnosisDialog))
		{
			if (form.getGlobalContext().Core.getPatientDiagnosisAtConsultationListIsNotNull()
				&& result.equals(DialogResult.OK))
			{
				form.getGlobalContext().Core.setPatientDiagnosisAtConsultationList(orderGridByDate(form.getGlobalContext().Core.getPatientDiagnosisAtConsultationList()));
				form.grdDiagnosis().getRows().clear();
				for (PatientDiagnosisAtConsultationVo item : form.getGlobalContext().Core.getPatientDiagnosisAtConsultationList())
				{
					grdDiagnosisRow aRow=form.grdDiagnosis().getRows().newRow();
					aRow.setcolDate(item.getDiagnosedDate());
					aRow.setcolDiagnosisReadOnly(true);
					aRow.setcolStatus(item.getCurrentStatus().getStatus().getIItemText());
					aRow.setcolDiagnosis(item.getDiagnosisDescription());
					aRow.setValue(item);
				}
				
			}
		}
		
		updateControlsState();
	}
	
	private PatientDiagnosisAtConsultationVoCollection orderGridByDate(PatientDiagnosisAtConsultationVoCollection diagnosises) 
	{
		Vector<PatientDiagnosisAtConsultationVo> v=new Vector<PatientDiagnosisAtConsultationVo>();
		for (int i=0;i<diagnosises.size();i++)
		{
			if (v.size()==0)
				v.add(diagnosises.get(i));
			else
			{
				PatientDiagnosisAtConsultationVo diagnosis = diagnosises.get(i);
				if (diagnosis.getAuthoringInfoIsNotNull()&&diagnosis.getAuthoringInfo().getAuthoringDateTimeIsNotNull())
				{
					int n=v.size();
					for (int j=0;j<n;j++)
					{
						if (v.get(j).getAuthoringInfoIsNotNull()&&v.get(j).getAuthoringInfo().getAuthoringDateTimeIsNotNull())
						{
							if (diagnosis.getAuthoringInfo().getAuthoringDateTime().compareTo(v.get(j).getAuthoringInfo().getAuthoringDateTime())<0)
								v.add(j, diagnosis);
							else
								v.add(diagnosis);
						}
					}
				}
			}
		}
		diagnosises.clear();
		for (int x=0;x<v.size();x++)
		{
			diagnosises.add(v.get(x));
		}
		return diagnosises;
	}

	@Override
	protected void onGrdProcedureSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		boolean bEnable = true;
		if (domain.getHcpLiteUser() == null)
			bEnable = false;

		form.getContextMenus().getProcedureCANCELItem().setVisible(form.getMode().equals(FormMode.EDIT) && bEnable);
		form.getContextMenus().getProcedureCANCELItem().setEnabled(form.getMode().equals(FormMode.EDIT) && bEnable);
		form.getContextMenus().getProcedureCANCELItem().setText("Remove");
	}
//	@Override
//	protected void onGrdDiagnosisSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
//	{
//		form.getContextMenus().getDiagnosisHotListRemoveItem().setVisible(true);
//		form.getContextMenus().getDiagnosisHotListRemoveItem().setEnabled(true);
//	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.DiagnosisHotList.AddDiagnosis:
				addDiagnosis();
			break;
			case GenForm.ContextMenus.DiagnosisHotList.Remove:
				removeDiagnosis();
			break;
			case GenForm.ContextMenus.DiagnosisHotList.EDIT:
				editDiagnosis();
			break;
	
			case GenForm.ContextMenus.Procedure.ADD:
				addProcedure();
			break;
			case GenForm.ContextMenus.Procedure.CANCEL:
				removeProcedure();
			break;				
	
			default :
		}
		
		updateControlsState();
	}

	private void updateControlsState()
	{
		form.getContextMenus().getDiagnosisHotListEDITItem().setVisible(form.getMode().equals(FormMode.EDIT) && form.grdDiagnosis().getValue() != null);				
	}

	private void editDiagnosis()
	{
		//PatientDiagnosisAtConsultationVoCollection diagList=form.grdDiagnosis().getValues();
		//form.getGlobalContext().Core.setPatientDiagnosisAtConsultationList(diagList);
		if (form.grdDiagnosis().getSelectedRow().getValue()!=null)
		{
			form.getGlobalContext().Core.setPatientDiagnosisAtConsultation(form.grdDiagnosis().getSelectedRow().getValue());
			engine.open(form.getForms().Clinical.DiagnosisDialog);
		}
	}
	
	private void removeProcedure() 
	{
		form.grdProcedure().getRows().remove(form.grdProcedure().getSelectedRowIndex());
		
		form.getContextMenus().getProcedureCANCELItem().setVisible(false);
		form.getContextMenus().getProcedureCANCELItem().setEnabled(false);
	}
	
	private void addProcedure() 
	{
		form.grdProcedure().getRows().newRow();
	}
	
	private void removeDiagnosis() 
	{
		form.grdDiagnosis().getRows().remove(form.grdDiagnosis().getSelectedRowIndex());
		
		form.getContextMenus().getDiagnosisHotListRemoveItem().setVisible(false);
		form.getContextMenus().getDiagnosisHotListRemoveItem().setEnabled(false);
	}
	
	private void addDiagnosis() 
	{
		form.getGlobalContext().Core.setPatientDiagnosisAtConsultation(null);
		engine.open(form.getForms().Clinical.DiagnosisDialog);
	}

	
	private AtConsultationVo populateDataFromScreen() 
	{
		AtConsultationVo voAtConsult=null;
		if (!anyDataToSave())
			return null;
		if (form.getLocalContext().getSelectedRecordIsNotNull())
			voAtConsult = (AtConsultationVo) form.getLocalContext().getSelectedRecord().clone();
		else
			voAtConsult = (AtConsultationVo) form.getLocalContext().getSelectedRecord();
		if (voAtConsult == null)
			voAtConsult = new AtConsultationVo();
		
		if (voAtConsult.getCatsReferral() == null)
			voAtConsult.setCatsReferral(form.getGlobalContext().RefMan.getCatsReferral());

		voAtConsult.setAuthoringInformation(form.customControlAuthoring().getValue());
		
		if (form.chkTreatment().getValue())
			voAtConsult.setFirstDefinitiveTreatmentDate(new ims.framework.utils.Date());
		else
		{
			voAtConsult.setFirstDefinitiveTreatmentDate(null);
			form.txtTreatment().setVisible(false);
		}
		
		//--------------------------------------- DIAGNOSES -------------------------------------------
		if (voAtConsult.getDiagnosisIsNotNull())
			voAtConsult.setDiagnosis(new PatientDiagnosisAtConsultationVoCollection());//dont need to handle inactive records, so can clear vocollection
		
		for ( int i = 0 ; i < form.grdDiagnosis().getRows().size() ; i++)
		{
			grdDiagnosisRow row = form.grdDiagnosis().getRows().get(i);
			
			if (row.getcolDiagnosis()!= null)
			{
				if ( voAtConsult.getDiagnosis() == null)
					voAtConsult.setDiagnosis(new PatientDiagnosisAtConsultationVoCollection());

				voAtConsult.getDiagnosis().add(row.getValue());
	/*			if (row.getValue() == null)
				{
					
				//	PatientDiagnosisAtConsultationVo voNew = new PatientDiagnosisAtConsultationVo();
				//	voNew.setDiagnosis((DiagLiteVo)row.getValue().getDiagnosis());
				//	voNew.setDiagnosisDescription(row.getValue().getDiagnosisDescription());
					
				//	PatientDiagnosisStatusVo voStat = new PatientDiagnosisStatusVo();
				//	voStat.setAuthoringDateTime(form.customControlAuthoring().getValue().getAuthoringDateTime());
				//	voStat.setAuthoringHCP(form.customControlAuthoring().getValue().getAuthoringHcp());
				//	voStat.setStatus((DiagnosisStatus)row.getValue().getCurrentStatus().getStatus());
				//	voNew.setCurrentStatus(voStat);
				//	voNew.setSourceofInformation(SourceofInformation.CLINICALCONTACT);
						
					voAtConsult.getDiagnosis().add(voNew);
				}
				else if (row.getValue() != null)
				{
					PatientDiagnosisAtConsultationVo voUpdate = row.getValue();
					//voUpdate.setSourceofInformation(SourceofInformation.CLINICALCONTACT);
//					voUpdate.setDiagnosis((DiagLiteVo)row.getValue().getDiagnosis());
//					voUpdate.setDiagnosisDescription(row.getValue().getDiagnosisDescription());
//					
//					PatientDiagnosisStatusVo voStat = voUpdate.getCurrentStatus();
//					voStat.setStatus((DiagnosisStatus)row.getValue().getCurrentStatus().getStatus());
//					
//					voUpdate.setCurrentStatus(voStat);

					voAtConsult.getDiagnosis().add(voUpdate);
				}
				*/
			}
		}
	
		
		//--------------------------------------- PROCEDURES -------------------------------------------
		if (voAtConsult.getProceduresIsNotNull())
			voAtConsult.setProcedures(new PatientProcedureLiteVoCollection());//dont need to handle inactive records, so can clear vocollection
		for ( int i = 0 ; i < form.grdProcedure().getRows().size() ; i++)
		{
			grdProcedureRow row = form.grdProcedure().getRows().get(i);
			
			if (row.getcolProcedure().getValue() != null || row.getcolDate()!=null)
			{
				if ( voAtConsult.getProcedures() == null)
					voAtConsult.setProcedures(new PatientProcedureLiteVoCollection());
					
				if (row.getValue() == null)
				{
					PatientProcedureLiteVo voNew = new PatientProcedureLiteVo();

					voNew.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
					voNew.setEpisodeOfCare(form.getGlobalContext().Core.getEpisodeofCareShort());
					
					voNew.setProcedure((ProcedureLiteVo)row.getcolProcedure().getValue());
					voNew.setProcDate(row.getcolDate());
					voNew.setProcedureDescription(row.getcolProcedure().getEditedText());
					voNew.setInfoSource(SourceofInformation.CLINICALCONTACT);
						
					voAtConsult.getProcedures().add(voNew);
				}
				else if (row.getValue() != null)
				{
					PatientProcedureLiteVo voUpdate = row.getValue();
					voUpdate.setProcedure((ProcedureLiteVo)row.getcolProcedure().getValue());
					voUpdate.setProcDate(row.getcolDate());
					voUpdate.setProcedureDescription(row.getcolProcedure().getEditedText());
					
					voAtConsult.getProcedures().add(voUpdate);
				}
			}
		}	
			
		return voAtConsult;
	}

	private void clearScreen() 
	{
		form.customControlAuthoring().setValue(null);
		form.grdDiagnosis().getRows().clear();
		form.grdProcedure().getRows().clear();
		form.txtTreatment().setVisible(false);
	}
	
	private void populateScreenFromData(AtConsultationVo voAtConsult) 
	{
		clearScreen();
		
		if (voAtConsult == null)
		{						
			return;
		}
			
		form.customControlAuthoring().setValue(voAtConsult.getAuthoringInformation());
		form.chkTreatment().setValue(voAtConsult.getFirstDefinitiveTreatmentDateIsNotNull());
		if (voAtConsult.getFirstDefinitiveTreatmentDateIsNotNull())
		{
			form.txtTreatment().setVisible(true);
			form.txtTreatment().setEnabled(false);
			form.txtTreatment().setValue(voAtConsult.getFirstDefinitiveTreatmentDate().toString());
		}
		else 
			form.txtTreatment().setVisible(false);
			
	
		//--------------------------------------- DIAGNOSES -------------------------------------------
		for ( int i = 0 ; voAtConsult.getDiagnosisIsNotNull() && i < voAtConsult.getDiagnosis().size() ; i++)
		{
			grdDiagnosisRow row = form.grdDiagnosis().getRows().newRow();
			
			row.setValue(voAtConsult.getDiagnosis().get(i));
			
			row.setcolDiagnosis(voAtConsult.getDiagnosis().get(i).getDiagnosisDescription());
			row.setcolDate(voAtConsult.getDiagnosis().get(i).getDiagnosedDateIsNotNull() ? voAtConsult.getDiagnosis().get(i).getDiagnosedDate() : null);
			row.setcolStatus(voAtConsult.getDiagnosis().get(i).getCurrentStatus().getStatus().getIItemText());
		}
			
		//--------------------------------------- PROCEDURES -------------------------------------------
		for ( int i = 0 ; voAtConsult.getProceduresIsNotNull() && i < voAtConsult.getProcedures().size() ; i++)
		{
			grdProcedureRow row = form.grdProcedure().getRows().newRow();
			
			row.setValue(voAtConsult.getProcedures().get(i));

			if (voAtConsult.getProcedures().get(i).getProcedureIsNotNull())
				row.getcolProcedure().newRow(voAtConsult.getProcedures().get(i).getProcedure(), voAtConsult.getProcedures().get(i).getProcedure().getProcedureName());
			
			row.setcolDate(voAtConsult.getProcedures().get(i).getProcDateIsNotNull() ? voAtConsult.getProcedures().get(i).getProcDate() : null);
			row.getcolProcedure().setValue(voAtConsult.getProcedures().get(i).getProcedure());
		}
			
		form.getLocalContext().setSelectedRecord(voAtConsult);
		
		if (form.getMode().equals(FormMode.EDIT) && voAtConsult.getID_AtConsultationIsNotNull())
		{
			form.customControlAuthoring().setEnabledAuthoringHCP(false);
			form.customControlAuthoring().setEnabledDateTime(false);
		}

	}
		
	public Boolean initialize()
	{
		if (form.getMode().equals(FormMode.EDIT))
			return false;

		clearScreen();
		form.setMode(FormMode.VIEW);
	
		form.customControlAuthoring().setIsRequiredPropertyToControls(true);

		//form.getLocalContext().setDefaultMedication();
		
		open();
		
		if (domain.getHcpLiteUser() == null && !engine.hasRight(AppRight.ALLOW_EDIT_CONSULTATION_DIAGNOSIS))
		{
			engine.showMessage("Logged in user is not a HCP.");
			form.btnEdit().setVisible(false);
			form.setMode(FormMode.VIEW);
			return false;
		}

		manageMenus();
		
		return true;
	}

	private void open() 
	{
		AtConsultationVo vo = domain.getConsultation(form.getGlobalContext().RefMan.getCatsReferral());
		populateScreenFromData(vo != null ? (AtConsultationVo)vo.clone() : null);
		form.getGlobalContext().Core.setPatientDiagnosisAtConsultationList(form.grdDiagnosis().getValues());
		
		//wdev-6163
		if(form.getGlobalContext().RefMan.getIsProviderCancellationIsNotNull()
			&& 	form.getGlobalContext().RefMan.getIsProviderCancellation())
		{
			form.setMode(FormMode.VIEW);
			form.btnEdit().setVisible(false);
		}

	}

	private void manageMenus() 
	{
		form.getContextMenus().hideAllDiagnosisHotListMenuItems();		
		form.getContextMenus().hideAllProcedureMenuItems();
		if (form.getMode().equals(FormMode.EDIT))
		{
			form.customControlAuthoring().setEnabledAuthoringHCP(true);
			form.customControlAuthoring().setEnabledDateTime(true);
	
			form.getContextMenus().getDiagnosisHotListAddDiagnosisItem().setVisible(true);
			form.getContextMenus().getDiagnosisHotListAddDiagnosisItem().setEnabled(true);

			if (form.grdDiagnosis().getSelectedRow() != null
				&& form.grdDiagnosis().getSelectedRow().getValue()!=null)
			{
				form.getContextMenus().getDiagnosisHotListEDITItem().setVisible(true);
				form.getContextMenus().getDiagnosisHotListEDITItem().setEnabled(true);
			}
			else
			{
				form.getContextMenus().getDiagnosisHotListEDITItem().setVisible(false);
				form.getContextMenus().getDiagnosisHotListEDITItem().setEnabled(false);
			}
	
			form.getContextMenus().getProcedureADDItem().setVisible(true);
			form.getContextMenus().getProcedureADDItem().setEnabled(true);
			
			if (domain.getHcpLiteUser() == null)
			{
				form.getContextMenus().hideAllDiagnosisHotListMenuItems();

				if (form.grdDiagnosis().getSelectedRow() != null
					&& form.grdDiagnosis().getSelectedRow().getValue()!=null
					&& engine.hasRight(AppRight.ALLOW_EDIT_CONSULTATION_DIAGNOSIS)
					&& ( ((PatientDiagnosisAtConsultationVo)form.grdDiagnosis().getSelectedRow().getValue()).getDiagnosis() == null
						|| ( ((PatientDiagnosisAtConsultationVo)form.grdDiagnosis().getSelectedRow().getValue()).getDiagnosisIsNotNull()
							&& ((PatientDiagnosisAtConsultationVo)form.grdDiagnosis().getSelectedRow().getValue()).getDiagnosis().getID_DiagnosisIsNotNull()
							&& ((PatientDiagnosisAtConsultationVo)form.grdDiagnosis().getSelectedRow().getValue()).getDiagnosis().getID_Diagnosis() == -1)) )
				{
					form.getContextMenus().getDiagnosisHotListEDITItem().setVisible(true);
					form.getContextMenus().getDiagnosisHotListEDITItem().setEnabled(true);
				}
				
				form.getContextMenus().getDiagnosisHotListAddDiagnosisItem().setVisible(false);
				form.getContextMenus().getDiagnosisHotListAddDiagnosisItem().setEnabled(false);

				form.customControlAuthoring().setEnabledAuthoringHCP(false);
				form.customControlAuthoring().setEnabledDateTime(false);

				form.getContextMenus().hideAllProcedureMenuItems();			
			}
		}
		else
		{
			form.getContextMenus().getDiagnosisHotListEDITItem().setVisible(false);
			form.getContextMenus().getDiagnosisHotListEDITItem().setEnabled(false);
			form.getContextMenus().getDiagnosisHotListAddDiagnosisItem().setVisible(false);
			form.getContextMenus().getDiagnosisHotListAddDiagnosisItem().setEnabled(false);
			
		}
	}
	
	@Override
	protected void onGrdProcedureGridQueryComboBoxTextSubmited(int column, grdProcedureRow row, String text) throws PresentationLogicException 
	{
		ServiceShortVo voServ;
		if (form.getLocalContext().getCurrentService() == null)
		{
			voServ = domain.getCatsReferralService(form.getGlobalContext().RefMan.getCatsReferral());
			form.getLocalContext().setCurrentService(voServ);
		}
		else
			voServ = form.getLocalContext().getCurrentService();
		
		row.getcolProcedure().clear();
		ProcedureLiteVoCollection voColl = null;
		try 
		{
			voColl = domain.listHotlistProcedureShort(text, voServ.getSpecialty());
		} 
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			return;
		}
	
		for (int i = 0 ; voColl != null && i < voColl.size() ;i++)
			row.getcolProcedure().newRow(voColl.get(i), voColl.get(i).getProcedureName());

		if (voColl == null || voColl.size() == 0)
		{
			engine.showMessage("No Procedures found for you search criteria.", "No Data Found", MessageButtons.OK, MessageIcon.INFORMATION);
			return;
		}
		
		if (voColl.size() == 1)
			row.getcolProcedure().setValue(voColl.get(0));
		else if (voColl.size() > 1)
			row.getcolProcedure().showOpened();
	}

	/*@Override
	protected void onGrdDiagnosisGridQueryComboBoxTextSubmited(int column, grdDiagnosisRow row, String text) throws PresentationLogicException 
	{
		DiagLiteVoCollection voColl;
		try 
		{
			voColl = domain.listActiveDiagnosis(text);
		} 
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.toString());
			return;
		}
		
		for (int i = 0 ; i < voColl.size() ; i++)
		{
			row.getcolDiagnosis().newRow(voColl.get(i), voColl.get(i).getDiagnosisName());
		}

		if (voColl.size() == 1)
		{
			row.getcolDiagnosis().setValue(voColl.get(0));
		}
		else
			row.getcolDiagnosis().showOpened();
	}
*/
	public Boolean anyDataToSave() 
	{
		if (form.grdDiagnosis().getRows().size() == 0			
			&& form.grdProcedure().getRows().size() == 0
			&& form.customControlAuthoring().getValue() == null)
			return false;
		else
			return true;
	}

	@Override
	protected void onBtnCancelClick() throws PresentationLogicException 
	{
		populateScreenFromData(form.getLocalContext().getSelectedRecord());
		form.setMode(FormMode.VIEW);
		form.btnEdit().setVisible(true);

		//wdev-6218
		if(form.getLocalContext().getSelectedRecordIsNotNull()
			&& form.getLocalContext().getSelectedRecord().getID_AtConsultation() == null)
				form.getLocalContext().setSelectedRecord(null);

		fireOnFormModeChange(FormMode.VIEW);
	}

	@Override
	protected void onBtnSaveClick() throws PresentationLogicException 
	{
		AtConsultationVo voAtCons = form.getLocalContext().getSelectedRecord();
		if (voAtCons == null)
			voAtCons = new AtConsultationVo();
			
		voAtCons.setDiagnosis(form.getGlobalContext().Core.getPatientDiagnosisAtConsultationList());
	
		voAtCons = populateDataFromScreen();
		
		try		
		{
			if(voAtCons.getMedications() != null)
			{
				for(int x = 0; x < voAtCons.getMedications().size(); x++)
				{
					if(voAtCons.getMedications().get(x).getMedication() != null && voAtCons.getMedications().get(x).getMedication() instanceof MedicationVo)
					{
						String[] medicationErrors = voAtCons.getMedications().get(x).getMedication().validate();
						if(medicationErrors != null && medicationErrors.length > 0)
						{
							engine.showErrors("Medication Error", medicationErrors);			
							return;
						}
						voAtCons.getMedications().get(x).setMedication(domain.createOrUpdateMedication((MedicationVo)voAtCons.getMedications().get(x).getMedication()));
					}
				}
			}
		}
		catch (StaleObjectException e) 
		{
			engine.showMessage("Unable to save the medication: " + e.toString());			
			return;
		}

		String[] str = voAtCons.validate();
		if (str != null && str.length > 0)
		{
			engine.showErrors(str);		
			return;
		}
		
		try 
		{
			form.getLocalContext().setSelectedRecord(domain.saveAtConsultation(voAtCons));
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(e.toString());			
			return;
		}

		form.getLocalContext().getSelectedRecord();
		populateScreenFromData(voAtCons);
		
		form.setMode(FormMode.VIEW);
		form.btnEdit().setVisible(true);

		if (voAtCons.getFirstDefinitiveTreatmentDate()!=null)
			form.txtTreatment().setVisible(true);
		fireOnFormModeChange(FormMode.VIEW);
	}

	@Override
	protected void onBtnEditClick() throws PresentationLogicException 
	{
		open();
		form.setMode(FormMode.EDIT);
		form.txtTreatment().setVisible(false);

		if( form.getLocalContext().getSelectedRecord() == null)
			form.customControlAuthoring().initializeComponent();
		
		fireOnFormModeChange(FormMode.EDIT);
	}

	private void fireOnFormModeChange(FormMode mode)
	{
		form.getGlobalContext().RefMan.setIsComponentInEditMode(mode);
		form.fireCustomControlValueChanged();
	}
	
	@Override
	protected void onFormModeChanged() 
	{
		manageMenus();

		updateControlsState();

		if (form.getMode().equals(FormMode.EDIT))
		{	
			if( form.getLocalContext().getSelectedRecordIsNotNull())
			{
				form.customControlAuthoring().setEnabledAuthoringHCP(Boolean.FALSE);
				form.customControlAuthoring().setEnabledDateTime(Boolean.FALSE);
				form.customControlAuthoring().setMode(FormMode.VIEW);
			}
			else
			{
				form.customControlAuthoring().setEnabledAuthoringHCP(Boolean.TRUE);
				form.customControlAuthoring().setEnabledDateTime(Boolean.TRUE);
				form.customControlAuthoring().setMode(FormMode.EDIT);
			}
			boolean bEnable = true;
			if (domain.getHcpLiteUser() == null)
				bEnable = false;
			
			form.chkTreatment().setEnabled(bEnable);
			form.txtTreatment().setEnabled(bEnable);
			form.grdProcedure().setReadOnly(!bEnable);			
		}
		
	}

	@Override
	protected void onGrdDiagnosisSelectionChanged() throws PresentationLogicException
	{
		if (form.grdDiagnosis().getSelectedRow().getValue()!=null)
		{
			form.getGlobalContext().Core.setPatientDiagnosisAtConsultation(form.grdDiagnosis().getSelectedRow().getValue());
			form.getGlobalContext().Core.getPatientDiagnosisAtConsultationList();
			manageMenus();
		}
	}					
}
