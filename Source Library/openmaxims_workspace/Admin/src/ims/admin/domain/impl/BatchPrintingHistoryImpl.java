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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.37 build 2118.23158)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.vo.PrintAgentDocumentsVoCollection;
import ims.admin.vo.domain.PrintAgentDocumentsVoAssembler;
import ims.core.admin.domain.objects.PrintAgentDocuments;
import ims.domain.DomainFactory;
import ims.domain.impl.DomainImpl;
import ims.framework.enumerations.SortOrder;
import ims.framework.utils.DateTime;

import java.util.Iterator;
import java.util.List;

public class BatchPrintingHistoryImpl extends DomainImpl implements ims.admin.domain.BatchPrintingHistory, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;
	
	/**
	* listDocuments
	*/
	public ims.admin.vo.PrintAgentDocumentsVoCollection listDocuments(Integer jobId, ims.framework.utils.DateTime startDate, ims.framework.utils.DateTime endDate) 
	{
		DomainFactory factory = getDomainFactory();
		
		List list = factory.find("from PrintAgentDocuments pad where pad.printAgent.id = :ID and pad.systemInformation.creationDateTime between :DATE1 and :DATE2 order by pad.systemInformation.creationDateTime desc", new String[] {"ID", "DATE1", "DATE2"}, new Object[] {jobId, startDate.getJavaDate(), endDate.getJavaDate()});
		
		PrintAgentDocumentsVoCollection coll = PrintAgentDocumentsVoAssembler.createPrintAgentDocumentsVoCollectionFromPrintAgentDocuments(list);
		for(int i = 0; i < coll.size(); i++)
		{
			Iterator it = list.iterator();
			
			while(it.hasNext())
			{
				PrintAgentDocuments obj = (PrintAgentDocuments)it.next();
				
				if(coll.get(i).getID_PrintAgentDocuments().equals(obj.getId()))
				{
					coll.get(i).setLastUpdateDateTime(new DateTime(obj.getSystemInformation().getCreationDateTime()));
					break;
				}
			}
		}
		
		return coll.sort(SortOrder.DESCENDING);
	}
}
