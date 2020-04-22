package selfTest;

import java.util.Scanner;

public class TestScores {
	public static final int MAX_NUMBER_SCORES = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[] scores = new double[MAX_NUMBER_SCORES];
		int counting = 0;
		
		System.out.println("This program reads test scores and shows");
		System.out.println("how much each differs from the average.");
		System.out.println("Enter test scores:");
		
		counting = fillArray(scores);
		showDifference(scores, counting);
		
	}

	public static int fillArray(double[] scores)
	{
		System.out.println("Mark the end of the list with a negative number.");
		/* your code */
		Scanner scan = new Scanner(System.in);
		double data;
		int index = 0;
		
		data = scan.nextDouble();
		while((data >= 0) && (index < scores.length)) {
			scores[index++] = data;
			data = scan.nextDouble();
		}
		return index;
	}
	
	public static void showDifference(double[] scores, int size)
	{
		double average = computeAverage(scores, size);
		
		System.out.println("Average of the scores = " + average);
		System.out.println("The scores are: ");
		
		/* your code */
		for(int i = 0; i < size; i++) {
			System.out.printf("%.1f differs from average by %.2f\n", scores[i], (scores[i] - average));
		}
	}
	
	public static double computeAverage(double[] scores, int size)
	{	
		double total = 0;
		
		// compute the sum of the array
		for(int i = 0; i < size; i++)
			total += scores[i];
		double average = total / size;
		
		if(size > 0)
			return average;
		else {
			System.out.println("error.\n");
			return 0;
		}
	}
}
