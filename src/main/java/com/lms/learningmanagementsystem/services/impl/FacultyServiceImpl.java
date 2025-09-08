package com.lms.learningmanagementsystem.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.learningmanagementsystem.dtos.FacultyRequest;
import com.lms.learningmanagementsystem.dtos.FacultyResponse;
import com.lms.learningmanagementsystem.entities.Faculty;
import com.lms.learningmanagementsystem.exception.ResourceNotFoundException;
import com.lms.learningmanagementsystem.repositories.FacultyRepository;
import com.lms.learningmanagementsystem.services.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
    private FacultyRepository facultyRepository;

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
        faculty.setEmployeeId(request.getEmployeeId());
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

    // 🔹 Mapper functions
    private Faculty mapToEntity(FacultyRequest request) {
        return new Faculty(
                null, // assuming id is auto-generated, set null
                request.getName(),
                request.getEmail(),
                request.getEmployeeId(),
                request.getDepartment(),
                request.getDesignation(),
                request.getSpecialization()
        );
    }

    private FacultyResponse mapToResponse(Faculty faculty) {
        return new FacultyResponse(
                faculty.getId(),
                faculty.getName(),
                faculty.getEmail(),
                faculty.getEmployeeId(),
                faculty.getDepartment(),
                faculty.getDesignation(),
                faculty.getSpecialization()
        );
    }

}