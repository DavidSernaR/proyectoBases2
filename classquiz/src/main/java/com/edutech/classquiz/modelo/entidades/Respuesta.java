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
@Table(name = "RESPUESTAS")
public class Respuesta {
    @Id
    @Column(name = "IDRESPUESTA", nullable = false)
    private Long id;

    @Column(name = "OPCIONRESPUESTA", nullable = false, length = 70)
    private String opcionrespuesta;

    @Column(name = "CORRECTA", nullable = false, length = 40)
    private String correcta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDPREGUNTAS", nullable = false)
    private Pregunta idpreguntas;

    @OneToMany(mappedBy = "idrespuesta")
    private Set<RespuestasEstudiante> respuestasEstudiantes = new LinkedHashSet<>();

}