package com.lms.learningmanagementsystem.controllers;


import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lms.learningmanagementsystem.dtos.SectionResponse;
import com.lms.learningmanagementsystem.dtos.StudentRequest;
import com.lms.learningmanagementsystem.dtos.StudentResponse;
import com.lms.learningmanagementsystem.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
	
    @Autowired
    private  StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest request) {
        return ResponseEntity.ok(studentService.createStudent(request));
    }
    
    @GetMapping("/{studentId}/sections")
    public ResponseEntity<List<SectionResponse>> getSectionsByStudentId(@PathVariable("studentId") Long studentId) {
        return ResponseEntity.ok(studentService.getSectionsByStudentId(studentId));
    }
    
    @PostMapping("/{studentId}/{sectionId}")
    public ResponseEntity<StudentResponse> addStudentToSection(@PathVariable("studentId") Long studentId,@PathVariable("sectionId") Long sectionId)
    {
    	return ResponseEntity.ok(studentService.addStudentToSection(studentId, sectionId));
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateStudent(@PathVariable Long id, @RequestBody StudentRequest request) {
        return ResponseEntity.ok(studentService.updateStudent(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
