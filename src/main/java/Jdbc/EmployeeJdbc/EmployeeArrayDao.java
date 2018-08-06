package Jdbc.EmployeeJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Jdbc.EmployeeJdbc.Employee.Gender;

@SuppressWarnings("unused")
public class EmployeeArrayDao implements EmployeeOperations {
	private List<Employee> employeeList = null;
	private Iterator<Employee> it = null;
	// Employee e;
	Connection c;
	private static Employee[] ee;

	public EmployeeArrayDao() {
		employeeList = new ArrayList<Employee>();
		// e = new Employee();
		c = DatabaseConnectivity.connect();
	}

	@Override
	public void createEmployee(Employee employee) throws SQLException {
		String sql = "INSERT into data values (?,?,?,?,?,?)";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setInt(1, employee.getId());
		pst.setString(2, employee.getFirstName());
		pst.setString(3, employee.getLastName());
		pst.setString(4, employee.getGender().name());
		pst.setDouble(5, employee.getSalary());
		pst.setInt(6, employee.getDeptNo());
		System.out.println("Rows Inserted");
		pst.executeUpdate();

	}

	@Override
	public Employee findEmployee(int empId) throws SQLException {
		Employee e = new Employee();
		String sql = "Select * from data where id=" + empId;
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			e.setId(rs.getInt(1));
			e.setFirstName(rs.getString(2));
			e.setLastName(rs.getString(3));
			String gen = rs.getString(4);
			if (gen.equalsIgnoreCase("Male"))
				e.setGender(Gender.MALE);
			else
				e.setGender(Gender.FEMALE);
			e.setSalary(rs.getDouble(5));
			e.setDeptNo(rs.getInt(6));
		}
		return e;
	}

	@Override
	public Employee[] findAll() throws SQLException {
		//

		String sql = "Select * from data";
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Employee e = new Employee();
			e.setId(rs.getInt(1));
			e.setFirstName(rs.getString(2));
			e.setLastName(rs.getString(3));
			String gen = rs.getString(4);
			if (gen.equalsIgnoreCase("Male"))
				e.setGender(Gender.MALE);
			else
				e.setGender(Gender.FEMALE);
			e.setSalary(rs.getDouble(5));
			e.setDeptNo(rs.getInt(6));
			employeeList.add(e);
		}
		ee = employeeList.toArray(new Employee[employeeList.size()]);
		return ee;
	}

	@Override
	public boolean deleteEmployee(int empId) throws SQLException {
		String sql = "delete from data where id=?";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setInt(1, empId);
		pst.executeUpdate();
		return true;
	}

	@Override
	public void updateEmployee(Employee employee) throws SQLException {

		String sql = "update data set firstname=?, lastname=?, gender=?, salary=?, deptno=? where id = ?";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setString(1, employee.getFirstName());
		pst.setString(2, employee.getLastName());
		pst.setString(3, employee.getGender().name());
		pst.setDouble(4, employee.getSalary());
		pst.setInt(5, employee.getDeptNo());
		pst.setInt(6, employee.getId());
		System.out.println("Rows Inserted");
		pst.executeUpdate();

	}

	@Override
	public void groupByGender() throws SQLException {
		String sql = "SELECT count(*) FROM `data` GROUP BY gender";
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		int male = 0;
		int female = 0;
		while (rs.next()) {
			if (female == 0 && male == 0)

				female = rs.getInt(1);
			else
				male = rs.getInt(1);
		}
		System.out.println("Female: " + female);
		System.out.println("Male:  " + male);
	}

	@Override
	public double averageSalary() throws SQLException {

		String sql = "select avg(salary) from data";
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		double averageSalary = 0;
		while (rs.next())
			averageSalary = rs.getDouble(1);
		return averageSalary;

	}

	// Anonymous inner class for Comparator
	public void sortById() throws SQLException {

		String sql = "SELECT * FROM data" + "   ORDER BY id";
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Employee e = new Employee();
			e.setId(rs.getInt(1));
			e.setFirstName(rs.getString(2));
			e.setLastName(rs.getString(3));
			String gen = rs.getString(4);
			if (gen.equalsIgnoreCase("Male"))
				e.setGender(Gender.MALE);
			else
				e.setGender(Gender.FEMALE);
			e.setSalary(rs.getDouble(5));
			e.setDeptNo(rs.getInt(6));
			employeeList.add(e);
		}
		employeeList.forEach(System.out::println);

	}

	public void sortBySalary() throws SQLException {
		String sql = "SELECT * FROM data" + "   ORDER BY salary";
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Employee e = new Employee();
			e.setId(rs.getInt(1));
			e.setFirstName(rs.getString(2));
			e.setLastName(rs.getString(3));
			String gen = rs.getString(4);
			if (gen.equalsIgnoreCase("Male"))
				e.setGender(Gender.MALE);
			else
				e.setGender(Gender.FEMALE);
			e.setSalary(rs.getDouble(5));
			e.setDeptNo(rs.getInt(6));
			employeeList.add(e);
		}
		employeeList.forEach(System.out::println);

	}

	public void sortByNameAndSalary() throws SQLException {
		String sql = "SELECT * FROM data" + "   ORDER BY name,salary";
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Employee e = new Employee();
			e.setId(rs.getInt(1));
			e.setFirstName(rs.getString(2));
			e.setLastName(rs.getString(3));
			String gen = rs.getString(4);
			if (gen.equalsIgnoreCase("Male"))
				e.setGender(Gender.MALE);
			else
				e.setGender(Gender.FEMALE);
			e.setSalary(rs.getDouble(5));
			e.setDeptNo(rs.getInt(6));
			employeeList.add(e);
		}
		employeeList.forEach(System.out::println);

	}

	public void sortByDepartmentNo() throws SQLException {
		String sql = "SELECT * FROM data" + "   ORDER BY deptno";
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Employee e = new Employee();
			e.setId(rs.getInt(1));
			e.setFirstName(rs.getString(2));
			e.setLastName(rs.getString(3));
			String gen = rs.getString(4);
			if (gen.equalsIgnoreCase("Male"))
				e.setGender(Gender.MALE);
			else
				e.setGender(Gender.FEMALE);
			e.setSalary(rs.getDouble(5));
			e.setDeptNo(rs.getInt(6));
			employeeList.add(e);
		}
		employeeList.forEach(System.out::println);

	}

}
