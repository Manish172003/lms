package com.lms.learningmanagementsystem.services.impl;


import jakarta.persistence.OptimisticLockException;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lms.learningmanagementsystem.dtos.EnrollmentRequest;
import com.lms.learningmanagementsystem.dtos.EnrollmentResponse;
import com.lms.learningmanagementsystem.entities.Enrollment;
import com.lms.learningmanagementsystem.entities.Student;
import com.lms.learningmanagementsystem.exception.ResourceNotFoundException;
import com.lms.learningmanagementsystem.repositories.EnrollmentRepository;
import com.lms.learningmanagementsystem.repositories.StudentRepository;
import com.lms.learningmanagementsystem.services.EnrollmentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
  
	@Autowired
    private EnrollmentRepository enrollmentRepository;
	@Autowired
    private StudentRepository studentRepository;
	@Autowired
    private SectionRepository sectionRepository;

    @Override
    @Transactional
    public EnrollmentResponse enrollStudent(EnrollmentRequest request) {
        if (enrollmentRepository.existsByStudentIdAndSectionId(request.getStudentId(), request.getSectionId())) {
            throw new RuntimeException("Student is already enrolled in this section");
        }

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + request.getStudentId()));

        Section section = sectionRepository.findById(request.getSectionId())
                .orElseThrow(() -> new ResourceNotFoundException("Section not found with id: " + request.getSectionId()));

        if (section.getEnrolledCount() >= section.getCapacity()) {
            throw new RuntimeException("Section is already full");
        }

        try {
            section.setEnrolledCount(section.getEnrolledCount() + 1);
            sectionRepository.save(section);

            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(student);
            enrollment.setSection(section);
            Enrollment saved = enrollmentRepository.save(enrollment);
            return mapToResponse(saved);
        } catch (OptimisticLockException e) {
            throw new RuntimeException("Concurrent enrollment detected. Please try again.");
        }
    }

    @Override
    public List<EnrollmentResponse> getEnrollmentsByStudent(Long studentId) {
        return enrollmentRepository.findAll().stream()
                .filter(e -> e.getStudent().getId().equals(studentId))
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void cancelEnrollment(Long enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id: " + enrollmentId));

        Section section = enrollment.getSection();
        section.setEnrolledCount(section.getEnrolledCount() - 1);
        sectionRepository.save(section);

        enrollmentRepository.delete(enrollment);
    }

   
    private EnrollmentResponse mapToResponse(Enrollment enrollment) {
    	 EnrollmentResponse response = new EnrollmentResponse();

    	    response.setId(enrollment.getId());
    	    response.setStudentId(enrollment.getStudent().getId());
    	    response.setStudentName(enrollment.getStudent().getName());
    	    response.setSectionId(enrollment.getSection().getId());
    	    response.setSectionName(enrollment.getSection().getSectionName());
    	    response.setCourseName(enrollment.getSection().getCourse().getName());

    	    return response;
    }
}

