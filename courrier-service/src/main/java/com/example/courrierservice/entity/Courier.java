package com.example.courrierservice.entity;



import com.example.courrierservice.model.Admine;
import com.example.courrierservice.model.Employee;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Entity
@Table(name = "couriers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long idEmployee;
    private Long idAdmine;
    @Transient
    private Employee employee;
    @Transient
    private Admine admine;
    private LocalDateTime dateEnvoi;
    private String description;

    @Enumerated(EnumType.STRING)
    private StatutCourier statut;

}

