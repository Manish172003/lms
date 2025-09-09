package com.lms.learningmanagementsystem.dtos;



import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {
    private Long id;
    private String name;
    private String email;
    private String rollNumber;
	private Double cgpa;
    private String department;
    private List<SectionResponse> sections = new ArrayList<>();
    
 


	public List<SectionResponse> getSections() {
		return sections;
	}

	public void setSections(List<SectionResponse> sections) {
		this.sections = sections;
	}

	public StudentResponse(Long id, String name, String email, String rollNumber, Double cgpa, String department,
			List<SectionResponse> sections) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.rollNumber = rollNumber;
		this.cgpa = cgpa;
		this.department = department;
		this.sections = sections;
	}

	public StudentResponse(Long id, String name, String email, String rollNumber, Double cgpa, String department) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.rollNumber = rollNumber;
		this.cgpa = cgpa;
		this.department = department;
	}

	public StudentResponse() {
		// TODO Auto-generated constructor stub
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

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public Double getCgpa() {
		return cgpa;
	}

	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
    
    
}

