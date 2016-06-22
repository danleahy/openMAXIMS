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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.18 build 40526.1800)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.ccosched.forms.relaitedappointments;
import ims.dto.Result;
import ims.dto.client.Sd_appt_dts;
import ims.framework.enumerations.DialogResult;
import ims.framework.utils.Date;
import ims.framework.utils.DateFormat;

import java.text.ParseException;
import java.util.ArrayList;

public class Logic extends BaseLogicDTO
{
	protected void onFormOpen()
	{
		form.Ok().setEnabled(false);
		Sd_appt_dts appointments = (Sd_appt_dts)domain.getDTOInstance(Sd_appt_dts.class);
		appointments.Filter.clear();
		appointments.Filter.Pkey = form.getGlobalContext().Core.getPatientShort().getPkey().getValue();

		Result result = appointments.list();
		if (result != null)
		{
			engine.showMessage(result.getMessage());
			return;
		}

		ArrayList a = new ArrayList();

		for(int i=0; i<appointments.DataCollection.count(); i++)
		{
			Sd_appt_dts.Sd_appt_dtsRecord appointment = appointments.DataCollection.get(i);
			if (!a.contains(appointment.Appt_head_id))
			{
				a.add(appointment.Appt_head_id);
				GenForm.MainGridRow row = form.MainGrid().getRows().newRow();
				Date Dtodt = null;
				if (appointment.Sess_dt != null && appointment.Sess_dt.equals("") == false)				
					try{Dtodt = new Date(appointment.Sess_dt, DateFormat.ISO);}catch(ParseException e){e.printStackTrace();}
				row.setDate(Dtodt == null?"" : Dtodt.toString(DateFormat.STANDARD));
				row.setActivity(appointment.Activitytxt);
				row.setAction(appointment.Action_idtxt);
				row.setValue(appointment);
			}
		}
	}
	protected void OnCancel()
	{
		form.getGlobalContext().CcoSched.RelaitedAppointments.setRelaitedAppointments(null);
		engine.close(DialogResult.CANCEL);
	}
	protected void OnOk()
	{
		form.getGlobalContext().CcoSched.RelaitedAppointments.setRelaitedAppointments((Sd_appt_dts.Sd_appt_dtsRecord)form.MainGrid().getValue());
		engine.close(DialogResult.OK);
	}
	protected void OnSelect()
	{
		form.Ok().setEnabled(true);
	}
}
