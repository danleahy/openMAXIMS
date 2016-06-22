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

package ims.scheduling.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to Scheduling.Booking_Appointment business object (ID: 1055100007).
 */
public class ReferralAppointmentDetailsBookingAppointmentVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<ReferralAppointmentDetailsBookingAppointmentVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ReferralAppointmentDetailsBookingAppointmentVo> col = new ArrayList<ReferralAppointmentDetailsBookingAppointmentVo>();
	public String getBoClassName()
	{
		return "ims.scheduling.domain.objects.Booking_Appointment";
	}
	public boolean add(ReferralAppointmentDetailsBookingAppointmentVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ReferralAppointmentDetailsBookingAppointmentVo value)
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
	public int indexOf(ReferralAppointmentDetailsBookingAppointmentVo instance)
	{
		return col.indexOf(instance);
	}
	public ReferralAppointmentDetailsBookingAppointmentVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ReferralAppointmentDetailsBookingAppointmentVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ReferralAppointmentDetailsBookingAppointmentVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ReferralAppointmentDetailsBookingAppointmentVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ReferralAppointmentDetailsBookingAppointmentVoCollection clone = new ReferralAppointmentDetailsBookingAppointmentVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ReferralAppointmentDetailsBookingAppointmentVo)this.col.get(x).clone());
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
	public ReferralAppointmentDetailsBookingAppointmentVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ReferralAppointmentDetailsBookingAppointmentVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public ReferralAppointmentDetailsBookingAppointmentVoCollection sort(SortOrder order)
	{
		return sort(new ReferralAppointmentDetailsBookingAppointmentVoComparator(order));
	}
	public ReferralAppointmentDetailsBookingAppointmentVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new ReferralAppointmentDetailsBookingAppointmentVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public ReferralAppointmentDetailsBookingAppointmentVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.scheduling.vo.Booking_AppointmentRefVoCollection toRefVoCollection()
	{
		ims.scheduling.vo.Booking_AppointmentRefVoCollection result = new ims.scheduling.vo.Booking_AppointmentRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public ReferralAppointmentDetailsBookingAppointmentVo[] toArray()
	{
		ReferralAppointmentDetailsBookingAppointmentVo[] arr = new ReferralAppointmentDetailsBookingAppointmentVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<ReferralAppointmentDetailsBookingAppointmentVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ReferralAppointmentDetailsBookingAppointmentVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public ReferralAppointmentDetailsBookingAppointmentVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ReferralAppointmentDetailsBookingAppointmentVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public ReferralAppointmentDetailsBookingAppointmentVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			ReferralAppointmentDetailsBookingAppointmentVo voObj1 = (ReferralAppointmentDetailsBookingAppointmentVo)obj1;
			ReferralAppointmentDetailsBookingAppointmentVo voObj2 = (ReferralAppointmentDetailsBookingAppointmentVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.scheduling.vo.beans.ReferralAppointmentDetailsBookingAppointmentVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.scheduling.vo.beans.ReferralAppointmentDetailsBookingAppointmentVoBean[] getBeanCollectionArray()
	{
		ims.scheduling.vo.beans.ReferralAppointmentDetailsBookingAppointmentVoBean[] result = new ims.scheduling.vo.beans.ReferralAppointmentDetailsBookingAppointmentVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			ReferralAppointmentDetailsBookingAppointmentVo vo = ((ReferralAppointmentDetailsBookingAppointmentVo)col.get(i));
			result[i] = (ims.scheduling.vo.beans.ReferralAppointmentDetailsBookingAppointmentVoBean)vo.getBean();
		}
		return result;
	}
	public static ReferralAppointmentDetailsBookingAppointmentVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ReferralAppointmentDetailsBookingAppointmentVoCollection coll = new ReferralAppointmentDetailsBookingAppointmentVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.scheduling.vo.beans.ReferralAppointmentDetailsBookingAppointmentVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static ReferralAppointmentDetailsBookingAppointmentVoCollection buildFromBeanCollection(ims.scheduling.vo.beans.ReferralAppointmentDetailsBookingAppointmentVoBean[] beans)
	{
		ReferralAppointmentDetailsBookingAppointmentVoCollection coll = new ReferralAppointmentDetailsBookingAppointmentVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
