package com.lms.learningmanagementsystem.services;


import java.util.List;

import com.lms.learningmanagementsystem.dtos.StudentRequest;
import com.lms.learningmanagementsystem.dtos.StudentResponse;

public interface StudentService {
    StudentResponse createStudent(StudentRequest request);
    StudentResponse getStudentById(Long id);
    List<StudentResponse> getAllStudents();
    StudentResponse updateStudent(Long id, StudentRequest request);
    void deleteStudent(Long id);
}

