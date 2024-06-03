package com.edutech.classquiz.servicios.interfaces;

import com.edutech.classquiz.modelo.entidades.AsignacionesEstudiante;

public interface AsignacionesEstudianteInterface {
    public AsignacionesEstudiante createAsignacion(Long idEstudiante, Long idExamen);
}
