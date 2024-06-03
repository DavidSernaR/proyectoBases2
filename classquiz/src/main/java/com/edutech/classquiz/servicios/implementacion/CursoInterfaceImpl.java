package com.edutech.classquiz.servicios.implementacion;

import com.edutech.classquiz.modelo.entidades.Curso;
import com.edutech.classquiz.repositorios.CursoRepo;
import com.edutech.classquiz.servicios.interfaces.CursoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoInterfaceImpl implements CursoInterface {

    @Autowired
    private CursoRepo cursoRepo;

    @Override
    public Curso getCursoById(Long id) {
        return cursoRepo.findById(id).get();
    }
}
