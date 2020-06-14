package assignment04;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * DictionaryArray
 * 인터페이스 Dictionary를 구현한 클래스이다.
 */
public class DictionaryArray implements Dictionary {
	// 단어의 형태와 정의를 저장할 WordDefinitionPair ArrayList
    private ArrayList<WordDefinitionPair> DicList;

    /**
     * find_index
     * @param word
     * 단어를 받아 그 단어가 저장된 인덱스를 반환
     * 만약, 단어가 없을 경우, -1을 반환함.
     * @return
     */
    public int find_index(String word) {
        int i = 0;

        for(i = 0; i < DicList.size(); i++) {
            if(word.equals(DicList.get(i).getWord())) {
                return i;    // exists.
            }
        }
        return -1;   // doesn't exist.
    }

    /**
     * DictionaryArray
     * @param // Nothing //
     * DictionaryArray의 생성자
     * DicList를 초기화한다.
     */
    public DictionaryArray() {
        this.DicList = new ArrayList<WordDefinitionPair>();
    }
    
    /**
     * getDicList
     * @param // Nothing //
     * DicList에 대한 getter
     * @return
     */
    public ArrayList<WordDefinitionPair> getDicList() {
    	return this.DicList;
    }

    /**
     * isEmpty
     * @param // Nothing //
     * DicList가 비어있는지의 여부를 반환한다.
     * 비어있다면 true 반환, 그렇지 않으면 false 반환
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return this.DicList.isEmpty();
    }

    /**
     * insertEntry
     * @param String word, String definition
     * 단어의 형태와 정의를 받아 DicList에 저장한다.
     * 만약, 해당 단어가 이미 있을 경우 이것에 대한 예외를 처리한다.
     * @return // Nothing //
     */
    @Override
    public void insertEntry(String word, String definition) throws AlreadyExistInDicException {
        // if the word already exists in the DicList
        if(find_index(word) != -1)
        	// Exception Handling
            throw new AlreadyExistInDicException();

        // if the word does not exist in the DicList
        else {
            WordDefinitionPair voca = new WordDefinitionPair(word, definition);
            this.DicList.add(voca);
        }
    }

    /**
     * WordDefinitionPair
     * @param idx
     * 인덱스를 받아 그에 해당하는 WordDefinitionPair 객체를 반환
     * 만약 범위에 벗어난 경우, null을 반환
     * @return
     */
    public WordDefinitionPair getVoca(int idx) {
        if(idx < this.DicList.size() && idx >= this.DicList.size())
            return null;
        else
            return this.DicList.get(idx);
    }

    /**
     * getDefinition
     * @param String word
     * 단어를 받아 그것의 정의(definition)을 출력한다.
     * DicList가 비어있을 경우에 대한 예외 처리
     * 해당 단어가 없을 경우에 대한 예외 처리
     * @return
     */
    @Override
    public void getDefinition(String word) throws EmptyException, NotInDicException {
        int index = find_index(word);

        if(isEmpty()) {
            // if the DicList is empty
            throw new EmptyException();
        }

        else if(index == -1) {
            // if the word doesn't exist in the DicList, which is not empty
            throw new NotInDicException();
        }

        else {
            // if the word exists in the DicList
            System.out.println(word + " mean : " + this.DicList.get(index).getDefinition());
        }
    }

    /**
     * removeWord
     * @param String word
     * 단어를 받아 그 단어를 DicList 내에서 삭제한다.
     * 만약, 해당 단어가 없을 경우 그것에 대한 예외 처리
     * @return
     */
    @Override
    public void removeWord(String word) throws EmptyException, NotInDicException {
        int index = find_index(word);

        if(isEmpty()) {
            // if the DicList is empty
            throw new EmptyException();
        }

        else if(index == -1) {
            // if the word doesn't exist in the DicList, which is not empty
            throw new NotInDicException();
        }

        else {
            this.DicList.remove(index);
        }
    }

    /**
     * printWords
     * @param // Nothing //
     * 사전에 있는 모든 단어의 word를 출력한다.
     * 만약 DicList가 비어있는 경우, 이에 대한 예외 처리
     * @return
     */
    @Override
    public void printWords() throws EmptyException {
        if(isEmpty()) {
            throw new EmptyException();
        }
        else {
            Iterator<WordDefinitionPair> iterator = this.DicList.iterator();
            int i = 1;
            while(iterator.hasNext()) {
                WordDefinitionPair voca = iterator.next();
                System.out.println(i+". "+ voca.getWord());
                i++;
            }
        }
    }

    /**
     * printAll
     * @param // Nothing //
     * DicList에 있는 모든 단어의 word와 definition을 출력한다.
     * 만약 DicList가 비어있는 경우, 이에 대한 예외 처리
     * @return
     */
    @Override
    public void printAll() throws EmptyException {
        if(isEmpty()) {
            throw new EmptyException();
        }
        else {
            Iterator<WordDefinitionPair> iterator = this.DicList.iterator();

            while(iterator.hasNext()) {
                System.out.println("******************************************");
                WordDefinitionPair voca = iterator.next();
                System.out.println("Word : " + voca.getWord());
                System.out.println("Definition : " + voca.getDefinition());
            }
        }
    }

    /**
     * show_length
     * @param // Nothing //
     * DicList에 있는 단어의 개수(WordDefinitionPair 객체의 개수)를 반환한다.
     * @return int
     */
    public int show_length() {
        return this.DicList.size();
    }

    /**
     * setDicList
     * @param arr
     * DicList에 대한 setter
     * @return
     */
    public void setDicList(ArrayList<WordDefinitionPair> arr) {
        this.DicList = new ArrayList<WordDefinitionPair>(arr.size());
        Iterator<WordDefinitionPair> iterator = this.DicList.iterator();

        while(iterator.hasNext())
            this.DicList.add(iterator.next());
    }
}
