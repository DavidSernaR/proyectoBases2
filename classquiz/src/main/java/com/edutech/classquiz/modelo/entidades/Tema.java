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
@Table(name = "TEMAS")
public class Tema {
    @Id
    @Column(name = "IDTEMA", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 60)
    private String nombre;

    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDCONTENIDO", nullable = false)
    private Contenido idcontenido;

    @OneToMany(mappedBy = "idtema")
    private Set<Examene> examenes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idtema")
    private Set<Pregunta> preguntas = new LinkedHashSet<>();

    public Tema(long l, String proyectoFinal, String proyectoFinal1, Contenido contenido) {
        this.id = l;
        this.nombre = proyectoFinal;
        this.descripcion = proyectoFinal1;
        this.idcontenido = contenido;
    }

    public Tema() {

    }
}