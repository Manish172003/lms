package com.lms.learningmanagementsystem.services;

import java.util.List;

import com.lms.learningmanagementsystem.dtos.AssignmentRequest;
import com.lms.learningmanagementsystem.dtos.AssignmentResponse;

public interface AssignmentService {
    AssignmentResponse createAssignment(AssignmentRequest request);
    List<AssignmentResponse> getAssignmentsBySection(Long sectionId);
    AssignmentResponse getAssignmentById(Long id);
    void deleteAssignment(Long id);
}