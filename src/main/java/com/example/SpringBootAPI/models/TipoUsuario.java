package com.example.SpringBootAPI.models;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "tipoUsuario")
@Setter
@Getter
@NoArgsConstructor

public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoUser;

    @Column(nullable = true, length = 250)
    private String caracteristicas;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public TipoUsuario(String tipoUser, String caracteristicas) {
        this.tipoUser = tipoUser;
        this.caracteristicas = caracteristicas;
    }
}
