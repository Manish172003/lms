package com.lms.learningmanagementsystem.dtos;

import java.util.List;
import java.util.ArrayList;
public class FacultyResponse {
	
	private String name;
	private String email;
	public List<SectionResponse> getSections() {
		return sectionResponse;
	}

	public void setSections(List<SectionResponse> sectionResponse) {
		this.sectionResponse = sectionResponse;
	}

	private Long employeeId;
	private String department;
	private String designation;
	private String specialization;
	private List<SectionResponse> sectionResponse = new ArrayList<>();
	
	

	public FacultyResponse() {
	}

	public FacultyResponse(Long employeeId, String name, String email,  String department, String designation,
			String specialization) {
		super();
		this.name = name;
		this.email = email;
		this.employeeId = employeeId;
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

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
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
