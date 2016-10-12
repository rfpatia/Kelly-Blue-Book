//Reyhan Fernando Patia
//CIS 35b
//Final Lab

package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import adapter.BuildAuto;

public class CreateServer 
{
	private ServerSocket a1;
	private DefaultSocketClient s1;
	BuildAuto a = new BuildAuto();
	
	CreateServer() 
	{
		try {
            a1 = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }
	}
	
	public void startServer()
	{
		Socket soc = null;
		while(true)
        {
			try 
			{
				soc = a1.accept();
			} catch (IOException e)
			{
				System.err.println("Accept failed.");
	            System.exit(1);
			}    
            s1 = new DefaultSocketClient(soc);
            s1.openConnection();
            handleConnection();
            s1.closeSession();
        }
	}
	
	public void handleConnection()
	{
		Properties p = new Properties();
		int choice;
		Object o;
		String sc, so, sos;
		boolean bool = true;
		do
		{
			choice = (int)s1.handleSession("r", null);
			if(choice == 1)
			{
				o = s1.handleSession("r", null);
				System.out.println ("Properties File Recieved");
				p = (Properties) o;
				a.addAuto(p);
				System.out.println ("Creating Car");
				s1.handleSession("s", "Car Created");
			}
			else if(choice == 2)
			{
				s1.handleSession("s", a.NumOfCar());
				if(a.NumOfCar() > 0)
				{
					System.out.println ("there is car in the list");
					s1.handleSession("s", a.PrintAllCar()); // send print all available car to client
					sc = (String) s1.handleSession("r", null); // recieve  car key from user
					if(a.printAuto(sc) != null)
					{
						System.out.println ("Correct Key!");
						s1.handleSession("s", a.printAuto(sc)); // send print all option
						sos = (String) s1.handleSession("r", null); // recieve optionset chosen
						so = (String) s1.handleSession("r", null); // recieve option chosen
						if(a.setOptionChoice(sc, sos, so)) // if car is updated, send car updated to client else print that it is not found
						{	
							s1.handleSession("s", "Car Updated");
							System.out.println ("Car Successfully Updated");
						}
						else
							s1.handleSession("s", "OptionSet/Option not Found");
					}	
					else
						s1.handleSession("s", null);
				}

			}
			else if(choice == 3)
			{
				bool = false;
			}
			else
			{
			}
		}while(bool);
	}
	
	public static void main(String [ ] args)
	{
		CreateServer start = new CreateServer();
		start.startServer();
	}
}
/***
 OUTPUT
 
 Properties File Recieved
Creating Car
Properties File Recieved
Creating Car
there is car in the list
there is car in the list
Correct Key!
there is car in the list
Correct Key!
there is car in the list
Correct Key!
Car Successfully Updated
 
 */
