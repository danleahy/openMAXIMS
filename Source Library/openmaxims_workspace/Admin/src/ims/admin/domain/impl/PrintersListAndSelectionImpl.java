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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.71 build 3930.18325)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.admin.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.admin.domain.base.impl.BasePrintersListAndSelectionImpl;
import ims.domain.DomainFactory;
import ims.framework.interfaces.IPrinter;
import ims.reports.ReportEngine;

public class PrintersListAndSelectionImpl extends BasePrintersListAndSelectionImpl
{

	private static final long serialVersionUID = 1L;
	
	public IPrinter[] listPrintersForCurrentLocation(Integer locationID, String printerName)
	{
		DomainFactory factory = getDomainFactory();				
 
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		StringBuffer hql = new StringBuffer(" select printers from Location as loc join loc.printers as printers where loc.id = :locationID");			
		names.add("locationID");				
		values.add(locationID);
		
		if (printerName != null)
		{
			hql.append(" and printers.name like '%" + printerName + "%'");
		}
		
		List printers = factory.find(hql.toString(),names,values);
		IPrinter[] printersList = new IPrinter[printers.size()]	;	
		if (printers.size() > 0)
		{
			for (int i = 0; i < printers.size(); i++)
			{
				if ( printers.get(i) instanceof IPrinter)
				{
					printersList[i] = (IPrinter) printers.get(i);
				}
			}
			
			return printersList;
		}
		
		return null;
	}		
	
	public IPrinter listDefaultPrinterForCurrentLocation(Integer locationID)
	{
		DomainFactory factory = getDomainFactory();				
 
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		StringBuffer hql = new StringBuffer(" select defaultPrinter from Location as loc left join loc.defaultPrinter as defaultPrinter where loc.id = :locationID");			
		names.add("locationID");				
		values.add(locationID);
		
		List printers = factory.find(hql.toString(),names,values);
		
		if (printers.size() > 0 && printers.get(0) instanceof IPrinter)
		{
			return (IPrinter) printers.get(0);
		}
		
		return null;		
	}	
	
	public IPrinter getIPrinterName(String printerName)
	{
		DomainFactory factory = getDomainFactory();				
 
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		
		StringBuffer hql = new StringBuffer(" select printer from Printer as printer where printer.name = : printerName ");			
		names.add("printerName");				
		values.add(printerName);
		
		List printers = factory.find(hql.toString(),names,values);
		
		if (printers.size() > 0 && printers.get(0) instanceof IPrinter)
		{
			return (IPrinter) printers.get(0);
		}
		
		return null;		
	}	
	
	public IPrinter refreshPrintersList()
	{
		ReportEngine re = getReportEngine();
		String[] printersAsString = re.listPrinters(null);
		ArrayList<String> printers = new ArrayList<String>();
		for (int i = 0; i < printersAsString.length; i++)
		{
			printers.add(printersAsString[i]);
		}
		
		DomainFactory factory = getDomainFactory();
		List dbPrinters = factory.find(" from Printer ");
		
		
		
		
		return null;
	}
	
	
}
