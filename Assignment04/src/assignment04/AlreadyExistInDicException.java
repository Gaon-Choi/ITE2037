package assignment04;

/**
 * AlreadyExistInDicException
 * 이미 사전에 있는 단어를 입력할 경우 발생하는 Exception
 */

public class AlreadyExistInDicException extends Exception {
	/**
	 * NotInDicException의 생성자
	 * @param // nothing //
	 */
    public AlreadyExistInDicException() {
        super("this word already exist in dictionary");
    }

	/**
	 * NotInDicException의 생성자
	 * @param msg
	 */
    public AlreadyExistInDicException(String msg) {
        super(msg);
    }
}
