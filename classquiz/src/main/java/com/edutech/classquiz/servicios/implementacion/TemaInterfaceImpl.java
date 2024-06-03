package com.edutech.classquiz.servicios.implementacion;

import com.edutech.classquiz.modelo.entidades.Tema;
import com.edutech.classquiz.repositorios.TemaRepo;
import com.edutech.classquiz.servicios.interfaces.TemaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaInterfaceImpl implements TemaInterface {

    @Autowired
    private TemaRepo temaRepo;

    @Override
    public Tema getTemaById(Long id) {
        return temaRepo.findById(id).get();
    }
}
