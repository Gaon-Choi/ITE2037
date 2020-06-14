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
	 * 프로그램 내에서 선택할 수 있는 메뉴를 보여주는 메소드
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
        int opt;	/* 선택할 메뉴 */
        boolean endCoin = true;	/* 프로그램의 ON/OFF 스위치 */
        Scanner scanner = new Scanner(System.in);

        // These are for file writing in case 6
        PrintWriter outputStream = null;
        File file = null;

        // DictionaryArray 객체 생성
        DictionaryArray dictionary = new DictionaryArray();
        

		do {
			show_menu();

			// 메뉴를 선택
			opt = scanner.nextInt();
			
			switch (opt) {
			/* [1] InsertEntry */
			// word와 definition을 순차적으로 입력받아 사전에 추가한다.
			// 사전에 word가 이미 존재하면 예외 처리
			
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
			// 입력한 word를 사전에서 찾아 definition을 출력한다.
			// 1) 사전에 아무것도 없으면 예외 처리
			// 2) 사전에 해당 단어가 없으면 예외 처리
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
			// 사전에 있는 word들의 list를 출력한다.
			// 사전에 아무것도 없으면 예외 처리
			case 3:
				try {
					dictionary.printWords();
				}
				catch (EmptyException e) {
					// 사전이 비어있으면 예외 처리
					System.out.println(e.getMessage());
				}

				break;

			/* [4] RemoveWord */
			// 입력한 word를 사전에서 찾아 삭제한다.
			// 사전에 아무것도 없으면 예외 처리
			// 사전에 해당 단어가 없으면 예외 처리
			case 4:
				System.out.print("word to remove : ");
				scanner.nextLine();
				word = scanner.nextLine();

				try {
					dictionary.removeWord(word);
				}
				catch (EmptyException e1) {
					// 사전이 비어있으면 예외 처리
					System.out.println(e1.getMessage());
				}
				catch (NotInDicException e2) {
					// 사전에 해당 단어가 없으면 예외 처리
					System.out.println(e2.getMessage());
				}

				break;

			/* [5] PrintAll */
			// 사전에 있는 word들의 list를 출력한다.
			// 사전에 아무것도 없으면 예외 처리
			case 5:
				try {
					dictionary.printAll();
				}
				catch (EmptyException e) {
					// 사전이 비어있으면 예외 처리
					System.out.println(e.getMessage());
				}

				break;

			/* [6] Write outputs and quit this program */
			// 저장할 텍스트 파일의 이름을 입력받는다.
			// 이 파일 처리와 관련한 예외 처리
			// 사전에 있는 내용을 텍스트파일에 기록
			// 프로그램 종료
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
						// 파일에 쓰기를 할 수 없을 때에 대한 예외 처리
						scanner.nextLine();
						System.out.println("cannot write the file.");
						System.out.println("try again!");
						System.out.println("Enter a file name :");
						file_name = scanner.next();
					}
					finally {
						// 사전에 있는 내용들을 텍스트 파일에 기록
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
				
				// 프로그램 스위치 OFF
				endCoin = false;

				break;

			default:
				// 잘못된 값이 입력된 경우
				System.out.println("Insert 1 ~ 6");
				break;
			}

		} while (endCoin);

		scanner.close();
    }
}
