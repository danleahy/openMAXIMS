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
// This code was generated by Brendan Woods using IMS Development Environment (version 1.20 build 40824.905)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.coe.forms.rptepisodesummary;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.lookups.PatIdType;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		String dsn = "";
		String host = "";
		String userName = "";
		String password = "";

		dsn = ConfigFlag.UI.REPORTS_DSN.getValue();
		host = ConfigFlag.UI.REPORTS_HOST.getValue();
		userName =  ConfigFlag.UI.REPORTS_USER.getValue();
		password = ConfigFlag.UI.REPORTS_PASS.getValue();
		
		String html = "";
		if(form.getGlobalContext().COE.getTransferNote() != null){
			PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue());
			Integer tran_id = form.getGlobalContext().COE.getTransferNote().getID_TransferNote();	
			String server = ConfigFlag.UI.REPORT_SERVER.getValue();
			html = "<IFRAME src='http://" + server + "/EpisodeSummary.asp?transferid=" + tran_id + "&idtype=" + dispIdType.getId() + "&dsn=" + dsn + "&host=" + host + "&userName=" + userName + "&password=" + password + "' style=\"width:100%; height:100%;\">";		
		}
		form.htm1().setHTML(html);
		
	}
}
