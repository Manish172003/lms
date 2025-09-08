package com.lms.learningmanagementsystem.services.impl;


import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.learningmanagementsystem.dtos.StudentRequest;
import com.lms.learningmanagementsystem.dtos.StudentResponse;
import com.lms.learningmanagementsystem.entities.Student;
import com.lms.learningmanagementsystem.exception.ResourceNotFoundException;
import com.lms.learningmanagementsystem.repositories.StudentRepository;
import com.lms.learningmanagementsystem.services.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    
	@Autowired
    private  StudentRepository studentRepository;

    @Override
    public StudentResponse createStudent(StudentRequest request) {
        Student student = mapToEntity(request);
        Student saved = studentRepository.save(student);
        return mapToResponse(saved);
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        return mapToResponse(student);
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest request) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setRollNumber(request.getRollNumber());
        student.setCgpa(request.getCgpa());
        student.setDepartment(request.getDepartment());

        Student updated = studentRepository.save(student);
        return mapToResponse(updated);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        studentRepository.delete(student);
    }

    // 🔹 Mapper functions
    private Student mapToEntity(StudentRequest request) {
    	Student student = new Student();
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setRollNumber(request.getRollNumber());
        student.setCgpa(request.getCgpa());
        student.setDepartment(request.getDepartment());
        return student;
    }

    private StudentResponse mapToResponse(Student student) {
    	 return new StudentResponse(
    	            student.getId(),
    	            student.getName(),
    	            student.getEmail(),
    	            student.getRollNumber(),
    	            student.getCgpa(),
    	            student.getDepartment()
    	    );
    }
}
