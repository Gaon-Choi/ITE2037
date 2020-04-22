package selfTest;

import java.util.Scanner;

public class GradeBook {
	private int numberOfStudents;
	private int numberOfQuizzes;
	
	private int [][] grade;
	
	private double[] studentAverage;
	private double[] quizAverage;

	public GradeBook()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter the number of Students:");
		numberOfStudents = keyboard.nextInt();
		
		System.out.println("Enter the number of Quizzes:");
		numberOfQuizzes = keyboard.nextInt();
		

		/* Initialize grade */
		grade = new int[numberOfStudents][numberOfQuizzes];
		
		for(int i = 0; i < numberOfStudents; i++) {
			for(int j = 0; j < numberOfQuizzes; j++) {
				System.out.printf("Enter the score for student %d on quiz %d\n", i + 1, j + 1);
				grade[i][j] = keyboard.nextInt();
			}
		}
		fillStudentAverage();
		fillQuizAverage();
	}
	

	
	private void fillStudentAverage()
	{
		/* Write the code */
		studentAverage = new double[numberOfStudents];
		for(int i = 0; i < numberOfStudents; i++) {
			for(int j = 0; j < numberOfQuizzes; j++)
				studentAverage[i] += grade[i][j];
			studentAverage[i] /= numberOfQuizzes;
		}
	}
	
	private void fillQuizAverage()
	{
		/* Write the code */
		quizAverage = new double[numberOfQuizzes];
		for(int i = 0; i < numberOfQuizzes; i++) {
			for(int j = 0; j < numberOfStudents; j++)
				quizAverage[i] += grade[j][i];
			quizAverage[i] /= numberOfStudents;
		}
	}
	
	
	public void display()
	{
		for(int studentNumber =1; studentNumber <= numberOfStudents; studentNumber++)
		{
			System.out.print("Student " + studentNumber + " Quizzes: ");
			for(int quizNumber = 1;quizNumber <= numberOfQuizzes; quizNumber++)
				System.out.print(grade[studentNumber-1][quizNumber-1] + " ");
			System.out.println("Ave = " + studentAverage[studentNumber-1]);
		}
		
		System.out.println("Quiz average : ");
		
		for(int quizNumber = 1; quizNumber <= numberOfQuizzes;quizNumber++)
			System.out.print("Quiz "+quizNumber + " Ave = "+ quizAverage[quizNumber - 1] + " ");
		System.out.println();
	}
	
	
}