package com.lms.learningmanagementsystem.dtos;



import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseResponse {
    private Long id;
    private String code;
    private String name;
    private String description;
    private List<Long> sectionIds;
	public CourseResponse(Long id, String code, String name, String description, List<Long> sectionIds) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.sectionIds = sectionIds;
	}
	public CourseResponse() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Long> getSectionIds() {
		return sectionIds;
	}
	public void setSectionIds(List<Long> sectionIds) {
		this.sectionIds = sectionIds;
	} 
}
