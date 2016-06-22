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

package ims.clinicaladmin.forms.prognosticlocationconfig;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinicaladmin.domain.PrognosticLocationConfig.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.clinicaladmin.domain.PrognosticLocationConfig domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected void clearScreen()
	{
		this.form.ctnDetails().chkActive().setValue(false);
		this.form.ctnDetails().txtDescription().setValue("");
		this.form.ctnDetails().txtName().setValue("");
	}
	protected void populateScreenFromData(ims.oncology.vo.PrognosticLocationConfigVo value)
	{
		clearScreen();
		if(value == null)
			return;

		if(value.getIsActiveIsNotNull())
			this.form.ctnDetails().chkActive().setValue(value.getIsActive().booleanValue());
		this.form.ctnDetails().txtDescription().setValue(value.getLocationDescriptionIsNotNull() ? value.getLocationDescription(): null);
		this.form.ctnDetails().txtName().setValue(value.getLocationNameIsNotNull() ? value.getLocationName(): null);
	}
	protected ims.oncology.vo.PrognosticLocationConfigVo populateDataFromScreen(ims.oncology.vo.PrognosticLocationConfigVo value)
	{
		if(value == null)
			value = new ims.oncology.vo.PrognosticLocationConfigVo();

		value.setIsActive(new Boolean(this.form.ctnDetails().chkActive().getValue()));
		value.setLocationDescription(this.form.ctnDetails().txtDescription().getValue());
		value.setLocationName(this.form.ctnDetails().txtName().getValue());

		return value;
	}
	protected ims.oncology.vo.PrognosticLocationConfigVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.oncology.vo.PrognosticLocationConfigVo());
	}
	public void initialize() throws ims.framework.exceptions.FormOpenException
	{
	}
	public boolean allowNew()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public boolean allowUpdate()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public String[] validateUIRules()
	{
		return null;
	}
	public void clear()
	{
	}
	public void search()
	{
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinicaladmin.domain.PrognosticLocationConfig domain;
}
