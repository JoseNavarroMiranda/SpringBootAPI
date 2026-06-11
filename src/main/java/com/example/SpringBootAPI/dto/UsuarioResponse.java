package com.example.SpringBootAPI.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class UsuarioResponse {

    private String nombre;
    private String username;
    private String apellidoPat;
    private String apellidoMat;
    private long rolid;
    private long tipoid;
    private boolean estatusUsuario;
    private LocalDateTime created_at;
}
