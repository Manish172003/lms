package com.lms.learningmanagementsystem.services;

import java.util.List;

import com.lms.learningmanagementsystem.dtos.FacultyRequest;
import com.lms.learningmanagementsystem.dtos.FacultyResponse;

public interface FacultyService {
	FacultyResponse createFaculty(FacultyRequest request);

	FacultyResponse getFacultyById(Long id);

	List<FacultyResponse> getAllFaculty();

	FacultyResponse updateFaculty(Long id, FacultyRequest request);

	void deleteFaculty(Long id);
}
