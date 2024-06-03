package com.edutech.classquiz.servicios.implementacion;

import com.edutech.classquiz.modelo.entidades.*;
import com.edutech.classquiz.repositorios.*;
import com.edutech.classquiz.servicios.interfaces.ExameneInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExameneInterfaceImpl implements ExameneInterface {

    @Autowired
    private ExameneRepo exameneRepo;

    @Autowired
    private PreguntaRepo preguntaRepo;

    @Autowired
    private BancopreguntaRepo bancopreguntaRepo;

    @Autowired
    private EstudianteRepo estudianteRepo;

    @Override
    public List<Examene> getAllExamenes() {
        return exameneRepo.findAll();
    }

    @Override
    public Examene createExamen(Examene examen, List<Pregunta> preguntas) {
        Examene savedExamen = exameneRepo.save(examen);
        for (Pregunta pregunta : preguntas) {
            preguntaRepo.save(pregunta);
            Bancopregunta bancoPreguntas = new Bancopregunta();
            bancoPreguntas.setExamenesIdexamenen(savedExamen);
            bancoPreguntas.setPreguntasIdpregunta(pregunta);
            bancopreguntaRepo.save(bancoPreguntas);
        }
        return savedExamen;
    }

    @Override
    public Examene getExamenById(Long examenId) {
        return exameneRepo.findExamenById(examenId);
    }

    @Override
    public List<Long> getListExamenId() {
        return exameneRepo.listaExamenesId();
    }

}
