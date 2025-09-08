package com.lms.learningmanagementsystem.dtos;



import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentRequest {
    private Long studentId;
    public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Long getSectionId() {
		return sectionId;
	}
	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}
	public EnrollmentRequest(Long studentId, Long sectionId) {
		super();
		this.studentId = studentId;
		this.sectionId = sectionId;
	}
	private Long sectionId;
}
