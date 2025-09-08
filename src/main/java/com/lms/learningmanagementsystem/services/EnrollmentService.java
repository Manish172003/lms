package com.lms.learningmanagementsystem.services;


import java.util.List;

import com.lms.learningmanagementsystem.dtos.EnrollmentRequest;
import com.lms.learningmanagementsystem.dtos.EnrollmentResponse;

public interface EnrollmentService {
    EnrollmentResponse enrollStudent(EnrollmentRequest request);
    List<EnrollmentResponse> getEnrollmentsByStudent(Long studentId);
    void cancelEnrollment(Long enrollmentId);
}
