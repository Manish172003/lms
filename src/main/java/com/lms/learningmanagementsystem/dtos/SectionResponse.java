package com.lms.learningmanagementsystem.dtos;

import java.util.ArrayList;
import java.util.List;

import com.lms.learningmanagementsystem.entities.Assignment;


public class SectionResponse {

	private Long id;
	private String sectionName;
	private int capacity;
	private int enrolledCount;
	private Long courseId;
	private String courseName;
	private Long facultyId;
	private String facultyName;
	private List<AssignmentResponse> assignments = new ArrayList<>();
	public SectionResponse(Long id, String sectionName, int capacity, int enrolledCount, Long courseId,
			String courseName, Long facultyId, String facultyName, List<AssignmentResponse> assignments
			) {
		super();
		this.id = id;
		this.sectionName = sectionName;
		this.capacity = capacity;
		this.enrolledCount = enrolledCount;
		this.courseId = courseId;
		this.courseName = courseName;
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.assignments = assignments;
	}

	public List<AssignmentResponse> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<AssignmentResponse> assignments) {
		this.assignments = assignments;
	}


	public SectionResponse(Long id, String sectionName, int capacity, int enrolledCount, Long courseId,
			String courseName, Long facultyId, String facultyName, Long assignmentId, String assignmentName) {
		super();
		this.id = id;
		this.sectionName = sectionName;
		this.capacity = capacity;
		this.enrolledCount = enrolledCount;
		this.courseId = courseId;
		this.courseName = courseName;
		this.facultyId = facultyId;
		this.facultyName = facultyName;
	}

	public SectionResponse() {
		super();
		
	}

	public SectionResponse(Long id, String sectionName, int capacity, int enrolledCount, Long courseId,
			String courseName, Long facultyId, String facultyName) {
		super();
		this.id = id;
		this.sectionName = sectionName;
		this.capacity = capacity;
		this.enrolledCount = enrolledCount;
		this.courseId = courseId;
		this.courseName = courseName;
		this.facultyId = facultyId;
		this.facultyName = facultyName;
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

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

}
