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
package ims.pathways.domain.objects;

/**
 * 
 * @author Sean Nesbitt
 * Generated.
 */


public class AdminEvent extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1088100011;
	private static final long serialVersionUID = 1088100011L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	private ims.core.clinical.domain.objects.RecordingUserInformation recordingDetails;
	private String eventDetails;
	private ims.domain.lookups.LookupInstance outcome;
	private ims.domain.lookups.LookupInstance eventMethod;
	private ims.pathways.domain.objects.PathwaysRTTClockImpact rTTClockImpact;
	private ims.domain.lookups.LookupInstance outcomeReason;
	/** Earliest Clinically Appropriate Date - used on Decision To Treat for Cancer Referrals */
	private java.util.Date ecadDate;
	private Boolean admittedStop;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public AdminEvent (Integer id, int ver)
    {
    	super(id, ver);
    }
    public AdminEvent ()
    {
    	super();
    }
    public AdminEvent (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.pathways.domain.objects.AdminEvent.class;
	}


	public ims.core.clinical.domain.objects.RecordingUserInformation getRecordingDetails() {
		return recordingDetails;
	}
	public void setRecordingDetails(ims.core.clinical.domain.objects.RecordingUserInformation recordingDetails) {
		this.recordingDetails = recordingDetails;
	}

	public String getEventDetails() {
		return eventDetails;
	}
	public void setEventDetails(String eventDetails) {
		if ( null != eventDetails && eventDetails.length() > 500 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for eventDetails. Tried to set value: "+
				eventDetails);
		}
		this.eventDetails = eventDetails;
	}

	public ims.domain.lookups.LookupInstance getOutcome() {
		return outcome;
	}
	public void setOutcome(ims.domain.lookups.LookupInstance outcome) {
		this.outcome = outcome;
	}

	public ims.domain.lookups.LookupInstance getEventMethod() {
		return eventMethod;
	}
	public void setEventMethod(ims.domain.lookups.LookupInstance eventMethod) {
		this.eventMethod = eventMethod;
	}

	public ims.pathways.domain.objects.PathwaysRTTClockImpact getRTTClockImpact() {
		return rTTClockImpact;
	}
	public void setRTTClockImpact(ims.pathways.domain.objects.PathwaysRTTClockImpact rTTClockImpact) {
		this.rTTClockImpact = rTTClockImpact;
	}

	public ims.domain.lookups.LookupInstance getOutcomeReason() {
		return outcomeReason;
	}
	public void setOutcomeReason(ims.domain.lookups.LookupInstance outcomeReason) {
		this.outcomeReason = outcomeReason;
	}

	public java.util.Date getEcadDate() {
		return ecadDate;
	}
	public void setEcadDate(java.util.Date ecadDate) {
		this.ecadDate = ecadDate;
	}

	public Boolean isAdmittedStop() {
		return admittedStop;
	}
	public void setAdmittedStop(Boolean admittedStop) {
		this.admittedStop = admittedStop;
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
		
		auditStr.append("\r\n*recordingDetails* :");
		if (recordingDetails != null)
		{
			auditStr.append(toShortClassName(recordingDetails));
				
		    auditStr.append(recordingDetails.toString());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*eventDetails* :");
		auditStr.append(eventDetails);
	    auditStr.append("; ");
		auditStr.append("\r\n*outcome* :");
		if (outcome != null)
			auditStr.append(outcome.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*eventMethod* :");
		if (eventMethod != null)
			auditStr.append(eventMethod.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*rTTClockImpact* :");
		if (rTTClockImpact != null)
		{
			auditStr.append(toShortClassName(rTTClockImpact));
				
		    auditStr.append(rTTClockImpact.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*outcomeReason* :");
		if (outcomeReason != null)
			auditStr.append(outcomeReason.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*ecadDate* :");
		auditStr.append(ecadDate);
	    auditStr.append("; ");
		auditStr.append("\r\n*admittedStop* :");
		auditStr.append(admittedStop);
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
		
		String keyClassName = "AdminEvent";
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
		if (this.getRecordingDetails() != null)
		{
			sb.append("<recordingDetails>");
			sb.append(this.getRecordingDetails().toXMLString(domMap)); 	
			sb.append("</recordingDetails>");		
		}
		if (this.getEventDetails() != null)
		{
			sb.append("<eventDetails>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getEventDetails().toString()));
			sb.append("</eventDetails>");		
		}
		if (this.getOutcome() != null)
		{
			sb.append("<outcome>");
			sb.append(this.getOutcome().toXMLString()); 
			sb.append("</outcome>");		
		}
		if (this.getEventMethod() != null)
		{
			sb.append("<eventMethod>");
			sb.append(this.getEventMethod().toXMLString()); 
			sb.append("</eventMethod>");		
		}
		if (this.getRTTClockImpact() != null)
		{
			sb.append("<rTTClockImpact>");
			sb.append(this.getRTTClockImpact().toXMLString(domMap)); 	
			sb.append("</rTTClockImpact>");		
		}
		if (this.getOutcomeReason() != null)
		{
			sb.append("<outcomeReason>");
			sb.append(this.getOutcomeReason().toXMLString()); 
			sb.append("</outcomeReason>");		
		}
		if (this.getEcadDate() != null)
		{
			sb.append("<ecadDate>");
			sb.append(new ims.framework.utils.DateTime(this.getEcadDate()).toString(ims.framework.utils.DateTimeFormat.MILLI));
			sb.append("</ecadDate>");		
		}
		if (this.isAdmittedStop() != null)
		{
			sb.append("<admittedStop>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.isAdmittedStop().toString()));
			sb.append("</admittedStop>");		
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
			AdminEvent domainObject = getAdminEventfromXML(itemEl, factory, domMap);

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
			AdminEvent domainObject = getAdminEventfromXML(itemEl, factory, domMap);

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
		
	public static AdminEvent getAdminEventfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getAdminEventfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static AdminEvent getAdminEventfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!AdminEvent.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!AdminEvent.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the AdminEvent class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (AdminEvent)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(AdminEvent.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		AdminEvent ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (AdminEvent)factory.getImportedDomainObject(AdminEvent.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new AdminEvent();
		}
		String keyClassName = "AdminEvent";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (AdminEvent)impObj.getDomainObject();
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

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, AdminEvent obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("recordingDetails");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setRecordingDetails(ims.core.clinical.domain.objects.RecordingUserInformation.getRecordingUserInformationfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("eventDetails");
		if(fldEl != null)
		{	
    		obj.setEventDetails(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("outcome");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setOutcome(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("eventMethod");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setEventMethod(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("rTTClockImpact");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setRTTClockImpact(ims.pathways.domain.objects.PathwaysRTTClockImpact.getPathwaysRTTClockImpactfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("outcomeReason");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setOutcomeReason(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("ecadDate");
		if(fldEl != null)
		{	
    		obj.setEcadDate(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").parse(fldEl.getTextTrim()));
		}
		fldEl = el.element("admittedStop");
		if(fldEl != null)
		{	
    		obj.setAdmittedStop(new Boolean(fldEl.getTextTrim()));	
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
		public static final String RecordingDetails = "recordingDetails";
		public static final String EventDetails = "eventDetails";
		public static final String Outcome = "outcome";
		public static final String EventMethod = "eventMethod";
		public static final String RTTClockImpact = "rTTClockImpact";
		public static final String OutcomeReason = "outcomeReason";
		public static final String EcadDate = "ecadDate";
		public static final String AdmittedStop = "admittedStop";
	}
}

