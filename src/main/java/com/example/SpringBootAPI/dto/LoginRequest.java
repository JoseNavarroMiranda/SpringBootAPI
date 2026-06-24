package com.example.SpringBootAPI.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {

    @NotBlank(message = "El username no puede ser vacio")
    private String username;

    @NotBlank(message = "La password no puede ser vacia")
    private String password;


}
