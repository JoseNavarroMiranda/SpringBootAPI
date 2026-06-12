package com.example.SpringBootAPI.services;

import com.example.SpringBootAPI.dto.UsuarioRequest;
import com.example.SpringBootAPI.models.RolUsuario;
import com.example.SpringBootAPI.models.TipoUsuario;
import com.example.SpringBootAPI.models.Usuario;
import com.example.SpringBootAPI.repositories.RolUsuarioRepository;
import com.example.SpringBootAPI.repositories.TipoUsuarioRepository;
import com.example.SpringBootAPI.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final TipoUsuarioRepository tipoRepo;
    private final RolUsuarioRepository rolRepo;
    private final PasswordEncoder passwordEncoder;

    //Funciones de modelo de ususario (CRUD)
    public Usuario CreateUser(UsuarioRequest usuarioRequest) {
        RolUsuario rol = rolRepo.findById(usuarioRequest.getRolid())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        TipoUsuario tipo = tipoRepo.findById(usuarioRequest.getTipoid())
                .orElseThrow(() -> new RuntimeException("Tipo no encontrado"));

        if (usuarioRepository.findByUsername(usuarioRequest.getUsername()).isPresent()) {
            throw new RuntimeException("Usuario existente");
        }
        Usuario usuario = new Usuario(
                usuarioRequest.getNombre(),
                usuarioRequest.getUsername(),
                usuarioRequest.getApellidoPat(),
                usuarioRequest.getApellidoMat(),
                usuarioRequest.getFotoPerfil(),
                passwordEncoder.encode(usuarioRequest.getPassword()),
                rol,
                tipo,
                usuarioRequest.isEstatusUsuario()
        );
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> ObtenerTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario ObtenerUsuario(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontraron resultados en la busqueda"));
    }

}
