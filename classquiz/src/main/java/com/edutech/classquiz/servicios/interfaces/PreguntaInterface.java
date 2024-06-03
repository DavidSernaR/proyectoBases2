package com.edutech.classquiz.servicios.interfaces;

import com.edutech.classquiz.modelo.entidades.Pregunta;
import com.edutech.classquiz.modelo.entidades.Respuesta;

import java.util.List;

public interface PreguntaInterface {
    public List<Pregunta> getPreguntasByExamenId(Long examenId);
    public Pregunta createPregunta(Pregunta pregunta);
}
