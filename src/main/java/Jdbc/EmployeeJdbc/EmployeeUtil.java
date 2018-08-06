package Jdbc.EmployeeJdbc;

import java.util.Scanner;

public class EmployeeUtil {

	private static Scanner scanner = new Scanner(System.in);

	public static int chooseOperation() {
		System.out.println();
		System.out.println("   ||| MENU |||   ");
		System.out.println("1. Create Employee");
		System.out.println("2. Read(View) Employee");
		System.out.println("3. View all Employees");
		System.out.println("4. Update Employee");
		System.out.println("5. Delete Employee");
		// System.out.println("6. Calculate HRA");
		// System.out.println("7. Calculate Gross Salary");
		System.out.println("6. Calculate average salary");
		System.out.println("7. Group by on gender");
		System.out.println("8. Sorting");
//		System.out.println("9. Employees who're salary is greater than given salary");
		System.out.println("9. Exit");

		System.out.print("Select a choice :");
		return scanner.nextInt();
	}

	public static Employee readEmployee() {
		System.out.print("Enter trng.Employee id:");
		int id = scanner.nextInt();

		System.out.print("Enter trng.Employee firstname:");
		String firstName = scanner.next();

		System.out.print("Enter trng.Employee lastname:");
		String lastName = scanner.next();

		System.out.print("Enter trng.Employee Salary:");
		double salary = scanner.nextDouble();
		if (salary < 5000) {
			try {
				throw new InvalidSalaryException("Salary should be more than $5000");
			} catch (InvalidSalaryException e) {
				System.out.println(e);
				System.out.println("Enter Salary again(Minimum $5000)");
				salary = scanner.nextDouble();

			}
		}
		System.out.print("Enter trng.Employee DepartmentNo:");
		int deptNo = scanner.nextInt();

		System.out.println("Select the gender");
		System.out.println("	1.Male");
		System.out.println("	2.Female");

		int gender = scanner.nextInt();
		return new Employee(id, firstName, lastName, salary, gender, deptNo);
	}
}
