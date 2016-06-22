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

package ims.core.vo.lookups;

import ims.framework.cn.data.TreeModel;
import ims.framework.cn.data.TreeNode;
import ims.vo.LookupInstanceCollection;
import ims.vo.LookupInstVo;

public class PDSSearchTypeCollection extends LookupInstanceCollection implements ims.vo.ImsCloneable, TreeModel
{
	private static final long serialVersionUID = 1L;
	public void add(PDSSearchType value)
	{
		super.add(value);
	}
	public int indexOf(PDSSearchType instance)
	{
		return super.indexOf(instance);
	}
	public boolean contains(PDSSearchType instance)
	{
		return indexOf(instance) >= 0;
	}
	public PDSSearchType get(int index)
	{
		return (PDSSearchType)super.getIndex(index);
	}
	public void remove(PDSSearchType instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public Object clone()
	{
		PDSSearchTypeCollection newCol = new PDSSearchTypeCollection();
		PDSSearchType item;
		for (int i = 0; i < super.size(); i++)
		{
			item = this.get(i);
			newCol.add(new PDSSearchType(item.getID(), item.getText(), item.isActive(), item.getParent(), item.getImage(), item.getColor(), item.getOrder()));
		}
		for (int i = 0; i < newCol.size(); i++)
		{
			item = newCol.get(i);
			if (item.getParent() != null)
			{
				int parentIndex = this.indexOf(item.getParent());
				if(parentIndex >= 0)
					item.setParent(newCol.get(parentIndex));
				else
					item.setParent((PDSSearchType)item.getParent().clone());
			}
		}
		return newCol;
	}
	public PDSSearchType getInstance(int instanceId)
	{
		return (PDSSearchType)super.getInstanceById(instanceId);
	}
	public TreeNode[] getRootNodes()
	{
		LookupInstVo[] roots = super.getRoots();
		TreeNode[] nodes = new TreeNode[roots.length];
		System.arraycopy(roots, 0, nodes, 0, roots.length);
		return nodes;
	}
	public PDSSearchType[] toArray()
	{
		PDSSearchType[] arr = new PDSSearchType[this.size()];
		super.toArray(arr);
		return arr;
	}
	public static PDSSearchTypeCollection buildFromBeanCollection(java.util.Collection beans)
	{
		PDSSearchTypeCollection coll = new PDSSearchTypeCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while(iter.hasNext())
		{
			coll.add(PDSSearchType.buildLookup((ims.vo.LookupInstanceBean)iter.next()));
		}
		return coll;
	}
	public static PDSSearchTypeCollection buildFromBeanCollection(ims.vo.LookupInstanceBean[] beans)
	{
		PDSSearchTypeCollection coll = new PDSSearchTypeCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(PDSSearchType.buildLookup(beans[x]));
		}
		return coll;
	}
}
