//Reyhan Fernando Patia
//CIS 35b
//Final Lab

package adapter;

import exception.InvalidOptionException;

public interface UpdateAuto 
{
	public void updateOptionSetName(String Modelname,String OptionSetname, String newName)throws InvalidOptionException;
	
	public void updateOptionPrice(String Modelname, String Optionname, String Option, float newprice) throws InvalidOptionException;

}
