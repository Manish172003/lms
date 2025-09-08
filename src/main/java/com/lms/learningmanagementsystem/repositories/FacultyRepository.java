package com.lms.learningmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.learningmanagementsystem.entities.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
