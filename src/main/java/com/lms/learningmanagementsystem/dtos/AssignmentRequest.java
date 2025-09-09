package com.lms.learningmanagementsystem.dtos;

import java.time.LocalDate;

public class AssignmentRequest {
	private String title;
	private String description;
	private LocalDate dueDate;
	private Long sectionId;
	private Long facultyId;

	public AssignmentRequest() {
		super();
	}



	public AssignmentRequest(String title, String description, LocalDate dueDate, Long sectionId, Long facultyId) {
		super();
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.sectionId = sectionId;
		this.facultyId = facultyId;
	}



	public Long getFacultyId() {
		return facultyId;
	}



	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
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

}
