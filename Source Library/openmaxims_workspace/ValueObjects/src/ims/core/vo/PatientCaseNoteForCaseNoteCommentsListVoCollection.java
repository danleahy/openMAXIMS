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
 * Linked to core.clinical.PatientCaseNote business object (ID: 1003100130).
 */
public class PatientCaseNoteForCaseNoteCommentsListVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<PatientCaseNoteForCaseNoteCommentsListVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<PatientCaseNoteForCaseNoteCommentsListVo> col = new ArrayList<PatientCaseNoteForCaseNoteCommentsListVo>();
	public String getBoClassName()
	{
		return "ims.core.clinical.domain.objects.PatientCaseNote";
	}
	public boolean add(PatientCaseNoteForCaseNoteCommentsListVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, PatientCaseNoteForCaseNoteCommentsListVo value)
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
	public int indexOf(PatientCaseNoteForCaseNoteCommentsListVo instance)
	{
		return col.indexOf(instance);
	}
	public PatientCaseNoteForCaseNoteCommentsListVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, PatientCaseNoteForCaseNoteCommentsListVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(PatientCaseNoteForCaseNoteCommentsListVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(PatientCaseNoteForCaseNoteCommentsListVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		PatientCaseNoteForCaseNoteCommentsListVoCollection clone = new PatientCaseNoteForCaseNoteCommentsListVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((PatientCaseNoteForCaseNoteCommentsListVo)this.col.get(x).clone());
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
	public PatientCaseNoteForCaseNoteCommentsListVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public PatientCaseNoteForCaseNoteCommentsListVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public PatientCaseNoteForCaseNoteCommentsListVoCollection sort(SortOrder order)
	{
		return sort(new PatientCaseNoteForCaseNoteCommentsListVoComparator(order));
	}
	public PatientCaseNoteForCaseNoteCommentsListVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new PatientCaseNoteForCaseNoteCommentsListVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public PatientCaseNoteForCaseNoteCommentsListVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.clinical.vo.PatientCaseNoteRefVoCollection toRefVoCollection()
	{
		ims.core.clinical.vo.PatientCaseNoteRefVoCollection result = new ims.core.clinical.vo.PatientCaseNoteRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public PatientCaseNoteForCaseNoteCommentsListVo[] toArray()
	{
		PatientCaseNoteForCaseNoteCommentsListVo[] arr = new PatientCaseNoteForCaseNoteCommentsListVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<PatientCaseNoteForCaseNoteCommentsListVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class PatientCaseNoteForCaseNoteCommentsListVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public PatientCaseNoteForCaseNoteCommentsListVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public PatientCaseNoteForCaseNoteCommentsListVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public PatientCaseNoteForCaseNoteCommentsListVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			PatientCaseNoteForCaseNoteCommentsListVo voObj1 = (PatientCaseNoteForCaseNoteCommentsListVo)obj1;
			PatientCaseNoteForCaseNoteCommentsListVo voObj2 = (PatientCaseNoteForCaseNoteCommentsListVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.core.vo.beans.PatientCaseNoteForCaseNoteCommentsListVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.core.vo.beans.PatientCaseNoteForCaseNoteCommentsListVoBean[] getBeanCollectionArray()
	{
		ims.core.vo.beans.PatientCaseNoteForCaseNoteCommentsListVoBean[] result = new ims.core.vo.beans.PatientCaseNoteForCaseNoteCommentsListVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			PatientCaseNoteForCaseNoteCommentsListVo vo = ((PatientCaseNoteForCaseNoteCommentsListVo)col.get(i));
			result[i] = (ims.core.vo.beans.PatientCaseNoteForCaseNoteCommentsListVoBean)vo.getBean();
		}
		return result;
	}
	public static PatientCaseNoteForCaseNoteCommentsListVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		PatientCaseNoteForCaseNoteCommentsListVoCollection coll = new PatientCaseNoteForCaseNoteCommentsListVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.core.vo.beans.PatientCaseNoteForCaseNoteCommentsListVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static PatientCaseNoteForCaseNoteCommentsListVoCollection buildFromBeanCollection(ims.core.vo.beans.PatientCaseNoteForCaseNoteCommentsListVoBean[] beans)
	{
		PatientCaseNoteForCaseNoteCommentsListVoCollection coll = new PatientCaseNoteForCaseNoteCommentsListVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
