package com.example.SpringBootAPI.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "proyecto")
@Getter
@Setter
@NoArgsConstructor
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String descripcion;

    @OneToOne
    @JoinColumn(
            name = "categoria_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Categoria categoria;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    public Proyecto(String name, String descripcion, Categoria categoria) {
        this.name = name;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

}
