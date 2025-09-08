package com.lms.learningmanagementsystem.services;

import java.util.List;

import com.lms.learningmanagementsystem.dtos.SectionRequest;
import com.lms.learningmanagementsystem.dtos.SectionResponse;

public interface SectionService {
	SectionResponse createSection(SectionRequest request);

	SectionResponse getSectionById(Long id);

	List<SectionResponse> getAllSections();

	SectionResponse updateSection(Long id, SectionRequest request);

	void deleteSection(Long id);
}
