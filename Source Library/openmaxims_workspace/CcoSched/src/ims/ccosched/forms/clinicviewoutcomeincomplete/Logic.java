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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.18 build 40610.1450)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.ccosched.forms.clinicviewoutcomeincomplete;

import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.PatientShort;
import ims.core.vo.PersonAddress;
import ims.dto.Result;
import ims.dto.client.Sd_activstaff;
import ims.dto.client.Sd_appt;
import ims.framework.enumerations.DialogResult;
import ims.framework.utils.Time;
import ims.framework.utils.TimeFormat;

import java.util.ArrayList;
import java.util.Calendar;

public class Logic extends BaseLogicDTO
{
	private final static String NewLine = System.getProperty("line.separator");

	protected void onFormOpen()
	{

		// load patient information
		PatientShort patient = form.getGlobalContext().Core.getPatientShort();
		form.PatientHospitalNumber().setValue(patient.getHospnum() != null ? patient.getHospnum().getValue() : "");
		form.PatientName().setValue(patient.getNameIsNotNull() ? patient.getName().getForename() + " " + patient.getName().getSurname() : "");
		form.PatientDOB().setValue(patient.getDobIsNotNull() ? patient.getDob().toString() : "");

		//WDEV-14469
		PersonAddress tempAddress = patient.getAddress();
		
		if (tempAddress != null)
		{
			StringBuffer address = new StringBuffer(200);

			if (tempAddress.getLine1IsNotNull())
			{
				address.append(tempAddress.getLine1());
				address.append(NewLine);
			}
			
			if (tempAddress.getLine2IsNotNull())
			{
				address.append(tempAddress.getLine2());
				address.append(NewLine);
			}
			
			if (tempAddress.getLine3IsNotNull())
			{
				address.append(tempAddress.getLine3());
				address.append(NewLine);
			}
			
			if (tempAddress.getLine4IsNotNull())
			{
				address.append(tempAddress.getLine4());
				address.append(NewLine);
			}

			form.PatientAddress().setValue(address.toString());
		}
		//WDEV-16929 Category is now populated
		form.PatientCategory().setValue(form.getGlobalContext().CcoSched.ClinicView.getCategoryIsNotNull() ? form.getGlobalContext().CcoSched.ClinicView.getCategory() : ""); //??????????????

		form.Comment().setValue(form.getGlobalContext().CcoSched.ClinicView.getBookingComment());

		// set default values
		Sd_appt appointments = (Sd_appt)domain.getDTOInstance(Sd_appt.class);
		appointments.Filter.clear();
		appointments.Filter.Appt_head_id = form.getGlobalContext().CcoSched.ClinicView.getAppointmentHeaderID();

		Result result = appointments.get();
		if (result != null)
		{
			engine.showMessage(result.getMessage());
			return;
		}

		String hcpseen = "";
		Sd_appt.Sd_apptRecord appointment = appointments.DataCollection.get(0);
		form.getLocalContext().setAppointments(appointments);
		//foreach (dto.Sd_apptDTO.Appt_idClient t in appointment.Appt_idCollection)
		for(int i = 0; i < appointment.Appt_idCollection.count(); i++)
		{
			Sd_appt.Sd_apptAppt_idRecord t = appointment.Appt_idCollection.get(i); 
			
			if (t.Appt_id.equalsIgnoreCase(form.getGlobalContext().CcoSched.ClinicView.getAppointmentID()))
			{
				Time Dtodt = null;
				try
				{
					Dtodt = new Time(t.Tm_seen, TimeFormat.FLAT6);
				}
				catch (Exception e)
				{
					Dtodt = null;
				}
				
				form.StartTime().setValue(Dtodt == null ? new Time() : Dtodt);
				
				Calendar dt =  appointments.Connection.getDateTime();
				if (dt != null)
				{
					form.EndTime().setValue(new Time(dt.getTime()));
				}
//				dt = Utility.GetDTOTimeFromString(t.attAct_complete_tm);
//				Form.EndTime.Value = dt.IsNull ? DateTime.Now : dt;
				
				if (t.Appt_stat.equalsIgnoreCase("-2192"))
				{
					this.setReasonLookupValue(GetIntegerFromString(t.Appt_stat_reason));
				}
				
				hcpseen = t.Hcp_seen;
			}
		}
		// HCP 
		Sd_activstaff activstaff = (Sd_activstaff)domain.getDTOInstance(Sd_activstaff.class);
		activstaff.Filter.clear();
		activstaff.Filter.Activ_id = form.getGlobalContext().CcoSched.ClinicView.getApptDetails().Activ_id;
		activstaff.Filter.Grp_id = form.getGlobalContext().CcoSched.ClinicView.getApptDetails().Grp_id;
		result = activstaff.list();
		if (result !=null)
		{
			engine.showMessage(result.getMessage());
			return;
		}
		boolean defaultvalue = false;
		//foreach (dto.Sd_activstaffDTO.Sd_activstaffClient staff in activstaff.Sd_activstaffCollection)
		for (int i = 0; i < activstaff.DataCollection.count(); i++)
		{
			Sd_activstaff.Sd_activstaffRecord staff = activstaff.DataCollection.get(i);

			if (staff.Staff_no.equalsIgnoreCase(hcpseen) && (staff.Act_ind.equalsIgnoreCase("N") || staff.Act_indstf.equalsIgnoreCase("N")))
			{
				form.HCP().newRow(staff.Staff_no, staff.Staff_name);
				form.HCP().setValue(staff.Staff_no);
				defaultvalue = true;
			}
			else if (staff.Act_ind.equalsIgnoreCase("Y") && staff.Act_indstf.equalsIgnoreCase("Y"))
				form.HCP().newRow(staff.Staff_no, staff.Staff_name);
		}
		if (!defaultvalue)
		{
			form.HCP().newRow("", "");
			form.HCP().setValue("");
		}
	}
	protected void onFormClosing(ims.framework.delegates.CancelArgs args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setAppointments(null);
	}
	protected void onCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	protected void onSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		//WDEV-16930
		String[] errors = getUIErrors();
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return ;
		}
		
		Sd_appt appointments = form.getLocalContext().getAppointments();
		Sd_appt.Sd_apptRecord appointment = appointments.DataCollection.get(0);
		//foreach (dto.Sd_apptDTO.Appt_idClient t in appointment.Appt_idCollection)
		for(int i = 0; i < appointment.Appt_idCollection.count(); i++)
		{
			Sd_appt.Sd_apptAppt_idRecord t = appointment.Appt_idCollection.get(i); 
		
			if (t.Appt_id.equalsIgnoreCase(form.getGlobalContext().CcoSched.ClinicView.getAppointmentID()))
			{
				Result result = appointments.getForUpdate();
				if (result != null)
				{
					if (result.getId() < 0)
						engine.showMessage(result.getMessage());
					else
						engine.showMessage("Data was changed.");
					return;
				}

				if (form.StartTime().getValue() != null)
				{
					t.Tm_seen = form.StartTime().getValue().toString(TimeFormat.FLAT6);
					
					if (form.EndTime().getValue() != null)					
						t.Act_complete_tm = form.EndTime().getValue().toString(TimeFormat.FLAT6);
					else
						t.Act_complete_tm = "";
					
					t.Appt_stat_reason = form.Reason().getValue() != null?Integer.toString(form.Reason().getValue().getID()):"";
					t.Appt_stat = "-2192"; //Attended
					t.Act_comp_flg = "N";
					// WDEV-14218
					// Any member of staff can make a booking
					MemberOfStaffShortVo mosVo = (MemberOfStaffShortVo) domain.getMosUser();
					if (mosVo != null)
						t.Hcp_booking1 =String.valueOf(mosVo.getIMosId());

					t.Hcp_seen = form.HCP().getValue();
	//				20/01/2004 - Set the inpatient value
					if(form.getGlobalContext().CcoSched.ClinicView.getInpatientIsNotNull())
						t.Appinpatstat = form.getGlobalContext().CcoSched.ClinicView.getInpatient();
	
					result = appointments.update();
					if (result != null)
					{
						engine.showMessage("Failed to update record.");
						engine.showMessage(result.getMessage());
						return;
					}
				}
				else
				{
					engine.showMessage("Appointment start time is mandatory! ");//WDEV-14469
					return;
				}
				break;
			}
		}	
		engine.close(DialogResult.OK);
	}
	
	//WDEV-16930
	private String[] getUIErrors()
	{
		ArrayList<String> errors = new ArrayList<String>();

		if (form.StartTime().getValue() == null)
		{
			errors.add("'Appointment Start Time' is mandatory!");
						
		}
		
		if (form.StartTime().getValue() != null)
		{
			if (form.StartTime().getValue().isGreaterThan(form.EndTime().getValue()))
			{
					errors.add("'Appointment Start Time' cannot be greater than 'Appointment End Time'!");
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
	
	private int GetIntegerFromString(String sValue)
	{
		Integer newVal = null;
		if(sValue != null && !sValue.equals(""))
		{
			try{newVal = Integer.valueOf(sValue);}
			catch(NumberFormatException e)
			{e.printStackTrace();}
		}

		return newVal != null?newVal.intValue():-1;
	}
}
