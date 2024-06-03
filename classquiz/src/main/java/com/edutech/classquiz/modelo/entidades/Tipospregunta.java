package com.edutech.classquiz.modelo.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "TIPOSPREGUNTAS")
public class Tipospregunta {
    @Id
    @Column(name = "IDTIPOPREGUNTA", nullable = false)
    private Long id;

    @Column(name = "DESCRIPCION", nullable = false, length = 40)
    private String descripcion;

    @OneToMany(mappedBy = "idtipopregunta")
    private Set<Pregunta> preguntas = new LinkedHashSet<>();

}