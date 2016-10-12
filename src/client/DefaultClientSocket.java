//Reyhan Fernando Patia
//CIS 35b
//Final Lab

package client;

import java.net.*;
import java.io.*;
public class 
   
DefaultClientSocket extends Thread
{

    private ObjectInputStream in = null;
    private ObjectOutputStream out = null;
    private Socket sock = null;
    private String strHost;
    private int iPort;

    public DefaultClientSocket(String strHost, int iPort) 
    {       
            setPort (iPort);
            setHost (strHost);
    }//constructor

    public void run()
    {
    }
    
    public boolean openConnection()
    {
    	try 
    	{
    		sock = new Socket(strHost, iPort);  
    	}
   	   catch(IOException socketError)
    	{
   		   System.err.println("Unable to connect to " + strHost);
   		   return false;
       }
  
    	try {
    		out = new ObjectOutputStream(sock.getOutputStream());
    		in = new ObjectInputStream(sock.getInputStream());
    	}
    	catch (Exception e)
    	{
    	    System.err.println("Unable to obtain stream to/from " + strHost);
    	     return false;
    	}
    	return true;
    }
   
	public Object handleSession(String ros, Object output)
	{
		Object o = null;
		switch(ros)
		{
			case "r": o = ReadInput();
					  return o;
			case "s": sendOutput(output);
			default:  return o;
		}
	}     
	

	public void sendOutput(Object strOutput)
	{
	  try 
	  {
	    out.writeObject(strOutput);
	  }
	  catch (IOException e){
	    System.out.println ("Error writing");
	  }
	}
	
    public Object ReadInput()
    {
    	Object o = null;
    	try
    	{
    		o = in.readObject();
    	}
    	catch (IOException e)
    	{
    		System.out.println ("Handling session");
    	} catch (ClassNotFoundException e) {
    		System.out.println ("Class not found");
    	}
    	
    	return o;
    }       

    public void closeSession(){
       try {
          in = null;
          out = null;
          sock.close();
       }
       catch (IOException e){
        System.err.println("Error closing socket to " + strHost);
       }       
    }

    public void setHost(String strHost){
            this.strHost = strHost;
    }

    public void setPort(int iPort){
            this.iPort = iPort;
    }
}


