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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.ocrr.domain.impl;

import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.ocrr.domain.base.impl.BaseResultCommentsDialogImpl;
import ims.ocrr.orderingresults.domain.objects.OrderInvestigation;
import ims.ocrr.orderingresults.domain.objects.OrderSpecimen;
import ims.ocrr.orderingresults.domain.objects.ResultConclusionAndActionComment;
import ims.ocrr.orderingresults.vo.OrderInvestigationRefVo;
import ims.ocrr.orderingresults.vo.ResultConclusionAndActionCommentRefVo;
import ims.ocrr.vo.OcsPathRadResultVo;
import ims.ocrr.vo.ResultCommentsVo;
import ims.ocrr.vo.ResultCommentsVoCollection;
import ims.ocrr.vo.domain.ResultCommentsVoAssembler;
import ims.ocrr.vo.lookups.Category;



public class ResultCommentsDialogImpl extends BaseResultCommentsDialogImpl
{
	private static final long serialVersionUID = 1L;

	
	public ResultCommentsVoCollection listComments(OcsPathRadResultVo result)
	{
		if (result == null)
			return null;
		
		if (Category.PATHOLOGY.equals(result.getCategory()))
			return listCommentsFromOrderSpeciment(result);
		
		if (Category.CLINICALIMAGING.equals(result.getCategory()) || Category.CLINICAL.equals(result.getCategory())) //WDEV-16643
			return listCommentsFromOrderInvestigation(result);
		
		return null;
	}

	
	private ResultCommentsVoCollection listCommentsFromOrderInvestigation(OcsPathRadResultVo result)
	{
		if (result == null || !result.getOrderInvestigationIsNotNull() || !result.getOrderInvestigation().getID_OrderInvestigationIsNotNull())
			return null;
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT comm FROM OrderInvestigation AS inv LEFT JOIN inv.resultConclusionComments AS comm ");
		query.append("WHERE inv.id = :INV_ID");
		query.append(" order by comm.authoringInformation.authoringDateTime desc"); //WDEV-14077 
		
		return ResultCommentsVoAssembler.createResultCommentsVoCollectionFromResultConclusionAndActionComment(getDomainFactory().find(query.toString(), "INV_ID", result.getOrderInvestigation().getID_OrderInvestigation()));
	}

	private ResultCommentsVoCollection listCommentsFromOrderSpeciment(OcsPathRadResultVo result)
	{
		if (result == null || !result.getOrderInvestigationIsNotNull() || !result.getOrderInvestigation().getID_OrderInvestigationIsNotNull())
			return null;
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT comm FROM OrderInvestigation AS inv LEFT JOIN inv.specimen AS spec LEFT JOIN spec.resultConclusionComments AS comm ");
		query.append("WHERE inv.id = :INV_ID");
		query.append(" order by comm.authoringInformation.authoringDateTime desc"); //WDEV-14077 
		
		return ResultCommentsVoAssembler.createResultCommentsVoCollectionFromResultConclusionAndActionComment(getDomainFactory().find(query.toString(), "INV_ID", result.getOrderInvestigation().getID_OrderInvestigation()));
	}

	
	
	public ResultCommentsVo getComment(ResultConclusionAndActionCommentRefVo comment)
	{
		if (comment == null || !comment.getID_ResultConclusionAndActionCommentIsNotNull())
			return null;
		
		return ResultCommentsVoAssembler.create((ResultConclusionAndActionComment) getDomainFactory().getDomainObject(ResultConclusionAndActionComment.class, comment.getID_ResultConclusionAndActionComment()));
	}

	
	public ResultCommentsVo saveEdit(ResultCommentsVo comment) throws ims.domain.exceptions.StaleObjectException
	{
		if (comment == null)
			throw new DomainRuntimeException("Can not save empty record.");
		
		if (!comment.isValidated())
			throw new DomainRuntimeException("Record to save is not validated.");

		DomainFactory factory = getDomainFactory();

		ResultConclusionAndActionComment domComment = ResultCommentsVoAssembler.extractResultConclusionAndActionComment(factory, comment);
		
		// Check for stale comment (deleted)
		if (domComment == null)
			throw new StaleObjectException(domComment);
		
		factory.save(domComment);

		return ResultCommentsVoAssembler.create(domComment);
	}

	
	public ResultCommentsVo saveNew(OcsPathRadResultVo result, ResultCommentsVo comment) throws StaleObjectException
	{
		if (result == null)
			throw new DomainRuntimeException("Can not add comment to null parent.");

		
		if (Category.PATHOLOGY.equals(result.getCategory()))
			return saveNewCommentToOrderSpecimen(result, comment);
		
		
		if (Category.CLINICALIMAGING.equals(result.getCategory()) || Category.CLINICAL.equals(result.getCategory())) //WDEV-16643
			return saveNewCommentToOrderInvestigation(result, comment);
		
		return null;
	}

	
	@SuppressWarnings("unchecked")
	private ResultCommentsVo saveNewCommentToOrderInvestigation(OcsPathRadResultVo result, ResultCommentsVo comment) throws StaleObjectException
	{
		if (result == null || !result.getOrderInvestigationIsNotNull() || !result.getOrderInvestigation().getID_OrderInvestigationIsNotNull())
			throw new DomainRuntimeException("Can not add comment to null parent.");
		
		if (comment == null)
			throw new DomainRuntimeException("Can not save null comment record.");
		
		if (!comment.isValidated())
			throw new DomainRuntimeException("Comment record is not validated.");
		
		
		DomainFactory factory = getDomainFactory();
		
		// Extract comment domain object
		ResultConclusionAndActionComment domainComment = ResultCommentsVoAssembler.extractResultConclusionAndActionComment(factory, comment);
		// Commit comment to data base
		factory.save(domainComment);
		// Get order investigation from data base
		OrderInvestigation domOrderInvestigation = (OrderInvestigation) factory.getDomainObject(OrderInvestigation.class, result.getOrderInvestigation().getID_OrderInvestigation());
		domOrderInvestigation.getResultConclusionComments().add(domainComment);
		factory.save(domOrderInvestigation);

		// Return saved comment
		return ResultCommentsVoAssembler.create(domainComment);
	}


	@SuppressWarnings("unchecked")
	private ResultCommentsVo saveNewCommentToOrderSpecimen(OcsPathRadResultVo result, ResultCommentsVo comment) throws StaleObjectException
	{
		if (result == null || !result.getOrderInvestigationIsNotNull() || !result.getOrderInvestigation().getID_OrderInvestigationIsNotNull())
			throw new DomainRuntimeException("Can not add comment to null parent");
		
		if (comment == null)
			throw new DomainRuntimeException("Can not save null comment record.");
		
		if (!comment.isValidated())
			throw new DomainRuntimeException("Comment record is not validated");
		
		DomainFactory factory = getDomainFactory();
		
		// Extract comment domain object
		ResultConclusionAndActionComment domComment = ResultCommentsVoAssembler.extractResultConclusionAndActionComment(factory, comment);
		// Commit comment to data base
		factory.save(domComment);
		
		// Get order investigation from data base
		OrderInvestigation domOrderInvestigation = (OrderInvestigation) factory.getDomainObject(OrderInvestigation.class, result.getOrderInvestigation().getID_OrderInvestigation());
		// Get specimen domain object
		OrderSpecimen domSpecimen = (OrderSpecimen) domOrderInvestigation.getSpecimen().get(0);
		domSpecimen.getResultConclusionComments().add(domComment);
		factory.save(domSpecimen);

		// Return saved comment
		return ResultCommentsVoAssembler.create(domComment);
	}


	public void removeComment(OcsPathRadResultVo result, ResultCommentsVo comment) throws StaleObjectException, ForeignKeyViolationException
	{
		if (result == null)
			throw new DomainRuntimeException("Can not remove comment from null parent.");
		

		if (Category.PATHOLOGY.equals(result.getCategory()))
		{
			removeComentFromOrderSpecimen(result, comment);
			return;
		}
		
		if (Category.CLINICALIMAGING.equals(result.getCategory()))
		{
			removeCommentFromOrderInvestigation(result, comment);
			return;
		}
		
		return;
	}


	private void removeCommentFromOrderInvestigation(OcsPathRadResultVo result, ResultCommentsVo comment) throws StaleObjectException, ForeignKeyViolationException
	{
		if (result == null || !result.getOrderInvestigationIsNotNull() || !result.getOrderInvestigation().getID_OrderInvestigationIsNotNull())
			throw new DomainRuntimeException("Can not remove comment from null parent.");
		
		if (comment == null || !comment.getID_ResultConclusionAndActionCommentIsNotNull())
			throw new DomainRuntimeException("Can not remove unsaved comment.");
		
		DomainFactory factory = getDomainFactory();
		
		// Extract comment domain object
		ResultConclusionAndActionComment domComment = (ResultConclusionAndActionComment) factory.getDomainObject(ResultConclusionAndActionComment.class, comment.getID_ResultConclusionAndActionComment());
		
		// Check for stale comment (deleted or edited)
		if (domComment == null || domComment.getVersion() > comment.getVersion_ResultConclusionAndActionComment())
			throw new StaleObjectException(domComment);
		
		OrderInvestigation domOrderInv = (OrderInvestigation) factory.getDomainObject(OrderInvestigation.class, result.getOrderInvestigation().getID_OrderInvestigation());
		
		// Remove comment from order investigation comments
		domOrderInv.getResultConclusionComments().remove(domComment);
		factory.delete(domComment);
		factory.save(domOrderInv);
		
		return;
	}


	private void removeComentFromOrderSpecimen(OcsPathRadResultVo result, ResultCommentsVo comment) throws StaleObjectException, ForeignKeyViolationException
	{
		if (result == null || !result.getOrderInvestigationIsNotNull() || !result.getOrderInvestigation().getID_OrderInvestigationIsNotNull())
			throw new DomainRuntimeException("Can not remove comment from null parent.");
		
		if (comment == null || !comment.getID_ResultConclusionAndActionCommentIsNotNull())
			throw new DomainRuntimeException("Can not remove unsaved comment.");
		
		DomainFactory factory = getDomainFactory();
		
		// Extract comment domain object
		ResultConclusionAndActionComment domComment = (ResultConclusionAndActionComment) factory.getDomainObject(ResultConclusionAndActionComment.class, comment.getID_ResultConclusionAndActionComment());
		
		// Check for stale comment (deleted or edited)
		if (domComment == null || domComment.getVersion() > comment.getVersion_ResultConclusionAndActionComment())
			throw new StaleObjectException(domComment);
		
		OrderInvestigation domOrderInv = (OrderInvestigation) factory.getDomainObject(OrderInvestigation.class, result.getOrderInvestigation().getID_OrderInvestigation());
		OrderSpecimen domSpecimen = (OrderSpecimen) domOrderInv.getSpecimen().get(0);
		
		// Remove comment from order investigation comments
		domSpecimen.getResultConclusionComments().remove(domComment);
		factory.delete(domComment);
		factory.save(domOrderInv);
		
		return;
	}


	public OrderInvestigationRefVo getOrderInvestigation(OrderInvestigationRefVo investigation)
	{
		if (investigation == null || !investigation.getID_OrderInvestigationIsNotNull())
			return null;
		
		OrderInvestigation domInvestigation = (OrderInvestigation) getDomainFactory().getDomainObject(OrderInvestigation.class, investigation.getID_OrderInvestigation());
		
		return new OrderInvestigationRefVo(domInvestigation.getId(), domInvestigation.getVersion());
	}
}
