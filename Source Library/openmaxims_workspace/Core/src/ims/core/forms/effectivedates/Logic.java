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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.80 build 5427.27524)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.forms.effectivedates;

public class Logic extends BaseLogic
{
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	/**
	* setEffectiveDates
	*/
	public void setEffectiveDates(ims.framework.utils.Date dateFrom, ims.framework.utils.Date dateTo)
	{
		form.dteEffectiveFrom().setValue(dateFrom);
		form.dteEffectiveTo().setValue(dateTo);
	}

	/**
	* getDateFrom
	*/
	public ims.framework.utils.Date getDateFrom()
	{
		return form.dteEffectiveFrom().getValue();
	}

	/**
	* getDateTo
	*/
	public ims.framework.utils.Date getDateTo()
	{
		return form.dteEffectiveTo().getValue();
	}

	/**
	* clear
	*/
	public void clear()
	{
		form.dteEffectiveFrom().setValue(null);
		form.dteEffectiveTo().setValue(null);
	}

	/**
	* setEnabled
	*/
	public void setEnabled(Boolean bEnabled)
	{
		form.dteEffectiveFrom().setEnabled(bEnabled);
		form.dteEffectiveTo().setEnabled(bEnabled);
	}

	@Override
	public void setDateFromRequired(Boolean required)
	{
		form.dteEffectiveFrom().setRequired(required);
	}

	@Override
	public Boolean isDateFromRequired()
	{
		return form.dteEffectiveFrom().isRequired();
	}

	@Override
	public void showDates(Boolean bShow)
	{
		form.dteEffectiveFrom().setVisible(bShow);
		form.dteEffectiveTo().setVisible(bShow);
		form.lblFrom().setVisible(bShow);
		form.lblTo().setVisible(bShow);
	}
}
