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

package ims.ocrr.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to OCRR.OrderingResults.OrderResultHistory business object (ID: 1070100020).
 */
public class OrderResultHistoryVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<OrderResultHistoryVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<OrderResultHistoryVo> col = new ArrayList<OrderResultHistoryVo>();
	public String getBoClassName()
	{
		return "ims.ocrr.orderingresults.domain.objects.OrderResultHistory";
	}
	public boolean add(OrderResultHistoryVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, OrderResultHistoryVo value)
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
	public int indexOf(OrderResultHistoryVo instance)
	{
		return col.indexOf(instance);
	}
	public OrderResultHistoryVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, OrderResultHistoryVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(OrderResultHistoryVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(OrderResultHistoryVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		OrderResultHistoryVoCollection clone = new OrderResultHistoryVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((OrderResultHistoryVo)this.col.get(x).clone());
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
	public OrderResultHistoryVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public OrderResultHistoryVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public OrderResultHistoryVoCollection sort(SortOrder order)
	{
		return sort(new OrderResultHistoryVoComparator(order));
	}
	public OrderResultHistoryVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new OrderResultHistoryVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public OrderResultHistoryVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.ocrr.orderingresults.vo.OrderResultHistoryRefVoCollection toRefVoCollection()
	{
		ims.ocrr.orderingresults.vo.OrderResultHistoryRefVoCollection result = new ims.ocrr.orderingresults.vo.OrderResultHistoryRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public OrderResultHistoryVo[] toArray()
	{
		OrderResultHistoryVo[] arr = new OrderResultHistoryVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ims.vo.interfaces.IOrderResultDisplay[] toIOrderResultDisplayArray()
	{
		ims.vo.interfaces.IOrderResultDisplay[] arr = new ims.vo.interfaces.IOrderResultDisplay[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<OrderResultHistoryVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class OrderResultHistoryVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public OrderResultHistoryVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public OrderResultHistoryVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public OrderResultHistoryVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			OrderResultHistoryVo voObj1 = (OrderResultHistoryVo)obj1;
			OrderResultHistoryVo voObj2 = (OrderResultHistoryVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.ocrr.vo.beans.OrderResultHistoryVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.ocrr.vo.beans.OrderResultHistoryVoBean[] getBeanCollectionArray()
	{
		ims.ocrr.vo.beans.OrderResultHistoryVoBean[] result = new ims.ocrr.vo.beans.OrderResultHistoryVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			OrderResultHistoryVo vo = ((OrderResultHistoryVo)col.get(i));
			result[i] = (ims.ocrr.vo.beans.OrderResultHistoryVoBean)vo.getBean();
		}
		return result;
	}
	public static OrderResultHistoryVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		OrderResultHistoryVoCollection coll = new OrderResultHistoryVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.ocrr.vo.beans.OrderResultHistoryVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static OrderResultHistoryVoCollection buildFromBeanCollection(ims.ocrr.vo.beans.OrderResultHistoryVoBean[] beans)
	{
		OrderResultHistoryVoCollection coll = new OrderResultHistoryVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
