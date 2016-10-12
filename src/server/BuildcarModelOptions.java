//Reyhan Fernando Patia
//CIS 35b
//Final Lab

package server;

import java.util.Properties;
import Model.Automotive;
import Util.FileIO;
import adapter.BuildAuto;

public class BuildcarModelOptions 
{
	BuildAuto b = new BuildAuto();
	private FileIO autoutil = new FileIO();
	
	public Automotive createAuto(Properties p1)
	{
		Automotive a = new Automotive();
		a = autoutil.readProperties(p1);
		return a;
	}
	
	public void addAutotoLHM(Automotive a1)
	{
		b.addcar(a1);
	}

}
