package com.lms.learningmanagementsystem.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.learningmanagementsystem.dtos.CourseResponse;
import com.lms.learningmanagementsystem.dtos.FacultyRequest;
import com.lms.learningmanagementsystem.dtos.FacultyResponse;
import com.lms.learningmanagementsystem.dtos.SectionResponse;
import com.lms.learningmanagementsystem.entities.Course;
import com.lms.learningmanagementsystem.entities.Faculty;
import com.lms.learningmanagementsystem.exception.ResourceNotFoundException;
import com.lms.learningmanagementsystem.repositories.FacultyRepository;
import com.lms.learningmanagementsystem.repositories.SectionRepository;
import com.lms.learningmanagementsystem.services.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
    private FacultyRepository facultyRepository;
	
	@Autowired
    private SectionRepository sectionRepository;

    @Override
    public FacultyResponse createFaculty(FacultyRequest request) {
        Faculty faculty = mapToEntity(request);
        Faculty saved = facultyRepository.save(faculty);
        return mapToResponse(saved);
    }

    @Override
    public FacultyResponse getFacultyById(Long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty not found with id: " + id));
        return mapToResponse(faculty);
    }

    @Override
    public List<FacultyResponse> getAllFaculty() {
        return facultyRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FacultyResponse updateFaculty(Long id, FacultyRequest request) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty not found with id: " + id));

        faculty.setName(request.getName());
        faculty.setEmail(request.getEmail());
        faculty.setDepartment(request.getDepartment());
        faculty.setDesignation(request.getDesignation());
        faculty.setSpecialization(request.getSpecialization());

        Faculty updated = facultyRepository.save(faculty);
        return mapToResponse(updated);
    }

    @Override
    public void deleteFaculty(Long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty not found with id: " + id));
        facultyRepository.delete(faculty);
    }


    private Faculty mapToEntity(FacultyRequest request) {
        return new Faculty(
                request.getName(),
                request.getEmail(),
                request.getDepartment(),
                request.getDesignation(),
                request.getSpecialization()
        );
    }
    
    
    private FacultyResponse mapToResponse(Faculty faculty) {
       FacultyResponse response = new FacultyResponse();
       response.setDepartment(faculty.getDepartment());
       response.setDesignation(faculty.getDesignation());
       response.setEmail(faculty.getEmail());
       response.setName(faculty.getName());
       response.setSpecialization(faculty.getSpecialization());
       response.setEmployeeId(faculty.getFacultyId());
       
       if (faculty.getSections() != null) {
           List<SectionResponse> sectionResponses = faculty.getSections().stream().map(section -> {
               SectionResponse sr = new SectionResponse();
               sr.setId(section.getId());
               sr.setSectionName(section.getSectionName());
               sr.setCapacity(section.getCapacity());
               if (section.getFaculty() != null) {
                   sr.setFacultyId(section.getFaculty().getFacultyId());
                   sr.setFacultyName(section.getFaculty().getName());
               }
               if (section.getCourse() != null) {
    	   
                   sr.setCourseId(section.getCourse().getId());
                   sr.setCourseName(section.getCourse().getName());
               }
               return sr;
           }).collect(Collectors.toList());

           response.setSections(sectionResponses);
       }
       
       return response;
       
    }

}