package com.example.SpringBootAPI.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "proyectoUsuario")
@Getter
@Setter
@NoArgsConstructor
public class proyectoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "proyecto_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(
            name = "usuario_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Usuario usuario;

    @Column(nullable = false)
    private String rolProyecto;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    public proyectoUsuario(Proyecto proyecto, String rolProyecto, Usuario usuario) {
        this.proyecto = proyecto;
        this.rolProyecto = rolProyecto;
        this.usuario = usuario;
    }

}
