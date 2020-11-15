package com.employee.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="employee_details")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name="emp_name")
	private String emp_name;
	@Column(name="date_of_joining")
	private String date_of_joining;
	@Column(name="employee_status")
	private String employee_status;	
	@Column(name="time_stamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date time_stamp;
	@OneToOne(cascade=javax.persistence.CascadeType.ALL)
	@JoinColumn(name="employee_details_emp_id",nullable=false)
	private Address address;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(String date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	public String getEmployee_status() {
		return employee_status;
	}

	public void setEmployee_status(String employee_status) {
		this.employee_status = employee_status;
	}

	public Date getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(Date time_stamp) {
		this.time_stamp = time_stamp;
	}

	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", emp_name=" + emp_name + ", date_of_joining=" + date_of_joining
				+ ", employee_status=" + employee_status + ", time_stamp=" + time_stamp + ", address=" + address + "]";
	}

	public Employee() {
		super();
	}
}
