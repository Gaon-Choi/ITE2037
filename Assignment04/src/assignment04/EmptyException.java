package assignment04;

/**
 * EmptyException
 * 단어를 저장하는 list가 비어있을 때 발생하는 Exception
 * [Note]
 * 	It should be handled with higher priority
 * 	than NotInDicException and AlreadyExistInDicException
 */

public class EmptyException extends Exception {
	/**
	 * EmptyException의 생성자
	 * @param // nothing //
	 */
    public EmptyException() {
        super("list is empty");
    }

    /**
     * EmptyException의 생성자
     * @param msg
     */
    public EmptyException(String msg) {
        super(msg);
    }
}
