//Reyhan Fernando Patia
//CIS 35b
//Final Lab
package exception;

@SuppressWarnings("serial")
public class InvalidOptionException extends AutoException {

	public InvalidOptionException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidOptionException(String exceptionMsg) {
		super(exceptionMsg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printException() {
		System.out.println("Error-- " + getExceptionMsg());
		System.out.println("The specified OptionSet/Option does not exist");

	}
	
	@Override
	public Object fixException() 
	{
		return null;
	}

}
