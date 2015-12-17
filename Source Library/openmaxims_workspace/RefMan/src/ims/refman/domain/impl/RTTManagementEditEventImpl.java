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
// This code was generated by Michael Noonan using IMS Development Environment (version 1.80 build 5427.27524)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import java.util.List;

import ims.RefMan.domain.base.impl.BaseRTTManagementEditEventImpl;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.pathways.configuration.domain.objects.RTTStatusPoint;
import ims.pathways.domain.objects.PathwayRTTStatus;
import ims.pathways.vo.PathwayRTTStatusRefVo;
import ims.pathways.vo.PathwayRTTStatusVo;
import ims.pathways.vo.RTTStatusPointLiteVo;
import ims.pathways.vo.RTTStatusPointLiteVoCollection;
import ims.pathways.vo.domain.PathwayRTTStatusVoAssembler;
import ims.pathways.vo.domain.RTTStatusPointLiteVoAssembler;

public class RTTManagementEditEventImpl extends BaseRTTManagementEditEventImpl
{

	private static final long serialVersionUID = 1L;

	

	@Override
	public void saveRTTStatus(PathwayRTTStatusVo rttStatusVo) throws StaleObjectException {
		DomainFactory factory = getDomainFactory();
		PathwayRTTStatus statusDom = PathwayRTTStatusVoAssembler.extractPathwayRTTStatus(factory, rttStatusVo);
		factory.save(statusDom);
	}



	@Override
	public PathwayRTTStatusVo getRTTStatusFromRef(PathwayRTTStatusRefVo rttStatusRef) {
		DomainFactory factory = getDomainFactory();
		PathwayRTTStatus statusDom = (PathwayRTTStatus)factory.getDomainObject(rttStatusRef);
		return PathwayRTTStatusVoAssembler.create(statusDom);
	}



	@Override
	public RTTStatusPointLiteVoCollection listRelatedRTTStatusPoints(RTTStatusPointLiteVo statusPoint) {
		DomainFactory factory = getDomainFactory();
		if(statusPoint.getNationalCodeIsNotNull())
		{
			Integer startCode = statusPoint.getNationalCode() - (statusPoint.getNationalCode()%10);
			List<RTTStatusPoint> list = factory.find("select stp from RTTStatusPoint as stp where stp.nationalCode between :start and :stop",new String[]{"start","stop"},new Object[]{startCode,startCode+9});
			return RTTStatusPointLiteVoAssembler.createRTTStatusPointLiteVoCollectionFromRTTStatusPoint(list);
		}
		return null;
	}

}