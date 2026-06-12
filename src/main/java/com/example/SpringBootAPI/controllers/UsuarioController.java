package com.example.SpringBootAPI.controllers;

import com.example.SpringBootAPI.dto.UsuarioRequest;
import com.example.SpringBootAPI.models.Usuario;
import com.example.SpringBootAPI.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public ResponseEntity<?> ListarUsuario(){
        try {
            List<Usuario> usuario = usuarioService.ObtenerTodos();
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity <?> ListarSoloUsuario(@PathVariable Long id){
        try{
            Usuario usuario = usuarioService.ObtenerUsuario(id);
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}