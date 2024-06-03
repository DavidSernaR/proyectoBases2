package com.edutech.classquiz.servicios.implementacion;

import com.edutech.classquiz.modelo.entidades.Estudiante;
import com.edutech.classquiz.repositorios.*;
import com.edutech.classquiz.servicios.interfaces.EstudianteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteInterfaceImpl implements EstudianteInterface {

    @Autowired
    private EstudianteRepo estudianteRepo;

    @Override
    public List<Long> getListEstudianteId() {
        return estudianteRepo.listaEstudiantesId();
    }

    @Override
    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepo.findAll();
    }

}
