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
@Table(name = "CURSOS")
public class Curso {
    @Id
    @Column(name = "IDCURSO", nullable = false)
    private Long id;

    @Column(name = "NOMBRECURSO", length = 60)
    private String nombrecurso;

    @Column(name = "DESCRIPCION", length = 60)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDDOCENTE", nullable = false)
    private Docente iddocente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDMATERIA", nullable = false)
    private Materia idmateria;

    @OneToMany(mappedBy = "idcurso")
    private Set<EstudianteCurso> estudianteCursos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idcurso")
    private Set<Examene> examenes = new LinkedHashSet<>();

    public Curso(long l, String s, String s1, Docente docente, Materia materia) {
        this.id = l;
        this.nombrecurso = s;
        this.descripcion = s1;
        this.iddocente = docente;
        this.idmateria = materia;
    }

    public Curso() {

    }
}