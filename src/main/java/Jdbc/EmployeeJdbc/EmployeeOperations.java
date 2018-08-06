package Jdbc.EmployeeJdbc;

import java.sql.SQLException;

public interface EmployeeOperations {

	void createEmployee(Employee employee) throws SQLException;

	Employee findEmployee(int empId) throws SQLException;

	Employee[] findAll() throws SQLException;

	boolean deleteEmployee(int empId) throws SQLException;

	void updateEmployee(Employee employee) throws SQLException;

	// new methods
	void groupByGender() throws SQLException;

	double averageSalary() throws SQLException;

	void sortById() throws SQLException;

	void sortBySalary() throws SQLException;

	void sortByNameAndSalary() throws SQLException;

	void sortByDepartmentNo() throws SQLException;

}
