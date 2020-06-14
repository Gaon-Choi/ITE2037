package assignment04;

/**
 * WordDefinitionPair
 * 단어의 형태와 정의를 묶어 다룰 수 있는 객체를 생성하는 클래스이다.
 */
public class WordDefinitionPair {
    private String word;		// 단어의 형태
    private String definition;	// 단어의 정의

    /**
     * word와 definition을 인자로 받는 생성자
     * @param // Nothing //
     */
    public WordDefinitionPair(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    /**
     * WordDefinitionPair의 Copy Constructor
     * @param voca
     */
    public WordDefinitionPair(WordDefinitionPair voca) {
        this(voca.word, voca.definition);
    }

    /**
     * word에 대한 getter
     * @return
     */
    public String getWord() {
        return this.word;
    }

    /**
     * word에 대한 setter
     * @param word
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * definition에 대한 getter
     * @return
     */
    public String getDefinition() {
        return this.definition;
    }

    /**
     * definition에 대한 setter
     * @param definition
     */
    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
