package com.omar.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.portfolio.entity.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}