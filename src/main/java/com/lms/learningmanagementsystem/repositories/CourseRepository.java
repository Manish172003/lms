package com.lms.learningmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.learningmanagementsystem.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
