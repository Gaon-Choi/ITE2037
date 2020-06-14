package assignment04;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * DictionaryArray
 * �������̽� Dictionary�� ������ Ŭ�����̴�.
 */
public class DictionaryArray implements Dictionary {
	// �ܾ��� ���¿� ���Ǹ� ������ WordDefinitionPair ArrayList
    private ArrayList<WordDefinitionPair> DicList;

    /**
     * find_index
     * @param word
     * �ܾ �޾� �� �ܾ ����� �ε����� ��ȯ
     * ����, �ܾ ���� ���, -1�� ��ȯ��.
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
     * DictionaryArray�� ������
     * DicList�� �ʱ�ȭ�Ѵ�.
     */
    public DictionaryArray() {
        this.DicList = new ArrayList<WordDefinitionPair>();
    }
    
    /**
     * getDicList
     * @param // Nothing //
     * DicList�� ���� getter
     * @return
     */
    public ArrayList<WordDefinitionPair> getDicList() {
    	return this.DicList;
    }

    /**
     * isEmpty
     * @param // Nothing //
     * DicList�� ����ִ����� ���θ� ��ȯ�Ѵ�.
     * ����ִٸ� true ��ȯ, �׷��� ������ false ��ȯ
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return this.DicList.isEmpty();
    }

    /**
     * insertEntry
     * @param String word, String definition
     * �ܾ��� ���¿� ���Ǹ� �޾� DicList�� �����Ѵ�.
     * ����, �ش� �ܾ �̹� ���� ��� �̰Ϳ� ���� ���ܸ� ó���Ѵ�.
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
     * �ε����� �޾� �׿� �ش��ϴ� WordDefinitionPair ��ü�� ��ȯ
     * ���� ������ ��� ���, null�� ��ȯ
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
     * �ܾ �޾� �װ��� ����(definition)�� ����Ѵ�.
     * DicList�� ������� ��쿡 ���� ���� ó��
     * �ش� �ܾ ���� ��쿡 ���� ���� ó��
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
     * �ܾ �޾� �� �ܾ DicList ������ �����Ѵ�.
     * ����, �ش� �ܾ ���� ��� �װͿ� ���� ���� ó��
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
     * ������ �ִ� ��� �ܾ��� word�� ����Ѵ�.
     * ���� DicList�� ����ִ� ���, �̿� ���� ���� ó��
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
     * DicList�� �ִ� ��� �ܾ��� word�� definition�� ����Ѵ�.
     * ���� DicList�� ����ִ� ���, �̿� ���� ���� ó��
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
     * DicList�� �ִ� �ܾ��� ����(WordDefinitionPair ��ü�� ����)�� ��ȯ�Ѵ�.
     * @return int
     */
    public int show_length() {
        return this.DicList.size();
    }

    /**
     * setDicList
     * @param arr
     * DicList�� ���� setter
     * @return
     */
    public void setDicList(ArrayList<WordDefinitionPair> arr) {
        this.DicList = new ArrayList<WordDefinitionPair>(arr.size());
        Iterator<WordDefinitionPair> iterator = this.DicList.iterator();

        while(iterator.hasNext())
            this.DicList.add(iterator.next());
    }
}
