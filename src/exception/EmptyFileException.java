//Reyhan Fernando Patia
//CIS 35b
//Final Lab
package exception;

import java.util.Scanner;

@SuppressWarnings("serial")
public class EmptyFileException extends AutoException {

	public EmptyFileException() {
		// TODO Auto-generated constructor stub
	}

	public EmptyFileException(String exceptionMsg) {
		super(exceptionMsg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printException() {
		System.out.println("\nError -- " + getExceptionMsg());
		System.out.println("File cannot be blank.Please Enter Another existing file");

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
