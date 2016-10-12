//Reyhan Fernando Patia
//CIS 35b
//Final Lab

package server;

import java.util.Properties;

public interface AutoServer
{
	public void addAuto(Properties p);
	
	public int NumOfCar();
	
	public String PrintAllCar();
	
	public boolean setOptionChoice(String key, String name, String newname);
}
