package com.edutech.classquiz.repositorios;

import com.edutech.classquiz.modelo.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepo extends JpaRepository<Estudiante, Long> {
    @Query("SELECT e.id FROM Estudiante e")
    List<Long> listaEstudiantesId();
}
