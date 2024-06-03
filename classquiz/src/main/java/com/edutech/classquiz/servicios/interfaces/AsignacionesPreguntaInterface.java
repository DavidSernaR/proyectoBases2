package com.edutech.classquiz.servicios.interfaces;

import com.edutech.classquiz.modelo.entidades.AsignacionesPregunta;

public interface AsignacionesPreguntaInterface {
    public AsignacionesPregunta createAsignacion(Long idAsignacionEstudiante, Long idCuestionario);
}
