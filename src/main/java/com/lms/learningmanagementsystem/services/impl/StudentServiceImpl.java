package com.lms.learningmanagementsystem.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.learningmanagementsystem.dtos.StudentRequest;
import com.lms.learningmanagementsystem.dtos.StudentResponse;
import com.lms.learningmanagementsystem.dtos.SectionResponse;
import com.lms.learningmanagementsystem.entities.Student;
import com.lms.learningmanagementsystem.entities.Section;
import com.lms.learningmanagementsystem.exception.ResourceNotFoundException;
import com.lms.learningmanagementsystem.repositories.StudentRepository;
import com.lms.learningmanagementsystem.repositories.SectionRepository;
import com.lms.learningmanagementsystem.services.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public StudentResponse createStudent(StudentRequest request) {
        Student student = mapToEntity(request);
        Student saved = studentRepository.save(student);
        return mapToResponse(saved);
    }
    
    @Override
    public List<SectionResponse> getSectionsByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));
         System.out.println("from getsectionbystud id " + studentId);
        if (student.getSections() == null || student.getSections().isEmpty()) {
            return new ArrayList<>();
        }

        return student.getSections().stream().map(section -> {
            SectionResponse response = new SectionResponse();
            response.setId(section.getId());
            response.setSectionName(section.getSectionName());
            response.setCapacity(section.getCapacity());
            response.setEnrolledCount(section.getStudents() != null ? section.getStudents().size() : 0);

            if (section.getCourse() != null) {
                response.setCourseId(section.getCourse().getId());
                response.setCourseName(section.getCourse().getName());
            }

            if (section.getFaculty() != null) {
                response.setFacultyId(section.getFaculty().getFacultyId());
                response.setFacultyName(section.getFaculty().getName());
            }

            return response;
        }).collect(Collectors.toList());
    }
    
    @Override
    public StudentResponse addStudentToSection(Long studentId, Long sectionId) {
        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new ResourceNotFoundException("Section not found with id: " + sectionId));

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));

        // Ensure lists are initialized
        if (student.getSections() == null) {
            student.setSections(new ArrayList<>());
        }
        if (section.getStudents() == null) {
            section.setStudents(new ArrayList<>());
        }

        // Add section to student only if not already enrolled
        if (!student.getSections().contains(section)) {
            student.getSections().add(section);
        }

        // Add student to section only if not already present
        if (!section.getStudents().contains(student)) {
            section.getStudents().add(student);
        }

        // Save both sides (owning + inverse)
        sectionRepository.save(section);
        Student savedStudent = studentRepository.save(student);

        return mapToResponse(savedStudent);
    }


    @Override
    public StudentResponse getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        return mapToResponse(student);
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest request) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setRollNumber(request.getRollNumber());

//        if (request.getSections() != null) {
//            List<Section> sections = request.getSections().stream()
//                    .map(sectionId -> sectionRepository.findById(sectionId)
//                            .orElseThrow(() -> new ResourceNotFoundException("Section not found with id: " + sectionId)))
//                    .collect(Collectors.toList());
//            student.setSections(sections);
//        }

        Student updated = studentRepository.save(student);
        return mapToResponse(updated);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        studentRepository.delete(student);
    }

    private Student mapToEntity(StudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setRollNumber(request.getRollNumber());
        return student;
    }

    private StudentResponse mapToResponse(Student student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setEmail(student.getEmail());
        response.setRollNumber(student.getRollNumber());

        if (student.getSections() != null) {
            List<SectionResponse> sectionResponses = student.getSections().stream().map(section -> {
                SectionResponse sr = new SectionResponse();
                sr.setId(section.getId());
                sr.setSectionName(section.getSectionName());
                sr.setCapacity(section.getCapacity());
                if (section.getFaculty() != null) {
                    sr.setFacultyId(section.getFaculty().getFacultyId());
                    sr.setFacultyName(section.getFaculty().getName());
                }
                return sr;
            }).collect(Collectors.toList());

            response.setSections(sectionResponses);
        }

        return response;
    }
}
