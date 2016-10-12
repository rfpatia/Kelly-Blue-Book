//Reyhan Fernando Patia
//CIS 35b
//Final Lab

package client;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import exception.InvalidFilenameException;

public class CarModelOptionsIO 
{
	public Properties readdata(String name) throws InvalidFilenameException
	{
		Properties props= new Properties();
		try 
		{
			FileInputStream in;
			in = new FileInputStream(name);
			props.load(in);
		} catch (IOException e) {
			throw new InvalidFilenameException("Self Healing Begin");
		}
		
		return props;
	}

}
