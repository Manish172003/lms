package com.lms.learningmanagementsystem.dtos;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequest {
    private String name;
    private String email;
    private String rollNumber;
    private Double cgpa;
    private String department;
	public String getName() {
		return name;
	}
	public StudentRequest(String name, String email, String rollNumber, Double cgpa, String department) {
		super();
		this.name = name;
		this.email = email;
		this.rollNumber = rollNumber;
		this.cgpa = cgpa;
		this.department = department;
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
