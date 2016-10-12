//Reyhan Fernando Patia
//CIS 35b
//Final Lab

package adapter;

public interface ScaleThread 
{
	public void run();
	
	public void start ();
	
	public void stop();
	
	public void join() throws InterruptedException;
}
