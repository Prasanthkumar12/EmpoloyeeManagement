package com.employee.dao;

import java.util.List;

import com.employee.entity.Address;
import com.employee.entity.Employee;

public interface EmployeeDao {
	public List<Employee> getEmployees();
	public void saveEmployee(Employee employee);
	public List<Employee> getEmployee(int id);
	public Address updateEmployee(int id);
	public void inactiveEmployee(int id);
	public void updateEmployeeDetails(Address address);
}
