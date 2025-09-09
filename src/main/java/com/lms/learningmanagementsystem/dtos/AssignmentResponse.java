package com.lms.learningmanagementsystem.dtos;

import java.time.LocalDate;

public class AssignmentResponse {
	private Long id;
	private String title;
	private String description;
	private LocalDate dueDate;
	private Long sectionId;
	private String sectionName;
	private String courseName;
	private Long facultyId;
	private String facultyName;

	public AssignmentResponse() {
		super();
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


	public AssignmentResponse(Long id, String title, String description, LocalDate dueDate, Long sectionId,
			String sectionName, String courseName, Long facultyId, String facultyName) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.sectionId = sectionId;
		this.sectionName = sectionName;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
