package com.lms.learningmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.learningmanagementsystem.entities.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
}