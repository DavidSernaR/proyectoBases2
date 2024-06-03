package com.edutech.classquiz.servicios.interfaces;

import com.edutech.classquiz.modelo.entidades.Estudiante;

import java.util.List;

public interface EstudianteInterface {
    public List<Long> getListEstudianteId();
    public List<Estudiante> getAllEstudiantes();
}
