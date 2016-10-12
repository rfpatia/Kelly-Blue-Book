//Reyhan Fernando Patia
//CIS 35b
//Final Lab

package adapter;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;

import exception.InvalidFilenameException;
import exception.InvalidOptionException;
import Util.FileIO;
import Model.Automotive;
import Model.AutomotiveOptions;
import server.BuildcarModelOptions;

public class ProxyAutomobile 
{
	private static AutomotiveOptions myobj = new AutomotiveOptions();
	private FileIO autoutil = new FileIO();
	
	/*
	 * this method will self heal itself if the filename is not found
	 */
	public void BuildAuto(String filename) throws FileNotFoundException, InvalidFilenameException
	{
		boolean check;
		
		do{
			try 
			{	
				myobj.addCarOption(autoutil.readProperties(filename));
				check = true;
			} catch (InvalidFilenameException e) {
				filename = e.fixException();
				check = false;
			}
		}while(check != true);	
		
		
	}
	
	public void addcar(Automotive a)
	{
		myobj.addCarOption(a);
	}
	
	public void addAuto(Properties p)
	{
		if(p == null)
			return;
		BuildcarModelOptions a = new BuildcarModelOptions();
		a.addAutotoLHM(a.createAuto(p));
	}
	
	public String printAuto(String Modelname)
	{
		try
		{
			return myobj.getCarOption(Modelname).print();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public int NumOfCar()
	{
		return myobj.size();
	}
	
	public String PrintAllCar()
	{
		return myobj.printavailablecar();
	}
	
	public boolean setOptionChoice(String key, String name, String newname)
	{
		return myobj.getCarOption(key).setOptionChoice(name, newname);
	}
	
	public void updateOptionSetName(String Modelname,String OptionSetname, String newName) throws InvalidOptionException
	{
		try
		{	
			myobj.getCarOption(Modelname).updateOptionSetName(OptionSetname, newName);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			throw new InvalidOptionException("Self Healing Start");
		}
	}
	
	public void updateOptionPrice(String Modelname, String Optionname, String Option, float newprice) throws InvalidOptionException
	{
		try
		{
			myobj.getCarOption(Modelname).updateOptionPrice(Option, newprice, myobj.getCarOption(Modelname).findOptionSet(Optionname));
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			throw new InvalidOptionException("Self Healing Start");
		}
	}
	
	@SuppressWarnings("resource")
	public void FixOptionPrice(String model) 
	{
		boolean finish;
		
		do
		{
			finish = false; 
			
			System.out.println("Enter new OptionSetName");
			Scanner read = new Scanner(System.in);
			String fileName1 = read.nextLine();
			System.out.println("Enter new OptionName");
			String fileName2 = read.nextLine();
			System.out.println("Enter new price");
			float price = Float.parseFloat(read.nextLine());
		
			try
			{
				updateOptionPrice(model, fileName1, fileName2, price);
			}
			catch(InvalidOptionException e)
			{
				finish = true;
			}
			
		}while(finish);
		
	}
	
	@SuppressWarnings("resource")
	public void FixOptionName(String model)
	{
		boolean finish;
		
		do
		{
			finish = false; 
			
			System.out.println("Enter new OptionSetName");
			Scanner read = new Scanner(System.in);
			String fileName2 = read.nextLine();
			System.out.println("Enter new Name");
			String newname = read.nextLine();
		
			try
			{
				updateOptionSetName(model, fileName2, newname);
			}
			catch(InvalidOptionException e)
			{
				finish = true;
			}
			
		}while(finish);
		
	}
	

}
