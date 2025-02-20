package com.example.courrierservice.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "courier_paths")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourierPath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "courier_id", nullable = false)
    private Courier courier;

    private String emplacement;
    private LocalDateTime dateHeure;
    private String commentaire;
}
