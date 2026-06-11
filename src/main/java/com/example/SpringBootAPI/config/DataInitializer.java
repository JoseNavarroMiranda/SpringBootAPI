package com.example.SpringBootAPI.config;

import com.example.SpringBootAPI.models.RolUsuario;
import com.example.SpringBootAPI.models.TipoUsuario;
import com.example.SpringBootAPI.repositories.RolUsuarioRepository;
import com.example.SpringBootAPI.repositories.TipoUsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RolUsuarioRepository rolRepo;
    private final TipoUsuarioRepository tipoRepo;

    public DataInitializer(RolUsuarioRepository rolRepo, TipoUsuarioRepository tipoRepo) {
        this.rolRepo = rolRepo;
        this.tipoRepo = tipoRepo;
    }

    @Override
    public void run(String... args) {
        if (rolRepo.count() == 0) {
            rolRepo.save(new RolUsuario("Acceso completo al sistema", "ADMIN"));
            rolRepo.save(new RolUsuario("Acceso limitado a gestión de proyectos", "PROJECT_MANAGER"));
            rolRepo.save(new RolUsuario("Puede ver y editar tareas asignadas", "DESARROLLADOR"));
            rolRepo.save(new RolUsuario("Solo lectura", "VISUALIZADOR"));
        }

        if (tipoRepo.count() == 0) {
            tipoRepo.save(new TipoUsuario("INTERNO", "Empleado de la empresa"));
            tipoRepo.save(new TipoUsuario("EXTERNO", "Usuario externo o cliente"));
            tipoRepo.save(new TipoUsuario("ADMIN", "Administrador del sistema"));
        }
    }
}
