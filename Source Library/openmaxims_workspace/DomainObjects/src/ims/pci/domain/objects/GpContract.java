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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5589.25814)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated: 12/10/2015, 13:28
 *
 */
package ims.pci.domain.objects;

/**
 * 
 * @author Neil McAnaspie
 * Generated.
 */


public class GpContract extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1091100000;
	private static final long serialVersionUID = 1091100000L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** GP */
	private ims.core.resource.people.domain.objects.Gp gP;
	private String contractId;
	/** Contract Start Date */
	private java.util.Date contractStartDate;
	/** Contract End Date */
	private java.util.Date contractEndDate;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public GpContract (Integer id, int ver)
    {
    	super(id, ver);
    }
    public GpContract ()
    {
    	super();
    }
    public GpContract (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.pci.domain.objects.GpContract.class;
	}


	public ims.core.resource.people.domain.objects.Gp getGP() {
		return gP;
	}
	public void setGP(ims.core.resource.people.domain.objects.Gp gP) {
		this.gP = gP;
	}

	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		if ( null != contractId && contractId.length() > 50 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for contractId. Tried to set value: "+
				contractId);
		}
		this.contractId = contractId;
	}

	public java.util.Date getContractStartDate() {
		return contractStartDate;
	}
	public void setContractStartDate(java.util.Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public java.util.Date getContractEndDate() {
		return contractEndDate;
	}
	public void setContractEndDate(java.util.Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public ims.domain.SystemInformation getSystemInformation() {
		if (systemInformation == null) systemInformation = new ims.domain.SystemInformation();
		return systemInformation;
	}


	/**
	 * isConfigurationObject
	 * Taken from the Usage property of the business object, this method will return
	 * a boolean indicating whether this is a configuration object or not
	 * Configuration = true, Instantiation = false
	 */
	public static boolean isConfigurationObject()
	{
		if ( "Instantiation".equals("Configuration") )
			return true;
		else
			return false;
	}
	// method generated based on 'gpcontract_unq1' unique index.
	public static boolean recordExistForGPAndContractId(ims.domain.ILightweightDomainFactory factory,
		 ims.core.resource.people.domain.objects.Gp gP
	,
	 String contractId
	)	
	{
		return recordExistForGPAndContractId(factory, gP, contractId, null);
	}	

	// method generated based on 'gpcontract_unq1' unique index.
	public static boolean recordExistForGPAndContractId(ims.domain.ILightweightDomainFactory factory,
		 ims.core.resource.people.domain.objects.Gp gP
	,
	 String contractId
	, Integer recordId)	
	{
		String[] names = new String[2];
		Object[] values = new Object[2];
		StringBuffer hql = new StringBuffer();
		
		hql.append("from GpContract c where ");
		hql.append(" c.gP = :gP ");
		names[0] = "gP";
		values[0] = gP;		
		hql.append(" and "); 
		hql.append(" c.contractId = :contractId ");
		names[1] = "contractId";
		values[1] = contractId;		
		if(recordId != null)
		{
			hql.append(" and c.id <> " + recordId);
		}
		
		return factory.count(hql.toString(), names, values) > 0;				
	}	

	// method generated based on 'gpcontract_unq1' unique index.
	public static GpContract getRecordByGPAndContractId(ims.domain.ILightweightDomainFactory factory,
	 ims.core.resource.people.domain.objects.Gp gP
	,
	 String contractId
	)
	{
		String[] names = new String[2];
		Object[] values = new Object[2];
		StringBuffer hql = new StringBuffer();
		hql.append("from GpContract c where ");
		hql.append(" c.gP = :gP ");
		names[0] = "gP";
		values[0] = gP;		
		hql.append(" and "); 
		hql.append(" c.contractId = :contractId ");
		names[1] = "contractId";
		values[1] = contractId;		
		java.util.List l = factory.find(hql.toString(), names, values);
		if (l == null || l.size() == 0) return null;
		if (l.size() > 1) throw new ims.domain.exceptions.DomainRuntimeException("Non-unique get call. " + hql + " returned " + l.size() + " records. " );
		return (GpContract)l.get(0);
	}

	public static GpContract getGpContractFromgpcontract_unq1(ims.domain.ILightweightDomainFactory factory,
	 ims.core.resource.people.domain.objects.Gp gP
	,
	 String contractId
	)
	{
		String[] names = new String[2];
		Object[] values = new Object[2];
		StringBuffer hql = new StringBuffer();
		hql.append("from GpContract c where ");
		hql.append(" c.gP = :gP ");
		names[0] = "gP";
		values[0] = gP;		
		hql.append(" and "); 
		hql.append(" c.contractId = :contractId ");
		names[1] = "contractId";
		values[1] = contractId;		
		java.util.List l = factory.find(hql.toString(), names, values);
		if (l == null || l.size() == 0) return null;
		if (l.size() > 1) throw new ims.domain.exceptions.DomainRuntimeException("Non-unique get call. " + hql + " returned " + l.size() + " records. " );
		return (GpContract)l.get(0);
	}


	public int getClassId() {
		return CLASSID;
	}

	public String getClassVersion()
	{
		return CLASSVERSION;
	}

	public String toAuditString()
	{
		StringBuffer auditStr = new StringBuffer();
		
		auditStr.append("\r\n*gP* :");
		if (gP != null)
		{
			auditStr.append(toShortClassName(gP));
				
		    auditStr.append(gP.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*contractId* :");
		auditStr.append(contractId);
	    auditStr.append("; ");
		auditStr.append("\r\n*contractStartDate* :");
		auditStr.append(contractStartDate);
	    auditStr.append("; ");
		auditStr.append("\r\n*contractEndDate* :");
		auditStr.append(contractEndDate);
	    auditStr.append("; ");
		return auditStr.toString();
	}
	
	public String toXMLString()
	{
		return toXMLString(new java.util.HashMap());
	}
	
	public String toXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<class type=\"" + this.getClass().getName() + "\" ");		
		sb.append(" id=\"" + this.getId() + "\""); 
		sb.append(" source=\"" + ims.configuration.EnvironmentConfig.getImportExportSourceName() + "\" ");
		sb.append(" classVersion=\"" + this.getClassVersion() + "\" ");
		sb.append(" component=\"" + this.getIsComponentClass() + "\" >");
		
		if (domMap.get(this) == null)
		{
			domMap.put(this, this);
			sb.append(this.fieldsToXMLString(domMap));
		}
		sb.append("</class>");
		
		String keyClassName = "GpContract";
		String externalSource = ims.configuration.EnvironmentConfig.getImportExportSourceName();
		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + this.getId());
		if (impObj == null)
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(this.getId());
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(this);
			impObj.setLocalId(this.getId()); 
    		impObj.setClassName(keyClassName); 
			domMap.put(keyClassName + "_" + externalSource + "_" + this.getId(), impObj);
		}
		
		return sb.toString();
	}

	public String fieldsToXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		if (this.getGP() != null)
		{
			sb.append("<gP>");
			sb.append(this.getGP().toXMLString(domMap)); 	
			sb.append("</gP>");		
		}
		if (this.getContractId() != null)
		{
			sb.append("<contractId>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getContractId().toString()));
			sb.append("</contractId>");		
		}
		if (this.getContractStartDate() != null)
		{
			sb.append("<contractStartDate>");
			sb.append(new ims.framework.utils.DateTime(this.getContractStartDate()).toString(ims.framework.utils.DateTimeFormat.MILLI));
			sb.append("</contractStartDate>");		
		}
		if (this.getContractEndDate() != null)
		{
			sb.append("<contractEndDate>");
			sb.append(new ims.framework.utils.DateTime(this.getContractEndDate()).toString(ims.framework.utils.DateTimeFormat.MILLI));
			sb.append("</contractEndDate>");		
		}
		return sb.toString();
	}
		
	public static java.util.List fromListXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.List list, java.util.HashMap domMap) throws Exception
	{
		if (list == null)
		 list = new java.util.ArrayList();
		fillListFromXMLString(list, el, factory, domMap);
		return list;
	}
	
	public static java.util.Set fromSetXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.Set set, java.util.HashMap domMap) throws Exception
	{
		if (set == null)
			 set = new java.util.HashSet();
		fillSetFromXMLString(set, el, factory, domMap);
		return set;
	}
	
	private static void fillSetFromXMLString(java.util.Set set, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			GpContract domainObject = getGpContractfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!set.contains(domainObject)) 
				set.add(domainObject);
			newSet.add(domainObject);			
		}
		
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = set.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			set.remove(iter.next());
		}		
	}
	
	private static void fillListFromXMLString(java.util.List list, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			GpContract domainObject = getGpContractfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}

			int domIdx = list.indexOf(domainObject);
			if (domIdx == -1)
			{
				list.add(i, domainObject);
			}
			else if (i != domIdx && i < list.size())
			{
				Object tmp = list.get(i);
				list.set(i, list.get(domIdx));
				list.set(domIdx, tmp);
			}
		}		
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=list.size();
		while (i1 > size)
		{
			list.remove(i1-1);
			i1=list.size();
		}
	}
		
	public static GpContract getGpContractfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getGpContractfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static GpContract getGpContractfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!GpContract.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!GpContract.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the GpContract class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (GpContract)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(GpContract.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		GpContract ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (GpContract)factory.getImportedDomainObject(GpContract.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new GpContract();
		}
		String keyClassName = "GpContract";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (GpContract)impObj.getDomainObject();
		}
		else
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(extId);
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(ret);
			domMap.put(keyClassName + "_" + externalSource + "_" + extId, impObj);
		}
		fillFieldsfromXML(el, factory, ret, domMap);
		return ret;
	}

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, GpContract obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("gP");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setGP(ims.core.resource.people.domain.objects.Gp.getGpfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("contractId");
		if(fldEl != null)
		{	
    		obj.setContractId(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("contractStartDate");
		if(fldEl != null)
		{	
    		obj.setContractStartDate(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").parse(fldEl.getTextTrim()));
		}
		fldEl = el.element("contractEndDate");
		if(fldEl != null)
		{	
    		obj.setContractEndDate(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").parse(fldEl.getTextTrim()));
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String GP = "gP";
		public static final String ContractId = "contractId";
		public static final String ContractStartDate = "contractStartDate";
		public static final String ContractEndDate = "contractEndDate";
	}
}

