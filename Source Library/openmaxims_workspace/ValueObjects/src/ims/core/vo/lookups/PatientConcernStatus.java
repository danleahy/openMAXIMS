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

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class PatientConcernStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public PatientConcernStatus()
	{
		super();
	}
	public PatientConcernStatus(int id)
	{
		super(id, "", true);
	}
	public PatientConcernStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public PatientConcernStatus(int id, String text, boolean active, PatientConcernStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public PatientConcernStatus(int id, String text, boolean active, PatientConcernStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public PatientConcernStatus(int id, String text, boolean active, PatientConcernStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static PatientConcernStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new PatientConcernStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (PatientConcernStatus)super.getParentInstance();
	}
	public PatientConcernStatus getParent()
	{
		return (PatientConcernStatus)super.getParentInstance();
	}
	public void setParent(PatientConcernStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		PatientConcernStatus[] typedChildren = new PatientConcernStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (PatientConcernStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof PatientConcernStatus)
		{
			super.addChild((PatientConcernStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof PatientConcernStatus)
		{
			super.removeChild((PatientConcernStatus)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		PatientConcernStatusCollection result = new PatientConcernStatusCollection();
		result.add(ACTIVE);
		result.add(RESOLVED);
		return result;
	}
	public static PatientConcernStatus[] getNegativeInstances()
	{
		PatientConcernStatus[] instances = new PatientConcernStatus[2];
		instances[0] = ACTIVE;
		instances[1] = RESOLVED;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "ACTIVE";
		negativeInstances[1] = "RESOLVED";
		return negativeInstances;
	}
	public static PatientConcernStatus getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		String[] negativeInstances = getNegativeInstanceNames();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].equals(name))
				return getNegativeInstances()[i];
		}
		return null;
	}
	public static PatientConcernStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		PatientConcernStatus[] negativeInstances = getNegativeInstances();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].getID() == id)
				return negativeInstances[i];
		}
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1021079;
	public static final PatientConcernStatus ACTIVE = new PatientConcernStatus(-890, "Active", true, null, null, Color.Default);
	public static final PatientConcernStatus RESOLVED = new PatientConcernStatus(-767, "Resolved", true, null, null, Color.Default);
}
