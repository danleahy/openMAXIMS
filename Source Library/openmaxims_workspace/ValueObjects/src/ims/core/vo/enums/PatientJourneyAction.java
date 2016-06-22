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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.vo.enums;

public final class PatientJourneyAction extends ims.framework.utils.Enum
{
	public final static PatientJourneyAction CREATENEWPATHWAY = new PatientJourneyAction(0, "CreateNewPathway", null, ims.framework.utils.Color.Default);
	public final static PatientJourneyAction CREATENEWEVENT = new PatientJourneyAction(1, "CreateNewEvent", null, ims.framework.utils.Color.Default);
	public final static PatientJourneyAction ADDEVENTTOTARGET = new PatientJourneyAction(2, "AddEventToTarget", null, ims.framework.utils.Color.Default);
	public final static PatientJourneyAction VIEWCLOCKHISTORY = new PatientJourneyAction(3, "VIEWCLOCKHISTORY", null, ims.framework.utils.Color.Default);
	public final static PatientJourneyAction ADDREADJUSTMENT = new PatientJourneyAction(4, "AddReadjustment", null, ims.framework.utils.Color.Default);
	public final static PatientJourneyAction EDITREADJUSTMENT = new PatientJourneyAction(5, "EditReadjustment", null, ims.framework.utils.Color.Default);
	public final static PatientJourneyAction ADDPATHWAYCOMMENT = new PatientJourneyAction(6, "Add Pathway Comment", null, ims.framework.utils.Color.Default);
	public final static PatientJourneyAction ADDEVENTCOMMENT = new PatientJourneyAction(7, "Add Event Comment", null, ims.framework.utils.Color.Default);
	public final static PatientJourneyAction ADDTARGETCOMMENT = new PatientJourneyAction(8, "Add Target Comment", null, ims.framework.utils.Color.Default);
	public final static PatientJourneyAction RECORDBREACHREASON = new PatientJourneyAction(9, "Record Breach Reason", null, ims.framework.utils.Color.Default);
	public final static PatientJourneyAction REMOVETARGETFROMSCOPE = new PatientJourneyAction(10, "Remove Target From Scope", null, ims.framework.utils.Color.Default);

	private PatientJourneyAction(int id, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
	{
		super(id, text, image, textColor);
	}
}
