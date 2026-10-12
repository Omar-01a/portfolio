package com.omar.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.portfolio.entity.Education;

public interface EducationRepository extends JpaRepository<Education, Long> {
}