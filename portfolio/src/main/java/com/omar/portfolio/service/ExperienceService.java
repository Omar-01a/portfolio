package com.omar.portfolio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.omar.portfolio.entity.Experience;
import com.omar.portfolio.exception.ResourceNotFoundException;
import com.omar.portfolio.repository.ExperienceRepository;

@Service
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    public Optional<Experience> getExperienceById(Long id) {
        return experienceRepository.findById(id);
    }

    public Experience createExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    public Experience updateExperience(Long id, Experience experience) {

        Experience existingExperience = experienceRepository.findById(id)
               .orElseThrow(() ->
        new ResourceNotFoundException("Experience not found"));

        existingExperience.setCompany(experience.getCompany());
        existingExperience.setPosition(experience.getPosition());
        existingExperience.setLocation(experience.getLocation());
        existingExperience.setDescription(experience.getDescription());
        existingExperience.setStartDate(experience.getStartDate());
        existingExperience.setEndDate(experience.getEndDate());

        return experienceRepository.save(existingExperience);
    }

    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }
}