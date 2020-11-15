package com.employee.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address_details")
public class Address {

	@Id
	@Column(name = "emp_id")
	private Integer emp_id;
	@Column(name="phone_no")
	private String phone_no;
	@Column(name="email_id")
	private String email_id;	
	
	@OneToOne(mappedBy="address", cascade=CascadeType.ALL)
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	@Override
	public String toString() {
		return "Address [emp_id=" + emp_id + ", phone_no=" + phone_no + ", email_id=" + email_id + "]";
	}

	public Address() {
		super();
	}
}
