package com.edutech.classquiz.servicios.implementacion;

import com.edutech.classquiz.modelo.entidades.Respuesta;
import com.edutech.classquiz.repositorios.RespuestaRepo;
import com.edutech.classquiz.servicios.interfaces.RespuestaInterface;

public class RespuestaInterfaceImpl implements RespuestaInterface {

    public RespuestaRepo respuestaRepo;

    @Override
    public Respuesta createRespuesta(Respuesta respuesta) {
        return respuestaRepo.save(respuesta);
    }
}
