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

package ims.core.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.admin.PDSApptLetterRun business object (ID: 1004100076).
 */
public class PDSApptLetterRunVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<PDSApptLetterRunVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<PDSApptLetterRunVo> col = new ArrayList<PDSApptLetterRunVo>();
	public String getBoClassName()
	{
		return "ims.core.admin.domain.objects.PDSApptLetterRun";
	}
	public boolean add(PDSApptLetterRunVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, PDSApptLetterRunVo value)
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
	public int indexOf(PDSApptLetterRunVo instance)
	{
		return col.indexOf(instance);
	}
	public PDSApptLetterRunVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, PDSApptLetterRunVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(PDSApptLetterRunVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(PDSApptLetterRunVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		PDSApptLetterRunVoCollection clone = new PDSApptLetterRunVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((PDSApptLetterRunVo)this.col.get(x).clone());
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
	public PDSApptLetterRunVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public PDSApptLetterRunVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public PDSApptLetterRunVoCollection sort(SortOrder order)
	{
		return sort(new PDSApptLetterRunVoComparator(order));
	}
	public PDSApptLetterRunVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new PDSApptLetterRunVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public PDSApptLetterRunVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.admin.vo.PDSApptLetterRunRefVoCollection toRefVoCollection()
	{
		ims.core.admin.vo.PDSApptLetterRunRefVoCollection result = new ims.core.admin.vo.PDSApptLetterRunRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public PDSApptLetterRunVo[] toArray()
	{
		PDSApptLetterRunVo[] arr = new PDSApptLetterRunVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<PDSApptLetterRunVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class PDSApptLetterRunVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public PDSApptLetterRunVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public PDSApptLetterRunVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public PDSApptLetterRunVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			PDSApptLetterRunVo voObj1 = (PDSApptLetterRunVo)obj1;
			PDSApptLetterRunVo voObj2 = (PDSApptLetterRunVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.core.vo.beans.PDSApptLetterRunVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.core.vo.beans.PDSApptLetterRunVoBean[] getBeanCollectionArray()
	{
		ims.core.vo.beans.PDSApptLetterRunVoBean[] result = new ims.core.vo.beans.PDSApptLetterRunVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			PDSApptLetterRunVo vo = ((PDSApptLetterRunVo)col.get(i));
			result[i] = (ims.core.vo.beans.PDSApptLetterRunVoBean)vo.getBean();
		}
		return result;
	}
	public static PDSApptLetterRunVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		PDSApptLetterRunVoCollection coll = new PDSApptLetterRunVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.core.vo.beans.PDSApptLetterRunVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static PDSApptLetterRunVoCollection buildFromBeanCollection(ims.core.vo.beans.PDSApptLetterRunVoBean[] beans)
	{
		PDSApptLetterRunVoCollection coll = new PDSApptLetterRunVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
