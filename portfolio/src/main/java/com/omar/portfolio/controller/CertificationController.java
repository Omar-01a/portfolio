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

import com.omar.portfolio.entity.Certification;
import com.omar.portfolio.service.CertificationService;

@RestController
@RequestMapping("/api/certifications")
@CrossOrigin(origins = "http://localhost:5173")
public class CertificationController {

    private final CertificationService certificationService;

    public CertificationController(CertificationService certificationService) {
        this.certificationService = certificationService;
    }

    @GetMapping
    public List<Certification> getAllCertifications() {
        return certificationService.getAllCertifications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Certification> getCertificationById(
            @PathVariable Long id) {

        return certificationService.getCertificationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Certification createCertification(
            @RequestBody Certification certification) {

        return certificationService.createCertification(certification);
    }

    @PutMapping("/{id}")
    public Certification updateCertification(
            @PathVariable Long id,
            @RequestBody Certification certification) {

        return certificationService.updateCertification(id, certification);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertification(
            @PathVariable Long id) {

        certificationService.deleteCertification(id);

        return ResponseEntity.noContent().build();
    }
}