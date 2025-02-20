package org.example.employeservice.repository;

import org.example.employeservice.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employe, Long> {
    List<Employe> findByDepartment_Nom(String nom);
}