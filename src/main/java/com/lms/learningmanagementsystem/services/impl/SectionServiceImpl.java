package com.lms.learningmanagementsystem.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.learningmanagementsystem.dtos.SectionRequest;
import com.lms.learningmanagementsystem.dtos.SectionResponse;
import com.lms.learningmanagementsystem.entities.Course;
import com.lms.learningmanagementsystem.entities.Faculty;
import com.lms.learningmanagementsystem.entities.Section;
import com.lms.learningmanagementsystem.exception.ResourceNotFoundException;
import com.lms.learningmanagementsystem.repositories.CourseRepository;
import com.lms.learningmanagementsystem.repositories.FacultyRepository;
import com.lms.learningmanagementsystem.repositories.SectionRepository;
import com.lms.learningmanagementsystem.services.SectionService;

@Service
public class SectionServiceImpl implements SectionService {

	@Autowired
	private SectionRepository sectionRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private FacultyRepository facultyRepository;

	@Override
	public SectionResponse createSection(SectionRequest request) {
		Section section = mapToEntity(request);
		Section saved = sectionRepository.save(section);
		return mapToResponse(saved);
	}

	@Override
	public SectionResponse getSectionById(Long id) {
		Section section = sectionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Section not found with id: " + id));
		return mapToResponse(section);
	}

	@Override
	public List<SectionResponse> getAllSections() {
		return sectionRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
	}

	@Override
	public SectionResponse updateSection(Long id, SectionRequest request) {
		Section section = sectionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Section not found with id: " + id));

		Course course = courseRepository.findById(request.getCourseId())
				.orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + request.getCourseId()));

		Faculty faculty = facultyRepository.findById(request.getFacultyId()).orElseThrow(
				() -> new ResourceNotFoundException("Faculty not found with id: " + request.getFacultyId()));

		section.setSectionName(request.getSectionName());
		section.setCapacity(request.getCapacity());
		section.setCourse(course);
		section.setFaculty(faculty);

		Section updated = sectionRepository.save(section);
		return mapToResponse(updated);
	}

	@Override
	public void deleteSection(Long id) {
		Section section = sectionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Section not found with id: " + id));
		sectionRepository.delete(section);
	}

	private Section mapToEntity(SectionRequest request) {
		Course course = courseRepository.findById(request.getCourseId())
				.orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + request.getCourseId()));

		Faculty faculty = facultyRepository.findById(request.getFacultyId()).orElseThrow(
				() -> new ResourceNotFoundException("Faculty not found with id: " + request.getFacultyId()));

		Section section = new Section();
		section.setSectionName(request.getSectionName());
		section.setCapacity(request.getCapacity());
		section.setEnrolledCount(0);
		section.setCourse(course);
		section.setFaculty(faculty);

		return section;
	}

	private SectionResponse mapToResponse(Section section) {
		SectionResponse response = new SectionResponse();
		response.setId(section.getId());
		response.setSectionName(section.getSectionName());
		response.setCapacity(section.getCapacity());
		response.setEnrolledCount(section.getEnrolledCount());

		if (section.getCourse() != null) {
			response.setCourseId(section.getCourse().getId());
			response.setCourseName(section.getCourse().getName());
		}

		if (section.getFaculty() != null) {
			response.setFacultyId(section.getFaculty().getFacultyId());
			response.setFacultyName(section.getFaculty().getName());
		}

		return response;
	}

}
