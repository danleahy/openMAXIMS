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
// This code was generated by Neil McAnaspie using IMS Development Environment (version 1.25 build 1959.14958)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.domain.impl;

import ims.admin.domain.MosAdmin;
import ims.admin.domain.impl.MosAdminImpl;
import ims.admin.vo.ReportTemplateVoCollection;
import ims.admin.vo.domain.ReportTemplateVoAssembler;
import ims.core.admin.vo.TemplateBoRefVo;
import ims.core.resource.place.domain.objects.Clinic;
import ims.core.vo.ClinicLiteVoCollection;
import ims.core.vo.MedicVoCollection;
import ims.core.vo.domain.ClinicLiteVoAssembler;
import ims.correspondence.configuration.domain.objects.TemplateAssociations;
import ims.correspondence.vo.TemplateAssociationsVo;
import ims.correspondence.vo.TemplateAssociationsVoCollection;
import ims.correspondence.vo.domain.TemplateAssociationsVoAssembler;
import ims.correspondence.vo.lookups.AssociationSpecifier;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.impl.DomainImpl;

import java.util.ArrayList;
import java.util.List;

public class TemplateAssociationsImpl extends DomainImpl implements ims.correspondence.domain.TemplateAssociations, ims.domain.impl.Transactional
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see ims.dischargeletters.domain.TemplateAssociations#listTemplates(java.lang.Boolean)
	 */
	public ReportTemplateVoCollection listTemplates(Boolean activeOnly) 
	{
		DomainFactory factory = getDomainFactory();		
		List templates  = factory.find("from TemplateBo");
		return ReportTemplateVoAssembler.createReportTemplateVoCollectionFromTemplateBo(templates);	
	}


	/* (non-Javadoc)
	 * @see ims.dischargeletters.domain.TemplateAssociations#listClinics()
	 */
	public ClinicLiteVoCollection listClinics() 
	{		
		DomainFactory factory = getDomainFactory();
		return ClinicLiteVoAssembler.createClinicLiteVoCollectionFromClinic(factory.listDomainObjects(Clinic.class));
	}

	public MedicVoCollection listMedics() 
	{
		MosAdmin impl = (MosAdmin) getDomainImpl(MosAdminImpl.class);
		return impl.listAllMedics();
	}
	

	/* (non-Javadoc)
	 * @see ims.dischargeletters.domain.TemplateAssociations#listConsultantsForTemplate(java.lang.Integer)
	 */
	public TemplateAssociationsVoCollection listConsultantsForTemplate(Integer templateID) 
	{
		return listTemplateAssociation(templateID, AssociationSpecifier.CONSULTANT);		
	}

	/* (non-Javadoc)
	 * @see ims.dischargeletters.domain.TemplateAssociations#listClinicsForTemplate(java.lang.Integer)
	 */
	public TemplateAssociationsVoCollection listClinicsForTemplate(Integer templateID) 
	{
		return listTemplateAssociation(templateID, AssociationSpecifier.CLINIC); 
	}

	/* (non-Javadoc)
	 * @see ims.dischargeletters.domain.TemplateAssociations#listServicesForTemplate(java.lang.Integer)
	 */
	public TemplateAssociationsVoCollection listServicesForTemplate(Integer templateID) 
	{
		return listTemplateAssociation(templateID, AssociationSpecifier.SPECIALTY);		
	}		
	
	
	
	/* (non-Javadoc)
	 * @see ims.dischargeletters.domain.TemplateAssociations#getTemplateAssociations(java.lang.Integer)
	 */
	public TemplateAssociationsVo getTemplateAssociations(Integer templateID) 
	{
		DomainFactory factory = getDomainFactory();				
		StringBuffer condStr = new StringBuffer();
		condStr.append(" from TemplateAssociations ta where ta.template.id = " + templateID);		
		List lstTemplateAssociations = factory.find(condStr.toString());
		if (lstTemplateAssociations.size() > 0 )
			return TemplateAssociationsVoAssembler.create((TemplateAssociations) lstTemplateAssociations.get(0));
		else
			return new TemplateAssociationsVo(); 
	}

	/**
	 * @param templateID
	 * @param ts
	 * @return
	 */
	private TemplateAssociationsVoCollection listTemplateAssociation(Integer templateID, AssociationSpecifier ts) 
	{
		DomainFactory factory = getDomainFactory();		
		String hql = " from TemplateAssociations ta";
		String andStr = " ";		
		StringBuffer condStr = new StringBuffer();
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		
		markers.add("templateID");
		values.add(templateID);
		
		if (ts != null)
		{
			condStr.append(andStr + " ta.templateIdentifier = :templateID and ta.associationSpecifier = :templateType");
			markers.add("templateType");		
			values.add(getDomLookup(ts));			
		}

		else
			condStr.append(andStr + " ta.templateIdentifier = :templateID order by ta.associationSpecifier");
		
		
		hql += " where " + condStr.toString();		
		List lstTemplateClinics  = factory.find(hql, markers, values);		
		if (lstTemplateClinics.size() > 0 )
			return TemplateAssociationsVoAssembler.createTemplateAssociationsVoCollectionFromTemplateAssociations(lstTemplateClinics); 
		else
			return new TemplateAssociationsVoCollection();
	}

	/* (non-Javadoc)
	 * @see ims.dischargeletters.domain.TemplateAssociations#listAssociationsForTemplate(java.lang.Integer, ims.dischargeletters.vo.lookups.TemplateAssociationSpecifier)
	 */
	public TemplateAssociationsVoCollection listAssociationsForTemplate(Integer nTemplateID, AssociationSpecifier associationSpecifier) 
	{
		return listTemplateAssociation(nTemplateID, associationSpecifier);	
	}


	public TemplateAssociationsVo getAssociationsForTemplate(TemplateBoRefVo voRefTemplate) 
	{
		DomainFactory factory = getDomainFactory();
		return TemplateAssociationsVoAssembler.create(TemplateAssociations.getTemplateAssociationsFromTemplate(factory, voRefTemplate.getID_TemplateBo()));
	}

	public TemplateAssociationsVo saveTemplateAssociation(TemplateAssociationsVo voTemplateAssociation) throws StaleObjectException, UniqueKeyViolationException 
	{
		if (!voTemplateAssociation.isValidated())
			throw new DomainRuntimeException("TemplateAssociationVo has not been validated");

		DomainFactory factory = getDomainFactory();
		TemplateAssociations domTemplateAssociations = TemplateAssociationsVoAssembler.extractTemplateAssociations(factory, voTemplateAssociation);		
		factory.save(domTemplateAssociations);
		return TemplateAssociationsVoAssembler.create(domTemplateAssociations);
	}






}
