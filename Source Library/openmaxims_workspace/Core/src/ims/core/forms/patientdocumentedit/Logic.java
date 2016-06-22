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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 3959.29584)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.core.forms.patientdocumentedit;

import ims.configuration.gen.ConfigFlag;
import ims.core.forms.patientdocumentedit.GenForm.GroupUpdateStatusEnumeration;
import ims.core.vo.PatientDocumentStatusVo;
import ims.core.vo.PatientDocumentVo;
import ims.core.vo.lookups.DocumentStatus;
import ims.core.vo.lookups.FileType;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.IAppUser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	private static final String CHECKOUT_FOLDER = "CheckOut"; //WDEV-13366

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		form.getGlobalContext().Core.setNewDocumentStatus(null);
	}

	private void initialize() 
	{
		int interval = ConfigFlag.GEN.SESSION_TIMEOUT.getValue();
		form.getTimers().gettimerSession().setInterval(interval - 1 > 0 ? (interval - 1) * 60 : 58);
		
		IAppUser user = engine.getLoggedInUser();
		
		if(user != null)
		{
			form.pnlUser().setValue(user.getUserRealName());
		}
		
		if(form.getGlobalContext().Core.getPatientShortIsNotNull())
		{
			form.txtPatient().setValue(form.getGlobalContext().Core.getPatientShort().getNameIsNotNull() ? form.getGlobalContext().Core.getPatientShort().getName().toString() : null);
			form.txtNhsNumber().setValue(form.getGlobalContext().Core.getPatientShort().getNhsn() != null ? form.getGlobalContext().Core.getPatientShort().getNhsn().getIdValue() : null);
		}
		
		if(form.getGlobalContext().Core.getPatientCorrespondenceIsNotNull())
		{
			form.txtDocumentName().setValue(form.getGlobalContext().Core.getPatientCorrespondence().getName());
			form.txtDocumentDate().setValue(form.getGlobalContext().Core.getPatientCorrespondence().getDocumentDate() != null ? form.getGlobalContext().Core.getPatientCorrespondence().getDocumentDate().toString() : null);
			
			//WDEV-11714
			form.intNoOfCopies().setValue(form.getGlobalContext().Core.getPatientCorrespondence().getNoOfCopies());
			form.chkEnclosure().setValue(form.getGlobalContext().Core.getPatientCorrespondence().getHasEnclosure());//WDEV-18815
			
		}
		
		if (form.getGlobalContext().Core.getPatientCorrespondenceIsNotNull() && form.getGlobalContext().Core.getPatientCorrespondence().getCurrentDocumentStatusIsNotNull())
		{
			//hideCurrentStatus(form.getGlobalContext().Core.getPatientCorrespondence().getCurrentDocumentStatus());
			form.cmbStatus().setValue(form.getGlobalContext().Core.getPatientCorrespondence().getCurrentDocumentStatus().getCorrespondenceStatus()); //WDEV-18815
		}
		
		updateControlsState();//WDEV-18815
	}
	
	//WDEV-18815
	private void updateControlsState()
	{
		PatientDocumentStatusVo currentDocumentStatus = form.getGlobalContext().Core.getPatientCorrespondence().getCurrentDocumentStatus();
		
		boolean isNotFinalDocument = form.getGlobalContext().Core.getPatientCorrespondence()!=null && !isDocumentFinal(form.getGlobalContext().Core.getPatientCorrespondence());
		
		form.GroupUpdateStatus().setEnabled(GroupUpdateStatusEnumeration.rdoComplete,isNotFinalDocument && DocumentStatus.READY_TO_SEND.equals(currentDocumentStatus.getCorrespondenceStatus()));
		form.GroupUpdateStatus().setEnabled(GroupUpdateStatusEnumeration.rdoReview, isNotFinalDocument && (DocumentStatus.DRAFT.equals(currentDocumentStatus.getCorrespondenceStatus()) || DocumentStatus.FOR_UPDATE.equals(currentDocumentStatus.getCorrespondenceStatus())));
		form.GroupUpdateStatus().setEnabled(GroupUpdateStatusEnumeration.rdoUpdate, isNotFinalDocument && (DocumentStatus.FOR_REVIEW.equals(currentDocumentStatus.getCorrespondenceStatus())));//WDEV-19039
		form.GroupUpdateStatus().setEnabled(GroupUpdateStatusEnumeration.rdoReadyToSent, isNotFinalDocument && (DocumentStatus.DRAFT.equals(currentDocumentStatus.getCorrespondenceStatus()) || DocumentStatus.FOR_UPDATE.equals(currentDocumentStatus.getCorrespondenceStatus()) || DocumentStatus.FOR_REVIEW.equals(currentDocumentStatus.getCorrespondenceStatus())));
		
		//WDEV-19277
		form.GroupUpdateStatus().setVisible(GroupUpdateStatusEnumeration.rdoComplete,isNotFinalDocument && DocumentStatus.READY_TO_SEND.equals(currentDocumentStatus.getCorrespondenceStatus()));
		form.GroupUpdateStatus().setVisible(GroupUpdateStatusEnumeration.rdoReview, isNotFinalDocument && (DocumentStatus.DRAFT.equals(currentDocumentStatus.getCorrespondenceStatus()) || DocumentStatus.FOR_UPDATE.equals(currentDocumentStatus.getCorrespondenceStatus())));
		form.GroupUpdateStatus().setVisible(GroupUpdateStatusEnumeration.rdoUpdate, isNotFinalDocument && (DocumentStatus.FOR_REVIEW.equals(currentDocumentStatus.getCorrespondenceStatus())));//WDEV-19039
		form.GroupUpdateStatus().setVisible(GroupUpdateStatusEnumeration.rdoReadyToSent, isNotFinalDocument && (DocumentStatus.DRAFT.equals(currentDocumentStatus.getCorrespondenceStatus()) || DocumentStatus.FOR_UPDATE.equals(currentDocumentStatus.getCorrespondenceStatus()) || DocumentStatus.FOR_REVIEW.equals(currentDocumentStatus.getCorrespondenceStatus())));
		
		//I've commented this lines because this buttons are not used now. Are hidden from Devenv 
		//int count = form.getGlobalContext().Core.getPatientDocumentsCollection().size();
		//int index = form.getGlobalContext().Core.getPatientDocumentsCollection().indexOf(domain.getPatientDocumentforDocumentWorklist(form.getGlobalContext().Core.getPatientCorrespondence())) + 1;

		//form.imbPrev().setEnabled(form.getGlobalContext().Core.getPatientCorrespondence() != null && form.getGlobalContext().Core.getPatientDocumentsCollection().size() >=2 && index > 1 && index <= count);
		//form.imbNext().setEnabled(form.getGlobalContext().Core.getPatientCorrespondence() != null && form.getGlobalContext().Core.getPatientDocumentsCollection().size() >=2 && index >= 1 && index < count);
		//form.btnSaveOpenNextPatient().setEnabled(form.getGlobalContext().Core.getPatientCorrespondence() != null && isNotFinalDocument && form.getGlobalContext().Core.getPatientDocumentsCollection().size() >=2 && index >= 1 && index < count);
		//form.btnDiscardAndOpenNextPatient().setEnabled(form.getGlobalContext().Core.getPatientCorrespondence() != null && isNotFinalDocument&& form.getGlobalContext().Core.getPatientDocumentsCollection().size() >=2 && index >= 1 && index < count);
		
		form.intNoOfCopies().setEnabled(isNotFinalDocument);
		form.chkEnclosure().setEnabled(isNotFinalDocument);
		
		form.btnSave().setEnabled(isNotFinalDocument);
		form.btnDiscard().setEnabled(isNotFinalDocument);
	}
	
	private void hideCurrentStatus(PatientDocumentStatusVo currentDocumentStatus) 
	{		
		if (DocumentStatus.FOR_REVIEW.equals(currentDocumentStatus.getCorrespondenceStatus()))
		{
			form.GroupUpdateStatus().setVisible(GroupUpdateStatusEnumeration.rdoReview, false);
		}
		else if (DocumentStatus.FOR_UPDATE.equals(currentDocumentStatus.getCorrespondenceStatus()))
		{
			form.GroupUpdateStatus().setVisible(GroupUpdateStatusEnumeration.rdoUpdate, false);
		}
		else if (DocumentStatus.READY_TO_SEND.equals(currentDocumentStatus.getCorrespondenceStatus()))
		{
			form.GroupUpdateStatus().setVisible(GroupUpdateStatusEnumeration.rdoReadyToSent, false);
		}		
	}

	@Override
	protected void onTimer(ims.framework.controls.Timer timer) throws ims.framework.exceptions.PresentationLogicException
	{
		if(!domain.isDocumentStillCheckedOut(form.getGlobalContext().Core.getPatientCorrespondence()))
			engine.close(DialogResult.CANCEL);
	}
	
	private void showError(String error)
	{
		if(error == null || error.length() == 0)
			return;
		
		engine.showMessage(error, "Error", MessageButtons.OK, MessageIcon.ERROR);
	}

	@Override
	protected void onBtnDiscardClick() throws PresentationLogicException 
	{
		form.getLocalContext().setDiscardDocumentChanges(engine.showMessage("Are you sure you want to Discard your changes?", "Discard Document Changes", MessageButtons.YESNO, MessageIcon.INFORMATION)); //wdev-15634	
	}
	
	private boolean undoCheckOut(PatientDocumentVo doc)
	{
		if (!validateNonFinalDocument(doc))
		{
			return false;
		}

		if(!domain.isDocumentStillCheckedOut(doc))
			return true;
		
		String fullPath = getCheckOutWorkArea() + doc.getServerDocument().getFileName();//WDEV-13366
		
		doc = domain.refreshPatDoc(doc);
		File f =  new File(fullPath);
		if (f.exists() && !deleteFile(getCheckOutWorkArea() + doc.getServerDocument().getFileName()))//WDEV-13366
		{
			showError("Could not remove document from work area.\nPlease make sure that Microsoft Word is closed\nDocument will remain checked-out");
			return false;
		}
		
		setNewStatus(); // WDEV-18675
		
		doc.setIsLockedForEditing(false);
		doc.setLockedByUser(null);
		doc.setLockedOnDateTime(null);
		doc.validate();
	
		try
		{
			form.getGlobalContext().Core.setPatientCorrespondence(domain.savePatientDocument(doc));
		}
		catch (StaleObjectException e)
		{
			showError(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return false;
		}
		
		return true;
	}
	
	private boolean validateNonFinalDocument(PatientDocumentVo selectedDocument)
	{
		if (selectedDocument == null)
			throw new CodingRuntimeException("Trying to validate null document");
		
		String[] errors = selectedDocument.validate();
		
		if (errors != null && errors.length > 0)
		{
			showError("The document is not valid. Posible data corruption");
			return false;
		}
		
		if (isDocumentFinal(selectedDocument))
		{
			throw new CodingRuntimeException("The document is not draft");
		}
		
		if (!FileType.DOC.equals(selectedDocument.getServerDocument().getFileType()))
		{
			showError("The document is not the right type. Posible data corruption");
			return false;
		}
		
		return true;
	}
	
	private boolean isDocumentFinal(PatientDocumentVo value)
	{
		if (value == null || !value.getCurrentDocumentStatusIsNotNull())
			return false;

		return DocumentStatus.COMPLETED.equals(value.getCurrentDocumentStatus().getCorrespondenceStatus()) || DocumentStatus.READY_TO_SEND.equals(value.getCurrentDocumentStatus().getCorrespondenceStatus());
	}

	@Override
	protected void onBtnSaveClick() throws PresentationLogicException 
	{
		if(checkIn(form.getGlobalContext().Core.getPatientCorrespondence()))
			engine.close(DialogResult.OK);
	}
	
	private boolean checkIn(PatientDocumentVo doc)
	{
		if (!validateNonFinalDocument(doc))
		{
			return false;
		}
		
		if(!domain.isDocumentStillCheckedOut(doc))
		{
			if (getNewStatus() != null)
			{
				showError("The document is no longer checked out by you. If you still want to change the status on discarding, then please re-select the status.");
				form.GroupUpdateStatus().setValue(null);
			}
			else
				showError("The document is no longer checked out by you.");
			form.btnSave().setEnabled(false);
			return false;
		}
		
		//WDEV-11714 - starts here
		if(form.intNoOfCopies().getValue()!=null && form.intNoOfCopies().getValue().intValue() <= 0)//WDEV-11143
		{
			showError("Number of Copies must be greater than zero.");
			return false;
		}
		String workAreaFileName = doc.getServerDocument().getFileName();
		doc = domain.refreshPatDoc(doc);
		
		doc.setNoOfCopies(form.intNoOfCopies().getValue());
		doc.setHasEnclosure(form.chkEnclosure().getValue());//WDEV-18815
		//WDEV-11714 - ends here
			
		setNewStatus(); // WDEV-18675
		
		doc.setIsLockedForEditing(false);
		doc.setLockedByUser(null);
		doc.setLockedOnDateTime(null);
		doc.validate();
		
		if (!copyToStoreArea(workAreaFileName,doc))	
			return false;
				
		if (!deleteFile(getCheckOutWorkArea() + workAreaFileName))//WDEV-13366
		{
			showError("Could not remove document from work area.\nPlease make sure that Microsoft Word is closed\nDocument will remain checked-out");
			return false;
		}
		// save
		try
		{
			form.getGlobalContext().Core.setPatientCorrespondence(domain.savePatientDocument(doc));
		}
		catch (StaleObjectException e)
		{
			showError(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return false;	
		}
		
		return true;
	}
	
	private DocumentStatus getNewStatus() 
	{
		GroupUpdateStatusEnumeration newStatus = form.GroupUpdateStatus().getValue();
		if (GroupUpdateStatusEnumeration.rdoReview.equals(newStatus))
			return DocumentStatus.FOR_REVIEW;
		if (GroupUpdateStatusEnumeration.rdoUpdate.equals(newStatus))
			return DocumentStatus.FOR_UPDATE;
		if (GroupUpdateStatusEnumeration.rdoReadyToSent.equals(newStatus))
			return DocumentStatus.READY_TO_SEND;
		
		return null;
	}

	private boolean copyToStoreArea(String workAreaFileName, PatientDocumentVo doc)
	{
		String fileName = doc.getServerDocument().getFileName();
		String destinationFilePath = (getWorkAreaPath() + fileName).replace("/", "\\");//WDEV-13366
		String sourceFilePath = (getCheckOutWorkArea() + workAreaFileName).replace("/", "\\");//WDEV-13366
		return copyFile(sourceFilePath, destinationFilePath);
	}
	
	private String getWorkAreaPath()
	{
		String storePath = ConfigFlag.GEN.MAXIMS_DOCUMENT_WORK_AREA.getValue();

		if (!(storePath.endsWith("/") || storePath.endsWith("\\")))
			storePath = storePath + "/";

		return storePath;
	}
	
	private boolean deleteFile(String fileToDelete)
	{
		File file = new File(fileToDelete);
		return file.delete();
	}
	
	//WDEV-13366
	private String getCheckOutWorkArea()
	{
		String checkOutPath = getWorkAreaPath() + CHECKOUT_FOLDER;
		
		File checkout = new File(checkOutPath);
		
		if(!checkout.exists())
			checkout.mkdirs();
		
		String newCheckOutPath = checkout.getPath();
		
		if (!(newCheckOutPath.endsWith("/") || newCheckOutPath.endsWith("\\")))
			newCheckOutPath = newCheckOutPath + "/";

		return newCheckOutPath;
	}
	
	private boolean copyFile(String sourceFilePath, String destinationFilePath)
	{
		File sourceFile = new File(sourceFilePath);
		if (!sourceFile.exists())
		{
			showError("Could not find the document on disk");
			return false;
		}
		File destinationFile = new File(destinationFilePath);
		if (!destinationFile.exists())
			try
			{
				File parentDir = destinationFile.getParentFile();
				if (!parentDir.exists())
					parentDir.mkdirs();
				destinationFile.createNewFile();
			}
			catch (IOException e)
			{
				showError("Could not create the document on disk. An I/O error occurred");
				e.printStackTrace();
				return false;
			}

		FileInputStream in = null;
		FileOutputStream out = null;

		try
		{
			in = new FileInputStream(sourceFile);
			out = new FileOutputStream(destinationFile, false);
			byte[] buffer = new byte[1024 * 64];
			int bytesRead;
			while ((bytesRead = in.read(buffer)) != -1)
			{
				out.write(buffer, 0, bytesRead);

			}

		}
		catch (FileNotFoundException e)
		{
			showError("An error occured while copying the file !");
			e.printStackTrace();
			return false;
		}
		catch (IOException e)
		{
			showError("An I/O error occured while copying the file !");
			e.printStackTrace();
			return false;
		}
		finally
		{

			try
			{
				if (in != null)
					in.close();

			}
			catch (IOException e)
			{
				// no action
			}
			try
			{
				if (out != null)
					out.close();

			}
			catch (IOException e)
			{
				// no action
			}
		}
		
		return true;
	}

	//wdev-15634
	protected void onMessageBoxClosed(int messageBoxId, DialogResult result) throws PresentationLogicException 
	{
		if (form.getLocalContext().getDiscardDocumentChangesIsNotNull() && messageBoxId == form.getLocalContext().getDiscardDocumentChanges())
		{
			form.getLocalContext().setDiscardDocumentChanges(null);
			if (result.equals(DialogResult.YES))
			{
				if(undoCheckOut(form.getGlobalContext().Core.getPatientCorrespondence()))
				{
					setNewStatus(); // WDEV-18675
					engine.close(DialogResult.ABORT);
				}
			}
			
		}
		
		//WDEV-18815
		if (form.getLocalContext().getDiscardDocumentChangesAndMoveToNextIsNotNull() && messageBoxId == form.getLocalContext().getDiscardDocumentChangesAndMoveToNext())
		{
			form.getLocalContext().setDiscardDocumentChanges(null);
			if (result.equals(DialogResult.YES))
			{
				if(undoCheckOut(form.getGlobalContext().Core.getPatientCorrespondence()))
				{
					setNewStatus(); // WDEV-18675
					move(true);
				}
			}
			
		}
		
	}

	private void setNewStatus() 
	{
		if (getNewStatus() != null && form.getGlobalContext().Core.getPatientCorrespondence() != null && form.getGlobalContext().Core.getPatientCorrespondence().getCorrespondenceStatusIsNotNull() && !form.getGlobalContext().Core.getPatientCorrespondence().getCurrentDocumentStatus().getCorrespondenceStatus().equals(getNewStatus()))
		{
			form.getGlobalContext().Core.setNewDocumentStatus(getNewStatus());;
		}		
	}

	//WDEV-18815
	@Override
	protected void onBtnDiscardAndOpenNextPatientClick() throws PresentationLogicException
	{
		
		form.getLocalContext().setDiscardDocumentChangesAndMoveToNext(engine.showMessage("Are you sure you want to Discard your changes?", "Discard Document Changes", MessageButtons.YESNO, MessageIcon.INFORMATION)); //wdev-15634
	}

	@Override
	protected void onBtnSaveOpenNextPatientClick() throws PresentationLogicException
	{
		if(checkIn(form.getGlobalContext().Core.getPatientCorrespondence()))
		{
			move(true);	
		}
	}

	@Override
	protected void onImbNextClick() throws PresentationLogicException
	{
		move(true);
	}

	@Override
	protected void onImbPrevClick() throws PresentationLogicException
	{
		move(false);
	}
	
	private void move(boolean next)
	{	
		
		int index = form.getGlobalContext().Core.getPatientDocumentsCollection().indexOf(domain.getPatientDocumentforDocumentWorklist(form.getGlobalContext().Core.getPatientCorrespondence())) + 1;
		index = index + (next ? 1 : -1);		
		form.getGlobalContext().Core.setPatientCorrespondence(domain.getPatientDocumentVo(form.getGlobalContext().Core.getPatientDocumentsCollection().get(index - 1)));
		
		form.getGlobalContext().Core.setPatientShort(domain.getPatientShort(form.getGlobalContext().Core.getPatientCorrespondence().getPatient()));
		
		initialize();
		
	}
}
