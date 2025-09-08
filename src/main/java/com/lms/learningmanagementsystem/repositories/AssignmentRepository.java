package com.lms.learningmanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.learningmanagementsystem.entities.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
	List<Assignment> findBySectionId(Long sectionId);
}
