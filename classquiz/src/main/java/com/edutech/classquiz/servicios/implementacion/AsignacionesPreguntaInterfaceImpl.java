package com.edutech.classquiz.servicios.implementacion;

import com.edutech.classquiz.modelo.entidades.AsignacionesEstudiante;
import com.edutech.classquiz.modelo.entidades.AsignacionesPregunta;
import com.edutech.classquiz.modelo.entidades.Bancopregunta;
import com.edutech.classquiz.modelo.entidades.Examene;
import com.edutech.classquiz.repositorios.AsignacionesEstudianteRepo;
import com.edutech.classquiz.repositorios.AsignacionesPreguntaRepo;
import com.edutech.classquiz.repositorios.BancopreguntaRepo;
import com.edutech.classquiz.repositorios.ExameneRepo;
import com.edutech.classquiz.servicios.interfaces.AsignacionesPreguntaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AsignacionesPreguntaInterfaceImpl implements AsignacionesPreguntaInterface {

    @Autowired
    private AsignacionesPreguntaRepo asignacionesPreguntaRepo;

    @Autowired
    private ExameneRepo exameneRepo;

    @Autowired
    private AsignacionesEstudianteRepo asignacionesEstudianteRepo;

    @Override
    public AsignacionesPregunta createAsignacion(Long idAsignacionEstudiante, Long idCuestionario) {
        Bancopregunta bancopregunta = new Bancopregunta();
        AsignacionesPregunta asignacionesPregunta = new AsignacionesPregunta();
        Examene examene = exameneRepo.findExamenById(idCuestionario);
        Set<Bancopregunta> listBancoPreguntas = examene.getBancopreguntas();
        List<Bancopregunta> list = new ArrayList<>(listBancoPreguntas);
        if (!list.isEmpty()) {
            bancopregunta = list.get(0);
            AsignacionesEstudiante asignacionesEstudiante = asignacionesEstudianteRepo.findById(idAsignacionEstudiante).get();
            asignacionesPregunta.setIdasignacionestudiante(asignacionesEstudiante);
            asignacionesPregunta.setIdbanco(bancopregunta);
        }
        return asignacionesPregunta;
    }
}
