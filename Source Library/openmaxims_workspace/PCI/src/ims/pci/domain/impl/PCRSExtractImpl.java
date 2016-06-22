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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.62 build 3126.20282)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.pci.domain.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

import ims.configuration.gen.ConfigFlag;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.utils.DateTime;
import ims.pci.domain.base.impl.BasePCRSExtractImpl;
import ims.pci.vo.ExportTransactionLogVo;
import ims.pci.vo.domain.ExportTransactionLogVoAssembler;

public class PCRSExtractImpl extends BasePCRSExtractImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* getLastExportedDate
	*/
	public ims.framework.utils.DateTime getLastExportedDate()
	{
		DomainFactory factory = getDomainFactory();

		List list = factory.find("select max (e1_1.dateGenerated) from ExportTransactionLog as e1_1"); 
		
		if(list == null || list.size() == 0)
			return null;
		
		java.util.Date maxdate = (Date) list.get(0);
		
		return maxdate == null ? null : new ims.framework.utils.DateTime(maxdate);
	}

	/**
	* ExportData
	 * @throws DomainInterfaceException 
	*/
	public String[] exportData(String prefix, String sessionId) throws DomainInterfaceException
	{
		DomainFactory domainFactory = getDomainFactory();
		
		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
		
		boolean csvFileCreatedImm = false;
		boolean csvFileCreatedReg = false;
		
		//registration report
		String regRep[] = getSystemReportAndTemplate(new Integer(116));
		
		if(regRep == null || regRep.length < 2)
		{
			throw new DomainInterfaceException("I could not get the Registration report and template !");	
		}
		
		if(regRep[0] == null || regRep[1] == null)
		{
			throw new DomainInterfaceException("The Registration report has not been deployed !");	
		}

		//immunisation report
		String immRep[] = getSystemReportAndTemplate(new Integer(117));
		
		if(immRep == null || immRep.length < 2)
		{
			throw new DomainInterfaceException("I could not get the Immunisation report and template !");	
		}
		
		if(immRep[0] == null || immRep[1] == null)
		{
			throw new DomainInterfaceException("The Immunisation report has not been deployed !");	
		}
		
		System.out.println("Starting PCRS extract..." + new Date());
		
		QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, sessionId);

		client.addSeed(new SeedValue("PREFIX", prefix, String.class));

		byte[] immTxt = null;
		try
		{
			immTxt = client.buildReport(immRep[0], immRep[1], urlReportServer, QueryBuilderClient.TXT, "", 1);
		} 
		catch (QueryBuilderClientException e1)
		{
			throw new DomainInterfaceException(e1);			
		}
		
		ArrayList<Integer> aId = new ArrayList<Integer>();
		StringBuilder sbImmId = new StringBuilder();
		
		immTxt = processImmunisationReport(immTxt, aId, sbImmId, prefix);
		
		byte[] regTxt = null;
		try
		{
			/*
			if(aId == null || aId.size() == 0)
			{
				client.addSeed(new SeedValue("ID", new Integer(0), Integer.class));
			}
			else
			{
				for (Integer id: aId)
				{
					client.addSeed(new SeedValue("ID", id, Integer.class));
				}
			}
			*/
			
			regTxt = client.buildReport(regRep[0], regRep[1], urlReportServer, QueryBuilderClient.TXT, "", 1);
		} 
		catch (QueryBuilderClientException e1)
		{
			throw new DomainInterfaceException(e1);			
		}
		
		
		StringBuilder sbRegId = new StringBuilder();
		
		regTxt = processRegistrationReport(regTxt, sbRegId, prefix);

		ExportTransactionLogVo exportVo = new ExportTransactionLogVo();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String folderName = getOutputFolder();
		Date now = new Date();
		String regFileName = /*folderName + */"REG_" + df.format(now) + ".txt"; 
		String immFileName = /*folderName + */"IMM_" + df.format(now) + ".txt";

		FileOutputStream fos = null;
		try
		{
			fos = new FileOutputStream(folderName + immFileName);
			fos.write(immTxt);
			fos.flush();
			fos.close();
			
			csvFileCreatedImm = true;
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			
			throw new DomainInterfaceException(e);	
		}

		try
		{
			fos = new FileOutputStream(folderName + regFileName);
			fos.write(regTxt);
			fos.flush();
			fos.close();
			
			csvFileCreatedReg = true;
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			
			if(csvFileCreatedImm)
			{
				deleteFile(folderName + immFileName);
			}
			
			throw new DomainInterfaceException(e);	
		}
		
		if(sbImmId.length() > 0 || sbRegId.length() > 0)
		{
			Connection conn = domainFactory.getJdbcConnection();
			
			try
			{
	
				// Get a statement from the connection
				Statement stmt = conn.createStatement();
	
				int rows;
				// Execute the Update
				if(sbImmId.length() > 0)
				{
					rows = stmt.executeUpdate("UPDATE pci_clientschestva SET isextracte = 1 WHERE id in(" + sbImmId + ")");
	
					// Print how many rows were modified
					System.out.println(rows + " Rows modified in 'pci_clientschestva' table");
				}

				if(sbRegId.length() > 0)
				{
					rows = stmt.executeUpdate("UPDATE core_commcaredet SET isextracte = 1 WHERE id in ( SELECT communityc from core_patient where id in (" + sbRegId + "))");
		
					// Print how many rows were modified
					System.out.println(rows + " Rows modified in 'core_commcaredet' table");
				}
				
				// Close the statement and the connection
				stmt.close();
				conn.close();
			}
			catch (SQLException se)
			{
				System.out.println("SQL Exception:");
	
				// Loop through the SQL Exceptions
				while (se != null)
				{
					System.out.println("State  : " + se.getSQLState());
					System.out.println("Message: " + se.getMessage());
					System.out.println("Error  : " + se.getErrorCode());
	
					se = se.getNextException();
				}
				
				deleteExtractFiles(csvFileCreatedImm, csvFileCreatedReg, folderName, regFileName, immFileName);
				
				throw new DomainInterfaceException(se);
				
			}
			catch (Exception e)
			{
				System.out.println(e);
				
				deleteExtractFiles(csvFileCreatedImm, csvFileCreatedReg, folderName, regFileName, immFileName);
				
				throw new DomainInterfaceException(e);
			}
		}
		
		exportVo.setDateGenerated(new DateTime());
		exportVo.setRegistrationFilename(regFileName);
		exportVo.setImmunisationFilename(immFileName);
		
		try
		{
			domainFactory.save(ExportTransactionLogVoAssembler.extractExportTransactionLog(domainFactory, exportVo));
		}
		catch (StaleObjectException e)
		{
			// this exception should never occur
			e.printStackTrace();
			
			deleteExtractFiles(csvFileCreatedImm, csvFileCreatedReg, folderName, regFileName, immFileName);
			
			throw new DomainInterfaceException(e);
		}
		
		System.out.println("Ending PCRS extract..." + new Date());
		
		return new String[] {new String(immTxt), new String(regTxt)};
	}

	private void deleteExtractFiles(boolean csvFileCreatedImm, boolean csvFileCreatedReg, String folderName, String regFileName, String immFileName)
	{
		if(csvFileCreatedImm)
		{
			deleteFile(folderName + immFileName);
		}

		if(csvFileCreatedReg)
		{
			deleteFile(folderName + regFileName);
		}
	}
	
	private byte[] processImmunisationReport(byte[] immTxt, ArrayList<Integer> aId, StringBuilder sbImmId, String prefix)
	{
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> mapId = new HashMap<String, String>();
		Map<String, String> mapImmId = new HashMap<String, String>();
		String line;
		
		if(immTxt == null)
			return null;
		
		for (int i = 0; i < immTxt.length; i++)
		{
			if(immTxt[i] == -1)
				immTxt[i] = ' ';
		}
		
		BufferedReader reader = new BufferedReader(new StringReader(new String(immTxt)));

		try
		{
			while ((line = reader.readLine()) != null)
			{
				if (line.length() > 0)
				{
					mapImmId.put(line.substring(0, 10).trim(), null);
					mapId.put(line.substring(10, 20).trim(), null);
					map.put(line.substring(20), null);
				}

			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}		
		
		Map<String, String> sortedMap = new TreeMap<String, String>(map);
		
		StringBuilder res = new StringBuilder();
		int t4 = 0,t5 = 0,t6 = 0,t7 = 0,t8 = 0,t9 = 0;
		
		for (Iterator iter = sortedMap.keySet().iterator(); iter.hasNext();)
		{
			String key = (String) iter.next();

			if(res.length() > 0)
				res.append("\r\n");
			
			res.append(key);
			
			if(key.length() > 0)
			{
				if(key.charAt(0) == '4')
					t4++;
				else if(key.charAt(0) == '5')
					t5++;
				else if(key.charAt(0) == '6')
					t6++;
				else if(key.charAt(0) == '7')
					t7++;
				else if(key.charAt(0) == '8')
					t8++;
				else if(key.charAt(0) == '9')
					t9++;
			}
		}
		
		StringBuilder header = new StringBuilder();
		SimpleDateFormat df = new SimpleDateFormat("MMyyyy");
		
		header.append(leftPad(prefix, 2));
		header.append(df.format(new Date()));
		header.append("I");
		header.append(leftPad(t4 + t5 + t6 + t7 + t8 + t9, 5));
		header.append(leftPad(t4, 4));
		header.append(leftPad(t5, 4));
		header.append(leftPad(t6, 4));
		header.append(leftPad(t7, 4));
		header.append(leftPad(t8, 4));
		header.append(leftPad(t9, 4));
		header.append("\r\n");
		header.append(res.toString());
		
		//process ids
		for (Iterator iter = mapId.keySet().iterator(); iter.hasNext();)
		{
			String key = (String) iter.next();
			
			aId.add(Integer.parseInt(key));
		}
		
		for (Iterator iter = mapImmId.keySet().iterator(); iter.hasNext();)
		{
			String id = (String) iter.next();
		
			if(sbImmId.length() > 0)
				sbImmId.append(",");
		
			sbImmId.append(id);
		}
		
		
		return header.toString().getBytes();
	}

	private byte[] processRegistrationReport(byte[] regTxt, StringBuilder sbId, String prefix)
	{
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> mapId = new HashMap<String, String>();
		String line;
		
		if(regTxt == null)
			return null;
		
		for (int i = 0; i < regTxt.length; i++)
		{
			if(regTxt[i] == -1)
				regTxt[i] = ' ';
		}
		
		BufferedReader reader = new BufferedReader(new StringReader(new String(regTxt)));

		try
		{
			while ((line = reader.readLine()) != null)
			{
				if (line.length() > 0)
				{
					mapId.put(line.substring(0, 10).trim(), null);
					map.put(line.substring(10), null);
				}

			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}		
		
		Map<String, String> sortedMap = new TreeMap<String, String>(map);
		
		StringBuilder res = new StringBuilder();
		int t0 = 0,t1 = 0,t2 = 0,t3 = 0;
		
		for (Iterator iter = sortedMap.keySet().iterator(); iter.hasNext();)
		{
			String key = (String) iter.next();

			if(res.length() > 0)
				res.append("\r\n");
			
			res.append(key);
			
			if(key.length() > 0)
			{
				if(key.charAt(0) == '0')
					t0++;
				else if(key.charAt(0) == '1')
					t1++;
				else if(key.charAt(0) == '2')
					t2++;
				else if(key.charAt(0) == '3')
					t3++;
			}
		}
		
		StringBuilder header = new StringBuilder();
		SimpleDateFormat df = new SimpleDateFormat("MMyyyy");
		
		header.append(leftPad(prefix, 2));
		header.append(df.format(new Date()));
		header.append("R");
		header.append(leftPad(t0 + t1 + t2 + t3, 5));
		header.append(leftPad(t1, 4));
		header.append(leftPad(t2, 4));
		header.append(leftPad(t3, 4));
		header.append(leftPad(t0, 4));
		header.append("\r\n");
		header.append(res.toString());
		
		//process ids
		for (Iterator iter = mapId.keySet().iterator(); iter.hasNext();)
		{
			String id = (String) iter.next();
		
			if(sbId.length() > 0)
				sbId.append(",");
		
			sbId.append(id);
		}
		
		
		return header.toString().getBytes();
	}
	
	private String getOutputFolder() throws DomainInterfaceException 
	{
		if ( System.getProperty("catalina.home") == null)
		{
			throw new DomainInterfaceException("The JVM parameter 'catalina.home' was not found !");				
		}
		
		String folderName = System.getProperty("catalina.home") + "/TransactionExport/";				
		File folder = new File(folderName);
		
		if(folder.exists() == false)
		{
			boolean bSuccess = folder.mkdir();
			
			if(bSuccess == false)
				throw new DomainInterfaceException("I could not create the folder '" + folder.getAbsolutePath() + "' !");
		}
		
		return folderName;
	}

	public String[] getSystemReportAndTemplate(Integer imsId)
	{
		String[] result = null;
		
		DomainFactory factory = getDomainFactory();
		
		List lst = factory.find("select r1_1.reportXml, t1_1.templateXml, r1_1.reportName, r1_1.reportDescription, t1_1.name, t1_1.description from ReportBo as r1_1 left join r1_1.templates as t1_1 where (r1_1.imsId= :imsid) order by t1_1.name", new String[] {"imsid"}, new Object[] {imsId});
		
		if(lst.iterator().hasNext())
		{
			Object[] obj = (Object[])lst.iterator().next();
			
			result = new String[] {(String)obj[0], (String)obj[1], (String)obj[2], (String)obj[3], (String)obj[4], (String)obj[5]};
		}
		
		return result;
	}
	
	private boolean deleteFile(String fileName)
	{
		boolean success = false;
		try
		{
			File f = new File(fileName);
			if(f.exists() && f.canWrite())
			{
				f.delete();
				success = true;
			}
		}
		catch(Exception ee)
		{
			
		}
		
		return success;
	}	
	
	private String leftPad(String val, int size)
	{
		StringBuilder sb = new StringBuilder(size);
		
		if(val.length() >= size)
			return val.substring(0, size);
		
		sb.append(val);
		
		for (int i = 0; i < size - val.length(); i++)
		{
			sb.append(" ");
		}
		
		return sb.toString();
	}
	
	private String leftPad(int val, int size)
	{
		return leftPad("" + val, size);
	}
	
}
