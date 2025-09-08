package com.lms.learningmanagementsystem.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.learningmanagementsystem.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
