package com.edutech.classquiz.servicios.interfaces;

import com.edutech.classquiz.modelo.entidades.Docente;

public interface DocenteInterface {
    public Docente authenticateDocente(String email, String password);
}
