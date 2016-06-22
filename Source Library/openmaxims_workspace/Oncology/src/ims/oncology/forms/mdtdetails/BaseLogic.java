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

package ims.oncology.forms.mdtdetails;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.oncology.domain.MDTDetails.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.oncology.domain.MDTDetails domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbPerformanceStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbPerformanceStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.PatientPerformanceStatus existingInstance = (ims.oncology.vo.lookups.PatientPerformanceStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPerformanceStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.PatientPerformanceStatus)
		{
			ims.oncology.vo.lookups.PatientPerformanceStatus instance = (ims.oncology.vo.lookups.PatientPerformanceStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPerformanceStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.PatientPerformanceStatus existingInstance = (ims.oncology.vo.lookups.PatientPerformanceStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbPerformanceStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPerformanceStatusLookup()
	{
		this.form.ctnDetails().cmbPerformanceStatus().clear();
		ims.oncology.vo.lookups.PatientPerformanceStatusCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getPatientPerformanceStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbPerformanceStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPerformanceStatusLookupValue(int id)
	{
		ims.oncology.vo.lookups.PatientPerformanceStatus instance = ims.oncology.vo.lookups.LookupHelper.getPatientPerformanceStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbPerformanceStatus().setValue(instance);
	}
	protected final void defaultcmbPerformanceStatusLookupValue()
	{
		this.form.ctnDetails().cmbPerformanceStatus().setValue((ims.oncology.vo.lookups.PatientPerformanceStatus)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.PatientPerformanceStatus.class, engine.getFormName().getID(), ims.oncology.vo.lookups.PatientPerformanceStatus.TYPE_ID));
	}
	protected final void oncmbCoMorbidityIndexValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbCoMorbidityIndex().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.CoMorbidityAssessment existingInstance = (ims.oncology.vo.lookups.CoMorbidityAssessment)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCoMorbidityIndexLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.CoMorbidityAssessment)
		{
			ims.oncology.vo.lookups.CoMorbidityAssessment instance = (ims.oncology.vo.lookups.CoMorbidityAssessment)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCoMorbidityIndexLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.CoMorbidityAssessment existingInstance = (ims.oncology.vo.lookups.CoMorbidityAssessment)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbCoMorbidityIndex().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCoMorbidityIndexLookup()
	{
		this.form.ctnDetails().cmbCoMorbidityIndex().clear();
		ims.oncology.vo.lookups.CoMorbidityAssessmentCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getCoMorbidityAssessment(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbCoMorbidityIndex().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCoMorbidityIndexLookupValue(int id)
	{
		ims.oncology.vo.lookups.CoMorbidityAssessment instance = ims.oncology.vo.lookups.LookupHelper.getCoMorbidityAssessmentInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbCoMorbidityIndex().setValue(instance);
	}
	protected final void defaultcmbCoMorbidityIndexLookupValue()
	{
		this.form.ctnDetails().cmbCoMorbidityIndex().setValue((ims.oncology.vo.lookups.CoMorbidityAssessment)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.CoMorbidityAssessment.class, engine.getFormName().getID(), ims.oncology.vo.lookups.CoMorbidityAssessment.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.oncology.domain.MDTDetails domain;
}
