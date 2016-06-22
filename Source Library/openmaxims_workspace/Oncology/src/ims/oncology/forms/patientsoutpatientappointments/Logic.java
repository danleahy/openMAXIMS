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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 4091.21781)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.oncology.forms.patientsoutpatientappointments;

import java.util.ArrayList;

import ims.core.vo.OutPatientAttendanceCCOChemoVoCollection;
import ims.core.vo.PatientApptDiaryVoCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.oncology.forms.patientsoutpatientappointments.GenForm.grdAppointmentsRow;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.dteStart().setValue(null);
		form.dteEnd().setValue(null);
		form.grdAppointments().getRows().clear();	//wdev-12819
		updateControlsState();		//wdev-12819
	}
	
	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		//WDEV-16815
		String[] errors = getUIErrors();
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return ;
		}
		
		OutPatientAttendanceCCOChemoVoCollection voColl;
		PatientApptDiaryVoCollection voDiaryColl;
		try 
		{
			voDiaryColl = domain.listPatientDiaryByPatient(form.getGlobalContext().Core.getPatientShort(), form.dteStart().getValue(), form.dteEnd().getValue());
		} 
		catch (NumberFormatException e) 
		{
			engine.showMessage(e.getMessage());
			return;
		} 
	//	catch (DomainInterfaceException e) 
	//	{
	//		engine.showMessage(e.getMessage());
	//		return;
	//	}
		
		if (voDiaryColl == null || voDiaryColl.size() == 0 )
			engine.showMessage("No Records found.");
		
		form.grdAppointments().getRows().clear();
		for (int i = 0 ; voDiaryColl != null && i < voDiaryColl.size() ; i++)
		{
			grdAppointmentsRow row = form.grdAppointments().getRows().newRow();
			row.setcolDate(voDiaryColl.get(i).getApptDateIsNotNull() ? voDiaryColl.get(i).getApptDate().toString() : "");
			row.setcolClinicName(voDiaryColl.get(i).getClinicNameIsNotNull() ? voDiaryColl.get(i).getClinicName() : "");
			row.setcolStatus(voDiaryColl.get(i).getStatus());
			row.setcolStatusDate(voDiaryColl.get(i).getStatusDateIsNotNull() ? voDiaryColl.get(i).getStatusDate().toString() : "");
			row.setcolFrom(voDiaryColl.get(i).getStartTimeIsNotNull()  ? voDiaryColl.get(i).getStartTime().toString() : "");
			row.setcolTo(voDiaryColl.get(i).getEndTimeIsNotNull() ? voDiaryColl.get(i).getEndTime().toString() : "");
			row.setcolSource(voDiaryColl.get(i).getSourceIsNotNull() ? voDiaryColl.get(i).getSource() : "");
			row.setcolApptType(voDiaryColl.get(i).getApptType());
			
			row.setValue(voDiaryColl.get(i));
		}

		updateControlsState();		//wdev-12819
	}
	
	//WDEV-16815
	private String[] getUIErrors()
	{
		ArrayList<String> errors = new ArrayList<String>();

		if (form.dteStart().getValue() == null || form.dteEnd().getValue() == null)
		{
			errors.add("Please enter both Start and End dates.");
						
		}
		
		if (form.dteStart().getValue() != null)
		{
			if (form.dteStart().getValue().isGreaterThan(form.dteEnd().getValue()))
			{
					errors.add("'Start Date' cannot be greater than 'End Date'!");
			}
			
		}
		
		if (errors.size() > 0)
		{
			String[] UIErrors = new String[errors.size()];
			errors.toArray(UIErrors);
			return UIErrors;
		}

		return null;
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Oncology.setChosenCCOOPAppointment(form.grdAppointments().getValue());
		engine.close(DialogResult.OK);
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Oncology.setChosenOPAppointment(null);
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		form.btnSave().setEnabled(false);
		form.dteStart().setValue(new Date().addDay(-14));
		form.dteEnd().setValue(new Date().addDay(14));
	}
	
	@Override
	protected void onGrdAppointmentsSelectionChanged() throws PresentationLogicException 
	{
		
		updateControlsState();		//wdev-12819
	}
	//wdev-12819
	private void updateControlsState()
	{
		form.btnSave().setEnabled(form.grdAppointments().getValue() != null);
	}
}
