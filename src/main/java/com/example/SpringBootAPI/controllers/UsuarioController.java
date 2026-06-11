package com.example.SpringBootAPI.controllers;

import com.example.SpringBootAPI.dto.UsuarioRequest;
import com.example.SpringBootAPI.models.Usuario;
import com.example.SpringBootAPI.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
@AllArgsConstructor
public class UsuarioController {
    //Inyeccion de servicio de usuario
    private final UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest) {
        try {
            Usuario usuario = usuarioService.CreateUser(usuarioRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
