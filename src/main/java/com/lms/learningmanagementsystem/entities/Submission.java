package com.lms.learningmanagementsystem.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileUrl;  // or text content
    private LocalDateTime submittedAt;
    private Double score;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public LocalDateTime getSubmittedAt() {
		return submittedAt;
	}

	public void setSubmittedAt(LocalDateTime submittedAt) {
		this.submittedAt = submittedAt;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Submission(Long id, String fileUrl, LocalDateTime submittedAt, Double score, Assignment assignment,
			Student student) {
		super();
		this.id = id;
		this.fileUrl = fileUrl;
		this.submittedAt = submittedAt;
		this.score = score;
		this.assignment = assignment;
		this.student = student;
	}

	@ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
