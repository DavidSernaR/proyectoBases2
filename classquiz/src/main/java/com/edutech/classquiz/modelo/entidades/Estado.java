package com.edutech.classquiz.modelo.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ESTADOS")
public class Estado {
    @Id
    @Column(name = "IDESTADO", nullable = false)
    private Long id;

    @Column(name = "DESCRIPCION", length = 40)
    private String descripcion;

    @OneToMany(mappedBy = "idestado")
    private Set<Pregunta> preguntas = new LinkedHashSet<>();

}