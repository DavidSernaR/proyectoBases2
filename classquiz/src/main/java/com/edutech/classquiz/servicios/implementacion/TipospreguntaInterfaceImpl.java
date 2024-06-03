package com.edutech.classquiz.servicios.implementacion;

import com.edutech.classquiz.modelo.entidades.Tipospregunta;
import com.edutech.classquiz.repositorios.TipospreguntaRepo;
import com.edutech.classquiz.servicios.interfaces.TipospreguntaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipospreguntaInterfaceImpl implements TipospreguntaInterface {

    @Autowired
    private TipospreguntaRepo tipospreguntaRepo;

    @Override
    public Tipospregunta getTipospreguntaById(Long tiposPreguntaId) {
        return tipospreguntaRepo.findById(tiposPreguntaId).get();
    }
}
