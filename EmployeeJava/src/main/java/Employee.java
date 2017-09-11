package main.java;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name ="employee")

public class Employee {
	
	private String empId;
	private String name;
	private String designation;
	private Double salary;

	public Employee() {
	}

	public Employee(String empId, String name, String designation, double salary) {
		super();
		this.setEmpId(empId);
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@XmlElement
	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@XmlElement
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

}

