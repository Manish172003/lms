package com.lms.learningmanagementsystem.entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String rollNumber;
    private Double cgpa;
    private String department;
    
    @ManyToMany(mappedBy = "students")
    private List<Section> sections = new ArrayList<>();
    
    @OneToMany(mappedBy = "student")
    private List<Submission> submissions = new ArrayList<>();
    
    
	public Student(Long id, String name, String email, String rollNumber, Double cgpa, String department) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.rollNumber = rollNumber;
		this.cgpa = cgpa;
		this.department = department;
	}
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	public List<Submission> getSubmissions() {
		return submissions;
	}
	public void setSubmissions(List<Submission> submissions) {
		this.submissions = submissions;
	}
	public Student(Long id, String name, String email, String rollNumber, Double cgpa, String department,
			List<Section> sections, List<Submission> submissions) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.rollNumber = rollNumber;
		this.cgpa = cgpa;
		this.department = department;
		this.sections = sections;
		this.submissions = submissions;
	}
	public Student() {
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
