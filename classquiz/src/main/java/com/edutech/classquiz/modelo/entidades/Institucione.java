package com.edutech.classquiz.modelo.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "INSTITUCIONES")
public class Institucione {
    @Id
    @Column(name = "IDINSTITUCION", nullable = false)
    private Long id;

    @Column(name = "NOMBRENINSTITUCION", nullable = false, length = 40)
    private String nombreninstitucion;

    @Column(name = "DESCRIPCION", length = 40)
    private String descripcion;

    @Column(name = "DIRECCION", length = 40)
    private String direccion;

    @Column(name = "TELEFONO")
    private Long telefono;

    @OneToMany(mappedBy = "idinstitucion")
    private Set<Docente> docentes = new LinkedHashSet<>();

}