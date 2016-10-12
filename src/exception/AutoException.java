//Reyhan Fernando Patia
//CIS 35b
//Final Lab
package exception;

public abstract class AutoException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String exceptionMsg;

	public AutoException() {
		super();
		printException();
	}

	public AutoException(String exceptionMsg) {
		super();
		this.setExceptionMsg(exceptionMsg);
		printException();
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public abstract void printException();

	public abstract Object fixException();

}
