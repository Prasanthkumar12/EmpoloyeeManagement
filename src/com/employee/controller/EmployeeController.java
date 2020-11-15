package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.employee.entity.Address;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	// need to inject our employee service
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		// get employees from the service
		List<Employee> theEmployees = employeeService.getEmployees();				
		// add the employees to the model
		theModel.addAttribute("employees", theEmployees);
		return "list-employees";
	}	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {	
		// create model attribute to bind form data
		Employee employee = new Employee();
		theModel.addAttribute("employees", employee);	
		return "employee-form";
	}
	@RequestMapping("/saveEmployee")
	public String saveCustomer(@ModelAttribute("employees") Employee theEmployee) {
		// save the employee using our service
		employeeService.saveEmployee(theEmployee);			
		return "redirect:/list";
	}
	@RequestMapping("/showFormForView")
	public String showFormForView(Model theModel) {
		Employee employee = new Employee();
		theModel.addAttribute("employees", employee);
		return "view-employee";
	}
	@RequestMapping("/viewEmployee")
	public ModelAndView  viewEmployee(@RequestParam("address.emp_id") int theId,Model theModel) {
		List<Employee> theEmployees = employeeService.getEmployee(theId);
		if (theEmployees.isEmpty() ) {
			Employee employee = new Employee();		
			theModel.addAttribute("employees", employee);
			return new ModelAndView("view-employee", "error", "Please enter correct empid");
		}
		else
		{
			theModel.addAttribute("employees", theEmployees);
			return new ModelAndView("employee_details", "message", "");
		}
	}
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(Model theModel) {
		Employee employee = new Employee();
		theModel.addAttribute("employees", employee);
		return "update-employee";
	}
	@RequestMapping("/updateEmployee")
	public ModelAndView updateEmployee(@RequestParam("address.emp_id") int theId,Model theModel) {
		
		Address theEmployees = employeeService.updateEmployee(theId);
		if (theEmployees == null ) {
			Employee employee = new Employee();			
			theModel.addAttribute("employees", employee);
			return new ModelAndView("update-employee", "error", "Please enter correct empid");
		}
		else
		{
			theModel.addAttribute("employees", theEmployees);
			return new ModelAndView("employee-update-form", "message", "");
		}
	}
	@RequestMapping("/updateEmployeeDetails")
	public String updateEmployeeDetails(@ModelAttribute("employees") Address theAddress) {
		employeeService.updateEmployeeDetails(theAddress);			
		return "redirect:/list";
	}
	
	@RequestMapping("/showFormForInActive")
	public String showFormForInActive(Model theModel) {
		Employee employee = new Employee();
		theModel.addAttribute("employees", employee);
		return "inactive-employee";
	}
	@RequestMapping("/inactiveEmployee")
	public ModelAndView inactiveEmployee(@RequestParam("address.emp_id") int theId,Model theModel) {
		List<Employee> theEmployees = employeeService.getEmployee(theId);
		if (theEmployees.isEmpty() ) {
			Employee employee = new Employee();		
			theModel.addAttribute("employees", employee);
			return new ModelAndView("inactive-employee", "error", "Please enter correct empid");
		}
		else
		{
			theModel.addAttribute("employees", theEmployees);
			return new ModelAndView("inactive_employee_details", "message", "");
		}
	}
	@RequestMapping("/inactive")
	public String inactive(@RequestParam("address.emp_id") int theId) {
		employeeService.inactiveEmployee(theId);
		
		return "redirect:/list";
	}
}