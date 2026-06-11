package com.example.SpringBootAPI.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "archivo")
@Getter
@Setter //Se agregan decoradore de loombok que remplazan el codigo extenso de setter y getter
@NoArgsConstructor

public class Archivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "tarea_id",
            referencedColumnName = "id",
            nullable = true
    )
    private Tarea tarea;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    public Archivo(String url, Tarea tarea) {
        this.url = url;
        this.tarea = tarea;
    }
}
