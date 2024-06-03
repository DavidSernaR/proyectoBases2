package com.edutech.classquiz.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "MATERIAS")
public class Materia {
    @Id
    @Column(name = "IDMATERIA", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 60)
    private String nombre;

    @Column(name = "DESCRIPCION", nullable = false, length = 60)
    private String descripcion;

    @OneToMany(mappedBy = "idmateria")
    private Set<Curso> cursos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idmateria")
    private Set<Unidadesestudio> unidadesestudios = new LinkedHashSet<>();

    public Materia(long l, String basesDeDatosIi, String s) {
        this.id = l;
        this.nombre = basesDeDatosIi;
        this.descripcion = s;
    }

    public Materia() {

    }
}