package com.example.SpringBootAPI.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    @Column(nullable = false, length = 30)
    private String apellidoPat;

    @Column(nullable = false, length = 30)
    private String apellidoMat;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = true, length = 255)
    private String fotoPerfil;

    //Creacion de una campo con llave foranea a otra tabla/clase de springboot
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "rolUsuario_id",
            referencedColumnName = "id",
            nullable = false
    )
    private rolUsuario rol;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "tipo_id",
            referencedColumnName = "id",
            nullable = false
    )
    private tipoUsuario tipo;

    private boolean estatusUsuario;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    // Constructor con datos campos llenos de todo el modelo
    public Usuario(String nombre, String apellidoPat, String apellidoMat, String password,
                   String fotoPerfil, rolUsuario rol, tipoUsuario tipo, boolean estatusUsuario) {
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.password = password;
        this.fotoPerfil = fotoPerfil;
        this.rol = rol;
        this.tipo = tipo;
        this.estatusUsuario = estatusUsuario;
    }

}
