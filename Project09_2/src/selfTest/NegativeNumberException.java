package selfTest;

public class NegativeNumberException extends Exception {
	public NegativeNumberException() {
		/* your code */
		super("This number is negative!");
	}
	
	public NegativeNumberException(String message) {
		/* your code */
		super(message);
	}
}
