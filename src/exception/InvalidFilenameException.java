//Reyhan Fernando Patia
//CIS 35b
//Final Lab
package exception;

import java.util.Scanner;

public class InvalidFilenameException extends AutoException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidFilenameException() {
		super();	
	}


	public InvalidFilenameException(String exceptionMsg) {
		super(exceptionMsg);
	}

	@Override
	public void printException() {
		System.out.println("\nError -- " + getExceptionMsg());
		System.out.println("File Not Found. Please enter another filename.");
	}

	@SuppressWarnings("resource")
	@Override
	public String fixException() {
		System.out.println("Enter File Name");
		Scanner read = new Scanner(System.in);
		String fileName = read.nextLine();
		return fileName;
	}

}
