package assignment04;

/**
 * NotInDicException
 * ã������ �ܾ ������ ���� ��� �߻��ϴ� Exception
 */
public class NotInDicException extends Exception{
	/**
	 * NotInDicException�� ������
	 * @param // nothing //
	 */
    public NotInDicException() {
        super("this word not exists in dictionary");
    }

	/**
	 * NotInDicException�� ������
	 * @param msg
	 */
    public NotInDicException(String msg) {
        super(msg);
    }
}
