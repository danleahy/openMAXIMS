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

package ims.core.vo;

/**
 * Linked to core.resource.place.Location business object (ID: 1007100007).
 */
public class LocMostVo extends ims.core.vo.LocShortMappingsVo implements ims.vo.ImsCloneable, Comparable, ims.framework.interfaces.ILocation
{
	private static final long serialVersionUID = 1L;

	public LocMostVo()
	{
	}
	public LocMostVo(Integer id, int version)
	{
		super(id, version);
	}
	public LocMostVo(ims.core.vo.beans.LocMostVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.isactive = bean.getIsActive();
		this.isvirtual = bean.getIsVirtual();
		this.type = bean.getType() == null ? null : ims.core.vo.lookups.LocationType.buildLookup(bean.getType());
		this.displayinedtracking = bean.getDisplayInEDTracking();
		this.casenotefolderlocation = bean.getCaseNoteFolderLocation();
		this.address = bean.getAddress() == null ? null : bean.getAddress().buildVo();
		this.secureaccommodation = bean.getSecureAccommodation();
		this.treatinghosp = bean.getTreatingHosp();
		this.referringhospital = bean.getReferringHospital();
		this.codemappings = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getCodeMappings());
		this.locations = ims.core.vo.LocMostVoCollection.buildFromBeanCollection(bean.getLocations());
		this.parentlocation = bean.getParentLocation() == null ? null : bean.getParentLocation().buildVo();
		this.printers = ims.admin.vo.PrinterVoCollection.buildFromBeanCollection(bean.getPrinters());
		this.defaultprinter = bean.getDefaultPrinter() == null ? null : bean.getDefaultPrinter().buildVo();
		this.designatedprinterfornewresults = bean.getDesignatedPrinterForNewResults() == null ? null : bean.getDesignatedPrinterForNewResults().buildVo();
		this.designatedprinterforocsorder = bean.getDesignatedPrinterForOCSOrder() == null ? null : bean.getDesignatedPrinterForOCSOrder().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.LocMostVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.isactive = bean.getIsActive();
		this.isvirtual = bean.getIsVirtual();
		this.type = bean.getType() == null ? null : ims.core.vo.lookups.LocationType.buildLookup(bean.getType());
		this.displayinedtracking = bean.getDisplayInEDTracking();
		this.casenotefolderlocation = bean.getCaseNoteFolderLocation();
		this.address = bean.getAddress() == null ? null : bean.getAddress().buildVo(map);
		this.secureaccommodation = bean.getSecureAccommodation();
		this.treatinghosp = bean.getTreatingHosp();
		this.referringhospital = bean.getReferringHospital();
		this.codemappings = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getCodeMappings());
		this.locations = ims.core.vo.LocMostVoCollection.buildFromBeanCollection(bean.getLocations());
		this.parentlocation = bean.getParentLocation() == null ? null : bean.getParentLocation().buildVo(map);
		this.printers = ims.admin.vo.PrinterVoCollection.buildFromBeanCollection(bean.getPrinters());
		this.defaultprinter = bean.getDefaultPrinter() == null ? null : bean.getDefaultPrinter().buildVo(map);
		this.designatedprinterfornewresults = bean.getDesignatedPrinterForNewResults() == null ? null : bean.getDesignatedPrinterForNewResults().buildVo(map);
		this.designatedprinterforocsorder = bean.getDesignatedPrinterForOCSOrder() == null ? null : bean.getDesignatedPrinterForOCSOrder().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.LocMostVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.LocMostVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.LocMostVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("LOCATIONS"))
			return getLocations();
		if(fieldName.equals("PARENTLOCATION"))
			return getParentLocation();
		if(fieldName.equals("PRINTERS"))
			return getPrinters();
		if(fieldName.equals("DEFAULTPRINTER"))
			return getDefaultPrinter();
		if(fieldName.equals("DESIGNATEDPRINTERFORNEWRESULTS"))
			return getDesignatedPrinterForNewResults();
		if(fieldName.equals("DESIGNATEDPRINTERFOROCSORDER"))
			return getDesignatedPrinterForOCSOrder();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getLocationsIsNotNull()
	{
		return this.locations != null;
	}
	public ims.core.vo.LocMostVoCollection getLocations()
	{
		return this.locations;
	}
	public void setLocations(ims.core.vo.LocMostVoCollection value)
	{
		this.isValidated = false;
		this.locations = value;
	}
	public boolean getParentLocationIsNotNull()
	{
		return this.parentlocation != null;
	}
	public ims.core.vo.LocMostVo getParentLocation()
	{
		return this.parentlocation;
	}
	public void setParentLocation(ims.core.vo.LocMostVo value)
	{
		this.isValidated = false;
		this.parentlocation = value;
	}
	public boolean getPrintersIsNotNull()
	{
		return this.printers != null;
	}
	public ims.admin.vo.PrinterVoCollection getPrinters()
	{
		return this.printers;
	}
	public void setPrinters(ims.admin.vo.PrinterVoCollection value)
	{
		this.isValidated = false;
		this.printers = value;
	}
	public boolean getDefaultPrinterIsNotNull()
	{
		return this.defaultprinter != null;
	}
	public ims.admin.vo.PrinterVo getDefaultPrinter()
	{
		return this.defaultprinter;
	}
	public void setDefaultPrinter(ims.admin.vo.PrinterVo value)
	{
		this.isValidated = false;
		this.defaultprinter = value;
	}
	public boolean getDesignatedPrinterForNewResultsIsNotNull()
	{
		return this.designatedprinterfornewresults != null;
	}
	public ims.admin.vo.PrinterVo getDesignatedPrinterForNewResults()
	{
		return this.designatedprinterfornewresults;
	}
	public void setDesignatedPrinterForNewResults(ims.admin.vo.PrinterVo value)
	{
		this.isValidated = false;
		this.designatedprinterfornewresults = value;
	}
	public boolean getDesignatedPrinterForOCSOrderIsNotNull()
	{
		return this.designatedprinterforocsorder != null;
	}
	public ims.admin.vo.PrinterVo getDesignatedPrinterForOCSOrder()
	{
		return this.designatedprinterforocsorder;
	}
	public void setDesignatedPrinterForOCSOrder(ims.admin.vo.PrinterVo value)
	{
		this.isValidated = false;
		this.designatedprinterforocsorder = value;
	}
	/**
	* setParent
	*/
	public void setParent(LocMostVo value) 
	{
		LocMostVo valueParent = this.getParentLocation();
		if(valueParent != null)
		{
			valueParent.getLocations().remove(this);
		}	
		this.parentlocation = value;
		if(value != null)
		{
			value.getLocations().add(this);
		}
	}
	
	/**
	* getID()
	*/
	public int getID()
	{	
		return this.getID_Location();
	}
	/**
	* getName()
	*/
	public String getName()
	{
		return this.name;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.address != null)
		{
			if(!this.address.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.codemappings != null)
		{
			if(!this.codemappings.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.locations != null)
		{
			if(!this.locations.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.parentlocation != null)
		{
			if(!this.parentlocation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.printers != null)
		{
			if(!this.printers.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.defaultprinter != null)
		{
			if(!this.defaultprinter.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.designatedprinterfornewresults != null)
		{
			if(!this.designatedprinterfornewresults.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.designatedprinterforocsorder != null)
		{
			if(!this.designatedprinterforocsorder.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 120)
			listOfErrors.add("The length of the field [name] in the value object [ims.core.vo.LocMostVo] is too big. It should be less or equal to 120");
		if(this.isvirtual == null)
			listOfErrors.add("IsVirtual is mandatory");
		if(this.type == null)
			listOfErrors.add("Type is mandatory");
		if(this.address != null)
		{
			String[] listOfOtherErrors = this.address.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.codemappings != null)
		{
			String[] listOfOtherErrors = this.codemappings.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.locations != null)
		{
			String[] listOfOtherErrors = this.locations.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.parentlocation != null)
		{
			String[] listOfOtherErrors = this.parentlocation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.printers != null)
		{
			String[] listOfOtherErrors = this.printers.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.defaultprinter != null)
		{
			String[] listOfOtherErrors = this.defaultprinter.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.designatedprinterfornewresults != null)
		{
			String[] listOfOtherErrors = this.designatedprinterfornewresults.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.designatedprinterforocsorder != null)
		{
			String[] listOfOtherErrors = this.designatedprinterforocsorder.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		LocMostVo clone = new LocMostVo(this.id, this.version);
		
		clone.name = this.name;
		clone.isactive = this.isactive;
		clone.isvirtual = this.isvirtual;
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.core.vo.lookups.LocationType)this.type.clone();
		clone.displayinedtracking = this.displayinedtracking;
		clone.casenotefolderlocation = this.casenotefolderlocation;
		if(this.address == null)
			clone.address = null;
		else
			clone.address = (ims.core.vo.PersonAddress)this.address.clone();
		clone.secureaccommodation = this.secureaccommodation;
		clone.treatinghosp = this.treatinghosp;
		clone.referringhospital = this.referringhospital;
		if(this.codemappings == null)
			clone.codemappings = null;
		else
			clone.codemappings = (ims.core.vo.TaxonomyMapCollection)this.codemappings.clone();
		if(this.locations == null)
			clone.locations = null;
		else
			clone.locations = (ims.core.vo.LocMostVoCollection)this.locations.clone();
		if(this.parentlocation == null)
			clone.parentlocation = null;
		else
			clone.parentlocation = (ims.core.vo.LocMostVo)this.parentlocation.clone();
		if(this.printers == null)
			clone.printers = null;
		else
			clone.printers = (ims.admin.vo.PrinterVoCollection)this.printers.clone();
		if(this.defaultprinter == null)
			clone.defaultprinter = null;
		else
			clone.defaultprinter = (ims.admin.vo.PrinterVo)this.defaultprinter.clone();
		if(this.designatedprinterfornewresults == null)
			clone.designatedprinterfornewresults = null;
		else
			clone.designatedprinterfornewresults = (ims.admin.vo.PrinterVo)this.designatedprinterfornewresults.clone();
		if(this.designatedprinterforocsorder == null)
			clone.designatedprinterforocsorder = null;
		else
			clone.designatedprinterforocsorder = (ims.admin.vo.PrinterVo)this.designatedprinterforocsorder.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.locations != null)
			count++;
		if(this.printers != null)
			count++;
		if(this.defaultprinter != null)
			count++;
		if(this.designatedprinterfornewresults != null)
			count++;
		if(this.designatedprinterforocsorder != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 5;
	}
	protected ims.core.vo.LocMostVoCollection locations;
	protected ims.core.vo.LocMostVo parentlocation;
	protected ims.admin.vo.PrinterVoCollection printers;
	protected ims.admin.vo.PrinterVo defaultprinter;
	protected ims.admin.vo.PrinterVo designatedprinterfornewresults;
	protected ims.admin.vo.PrinterVo designatedprinterforocsorder;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
