package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Address;
import com.employee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// need to inject Employee dao
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}
	@Override
	@Transactional
	public void saveEmployee(Employee employee) {

	   employeeDao.saveEmployee(employee);
	}
	@Override
	@Transactional
	public List<Employee> getEmployee(int id) {
		return employeeDao.getEmployee(id);
	}
	@Override
	@Transactional
	public Address updateEmployee(int id) {
		return employeeDao.updateEmployee(id);
	}
	@Override
	@Transactional
	public void inactiveEmployee(int id)
	{
		employeeDao.inactiveEmployee(id);
	}
	@Override
	@Transactional
	public void updateEmployeeDetails(Address address)
	{
		   employeeDao.updateEmployeeDetails(address);
	}
}
