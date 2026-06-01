package com.example.SpringBootAPI.models;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

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
    public Usuario(String nombre, String apellidoPat, String apellidoMat, String password, String fotoPerfil, rolUsuario rol, tipoUsuario tipo, boolean estatusUsuario) {
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.password = password;
        this.fotoPerfil = fotoPerfil;
        this.rol = rol;
        this.tipo = tipo;
        this.estatusUsuario = estatusUsuario;
    }

    // COnstructor de modelo vacio
    public Usuario(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public rolUsuario getRol() {
        return rol;
    }

    public void setRol(rolUsuario rol) {
        this.rol = rol;
    }

    public tipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(tipoUsuario tipo) {
        this.tipo = tipo;
    }

    public boolean isEstatusUsuario() {
        return estatusUsuario;
    }

    public void setEstatusUsuario(boolean estatusUsuario) {
        this.estatusUsuario = estatusUsuario;
    }


}
