package com.lms.learningmanagementsystem.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

@Entity
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String sectionName; 
	private int capacity;
	private int enrolledCount;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "faculty_id")
	private Faculty faculty;
	
	@ManyToMany
    @JoinTable(
        name = "section_students",
        joinColumns = @JoinColumn(name = "section_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "section")
    private List<Assignment> assignments = new ArrayList<>();

	@Version
	private Long version;

	public Section() {
	}

	

	public Section(Long id, String sectionName, int capacity, int enrolledCount, Course course, Faculty faculty,
			List<Student> students, List<Assignment> assignments, Long version) {
		super();
		this.id = id;
		this.sectionName = sectionName;
		this.capacity = capacity;
		this.enrolledCount = enrolledCount;
		this.course = course;
		this.faculty = faculty;
		this.students = students;
		this.assignments = assignments;
		this.version = version;
	}



	public List<Student> getStudents() {
		return students;
	}



	public void setStudents(List<Student> students) {
		this.students = students;
	}



	public List<Assignment> getAssignments() {
		return assignments;
	}



	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getEnrolledCount() {
		return enrolledCount;
	}

	public void setEnrolledCount(int enrolledCount) {
		this.enrolledCount = enrolledCount;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}