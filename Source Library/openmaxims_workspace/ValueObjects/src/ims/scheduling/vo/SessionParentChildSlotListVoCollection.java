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

package ims.scheduling.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to Scheduling.SessionParentChildSlot business object (ID: 1090100019).
 */
public class SessionParentChildSlotListVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<SessionParentChildSlotListVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<SessionParentChildSlotListVo> col = new ArrayList<SessionParentChildSlotListVo>();
	public String getBoClassName()
	{
		return "ims.scheduling.domain.objects.SessionParentChildSlot";
	}
	public boolean add(SessionParentChildSlotListVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, SessionParentChildSlotListVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			this.col.add(index, value);
			return true;
		}
		return false;
	}
	public void clear()
	{
		this.col.clear();
	}
	public void remove(int index)
	{
		this.col.remove(index);
	}
	public int size()
	{
		return this.col.size();
	}
	public int indexOf(SessionParentChildSlotListVo instance)
	{
		return col.indexOf(instance);
	}
	public SessionParentChildSlotListVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, SessionParentChildSlotListVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(SessionParentChildSlotListVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(SessionParentChildSlotListVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		SessionParentChildSlotListVoCollection clone = new SessionParentChildSlotListVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((SessionParentChildSlotListVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		
		return clone;
	}
	public boolean isValidated()
	{
		for(int x = 0; x < col.size(); x++)
			if(!this.col.get(x).isValidated())
				return false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(col.size() == 0)
			return null;
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		for(int x = 0; x < col.size(); x++)
		{
			String[] listOfOtherErrors = this.col.get(x).validate();
			if(listOfOtherErrors != null)
			{
				for(int y = 0; y < listOfOtherErrors.length; y++)
				{
					listOfErrors.add(listOfOtherErrors[y]);
				}
			}
		}
		
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
			return null;
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		return result;
	}
	public SessionParentChildSlotListVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public SessionParentChildSlotListVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public SessionParentChildSlotListVoCollection sort(SortOrder order)
	{
		return sort(new SessionParentChildSlotListVoComparator(order));
	}
	public SessionParentChildSlotListVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new SessionParentChildSlotListVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public SessionParentChildSlotListVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.scheduling.vo.SessionParentChildSlotRefVoCollection toRefVoCollection()
	{
		ims.scheduling.vo.SessionParentChildSlotRefVoCollection result = new ims.scheduling.vo.SessionParentChildSlotRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public SessionParentChildSlotListVo[] toArray()
	{
		SessionParentChildSlotListVo[] arr = new SessionParentChildSlotListVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<SessionParentChildSlotListVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class SessionParentChildSlotListVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public SessionParentChildSlotListVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public SessionParentChildSlotListVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public SessionParentChildSlotListVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			SessionParentChildSlotListVo voObj1 = (SessionParentChildSlotListVo)obj1;
			SessionParentChildSlotListVo voObj2 = (SessionParentChildSlotListVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.scheduling.vo.beans.SessionParentChildSlotListVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.scheduling.vo.beans.SessionParentChildSlotListVoBean[] getBeanCollectionArray()
	{
		ims.scheduling.vo.beans.SessionParentChildSlotListVoBean[] result = new ims.scheduling.vo.beans.SessionParentChildSlotListVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			SessionParentChildSlotListVo vo = ((SessionParentChildSlotListVo)col.get(i));
			result[i] = (ims.scheduling.vo.beans.SessionParentChildSlotListVoBean)vo.getBean();
		}
		return result;
	}
	public static SessionParentChildSlotListVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		SessionParentChildSlotListVoCollection coll = new SessionParentChildSlotListVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.scheduling.vo.beans.SessionParentChildSlotListVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static SessionParentChildSlotListVoCollection buildFromBeanCollection(ims.scheduling.vo.beans.SessionParentChildSlotListVoBean[] beans)
	{
		SessionParentChildSlotListVoCollection coll = new SessionParentChildSlotListVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
