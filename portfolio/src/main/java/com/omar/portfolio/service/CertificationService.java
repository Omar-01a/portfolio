package com.omar.portfolio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.omar.portfolio.entity.Certification;
import com.omar.portfolio.exception.ResourceNotFoundException;
import com.omar.portfolio.repository.CertificationRepository;

@Service
public class CertificationService {

    private final CertificationRepository certificationRepository;

    public CertificationService(CertificationRepository certificationRepository) {
        this.certificationRepository = certificationRepository;
    }

    public List<Certification> getAllCertifications() {
        return certificationRepository.findAll();
    }

    public Optional<Certification> getCertificationById(Long id) {
        return certificationRepository.findById(id);
    }

    public Certification createCertification(Certification certification) {
        return certificationRepository.save(certification);
    }

    public Certification updateCertification(Long id, Certification certification) {

        Certification existingCertification =
                certificationRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Certification not found"));

        existingCertification.setName(certification.getName());
        existingCertification.setIssuer(certification.getIssuer());
        existingCertification.setIssueDate(certification.getIssueDate());
        existingCertification.setCredentialUrl(certification.getCredentialUrl());

        return certificationRepository.save(existingCertification);
    }

    public void deleteCertification(Long id) {
        certificationRepository.deleteById(id);
    }
}