package com.example.SpringBootAPI.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "tarea")
@Getter
@Setter
@NoArgsConstructor
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estado;

    @ManyToOne
    @JoinColumn(
            name = "usuario_id",
            referencedColumnName = "id",
            nullable = true
    )
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(
            name = "proyecto_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Proyecto proyecto;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    public Tarea(String estado, Usuario usuario, Proyecto proyecto) {
        this.estado = estado;
        this.usuario = usuario;
        this.proyecto = proyecto;
    }
}
