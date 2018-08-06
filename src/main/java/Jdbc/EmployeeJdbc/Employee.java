package Jdbc.EmployeeJdbc;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

	public enum Gender {
		FEMALE, MALE;
	}

	private int id;
	private String firstName;
	private String lastName;
	private double salary;
	Employee manager;
	int deptNo;
	Gender gender;

	public Employee getHighSalaryEmployee(Employee e) {
		return this.salary > e.salary ? this : e;
	}

	public Employee() {
		super();
	}

	public Employee(int id) {
		super();
		this.id = id;
	}

	public Employee(int id, String firstName, String lastName, double salary, int gender, int deptNo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.deptNo = deptNo;
		/*
		 * this.address = address; this.manager = manager; this.period = period;
		 * this.gender = gender;
		 */
		if (gender == 1) {
			this.gender = Gender.MALE;
		} else if (gender == 2) {
			this.gender = Gender.FEMALE;
		}
	}

	public double calculateHRA() {
		// System.out.println(salary);
		double hra = (salary) * (20.00 / 100.00);
		// System.out.println(hra);
		return hra;

	}

	public double calculateGrossSal() {

		double grossSal = this.salary + calculateHRA();
		return grossSal;

	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptNo;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (deptNo != other.deptNo)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender != other.gender)
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+  ", deptNo=" + deptNo + ", gender=" + gender + "]";
	}

	@Override
	public int compareTo(Employee o) {
		int flag = (int) (this.getSalary() - o.getSalary());
		if (flag == 0)
			flag = this.getLastName().compareTo(o.getLastName());
		return flag;
	}
			
		//nested Class
	static class EmployeeDepartmentcomparator implements Comparator<Employee> {

		@Override
		public int compare(Employee o1, Employee o2) {

			return o1.deptNo - o2.deptNo;
		}

	}

}
