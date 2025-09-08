package com.lms.learningmanagementsystem.dtos;

public class SectionRequest {
	private String sectionName;
	private int capacity;
	private Long courseId;
	private Long facultyId;

	public SectionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SectionRequest(String sectionName, int capacity, Long courseId, Long facultyId) {
		super();
		this.sectionName = sectionName;
		this.capacity = capacity;
		this.courseId = courseId;
		this.facultyId = facultyId;
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

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}

}
