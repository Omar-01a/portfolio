package com.omar.portfolio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.omar.portfolio.entity.Technology;
import com.omar.portfolio.repository.TechnologyRepository;

@Service
public class TechnologyService {

    private final TechnologyRepository technologyRepository;

    public TechnologyService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    public List<Technology> getAllTechnologies() {
        return technologyRepository.findAll();
    }

    public Optional<Technology> getTechnologyById(Long id) {
        return technologyRepository.findById(id);
    }

    public Technology createTechnology(Technology technology) {
        return technologyRepository.save(technology);
    }

    public Technology updateTechnology(Long id, Technology technology) {

        Technology existingTechnology = technologyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Technology not found"));

        existingTechnology.setName(technology.getName());
        existingTechnology.setCategory(technology.getCategory());
        existingTechnology.setIconUrl(technology.getIconUrl());

        return technologyRepository.save(existingTechnology);
    }

    public void deleteTechnology(Long id) {
        technologyRepository.deleteById(id);
    }
}