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

package ims.eas.vo.enums;

public final class EasAction extends ims.framework.utils.Enum
{
	public final static EasAction NEW = new EasAction(0, "New", null, ims.framework.utils.Color.Default);
	public final static EasAction VIEW = new EasAction(1, "View", null, ims.framework.utils.Color.Default);
	public final static EasAction VIEW_SUMMARY = new EasAction(2, "View Summary", null, ims.framework.utils.Color.Default);
	public final static EasAction EDIT = new EasAction(3, "Edit", null, ims.framework.utils.Color.Default);
	public final static EasAction PRINT = new EasAction(4, "Print", null, ims.framework.utils.Color.Default);
	public final static EasAction AUTHORISE = new EasAction(5, "Authorise", null, ims.framework.utils.Color.Default);
	public final static EasAction ANNOTATE = new EasAction(6, "Annotate", null, ims.framework.utils.Color.Default);

	private EasAction(int id, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
	{
		super(id, text, image, textColor);
	}
}
