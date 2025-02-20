package com.example.courrierservice.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    private Long idEmployee;

    private String nom;
    private String prenom;
    private String email;
    private String poste;

}
