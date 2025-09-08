package com.lms.learningmanagementsystem.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.learningmanagementsystem.dtos.AssignmentRequest;
import com.lms.learningmanagementsystem.dtos.AssignmentResponse;
import com.lms.learningmanagementsystem.entities.Assignment;
import com.lms.learningmanagementsystem.entities.Section;
import com.lms.learningmanagementsystem.exception.ResourceNotFoundException;
import com.lms.learningmanagementsystem.repositories.AssignmentRepository;
import com.lms.learningmanagementsystem.repositories.SectionRepository;
import com.lms.learningmanagementsystem.services.AssignmentService;

@Service
public class AssignmentServiceImpl implements AssignmentService {

	@Autowired
	private AssignmentRepository assignmentRepository;
	@Autowired
	private SectionRepository sectionRepository;

	@Override
	public AssignmentResponse createAssignment(AssignmentRequest request) {
		Section section = sectionRepository.findById(request.getSectionId()).orElseThrow(
				() -> new ResourceNotFoundException("Section not found with id: " + request.getSectionId()));

		Assignment assignment = new Assignment(null, request.getTitle(), request.getDescription(), request.getDueDate(),
				section);

		Assignment saved = assignmentRepository.save(assignment);
		return mapToResponse(saved);
	}

	@Override
	public List<AssignmentResponse> getAssignmentsBySection(Long sectionId) {
		return assignmentRepository.findBySectionId(sectionId).stream().map(this::mapToResponse)
				.collect(Collectors.toList());
	}

	@Override
	public AssignmentResponse getAssignmentById(Long id) {
		Assignment assignment = assignmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Assignment not found with id: " + id));
		return mapToResponse(assignment);
	}

	@Override
	public void deleteAssignment(Long id) {
		Assignment assignment = assignmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Assignment not found with id: " + id));
		assignmentRepository.delete(assignment);
	}

	// 🔹 Mapper
	private AssignmentResponse mapToResponse(Assignment assignment) {
		AssignmentResponse response = new AssignmentResponse();
		response.setId(assignment.getId());
		response.setTitle(assignment.getTitle());
		response.setDescription(assignment.getDescription());
		response.setDueDate(assignment.getDueDate());
		response.setSectionId(assignment.getSection().getId());
		response.setSectionName(assignment.getSection().getSectionName());
		response.setCourseName(assignment.getSection().getCourse().getName());
		return response;
	}

}