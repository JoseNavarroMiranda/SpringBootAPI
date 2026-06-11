package com.example.SpringBootAPI.dto;


import com.example.SpringBootAPI.validations.ValidPassword;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class UsuarioRequest {
    @NotBlank(message = "EL nombre no puede estar vacio")
    private String nombre;

    private String username;

    @NotBlank(message = "El apellido paterno no puede estar vacio")
    private String apellidoPat;

    @NotBlank(message = "El apellido materno no puede estar vacio")
    private String apellidoMat;

    @NotBlank(message = "La contraseña no puede estar vacia")
    @ValidPassword
    private String password;

    @NotNull(message = "El tipo de rol debe de ser asignado al crear el usuario ")
    private long rolid;

    @NotNull(message = "El tipo debe de ser asignado al crear el usuario ")
    private long tipoid;
    @Nullable
    private String FotoPerfil;
    private boolean estatusUsuario;
}
