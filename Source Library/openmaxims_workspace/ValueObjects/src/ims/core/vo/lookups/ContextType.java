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

public class ContextType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ContextType()
	{
		super();
	}
	public ContextType(int id)
	{
		super(id, "", true);
	}
	public ContextType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ContextType(int id, String text, boolean active, ContextType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ContextType(int id, String text, boolean active, ContextType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ContextType(int id, String text, boolean active, ContextType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ContextType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ContextType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ContextType)super.getParentInstance();
	}
	public ContextType getParent()
	{
		return (ContextType)super.getParentInstance();
	}
	public void setParent(ContextType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ContextType[] typedChildren = new ContextType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ContextType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ContextType)
		{
			super.addChild((ContextType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ContextType)
		{
			super.removeChild((ContextType)child);
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
		ContextTypeCollection result = new ContextTypeCollection();
		result.add(INPATIENT);
		result.add(OUTPATIENT);
		result.add(GHGSURGERY);
		result.add(DAYHOSPITAL);
		result.add(EMERGENCY_FIRST_VISIT);
		result.add(EMERGENCY_SCHEDULED);
		result.add(EMERGENCY_UNSCHEDULED);
		result.add(PRIMARY_CARE);
		result.add(REFERRAL);
		result.add(TCI);
		return result;
	}
	public static ContextType[] getNegativeInstances()
	{
		ContextType[] instances = new ContextType[10];
		instances[0] = INPATIENT;
		instances[1] = OUTPATIENT;
		instances[2] = GHGSURGERY;
		instances[3] = DAYHOSPITAL;
		instances[4] = EMERGENCY_FIRST_VISIT;
		instances[5] = EMERGENCY_SCHEDULED;
		instances[6] = EMERGENCY_UNSCHEDULED;
		instances[7] = PRIMARY_CARE;
		instances[8] = REFERRAL;
		instances[9] = TCI;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[10];
		negativeInstances[0] = "INPATIENT";
		negativeInstances[1] = "OUTPATIENT";
		negativeInstances[2] = "GHGSURGERY";
		negativeInstances[3] = "DAYHOSPITAL";
		negativeInstances[4] = "EMERGENCY_FIRST_VISIT";
		negativeInstances[5] = "EMERGENCY_SCHEDULED";
		negativeInstances[6] = "EMERGENCY_UNSCHEDULED";
		negativeInstances[7] = "PRIMARY_CARE";
		negativeInstances[8] = "REFERRAL";
		negativeInstances[9] = "TCI";
		return negativeInstances;
	}
	public static ContextType getNegativeInstance(String name)
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
	public static ContextType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ContextType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021167;
	public static final ContextType INPATIENT = new ContextType(-872, "In-Patient", true, null, null, Color.Default);
	public static final ContextType OUTPATIENT = new ContextType(-873, "Out-Patient", true, null, null, Color.Default);
	public static final ContextType GHGSURGERY = new ContextType(-1322, "Surgery", true, null, null, Color.Default);
	public static final ContextType DAYHOSPITAL = new ContextType(-1401, "Day-Hospital", true, null, null, Color.Default);
	public static final ContextType EMERGENCY_FIRST_VISIT = new ContextType(-1404, "EmergencyFirstVisit", true, null, null, Color.Default);
	public static final ContextType EMERGENCY_SCHEDULED = new ContextType(-1405, "EmergencyScheduled", true, null, null, Color.Default);
	public static final ContextType EMERGENCY_UNSCHEDULED = new ContextType(-1406, "EmergencyUnscheduled", true, null, null, Color.Default);
	public static final ContextType PRIMARY_CARE = new ContextType(-1508, "Primary Care", true, null, null, Color.Default);
	public static final ContextType REFERRAL = new ContextType(-3076, "Referral", true, null, null, Color.Default);
	public static final ContextType TCI = new ContextType(-2079, "To Come In", true, null, null, Color.Default);
}
