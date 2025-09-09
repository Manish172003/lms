package com.lms.learningmanagementsystem.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long facultyId;
	private String name;
	private String email;
	private String department;
	private String designation;
	private String specialization;
	
	@OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Section> sections;
	
    @OneToMany(mappedBy = "faculty")
    private List<Assignment> assignments = new ArrayList<>();

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public Faculty() {

	}

	public Faculty(Long facultyId, String name, String email, String department, String designation,
			String specialization, List<Section> sections, List<Assignment> assignments) {
		super();
		this.facultyId = facultyId;
		this.name = name;
		this.email = email;
		this.department = department;
		this.designation = designation;
		this.specialization = specialization;
		this.sections = sections;
		this.assignments = assignments;
	}

	public Faculty(long facultyId,String name, String email, String department, String designation,
			String specialization) {
		super();
		
		this.name = name;
		this.email = email;
		this.facultyId = facultyId;
		this.department = department;
		this.designation = designation;
		this.specialization = specialization;
	}
	
	public Faculty(String name, String email, String department, String designation,
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

	public Long getFacultyId() {
		return facultyId;
	}

	public void setEmployeeId(Long facultyId) {
		this.facultyId = facultyId;
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