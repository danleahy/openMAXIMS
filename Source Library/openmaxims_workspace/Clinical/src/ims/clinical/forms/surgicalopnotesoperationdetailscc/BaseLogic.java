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

package ims.clinical.forms.surgicalopnotesoperationdetailscc;

public abstract class BaseLogic extends Handlers implements IComponent
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinical.domain.SurgicalOPNotesOperationDetailsCC.class;
	}
	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form, ims.clinical.domain.SurgicalOPNotesOperationDetailsCC domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void setMode(ims.framework.enumerations.FormMode mode)
	{
		form.setMode(mode);
	}
	public ims.framework.enumerations.FormMode getMode()
	{
		return form.getMode();
	}
	protected void clearScreen()
	{
		this.form.txtClosure().setValue("");
		this.form.txtProcedure().setValue("");
		this.form.txtFindings().setValue("");
		this.form.txtIncision().setValue("");
	}
	protected void populateScreenFromData(ims.clinical.vo.SurgicalOperationDetailsVo value)
	{
		clearScreen();
		if(value == null)
			return;

		this.form.txtClosure().setValue(value.getClosureIsNotNull() ? value.getClosure(): null);
		this.form.txtProcedure().setValue(value.getProcedureIsNotNull() ? value.getProcedure(): null);
		this.form.txtFindings().setValue(value.getFindingsIsNotNull() ? value.getFindings(): null);
		this.form.txtIncision().setValue(value.getIncisionIsNotNull() ? value.getIncision(): null);
	}
	protected ims.clinical.vo.SurgicalOperationDetailsVo populateDataFromScreen(ims.clinical.vo.SurgicalOperationDetailsVo value)
	{
		if(value == null)
			value = new ims.clinical.vo.SurgicalOperationDetailsVo();

		value.setClosure(this.form.txtClosure().getValue());
		value.setProcedure(this.form.txtProcedure().getValue());
		value.setFindings(this.form.txtFindings().getValue());
		value.setIncision(this.form.txtIncision().getValue());

		return value;
	}
	protected ims.clinical.vo.SurgicalOperationDetailsVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.clinical.vo.SurgicalOperationDetailsVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinical.domain.SurgicalOPNotesOperationDetailsCC domain;
}
