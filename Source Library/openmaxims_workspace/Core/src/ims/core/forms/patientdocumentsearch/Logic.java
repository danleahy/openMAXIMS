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
// This code was generated by Aidan Mc Donnell using IMS Development Environment (version 1.70 build 3434.21163)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.patientdocumentsearch;

import ims.configuration.gen.ConfigFlag;
import ims.core.forms.patientdocumentsearch.GenForm.grdDetailsRow;
import ims.core.helper.ConversionHelper;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.DocumentAndPatientWrapperVo;
import ims.core.vo.DocumentAndPatientWrapperVoCollection;
import ims.core.vo.DocumentsToBeDeletedVo;
import ims.core.vo.EpisodeofCareShortVo;
import ims.core.vo.EpisodeofCareShortVoCollection;
import ims.core.vo.PatientDocumentSearchFilterVo;
import ims.core.vo.PatientDocumentSearchListVo;
import ims.core.vo.PatientDocumentSearchListVoCollection;
import ims.core.vo.PatientDocumentVo;
import ims.core.vo.PatientForDocumentWorklistVo;
import ims.core.vo.ServerDocumentVo;
import ims.core.vo.enums.MosType;
import ims.core.vo.lookups.DocumentStatus;
import ims.core.vo.lookups.FileType;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Logic extends BaseLogic
{	
	private static final int COL_DATETIME = 0;

	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	
	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearScreen();
		updateControlState();	
	}
	
	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		search();
		updateControlState();
	}

	private void search() 
	{
		if (validateSearchCriteria(true))
		{
			saveSearchFilter();
			populatePatientDocumentsGrid(listPatientDocumentsAndDisplayNoResultError());
		}
	}
	
	private void saveSearchFilter()
	{
		form.getGlobalContext().Core.setPatientDocumentSearchFilter(populateSearchFilterDataFromScreen());
	}
	
	private void populateSearchFilterScreenFromData(PatientDocumentSearchFilterVo searchFilter)
	{
		clearSearchScreen();
		
		if (searchFilter == null)
			return;
		
		if (searchFilter.getEpisodeOfCareIsNotNull())
		{
			form.cmbEpisodes().setValue(searchFilter.getEpisodeOfCare());
		}
		
		form.cmbSpecialty().setValue(searchFilter.getSpeciality());
		form.ccMos().setValue(searchFilter.getAuthoringHCP());
		form.dteFrom().setValue(searchFilter.getDateFrom());
		form.dteTo().setValue(searchFilter.getDateTo());
		form.cmbDocStatus().setValue(searchFilter.getStatus());
		form.cmbDocType().setValue(searchFilter.getCategory());
	}
	
	private PatientDocumentSearchFilterVo populateSearchFilterDataFromScreen()
	{
		PatientDocumentSearchFilterVo searchFilter = new PatientDocumentSearchFilterVo();
		searchFilter.setEpisodeOfCare(form.cmbEpisodes().getValue());
		searchFilter.setSpeciality(form.cmbSpecialty().getValue());
		searchFilter.setAuthoringHCP(form.ccMos().getValue());
		searchFilter.setDateFrom(form.dteFrom().getValue());
		searchFilter.setDateTo(form.dteTo().getValue());
		searchFilter.setCategory(form.cmbDocType().getValue());
		searchFilter.setStatus(form.cmbDocStatus().getValue());
		
		return searchFilter;
	}
	
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender)
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.CoreNamespace.PatientDocumentSearchMenu.NEW:
				newDocument();
			break;
			
			case GenForm.ContextMenus.CoreNamespace.PatientDocumentSearchMenu.EDIT:
				editDocument();
			break;
			
			case GenForm.ContextMenus.CoreNamespace.PatientDocumentSearchMenu.VIEW:
				viewDocument();
			break;
			
			case GenForm.ContextMenus.CoreNamespace.PatientDocumentSearchMenu.WORDPATH:
				setWinWordPath();
			break;
			
			case GenForm.ContextMenus.CoreNamespace.PatientDocumentSearchMenu.CHANGE:
				changeStatus();
			break;
			
			case GenForm.ContextMenus.CoreNamespace.PatientDocumentSearchMenu.PRINT:
				print();
			break;
			
			case GenForm.ContextMenus.CoreNamespace.PatientDocumentSearchMenu.PRINTANDLOCK:
				printAndLock();
			break;
		}
	}
	
	private void printAndLock() 
	{
		if(form.getLocalContext().getSelectedDocument() == null)
			return;
		
		form.getLocalContext().getSelectedDocument().setCorrespondenceStatus(DocumentStatus.FINAL);
		
		if(savePatientDocument(form.getLocalContext().getSelectedDocument()))
		{
			open();
			
			DocumentAndPatientWrapperVoCollection documents = new DocumentAndPatientWrapperVoCollection();
			
			DocumentAndPatientWrapperVo record = new DocumentAndPatientWrapperVo();
			record.setDocument(form.getLocalContext().getSelectedDocument());
			
			PatientForDocumentWorklistVo patient = new PatientForDocumentWorklistVo(form.getGlobalContext().Core.getPatientShort().getID_Patient(), form.getGlobalContext().Core.getPatientShort().getVersion_Patient());
			patient.setName(form.getGlobalContext().Core.getPatientShort().getName());
			patient.setIdentifiers(form.getGlobalContext().Core.getPatientShort().getIdentifiers());
			record.setPatient(patient);
			
			documents.add(record);
			
			engine.open(form.getForms().Core.MultiPrintDialog, new Object[] {documents});
		}
		
		form.getLocalContext().setSelectedDocument(domain.getPatientDocument(form.getLocalContext().getSelectedDocument()));
		form.getGlobalContext().Core.setPatientCorrespondence(form.getLocalContext().getSelectedDocument());
		form.grdDetails().setValue(domain.getPatientDocumentSearchListVo(form.getLocalContext().getSelectedDocument()));
	}

	private void print() 
	{
		DocumentAndPatientWrapperVoCollection documents = new DocumentAndPatientWrapperVoCollection();
		
		DocumentAndPatientWrapperVo record = new DocumentAndPatientWrapperVo();
		record.setDocument(form.getLocalContext().getSelectedDocument());
		
		PatientForDocumentWorklistVo patient = new PatientForDocumentWorklistVo(form.getGlobalContext().Core.getPatientShort().getID_Patient(), form.getGlobalContext().Core.getPatientShort().getVersion_Patient());
		patient.setName(form.getGlobalContext().Core.getPatientShort().getName());
		patient.setIdentifiers(form.getGlobalContext().Core.getPatientShort().getIdentifiers());
		record.setPatient(patient);
		
		documents.add(record);

		engine.open(form.getForms().Core.MultiPrintDialog, new Object[] {documents});
	}

	private void changeStatus() 
	{
		engine.open(form.getForms().Core.PatientDocumentStatus);
	}

	private void setWinWordPath() 
	{
		engine.open(form.getForms().Core.LocalSettingsDialog);
	}

	private void viewDocument() 
	{
		if(form.getLocalContext().getSelectedDocumentIsNotNull())
		{
			ServerDocumentVo document = form.getLocalContext().getSelectedDocument().getServerDocument();
			if(document != null)
			{
				String fileName = document.getFileName();
				String fullPath = getPdfStorePath();
				
				if(FileType.DOC.equals(document.getFileType()))
				{
					String tempPdfFile = convertRtfToPdf(fileName);
					
					if(tempPdfFile == null)
						return;
					
					fullPath += tempPdfFile;
					form.getLocalContext().setFileToDelete(fullPath);
				}
				else if(FileType.PDF.equals(document.getFileType()))
				{
					fullPath += fileName;
				}
				
				engine.open(form.getForms().Core.PatientDocumentView, new Object[] {fullPath.replace("/", "\\")},true,true);//WDEV-18706
			}
		}
	}
	
	private String generateName()
	{	
		String str = "";
	  
		try
		{
			//Get Random Segment
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
			str += Integer.toHexString(prng.nextInt());
			while (str.length () < 8)
			{
				str = '0' + str;
	      	}
		  
			//Get CurrentTimeMillis() segment
			str += Long.toHexString(System.currentTimeMillis());
			while (str.length () < 12)
	      	{
				str = '0' + str;
	      	}
	
			//Get Random Segment
			SecureRandom secondPrng = SecureRandom.getInstance("SHA1PRNG");
			str += Integer.toHexString(secondPrng.nextInt());
			while (str.length () < 8)
			{	
				str = '0' + str;
			}
	
			//Get IdentityHash() segment
			str += Long.toHexString(System.identityHashCode((Object) this));
			while (str.length() < 8)
			{
				str = '0' + str; 
			}	  
			//Get Third Random Segment
			byte bytes[] = new byte[16]; 
			SecureRandom thirdPrng = SecureRandom.getInstance("SHA1PRNG");
			thirdPrng.nextBytes(bytes);
			str += Integer.toHexString(thirdPrng.nextInt());
			while (str.length () < 8)
			{
				str = '0' + str;
	        }
		}
		catch(java.security.NoSuchAlgorithmException ex)
		{
			ex.getMessage();
		}
		  
		return str;
	}	

	private String convertRtfToPdf(String inputFileName) 
	{
		if(inputFileName == null || inputFileName.length() == 0)
			return null;
		
		int inputFileTypesIndex = inputFileName.lastIndexOf(".");
		String inputFileType = inputFileName.substring(inputFileTypesIndex+1);
		
		inputFileTypesIndex = inputFileName.lastIndexOf("/");
		if(inputFileTypesIndex < 0)
			inputFileTypesIndex = inputFileName.lastIndexOf("\\");
		
		if(inputFileTypesIndex < 0)
			return null;
		
		String inputFilePath = inputFileName.substring(0, inputFileTypesIndex);
		String pdfFileName = inputFilePath + "/" + generateName() + ".pdf";
		String pdfPathName = (getPdfStorePath() + pdfFileName).replace("/", "\\");
		
		byte[] buffer = readFile(getPdfStorePath() + inputFileName);
		if (buffer == null || (buffer != null && buffer.length == 0)) 
			pdfFileName = null;
	
		FileOutputStream outputStream = null;
			
		try 
		{
			outputStream = new FileOutputStream(pdfPathName);
			
			ConversionHelper helper = new ConversionHelper();
			helper.convert(buffer, inputFileType, outputStream);							
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			pdfFileName = null;
		}
		finally 
		{
			if(outputStream != null)
			{
				try 
				{
					outputStream.close();
				} 
				catch (IOException e) 
				{
					
				}
			}
		}
			
		if(pdfFileName == null)
		{
			engine.showMessage("File conversion error: file cannot be converted!");
			return null;
		}
			
		return pdfFileName;
	}

	private byte[] readFile(String filePath)
	{
		File pdf = new File(filePath);
		
		if(!pdf.exists())
		{
			
		}
		
		long size = pdf.length();
		
		if (size == 0) 
		{
			return null;
		}
		
		FileInputStream fileInputStream = null;
		byte[] buffer = null;
		
		try
		{
			fileInputStream = new FileInputStream(pdf);								
			int bytesAvailable = fileInputStream.available();
			int maxBufferSize = (int) size;
			int bufferSize = Math.min(bytesAvailable, maxBufferSize);
			buffer = new byte[bufferSize];
			int bytesRead = fileInputStream.read(buffer, 0, bufferSize);
			while (bytesRead > 0)
			{					
			    bytesAvailable = fileInputStream.available();
			    bufferSize = Math.min(bytesAvailable, maxBufferSize);
			    bytesRead = fileInputStream.read(buffer, 0, bufferSize);
			}
			
		}
		catch(IOException e)
		{
			buffer = null;
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				fileInputStream.close();
			} 
			catch (IOException e) 
			{
		
			}
		}
		
		return buffer;
	}

	private void editDocument() 
	{
		if(form.getLocalContext().getSelectedDocumentIsNotNull())
		{
			ServerDocumentVo document = form.getLocalContext().getSelectedDocument().getServerDocument();
			if(document != null)
			{
				String fileName = document.getFileName();
				String filePath = (getPdfStorePath() + fileName).replace("/", "\\");
				
				if(FileType.DOC.equals(document.getFileType()))
				{
					String winPath = engine.getLocalSettings().getWordEditorPath();
					
					if(winPath == null || winPath.length() == 0)
					{
						form.getLocalContext().setTryingToEditWhitoutPath(true);
						engine.open(form.getForms().Core.LocalSettingsDialog);
						return;
					}
					
					engine.runExternalApplication(winPath + " " + filePath);
				}
			}
		}
	}
	
	private String getPdfStorePath() 
	{
		String storePath = ConfigFlag.GEN.PDF_STORE_PATH.getValue();
		
		if(!(storePath.endsWith("/") || storePath.endsWith("\\")))
			storePath = storePath + "/";
		
		return storePath;
	}

	private void newDocument() 
	{
		form.getGlobalContext().Core.setPatientCorrespondence(null);
		engine.open(form.getForms().Core.PatientCorrespondenceTemplates);
	}

	@Override
	protected void onGrdDetailsSellectionChanged() throws PresentationLogicException
	{
		if(form.grdDetails().getValue() instanceof PatientDocumentSearchListVo)
		{
			form.getLocalContext().setSelectedDocument(domain.getPatientDocument(form.grdDetails().getValue()));
			form.getGlobalContext().Core.setPatientCorrespondence(form.getLocalContext().getSelectedDocument());
		}
		
		updateControlState();
	}
	
	private void populatePatientDocumentsGrid(PatientDocumentSearchListVoCollection listPatientDocuments)
	{
		if(listPatientDocuments == null)
			return;
		
		listPatientDocuments.sort(form.getLocalContext().getDateSortOrder());
		
		form.grdDetails().getRows().clear();
		
		for (int i = 0 ; i < listPatientDocuments.size() ; i++)
		{
			newPatDocRow(listPatientDocuments.get(i));	
		}
	}
	
	private void newPatDocRow(PatientDocumentSearchListVo patientDocument)
	{
		if (patientDocument == null)
			return;
		
		grdDetailsRow newRow = form.grdDetails().getRows().newRow();
		newRow.setValue(patientDocument);
		newRow.setDate(patientDocument.getRecordingDateTimeIsNotNull() ? patientDocument.getRecordingDateTime().toString() : null);
		newRow.setSpecialty(patientDocument.getSpecialtyIsNotNull() ? patientDocument.getSpecialty().getText() : null);
		newRow.setAuthor(patientDocument.getAuthoringHCPIsNotNull() ? patientDocument.getAuthoringHCP().getIMosName() : null);
		newRow.setDocType(patientDocument.getCategoryIsNotNull() ? patientDocument.getCategory().getText() : null);
		newRow.setDocStatus(patientDocument.getCorrespondenceStatusIsNotNull() ? patientDocument.getCorrespondenceStatus().getIItemText() : null);
		newRow.setDocSource(patientDocument.getCreationTypeIsNotNull() ? patientDocument.getCreationType().getIItemText() : null);
	}
	
	private PatientDocumentSearchListVoCollection listPatientDocumentsAndDisplayNoResultError()
	{
		PatientDocumentSearchListVoCollection patDocs = domain.listPatientDocuments(
					form.getGlobalContext().Core.getPatientShort(),form.cmbEpisodes().getValue(), 
					form.cmbSpecialty().getValue(),  form.ccMos().getValue() == null ? null : (MemberOfStaffRefVo) form.ccMos().getValue(), 
					form.dteFrom().getValue(), form.dteTo().getValue(), 
					form.cmbDocType().getValue(), form.cmbDocStatus().getValue());
		
		form.getLocalContext().setDocumentsCollection(patDocs);
		
		if (patDocs == null || patDocs.size() == 0)
		{
			form.grdDetails().getRows().clear();
			form.getLocalContext().setSelectedDocument(null);
			engine.showMessage("No documents matching your search criteria were found !", "No results",MessageButtons.OK, MessageIcon.INFORMATION);
			return null;
		}
		
		return patDocs;
	}
	
	private void initialize() throws PresentationLogicException
	{
		initAuthoringQCombo();
		bindEpisodeCombo();
		
		form.getLocalContext().setDateSortOrder(SortOrder.DESCENDING);
	}
	
	private void open()
	{
		form.setMode(FormMode.VIEW);
		
		if (form.getGlobalContext().Core.getPatientDocumentSearchFilterIsNotNull())
		{
			populateSearchFilterScreenFromData(form.getGlobalContext().Core.getPatientDocumentSearchFilter());
			if (validateSearchCriteria(false))
			{
				populatePatientDocumentsGrid(listPatientDocumentsAndDisplayNoResultError());
			}
		}
		
		updateControlState();
	}
	
	private void clearSearchScreen()
	{
		form.cmbEpisodes().setValue(null);
		form.cmbSpecialty().setValue(null);
		form.ccMos().clear();
		form.dteFrom().setValue(null);
		form.dteTo().setValue(null);
		form.cmbDocType().setValue(null);
		form.cmbDocStatus().setValue(null);
	}
	
	private void bindEpisodeCombo() throws PresentationLogicException
	{
		form.cmbEpisodes().clear();
		
		EpisodeofCareShortVoCollection listEpisodesOfCare = domain.listEpisodesOfCare(form.getGlobalContext().Core.getPatientShort());
		
		for (int i = 0 ; listEpisodesOfCare != null && i < listEpisodesOfCare.size() ; i++)
		{
			EpisodeofCareShortVo eoc = listEpisodesOfCare.get(i);
			
			if (eoc != null)
			{
				form.cmbEpisodes().newRow(eoc, getTextForEOC(eoc));
			}
		}
	}
	
	private String getTextForEOC(EpisodeofCareShortVo eoc)
	{
		if (eoc == null)
			return "";
		
		StringBuilder result = new StringBuilder();
		
		result.append(eoc.createDisplayString());
		
		if (eoc.getSpecialtyIsNotNull())
		{
			result.append(" - " + eoc.getSpecialty().getText());
		}
		if (eoc.getResponsibleHCPIsNotNull())
		{
			result.append(" - " + eoc.getResponsibleHCP().getIHcpName());
		}
		
		return result.toString();
	}

	private void initAuthoringQCombo()
	{
		form.ccMos().initialize(MosType.ALL);		
	}
	
	private void clearScreen()
	{
		form.getGlobalContext().Core.setPatientDocumentSearchFilter(null);
		form.grdDetails().getRows().clear();
		form.getLocalContext().setSelectedDocument(null);
		form.getLocalContext().setDocumentsCollection(null);
		form.getLocalContext().setTryingToEditWhitoutPath(null);
		clearSearchScreen();
	}
	
	/**
	 * Validates that at least one search criteria controls contains 
	 * non-null value and if not shows an error
	 * @param showErrors TODO
	 * @return boolean true if valid false otherwise
	 */
	private boolean validateSearchCriteria(boolean showErrors)
	{
		ArrayList<String> uiErrors = new ArrayList<String>();
		
		Date dateFrom = form.dteFrom().getValue();
		Date dateTo = form.dteTo().getValue();
		if (form.ccMos().getValue() == null && form.cmbEpisodes().getValue() == null 
			&& form.cmbSpecialty().getValue() == null && dateFrom == null 
			&& dateTo == null && form.cmbDocType().getValue() == null 
			&& form.cmbDocStatus().getValue() == null)
		{
			uiErrors.add("Please fill in at least one search field");
		}
		
		
		if (dateFrom != null && dateTo != null && dateTo.isLessThan(dateFrom))
		{
			uiErrors.add("'Document Date From' cannot be greater than 'Document Date To'."); //WDEV-18762
		}
		
		if (uiErrors.size() > 0)
		{
			if (showErrors)
				engine.showErrors(uiErrors.toArray(new String[uiErrors.size()]));
			return false;
		}
		
		return true;
	}
	
	private void updateControlState()
	{	
		form.getContextMenus().Core.hideAllPatientDocumentSearchMenuMenuItems();
		form.getContextMenus().Core.getPatientDocumentSearchMenuNEWItem().setVisible(true);
		form.getContextMenus().Core.getPatientDocumentSearchMenuVIEWItem().setVisible(form.grdDetails().getValue() != null); //WDEV-18711 
		form.getContextMenus().Core.getPatientDocumentSearchMenuEDITItem().setVisible(form.grdDetails().getValue() != null && !DocumentStatus.FINAL.equals(form.getLocalContext().getSelectedDocument().getCorrespondenceStatus())); //WDEV-18711 
		form.getContextMenus().Core.getPatientDocumentSearchMenuWORDPATHItem().setVisible(true);
		form.getContextMenus().Core.getPatientDocumentSearchMenuWORDPATHItem().setEnabled(!engine.isRIEMode());//WDEV-17579
		form.getContextMenus().Core.getPatientDocumentSearchMenuCHANGEItem().setVisible(form.grdDetails().getValue() != null && !DocumentStatus.FINAL.equals(form.getLocalContext().getSelectedDocument().getCorrespondenceStatus()));// WDEV-18711 
		form.getContextMenus().Core.getPatientDocumentSearchMenuPRINTItem().setVisible(form.grdDetails().getValue() != null);//WDEV-18711
		form.getContextMenus().Core.getPatientDocumentSearchMenuPRINTANDLOCKItem().setVisible(form.grdDetails().getValue() != null && !DocumentStatus.FINAL.equals(form.getLocalContext().getSelectedDocument().getCorrespondenceStatus())); //WDEV-18711
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if(formName.equals(form.getForms().Core.LocalSettingsDialog) && DialogResult.OK.equals(result))
		{
			if(form.getLocalContext().getTryingToEditWhitoutPathIsNotNull() && form.getLocalContext().getTryingToEditWhitoutPath())
			{
				String path = engine.getLocalSettings().getWordEditorPath();
				
				if(path != null && path.length() > 0)
					editDocument();
				
				form.getLocalContext().setTryingToEditWhitoutPath(false);
			}
		}
		
		if(formName.equals(form.getForms().Core.PatientCorrespondenceTemplates) && DialogResult.OK.equals(result))
		{
			fillSearchCriteria();
			search();
			
			if(form.getGlobalContext().Core.getPatientCorrespondenceIsNotNull())
			{
				form.grdDetails().setValue(domain.getPatientDocumentSearchListVo(form.getGlobalContext().Core.getPatientCorrespondence()));
			}
			
			form.getLocalContext().setSelectedDocument(form.getGlobalContext().Core.getPatientCorrespondence());
		}
		
		if(formName.equals(form.getForms().Core.PatientDocumentView))
		{
			if(form.getLocalContext().getFileToDeleteIsNotNull())
			{
				String boClassName = null;
				Integer documentId = null;
				
				if(form.getLocalContext().getSelectedDocumentIsNotNull())
				{
					boClassName = form.getLocalContext().getSelectedDocument().getBoClassName();
					documentId = form.getLocalContext().getSelectedDocument().getID_PatientDocument();
				}
					
				deleteFile(form.getLocalContext().getFileToDelete(), boClassName, documentId);
				form.getLocalContext().setFileToDelete(null);
			}
		}
		
		if(formName.equals(form.getForms().Core.PatientDocumentStatus) && DialogResult.OK.equals(result))
		{
			if(form.getGlobalContext().Core.getPatientCorrespondenceIsNotNull())
			{
				if(savePatientDocument(form.getGlobalContext().Core.getPatientCorrespondence()))
				{
					open();
				}
				
				form.getLocalContext().setSelectedDocument(domain.getPatientDocument(form.getLocalContext().getSelectedDocument()));
				form.getGlobalContext().Core.setPatientCorrespondence(form.getLocalContext().getSelectedDocument());
				form.grdDetails().setValue(domain.getPatientDocumentSearchListVo(form.getLocalContext().getSelectedDocument()));
			}
		}
		
		updateControlState();
	}

	private boolean savePatientDocument(PatientDocumentVo patientDocument) 
	{
		if(patientDocument == null)
			return false;
		
		String boClassName = patientDocument.getBoClassName();
		Integer documentId = patientDocument.getID_PatientDocument();
		
		String rtfFileName = null;
		String pdfFileName = null;
		
		if(DocumentStatus.FINAL.equals(patientDocument.getCorrespondenceStatus()))
		{
			ServerDocumentVo document = patientDocument.getServerDocument();
			if(document != null)
			{
				rtfFileName = document.getFileName();
				
				if(isStale(patientDocument, rtfFileName))
				{
					engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
					search();
					return false;
				}
				
				pdfFileName = convertRtfToPdf(rtfFileName);
				
				if(pdfFileName == null)
					return false;
			
				document.setFileName(pdfFileName);
				document.setFileType(FileType.PDF);
			}
			
			patientDocument.setServerDocument(document);
		}
		
		String[] errors = patientDocument.validate();
		if(errors != null && errors.length > 0)
		{
			engine.showMessage("Cannot update document status.");
			deleteFile(getPdfStorePath() + pdfFileName, boClassName, documentId);
			return false;
		}
		
		try 
		{
			form.getLocalContext().setSelectedDocument(domain.savePatientDocument(patientDocument));
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			deleteFile(getPdfStorePath() + pdfFileName, boClassName, documentId);
			search();
			return false;
		}
		
		//deleteRtfFile
		if(rtfFileName != null)
		{
			deleteFile(getPdfStorePath() + rtfFileName, boClassName, documentId);
		}
		
		return true;
	}

	private boolean isStale(PatientDocumentVo patientDocument,	String rtfFileName) 
	{
		File rtfFile = new File(rtfFileName);
		
		if(!rtfFile.exists())
		{
			if(domain.isStaleObjectException(patientDocument))
				return true;
		}
		
		return false;
	}

	private void deleteFile(String fileToDelete, String boClassName, Integer documentId) 
	{
		if(fileToDelete == null || fileToDelete.length() == 0)
			return;
		
		boolean success = false;
		
		File file = new File(fileToDelete);
		
		if(file.exists())
			success = file.delete();

		if (!success)
		{
			DocumentsToBeDeletedVo deleteDocument = new DocumentsToBeDeletedVo();
			deleteDocument.setFileName(fileToDelete);
			deleteDocument.setReferenceId(documentId);
			deleteDocument.setReferenceType(boClassName);
			deleteDocument.validate();
			
			domain.saveToBeDeteled(deleteDocument);
		    System.out.println("File '" + fileToDelete + "' was not successfully deleted !");
		}
	}

	private void fillSearchCriteria() 
	{
		clearSearchScreen();
		
		form.dteFrom().setValue(new Date());
	}

	@Override
	protected void onGrdDetailsGridHeaderClicked(int column) throws PresentationLogicException 
	{
		switch(column)
		{
			case COL_DATETIME:
				if(form.getLocalContext().getDateSortOrder() == null || SortOrder.DESCENDING.equals(form.getLocalContext().getDateSortOrder()))
					form.getLocalContext().setDateSortOrder(SortOrder.ASCENDING);
				else
					form.getLocalContext().setDateSortOrder(SortOrder.DESCENDING);
			break;
		}
		
		populatePatientDocumentsGrid(form.getLocalContext().getDocumentsCollection());
		updateControlState();//WDEV-18711 
	}	
}
