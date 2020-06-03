package assignment02;

import java.util.Scanner;

public class PriceListApp {
	public static void show_menu() {
		System.out.println("================Main Menu================");
		System.out.println("(1) Add a oil to price list");
		System.out.println("(2) View Region Information");
		System.out.println("(3) Print the entire price list");
		System.out.println("(4) Exit the program");
		System.out.println("=========================================");
	}

	public static void main(String[] args) {
		PriceList list = new PriceList();

		Scanner scanner = new Scanner(System.in);

		int opt;
		boolean endCoin = true;

		do {
			show_menu();
			System.out.print("choose a menu : ");

			opt = scanner.nextInt();

			switch (opt) {
			// Add a oil to price list
			case 1:
				try {
					if (list.getSize() == list.getVertical())
						throw new FullArrayException();
				}
				catch (FullArrayException e) {
					System.out.print(e.getMessage());
					int size;
					size = scanner.nextInt();
					list.extendList(size);
					System.out.println("list is extended.\n");
				}
				finally {
					String company;
					int price;

					System.out.print("company : ");
					company = scanner.next();
					System.out.print("supply price : ");
					price = scanner.nextInt();
					Gasoline gasoline = new Gasoline(price, company);
					list.setPricelist(list.getSize(), 0, gasoline);
					System.out.println("gasoline added\n");

					System.out.print("company : ");
					company = scanner.next();
					System.out.print("supply price : ");
					price = scanner.nextInt();
					Diesel diesel = new Diesel(price, company);
					list.setPricelist(list.getSize(), 1, diesel);
					System.out.println("diesel added\n");

					list.inc_size();
				}
				break;

			// View Region Information
			case 2:
				int region_num;
				System.out.print("region number to view : ");
				region_num = scanner.nextInt();
				try {
					System.out.println(list.getRegionInfo(region_num));
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("out of index");
				}
				break;

			// Print the entire price list
			case 3:
				list.printList();
				break;

			// Exit the program
			case 4:
				endCoin = false;
				System.out.println("Exit application");
				break;

			default:
				System.out.println("Insert 1 ~ 4");
				break;
			}
			System.out.println("\n");
		} while (endCoin);
		
		scanner.close();
	}
}
