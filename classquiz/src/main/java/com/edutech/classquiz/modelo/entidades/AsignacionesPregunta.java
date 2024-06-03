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
@Table(name = "ASIGNACIONES_PREGUNTAS")
public class AsignacionesPregunta {
    @Id
    @Column(name = "IDASIGNACIONPREGUNTA", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDASIGNACIONESTUDIANTE", nullable = false)
    private AsignacionesEstudiante idasignacionestudiante;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDBANCO", nullable = false)
    private Bancopregunta idbanco;

    @OneToMany(mappedBy = "idasignacionpregunta")
    private Set<RespuestasEstudiante> respuestasEstudiantes = new LinkedHashSet<>();

}