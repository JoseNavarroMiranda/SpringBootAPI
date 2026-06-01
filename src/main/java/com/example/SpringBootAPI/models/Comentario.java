package com.example.SpringBootAPI.models;

import jakarta.persistence.*;

@Entity
@Table(name = "comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length = 250)
    private String comentario;

    @
}
