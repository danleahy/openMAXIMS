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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.core.forms.filmtracking;

import ims.core.forms.filmtracking.GenForm.grdPacketsRow;
import ims.core.forms.filmtracking.GenForm.grdTransfersRow;
import ims.core.vo.FilmPacketVo;
import ims.core.vo.FilmPacketVoCollection;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;


public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
		open(false);
	}

	private void open(boolean bReOpen)
	{
		populatePacketsGrid(domain.listFilmPackets(form.getGlobalContext().Core.getPatientShort()),bReOpen);
	}

	private void populatePacketsGrid(FilmPacketVoCollection packetsVoColl, boolean reOpen) 
	{
		FilmPacketVo voToReopen = form.grdPackets().getValue();
		
		form.grdPackets().getRows().clear();

		for (int i = 0 ; packetsVoColl != null && i < packetsVoColl.size() ; i++)
		{
			grdPacketsRow row = form.grdPackets().getRows().newRow();
			row.setcolType(packetsVoColl.get(i).getMediaTypeIsNotNull() ? packetsVoColl.get(i).getMediaType().toString() : "");
			row.setcolHosp(packetsVoColl.get(i).getHospital());
			
			if (packetsVoColl.get(i).getTransferHistoryIsNotNull()
				&& packetsVoColl.get(i).getTransferHistory().size() > 0)
			{
				packetsVoColl.get(i).getTransferHistory().sort(SortOrder.DESCENDING);
				row.setcolLocation(packetsVoColl.get(i).getTransferHistory().get(0).getTransferLocation());
				row.setcolDate(packetsVoColl.get(i).getTransferHistory().get(0).getDateSentIsNotNull() ? packetsVoColl.get(i).getTransferHistory().get(0).getDateSent().toString() : "");
			}
			
			row.setValue(packetsVoColl.get(i));
		}
		if (voToReopen !=null)
		{
			form.grdPackets().setValue(voToReopen);
			openPacket();
		}
		updateContextMenuState();
	}

	private void initialise() 
	{
		form.getGlobalContext().Core.setFilmPacket(null);
		form.getGlobalContext().Core.setFilmPacketTransfer(null);
		
		form.grdPackets().getRows().clear();
		
		form.grdTransfers().getRows().clear();
		
		updateContextMenuState();
	}


	@Override
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		//WDEV-15286
		if (form.grdPackets().getSelectedRow() != null && form.getGlobalContext().Core.getFilmPacket() == null && formName.equals(form.getForms().Core.FilmTrackingNewMediaDialog) && result.equals(DialogResult.CANCEL))
		{
			initialise();
			open(false);
			return;
		}
		
		if (result.equals(DialogResult.CANCEL))
			return;

		if (formName.equals(form.getForms().Core.FilmTrackingNewMediaDialog))
			saveMediaPacket();
		
		if (formName.equals(form.getForms().Core.FilmTrackingTransferDialog))
			saveTransferMediaPacket();

	}
	
	private void saveTransferMediaPacket() 
	{
		FilmPacketVo voFilm = form.getGlobalContext().Core.getFilmPacket();

		if (form.getGlobalContext().Core.getFilmPacketTransfer().getID_FilmPacketTransferIsNotNull())
			voFilm.getTransferHistory().set(voFilm.getTransferHistory().indexOf(form.getGlobalContext().Core.getFilmPacketTransfer()), form.getGlobalContext().Core.getFilmPacketTransfer());
		else			
			voFilm.getTransferHistory().add(form.getGlobalContext().Core.getFilmPacketTransfer());

		String[] arrErrors = voFilm.validate();
		if(arrErrors != null)
		{
			engine.showErrors("Validation Errors", arrErrors);
			return;
		}
		
		try 
		{
			domain.saveFilmTracking(voFilm);
		} 
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(e.getMessage());
		}

		open(true);
	}

	private void saveMediaPacket() 
	{
		FilmPacketVo voFilm = form.getGlobalContext().Core.getFilmPacket();
	
		String[] arrErrors = voFilm.validate();
		if(arrErrors != null)
		{
			engine.showErrors("Validation Errors", arrErrors);
			return;
		}

		try 
		{
			domain.saveFilmTracking(voFilm);
		} 
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(e.getMessage());
		}
		
		open(true);
	}

	private void newTransferMediaPacket() 
	{
		form.getGlobalContext().Core.setFilmPacketTransfer(null);
		engine.open(form.getForms().Core.FilmTrackingTransferDialog);
	}
	
	private void newMediaPacket() 
	{
		form.getGlobalContext().Core.setFilmPacket(null);
		engine.open(form.getForms().Core.FilmTrackingNewMediaDialog);
	}
	
	private void updateContextMenuState()
	{
		form.getContextMenus().Core.hideAllFilmPacketMenuItems();
		
		form.getContextMenus().Core.getFilmPacketADD_MEDIAItem().setVisible(true);
		form.getContextMenus().Core.getFilmPacketEDIT_MEDIAItem().setVisible(form.grdPackets().getValue() != null);
		form.getContextMenus().Core.getFilmPacketTRANSFER_LOCATIONItem().setVisible(form.grdPackets().getValue() != null);
		
		form.getContextMenus().Core.hideAllFilmTransfersMenuItems();
		
		form.getContextMenus().Core.getFilmTransfersEDIT_TRANSFERItem().setVisible(form.grdTransfers().getValue() != null);
	}

	@Override
	protected void onGrdTransfersSelectionChanged()
	{
		updateContextMenuState();
	}
	@Override
	protected void onGrdPacketsSelectionChanged()
	{
		openPacket();
	}
	
	private void openPacket() 
	{
		form.grdTransfers().getRows().clear();
		FilmPacketVo voPacket = form.grdPackets().getSelectedRow().getValue();
		voPacket.getTransferHistory().sort(SortOrder.DESCENDING);

		for (int i = 0 ; voPacket != null && voPacket.getTransferHistoryIsNotNull() && i < voPacket.getTransferHistory().size() ; i++)
		{
			grdTransfersRow row = form.grdTransfers().getRows().newRow();
			row.setcolLocation(voPacket.getTransferHistory().get(i).getTransferLocation());
			row.setcolDate(voPacket.getTransferHistory().get(i).getDateSentIsNotNull() ? voPacket.getTransferHistory().get(i).getDateSent().toString() : "");
			row.setcolComment(voPacket.getTransferHistory().get(i).getComment());
			row.setcolUser(voPacket.getTransferHistory().get(i).getRecordingUserIsNotNull() && voPacket.getTransferHistory().get(i).getRecordingUser().getNameIsNotNull() ? voPacket.getTransferHistory().get(i).getRecordingUser().getName().toString() : "");
			row.setcolRecDateTime(voPacket.getTransferHistory().get(i).getRecordingDateTimeIsNotNull() ? voPacket.getTransferHistory().get(i).getRecordingDateTime().toString() : "");
			row.setValue(voPacket.getTransferHistory().get(i));
		}
		
		form.getGlobalContext().Core.setFilmPacket(voPacket);
		
		updateContextMenuState();
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.CoreNamespace.FilmPacket.ADD_MEDIA:
				newMediaPacket();
				break;
			case GenForm.ContextMenus.CoreNamespace.FilmPacket.TRANSFER_LOCATION:
				newTransferMediaPacket();
				break;
			case GenForm.ContextMenus.CoreNamespace.FilmPacket.EDIT_MEDIA:
				updateMediaPacket();
				break;
			case GenForm.ContextMenus.CoreNamespace.FilmTransfers.EDIT_TRANSFER:
				updateTransferMediaPacket();
				break;
		}
	}

	private void updateTransferMediaPacket() 
	{
		form.getGlobalContext().Core.setFilmPacketTransfer(form.grdTransfers().getValue());
		engine.open(form.getForms().Core.FilmTrackingTransferDialog);
	}

	private void updateMediaPacket() 
	{
		form.getGlobalContext().Core.setFilmPacket(form.grdPackets().getValue());
		engine.open(form.getForms().Core.FilmTrackingNewMediaDialog);
	}
}
