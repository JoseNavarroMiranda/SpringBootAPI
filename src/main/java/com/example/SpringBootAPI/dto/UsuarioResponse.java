package com.example.SpringBootAPI.dto;

import com.example.SpringBootAPI.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse{

    private  String id;
    private String nombre;
    private String username;
    private String apellidoPat;
    private String apellidoMat;
    private long rolid;
    private long tipoid;
    private boolean estatusUsuario;
    private LocalDateTime created_at;


    public UsuarioResponse( Usuario usuario) {
        this.id = usuario.getId().toString();
        this.nombre = usuario.getNombre();
        this.username = usuario.getUsername();
        this.apellidoPat = usuario.getApellidoPat();
        this.apellidoMat = usuario.getApellidoMat();
        this .rolid = usuario.getRol().getId();
        this.tipoid = usuario.getTipo().getId();
        this.estatusUsuario = usuario.isEstatusUsuario();
        this.created_at = usuario.getCreatedAt();
    }
}
