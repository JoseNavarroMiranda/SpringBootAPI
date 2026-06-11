package com.example.SpringBootAPI.models;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "proyectoUsuario")
@Getter
@Setter
@NoArgsConstructor

public class ProyectoUsuario {
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

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    public ProyectoUsuario(Proyecto proyecto, Usuario usuario, String rolProyecto) {
        this.proyecto = proyecto;
        this.usuario = usuario;
        this.rolProyecto = rolProyecto;
    }
}
