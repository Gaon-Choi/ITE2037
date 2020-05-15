package selfTest;

public class TooMuchStuffException extends Exception {

	private int inputNumber;
	
	public TooMuchStuffException(int num) {
		/* your code */
		super("Too much stuff!");
		inputNumber = num;
	}
	
	public TooMuchStuffException() {
		/* your code */
		super("Too much stuff!");
	}
	
	public TooMuchStuffException(String msg) {
		/* your code */
		super(msg);
	}
	
	public int getNumber() {
		/* your code */
		return inputNumber;
	}
	
}
