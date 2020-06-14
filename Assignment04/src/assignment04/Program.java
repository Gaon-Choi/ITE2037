package assignment04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 **********************************************************
 * [ Assignment04 ]                                       *
 *    User-defined Dictionary Program                     *
 **********************************************************
 * @author	Gaon Choi                                     *
 * 			Division of Computer Software Engineering 19  *
 * 			Hanyang University(Seoul)                     *
 * 			Republic of Korea.                            *
 **********************************************************
 * Program class contains the main part.                  *
 **********************************************************
 */


public class Program {
	/**
	 * show_menu()
	 * @return
	 * ���α׷� ������ ������ �� �ִ� �޴��� �����ִ� �޼ҵ�
	 */
    public static void show_menu() {
        System.out.print(
                "================Main Menu================\n" +
                "(1) Add a word to dictionary\n" +
                "(2) Show definition of word\n" +
                "(3) Show word list\n" +
                "(4) Remove word\n" +
                "(5) print all contents\n" +
                "(6) Exit program\n" +
                "=====================================\n" +
                "choose a menu : "
        );
    }

    public static void main(String[] args) {
        int opt;	/* ������ �޴� */
        boolean endCoin = true;	/* ���α׷��� ON/OFF ����ġ */
        Scanner scanner = new Scanner(System.in);

        // These are for file writing in case 6
        PrintWriter outputStream = null;
        File file = null;

        // DictionaryArray ��ü ����
        DictionaryArray dictionary = new DictionaryArray();
        

		do {
			show_menu();

			// �޴��� ����
			opt = scanner.nextInt();
			
			switch (opt) {
			/* [1] InsertEntry */
			// word�� definition�� ���������� �Է¹޾� ������ �߰��Ѵ�.
			// ������ word�� �̹� �����ϸ� ���� ó��
			
			case 1:
				String word, definition;
				System.out.println("word :");
				scanner.nextLine();
				word = scanner.nextLine();

				System.out.println("definition :");
				definition = scanner.nextLine();

				try {
					dictionary.insertEntry(word, definition);
				}
				catch (AlreadyExistInDicException e) {
					System.out.println(e.getMessage());
				}

				break;

			/* [2] GetDefinition */
			// �Է��� word�� �������� ã�� definition�� ����Ѵ�.
			// 1) ������ �ƹ��͵� ������ ���� ó��
			// 2) ������ �ش� �ܾ ������ ���� ó��
			case 2:
				System.out.println("word for searching :");
				scanner.nextLine();
				word = scanner.nextLine();

				try {
					dictionary.getDefinition(word);
				}
				catch (EmptyException e1) {
					System.out.println(e1.getMessage());
				}
				catch (NotInDicException e2) {
					System.out.println(e2.getMessage());
				}

				break;

			/* [3] PrintWords */
			// ������ �ִ� word���� list�� ����Ѵ�.
			// ������ �ƹ��͵� ������ ���� ó��
			case 3:
				try {
					dictionary.printWords();
				}
				catch (EmptyException e) {
					// ������ ��������� ���� ó��
					System.out.println(e.getMessage());
				}

				break;

			/* [4] RemoveWord */
			// �Է��� word�� �������� ã�� �����Ѵ�.
			// ������ �ƹ��͵� ������ ���� ó��
			// ������ �ش� �ܾ ������ ���� ó��
			case 4:
				System.out.print("word to remove : ");
				scanner.nextLine();
				word = scanner.nextLine();

				try {
					dictionary.removeWord(word);
				}
				catch (EmptyException e1) {
					// ������ ��������� ���� ó��
					System.out.println(e1.getMessage());
				}
				catch (NotInDicException e2) {
					// ������ �ش� �ܾ ������ ���� ó��
					System.out.println(e2.getMessage());
				}

				break;

			/* [5] PrintAll */
			// ������ �ִ� word���� list�� ����Ѵ�.
			// ������ �ƹ��͵� ������ ���� ó��
			case 5:
				try {
					dictionary.printAll();
				}
				catch (EmptyException e) {
					// ������ ��������� ���� ó��
					System.out.println(e.getMessage());
				}

				break;

			/* [6] Write outputs and quit this program */
			// ������ �ؽ�Ʈ ������ �̸��� �Է¹޴´�.
			// �� ���� ó���� ������ ���� ó��
			// ������ �ִ� ������ �ؽ�Ʈ���Ͽ� ���
			// ���α׷� ����
			case 6:
				boolean done = false;
				System.out.println("Enter a file name :");
				String file_name = scanner.next();
				while (!done) {
					try {
						file = new File("resource\\" + file_name);
						outputStream = new PrintWriter(file);
						done = true;
					}
					catch (FileNotFoundException e) {
						// ���Ͽ� ���⸦ �� �� ���� ���� ���� ���� ó��
						scanner.nextLine();
						System.out.println("cannot write the file.");
						System.out.println("try again!");
						System.out.println("Enter a file name :");
						file_name = scanner.next();
					}
					finally {
						// ������ �ִ� ������� �ؽ�Ʈ ���Ͽ� ���
						int i;
						for (i = 0; i < dictionary.show_length(); i++) {
							outputStream.println((i + 1) + ". word : " + dictionary.getVoca(i).getWord());
							outputStream.println("   " + "definition : " + dictionary.getVoca(i).getDefinition());
						}
						System.out.println("saved as " + file_name);
						outputStream.close();
					}
				}
				System.out.print("exit program");
				
				// ���α׷� ����ġ OFF
				endCoin = false;

				break;

			default:
				// �߸��� ���� �Էµ� ���
				System.out.println("Insert 1 ~ 6");
				break;
			}

		} while (endCoin);

		scanner.close();
    }
}
