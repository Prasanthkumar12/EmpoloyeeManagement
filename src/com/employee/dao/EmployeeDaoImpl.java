package com.employee.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.employee.entity.Address;
import com.employee.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
		// need to inject the session factory
		@Autowired
		private SessionFactory sessionFactory;
		HibernateTemplate hibernateTemplate;
				
		@Override
		public List<Employee> getEmployees() {
			hibernateTemplate = new HibernateTemplate(sessionFactory);
			List<Employee> list= hibernateTemplate.find("from Employee");
			System.out.println("list values "+list);		
			return list;
		}	
		@Override
		public void saveEmployee(Employee employee)
		{
	          Employee employee1 = new Employee();
	          Address address = new Address();
	          Date date = new Date();
	          address.setEmp_id(employee.getAddress().getEmp_id());
	          employee1.setDate_of_joining(date.toString());
	          employee1.setEmp_name(employee.getEmp_name());
	          employee1.setEmployee_status("Active");	          
	          employee1.setTime_stamp(date);
	          address.setEmail_id(employee.getAddress().getEmail_id());
	          address.setPhone_no(employee.getAddress().getPhone_no());
	          employee1.setAddress(address);
	          hibernateTemplate.save(address);
	          hibernateTemplate.save(employee1);
		}
		@Override
		public List<Employee> getEmployee(int id) {
			hibernateTemplate = new HibernateTemplate(sessionFactory);
			System.out.println("id==============="+id);
			List<Employee> list= hibernateTemplate.find("from Employee where address.emp_id="+id);
			System.out.println("list values "+list);		
			return list;
		}
		@Override
		public Address updateEmployee(int id) {
			hibernateTemplate = new HibernateTemplate(sessionFactory);
			System.out.println("id==============="+id);
			Address address = hibernateTemplate.get(Address.class, id);
			return address;
		}
		@Override
		public void inactiveEmployee(int id)
		{
			hibernateTemplate = new HibernateTemplate(sessionFactory);
			System.out.println("id==============="+id);
			SessionFactory session=hibernateTemplate.getSessionFactory();
			Session ses=session.openSession();
			Query query=ses.createQuery("update Employee set employee_status='InActive' where employee_details_emp_id="+id);
			query.executeUpdate();		
		}
		public void updateEmployeeDetails(Address address1)
		{
			hibernateTemplate = new HibernateTemplate(sessionFactory);
			SessionFactory session=hibernateTemplate.getSessionFactory();
			Session ses=session.openSession();
    		Query query=ses.createQuery("update Address set phone_no='"+address1.getPhone_no()+"', email_id='"+address1.getEmail_id()+"' where emp_id="+address1.getEmp_id());
    		Query query1=ses.createQuery("update Employee set emp_name='"+address1.getEmployee().getEmp_name()+"' where employee_details_emp_id="+address1.getEmp_id());
    		query.executeUpdate();
    		query1.executeUpdate();	        
		}
}
