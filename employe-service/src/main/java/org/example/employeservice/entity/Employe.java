package org.example.employeservice.entity;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String poste;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departement department;
}

