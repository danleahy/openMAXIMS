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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.70 build 3434.21163)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.rules.domain.impl;

import ims.admin.vo.BusinessRuleVo;
import ims.admin.vo.BusinessRuleVoCollection;
import ims.admin.vo.domain.BusinessRuleVoAssembler;
import ims.core.admin.domain.objects.BusinessRule;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.hibernate3.IMSCriteria;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.CodingRuntimeException;
import ims.rules.domain.base.impl.BaseRulesPriorityEditorImpl;
import ims.rules.helper.Entities;
import ims.rules.interfaces.IRule;
import ims.rules.types.RulesEngineEntity;
import ims.rules.utils.RuleXmlSerialization;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RulesPriorityEditorImpl extends BaseRulesPriorityEditorImpl
{

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public BusinessRuleVoCollection list(RulesEngineEntity entity)
	{
		if (entity == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		IMSCriteria criteria = new IMSCriteria(BusinessRule.class, factory);
		criteria.equal("this.rootEntity", entity.getId());
		criteria.equal("this.active", true);
		
		List rules = criteria.find();
		Collections.sort(rules, new BusinessRuleComparator(SortOrder.DESCENDING));
		
		return BusinessRuleVoAssembler.createBusinessRuleVoCollectionFromBusinessRule(rules);
	}

	/**
	 * 
	 */
	public BusinessRuleVoCollection save(BusinessRuleVoCollection rules) throws DomainInterfaceException, StaleObjectException, ForeignKeyViolationException, UniqueKeyViolationException
	{
		if (rules == null)
			throw new CodingRuntimeException("Major Logical Error - Rules collection must not be null");
		
		DomainFactory factory = getDomainFactory();
		
		for (int i = 0; i < rules.size(); i++)
		{
			BusinessRuleVo rule = rules.get(i);
			BusinessRule domRule = BusinessRuleVoAssembler.extractBusinessRule(factory, rule);			
			
			if (rule.getXmlContent() == null)
				throw new CodingRuntimeException("Major Logical Error - XML Content cannot be null");
			
			String xml;
			try {
				IRule iRule = RuleXmlSerialization.deserializeFromXml(rule.getXmlContent(), Entities.getInstance());
				iRule.setPriority(rule.getPriority());
				xml = RuleXmlSerialization.serialize(iRule);
				domRule.setXmlContent(xml);
				factory.save(domRule);
			}
			catch (Exception e) 
			{
				throw new DomainInterfaceException(e.getMessage());				
			}				
		}
		
		// Return null
		return null;
	}
	
	/**
	 * 
	 * @author George Cristian Josan
	 *
	 */
	public class BusinessRuleComparator implements Comparator
	{
		private int direction = 1;
		
		public BusinessRuleComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public BusinessRuleComparator(SortOrder order)
		{
			if (SortOrder.DESCENDING.equals(order))
			{
				direction = -1;
			}
		}
		
		public int compare(Object arg0, Object arg1)
		{
			if (!(arg0 instanceof BusinessRule) || ! (arg1 instanceof BusinessRule))
				throw new CodingRuntimeException("Major Logica Problem - Data type mismatch on BusinessRuleVoComparator");

			BusinessRule ruleVo0 = (BusinessRule) arg0;
			BusinessRule ruleVo1 = (BusinessRule) arg1;
			
			if (ruleVo0.getPriority().compareTo(ruleVo1.getPriority()) == 0)
			{
				return ruleVo0.getName().compareTo(ruleVo1.getName());
			}
			
			return direction * ruleVo0.getPriority().compareTo(ruleVo1.getPriority());
		}
	}
}
