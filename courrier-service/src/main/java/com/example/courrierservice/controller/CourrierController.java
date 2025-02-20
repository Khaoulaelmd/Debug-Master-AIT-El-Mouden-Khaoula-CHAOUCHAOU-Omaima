package com.example.courrierservice.controller;


import com.example.courrierservice.entity.Courrier;
import com.example.courrierservice.service.CourrierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courriers")
public class CourrierController {

    private final CourrierService courrierService;

    public CourrierController(CourrierService courrierService) {
        this.courrierService = courrierService;
    }

    @GetMapping
    public List<Courrier> getAllCourriers() {
        return courrierService.getAllCourriers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Courrier> getCourrierById(@PathVariable Long id) {
        return courrierService.getCourrierById(id);
    }

    @PostMapping
    public ResponseEntity<Courrier> createCourrier(@RequestBody Courrier courrier) {
        return courrierService.createCourrier(courrier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourrier(@PathVariable Long id) {
        return courrierService.deleteCourrier(id);
    }
}