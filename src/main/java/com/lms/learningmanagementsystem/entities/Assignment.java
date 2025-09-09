package com.lms.learningmanagementsystem.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Assignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String description;

	private LocalDate dueDate;

	@ManyToOne
	@JoinColumn(name = "section_id", nullable = false)
	private Section section;
	
	@ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(mappedBy = "assignment")
    private List<Submission> submissions = new ArrayList<>();

	public Assignment() {
		super();
		
	}

	



	public Faculty getFaculty() {
		return faculty;
	}





	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}





	public Assignment(Long id, String title, String description, LocalDate dueDate, Section section, Faculty faculty,
			List<Submission> submissions) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.section = section;
		this.faculty = faculty;
		this.submissions = submissions;
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




	public List<Submission> getSubmissions() {
		return submissions;
	}



	public void setSubmissions(List<Submission> submissions) {
		this.submissions = submissions;
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

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

}