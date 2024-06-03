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
@Table(name = "BANCOPREGUNTAS")
public class Bancopregunta {
    @Id
    @Column(name = "IDBANCO", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PREGUNTAS_IDPREGUNTA", nullable = false)
    private Pregunta preguntasIdpregunta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "EXAMENES_IDEXAMENEN", nullable = false)
    private Examene examenesIdexamenen;

    @OneToMany(mappedBy = "idbanco")
    private Set<AsignacionesPregunta> asignacionesPreguntas = new LinkedHashSet<>();

}