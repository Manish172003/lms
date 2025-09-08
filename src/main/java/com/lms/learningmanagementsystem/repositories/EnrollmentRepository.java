package com.lms.learningmanagementsystem.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.learningmanagementsystem.entities.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    boolean existsByStudentIdAndSectionId(Long studentId, Long sectionId);
}
