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

package ims.scheduling.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class PendingEmergencyCurrentPatientLocation extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public PendingEmergencyCurrentPatientLocation()
	{
		super();
	}
	public PendingEmergencyCurrentPatientLocation(int id)
	{
		super(id, "", true);
	}
	public PendingEmergencyCurrentPatientLocation(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public PendingEmergencyCurrentPatientLocation(int id, String text, boolean active, PendingEmergencyCurrentPatientLocation parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public PendingEmergencyCurrentPatientLocation(int id, String text, boolean active, PendingEmergencyCurrentPatientLocation parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public PendingEmergencyCurrentPatientLocation(int id, String text, boolean active, PendingEmergencyCurrentPatientLocation parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static PendingEmergencyCurrentPatientLocation buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new PendingEmergencyCurrentPatientLocation(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (PendingEmergencyCurrentPatientLocation)super.getParentInstance();
	}
	public PendingEmergencyCurrentPatientLocation getParent()
	{
		return (PendingEmergencyCurrentPatientLocation)super.getParentInstance();
	}
	public void setParent(PendingEmergencyCurrentPatientLocation parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		PendingEmergencyCurrentPatientLocation[] typedChildren = new PendingEmergencyCurrentPatientLocation[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (PendingEmergencyCurrentPatientLocation)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof PendingEmergencyCurrentPatientLocation)
		{
			super.addChild((PendingEmergencyCurrentPatientLocation)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof PendingEmergencyCurrentPatientLocation)
		{
			super.removeChild((PendingEmergencyCurrentPatientLocation)child);
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
		PendingEmergencyCurrentPatientLocationCollection result = new PendingEmergencyCurrentPatientLocationCollection();
		return result;
	}
	public static PendingEmergencyCurrentPatientLocation[] getNegativeInstances()
	{
		return new PendingEmergencyCurrentPatientLocation[] {};
	}
	public static String[] getNegativeInstanceNames()
	{
		return new String[] {};
	}
	public static PendingEmergencyCurrentPatientLocation getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		// No negative instances found
		return null;
	}
	public static PendingEmergencyCurrentPatientLocation getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		// No negative instances found
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1141038;
}
