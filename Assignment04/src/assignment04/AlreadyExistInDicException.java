package assignment04;

/**
 * AlreadyExistInDicException
 * �̹� ������ �ִ� �ܾ �Է��� ��� �߻��ϴ� Exception
 */

public class AlreadyExistInDicException extends Exception {
	/**
	 * NotInDicException�� ������
	 * @param // nothing //
	 */
    public AlreadyExistInDicException() {
        super("this word already exist in dictionary");
    }

	/**
	 * NotInDicException�� ������
	 * @param msg
	 */
    public AlreadyExistInDicException(String msg) {
        super(msg);
    }
}
