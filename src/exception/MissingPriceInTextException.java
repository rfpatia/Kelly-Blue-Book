//Reyhan Fernando Patia
//CIS 35b
//Final Lab
package exception;

@SuppressWarnings("serial")
public class MissingPriceInTextException extends AutoException {

	public MissingPriceInTextException() {
		// TODO Auto-generated constructor stub
	}

	public MissingPriceInTextException(String exceptionMsg) {
		super(exceptionMsg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printException() {
		System.out.println("\nError -- " + getExceptionMsg());
		System.out.println("Missing price in the text file. Setting missing price into 0");

	}

	@Override
	public String fixException() {
		// TODO Auto-generated method stub
		return "0";
	}

}
