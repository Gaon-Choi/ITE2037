package selfTest;

public class EmployeeManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Write the code */
		// created five Employee objects
		Employee employee1 = new Employee("Walter White", 42, "Manager", 20000);
		Employee employee2 = new Employee("Jesse Pinkman", 32, "Assistant Manager", 12000, 7);
		Employee employee3 = new Employee("Jimmie McGill", 38);
		Employee employee4 = new Employee("Chuck McGill", 40);
		Employee employee5 = new Employee("Walter White", 42, "Manager", 20000);
		
		// change Walter White's Salary to 21000
		employee1.setSalary(21000);
		
		// print info of Walter White, Jesse Pinkman
		employee1.outInfo();
		employee2.outInfo();
		
		// vacation request of Jimmie McGill
		System.out.println(employee3.vacation(10));
		System.out.println();
		
		// vacation request of Jesse Pinkman
		System.out.println(employee2.vacation(10));
		System.out.println();
		
		// print info of Jimmie McGill
		employee3.outInfo();
		
		// print employee1 and employee2 have the same name, age, and Position
		System.out.println(employee1.equals(employee2));
		
		// print employee1 and employee5 have the same name, age, and Position
		System.out.println(employee1.equals(employee5));
		

	}

}
