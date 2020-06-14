package assignment04;

/**
 * NotInDicException
 * 찾으려는 단어가 사전에 없을 경우 발생하는 Exception
 */
public class NotInDicException extends Exception{
	/**
	 * NotInDicException의 생성자
	 * @param // nothing //
	 */
    public NotInDicException() {
        super("this word not exists in dictionary");
    }

	/**
	 * NotInDicException의 생성자
	 * @param msg
	 */
    public NotInDicException(String msg) {
        super(msg);
    }
}
