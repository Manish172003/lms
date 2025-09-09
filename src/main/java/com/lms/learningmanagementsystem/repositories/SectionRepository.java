package com.lms.learningmanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.lms.learningmanagementsystem.entities.Course;
import com.lms.learningmanagementsystem.entities.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
	
	@Query("SELECT DISTINCT s.course FROM Section s WHERE s.faculty.facultyId = :facultyId")
	List<Course> findCoursesByFacultyId(@Param("facultyId") Long facultyId);
}