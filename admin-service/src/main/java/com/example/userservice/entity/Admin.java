package com.example.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


    @Entity
    @Table(name = "admin")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Admin {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nom;
        private String prenom;
        private String email;

}

