package com.example.SpringBootAPI.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "tipoUsuario")
@Setter
@Getter
@NoArgsConstructor
public class tipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoUser;

    @Column(nullable = true, length = 250)
    private String caracteristicas;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public tipoUsuario(String tipoUser, String caracteristicas) {
        this.tipoUser = tipoUser;
        this.caracteristicas = caracteristicas;
    }

}
