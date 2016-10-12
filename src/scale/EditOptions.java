//Reyhan Fernando Patia
//CIS 35b
//Final Lab

package scale;

import java.util.Scanner;
import exception.InvalidOptionException;
import adapter.ProxyAutomobile;
import adapter.ScaleThread;


public class EditOptions extends ProxyAutomobile implements Runnable, ScaleThread
{
	Thread a1;
    int ops;
    String model;
    public EditOptions(int ops, String model) 
    {
    	this.ops = ops; //create an instance of a1 for a given ops
        this.model = model;
        a1 = new Thread(this);
    }
	
	@Override
	public void run() 
	{
		switch(ops)
        {
           case 0:   
        	updateOptionName();
			break;
           case 1:   
        	updateOptionPrices();
        	break;
        }
	}
	
	public void start () 
	{
		a1.start();
	}

	public void stop () 
	{

	} 
	
	@SuppressWarnings("resource")
	synchronized void updateOptionName()
	{
		System.out.println("Enter OldName");
		Scanner read1 = new Scanner(System.in);
		String x1 = read1.nextLine();
		System.out.println("Enter newName");
		String y1 = read1.nextLine();
		try{	
			updateOptionSetName(model, x1, y1);
		}
		catch(InvalidOptionException e) {
			FixOptionName(model);
		}
	}
	
	@SuppressWarnings("resource")
	synchronized void updateOptionPrices()
	{
		System.out.println("Enter OptionSetName");
		Scanner read2 = new Scanner(System.in);
		String x2 = read2.nextLine();
		System.out.println("Enter OptionName");
		String y2 = read2.nextLine();
		System.out.println("Enter new price");
		float z2 = Float.parseFloat(read2.nextLine());
		try
		{
			updateOptionPrice(model,x2,y2,z2);	
		
		}catch(InvalidOptionException e) {
			FixOptionPrice(model);
				 
		}
	}

	public void join() throws InterruptedException {
		a1.join();
		
	}

}
