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

package ims.oncology.configuration.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to Oncology.Configuration.PrognosticGroupingConfig business object (ID: 1075100014).
 */
public class PrognosticGroupingConfigRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<PrognosticGroupingConfigRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<PrognosticGroupingConfigRefVo> col = new ArrayList<PrognosticGroupingConfigRefVo>();
	public final String getBoClassName()
	{
		return "ims.oncology.configuration.domain.objects.PrognosticGroupingConfig";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(PrognosticGroupingConfigRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, PrognosticGroupingConfigRefVo value)
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
	public int indexOf(PrognosticGroupingConfigRefVo instance)
	{
		return col.indexOf(instance);
	}
	public PrognosticGroupingConfigRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, PrognosticGroupingConfigRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(PrognosticGroupingConfigRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(PrognosticGroupingConfigRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		PrognosticGroupingConfigRefVoCollection clone = new PrognosticGroupingConfigRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((PrognosticGroupingConfigRefVo)this.col.get(x).clone());
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
	public PrognosticGroupingConfigRefVo[] toArray()
	{
		PrognosticGroupingConfigRefVo[] arr = new PrognosticGroupingConfigRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public PrognosticGroupingConfigRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public PrognosticGroupingConfigRefVoCollection sort(SortOrder order)
	{
		return sort(new PrognosticGroupingConfigRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public PrognosticGroupingConfigRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<PrognosticGroupingConfigRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class PrognosticGroupingConfigRefVoComparator implements Comparator
	{
		private int direction = 1;
		public PrognosticGroupingConfigRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public PrognosticGroupingConfigRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			PrognosticGroupingConfigRefVo voObj1 = (PrognosticGroupingConfigRefVo)obj1;
			PrognosticGroupingConfigRefVo voObj2 = (PrognosticGroupingConfigRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
