package com.lms.learningmanagementsystem.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.learningmanagementsystem.dtos.CourseRequest;
import com.lms.learningmanagementsystem.dtos.CourseResponse;
import com.lms.learningmanagementsystem.dtos.SectionResponse;
import com.lms.learningmanagementsystem.entities.Course;
import com.lms.learningmanagementsystem.entities.Section;
import com.lms.learningmanagementsystem.exception.ResourceNotFoundException;
import com.lms.learningmanagementsystem.repositories.CourseRepository;
import com.lms.learningmanagementsystem.services.CourseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

	@Autowired
    private  CourseRepository courseRepository;

    @Override
    public CourseResponse createCourse(CourseRequest request) {
        Course course = mapToEntity(request);
        Course saved = courseRepository.save(course);
        return mapToResponse(saved);
    }

    @Override
    public CourseResponse getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
        return mapToResponse(course);
    }

    @Override
    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest request) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));

        course.setCode(request.getCode());
        course.setName(request.getName());
        course.setDescription(request.getDescription());

        Course updated = courseRepository.save(course);
        return mapToResponse(updated);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
        courseRepository.delete(course);
    }

 
    private Course mapToEntity(CourseRequest request) {
    	Course course = new Course();
        course.setCode(request.getCode());
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        return course;
    }

    private CourseResponse mapToResponse(Course course) {
        CourseResponse response = new CourseResponse();
        response.setId(course.getId());
        response.setCode(course.getCode());
        response.setName(course.getName());
        response.setDescription(course.getDescription());

        if (course.getSections() != null) {
            List<SectionResponse> sectionResponses = course.getSections().stream().map(section -> {
                SectionResponse sr = new SectionResponse();
                sr.setId(section.getId());
                sr.setSectionName(section.getSectionName());
                sr.setCapacity(section.getCapacity());
                if (section.getFaculty() != null) {
                    sr.setFacultyId(section.getFaculty().getEmployeeId());
                    sr.setFacultyName(section.getFaculty().getName());
                }
                return sr;
            }).collect(Collectors.toList());

            response.setSections(sectionResponses);
        }

        return response;
    }


}
