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
// This code was generated by John MacEnri using IMS Development Environment (version 1.21 build 41007.1400)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.imageadmin;

import ims.admin.vo.AppImageVo;
import ims.admin.vo.AppImageVoCollection;
import ims.assessment.vo.GraphicAssessmentShortVoCollection;
import ims.configuration.AppRight;
import ims.configuration.gen.ConfigFlag;
import ims.configuration.EnvironmentConfig;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.Control;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Image;
import ims.framework.utils.ImageInfo;
import ims.framework.utils.ImagePath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Logic extends BaseLogic
{
	// ------------------------------------------------------------------------------------------------------------------------------------------------------
	// Region - Event Handlers
	// ------------------------------------------------------------------------------------------------------------------------------------------------------

	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		// Set upload Servlet to ImageUpload
		//engine.setUploadUrl("ImageUpload");
		form.setMode(FormMode.VIEW);
		clearDetails();
		form.txtFilter().setFocus();
		form.chkActiveOnly().setValue(true);
		// wdev-11245
		form.getLocalContext().setEditdRecord(null);
		// ----------
	}

	// wdev-11245
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	// wdev-11245
	protected void onMessageBoxClosed(int messageBoxId, DialogResult result) throws PresentationLogicException
	{

		if (result.equals(DialogResult.CONFIRM))
		{
			form.setMode(FormMode.EDIT);
			clearDetails();
			form.getLocalContext().setEditdRecord(Boolean.TRUE);
			form.getLocalContext().setCurrentImage(form.grdImages().getValue());
		}

	}

	protected void onBtnFilterClick() throws PresentationLogicException
	{
		populateImageGrid();
	}

	protected void onfileupldImageFileUploaded(String fileName)
	{
		form.getLocalContext().setCurrentImage(null);
		form.getLocalContext().setselectedFilename(fileName);

		String uploadFileName = "";
		if (EnvironmentConfig.getImageServerURL() == "")
		{
			uploadFileName = EnvironmentConfig.getAplicationURL() + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + getBaseName(getBaseName(fileName));
		}
		else
		{
			uploadFileName = EnvironmentConfig.getImageServerURL() + getBaseName(getBaseName(fileName));
		}
		form.htmPreview().setHTML("<IFRAME id=\"PostFrame\" name=\"PostFrame\" width=\"100%\" height=\"100%\" frameborder=0 src='" + uploadFileName + "'></IFRAME>");
		
	}

	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		clearDetails(); 
		form.getLocalContext().setCurrentImage(new AppImageVo());
		// wdev-11245
		form.getLocalContext().setEditdRecord(null);
		// -----------

	}

	// wdev-11245
	protected void onBtnEditClick() throws PresentationLogicException
	{
		
		GraphicAssessmentShortVoCollection tempColVo = domain.getGraphicAssessmentByImage(form.grdImages().getValue());
		if (tempColVo != null && tempColVo.size() > 0)
		{
			String strAssess = new String();
			for (int i = 0; i < tempColVo.size(); i++)
			{
				strAssess += tempColVo.get(i).getName();
				// it is hardcoded because we will display maxim 4 assessment on dialog confirmation
				if (i == 4)
				{
					if (tempColVo.size() > 4)
						strAssess += "...";

					break;
				}
				else if (i < tempColVo.size() - 1)
					strAssess += ",";
			}
			engine.showMessage("This image is used in  " + tempColVo.size() + " Assessments. - " + strAssess + ".\n Please confirm if you want to edit this image ", "Confirmation", MessageButtons.CONFIRMCANCEL, MessageIcon.QUESTION);
			return;
		}

		form.setMode(FormMode.EDIT);
		clearDetails();
		form.getLocalContext().setEditdRecord(Boolean.TRUE);
		form.getLocalContext().setCurrentImage(form.grdImages().getValue());

	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		clearDetails();
		form.getLocalContext().setCurrentImage(form.grdImages().getValue()); //WDEV-13812
		populateImageGrid(); //WDEV-13812
		form.grdImages().setValue(form.getLocalContext().getCurrentImage()); //WDEV-13812
		onGrdImagesSelectionChanged();
		
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		AppImageVo image = null;

		if (form.getLocalContext().getCurrentImageIsNotNull())
		{
			image = form.getLocalContext().getCurrentImage();
		}
		else
		{
			image = new AppImageVo();
		}
		// wdev-11245
		if (form.getLocalContext().getEditdRecordIsNotNull() && form.getLocalContext().getEditdRecord().equals(Boolean.TRUE))
			image = form.grdImages().getValue();
		// --------------
		String uploadFileName = "";

		try
		{
			String imageFilename = form.getLocalContext().getselectedFilename();
			if (imageFilename == null || imageFilename.equals(""))
			{
				engine.showMessage("Image cannot be saved with no file name specified");
				form.htmPreview().setHTML("");
				return;
			}

			uploadFileName = getBaseName(imageFilename);
			if (EnvironmentConfig.getImageServerURL() == "")
			{
				image.setImagePath(ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + getBaseName(imageFilename));
			}
			else
			{
				image.setImagePath(EnvironmentConfig.getImageServerURL() + getBaseName(imageFilename));
			}

			image.setIsSystem(Boolean.FALSE);
			ImageInfo info = null;
			java.io.InputStream fileContent = null;

			if (EnvironmentConfig.getImageServerURL() != "")
			{
				if (EnvironmentConfig.getUserImagesStorePath().startsWith("/"))
				{
					String path = EnvironmentConfig.getUserImagesStorePath() + getBaseName(imageFilename);
					path.replace('\\', '/');
					fileContent = new FileInputStream(path);
					info = ImagePath.getImageInfo(fileContent);
				}
				else if (EnvironmentConfig.getUserImagesStorePath().startsWith("\\\\"))
				{
					String path = EnvironmentConfig.getUserImagesStorePath() + "\\" + getBaseName(imageFilename);
					path.replace('/', '\\');
					fileContent = new FileInputStream(path);
					info = ImagePath.getImageInfo(fileContent);
				}
				else
				{
					fileContent = new FileInputStream(EnvironmentConfig.getUserImagesStorePath() + "\\" + getBaseName(imageFilename));
					info = ImagePath.getImageInfo(fileContent);
				}
			}
			else
			{
				// UNIX env
				if (EnvironmentConfig.getBaseUri().startsWith("/"))
				{
					String path = EnvironmentConfig.getBaseUri() + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + getBaseName(imageFilename);
					path.replace('\\', '/');
					fileContent = new FileInputStream(path);
					info = ImagePath.getImageInfo(fileContent);
				}
				else
				{
					String path = EnvironmentConfig.getBaseUri() + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + getBaseName(imageFilename);
					path.replace('/', '\\');
					fileContent = new FileInputStream(path);
					info = ImagePath.getImageInfo(fileContent);
				}
			}

			if (info != null)
			{
				image.setWidth(new Integer(info.getWidth()));
				image.setHeight(new Integer(info.getHeight()));
			}

			String[] err = image.validate();

			if (err != null)
			{
				engine.showErrors(err);
				return;
			}

			image = domain.saveImage(image);
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			form.htmPreview().setHTML("");
			form.getLocalContext().setselectedFilename(null); //WDEV-13812
			return;
		}
		catch (FileNotFoundException e1)
		{
			engine.showMessage(e1.getMessage());
			form.htmPreview().setHTML("");
			return;
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			populateImageGrid();
			clearDetails();
			return;
		}

		fillDetails(image);
		populateImageGrid(image.getImagePath());
		form.txtFilter().setValue(image.getImagePath());
		form.setMode(FormMode.VIEW);
		form.getLocalContext().setselectedFilename(null); //WDEV-13812
		

		if (EnvironmentConfig.getImageServerURL() == "")
		{
			uploadFileName = EnvironmentConfig.getAplicationURL() + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + uploadFileName;
		}
		else
		{
			uploadFileName = EnvironmentConfig.getImageServerURL() + uploadFileName;
		}
		form.htmPreview().setHTML("<IFRAME id=\"PostFrame\" name=\"PostFrame\" width=\"100%\" height=\"100%\" frameborder=0 src='" + uploadFileName + "'></IFRAME>");
	}

	protected void onGrdImagesSelectionChanged()
	{
		AppImageVo image = form.grdImages().getValue();
		if (image != null)
		{
			fillDetails(image);

		}
		updateControlsState();
	}
	
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.ImageAdmin.Activate:
				toggleActiveStatus();
				break;
		}

		// WDEV-13186
		// Update the state for controls and context menus
		updateControlsState();
	}


	
	// -----------------------------------------------------------------------------------------------------------------------------------------------------
	// Form presentation functions
	// -----------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * WDEV-13186
	 * Update the state (Hidden/Visible, Enabled/Disabled)  for controls
	 */
	private void updateControlsState()
	{
		if (FormMode.VIEW.equals(form.getMode()))
		{
			// - 'Edit' button - visible only in VIEW mode if the user has right to edit images & image record selected; set as hidden from DevEnv for EDIT mode
			form.btnEdit().setVisible(form.grdImages().getValue() != null && engine.hasRight(AppRight.ALLOW_EDIT_IMAGES));
		}

		// Update the context menu after controls were updated
		updateContextMenuState();
	}

	
	/**
	 * WDEV-13186
	 * Update the context menu options state
	 * 
	 */
	private void updateContextMenuState()
	{
		// Set a reference to selected image
		AppImageVo selectedImage = form.grdImages().getValue();
		
		// - 'Activate/Inactivate' option - visible only in VIEW mode for non system images
		form.getContextMenus().getImageAdminActivateItem().setVisible(selectedImage != null && !Boolean.TRUE.equals(selectedImage.getIsSystem()));

		// Set image and text for 'Activate/Inactivate' option
		// - if the action is active then set the text to 'Deactivate' and appropriate image
		// - else (and by default when no image is selected) set the text to 'Activate' and appropriate image
		if (selectedImage != null && Boolean.TRUE.equals(selectedImage.getIsActive()))
		{
			form.getContextMenus().getImageAdminActivateItem().setIcon(form.getImages().Core.Delete);
			form.getContextMenus().getImageAdminActivateItem().setText("Deactivate");
		}
		else
		{
			form.getContextMenus().getImageAdminActivateItem().setIcon(form.getImages().Core.Tick);
			form.getContextMenus().getImageAdminActivateItem().setText("Activate");
		}
	}

	private void populateImageGrid()
	{
		populateImageGrid(null);
		
		updateControlsState();
	}

	private void populateImageGrid(String imageName)
	{
		if (imageName == null)
			imageName = form.txtFilter().getValue();

		if (imageName == null && !form.chkSiteOnly().getValue())
		{
			engine.showMessage("Search criteria must be entered.");
			return;
		}
		clearDetails();
		form.grdImages().getRows().clear();

		AppImageVo vo = new AppImageVo();
		vo.setImagePath(imageName);
		if (form.chkSiteOnly().getValue())
		{
			vo.setIsSystem(Boolean.FALSE);
		}
		if (form.chkActiveOnly().getValue())
		{
			vo.setIsActive(Boolean.TRUE);
		}
		else
		{
			vo.setIsActive(Boolean.FALSE);
		}
		AppImageVoCollection images = domain.listImages(vo);

		GenForm.grdImagesRow row = null;

		for (int i = 0; i < images.size(); i++)
		{
			AppImageVo image = images.get(i);
			row = form.grdImages().getRows().newRow();
			row.setInternalID(image.getID_AppImage());
			row.setImagePath(getBaseName(image.getImagePath()));
			row.setSystem(image.getIsSystem().booleanValue());
			row.setTooltipForImagePath(image.getImagePath());
			row.setactive(image.getIsActive().booleanValue());
			row.setValue(image);
		}
		if (form.grdImages().getRows().size() == 1)
		{
			form.grdImages().setValue(form.grdImages().getRows().get(0).getValue());
			onGrdImagesSelectionChanged();
		}
		form.lblTotal().setValue("Total : " + form.grdImages().getRows().size());
		if (form.grdImages().getRows().size() == 0)
			engine.showMessage("No records match your search criteria.");
	}

	private void fillDetails(AppImageVo image)
	{
		if (image != null)
		{
			Image img = engine.getRegisteredImage(image.getID_AppImage().intValue());
			if (img != null)
			{
				if (image.getIsSystem())
				{
					String uploadFileName = EnvironmentConfig.getAplicationURL() + img.getImagePath();
					form.htmPreview().setHTML("<IFRAME id=\"PostFrame\" name=\"PostFrame\" width=\"100%\" height=\"100%\" frameborder=0 src='" + uploadFileName + "'></IFRAME>");
				}
				else
				{
					String uploadFileName = "";
					if (EnvironmentConfig.getImageServerURL() == "")
					{
						uploadFileName = (EnvironmentConfig.getAplicationURL() + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + getBaseName(getBaseName(image.getImagePath()))).replace('\\', '/');;
					}
					else
					{
						uploadFileName = (EnvironmentConfig.getImageServerURL() + getBaseName(getBaseName(image.getImagePath()))).replace('\\', '/');;
					}

					form.htmPreview().setHTML("<IFRAME id=\"PostFrame\" name=\"PostFrame\" width=\"100%\" height=\"100%\" frameborder=0 src='" + uploadFileName + "'></IFRAME>");
				}
			}
			else
			{
				form.htmPreview().setHTML("");
			}
		}
	}

	private void clearDetails()
	{
		form.htmPreview().setHTML("");
	}

	private String getBaseName(String fullFileName)
	{
		if (fullFileName != null)
		{
			int ind = fullFileName.lastIndexOf("/");
			if (ind == -1)
			{
				ind = fullFileName.lastIndexOf("\\");
			}
			if (ind == -1)
				return fullFileName;

			if (ind + 1 == fullFileName.length())
				return "";

			return fullFileName.substring(ind + 1);
		}

		return null;
	}

	private void toggleActiveStatus()
	{
		AppImageVo vo = form.grdImages().getValue();
		int index = form.grdImages().getSelectedRowIndex();

		if (vo == null)
			return;
		if (vo.getIsActive().booleanValue())
		{
			vo.setIsActive(Boolean.FALSE);
		}
		else
		{
			vo.setIsActive(Boolean.TRUE);
		}
		try
		{
			String[] err = vo.validate();

			if (err != null)
			{
				engine.showErrors(err);
				return;
			}

			vo = domain.saveImage(vo);
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			return;
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			populateImageGrid();
			clearDetails();
			return;
		}
		engine.registerImage(vo);
		fillDetails(vo);

		if (vo != null)
			if (form.grdImages().getRows() != null)
				if (form.grdImages().getRows().get(index) != null)
				{
					form.grdImages().getRows().get(index).setValue(vo);
					form.grdImages().getRows().get(index).setactive(vo.getIsActive());
				}

		form.setMode(FormMode.VIEW);
	}
}
