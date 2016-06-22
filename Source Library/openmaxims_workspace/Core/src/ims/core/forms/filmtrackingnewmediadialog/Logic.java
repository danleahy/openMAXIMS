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

package ims.core.forms.filmtrackingnewmediadialog;

import ims.core.vo.FilmPacketVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.utils.DateTime;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		MemberOfStaffShortVo mos = (MemberOfStaffShortVo)domain.getMosUser();
		
		//WDEV-14885
		if (mos==null)
		{
			engine.close(DialogResult.CANCEL);
			engine.showMessage("Logged In User is not Member Of Staff");	
			return;
		}
		
		form.txtRecordingUser().setValue(mos != null && mos.getNameIsNotNull() ? mos.getName().toString() : "");
		form.dtimRecDT().setValue(new DateTime());
		
		if (form.getGlobalContext().Core.getFilmPacketIsNotNull())
			populateScreenFormData(form.getGlobalContext().Core.getFilmPacket());
	}

	private void populateScreenFormData(FilmPacketVo voPacket) 
	{
		form.txtHospital().setValue(voPacket.getHospital());
		form.cmbMediaType().setValue(voPacket.getMediaType());
		form.dtimRecDT().setValue(voPacket.getRecordingDateTime());
		form.txtRecordingUser().setValue(voPacket.getRecordingUserIsNotNull() && voPacket.getRecordingUser().getNameIsNotNull() ? voPacket.getRecordingUser().getName().toString() : "");
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (validateSave())
		{
			FilmPacketVo voFilm = form.getGlobalContext().Core.getFilmPacket();
			if (voFilm == null)
				voFilm = new FilmPacketVo();
			
			voFilm.setPatient(form.getGlobalContext().Core.getPatientShort());
			voFilm.setMediaType(form.cmbMediaType().getValue());
			voFilm.setHospital(form.txtHospital().getValue());
			voFilm.setRecordingDateTime(form.dtimRecDT().getValue());
			voFilm.setRecordingUser(new MemberOfStaffLiteVo(engine.getLoggedInUser().getMosId(),0));
			
			form.getGlobalContext().Core.setFilmPacket(voFilm);
			
			engine.close(DialogResult.OK);
		}
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	private boolean validateSave() 
	{
		if (form.txtHospital().getValue() == null
			|| form.cmbMediaType().getValue() == null)
		{
			engine.showMessage("Please enter both a Hospital and a Media Type");
			return false;
		}
		return true;
	}
	
}
