package com.example.SpringBootAPI.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "rolUsuario")
@Getter
@Setter
@NoArgsConstructor
public class rolUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String rol;

    @Column(nullable = true, length = 250)
    private String caracteristicas;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public rolUsuario(String rol, String caracteristicas) {
        this.rol = rol;
        this.caracteristicas = caracteristicas;
    }

}
