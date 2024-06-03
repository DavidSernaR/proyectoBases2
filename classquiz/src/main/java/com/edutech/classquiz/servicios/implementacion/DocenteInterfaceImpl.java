package com.edutech.classquiz.servicios.implementacion;

import com.edutech.classquiz.modelo.entidades.Docente;
import com.edutech.classquiz.repositorios.*;
import com.edutech.classquiz.servicios.interfaces.DocenteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocenteInterfaceImpl implements DocenteInterface {

    @Autowired
    private DocenteRepo docenteRepo;

    @Override
    public Docente authenticateDocente(String email, String password) {
        return docenteRepo.findByEmailAndPassword(email, password);
    }

}
