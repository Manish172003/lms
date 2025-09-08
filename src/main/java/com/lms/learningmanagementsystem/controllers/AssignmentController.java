package com.lms.learningmanagementsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.learningmanagementsystem.dtos.AssignmentRequest;
import com.lms.learningmanagementsystem.dtos.AssignmentResponse;
import com.lms.learningmanagementsystem.services.AssignmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentController {

	@Autowired
	private AssignmentService assignmentService;

	@PostMapping
	public ResponseEntity<AssignmentResponse> createAssignment(@RequestBody AssignmentRequest request) {
		return ResponseEntity.ok(assignmentService.createAssignment(request));
	}

	@GetMapping("/section/{sectionId}")
	public ResponseEntity<List<AssignmentResponse>> getAssignmentsBySection(@PathVariable Long sectionId) {
		return ResponseEntity.ok(assignmentService.getAssignmentsBySection(sectionId));
	}

	@GetMapping("/{id}")
	public ResponseEntity<AssignmentResponse> getAssignmentById(@PathVariable Long id) {
		return ResponseEntity.ok(assignmentService.getAssignmentById(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
		assignmentService.deleteAssignment(id);
		return ResponseEntity.noContent().build();
	}
}