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
package ims.core.admin.domain.objects;

/**
 * 
 * @author Sean Nesbitt
 * Generated.
 */


public class PDSApptLetterRun extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1004100076;
	private static final long serialVersionUID = 1004100076L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** Appointments From Date */
	private java.util.Date fromDate;
	/** Appointments To Date */
	private java.util.Date toDate;
	/** Configured Job Id Instance */
	private ims.core.configuration.domain.objects.ConfiguredJob configuredJob;
	/** Letter Run Type */
	private ims.domain.lookups.LookupInstance letterType;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public PDSApptLetterRun (Integer id, int ver)
    {
    	super(id, ver);
    }
    public PDSApptLetterRun ()
    {
    	super();
    }
    public PDSApptLetterRun (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.core.admin.domain.objects.PDSApptLetterRun.class;
	}


	public java.util.Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(java.util.Date fromDate) {
		this.fromDate = fromDate;
	}

	public java.util.Date getToDate() {
		return toDate;
	}
	public void setToDate(java.util.Date toDate) {
		this.toDate = toDate;
	}

	public ims.core.configuration.domain.objects.ConfiguredJob getConfiguredJob() {
		return configuredJob;
	}
	public static PDSApptLetterRun getPDSApptLetterRunFromConfiguredJob(ims.domain.ILightweightDomainFactory factory, Integer id)
	{
		java.util.List l = factory.find("from PDSApptLetterRun c where c.configuredJob.id = " + id);
		if (l == null || l.size() == 0) return null;
		if (l.size() > 1) throw new ims.domain.exceptions.DomainRuntimeException("Non-unique get call. PDSApptLetterRun.configuredJob.id = " + id + " returned " + l.size() + " records. " );
		return (PDSApptLetterRun)l.get(0);
	}
	public void setConfiguredJob(ims.core.configuration.domain.objects.ConfiguredJob configuredJob) {
		this.configuredJob = configuredJob;
	}

	public ims.domain.lookups.LookupInstance getLetterType() {
		return letterType;
	}
	public void setLetterType(ims.domain.lookups.LookupInstance letterType) {
		this.letterType = letterType;
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
		
		auditStr.append("\r\n*fromDate* :");
		auditStr.append(fromDate);
	    auditStr.append("; ");
		auditStr.append("\r\n*toDate* :");
		auditStr.append(toDate);
	    auditStr.append("; ");
		auditStr.append("\r\n*configuredJob* :");
		if (configuredJob != null)
		{
			auditStr.append(toShortClassName(configuredJob));
				
		    auditStr.append(configuredJob.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*letterType* :");
		if (letterType != null)
			auditStr.append(letterType.getText());
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
		
		String keyClassName = "PDSApptLetterRun";
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
		if (this.getFromDate() != null)
		{
			sb.append("<fromDate>");
			sb.append(new ims.framework.utils.DateTime(this.getFromDate()).toString(ims.framework.utils.DateTimeFormat.MILLI));
			sb.append("</fromDate>");		
		}
		if (this.getToDate() != null)
		{
			sb.append("<toDate>");
			sb.append(new ims.framework.utils.DateTime(this.getToDate()).toString(ims.framework.utils.DateTimeFormat.MILLI));
			sb.append("</toDate>");		
		}
		if (this.getConfiguredJob() != null)
		{
			sb.append("<configuredJob>");
			sb.append(this.getConfiguredJob().toXMLString(domMap)); 	
			sb.append("</configuredJob>");		
		}
		if (this.getLetterType() != null)
		{
			sb.append("<letterType>");
			sb.append(this.getLetterType().toXMLString()); 
			sb.append("</letterType>");		
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
			PDSApptLetterRun domainObject = getPDSApptLetterRunfromXML(itemEl, factory, domMap);

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
			PDSApptLetterRun domainObject = getPDSApptLetterRunfromXML(itemEl, factory, domMap);

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
		
	public static PDSApptLetterRun getPDSApptLetterRunfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getPDSApptLetterRunfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static PDSApptLetterRun getPDSApptLetterRunfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!PDSApptLetterRun.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!PDSApptLetterRun.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the PDSApptLetterRun class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (PDSApptLetterRun)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(PDSApptLetterRun.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		PDSApptLetterRun ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (PDSApptLetterRun)factory.getImportedDomainObject(PDSApptLetterRun.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new PDSApptLetterRun();
		}
		String keyClassName = "PDSApptLetterRun";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (PDSApptLetterRun)impObj.getDomainObject();
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

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, PDSApptLetterRun obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("fromDate");
		if(fldEl != null)
		{	
    		obj.setFromDate(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").parse(fldEl.getTextTrim()));
		}
		fldEl = el.element("toDate");
		if(fldEl != null)
		{	
    		obj.setToDate(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").parse(fldEl.getTextTrim()));
		}
		fldEl = el.element("configuredJob");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setConfiguredJob(ims.core.configuration.domain.objects.ConfiguredJob.getConfiguredJobfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("letterType");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setLetterType(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
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
		public static final String FromDate = "fromDate";
		public static final String ToDate = "toDate";
		public static final String ConfiguredJob = "configuredJob";
		public static final String LetterType = "letterType";
	}
}

