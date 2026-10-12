package com.omar.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.portfolio.entity.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}