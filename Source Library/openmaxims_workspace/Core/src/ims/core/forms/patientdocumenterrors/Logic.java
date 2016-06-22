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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 3972.30067)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.core.forms.patientdocumenterrors;

import ims.core.forms.patientdocumenterrors.GenForm.grdErrorsRow;
import ims.core.vo.PatientIdCollection;
import ims.core.vo.lookups.PatIdType;
import ims.correspondence.vo.PatientDocumentErrorVo;
import ims.correspondence.vo.PatientDocumentErrorVoCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.utils.Color;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize(args);
	}
	
	private void initialize(Object[] args) 
	{
		PatientDocumentErrorVoCollection errors = null;
		
		if(args != null && args.length > 0)
		{
			errors = (PatientDocumentErrorVoCollection) args[0];
		}
		
		populateGrid(errors);
	}
	
	private void populateGrid(PatientDocumentErrorVoCollection errors) 
	{
		if(errors == null || errors.size() == 0)
			return;
		
		for(int i=0; i<errors.size(); i++)
		{
			addRow(errors.get(i));
		}
	}

	private void addRow(PatientDocumentErrorVo patientDocumentErrorVo) 
	{
		if(patientDocumentErrorVo == null)
			return;
		
		grdErrorsRow row = form.grdErrors().getRows().newRow();
		
		row.setColPatient(patientDocumentErrorVo.getPatient() != null ? patientDocumentErrorVo.getPatient().toString() : null);
		row.setColNHS(getNHS(patientDocumentErrorVo.getIdentifiers()));
		row.setColDoc(patientDocumentErrorVo.getDocumentName());
		row.setColDate(patientDocumentErrorVo.getDocumentDate() != null ? patientDocumentErrorVo.getDocumentDate().toString() : null);
		row.setColError(patientDocumentErrorVo.getError());
		row.setColErrorTextColor(Color.Red);
		
		row.setTooltip(patientDocumentErrorVo.getError());
	}

	private String getNHS(PatientIdCollection identifiers) 
	{
		if(identifiers == null)
			return null;
		
		for (int i = 0; i < identifiers.size(); i++)
		{
			ims.core.vo.PatientId id = identifiers.get(i);
			
			if (id.getType().equals(PatIdType.NHSN))
			{
				return id.getValue();
			}
		}
		
		return null;
	}

	@Override
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}
}
