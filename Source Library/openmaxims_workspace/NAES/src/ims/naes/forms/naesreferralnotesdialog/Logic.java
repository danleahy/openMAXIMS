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
// This code was generated by Aidan Mc Donnell using IMS Development Environment (version 1.70 build 3300.22643)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.naes.forms.naesreferralnotesdialog;

import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.MemberOfStaffLiteVoCollection;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;
import ims.naes.vo.NAESReferralNoteVo;

public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;

	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		populateScreenFromData(form.getGlobalContext().Naes.getReferralNote());

	}

	private void populateScreenFromData(NAESReferralNoteVo referralNote)
	{
		clear();

		if (referralNote.getRecordingDateTimeIsNotNull())
			form.dtimRecDT().setValue(referralNote.getRecordingDateTime());
		else
			form.dtimRecDT().setValue(new DateTime());

		if (referralNote.getNoteIsNotNull())
			form.txtNote().setValue(referralNote.getNote());

		if (referralNote.getRecordingUserIsNotNull())
		{
			form.qmbRecUser().newRow(referralNote.getRecordingUser(), referralNote.getRecordingUser().getIMosName());
			form.qmbRecUser().setValue(referralNote.getRecordingUser());
		}
		else
		{
			MemberOfStaffLiteVo loggedUser = (MemberOfStaffLiteVo) domain.getMosUser();
			if (loggedUser != null)
			{
				form.qmbRecUser().newRow(loggedUser, loggedUser.getIMosName());
				form.qmbRecUser().setValue(loggedUser);
			}
		}
	}

	private void clear()
	{

		form.dtimRecDT().setValue(null);
		form.qmbRecUser().clear();
		form.txtNote().setValue(null);
	}

	protected void onQmbRecUserTextSubmitted(String value) throws ims.framework.exceptions.PresentationLogicException
	{

		populateQmbRecUser(value);

	}

	private void populateQmbRecUser(String value)
	{

		MemberOfStaffLiteVoCollection users = domain.getMos(value);

		if (users != null)
		{
			for (int i = 0; i < users.size(); i++)
			{
				form.qmbRecUser().newRow(users.get(i), users.get(i).getIMosName());
			}

			form.qmbRecUser().showOpened();
		}
	}

	protected void onBtnSaveClicked() throws ims.framework.exceptions.PresentationLogicException
	{

		NAESReferralNoteVo referralNote = populateDataFromScreen(form.getGlobalContext().Naes.getReferralNote());
		String[] errors = referralNote.validate();

		if (errors != null)
		{
			engine.showErrors(errors);
			return;
		}
		try
		{
			domain.save(referralNote);
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
		}
		catch (ForeignKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
		}

		engine.close(DialogResult.OK);

	}

	private NAESReferralNoteVo populateDataFromScreen(NAESReferralNoteVo referralNote)
	{

		referralNote.setReferral(form.getGlobalContext().Naes.getReferral().toNAESReferralRefVo());
		referralNote.setRecordingDateTime(form.dtimRecDT().getValue());
		referralNote.setNote(form.txtNote().getValue());
		referralNote.setRecordingUser(form.qmbRecUser().getValue());
		return referralNote;
	}

	protected void onBtnCancelClicked() throws PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
}
