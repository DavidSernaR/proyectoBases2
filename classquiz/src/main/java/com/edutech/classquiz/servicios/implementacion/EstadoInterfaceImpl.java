package com.edutech.classquiz.servicios.implementacion;

import com.edutech.classquiz.modelo.entidades.Estado;
import com.edutech.classquiz.repositorios.EstadoRepo;
import com.edutech.classquiz.servicios.interfaces.EstadoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoInterfaceImpl implements EstadoInterface {

    @Autowired
    private EstadoRepo estadoRepo;

    @Override
    public Estado getEstadoById(Long estadoId) {
        return estadoRepo.findById(estadoId).get();
    }
}
