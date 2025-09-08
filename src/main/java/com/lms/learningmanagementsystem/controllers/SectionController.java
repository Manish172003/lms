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

import com.lms.learningmanagementsystem.dtos.SectionRequest;
import com.lms.learningmanagementsystem.dtos.SectionResponse;
import com.lms.learningmanagementsystem.services.SectionService;

@RestController
@RequestMapping("/api/sections")
public class SectionController {

	@Autowired
	private SectionService sectionService;

	@PostMapping
	public ResponseEntity<SectionResponse> createSection(@RequestBody SectionRequest request) {
		return ResponseEntity.ok(sectionService.createSection(request));
	}

	@GetMapping("/{id}")
	public ResponseEntity<SectionResponse> getSectionById(@PathVariable Long id) {
		return ResponseEntity.ok(sectionService.getSectionById(id));
	}

	@GetMapping
	public ResponseEntity<List<SectionResponse>> getAllSections() {
		return ResponseEntity.ok(sectionService.getAllSections());
	}

	@PutMapping("/{id}")
	public ResponseEntity<SectionResponse> updateSection(@PathVariable Long id, @RequestBody SectionRequest request) {
		return ResponseEntity.ok(sectionService.updateSection(id, request));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSection(@PathVariable Long id) {
		sectionService.deleteSection(id);
		return ResponseEntity.noContent().build();
	}
}