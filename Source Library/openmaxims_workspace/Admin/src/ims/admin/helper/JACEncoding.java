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
package ims.admin.helper;

import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.IExternalEncodingProvider;

/*
Encoding the parameter string
A simple encryption algorithm is used to encode the parameter string. Each character, including the first is encoded.
For each ODD numbered character in the string (including the first ADD 29 to the ASCII value of the character.
For each EVEN numbered character in the string SUBTRACT 23 from the ASCII value of the character.
*/

public class JACEncoding implements IExternalEncodingProvider 
{
	private static final int ODD = 29;
	private static final int EVEN = -23;
	
	public String encode(String value)
	{
		if(value == null)
			throw new CodingRuntimeException("The string to be encoded is null.");
		
		StringBuilder encodedString = new StringBuilder(value.length());
		
		for(int i=0;  i < value.length(); i++)
		{
			int code = String.valueOf(value.charAt(i)).codePointAt(0);
			code += ((i+1) % 2 == 1) ?  ODD : EVEN;
			encodedString.append((char) code);
		}
		
		return encodedString.toString();
	}
}
