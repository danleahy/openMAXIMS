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

package ims.emergency.vo.enums;

public final class DischargeDetails_CustomEvents extends ims.framework.utils.Enum
{
	public final static DischargeDetails_CustomEvents FORMMODECHANGED = new DischargeDetails_CustomEvents(0, "FormModeChanged", null, ims.framework.utils.Color.Default);
	public final static DischargeDetails_CustomEvents NEW = new DischargeDetails_CustomEvents(1, "NEW", null, ims.framework.utils.Color.Default);
	public final static DischargeDetails_CustomEvents EDIT = new DischargeDetails_CustomEvents(2, "EDIT", null, ims.framework.utils.Color.Default);
	public final static DischargeDetails_CustomEvents SAVE = new DischargeDetails_CustomEvents(3, "SAVE", null, ims.framework.utils.Color.Default);
	public final static DischargeDetails_CustomEvents CANCEL = new DischargeDetails_CustomEvents(4, "CANCEL", null, ims.framework.utils.Color.Default);
	public final static DischargeDetails_CustomEvents UNDO = new DischargeDetails_CustomEvents(5, "UNDO", null, ims.framework.utils.Color.Default);
	public final static DischargeDetails_CustomEvents BOOK_APPOINTMENT = new DischargeDetails_CustomEvents(6, "BOOK_APPOINTMENT", null, ims.framework.utils.Color.Default);

	private DischargeDetails_CustomEvents(int id, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
	{
		super(id, text, image, textColor);
	}
}
