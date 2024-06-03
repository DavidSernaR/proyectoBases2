package com.edutech.classquiz.servicios.interfaces;

import com.edutech.classquiz.modelo.entidades.Docente;
import com.edutech.classquiz.modelo.entidades.Estudiante;
import com.edutech.classquiz.modelo.entidades.Examene;
import com.edutech.classquiz.modelo.entidades.Pregunta;

import java.util.List;

public interface ExameneInterface {
    public List<Examene> getAllExamenes();
    public Examene createExamen(Examene examen, List<Pregunta> preguntas);
    public Examene getExamenById(Long examenId);
    public List<Long> getListExamenId();
}
