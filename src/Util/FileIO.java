//Reyhan Fernando Patia
//CIS 35b
//Final Lab

package Util;

import java.io.*;
import java.util.Properties;

import exception.InvalidFilenameException;
import Model.Automotive;

public class FileIO 
{
	public void writeFile(String name) throws IOException
	{
		File outFile = new File("NewFordZTW.txt");
		FileOutputStream outFileStream = new FileOutputStream(outFile);
		ObjectOutputStream outObjectStream = new ObjectOutputStream (outFileStream);
		outObjectStream.writeObject(name);
		outObjectStream.close();
	}
	
	public Automotive readFile(String name) throws InvalidFilenameException
	{
		Automotive auto = new Automotive();
		int count = 0;
		String[] s;
		int size = 100, sizeopt = 100;
		
		try {
			FileReader file = new FileReader(name);
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false;
			while (!eof)
			{
				String line = buff.readLine();
				
				if(count == 0)
				{
					auto.setName(line);
					count++;
				}
				else if(count == 1)
				{
					auto.setBaseprice(Float.parseFloat(line));
					count++;
				}
				else if(count == 2)
				{
					auto.setModel(line);
					count++;
				}
				else if(count == 3)
				{
					auto.setMake(line);
					count++;
				}
				else if(count == 4)
				{
					size = Integer.parseInt(line);
					count++;
				}
				else 
				{				
					for(int i = 0; i < size; i++)
					{
						line = buff.readLine();
						s = line.split(",");
						auto.addOptionSet(s[0], i);
						sizeopt = Integer.parseInt(s[1]);
						for(int j = 0; j < sizeopt; j++)
						{
							line = buff.readLine();
							s = line.split(",");
							auto.addOption(i, s[0], Float.parseFloat(s[1]));
						}
					}
					eof = true;
				}
			}
			buff.close();
			return auto;
			}catch (IOException e) {
				throw new InvalidFilenameException("Self Healing Begin");
			}
	}
	
	public Automotive readProperties(String p1) throws InvalidFilenameException
	{
		Automotive auto = new Automotive();
		String value = "";
		int price = 0;
		try
		{
			Properties props= new Properties();
			FileInputStream in = new FileInputStream(p1);
			props.load(in);
			String CarMake = props.getProperty("CarMake"); 
			auto.setMake(CarMake);
			if(!CarMake.equals(null))
			{
				auto.setModel(props.getProperty("CarModel"));
				auto.setName(CarMake + " " + props.getProperty("CarModel"));
				auto.setBaseprice(Float.parseFloat(props.getProperty("CarPrice")));
				for(int i = 0; i < Integer.parseInt(props.getProperty("NumOption")); i++)
				{
					auto.addOptionSet(props.getProperty("Option" + (i + 1)), i);
					for(int j = 0; j < Integer.parseInt(props.getProperty("NumOption" + (i + 1))); j++)
					{
						value = props.getProperty("OptionValue" + (i + 1) + (char)(97 + j) );
						price = Integer.parseInt(props.getProperty("OptionPrice" + (i + 1) + (char)(97 + j)));
						auto.addOption(i, value, price);
					}
				}
						
			}
		}catch (IOException e) {
			throw new InvalidFilenameException("Self Healing Begin");
		}
		
		return auto;
	}
	
	public Automotive readProperties(Properties p1) 
	{
		Automotive auto = new Automotive();
		Properties props= new Properties();
		String value = "";
		float price = 0;
		props = p1;
		int imax, jmax;
		String CarMake = props.getProperty("CarMake"); 
		auto.setMake(CarMake);
		if(!CarMake.equals(null))
		{
			auto.setModel(props.getProperty("CarModel"));
			auto.setName(CarMake + " " + props.getProperty("CarModel"));
			auto.setBaseprice(Float.parseFloat(props.getProperty("CarPrice")));
			imax = Integer.parseInt(props.getProperty("NumOption"));
			for(int i = 0; i < imax; i++)
			{
				auto.addOptionSet(props.getProperty("Option" + (i + 1)), i);
				jmax = Integer.parseInt(props.getProperty("NumOption" + (i + 1)));
				for(int j = 0; j < jmax; j++)
				{
					value = props.getProperty("OptionValue" + (i + 1) + (char)(97 + j) );
					price = Float.parseFloat(props.getProperty("OptionPrice" + (i + 1) + (char)(97 + j)));
					auto.addOption(i, value, price);
				}
			}
					
		}
		
		return auto;
	}
	
	public void serializeAuto(Automotive fordZTW) throws IOException
	{
		try 
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("auto.ser"));
			out.writeObject(fordZTW);
			out.flush();
			out.close();
		} catch (Exception e)
		{
			System.out.print(e.getMessage());
		}
	}
	public Automotive deserializeAuto(String name)
	{
		try
	    {
			FileInputStream fis = new FileInputStream(name);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Automotive newford = (Automotive) ois.readObject();
			ois.close();
			return newford;
	    }catch(IOException i)
		{
		    i.printStackTrace();
		    return null;
		      
	    }catch(ClassNotFoundException c)
	      {
	         System.out.println("Automotive class not found");
	         c.printStackTrace();
	         return null;
	      }
	}

}


