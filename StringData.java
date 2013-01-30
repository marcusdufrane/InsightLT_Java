/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InsightLT;

import com.sun.squawk.util.Arrays;

/**
 *
 * @author Wave
 */
public class StringData implements DisplayData{
    
    public StringData()
    {
        m_stringData = "";
        m_stringHeader = "";
    };
    
    public StringData(String header)
    {
        m_updateString = true;
        m_stringHeader = header;
        m_stringData = "";
    }
    
    public void setData(String data)
    {
        m_updateString = true;
        m_stringData = data;
    }
    
    public void setHeader(String header)
    {
        m_updateString = true;
        m_stringHeader = header;
    }
    
    public String getFormattedString(int zoneLength)
    {
        if(m_updateString)
	{
            m_updateString = false;
            if(m_stringHeader.length() + m_stringData.length() > zoneLength)
            {
                String tmpString = m_stringData;
                if(m_stringData.length() > zoneLength)
                {
                        tmpString = new String( tmpString.substring( 0, (tmpString.length() - (tmpString.length() - zoneLength) - 1)));
                }
                m_formattedString = m_stringHeader.substring(0, zoneLength - tmpString.length()) + tmpString;
            }
            else
            {
                byte[] tmp = new byte[zoneLength - (m_stringHeader.length() + m_stringData.length())];
                Arrays.fill(tmp, (byte)' ');
                m_formattedString = m_stringHeader + new String(tmp).concat(m_stringData);
            }	
	}		
	return m_formattedString;
    }
    
    private String m_formattedString;
    private String m_stringHeader;
    private String m_stringData;
    
    private boolean m_updateString;
}
