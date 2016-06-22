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

package ims.core.forms.bayfloorplandesigner;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

			FloorLayout = new FloorLayoutContext(context);
		}
		public final class FloorLayoutContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private FloorLayoutContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getSelectionIsNotNull()
			{
				return !cx_CoreFloorLayoutSelection.getValueIsNull(context);
			}
			public ims.core.layout.vo.FloorLayoutRefVo getSelection()
			{
				return (ims.core.layout.vo.FloorLayoutRefVo)cx_CoreFloorLayoutSelection.getValue(context);
			}
		public void setSelection(ims.core.layout.vo.FloorLayoutRefVo value)
		{
				cx_CoreFloorLayoutSelection.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CoreFloorLayoutSelection = new ims.framework.ContextVariable("Core.FloorLayout.Selection", "_cv_Core.FloorLayout.Selection");
			public boolean getReadOnlyIsNotNull()
			{
				return !cx_CoreFloorLayoutReadOnly.getValueIsNull(context);
			}
			public Boolean getReadOnly()
			{
				return (Boolean)cx_CoreFloorLayoutReadOnly.getValue(context);
			}

			private ims.framework.ContextVariable cx_CoreFloorLayoutReadOnly = new ims.framework.ContextVariable("Core.FloorLayout.ReadOnly", "_cv_Core.FloorLayout.ReadOnly");
			private ims.framework.Context context;
		}


		public FloorLayoutContext FloorLayout;
		private ims.framework.Context context;
	}

	public CoreContext Core;
}
