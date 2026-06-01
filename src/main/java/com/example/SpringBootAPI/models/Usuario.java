package com.example.SpringBootAPI.models;
import jakarta.persistence.*;

//condecorador que avisa a springboot que la clase sera una tabla en la db
@Entity
@Table(name = "usuario") //esto es opciones para poder dejar el nombre de la tabla
public class Usuario {

    @Id //se define el campo que sera ID
    // Condecorador que forza al atributo de la tabla a ser AUTOINCREMENT
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false, length = 30)
    private String apellidoPat;

    @Column(nullable = false, length = 30)
    private String apellidoMat;

    @Column(nullable = false, length = 18)
    private String password;

    @Column(nullable = true, length = 255)
    private String fotoPerfil;

    //Creacion de una campo con llave foranea a otra tabla/clase de springboot
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "rol_id",
            referencedColumnName = "id",
            nullable = false,
    )
    private rolUsuario rol;

}
