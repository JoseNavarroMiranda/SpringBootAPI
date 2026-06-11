package com.example.SpringBootAPI.repositories;

import com.example.SpringBootAPI.models.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> { }
