package com.lms.learningmanagementsystem.dtos;



import lombok.*;

import java.util.ArrayList;
import java.util.List;

import com.lms.learningmanagementsystem.entities.Section;

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
    private List<SectionResponse> sections = new ArrayList<>();
	public CourseResponse(Long id, String code, String name, String description, List<SectionResponse> sections) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.sections = sections;
	}
	public CourseResponse() {
		
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
	public List<SectionResponse> getSections() {
		return new ArrayList<>(sections);
	}
	public void setSections(List<SectionResponse> sections) {
		this.sections = sections;
	} 
}
