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

/**
 * Linked to clinical.Clinicalcdiassociations business object (ID: 1072100037).
 */
public class ClinicalcdiassociationsRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<ClinicalcdiassociationsRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ClinicalcdiassociationsRefVo> col = new ArrayList<ClinicalcdiassociationsRefVo>();
	public final String getBoClassName()
	{
		return "ims.clinical.domain.objects.Clinicalcdiassociations";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(ClinicalcdiassociationsRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ClinicalcdiassociationsRefVo value)
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
	public int indexOf(ClinicalcdiassociationsRefVo instance)
	{
		return col.indexOf(instance);
	}
	public ClinicalcdiassociationsRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ClinicalcdiassociationsRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ClinicalcdiassociationsRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ClinicalcdiassociationsRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ClinicalcdiassociationsRefVoCollection clone = new ClinicalcdiassociationsRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ClinicalcdiassociationsRefVo)this.col.get(x).clone());
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
	public ClinicalcdiassociationsRefVo[] toArray()
	{
		ClinicalcdiassociationsRefVo[] arr = new ClinicalcdiassociationsRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ClinicalcdiassociationsRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ClinicalcdiassociationsRefVoCollection sort(SortOrder order)
	{
		return sort(new ClinicalcdiassociationsRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public ClinicalcdiassociationsRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<ClinicalcdiassociationsRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ClinicalcdiassociationsRefVoComparator implements Comparator
	{
		private int direction = 1;
		public ClinicalcdiassociationsRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ClinicalcdiassociationsRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			ClinicalcdiassociationsRefVo voObj1 = (ClinicalcdiassociationsRefVo)obj1;
			ClinicalcdiassociationsRefVo voObj2 = (ClinicalcdiassociationsRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
