package com.edutech.classquiz.modelo.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ESTUDIANTES")
public class Estudiante {
    @Id
    @Column(name = "IDESTUDIANTE", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 40)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false, length = 40)
    private String apellido;

    @Column(name = "USUARIO", nullable = false, length = 40)
    private String usuario;

    @Column(name = "EMAIL", nullable = false, length = 40)
    private String email;

    @Column(name = "PASSWORD", nullable = false, length = 40)
    private String password;

    @Column(name = "TELEFONO")
    private Long telefono;

    @OneToMany(mappedBy = "idestudiante")
    private Set<AsignacionesEstudiante> asignacionesEstudiantes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idestudiante")
    private Set<EstudianteCurso> estudianteCursos = new LinkedHashSet<>();

}