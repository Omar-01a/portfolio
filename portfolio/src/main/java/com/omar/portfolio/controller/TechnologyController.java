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

import com.omar.portfolio.entity.Technology;
import com.omar.portfolio.service.TechnologyService;

@RestController
@RequestMapping("/api/technologies")
@CrossOrigin(origins = "http://localhost:5173")
public class TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping
    public List<Technology> getAllTechnologies() {
        return technologyService.getAllTechnologies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technology> getTechnologyById(@PathVariable Long id) {

        return technologyService.getTechnologyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Technology createTechnology(@RequestBody Technology technology) {
        return technologyService.createTechnology(technology);
    }

    @PutMapping("/{id}")
    public Technology updateTechnology(
            @PathVariable Long id,
            @RequestBody Technology technology) {

        return technologyService.updateTechnology(id, technology);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnology(@PathVariable Long id) {

        technologyService.deleteTechnology(id);

        return ResponseEntity.noContent().build();
    }
}