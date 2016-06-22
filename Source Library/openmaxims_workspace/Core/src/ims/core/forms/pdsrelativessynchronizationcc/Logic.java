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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.80 build 5465.13953)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.

package ims.core.forms.pdsrelativessynchronizationcc;

import ims.core.forms.pdsrelativessynchronizationcc.GenForm.grdSyncRow;
import ims.core.helper.PdsQuery;
import ims.core.vo.PatRelative;
import ims.core.vo.PatRelativeCollection;
import ims.core.vo.enums.PDSSynchronisationCustomControlEvents;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;

import java.util.Comparator;

public class Logic extends BaseLogic
{
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	public void initialize()
	{
	}

	/**
	* setRelatives
	*/
	public void setRelatives(ims.core.vo.PatRelativeCollection relatives)
	{
		form.getLocalContext().setRelatives(relatives);
		
		if(form.grdSync().getRows().size() == 0)
		{
			PdsQuery helper = new PdsQuery(domain);
			
			relatives.sort(new PatRelativeComparator(SortOrder.ASCENDING));
			
			for(int i = 0; i < relatives.size(); i++)
			{
				PatRelative rel = relatives.get(i);
				
				grdSyncRow row = form.grdSync().getRows().newRow();
				
				row.setcolPdsLocal(rel.getObjectidentifierIsNotNull() ? "PDS" : "Local");
				row.setcolName(rel.getName().toString());
				row.setcolRole(rel.getRoleIsNotNull() ? rel.getRole().getText() : "");
				row.setcolType(rel.getRelationshipIsNotNull() ? rel.getRelationship().getText() : "");
				row.setcolContact(helper.getPersonContactNumber(rel.getCommChannels()));
				row.setcolRemove(form.getImages().Core.Remove);
				
				row.setValue(rel);
			}
		}
	}

	/**
	* getRelatives
	*/
	public ims.core.vo.PatRelativeCollection getRelatives()
	{
		PatRelativeCollection relatives = form.getLocalContext().getRelatives();
		
		relatives.clear();
		
		for(int i = 0; i < form.grdSync().getRows().size(); i++)
		{
			relatives.add(form.grdSync().getRows().get(i).getValue());
		}
		
		return relatives;
	}

	@Override
	public PDSSynchronisationCustomControlEvents getSelectedEvent()
	{
		return null;
	}
	@Override
	public void clearSelectedEvent()
	{
		
	}
	@Override
	protected void onGrdSyncGridButtonClicked(int column, grdSyncRow row) throws PresentationLogicException
	{
		for(int i = 0; i < form.grdSync().getRows().size(); i++)
		{
			if(form.grdSync().getRows().get(i).getValue().equals(row.getValue()))
			{
				form.grdSync().getRows().remove(i);
				break;
			}
		}
	}
	
	public class PatRelativeComparator implements Comparator
	{
		private int direction = 1;
		
		public PatRelativeComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public PatRelativeComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			Integer contactRank1 = null;
			Integer contactRank2 = null;
			
			if(ob1 instanceof PatRelative)
			{
				PatRelative ps1 = (PatRelative)ob1;
				
				if(ps1.getContactRank() != null && isInteger(ps1.getContactRank()))
					contactRank1 = Integer.parseInt(ps1.getContactRank());
				else
					contactRank1 = 9999;
			}
			if(ob2 instanceof PatRelative)
			{
				PatRelative ps2 = (PatRelative)ob2;
				
				if(ps2.getContactRank() != null && isInteger(ps2.getContactRank()))
					contactRank2 = Integer.parseInt(ps2.getContactRank());
				else
					contactRank2 = 9999;
			}
			
			if(contactRank1 != null )
				return  contactRank1.compareTo(contactRank2)*direction;
			
			if(contactRank2 != null)
				return (-1)*direction;
			
			return 0;
		}

		public boolean isInteger(String in)
		{
		    char c;
		    int length = in.length();
		    boolean ret = length > 0;
		    int i = ret && in.charAt(0) == '-' ? 1 : 0;
		    for (; ret && i < length; i++)
		    {
		        c = in.charAt(i);
		        ret = (c >= '0' && c <= '9');
		    }
		    return ret;
		}
	}

	@Override
	public Integer countRelatives()
	{
		return form.grdSync().getRows().size();
	}
}
