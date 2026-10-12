package com.omar.portfolio.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omar.portfolio.entity.Experience;
import com.omar.portfolio.service.ExperienceService;

@RestController
@RequestMapping("/api/experiences")
@CrossOrigin(origins = "http://localhost:5173")
public class ExperienceController {

    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping
    public List<Experience> getAllExperiences() {
        return experienceService.getAllExperiences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable Long id) {

        return experienceService.getExperienceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Experience createExperience(@RequestBody Experience experience) {
        return experienceService.createExperience(experience);
    }

    @PutMapping("/{id}")
    public Experience updateExperience(
            @PathVariable Long id,
            @RequestBody Experience experience) {

        return experienceService.updateExperience(id, experience);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long id) {

        experienceService.deleteExperience(id);

        return ResponseEntity.noContent().build();
    }
}