package com.example.courrierservice.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Admine {
    private Long idAdmine;

    private String nom;
    private String prenom;
    private String email;

}
