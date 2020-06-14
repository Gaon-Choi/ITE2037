package assignment04;

/**
 * WordDefinitionPair
 * �ܾ��� ���¿� ���Ǹ� ���� �ٷ� �� �ִ� ��ü�� �����ϴ� Ŭ�����̴�.
 */
public class WordDefinitionPair {
    private String word;		// �ܾ��� ����
    private String definition;	// �ܾ��� ����

    /**
     * word�� definition�� ���ڷ� �޴� ������
     * @param // Nothing //
     */
    public WordDefinitionPair(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    /**
     * WordDefinitionPair�� Copy Constructor
     * @param voca
     */
    public WordDefinitionPair(WordDefinitionPair voca) {
        this(voca.word, voca.definition);
    }

    /**
     * word�� ���� getter
     * @return
     */
    public String getWord() {
        return this.word;
    }

    /**
     * word�� ���� setter
     * @param word
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * definition�� ���� getter
     * @return
     */
    public String getDefinition() {
        return this.definition;
    }

    /**
     * definition�� ���� setter
     * @param definition
     */
    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
