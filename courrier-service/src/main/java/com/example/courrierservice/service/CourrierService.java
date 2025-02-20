package com.example.courrierservice.service;


import com.example.courrierservice.entity.Courrier;
import com.example.courrierservice.repository.CourrierRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourrierService {

    private final CourrierRepository courrierRepository;

    public CourrierService(CourrierRepository courrierRepository) {
        this.courrierRepository = courrierRepository;
    }

    public List<Courrier> getAllCourriers() {
        return courrierRepository.findAll();
    }

    public ResponseEntity<Courrier> getCourrierById(Long id) {
        Optional<Courrier> courrier = courrierRepository.findById(id);
        return courrier.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Courrier> createCourrier(Courrier courrier) {
        return ResponseEntity.ok(courrierRepository.save(courrier));
    }

    public ResponseEntity<Void> deleteCourrier(Long id) {
        if (courrierRepository.existsById(id)) {
            courrierRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

