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
//This code is generated, please do not modify it.
//AppointmentsoverviewRds.java : Generated by vpurdila on 07 Jul 2004 11:33.
//Java DTO script

package ims.rds.dto.script;

import java.util.ArrayList;
import java.util.StringTokenizer;
import ims.rds.dto.*;
import ims.dto.Result;
import ims.dto.client.Sd_appt_misctrl;
import ims.dto.client.Sd_sess_avail;

public final class AppointmentsoverviewRds extends IMSReportDataSourceDTO
{
    public AppointmentsoverviewRds(ims.dto.DTODomain domain, String seed1, String seed2, String seed3, String seed4)
    {
        super(domain);
        SEED_VALUE[0] = seed1;
        SEED_VALUE[1] = seed2;
        SEED_VALUE[2] = seed3;
        SEED_VALUE[3] = seed4;
    }

    //Seeds
    private String[] SEED = new String[] {"TODAY", "SD_SESS_AVAIL.SESS_DT", "SD_SESS_AVAIL.GRP_ID", "SD_SESS_AVAIL.ACTIV_ID"};
    private String[] SEED_VALUE = new String[4];

    //User variables declaration
    private String[] IMS_USERVAR = new String[] {"H_LABEL", "H_DATE", "H_LOCATION", "H_NAME", "H_TOTAL", "H_FIRSTS", "TODAY"};
    private String[] IMS_USERVAR_ALIAS = new String[] {"H_LABEL", "H_DATE", "H_LOCATION", "H_NAME", "H_TOTAL", "H_FIRSTS", "TODAY"};
    private String[] IMS_USERVAR_DESC = new String[] {"__", "__", "__", "__", "__", "__", "__"};
    private ArrayList IMS_USERVAR_VALUE = new ArrayList();

    //Services declarations
    private String[] SD_APPT_MISCTRL = new String[] {"MAX_APPS", "REM_APPS", "SESSION_ID", "SESSIOND_ID", "APPT_STAT", "SESS_MCNM", "SESS_LCNM", "MC_ID", "TNO_FAPPTS", "APPT_ID", "ACTION_COUNT", "ACTION_TXT", "ACTION_ID"};
    private String[] SD_APPT_MISCTRL_ALIAS = new String[] {"SD_APPT_MISCTRL.MAX_APPS", "SD_APPT_MISCTRL.REM_APPS", "SD_APPT_MISCTRL.SESSION_ID", "SD_APPT_MISCTRL.SESSIOND_ID", "SD_APPT_MISCTRL.APPT_STAT", "SD_APPT_MISCTRL.SESS_MCNM", "SD_APPT_MISCTRL.SESS_LCNM", "SD_APPT_MISCTRL.MC_ID", "SD_APPT_MISCTRL.TNO_FAPPTS", "SD_APPT_MISCTRL.APPT_ID", "SD_APPT_MISCTRL.ACTION_COUNT", "SD_APPT_MISCTRL.ACTION_TXT", "SD_APPT_MISCTRL.ACTION_ID"};
    private String[] SD_APPT_MISCTRL_ATTR_DESC = new String[] {"__", "__", "__", "__", "__", "__", "__", "__", "__", "S_", "R_", "R_", "R_"};
    private ArrayList SD_APPT_MISCTRL_VALUE = new ArrayList();
    private ArrayList SD_APPT_MISCTRL_FILTERS = new ArrayList();
    private ims.dto.client.Sd_appt_misctrl sd_appt_misctrlRds = null;
    private String[] SD_SESS_AVAIL = new String[] {"SESS_DT", "TOTAL_TM", "REM_TM", "SESSD_STAT", "SESSD_ACT_IND", "GRP_ID", "ACTIV_ID", "LO_ID", "LO_SESSIOND_ID", "LO_ACT_IND", "MC_ID", "ACT_ID", "ACT_SESSIOND_ID", "ACTION_ACT_IND", "MAX_APPS", "REM_APPS", "SESSION_ID", "SESSIOND_ID", "SESSIOND_IDS"};
    private String[] SD_SESS_AVAIL_ALIAS = new String[] {"SD_SESS_AVAIL.SESS_DT", "SD_SESS_AVAIL.TOTAL_TM", "SD_SESS_AVAIL.REM_TM", "SD_SESS_AVAIL.SESSD_STAT", "SD_SESS_AVAIL.SESSD_ACT_IND", "SD_SESS_AVAIL.GRP_ID", "SD_SESS_AVAIL.ACTIV_ID", "SD_SESS_AVAIL.LO_ID", "SD_SESS_AVAIL.LO_SESSIOND_ID", "SD_SESS_AVAIL.LO_ACT_IND", "SD_SESS_AVAIL.MC_ID", "SD_SESS_AVAIL.ACT_ID", "SD_SESS_AVAIL.ACT_SESSIOND_ID", "SD_SESS_AVAIL.ACTION_ACT_IND", "SD_SESS_AVAIL.MAX_APPS", "SD_SESS_AVAIL.REM_APPS", "SD_SESS_AVAIL.SESSION_ID", "SD_SESS_AVAIL.SESSIOND_ID", "SD_SESS_AVAIL.SESSIOND_IDS"};
    private String[] SD_SESS_AVAIL_ATTR_DESC = new String[] {"_D", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__"};
    private ArrayList SD_SESS_AVAIL_VALUE = new ArrayList();
    private ArrayList SD_SESS_AVAIL_FILTERS = new ArrayList();
    private ims.dto.client.Sd_sess_avail sd_sess_availRds = null;

    //Init default values
    private void InitDefaultValues()
    {
        int i;

        sd_appt_misctrlRds = (Sd_appt_misctrl)domain.getDTOInstance(Sd_appt_misctrl.class);
        sd_sess_availRds = (Sd_sess_avail)domain.getDTOInstance(Sd_sess_avail.class);

        //init user variables
        IMS_USERVAR_VALUE.clear();
        for(i = 0; i < 7; i++)
        {
            IMS_USERVAR_VALUE.add(new ArrayList());

            for(int j = 0; j < SEED.length; j++)
            {
                if(SEED[j].equalsIgnoreCase(IMS_USERVAR[i]) == true)
                {
                    ArrayList al = (ArrayList)IMS_USERVAR_VALUE.get(i);
                    al.add(SEED_VALUE[j]);
                    IMS_USERVAR_VALUE.set(i,al);
                    break;
                }
            }
        }

        //init variables
        SD_APPT_MISCTRL_VALUE.clear();
        for(i = 0; i < 13; i++)
            SD_APPT_MISCTRL_VALUE.add(new ArrayList());
        SD_SESS_AVAIL_VALUE.clear();
        for(i = 0; i < 19; i++)
            SD_SESS_AVAIL_VALUE.add(new ArrayList());

        int ix = 0;
        ArrayList al = null;
        ix = GetIndexByName("SD_SESS_AVAIL.SESS_DT", SD_SESS_AVAIL);
        al = (ArrayList)SD_SESS_AVAIL_VALUE.get(ix);
        al.add(SEED_VALUE[GetIndexByName("SD_SESS_AVAIL.SESS_DT", SEED)]);
        SD_SESS_AVAIL_VALUE.set(ix,al);
        ix = GetIndexByName("SD_SESS_AVAIL.GRP_ID", SD_SESS_AVAIL);
        al = (ArrayList)SD_SESS_AVAIL_VALUE.get(ix);
        al.add(SEED_VALUE[GetIndexByName("SD_SESS_AVAIL.GRP_ID", SEED)]);
        SD_SESS_AVAIL_VALUE.set(ix,al);
        ix = GetIndexByName("SD_SESS_AVAIL.ACTIV_ID", SD_SESS_AVAIL);
        al = (ArrayList)SD_SESS_AVAIL_VALUE.get(ix);
        al.add(SEED_VALUE[GetIndexByName("SD_SESS_AVAIL.ACTIV_ID", SEED)]);
        SD_SESS_AVAIL_VALUE.set(ix,al);
    }

    public void SetSeeds(String seed1, String seed2, String seed3, String seed4)
    {
        SEED_VALUE[0] = seed1;
        SEED_VALUE[1] = seed2;
        SEED_VALUE[2] = seed3;
        SEED_VALUE[3] = seed4;
    }

    private boolean _internalGetData()
    {
        boolean bRet = true;

        //clear internal collections
        Clear();

        //init the default values first
        InitDefaultValues();

        //LIST SD_SESS_AVAIL
        SD_SESS_AVAIL_FILTERS.clear();
        SD_SESS_AVAIL_FILTERS.add("SESS_DT");
        SD_SESS_AVAIL_FILTERS.add("GRP_ID");
        SD_SESS_AVAIL_FILTERS.add("ACTIV_ID");
        bRet = CallService(sd_sess_availRds, "SD_SESS_AVAIL", "LIST", SD_SESS_AVAIL, SD_SESS_AVAIL_ATTR_DESC, SD_SESS_AVAIL_VALUE, SD_SESS_AVAIL_FILTERS, false);

		for(int x = 0; x<sd_sess_availRds.DataCollection.count(); x++)
		{	
			Sd_sess_avail.Sd_sess_availRecord session = sd_sess_availRds.DataCollection.get(x);

			String date = "";
			
			if(session.Sess_dt.length() == 8)
			{
				date = session.Sess_dt.substring(6,8) + "/" + session.Sess_dt.substring(4,6) + "/" + session.Sess_dt.substring(0,4);
			}
			
			((ArrayList)IMS_USERVAR_VALUE.get(GetIndexByName("H_LABEL", IMS_USERVAR))).add("");
			((ArrayList)IMS_USERVAR_VALUE.get(GetIndexByName("H_DATE", IMS_USERVAR))).add(date);
			((ArrayList)IMS_USERVAR_VALUE.get(GetIndexByName("H_LOCATION", IMS_USERVAR))).add("");
			
			String[] tmp = SplitString(session.Sessiond_ids,",+");
			for (int i = 0; i < (tmp.length / 2); ++i)
			{
				Sd_appt_misctrl machineControls = sd_appt_misctrlRds;
				machineControls.Filter.clear();
				machineControls.Filter.Session_id = tmp[2 * i];
				machineControls.Filter.Sessiond_id = tmp[2 * i + 1];					

				Result result = machineControls.get();
				if (result == null)
				{
					if (machineControls.DataCollection.count() == 1)
					{

						Sd_appt_misctrl.Sd_appt_misctrlRecord machineControl = machineControls.DataCollection.get(0);

						//Add the Location + Name + Toal + First
						((ArrayList)IMS_USERVAR_VALUE.get(GetIndexByName("H_LABEL", IMS_USERVAR))).add("");
						((ArrayList)IMS_USERVAR_VALUE.get(GetIndexByName("H_DATE", IMS_USERVAR))).add("");
						((ArrayList)IMS_USERVAR_VALUE.get(GetIndexByName("H_LOCATION", IMS_USERVAR))).add("Location: " + machineControl.Sess_lcnm + "; " +	"Machine Name: " + machineControl.Sess_mcnm + "; " +	"Total Number of Appointments: " + machineControl.Max_apps + "; " + "Number of First Appointments: " + machineControl.Tno_fappts);

						//Add the Action and the Count
						for(int j=0; j<machineControls.DataCollection.get(0).Action_idCollection.count(); j++)
						{
							((ArrayList)IMS_USERVAR_VALUE.get(GetIndexByName("H_LABEL", IMS_USERVAR))).add("");
							((ArrayList)IMS_USERVAR_VALUE.get(GetIndexByName("H_DATE", IMS_USERVAR))).add("");
							((ArrayList)IMS_USERVAR_VALUE.get(GetIndexByName("H_LOCATION", IMS_USERVAR))).add("               - Action: " + machineControls.DataCollection.get(0).Action_idCollection.get(j).Action_txt + ";  Count: "  + machineControls.DataCollection.get(0).Action_idCollection.get(j).Action_count);
						}
					}
				}
			}
		}
        
        return bRet;
    }

    public String GetData()
    {
        boolean bRet = _internalGetData();

        //build results
        BuildResult(SD_APPT_MISCTRL_ALIAS, SD_APPT_MISCTRL_ATTR_DESC, SD_APPT_MISCTRL_VALUE);
        BuildResult(SD_SESS_AVAIL_ALIAS, SD_SESS_AVAIL_ATTR_DESC, SD_SESS_AVAIL_VALUE);
        BuildResult(IMS_USERVAR_ALIAS, IMS_USERVAR_DESC, IMS_USERVAR_VALUE);

        return Serialize();
    }

    public String GetStructuredData(String sName)
    {
        boolean bRet = _internalGetData();

        //build results
        BuildStructuredResult("SD_APPT_MISCTRL", SD_APPT_MISCTRL_ALIAS, SD_APPT_MISCTRL_ATTR_DESC, SD_APPT_MISCTRL_VALUE);
        BuildStructuredResult("SD_SESS_AVAIL", SD_SESS_AVAIL_ALIAS, SD_SESS_AVAIL_ATTR_DESC, SD_SESS_AVAIL_VALUE);
        BuildStructuredResult("IMS_USERVAR", IMS_USERVAR_ALIAS, IMS_USERVAR_DESC, IMS_USERVAR_VALUE);

        return SerializeStructuredData(sName);
    }
    
	private String[] SplitString(String source, String token)
	{
		StringTokenizer st = new  StringTokenizer(source, token);
		
		int nCount = st.countTokens();
		
		if(nCount == 0)
			return null;
		
		String[] result = new String[nCount];
		
		for(int i = 0; i < nCount; i++)
			result[i] = st.nextToken();
		
		return result;
	}
    
}
