package com.nando.demo_park_api.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name ="usuarios")

public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username", nullable = false, unique = true, length = 100)
    private String username;

    @Column(name = "password", nullable = false,length = 200)
    private String password;

    @Column(name = "placa", unique = true, length = 10)
    private String placa;

    @Enumerated(EnumType.STRING)
    @Column(name = "role",nullable =false, length = 25)
    private  Role role = Role.ROLE_CLIENT;

    @Column(name = "Data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "Data_modificacao")
    private LocalDateTime dataModificacao;

    @Column(name = "Criado_Por")
    private String criadoPor;

    @Column(name = "modificado_por")
    private String modificadoPor;

    public enum Role {
        ROLE_ADMIN,ROLE_CLIENT
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                '}';
    }
}
