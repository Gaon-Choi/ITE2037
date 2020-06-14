package assignment04;

/**
 * Dictioary: 인터페이스의 형태로 구현되었다.
 */
public interface Dictionary {
    public abstract boolean isEmpty();
    public abstract void insertEntry(String word, String definition) throws AlreadyExistInDicException;
    public abstract void getDefinition(String word) throws EmptyException, NotInDicException;
    public abstract void removeWord(String word) throws EmptyException, NotInDicException;
    public abstract void printWords() throws EmptyException;
    public abstract void printAll() throws EmptyException;

}
