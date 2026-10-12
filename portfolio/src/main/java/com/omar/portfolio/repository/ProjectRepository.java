package com.omar.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.portfolio.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}