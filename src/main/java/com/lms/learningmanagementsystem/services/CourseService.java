package com.lms.learningmanagementsystem.services;



import java.util.List;

import com.lms.learningmanagementsystem.dtos.CourseRequest;
import com.lms.learningmanagementsystem.dtos.CourseResponse;

public interface CourseService {
    CourseResponse createCourse(CourseRequest request);
    CourseResponse getCourseById(Long id);
    List<CourseResponse> getAllCourses();
    CourseResponse updateCourse(Long id, CourseRequest request);
    void deleteCourse(Long id);
}
