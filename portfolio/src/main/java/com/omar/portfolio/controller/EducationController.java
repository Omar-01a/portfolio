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

import com.omar.portfolio.entity.Education;
import com.omar.portfolio.service.EducationService;

@RestController
@RequestMapping("/api/education")
@CrossOrigin(origins = "http://localhost:5173")
public class EducationController {

    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping
    public List<Education> getAllEducation() {
        return educationService.getAllEducation();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable Long id) {

        return educationService.getEducationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Education createEducation(@RequestBody Education education) {
        return educationService.createEducation(education);
    }

    @PutMapping("/{id}")
    public Education updateEducation(
            @PathVariable Long id,
            @RequestBody Education education) {

        return educationService.updateEducation(id, education);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long id) {

        educationService.deleteEducation(id);

        return ResponseEntity.noContent().build();
    }
}