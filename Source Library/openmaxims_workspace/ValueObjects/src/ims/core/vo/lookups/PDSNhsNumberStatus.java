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

public class PDSNhsNumberStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public PDSNhsNumberStatus()
	{
		super();
	}
	public PDSNhsNumberStatus(int id)
	{
		super(id, "", true);
	}
	public PDSNhsNumberStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public PDSNhsNumberStatus(int id, String text, boolean active, PDSNhsNumberStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public PDSNhsNumberStatus(int id, String text, boolean active, PDSNhsNumberStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public PDSNhsNumberStatus(int id, String text, boolean active, PDSNhsNumberStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static PDSNhsNumberStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new PDSNhsNumberStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (PDSNhsNumberStatus)super.getParentInstance();
	}
	public PDSNhsNumberStatus getParent()
	{
		return (PDSNhsNumberStatus)super.getParentInstance();
	}
	public void setParent(PDSNhsNumberStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		PDSNhsNumberStatus[] typedChildren = new PDSNhsNumberStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (PDSNhsNumberStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof PDSNhsNumberStatus)
		{
			super.addChild((PDSNhsNumberStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof PDSNhsNumberStatus)
		{
			super.removeChild((PDSNhsNumberStatus)child);
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
		PDSNhsNumberStatusCollection result = new PDSNhsNumberStatusCollection();
		result.add(PRESENTVERIFIED);
		result.add(PRESENTNOTTRACED);
		result.add(TREACEREQUIRED);
		result.add(TRACEATTEMPTED);
		result.add(TRACENEEDSRESOLVE);
		result.add(TRACEINPROGRESS);
		result.add(NUMBERNOTPRESENT);
		result.add(TRACEPOSTPONED);
		return result;
	}
	public static PDSNhsNumberStatus[] getNegativeInstances()
	{
		PDSNhsNumberStatus[] instances = new PDSNhsNumberStatus[8];
		instances[0] = PRESENTVERIFIED;
		instances[1] = PRESENTNOTTRACED;
		instances[2] = TREACEREQUIRED;
		instances[3] = TRACEATTEMPTED;
		instances[4] = TRACENEEDSRESOLVE;
		instances[5] = TRACEINPROGRESS;
		instances[6] = NUMBERNOTPRESENT;
		instances[7] = TRACEPOSTPONED;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[8];
		negativeInstances[0] = "PRESENTVERIFIED";
		negativeInstances[1] = "PRESENTNOTTRACED";
		negativeInstances[2] = "TREACEREQUIRED";
		negativeInstances[3] = "TRACEATTEMPTED";
		negativeInstances[4] = "TRACENEEDSRESOLVE";
		negativeInstances[5] = "TRACEINPROGRESS";
		negativeInstances[6] = "NUMBERNOTPRESENT";
		negativeInstances[7] = "TRACEPOSTPONED";
		return negativeInstances;
	}
	public static PDSNhsNumberStatus getNegativeInstance(String name)
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
	public static PDSNhsNumberStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		PDSNhsNumberStatus[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021358;
	public static final PDSNhsNumberStatus PRESENTVERIFIED = new PDSNhsNumberStatus(-3126, "Present and Verified", true, null, null, Color.Default);
	public static final PDSNhsNumberStatus PRESENTNOTTRACED = new PDSNhsNumberStatus(-3127, "Present but not traced", true, null, null, Color.Default);
	public static final PDSNhsNumberStatus TREACEREQUIRED = new PDSNhsNumberStatus(-3128, "Trace Required", true, null, null, Color.Default);
	public static final PDSNhsNumberStatus TRACEATTEMPTED = new PDSNhsNumberStatus(-3129, "Trace Attempted", true, null, null, Color.Default);
	public static final PDSNhsNumberStatus TRACENEEDSRESOLVE = new PDSNhsNumberStatus(-3130, "Trace needs resolution", true, null, null, Color.Default);
	public static final PDSNhsNumberStatus TRACEINPROGRESS = new PDSNhsNumberStatus(-3131, "Trace in progress", true, null, null, Color.Default);
	public static final PDSNhsNumberStatus NUMBERNOTPRESENT = new PDSNhsNumberStatus(-3132, "Number not present", true, null, null, Color.Default);
	public static final PDSNhsNumberStatus TRACEPOSTPONED = new PDSNhsNumberStatus(-3133, "Trace postponed", true, null, null, Color.Default);
}
