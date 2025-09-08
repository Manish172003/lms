package com.lms.learningmanagementsystem.dtos;



import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentResponse {
    public EnrollmentResponse(Long id, Long studentId, String studentName, Long sectionId, String sectionName,
			String courseName) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.studentName = studentName;
		this.sectionId = sectionId;
		this.sectionName = sectionName;
		this.courseName = courseName;
	}
	public EnrollmentResponse() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
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
	private Long id;
    private Long studentId;
    private String studentName;
    private Long sectionId;
    private String sectionName;
    private String courseName;
}
