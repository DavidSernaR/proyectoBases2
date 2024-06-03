package com.edutech.classquiz.servicios.implementacion;

import com.edutech.classquiz.modelo.entidades.AsignacionesEstudiante;
import com.edutech.classquiz.repositorios.AsignacionesEstudianteRepo;
import com.edutech.classquiz.repositorios.EstudianteRepo;
import com.edutech.classquiz.repositorios.ExameneRepo;
import com.edutech.classquiz.servicios.interfaces.AsignacionesEstudianteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignacionesEstudianteInterfaceImpl implements AsignacionesEstudianteInterface {

    @Autowired
    private AsignacionesEstudianteRepo asignacionesEstudianteRepo;

    @Autowired
    private EstudianteRepo estudianteRepo;

    @Autowired
    private ExameneRepo exameneRepo;

    @Override
    public AsignacionesEstudiante createAsignacion(Long idEstudiante, Long idExamen) {
        AsignacionesEstudiante asignacion = new AsignacionesEstudiante();
        asignacion.setIdestudiante(estudianteRepo.findById(idEstudiante).get());
        asignacion.setIdexamenes(exameneRepo.findById(idExamen).get());
        return asignacionesEstudianteRepo.save(asignacion);
    }
}
