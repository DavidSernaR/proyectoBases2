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
@Table(name = "CONTENIDOS")
public class Contenido {
    @Id
    @Column(name = "IDCONTENIDO", nullable = false)
    private Long id;

    @Column(name = "DESCRICONTENIDO", nullable = false, length = 60)
    private String descricontenido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDUNIDAD", nullable = false)
    private Unidadesestudio idunidad;

    @OneToMany(mappedBy = "idcontenido")
    private Set<Tema> temas = new LinkedHashSet<>();

    public Contenido(long l, String contenidoBasesIi, Unidadesestudio unidadesestudio) {
        this.id = l;
        this.descricontenido = contenidoBasesIi;
        this.idunidad = unidadesestudio;
    }

    public Contenido() {

    }
}