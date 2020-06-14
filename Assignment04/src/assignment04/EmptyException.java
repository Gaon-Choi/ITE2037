package assignment04;

/**
 * EmptyException
 * �ܾ �����ϴ� list�� ������� �� �߻��ϴ� Exception
 * [Note]
 * 	It should be handled with higher priority
 * 	than NotInDicException and AlreadyExistInDicException
 */

public class EmptyException extends Exception {
	/**
	 * EmptyException�� ������
	 * @param // nothing //
	 */
    public EmptyException() {
        super("list is empty");
    }

    /**
     * EmptyException�� ������
     * @param msg
     */
    public EmptyException(String msg) {
        super(msg);
    }
}
