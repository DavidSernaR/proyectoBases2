package com.edutech.classquiz.modelo.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ASIGNACIONES_ESTUDIANTES")
public class AsignacionesEstudiante {
    @Id
    @Column(name = "IDASIGNACION", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDESTUDIANTE", nullable = false)
    private Estudiante idestudiante;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDEXAMENES", nullable = false)
    private Examene idexamenes;

    @Column(name = "NOTA", nullable = false)
    private Double nota;

    @Column(name = "HORA_INICIO", nullable = false)
    private LocalDate horaInicio;

    @Column(name = "HORA_FINAL", nullable = false)
    private LocalDate horaFinal;

    @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

    @OneToMany(mappedBy = "idasignacionestudiante")
    private Set<AsignacionesPregunta> asignacionesPreguntas = new LinkedHashSet<>();

}