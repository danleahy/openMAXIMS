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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.45 build 2445.24540)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.forms.cumulateresults;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.ChartInvestigationCommentsVo;
import ims.core.vo.ChartResultVo;
import ims.core.vo.ChartResultVoCollection;
import ims.core.vo.ChartSpecimenCommentsVo;
import ims.core.vo.ChartValueCommentVo;
import ims.core.vo.ChartValueCommentVoCollection;
import ims.core.vo.ChartValueGroupVo;
import ims.core.vo.ChartValueGroupVoCollection;
import ims.core.vo.ChartValueSetVo;
import ims.core.vo.ChartValueVo;
import ims.core.vo.ChartValueVoCollection;
import ims.core.vo.DataSetTypeVo;
import ims.core.vo.enums.ChartingEvents;
import ims.core.vo.lookups.Sex;
import ims.domain.exceptions.DomainInterfaceException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.ocrr.configuration.vo.AnalyteRefVo;
import ims.ocrr.vo.ChartResultAnalyteVo;
import ims.ocrr.vo.ChartResultAnalyteVoCollection;
import ims.ocrr.vo.OrderInvestigationChartVo;
import ims.ocrr.vo.OrderResultCommentsVo;
import ims.ocrr.vo.OrderSpecimenChartVo;
import ims.ocrr.vo.PathResultDetailsCommentsVo;
import ims.ocrr.vo.PathologyResultDetailsForCumulateResultsVo;
import ims.ocrr.vo.ResultComponentCommentsVo;
import ims.ocrr.vo.ResultComponentCommentsVoCollection;
import ims.ocrr.vo.lookups.InvEventType;
import ims.ocrr.vo.lookups.OcsDisplayFlag;
import ims.ocrr.vo.lookups.ResultValueType;
import ims.vo.interfaces.IChartValueSet;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	private static final Integer VIEW_GRAPHICAL = new Integer(0);
	private static final Integer VIEW_TABULAR = new Integer(1);

	class DatasetAnalyte
	{
		private DataSetTypeVo dataset;
		private AnalyteRefVo analyte;
		private String refRange;
		
		public DatasetAnalyte(DataSetTypeVo dataset, AnalyteRefVo analyte, String refRange)
		{
			this.dataset = dataset;
			this.analyte = analyte;
			this.refRange = refRange;
		}
		
		public DataSetTypeVo getDataset()
		{
			return this.dataset;
		}
		public AnalyteRefVo getAnalyte()
		{
			return this.analyte;
		}
		public String getRefRange()
		{
			return this.refRange;
		}
	}
	
	protected void onFormOpen() throws PresentationLogicException 
	{
		initialize();	
		open();
		changeView(true);
	}
	
	protected void onCmbViewValueChanged() throws PresentationLogicException 
	{
		changeView(false);
	}
	
	private void changeView(boolean isFormOpen) throws PresentationLogicException 
	{
		if(form.cmbView().getValue() == null)
			form.cmbView().setValue(VIEW_TABULAR);
		
		if(form.cmbView().getValue().equals(VIEW_TABULAR))
		{
			form.customControl().switchToTabularView();
		}
		else
		{
			form.customControl().switchToGraphicalView();
		}
		
		if(!isFormOpen)
			search(); //WDEV-13834 
		
		form.imbConfigureChart().setVisible(form.cmbView().getValue() == null || form.cmbView().getValue().equals(VIEW_GRAPHICAL));
	}
	
	protected void onBtnSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		search();
	}
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}
	private void initialize()
	{
		form.customControl().initialize(Boolean.TRUE);
		
		if(form.getGlobalContext().Core.getPatientShortIsNotNull())
			form.getLocalContext().setPatientShort(form.getGlobalContext().Core.getPatientShort());
		else if(form.getGlobalContext().Core.getSecondPatientShortIsNotNull())
			form.getLocalContext().setPatientShort(form.getGlobalContext().Core.getSecondPatientShort());
		
		if(form.getGlobalContext().OCRR.getOrderInvestigationReferenceIsNotNull())
		{
			form.getLocalContext().setDFTOrderInvestigation(domain.getDTFOrderInvestigation(form.getGlobalContext().OCRR.getOrderInvestigationReference()));
		}
		
		if(isOrderInvestigationDTF())//WDEV-16232
		{
			form.customControl().setOrder(SortOrder.ASCENDING);
		}
		
		updateControlsState();
		
		form.btnClose().setEnabled(Boolean.FALSE.equals(ConfigFlag.UI.DISPLAY_INVESTIGATION_COMMENTS_ON_CUMULATE_RESULTS.getValue()));
		
		setupDefaultDateInterval();		
		setupGraphingView();		
	}
	
	private void updateControlsState() 
	{
		boolean isDTF = isOrderInvestigationDTF();
		
		form.lblFrom().setVisible(!isDTF);
		form.dteStart().setVisible(!isDTF);
		form.lblTo().setVisible(!isDTF);
		form.dteEnd().setVisible(!isDTF);
		
		form.btnSearch().setVisible(!isDTF);
	}
	
	private boolean isOrderInvestigationDTF() 
	{
		return form.getLocalContext().getDFTOrderInvestigationIsNotNull() && form.getLocalContext().getDFTOrderInvestigation().getInvestigationIsNotNull() && InvEventType.TIME_SERIES.equals(form.getLocalContext().getDFTOrderInvestigation().getInvestigation().getEventType());
	}
	
	private void open() throws PresentationLogicException
	{	
		search();
	}
	
	private void setupDefaultDateInterval() 
	{
		Date oneMonthBack = new Date().addMonth(-1);
		Date suppliedDate = form.getGlobalContext().OCRR.getResultDisplayDate();		
		Date date = oneMonthBack;
		
		if(suppliedDate != null)
		{
			Date advDate = new Date(suppliedDate);			
			advDate = advDate.addMonth(1);
			if(advDate.isLessOrEqualThan(new Date()))
				date = suppliedDate;
		}
		
		form.dteStart().setValue(date);
		
		form.dteEnd().setValue(new Date());
	}
	private void setupGraphingView()
	{
		form.cmbView().clear();
		
		if(ConfigFlag.UI.DISPLAY_GRAPHICAL_VIEW_ON_CUMULATIVE_RESULTS.getValue())//WDEV-16580
		{
			form.cmbView().newRow(VIEW_GRAPHICAL, "Graphical");
		}
		
		form.cmbView().newRow(VIEW_TABULAR, "Tabular");
		form.cmbView().setValue(VIEW_TABULAR);
		form.customControl().switchToTabularView();
		//wdev-11992
		form.customControl().readOnlyDynGrid(false);
		//------
	}
	private void search() throws PresentationLogicException
	{
		try 
		{
			ChartResultVoCollection results = null;
			boolean isDFT = isOrderInvestigationDTF();
			
			if(isDFT)
			{
				//WDEV-16618
				if(!selectedPatientSexIsKnown() && VIEW_GRAPHICAL.equals(form.cmbView().getValue()))
				{
					engine.showErrors("Search Error", new String[] {"The patient's sex is unknown."}); //WDEV-16931 as workaround
					return;
				}
				
				results = getResultsFromDFTOrderInvestigation(VIEW_TABULAR.equals(form.cmbView().getValue()));
			}
			else
			{
				if(!canSearch())
					return;
	
				results = domain.listResults(form.getLocalContext().getPatientShort(), form.getGlobalContext().OCRR.getCumulateAnalytes(), form.dteStart().getValue(), form.dteEnd().getValue(), VIEW_TABULAR.equals(form.cmbView().getValue()));//WDEV-16232
				
				if(results == null || results.size() == 0)//WDEV-15802
				{
					engine.showMessage("No records match your search criteria.");
				}
			}

			form.customControl().setValue(generateChartingValueSet(results, isDFT));
		} 
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
		}
	}
	
	private ChartResultVoCollection getResultsFromDFTOrderInvestigation(boolean isTabularView) 
	{
		if(form.getLocalContext().getDFTOrderInvestigation() == null || form.getLocalContext().getDFTOrderInvestigation().getResultDetails() == null || form.getLocalContext().getDFTOrderInvestigation().getResultDetails().getPathologyResultDetails() == null)
			return null;
		
		OrderInvestigationChartVo oi = domain.getOrderInvestigation(form.getLocalContext().getDFTOrderInvestigation());
		
		ChartResultVoCollection results = new ChartResultVoCollection();
		
		for(PathologyResultDetailsForCumulateResultsVo pathResult : form.getLocalContext().getDFTOrderInvestigation().getResultDetails().getPathologyResultDetails())
		{
			if(pathResult == null || pathResult.getResultComponents() == null)
				continue;
			
			for(ChartResultVo component : pathResult.getResultComponents())
			{
				if(component == null)
					continue;
				
				if(ResultValueType.NM.equals(component.getResValType()) || (isTabularView && (ResultValueType.SN.equals(component.getResValType()) || ResultValueType.ST.equals(component.getResValType()))))
				{
					component.setInvestigationData(oi);
					component.setSpecimenComments(pathResult.getOrderSpecimen());
					component.setPathologyResultId(pathResult.getID_PathResultDetails());
				
					results.add(component);
				}
			}
		}
		
		return results;
	}
	
	private ChartResultAnalyteVoCollection getAnalytes(ChartResultVoCollection results) throws PresentationLogicException
	{
		if(results == null)
			return new ChartResultAnalyteVoCollection();
		
		ChartResultAnalyteVoCollection analytes = new ChartResultAnalyteVoCollection();
		
		for(ChartResultVo result : results)
		{
			ChartResultAnalyteVo analyte = result.getAnalyte();

			if(analyte == null || analyte.getID_Analyte() == null)
				throw new PresentationLogicException("Invalid result analyte");
			
			analyte.setRefRange(result.getRefRange());
			
			if(analytes.indexOf(analyte) < 0)
				analytes.add(analyte);
		}
		
		return analytes;
	}
	private DatasetAnalyte[] getDatasetCollection(ChartResultAnalyteVoCollection analytes)
	{
		ArrayList<DatasetAnalyte> resultCollection = new ArrayList<DatasetAnalyte>();
		
		for(ChartResultAnalyteVo chartResultAnalyteVo : analytes)
		{
			DataSetTypeVo dataset = chartResultAnalyteVo.getDatasetType();
			resultCollection.add(new DatasetAnalyte(dataset, chartResultAnalyteVo, chartResultAnalyteVo.getRefRange()));
		}
		
		DatasetAnalyte[] result = new DatasetAnalyte[resultCollection.size()];
		for(int x = 0; x < resultCollection.size(); x++)
		{
			result[x] = resultCollection.get(x);
		}
		return result;
	}


	private IChartValueSet generateChartingValueSet(ChartResultVoCollection results, boolean isDFT) throws PresentationLogicException 
	{
		ChartValueSetVo set = new ChartValueSetVo();
		DatasetAnalyte[] datesetGroups = getDatasetCollection(getAnalytes(results));
		
		set.setTitle("Cumulative Results");
		
		if(form.dteStart().isVisible() && form.dteEnd().isVisible())
		{
			set.setSubTitle("From " + (form.dteStart().getValue() == null ? "?" : form.dteStart().getValue().toString()) + " to " + (form.dteEnd().getValue() == null ? "?" : form.dteEnd().getValue().toString()));
		}
		
		set.setDescription("");
		
		set.setBelowBandPercent(new Integer(20));
		set.setAboveBandPercent(new Integer(20));
		
		ChartValueGroupVoCollection groups = new ChartValueGroupVoCollection();
		for(int x = 0; x < datesetGroups.length; x++)
		{
			DataSetTypeVo dataset = datesetGroups[x].getDataset();
			
			if(dataset != null && dataset.getIsActiveIsNotNull() && dataset.getIsActive())
			{
				AnalyteRefVo currentAnalyte = datesetGroups[x].getAnalyte();
				
				ChartValueGroupVo group = new ChartValueGroupVo();
				
				group.setName(dataset.getName());
				
				group.setSortOrder(getAnalyteOrder(currentAnalyte));//WDEV-16232 
				
				if(dataset.getDefaultLineType() != null)
					group.setLineType(dataset.getDefaultLineType());
				if(dataset.getDefLineColPtIcon() != null)
				{
					group.setColor(dataset.getDefLineColPtIcon().getColor());
					group.setImage(dataset.getDefLineColPtIcon().getImage());
				}
				
				Float minValue = (selectedPatientIsMale() != null && selectedPatientIsMale().booleanValue())? dataset.getNormalBandMinValueMale() : dataset.getNormalBandMinValueFemale(); //WDEV-16232
				Float maxValue = (selectedPatientIsMale() != null && selectedPatientIsMale().booleanValue()) ? dataset.getNormalBandMaxValueMale() : dataset.getNormalBandMaxValueFemale();//WDEV-16232
				
				// Each dataset now has its own min/max factor, the chart min/max factor is ignored
				group.setMinFactor(dataset.getMinFactor());
				group.setMaxFactor(dataset.getMaxFactor());
				
				group.setMinValue(minValue);
				group.setMaxValue(maxValue);
				
				if (form.cmbView().getValue().equals(VIEW_TABULAR))
					group.setRefRange(datesetGroups[x].getRefRange() == null ? "-" : datesetGroups[x].getRefRange());
				else
					group.setRefRange((minValue == null ? "?" : minValue.toString()) + "-" + (maxValue == null ? "?" : maxValue.toString()));

				group.setUnits(dataset.getUnitOfMeasure() == null ? "?" : dataset.getUnitOfMeasure().getText());
			
				ChartValueVoCollection values = new ChartValueVoCollection();
				for(int y = 0; y < results.size(); y++)
				{
					ChartResultVo chartResult = results.get(y); 
					if(chartResult != null && chartResult.getAnalyte() != null && chartResult.getAnalyte().equals(currentAnalyte))
					{					
						ChartValueVo value = new ChartValueVo();	
						
						//WDEV-16232 - starts here
						if(chartResult.getSpecimenComments() != null)
						{
							if(chartResult.getSpecimenComments().getCollDateTimeFiller() != null)
							{
								value.setDate(chartResult.getObsDateTime() != null ? chartResult.getObsDateTime() : chartResult.getSpecimenComments().getCollDateTimeFiller()); //WDEV-19986
								value.setIsTimeSuplied(chartResult.getSpecimenComments().getColTimeFillerSupplied());
							}
							else
							{
								value.setDate(chartResult.getSpecimenComments().getReceivedDateTime());
								value.setIsTimeSuplied(chartResult.getSpecimenComments().getReceivedTimeSupplied());
								value.setIsReceivedDateTime(true);
							}
						}
						//WDEV-16232 - ends here
						
						value.setIsAbnormal(chartResult.getIsAbnormal());
						value.setSpecimenSource(chartResult.getSpecimenSource());
						value.setResultSpecimenType(chartResult.getResultSpecimenType());
						value.setRefRange(chartResult.getRefRange());
						value.setUnitOfMeasure(chartResult.getUnitOfMeasure());
						
						ResultComponentCommentsVoCollection comments = chartResult.getComments();
						if(comments != null)
						{
							ChartValueCommentVoCollection valueComments = new ChartValueCommentVoCollection();

							for(int z = 0; z < comments.size(); z++)
							{
								if(comments.get(z) != null)
								{
									//http://jira/browse/WDEV-12250 CHANGED TO USE LOCAL LOOP VARIABLE
									ChartValueCommentVo valueComment = new ChartValueCommentVo();
									
									valueComment.setSource(comments.get(z).getCmtSrc());
									valueComment.setText(comments.get(z).getCmtText());
									if(comments.get(z).getCommentType() != null)
									{
										valueComment.setType(comments.get(z).getCommentType().getText());
									}
								
									valueComments.add(valueComment);
								}
							}
							
							value.setComments(valueComments);
						}
						
						
						OrderInvestigationChartVo investigation = chartResult.getInvestigationData();

						if (investigation != null && investigation.getResultDetails() != null && investigation.getResultDetails().getPathologyResultDetails() != null && investigation.getResultDetails().getPathologyResultDetails().size() > 0)//WDEV-16232
						{
							ChartInvestigationCommentsVo investigationData = new ChartInvestigationCommentsVo();
							
							investigationData.setInvestigationName(investigation.getInvestigation().getInvestigationIndex().getName());
							investigationData.setLabOrderNo(getLabOrderNo(chartResult));//WDEV-16232
							
							if(isDFT)//WDEV-16493
							{
								investigationData.setDate(chartResult.getSpecimenComments() != null ? chartResult.getSpecimenComments().getCollDateTimeFiller() : null);
								investigationData.setDisplayFlag(OcsDisplayFlag.SPEC_COLL.getText());
							}
							else
							{
								investigationData.setDate(investigation.getDisplayDateTime());
								investigationData.setDisplayFlag(investigation.getDisplayFlag() != null ? investigation.getDisplayFlag().getText() : null);
							}
							investigationData.setInvestigationID(investigation.getID_OrderInvestigation());
							investigationData.setIsDFT(isDFT);
							investigationData.setPathologyResultId(chartResult.getPathologyResultId());
							
							investigationData.setInvestigationComments(new ChartValueCommentVoCollection());
							
							
							PathResultDetailsCommentsVo pathResult= getPathResultComments(chartResult);
							
							if(pathResult != null)
							{
								for (OrderResultCommentsVo orderComment : pathResult.getResultComments())//WDEV-16232
								{
									ChartValueCommentVo investigationComment = new ChartValueCommentVo();
									
									investigationComment.setSource(orderComment.getCmtSrc());
									investigationComment.setText(orderComment.getCmtText());
									investigationComment.setType(orderComment.getCommentType() != null ? orderComment.getCommentType().getText() : null);
									
									investigationData.getInvestigationComments().add(investigationComment);
								}
							}
							
							value.setInvestigationComments(investigationData);
						}
						
						if (chartResult.getSpecimenComments() != null && chartResult.getSpecimenComments().getLabSpecComments() != null)
						{
							ChartSpecimenCommentsVo specimenData = new ChartSpecimenCommentsVo();
							
							specimenData.setSpecimenType(chartResult.getSpecimenComments().getSpecimenSource() != null ? chartResult.getSpecimenComments().getSpecimenSource().getText() : "Not specified");
							specimenData.setSpecimenComments(new ChartValueCommentVoCollection());
							
							for (ResultComponentCommentsVo orderSpecimenComment : chartResult.getSpecimenComments().getLabSpecComments())
							{
								ChartValueCommentVo specimenComment = new ChartValueCommentVo();
								
								specimenComment.setSource(orderSpecimenComment.getCmtSrc());
								specimenComment.setText(orderSpecimenComment.getCmtText());
								specimenComment.setType(orderSpecimenComment.getCommentType() != null ? orderSpecimenComment.getCommentType().getText() : null);
								
								specimenData.getSpecimenComments().add(specimenComment);
							}
							
							value.setSpecimenComments(specimenData);
						}
						
						value.setValueString(chartResult.getResultVal());
						
						try
						{
							value.setValue(new Float(Float.parseFloat(chartResult.getResultVal())));
						}
						catch(Exception ex)
						{						
						}

						values.add(value);
					}
				}
				group.setValues(values);
				groups.add(group);
			}
		}
		set.setGroups(groups);
		
		return set;
	}

	private Integer getAnalyteOrder(AnalyteRefVo currentAnalyte) //WDEV-16232 
	{
		if(currentAnalyte == null || form.getGlobalContext().OCRR.getCumulateAnalytes() == null)
			return null;
		
		for(int i=0; i<form.getGlobalContext().OCRR.getCumulateAnalytes().size(); i++)
		{
			if(currentAnalyte.equals(form.getGlobalContext().OCRR.getCumulateAnalytes().get(i)))
			{
				return i;
			}
		}
		
		return null;
	}

	private PathResultDetailsCommentsVo getPathResultComments(ChartResultVo chartResult) 
	{
		if(chartResult == null || chartResult.getInvestigationData() == null || chartResult.getInvestigationData().getResultDetails() == null || chartResult.getInvestigationData().getResultDetails().getPathologyResultDetails() == null || chartResult.getInvestigationData().getResultDetails().getPathologyResultDetails().size() == 0)
			return null;
		
		if(chartResult.getInvestigationData().getResultDetails().getPathologyResultDetails().size() == 1)
			return chartResult.getInvestigationData().getResultDetails().getPathologyResultDetails().get(0);
		
		if(chartResult.getPathologyResultId() == null)
			return null;
		
		for(PathResultDetailsCommentsVo pathR : chartResult.getInvestigationData().getResultDetails().getPathologyResultDetails())
		{
			if(chartResult.getPathologyResultId().equals(pathR.getID_PathResultDetails()))
				return pathR;
		}
		
		return null;
	}

	private String getLabOrderNo(ChartResultVo chartResult) 
	{
		if(chartResult == null || chartResult.getInvestigationData() == null || chartResult.getInvestigationData().getSpecimen() == null || chartResult.getInvestigationData().getSpecimen().size() == 0)
			return null;
		
		if(chartResult.getInvestigationData().getSpecimen().size() == 1 && chartResult.getInvestigationData().getSpecimen().get(0) != null)
			return chartResult.getInvestigationData().getSpecimen().get(0).getFillerOrdNum();
		
		for(OrderSpecimenChartVo spec : chartResult.getInvestigationData().getSpecimen())
		{
			if(chartResult.getSpecimenComments() != null && chartResult.getSpecimenComments().getID_OrderSpecimen().equals(spec.getID_OrderSpecimen()))
			{
				return spec.getFillerOrdNum();
			}
		}
		
		return null;
	}
	
	private boolean canSearch()
	{
		ArrayList<String> errors = new ArrayList<String>();
		
		if(!selectedPatientSexIsKnown() && VIEW_GRAPHICAL.equals(form.cmbView().getValue()))
			errors.add("The patient's sex is unknown"); //WDEV-16931 - misspellings
		if(form.dteStart().getValue() == null)
			errors.add("'From' date is mandatory");//WDEV-15802
		if(form.dteEnd().getValue() == null)
			errors.add("'To' date is mandatory");//WDEV-15802
		if (form.dteStart().getValue() != null && form.dteEnd().getValue() != null && form.dteStart().getValue().isGreaterThan(form.dteEnd().getValue()))
		{
			errors.add("'From' date cannot be later than 'To' date");
		}
		
		if(errors.size() > 0)
		{
			String[] errorList = new String[errors.size()];
			for(int x = 0; x < errors.size(); x++)
			{
				errorList[x] = errors.get(x);			
			}
			
			engine.showErrors("Search Error", errorList);
			return false;
		}
		
		return true;
	}
	private boolean selectedPatientSexIsKnown()
	{
		if(form.getLocalContext().getPatientShort() == null)
			return false;
		if(form.getLocalContext().getPatientShort().getSex() == null)
			return false;
		if(form.getLocalContext().getPatientShort().getSex().equals(Sex.MALE))
			return true;
		if(form.getLocalContext().getPatientShort().getSex().equals(Sex.FEMALE))
			return true;
		
		return false;
	}
	private Boolean selectedPatientIsMale()
	{
		if(!selectedPatientSexIsKnown())
			return null;
		
		if(form.getLocalContext().getPatientShort().getSex().equals(Sex.MALE))
			return Boolean.TRUE;
		
		return Boolean.FALSE;
	}
	protected void onCustomControlValueChanged() throws PresentationLogicException 
	{
		if (ChartingEvents.ENABLE_CLOSE.equals(form.customControl().getCustomEvent()))
		{
			form.btnClose().setEnabled(true);
			form.customControl().clearCustomEvent();
		}
		else if (ChartingEvents.DISABLE_CLOSE.equals(form.customControl().getCustomEvent()))
		{
			form.btnClose().setEnabled(false);
			form.customControl().clearCustomEvent();
		}	

		form.imbConfigureChart().setEnabled(form.customControl().canSelectGroups().booleanValue());
	}
	protected void onImbConfigureChartClick() throws PresentationLogicException 
	{
		if(!selectedPatientSexIsKnown() && VIEW_GRAPHICAL.equals(form.cmbView().getValue())) //WDEV-16876
		{
			engine.showErrors("Search Error", new String[]{"The patient's sex is unknown."}); //WDEV-16931 as workaround
			return;
		}
		form.getGlobalContext().OCRR.setSelectGroupsInViewGraphic(Boolean.TRUE); //wdev-13893
		form.customControl().selectGroups();
	}
}
