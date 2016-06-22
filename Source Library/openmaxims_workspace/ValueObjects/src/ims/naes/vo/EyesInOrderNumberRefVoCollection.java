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

package ims.naes.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to NAES.EyesInOrderNumber business object (ID: 1097100008).
 */
public class EyesInOrderNumberRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<EyesInOrderNumberRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<EyesInOrderNumberRefVo> col = new ArrayList<EyesInOrderNumberRefVo>();
	public final String getBoClassName()
	{
		return "ims.naes.domain.objects.EyesInOrderNumber";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(EyesInOrderNumberRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, EyesInOrderNumberRefVo value)
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
	public int indexOf(EyesInOrderNumberRefVo instance)
	{
		return col.indexOf(instance);
	}
	public EyesInOrderNumberRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, EyesInOrderNumberRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(EyesInOrderNumberRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(EyesInOrderNumberRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		EyesInOrderNumberRefVoCollection clone = new EyesInOrderNumberRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((EyesInOrderNumberRefVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		return clone;
	}
	public boolean isValidated()
	{
		return true;
	}
	public String[] validate()
	{
		return null;
	}
	public EyesInOrderNumberRefVo[] toArray()
	{
		EyesInOrderNumberRefVo[] arr = new EyesInOrderNumberRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public EyesInOrderNumberRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public EyesInOrderNumberRefVoCollection sort(SortOrder order)
	{
		return sort(new EyesInOrderNumberRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public EyesInOrderNumberRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<EyesInOrderNumberRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class EyesInOrderNumberRefVoComparator implements Comparator
	{
		private int direction = 1;
		public EyesInOrderNumberRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public EyesInOrderNumberRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			EyesInOrderNumberRefVo voObj1 = (EyesInOrderNumberRefVo)obj1;
			EyesInOrderNumberRefVo voObj2 = (EyesInOrderNumberRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
