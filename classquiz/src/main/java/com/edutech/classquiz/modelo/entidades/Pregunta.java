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
@Table(name = "PREGUNTAS")
public class Pregunta {
    @Id
    @Column(name = "IDPREGUNTA", nullable = false)
    private Long id;

    @Column(name = "ENUNCIADO", nullable = false, length = 100)
    private String enunciado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDTEMA", nullable = false)
    private Tema idtema;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDESTADO", nullable = false)
    private Estado idestado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDTIPOPREGUNTA", nullable = false)
    private Tipospregunta idtipopregunta;

    @Column(name = "PESO", nullable = false)
    private Double peso;

    @OneToMany(mappedBy = "preguntasIdpregunta")
    private Set<Bancopregunta> bancopreguntas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idpreguntas")
    private Set<Respuesta> respuestas = new LinkedHashSet<>();

}