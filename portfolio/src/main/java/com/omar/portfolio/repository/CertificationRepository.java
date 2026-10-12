package com.omar.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.portfolio.entity.Certification;

public interface CertificationRepository extends JpaRepository<Certification, Long> {

}