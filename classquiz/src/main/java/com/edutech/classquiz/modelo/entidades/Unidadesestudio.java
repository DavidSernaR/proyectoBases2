package com.edutech.classquiz.modelo.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "UNIDADESESTUDIO")
public class Unidadesestudio {
    @Id
    @Column(name = "IDUNIDAD", nullable = false)
    private Long id;

    @Column(name = "NOMBRE_UNIDAD", nullable = false, length = 40)
    private String nombreUnidad;

    @Column(name = "DESCRIPCION", nullable = false, length = 40)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDMATERIA", nullable = false)
    private Materia idmateria;

    @OneToMany(mappedBy = "idunidad")
    private Set<Contenido> contenidos = new LinkedHashSet<>();

    public Unidadesestudio(long l, String s, String s1, Materia materia) {
        this.id = l;
        this.nombreUnidad = s;
        this.descripcion = s1;
        this.idmateria = materia;
    }

    public Unidadesestudio() {

    }
}