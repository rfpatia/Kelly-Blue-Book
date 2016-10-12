//Reyhan Fernando Patia
//CIS 35b
//Final Lab

package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DefaultSocketClient extends Thread
{
	Socket sock;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	DefaultSocketClient(Socket s1)
    {
        sock = s1;
    }
	
	public void run()
	{
	}
	
	public boolean openConnection()
	{
		try
		{
			out = new ObjectOutputStream(sock.getOutputStream());
			in = new ObjectInputStream(sock.getInputStream());
		}catch(Exception e)
		{
			System.err.println("Unable to obtain stream");
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
    	catch (IOException e){
    		System.out.println ("Handling session");
    	} catch (ClassNotFoundException e) {
    		System.out.println ("Class not found");
    	}
    	
    	return o;
    }       

    public void closeSession()
    {
    	try 
    	{
    		in = null;
    		out = null;
    		sock.close();
    	}
    	catch (IOException e)
    	{
    		System.err.println("Error closing socket");
    	}       
   }


	
	
}
