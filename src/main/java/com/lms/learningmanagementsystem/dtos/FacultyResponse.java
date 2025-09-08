package com.lms.learningmanagementsystem.dtos;

public class FacultyResponse {
	private Long id;
	private String name;
	private String email;
	private String employeeId;
	private String department;
	private String designation;
	private String specialization;

	public FacultyResponse() {
	}

	public FacultyResponse(Long id, String name, String email, String employeeId, String department, String designation,
			String specialization) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.employeeId = employeeId;
		this.department = department;
		this.designation = designation;
		this.specialization = specialization;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
