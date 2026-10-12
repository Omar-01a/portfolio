package com.omar.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.portfolio.entity.ContactMessage;

public interface ContactMessageRepository
        extends JpaRepository<ContactMessage, Long> {
}