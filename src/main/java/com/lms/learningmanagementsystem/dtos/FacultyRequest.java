package com.lms.learningmanagementsystem.dtos;

public class FacultyRequest {
	private String name;
	private String email;
	private String employeeId;
	private String department;
	private String designation;
	private String specialization;

	public FacultyRequest() {
	}

	public FacultyRequest(String name, String email,String department, String designation,
			String specialization) {
		super();
		this.name = name;
		this.email = email;	
		this.department = department;
		this.designation = designation;
		this.specialization = specialization;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

}
