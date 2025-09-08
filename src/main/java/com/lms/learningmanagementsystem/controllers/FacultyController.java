package com.lms.learningmanagementsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.learningmanagementsystem.dtos.FacultyRequest;
import com.lms.learningmanagementsystem.dtos.FacultyResponse;
import com.lms.learningmanagementsystem.services.FacultyService;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	@PostMapping
	public ResponseEntity<FacultyResponse> createFaculty(@RequestBody FacultyRequest request) {
		return ResponseEntity.ok(facultyService.createFaculty(request));
	}

	@GetMapping("/{id}")
	public ResponseEntity<FacultyResponse> getFacultyById(@PathVariable Long id) {
		return ResponseEntity.ok(facultyService.getFacultyById(id));
	}

	@GetMapping
	public ResponseEntity<List<FacultyResponse>> getAllFaculty() {
		return ResponseEntity.ok(facultyService.getAllFaculty());
	}

	@PutMapping("/{id}")
	public ResponseEntity<FacultyResponse> updateFaculty(@PathVariable Long id, @RequestBody FacultyRequest request) {
		return ResponseEntity.ok(facultyService.updateFaculty(id, request));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
		facultyService.deleteFaculty(id);
		return ResponseEntity.noContent().build();
	}
}