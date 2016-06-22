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
//PatientappointmentsRds.java : Generated by vpurdila on 08 Jul 2004 11:55.
//Java DTO script

package ims.rds.dto.script;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import ims.rds.dto.*;
import ims.dto.client.Patient;
import ims.dto.client.Sd_appt_dts;
import ims.dto.client.Resource;
import ims.dto.client.Sd_appt_dts.Sd_appt_dtsRecord;


public final class PatientappointmentsRds extends IMSReportDataSourceDTO
{
	private static final String COLLECTION = "Collection";
	
    public PatientappointmentsRds(ims.dto.DTODomain domain, String seed1, String seed2, String seed3)
    {
        super(domain);
        SEED_VALUE[0] = seed1;
        SEED_VALUE[1] = seed2;
        SEED_VALUE[2] = seed3;
    }

    //Seeds
    private String[] SEED = new String[] {"_PKEY_", "_APPT_DATE_", "_TODAY_"};
    private String[] SEED_VALUE = new String[3];

    //User variables declaration
    private String[] IMS_USERVAR = new String[] {"_PKEY_", "_APPT_DATE_", "_APPT_STAT_", "_TODAY_", "PAT_ADR1", "PAT_ADR2", "PAT_ADR3", "PAT_ADR4", "PAT_POST", "PAT_DTEL", "PAT_NTEL"};
    private String[] IMS_USERVAR_ALIAS = new String[] {"_PKEY_", "_APPT_DATE_", "_APPT_STAT_", "_TODAY_", "PAT_ADR1", "PAT_ADR2", "PAT_ADR3", "PAT_ADR4", "PAT_POST", "PAT_DTEL", "PAT_NTEL"};
    private String[] IMS_USERVAR_DESC = new String[] {"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__"};
    private ArrayList IMS_USERVAR_VALUE = new ArrayList();

    //Services declarations
	//Services declarations
	private String[] PATIENT = new String[] {"PKEY", "SNM", "FNM1", "TITL", "TITLTXT", "DOB", "NHSN", "HOSPNUM", "ADR1", "ADR2", "ADR3", "ADR4", "ADR5", "POST", "NTEL", "DTEL", "GPCD", "GPCDNAME", "GPADR1", "GPADR2", "GPADR3", "GPADR4", "GPADR5", "TADR1", "TADR2", "TADR3", "TADR4", "TPOST", "TDTEL", "TNTEL", "SEXTXT"};
	private String[] PATIENT_ALIAS = new String[] {"PATIENT.PKEY", "PATIENT.SNM", "PATIENT.FNM1", "PATIENT.TITL", "PATIENT.TITLTXT", "PATIENT.DOB", "PATIENT.NHSN", "PATIENT.HOSPNUM", "PATIENT.ADR1", "PATIENT.ADR2", "PATIENT.ADR3", "PATIENT.ADR4", "PATIENT.ADR5", "PATIENT.POST", "PATIENT.NTEL", "PATIENT.DTEL", "PATIENT.GPCD", "PATIENT.GPCDNAME", "PATIENT.GPADR1", "PATIENT.GPADR2", "PATIENT.GPADR3", "PATIENT.GPADR4", "PATIENT.GPADR5", "PATIENT.TADR1", "PATIENT.TADR2", "PATIENT.TADR3", "PATIENT.TADR4", "PATIENT.TPOST", "PATIENT.TDTEL", "PATIENT.TNTEL", "PATIENT.SEXTXT"};
	private String[] PATIENT_ATTR_DESC = new String[] {"__", "__", "__", "__", "__", "_D", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__"};
    private ArrayList PATIENT_VALUE = new ArrayList();
    private ArrayList PATIENT_FILTERS = new ArrayList();
    private ims.dto.client.Patient patientRds = null;
    private String[] SD_APPT_DTS = new String[] {"APPT_ID", "APPT_HEAD_ID", "PKEY", "STM", "APPT_DT", "APPT_STAT", "MODIDTXT", "MODENRGY", "MODENRGYUNITTXT", "ATTND_ASTXT", "TXCATTYPETXT", "ATT_TM", "LO_IDTXT", "APPT_STATTXT", "ATT_STATTXT", "APPT_CMTS", "SESS_DT", "PRTYTXT", "ACTION_IDTXT", "ACTIVITYTXT", "TRANS_TYPTXT", "PRFILE_SESS_IDTXT", "ACT_COMP_FLG", "MC_NM", "CONFIRM_STATTXT", "ACT_CONSULTTXT"};
    private String[] SD_APPT_DTS_ALIAS = new String[] {"SD_APPT_DTS.APPT_ID", "SD_APPT_DTS.APPT_HEAD_ID", "SD_APPT_DTS.PKEY", "SD_APPT_DTS.STM", "SD_APPT_DTS.APPT_DT", "SD_APPT_DTS.APPT_STAT", "SD_APPT_DTS.MODIDTXT", "SD_APPT_DTS.MODENRGY", "SD_APPT_DTS.MODENRGYUNITTXT", "SD_APPT_DTS.ATTND_ASTXT", "SD_APPT_DTS.TXCATTYPETXT", "SD_APPT_DTS.ATT_TM", "SD_APPT_DTS.LO_IDTXT", "SD_APPT_DTS.APPT_STATTXT", "SD_APPT_DTS.ATT_STATTXT", "SD_APPT_DTS.APPT_CMTS", "SD_APPT_DTS.SESS_DT", "SD_APPT_DTS.PRTYTXT", "SD_APPT_DTS.ACTION_IDTXT", "SD_APPT_DTS.ACTIVITYTXT", "SD_APPT_DTS.TRANS_TYPTXT", "SD_APPT_DTS.PRFILE_SESS_IDTXT", "SD_APPT_DTS.ACT_COMP_FLG", "SD_APPT_DTS.MC_NM", "SD_APPT_DTS.CONFIRM_STATTXT", "SD_APPT_DTS.ACT_CONSULTTXT"};
    private String[] SD_APPT_DTS_ATTR_DESC = new String[] {"__", "__", "__", "_T", "_D", "__", "__", "__", "__", "__", "__", "_T", "__", "__", "__", "__", "_D", "__", "__", "__", "__", "__", "__", "__", "__", "__"};
    private ArrayList SD_APPT_DTS_VALUE = new ArrayList();
    private ArrayList SD_APPT_DTS_FILTERS = new ArrayList();
    private ims.dto.client.Sd_appt_dts sd_appt_dtsRds = null;
    private String[] RESOURCE = new String[] {"RSNO", "NAME", "ADR1", "ADR2", "ADR3", "ADR4"};
    private String[] RESOURCE_ALIAS = new String[] {"RESOURCE.RSNO", "RESOURCE.NAME", "RESOURCE.ADR1", "RESOURCE.ADR2", "RESOURCE.ADR3", "RESOURCE.ADR4"};
    private String[] RESOURCE_ATTR_DESC = new String[] {"__", "__", "__", "__", "__", "__"};
    private ArrayList RESOURCE_VALUE = new ArrayList();
    private ArrayList RESOURCE_FILTERS = new ArrayList();
    private ims.dto.client.Resource resourceRds = null;

    //Init default values
    private void InitDefaultValues()
    {
        int i;

        patientRds = (Patient)domain.getDTOInstance(Patient.class);
        sd_appt_dtsRds = (Sd_appt_dts)domain.getDTOInstance(Sd_appt_dts.class);
        resourceRds = (Resource)domain.getDTOInstance(Resource.class);

        //init user variables
        IMS_USERVAR_VALUE.clear();
        for(i = 0; i < 11; i++)
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
        PATIENT_VALUE.clear();
        for(i = 0; i < 31; i++)
            PATIENT_VALUE.add(new ArrayList());
        SD_APPT_DTS_VALUE.clear();
        for(i = 0; i < 26; i++)
            SD_APPT_DTS_VALUE.add(new ArrayList());
        RESOURCE_VALUE.clear();
        for(i = 0; i < 6; i++)
            RESOURCE_VALUE.add(new ArrayList());

        int ix = 0;
        ArrayList al = null;
    }

    public void SetSeeds(String seed1, String seed2, String seed3)
    {
        SEED_VALUE[0] = seed1;
        SEED_VALUE[1] = seed2;
        SEED_VALUE[2] = seed3;
    }

    private boolean _internalGetData()
    {
        boolean bRet = true;

        //clear internal collections
        Clear();

        //init the default values first
        InitDefaultValues();

        //GET PATIENT
        PATIENT_FILTERS.clear();
        PATIENT_FILTERS.add("PKEY");
        CopyValue(PATIENT_VALUE, GetIndexByName("PKEY", PATIENT), (ArrayList)IMS_USERVAR_VALUE.get(GetIndexByName("_PKEY_", IMS_USERVAR)));
        bRet = CallService(patientRds, "PATIENT", "GET", PATIENT, PATIENT_ATTR_DESC, PATIENT_VALUE, PATIENT_FILTERS, false);
        //LIST SD_APPT_DTS
        SD_APPT_DTS_FILTERS.clear();
        SD_APPT_DTS_FILTERS.add("PKEY");
        SD_APPT_DTS_FILTERS.add("APPT_DT");
        SD_APPT_DTS_FILTERS.add("APPT_STAT");
        CopyValue(SD_APPT_DTS_VALUE, GetIndexByName("PKEY", SD_APPT_DTS), (ArrayList)IMS_USERVAR_VALUE.get(GetIndexByName("_PKEY_", IMS_USERVAR)));
        CopyValue(SD_APPT_DTS_VALUE, GetIndexByName("APPT_DT", SD_APPT_DTS), (ArrayList)IMS_USERVAR_VALUE.get(GetIndexByName("_APPT_DATE_", IMS_USERVAR)));
        CopyValue(SD_APPT_DTS_VALUE, GetIndexByName("APPT_STAT", SD_APPT_DTS), "!-2190||-2193");
        bRet = CallService(sd_appt_dtsRds, "SD_APPT_DTS", "LIST", SD_APPT_DTS, SD_APPT_DTS_ATTR_DESC, SD_APPT_DTS_VALUE, SD_APPT_DTS_FILTERS, false);
        //GET RESOURCE
        RESOURCE_FILTERS.clear();
        RESOURCE_FILTERS.add("RSNO");
        CopyValue(RESOURCE_VALUE, GetIndexByName("RSNO", RESOURCE), (ArrayList)PATIENT_VALUE.get(GetIndexByName("GPCD",PATIENT)));
        bRet = CallService(resourceRds, "RESOURCE", "GET", RESOURCE, RESOURCE_ATTR_DESC, RESOURCE_VALUE, RESOURCE_FILTERS, false);
        //Initialisation variable
        CopyValue(PATIENT_VALUE, GetIndexByName("GPADR1",PATIENT) , (ArrayList)RESOURCE_VALUE.get(GetIndexByName("ADR1",RESOURCE)));
        //Initialisation variable
        CopyValue(PATIENT_VALUE, GetIndexByName("GPADR2",PATIENT) , (ArrayList)RESOURCE_VALUE.get(GetIndexByName("ADR2",RESOURCE)));
        //Initialisation variable
        CopyValue(PATIENT_VALUE, GetIndexByName("GPADR3",PATIENT) , (ArrayList)RESOURCE_VALUE.get(GetIndexByName("ADR3",RESOURCE)));
        //Initialisation variable
        CopyValue(PATIENT_VALUE, GetIndexByName("GPADR4",PATIENT) , (ArrayList)RESOURCE_VALUE.get(GetIndexByName("ADR4",RESOURCE)));

		boolean bUseTempAddress = false;
		if(((ArrayList)(PATIENT_VALUE.get(GetIndexByName("TADR1",PATIENT)))).size() > 0)
			if(((String)((ArrayList)PATIENT_VALUE.get(GetIndexByName("TADR1",PATIENT))).get(0)).equals("") == false)
				bUseTempAddress = true;

		if(bUseTempAddress == true)
		{
			CopyValue(IMS_USERVAR_VALUE, GetIndexByName("PAT_ADR1",IMS_USERVAR) , ((ArrayList)PATIENT_VALUE.get(GetIndexByName("TADR1",PATIENT))));
			CopyValue(IMS_USERVAR_VALUE, GetIndexByName("PAT_ADR2",IMS_USERVAR) , ((ArrayList)PATIENT_VALUE.get(GetIndexByName("TADR2",PATIENT))));
			CopyValue(IMS_USERVAR_VALUE, GetIndexByName("PAT_ADR3",IMS_USERVAR) , ((ArrayList)PATIENT_VALUE.get(GetIndexByName("TADR3",PATIENT))));
			CopyValue(IMS_USERVAR_VALUE, GetIndexByName("PAT_ADR4",IMS_USERVAR) , ((ArrayList)PATIENT_VALUE.get(GetIndexByName("TADR4",PATIENT))));
			CopyValue(IMS_USERVAR_VALUE, GetIndexByName("PAT_POST",IMS_USERVAR) , ((ArrayList)PATIENT_VALUE.get(GetIndexByName("TPOST",PATIENT))));
			CopyValue(IMS_USERVAR_VALUE, GetIndexByName("PAT_DTEL",IMS_USERVAR) , ((ArrayList)PATIENT_VALUE.get(GetIndexByName("TDTEL",PATIENT))));
			CopyValue(IMS_USERVAR_VALUE, GetIndexByName("PAT_NTEL",IMS_USERVAR) , ((ArrayList)PATIENT_VALUE.get(GetIndexByName("TNTEL",PATIENT))));
		}
		else
		{
			CopyValue(IMS_USERVAR_VALUE, GetIndexByName("PAT_ADR1",IMS_USERVAR) , ((ArrayList)PATIENT_VALUE.get(GetIndexByName("ADR1",PATIENT))));
			CopyValue(IMS_USERVAR_VALUE, GetIndexByName("PAT_ADR2",IMS_USERVAR) , ((ArrayList)PATIENT_VALUE.get(GetIndexByName("ADR2",PATIENT))));
			CopyValue(IMS_USERVAR_VALUE, GetIndexByName("PAT_ADR3",IMS_USERVAR) , ((ArrayList)PATIENT_VALUE.get(GetIndexByName("ADR3",PATIENT))));
			CopyValue(IMS_USERVAR_VALUE, GetIndexByName("PAT_ADR4",IMS_USERVAR) , ((ArrayList)PATIENT_VALUE.get(GetIndexByName("ADR4",PATIENT))));
			CopyValue(IMS_USERVAR_VALUE, GetIndexByName("PAT_POST",IMS_USERVAR) , ((ArrayList)PATIENT_VALUE.get(GetIndexByName("POST",PATIENT))));
			CopyValue(IMS_USERVAR_VALUE, GetIndexByName("PAT_DTEL",IMS_USERVAR) , ((ArrayList)PATIENT_VALUE.get(GetIndexByName("DTEL",PATIENT))));
			CopyValue(IMS_USERVAR_VALUE, GetIndexByName("PAT_NTEL",IMS_USERVAR) , ((ArrayList)PATIENT_VALUE.get(GetIndexByName("NTEL",PATIENT))));
		}
        
        return bRet;
    }

    public String GetData()
    {
        boolean bRet = _internalGetData();

        //build results
        
        //list will have to be re-sorted based on SESS_DT and ATT_TM attributes
        ReSortList();
        BuildResult(PATIENT_ALIAS, PATIENT_ATTR_DESC, PATIENT_VALUE);
        BuildResult(SD_APPT_DTS_ALIAS, SD_APPT_DTS_ATTR_DESC, SD_APPT_DTS_VALUE);
        BuildResult(RESOURCE_ALIAS, RESOURCE_ATTR_DESC, RESOURCE_VALUE);
        BuildResult(IMS_USERVAR_ALIAS, IMS_USERVAR_DESC, IMS_USERVAR_VALUE);

        return Serialize();
    }

    private void ReSortList() 
    {
		java.util.List<Object> newList = new ArrayList<Object>();
		if (sd_appt_dtsRds.DataCollection != null && sd_appt_dtsRds.DataCollection.count() > 0)
		{
			
			for (int i=0; i<sd_appt_dtsRds.DataCollection.count(); i++)
			{
				// If the attendance time is only 4 digits, we need to prepend
				// and zero to it
				Sd_appt_dts.Sd_appt_dtsRecord appointment = sd_appt_dtsRds.DataCollection.get(i);
				if (appointment.Att_tm != null && appointment.Att_tm.length() == 5)
				{
					appointment.Att_tm = "0" + appointment.Att_tm;
				}
				newList.add(appointment);
			}
			
			Collections.sort(newList, new AppointmentListComparator());
			
			sd_appt_dtsRds.DataCollection.clear();
			// Convert back to appointments collection
			for (int i=0; i<newList.size(); i++)
			{
				sd_appt_dtsRds.DataCollection.add((Sd_appt_dtsRecord) newList.get(i));
			}
		}

		//put back into SD_APPT_DTS_VALUE
		Object objDataCollection = null;
		try
		{
			objDataCollection = sd_appt_dtsRds.getClass().getField("DataCollection").get(sd_appt_dtsRds);
		} 
		catch (SecurityException e1)
		{
			e1.printStackTrace();
			return;
		} 
		catch (NoSuchFieldException e1)
		{
			e1.printStackTrace();
			return;
		}
		catch(IllegalAccessException e)
		{
			e.printStackTrace();
			return;
		}
		
		//clear attr values
		for(int i = 0; i < SD_APPT_DTS_VALUE.size(); i++)
		{
			ArrayList al = (ArrayList)SD_APPT_DTS_VALUE.get(i);
			al.clear();
			SD_APPT_DTS_VALUE.set(i,al);
		}

		IterateCollection(objDataCollection,SD_APPT_DTS, SD_APPT_DTS_ATTR_DESC, SD_APPT_DTS_VALUE);
    	    
	}

    class AppointmentListComparator implements Comparator
    {
    	public int compare(Object obj1, Object obj2)
    	{
    		Sd_appt_dts.Sd_appt_dtsRecord voObj1 = (Sd_appt_dts.Sd_appt_dtsRecord)obj1;
    		Sd_appt_dts.Sd_appt_dtsRecord voObj2 = (Sd_appt_dts.Sd_appt_dtsRecord)obj2;
    		
    		// compare session date and attendance time
    		if (voObj1.Sess_dt != null && voObj2.Sess_dt != null)
    		{
    			int result =voObj1.Sess_dt.compareTo(voObj2.Sess_dt); 
    			if (result < 0)  // Negative voObj1 less than obj2
    				return -1;
    			else if (result > 0)  // Positive voObj1 greater than obj2
    				return 1;
    			else if (result == 0)  // Values Equal - check times
    			{
    				if (voObj1.Att_tm != null && voObj2.Att_tm != null)
    				{
    					int timeResult = voObj1.Att_tm.compareTo(voObj2.Att_tm);
    					if (timeResult < 0)
    						return -1;
    					else if (timeResult > 0)
    						return 1;
    					else 
    						return 0;
    				}
    			}
    		}
    		return 0;
    	}
    }
    
	private boolean IterateCollection(Object objDataCollection, String[] aAttr, String[] aAttrDescr, ArrayList aAttrValue)
	{
		String val = "";
		String colName = "";
		int ix = 0;
		
		Method countMethod = null;
		Method getMethod = null;
		Integer iCount = null;
		int nCount = 0;
		try
		{
			countMethod = objDataCollection.getClass().getDeclaredMethod("count", null);
			getMethod = objDataCollection.getClass().getDeclaredMethod("get", new Class[] {int.class});
			iCount = (Integer)countMethod.invoke(objDataCollection, null);
			
			nCount = iCount.intValue();
		} 
		catch (SecurityException e1)
		{
			e1.printStackTrace();
			
			return false;
		} 
		catch (NoSuchMethodException e1)
		{
			e1.printStackTrace();
			
			return false;
		}
		catch (IllegalAccessException e1)
		{
			e1.printStackTrace();
			
			return false;
		}
		catch (InvocationTargetException e1)
		{
			e1.printStackTrace();
			
			return false;
		}
		
		if(nCount == 0)
			return true;
		
		Field[] attributes = null;
		Object objRecord = null;
		
		for (int i = 0; i < nCount; i++)
		{
			try
			{
				objRecord = getMethod.invoke(objDataCollection, new Object[] {new Integer(i)});
			} 
			catch (IllegalArgumentException e)
			{
				e.printStackTrace();
				
				return false;
			} 
			catch (IllegalAccessException e)
			{
				e.printStackTrace();
				
				return false;
			} 
			catch (InvocationTargetException e)
			{
				e.printStackTrace();
				
				return false;
			}
			
			attributes = objRecord.getClass().getFields();
			
			for (int j = 0; j < attributes.length; j++)
			{
				colName = attributes[j].getName();
				if(colName.charAt(0) >= 'A' && colName.charAt(0) <= 'Z')
				{
					if(attributes[j].getType().getName().equals("java.lang.String") == true)
					{
						colName = colName.toUpperCase();
						ix = GetIndexByName(colName,aAttr);
						
						if(ix != -1)
						{
							try
							{
								val = (String)attributes[j].get(objRecord);
								ArrayList al = (ArrayList)aAttrValue.get(ix);
								al.add(val);
								aAttrValue.set(ix,al);
							} 
							catch (IllegalArgumentException e2)
							{
								e2.printStackTrace();
								
								return false;
							} 
							catch (IllegalAccessException e2)
							{
								e2.printStackTrace();
								
								return false;
							}
						}
					}
					else
					if(attributes[j].getType().getName().length() > COLLECTION.length() && attributes[j].getType().getName().endsWith(COLLECTION))
					{
						//this is a repeating group
						boolean bRet = false;
						try
						{
							bRet = IterateCollection(attributes[j].get(objRecord), aAttr, aAttrDescr, aAttrValue);
						} 
						catch (IllegalArgumentException e2)
						{
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IllegalAccessException e2)
						{
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						if(bRet == false)
							return false;
					}
				}
			}
		}
		
		return true;
	}
	
    public String GetStructuredData(String sName)
    {
        boolean bRet = _internalGetData();

        //build results
        BuildStructuredResult("PATIENT", PATIENT_ALIAS, PATIENT_ATTR_DESC, PATIENT_VALUE);
        BuildStructuredResult("SD_APPT_DTS", SD_APPT_DTS_ALIAS, SD_APPT_DTS_ATTR_DESC, SD_APPT_DTS_VALUE);
        BuildStructuredResult("RESOURCE", RESOURCE_ALIAS, RESOURCE_ATTR_DESC, RESOURCE_VALUE);
        BuildStructuredResult("IMS_USERVAR", IMS_USERVAR_ALIAS, IMS_USERVAR_DESC, IMS_USERVAR_VALUE);

        return SerializeStructuredData(sName);
    }
}
