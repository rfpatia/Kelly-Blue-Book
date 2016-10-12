//Reyhan Fernando Patia
//CIS 35b
//Final Lab
package exception;

@SuppressWarnings("serial")
public class InvalidInputException extends AutoException {

	public InvalidInputException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidInputException(String exceptionMsg) {
		super(exceptionMsg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printException() {
		System.out.println("\nError -- " + getExceptionMsg());
		System.out.println("Invalid characters in input file. Please enter only integers where Option Cost is expected");

	}

	@Override
	public Object fixException() {
		// TODO Auto-generated method stub
		return null;
	}

}
