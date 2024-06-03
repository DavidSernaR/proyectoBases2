package com.edutech.classquiz.servicios.implementacion;

import com.edutech.classquiz.modelo.entidades.Pregunta;
import com.edutech.classquiz.repositorios.PreguntaRepo;
import com.edutech.classquiz.servicios.interfaces.PreguntaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaInterfaceImpl implements PreguntaInterface {

    @Autowired
    private PreguntaRepo preguntaRepo;

    @Override
    public List<Pregunta> getPreguntasByExamenId(Long examenId) {
        return preguntaRepo.findPreguntasByExamenId(examenId);
    }

    @Override
    public Pregunta createPregunta(Pregunta pregunta) {
        return preguntaRepo.save(pregunta);
    }
}
