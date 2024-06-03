package com.edutech.classquiz.modelo.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "RESPUESTAS_ESTUDIANTES")
public class RespuestasEstudiante {
    @Id
    @Column(name = "IDRESPUESTAESTUDIANTE", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDRESPUESTA", nullable = false)
    private Respuesta idrespuesta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDASIGNACIONPREGUNTA", nullable = false)
    private AsignacionesPregunta idasignacionpregunta;

    @Column(name = "RESPUESTA", nullable = false, length = 100)
    private String respuesta;

}