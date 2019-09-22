package com.starfall.springmvc.demo.bean;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo.bean
 * @className Employee
 * @date 2019/9/7 22:53
 * @description Employee
 */
public class Employee implements Serializable {
	private static final long serialVersionUID = -953744435608568365L;

	private Integer employeeId;
	private String employeeName;
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date hireDate;
	@NumberFormat(pattern = "#,###")
	private Double salary;

	public Employee() {
	}

	public Employee(Integer employeeId, String employeeName, Date hireDate, Double salary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.hireDate = hireDate;
		this.salary = salary;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{" + "employeeId=" + employeeId + ", employeeName='" + employeeName + '\'' + ", hireDate="
				+ hireDate + ", salary=" + salary + '}';
	}
}
