package selfTest;

public class PowerFailureException extends Exception{

	public PowerFailureException() {
		/* your code */
		super("Power Failure");
	}
	
	public PowerFailureException(String msg) {
		/* your code */
		super(msg);
	}
	
}
