package com.example.SpringBootAPI.services;

import com.example.SpringBootAPI.dto.PasswordUpdateRequest;
import com.example.SpringBootAPI.dto.UsuarioRequest;
import com.example.SpringBootAPI.models.RolUsuario;
import com.example.SpringBootAPI.models.TipoUsuario;
import com.example.SpringBootAPI.models.Usuario;
import com.example.SpringBootAPI.repositories.RolUsuarioRepository;
import com.example.SpringBootAPI.repositories.TipoUsuarioRepository;
import com.example.SpringBootAPI.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
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

        //Refactorizacion de funciones, se colocan como private, execpto con la ultima funcion debido a que se utiliza para regresar un msj
        // si el usuario esta en uso, de lo contrario permite realizar la creacion de usuario
        RolUsuario rol = findRolByRol(usuarioRequest.getRolid());

        TipoUsuario tipo = findTipoById(usuarioRequest.getTipoid());

        UsuarioIsNotTaken(usuarioRequest.getUsername());

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

    public Usuario UpdatePsswordUsuario(Long id , PasswordUpdateRequest request){

        Usuario usuario = ObtenerUsuario(id);
        //Validacion de password actual
        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())){
            throw new RuntimeException("La contraseña no es valida");
        }

        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        return usuarioRepository.save(usuario);
    }


    private @NonNull RolUsuario findRolByRol(Long rolid){
        return rolRepo.findById(rolid)
                .orElseThrow(() -> new RuntimeException("Tipo de usuario no se encontro"));
    }

    private @NonNull TipoUsuario findTipoById(Long tipoid){
        return tipoRepo.findById(tipoid)
                .orElseThrow(() -> new RuntimeException("Tipo de usuario no se encontro"));
    }

    private void UsuarioIsNotTaken(String username){
        if (usuarioRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Usuario existente, no se puede dulplicar un usuario");
        }
    }



}
