package com.lms.learningmanagementsystem.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.learningmanagementsystem.entities.Section;
import com.lms.learningmanagementsystem.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query("SELECT s.sections FROM Student s WHERE s.id = :studentId")
	List<Section> findSectionsByStudentId(@Param("studentId") Long studentId);
}
