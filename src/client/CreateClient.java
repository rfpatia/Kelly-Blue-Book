//Reyhan Fernando Patia
//CIS 35b
//Final Lab

package client;

import java.util.Properties;
import java.util.Scanner;
import exception.InvalidFilenameException;

public class CreateClient 
{
	DefaultClientSocket sock;
	CarModelOptionsIO a = new CarModelOptionsIO();
	
	CreateClient()
	{
		sock = new DefaultClientSocket("10.0.1.15", 4444);
	}
	
	public void SelectServiceOption()
	{	
		
		Properties file = null;
		int selection;
		String filename, s;
		boolean bool = true;
		
		do
		{
			selection = Integer.parseInt(readFromConsole("\nSelect-\n1. Upload a car configuration\n2. Configure a car\n3. Quit\nPlease enter 1 or 2 or 3"));
			sock.handleSession("s", selection);
			if (selection==1)
			{
				filename = readFromConsole("Enter file name");
				boolean check;
				
				do{
					try {
						file = a.readdata(filename);
						check = true;
					} catch (InvalidFilenameException e)
					{
						filename = e.fixException();
						check = false;
					}
				}while(check != true);
				
				sock.handleSession("s", file);
				
				System.out.println("\nServer:" + sock.handleSession("r", null));
			
			}else if (selection == 2)
			{
				System.out.println("\nClient: Asking for all available model");
				selection = (int) sock.handleSession("r", null); 
				
				if(selection > 0) // if no car is in the list, it will print no car in the list
				{
					System.out.println((String) sock.handleSession("r", null)); // print all available car
					s = readFromConsole("Choose a car key to choose an option for the car"); 
					sock.handleSession("s", s); // send key from client to server
					s = (String) sock.handleSession("r", null);
					if(s != null)
					{
						System.out.println(s); // print all option of the car 		
						s = readFromConsole("Choose an optionset for the car");
						sock.handleSession("s", s); // send optionset from client to server
						s = readFromConsole("Choose an option for the car");	
						sock.handleSession("s", s);	// send option from client to server
						System.out.println("\nServer:" + sock.handleSession("r", null)); // print that car is updated
					}
					else
						System.out.println("Wrong Key");
				}
				else 
					System.out.println("No Car in the list");
				
				
				
			}else if(selection == 3)
			{
				bool = false;
			}
			else
				System.out.println("Invalid Selection");
				
			
		}while(bool);
	}
		
		
	@SuppressWarnings("resource")
	public String readFromConsole(String a) 
	{
		System.out.println(a);
		Scanner read = new Scanner(System.in);
		return read.nextLine();
	}
	
	public void performOperation()
	{
		if(sock.openConnection())
			SelectServiceOption();	
		sock.closeSession();
	}
	
	public static void main(String [ ] args)
	{
		System.out.println("Application Is Starting");
		CreateClient start = new CreateClient();
		start.performOperation();
	}

}
/****
OUTPUT

Application Is Starting

Select-
1. Upload a car configuration
2. Configure a car
3. Quit
Please enter 1 or 2 or 3
2

Client: Asking for all available model
No Car in the list

Select-
1. Upload a car configuration
2. Configure a car
3. Quit
Please enter 1 or 2 or 3
1
Enter file name
Bmww.txt

Error -- Self Healing Begin
File Not Found. Please enter another filename.
Enter File Name
Bmw.txt

Server:Car Created

Select-
1. Upload a car configuration
2. Configure a car
3. Quit
Please enter 1 or 2 or 3
1
Enter file name
Ford.txt

Server:Car Created

Select-
1. Upload a car configuration
2. Configure a car
3. Quit
Please enter 1 or 2 or 3
2

Client: Asking for all available model
Car Name: BMW M4
Key: BMW-M4
Car Name: Ford ZTW
Key: Ford-ZTW

Choose a car key to choose an option for the car
M3
Wrong Key

Select-
1. Upload a car configuration
2. Configure a car
3. Quit
Please enter 1 or 2 or 3
2

Client: Asking for all available model
Car Name: BMW M4
Key: BMW-M4
Car Name: Ford ZTW
Key: Ford-ZTW

Choose a car key to choose an option for the car
BMW-M4
Model:BMW M4
Base Price:$64200.0

Options:

Color
Alpine White: $0.0
Austin Yellow Metallic: $0.0
Black Sapphire Metallic: $0.0
Mineral Grey Metallic: $0.0
Mineral White Metallic: $0.0
Sakhir Orange Metallic: $0.0
Silverstone Metallic: $0.0
Yas Marina Blue Metallic: $0.0

Transmission
automatic: $0.0
manual: $-950.0

Brakes/Traction Control
Standard: $0.0
ABS: $750.0
ABS with Advance Trac: $2400.0

Side Impact Air Bags
present: $350.0
not present: $0.0

Power Moonroof
present: $595.0
not present: $0.0

-------End-------

Choose an optionset for the car
Power Moonroof
Choose an option for the car
wad

Server:OptionSet/Option not Found

Select-
1. Upload a car configuration
2. Configure a car
3. Quit
Please enter 1 or 2 or 3
2

Client: Asking for all available model
Car Name: BMW M4
Key: BMW-M4
Car Name: Ford ZTW
Key: Ford-ZTW

Choose a car key to choose an option for the car
BMW-M4
Model:BMW M4
Base Price:$64200.0

Options:

Color
Alpine White: $0.0
Austin Yellow Metallic: $0.0
Black Sapphire Metallic: $0.0
Mineral Grey Metallic: $0.0
Mineral White Metallic: $0.0
Sakhir Orange Metallic: $0.0
Silverstone Metallic: $0.0
Yas Marina Blue Metallic: $0.0

Transmission
automatic: $0.0
manual: $-950.0

Brakes/Traction Control
Standard: $0.0
ABS: $750.0
ABS with Advance Trac: $2400.0

Side Impact Air Bags
present: $350.0
not present: $0.0

Power Moonroof
present: $595.0
not present: $0.0

-------End-------

Choose an optionset for the car
AW
Choose an option for the car
wd

Server:OptionSet/Option not Found

Select-
1. Upload a car configuration
2. Configure a car
3. Quit
Please enter 1 or 2 or 3
2

Client: Asking for all available model
Car Name: BMW M4
Key: BMW-M4
Car Name: Ford ZTW
Key: Ford-ZTW

Choose a car key to choose an option for the car
BMW-M4
Model:BMW M4
Base Price:$64200.0

Options:

Color
Alpine White: $0.0
Austin Yellow Metallic: $0.0
Black Sapphire Metallic: $0.0
Mineral Grey Metallic: $0.0
Mineral White Metallic: $0.0
Sakhir Orange Metallic: $0.0
Silverstone Metallic: $0.0
Yas Marina Blue Metallic: $0.0

Transmission
automatic: $0.0
manual: $-950.0

Brakes/Traction Control
Standard: $0.0
ABS: $750.0
ABS with Advance Trac: $2400.0

Side Impact Air Bags
present: $350.0
not present: $0.0

Power Moonroof
present: $595.0
not present: $0.0

-------End-------

Choose an optionset for the car
Brakes/Traction Control
Choose an option for the car
ABS with Advance Trac

Server:Car Updated

Select-
1. Upload a car configuration
2. Configure a car
3. Quit
Please enter 1 or 2 or 3
3


*/