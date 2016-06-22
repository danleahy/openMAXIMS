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

package ims.clinical.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;


public class EMISAllergiesVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<EMISAllergiesVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<EMISAllergiesVo> col = new ArrayList<EMISAllergiesVo>();
	public String getBoClassName()
	{
		return null;
	}
	public boolean add(EMISAllergiesVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, EMISAllergiesVo value)
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
	public int indexOf(EMISAllergiesVo instance)
	{
		return col.indexOf(instance);
	}
	public EMISAllergiesVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, EMISAllergiesVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(EMISAllergiesVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(EMISAllergiesVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		EMISAllergiesVoCollection clone = new EMISAllergiesVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((EMISAllergiesVo)this.col.get(x).clone());
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
	public EMISAllergiesVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public EMISAllergiesVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public EMISAllergiesVoCollection sort(SortOrder order)
	{
		return sort(new EMISAllergiesVoComparator(order));
	}
	public EMISAllergiesVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new EMISAllergiesVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public EMISAllergiesVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public EMISAllergiesVo[] toArray()
	{
		EMISAllergiesVo[] arr = new EMISAllergiesVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<EMISAllergiesVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class EMISAllergiesVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public EMISAllergiesVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public EMISAllergiesVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public EMISAllergiesVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			EMISAllergiesVo voObj1 = (EMISAllergiesVo)obj1;
			EMISAllergiesVo voObj2 = (EMISAllergiesVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.clinical.vo.beans.EMISAllergiesVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.clinical.vo.beans.EMISAllergiesVoBean[] getBeanCollectionArray()
	{
		ims.clinical.vo.beans.EMISAllergiesVoBean[] result = new ims.clinical.vo.beans.EMISAllergiesVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			EMISAllergiesVo vo = ((EMISAllergiesVo)col.get(i));
			result[i] = (ims.clinical.vo.beans.EMISAllergiesVoBean)vo.getBean();
		}
		return result;
	}
	public static EMISAllergiesVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		EMISAllergiesVoCollection coll = new EMISAllergiesVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.clinical.vo.beans.EMISAllergiesVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static EMISAllergiesVoCollection buildFromBeanCollection(ims.clinical.vo.beans.EMISAllergiesVoBean[] beans)
	{
		EMISAllergiesVoCollection coll = new EMISAllergiesVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
