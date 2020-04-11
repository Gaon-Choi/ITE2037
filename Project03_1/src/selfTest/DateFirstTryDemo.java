package selfTest;

public class DateFirstTryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Write the Code*/
		DateFirstTry date1 = new DateFirstTry();
		DateFirstTry date2 = new DateFirstTry();
		
		// the submitted date
		date1.month = "April";
		date1.day = 9;
		// my birthday
		date2.month = "October";
		date2.day = 28;
		
		
		System.out.println("date1: " + date1.yellIfNewYear());
		System.out.println("date2: " + date2.yellIfNewYear());
		
	}

}
