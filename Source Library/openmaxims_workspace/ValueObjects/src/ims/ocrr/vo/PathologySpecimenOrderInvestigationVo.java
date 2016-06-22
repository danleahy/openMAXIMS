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

package ims.ocrr.vo;

/**
 * Linked to OCRR.OrderingResults.OrderInvestigation business object (ID: 1070100002).
 */
public class PathologySpecimenOrderInvestigationVo extends ims.ocrr.orderingresults.vo.OrderInvestigationRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IOrderResultDisplay
{
	private static final long serialVersionUID = 1L;

	public PathologySpecimenOrderInvestigationVo()
	{
	}
	public PathologySpecimenOrderInvestigationVo(Integer id, int version)
	{
		super(id, version);
	}
	public PathologySpecimenOrderInvestigationVo(ims.ocrr.vo.beans.PathologySpecimenOrderInvestigationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.resultdemographics = bean.getResultDemographics() == null ? null : bean.getResultDemographics().buildVo();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo();
		this.repdatetime = bean.getRepDateTime() == null ? null : bean.getRepDateTime().buildDateTime();
		this.reptimesupplied = bean.getRepTimeSupplied();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.ordinvseq = bean.getOrdInvSeq();
		this.ordinvcurrentstatus = bean.getOrdInvCurrentStatus() == null ? null : bean.getOrdInvCurrentStatus().buildVo();
		this.passessecurity = bean.getPassesSecurity();
		this.specimen = ims.ocrr.vo.SpecimenNameVoCollection.buildFromBeanCollection(bean.getSpecimen());
		this.resultspecimentype = bean.getResultSpecimenType() == null ? null : bean.getResultSpecimenType().buildLookupInstVo();
		this.resultstatus = bean.getResultStatus() == null ? null : ims.ocrr.vo.lookups.ResultStatus.buildLookup(bean.getResultStatus());
		this.resultdetails = bean.getResultDetails() == null ? null : bean.getResultDetails().buildVo();
		this.expecteddatetime = bean.getExpectedDateTime() == null ? null : bean.getExpectedDateTime().buildDateTime();
		this.placerordnum = bean.getPlacerOrdNum();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.PathologySpecimenOrderInvestigationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.resultdemographics = bean.getResultDemographics() == null ? null : bean.getResultDemographics().buildVo(map);
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo(map);
		this.repdatetime = bean.getRepDateTime() == null ? null : bean.getRepDateTime().buildDateTime();
		this.reptimesupplied = bean.getRepTimeSupplied();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.ordinvseq = bean.getOrdInvSeq();
		this.ordinvcurrentstatus = bean.getOrdInvCurrentStatus() == null ? null : bean.getOrdInvCurrentStatus().buildVo(map);
		this.passessecurity = bean.getPassesSecurity();
		this.specimen = ims.ocrr.vo.SpecimenNameVoCollection.buildFromBeanCollection(bean.getSpecimen());
		this.resultspecimentype = bean.getResultSpecimenType() == null ? null : bean.getResultSpecimenType().buildLookupInstVo();
		this.resultstatus = bean.getResultStatus() == null ? null : ims.ocrr.vo.lookups.ResultStatus.buildLookup(bean.getResultStatus());
		this.resultdetails = bean.getResultDetails() == null ? null : bean.getResultDetails().buildVo(map);
		this.expecteddatetime = bean.getExpectedDateTime() == null ? null : bean.getExpectedDateTime().buildDateTime();
		this.placerordnum = bean.getPlacerOrdNum();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.PathologySpecimenOrderInvestigationVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.PathologySpecimenOrderInvestigationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.PathologySpecimenOrderInvestigationVoBean();
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
		if(fieldName.equals("RESULTDEMOGRAPHICS"))
			return getResultDemographics();
		if(fieldName.equals("INVESTIGATION"))
			return getInvestigation();
		if(fieldName.equals("REPDATETIME"))
			return getRepDateTime();
		if(fieldName.equals("REPTIMESUPPLIED"))
			return getRepTimeSupplied();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("ORDINVSEQ"))
			return getOrdInvSeq();
		if(fieldName.equals("ORDINVCURRENTSTATUS"))
			return getOrdInvCurrentStatus();
		if(fieldName.equals("PASSESSECURITY"))
			return getPassesSecurity();
		if(fieldName.equals("SPECIMEN"))
			return getSpecimen();
		if(fieldName.equals("RESULTSPECIMENTYPE"))
			return getResultSpecimenType();
		if(fieldName.equals("RESULTSTATUS"))
			return getResultStatus();
		if(fieldName.equals("RESULTDETAILS"))
			return getResultDetails();
		if(fieldName.equals("EXPECTEDDATETIME"))
			return getExpectedDateTime();
		if(fieldName.equals("PLACERORDNUM"))
			return getPlacerOrdNum();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getResultDemographicsIsNotNull()
	{
		return this.resultdemographics != null;
	}
	public ims.ocrr.vo.ResultDemographicsVo getResultDemographics()
	{
		return this.resultdemographics;
	}
	public void setResultDemographics(ims.ocrr.vo.ResultDemographicsVo value)
	{
		this.isValidated = false;
		this.resultdemographics = value;
	}
	public boolean getInvestigationIsNotNull()
	{
		return this.investigation != null;
	}
	public ims.ocrr.vo.PathologyInvestigationVo getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.PathologyInvestigationVo value)
	{
		this.isValidated = false;
		this.investigation = value;
	}
	public boolean getRepDateTimeIsNotNull()
	{
		return this.repdatetime != null;
	}
	public ims.framework.utils.DateTime getRepDateTime()
	{
		return this.repdatetime;
	}
	public void setRepDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.repdatetime = value;
	}
	public boolean getRepTimeSuppliedIsNotNull()
	{
		return this.reptimesupplied != null;
	}
	public Boolean getRepTimeSupplied()
	{
		return this.reptimesupplied;
	}
	public void setRepTimeSupplied(Boolean value)
	{
		this.isValidated = false;
		this.reptimesupplied = value;
	}
	public boolean getSysInfoIsNotNull()
	{
		return this.sysinfo != null;
	}
	public ims.vo.SystemInformation getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinfo = value;
	}
	public boolean getOrdInvSeqIsNotNull()
	{
		return this.ordinvseq != null;
	}
	public Integer getOrdInvSeq()
	{
		return this.ordinvseq;
	}
	public void setOrdInvSeq(Integer value)
	{
		this.isValidated = false;
		this.ordinvseq = value;
	}
	public boolean getOrdInvCurrentStatusIsNotNull()
	{
		return this.ordinvcurrentstatus != null;
	}
	public ims.ocrr.vo.OrderedInvestigationStatusVo getOrdInvCurrentStatus()
	{
		return this.ordinvcurrentstatus;
	}
	public void setOrdInvCurrentStatus(ims.ocrr.vo.OrderedInvestigationStatusVo value)
	{
		this.isValidated = false;
		this.ordinvcurrentstatus = value;
	}
	public boolean getPassesSecurityIsNotNull()
	{
		return this.passessecurity != null;
	}
	public Boolean getPassesSecurity()
	{
		return this.passessecurity;
	}
	public void setPassesSecurity(Boolean value)
	{
		this.isValidated = false;
		this.passessecurity = value;
	}
	public boolean getSpecimenIsNotNull()
	{
		return this.specimen != null;
	}
	public ims.ocrr.vo.SpecimenNameVoCollection getSpecimen()
	{
		return this.specimen;
	}
	public void setSpecimen(ims.ocrr.vo.SpecimenNameVoCollection value)
	{
		this.isValidated = false;
		this.specimen = value;
	}
	public boolean getResultSpecimenTypeIsNotNull()
	{
		return this.resultspecimentype != null;
	}
	public ims.vo.LookupInstVo getResultSpecimenType()
	{
		return this.resultspecimentype;
	}
	public void setResultSpecimenType(ims.vo.LookupInstVo value)
	{
		this.isValidated = false;
		this.resultspecimentype = value;
	}
	public boolean getResultStatusIsNotNull()
	{
		return this.resultstatus != null;
	}
	public ims.ocrr.vo.lookups.ResultStatus getResultStatus()
	{
		return this.resultstatus;
	}
	public void setResultStatus(ims.ocrr.vo.lookups.ResultStatus value)
	{
		this.isValidated = false;
		this.resultstatus = value;
	}
	public boolean getResultDetailsIsNotNull()
	{
		return this.resultdetails != null;
	}
	public ims.ocrr.vo.ResultDetailsForPathologySpecimenOrderInvestigationVo getResultDetails()
	{
		return this.resultdetails;
	}
	public void setResultDetails(ims.ocrr.vo.ResultDetailsForPathologySpecimenOrderInvestigationVo value)
	{
		this.isValidated = false;
		this.resultdetails = value;
	}
	public boolean getExpectedDateTimeIsNotNull()
	{
		return this.expecteddatetime != null;
	}
	public ims.framework.utils.DateTime getExpectedDateTime()
	{
		return this.expecteddatetime;
	}
	public void setExpectedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.expecteddatetime = value;
	}
	public boolean getPlacerOrdNumIsNotNull()
	{
		return this.placerordnum != null;
	}
	public String getPlacerOrdNum()
	{
		return this.placerordnum;
	}
	public static int getPlacerOrdNumMaxLength()
	{
		return 20;
	}
	public void setPlacerOrdNum(String value)
	{
		this.isValidated = false;
		this.placerordnum = value;
	}
	/**
	* IOrderResultDisplay interface methods
	*/
	public String getIOrderResultDisplayInvName()
	{
		if(investigation != null && investigation.getInvestigationIndexIsNotNull())
			return investigation.getInvestigationIndex().getName();
		
		return null;
	}
	public ims.ocrr.vo.lookups.InvestigationOrderability getIOrderResultDisplayOrderAbility()
	{
		if(investigation != null && investigation.getInvestigationIndexIsNotNull())
			return investigation.getInvestigationIndex().getOrderability();
		
		return null;
	}
	public ims.ocrr.vo.PathologyResultDetailVo getIOrderResultDisplayPathResultDetails()
	{
		if (resultdetails != null && resultdetails.pathologyresultdetails != null && resultdetails.pathologyresultdetails.size() >0)	//WDEV-16232
		{
			return resultdetails.pathologyresultdetails.get(0);
		}
					
		return null;//WDEV-16232
	}
	public ims.ocrr.vo.RadResultDetailsVo getIOrderResultDisplayRadResultDetails()
	{
		return null;
	}
	public ims.framework.utils.DateTime getIOrderResultDisplayRepDateTime()
	{
		return repdatetime;
	}
	public Boolean getIOrderResultDisplayRepTimeSupplied()
	{
		return reptimesupplied;
	}
	public ims.core.vo.LocationLiteVo getIOrderResultDisplayRequestedLocation()
	{
		return null;
	}
	public ims.ocrr.vo.lookups.OrderInvStatus getIOrderResultDisplayStatus()
	{
		if(ordinvcurrentstatus != null)
			return ordinvcurrentstatus.getOrdInvStatus();
		
		return null;
	}
	public ims.framework.utils.DateTime getIOrderResultDisplayHistoryDateTime()
	{
		return null;
	}
	public String getIOrderResultSpecimen()
	{
		if (this.specimen == null || this.specimen.size() == 0 || this.specimen.get(0) == null || this.specimen.get(0).specimensource == null)
				return null;
		
		// Specimen source is mandatory for OrderSpecimen
		return this.specimen.get(0).specimensource.getText();
	}
	
	public java.util.LinkedHashMap<ims.ocrr.vo.lookups.ResultEDSubtype, Object> getIOrderResultDisplayExtendedDataResult()
		{
			java.util.LinkedHashMap<ims.ocrr.vo.lookups.ResultEDSubtype, Object> dataStore = new java.util.LinkedHashMap<ims.ocrr.vo.lookups.ResultEDSubtype, Object>();
			java.util.ArrayList<java.util.HashMap<ims.ocrr.vo.lookups.ResultEDSubtype, StringBuilder>> jpegDataStore =  new java.util.ArrayList<java.util.HashMap<ims.ocrr.vo.lookups.ResultEDSubtype, StringBuilder>>();
			java.util.HashMap<ims.ocrr.vo.lookups.ResultEDSubtype, StringBuilder> jpegData = new java.util.HashMap<ims.ocrr.vo.lookups.ResultEDSubtype, StringBuilder>();
			
			String jpegStartSignature = "/9j"; 
			
			if(this.resultdetails != null && this.resultdetails.getPathologyResultDetails() != null && 
				this.resultdetails.getPathologyResultDetails().size() > 0 && 
					this.resultdetails.getPathologyResultDetails().get(0) != null &&
						this.resultdetails.getPathologyResultDetails().get(0).getResultComponentsIsNotNull() &&
							this.resultdetails.getPathologyResultDetails().get(0).getResultComponents().size() > 0 &&
								this.resultdetails.getPathologyResultDetails().get(0).getResultComponents().get(0) != null)			
			{
				
				for (int i = 0; i < this.resultdetails.getPathologyResultDetails().get(0).getResultComponents().size(); i++) 
				{
					PathologyResultComponentVo pathologyResultComponentVo = this.resultdetails.getPathologyResultDetails().get(0).getResultComponents().get(i);
					if (ims.ocrr.vo.lookups.ResultValueType.ED.equals(this.resultdetails.getPathologyResultDetails().get(0).getResultComponents().get(i).getResValType()))
					{				
						if (pathologyResultComponentVo.getEDSubTypeIsNotNull())//WDEV-16232
						{
							if (ims.ocrr.vo.lookups.ResultEDSubtype.RTF.equals(pathologyResultComponentVo.getEDSubType()))
							{
								StringBuilder value = (StringBuilder) dataStore.get(ims.ocrr.vo.lookups.ResultEDSubtype.RTF);
								
								if (value == null)
									value = new StringBuilder();
								
								if(pathologyResultComponentVo.getFormattedTextIsNotNull())
									value.append(ims.utils.Base64Coder.decode(pathologyResultComponentVo.getFormattedText()));	
								else if(pathologyResultComponentVo.getResultValIsNotNull())
									value.append(ims.utils.Base64Coder.decode(pathologyResultComponentVo.getResultVal()));
									
								dataStore.put(ims.ocrr.vo.lookups.ResultEDSubtype.RTF, value);
							}
							else if (ims.ocrr.vo.lookups.ResultEDSubtype.PDF.equals(pathologyResultComponentVo.getEDSubType()))
							{
								StringBuilder value = (StringBuilder) dataStore.get(ims.ocrr.vo.lookups.ResultEDSubtype.PDF);
								
								if (value == null)
									value = new StringBuilder();
								if(pathologyResultComponentVo.getFormattedTextIsNotNull())
									value.append(pathologyResultComponentVo.getFormattedText());
								else if(pathologyResultComponentVo.getResultValIsNotNull())
									value.append(pathologyResultComponentVo.getResultVal());
			
								dataStore.put(ims.ocrr.vo.lookups.ResultEDSubtype.PDF, value);
							}
							else if (ims.ocrr.vo.lookups.ResultEDSubtype.HTML.equals(pathologyResultComponentVo.getEDSubType()))
							{
								StringBuilder value = (StringBuilder) dataStore.get(ims.ocrr.vo.lookups.ResultEDSubtype.HTML);
								
								if (value == null)
									value = new StringBuilder();							
								if(pathologyResultComponentVo.getFormattedTextIsNotNull())
									value.append(ims.utils.Base64Coder.decode(pathologyResultComponentVo.getFormattedText()));	
								else if(pathologyResultComponentVo.getResultValIsNotNull())
									value.append(ims.utils.Base64Coder.decode(pathologyResultComponentVo.getResultVal()));
								
								dataStore.put(ims.ocrr.vo.lookups.ResultEDSubtype.HTML, value);
							}
							else if (ims.ocrr.vo.lookups.ResultEDSubtype.JPEG.equals(pathologyResultComponentVo.getEDSubType()))
							{
								dataStore.put(ims.ocrr.vo.lookups.ResultEDSubtype.JPEG, null);
							
								StringBuilder value = (StringBuilder) jpegData.get(ims.ocrr.vo.lookups.ResultEDSubtype.JPEG);
								if (value == null)
									value = new StringBuilder();
							
								if(pathologyResultComponentVo.getFormattedTextIsNotNull())
								{
									if (jpegData.keySet().size() > 0)
									{								
										if (pathologyResultComponentVo.getFormattedText().startsWith(jpegStartSignature))
										{										
											jpegDataStore.add(jpegData);
											jpegData = new java.util.HashMap<ims.ocrr.vo.lookups.ResultEDSubtype, StringBuilder>();
											value = new StringBuilder();										
											value.append(pathologyResultComponentVo.getFormattedText());
											jpegData.put(ims.ocrr.vo.lookups.ResultEDSubtype.JPEG, value);									
										}
										else
										{
											value.append(pathologyResultComponentVo.getFormattedText());
											jpegData.put(ims.ocrr.vo.lookups.ResultEDSubtype.JPEG, value);									
										}
									}
									else
									{			
										if (pathologyResultComponentVo.getFormattedText().startsWith(jpegStartSignature))
										{									
											jpegData = new java.util.HashMap<ims.ocrr.vo.lookups.ResultEDSubtype, StringBuilder>();
											value = new StringBuilder();									
											value.append(pathologyResultComponentVo.getFormattedText());
											jpegData.put(ims.ocrr.vo.lookups.ResultEDSubtype.JPEG, value);		
										}							
									}
								}							
								else if(pathologyResultComponentVo.getResultValIsNotNull())
								{
									if (jpegData.keySet().size() > 0)
									{																
										if (pathologyResultComponentVo.getResultVal().startsWith(jpegStartSignature))
										{	
											jpegDataStore.add(jpegData);
											jpegData = new java.util.HashMap<ims.ocrr.vo.lookups.ResultEDSubtype, StringBuilder>();	
											value = new StringBuilder();
											value.append(pathologyResultComponentVo.getResultVal());
											jpegData.put(ims.ocrr.vo.lookups.ResultEDSubtype.JPEG, value);									
										}
										else
										{
											value.append(pathologyResultComponentVo.getResultVal());
											jpegData.put(ims.ocrr.vo.lookups.ResultEDSubtype.JPEG, value);									
										}
									}
									else
									{		
										if (pathologyResultComponentVo.getResultVal().startsWith(jpegStartSignature))
										{									
											jpegData = new java.util.HashMap<ims.ocrr.vo.lookups.ResultEDSubtype, StringBuilder>();
											value = new StringBuilder();
											value.append(pathologyResultComponentVo.getResultVal());
											jpegData.put(ims.ocrr.vo.lookups.ResultEDSubtype.JPEG, value);		
										}								
									}
								}							
							}
						}
						else
						{
							StringBuilder value = (StringBuilder) dataStore.get(ims.ocrr.vo.lookups.ResultEDSubtype.RTF);
							
							if (value == null)
								value = new StringBuilder();
							if(pathologyResultComponentVo.getResultValIsNotNull())
								value.append(ims.utils.Base64Coder.decode(pathologyResultComponentVo.getResultVal()));
							else if(pathologyResultComponentVo.getFormattedTextIsNotNull())
								value.append(ims.utils.Base64Coder.decode(pathologyResultComponentVo.getFormattedText()));
							
							dataStore.put(ims.ocrr.vo.lookups.ResultEDSubtype.RTF, value);
						}
					}
				}
				
				if(jpegData.size() > 0 && !jpegDataStore.contains(jpegData))
					jpegDataStore.add(jpegData);			
					
				if (jpegDataStore.size() > 0)
					dataStore.put(ims.ocrr.vo.lookups.ResultEDSubtype.JPEG, jpegDataStore);
			}
				
			return dataStore;													
		}
	
	public String getIOrderResultLabSpecimenType()
	{
		if (this.resultspecimentype == null)
			return null;
			
		return this.resultspecimentype.getText();
	}
	
	public ims.ocrr.vo.lookups.InvType getIInvestigationType() 
	{
		if(this.investigation != null)
		{
			return this.investigation.type;
		}
			
		return null;
	}
		
	public ims.ocrr.vo.lookups.InvEventType getIInvestigationEventType() 
	{
		if(this.investigation != null)
		{
			return this.investigation.eventtype;
		}
			
		return null;
	}
	
	public ims.vo.interfaces.IOrderSpecimen[] getIOrderSpecimens() 
	{
		if(this.specimen != null)
		{
			this.specimen.sort(new OrderSpecimenComparator(ims.framework.enumerations.SortOrder.ASCENDING));// 	WDEV-16661
			return this.specimen.toIOrderSpecimenArray();
		}
			
		return null;
	}
	
	// 	WDEV-16232
	public ims.ocrr.vo.PathologyResultDetailVo getIOrderResultDisplayPathResultDetailsForDFT(ims.vo.interfaces.IOrderSpecimen orderSpecimen) 
	{
		if(orderSpecimen == null || orderSpecimen.getIOrderSpecimenId() == null)
			return null;
					
		if(this.resultdetails == null || this.resultdetails.pathologyresultdetails == null)
			return null;
					
		for(int x=0; x<this.resultdetails.pathologyresultdetails.size(); x++)
		{
			PathologyResultDetailVo pathResult = this.resultdetails.pathologyresultdetails.get(x);
						
			if(pathResult == null || pathResult.orderspecimen == null || pathResult.orderspecimen.getID_OrderSpecimen() == null)
				continue;
						
			if(pathResult.orderspecimen.getID_OrderSpecimen().equals(orderSpecimen.getIOrderSpecimenId()))
				return pathResult;
		}
					
		return null;
	}
	
	//WDEV-16661
	class OrderSpecimenComparator implements java.util.Comparator<SpecimenNameVo>
	{
		private int order =1;
		public OrderSpecimenComparator()
		{
			order = 1;
		}
		public OrderSpecimenComparator(ims.framework.enumerations.SortOrder order)
		{
			this.order = ims.framework.enumerations.SortOrder.DESCENDING.equals(order)?-1:1;
		}
		public int compare(SpecimenNameVo o1, SpecimenNameVo o2)
		{
			if (o1 != null && (o1.getCollDateTimeFiller() != null || o1.getReceivedDateTime() != null) && o2 != null && (o2.getCollDateTimeFiller() != null || o2.getReceivedDateTime() != null))
			{
				ims.framework.utils.DateTime o1Date = o1.getCollDateTimeFiller() != null ? o1.getCollDateTimeFiller() : o1.getReceivedDateTime();
				ims.framework.utils.DateTime o2Date = o2.getCollDateTimeFiller() != null ? o2.getCollDateTimeFiller() : o2.getReceivedDateTime();
					
				return order * o1Date.compareTo(o2Date);
			}
			if (o1 == null || (o1.getCollDateTimeFiller() == null && o1.getReceivedDateTime() == null))
				return -1*order;
			if (o2 == null || (o2.getCollDateTimeFiller() == null && o2.getReceivedDateTime() == null))
				return order;
				
			return 0;
		}	
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
		if(this.resultdemographics != null)
		{
			if(!this.resultdemographics.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.investigation != null)
		{
			if(!this.investigation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.ordinvcurrentstatus != null)
		{
			if(!this.ordinvcurrentstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.resultdetails != null)
		{
			if(!this.resultdetails.isValidated())
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
		if(this.resultdemographics != null)
		{
			String[] listOfOtherErrors = this.resultdemographics.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.investigation == null)
			listOfErrors.add("Investigation is mandatory");
		if(this.investigation != null)
		{
			String[] listOfOtherErrors = this.investigation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ordinvseq == null)
			listOfErrors.add("ordInvSeq is mandatory");
		if(this.ordinvcurrentstatus == null)
			listOfErrors.add("OrdInvCurrentStatus is mandatory");
		if(this.ordinvcurrentstatus != null)
		{
			String[] listOfOtherErrors = this.ordinvcurrentstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.resultdetails != null)
		{
			String[] listOfOtherErrors = this.resultdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.placerordnum != null)
			if(this.placerordnum.length() > 20)
				listOfErrors.add("The length of the field [placerordnum] in the value object [ims.ocrr.vo.PathologySpecimenOrderInvestigationVo] is too big. It should be less or equal to 20");
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
	
		PathologySpecimenOrderInvestigationVo clone = new PathologySpecimenOrderInvestigationVo(this.id, this.version);
		
		if(this.resultdemographics == null)
			clone.resultdemographics = null;
		else
			clone.resultdemographics = (ims.ocrr.vo.ResultDemographicsVo)this.resultdemographics.clone();
		if(this.investigation == null)
			clone.investigation = null;
		else
			clone.investigation = (ims.ocrr.vo.PathologyInvestigationVo)this.investigation.clone();
		if(this.repdatetime == null)
			clone.repdatetime = null;
		else
			clone.repdatetime = (ims.framework.utils.DateTime)this.repdatetime.clone();
		clone.reptimesupplied = this.reptimesupplied;
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		clone.ordinvseq = this.ordinvseq;
		if(this.ordinvcurrentstatus == null)
			clone.ordinvcurrentstatus = null;
		else
			clone.ordinvcurrentstatus = (ims.ocrr.vo.OrderedInvestigationStatusVo)this.ordinvcurrentstatus.clone();
		clone.passessecurity = this.passessecurity;
		if(this.specimen == null)
			clone.specimen = null;
		else
			clone.specimen = (ims.ocrr.vo.SpecimenNameVoCollection)this.specimen.clone();
		clone.resultspecimentype = this.resultspecimentype;
		if(this.resultstatus == null)
			clone.resultstatus = null;
		else
			clone.resultstatus = (ims.ocrr.vo.lookups.ResultStatus)this.resultstatus.clone();
		if(this.resultdetails == null)
			clone.resultdetails = null;
		else
			clone.resultdetails = (ims.ocrr.vo.ResultDetailsForPathologySpecimenOrderInvestigationVo)this.resultdetails.clone();
		if(this.expecteddatetime == null)
			clone.expecteddatetime = null;
		else
			clone.expecteddatetime = (ims.framework.utils.DateTime)this.expecteddatetime.clone();
		clone.placerordnum = this.placerordnum;
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(PathologySpecimenOrderInvestigationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PathologySpecimenOrderInvestigationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PathologySpecimenOrderInvestigationVo compareObj = (PathologySpecimenOrderInvestigationVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getOrdInvSeq() == null && compareObj.getOrdInvSeq() != null)
				return -1;
			if(this.getOrdInvSeq() != null && compareObj.getOrdInvSeq() == null)
				return 1;
			if(this.getOrdInvSeq() != null && compareObj.getOrdInvSeq() != null)
				retVal = this.getOrdInvSeq().compareTo(compareObj.getOrdInvSeq());
		}
		if (retVal == 0)
		{
			if(this.getSysInfo() == null && compareObj.getSysInfo() != null)
				return -1;
			if(this.getSysInfo() != null && compareObj.getSysInfo() == null)
				return 1;
			if(this.getSysInfo() != null && compareObj.getSysInfo() != null)
				retVal = this.getSysInfo().compareTo(compareObj.getSysInfo());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.resultdemographics != null)
			count++;
		if(this.investigation != null)
			count++;
		if(this.repdatetime != null)
			count++;
		if(this.reptimesupplied != null)
			count++;
		if(this.sysinfo != null)
			count++;
		if(this.ordinvseq != null)
			count++;
		if(this.ordinvcurrentstatus != null)
			count++;
		if(this.passessecurity != null)
			count++;
		if(this.specimen != null)
			count++;
		if(this.resultspecimentype != null)
			count++;
		if(this.resultstatus != null)
			count++;
		if(this.resultdetails != null)
			count++;
		if(this.expecteddatetime != null)
			count++;
		if(this.placerordnum != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 14;
	}
	protected ims.ocrr.vo.ResultDemographicsVo resultdemographics;
	protected ims.ocrr.vo.PathologyInvestigationVo investigation;
	protected ims.framework.utils.DateTime repdatetime;
	protected Boolean reptimesupplied;
	protected ims.vo.SystemInformation sysinfo;
	protected Integer ordinvseq;
	protected ims.ocrr.vo.OrderedInvestigationStatusVo ordinvcurrentstatus;
	protected Boolean passessecurity;
	protected ims.ocrr.vo.SpecimenNameVoCollection specimen;
	protected ims.vo.LookupInstVo resultspecimentype;
	protected ims.ocrr.vo.lookups.ResultStatus resultstatus;
	protected ims.ocrr.vo.ResultDetailsForPathologySpecimenOrderInvestigationVo resultdetails;
	protected ims.framework.utils.DateTime expecteddatetime;
	protected String placerordnum;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
