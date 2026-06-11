package com.example.SpringBootAPI.models;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

//condecorador que avisa a springboot que la clase sera una tabla en la db
@Entity
@Table(name = "usuario") //esto es opciones para poder dejar el nombre de la tabla
@Getter
@Setter
@NoArgsConstructor

public class Usuario {

    @Id //se define el campo que sera ID
    // Condecorador que forza al atributo de la tabla a ser AUTOINCREMENT
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false, length = 60)
    private String username;

    @Column(nullable = false, length = 30)
    private String apellidoPat;

    @Column(nullable = false, length = 30)
    private String apellidoMat;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = true, length = 255)
    private String fotoPerfil;

    //Creacion de una campo con llave foranea a otra tabla/clase de springboot
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "rolUsuario_id",
            referencedColumnName = "id",
            nullable = false
    )
    private RolUsuario rol;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "tipo_id",
            referencedColumnName = "id",
            nullable = false
    )
    private TipoUsuario tipo;

    private boolean estatusUsuario;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    public Usuario(String nombre, String username, String apellidoPat, String apellidoMat, String fotoPerfil, String password,
                   RolUsuario rol, TipoUsuario tipo, boolean estatusUsuario) {
        this.nombre = nombre;
        this.username = username;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.fotoPerfil = fotoPerfil;
        this.password = password;
        this.rol = rol;
        this.tipo = tipo;
        this.estatusUsuario = estatusUsuario;
    }
}
