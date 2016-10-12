//Reyhan Fernando Patia
//CIS 35b
//Final Lab

package adapter;

import java.io.FileNotFoundException;

import exception.InvalidFilenameException;

public interface CreateAuto 
{
	public void BuildAuto(String filename) throws FileNotFoundException, InvalidFilenameException;
	
	public String printAuto(String Modelname);
	
}
