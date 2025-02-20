package com.example.courrierservice.repository;

import com.example.courrierservice.entity.Courrier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourrierRepository extends JpaRepository<Courrier, Long> {
}