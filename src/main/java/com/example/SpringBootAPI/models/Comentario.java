package com.example.SpringBootAPI.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "comentario")
@Getter
@Setter
@NoArgsConstructor
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length = 250)
    private String comentario;

    @ManyToOne
    @JoinColumn(
            name = "tarea_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Tarea tarea;

    @ManyToOne
    @JoinColumn(
            name = "usuario_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Usuario usuario;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    public Comentario(String comentario, Tarea tarea, Usuario usuario) {
        this.comentario = comentario;
        this.tarea = tarea;
        this.usuario = usuario;
    }

}
