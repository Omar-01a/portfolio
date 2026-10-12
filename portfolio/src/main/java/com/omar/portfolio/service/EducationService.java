package com.omar.portfolio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.omar.portfolio.entity.Education;
import com.omar.portfolio.exception.ResourceNotFoundException;
import com.omar.portfolio.repository.EducationRepository;

@Service
public class EducationService {

    private final EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public List<Education> getAllEducation() {
        return educationRepository.findAll();
    }

    public Optional<Education> getEducationById(Long id) {
        return educationRepository.findById(id);
    }

    public Education createEducation(Education education) {
        return educationRepository.save(education);
    }

    public Education updateEducation(Long id, Education education) {

        Education existingEducation = educationRepository.findById(id)
               .orElseThrow(() ->
        new ResourceNotFoundException("Education not found"));

        existingEducation.setInstitution(education.getInstitution());
        existingEducation.setDegree(education.getDegree());
        existingEducation.setField(education.getField());
        existingEducation.setLocation(education.getLocation());
        existingEducation.setStartDate(education.getStartDate());
        existingEducation.setEndDate(education.getEndDate());
        existingEducation.setDescription(education.getDescription());

        return educationRepository.save(existingEducation);
    }

    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }
}