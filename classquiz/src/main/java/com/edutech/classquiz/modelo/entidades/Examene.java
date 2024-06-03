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
@Table(name = "EXAMENES")
public class Examene {
    @Id
    @Column(name = "IDEXAMENEN", nullable = false)
    private Long id;

    @Column(name = "TITULO", nullable = false, length = 80)
    private String titulo;

    @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

    @Column(name = "DURACIONEXAMEN", nullable = false)
    private Long duracionexamen;

    @Column(name = "CANTIDADPREGUNTAS", nullable = false)
    private Long cantidadpreguntas;

    @Column(name = "CALIFICACION", nullable = false)
    private Double calificacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDCURSO", nullable = false)
    private Curso idcurso;

    @Column(name = "CANTIDADPREGUNTASXESTUDIANTE", nullable = false)
    private Long cantidadpreguntasxestudiante;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDTEMA", nullable = false)
    private Tema idtema;

    @Column(name = "HORAINICIO", nullable = false)
    private LocalDate horainicio;

    @Column(name = "HORAFIN", nullable = false)
    private LocalDate horafin;

    @Column(name = "NOTAPARAAPROBAR", nullable = false)
    private Long notaparaaprobar;

    @Column(name = "ESTADO", nullable = false, length = 10)
    private String estado;

    @OneToMany(mappedBy = "idexamenes")
    private Set<AsignacionesEstudiante> asignacionesEstudiantes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "examenesIdexamenen")
    private Set<Bancopregunta> bancopreguntas = new LinkedHashSet<>();

}